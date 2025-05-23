package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, FromServiceMsg fromServiceMsg, Object obj) {
        if (BaseConstants.CMD_REGPRXYSVC_INFOLOGIN.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (fromServiceMsg.getResultCode() == 1000) {
                messageHandler.notifyUI(4004, true, null);
                return;
            }
            if (fromServiceMsg.getResultCode() != 1002 && fromServiceMsg.getResultCode() != 1013) {
                if (fromServiceMsg.getResultCode() == -20009) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request overload protection!");
                    }
                    messageHandler.notifyUI(4004, false, null);
                    messageHandler.notifyUI(4001, false, null);
                    messageHandler.notifyUI(4016, false, null);
                    messageHandler.notifyUI(4003, false, null);
                    messageHandler.notifyUI(4002, false, null);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request error!");
                }
                messageHandler.notifyUI(4004, false, null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request timeout!");
            }
            messageHandler.notifyUI(4004, false, null);
        }
    }
}
