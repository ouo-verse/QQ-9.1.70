package com.tencent.soter.wrapper.wrap_callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes25.dex */
public class SoterProcessNoExtResult extends SoterProcessResultBase {
    static IPatchRedirector $redirector_;

    public SoterProcessNoExtResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public SoterProcessNoExtResult(int i3, String str) {
        super(i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
    }

    public SoterProcessNoExtResult(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, i3);
    }
}
