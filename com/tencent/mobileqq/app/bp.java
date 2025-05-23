package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import msf.msgcomm.msg_comm$UinPairMsg;
import msf.msgsvc.msg_svc$MultiMsgAssist;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bp implements MessageHandlerUtils.Callback {
    static IPatchRedirector $redirector_;

    public bp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public void addBubbleInfo(AppInterface appInterface, MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        im_msg_body$RichText im_msg_body_richtext;
        PBRepeatMessageField<im_msg_body$Elem> pBRepeatMessageField;
        com.tencent.mobileqq.bubble.b z16;
        HashMap<String, com.tencent.mobileqq.bubble.g> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appInterface, messageRecord, msg_svc_pbsendmsgreq);
            return;
        }
        int length = msg_svc_pbsendmsgreq.toByteArray().length;
        ISVIPHandler iSVIPHandler = (ISVIPHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        int bubbleMsgLimit = iSVIPHandler.getBubbleMsgLimit();
        BubbleManager bubbleManager = (BubbleManager) appInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
        int selfBubbleId = iSVIPHandler.getSelfBubbleId();
        boolean z17 = true;
        boolean z18 = false;
        if (selfBubbleId > 0 && ((z16 = bubbleManager.z(selfBubbleId, false)) == null || ((hashMap = z16.f200661r) != null && hashMap.size() > 0))) {
            z18 = true;
        }
        boolean z19 = z18;
        if (QLog.isColorLevel()) {
            QLog.d(MessageHandlerUtils.TAG, 2, "bubbleId->" + selfBubbleId + " needSend->" + z19);
        }
        if (msg_svc_pbsendmsgreq.msg_body.has() && msg_svc_pbsendmsgreq.msg_body.get().rich_text.has() && (pBRepeatMessageField = (im_msg_body_richtext = msg_svc_pbsendmsgreq.msg_body.get().rich_text.get()).elems) != null && pBRepeatMessageField.has()) {
            im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
            new generalflags$ResvAttr();
            boolean addBubbleDiyTextId = MessageHandlerUtils.addBubbleDiyTextId(messageRecord, length, 7, bubbleMsgLimit, z19, false, im_msg_body_generalflags);
            int i3 = messageRecord.vipSubBubbleId;
            if (i3 != 0) {
                im_msg_body_generalflags.uint32_bubble_sub_id.set(i3);
                if (QLog.isColorLevel()) {
                    QLog.i(MessageHandlerUtils.TAG, 2, "getPbSendReqFromBlessMsg, sub bubbleid: " + messageRecord.vipSubBubbleId);
                }
            } else {
                z17 = addBubbleDiyTextId;
            }
            if (z17) {
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body_elem.general_flags.set(im_msg_body_generalflags);
                im_msg_body_richtext.elems.get().add(im_msg_body_elem);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public long convertTinyToUin(long j3, msg_comm$UinPairMsg msg_comm_uinpairmsg, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), msg_comm_uinpairmsg, appInterface)).longValue();
        }
        return ed1.d.a(j3, msg_comm_uinpairmsg, appInterface);
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public boolean getBabyQGuideMsgCookieFromAISpecialGuide(MessageRecord messageRecord, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord, (Object) im_msg_body_generalflags)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public Object[] getRichTextAndMsgVia(MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, messageRecord, im_msg_body_richtext, Integer.valueOf(i3));
        }
        int i16 = messageRecord.msgtype;
        if (i16 == -1000) {
            MessageForText messageForText = (MessageForText) messageRecord;
            im_msg_body_richtext = com.tencent.mobileqq.service.message.p.A(messageForText);
            i3 = messageForText.msgVia;
        } else if (i16 == -2022) {
            im_msg_body_richtext = com.tencent.mobileqq.service.message.p.t((MessageForShortVideo) messageRecord);
        } else if (i16 == -2000) {
            im_msg_body_richtext = com.tencent.mobileqq.service.message.p.t((MessageForPic) messageRecord);
        }
        return new Object[]{im_msg_body_richtext, Integer.valueOf(i3)};
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public String getTroopDisplayName(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, appInterface, str, str2);
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (currentAccountUin != null && currentAccountUin.equals(str)) {
            return HardCodeUtil.qqStr(R.string.o2g);
        }
        String s16 = com.tencent.mobileqq.utils.ac.s((QQAppInterface) appInterface, str, str2, 1, 0);
        if (s16 == str) {
            return com.tencent.qqnt.contact.friends.b.f355778a.b(str);
        }
        return s16;
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public boolean isMessageForFoldMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return messageRecord instanceof MessageForFoldMsg;
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public boolean isMsgSendSuc(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord)).booleanValue();
        }
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (!(appInterface instanceof QQAppInterface) || messageRecord.extraflag == 32768 || ((QQAppInterface) appInterface).getMsgCache().t1(messageRecord)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.MessageHandlerUtils.Callback
    public void setMultiMsgFieldInfo(Object obj, msg_svc$MultiMsgAssist msg_svc_multimsgassist) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj, (Object) msg_svc_multimsgassist);
            return;
        }
        if (obj != null && (obj instanceof ChatActivityFacade.a)) {
            ChatActivityFacade.a aVar = (ChatActivityFacade.a) obj;
            if (QLog.isColorLevel()) {
                QLog.d(MessageHandlerUtils.TAG, 2, String.format("getPbSendReqFromBlessMsg, hongbao param, temp_id: %d, video_len: %d, redbag_id: %s, redbag_amount: %d, has_readbag: %d, has_video: %d", Long.valueOf(aVar.f175126a), Long.valueOf(aVar.f175127b), aVar.f175128c, Long.valueOf(aVar.f175129d), Integer.valueOf(aVar.f175130e), Integer.valueOf(aVar.f175131f)));
            }
            msg_svc_multimsgassist.uint64_temp_id.set(aVar.f175126a);
            msg_svc_multimsgassist.uint64_vedio_len.set(aVar.f175127b);
            msg_svc_multimsgassist.uint32_has_readbag.set(aVar.f175130e);
            if (aVar.f175130e == 1) {
                byte[] bArr = aVar.f175128c;
                if (bArr != null) {
                    msg_svc_multimsgassist.bytes_redbag_id.set(ByteStringMicro.copyFrom(bArr));
                }
                msg_svc_multimsgassist.uint64_redbag_amount.set(aVar.f175129d);
            }
            msg_svc_multimsgassist.uint32_has_vedio.set(aVar.f175131f);
        }
    }
}
