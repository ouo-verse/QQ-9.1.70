package com.tencent.mobileqq.mixedmsg.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgMixedImpl implements IMsgMixed {
    static IPatchRedirector $redirector_;

    public MsgMixedImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.mixedmsg.api.IMsgMixed
    public void copyBaseInfoFromMixedToPic(MessageForPic messageForPic, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPic, (Object) messageRecord);
        } else {
            MessageForMixedMsg.copyBaseInfoFromMixedToPic(messageForPic, (MessageForMixedMsg) messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.mixedmsg.api.IMsgMixed
    public List<MessageRecord> getElementList(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord);
        }
        return ((MessageForMixedMsg) messageRecord).msgElemList;
    }

    @Override // com.tencent.mobileqq.mixedmsg.api.IMsgMixed
    public MessageRecord getMessageForPic(MessageRecord messageRecord, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 6, this, messageRecord, Long.valueOf(j3));
        }
        return ((MessageForMixedMsg) messageRecord).getSubMessage(j3);
    }

    @Override // com.tencent.mobileqq.mixedmsg.api.IMsgMixed
    public boolean isMessageForMixedMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return messageRecord instanceof MessageForMixedMsg;
    }

    @Override // com.tencent.mobileqq.mixedmsg.api.IMsgMixed
    public MessageRecord updateMixmsgBySVMsg(MessageRecord messageRecord, MessageRecord messageRecord2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 7, this, messageRecord, messageRecord2, Integer.valueOf(i3));
        }
        if (messageRecord != null && (messageRecord instanceof MessageForMixedMsg)) {
            MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord;
            List<MessageRecord> list = messageForMixedMsg.msgElemList;
            if (list != null && list.size() > i3) {
                messageForMixedMsg.msgElemList.set(i3, messageRecord2);
            }
            messageForMixedMsg.prewrite();
            return messageRecord;
        }
        return messageRecord2;
    }

    @Override // com.tencent.mobileqq.mixedmsg.api.IMsgMixed
    public void updateMsgAfterDownload(AppInterface appInterface, MessageRecord messageRecord, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, messageRecord, messageForPic);
            return;
        }
        byte[] upateMessageForPic = ((MessageForMixedMsg) messageRecord).upateMessageForPic(messageForPic);
        if (upateMessageForPic != null) {
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq, upateMessageForPic);
        }
    }
}
