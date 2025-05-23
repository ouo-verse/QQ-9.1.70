package com.tencent.mobileqq.troopmanage.api.impl;

import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler;
import com.tencent.mobileqq.troopmanage.base.TroopManagerHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManageServiceImpl implements ITroopManageService {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "TroopManageServiceImpl";
    private QQAppInterface appInterface;
    private EntityManagerFactory emFactoryQQ;
    private TroopManageRemoteHandler mTroopManageRemoteHandler;

    public TroopManageServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean isValidName(String str) {
        if (str != null && !str.equals("")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troopmanage.api.ITroopManageService
    public EntityManagerFactory getQQEntityManagerFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String account = this.appInterface.getAccount();
        if (account != null) {
            synchronized (this) {
                if (this.emFactoryQQ == null) {
                    l c16 = l.c(account);
                    c16.verifyAuthentication();
                    this.emFactoryQQ = c16;
                }
            }
            return this.emFactoryQQ;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    @Override // com.tencent.mobileqq.troopmanage.api.ITroopManageService
    @NonNull
    public TroopInfo getTroopInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        TroopInfo troopInfo = ((ITroopInfoService) this.appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, StringUtil.makeLogMsg("getTroopInfo()", str, Long.valueOf(troopInfo.dwGroupFlagExt)));
        }
        return troopInfo;
    }

    @Override // com.tencent.mobileqq.troopmanage.api.ITroopManageService
    @NonNull
    public TroopManagerHandler getTroopManageHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopManagerHandler) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (TroopManagerHandler) this.appInterface.getBusinessHandler(TroopManagerHandler.class.getName());
    }

    @Override // com.tencent.mobileqq.troopmanage.api.ITroopManageService
    public synchronized TroopManageRemoteHandler getTroopManageRemoteHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopManageRemoteHandler) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mTroopManageRemoteHandler == null) {
            this.mTroopManageRemoteHandler = new TroopManageRemoteHandler(BaseApplicationImpl.getApplication(), this.appInterface);
        }
        return this.mTroopManageRemoteHandler;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.appInterface = (QQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TroopManageRemoteHandler troopManageRemoteHandler = this.mTroopManageRemoteHandler;
        if (troopManageRemoteHandler != null) {
            troopManageRemoteHandler.h();
            this.mTroopManageRemoteHandler = null;
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.api.ITroopManageService
    public void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
        } else {
            ReportController.r(this.appInterface, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        }
    }
}
