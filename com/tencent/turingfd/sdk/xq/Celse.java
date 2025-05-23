package com.tencent.turingfd.sdk.xq;

import android.content.Context;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.else, reason: invalid class name */
/* loaded from: classes27.dex */
public class Celse {

    /* renamed from: a, reason: collision with root package name */
    public static Context f383328a;

    public static synchronized boolean a(Context context) {
        synchronized (Celse.class) {
            if (f383328a != null) {
                return true;
            }
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            f383328a = applicationContext;
            return true;
        }
    }

    public static synchronized Context a() {
        Context context;
        synchronized (Celse.class) {
            context = f383328a;
        }
        return context;
    }
}
