package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class y implements j {
    static IPatchRedirector $redirector_;

    public y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (message.msgtype == -2011) {
            AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(message.msgData);
            if (d16 != null) {
                str = d16.mMsgBrief;
            } else {
                str = "";
            }
            message.f203106msg = str;
        }
    }
}
