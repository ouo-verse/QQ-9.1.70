package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x155.SubMsgType0x155$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ac implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, byte[] bArr) {
        SubMsgType0x155$MsgBody subMsgType0x155$MsgBody = new SubMsgType0x155$MsgBody();
        try {
            subMsgType0x155$MsgBody.mergeFrom(bArr);
            String valueOf = String.valueOf(subMsgType0x155$MsgBody.from_uin.get());
            String valueOf2 = String.valueOf(subMsgType0x155$MsgBody.beat_type.get());
            String stringUtf8 = subMsgType0x155$MsgBody.fold_msg.grey_prompt.get().toStringUtf8();
            String stringUtf82 = subMsgType0x155$MsgBody.fold_msg.toast.get().toStringUtf8();
            long j3 = subMsgType0x155$MsgBody.msg_uid.get();
            long j16 = subMsgType0x155$MsgBody.msg_time.get();
            List<MessageRecord> v06 = qQAppInterface.getMessageFacade().v0(valueOf, 0, j16, j3);
            if (v06 != null && !v06.isEmpty()) {
                MessageRecord messageRecord = v06.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "from_uin=", StringUtil.getSimpleUinForPrint(valueOf), ", msgUid=", String.valueOf(j3), ", beat_type=", valueOf2, ", greyPrompt=", stringUtf8, ", toast=", stringUtf82, ", msgTime=", String.valueOf(j16), ", msg=" + messageRecord.f203106msg);
                }
                messageRecord.saveExtInfoToExtStr("safety_msg_beat_type", valueOf2);
                messageRecord.saveExtInfoToExtStr("safety_msg_grey_prompt", stringUtf8);
                messageRecord.saveExtInfoToExtStr("safety_msg_click_toast", stringUtf82);
                qQAppInterface.getMessageFacade().a1(valueOf, 0, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                return;
            }
            QLog.e("Q.msg.BaseMessageProcessor", 1, "onLinePush receive 0x210_0x155 mrList is null or empty");
            QLog.d("Q.msg.BaseMessageProcessor", 2, "from_uin=", StringUtil.getSimpleUinForPrint(valueOf), ", msgUid=", String.valueOf(j3), ", beat_type=", valueOf2, ", greyPrompt=", stringUtf8, ", toast=", stringUtf82, ", msgTime=", String.valueOf(j16));
        } catch (Exception e16) {
            QLog.d("Q.msg.BaseMessageProcessor", 1, "onLinePush receive 0x210_0x155 " + e16);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x155");
        }
        if (!t61.a.d()) {
            return null;
        }
        b((QQAppInterface) afVar.d(), bArr);
        return null;
    }
}
