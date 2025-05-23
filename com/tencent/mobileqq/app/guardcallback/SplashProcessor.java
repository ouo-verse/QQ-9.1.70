package com.tencent.mobileqq.app.guardcallback;

import android.os.Build;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.dd;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashEmptyReportHelper;
import com.tencent.mobileqq.splashad.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class SplashProcessor implements IGuardInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static String f195662d;

    /* renamed from: e, reason: collision with root package name */
    private static long f195663e;

    /* renamed from: f, reason: collision with root package name */
    private static final Runnable f195664f;

    /* renamed from: h, reason: collision with root package name */
    private static final Runnable f195665h;

    /* renamed from: i, reason: collision with root package name */
    private static final Runnable f195666i;

    /* renamed from: m, reason: collision with root package name */
    private static final Runnable f195667m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f195662d = "setsplash";
        f195663e = -1L;
        f195664f = new Runnable() { // from class: com.tencent.mobileqq.app.guardcallback.e
            @Override // java.lang.Runnable
            public final void run() {
                SplashProcessor.g();
            }
        };
        f195665h = new Runnable() { // from class: com.tencent.mobileqq.app.guardcallback.f
            @Override // java.lang.Runnable
            public final void run() {
                SplashProcessor.h();
            }
        };
        f195666i = new Runnable() { // from class: com.tencent.mobileqq.app.guardcallback.SplashProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 <= 23) {
                    QLog.e(SplashProcessor.f195662d, 1, "device limit, cancel FgPreloadAmsAdTask, Build.VERSION.SDK_INT:" + i3);
                    return;
                }
                if (!GuardManager.sInstance.isApplicationForeground()) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316008);
                    QLog.e(SplashProcessor.f195662d, 1, "app on bg, cancel FgPreloadAmsAdTask");
                } else if (((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).needSkipPreload()) {
                    QLog.e(SplashProcessor.f195662d, 1, "show time check skip cancel FgPreloadAmsAdTask");
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316009);
                } else if (((IGdtAPI) QRoute.api(IGdtAPI.class)).needCancelSplashFgPreload()) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(13160010);
                    QLog.e(SplashProcessor.f195662d, 1, "time over load, cancel FgPreloadAmsAdTask");
                } else {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).fgSplashPreload();
                    ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateSplashFgPreload();
                }
            }
        };
        f195667m = new Runnable() { // from class: com.tencent.mobileqq.app.guardcallback.SplashProcessor.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!((IGdtAPI) QRoute.api(IGdtAPI.class)).getCanHotSplash() && QLog.isColorLevel()) {
                    QLog.d(SplashProcessor.f195662d, 1, "switch closed, cancel hotSplash CheckTask");
                    return;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 <= 23) {
                    QLog.e(SplashProcessor.f195662d, 1, "device limit, cancel hotSplash CheckTask, Build.VERSION.SDK_INT:" + i3);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - SplashProcessor.f195663e;
                q qVar = q.f288880a;
                boolean d16 = qVar.d(2);
                if (currentTimeMillis < ((IGdtAPI) QRoute.api(IGdtAPI.class)).getHotSplashLimit()) {
                    return;
                }
                if (!d16 || !qVar.c(2)) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).onEmptyHotSplash();
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateSplashEmptyOrderParams(true, true, 1003);
                    SplashEmptyReportHelper.f288736a.b();
                }
            }
        };
    }

    public SplashProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void e() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (!(qBaseActivity instanceof SplashActivity)) {
            return;
        }
        qBaseActivity.finish();
        QLog.d("SplashController", 1, "finish splashActivity ");
    }

    private void f(long j3) {
        GuardManager guardManager;
        if (j3 != 1 || (guardManager = GuardManager.sInstance) == null) {
            return;
        }
        if (!((IGdtAPI) QRoute.api(IGdtAPI.class)).getCanHotSplash() && QLog.isColorLevel()) {
            QLog.d(f195662d, 1, "switch closed, cancel hotSplash check");
            return;
        }
        if (guardManager.mFgProcess == null) {
            long b16 = q.f288880a.b();
            if (b16 == Long.MAX_VALUE) {
                QLog.d(f195662d, 1, "no valid splash, cancel hotSplash check");
                return;
            }
            long j16 = b16 * 1000;
            long hotSplashLimit = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getHotSplashLimit();
            if (j16 < hotSplashLimit) {
                j16 = hotSplashLimit;
            }
            QLog.d(f195662d, 1, "delayTime is " + j16);
            ThreadManagerV2.getUIHandlerV2().postDelayed(f195664f, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g() {
        if (!q.f288880a.e(false)) {
            QLog.d(f195662d, 1, "needStartHotSplash false, cancel finish");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f195662d, 2, "needshowsplashtoday , set warm splash");
        }
        ReportController.r(null, "CliOper", "", "", "0X800483B", "0X800483B", 2, 0, "", "", "", "");
        dd.l(true);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h() {
        if (!((IGdtAPI) QRoute.api(IGdtAPI.class)).getCanHotAmsSplash()) {
            if (QLog.isColorLevel()) {
                QLog.d(f195662d, 1, "switch close, cancel refreshHotGdtSplashData");
                return;
            }
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 23) {
            QLog.e(f195662d, 1, "device limit, cancel BgPreloadAmsAdTask Build.VERSION.SDK_INT:" + i3);
            return;
        }
        if (GuardManager.sInstance.isApplicationForeground()) {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316004);
            QLog.d(f195662d, 1, "onforeground, cancel BgPreloadAmsAdTask");
        } else if (((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).needSkipPreload()) {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316005);
            QLog.d(f195662d, 1, "show time skip, cancel BgPreloadAmsAdTask");
        } else if (((IGdtAPI) QRoute.api(IGdtAPI.class)).needCancelHotSplashBgPreload()) {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316006);
            QLog.d(f195662d, 1, "time over load, cancel BgPreloadAmsAdTask");
        } else {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).bgSplashPreload(((IGdtAPI) QRoute.api(IGdtAPI.class)).isHotSplashBgPreloadTimeLimit());
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateHotSplashBgPreload();
        }
    }

    private void i() {
        ThreadManagerV2.excute(f195665h, 128, null, false);
    }

    private void j() {
        if (!((IGdtAPI) QRoute.api(IGdtAPI.class)).getCanHotAmsSplash()) {
            if (QLog.isColorLevel()) {
                QLog.d(f195662d, 1, "switch close, cancel refreshHotGdtSplashData");
            }
        } else {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316007);
            ThreadManagerV2.executeDelay(f195666i, 128, null, false, ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPredownloadDelayTime());
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f195663e = System.currentTimeMillis();
        dd.l(false);
        q qVar = q.f288880a;
        qVar.a();
        ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).clearHotSplashCache();
        qVar.f(1, com.tencent.mobileqq.splashad.h.f288777a.a());
        i();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (f195663e == -1) {
            if (QLog.isColorLevel()) {
                QLog.d(f195662d, 1, "login fg, cancel preload");
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(f195664f);
            ThreadManagerV2.removeJob(f195665h, 128);
            j();
            ThreadManagerV2.excute(f195667m, 128, null, false);
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).checkScheduleDownloadTask(2);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            f(j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }
}
