package org.apache.commons.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CharUtils {
    private static final String CHAR_STRING = "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007f";
    public static final char CR = '\r';
    public static final char LF = '\n';
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    private static final Character[] CHAR_ARRAY = new Character[128];

    static {
        for (int i3 = 127; i3 >= 0; i3--) {
            CHAR_STRING_ARRAY[i3] = CHAR_STRING.substring(i3, i3 + 1);
            CHAR_ARRAY[i3] = new Character((char) i3);
        }
    }

    public static boolean isAscii(char c16) {
        if (c16 < '\u0080') {
            return true;
        }
        return false;
    }

    public static boolean isAsciiAlpha(char c16) {
        if ((c16 >= 'A' && c16 <= 'Z') || (c16 >= 'a' && c16 <= 'z')) {
            return true;
        }
        return false;
    }

    public static boolean isAsciiAlphaLower(char c16) {
        if (c16 >= 'a' && c16 <= 'z') {
            return true;
        }
        return false;
    }

    public static boolean isAsciiAlphaUpper(char c16) {
        if (c16 >= 'A' && c16 <= 'Z') {
            return true;
        }
        return false;
    }

    public static boolean isAsciiAlphanumeric(char c16) {
        if ((c16 >= 'A' && c16 <= 'Z') || ((c16 >= 'a' && c16 <= 'z') || (c16 >= '0' && c16 <= '9'))) {
            return true;
        }
        return false;
    }

    public static boolean isAsciiControl(char c16) {
        if (c16 >= ' ' && c16 != '\u007f') {
            return false;
        }
        return true;
    }

    public static boolean isAsciiNumeric(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isAsciiPrintable(char c16) {
        if (c16 >= ' ' && c16 < '\u007f') {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isHighSurrogate(char c16) {
        if ('\ud800' <= c16 && '\udbff' >= c16) {
            return true;
        }
        return false;
    }

    public static char toChar(Character ch5) {
        if (ch5 != null) {
            return ch5.charValue();
        }
        throw new IllegalArgumentException("The Character must not be null");
    }

    public static Character toCharacterObject(char c16) {
        Character[] chArr = CHAR_ARRAY;
        if (c16 < chArr.length) {
            return chArr[c16];
        }
        return new Character(c16);
    }

    public static int toIntValue(char c16) {
        if (isAsciiNumeric(c16)) {
            return c16 - '0';
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The character ");
        stringBuffer.append(c16);
        stringBuffer.append(" is not in the range '0' - '9'");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static String toString(char c16) {
        if (c16 < '\u0080') {
            return CHAR_STRING_ARRAY[c16];
        }
        return new String(new char[]{c16});
    }

    public static String unicodeEscaped(char c16) {
        if (c16 < 16) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\\u000");
            stringBuffer.append(Integer.toHexString(c16));
            return stringBuffer.toString();
        }
        if (c16 < '\u0100') {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("\\u00");
            stringBuffer2.append(Integer.toHexString(c16));
            return stringBuffer2.toString();
        }
        if (c16 < '\u1000') {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("\\u0");
            stringBuffer3.append(Integer.toHexString(c16));
            return stringBuffer3.toString();
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("\\u");
        stringBuffer4.append(Integer.toHexString(c16));
        return stringBuffer4.toString();
    }

    public static char toChar(Character ch5, char c16) {
        return ch5 == null ? c16 : ch5.charValue();
    }

    public static int toIntValue(char c16, int i3) {
        return !isAsciiNumeric(c16) ? i3 : c16 - '0';
    }

    public static String toString(Character ch5) {
        if (ch5 == null) {
            return null;
        }
        return toString(ch5.charValue());
    }

    public static char toChar(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("The String must not be empty");
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return toCharacterObject(str.charAt(0));
    }

    public static int toIntValue(Character ch5) {
        if (ch5 != null) {
            return toIntValue(ch5.charValue());
        }
        throw new IllegalArgumentException("The character must not be null");
    }

    public static String unicodeEscaped(Character ch5) {
        if (ch5 == null) {
            return null;
        }
        return unicodeEscaped(ch5.charValue());
    }

    public static int toIntValue(Character ch5, int i3) {
        return ch5 == null ? i3 : toIntValue(ch5.charValue(), i3);
    }

    public static char toChar(String str, char c16) {
        return StringUtils.isEmpty(str) ? c16 : str.charAt(0);
    }
}
