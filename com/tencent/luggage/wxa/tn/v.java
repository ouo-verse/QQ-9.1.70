package com.tencent.luggage.wxa.tn;

import android.location.LocationManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v {
    public static boolean a() {
        try {
            return ((LocationManager) z.c().getSystemService("location")).isProviderEnabled("gps");
        } catch (Exception e16) {
            w.b("MicroMsg.LocationUtil", "exception:%s", w0.a((Throwable) e16));
            return false;
        }
    }

    public static boolean b() {
        try {
            return ((LocationManager) z.c().getSystemService("location")).isProviderEnabled("network");
        } catch (Exception e16) {
            w.b("MicroMsg.LocationUtil", "exception:%s", w0.a((Throwable) e16));
            return false;
        }
    }
}
