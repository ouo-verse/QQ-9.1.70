package com.tencent.relation.common.servlet;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f extends d {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.servlet.d
    public void a(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, fromServiceMsg, bArr);
        } else if (MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof AppInterface) {
            ((RelationRequestHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(RelationRequestHandler.f364746h)).D2(intent, fromServiceMsg, bArr);
        }
    }
}
