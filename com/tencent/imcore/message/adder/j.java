package com.tencent.imcore.message.adder;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.al;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class j implements h {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(MessageRecord messageRecord) {
        AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
        if (absStructMsg != null && absStructMsg.mMsgServiceID == 61) {
            messageRecord.extInt = 61;
        }
    }

    private void c(QQAppInterface qQAppInterface, MessageForStructing messageForStructing) {
        String str;
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg != null && (str = absStructMsg.mMsgUrl) != null && str.startsWith("https://docs.qq.com")) {
            com.tencent.mobileqq.doc.d.a(qQAppInterface, messageForStructing.frienduin, messageForStructing.senderuin, messageForStructing.istroop, messageForStructing.time, messageForStructing.msgseq, messageForStructing.msgUid);
        }
    }

    @Override // com.tencent.imcore.message.adder.h
    public void a(AppRuntime appRuntime, IMessageManager iMessageManager, MessageRecord messageRecord, boolean z16, boolean z17, boolean z18, Map<String, MessageRecord> map, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, iMessageManager, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, str, Integer.valueOf(i3));
            return;
        }
        if (messageRecord instanceof MessageForStructing) {
            b(messageRecord);
        }
        ((BaseMessageManager) iMessageManager).y(messageRecord.istroop).c(messageRecord.frienduin, messageRecord.istroop, messageRecord, new al(), z16, z17, z18);
        if (messageRecord instanceof MessageForStructing) {
            c((QQAppInterface) appRuntime, (MessageForStructing) messageRecord);
        }
    }
}
