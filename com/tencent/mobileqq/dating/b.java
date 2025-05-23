package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.darenassistant.pb.DarenAssistantMsg$MsgBody;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static MessageRecord a(QQAppInterface qQAppInterface, byte[] bArr, msg_comm$Msg msg_comm_msg) {
        MessageForDarenAssistant messageForDarenAssistant = null;
        if (bArr != null) {
            try {
                DarenAssistantMsg$MsgBody darenAssistantMsg$MsgBody = new DarenAssistantMsg$MsgBody();
                darenAssistantMsg$MsgBody.mergeFrom(bArr);
                MessageForDarenAssistant messageForDarenAssistant2 = (MessageForDarenAssistant) q.d(MessageRecord.MSG_TYPE_DAREN_ASSISTANT);
                messageForDarenAssistant2.f203106msg = darenAssistantMsg$MsgBody.bytes_wording.get().toStringUtf8();
                messageForDarenAssistant2.jumpUrl = darenAssistantMsg$MsgBody.bytes_jump_url.get().toStringUtf8();
                long j3 = darenAssistantMsg$MsgBody.uint32_update_time.get();
                if (j3 <= 0) {
                    j3 = msg_comm_msg.msg_head.get().msg_time.get();
                }
                messageForDarenAssistant2.time = j3;
                messageForDarenAssistant2.msgseq = j3;
                messageForDarenAssistant2.shmsgseq = msg_comm_msg.msg_head.msg_seq.get();
                messageForDarenAssistant2.msgUid = msg_comm_msg.msg_head.msg_uid.get();
                messageForDarenAssistant2.selfuin = qQAppInterface.getCurrentAccountUin();
                messageForDarenAssistant2.istroop = 1001;
                messageForDarenAssistant2.isread = false;
                messageForDarenAssistant2.frienduin = AppConstants.LBS_HELLO_UIN;
                messageForDarenAssistant2.senderuin = AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN;
                messageForDarenAssistant2.getBytes();
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i("DarenAssistantHelper", 2, "decodePull0x210_0x100, decodeDarenAssistantMsg msg=" + darenAssistantMsg$MsgBody.bytes_wording.get().toStringUtf8() + ",jumpUrl=" + darenAssistantMsg$MsgBody.bytes_jump_url.get().toStringUtf8() + ",updateTime=" + darenAssistantMsg$MsgBody.uint32_update_time.get() + ",fromUin=" + msg_comm_msg.msg_head.from_uin.get());
                    }
                    return messageForDarenAssistant2;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    messageForDarenAssistant = messageForDarenAssistant2;
                    QLog.i("DarenAssistantHelper", 1, "decodePull0x210_0x100 decode error, e=" + e.toString());
                    return messageForDarenAssistant;
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
        } else {
            QLog.i("DarenAssistantHelper", 1, "decodePull0x210_0x100 pbData = null");
            return null;
        }
    }
}
