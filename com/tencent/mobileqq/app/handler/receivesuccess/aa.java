package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponseSetRoamMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class aa {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            SvcResponseSetRoamMsg svcResponseSetRoamMsg = (SvcResponseSetRoamMsg) obj;
            if (svcResponseSetRoamMsg != null && svcResponseSetRoamMsg.cReplyCode == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            messageHandler.notifyBusiness(1005, z16, null);
        }
    }
}
