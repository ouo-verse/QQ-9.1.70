package com.tencent.sonic.sdk;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public class SonicSessionThreadPool {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SonicSdk_SonicSessionThreadPool";
    private static final SonicSessionThreadPool sInstance;
    private final ExecutorService executorServiceImpl;

    /* loaded from: classes25.dex */
    private static class SessionThreadFactory implements ThreadFactory {
        static IPatchRedirector $redirector_ = null;
        private static final String NAME_PREFIX = "pool-sonic-session-thread-";
        private final ThreadGroup group;
        private final AtomicInteger threadNumber;

        SessionThreadFactory() {
            ThreadGroup threadGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.threadNumber = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            BaseThread baseThread = new BaseThread(this.group, runnable, NAME_PREFIX + this.threadNumber.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            if (baseThread.getPriority() != 5) {
                baseThread.setPriority(5);
            }
            return baseThread;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sInstance = new SonicSessionThreadPool();
        }
    }

    SonicSessionThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.executorServiceImpl = new BaseThreadPoolExecutor(1, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new SessionThreadFactory());
        }
    }

    private boolean execute(Runnable runnable) {
        try {
            this.executorServiceImpl.execute(runnable);
            return true;
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "execute task error:" + th5.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean postTask(Runnable runnable) {
        return sInstance.execute(runnable);
    }
}
