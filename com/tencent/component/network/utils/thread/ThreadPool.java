package com.tencent.component.network.utils.thread;

import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ThreadPool {
    protected static final int DEFAULT_POOL_SIZE = DownloaderImpl.THREAD_POOL_SIZE;
    public static final JobContext JOB_CONTEXT_STUB = new JobContextStub();
    protected static final int KEEP_ALIVE_TIME = 10;
    public static final int MODE_CPU = 1;
    public static final int MODE_NETWORK = 2;
    public static final int MODE_NONE = 0;
    private static final String TAG = "ThreadPool";
    ResourceCounter mCpuCounter;
    private final Executor mExecutor;
    ResourceCounter mNetworkCounter;

    /* loaded from: classes5.dex */
    public interface CancelListener {
        void onCancel();
    }

    /* loaded from: classes5.dex */
    public interface Job<T> {
        T run(JobContext jobContext);
    }

    /* loaded from: classes5.dex */
    public interface JobContext {
        boolean isCancelled();

        void setCancelListener(CancelListener cancelListener);

        boolean setMode(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ResourceCounter {
        public int value;

        public ResourceCounter(int i3) {
            this.value = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Worker<T> implements Runnable, Future<T>, JobContext, Comparable<Worker> {
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
            this.mJob = job;
            this.mListener = futureListener;
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

        @Override // com.tencent.component.network.utils.thread.Future
        public synchronized void cancel() {
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

        @Override // com.tencent.component.network.utils.thread.Future
        public synchronized T get() {
            while (!this.mIsDone) {
                try {
                    LockMethodProxy.wait(this);
                } catch (Exception e16) {
                    QDLog.w(TAG, "ignore exception", e16);
                }
            }
            return this.mResult;
        }

        @Override // com.tencent.component.network.utils.thread.Future, com.tencent.component.network.utils.thread.ThreadPool.JobContext
        public boolean isCancelled() {
            return this.mIsCancelled;
        }

        @Override // com.tencent.component.network.utils.thread.Future
        public synchronized boolean isDone() {
            return this.mIsDone;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            T run;
            FutureListener<T> futureListener = this.mListener;
            if (futureListener != null) {
                futureListener.onFutureBegin(this);
            }
            if (setMode(1)) {
                try {
                    run = this.mJob.run(this);
                } catch (Throwable th5) {
                    QDLog.w(TAG, "Exception in running a job", th5);
                }
                synchronized (this) {
                    setMode(0);
                    this.mResult = run;
                    this.mIsDone = true;
                    notifyAll();
                }
                try {
                    FutureListener<T> futureListener2 = this.mListener;
                    if (futureListener2 != null) {
                        futureListener2.onFutureDone(this);
                        return;
                    }
                    return;
                } catch (Throwable th6) {
                    QDLog.w(TAG, "Exception in onFutureDone.", th6);
                    return;
                }
            }
            run = null;
            synchronized (this) {
            }
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.JobContext
        public synchronized void setCancelListener(CancelListener cancelListener) {
            CancelListener cancelListener2;
            this.mCancelListener = cancelListener;
            if (this.mIsCancelled && (cancelListener2 = this.mCancelListener) != null) {
                cancelListener2.onCancel();
            }
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.JobContext
        public boolean setMode(int i3) {
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

        @Override // com.tencent.component.network.utils.thread.Future
        public void waitDone() {
            get();
        }

        @Override // java.lang.Comparable
        public int compareTo(Worker worker) {
            return ((Comparable) this.mJob).compareTo(worker.mJob);
        }
    }

    public ThreadPool() {
        this("thread-pool", DEFAULT_POOL_SIZE);
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        Worker worker = new Worker(job, futureListener);
        this.mExecutor.execute(worker);
        return worker;
    }

    public ThreadPool(String str, int i3) {
        this(str, i3, i3, new LinkedBlockingQueue());
    }

    public ThreadPool(Executor executor) {
        this.mCpuCounter = new ResourceCounter(2);
        this.mNetworkCounter = new ResourceCounter(DownloaderImpl.THREAD_POOL_SIZE);
        this.mExecutor = new SmartThreadExecutor(executor == null ? new BaseThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10)) : executor);
    }

    public <T> Future<T> submit(Job<T> job) {
        return submit(job, null);
    }

    public ThreadPool(String str, int i3, int i16, BlockingQueue<Runnable> blockingQueue) {
        this.mCpuCounter = new ResourceCounter(2);
        ResourceCounter resourceCounter = new ResourceCounter(DownloaderImpl.THREAD_POOL_SIZE);
        this.mNetworkCounter = resourceCounter;
        int i17 = i3 <= 0 ? 1 : i3;
        int i18 = i16 <= i17 ? i17 : i16;
        resourceCounter.value = i18;
        this.mExecutor = new SmartThreadExecutor(new BaseThreadPoolExecutor(i17, i18, 10L, TimeUnit.SECONDS, blockingQueue, new PriorityThreadFactory(str, 10)));
    }

    /* loaded from: classes5.dex */
    private static class JobContextStub implements JobContext {
        JobContextStub() {
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.JobContext
        public boolean isCancelled() {
            return false;
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.JobContext
        public boolean setMode(int i3) {
            return true;
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.JobContext
        public void setCancelListener(CancelListener cancelListener) {
        }
    }
}
