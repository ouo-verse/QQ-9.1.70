package com.tencent.gamecenter.wadl.sdk.common.b.j;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends BaseThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f107044a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f107045b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f107046c;

    /* renamed from: d, reason: collision with root package name */
    private long f107047d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Thread.UncaughtExceptionHandler {
        a(e eVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class b implements RejectedExecutionHandler {
        b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            throw new RejectedExecutionException();
        }
    }

    public e(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory, new b(null));
        this.f107044a = new AtomicInteger(0);
        this.f107045b = new AtomicLong(0L);
        this.f107046c = new AtomicLong(0L);
        this.f107047d = 1000L;
    }

    public void a(Runnable runnable, long j3, TimeUnit timeUnit) {
        this.f107044a.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e16) {
            if (!(super.getQueue() instanceof c)) {
                this.f107044a.decrementAndGet();
                throw e16;
            }
            try {
                if (((c) super.getQueue()).a(runnable, j3, timeUnit)) {
                    return;
                }
                this.f107044a.decrementAndGet();
                throw new RejectedExecutionException("Queue capacity is full.");
            } catch (InterruptedException e17) {
                this.f107044a.decrementAndGet();
                Thread.interrupted();
                throw new RejectedExecutionException(e17);
            }
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th5) {
        this.f107044a.decrementAndGet();
        if (th5 == null) {
            c();
        }
    }

    public int b() {
        return this.f107044a.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (a()) {
            long longValue = this.f107046c.longValue();
            if (this.f107047d + longValue < System.currentTimeMillis() && this.f107046c.compareAndSet(longValue, System.currentTimeMillis() + 1)) {
                Thread.currentThread().setUncaughtExceptionHandler(new a(this));
                throw new RuntimeException("Stopping thread to avoid potential memory leaks after a context was stopped.");
            }
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a(runnable, 0L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return this.f107047d >= 0 && (Thread.currentThread() instanceof d) && ((d) Thread.currentThread()).a() < this.f107045b.longValue();
    }
}
