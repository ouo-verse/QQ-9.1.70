package com.qq.e.comm.plugin.k;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f39613a;

    public static final boolean a(Runnable runnable) {
        return b().post(runnable);
    }

    private static Handler b() {
        if (f39613a == null) {
            f39613a = new Handler(Looper.getMainLooper());
        }
        return f39613a;
    }

    public static final boolean a(Runnable runnable, long j3) {
        return b().postDelayed(runnable, j3);
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static final void b(Runnable runnable) {
        b().removeCallbacks(runnable);
    }
}
