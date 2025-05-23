package com.tencent.mobileqq.structmsg.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.aa;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmediabrowser.j;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.structmsg.view.e;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichMsg;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MsgStructingImpl implements IMsgStructing {
    static IPatchRedirector $redirector_;

    public MsgStructingImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.api.IMsgStructing
    public void consumeStructMsgPicPre(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord);
        } else {
            aa.a((MessageForStructing) messageRecord, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    @Override // com.tencent.mobileqq.structmsg.api.IMsgStructing
    public MessageForPic getMessageForPic(MessageRecord messageRecord) {
        e firstImageElement;
        MessageForPic messageForPic;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageForPic) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord);
        }
        AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
        if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = ((StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null && (messageForPic = firstImageElement.f290638c1) != null) {
            return messageForPic;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.structmsg.api.IMsgStructing
    public boolean isMessageForStructing(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return messageRecord instanceof MessageForStructing;
    }

    @Override // com.tencent.mobileqq.structmsg.api.IMsgStructing
    public void updateMsgAfterDownload(AppInterface appInterface, MessageRecord messageRecord, MessageForPic messageForPic) {
        e firstImageElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, messageRecord, messageForPic);
            return;
        }
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if ((absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = ((StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
            firstImageElement.f290638c1 = messageForPic;
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq, messageForStructing.structingMsg.getBytes());
        }
    }

    @Override // com.tencent.mobileqq.structmsg.api.IMsgStructing
    public void updateMsgAfterUpload(AppInterface appInterface, MessageRecord messageRecord, String str, String str2, long j3, Long l3, String str3, int i3) {
        e firstImageElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, messageRecord, str, str2, Long.valueOf(j3), l3, str3, Integer.valueOf(i3));
            return;
        }
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = ((StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
            firstImageElement.T0 = str;
            firstImageElement.S0 = str2;
            firstImageElement.Z0 = j3;
            if (l3 != null) {
                firstImageElement.Y0 = l3.longValue();
            }
            firstImageElement.f290636a1 = messageRecord.time;
            messageForStructing.msgData = messageForStructing.structingMsg.getBytes();
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(str3, i3, messageRecord.uniseq, messageForStructing.msgData);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.api.IMsgStructing
    public void uploadPicConstructRichText(MessageRecord messageRecord, String str, String str2, long j3, Long l3, im_msg_body$RichText im_msg_body_richtext) {
        StructMsgForImageShare structMsgForImageShare;
        e firstImageElement;
        byte[] xmlBytes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, messageRecord, str, str2, Long.valueOf(j3), l3, im_msg_body_richtext);
            return;
        }
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = (structMsgForImageShare = (StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
            firstImageElement.T0 = str;
            firstImageElement.S0 = str2;
            if (l3 != null) {
                firstImageElement.Y0 = l3.longValue();
            }
            firstImageElement.f290636a1 = messageRecord.time;
            firstImageElement.Z0 = j3;
            if (j.e(structMsgForImageShare.mMsgActionData)) {
                String str3 = firstImageElement.R0;
                firstImageElement.R0 = "";
                xmlBytes = messageForStructing.structingMsg.getXmlBytes();
                firstImageElement.R0 = str3;
            } else {
                xmlBytes = messageForStructing.structingMsg.getXmlBytes();
            }
            if (!TextUtils.isEmpty(messageForStructing.frienduin) && xmlBytes != null) {
                im_msg_body$RichMsg im_msg_body_richmsg = new im_msg_body$RichMsg();
                im_msg_body_richmsg.bytes_template_1.set(ByteStringMicro.copyFrom(xmlBytes));
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body_elem.rich_msg.set(im_msg_body_richmsg);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
            }
        }
    }
}
