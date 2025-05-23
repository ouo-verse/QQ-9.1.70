package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bm {

    /* renamed from: a, reason: collision with root package name */
    private static bv f388278a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f388279b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static String f388280c;

    private static int a(Context context) {
        String str;
        try {
            x e16 = au.e();
            if (e16 != null) {
                if (e16.a() == 0) {
                    String h16 = e16.h();
                    if (!TextUtils.isEmpty(h16) && !"UNKNOWN".equalsIgnoreCase(h16)) {
                        str = "M-" + h16;
                    } else {
                        str = null;
                    }
                    j(str);
                    return 0;
                }
                if (e16.a() != 1 && e16.a() != 6) {
                    j(null);
                    return -1;
                }
                j("WIFI-ID-UNKNOWN");
                return 1;
            }
            j(null);
            return -1;
        } catch (Exception e17) {
            jz4.c.B("DisconnectStatsHelper getNetType occurred error: " + e17.getMessage());
            j(null);
            return -1;
        }
    }

    private static synchronized String b() {
        String str;
        synchronized (bm.class) {
            str = f388280c;
        }
        return str;
    }

    public static void c(Context context) {
        if (!h(context)) {
            g("onReconnection shouldSampling = false");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f388279b = a(context);
        cq.i(context, currentTimeMillis);
        g("onReconnection connectedNetworkType = " + f388279b);
    }

    public static void d(Context context, ep epVar) {
        if (h(context)) {
            if (f388278a == null) {
                f388278a = new bv(context);
            }
            epVar.i(f388278a);
            g("startStats");
        }
    }

    public static void e(Context context, String str) {
        if (!h(context)) {
            g("onWifiChanged shouldSampling = false");
            return;
        }
        g("onWifiChanged wifiDigest = " + str);
        if (!TextUtils.isEmpty(str)) {
            j("W-" + str);
        }
    }

    public static void f(Context context, String str, int i3) {
        if (!h(context)) {
            g("onDisconnection shouldSampling = false");
            return;
        }
        cq.k(context, str, au.v(context), System.currentTimeMillis(), i3, com.xiaomi.push.service.as.c(context).l(), a(context), b(), f388279b);
        g("onDisconnection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(String str) {
        bf.b("Push-DiscntStats", str);
    }

    private static boolean h(Context context) {
        return bf.c(context);
    }

    public static void i(Context context, ep epVar) {
        bv bvVar = f388278a;
        if (bvVar != null) {
            epVar.x(bvVar);
            f388278a = null;
            g("stopStats");
        }
    }

    private static synchronized void j(String str) {
        synchronized (bm.class) {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                String str2 = f388280c;
                if (str2 == null || !str2.startsWith("W-")) {
                    f388280c = null;
                }
            } else {
                f388280c = str;
            }
            g("updateNetId new networkId = " + str + ", finally netId = " + f388280c);
        }
    }
}
