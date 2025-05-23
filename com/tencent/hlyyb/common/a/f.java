package com.tencent.hlyyb.common.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f114338h;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadGroup f114339d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f114340e;

    /* renamed from: f, reason: collision with root package name */
    public final String f114341f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f114338h = new AtomicInteger(1);
        }
    }

    public f(String str) {
        ThreadGroup threadGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f114340e = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f114339d = threadGroup;
        this.f114341f = str + "-" + f114338h.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Thread) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        }
        BaseThread baseThread = new BaseThread(this.f114339d, runnable, this.f114341f + this.f114340e.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        try {
            baseThread.setPriority(5);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return baseThread;
    }
}
