package com.huawei.secure.android.common.anonymization;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static String[] a(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static String[] b(String str, String[] strArr) {
        return a(new String[]{str}, strArr);
    }

    public static String[] b(String str, char c16) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i3 = 1;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (str.charAt(i16) == c16) {
                i3++;
            }
        }
        if (i3 <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i3];
        StringBuilder sb5 = new StringBuilder(str.length());
        int i17 = 0;
        for (int i18 = 0; i18 < str.length() && i17 < i3; i18++) {
            char charAt = str.charAt(i18);
            if (charAt == c16) {
                strArr[i17] = sb5.toString();
                sb5.setLength(0);
                i17++;
            } else {
                sb5.append(charAt);
            }
        }
        strArr[i17] = sb5.toString();
        return strArr;
    }

    public static String[] a(String[] strArr, String str) {
        return a(strArr, new String[]{str});
    }

    public static String[] a(String str, int i3, int i16) {
        String[] a16 = a(str, i3);
        return b(a(a16, 0), a(a(a16, 1), i16 - i3));
    }

    public static String[] a(String str, int i3, int i16, int i17) {
        String[] a16 = a(str, i3);
        return b(a(a16, 0), a(a(a16, 1), i16 - i3, i17 - i3));
    }

    public static String[] a(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        }
        if (iArr.length <= 1) {
            return a(str, iArr[0]);
        }
        int i3 = iArr[0];
        int length = iArr.length - 1;
        int[] iArr2 = new int[length];
        int i16 = 0;
        while (i16 < length) {
            int i17 = i16 + 1;
            iArr2[i16] = iArr[i17] - i3;
            i16 = i17;
        }
        String[] a16 = a(str, i3);
        return b(a(a16, 0), a(a(a16, 1), iArr2));
    }

    public static String[] a(String str, int i3) {
        if (str == null) {
            return new String[]{"", ""};
        }
        return (i3 < 0 || i3 > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i3), str.substring(i3)};
    }

    public static String a(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(strArr[0]);
        for (int i3 = 1; i3 < strArr.length; i3++) {
            if (strArr[i3] != null) {
                sb5.append(str);
                sb5.append(strArr[i3]);
            }
        }
        return sb5.toString();
    }

    public static String a(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c16 = charArray[i3];
            int lastIndexOf = str2.lastIndexOf(c16);
            if (lastIndexOf < 0) {
                cArr[i3] = c16;
            } else {
                cArr[i3] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    public static String a(String[] strArr, int i3) {
        return (strArr == null || strArr.length <= 0 || i3 < 0 || i3 >= strArr.length) ? "" : strArr[i3];
    }

    public static String a(String str, char c16) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = c16;
        }
        return new String(cArr);
    }

    public static int a(String str, char c16, int i3) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c16 || i3 - 1 > 0)) {
            length--;
        }
        return length;
    }
}
