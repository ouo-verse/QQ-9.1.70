package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class u implements j {
    static IPatchRedirector $redirector_;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
        } else if (message.msgtype == -7090) {
            submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = new submsgtype0x13a$MsgBody();
            submsgtype0x13a_msgbody.mergeFrom(message.msgData);
            message.f203106msg = submsgtype0x13a_msgbody.msg_system_notify.bytes_msg_summary.get().toStringUtf8();
        }
    }
}
