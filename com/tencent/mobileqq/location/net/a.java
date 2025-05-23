package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
abstract class a<T extends BusinessHandler> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj)).booleanValue();
        }
        boolean z16 = false;
        if (QLog.isColorLevel()) {
            QLog.d("BaseProto", 2, "ssoLinkOk: invoked. ", " req: ", toServiceMsg, " res: ", fromServiceMsg, " data: ", obj);
        }
        if (toServiceMsg == null || fromServiceMsg == null || obj == null || !fromServiceMsg.isSuccess()) {
            z16 = true;
        }
        return !z16;
    }
}
