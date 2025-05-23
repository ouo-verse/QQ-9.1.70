package com.tencent.mobileqq.qqgift.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgift.api.IQQGiftDataStore;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftDataStoreImpl implements IQQGiftDataStore {
    static IPatchRedirector $redirector_;
    private String sceneId;

    public QQGiftDataStoreImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftDataStore
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.sceneId = null;
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftDataStore
    public String getSceneId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sceneId;
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftDataStore
    public void setSceneId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.sceneId = str;
        }
    }
}
