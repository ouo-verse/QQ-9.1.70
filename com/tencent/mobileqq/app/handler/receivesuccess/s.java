package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(serviceCmd) || "OnlinePush.PbPushDisMsg".equalsIgnoreCase(serviceCmd) || "OnlinePush.PbC2CMsgSync".equalsIgnoreCase(serviceCmd) || "OnlinePush.PbPushC2CMsg".equalsIgnoreCase(serviceCmd) || "OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(serviceCmd)) {
            try {
                messageHandler.N3(fromServiceMsg, obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "handleMessagePush_PB exception ! ", e16);
                }
            }
        }
    }
}
