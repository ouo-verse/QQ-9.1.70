package com.tencent.ecommerce.biz.util;

import android.os.SystemProperties;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes31.dex */
public class w {
    private static String a() {
        return b("ro.build.display.id", "");
    }

    private static String b(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return str2;
        }
    }

    public static boolean c() {
        return a().toLowerCase().contains("flyme");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(b("ro.miui.ui.version.name", ""));
    }
}
