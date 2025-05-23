package com.tencent.mobileqq.perf.thread.config;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadSmartPoolMonitorConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class ThreadPoolMonitorUpdateImpl implements com.tencent.mobileqq.qqfeatureswitch.c {
    static IPatchRedirector $redirector_;

    public ThreadPoolMonitorUpdateImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (MobileQQ.sProcessId != 1) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.thread.config.ThreadPoolMonitorUpdateImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThreadPoolMonitorUpdateImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.d("ThreadSmartPoolMonitorConfig", 1, "onFeatureUpdate");
                    try {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime != null) {
                            Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet("qq_thread_pool_monitor_config", "");
                            QLog.d("ThreadSmartPoolMonitorConfig", 1, "FT: dataSet:" + isEnabledWithDataSet.toString());
                            ThreadSmartPoolMonitorConfig.setConfigData(isEnabledWithDataSet);
                        }
                    } catch (Exception e16) {
                        QLog.e("ThreadSmartPoolMonitorConfig", 1, "[onFeatureUpdate]:" + e16.toString());
                    }
                }
            }, 16, null, true);
        }
    }
}
