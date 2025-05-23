package com.tencent.mobileqq.msf.core.net.u.b;

import com.tencent.mobileqq.msf.core.n;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e implements b, d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f249410b = "MessageTimeoutFilter";

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f249411c;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.quicksend.b f249412a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements n.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.n.d
        public void a(ToServiceMsg toServiceMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
            } else {
                e.this.f249412a.g(toServiceMsg);
                QLog.d(e.f249410b, 1, "[onTimeout] ", com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
            }
        }
    }

    e(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f249412a = bVar;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.b
    public FromServiceMsg a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FromServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (fromServiceMsg == null) {
            return null;
        }
        Runnable runnable = (Runnable) toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER);
        if (runnable != null && this.f249412a.b() != null && this.f249412a.b().p() != null) {
            this.f249412a.b().p().a().removeCallbacks(runnable);
        }
        QLog.d(f249410b, 1, "[filter] remove callback ssoSeq: ", com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
        return fromServiceMsg;
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.d
    public ToServiceMsg a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg == null) {
            return null;
        }
        long timeout = toServiceMsg.getTimeout();
        if (timeout != -1 && ((Runnable) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER)) == null && this.f249412a.b() != null && this.f249412a.b().r() != null && this.f249412a.b().p() != null) {
            toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER, this.f249412a.b().p().a(toServiceMsg, timeout, new a(), this.f249412a.b().r().a(toServiceMsg.getServiceCmd())));
            QLog.d(f249410b, 1, "[filter] setTimeout ", Long.valueOf(timeout), com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
        }
        return toServiceMsg;
    }

    public static e a(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        if (f249411c == null) {
            synchronized (e.class) {
                if (f249411c == null) {
                    f249411c = new e(bVar);
                }
            }
        }
        return f249411c;
    }
}
