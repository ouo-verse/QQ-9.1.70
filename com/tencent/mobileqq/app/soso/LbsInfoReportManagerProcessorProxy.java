package com.tencent.mobileqq.app.soso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.inject.ILbsInfoReportManagerProcessor;

/* loaded from: classes11.dex */
public class LbsInfoReportManagerProcessorProxy implements ILbsInfoReportManagerProcessor {
    static IPatchRedirector $redirector_;

    public LbsInfoReportManagerProcessorProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.inject.ILbsInfoReportManagerProcessor
    public void reportLbsInfo2DC(SosoLocation sosoLocation, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sosoLocation, (Object) str);
        } else {
            LbsInfoReportManager.v(sosoLocation, str);
        }
    }
}
