package com.tencent.mobileqq.app;

import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ThreadAsyncTaskPool extends ThreadSmartPool {
    static IPatchRedirector $redirector_ = null;
    private static final int BLOCKING_QUEUE_SIZE = 128;
    private static final int CORE_POOL_SIZE;
    private static final int MAX_POOL_SIZE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_INVALID_JSON);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        int i3 = ThreadSmartPool.CPU_COUNT;
        CORE_POOL_SIZE = Math.max(2, Math.min(i3 - 1, 4));
        MAX_POOL_SIZE = (i3 * 2) + 1;
    }

    ThreadAsyncTaskPool(BlockingQueue<Runnable> blockingQueue, PriorityThreadFactory priorityThreadFactory) {
        super(CORE_POOL_SIZE, MAX_POOL_SIZE, 15L, blockingQueue, priorityThreadFactory);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) blockingQueue, (Object) priorityThreadFactory);
        }
    }

    public static ThreadSmartPool createThreadPool() {
        return new ThreadAsyncTaskPool(new LinkedBlockingDeque(128), new PriorityThreadFactory("thread_sp_Async_", 5));
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ThreadAsyncTaskPool";
    }

    @Override // com.tencent.mobileqq.app.ThreadSmartPool
    protected ConcurrentLinkedQueue<String> getRunningJobCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConcurrentLinkedQueue) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Job.runningJmapInAync;
    }
}
