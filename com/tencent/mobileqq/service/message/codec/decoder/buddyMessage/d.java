package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements com.tencent.mobileqq.service.message.codec.decoder.d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, long j3, boolean z16, boolean z17, long j16, int i3) {
        String valueOf;
        String str;
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
        int i16 = msg_comm_msg.msg_head.get().c2c_cmd.get();
        Long valueOf2 = Long.valueOf(msg_comm_msg.msg_head.get().from_uin.get());
        Long valueOf3 = Long.valueOf(msg_comm_msg.msg_head.get().to_uin.get());
        long j17 = msg_comm_msg.msg_head.get().msg_time.get();
        short s16 = (short) msg_comm_msg.msg_head.get().msg_seq.get();
        String l3 = valueOf2.toString();
        String currentAccountUin = messageHandler.Q.getCurrentAccountUin();
        if (i16 == 129) {
            if (l3.equals(String.valueOf(valueOf3)) && l3.equals(currentAccountUin)) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
                    return;
                }
                return;
            }
            str = l3;
        } else {
            if (currentAccountUin.equals(String.valueOf(valueOf2))) {
                valueOf = String.valueOf(valueOf3);
            } else {
                valueOf = String.valueOf(valueOf2);
            }
            str = valueOf;
        }
        if (i16 != 129) {
            if (i16 != 131) {
                if (i16 == 133) {
                    f(messageHandler, j3, z16, j16, i3, im_msg_body_msgbody, i16, j17, s16, str);
                    return;
                }
                return;
            }
            e(messageHandler, j3, z16, j16, i3, im_msg_body_msgbody, i16, j17, s16, str);
            return;
        }
        d(messageHandler, j3, z16, z17, j16, i3, im_msg_body_msgbody, i16, valueOf2, j17, s16, str, currentAccountUin);
    }

    private void d(MessageHandler messageHandler, long j3, boolean z16, boolean z17, long j16, int i3, im_msg_body$MsgBody im_msg_body_msgbody, int i16, Long l3, long j17, short s16, String str, String str2) {
        if (str2.equalsIgnoreCase(String.valueOf(l3))) {
            if (QLog.isColorLevel()) {
                QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
                return;
            }
            return;
        }
        if (z17) {
            if (QLog.isColorLevel()) {
                QLog.i("OnlineFileDecoder", 2, "recv roam online msg, return!");
                return;
            }
            return;
        }
        m t16 = messageHandler.Q.getFileTransferHandler().t(im_msg_body_msgbody.msg_content.get().toByteArray());
        if (t16 != null) {
            if (!messageHandler.Q.getFileTransferHandler().F0(t16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
                    return;
                }
                return;
            } else {
                if (!t16.H) {
                    if (QLog.isColorLevel()) {
                        QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
                        return;
                    }
                    return;
                }
                messageHandler.Q.getFileTransferHandler().X(i16, String.valueOf(j3), str, j17, s16, z16, 0, null, t16, j16, i3);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
    }

    private void e(MessageHandler messageHandler, long j3, boolean z16, long j16, int i3, im_msg_body$MsgBody im_msg_body_msgbody, int i16, long j17, short s16, String str) {
        m t16 = messageHandler.Q.getFileTransferHandler().t(im_msg_body_msgbody.msg_content.get().toByteArray());
        if (t16 != null) {
            if (!messageHandler.Q.getFileTransferHandler().F0(t16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
                    return;
                }
                return;
            }
            messageHandler.Q.getFileTransferHandler().X(i16, String.valueOf(j3), str, j17, s16, z16, 0, null, t16, j16, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
        }
    }

    private void f(MessageHandler messageHandler, long j3, boolean z16, long j16, int i3, im_msg_body$MsgBody im_msg_body_msgbody, int i16, long j17, short s16, String str) {
        m q16 = messageHandler.Q.getFileTransferHandler().q(im_msg_body_msgbody.msg_content.get().toByteArray());
        if (q16 != null) {
            if (!messageHandler.Q.getFileTransferHandler().F0(q16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
                    return;
                }
                return;
            }
            messageHandler.Q.getFileTransferHandler().X(i16, String.valueOf(j3), str, j17, s16, z16, 0, null, q16, j16, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
        } else {
            c(messageHandler, msg_comm_msg, aVar.f286338a, aVar.f286154i, aVar.f286155j, aVar.f286151f, aVar.f286152g);
        }
    }
}
