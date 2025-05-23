package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class v implements j {
    static IPatchRedirector $redirector_;

    public v() {
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
            return;
        }
        int i3 = message.msgtype;
        if (i3 == -1003 || i3 == -1032 || i3 == 201) {
            int i16 = message.istroop;
            if (i16 == 1001 || i16 == 10002) {
                try {
                    message.f203106msg = com.tencent.mobileqq.utils.c.a(message.f203106msg).f24895msg;
                } catch (Exception e16) {
                    throw e16;
                }
            }
        }
    }
}
