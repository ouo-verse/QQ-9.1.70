package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.ILocalManagerApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LocalManagerApiImpl implements ILocalManagerApi {
    static IPatchRedirector $redirector_;

    public LocalManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ILocalManagerApi
    public boolean isLocaleCN() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return LocaleManager.isLocaleCN();
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ILocalManagerApi
    public boolean isLocaleUpdatedByUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return LocaleManager.isLocaleUpdatedByUser();
    }
}
