package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadManagerInitialler implements ThreadWrapContext {
    static IPatchRedirector $redirector_;
    private static boolean sFlagInited;
    private static volatile boolean sShotChanceForPublicVersion;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            sFlagInited = false;
            sShotChanceForPublicVersion = false;
        }
    }

    public ThreadManagerInitialler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void initShotChanceForPublicVersion(long j3) {
        if (!sFlagInited && MobileQQ.sProcessId == 1) {
            sFlagInited = true;
            if (QLog.isColorLevel()) {
                QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|chance " + j3);
            }
            if (j3 > 0) {
                sShotChanceForPublicVersion = JobReporter.ramdomReport((int) j3);
                if (QLog.isColorLevel()) {
                    QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|sShotChanceForPublicVersion " + sShotChanceForPublicVersion);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void d(String str, int i3, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), str2, th5);
        } else {
            QLog.d(str, i3, str2, th5);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public int getFdCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return com.tencent.qqperf.tools.e.a();
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public long getMainProccessThreadMonitorTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return ea.v0();
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public long getMainProccessThreadPeakCounts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return ea.w0();
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return QLog.isColorLevel();
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public boolean isShotReportRejectedError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return sShotChanceForPublicVersion;
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void registerApplicationStatus(cb cbVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) cbVar);
        } else {
            GuardManagerCallbackDispatcher.registerCallBack(new IGuardInterface(cbVar) { // from class: com.tencent.mobileqq.app.ThreadManagerInitialler.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ cb val$listener;

                {
                    this.val$listener = cbVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThreadManagerInitialler.this, (Object) cbVar);
                    }
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onApplicationBackground() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    } else {
                        this.val$listener.onApplicationBackground();
                    }
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onApplicationForeground() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.val$listener.onApplicationForeground();
                    }
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onBackgroundTimeTick(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, j3);
                    }
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onBackgroundUnguardTimeTick(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                        iPatchRedirector2.redirect((short) 7, (Object) this, j3);
                    }
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onLiteTimeTick(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, (Object) this, j3);
                    }
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onScreensStateChanged(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void reportBeacon(String str, Map<String, String> map) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) map);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        } else {
            str2 = "0";
        }
        QQBeaconReport.report(str2, str, map);
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void reportDengTaException(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3, Boolean.valueOf(z17));
        } else {
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, str2, z16, j3, j16, hashMap, str3, z17);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void reportRDMException(Throwable th5, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, th5, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void setMainProccessThreadMonitorTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            ea.V2(j3);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public void setMainProccessThreadPeakCounts(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            ea.W2(j3);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadWrapContext
    public int threadMonitorReportSample() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        com.tencent.mobileqq.config.au auVar = (com.tencent.mobileqq.config.au) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101595");
        if (auVar != null) {
            return auVar.f202340e;
        }
        return 10000;
    }
}
