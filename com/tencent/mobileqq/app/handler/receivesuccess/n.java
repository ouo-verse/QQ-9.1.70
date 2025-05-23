package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbMsgReadedReportResp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class n {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            long j3 = toServiceMsg.extraData.getLong("msgSeq");
            if (messageHandler.getHandlerFromQueue(j3) == null) {
                return;
            }
            try {
                msg_svc$PbMsgReadedReportResp mergeFrom = new msg_svc$PbMsgReadedReportResp().mergeFrom((byte[]) obj);
                if (QLog.isColorLevel()) {
                    if (mergeFrom.c2c_read_report.result.has()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>C2C replyCode:" + mergeFrom.c2c_read_report.result.get() + "reqSeq:" + j3);
                    }
                    if (mergeFrom.dis_read_report.has() && mergeFrom.dis_read_report.get(0).result.has()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>Dis replyCode:" + mergeFrom.dis_read_report.get(0).result.get() + "reqSeq:" + j3);
                    }
                    if (mergeFrom.grp_read_report.has() && mergeFrom.grp_read_report.get(0).result.has()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>GRP replyCode:" + mergeFrom.grp_read_report.get(0).result.get() + " reqSeq:" + j3);
                    }
                }
                messageHandler.removeSendMessageHandler(j3);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "<ReadReport>handleMsgReadedReportResp_PB : server did not return a valid response,reqSeq " + j3);
                }
            }
        }
    }
}
