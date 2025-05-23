package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class al extends af {
    static IPatchRedirector $redirector_;

    public al() {
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
        com.tencent.mobileqq.service.message.o oVar = new com.tencent.mobileqq.service.message.o();
        int i3 = 0;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                try {
                    generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                    if (generalflags_resvattr.uint32_troop_pobing_template.has()) {
                        i3 = generalflags_resvattr.uint32_troop_pobing_template.get();
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
        }
        if (i3 == 0) {
            oVar.n(list, list2, sb5, msg_comm_msg, cVar);
            return true;
        }
        StringBuilder t16 = oVar.t(null, list, sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, new com.tencent.mobileqq.service.message.aa(), new ArrayList<>(2), msg_comm_msg.msg_head.msg_time.get());
        MessageForTroopPobing messageForTroopPobing = (MessageForTroopPobing) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_TROOP_NEWER_POBING);
        messageForTroopPobing.msgtype = MessageRecord.MSG_TYPE_TROOP_NEWER_POBING;
        StructMsgForGeneralShare structMsgForGeneralShare = new StructMsgForGeneralShare();
        structMsgForGeneralShare.pobingTemplateId = i3;
        structMsgForGeneralShare.mMsgBrief = t16.toString();
        messageForTroopPobing.structingMsg = structMsgForGeneralShare;
        messageForTroopPobing.doPrewrite();
        messageForTroopPobing.doParse();
        list2.add(messageForTroopPobing);
        long j3 = msg_comm_msg.msg_head.to_uin.get();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            new com.tencent.mobileqq.statistics.q(peekAppRuntime).i("dc00899").a("Grp_AIO").f("newman_join").d("exp_welcome").b(j3 + "", "", "" + TroopUtils.c((QQAppInterface) peekAppRuntime, String.valueOf(j3))).g();
        }
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            try {
                generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                if ((!generalflags_resvattr.uint32_troop_pobing_template.has() || generalflags_resvattr.uint32_troop_pobing_template.get() == 0) && (!generalflags_resvattr.uint32_is_ice_break_msg.has() || generalflags_resvattr.uint32_is_ice_break_msg.get() == 0)) {
                    return false;
                }
                return true;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("TroopIceBreakElemDecoder", 1, "match merge error", e16);
            }
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
