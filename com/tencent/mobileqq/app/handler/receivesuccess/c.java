package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponseDelRoamMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Object valueOf;
        if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            SvcResponseDelRoamMsg svcResponseDelRoamMsg = (SvcResponseDelRoamMsg) obj;
            if (svcResponseDelRoamMsg != null && svcResponseDelRoamMsg.cReplyCode == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleDelRoamResp isSuccess = ");
                sb5.append(z16);
                sb5.append(" , cReplyCode = ");
                if (svcResponseDelRoamMsg == null) {
                    valueOf = "null";
                } else {
                    valueOf = Byte.valueOf(svcResponseDelRoamMsg.cReplyCode);
                }
                sb5.append(valueOf);
                QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
            }
            messageHandler.notifyBusiness(1003, z16, null);
        }
    }
}
