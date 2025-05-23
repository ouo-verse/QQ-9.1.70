package com.tencent.upload.utils.pool;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes27.dex */
public class PriorityThreadPoolExecutor extends BaseThreadPoolExecutor {
    static IPatchRedirector $redirector_ = null;
    public static final int ABOVE_NORMAL = 1;
    public static final int BELOW_NORMAL = -1;
    public static final int HIGH = 2;
    public static final int IDEL = -2;
    public static final int NORMAL = 0;
    private static final String TAG = "PriorityThreadPoolExecutor";

    /* loaded from: classes27.dex */
    private static class ComparableFutureTask<V> extends FutureTask<V> implements Comparable<ComparableFutureTask<V>> {
        static IPatchRedirector $redirector_;
        private Object object;

        public ComparableFutureTask(Callable<V> callable) {
            super(callable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.object = callable;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callable);
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
            }
            if (obj != null && (obj instanceof ComparableFutureTask)) {
                return this.object.equals(((ComparableFutureTask) obj).object);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask<V> comparableFutureTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) comparableFutureTask)).intValue();
            }
            if (this == comparableFutureTask) {
                return 0;
            }
            if (comparableFutureTask == null) {
                return -1;
            }
            Object obj = this.object;
            if (obj != null && comparableFutureTask.object != null && obj.getClass().equals(comparableFutureTask.object.getClass())) {
                Object obj2 = this.object;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(comparableFutureTask.object);
                }
            }
            return 0;
        }

        public ComparableFutureTask(Runnable runnable, V v3) {
            super(runnable, v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.object = runnable;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) v3);
            }
        }
    }

    /* loaded from: classes27.dex */
    private static class PriorityTask implements Comparable<PriorityTask> {
        static IPatchRedirector $redirector_;
        protected long mPostTime;
        protected int mPriority;

        public PriorityTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mPriority = 0;
                this.mPostTime = System.currentTimeMillis();
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(PriorityTask priorityTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) priorityTask)).intValue();
            }
            if (this == priorityTask) {
                return 0;
            }
            int i3 = priorityTask.mPriority - this.mPriority;
            return i3 != 0 ? i3 : (int) (this.mPostTime - priorityTask.mPostTime);
        }

        public PriorityTask(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            this.mPriority = 0;
            this.mPostTime = System.currentTimeMillis();
            this.mPriority = i3;
        }
    }

    public PriorityThreadPoolExecutor(int i3, int i16, ThreadFactory threadFactory) {
        super(i3, i16, 15L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), threadFactory);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else if (runnable instanceof ComparableFutureTask) {
            super.execute(runnable);
        } else {
            submit(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? new ComparableFutureTask(runnable, t16) : (RunnableFuture) iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable, (Object) t16);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public boolean remove(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) runnable)).booleanValue();
        }
        return super.remove(new PriorityRunnable(runnable));
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public java.util.concurrent.Future<?> submit(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? super.submit(new PriorityRunnable(runnable)) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class PriorityCallable<T> extends PriorityTask implements Callable<T> {
        static IPatchRedirector $redirector_;
        protected Callable<T> mC;

        public PriorityCallable(Callable<T> callable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mC = callable;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callable);
            }
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (System.currentTimeMillis() - this.mPostTime > 30000) {
                Log.w(PriorityThreadPoolExecutor.TAG, "this job hangury too long. job:" + this + ". job:" + this.mC);
            }
            T call = this.mC.call();
            this.mC = null;
            return call;
        }

        public PriorityCallable(Callable<T> callable, int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mC = callable;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) callable, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class PriorityRunnable extends PriorityTask implements Runnable {
        static IPatchRedirector $redirector_;
        protected Runnable mR;

        public PriorityRunnable(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mR = runnable;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (System.currentTimeMillis() - this.mPostTime > 30000) {
                Log.w(PriorityThreadPoolExecutor.TAG, "this job hangury too long. job:" + this + ". job:" + this.mR);
            }
            try {
                this.mR.run();
            } catch (Throwable th5) {
                Log.w(PriorityThreadPoolExecutor.TAG, th5);
            }
            this.mR = null;
        }

        public PriorityRunnable(Runnable runnable, int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mR = runnable;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, i3);
            }
        }
    }

    public PriorityThreadPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, new PriorityBlockingQueue(), threadFactory);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), timeUnit, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? new ComparableFutureTask(callable) : (RunnableFuture) iPatchRedirector.redirect((short) 11, (Object) this, (Object) callable);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java.util.concurrent.Future<T> submit(Runnable runnable, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? super.submit((Runnable) new PriorityRunnable(runnable), (PriorityRunnable) t16) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable, (Object) t16);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java.util.concurrent.Future<T> submit(Callable<T> callable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? super.submit(new PriorityCallable(callable)) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) callable);
    }

    public java.util.concurrent.Future<?> submit(Runnable runnable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? super.submit(new PriorityRunnable(runnable, i3)) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable, i3);
    }

    public <T> java.util.concurrent.Future<?> submit(Runnable runnable, T t16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? super.submit((Runnable) new PriorityRunnable(runnable, i3), (PriorityRunnable) t16) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 7, this, runnable, t16, Integer.valueOf(i3));
    }

    public <T> java.util.concurrent.Future<T> submit(Callable<T> callable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? submit(new PriorityCallable(callable, i3)) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 8, (Object) this, (Object) callable, i3);
    }
}
