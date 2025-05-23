package com.tencent.luggage.wxa.uk;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l0 {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper() || Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static void a(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            com.tencent.luggage.wxa.tn.c0.a(runnable);
        }
    }
}
