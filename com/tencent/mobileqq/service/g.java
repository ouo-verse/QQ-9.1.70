package com.tencent.mobileqq.service;

import VIP.AIOKeyWordReq;
import VIP.AIOSendReq;
import VIP.AIOSendRes;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new String[]{"AIOSendSvc"};
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if ((!VIPAioSendHandler.f195181f.equals(toServiceMsg.getServiceCmd()) && !VIPAioSendHandler.f195182h.equals(toServiceMsg.getServiceCmd())) || fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (AIOSendRes) uniPacket.getByClass("response", new AIOSendRes());
        } catch (RuntimeException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        uniPacket.setServantName("VIP.AIOSendTipsServer.AIOSendTipsObj");
        if (VIPAioSendHandler.f195181f.equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setFuncName("CheckPopGrayStips");
            uniPacket.put(Const.BUNDLE_KEY_REQUEST, (AIOSendReq) toServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
            return true;
        }
        if (VIPAioSendHandler.f195182h.equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setFuncName("getUserKeyWordStips");
            uniPacket.put(Const.BUNDLE_KEY_REQUEST, (AIOKeyWordReq) toServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
            return true;
        }
        return true;
    }
}
