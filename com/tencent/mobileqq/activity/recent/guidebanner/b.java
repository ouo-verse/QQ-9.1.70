package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f185595d;

    /* renamed from: e, reason: collision with root package name */
    c f185596e;

    /* renamed from: f, reason: collision with root package name */
    private oidb_0x59f$Guidelines_8410 f185597f;

    /* renamed from: h, reason: collision with root package name */
    e f185598h;

    public b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f185598h = e.f185602a;
        this.f185595d = appInterface;
        c cVar = new c(appInterface);
        this.f185596e = cVar;
        appInterface.addObserver(cVar);
    }

    void a() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerManager", 2, "hideNewerGuideBanner");
        }
        if (this.f185595d != null) {
            ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).hideNewerGuideBanner(this.f185595d);
        }
    }

    boolean b(oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410) {
        boolean z16 = false;
        if (oidb_0x59f_guidelines_8410 == null || this.f185595d == null) {
            return false;
        }
        int i3 = oidb_0x59f_guidelines_8410.uint32_banner_status.get();
        QLog.d("NewerGuideBannerManager", 1, "isNeedShow flag = " + i3);
        if (i3 == 0) {
            return false;
        }
        String currentAccountUin = this.f185595d.getCurrentAccountUin();
        if (i3 == 2) {
            this.f185598h.e(currentAccountUin);
            return true;
        }
        long a16 = this.f185598h.a(currentAccountUin);
        if (a16 <= 0) {
            z16 = true;
        }
        QLog.d("NewerGuideBannerManager", 1, "isNeedShow closeTime = " + a16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = this.f185597f;
        if (oidb_0x59f_guidelines_8410 != null && oidb_0x59f_guidelines_8410.uint32_banner_status.has() && this.f185597f.uint32_banner_status.get() == 2) {
            this.f185597f.uint32_banner_status.set(1);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f185595d != null) {
            ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).getNewerGuideHandler(this.f185595d).E2();
        }
    }

    void e() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBanner called");
        }
        if (this.f185595d != null && this.f185597f != null) {
            ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).showNewerGuideBanner(this.f185595d, this.f185597f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410) {
        this.f185597f = oidb_0x59f_guidelines_8410;
        boolean b16 = b(oidb_0x59f_guidelines_8410);
        QLog.d("NewerGuideBannerManager", 1, "showNewerGuideBannerIfNeed needShow -> " + b16);
        if (!b16) {
            a();
        } else {
            e();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerManager", 2, "onDestroy, instance manager -> " + this);
        }
        AppInterface appInterface = this.f185595d;
        if (appInterface != null) {
            appInterface.removeObserver(this.f185596e);
            this.f185595d = null;
        }
        this.f185596e = null;
        this.f185597f = null;
    }
}
