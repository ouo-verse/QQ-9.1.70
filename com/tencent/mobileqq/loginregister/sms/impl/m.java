package com.tencent.mobileqq.loginregister.sms.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginVerifyReasonHelper;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m implements com.tencent.mobileqq.loginregister.sms.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QBaseActivity f243015a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.sms.c f243016b;

    /* renamed from: c, reason: collision with root package name */
    public int f243017c;

    /* renamed from: d, reason: collision with root package name */
    private int f243018d;

    /* renamed from: e, reason: collision with root package name */
    private String f243019e;

    /* renamed from: f, reason: collision with root package name */
    private String f243020f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.loginregister.servlet.h f243021g;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class a extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void A(String str, String str2, int i3, int i16, int i17, ErrMsg errMsg) {
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
                return;
            }
            QLog.d("SmsVerifyComponent.PhoneLoginVerifyCodeApiImpl", 1, "onRefreshSMSVerifyLoginAccount mobile=" + str + " msg=" + str2 + " timeLimit=" + i16 + " ret=" + i17);
            if (errMsg != null) {
                QLog.d("SmsVerifyComponent.PhoneLoginVerifyCodeApiImpl", 1, "onRefreshSMSVerifyLoginAccount errMsg=" + errMsg.getMessage());
            }
            if (m.this.f243015a.isFinishing()) {
                return;
            }
            m.this.f243016b.dismissDialog();
            if (i17 != 0) {
                if (errMsg != null) {
                    str3 = errMsg.getMessage();
                } else {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = m.this.f243015a.getString(R.string.f173065h22);
                }
                m.this.p(str3, 1, i17);
                if (i17 == 155) {
                    m.this.f243015a.finish();
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = m.this.f243015a.getString(R.string.f173065h22);
                }
                ReportController.r(m.this.f243015a.getAppRuntime(), "dc00898", "", m.this.m(), "0X800B10B", "0X800B10B", m.this.f243018d, 0, "", "", str3, "");
                return;
            }
            m.this.f243016b.startTimer(60);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void F(String str, String str2, int i3, WUserSigInfo wUserSigInfo, ErrMsg errMsg) {
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), wUserSigInfo, errMsg);
                return;
            }
            QLog.d("SmsVerifyComponent.PhoneLoginVerifyCodeApiImpl", 1, "onVerifySMSVerifyLoginAccount mobile=" + str + " msgCode=" + str2 + " ret=" + i3);
            if (errMsg != null) {
                QLog.d("SmsVerifyComponent.PhoneLoginVerifyCodeApiImpl", 1, "onVerifySMSVerifyLoginAccount errMsg=" + errMsg.getMessage());
            }
            if (m.this.f243015a.isFinishing()) {
                QLog.e("SmsVerifyComponent.PhoneLoginVerifyCodeApiImpl", 1, "onVerifySMSVerifyLoginAccount activity is finishing");
                return;
            }
            ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) m.this.f243015a.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
            if (i3 != 0) {
                m.this.f243016b.dismissDialog();
                if (errMsg != null) {
                    str3 = errMsg.getMessage();
                } else {
                    str3 = null;
                }
                m.this.f243016b.clearWrongCode();
                if (TextUtils.isEmpty(str3)) {
                    str3 = m.this.f243015a.getString(R.string.f173065h22);
                }
                m.this.p(str3, 1, i3);
                if (i3 == 155) {
                    iSmsVerifyCodeService.handleSmsVerifyCodeCancel(m.this.f243015a, new Bundle());
                    m.this.f243015a.finish();
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = m.this.f243015a.getString(R.string.f173065h22);
                }
                ReportController.r(m.this.f243015a.getAppRuntime(), "dc00898", "", m.this.m(), "0X800B10B", "0X800B10B", m.this.f243018d, 0, "", "", str3, "");
                return;
            }
            ReportController.r(m.this.f243015a.getAppRuntime(), "dc00898", "", m.this.m(), "0X800B10C", "0X800B10C", m.this.f243018d, 0, "", "", "", "");
            iSmsVerifyCodeService.handlePhoneLoginSmsVerifySuccess(m.this.f243015a, wUserSigInfo);
            m.this.f243015a.finish();
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243017c = -1;
            this.f243021g = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        AppRuntime appRuntime = this.f243015a.getAppRuntime();
        if (appRuntime == null || appRuntime.isLogin()) {
            return "";
        }
        return this.f243020f;
    }

    private void o(String str, int i3) {
        n(str, i3);
        as.g(this.f243015a.getAppRuntime(), "0X800C1C7", "", this.f243018d, str);
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
            o(qBaseActivity.getString(R.string.b3j), 0);
            return false;
        }
        if (str != null) {
            str = str.trim();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f243019e = str;
            cVar.showLoadingDialog();
            QLog.d("SmsVerifyComponent.PhoneLoginVerifyCodeApiImpl", 1, "commitSmsCode start...");
            int verifySMSVerifyLoginCode = ((ILoginServletService) qBaseActivity.getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).verifySMSVerifyLoginCode(qBaseActivity.getIntent().getStringExtra("key"), this.f243020f, str, this.f243021g);
            if (verifySMSVerifyLoginCode != 0) {
                cVar.dismissDialog();
                p(qBaseActivity.getString(R.string.f173065h22), 1, verifySMSVerifyLoginCode);
            }
        } else {
            o(qBaseActivity.getString(R.string.fz6), 0);
        }
        return false;
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
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            o(qBaseActivity.getString(R.string.b3j), 0);
            return false;
        }
        cVar.showLoadingDialog();
        int refreshSMSVerifyLoginCode = ((ILoginServletService) qBaseActivity.getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).refreshSMSVerifyLoginCode(qBaseActivity.getIntent().getStringExtra("key"), this.f243020f, this.f243021g);
        if (refreshSMSVerifyLoginCode != 0) {
            cVar.dismissDialog();
            p(qBaseActivity.getString(R.string.f173065h22), 1, refreshSMSVerifyLoginCode);
        }
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", m(), "0X800B10A", "0X800B10A", this.f243018d, 0, "", "", "", "");
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void h(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) cVar);
            return;
        }
        this.f243015a = qBaseActivity;
        this.f243016b = cVar;
        Intent intent = qBaseActivity.getIntent();
        if (intent != null) {
            this.f243018d = intent.getIntExtra("phoneNumLoginEntrance", 0);
        }
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        this.f243020f = qBaseActivity.getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        ReportController.r(appRuntime, "dc00898", "", m(), "0X800B109", "0X800B109", this.f243018d, 0, "", "", "", "");
    }

    public void n(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3);
        } else if (str != null && str.length() != 0) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            QQToast.makeText(this.f243015a, i3, str, 0).show();
        }
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

    public void p(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            n(str, i3);
            as.f(this.f243015a.getAppRuntime(), "0X800C1A1", "", this.f243018d, i16, str);
        }
    }
}
