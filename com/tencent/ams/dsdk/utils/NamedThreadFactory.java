package com.tencent.ams.dsdk.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NamedThreadFactory implements ThreadFactory {
    static IPatchRedirector $redirector_;
    private static final AtomicInteger poolNumber;
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            poolNumber = new AtomicInteger(1);
        }
    }

    public NamedThreadFactory(String str) {
        ThreadGroup threadGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
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
        this.namePrefix = (TextUtils.isEmpty(str) ? "DynamicSDKThreadPool" : str) + "-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        BaseThread baseThread = new BaseThread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 5) {
            baseThread.setPriority(5);
        }
        return baseThread;
    }
}
