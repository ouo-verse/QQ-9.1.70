package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        if ("AccostSvc.ReqInsertBlackList".equals(fromServiceMsg.getServiceCmd())) {
            String string = toServiceMsg.extraData.getString("insertUin");
            if (fromServiceMsg.getResultCode() == 1000) {
                messageHandler.H2(string);
            }
            if (fromServiceMsg.getResultCode() == 1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            messageHandler.notifyUI(6001, z16, string);
        }
    }
}
