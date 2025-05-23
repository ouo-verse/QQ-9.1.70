package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            try {
                Automator automator = messageHandler.Q.mAutomator;
                if (automator != null && !automator.isSyncNormalMsgFinish()) {
                    messageHandler.O3(toServiceMsg, fromServiceMsg, obj);
                } else {
                    messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C).t(1002, toServiceMsg, fromServiceMsg, obj);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "handleGetC2CMessageResp_PB exception ! ", e16);
                }
                messageHandler.w3(toServiceMsg);
            }
        }
    }
}
