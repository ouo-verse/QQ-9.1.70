package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import msf.msgsvc.msg_svc$PbSendMsgResp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j {
    static IPatchRedirector $redirector_;

    private static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp;
        String arrays;
        int i3;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp.");
        }
        String string = toServiceMsg.extraData.getString("uin");
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        int i16 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        try {
            msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : invalid.", e16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---handleC2CReceiptMessageResp : data:");
                if (obj == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString((byte[]) obj);
                }
                sb5.append(arrays);
                QLog.e("Q.msg.MessageHandler", 2, sb5.toString());
            }
            msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp();
        }
        if (!msg_svc_pbsendmsgresp.result.has()) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : server did not return a valid result code, use 4 instead.");
            }
            i3 = 4;
        } else if (msg_svc_pbsendmsgresp.result.get() != 0) {
            i3 = msg_svc_pbsendmsgresp.result.get();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead----replyCode:" + i3 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + " peerUin:" + string + " msgseq:" + j3 + " msgType:" + i16);
        }
        long j16 = i3;
        fromServiceMsg.extraData.putLong("ServerReplyCode", j16);
        messageHandler.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = messageHandler.getHandlerFromQueue(j3);
        if (handlerFromQueue == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead,no SendMessageHandler found.");
                return;
            }
            return;
        }
        if (i3 == 255) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && messageHandler.retrySendMessage(handlerFromQueue, "server")) {
            return;
        }
        if (i3 != 0 && i3 != 241) {
            messageHandler.l4(toServiceMsg, msg_svc_pbsendmsgresp);
            messageHandler.notifyBusiness(3021, true, new Long[]{Long.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16)});
        } else if (i16 == 1) {
            messageHandler.notifyBusiness(6015, true, new Long[]{Long.valueOf(i16), Long.valueOf(j3)});
        } else {
            messageHandler.notifyBusiness(6015, true, new Long[]{Long.valueOf(i16), Long.valueOf(j3), Long.valueOf(msg_svc_pbsendmsgresp.receipt_resp.receipt_info.uint64_read_time.get())});
        }
        messageHandler.removeSendMessageHandler(j3);
    }

    public static void b(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, String str) {
        if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(str)) {
            a(messageHandler, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
