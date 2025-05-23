package com.tencent.upload.utils.pool;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes27.dex */
public class PriorityThreadFactory implements ThreadFactory {
    static IPatchRedirector $redirector_;
    private final String mName;
    private final AtomicInteger mNumber;
    private final int mPriority;

    public PriorityThreadFactory(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.mNumber = new AtomicInteger();
        this.mName = str;
        this.mPriority = i3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        return new BaseThread(runnable, this.mName + '-' + this.mNumber.getAndIncrement()) { // from class: com.tencent.upload.utils.pool.PriorityThreadFactory.1
            static IPatchRedirector $redirector_;

            {
                super(runnable, r9);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PriorityThreadFactory.this, runnable, r9);
                }
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
                    super.run();
                }
            }
        };
    }
}
