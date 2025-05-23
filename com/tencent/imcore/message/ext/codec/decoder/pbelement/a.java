package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends af {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$Elem im_msg_body_elem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body_elem = it.next();
                if (b(im_msg_body_elem)) {
                    break;
                }
            } else {
                im_msg_body_elem = null;
                break;
            }
        }
        if (im_msg_body_elem != null && im_msg_body_elem.common_elem.bytes_pb_elem.has()) {
            if (list2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(MessageForAniSticker.TAG, 2, "[decodePBMsgElem] msgRecords null");
                }
                list2 = new ArrayList<>();
            } else {
                list2.clear();
            }
            MessageForAniSticker messageForAniSticker = new MessageForAniSticker();
            messageForAniSticker.deserializeMsgBody(im_msg_body_elem.common_elem.bytes_pb_elem.get().toByteArray());
            messageForAniSticker.msgtype = -8018;
            messageForAniSticker.f203106msg = messageForAniSticker.text;
            messageForAniSticker.mIsParsed = true;
            messageForAniSticker.msgData = messageForAniSticker.serializeMsgData();
            list2.add(messageForAniSticker);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e(MessageForAniSticker.TAG, 2, "[decodePBMsgElem] matchElem null or Bytes isEmpty");
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 37 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
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
        return super.getPriority() + 5;
    }
}
