package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ar extends af {
    static IPatchRedirector $redirector_;

    public ar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private MessageForWriteTogether d(im_msg_body$Elem im_msg_body_elem, MessageRecord messageRecord) {
        MessageForWriteTogether messageForWriteTogether = new MessageForWriteTogether();
        MessageRecord.copyMessageRecordBaseField(messageForWriteTogether, messageRecord);
        return messageForWriteTogether;
    }

    private boolean e(im_msg_body$Elem im_msg_body_elem, List<MessageRecord> list) {
        if (im_msg_body_elem != null && list != null && list.size() != 0) {
            if (QLog.isColorLevel() && list.size() != 1) {
                Iterator<MessageRecord> it = list.iterator();
                while (it.hasNext()) {
                    QLog.d("WriteTogetherElemDecode", 1, "[decodeWriteTogetherMsg] " + it.next().toString());
                }
            }
            list.set(0, d(im_msg_body_elem, list.get(0)));
            return true;
        }
        QLog.e("WriteTogetherElemDecode", 1, "[decodeWriteTogetherMsg] elem: " + im_msg_body_elem + ", message: " + list);
        return false;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        if (list2 == null) {
            return false;
        }
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (b(im_msg_body_elem) && e(im_msg_body_elem, list2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 35 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
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
        return -1000;
    }
}
