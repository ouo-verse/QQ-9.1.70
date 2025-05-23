package com.tencent.upload.utils.pool;

import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public class ThreadPool {
    static IPatchRedirector $redirector_ = null;
    private static final int CORE_POOL_SIZE = 4;
    public static final JobContext JOB_CONTEXT_STUB;
    private static final int MAX_POOL_SIZE = 8;
    public static final int MODE_CPU = 1;
    public static final int MODE_NETWORK = 2;
    public static final int MODE_NONE = 0;
    private static final String TAG = "ThreadPool";
    private final PriorityThreadPoolExecutor mExecutor;

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

        @Override // com.tencent.upload.utils.pool.ThreadPool.JobContext
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.upload.utils.pool.ThreadPool.JobContext
        public void setCancelListener(CancelListener cancelListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cancelListener);
            }
        }

        @Override // com.tencent.upload.utils.pool.ThreadPool.JobContext
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class Worker<T> implements Runnable, Future<T>, JobContext {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "Worker";
        private CancelListener mCancelListener;
        private volatile boolean mIsCancelled;
        private boolean mIsDone;
        private Job<T> mJob;
        private FutureListener<T> mListener;
        private T mResult;

        public Worker(Job<T> job, FutureListener<T> futureListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThreadPool.this, job, futureListener);
            } else {
                this.mJob = job;
                this.mListener = futureListener;
            }
        }

        @Override // com.tencent.upload.utils.pool.Future
        public synchronized void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                if (this.mIsCancelled) {
                    return;
                }
                this.mIsCancelled = true;
                CancelListener cancelListener = this.mCancelListener;
                if (cancelListener != null) {
                    cancelListener.onCancel();
                }
            }
        }

        @Override // com.tencent.upload.utils.pool.Future
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

        @Override // com.tencent.upload.utils.pool.Future, com.tencent.upload.utils.pool.ThreadPool.JobContext
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.mIsCancelled;
        }

        @Override // com.tencent.upload.utils.pool.Future
        public synchronized boolean isDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.mIsDone;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
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
            if (setMode(1)) {
                try {
                    run = this.mJob.run(this);
                } catch (Throwable th5) {
                    Log.w(TAG, "Exception in running a job", th5);
                }
                synchronized (this) {
                    setMode(0);
                    this.mResult = run;
                    this.mIsDone = true;
                    notifyAll();
                }
                FutureListener<T> futureListener = this.mListener;
                if (futureListener != null) {
                    futureListener.onFutureDone(this);
                    return;
                }
                return;
            }
            run = null;
            synchronized (this) {
            }
        }

        @Override // com.tencent.upload.utils.pool.ThreadPool.JobContext
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

        @Override // com.tencent.upload.utils.pool.ThreadPool.JobContext
        public boolean setMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            return !isCancelled();
        }

        @Override // com.tencent.upload.utils.pool.Future
        public void waitDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                get();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            JOB_CONTEXT_STUB = new JobContextStub(null);
        }
    }

    public ThreadPool() {
        this(4, 8);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public PriorityThreadPoolExecutor getExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PriorityThreadPoolExecutor) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mExecutor;
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? submit(job, 0, futureListener) : (Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) job, (Object) futureListener);
    }

    public ThreadPool(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mExecutor = ThreadPoolFactory.createPriorityThreadPoolExecutor(i3, i16, "thread-pool");
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public <T> Future<T> submit(Job<T> job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? submit(job, 0, null) : (Future) iPatchRedirector.redirect((short) 6, (Object) this, (Object) job);
    }

    public <T> Future<T> submit(Job<T> job, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? submit(job, i3, null) : (Future) iPatchRedirector.redirect((short) 7, (Object) this, (Object) job, i3);
    }

    public ThreadPool(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mExecutor = ThreadPoolFactory.createPriorityThreadPoolExecutor(i3, i16, str);
        } else {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
    }

    public <T> Future<T> submit(Job<T> job, int i3, FutureListener<T> futureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Future) iPatchRedirector.redirect((short) 8, this, job, Integer.valueOf(i3), futureListener);
        }
        Worker worker = new Worker(job, futureListener);
        this.mExecutor.submit(worker, i3);
        return worker;
    }

    public java.util.concurrent.Future<?> submit(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.mExecutor.submit(runnable) : (java.util.concurrent.Future) iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
    }
}
