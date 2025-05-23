package com.tencent.luggage.wxa.tg;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends FutureTask implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public volatile long f141317a;

        public a(Runnable runnable, Object obj, long j3) {
            super(runnable, obj);
            this.f141317a = 0L;
            this.f141317a = j3;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Long.valueOf(this.f141317a).compareTo(Long.valueOf(aVar.f141317a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends BaseThreadPoolExecutor {
        public c(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(i3, i16, j3, timeUnit, blockingQueue);
        }

        public void a(Runnable runnable, long j3) {
            super.execute(new a(runnable, null, j3));
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public RunnableFuture newTaskFor(Runnable runnable, Object obj) {
            return (RunnableFuture) runnable;
        }

        public c(int i3) {
            this(i3, i3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public RunnableFuture newTaskFor(Callable callable) {
            return (RunnableFuture) callable;
        }
    }

    public static Future a(Runnable runnable, String str) {
        b bVar = new b("job " + str + " ");
        Future<?> submit = bVar.submit(runnable);
        bVar.shutdown();
        return submit;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends BaseThreadPoolExecutor {

        /* renamed from: a, reason: collision with root package name */
        public String f141318a;

        public b(String str) {
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            this.f141318a = str;
        }

        public int a() {
            return getActiveCount() + getQueue().size();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th5) {
            super.afterExecute(runnable, th5);
            if (th5 == null && (runnable instanceof Future)) {
                try {
                    Future future = (Future) runnable;
                    if (future.isDone() && !future.isCancelled()) {
                        h.a(3, "ThreadUtils", "before future.get()");
                        future.get();
                        h.a(3, "ThreadUtils", "after future.get()");
                    }
                } catch (InterruptedException unused) {
                    h.a(5, "ThreadUtils", "InterruptedException");
                    Thread.currentThread().interrupt();
                } catch (CancellationException e16) {
                    th5 = e16;
                    h.a(5, "ThreadUtils", "CancellationException");
                } catch (ExecutionException e17) {
                    h.a(5, "ThreadUtils", "ExecutionException");
                    th5 = e17.getCause();
                }
            }
            if (th5 != null) {
                h.a(6, "ThreadUtils", this.f141318a + " error occurred during processing request:" + h.a(th5));
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        public void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            h.a(4, "ThreadUtils", "beforeExecute: thread=" + thread.toString() + " thread.state=" + thread.getState() + " runnable=" + runnable.toString());
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public RunnableFuture newTaskFor(Runnable runnable, Object obj) {
            return super.newTaskFor(runnable, obj);
        }

        public b(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(i3, i16, j3, timeUnit, blockingQueue);
            this.f141318a = "";
        }
    }

    public static synchronized void a(ArrayList arrayList, int i3) {
        synchronized (m.class) {
            c cVar = new c(i3);
            Long l3 = 1L;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                Long valueOf = Long.valueOf(l3.longValue() + 1);
                cVar.a(runnable, l3.longValue());
                l3 = valueOf;
            }
            cVar.shutdown();
        }
    }

    public static Object a(Callable callable, int i3, boolean z16, String str, String str2) {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(callable);
        newSingleThreadExecutor.shutdown();
        String str3 = "job " + str + " ";
        try {
            return submit.get(i3, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            if (!z16) {
                return null;
            }
            h.a(4, str2, str3 + "cancelled");
            submit.cancel(true);
            return null;
        }
    }
}
