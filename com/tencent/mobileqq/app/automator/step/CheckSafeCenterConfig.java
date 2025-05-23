package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mqp.app.sec.ScConfigManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CheckSafeCenterConfig extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public CheckSafeCenterConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        int i3 = this.mStepId;
        if (i3 == 47) {
            ScConfigManager.i().b(((Automator) this.mAutomator).E, "SecCenterConfig");
            return 7;
        }
        if (i3 == 48) {
            ScConfigManager.i().l(((Automator) this.mAutomator).E, "SecCenterConfig", true);
            return 7;
        }
        return 7;
    }
}
