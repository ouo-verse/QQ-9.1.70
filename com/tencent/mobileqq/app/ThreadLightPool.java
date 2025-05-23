package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ThreadLightPool extends ThreadSmartPool {
    static IPatchRedirector $redirector_ = null;
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 128;

    ThreadLightPool(BlockingQueue<Runnable> blockingQueue, PriorityThreadFactory priorityThreadFactory) {
        super(2, 128, 15L, blockingQueue, priorityThreadFactory);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) blockingQueue, (Object) priorityThreadFactory);
        }
    }

    public static ThreadSmartPool createThreadPool() {
        return new ThreadLightPool(new SynchronousQueue(true), new PriorityThreadFactory("thread_light_", 2));
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
        return "ThreadLightPool";
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected ConcurrentLinkedQueue<String> getRunningJobCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConcurrentLinkedQueue) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Job.runningJmapInLight;
    }
}
