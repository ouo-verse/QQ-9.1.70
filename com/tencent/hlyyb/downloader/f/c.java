package com.tencent.hlyyb.downloader.f;

import com.tencent.hlyyb.common.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends BaseThreadPoolExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f114649e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicLong f114650f;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicLong f114651h;

    /* renamed from: i, reason: collision with root package name */
    public long f114652i;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a<T> extends FutureTask<T> implements Comparable<a<T>> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public Object f114653d;

        public a(c cVar, Runnable runnable, T t16) {
            super(runnable, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cVar, runnable, t16);
            } else {
                this.f114653d = runnable;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            a<T> aVar = (a) obj;
            if (this != aVar) {
                if (aVar == null) {
                    return -1;
                }
                Object obj2 = this.f114653d;
                if (obj2 != null && aVar.f114653d != null && obj2.getClass().equals(aVar.f114653d.getClass())) {
                    Object obj3 = this.f114653d;
                    if (obj3 instanceof Comparable) {
                        return ((Comparable) obj3).compareTo(aVar.f114653d);
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b implements RejectedExecutionHandler {
        static IPatchRedirector $redirector_;

        public b() {
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

        public /* synthetic */ b(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        }
    }

    public c(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(0, i16, 5L, timeUnit, blockingQueue, threadFactory, new b((byte) 0));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), timeUnit, blockingQueue, threadFactory);
            return;
        }
        this.f114649e = new AtomicInteger(0);
        this.f114650f = new AtomicLong(0L);
        this.f114651h = new AtomicLong(0L);
        this.f114652i = 1000L;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (b()) {
            long longValue = this.f114651h.longValue();
            if (this.f114652i + longValue < System.currentTimeMillis() && this.f114651h.compareAndSet(longValue, System.currentTimeMillis() + 1)) {
                Thread.currentThread().setUncaughtExceptionHandler(new d(this));
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
        this.f114649e.decrementAndGet();
        if (th5 == null) {
            a();
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f114652i >= 0 && (Thread.currentThread() instanceof a.d) && ((a.d) Thread.currentThread()).a() < this.f114650f.longValue()) {
            return true;
        }
        return false;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f114649e.get();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f114649e.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e16) {
            if (super.getQueue() instanceof com.tencent.hlyyb.downloader.f.b) {
                try {
                    if (((com.tencent.hlyyb.downloader.f.b) super.getQueue()).a(runnable, 0L, timeUnit)) {
                        return;
                    }
                    this.f114649e.decrementAndGet();
                    throw new RejectedExecutionException("Queue capacity is full.");
                } catch (InterruptedException e17) {
                    this.f114649e.decrementAndGet();
                    Thread.interrupted();
                    throw new RejectedExecutionException(e17);
                }
            }
            this.f114649e.decrementAndGet();
            throw e16;
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? (RunnableFuture) runnable : (RunnableFuture) iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable, (Object) t16);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Future) iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        }
        return super.submit(new a(this, runnable, null));
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? (RunnableFuture) callable : (RunnableFuture) iPatchRedirector.redirect((short) 8, (Object) this, (Object) callable);
    }
}
