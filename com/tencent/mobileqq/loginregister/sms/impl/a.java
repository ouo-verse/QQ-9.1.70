package com.tencent.mobileqq.loginregister.sms.impl;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.login.verify.t;
import com.tencent.mobileqq.login.z;
import com.tencent.mobileqq.loginregister.LoginVerifyReasonHelper;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.loginregister.sms.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f242936a;

    /* renamed from: b, reason: collision with root package name */
    private String f242937b;

    /* renamed from: c, reason: collision with root package name */
    private int f242938c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f242939d;

    /* renamed from: e, reason: collision with root package name */
    private z f242940e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f242941f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f242942g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f242943h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.loginregister.sms.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class DialogInterfaceOnClickListenerC7995a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f242944d;

        DialogInterfaceOnClickListenerC7995a(QBaseActivity qBaseActivity) {
            this.f242944d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            a.this.f242942g = true;
            a.this.p(this.f242944d, "0X800BB53");
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f242946d;

        b(QBaseActivity qBaseActivity) {
            this.f242946d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            a.this.p(this.f242946d, "0X800BB52");
            a.this.m(this.f242946d);
            a.this.f242942g = false;
            this.f242946d.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class c implements z {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QBaseActivity> f242948d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<com.tencent.mobileqq.loginregister.sms.c> f242949e;

        /* renamed from: f, reason: collision with root package name */
        private final String f242950f;

        /* renamed from: h, reason: collision with root package name */
        private com.tencent.mobileqq.loginregister.n f242951h;

        /* renamed from: i, reason: collision with root package name */
        private final WeakReference<a> f242952i;

        public c(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar, String str, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qBaseActivity, cVar, str, aVar);
                return;
            }
            this.f242948d = new WeakReference<>(qBaseActivity);
            this.f242949e = new WeakReference<>(cVar);
            this.f242950f = str;
            this.f242951h = new com.tencent.mobileqq.loginregister.n();
            this.f242952i = new WeakReference<>(aVar);
        }

        private void d(Bundle bundle, QBaseActivity qBaseActivity, ISmsVerifyCodeService iSmsVerifyCodeService, boolean z16) {
            Intent intent = new Intent();
            intent.putExtra("devlock_verify_result", true);
            intent.putExtra("devlock_verify_login_bundle", bundle);
            intent.putExtra("devlock_verify_is_login", z16);
            qBaseActivity.setResult(-1, intent);
            qBaseActivity.finish();
            this.f242951h.a(qBaseActivity.getAppRuntime(), qBaseActivity, this.f242950f, true);
            iSmsVerifyCodeService.handleLoginSmsVerifySuccess(qBaseActivity, intent.getExtras());
        }

        @Override // com.tencent.mobileqq.login.z
        public void a(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.i("AccountLoginDevVerifyApiImpl", 1, "onSmsVerifyLogin ret = " + i3 + " errMsg = " + str);
            QBaseActivity qBaseActivity = this.f242948d.get();
            com.tencent.mobileqq.loginregister.sms.c cVar = this.f242949e.get();
            if (c(qBaseActivity, cVar)) {
                QLog.w("AccountLoginDevVerifyApiImpl", 1, "onSmsVerifyLogin, context is invalid");
                return;
            }
            cVar.dismissDialog();
            ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) qBaseActivity.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
            if (i3 == 0) {
                a aVar = this.f242952i.get();
                if (aVar != null) {
                    aVar.o(qBaseActivity);
                }
                d(bundle, qBaseActivity, iSmsVerifyCodeService, true);
                return;
            }
            QLog.d("AccountLoginDevVerifyApiImpl", 2, "onRecvCheckSMSResult ret = " + i3 + " errMsg=" + str);
            if (i3 == 24) {
                d(bundle, qBaseActivity, iSmsVerifyCodeService, false);
                return;
            }
            cVar.clearWrongCode();
            if (!TextUtils.isEmpty(str)) {
                QQToast.makeText(qBaseActivity, 1, str, 1).show();
            } else {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.g0j), 1).show();
            }
            if (i3 == 9 || i3 == 155) {
                qBaseActivity.setResult(-1);
                qBaseActivity.finish();
                iSmsVerifyCodeService.handleSmsVerifyCodeCancel(qBaseActivity, null);
            }
        }

        @Override // com.tencent.mobileqq.login.z
        public void b(int i3, String str, DevlockInfo devlockInfo) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, devlockInfo);
                return;
            }
            QLog.i("AccountLoginDevVerifyApiImpl", 1, "onGetSmsVerifyCode ret = " + i3 + " errMsg = " + str);
            QBaseActivity qBaseActivity = this.f242948d.get();
            com.tencent.mobileqq.loginregister.sms.c cVar = this.f242949e.get();
            if (c(qBaseActivity, cVar)) {
                QLog.w("AccountLoginDevVerifyApiImpl", 1, "onGetSmsVerifyCode, context is invalid");
                return;
            }
            cVar.dismissDialog();
            if (i3 == 0) {
                if (devlockInfo == null || (i16 = devlockInfo.TimeLimit) <= 0) {
                    i16 = 60;
                }
                cVar.startTimer(i16);
                return;
            }
            if (i3 == 9 || i3 == 155) {
                ((ISmsVerifyCodeService) qBaseActivity.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all")).handleSmsVerifyCodeCancel(qBaseActivity, null);
                qBaseActivity.setResult(-1);
                qBaseActivity.finish();
            }
            if (!TextUtils.isEmpty(str)) {
                QQToast.makeText(qBaseActivity, 1, str, 1).show();
            } else {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.g0j), 1).show();
            }
        }

        public boolean c(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity, (Object) cVar)).booleanValue();
            }
            if (qBaseActivity != null && cVar != null) {
                return qBaseActivity.isFinishing();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d implements t.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QBaseActivity> f242953a;

        d(QBaseActivity qBaseActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
            } else {
                this.f242953a = new WeakReference<>(qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("AccountLoginDevVerifyApiImpl", 1, "WebAuxiliaryVerify onVerifyCancel");
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void b(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.d("AccountLoginDevVerifyApiImpl", 1, "WebAuxiliaryVerify onVerifySuccess");
            QBaseActivity qBaseActivity = this.f242953a.get();
            if (qBaseActivity == null) {
                QLog.w("AccountLoginDevVerifyApiImpl", 1, "WebAuxiliaryVerify onVerifySuccess activity is null");
            } else {
                ((ISmsVerifyCodeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all")).handleLoginSmsVerifySuccess(qBaseActivity, new Bundle());
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f242941f = false;
        this.f242942g = false;
        this.f242943h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(QBaseActivity qBaseActivity) {
        ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) qBaseActivity.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
        if (iSmsVerifyCodeService != null) {
            iSmsVerifyCodeService.handleSmsVerifyCodeCancel(qBaseActivity, new Bundle());
        }
    }

    private void n(QBaseActivity qBaseActivity, DevlockInfo devlockInfo, String str, boolean z16, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("subAccountUin", str);
        bundle.putBoolean("isSubaccount", z16);
        bundle.putBoolean("avoidLoginWeb", z16);
        bundle.putString("from_where", str2);
        String str3 = devlockInfo.OtherDevLockVerifyUrl;
        String g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g();
        if (!TextUtils.isEmpty(g16)) {
            str3 = DevLockVerifyComponent.h(str3, g16);
        }
        t.e(qBaseActivity, str3, bundle, this.f242938c, str, false, new d(qBaseActivity));
        p(qBaseActivity, "0X800C10B");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(QBaseActivity qBaseActivity) {
        if (this.f242942g) {
            p(qBaseActivity, "0X800BB54");
        }
        ILoginReporter iLoginReporter = (ILoginReporter) QRoute.api(ILoginReporter.class);
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", iLoginReporter.getLoginUinForReport(), "0X800BC48", "0X800BC48", iLoginReporter.getLoginEntranceForReport(), 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(QBaseActivity qBaseActivity, String str) {
        ILoginReporter iLoginReporter = (ILoginReporter) QRoute.api(ILoginReporter.class);
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", iLoginReporter.getLoginUinForReport(), str, str, iLoginReporter.getLoginEntranceForReport(), 0, "", "", "", "");
    }

    private void q(QBaseActivity qBaseActivity) {
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        String currentUin = appRuntime.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            currentUin = qBaseActivity.getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        }
        ReportController.r(appRuntime, "dc00898", "", currentUin, "0X800BB50", "0X800BB50", 0, 0, "", "", "", "");
        p(qBaseActivity, "0X800C10C");
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void a(QBaseActivity qBaseActivity, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qBaseActivity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean b(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity, (Object) cVar)).booleanValue();
        }
        QLog.i("AccountLoginDevVerifyApiImpl", 1, "sendSms");
        ILoginServletService iLoginServletService = (ILoginServletService) qBaseActivity.getAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        int i3 = this.f242936a;
        if (i3 != -1) {
            iLoginServletService.setDevLockMobileType(i3);
        }
        iLoginServletService.getDevLockSmsVerifyCode(this.f242937b, this.f242939d, this.f242940e);
        cVar.showLoadingDialog();
        this.f242943h = true;
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean c(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, qBaseActivity, cVar, str)).booleanValue();
        }
        QLog.i("AccountLoginDevVerifyApiImpl", 1, "submitSms smsCode=" + StringUtil.getSimpleUinForPrint(str));
        ((ILoginServletService) qBaseActivity.getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).devLockSmsVerifyLogin(this.f242938c, this.f242937b, str, this.f242939d, this.f242940e);
        cVar.showLoadingDialog();
        this.f242941f = true;
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void d(QBaseActivity qBaseActivity, long j3, com.tencent.mobileqq.loginregister.callback.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, qBaseActivity, Long.valueOf(j3), aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        DevlockInfo b16 = LoginVerifyReasonHelper.b(qBaseActivity);
        if (b16 == null) {
            aVar.onResult(null);
        } else {
            LoginVerifyReasonHelper.c(b16, 7, 1, aVar, j3);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void e(QBaseActivity qBaseActivity) {
        Bundle extras;
        DevlockInfo devlockInfo;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity);
            return;
        }
        QLog.d("AccountLoginDevVerifyApiImpl", 1, "startWebAuxiliaryVerify");
        Intent intent = qBaseActivity.getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            extras.getBoolean(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN);
            extras.getInt("seq");
            Object obj = extras.get(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO);
            if (obj instanceof DevlockInfo) {
                devlockInfo = (DevlockInfo) obj;
            } else {
                devlockInfo = null;
            }
            DevlockInfo devlockInfo2 = devlockInfo;
            if (devlockInfo2 == null) {
                return;
            }
            String string = extras.getString("uin");
            String string2 = extras.getString("from_where");
            String string3 = extras.getString("mainaccount");
            if (string3 != null && !string3.equals(string)) {
                z16 = true;
            } else {
                z16 = false;
            }
            n(qBaseActivity, devlockInfo2, string, z16, string2);
        } catch (Exception e16) {
            QLog.e("AccountLoginDevVerifyApiImpl", 1, "get devInfo error : ", e16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean f(QBaseActivity qBaseActivity, boolean z16, long j3) {
        boolean z17;
        String string;
        String string2;
        String string3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qBaseActivity, Boolean.valueOf(z16), Long.valueOf(j3))).booleanValue();
        }
        q(qBaseActivity);
        SmsVerifyBaseFragment.a aVar = (SmsVerifyBaseFragment.a) new ViewModelProvider(qBaseActivity).get(SmsVerifyBaseFragment.a.class);
        if (aVar != null && aVar.M1()) {
            QLog.i("AccountLoginDevVerifyApiImpl", 1, "already showBackDialog");
            return false;
        }
        if (!z16 && j3 == 0) {
            string = qBaseActivity.getString(R.string.f200294rq);
            string2 = qBaseActivity.getString(R.string.f200194rg);
            string3 = qBaseActivity.getString(R.string.f200394s0);
            z17 = true;
        } else {
            if (z16 && !this.f242941f) {
                z17 = true;
            } else {
                z17 = false;
            }
            string = qBaseActivity.getString(R.string.f211655le);
            string2 = qBaseActivity.getString(R.string.f212165ms);
            string3 = qBaseActivity.getString(R.string.f171898lr0);
        }
        if (!z17) {
            return false;
        }
        DialogUtil.createCustomDialog(qBaseActivity, 230, qBaseActivity.getString(R.string.f211675lg), string, string3, string2, new DialogInterfaceOnClickListenerC7995a(qBaseActivity), new b(qBaseActivity)).show();
        p(qBaseActivity, "0X800BB51");
        if (aVar != null) {
            aVar.O1(true);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean g(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qBaseActivity, (Object) cVar)).booleanValue();
        }
        if (this.f242943h) {
            str = "0X800C10A";
        } else {
            str = "0X800C109";
        }
        p(qBaseActivity, str);
        return b(qBaseActivity, cVar);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void h(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) cVar);
            return;
        }
        Intent intent = qBaseActivity.getIntent();
        if (intent == null) {
            QLog.d("AccountLoginDevVerifyApiImpl", 1, "sendSms, intent is null");
            return;
        }
        this.f242936a = intent.getIntExtra("mobile_type", -1);
        this.f242937b = intent.getStringExtra("uin");
        this.f242938c = intent.getIntExtra("account_login_type", 1);
        this.f242939d = intent.getBundleExtra("pass_through_param");
        this.f242940e = new c(qBaseActivity, cVar, this.f242937b, this);
        com.tencent.mobileqq.login.verify.a.a().b(qBaseActivity.getAppRuntime(), "0X800BC47");
        p(qBaseActivity, "0X800C108");
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
