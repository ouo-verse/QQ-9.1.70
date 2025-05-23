package com.tencent.mobileqq.msf.core.net.u.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249409a = "FromServiceMsgParamFill";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
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
        if (toServiceMsg != null) {
            int requestSsoSeq = toServiceMsg.getRequestSsoSeq();
            fromServiceMsg.setRequestSsoSeq(requestSsoSeq);
            if (QLog.isColorLevel()) {
                QLog.d(f249409a, 2, "[filter] set from message ssoSeq: ", Integer.valueOf(requestSsoSeq));
            }
        }
        return fromServiceMsg;
    }
}
