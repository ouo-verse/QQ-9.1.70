package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.content.SharedPreferences;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    public int f121780a;

    /* renamed from: b, reason: collision with root package name */
    public String f121781b;

    /* renamed from: c, reason: collision with root package name */
    public String f121782c;

    public s0() {
    }

    public static s0 a(String str) {
        s0 s0Var = new s0();
        SharedPreferences q16 = y0.q();
        s0Var.f121782c = str;
        s0Var.f121780a = q16.getInt(a(str, "version"), -1);
        s0Var.f121781b = q16.getString(a(str, "versionDetail"), "");
        return s0Var;
    }

    public static void b(int i3) {
        SharedPreferences p16 = y0.p();
        if (p16 != null) {
            x0.d("XWebCoreInfo", "save using core version:" + i3);
            p16.edit().putBoolean("using_core_version_" + i3, true).apply();
        }
    }

    public String toString() {
        return "XWebCoreInfo{ver=" + this.f121780a + ", verDetail='" + this.f121781b + "', strAbi='" + this.f121782c + "'}";
    }

    public s0(int i3, String str, String str2) {
        this.f121780a = i3;
        this.f121781b = str;
        this.f121782c = str2;
    }

    public static boolean a(int i3, String str, String str2) {
        SharedPreferences.Editor edit = y0.q().edit();
        edit.putInt(a(str2, "version"), i3);
        edit.putString(a(str2, "versionDetail"), str);
        boolean commit = edit.commit();
        if (commit && i3 > 0 && !b.b().equalsIgnoreCase(str2)) {
            if ("armeabi-v7a".equalsIgnoreCase(str2)) {
                n0.a(577L, 238L, 1L);
            } else if ("arm64-v8a".equalsIgnoreCase(str2)) {
                n0.a(577L, 239L, 1L);
            }
        }
        x0.a("XWebCoreInfo", "setVersionInfo, version:" + i3 + ", abi:" + str2 + ", detail:" + str);
        return commit;
    }

    public static boolean a(s0 s0Var) {
        if (s0Var == null) {
            x0.f("XWebCoreInfo", "setVersionInfo, info is null");
            return false;
        }
        return a(s0Var.f121780a, s0Var.f121781b, s0Var.f121782c);
    }

    public static int a(Context context) {
        if (context == null) {
            x0.f("XWebCoreInfo", "getInstalledNewestVersionForCurAbi, context is null, return -1");
            return -1;
        }
        XWalkEnvironment.ensureInitEnvironment(context);
        return y0.q().getInt(a(b.b(), "version"), -1);
    }

    public static String a(String str, String str2) {
        return "back_core_" + str2 + "_for_" + str;
    }

    public static void a() {
        SharedPreferences p16 = y0.p();
        if (p16 == null || !XWalkEnvironment.getPackageName().equalsIgnoreCase(XWalkEnvironment.getProcessName())) {
            return;
        }
        x0.d("XWebCoreInfo", "reset using core version in main process");
        p16.edit().clear().apply();
    }

    public static boolean a(int i3) {
        SharedPreferences p16 = y0.p();
        if (p16 == null) {
            return false;
        }
        boolean contains = p16.contains("using_core_version_" + i3);
        x0.d("XWebCoreInfo", "core version(" + i3 + ") is using:" + contains);
        return contains;
    }
}
