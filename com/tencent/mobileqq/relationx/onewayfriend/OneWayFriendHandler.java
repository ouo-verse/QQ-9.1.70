package com.tencent.mobileqq.relationx.onewayfriend;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe8c.oidb_0xe8c$ReqBody;
import tencent.im.oidb.cmd0xe8c.oidb_0xe8c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class OneWayFriendHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public OneWayFriendHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        c cVar = new c();
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } catch (Exception e16) {
                QLog.e("OneWayFriendHandler", 1, "handleGetOneWayFriendFlag fail.", e16);
            }
            if (z17) {
                oidb_0xe8c$RspBody oidb_0xe8c_rspbody = new oidb_0xe8c$RspBody();
                oidb_0xe8c_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                long j3 = oidb_0xe8c_rspbody.uint64_friend_uin.get();
                int i3 = oidb_0xe8c_rspbody.uint32_flag.get();
                if ((i3 & 1) != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if ((i3 & 2) != 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                cVar.f280832a = j3;
                if (!z18 && z19) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                cVar.f280833b = z26;
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("OneWayFriendHandler", 2, String.format("handleGetOneWayFriendFlag success=%s result=%s", Boolean.valueOf(z16), cVar));
                }
                notifyUI(1, z16, cVar);
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        notifyUI(1, z16, cVar);
    }

    public void D2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OneWayFriendHandler", 2, String.format("getOneWayFriendFlag friendUin=%s", Long.valueOf(j3)));
        }
        oidb_0xe8c$ReqBody oidb_0xe8c_reqbody = new oidb_0xe8c$ReqBody();
        oidb_0xe8c_reqbody.uint64_friend_uin.set(j3);
        sendPbReq(makeOIDBPkg("OidbSvc.0xe8c", 3724, 0, oidb_0xe8c_reqbody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xe8c".equals(toServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
