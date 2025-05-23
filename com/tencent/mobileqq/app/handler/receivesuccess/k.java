package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Bundle bundle;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(serviceCmd) || BaseConstants.CMD_MSG_UNREAD_MSG_SEQ.equalsIgnoreCase(serviceCmd)) && toServiceMsg != null && (bundle = toServiceMsg.extraData) != null) {
            if (ISubAccountControlService.ACT_GET_THIRD_QQ_UNREAD_NUM.equals(bundle.getString("action"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<<---handle response - get thirdqq unread number");
                }
                try {
                    messageHandler.l3().d1(toServiceMsg, fromServiceMsg, obj);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.MessageHandler", 2, "handle response - get thirdqq unread number exception ! ", e16);
                    }
                    messageHandler.l3().c1(toServiceMsg, fromServiceMsg);
                    return;
                }
            }
            try {
                if (messageHandler.isPbReq(toServiceMsg)) {
                    messageHandler.K3(toServiceMsg, fromServiceMsg, obj);
                } else {
                    messageHandler.J3(toServiceMsg, fromServiceMsg, (SvcResponsePullGroupMsgSeq) obj);
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp exception ! ", e17);
                }
                messageHandler.I3(toServiceMsg, fromServiceMsg);
            }
        }
    }
}
