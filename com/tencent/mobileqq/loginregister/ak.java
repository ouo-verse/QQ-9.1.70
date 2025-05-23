package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ak implements u {
    static IPatchRedirector $redirector_;

    public ak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.u
    public void a(GatewayVerify$ReqBody gatewayVerify$ReqBody, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gatewayVerify$ReqBody, (Object) str);
        } else if (gatewayVerify$ReqBody != null && str != null) {
            com.tencent.open.agent.util.g.T(gatewayVerify$ReqBody, str);
        }
    }
}
