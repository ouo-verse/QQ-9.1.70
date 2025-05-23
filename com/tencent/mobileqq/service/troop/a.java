package com.tencent.mobileqq.service.troop;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.ModifyGroupCardResp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (ModifyGroupCardResp) c(fromServiceMsg.getWupBuffer(), "MGCRESP", new ModifyGroupCardResp());
    }

    private final <T> T c(byte[] bArr, String str, T t16) {
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    public Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("TroopReceiver", 2, "~~~decode cmd: " + serviceCmd);
        }
        if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(serviceCmd)) {
            return b(toServiceMsg, fromServiceMsg);
        }
        return null;
    }
}
