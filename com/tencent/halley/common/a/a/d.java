package com.tencent.halley.common.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
public final class d extends BaseThreadPoolExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f113207a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f113208b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f113209c;

    /* renamed from: d, reason: collision with root package name */
    private long f113210d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class a implements RejectedExecutionHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) threadPoolExecutor);
                return;
            }
            throw new RejectedExecutionException();
        }

        /* synthetic */ a(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
        }
    }

    public d(int i3, int i16, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, 5L, timeUnit, blockingQueue, threadFactory, new a((byte) 0));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), timeUnit, blockingQueue, threadFactory);
            return;
        }
        this.f113207a = new AtomicInteger(0);
        this.f113208b = new AtomicLong(0L);
        this.f113209c = new AtomicLong(0L);
        this.f113210d = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (b()) {
            long longValue = this.f113209c.longValue();
            if (this.f113210d + longValue < System.currentTimeMillis() && this.f113209c.compareAndSet(longValue, System.currentTimeMillis() + 1)) {
                Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tencent.halley.common.a.a.d.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) d.this);
                        }
                    }

                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread, Throwable th5) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) thread, (Object) th5);
                        } else {
                            th5.printStackTrace();
                        }
                    }
                });
                throw new RuntimeException("Stopping thread to avoid potential memory leaks after a context was stopped.");
            }
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    protected final void afterExecute(Runnable runnable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) th5);
            return;
        }
        this.f113207a.decrementAndGet();
        if (th5 == null) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f113210d >= 0 && (Thread.currentThread() instanceof c) && ((c) Thread.currentThread()).f113206a < this.f113208b.longValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f113207a.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e16) {
            if (super.getQueue() instanceof b) {
                try {
                    if (((b) super.getQueue()).a(runnable, timeUnit)) {
                        return;
                    }
                    this.f113207a.decrementAndGet();
                    throw new RejectedExecutionException("Queue capacity is full." + e16.getLocalizedMessage());
                } catch (InterruptedException e17) {
                    this.f113207a.decrementAndGet();
                    Thread.interrupted();
                    throw new RejectedExecutionException(e17);
                }
            }
            this.f113207a.decrementAndGet();
            throw e16;
        }
    }
}
