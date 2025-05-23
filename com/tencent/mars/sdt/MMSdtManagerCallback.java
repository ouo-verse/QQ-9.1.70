package com.tencent.mars.sdt;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.sdt.MMSdtManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMSdtManagerCallback implements MMSdtManager.CallBack {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.SdtManagerCallback";

    public MMSdtManagerCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mars.sdt.MMSdtManager.CallBack
    public void startTraceRoute(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            w.d(TAG, "startTraceRoute");
        }
    }
}
