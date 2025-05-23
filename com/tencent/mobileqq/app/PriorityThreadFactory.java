package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class PriorityThreadFactory implements ThreadFactory {
    static IPatchRedirector $redirector_;
    public String mName;
    public int mPriority;
    private com.tencent.mobileqq.app.monitor.f monitor;
    public volatile int threadIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PriorityThreadFactory(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.threadIndex = 0;
        this.mPriority = i3;
        this.mName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Thread) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        }
        this.threadIndex++;
        if (this.threadIndex > 10000) {
            this.threadIndex = 0;
        }
        BaseThread baseThread = new BaseThread(runnable, this.mName + this.threadIndex);
        com.tencent.mobileqq.app.monitor.f fVar = this.monitor;
        if (fVar != null) {
            fVar.l(baseThread);
        }
        return baseThread;
    }

    public void setMonitor(com.tencent.mobileqq.app.monitor.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        } else {
            this.monitor = fVar;
        }
    }
}
