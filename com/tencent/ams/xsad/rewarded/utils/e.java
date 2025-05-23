package com.tencent.ams.xsad.rewarded.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f71860h;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadGroup f71861d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f71862e;

    /* renamed from: f, reason: collision with root package name */
    private final String f71863f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14881);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f71860h = new AtomicInteger(1);
        }
    }

    public e(String str) {
        ThreadGroup threadGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f71862e = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f71861d = threadGroup;
        this.f71863f = (TextUtils.isEmpty(str) ? "RewardedAdPool" : str) + "-" + f71860h.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        BaseThread baseThread = new BaseThread(this.f71861d, runnable, this.f71863f + this.f71862e.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 5) {
            baseThread.setPriority(5);
        }
        return baseThread;
    }
}
