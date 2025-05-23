package com.tencent.qimei.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f343203a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343203a = new AtomicInteger(0);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Thread) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        }
        try {
            return new BaseThread(runnable, "oaid_thread_" + f343203a.getAndIncrement());
        } catch (Exception e16) {
            str = e16.toString();
            com.tencent.qimei.ad.b.a(str);
            return null;
        } catch (OutOfMemoryError unused) {
            str = "[task] memory not enough, create thread failed.";
            com.tencent.qimei.ad.b.a(str);
            return null;
        }
    }
}
