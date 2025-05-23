package com.tencent.mobileqq.guild.util;

import android.text.TextUtils;
import java.util.Objects;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes14.dex */
public class az {
    public static String a(String str) {
        String property = System.getProperty("line.separator");
        Objects.requireNonNull(property);
        return str.replaceAll(property, " ");
    }

    public static boolean b(String str) {
        if (str != null) {
            return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
        }
        return false;
    }

    public static int c(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static long d(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }
}
