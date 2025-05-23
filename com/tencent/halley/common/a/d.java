package com.tencent.halley.common.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f113263b;

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f113264a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10129);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f113263b = null;
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113264a = (ThreadPoolExecutor) ProxyExecutors.newCachedThreadPool(new com.tencent.halley.common.a.a.a(i.b("BusinessTaskPool")));
        }
    }

    public static d a() {
        if (f113263b == null) {
            synchronized (d.class) {
                if (f113263b == null) {
                    f113263b = new d();
                }
            }
        }
        return f113263b;
    }
}
