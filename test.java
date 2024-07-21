public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }

    private boolean isMatchHelper(String s, String p, int i, int j) {
        // Base cases
        if (j == p.length()) {
            return i == s.length();
        }
        
        // Check if the current characters match
        boolean firstMatch = (i < s.length() &&
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
        
        // If the next character is '+', we have two choices
        if (j + 1 < p.length() && p.charAt(j + 1) == '+') {
            // Choice 1: Skip the current character and its '+'
            // This is what leads to nodes 10 and 11
            if (isMatchHelper(s, p, i, j + 2)) {
                return true;
            }
            
            // Choice 2: Use the current character if it matches
            return firstMatch && isMatchHelper(s, p, i + 1, j);
        }
        
        // If there's no '+', just match and move forward
        return firstMatch && isMatchHelper(s, p, i + 1, j + 1);
    }
}