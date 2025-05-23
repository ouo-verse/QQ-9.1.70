package com.tencent.rmonitor.base.config.data;

import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.launch.AppLaunchInstallerImpl;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b {
    private void b(a aVar) {
        try {
            if (aVar.b()) {
                AppLaunchInstallerImpl.getInstance().setProtectCheckEnabled(true);
            } else {
                AppLaunchInstallerImpl.getInstance().setProtectCheckEnabled(false);
            }
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_config", "AppLaunchSampler, parseLaunchConfigInfo, t: " + th5);
        }
    }

    private void c(a aVar) {
        try {
            AppLaunchInstallerImpl appLaunchInstallerImpl = AppLaunchInstallerImpl.getInstance();
            if (aVar.enabled) {
                if (aVar.b() && appLaunchInstallerImpl.checkLastLauncherUnsafe()) {
                    appLaunchInstallerImpl.setLaunchMonitorEnabled(false);
                    return;
                }
                if (aVar.b()) {
                    appLaunchInstallerImpl.setLauncherSafe(false);
                }
                appLaunchInstallerImpl.setLaunchMonitorEnabled(true);
                return;
            }
            appLaunchInstallerImpl.setLaunchMonitorEnabled(false);
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_config", "AppLaunchSampler, scheduleNextLaunchMonitor, t: " + th5);
        }
    }

    public void a(a aVar) {
        b(aVar);
        c(aVar);
    }
}
