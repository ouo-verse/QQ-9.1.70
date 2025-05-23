package com.tencent.oskplayer.util;

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
/* loaded from: classes22.dex */
public class ThreadUtils {
    private static final String TAG = "ThreadUtils";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ComparableFutureTask<T> extends FutureTask<T> implements Comparable<ComparableFutureTask<T>> {
        volatile long priority;

        public ComparableFutureTask(Callable<T> callable, long j3) {
            super(callable);
            this.priority = 0L;
            this.priority = j3;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask<T> comparableFutureTask) {
            return Long.valueOf(this.priority).compareTo(Long.valueOf(comparableFutureTask.priority));
        }

        public ComparableFutureTask(Runnable runnable, T t16, long j3) {
            super(runnable, t16);
            this.priority = 0L;
            this.priority = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class PriorityExecutor extends BaseThreadPoolExecutor {
        public PriorityExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i3, i16, j3, timeUnit, blockingQueue);
        }

        public void execute(Runnable runnable, long j3) {
            super.execute(new ComparableFutureTask(runnable, null, j3));
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t16) {
            return (RunnableFuture) runnable;
        }

        public Future<?> submit(Runnable runnable, long j3) {
            return super.submit(new ComparableFutureTask(runnable, null, j3));
        }

        public PriorityExecutor(int i3) {
            this(i3, i3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
            return (RunnableFuture) callable;
        }
    }

    public static synchronized void executePriorityTask(ArrayList<Runnable> arrayList) {
        synchronized (ThreadUtils.class) {
            executePriorityTask(arrayList, 2);
        }
    }

    public static Future<?> submitTask(Runnable runnable, String str) {
        FlexibleSizeExecutor flexibleSizeExecutor = new FlexibleSizeExecutor("job " + str + " ");
        Future<?> submit = flexibleSizeExecutor.submit(runnable);
        flexibleSizeExecutor.shutdown();
        return submit;
    }

    public static void submitTaskCatchAll(Runnable runnable, int i3, boolean z16, String str) {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future<?> submit = newSingleThreadExecutor.submit(runnable);
        newSingleThreadExecutor.shutdown();
        String str2 = "job " + str + " ";
        try {
            submit.get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            PlayerUtils.log(5, TAG, str2 + "interrupted");
        } catch (ExecutionException e16) {
            PlayerUtils.log(6, TAG, str2 + "caught exception: " + PlayerUtils.getPrintableStackTrace(e16));
        } catch (TimeoutException unused2) {
            if (z16) {
                PlayerUtils.log(4, TAG, str2 + "cancelled");
                submit.cancel(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class FlexibleSizeExecutor extends BaseThreadPoolExecutor {
        String jobDescription;

        public FlexibleSizeExecutor(String str) {
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            this.jobDescription = str;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th5) {
            super.afterExecute(runnable, th5);
            if (th5 == null && (runnable instanceof Future)) {
                try {
                    Future future = (Future) runnable;
                    if (future.isDone() && !future.isCancelled()) {
                        PlayerUtils.log(3, ThreadUtils.TAG, "before future.get()");
                        future.get();
                        PlayerUtils.log(3, ThreadUtils.TAG, "after future.get()");
                    }
                } catch (InterruptedException unused) {
                    PlayerUtils.log(5, ThreadUtils.TAG, "InterruptedException");
                    Thread.currentThread().interrupt();
                } catch (CancellationException e16) {
                    th5 = e16;
                    PlayerUtils.log(5, ThreadUtils.TAG, "CancellationException");
                } catch (ExecutionException e17) {
                    PlayerUtils.log(5, ThreadUtils.TAG, "ExecutionException");
                    th5 = e17.getCause();
                }
            }
            if (th5 != null) {
                PlayerUtils.log(6, ThreadUtils.TAG, this.jobDescription + " error occurred during processing request : " + PlayerUtils.getPrintableStackTrace(th5));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        public void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            PlayerUtils.log(4, ThreadUtils.TAG, "beforeExecute: thread=" + thread.toString() + " thread.state=" + thread.getState() + " runnable=" + runnable.toString());
        }

        public int getPendingTaskCount() {
            return getActiveCount() + getQueue().size();
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t16) {
            return super.newTaskFor(runnable, t16);
        }

        public FlexibleSizeExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i3, i16, j3, timeUnit, blockingQueue);
            this.jobDescription = "";
        }
    }

    public static synchronized void executePriorityTask(ArrayList<Runnable> arrayList, int i3) {
        synchronized (ThreadUtils.class) {
            PriorityExecutor priorityExecutor = new PriorityExecutor(i3);
            Long l3 = 1L;
            Iterator<Runnable> it = arrayList.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                Long valueOf = Long.valueOf(l3.longValue() + 1);
                priorityExecutor.execute(next, l3.longValue());
                l3 = valueOf;
            }
            priorityExecutor.shutdown();
        }
    }

    public static void submitTask(Runnable runnable, int i3, boolean z16, String str) throws InterruptedException, ExecutionException {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future<?> submit = newSingleThreadExecutor.submit(runnable);
        newSingleThreadExecutor.shutdown();
        String str2 = "job " + str + " ";
        try {
            submit.get(i3, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            if (z16) {
                PlayerUtils.log(4, TAG, str2 + "cancelled");
                submit.cancel(true);
            }
        }
    }

    public static Object submitTaskCatchAll(Callable<?> callable, int i3, boolean z16, String str, String str2) {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(callable);
        newSingleThreadExecutor.shutdown();
        String str3 = "job " + str + " ";
        try {
            return submit.get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            PlayerUtils.log(4, str2, str3 + "interrupted");
            return null;
        } catch (ExecutionException e16) {
            PlayerUtils.log(4, str2, str3 + "caught exception " + PlayerUtils.getPrintableStackTrace(e16));
            return null;
        } catch (TimeoutException unused2) {
            if (!z16) {
                return null;
            }
            PlayerUtils.log(4, str2, str3 + "cancelled");
            submit.cancel(true);
            return null;
        }
    }

    public static Object submitTask(Callable<?> callable, int i3, boolean z16, String str, String str2) throws InterruptedException, ExecutionException {
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
            PlayerUtils.log(4, str2, str3 + "cancelled");
            submit.cancel(true);
            return null;
        }
    }
}
