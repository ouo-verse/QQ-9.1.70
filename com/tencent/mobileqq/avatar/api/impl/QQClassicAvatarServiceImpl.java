package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.api.IQQClassicAvatarService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQClassicAvatarServiceImpl implements IQQClassicAvatarService {
    static IPatchRedirector $redirector_;
    protected AppRuntime mApp;

    public QQClassicAvatarServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQClassicAvatarService
    public void handleGetHeadError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            ((com.tencent.mobileqq.app.utils.b) this.mApp.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER)).d(str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQClassicAvatarService
    public boolean isClassicHeadActivityActivate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((com.tencent.mobileqq.app.utils.b) this.mApp.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER)).h();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
