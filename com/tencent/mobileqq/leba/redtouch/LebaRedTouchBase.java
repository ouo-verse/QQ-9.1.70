package com.tencent.mobileqq.leba.redtouch;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.business.h;
import com.tencent.mobileqq.leba.core.e;
import com.tencent.mobileqq.leba.entity.g;
import com.tencent.mobileqq.leba.entity.p;
import com.tencent.mobileqq.leba.l;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class LebaRedTouchBase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected HashSet<Long> f240732a;

    /* renamed from: b, reason: collision with root package name */
    protected Map<Long, g> f240733b;

    /* renamed from: c, reason: collision with root package name */
    protected h f240734c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f240735d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f240736e;

    public LebaRedTouchBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240732a = new HashSet<>();
        this.f240733b = new HashMap();
        this.f240734c = new h();
        this.f240735d = true;
        this.f240736e = new AtomicBoolean(false);
        e();
    }

    private void b(AppRuntime appRuntime, long j3, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        if (!this.f240732a.contains(Long.valueOf(j3)) && appInfo != null && appInfo.iNewFlag.get() != 0) {
            this.f240732a.add(Long.valueOf(j3));
            a.f240739a.c(appInfo, 30, false);
            if (j3 == 489) {
                ThreadManagerV2.excute(new Runnable(appInfo, z16) { // from class: com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f240737d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ boolean f240738e;

                    {
                        this.f240737d = appInfo;
                        this.f240738e = z16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, LebaRedTouchBase.this, appInfo, Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).reportExposureForCommonVersion(this.f240737d, this.f240738e, LebaPluginLogic.e());
                        }
                    }
                }, 16, null, false);
            }
        }
    }

    private void i(long j3, RedTouch redTouch) {
        int b16 = l.b(redTouch);
        if (b16 != 0) {
            this.f240733b.put(Long.valueOf(j3), new g(b16, l.a(redTouch)));
        }
    }

    public void a(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) pVar);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Q.lebatab.LebaRedTouchBase", 1, "updateRedTouch appRuntime = null");
        } else {
            long j3 = pVar.f240523d;
            b(peekAppRuntime, j3, c(peekAppRuntime, String.valueOf(j3)), pVar.f240526g);
        }
    }

    public abstract BusinessInfoCheckUpdate.AppInfo c(AppRuntime appRuntime, String str);

    public abstract void d(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo);

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f240734c.b();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f240736e.compareAndSet(false, true)) {
            this.f240735d = new com.tencent.mobileqq.leba.config.a().a();
        }
        if (g().booleanValue()) {
            this.f240735d = false;
        }
    }

    public Boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Boolean) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Boolean.valueOf(TianshuRedTouch.INSTANCE.j());
    }

    public void h(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            return;
        }
        if (!this.f240732a.isEmpty()) {
            try {
                e.f240372e |= 2;
                QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause update" + e.f240372e);
                ((IRedTouchServer) appRuntime.getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
            } catch (Exception e16) {
                QLog.i("Q.lebatab.LebaRedTouchBase", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, e16);
            }
        }
        this.f240732a.clear();
        this.f240733b.clear();
    }

    public void j(p pVar, LebaPluginProxy lebaPluginProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pVar, (Object) lebaPluginProxy);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Q.lebatab.LebaRedTouchBase", 1, "updateRedTouch appRuntime = null");
            return;
        }
        Context context = pVar.f240520a;
        LebaRedTouch lebaRedTouch = pVar.f240522c;
        long j3 = pVar.f240523d;
        String str = pVar.f240524e;
        int i3 = pVar.f240525f;
        boolean z16 = pVar.f240526g;
        String.valueOf(j3);
        lebaPluginProxy.h(peekAppRuntime, context, j3, lebaRedTouch, str, this.f240733b, i3, z16);
    }

    public void k(p pVar) {
        String str;
        RedTouch redTouch;
        LebaRedTouch lebaRedTouch;
        String str2;
        char c16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pVar);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Q.lebatab.LebaRedTouchBase", 1, "updateRedTouch appRuntime = null");
            return;
        }
        Context context = pVar.f240520a;
        RedTouch redTouch2 = pVar.f240521b;
        LebaRedTouch lebaRedTouch2 = pVar.f240522c;
        long j3 = pVar.f240523d;
        String str3 = pVar.f240524e;
        int i3 = pVar.f240525f;
        boolean z17 = pVar.f240526g;
        BusinessInfoCheckUpdate.AppInfo c17 = c(peekAppRuntime, String.valueOf(j3));
        b(peekAppRuntime, j3, c17, pVar.f240526g);
        f();
        if (this.f240735d) {
            str = str3;
            redTouch = redTouch2;
            lebaRedTouch = lebaRedTouch2;
            str2 = "Q.lebatab.LebaRedTouchBase";
            c16 = 1;
            z16 = this.f240734c.a(peekAppRuntime, context, j3, redTouch, str, this.f240733b, i3, z17);
        } else {
            str = str3;
            redTouch = redTouch2;
            lebaRedTouch = lebaRedTouch2;
            str2 = "Q.lebatab.LebaRedTouchBase";
            c16 = 1;
            z16 = false;
        }
        Object[] objArr = new Object[8];
        objArr[0] = "updateRedTouch,resID=";
        objArr[c16] = Long.valueOf(j3);
        objArr[2] = ",resPkgName=";
        objArr[3] = str;
        objArr[4] = ",isHandledRedTouch=";
        objArr[5] = Boolean.valueOf(z16);
        objArr[6] = ",leba_red_touch_spcific_enable->mSpecificEnable=";
        objArr[7] = Boolean.valueOf(this.f240735d);
        QLog.d(str2, 4, objArr);
        if (!z16) {
            if (g().booleanValue()) {
                if (lebaRedTouch != null) {
                    lebaRedTouch.I0(pVar);
                }
            } else {
                d(redTouch, c17);
                i(j3, redTouch);
            }
        }
    }

    public void l(p pVar, LebaPluginProxy lebaPluginProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pVar, (Object) lebaPluginProxy);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Q.lebatab.LebaRedTouchBase", 1, "updateRedTouch appRuntime = null");
            return;
        }
        Context context = pVar.f240520a;
        RedTouch redTouch = pVar.f240521b;
        long j3 = pVar.f240523d;
        String str = pVar.f240524e;
        int i3 = pVar.f240525f;
        boolean z16 = pVar.f240526g;
        BusinessInfoCheckUpdate.AppInfo c16 = c(peekAppRuntime, String.valueOf(j3));
        b(peekAppRuntime, j3, c16, pVar.f240526g);
        boolean i16 = lebaPluginProxy.i(peekAppRuntime, context, j3, redTouch, str, this.f240733b, i3, z16);
        QLog.d("Q.lebatab.LebaRedTouchBase", 4, "updateRedTouch,resID=", Long.valueOf(j3), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(i16), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.f240735d));
        if (!i16) {
            d(redTouch, c16);
            i(j3, redTouch);
        }
    }
}
