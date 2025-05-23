package com.tencent.mobileqq.msf.core.net.u.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements com.tencent.mobileqq.msf.core.net.u.b.b, d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249414a = "ReceivedMessageFilter";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final f f249415a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14806);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249415a = new f(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ f(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.d
    public ToServiceMsg a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? toServiceMsg : (ToServiceMsg) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static f a() {
        return b.f249415a;
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.b
    public FromServiceMsg a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FromServiceMsg) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_USE_UDP, Boolean.TRUE);
        return fromServiceMsg;
    }
}
