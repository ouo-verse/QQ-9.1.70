package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements j {
    static IPatchRedirector $redirector_;

    public c() {
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
        } else if (message.msgtype == -5016 && message.msgData != null) {
            MessageForArkBabyqReply messageForArkBabyqReply = new MessageForArkBabyqReply();
            messageForArkBabyqReply.fromBytes(message.msgData);
            message.f203106msg = messageForArkBabyqReply.getSummery();
        }
    }
}
