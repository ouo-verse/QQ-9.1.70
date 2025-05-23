package com.tencent.tuxmetersdk.impl;

import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxThread;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxThreadImpl implements ITuxThread {
    static IPatchRedirector $redirector_;
    private static final int CPU_CORE_SIZE;
    private static final int WORK_THREAD_POOL_SIZE;
    private final ITuxHandlerThread handlerThread;
    private final ExecutorService workExecutor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_CORE_SIZE = availableProcessors;
        WORK_THREAD_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TuxThreadImpl(ExecutorService executorService, ITuxHandlerThread iTuxHandlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) executorService, (Object) iTuxHandlerThread);
            return;
        }
        if (executorService == null) {
            this.workExecutor = ProxyExecutors.newFixedThreadPool(WORK_THREAD_POOL_SIZE);
        } else {
            this.workExecutor = executorService;
        }
        this.handlerThread = iTuxHandlerThread;
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxThread
    public void execWorkTask(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            this.workExecutor.execute(runnable);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getDeliveryLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Looper) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.handlerThread.getDeliveryLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getSDKDataReadyLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Looper) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.handlerThread.getSDKDataReadyLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getSurveyEventLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Looper) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.handlerThread.getSurveyEventLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getTriggerLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Looper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.handlerThread.getTriggerLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxThread
    public ExecutorService getWorkExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ExecutorService) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.workExecutor;
    }

    TuxThreadImpl(ITuxHandlerThread iTuxHandlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTuxHandlerThread);
        } else {
            this.workExecutor = ProxyExecutors.newFixedThreadPool(WORK_THREAD_POOL_SIZE);
            this.handlerThread = iTuxHandlerThread;
        }
    }
}
