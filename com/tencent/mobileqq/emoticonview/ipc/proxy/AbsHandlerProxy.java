package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class AbsHandlerProxy<T> {
    static IPatchRedirector $redirector_;
    protected T businessHandler;
    protected BaseQQAppInterface mApp;

    public AbsHandlerProxy(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) str);
            return;
        }
        this.mApp = baseQQAppInterface;
        if (baseQQAppInterface != null) {
            this.businessHandler = (T) baseQQAppInterface.getBusinessHandler(str);
        }
    }
}
