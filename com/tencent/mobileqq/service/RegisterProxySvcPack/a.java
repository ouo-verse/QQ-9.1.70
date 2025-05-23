package com.tencent.mobileqq.service.RegisterProxySvcPack;

import IPwdPxyMQQ.RespondHeader;
import IPwdPxyMQQ.RespondQueryIPwdStat;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestRegisterAndroid;
import RegisterProxySvcPack.SvcRequestRegisterNew;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.auth.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f286077d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74901);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286077d = new String[]{"RegPrxySvc"};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SvcRespRegister svcRespRegister;
        if ((toServiceMsg.extraData.getLong("requestOptional", 0L) & 16) == 16) {
            svcRespRegister = (SvcRespRegister) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
        } else {
            svcRespRegister = null;
        }
        if (svcRespRegister != null) {
            if (QLog.isColorLevel()) {
                QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyInfoNew resp.strResult =" + svcRespRegister.strResult);
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopMsg null");
        }
        return svcRespRegister;
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        RegisterPushNotice registerPushNotice = (RegisterPushNotice) decodePacket(fromServiceMsg.getWupBuffer(), "RegisterPushNotice", new RegisterPushNotice());
        if (registerPushNotice != null) {
            if (QLog.isColorLevel()) {
                QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq cReplyCode = " + registerPushNotice.ulTimeOutFlag);
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq null");
        }
        return registerPushNotice;
    }

    private Object c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("RegisterProxySvcPackService", 2, "decodeSvcResponseIpwdStat() ");
        }
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        RespondHeader respondHeader = (RespondHeader) decodePacket(wupBuffer, e.f247452l, new RespondHeader());
        RespondQueryIPwdStat respondQueryIPwdStat = (RespondQueryIPwdStat) decodePacket(wupBuffer, "RespondQueryIPwdStat", new RespondQueryIPwdStat());
        if (respondHeader == null || respondHeader.result != 0) {
            return null;
        }
        return respondQueryIPwdStat;
    }

    private boolean d(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("RegPrxySvc");
        SvcRequestRegisterNew svcRequestRegisterNew = new SvcRequestRegisterNew();
        svcRequestRegisterNew.ulRequestOptional |= 32;
        uniPacket.put("req_OffMsg", svcRequestRegisterNew);
        return true;
    }

    private boolean e(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        SvcRequestRegisterAndroid svcRequestRegisterAndroid = new SvcRequestRegisterAndroid();
        svcRequestRegisterAndroid.ulRequestOptional = 1L;
        uniPacket.setServantName("RegisterProxySvcPack");
        uniPacket.setFuncName("OffLineMsg");
        uniPacket.put("req_OffMsg", svcRequestRegisterAndroid);
        return true;
    }

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return false;
        }
        uniPacket.setServantName("RegPrxySvc");
        SvcRequestRegisterNew g16 = g(qQAppInterface, toServiceMsg, uniPacket);
        uniPacket.put("req_OffMsg", g16);
        if (g16.ulRequestOptional == 0) {
            return false;
        }
        return true;
    }

    private SvcRequestRegisterNew g(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong("requestOptional");
        int i3 = toServiceMsg.extraData.getInt("type");
        int i16 = toServiceMsg.extraData.getInt("endSeq");
        boolean z16 = toServiceMsg.extraData.getBoolean("isGetPassword");
        SvcRequestRegisterNew svcRequestRegisterNew = new SvcRequestRegisterNew();
        svcRequestRegisterNew.cDisgroupMsgFilter = (byte) 1;
        svcRequestRegisterNew.ulRequestOptional = j3;
        svcRequestRegisterNew.cSubCmd = (byte) 0;
        svcRequestRegisterNew.ulLastFilterListTime = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getUpdateTime();
        if (i3 == 3) {
            svcRequestRegisterNew.cOptGroupMsgFlag = (byte) 1;
            QLog.d("SvcRequestRegisterNew", 1, "Type = " + i3 + ", req.cOptGroupMsgFlag = " + ((int) svcRequestRegisterNew.cOptGroupMsgFlag));
        }
        if (i3 == 1) {
            svcRequestRegisterNew.cGroupMask = (byte) 2;
        }
        svcRequestRegisterNew.uEndSeq = i16;
        QLog.d("RegisterProxySvcPackService", 1, "requestMsgRegister , type = " + i3 + " isGetPassword = " + z16);
        QLog.d("SvcRequestRegisterNew", 1, "cDisgroupMsgFilter:" + ((int) svcRequestRegisterNew.cDisgroupMsgFilter) + ",NoticeEndSeq:" + i16 + " , ulRequestOptional : " + svcRequestRegisterNew.ulRequestOptional);
        return svcRequestRegisterNew;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f286077d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if ("RegPrxySvc.infoAndroid".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return null;
        }
        if (BaseConstants.CMD_REGPRXYSVC_INFOLOGIN.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return a(toServiceMsg, fromServiceMsg);
        }
        if (BaseConstants.CMD_REGPRXYSVC_NOTICE_END.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return b(toServiceMsg, fromServiceMsg);
        }
        if (!"RegPrxySvc.QueryIpwdStat".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return null;
        }
        return c(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoAndroid")) {
            return e(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(BaseConstants.CMD_REGPRXYSVC_INFOLOGIN)) {
            return f(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.getExtinfo")) {
            return d(toServiceMsg, uniPacket);
        }
        return false;
    }
}
