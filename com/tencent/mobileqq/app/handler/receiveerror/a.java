package com.tencent.mobileqq.app.handler.receiveerror;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.handler.receivesuccess.w;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.k;
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
            QLog.d("Q.msg.MessageHandler", 2, "<<---handleError serviceCmd:" + fromServiceMsg.getServiceCmd());
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (ProcessorDispatcher.getProcessorMap().containsKey(serviceCmd)) {
            messageHandler.dispatchErrorToProcessor(serviceCmd, toServiceMsg, fromServiceMsg);
            return;
        }
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(serviceCmd)) {
            messageHandler.w3(toServiceMsg);
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
            com.tencent.mobileqq.statistics.tianjige.tracers.a.d(toServiceMsg, fromServiceMsg);
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
        if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(serviceCmd)) {
            messageHandler.P3(toServiceMsg, fromServiceMsg);
            return;
        }
        if (!"MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(serviceCmd) && !BaseConstants.CMD_MSG_UNREAD_MSG_SEQ.equalsIgnoreCase(serviceCmd)) {
            if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(serviceCmd)) {
                messageHandler.i4(toServiceMsg, fromServiceMsg);
                return;
            }
            if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(serviceCmd)) {
                messageHandler.r3(toServiceMsg, fromServiceMsg);
                return;
            } else if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(serviceCmd)) {
                messageHandler.q3(toServiceMsg, fromServiceMsg);
                return;
            } else {
                if ("StreamSvr.UploadStreamMsg".equals(serviceCmd)) {
                    messageHandler.notifyUI(3011, false, new Object[]{new k.d(toServiceMsg.extraData.getString("filepath"), toServiceMsg.extraData.getShort("PackSeq"), toServiceMsg.extraData.getShort("flowLayer"), null, 0)});
                    return;
                }
                return;
            }
        }
        if (toServiceMsg != null && (bundle = toServiceMsg.extraData) != null) {
            if (ISubAccountControlService.ACT_GET_THIRD_QQ_UNREAD_NUM.equals(bundle.getString("action"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<<---handleError - get thirdqq unread number");
                }
                messageHandler.l3().c1(toServiceMsg, fromServiceMsg);
                return;
            }
            messageHandler.I3(toServiceMsg, fromServiceMsg);
        }
    }
}
