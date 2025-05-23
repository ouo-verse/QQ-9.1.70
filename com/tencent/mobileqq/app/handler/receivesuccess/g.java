package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("MessageSvc.PbGetDiscussMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            try {
                messageHandler.A3(toServiceMsg, fromServiceMsg, obj);
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp_PB exception ! ", e16);
                }
                messageHandler.z3(toServiceMsg, fromServiceMsg);
            }
        }
    }
}
