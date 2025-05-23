package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqperf.monitor.crash.ReportLog;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SetLogOn extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public SetLogOn() {
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
        String serverConfigValue = ((Automator) this.mAutomator).E.getServerConfigValue(ServerConfigManager.ConfigType.common, "QQIniUrl");
        if (serverConfigValue != null && serverConfigValue.length() > 0) {
            ReportLog.F = serverConfigValue.trim();
        }
        ReportLog.d(((Automator) this.mAutomator).E.getApp(), true);
        return 7;
    }
}
