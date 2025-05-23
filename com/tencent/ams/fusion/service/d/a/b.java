package com.tencent.ams.fusion.service.d.a;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f70263h;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadGroup f70264d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f70265e;

    /* renamed from: f, reason: collision with root package name */
    private final String f70266f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f70263h = new AtomicInteger(1);
        }
    }

    public b(String str) {
        ThreadGroup threadGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f70265e = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f70264d = threadGroup;
        this.f70266f = (TextUtils.isEmpty(str) ? "FusionAdPool" : str) + "-" + f70263h.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        BaseThread baseThread = new BaseThread(this.f70264d, runnable, this.f70266f + this.f70265e.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 5) {
            baseThread.setPriority(5);
        }
        return baseThread;
    }
}
