package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.cx;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class JumpKidModeMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f290891a;

    /* renamed from: b, reason: collision with root package name */
    private int f290892b;

    /* renamed from: c, reason: collision with root package name */
    private int f290893c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f290894d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f290895e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f290896f;

    /* renamed from: g, reason: collision with root package name */
    private cx f290897g;

    /* renamed from: h, reason: collision with root package name */
    private KidModeObserver f290898h;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends cx {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpKidModeMgr.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        public void c(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SecSvcObserver", 2, "JumpKidModeMgr:onGetPhoneUnityInfo isSuccess: " + z16);
            }
            if (bundle != null) {
                String string = bundle.getString("phone");
                StudyModeManager.K(StringUtil.isEmpty(string) ? 1 : 0, string, bundle.getString("mibao_set_url"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends KidModeObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpKidModeMgr.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void c(KidModeObserver.QueryPasswordStateResult queryPasswordStateResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) queryPasswordStateResult);
                return;
            }
            if (queryPasswordStateResult == null) {
                QLog.i("KidModeObserver", 1, "JumpKidModeMgr:onQueryPasswordState result is null");
                return;
            }
            QLog.i("KidModeObserver", 1, "JumpKidModeMgr:onQueryPasswordState errCode=" + queryPasswordStateResult.errCode + ",State=" + queryPasswordStateResult.passwordState + ",salt=" + f.b(queryPasswordStateResult.salt));
            if (queryPasswordStateResult.errCode == 0) {
                StudyModeManager.N(queryPasswordStateResult.passwordState, queryPasswordStateResult.salt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final JumpKidModeMgr f290901a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75646);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f290901a = new JumpKidModeMgr();
            }
        }
    }

    public JumpKidModeMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290892b = -1;
        this.f290893c = -1;
        this.f290894d = false;
        this.f290895e = false;
        this.f290896f = false;
        this.f290897g = new a();
        this.f290898h = new b();
    }

    private void a(QQAppInterface qQAppInterface, int i3) {
        QQAppInterface e16 = e();
        if (e16 == null) {
            QLog.i("JumpKidModeMgr", 1, "checkToRegisterObserver curApp == null");
            return;
        }
        QLog.i("JumpKidModeMgr", 1, "checkToRegisterObserver, app=" + qQAppInterface + ", mApp=" + e16 + ", hasRegisterObserver=" + this.f290896f + ", src: " + i3);
        if (w(i3)) {
            if (!this.f290896f || qQAppInterface != e16) {
                qQAppInterface.addObserver(this.f290897g);
                qQAppInterface.registObserver(this.f290898h);
                this.f290896f = true;
            }
        }
    }

    public static JumpKidModeMgr b() {
        return c.f290901a;
    }

    private QQAppInterface e() {
        WeakReference<QQAppInterface> weakReference = this.f290891a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void j(int i3, int i16, int i17, int i18, int i19, int i26, Context context) {
        Intent intent = new Intent();
        intent.putExtra("ExtraTargetAction", i17);
        intent.putExtra("extra_target_mode", i3);
        intent.putExtra("extra_old_mode", i16);
        intent.putExtra("extra_source", i18);
        intent.putExtra("extra_source_for_report", i19);
        if (p.f(i18)) {
            if (context instanceof Activity) {
                QPublicFragmentActivity.startForResult((Activity) context, intent, (Class<? extends QPublicBaseFragment>) StudyPwdSetFragment.class, i26);
                return;
            } else {
                QPublicFragmentActivity.start(BaseApplicationImpl.getApplication(), intent, StudyPwdSetFragment.class);
                return;
            }
        }
        if (i17 == 1) {
            QPublicFragmentActivity.start(context, intent, StudyPwdSetFragment.class);
        } else {
            QPublicFragmentActivity.startForResult((Activity) context, intent, (Class<? extends QPublicBaseFragment>) StudyPwdSetFragment.class, 2);
        }
    }

    private void n(int i3, int i16, int i17, int i18, int i19, int i26, Context context) {
        Intent intent = new Intent();
        intent.putExtra("ExtraTargetAction", i17);
        intent.putExtra("extra_target_mode", i3);
        intent.putExtra("extra_old_mode", i16);
        intent.putExtra("extra_source", i18);
        intent.putExtra("extra_source_for_report", i19);
        if (p.f(i18)) {
            if (context instanceof Activity) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyPwdVerifyFragment((Activity) context, intent, Integer.valueOf(i26));
                return;
            } else {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyPwdVerifyFragment(context, intent, null);
                return;
            }
        }
        if (i17 == 1) {
            if (i26 != -1 && (context instanceof Activity)) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyPwdVerifyFragment((Activity) context, intent, Integer.valueOf(i26));
                return;
            } else {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyPwdVerifyFragment(context, intent, null);
                return;
            }
        }
        ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyPwdVerifyFragment((Activity) context, intent, 2);
    }

    private void o(int i3, int i16, int i17, int i18, int i19, int i26, Context context) {
        Intent intent = new Intent();
        intent.putExtra("ExtraTargetAction", i17);
        intent.putExtra("extra_target_mode", i3);
        intent.putExtra("extra_old_mode", i16);
        intent.putExtra("extra_source", i18);
        intent.putExtra("extra_source_for_report", i19);
        intent.putExtra("FIRST_TIME_RES", -1);
        if (p.f(i18)) {
            if (context instanceof Activity) {
                PublicFragmentActivity.startForResult((Activity) context, intent, KidModeVerifyFragment.class, i26);
                return;
            } else {
                PublicFragmentActivity.start(BaseApplicationImpl.getApplication(), intent, KidModeVerifyFragment.class);
                return;
            }
        }
        if (i17 == 1) {
            PublicFragmentActivity.start(context, intent, KidModeVerifyFragment.class);
        } else {
            PublicFragmentActivity.startForResult((Activity) context, intent, KidModeVerifyFragment.class, 2);
        }
    }

    private void s() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.studymode.JumpKidModeMgr.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpKidModeMgr.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 0, R.string.f2051154q, 0).show();
                }
            }
        });
    }

    private void v() {
        QQAppInterface e16 = e();
        if (e16 == null) {
            QLog.i("JumpKidModeMgr", 1, "pullPhoneVerifyStatus app == null");
            return;
        }
        SecSvcHandler secSvcHandler = (SecSvcHandler) e16.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null) {
            secSvcHandler.G2(3);
        }
        KidModeServlet.n(e16);
    }

    private boolean w(int i3) {
        if (!p.g(i3) && !p.f(i3)) {
            return false;
        }
        return true;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f290892b;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f290893c;
    }

    public boolean f(int i3, int i16, QQAppInterface qQAppInterface, Activity activity, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), qQAppInterface, activity, Integer.valueOf(i17))).booleanValue();
        }
        return g(i3, i16, qQAppInterface, activity, i17, -1);
    }

    public boolean g(int i3, int i16, QQAppInterface qQAppInterface, Activity activity, int i17, int i18) {
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), qQAppInterface, activity, Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
        }
        this.f290892b = i16;
        this.f290893c = i3;
        if (i3 == 2) {
            i19 = 2;
        } else {
            i19 = 3;
        }
        return m(i3, i16, i19, qQAppInterface, activity, i17, i18, -1);
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f290894d;
    }

    public void i(int i3, int i16, Activity activity, int i17, int i18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), activity, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_target_mode", i3);
        intent.putExtra("extra_old_mode", i16);
        intent.putExtra("extra_source", i17);
        intent.putExtra("extra_source_for_report", i18);
        intent.putExtra("extra_to_adv_setting_need_pwd", z16);
        if (i3 == 2) {
            ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyModeOpenFragmentForResult(activity, intent, 4);
        } else {
            ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startStudyModeCloseFragmentForResult(activity, intent, 4);
        }
    }

    public boolean k(int i3, int i16, int i17, QQAppInterface qQAppInterface, int i18, Activity activity, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), qQAppInterface, Integer.valueOf(i18), activity, Integer.valueOf(i19))).booleanValue();
        }
        return m(i3, i16, i17, qQAppInterface, activity, i19, -1, i18);
    }

    public boolean l(int i3, int i16, int i17, QQAppInterface qQAppInterface, Activity activity, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), qQAppInterface, activity, Integer.valueOf(i18))).booleanValue();
        }
        return m(i3, i16, i17, qQAppInterface, activity, i18, -1, -1);
    }

    boolean m(int i3, int i16, int i17, QQAppInterface qQAppInterface, Activity activity, int i18, int i19, int i26) {
        if (!AppNetConnInfo.isNetSupport()) {
            QLog.i("JumpKidModeMgr", 1, "jumpToKidModelVerify action=" + i17);
            return false;
        }
        a(qQAppInterface, i18);
        this.f290891a = new WeakReference<>(qQAppInterface);
        this.f290895e = true;
        this.f290894d = false;
        int g16 = StudyModeManager.g();
        int j3 = StudyModeManager.j();
        int l3 = StudyModeManager.l();
        QLog.i("JumpKidModeMgr", 1, "jumpToKidModelVerify action=" + i17 + ",bindBindPhone=" + g16 + ",kidModeNeedVerifyPhone=" + j3 + ",kidModePasswordState=" + l3 + ", hasRegister: " + this.f290896f);
        if (l3 == 1) {
            if (g16 != -1 && j3 != -1) {
                if (g16 == 0 && j3 == 1) {
                    o(i3, i16, i17, i18, i19, i26, activity);
                } else {
                    j(i3, i16, i17, i18, i19, i26, activity);
                }
                return true;
            }
            v();
            return false;
        }
        if (l3 == 3) {
            j(i3, i16, i17, i18, i19, i26, activity);
            return true;
        }
        if (l3 == 2) {
            n(i3, i16, i17, i18, i19, i26, activity);
            this.f290894d = true;
            return true;
        }
        KidModeServlet.m(qQAppInterface);
        return false;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return u(null, -1, 6);
    }

    public boolean q(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity)).booleanValue();
        }
        return u(activity, -1, 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f290895e;
    }

    public boolean t(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity, i3)).booleanValue();
        }
        if (g.a() == 2) {
            QLog.d("JumpKidModeMgr", 2, "cur already is studymode");
            return false;
        }
        x(activity, i3);
        return true;
    }

    public boolean u(Activity activity, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, activity, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return false;
        }
        boolean k3 = k(-1, -1, p.c(i16), (QQAppInterface) peekAppRuntime, i3, activity, i16);
        if (!k3) {
            s();
        }
        return k3;
    }

    public void x(Activity activity, int i3) {
        boolean z16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, i3);
            return;
        }
        int a16 = g.a();
        int i17 = 0;
        if (a16 == 2) {
            int n3 = StudyModeManager.n();
            if (n3 != -1) {
                i17 = n3;
            }
            i16 = i17;
            z16 = true;
        } else {
            z16 = false;
            i16 = 2;
        }
        b().i(i16, a16, activity, i3, p.d(i3), z16);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            a(qQAppInterface, i3);
            this.f290891a = new WeakReference<>(qQAppInterface);
            int l3 = StudyModeManager.l();
            if (l3 != 1 && l3 != 3 && l3 != 2) {
                KidModeServlet.m(qQAppInterface);
            }
            int g16 = StudyModeManager.g();
            int j3 = StudyModeManager.j();
            if (l3 == 1 && (g16 == -1 || j3 == -1)) {
                v();
            }
            QLog.i("JumpKidModeMgr", 1, "open studymode from source:" + i3 + ", bindBindPhone=" + g16 + ",kidModeNeedVerifyPhone=" + j3 + ",kidModePasswordState=" + l3 + ", hasRegister: " + this.f290896f);
        }
    }
}
