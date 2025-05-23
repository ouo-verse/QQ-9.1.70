package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.biz.pubaccount.util.m;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import msf.msgsvc.msg_ctrl$MsgCtrl;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h implements IPbSendReqHandler {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        AbsStructMsg absStructMsg;
        if (msg_svc_pbsendmsgreq != null && (messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null && m.i(absStructMsg)) {
            msg_ctrl$MsgCtrl msg_ctrl_msgctrl = new msg_ctrl$MsgCtrl();
            msg_ctrl_msgctrl.msg_flag.set(4);
            msg_svc_pbsendmsgreq.msg_ctrl.set(msg_ctrl_msgctrl);
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler
    public msg_svc$PbSendMsgReq handlePbSendMsg(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (msg_svc$PbSendMsgReq) iPatchRedirector.redirect((short) 2, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3), msg_svc_pbsendmsgreq);
        }
        a(messageRecord, msg_svc_pbsendmsgreq);
        return msg_svc_pbsendmsgreq;
    }
}
