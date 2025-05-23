package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopEnterEffectApi;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.qun.group_effect.group_effect_commu$ReqBody;
import tencent.qun.group_effect.group_effect_commu$TEntryNotifyReq0x2000;
import tencent.qun.group_effect.group_effect_commu$TGetMyEffectReq0x2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopEnterEffectApiImpl implements ITroopEnterEffectApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TROOP_ENTER_EFFECT_CMD = "Groupeffect.commop";

    public TroopEnterEffectApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private NewIntent createRequestIntent(String str, BaseApplication baseApplication, byte[] bArr) {
        NewIntent newIntent = new NewIntent(baseApplication, com.tencent.mobileqq.app.servlet.a.class);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        return newIntent;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopEnterEffectApi
    public void sendGetBaseVipInfoReq(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, str2);
        } else if (appRuntime instanceof QQAppInterface) {
            ((VipInfoHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopEnterEffectApi
    public void sendTroopEnterEffectCMD(AppRuntime appRuntime, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (appRuntime instanceof QQAppInterface) {
            group_effect_commu$ReqBody group_effect_commu_reqbody = new group_effect_commu$ReqBody();
            group_effect_commu_reqbody.u64_cmd.set(j3);
            group_effect_commu_reqbody.u64_uin.set(Long.parseLong(appRuntime.getCurrentAccountUin()));
            group_effect_commu_reqbody.i32_implat.set(109);
            group_effect_commu_reqbody.str_version.set(ah.P());
            if (j3 == 8192) {
                if (QLog.isColorLevel()) {
                    QLog.d(ITroopEnterEffectService.TAG, 2, "sendTroopEnterEffectCMD ENTER_GROUP troopId = " + j16);
                }
                group_effect_commu$TEntryNotifyReq0x2000 group_effect_commu_tentrynotifyreq0x2000 = new group_effect_commu$TEntryNotifyReq0x2000();
                group_effect_commu_tentrynotifyreq0x2000.group_id.set(j16);
                group_effect_commu_reqbody.st_entry_notify.set(group_effect_commu_tentrynotifyreq0x2000);
            } else if (j3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d(ITroopEnterEffectService.TAG, 2, "sendTroopEnterEffectCMD GET_MY_EFFECT troopId = " + j16);
                }
                group_effect_commu_reqbody.st_get_effect.set(new group_effect_commu$TGetMyEffectReq0x2());
            }
            NewIntent createRequestIntent = createRequestIntent(TROOP_ENTER_EFFECT_CMD, appRuntime.getApp(), group_effect_commu_reqbody.toByteArray());
            createRequestIntent.putExtra("usrdata", j3);
            appRuntime.startServlet(createRequestIntent);
        }
    }
}
