package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.api.IRuntimeService;

/* loaded from: classes12.dex */
public class AbsEmoRuntimeServiceProxy<T extends IRuntimeService> {
    static IPatchRedirector $redirector_;
    protected BaseQQAppInterface mApp;
    protected T manager;

    public AbsEmoRuntimeServiceProxy(BaseQQAppInterface baseQQAppInterface, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) cls);
            return;
        }
        this.mApp = baseQQAppInterface;
        if (baseQQAppInterface != null) {
            this.manager = (T) baseQQAppInterface.getRuntimeService(cls);
        }
    }
}
