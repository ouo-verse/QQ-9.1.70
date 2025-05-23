package com.tencent.ams.fusion.a;

import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static void a(String str, String str2) {
        if (com.tencent.ams.fusion.service.kv.b.b().g()) {
            com.tencent.ams.fusion.service.kv.b.b().l(str, str2);
        } else if (com.tencent.ams.fusion.service.b.b().f() != null) {
            SharedPreferences.Editor edit = com.tencent.ams.fusion.service.b.b().f().getSharedPreferences(str, 0).edit();
            edit.remove(str2);
            edit.apply();
        }
    }

    public static void b(String str, String str2, String str3) {
        if (com.tencent.ams.fusion.service.kv.b.b().g()) {
            com.tencent.ams.fusion.service.kv.b.b().j(str, str2, str3);
        } else if (com.tencent.ams.fusion.service.b.b().f() != null) {
            SharedPreferences.Editor edit = com.tencent.ams.fusion.service.b.b().f().getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.apply();
        }
    }

    public static String c(String str, String str2, String str3) {
        if (com.tencent.ams.fusion.service.kv.b.b().g()) {
            return com.tencent.ams.fusion.service.kv.b.b().e(str, str2, str3);
        }
        if (com.tencent.ams.fusion.service.b.b().f() != null) {
            return com.tencent.ams.fusion.service.b.b().f().getSharedPreferences(str, 0).getString(str2, str3);
        }
        return str3;
    }
}
