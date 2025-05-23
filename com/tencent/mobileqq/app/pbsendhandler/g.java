package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ExtraInfo;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g implements IPbSendReqHandler {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext) {
        if (messageRecord.msgtype == -1000) {
            MessageForText messageForText = (MessageForText) messageRecord;
            if (messageForText.mPasswdRedBagFlag != 0) {
                im_msg_body$ExtraInfo im_msg_body_extrainfo = new im_msg_body$ExtraInfo();
                im_msg_body_extrainfo.uint64_uin.set(messageForText.mPasswdRedBagSender);
                im_msg_body_extrainfo.uint32_msg_state_flag.set(messageForText.mPasswdRedBagFlag);
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body_elem.extra_info.set(im_msg_body_extrainfo);
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
        a(messageRecord, im_msg_body_richtext);
        return msg_svc_pbsendmsgreq;
    }
}
