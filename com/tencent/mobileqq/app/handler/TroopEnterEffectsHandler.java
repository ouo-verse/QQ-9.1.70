package com.tencent.mobileqq.app.handler;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.e;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.qun.group_effect.group_effect_commu$RspBody;
import tencent.qun.group_effect.group_effect_commu$TEntryNotifyRsp0x2000;
import tencent.qun.group_effect.group_effect_commu$TGetMyEffectRsp0x2;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TroopEnterEffectsHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f195673d;

    public TroopEnterEffectsHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f195673d = appInterface;
        }
    }

    private void E2(long j3) {
        if (j3 == 2) {
            notifyUI(26, false, null);
        }
    }

    public void D2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, fromServiceMsg, bArr);
            return;
        }
        if (this.f195673d == null) {
            return;
        }
        if (bArr != null && fromServiceMsg.isSuccess()) {
            group_effect_commu$RspBody group_effect_commu_rspbody = new group_effect_commu$RspBody();
            try {
                group_effect_commu_rspbody.mergeFrom(bArr);
                long longExtra = intent.getLongExtra("usrdata", 0L);
                if (group_effect_commu_rspbody.ret.get() == 0) {
                    ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) this.f195673d.getRuntimeService(ITroopEnterEffectService.class, "all");
                    if (longExtra == 8192) {
                        group_effect_commu$TEntryNotifyRsp0x2000 group_effect_commu_tentrynotifyrsp0x2000 = group_effect_commu_rspbody.st_entry_notify.get();
                        if (group_effect_commu_tentrynotifyrsp0x2000 != null) {
                            group_effect_commu_tentrynotifyrsp0x2000.st_userconfig.get();
                            iTroopEnterEffectService.setNotifyInterval(group_effect_commu_tentrynotifyrsp0x2000.notify_interval.get() * 1000);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(ITroopEnterEffectService.TAG, 2, "handleTroopEnterEffectCMD ENTER_GROUP success notifyInteval = " + iTroopEnterEffectService.getNotifyInterval());
                        }
                    } else if (longExtra == 2) {
                        group_effect_commu$TGetMyEffectRsp0x2 group_effect_commu_tgetmyeffectrsp0x2 = group_effect_commu_rspbody.st_get_effect.get();
                        if (group_effect_commu_tgetmyeffectrsp0x2 != null) {
                            if (group_effect_commu_tgetmyeffectrsp0x2.ret.get() != 0) {
                                QLog.e(ITroopEnterEffectService.TAG, 1, "handleTroopEnterEffectCMD getMyEffect fail");
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d(ITroopEnterEffectService.TAG, 2, "handleTroopEnterEffectCMD getMyEffect success");
                                }
                                e.b bVar = new e.b();
                                bVar.a(group_effect_commu_tgetmyeffectrsp0x2);
                                iTroopEnterEffectService.updateEffectInfo(bVar);
                                iTroopEnterEffectService.saveEffectConfigData(group_effect_commu_tgetmyeffectrsp0x2);
                                VipMMKV.getEnterEffectConfig().encodeLong(this.f195673d.getCurrentAccountUin(), System.currentTimeMillis());
                                notifyUI(26, true, null);
                            }
                        } else {
                            QLog.e(ITroopEnterEffectService.TAG, 1, "handleTroopEnterEffectCMD getMyEffect rsp is null");
                            E2(2L);
                        }
                    }
                } else {
                    QLog.e(ITroopEnterEffectService.TAG, 1, "handleTroopEnterEffectCMD error cmd = " + longExtra + " ret = " + group_effect_commu_rspbody.ret.get());
                }
                E2(2L);
                return;
            } catch (Exception e16) {
                QLog.e(ITroopEnterEffectService.TAG, 1, "handleTroopEnterEffectCMD error: " + e16.getMessage());
                E2(2L);
                return;
            }
        }
        QLog.e(ITroopEnterEffectService.TAG, 1, "handleTroopEnterEffectCMD fail data = " + bArr + " errorcode = " + fromServiceMsg.getResultCode() + " ssoSeq = " + fromServiceMsg.getRequestSsoSeq());
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return hs2.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
