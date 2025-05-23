package com.tencent.mobileqq.subaccount.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.f;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountAssistantForwardImpl implements ISubAccountAssistantForward {
    static IPatchRedirector $redirector_;

    public SubAccountAssistantForwardImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward
    public void doSomethingAfterSwitchAccount(AppRuntime appRuntime, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) context);
        } else {
            f.f(appRuntime, context);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward
    public void doSomethingAfterSwitchAccountSuccess(AppInterface appInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) context);
        } else {
            f.g(appInterface, context);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward
    public void doSomethingBeforeAddAccount(AppInterface appInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface, (Object) context);
        } else {
            f.h(appInterface, context);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward
    public void forwardTo(AppInterface appInterface, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, context, str);
        } else {
            f.i(appInterface, context, str);
        }
    }
}
