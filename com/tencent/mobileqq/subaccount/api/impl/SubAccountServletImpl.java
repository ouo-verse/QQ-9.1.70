package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.o;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountServletImpl implements ISubAccountServlet {
    static IPatchRedirector $redirector_;

    public SubAccountServletImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountServlet
    public NewIntent fetchOneTroopNewMsg(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NewIntent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        }
        return o.fetchOneTroopNewMsg(appInterface, str);
    }
}
