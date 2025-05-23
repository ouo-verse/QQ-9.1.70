package com.tencent.luggage.wxa.fd;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tn.f0 f125979a = com.tencent.luggage.wxa.tn.f0.e("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");

    public static void a(String str, boolean z16) {
        f125979a.putBoolean(str + "_AppDebugEnabled", z16).commit();
    }

    public static boolean b() {
        return f125979a.getBoolean("ENABLE_ALL_APP_DEBUG", false);
    }

    public static boolean c(String str) {
        if (!f125979a.getBoolean(str + "_AppDebugEnabled", false) && !b()) {
            return false;
        }
        return true;
    }

    public static String a() {
        return f125979a.getString("V8DebugFlags", "");
    }

    public static int b(String str) {
        return f125979a.getInt(str + "_FrameCaptureMode", 0);
    }

    public static boolean a(com.tencent.luggage.wxa.c5.e eVar) {
        com.tencent.luggage.wxa.qj.a aVar = (com.tencent.luggage.wxa.qj.a) eVar.a(com.tencent.luggage.wxa.qj.a.class, false);
        if (aVar == null || eVar.R1()) {
            return false;
        }
        return aVar.f138884b;
    }

    public static boolean a(String str) {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.rj.h.class));
        return false;
    }
}
