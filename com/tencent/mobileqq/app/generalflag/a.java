package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(QQAppInterface qQAppInterface, MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, boolean z16, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        com.tencent.mobileqq.bubble.b z17;
        HashMap<String, com.tencent.mobileqq.bubble.g> hashMap;
        BubbleManager bubbleManager = (BubbleManager) qQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
        if (msg_svc_pbsendmsgreq != null) {
            int length = msg_svc_pbsendmsgreq.toByteArray().length;
            ISVIPHandler iSVIPHandler = (ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
            int bubbleMsgLimit = iSVIPHandler.getBubbleMsgLimit();
            int selfBubbleId = iSVIPHandler.getSelfBubbleId();
            boolean z18 = false;
            if (selfBubbleId > 0 && ((z17 = bubbleManager.z(selfBubbleId, false)) == null || ((hashMap = z17.f200661r) != null && hashMap.size() > 0))) {
                z18 = true;
            }
            boolean z19 = z18;
            if (QLog.isColorLevel()) {
                QLog.d(MessageHandlerUtils.TAG, 2, "bubbleId->" + selfBubbleId + " needSend->" + z19);
            }
            boolean b16 = b(messageRecord, msg_svc_pbsendmsgreq, z16, im_msg_body_generalflags, length, 7, bubbleMsgLimit, z19);
            if (messageRecord.vipSubBubbleId != 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(MessageHandlerUtils.TAG, 2, "getGeneralFlagElemFromMsg, sub bubbleid: " + messageRecord.vipSubBubbleId);
                }
                im_msg_body_generalflags.uint32_bubble_sub_id.set(messageRecord.vipSubBubbleId);
                return true;
            }
            return b16;
        }
        return z16;
    }

    private boolean b(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, boolean z16, im_msg_body$GeneralFlags im_msg_body_generalflags, int i3, int i16, int i17, boolean z17) {
        PBRepeatMessageField<im_msg_body$Elem> pBRepeatMessageField;
        if (z17) {
            if ((i17 <= 0 || (i3 + i16 < i17 && i17 > 0)) && messageRecord.vipBubbleDiyTextId > 0 && msg_svc_pbsendmsgreq.msg_body.has() && msg_svc_pbsendmsgreq.msg_body.get().rich_text.has() && (pBRepeatMessageField = msg_svc_pbsendmsgreq.msg_body.get().rich_text.get().elems) != null && pBRepeatMessageField.has()) {
                im_msg_body_generalflags.uint32_bubble_diy_text_id.set(messageRecord.vipBubbleDiyTextId);
                if (QLog.isColorLevel()) {
                    QLog.d(MessageHandlerUtils.TAG, 2, "add BubbleDiyTextId!");
                }
                return true;
            }
            return z16;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        return new boolean[]{a((QQAppInterface) appInterface, messageRecord, msg_svc_pbsendmsgreq, z16, im_msg_body_generalflags), z17};
    }
}
