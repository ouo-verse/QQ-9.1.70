package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.handler.IMsgHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
final class MessageInnerRegistry {
    static IPatchRedirector $redirector_;

    public MessageInnerRegistry(com.tencent.imcore.message.basic.c<String, IMsgHandler> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        }
    }
}
