package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ThreadNormalPool extends ThreadSmartPool {
    static IPatchRedirector $redirector_ = null;
    private static final int BLOCKING_QUEUE_SIZE;
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE;
    public static final String TAG = "thread_sp_normal_";

    static {
        int i3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41101);
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ThreadNormalPool(BlockingQueue<Runnable> blockingQueue, PriorityThreadFactory priorityThreadFactory) {
        super(5, r7, 15L, blockingQueue, priorityThreadFactory);
        int i3 = MAX_POOL_SIZE;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) blockingQueue, (Object) priorityThreadFactory);
            return;
        }
        com.tencent.mobileqq.app.monitor.f b16 = com.tencent.mobileqq.app.monitor.f.b(getName(), 5, i3, BLOCKING_QUEUE_SIZE);
        this.threadPoolMonitor = b16;
        priorityThreadFactory.setMonitor(b16);
    }

    public static ThreadSmartPool createThreadPool() {
        return new ThreadNormalPool(new LinkedBlockingDeque(BLOCKING_QUEUE_SIZE), new PriorityThreadFactory(TAG, 5));
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool, com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
            return;
        }
        com.tencent.mobileqq.app.monitor.f fVar = this.threadPoolMonitor;
        if (fVar != null) {
            fVar.c(this);
        }
        super.execute(runnable);
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ThreadNormalPool";
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected ConcurrentLinkedQueue<String> getRunningJobCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConcurrentLinkedQueue) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Job.runningJmapInNormal;
    }
}
