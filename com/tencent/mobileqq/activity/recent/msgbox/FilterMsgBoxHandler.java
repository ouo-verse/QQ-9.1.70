package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FilterMsgBoxHandler extends BusinessHandler implements l71.a {
    static IPatchRedirector $redirector_;

    protected FilterMsgBoxHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.d("FilterMsgBoxHandler", 2, "onReceiverOxefe() called with: resultCode = [" + resultCode + "], req = [" + toServiceMsg + "], res = [" + fromServiceMsg + "]");
        }
        if (fromServiceMsg.isSuccess()) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (Exception e16) {
                QLog.d("FilterMsgBoxHandler", 1, "onReceiverOxefe()  e =", e16);
            }
            notifyUI(oidb_sso_oidbssopkg.uint32_result.get(), true, null);
        }
    }

    @Override // l71.a
    public void l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FilterMsgBoxHandler", 2, "sendDelPbReq() called with: uin = [" + j3 + "]");
        }
        oidb_cmd0xefe$ReqBody oidb_cmd0xefe_reqbody = new oidb_cmd0xefe$ReqBody();
        oidb_cmd0xefe_reqbody.friend_uin.set(j3);
        oidb_cmd0xefe_reqbody.last_ts.set(b.d());
        sendPbReq(makeOIDBPkg("OidbSvc.0xefe", 3838, 3, oidb_cmd0xefe_reqbody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && obj != null) {
            if ("OidbSvc.0xefe".equals(fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
            }
        } else {
            QLog.e("FilterMsgBoxHandler", 1, "[onReceive] params: res: " + fromServiceMsg + ". data: " + obj);
        }
    }
}
