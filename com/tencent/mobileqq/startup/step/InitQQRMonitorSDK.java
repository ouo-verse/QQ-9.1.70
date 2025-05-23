package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class InitQQRMonitorSDK extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public InitQQRMonitorSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void init() {
        if (!PrivacyPolicyHelper.isUserAllow()) {
            QLog.i("RMonitorSDK", 1, "privacy policy not allowed");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RMonitorSDK", 2, "RMonitor init");
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.startup.step.a
            @Override // java.lang.Runnable
            public final void run() {
                QQRMonitorSDKManager.c();
            }
        }, 16, null, true, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        init();
        return super.doStep();
    }
}
