package com.tencent.mobileqq.microapp.ext;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

/* loaded from: classes15.dex */
public class ManagerProxy {
    static IPatchRedirector $redirector_;

    public ManagerProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ApkgConfigManager getApkgConfigManager(AppRuntime appRuntime) {
        return (ApkgConfigManager) appRuntime.getManager(QQManagerFactory.APKG_CONFIG_MANAGER);
    }

    public static IQWalletConfigService getQWalletConfigManager(AppRuntime appRuntime) {
        return (IQWalletConfigService) appRuntime.getRuntimeService(IQWalletConfigService.class, "");
    }

    public static TicketManager getTicketManager(AppRuntime appRuntime) {
        return (TicketManager) appRuntime.getManager(2);
    }
}
