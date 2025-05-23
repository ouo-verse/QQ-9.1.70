package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b1 {

    /* renamed from: d, reason: collision with root package name */
    public static final b1 f36357d = new b1();

    /* renamed from: a, reason: collision with root package name */
    public volatile Executor f36358a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ExecutorService f36359b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f36360c = new Object();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static Executor a() {
        b1 b1Var = f36357d;
        if (b1Var.f36358a == null) {
            synchronized (b1Var.f36360c) {
                if (b1Var.f36358a == null) {
                    b1Var.f36358a = new a();
                }
            }
        }
        return b1Var.f36358a;
    }

    public static ExecutorService c() {
        return f36357d.b();
    }

    public final ExecutorService b() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return baseThreadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }
}
