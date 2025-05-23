package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class InitTabData extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public InitTabData() {
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
        ((TabDataHandler) ((Automator) this.mAutomator).E.getBusinessHandler(TabDataHandler.class.getName())).I2();
        ((ILebaHelperService) ((Automator) this.mAutomator).E.getRuntimeService(ILebaHelperService.class, "")).getUserSettingNet(((Automator) this.mAutomator).E);
        return super.doStep();
    }
}
