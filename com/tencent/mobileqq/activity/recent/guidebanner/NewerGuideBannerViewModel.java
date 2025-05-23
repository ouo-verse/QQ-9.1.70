package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.guidebanner.f;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewerGuideBannerViewModel extends com.tencent.mobileqq.mvvm.c<d> {
    static IPatchRedirector $redirector_;
    static ViewModelProvider.Factory E;
    private NewerGuideWebLaunchSuccessReceiver C;
    e D;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<com.tencent.mobileqq.activity.recent.guidebanner.a> f185582i;

    /* renamed from: m, reason: collision with root package name */
    private URLDrawable f185583m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f185588d;

        a(AppRuntime appRuntime) {
            this.f185588d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerViewModel.this, (Object) appRuntime);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
                return;
            }
            QLog.d("NewerGuideBannerViewModel", 1, "onLoadCanceled");
            NewerGuideBannerViewModel.this.X1(this.f185588d);
            uRLDrawable.setURLDrawableListener(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
                return;
            }
            QLog.d("NewerGuideBannerViewModel", 1, "onLoadFailed");
            NewerGuideBannerViewModel.this.X1(this.f185588d);
            uRLDrawable.setURLDrawableListener(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            QLog.d("NewerGuideBannerViewModel", 1, "onLoadSuccess");
            NewerGuideBannerViewModel.this.f185582i.setValue(com.tencent.mobileqq.activity.recent.guidebanner.a.a(NewerGuideBannerViewModel.this.f185583m, true));
            NewerGuideBannerViewModel.this.j2(this.f185588d);
            uRLDrawable.setURLDrawableListener(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            return new NewerGuideBannerViewModel(new d());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            E = new b();
        }
    }

    public NewerGuideBannerViewModel(d dVar) {
        super(dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        } else {
            this.f185582i = new MutableLiveData<>();
            this.D = e.f185602a;
        }
    }

    public static void Q1(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerViewModel", 2, "onNewerGuideBrowserActivityOnStart sourceFrom -> " + str);
        }
        if (TextUtils.equals(str, "NewerGuideBannerViewModel")) {
            BaseApplication.getContext().sendBroadcast(new Intent("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS"));
        }
    }

    private void R1(AppRuntime appRuntime) {
        QLog.d("NewerGuideBannerViewModel", 1, "doPreloadWebProcess");
        ThreadManagerV2.excute(new Runnable(appRuntime) { // from class: com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f185584d;

            {
                this.f185584d = appRuntime;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerViewModel.this, (Object) appRuntime);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((IWebProcessManagerService) this.f185584d.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(25, null);
                    NewerGuideBannerViewModel.this.D.c(this.f185584d.getCurrentAccountUin());
                }
            }
        }, 16, null, true);
    }

    private void S1(AppRuntime appRuntime, URLDrawable uRLDrawable) {
        uRLDrawable.setURLDrawableListener(new a(appRuntime));
        uRLDrawable.startDownload();
    }

    private void W1(QBaseActivity qBaseActivity, String str) {
        PermissionChecker.e(qBaseActivity, new Runnable(str, qBaseActivity) { // from class: com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f185585d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f185586e;

            {
                this.f185585d = str;
                this.f185586e = qBaseActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NewerGuideBannerViewModel.this, str, qBaseActivity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NewerGuideBannerViewModel", 2, "[onContactsWebJump] allow");
                }
                NewerGuideBannerViewModel.this.U1(this.f185586e, this.f185585d + "&ab_auth=1");
                NewerGuideBannerViewModel.this.q2(this.f185586e);
            }
        }, new Runnable() { // from class: com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerViewModel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    NewerGuideBannerViewModel.this.m2();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private boolean Z1(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("https://ti.qq.com/hybrid-h5/new_user_guide/index")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(AppRuntime appRuntime) {
        if (DeviceInfoUtils.isLowPerfDevice() || ((d) this.mRepository).l() != 0 || ((d) this.mRepository).p(appRuntime)) {
            return;
        }
        R1(appRuntime);
    }

    private void l2(int i3) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        f.b(new f.a().c("tianshu.251").f("tianshu.251").g(f.a(serverTimeMillis)).d(String.valueOf(((d) this.mRepository).j())).e(serverTimeMillis).h(((d) this.mRepository).n()).b(i3).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerViewModel", 2, "[onContactsWebJump] do not have permission");
        }
        this.f185582i.setValue(com.tencent.mobileqq.activity.recent.guidebanner.a.b());
    }

    private void p2(AppRuntime appRuntime, String str) {
        URLDrawable uRLDrawable = this.f185583m;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
        this.f185583m = drawable;
        boolean z16 = false;
        this.f185582i.setValue(com.tencent.mobileqq.activity.recent.guidebanner.a.a(drawable, false));
        int status = this.f185583m.getStatus();
        if (status == 1) {
            z16 = true;
        }
        if (!z16) {
            S1(appRuntime, this.f185583m);
        } else {
            this.f185582i.setValue(com.tencent.mobileqq.activity.recent.guidebanner.a.a(this.f185583m, true));
            j2(appRuntime);
        }
        QLog.d("NewerGuideBannerViewModel", 1, "updateUrlDrawableBg bgUrl: " + str + ", status: " + status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(QBaseActivity qBaseActivity) {
        ThreadManagerV2.excute(new Runnable(qBaseActivity) { // from class: com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f185587d;

            {
                this.f185587d = qBaseActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerViewModel.this, (Object) qBaseActivity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f185587d.getAppRuntime().getRuntimeService(IPhoneContactService.class, "");
                iPhoneContactService.uploadOrUpdateContact();
                iPhoneContactService.setNeedUploadResultTip(true);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableLiveData<com.tencent.mobileqq.activity.recent.guidebanner.a> T1() {
        return this.f185582i;
    }

    void U1(QBaseActivity qBaseActivity, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerViewModel", 2, "[onCommonWebJump] jump url: " + str);
        }
        if (str.startsWith("http") || str.startsWith("https")) {
            k2();
            ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).startBrowser(qBaseActivity, str, "NewerGuideBannerViewModel");
        }
    }

    void X1(AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerViewModel", 2, "hideNewerGuideBanner");
        }
        if (appRuntime != null) {
            ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).hideNewerGuideBanner(appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a2(QBaseActivity qBaseActivity) {
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        String m3 = ((d) this.mRepository).m();
        int l3 = ((d) this.mRepository).l();
        QLog.d("NewerGuideBannerViewModel", 1, "onBannerClick url -> " + m3 + ", jumpType -> " + l3);
        if (!TextUtils.isEmpty(m3)) {
            if (l3 != 0) {
                if (l3 != 1) {
                    if (l3 == 2) {
                        g2(qBaseActivity, m3);
                        b2(appRuntime);
                    }
                } else {
                    d2(qBaseActivity, m3);
                    b2(appRuntime);
                }
            } else {
                i2(qBaseActivity, m3);
            }
        }
        ReportController.o(appRuntime, "dc00898", "", "", "0X800B619", "0X800B619", ((d) this.mRepository).j(), 0, "", "", "", "");
        l2(102);
    }

    public void b2(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).getNewerGuideManager(appRuntime).c();
        this.D.d(appRuntime.getCurrentAccountUin());
        X1(appRuntime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c2(AppRuntime appRuntime) {
        QLog.d("NewerGuideBannerViewModel", 1, "onClickClose");
        b2(appRuntime);
        ReportController.o(appRuntime, "dc00898", "", "", "0X800B4EA", "0X800B4EA", ((d) this.mRepository).j(), 0, "", "", "", "");
        l2(122);
    }

    void d2(QBaseActivity qBaseActivity, String str) {
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qBaseActivity, str, 2016, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e2(QBaseActivity qBaseActivity) {
        QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] cancel");
        ReportController.o(qBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B4E8", "0X800B4E8", 1, 0, "", "", "", "");
        b2(qBaseActivity.getAppRuntime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f2(QBaseActivity qBaseActivity) {
        QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] confirm");
        ReportController.o(qBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B4E8", "0X800B4E8", 2, 0, "", "", "", "");
        U1(qBaseActivity, ((d) this.mRepository).m() + "&ab_auth=0");
    }

    void g2(QBaseActivity qBaseActivity, String str) {
        try {
            qBaseActivity.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str)));
        } catch (Throwable th5) {
            QLog.e("NewerGuideBannerViewModel", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h2(QBaseActivity qBaseActivity) {
        String k3 = ((d) this.mRepository).k();
        if (!TextUtils.isEmpty(k3)) {
            p2(qBaseActivity.getAppRuntime(), k3);
        }
        QLog.d("NewerGuideBannerViewModel", 1, "onThemeChange bgUrl: " + k3);
    }

    void i2(QBaseActivity qBaseActivity, String str) {
        if (Z1(str)) {
            W1(qBaseActivity, str);
        } else {
            U1(qBaseActivity, str);
        }
    }

    void k2() {
        if (this.C == null) {
            IntentFilter intentFilter = new IntentFilter("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS");
            this.C = new NewerGuideWebLaunchSuccessReceiver(this);
            BaseApplication.getContext().registerReceiver(this.C, intentFilter);
            this.f185582i.setValue(com.tencent.mobileqq.activity.recent.guidebanner.a.c(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n2() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideBannerViewModel", 2, "unRegisterReceiver");
        }
        if (this.C != null) {
            BaseApplication.getContext().unregisterReceiver(this.C);
            this.C = null;
        }
        this.f185582i.setValue(com.tencent.mobileqq.activity.recent.guidebanner.a.c(false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o2(QBaseActivity qBaseActivity, oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410) {
        ((d) this.mRepository).q(oidb_0x59f_guidelines_8410);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        String k3 = ((d) this.mRepository).k();
        QLog.d("NewerGuideBannerViewModel", 1, "update  bgUrl = " + k3);
        if (!TextUtils.isEmpty(k3)) {
            p2(appRuntime, k3);
            ReportController.o(appRuntime, "dc00898", "", "", "0X800B618", "0X800B618", ((d) this.mRepository).j(), 0, "", "", "", "");
            l2(101);
            return;
        }
        X1(appRuntime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCleared();
        URLDrawable uRLDrawable = this.f185583m;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
            this.f185583m = null;
        }
        n2();
    }
}
