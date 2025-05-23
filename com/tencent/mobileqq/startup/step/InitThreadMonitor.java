package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.monitor.ThreadMonitorReporter;
import com.tencent.mobileqq.perf.thread.config.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class InitThreadMonitor extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public InitThreadMonitor() {
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
        if (QLog.isColorLevel()) {
            QLog.d("[TM]InitThreadMonitor", 2, "doStep");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.startup.step.InitThreadMonitor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InitThreadMonitor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("[TM]InitThreadMonitor", 1, "doStep, ThreadMonitorManager.init().");
                com.tencent.mobileqq.perf.thread.a.a();
                InitThreadMonitor.this.g();
            }
        }, 16, null, true);
        return super.doStep();
    }

    public void g() {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        try {
            eVar = (e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105477");
        } catch (Throwable th5) {
            QLog.e("[TM]InitThreadMonitor", 1, th5, new Object[0]);
            eVar = null;
        }
        if (eVar == null) {
            QLog.d("[TM]InitThreadMonitor", 1, "ThreadPoolMonitor config is null. not init");
            return;
        }
        ThreadMonitorReporter.f196277g = new ThreadManagerInitialler();
        ThreadExcutor.getInstance().setThreadPoolMonitorConfig(eVar.f258140d);
        QLog.d("[TM]InitThreadMonitor", 1, "initThreadPoolMonitor.");
    }
}
