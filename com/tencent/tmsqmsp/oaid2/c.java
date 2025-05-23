package com.tencent.tmsqmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f380774a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements ThreadFactory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            return new BaseThread(runnable, "oaid2-thread");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f380774a = ProxyExecutors.newSingleThreadExecutor(new a());
        }
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f380774a.execute(runnable);
        }
    }
}
