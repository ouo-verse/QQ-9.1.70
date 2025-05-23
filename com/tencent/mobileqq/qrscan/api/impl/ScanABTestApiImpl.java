package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IScanABTestApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScanABTestApiImpl implements IScanABTestApi {
    static IPatchRedirector $redirector_ = null;
    private static final String EXP_SCAN_QQ_0630 = "exp_scan_qq_0630";
    private static final String EXP_SCAN_QQ_0630_A = "exp_scan_qq_0630_A";
    private static final String EXP_SCAN_QQ_0630_B = "exp_scan_qq_0630_B";
    private static final String TAG = "ScanABTestApiImpl";

    public ScanABTestApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanABTestApi
    public boolean isScanUIExpOnline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanABTestApi
    public boolean isScanUIExperimentB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanABTestApi
    public void reportScanUIExpExposure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
