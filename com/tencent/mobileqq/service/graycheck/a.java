package com.tencent.mobileqq.service.graycheck;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import protocol.GrayVersion.ApplyReq;
import protocol.GrayVersion.ApplyResp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f286136d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74932);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286136d = new String[]{"VCService", "GrayUinPro"};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ApplyReq applyReq = new ApplyReq();
        applyReq.uin = toServiceMsg.extraData.getLong("uin");
        applyReq.appid = toServiceMsg.extraData.getLong("appid");
        uniPacket.setServantName("VCService");
        uniPacket.setFuncName("Apply");
        uniPacket.put("req", applyReq);
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f286136d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (BaseConstants.CMD_GRAY_APPLY.equals(fromServiceMsg.getServiceCmd())) {
            return decodePacket(fromServiceMsg.getWupBuffer(), "res", new ApplyResp());
        }
        return super.decode(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_GRAY_APPLY)) {
            return a(toServiceMsg, uniPacket);
        }
        return false;
    }
}
