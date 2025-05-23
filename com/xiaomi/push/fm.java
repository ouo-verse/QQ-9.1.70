package com.xiaomi.push;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fm {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f388883a = "&quot;".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f388884b = "&apos;".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f388885c = "&amp;".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f388886d = "&lt;".toCharArray();

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f388887e = "&gt;".toCharArray();

    /* renamed from: f, reason: collision with root package name */
    private static Random f388888f = new Random();

    /* renamed from: g, reason: collision with root package name */
    private static char[] f388889g = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(int i3) {
        if (i3 < 1) {
            return null;
        }
        char[] cArr = new char[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            cArr[i16] = f388889g[f388888f.nextInt(71)];
        }
        return new String(cArr);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb5 = new StringBuilder((int) (length * 1.3d));
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            char c16 = charArray[i3];
            if (c16 <= '>') {
                if (c16 == '<') {
                    if (i3 > i16) {
                        sb5.append(charArray, i16, i3 - i16);
                    }
                    i16 = i3 + 1;
                    sb5.append(f388886d);
                } else if (c16 == '>') {
                    if (i3 > i16) {
                        sb5.append(charArray, i16, i3 - i16);
                    }
                    i16 = i3 + 1;
                    sb5.append(f388887e);
                } else if (c16 == '&') {
                    if (i3 > i16) {
                        sb5.append(charArray, i16, i3 - i16);
                    }
                    int i17 = i3 + 5;
                    if (length <= i17 || charArray[i3 + 1] != '#' || !Character.isDigit(charArray[i3 + 2]) || !Character.isDigit(charArray[i3 + 3]) || !Character.isDigit(charArray[i3 + 4]) || charArray[i17] != ';') {
                        i16 = i3 + 1;
                        sb5.append(f388885c);
                    }
                } else if (c16 == '\"') {
                    if (i3 > i16) {
                        sb5.append(charArray, i16, i3 - i16);
                    }
                    i16 = i3 + 1;
                    sb5.append(f388883a);
                } else if (c16 == '\'') {
                    if (i3 > i16) {
                        sb5.append(charArray, i16, i3 - i16);
                    }
                    i16 = i3 + 1;
                    sb5.append(f388884b);
                }
            }
            i3++;
        }
        if (i16 == 0) {
            return str;
        }
        if (i3 > i16) {
            sb5.append(charArray, i16, i3 - i16);
        }
        return sb5.toString();
    }

    public static final String c(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf >= 0) {
            char[] charArray = str.toCharArray();
            char[] charArray2 = str3.toCharArray();
            int length = str2.length();
            StringBuilder sb5 = new StringBuilder(charArray.length);
            sb5.append(charArray, 0, indexOf);
            sb5.append(charArray2);
            int i3 = indexOf + length;
            while (true) {
                int indexOf2 = str.indexOf(str2, i3);
                if (indexOf2 > 0) {
                    sb5.append(charArray, i3, indexOf2 - i3);
                    sb5.append(charArray2);
                    i3 = indexOf2 + length;
                } else {
                    sb5.append(charArray, i3, charArray.length - i3);
                    return sb5.toString();
                }
            }
        } else {
            return str;
        }
    }

    public static String d(byte[] bArr) {
        return String.valueOf(aa.e(bArr));
    }

    public static final String e(String str) {
        return c(c(c(c(c(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", ContainerUtils.FIELD_DELIMITER);
    }
}
