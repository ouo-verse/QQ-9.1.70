package com.tencent.soter.wrapper.wrap_callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SoterPubKeyModel;

/* loaded from: classes25.dex */
public class SoterProcessKeyPreparationResult extends SoterProcessResultBase<SoterPubKeyModel> {
    static IPatchRedirector $redirector_;

    public SoterProcessKeyPreparationResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public SoterProcessKeyPreparationResult(int i3, String str) {
        super(i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
    }

    public SoterProcessKeyPreparationResult(int i3, String str, SoterPubKeyModel soterPubKeyModel) {
        super(i3, str, soterPubKeyModel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, soterPubKeyModel);
    }

    public SoterProcessKeyPreparationResult(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, i3);
    }

    public SoterProcessKeyPreparationResult(int i3, SoterPubKeyModel soterPubKeyModel) {
        super(i3, soterPubKeyModel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) soterPubKeyModel);
    }
}
