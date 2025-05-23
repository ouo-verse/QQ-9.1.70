package com.tencent.tbs.one.impl.common.a;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f374798a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f374799b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f374800c;

    /* renamed from: d, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f374801d;

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f374802e;

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f374803f;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f374804g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile Executor f374805h;

    /* renamed from: i, reason: collision with root package name */
    private static b f374806i;

    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.common.a.b$2, reason: invalid class name */
    /* loaded from: classes26.dex */
    static class AnonymousClass2 implements Executor {

        /* renamed from: d, reason: collision with root package name */
        final ArrayDeque<Runnable> f374807d = new ArrayDeque<>();

        /* renamed from: e, reason: collision with root package name */
        Runnable f374808e;

        AnonymousClass2() {
        }

        final synchronized void a() {
            Runnable poll = this.f374807d.poll();
            this.f374808e = poll;
            if (poll != null) {
                b.f374802e.execute(this.f374808e);
            }
        }

        @Override // java.util.concurrent.Executor
        public final synchronized void execute(final Runnable runnable) {
            this.f374807d.offer(new Runnable() { // from class: com.tencent.tbs.one.impl.common.a.b.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        runnable.run();
                    } finally {
                        AnonymousClass2.this.a();
                    }
                }
            });
            if (this.f374808e == null) {
                a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f374811d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "StatisticExecutor #" + this.f374811d.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f374798a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f374799b = max;
        int i3 = (availableProcessors * 2) + 1;
        f374800c = i3;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f374801d = linkedBlockingQueue;
        a aVar = new a();
        f374803f = aVar;
        f374804g = new Object();
        f374805h = new AnonymousClass2();
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(max, i3, 30L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        f374802e = baseThreadPoolExecutor;
    }

    public static b a() {
        if (f374806i == null) {
            synchronized (f374804g) {
                if (f374806i == null) {
                    f374806i = new b();
                }
            }
        }
        return f374806i;
    }

    public static void b(Runnable runnable) {
        f374805h.execute(runnable);
    }
}
