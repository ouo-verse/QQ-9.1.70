package com.tencent.mobileqq.app.soso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soso.location.inject.ILbsGdtUtilsProcessor;
import com.tencent.mobileqq.turingfd.c;
import com.tencent.turingfd.sdk.xq.ITuringDID;

/* loaded from: classes11.dex */
public class LbsGdtProcessorProxy implements ILbsGdtUtilsProcessor {
    static IPatchRedirector $redirector_;

    public LbsGdtProcessorProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.inject.ILbsGdtUtilsProcessor
    public String getOaid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ITuringDID c16 = c.a().c(true);
        if (c16 == null) {
            return "";
        }
        return c16.getAIDTicket();
    }
}
