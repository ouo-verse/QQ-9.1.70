package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager;
import cooperation.vip.tianshu.TianShuManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TianshuLifeCircleManagerImpl implements ITianShuLifeCircleManager {
    static IPatchRedirector $redirector_;

    public TianshuLifeCircleManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager
    public void onAccountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            TianShuManager.getInstance().clearNecessaryDataCacheForReport();
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager
    public void onEnterBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager
    public void onEnterForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager
    public void onLogout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            TianShuManager.getInstance().clearNecessaryDataCacheForReport();
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager
    public void onNetworkStateChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }
}
