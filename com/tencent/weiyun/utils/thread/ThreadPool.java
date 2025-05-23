package com.tencent.weiyun.utils.thread;

import android.annotation.TargetApi;
import android.os.Process;
import android.util.Log;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes27.dex */
public class ThreadPool {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_POOL_SIZE = 4;
    public static final int DEFAULT_THREAD_PRIORITY = 10;
    public static final JobContext JOB_CONTEXT_STUB;
    public static final int MODE_CPU = 1;
    public static final int MODE_NETWORK = 2;
    public static final int MODE_NONE = 0;
    private static final String TAG = "ThreadPool";
    ResourceCounter mCpuCounter;
    private final ThreadPoolExecutor mExecutor;
    ResourceCounter mNetworkCounter;
    private final PriorityThreadFactory mThreadFactory;

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
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.weiyun.utils.thread.ThreadPool.JobContext
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.weiyun.utils.thread.ThreadPool.JobContext
        public void setCancelListener(CancelListener cancelListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cancelListener);
            }
        }

        @Override // com.tencent.weiyun.utils.thread.ThreadPool.JobContext
        public boolean setMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
            }
            return true;
        }

        /* synthetic */ JobContextStub(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }
    }

    /* loaded from: classes27.dex */
    static final class PriorityThreadFactory implements ThreadFactory {
        static IPatchRedirector $redirector_;
        private final String mName;
        private final AtomicInteger mNumber;
        private int mPriority;

        public PriorityThreadFactory(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                return;
            }
            this.mNumber = new AtomicInteger();
            this.mName = str;
            this.mPriority = i3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Thread) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            }
            return new BaseThread(runnable, this.mName + '-' + this.mNumber.getAndIncrement()) { // from class: com.tencent.weiyun.utils.thread.ThreadPool.PriorityThreadFactory.1
                static IPatchRedirector $redirector_;

                {
                    super(runnable, r9);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PriorityThreadFactory.this, runnable, r9);
                    }
                }

                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
                        super.run();
                    }
                }
            };
        }

        public void setPriority(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.mPriority = i3;
            }
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

        @Override // com.tencent.weiyun.utils.thread.Future
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

        @Override // com.tencent.weiyun.utils.thread.Future
        public synchronized T get() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (T) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            while (!this.mIsDone) {
                try {
                    LockMethodProxy.wait(this);
                } catch (Exception e16) {
                    Log.w(TAG, "ignore exception", e16);
                }
            }
            return this.mResult;
        }

        @Override // com.tencent.weiyun.utils.thread.Future, com.tencent.weiyun.utils.thread.ThreadPool.JobContext
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.mIsCancelled;
        }

        @Override // com.tencent.weiyun.utils.thread.Future
        public synchronized boolean isDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.mIsDone;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (setMode(1)) {
                t16 = this.mJob.run(this);
            } else {
                t16 = null;
            }
            synchronized (this) {
                setMode(0);
                this.mResult = t16;
                this.mIsDone = true;
                notifyAll();
            }
            FutureListener<T> futureListener = this.mListener;
            if (futureListener != null) {
                futureListener.onFutureDone(this);
            }
        }

        @Override // com.tencent.weiyun.utils.thread.ThreadPool.JobContext
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

        @Override // com.tencent.weiyun.utils.thread.ThreadPool.JobContext
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

        @Override // com.tencent.weiyun.utils.thread.Future
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(PlayUI.UIType.WEAKEN_SMALL_CARD_NG);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            JOB_CONTEXT_STUB = new JobContextStub(null);
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

    final Executor getExecutor() {
        return this.mExecutor;
    }

    public boolean isShutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mExecutor.isShutdown();
    }

    public void setPriority(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mThreadFactory.setPriority(i3);
        }
    }

    public void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mExecutor.shutdown();
        }
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Future) iPatchRedirector.redirect((short) 7, (Object) this, (Object) job, (Object) futureListener);
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

    @TargetApi(9)
    public ThreadPool(String str, int i3, long j3, TimeUnit timeUnit) {
        this(str, i3, i3, j3, timeUnit, new LinkedBlockingQueue());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), timeUnit);
        } else if (j3 > 0) {
            this.mExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public <T> Future<T> submit(Job<T> job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? submit(job, null) : (Future) iPatchRedirector.redirect((short) 8, (Object) this, (Object) job);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    public ThreadPool(String str, int i3, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this(str, i3, i3, j3, timeUnit, blockingQueue);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Long.valueOf(j3), timeUnit, blockingQueue);
        } else if (j3 > 0) {
            this.mExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public ThreadPool(String str, int i3, int i16, BlockingQueue<Runnable> blockingQueue) {
        this(str, i3, i16, 10L, TimeUnit.SECONDS, blockingQueue);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), blockingQueue);
    }

    public ThreadPool(String str, int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), timeUnit, blockingQueue);
            return;
        }
        this.mCpuCounter = new ResourceCounter(2);
        this.mNetworkCounter = new ResourceCounter(2);
        if (i3 < 0) {
            i18 = i16;
            i17 = 0;
        } else {
            i17 = i3;
            i18 = i16;
        }
        int i19 = i18 < i17 ? i17 : i18;
        PriorityThreadFactory priorityThreadFactory = new PriorityThreadFactory(str, 10);
        this.mThreadFactory = priorityThreadFactory;
        this.mExecutor = new BaseThreadPoolExecutor(i17, i19, j3, timeUnit, blockingQueue, priorityThreadFactory);
    }
}
