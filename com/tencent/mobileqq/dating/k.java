package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.s2c.msgtype0x210.submsgtype0x108.SubMsgType0x108$MsgBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k {
    static IPatchRedirector $redirector_;

    public static MessageRecord a(QQAppInterface qQAppInterface, byte[] bArr, msg_comm$Msg msg_comm_msg) {
        MessageForYanZhi messageForYanZhi = null;
        if (bArr != null) {
            try {
                SubMsgType0x108$MsgBody subMsgType0x108$MsgBody = new SubMsgType0x108$MsgBody();
                subMsgType0x108$MsgBody.mergeFrom(bArr);
                MessageForYanZhi messageForYanZhi2 = (MessageForYanZhi) q.d(MessageRecord.MSG_TYPE_YANZHI);
                messageForYanZhi2.type = subMsgType0x108$MsgBody.uint32_type.get();
                messageForYanZhi2.pushUin = subMsgType0x108$MsgBody.uint64_push_uin.get();
                messageForYanZhi2.likeCount = subMsgType0x108$MsgBody.uint32_like_count.get();
                messageForYanZhi2.pushTime = subMsgType0x108$MsgBody.push_time.get();
                messageForYanZhi2.f203106msg = subMsgType0x108$MsgBody.uint32_like_count.get() + BaseApplication.getContext().getString(R.string.f171127cd2);
                long j3 = (long) subMsgType0x108$MsgBody.push_time.get();
                if (j3 <= 0) {
                    j3 = msg_comm_msg.msg_head.get().msg_time.get();
                }
                messageForYanZhi2.time = j3;
                messageForYanZhi2.msgseq = j3;
                messageForYanZhi2.shmsgseq = msg_comm_msg.msg_head.msg_seq.get();
                messageForYanZhi2.msgUid = msg_comm_msg.msg_head.msg_uid.get();
                messageForYanZhi2.selfuin = qQAppInterface.getCurrentAccountUin();
                messageForYanZhi2.istroop = 1001;
                messageForYanZhi2.isread = false;
                messageForYanZhi2.frienduin = AppConstants.LBS_HELLO_UIN;
                messageForYanZhi2.senderuin = AppConstants.MSG_BOX_YANZHI_UIN;
                messageForYanZhi2.getBytes();
                b(qQAppInterface, messageForYanZhi2);
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.msg_box.YanZhiHelper", 2, "decodePull0x210_0x108,decode MessageForYanZhitype=" + subMsgType0x108$MsgBody.uint32_type.get() + ",pushUin=" + subMsgType0x108$MsgBody.uint64_push_uin.get() + ",likeCount=" + subMsgType0x108$MsgBody.uint32_like_count.get() + ",pushTime=" + subMsgType0x108$MsgBody.push_time.get());
                    }
                    return messageForYanZhi2;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    messageForYanZhi = messageForYanZhi2;
                    QLog.i("Q.msg_box.YanZhiHelper", 1, "decodePull0x210_0x108 decode error, e=" + e.toString());
                    return messageForYanZhi;
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
        } else {
            QLog.i("Q.msg_box.YanZhiHelper", 1, "decodePull0x210_0x108 pbData = null");
            return null;
        }
    }

    private static void b(QQAppInterface qQAppInterface, MessageForYanZhi messageForYanZhi) {
        MessageRecord x16 = qQAppInterface.getMessageFacade().x1(messageForYanZhi.senderuin, messageForYanZhi.istroop);
        if (x16 != null) {
            qQAppInterface.getMessageFacade().T1(x16.senderuin, x16.istroop, x16.uniseq);
        }
    }
}
