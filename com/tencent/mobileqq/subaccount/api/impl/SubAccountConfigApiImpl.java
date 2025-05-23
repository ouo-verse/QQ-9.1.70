package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountConfigApiImpl implements ISubAccountConfigApi {
    static IPatchRedirector $redirector_;

    public SubAccountConfigApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi
    public boolean getIsHideSubAccountTroopMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
