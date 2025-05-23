package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQDtAfterLoginStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public QQDtAfterLoginStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g() {
        if (com.tencent.mobileqq.dt.b.f203754c) {
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                guardManager.reportForegroundEvent(MobileQQ.processName);
            }
            com.tencent.mobileqq.dt.b.h();
            com.tencent.mobileqq.dt.b.f203754c = false;
            QLog.d("QQDtAfterLoginStep", 1, "848QQDT [doAfterLogin] report");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        QLog.d("QQDtAfterLoginStep", 1, "doStep");
        g();
        com.tencent.mobileqq.data.dt.g.c().f();
        DtSdkInitStep.l();
        return super.doStep();
    }
}
