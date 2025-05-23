package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class IQQLiveBaseModule implements IQQLiveModule {
    static IPatchRedirector $redirector_;
    protected IQQLiveSDK sdkImpl;

    public IQQLiveBaseModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdkImpl = iQQLiveSDK;
        }
    }
}
