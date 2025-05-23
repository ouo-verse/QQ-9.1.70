package com.tencent.mobileqq.microapp.sdk;

import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public abstract class OutBaseBridgeJsPlugin extends OutBaseJsPlugin {
    static IPatchRedirector $redirector_;

    public OutBaseBridgeJsPlugin(MiniAppInterface miniAppInterface) {
        super(miniAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppInterface);
        }
    }
}
