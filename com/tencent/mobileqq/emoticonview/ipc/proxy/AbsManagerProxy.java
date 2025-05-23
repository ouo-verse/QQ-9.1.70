package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.manager.Manager;

/* loaded from: classes12.dex */
public class AbsManagerProxy<T extends Manager> {
    static IPatchRedirector $redirector_;
    protected BaseQQAppInterface mApp;
    protected T manager;

    public AbsManagerProxy(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, i3);
            return;
        }
        this.mApp = baseQQAppInterface;
        if (baseQQAppInterface != null) {
            this.manager = (T) baseQQAppInterface.getManager(i3);
        }
    }
}
