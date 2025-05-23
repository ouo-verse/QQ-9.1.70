package com.xiaomi.mipush.sdk;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f388064a = false;

    public static boolean a() {
        return f388064a;
    }

    public static void b(Context context) {
        a b16 = e.c(context).b(d.ASSEMBLE_PUSH_HUAWEI);
        if (b16 != null) {
            b16.register();
        }
    }

    public static synchronized void c(Context context) {
        synchronized (i.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized boolean d(Context context) {
        boolean z16;
        synchronized (i.class) {
            z16 = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000) {
                z16 = true;
            }
        }
        return z16;
    }
}
