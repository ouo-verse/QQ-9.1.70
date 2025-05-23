package com.tencent.mobileqq.app.handler.impl;

import com.tencent.common.app.e;
import com.tencent.mobileqq.app.handler.IRegisterProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class RegisterProxyServiceImpl implements IRegisterProxyService {
    static IPatchRedirector $redirector_;

    public RegisterProxyServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.handler.IRegisterProxyService
    public void onNewRegisterProxyRestPacketEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            e.a();
        }
    }
}
