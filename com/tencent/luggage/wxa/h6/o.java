package com.tencent.luggage.wxa.h6;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {
    public static String a(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String c(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(63)) < 0) {
            return "";
        }
        int i3 = indexOf + 1;
        int lastIndexOf = str.lastIndexOf(38);
        int lastIndexOf2 = str.lastIndexOf(35);
        if (lastIndexOf2 < 0) {
            return str.substring(i3, str.length());
        }
        if (lastIndexOf2 > lastIndexOf) {
            if (i3 > lastIndexOf2) {
                return str.substring(i3, str.length());
            }
            return str.substring(i3, lastIndexOf2);
        }
        return str.substring(i3, str.length());
    }

    public static Map d(String str) {
        int i3;
        String substring;
        HashMap hashMap = new HashMap();
        String c16 = c(str);
        if (TextUtils.isEmpty(c16)) {
            return hashMap;
        }
        int length = c16.length();
        int i16 = 0;
        while (true) {
            int indexOf = c16.indexOf(38, i16);
            if (indexOf != -1) {
                i3 = indexOf;
            } else {
                i3 = length;
            }
            int indexOf2 = c16.indexOf(61, i16);
            if (indexOf2 > i3 || indexOf2 == -1) {
                indexOf2 = i3;
            }
            String decode = Uri.decode(c16.substring(i16, indexOf2));
            if (indexOf2 == i3) {
                substring = "";
            } else {
                substring = c16.substring(indexOf2 + 1, i3);
            }
            hashMap.put(decode, substring);
            if (indexOf != -1) {
                i16 = indexOf + 1;
            } else {
                return hashMap;
            }
        }
    }

    public static boolean a(String str, String str2) {
        return str != null && str2 != null && str.length() >= 0 && str2.length() >= 0 && str2.length() <= str.length() && str2.equalsIgnoreCase(str.substring(0, str2.length()));
    }
}
