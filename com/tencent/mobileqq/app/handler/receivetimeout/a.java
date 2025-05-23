package com.tencent.mobileqq.app.handler.receivetimeout;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.handler.receivesuccess.w;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Bundle bundle;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<<---handleTimeOut serviceCmd:" + fromServiceMsg.getServiceCmd());
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (ProcessorDispatcher.getProcessorMap().containsKey(serviceCmd)) {
            messageHandler.dispatchTimeoutToProcessor(serviceCmd, toServiceMsg, fromServiceMsg);
            return;
        }
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(serviceCmd)) {
            messageHandler.x3(toServiceMsg);
            return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(serviceCmd)) {
            messageHandler.M3(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(serviceCmd)) {
            messageHandler.b4(toServiceMsg, fromServiceMsg);
            return;
        }
        if (BaseConstants.CMD_MSG_PBSENDMSG.equalsIgnoreCase(serviceCmd)) {
            messageHandler.d4(toServiceMsg, fromServiceMsg);
            com.tencent.mobileqq.statistics.tianjige.tracers.a.e(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("OidbSvc.0xa89".equalsIgnoreCase(serviceCmd)) {
            messageHandler.c4(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("AccostSvc.ClientMsg".equalsIgnoreCase(serviceCmd)) {
            w.a(messageHandler, toServiceMsg, fromServiceMsg);
            return;
        }
        if (BaseConstants.CMD_MSG_UNREAD_MSG_SEQ.equalsIgnoreCase(serviceCmd)) {
            if (toServiceMsg != null && (bundle = toServiceMsg.extraData) != null) {
                if (ISubAccountControlService.ACT_GET_THIRD_QQ_UNREAD_NUM.equals(bundle.getString("action"))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<<---handle timeout - get thirdqq unread number");
                    }
                    messageHandler.l3().e1(toServiceMsg, fromServiceMsg);
                    return;
                }
                messageHandler.L3(toServiceMsg, fromServiceMsg);
                return;
            }
            return;
        }
        if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(serviceCmd)) {
            messageHandler.j4(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(serviceCmd)) {
            messageHandler.s3(toServiceMsg, fromServiceMsg);
        } else if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(serviceCmd)) {
            messageHandler.P3(toServiceMsg, fromServiceMsg);
        } else if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(serviceCmd)) {
            messageHandler.q3(toServiceMsg, fromServiceMsg);
        }
    }
}
