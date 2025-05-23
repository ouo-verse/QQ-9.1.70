package com.tencent.upload.utils.pool;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes27.dex */
public class ThreadPoolFactory {
    static IPatchRedirector $redirector_;

    /* loaded from: classes27.dex */
    private static class RunnableProxy implements Runnable {
        static IPatchRedirector $redirector_;
        private final String TAG;
        private final Runnable mR;

        public RunnableProxy(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            } else {
                this.TAG = "Execption";
                this.mR = runnable;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                this.mR.run();
            } catch (Throwable th5) {
                Log.w("Execption", th5);
            }
        }
    }

    /* loaded from: classes27.dex */
    private static class ThreadPoolExecutorImpl extends BaseThreadPoolExecutor {
        static IPatchRedirector $redirector_;

        public ThreadPoolExecutorImpl(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), timeUnit, blockingQueue, threadFactory);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            } else {
                super.execute(new RunnableProxy(runnable));
            }
        }
    }

    public ThreadPoolFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static PriorityThreadPoolExecutor createPriorityThreadPoolExecutor(int i3, int i16, String str) {
        return new PriorityThreadPoolExecutor(i3, i16, new PriorityThreadFactory(str, 0));
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(int i3, long j3, String str) {
        return new ThreadPoolExecutorImpl(i3, i3, j3, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(str, 10));
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(int i3, int i16, long j3, String str) {
        return new ThreadPoolExecutorImpl(i3, i16, j3, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(str, 10));
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        return new ThreadPoolExecutorImpl(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
    }
}
