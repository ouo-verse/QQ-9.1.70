package com.tencent.soter.wrapper.wrap_callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SoterSignatureResult;

/* loaded from: classes25.dex */
public class SoterProcessAuthenticationResult extends SoterProcessResultBase<SoterSignatureResult> {
    static IPatchRedirector $redirector_;

    public SoterProcessAuthenticationResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public SoterProcessAuthenticationResult(int i3, String str) {
        super(i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
    }

    public SoterProcessAuthenticationResult(int i3, String str, SoterSignatureResult soterSignatureResult) {
        super(i3, str, soterSignatureResult);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, soterSignatureResult);
    }

    public SoterProcessAuthenticationResult(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, i3);
    }

    public SoterProcessAuthenticationResult(int i3, SoterSignatureResult soterSignatureResult) {
        super(i3, soterSignatureResult);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) soterSignatureResult);
    }
}
