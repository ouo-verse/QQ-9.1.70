package com.tencent.weiyun.transmission.utils.thread;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.weiyun.transmission.utils.TsLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes27.dex */
public class ThreadPool {
    static IPatchRedirector $redirector_ = null;
    protected static final int DEFAULT_POOL_SIZE = 4;
    protected static final int KEEP_ALIVE_TIME = 10;
    public static final int MODE_CPU = 1;
    public static final int MODE_NETWORK = 2;
    public static final int MODE_NONE = 0;
    ResourceCounter mCpuCounter;
    private final ThreadPoolExecutor mExecutor;
    ResourceCounter mNetworkCounter;

    /* loaded from: classes27.dex */
    public interface CancelListener {
        void onCancel();
    }

    /* loaded from: classes27.dex */
    public interface Job<T> {
        T run(JobContext jobContext);
    }

    /* loaded from: classes27.dex */
    public interface JobContext {
        boolean isCancelled();

        void setCancelListener(CancelListener cancelListener);

        boolean setMode(int i3);
    }

    /* loaded from: classes27.dex */
    private static class JobContextStub implements JobContext {
        static IPatchRedirector $redirector_;

        JobContextStub() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext
        public void setCancelListener(CancelListener cancelListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cancelListener);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext
        public boolean setMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class ResourceCounter {
        static IPatchRedirector $redirector_;
        public int value;

        public ResourceCounter(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.value = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class Worker<T> implements Runnable, Future<T>, JobContext, Comparable<Worker> {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "Worker";
        private CancelListener mCancelListener;
        private volatile boolean mIsCancelled;
        private boolean mIsDone;
        private final Job<T> mJob;
        private final FutureListener<T> mListener;
        private int mMode;
        private T mResult;
        private ResourceCounter mWaitOnResource;

        public Worker(Job<T> job, FutureListener<T> futureListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThreadPool.this, job, futureListener);
            } else {
                this.mJob = job;
                this.mListener = futureListener;
            }
        }

        private boolean acquireResource(ResourceCounter resourceCounter) {
            while (true) {
                synchronized (this) {
                    if (this.mIsCancelled) {
                        this.mWaitOnResource = null;
                        return false;
                    }
                    this.mWaitOnResource = resourceCounter;
                    synchronized (resourceCounter) {
                        int i3 = resourceCounter.value;
                        if (i3 > 0) {
                            resourceCounter.value = i3 - 1;
                            synchronized (this) {
                                this.mWaitOnResource = null;
                            }
                            return true;
                        }
                        try {
                            LockMethodProxy.wait(resourceCounter);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }

        private ResourceCounter modeToCounter(int i3) {
            if (i3 == 1) {
                return ThreadPool.this.mCpuCounter;
            }
            if (i3 == 2) {
                return ThreadPool.this.mNetworkCounter;
            }
            return null;
        }

        private void releaseResource(ResourceCounter resourceCounter) {
            synchronized (resourceCounter) {
                resourceCounter.value++;
                resourceCounter.notifyAll();
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.Future
        public synchronized void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.mIsCancelled) {
                return;
            }
            this.mIsCancelled = true;
            ResourceCounter resourceCounter = this.mWaitOnResource;
            if (resourceCounter != null) {
                synchronized (resourceCounter) {
                    this.mWaitOnResource.notifyAll();
                }
            }
            CancelListener cancelListener = this.mCancelListener;
            if (cancelListener != null) {
                cancelListener.onCancel();
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.Future
        public synchronized T get() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (T) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            while (!this.mIsDone) {
                try {
                    LockMethodProxy.wait(this);
                } catch (Exception e16) {
                    TsLog.w(TAG, "ignore exception", e16);
                }
            }
            return this.mResult;
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.Future, com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.mIsCancelled;
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.Future
        public synchronized boolean isDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.mIsDone;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            T run;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FutureListener<T> futureListener = this.mListener;
            if (futureListener != null) {
                futureListener.onFutureBegin(this);
            }
            if (setMode(1)) {
                try {
                    run = this.mJob.run(this);
                } catch (Throwable th5) {
                    TsLog.w(TAG, "Exception in running a job", th5);
                }
                synchronized (this) {
                    setMode(0);
                    this.mResult = run;
                    this.mIsDone = true;
                    notifyAll();
                }
                FutureListener<T> futureListener2 = this.mListener;
                if (futureListener2 != null) {
                    futureListener2.onFutureDone(this);
                    return;
                }
                return;
            }
            run = null;
            synchronized (this) {
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext
        public synchronized void setCancelListener(CancelListener cancelListener) {
            CancelListener cancelListener2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) cancelListener);
                return;
            }
            this.mCancelListener = cancelListener;
            if (this.mIsCancelled && (cancelListener2 = this.mCancelListener) != null) {
                cancelListener2.onCancel();
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext
        public boolean setMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            ResourceCounter modeToCounter = modeToCounter(this.mMode);
            if (modeToCounter != null) {
                releaseResource(modeToCounter);
            }
            this.mMode = 0;
            ResourceCounter modeToCounter2 = modeToCounter(i3);
            if (modeToCounter2 != null) {
                if (!acquireResource(modeToCounter2)) {
                    return false;
                }
                this.mMode = i3;
                return true;
            }
            return true;
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.Future
        public void waitDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                get();
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Worker worker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? ((Comparable) this.mJob).compareTo(worker.mJob) : ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) worker)).intValue();
        }
    }

    public ThreadPool() {
        this("thread-pool", 4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mExecutor.shutdown();
        }
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) job, (Object) futureListener);
        }
        Worker worker = new Worker(job, futureListener);
        this.mExecutor.execute(worker);
        return worker;
    }

    public ThreadPool(String str, int i3) {
        this(str, i3, i3, new LinkedBlockingQueue());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
    }

    public ThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) threadPoolExecutor);
            return;
        }
        this.mCpuCounter = new ResourceCounter(2);
        this.mNetworkCounter = new ResourceCounter(2);
        this.mExecutor = threadPoolExecutor == null ? new BaseThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10)) : threadPoolExecutor;
    }

    public <T> Future<T> submit(Job<T> job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? submit(job, null) : (Future) iPatchRedirector.redirect((short) 6, (Object) this, (Object) job);
    }

    public ThreadPool(String str, int i3, int i16, BlockingQueue<Runnable> blockingQueue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), blockingQueue);
            return;
        }
        this.mCpuCounter = new ResourceCounter(2);
        this.mNetworkCounter = new ResourceCounter(2);
        int i17 = i3 <= 0 ? 1 : i3;
        this.mExecutor = new BaseThreadPoolExecutor(i17, i16 <= i17 ? i17 : i16, 10L, TimeUnit.SECONDS, blockingQueue, new PriorityThreadFactory(str, 10));
    }
}
