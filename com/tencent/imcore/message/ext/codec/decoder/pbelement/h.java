package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype11;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h extends af {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg) {
        im_msg_body$CommonElem im_msg_body_commonelem;
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
            sb5.append("decodePBMsgElems_ScribbleMsg;\n");
        }
        hummer_commelem$MsgElemInfo_servtype11 hummer_commelem_msgeleminfo_servtype11 = new hummer_commelem$MsgElemInfo_servtype11();
        try {
            hummer_commelem_msgeleminfo_servtype11.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            MessageForScribble messageForScribble = (MessageForScribble) com.tencent.mobileqq.service.message.q.d(-7001);
            messageForScribble.msgtype = -7001;
            if (hummer_commelem_msgeleminfo_servtype11.bytes_Doodle_md5.has()) {
                messageForScribble.combineFileMd5 = new String(hummer_commelem_msgeleminfo_servtype11.bytes_Doodle_md5.get().toByteArray());
            }
            if (hummer_commelem_msgeleminfo_servtype11.bytes_Doodle_url.has()) {
                messageForScribble.combineFileUrl = new String(hummer_commelem_msgeleminfo_servtype11.bytes_Doodle_url.get().toByteArray());
            }
            if (hummer_commelem_msgeleminfo_servtype11.uint32_doodleData_offset.has()) {
                messageForScribble.offSet = hummer_commelem_msgeleminfo_servtype11.uint32_doodleData_offset.get();
            }
            if (hummer_commelem_msgeleminfo_servtype11.uint32_doodle_gif_id.has()) {
                messageForScribble.gifId = hummer_commelem_msgeleminfo_servtype11.uint32_doodle_gif_id.get();
            }
            if (QLog.isColorLevel()) {
                QLog.i("DoodleElemDecoderscribble msg", 1, " decodePBMsgElems_ScribbleMsg " + messageForScribble.combineFileMd5 + " " + messageForScribble.combineFileUrl);
            }
            messageForScribble.prewrite();
            list2.add(messageForScribble);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("DoodleElemDecoderscribble msg", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        d(list, list2, sb5, msg_comm_msg);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 11 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
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
