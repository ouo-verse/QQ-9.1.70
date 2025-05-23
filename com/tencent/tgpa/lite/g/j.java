package com.tencent.tgpa.lite.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j {
    public static String a(String str, String str2) {
        if (a.a() != null && str != null) {
            return a.a().getSharedPreferences("tgpa", 0).getString(str, str2);
        }
        return str2;
    }

    public static void b(String str, String str2) {
        if (a.a() != null && str != null) {
            a.a().getSharedPreferences("tgpa", 0).edit().putString(str, str2).apply();
        } else {
            h.b("apply info to tgpa shared pref failed, ple check!", new Object[0]);
        }
    }
}
