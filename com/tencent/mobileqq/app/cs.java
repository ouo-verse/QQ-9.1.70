package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cs implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f195466d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.troop.roamsetting.a f195467e;

    public cs(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195466d = qQAppInterface;
            this.f195467e = ((IRoamSettingService) qQAppInterface.getRuntimeService(IRoamSettingService.class, "")).getReqGetSettingsHandler();
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        BaseProtocolCoder lookupCoder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (this.f195466d.mAutomator.f195306e == 2) {
            this.f195467e.loadAllRoamSettings(true);
        }
        if (this.f195467e.r() != null && (lookupCoder = this.f195466d.mqqService.lookupCoder(this.f195467e.r().getServiceCmd())) != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            if (lookupCoder.encodeReqMsg(this.f195467e.r(), uniPacket)) {
                ReqItem reqItem = new ReqItem();
                reqItem.eServiceID = 115;
                reqItem.vecParam = uniPacket.encode();
                return reqItem;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
        } else if (respItem.eServiceID == 115 && respItem.cResult == 2) {
            this.f195467e.r1(respItem.vecUpdate);
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }
}
