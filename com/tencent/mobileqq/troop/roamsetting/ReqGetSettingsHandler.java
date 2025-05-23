package com.tencent.mobileqq.troop.roamsetting;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ReqGetSettingsHandler extends RoamSettingHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private ToServiceMsg f298290e;

    public ReqGetSettingsHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.a
    public void loadAllRoamSettings(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            ((RoamSettingServiceImpl) this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).loadAllRoamSettings(z16, this);
        }
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.a
    public ToServiceMsg r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f298290e;
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.a
    public void r1(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        FromServiceMsg fromServiceMsg = new FromServiceMsg(this.appRuntime.getAccount(), "ProfileService.ReqGetSettings");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.putWupBuffer(bArr);
        this.appRuntime.receiveToService(this.f298290e, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void send(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RoamSettingHandler", 2, "ReqGetSettingsItem.send...");
        }
        this.f298290e = toServiceMsg;
    }
}
