package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ap extends f {
    static IPatchRedirector $redirector_;

    public ap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public boolean b(AppRuntime appRuntime, Class<?> cls, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, cls, Long.valueOf(j3))).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            ((SimpleUIHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).Y2();
        }
        return true;
    }
}
