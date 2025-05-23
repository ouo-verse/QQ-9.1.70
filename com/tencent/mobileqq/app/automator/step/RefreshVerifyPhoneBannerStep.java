package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class RefreshVerifyPhoneBannerStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public RefreshVerifyPhoneBannerStep() {
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
        BannerManager.l().D(VerifyPhoneBannerProcessor.f185283i, 3000);
        return super.doStep();
    }
}
