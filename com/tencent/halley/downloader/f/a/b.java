package com.tencent.halley.downloader.f.a;

import com.tencent.halley.common.a.a.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.lang.Thread;
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
/* loaded from: classes6.dex */
public final class b extends BaseThreadPoolExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final AtomicInteger f113751a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f113752b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f113753c;

    /* renamed from: d, reason: collision with root package name */
    private long f113754d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    protected class a<T> extends FutureTask<T> implements Comparable<a<T>> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private Object f113757b;

        /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Runnable;TT;)V */
        public a(Runnable runnable) {
            super(runnable, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) runnable);
            } else {
                this.f113757b = runnable;
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
                Object obj2 = this.f113757b;
                if (obj2 != null && aVar.f113757b != null && obj2.getClass().equals(aVar.f113757b.getClass())) {
                    Object obj3 = this.f113757b;
                    if (obj3 instanceof Comparable) {
                        return ((Comparable) obj3).compareTo(aVar.f113757b);
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.f.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class RejectedExecutionHandlerC1245b implements RejectedExecutionHandler {
        static IPatchRedirector $redirector_;

        RejectedExecutionHandlerC1245b() {
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

        /* synthetic */ RejectedExecutionHandlerC1245b(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
        }
    }

    public b(int i3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(0, i3, 5L, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandlerC1245b((byte) 0));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), timeUnit, blockingQueue, threadFactory);
            return;
        }
        this.f113751a = new AtomicInteger(0);
        this.f113752b = new AtomicLong(0L);
        this.f113753c = new AtomicLong(0L);
        this.f113754d = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (b()) {
            long longValue = this.f113753c.longValue();
            if (this.f113754d + longValue < System.currentTimeMillis() && this.f113753c.compareAndSet(longValue, System.currentTimeMillis() + 1)) {
                Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tencent.halley.downloader.f.a.b.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
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
        this.f113751a.decrementAndGet();
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
        if (this.f113754d >= 0 && (Thread.currentThread() instanceof c) && ((c) Thread.currentThread()).f113206a < this.f113752b.longValue()) {
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
        this.f113751a.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e16) {
            if (super.getQueue() instanceof com.tencent.halley.downloader.f.a.a) {
                try {
                    if (((com.tencent.halley.downloader.f.a.a) super.getQueue()).a(runnable, timeUnit)) {
                        return;
                    }
                    this.f113751a.decrementAndGet();
                    throw new RejectedExecutionException("Queue capacity is full.");
                } catch (InterruptedException e17) {
                    this.f113751a.decrementAndGet();
                    Thread.interrupted();
                    throw new RejectedExecutionException(e17);
                }
            }
            this.f113751a.decrementAndGet();
            throw e16;
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? (RunnableFuture) runnable : (RunnableFuture) iPatchRedirector.redirect((short) 8, (Object) this, (Object) runnable, (Object) t16);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Future) iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
        }
        return super.submit(new a(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? (RunnableFuture) callable : (RunnableFuture) iPatchRedirector.redirect((short) 7, (Object) this, (Object) callable);
    }
}
