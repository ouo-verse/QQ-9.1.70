package com.tencent.mobileqq.enterpriseqq.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.enterpriseqq.api.IEnterpriseQQService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EnterpriseQQServiceImpl implements IEnterpriseQQService {
    static IPatchRedirector $redirector_;
    private EnterpriseQQManager eQQManager;
    private QQAppInterface mApp;

    public EnterpriseQQServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.eQQManager = null;
        }
    }

    @Override // com.tencent.mobileqq.enterpriseqq.api.IEnterpriseQQService
    public void getMenuFromNet(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            this.eQQManager.k(this.mApp, str, z16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        this.mApp = qQAppInterface;
        this.eQQManager = EnterpriseQQManager.j(qQAppInterface);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
