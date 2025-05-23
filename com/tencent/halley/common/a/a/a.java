package com.tencent.halley.common.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f113200a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadGroup f113201b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f113202c;

    /* renamed from: d, reason: collision with root package name */
    private final String f113203d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f113200a = new AtomicInteger(1);
        }
    }

    public a(String str) {
        ThreadGroup threadGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f113202c = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f113201b = threadGroup;
        this.f113203d = str + "_" + f113200a.getAndIncrement() + "_thread_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        BaseThread baseThread = new BaseThread(this.f113201b, runnable, this.f113203d + this.f113202c.getAndIncrement(), 0L);
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
