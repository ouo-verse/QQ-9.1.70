package com.tencent.mobileqq.qqlive.api.verified.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveDataStoreImpl implements IQQLiveDataStore {
    static IPatchRedirector $redirector_;
    private String appId;

    public QQLiveDataStoreImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.appId = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore
    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appId;
    }

    @Override // com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore
    public void setAppId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.appId = str;
        }
    }
}
