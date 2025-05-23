package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype24;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class s extends af {
    static IPatchRedirector $redirector_;

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        int i3;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("decodePBMsgElems_LimitChatConfirmMsg;\n");
        }
        hummer_commelem$MsgElemInfo_servtype24 hummer_commelem_msgeleminfo_servtype24 = new hummer_commelem$MsgElemInfo_servtype24();
        try {
            hummer_commelem_msgeleminfo_servtype24.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            MessageForLimitChatConfirm messageForLimitChatConfirm = (MessageForLimitChatConfirm) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_LIMIT_CHAT_CONFIRM);
            messageForLimitChatConfirm.msgtype = MessageRecord.MSG_TYPE_LIMIT_CHAT_CONFIRM;
            if (im_msg_body_commonelem.uint32_business_type.has()) {
                i3 = im_msg_body_commonelem.uint32_business_type.get();
            } else {
                i3 = 1;
            }
            if (i3 == 1) {
                if (hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.has()) {
                    messageForLimitChatConfirm.SenderNickName = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.bytes_match_nick.get().toStringUtf8();
                    messageForLimitChatConfirm.tipsWording = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.bytes_tips_wording.get().toStringUtf8();
                    messageForLimitChatConfirm.leftChatTime = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint32_left_chat_time.get();
                    messageForLimitChatConfirm.c2cExpiredTime = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint32_c2c_expired_time.get();
                    messageForLimitChatConfirm.matchExpiredTime = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint32_match_expired_time.get();
                    messageForLimitChatConfirm.timeStamp = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint64_match_ts.get();
                    messageForLimitChatConfirm.readyTs = hummer_commelem_msgeleminfo_servtype24.limit_chat_enter.uint64_ready_ts.get();
                    messageForLimitChatConfirm.bEnterMsg = true;
                } else {
                    QLog.e("LimitChatConfirmElemDecoderExtendFriendLimitChatLimitChatConfirm msg", 1, " !!!limitChatElem  limit_chat_enter is null ");
                }
            } else if (hummer_commelem_msgeleminfo_servtype24.limit_chat_exit.has()) {
                messageForLimitChatConfirm.bEnterMsg = false;
                messageForLimitChatConfirm.leaveChatType = hummer_commelem_msgeleminfo_servtype24.limit_chat_exit.uint32_exit_method.get();
                messageForLimitChatConfirm.timeStamp = hummer_commelem_msgeleminfo_servtype24.limit_chat_exit.uint64_match_ts.get();
            } else {
                QLog.e("LimitChatConfirmElemDecoderLimitChatConfirm msg", 1, " limitChatElem  limit_chat_exit is null ");
            }
            if (QLog.isColorLevel()) {
                QLog.i("LimitChatConfirmElemDecoderLimitChatConfirm msg", 1, " decodePBMsgElems_LimitChatConfirmMsg type" + i3 + " " + messageForLimitChatConfirm.matchExpiredTime + " " + messageForLimitChatConfirm.frienduin);
            }
            messageForLimitChatConfirm.prewrite();
            list2.add(messageForLimitChatConfirm);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.e("LimitChatConfirmElemDecoderscribble msg", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        d(list, list2, sb5);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 24 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1000;
    }
}
