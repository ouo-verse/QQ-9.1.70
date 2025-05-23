package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AssociatedAccountApiImpl implements IAssociatedAccountApi {
    static IPatchRedirector $redirector_;

    public AssociatedAccountApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi
    public Class<?> getAssociatedAccountActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AssociatedAccountActivity.class;
    }

    @Override // com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi
    public Class<?> getSubAccountParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.scheme.d.class;
    }
}
