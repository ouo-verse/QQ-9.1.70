package com.tencent.mobileqq.troop.honor.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler;
import com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHonorHandlerImpl implements ITroopHonorHandler {
    static IPatchRedirector $redirector_;
    private AppRuntime mApp;
    private TroopHonorHandler troopHonorHandler;

    public TroopHonorHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private TroopHonorHandler getTroopHonorHandler() {
        AppInterface appInterface = (AppInterface) this.mApp;
        if (appInterface != null) {
            TroopHonorHandler troopHonorHandler = (TroopHonorHandler) appInterface.getBusinessHandler(TroopHonorHandler.class.getName());
            this.troopHonorHandler = troopHonorHandler;
            return troopHonorHandler;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler
    public void getHostTroopHonorList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.troopHonorHandler.F2(z16);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            this.troopHonorHandler = getTroopHonorHandler();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler
    public void getHostTroopHonorList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            getHostTroopHonorList(false);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
