package org.apache.commons.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WordUtils {
    public static String abbreviate(String str, int i3, int i16, String str2) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        if (i3 > str.length()) {
            i3 = str.length();
        }
        if (i16 == -1 || i16 > str.length()) {
            i16 = str.length();
        }
        if (i16 < i3) {
            i16 = i3;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int indexOf = StringUtils.indexOf(str, " ", i3);
        if (indexOf == -1) {
            stringBuffer.append(str.substring(0, i16));
            if (i16 != str.length()) {
                stringBuffer.append(StringUtils.defaultString(str2));
            }
        } else if (indexOf > i16) {
            stringBuffer.append(str.substring(0, i16));
            stringBuffer.append(StringUtils.defaultString(str2));
        } else {
            stringBuffer.append(str.substring(0, indexOf));
            stringBuffer.append(StringUtils.defaultString(str2));
        }
        return stringBuffer.toString();
    }

    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, null);
    }

    public static String initials(String str) {
        return initials(str, null);
    }

    private static boolean isDelimiter(char c16, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c16);
        }
        for (char c17 : cArr) {
            if (c16 == c17) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        int length;
        char c16;
        if (str != null && (length = str.length()) != 0) {
            StringBuffer stringBuffer = new StringBuffer(length);
            boolean z16 = true;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (Character.isUpperCase(charAt)) {
                    c16 = Character.toLowerCase(charAt);
                } else if (Character.isTitleCase(charAt)) {
                    c16 = Character.toLowerCase(charAt);
                } else if (Character.isLowerCase(charAt)) {
                    if (z16) {
                        c16 = Character.toTitleCase(charAt);
                    } else {
                        c16 = Character.toUpperCase(charAt);
                    }
                } else {
                    c16 = charAt;
                }
                stringBuffer.append(c16);
                z16 = Character.isWhitespace(charAt);
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, null);
    }

    public static String wrap(String str, int i3) {
        return wrap(str, i3, null, false);
    }

    public static String capitalize(String str, char[] cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (str == null || str.length() == 0 || length == 0) {
            return str;
        }
        int length2 = str.length();
        StringBuffer stringBuffer = new StringBuffer(length2);
        boolean z16 = true;
        for (int i3 = 0; i3 < length2; i3++) {
            char charAt = str.charAt(i3);
            if (isDelimiter(charAt, cArr)) {
                stringBuffer.append(charAt);
                z16 = true;
            } else if (z16) {
                stringBuffer.append(Character.toTitleCase(charAt));
                z16 = false;
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String capitalizeFully(String str, char[] cArr) {
        return (str == null || str.length() == 0 || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char[] cArr) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[(length / 2) + 1];
        boolean z16 = true;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (isDelimiter(charAt, cArr)) {
                z16 = true;
            } else if (z16) {
                cArr2[i3] = charAt;
                i3++;
                z16 = false;
            }
        }
        return new String(cArr2, 0, i3);
    }

    public static String uncapitalize(String str, char[] cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (str == null || str.length() == 0 || length == 0) {
            return str;
        }
        int length2 = str.length();
        StringBuffer stringBuffer = new StringBuffer(length2);
        boolean z16 = true;
        for (int i3 = 0; i3 < length2; i3++) {
            char charAt = str.charAt(i3);
            if (isDelimiter(charAt, cArr)) {
                stringBuffer.append(charAt);
                z16 = true;
            } else if (z16) {
                stringBuffer.append(Character.toLowerCase(charAt));
                z16 = false;
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String wrap(String str, int i3, String str2, boolean z16) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = SystemUtils.LINE_SEPARATOR;
        }
        if (i3 < 1) {
            i3 = 1;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 32);
        int i16 = 0;
        while (length - i16 > i3) {
            if (str.charAt(i16) == ' ') {
                i16++;
            } else {
                int i17 = i3 + i16;
                int lastIndexOf = str.lastIndexOf(32, i17);
                if (lastIndexOf >= i16) {
                    stringBuffer.append(str.substring(i16, lastIndexOf));
                    stringBuffer.append(str2);
                    i16 = lastIndexOf + 1;
                } else {
                    if (z16) {
                        stringBuffer.append(str.substring(i16, i17));
                        stringBuffer.append(str2);
                    } else {
                        int indexOf = str.indexOf(32, i17);
                        if (indexOf >= 0) {
                            stringBuffer.append(str.substring(i16, indexOf));
                            stringBuffer.append(str2);
                            i17 = indexOf + 1;
                        } else {
                            stringBuffer.append(str.substring(i16));
                            i16 = length;
                        }
                    }
                    i16 = i17;
                }
            }
        }
        stringBuffer.append(str.substring(i16));
        return stringBuffer.toString();
    }
}
