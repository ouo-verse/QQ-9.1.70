package com.tencent.tbs.one.impl.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f374594a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static HandlerThread f374595b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f374596c;

    public static Handler a() {
        Handler handler;
        synchronized (f374594a) {
            if (f374596c == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TBSOneThread");
                f374595b = baseHandlerThread;
                baseHandlerThread.start();
                f374596c = new Handler(f374595b.getLooper());
            }
            handler = f374596c;
        }
        return handler;
    }

    public static void b(Runnable runnable) {
        if (e()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    @VisibleForTesting
    public static void c(Runnable runnable, long j3) {
        a().postDelayed(runnable, j3);
    }

    public static void d(Runnable runnable) {
        a().post(runnable);
    }

    public static boolean e() {
        if (a().getLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static void f(Runnable runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
    }
}
