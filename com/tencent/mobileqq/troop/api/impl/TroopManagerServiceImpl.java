package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManagerServiceImpl implements ITroopManagerService {
    static IPatchRedirector $redirector_;
    private AppRuntime mAppRuntime;

    public TroopManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopManagerService
    public byte[] getTroopAppListData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return ((com.tencent.mobileqq.model.d) this.mAppRuntime.getManager(QQManagerFactory.TROOPINFO_MANAGER)).d(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopManagerService
    public void getTroopsMemberList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime instanceof QQAppInterface) {
            ((ITroopMemberInfoService) appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopsMemberList();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopManagerService
    public void handleTroopMemberNewLevelChange(String str, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, bArr, Integer.valueOf(i3));
        } else {
            ((TroopManager) this.mAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).N(str, bArr, i3);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopManagerService
    public void setTroopAppListData(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bArr);
        } else {
            ((ITroopAppService) this.mAppRuntime.getRuntimeService(ITroopAppService.class, "all")).setTroopAppListData(str, bArr);
            ((com.tencent.mobileqq.model.d) this.mAppRuntime.getManager(QQManagerFactory.TROOPINFO_MANAGER)).g(str, bArr);
        }
    }
}
