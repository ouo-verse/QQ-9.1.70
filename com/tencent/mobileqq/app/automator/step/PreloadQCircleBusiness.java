package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qcircle.api.IQCirclePreloadStepApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class PreloadQCircleBusiness extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public PreloadQCircleBusiness() {
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
        try {
            ((IQCirclePreloadStepApi) QRoute.api(IQCirclePreloadStepApi.class)).doPreload();
        } catch (Throwable th5) {
            QLog.e("InitQCircle", 1, "", th5);
        }
        return super.doStep();
    }
}
