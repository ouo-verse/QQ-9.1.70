package com.tencent.mobileqq.msf.core.net.s;

import com.tencent.mobileqq.msf.core.net.s.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249050a = "NetworkToolsHelper";

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f249051b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f249051b = new AtomicBoolean(false);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static f.a a(String str) {
        if (f249051b.compareAndSet(false, true)) {
            f.a c16 = new f(str, true).c();
            f249051b.set(false);
            return c16;
        }
        QLog.d(f249050a, 1, "Stop traceroute host: " + str + " by another task running");
        return null;
    }
}
