package org.apache.commons.lang;

import org.apache.commons.lang.text.StrBuilder;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CharSetUtils {
    public static int count(String str, String str2) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return 0;
        }
        return count(str, new String[]{str2});
    }

    public static String delete(String str, String str2) {
        return (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) ? str : delete(str, new String[]{str2});
    }

    public static CharSet evaluateSet(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return new CharSet(strArr);
    }

    public static String keep(String str, String str2) {
        if (str == null) {
            return null;
        }
        return (str.length() == 0 || StringUtils.isEmpty(str2)) ? "" : keep(str, new String[]{str2});
    }

    private static String modify(String str, String[] strArr, boolean z16) {
        CharSet charSet = CharSet.getInstance(strArr);
        StrBuilder strBuilder = new StrBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (charSet.contains(charArray[i3]) == z16) {
                strBuilder.append(charArray[i3]);
            }
        }
        return strBuilder.toString();
    }

    public static String squeeze(String str, String str2) {
        return (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) ? str : squeeze(str, new String[]{str2});
    }

    public static String translate(String str, String str2, String str3) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        StrBuilder strBuilder = new StrBuilder(str.length());
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = charArray.length;
        int length2 = str3.length() - 1;
        for (int i3 = 0; i3 < length; i3++) {
            int indexOf = str2.indexOf(charArray[i3]);
            if (indexOf != -1) {
                if (indexOf > length2) {
                    indexOf = length2;
                }
                strBuilder.append(charArray2[indexOf]);
            } else {
                strBuilder.append(charArray[i3]);
            }
        }
        return strBuilder.toString();
    }

    public static int count(String str, String[] strArr) {
        if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i3 = 0;
        for (char c16 : str.toCharArray()) {
            if (charSet.contains(c16)) {
                i3++;
            }
        }
        return i3;
    }

    public static String delete(String str, String[] strArr) {
        return (StringUtils.isEmpty(str) || ArrayUtils.isEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        return (str.length() == 0 || ArrayUtils.isEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    public static String squeeze(String str, String[] strArr) {
        if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty(strArr)) {
            return str;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        StrBuilder strBuilder = new StrBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c16 = TokenParser.SP;
        for (int i3 = 0; i3 < length; i3++) {
            char c17 = charArray[i3];
            if (!charSet.contains(c17) || c17 != c16 || i3 == 0) {
                strBuilder.append(c17);
                c16 = c17;
            }
        }
        return strBuilder.toString();
    }
}
