package com.tencent.biz.common.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j {
    public static String a(String str, int i3, String str2) {
        if (c(str) < i3) {
            return str;
        }
        return b(str, i3) + str2;
    }

    public static String b(String str, int i3) {
        try {
            byte[] bytes = str.getBytes("Unicode");
            int i16 = 2;
            int i17 = 0;
            while (i16 < bytes.length && i17 < i3) {
                if (i16 % 2 != 1 && bytes[i16] == 0) {
                    i16++;
                }
                i17++;
                i16++;
            }
            if (i16 % 2 == 1) {
                int i18 = i16 - 1;
                if (bytes[i18] != 0) {
                    i16 = i18;
                } else {
                    i16++;
                }
            }
            return new String(bytes, 0, i16, "Unicode");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static int c(String str) {
        if (str == null) {
            return 0;
        }
        int i3 = 0;
        for (char c16 : str.toCharArray()) {
            i3++;
            if (!e(c16)) {
                i3++;
            }
        }
        return i3;
    }

    public static final int d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            return str.getBytes(str2).length;
        } catch (UnsupportedEncodingException unused) {
            return str.length() * 3;
        }
    }

    public static boolean e(char c16) {
        if (c16 / '\u0080' == 0) {
            return true;
        }
        return false;
    }

    public static final String f(String str, int i3, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        if (d(str, str2) <= i3) {
            return str;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < str.length()) {
            int i18 = i16 + 1;
            i17 += d(str.substring(i16, i18), str2);
            if (i17 > i3) {
                String substring = str.substring(0, i16);
                if (!TextUtils.isEmpty(str3)) {
                    return substring + str3;
                }
                return substring;
            }
            i16 = i18;
        }
        return str;
    }
}
