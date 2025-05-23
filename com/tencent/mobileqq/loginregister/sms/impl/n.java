package com.tencent.mobileqq.loginregister.sms.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.servlet.IRegisterServletService;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.register.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n implements com.tencent.mobileqq.loginregister.sms.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QBaseActivity f243023a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.sms.c f243024b;

    /* renamed from: c, reason: collision with root package name */
    public String f243025c;

    /* renamed from: d, reason: collision with root package name */
    public String f243026d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f243027e;

    /* renamed from: f, reason: collision with root package name */
    public int f243028f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f243029g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f243030h;

    /* renamed from: i, reason: collision with root package name */
    private int f243031i;

    /* renamed from: j, reason: collision with root package name */
    private String f243032j;

    /* renamed from: k, reason: collision with root package name */
    private int f243033k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.servlet.d f243034l;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.loginregister.servlet.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.d
        public void f(boolean z16, int i3, String str, String str2, String str3, byte[] bArr, String str4) {
            String str5;
            String str6;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, bArr, str4);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_SmsVerifyComponent.RegisterVerifyCodeApiImpl", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp isSuccess=" + z16 + ",code=" + i3);
            }
            if (n.this.f243023a.isFinishing()) {
                return;
            }
            AppRuntime appRuntime = n.this.f243023a.getAppRuntime();
            n.this.f243024b.dismissDialog();
            try {
                str5 = new String(bArr, "utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                str5 = null;
            }
            String str7 = str5;
            String num = Integer.toString(i3);
            if (str7 == null) {
                str6 = "";
            } else {
                str6 = str7;
            }
            ReportController.u(appRuntime, "new_reg", "msg_page", "next_clk", "", 1, "", num, "2", str6, "", "", "", "", "");
            if (z16 && i3 == 0) {
                String str8 = n.this.f243032j;
                if (str8 != null) {
                    str8 = str8.trim();
                }
                ((ISmsVerifyCodeService) appRuntime.getRuntimeService(ISmsVerifyCodeService.class, "all")).handleRegisterVerifySuccess(n.this.f243023a, str8, str4);
                ReportController.r(appRuntime, "dc00898", "", "", "0X800B609", "0X800B609", 0, 0, "", "", n.this.f243023a.getIntent().getStringExtra(AppConstants.Key.PHONENUM), "");
                if (QLog.isColorLevel()) {
                    QLog.d("Login_Optimize_SmsVerifyComponent.RegisterVerifyCodeApiImpl", 2, "onRegisterCommitSmsCodeResp code=" + i3 + " ,uin=" + str + " ,nick=" + str2 + " ,faceUrl=" + str3);
                }
                n.this.f243023a.finish();
                return;
            }
            if (TextUtils.isEmpty(str7)) {
                str7 = n.this.f243023a.getString(R.string.g0j);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_SmsVerifyComponent.RegisterVerifyCodeApiImpl", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp error=" + str7);
            }
            n.this.f243024b.clearWrongCode();
            n.this.r(str7, 1);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.d
        public void h(boolean z16, int i3, byte[] bArr, int i16, int i17) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            QLog.d("SmsVerifyComponent.RegisterVerifyCodeApiImpl", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp. isSuccess= " + z16 + ", code= " + i3);
            if (n.this.f243023a.isFinishing()) {
                QLog.e("SmsVerifyComponent.RegisterVerifyCodeApiImpl", 1, "onRegisterSendResendSmsreqResp acitivty is finishing");
                return;
            }
            n.this.f243024b.dismissDialog();
            try {
                str = new String(bArr, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                str = null;
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str = n.this.f243023a.getString(R.string.g0j);
            }
            if (!z16) {
                n.this.r(str, 1);
                return;
            }
            QLog.i("SmsVerifyComponent.RegisterVerifyCodeApiImpl", 1, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp code = " + i3 + ";strMsg = " + str2 + ";nextChkTime =" + i16 + ";totalTimeOver =" + i17);
            if (i3 == 0) {
                n.this.f243033k = 60;
            } else if (i3 == 5) {
                if (i16 <= 60) {
                    i16 = 60;
                }
                n.this.f243033k = i16;
            } else if (i3 == 2) {
                if (!ce.c(str2)) {
                    n.this.r(str, 1);
                } else {
                    n.this.f243023a.finish();
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.KEY_REGISTER_PROMPT_INFO, str2);
                    intent.putExtra(AppConstants.Key.KEY_REGISTER_FROM, 7);
                    ((ISmsVerifyCodeService) n.this.f243023a.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all")).handleTransToSendUpSms(n.this.f243023a, intent.getExtras());
                }
                n nVar = n.this;
                com.tencent.mobileqq.loginregister.sms.f.h(nVar.f243025c, nVar.f243031i);
                return;
            }
            n.this.f243024b.startTimer(n.this.f243033k);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243025c = "";
        this.f243026d = "86";
        this.f243027e = true;
        this.f243028f = -1;
        this.f243033k = 60;
        this.f243034l = new a();
    }

    private void q() {
        int i3;
        AppRuntime appRuntime = this.f243023a.getAppRuntime();
        ReportController.o(appRuntime, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
        cb.d("0X8007361");
        if (this.f243028f == 7) {
            ReportController.u(appRuntime, "new_reg_805", "msg_page", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
        } else {
            ReportController.u(appRuntime, "new_reg_805", "msg_page", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
        }
        if (this.f243030h) {
            i3 = 3;
        } else if (this.f243029g) {
            i3 = 2;
        } else if (this.f243028f == 7) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        ReportController.r(appRuntime, "dc00898", "", "", "0X8009CEC", "0X8009CEC", i3, 0, "", "", this.f243023a.getIntent().getStringExtra(AppConstants.Key.PHONENUM), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, int i3) {
        p(str, i3);
        as.g(this.f243023a.getAppRuntime(), "0X800C1C7", "", ao.INSTANCE.c(), str);
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
        cVar.startTimer(60);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean c(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, qBaseActivity, cVar, str)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            r(qBaseActivity.getString(R.string.b3j), 0);
            return true;
        }
        if (str != null && str.length() > 0) {
            try {
                ((IRegisterServletService) qBaseActivity.getAppRuntime().getRuntimeService(IRegisterServletService.class, "all")).sendRegisterByCommitSmsVerifyCode(str, this.f243034l);
                cVar.Xc(R.string.fyv);
                this.f243032j = str;
            } catch (Exception unused) {
                QLog.e("SmsVerifyComponent.RegisterVerifyCodeApiImpl", 1, "checkSms showDialog exception");
            }
        } else {
            r(qBaseActivity.getString(R.string.fz6), 0);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public /* synthetic */ void d(QBaseActivity qBaseActivity, long j3, com.tencent.mobileqq.loginregister.callback.a aVar) {
        com.tencent.mobileqq.loginregister.sms.a.a(this, qBaseActivity, j3, aVar);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void e(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean f(QBaseActivity qBaseActivity, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 5, this, qBaseActivity, Boolean.valueOf(z16), Long.valueOf(j3))).booleanValue();
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean g(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qBaseActivity, (Object) cVar)).booleanValue();
        }
        try {
            ((IRegisterServletService) qBaseActivity.getAppRuntime().getRuntimeService(IRegisterServletService.class, "all")).sendRegisterByResendSms(this.f243034l);
            cVar.showLoadingDialog();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        String stringExtra = qBaseActivity.getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        ReportController.u(appRuntime, "new_reg_805", "msg_page", "resend_clk", "", 1, "", "", "", "", "", "", "", "", "");
        ReportController.r(appRuntime, "dc00898", "", "", "0X8009CED", "0X8009CED", 0, 0, "", "", stringExtra, "");
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void h(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) cVar);
            return;
        }
        this.f243023a = qBaseActivity;
        this.f243024b = cVar;
        this.f243025c = qBaseActivity.getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        this.f243026d = qBaseActivity.getIntent().getStringExtra("key");
        this.f243029g = qBaseActivity.getIntent().getBooleanExtra(AppConstants.Key.KEY_REGISTER_FROM_FRIEND_VERIFY, false);
        this.f243030h = qBaseActivity.getIntent().getBooleanExtra(AppConstants.Key.KEY_REGISTER_FROM_FACE_VERIFY, false);
        q();
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
        } else {
            q.c().l(3);
        }
    }

    public void p(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        } else if (str != null && str.length() != 0) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            QQToast.makeText(this.f243023a, i3, str, 0).show();
        }
    }
}
