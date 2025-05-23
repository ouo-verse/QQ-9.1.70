package com.tencent.mobileqq.service.message.codec.decoder;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.p;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void c(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, boolean z16, boolean z17, boolean z18, int i3) {
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has()) {
            long longValue = Long.valueOf(messageHandler.Q.getCurrentAccountUin()).longValue();
            long j3 = msg_comm_msg.msg_head.get().from_uin.get();
            short s16 = (short) msg_comm_msg.msg_head.get().msg_type.get();
            int i16 = (-1006) - (s16 - 187);
            if (!z16 && !z17 && !z18) {
                messageHandler.m3().W(longValue, j3, s16, i16, msg_comm_msg, i3);
            }
            msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
            if (msg_comm_msghead != null) {
                String str = "" + msg_comm_msghead.auth_uin.get();
                String str2 = msg_comm_msghead.auth_nick.get();
                String str3 = msg_comm_msghead.auth_remark.get();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                    messageHandler.W4(str, str3);
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    messageHandler.V4(str, str2);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SystemMessageDecoder", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + msg_comm_msg.msg_body.has() + ",hasMsgContent" + msg_comm_msg.msg_body.get().msg_content.has() + ",isReaded:" + z16 + "syncOther:" + z17);
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.SYSTEM_MSG, 2, "friend system msg notify");
        }
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        short s16 = (short) msg_comm_msghead.msg_seq.get();
        long j3 = msg_comm_msghead.from_uin.get();
        long j16 = msg_comm_msghead.msg_uid.get();
        int i3 = msg_comm_msghead.msg_type.get();
        if (i3 != 188 && i3 != 189) {
            z16 = false;
        }
        if (!aVar.f286156k && !z16) {
            messageHandler.m3().v0(2);
        }
        aVar.f286338a = AppConstants.SYSTEM_MSG_UIN_LONGVALUE;
        c(messageHandler, msg_comm_msg, aVar.f286154i, aVar.f286159n, aVar.f286157l, s16);
        p.I(j3, s16, j16, i3, messageHandler.getApp());
    }
}
