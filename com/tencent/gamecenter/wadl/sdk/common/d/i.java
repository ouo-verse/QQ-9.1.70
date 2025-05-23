package com.tencent.gamecenter.wadl.sdk.common.d;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f107132a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f107133b = "";

    public static int a(String str, int i3, boolean z16) {
        return com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(c(z16), 0).getInt(str, i3);
    }

    public static final int b(boolean z16) {
        com.tencent.gamecenter.wadl.sdk.common.a.i();
        return 18080;
    }

    private static String c(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("WadlServicePreferences_");
        sb5.append(com.tencent.gamecenter.wadl.sdk.common.a.c());
        if (com.tencent.gamecenter.wadl.sdk.common.a.i()) {
            str = "_test";
        } else {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        if (z16) {
            return sb6 + "_" + com.tencent.gamecenter.wadl.sdk.common.a.f();
        }
        return sb6;
    }

    public static long a(String str, long j3, boolean z16) {
        return com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(c(z16), 0).getLong(str, j3);
    }

    public static void b(String str, int i3, boolean z16) {
        com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(c(z16), 0).edit().putInt(str, i3).commit();
    }

    public static String a() {
        if (!TextUtils.isEmpty(f107133b)) {
            return f107133b;
        }
        String a16 = a("deviceid", "", false);
        f107133b = a16;
        return a16;
    }

    public static void b(String str, long j3, boolean z16) {
        com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(c(z16), 0).edit().putLong(str, j3).commit();
    }

    public static String a(int i3) {
        return i3 == 2 ? QADNetStatus.G_2 : i3 == 3 ? QADNetStatus.G_3 : i3 == 4 ? QADNetStatus.G_4 : i3 == 5 ? QADNetStatus.G_5 : i3 == 1 ? "wifi" : "";
    }

    public static void b(String str, String str2, boolean z16) {
        com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(c(z16), 0).edit().putString(str, str2).commit();
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f107132a)) {
            return f107132a;
        }
        String packageName = context.getPackageName();
        String a16 = com.tencent.gamecenter.wadl.sdk.common.e.g.a(Process.myPid());
        if (TextUtils.isEmpty(a16) || !a16.startsWith(packageName)) {
            a16 = com.tencent.gamecenter.wadl.sdk.common.e.g.a(context, Process.myPid());
        }
        f107132a = a16;
        return a16;
    }

    public static String a(String str, String str2, boolean z16) {
        return com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(c(z16), 0).getString(str, str2);
    }

    public static final String a(boolean z16) {
        return z16 ? com.tencent.gamecenter.wadl.sdk.common.a.i() ? "test-hllb-hl.mig.tencent-cloud.net" : "hllb-hl.mig.tencent-cloud.net" : com.tencent.gamecenter.wadl.sdk.common.a.i() ? "test-conn-hl.mig.tencent-cloud.net" : "conn-hl.mig.tencent-cloud.net";
    }

    public static void a(String str) {
        b("deviceid", str, false);
        f107133b = str;
    }
}
