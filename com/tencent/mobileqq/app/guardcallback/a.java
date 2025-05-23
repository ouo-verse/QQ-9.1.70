package com.tencent.mobileqq.app.guardcallback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements IGuardInterface {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        if (qQAppInterface != null && qQAppInterface.isRunning()) {
            qQAppInterface.showIdleNotification(BaseApplicationImpl.sApplication, null);
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).setAppOnForeground(qQAppInterface, false);
        BackgroundProbeManager.e();
        if (qQAppInterface != null) {
            BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(1, 0L, 0L);
        }
        BackgroundAliveTimeStatistic.c();
        com.tencent.mobileqq.qmethodmonitor.a.c(BaseApplication.getContext());
        com.tencent.mobileqq.power.c cVar = com.tencent.mobileqq.power.c.f259407a;
        cVar.e(BaseApplication.getContext());
        cVar.f();
        com.tencent.mobileqq.perf.process.backgroud.audio.b.f257817d.e();
        h.c().i();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DarkModeManager.u(null);
        PerfReportUtil.f();
        BackgroundAliveTimeStatistic.a();
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).setAppOnForeground((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), true);
        com.tencent.mobileqq.qmethodmonitor.a.d(BaseApplication.getContext());
        com.tencent.mobileqq.power.c.f259407a.g();
        com.tencent.mobileqq.perf.process.backgroud.audio.b.f257817d.f();
        h.c().j();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            BackgroundAliveTimeStatistic.b();
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        int i3 = GuardManager.SUICIDE_FACTOR;
        if ((j3 == (i3 * 50) - 1 || j3 == i3 * 50) && GuardManager.sInstance.mFgProcess == null) {
            QLog.w("GuardManager.CommonProcessor", 1, "Main Process would be killed at next tick");
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
