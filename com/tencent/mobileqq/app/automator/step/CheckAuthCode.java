package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CheckAuthCode extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.app.h f195326d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends com.tencent.mobileqq.app.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CheckAuthCode.this);
            }
        }

        @Override // com.tencent.mobileqq.app.h
        public void b(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                CheckAuthCode.this.setResult(7);
            }
        }
    }

    public CheckAuthCode() {
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
        if (this.f195326d == null) {
            a aVar = new a();
            this.f195326d = aVar;
            ((Automator) this.mAutomator).E.addDefaultObservers(aVar);
        }
        if (((ConfigHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).D2()) {
            return 2;
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.app.h hVar = this.f195326d;
        if (hVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(hVar);
            this.f195326d = null;
        }
    }
}
