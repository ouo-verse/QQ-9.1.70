package com.tencent.mobileqq.service.lbs;

import EncounterSvc.UserData;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.bz;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    static String[] f286145f;

    /* renamed from: d, reason: collision with root package name */
    public UserData[] f286146d;

    /* renamed from: e, reason: collision with root package name */
    AppInterface f286147e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286145f = new String[]{"EncounterSvc", "NeighborSvc", "VisitorSvc"};
        }
    }

    public c(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f286146d = new UserData[2];
            this.f286147e = appInterface;
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f286145f;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if ("NeighborSvc.ReqGetPoint".equals(fromServiceMsg.getServiceCmd())) {
            return bz.b(this, fromServiceMsg, toServiceMsg);
        }
        if ("VisitorSvc.ReqFavorite".equals(fromServiceMsg.getServiceCmd())) {
            bz.a(fromServiceMsg, toServiceMsg);
        }
        return super.decode(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if ("NeighborSvc.ReqGetPoint".equals(toServiceMsg.getServiceCmd())) {
            return bz.f(this, toServiceMsg, uniPacket);
        }
        if ("VisitorSvc.ReqFavorite".equals(toServiceMsg.getServiceCmd())) {
            return bz.h(toServiceMsg, uniPacket);
        }
        return false;
    }
}
