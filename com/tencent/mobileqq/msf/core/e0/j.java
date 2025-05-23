package com.tencent.mobileqq.msf.core.e0;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j implements d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f248015b = "SubSenderSwitchCallback";

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.a f248016a;

    public j(com.tencent.mobileqq.msf.core.f0.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f248016a = aVar;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.d
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else if (fromServiceMsg != null && (this.f248016a instanceof com.tencent.mobileqq.msf.core.f0.d.a) && fromServiceMsg.getResultCode() == -10114) {
            ((com.tencent.mobileqq.msf.core.f0.d.a) this.f248016a).a(false);
            QLog.d(f248015b, 1, "[onMessageReceive] CODE_NEW_CONN_FAILD(-10114) close subSender.");
        }
    }
}
