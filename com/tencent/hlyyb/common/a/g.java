package com.tencent.hlyyb.common.a;

import com.tencent.hlyyb.common.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class g extends BaseThreadPoolExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f114342e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicLong f114343f;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicLong f114344h;

    /* renamed from: i, reason: collision with root package name */
    public long f114345i;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a implements RejectedExecutionHandler {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable, (Object) threadPoolExecutor);
                return;
            }
            throw new RejectedExecutionException();
        }

        public /* synthetic */ a(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        }
    }

    public g(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(0, i16, 5L, timeUnit, blockingQueue, threadFactory, new a((byte) 0));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), timeUnit, blockingQueue, threadFactory);
            return;
        }
        this.f114342e = new AtomicInteger(0);
        this.f114343f = new AtomicLong(0L);
        this.f114344h = new AtomicLong(0L);
        this.f114345i = 1000L;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (b()) {
            long longValue = this.f114344h.longValue();
            if (this.f114345i + longValue < System.currentTimeMillis() && this.f114344h.compareAndSet(longValue, System.currentTimeMillis() + 1)) {
                Thread.currentThread().setUncaughtExceptionHandler(new h(this));
                throw new RuntimeException("Stopping thread to avoid potential memory leaks after a context was stopped.");
            }
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) th5);
            return;
        }
        this.f114342e.decrementAndGet();
        if (th5 == null) {
            a();
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f114345i >= 0 && (Thread.currentThread() instanceof a.d) && ((a.d) Thread.currentThread()).a() < this.f114343f.longValue()) {
            return true;
        }
        return false;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f114342e.get();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f114342e.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e16) {
            if (super.getQueue() instanceof a.c) {
                try {
                    if (((a.c) super.getQueue()).a(runnable, 0L, timeUnit)) {
                        return;
                    }
                    this.f114342e.decrementAndGet();
                    throw new RejectedExecutionException("Queue capacity is full.");
                } catch (InterruptedException e17) {
                    this.f114342e.decrementAndGet();
                    Thread.interrupted();
                    throw new RejectedExecutionException(e17);
                }
            }
            this.f114342e.decrementAndGet();
            throw e16;
        }
    }
}
