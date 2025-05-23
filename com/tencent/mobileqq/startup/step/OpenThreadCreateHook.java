package com.tencent.mobileqq.startup.step;

import android.os.Build;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.au;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfig;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.data.nativemonitor.traffic.NativeTrafficMonitorHelper;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OpenThreadCreateHook {
    static IPatchRedirector $redirector_;

    public OpenThreadCreateHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        NativeMemoryMonitor.setSoLoader(com.tencent.mobileqq.data.nativemonitor.c.a());
        NativeMemoryMonitor.getInstance().setEventLog(new com.tencent.mobileqq.data.nativemonitor.b());
        au auVar = (au) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101595");
        if (auVar != null) {
            QLog.d("ThreadMonitorConfig", 1, "config:" + auVar);
            if (MobileQQ.sProcessId == 1 && auVar.f202339d) {
                ThreadManagerV2.sThreadWrapContext = new ThreadManagerInitialler();
                NativeMonitorConfigHelper.startHookThreadCreate();
            }
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.startup.step.OpenThreadCreateHook.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OpenThreadCreateHook.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((NativeMonitorConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(NativeMonitorConfigHelper.f203157GROUP)) != null && System.currentTimeMillis() % 10000 < r0.soHook) {
                    NativeMonitorConfigHelper.setupSoLoadHook();
                }
                if (Build.VERSION.SDK_INT > 23) {
                    QLog.d("NativeTrafficMonitorHelper", 1, "init from OpenNativeTrafficMonitor");
                    NativeTrafficMonitorHelper.b().f();
                }
            }
        }, 5000L);
        return true;
    }
}
