package com.tencent.guild.aio.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes6.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f112366a;

    public static void a(Runnable runnable) {
        synchronized (aa.class) {
            Handler handler = f112366a;
            if (handler == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public static void b(Runnable runnable) {
        synchronized (aa.class) {
            if (f112366a == null) {
                f112366a = new Handler(Looper.getMainLooper());
            }
        }
        f112366a.post(runnable);
    }

    public static void c(Runnable runnable, long j3) {
        synchronized (aa.class) {
            if (f112366a == null) {
                f112366a = new Handler(Looper.getMainLooper());
            }
        }
        f112366a.postDelayed(runnable, j3);
    }
}
