package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.IBaseHandlerService;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BaseHandlerServiceImpl implements IBaseHandlerService {
    static IPatchRedirector $redirector_;

    public BaseHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.IBaseHandlerService
    public int getHandlerNetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return BaseHandler.getHandlerNetType();
    }
}
