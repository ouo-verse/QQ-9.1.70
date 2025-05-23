package com.tencent.mobileqq.service.message;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static String[] f286329f;

    /* renamed from: d, reason: collision with root package name */
    private m f286330d;

    /* renamed from: e, reason: collision with root package name */
    private k f286331e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f286329f = new String[]{"MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo"};
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286330d = new m();
            this.f286331e = new k();
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return f286329f;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        return this.f286331e.o(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        return this.f286330d.w(toServiceMsg, uniPacket);
    }
}
