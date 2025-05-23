package com.tencent.mobileqq.mqq.api.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.adapter.aj;
import com.tencent.mobileqq.adapter.s;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ThreadManagerApiImpl implements IThreadManagerApi<MqqHandler> {
    static IPatchRedirector $redirector_;

    public ThreadManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ThreadPoolParams createThreadPoolParams(aj ajVar) {
        return new ThreadPoolParams();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public void execute(Runnable runnable, int i3, s sVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, runnable, Integer.valueOf(i3), sVar, Boolean.valueOf(z16));
        } else {
            ThreadManagerV2.excute(runnable, i3, ThreadListenerAdapter.from(sVar), z16);
        }
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public void executeOnFileThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else {
            ThreadManagerV2.executeOnFileThread(runnable);
        }
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public void executeOnSubThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            ThreadManagerV2.executeOnSubThread(runnable);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) runnable);
        }
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Thread getFileThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Thread) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ThreadManagerV2.getFileThread();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Looper getFileThreadLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Looper) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return ThreadManagerV2.getFileThreadLooper();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Thread getRecentThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Thread) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return ThreadManagerV2.getRecentThread();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Looper getRecentThreadLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Looper) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return ThreadManagerV2.getRecentThreadLooper();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Thread getSubThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Thread) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return ThreadManagerV2.getSubThread();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Looper getSubThreadLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Looper) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return ThreadManagerV2.getSubThreadLooper();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Handler getUIHandlerV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Handler) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return ThreadManagerV2.getUIHandlerV2();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public HandlerThread newFreeHandlerThread(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        return ThreadManagerV2.newFreeHandlerThread(str, i3);
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Thread newFreeThread(Runnable runnable, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Thread) iPatchRedirector.redirect((short) 3, this, runnable, str, Integer.valueOf(i3));
        }
        return ThreadManagerV2.newFreeThread(runnable, str, i3);
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public Executor newFreeThreadPool(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Executor) iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
        }
        return ThreadManagerV2.newFreeThreadPool(createThreadPoolParams(ajVar));
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public boolean removeJobFromThreadPool(Runnable runnable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable, i3)).booleanValue();
        }
        return ThreadManagerV2.removeJobFromThreadPool(runnable, i3);
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public String reportCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ThreadManagerV2.reportCurrentState();
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public void executeOnSubThread(Runnable runnable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            ThreadManagerV2.executeOnSubThread(runnable, z16);
        } else {
            iPatchRedirector.redirect((short) 19, this, runnable, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public MqqHandler getFileThreadHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? ThreadManager.getFileThreadHandler() : (MqqHandler) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public MqqHandler getSubThreadHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? ThreadManager.getSubThreadHandler() : (MqqHandler) iPatchRedirector.redirect((short) 15, (Object) this);
    }

    @Override // com.tencent.mobileqq.mqq.api.IThreadManagerApi
    public MqqHandler getUIHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? ThreadManager.getUIHandler() : (MqqHandler) iPatchRedirector.redirect((short) 20, (Object) this);
    }
}
