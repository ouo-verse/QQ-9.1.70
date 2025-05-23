package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ThreadDBPool extends ThreadSmartPool {
    static IPatchRedirector $redirector_ = null;
    private static final int BLOCKING_QUEUE_SIZE;
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE;
    public static final String TAG = "thread_sp_db_";

    static {
        int i3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40967);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        MAX_POOL_SIZE = Math.max(5, ThreadSmartPool.maximumPoolSize);
        if (ThreadSetting.isPublicVersion) {
            i3 = 128;
        } else {
            i3 = 64;
        }
        BLOCKING_QUEUE_SIZE = i3;
    }

    ThreadDBPool(BlockingQueue<Runnable> blockingQueue, PriorityThreadFactory priorityThreadFactory) {
        super(5, MAX_POOL_SIZE, 15L, blockingQueue, priorityThreadFactory);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) blockingQueue, (Object) priorityThreadFactory);
        }
    }

    public static ThreadSmartPool createThreadPool() {
        return new ThreadDBPool(new LinkedBlockingQueue(BLOCKING_QUEUE_SIZE), new PriorityThreadFactory(TAG, 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) thread, (Object) runnable);
        } else {
            super.beforeExecute(thread, runnable);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ThreadDBPool";
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected ConcurrentLinkedQueue<String> getRunningJobCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConcurrentLinkedQueue) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Job.runningJmapInDB;
    }
}
