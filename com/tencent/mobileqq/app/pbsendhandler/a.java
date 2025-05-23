package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype13;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements IPbSendReqHandler {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(QQAppInterface qQAppInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext) {
        Setting a16;
        com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) qQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        if (bVar != null && bVar.h() && bVar.b() == 1) {
            int i3 = messageRecord.istroop;
            if ((i3 == 1 || i3 == 3000) && (a16 = bVar.a()) != null) {
                short s16 = a16.systemHeadID;
                byte b16 = a16.bHeadType;
                if (QLog.isColorLevel()) {
                    QLog.d(MessageHandlerUtils.TAG, 4, 2, " QQ 18 aniversary activity send system head id = " + ((int) s16) + ", head flag = " + ((int) b16));
                }
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                im_msg_body_commonelem.uint32_service_type.set(13);
                hummer_commelem$MsgElemInfo_servtype13 hummer_commelem_msgeleminfo_servtype13 = new hummer_commelem$MsgElemInfo_servtype13();
                hummer_commelem_msgeleminfo_servtype13.uint32_sys_head_id.set(s16);
                hummer_commelem_msgeleminfo_servtype13.uint32_head_flag.set(b16);
                im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype13.toByteArray()));
                im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler
    public msg_svc$PbSendMsgReq handlePbSendMsg(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (msg_svc$PbSendMsgReq) iPatchRedirector.redirect((short) 2, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3), msg_svc_pbsendmsgreq);
        }
        a((QQAppInterface) appInterface, messageRecord, im_msg_body_richtext);
        return msg_svc_pbsendmsgreq;
    }
}
