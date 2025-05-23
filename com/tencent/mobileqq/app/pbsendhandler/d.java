package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements IPbSendReqHandler {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler
    public msg_svc$PbSendMsgReq handlePbSendMsg(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (msg_svc$PbSendMsgReq) iPatchRedirector.redirect((short) 2, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3), msg_svc_pbsendmsgreq);
        }
        im_msg_body$GeneralFlags generalFlagElemFromMsg = MessageHandlerUtils.getGeneralFlagElemFromMsg(appInterface, messageRecord, msg_svc_pbsendmsgreq);
        if (generalFlagElemFromMsg != null && msg_svc_pbsendmsgreq != null) {
            im_msg_body$RichText im_msg_body_richtext2 = msg_svc_pbsendmsgreq.msg_body.get().rich_text.get();
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.general_flags.set(generalFlagElemFromMsg);
            im_msg_body_richtext2.elems.get().add(im_msg_body_elem);
        }
        return msg_svc_pbsendmsgreq;
    }
}
