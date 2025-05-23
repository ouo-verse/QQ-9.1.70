package com.github.henryye.nativeiv;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum a {
    INSTANCE;


    /* renamed from: d, reason: collision with root package name */
    public static int f32866d = Runtime.getRuntime().availableProcessors() + 1;

    /* renamed from: a, reason: collision with root package name */
    public ExecutorService f32868a = null;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f32869b = null;

    /* compiled from: P */
    /* renamed from: com.github.henryye.nativeiv.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ThreadFactoryC0225a implements ThreadFactory {
        public ThreadFactoryC0225a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "native_image_decode_net");
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "native_image_decode_local");
        }
    }

    a() {
        a();
    }

    public final void a() {
        int max = Math.max(f32866d, 5);
        int max2 = Math.max(max / 2, 4);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f32868a = new BaseThreadPoolExecutor(1, max2, 500L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC0225a());
        this.f32869b = new BaseThreadPoolExecutor(max - 1, max, 500L, timeUnit, new LinkedBlockingQueue(), new b());
    }

    public void b(Runnable runnable) {
        this.f32868a.execute(runnable);
    }

    public void a(Runnable runnable) {
        this.f32869b.execute(runnable);
    }
}
