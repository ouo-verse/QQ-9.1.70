package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k implements n {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(int i3, int i16, QQAppInterface qQAppInterface, byte[] bArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d("SecSpyFileDecoder", 4, "OnLinePushMessageProcessor receive 0x7c push message, seq = " + i3 + "submsgtype:" + i16);
        }
        submsgtype0x7c$MsgBody submsgtype0x7c_msgbody = new submsgtype0x7c$MsgBody();
        try {
            submsgtype0x7c_msgbody.mergeFrom(bArr);
            if (qQAppInterface.getCurrentAccountUin().equals(String.valueOf(submsgtype0x7c_msgbody.uint64_uin.get()))) {
                ((SecSpyFileManager) qQAppInterface.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER)).g(submsgtype0x7c_msgbody, 3);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SecSpyFileDecoder", 2, "parse 0x7c push msg error", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg_comm_msgtype0x210, msg_comm_msg, list, aVar, messageHandler);
        } else {
            a(msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_type.get(), messageHandler.Q, msg_comm_msgtype0x210.msg_content.get().toByteArray());
        }
    }
}
