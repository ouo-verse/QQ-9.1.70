package com.tencent.imcore.message.decoder;

import ActionMsg.MsgBody;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class o implements j {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (com.tencent.mobileqq.utils.c.h(message.msgtype) || (i3 = message.msgtype) == -3001 || i3 == -30002 || i3 == -30003) {
            try {
                MsgBody a16 = com.tencent.mobileqq.utils.c.a(message.f203106msg);
                message.f203106msg = a16.f24895msg;
                message.action = a16.action;
                message.shareAppID = a16.shareAppID;
                message.actMsgContentValue = a16.actMsgContentValue;
            } catch (Exception e16) {
                throw e16;
            }
        }
    }
}
