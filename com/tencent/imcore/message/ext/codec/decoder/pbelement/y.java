package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype2;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class y extends af {
    static IPatchRedirector $redirector_;

    public y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
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
        if (im_msg_body_elem.common_elem.has() && 2 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
            return true;
        }
        return false;
    }

    void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        int i3;
        String qqStr;
        String str;
        int i16;
        if (QLog.isColorLevel()) {
            sb5.append("elemType:PokeMsg;\n");
        }
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
            if (QLog.isColorLevel()) {
                QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
                return;
            }
            return;
        }
        MessageForPoke messageForPoke = new MessageForPoke();
        messageForPoke.msgtype = MessageRecord.MSG_TYPE_POKE_MSG;
        if (im_msg_body_commonelem.uint32_business_type.has()) {
            messageForPoke.interactType = im_msg_body_commonelem.uint32_business_type.get();
        }
        if (im_msg_body_commonelem.bytes_pb_elem.has()) {
            hummer_commelem$MsgElemInfo_servtype2 hummer_commelem_msgeleminfo_servtype2 = new hummer_commelem$MsgElemInfo_servtype2();
            try {
                hummer_commelem_msgeleminfo_servtype2.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
                messageForPoke.f203106msg = hummer_commelem_msgeleminfo_servtype2.bytes_poke_summary.get().toStringUtf8();
                messageForPoke.doubleHitState = hummer_commelem_msgeleminfo_servtype2.uint32_double_hit.get();
                if (hummer_commelem_msgeleminfo_servtype2.uint32_vaspoke_id.has()) {
                    i3 = hummer_commelem_msgeleminfo_servtype2.uint32_vaspoke_id.get();
                } else {
                    i3 = -1;
                }
                messageForPoke.subId = i3;
                if (hummer_commelem_msgeleminfo_servtype2.bytes_vaspoke_name.has()) {
                    qqStr = hummer_commelem_msgeleminfo_servtype2.bytes_vaspoke_name.get().toStringUtf8();
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.o3b);
                }
                messageForPoke.name = qqStr;
                if (hummer_commelem_msgeleminfo_servtype2.bytes_vaspoke_minver.has()) {
                    str = hummer_commelem_msgeleminfo_servtype2.bytes_vaspoke_minver.get().toStringUtf8();
                } else {
                    str = "";
                }
                messageForPoke.minVersion = str;
                messageForPoke.strength = hummer_commelem_msgeleminfo_servtype2.uint32_poke_strength.get();
                if (hummer_commelem_msgeleminfo_servtype2.uint32_poke_flag.has()) {
                    i16 = hummer_commelem_msgeleminfo_servtype2.uint32_poke_flag.get();
                } else {
                    i16 = 0;
                }
                messageForPoke.flag = i16;
                if (messageForPoke.interactType == 126) {
                    VasWebviewUtil.reportCommercialDrainage("", "poke", "receive", "", 0, 0, 0, "", String.valueOf(messageForPoke.subId), "none", "", "", "", "", 0, 0, 0, 0);
                }
            } catch (Exception e16) {
                QLog.d("PokeMsg", 1, "decodePBMsgElems_PokeMsg exception!", e16);
            }
        }
        list2.add(messageForPoke);
        if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "decodePbElems, common_elem type 2, interactType:" + messageForPoke.interactType + " ,doubleHitState:" + messageForPoke.doubleHitState);
        }
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
