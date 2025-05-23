package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.util.Base64;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.IdentificationUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$RspBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o implements p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f242886a;

    /* renamed from: b, reason: collision with root package name */
    private a f242887b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QBaseActivity> f242888d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<q> f242889e;

        public a(QBaseActivity qBaseActivity, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) qVar);
            } else {
                this.f242888d = new WeakReference<>(qBaseActivity);
                this.f242889e = new WeakReference<>(qVar);
            }
        }

        public boolean a(QBaseActivity qBaseActivity, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
            }
            if (qBaseActivity != null && qVar != null && !qBaseActivity.isFinishing()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getTmpKeySuccess(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                return;
            }
            QLog.d("FaceSmsVerifyImpl", 1, "getTmpKeySuccess");
            QBaseActivity qBaseActivity = this.f242888d.get();
            if (a(qBaseActivity, this.f242889e.get())) {
                QLog.e("FaceSmsVerifyImpl", 1, "getTmpKeySuccess, but context is invalid");
            } else {
                IdentificationUtils.b(qBaseActivity, qBaseActivity.getAppRuntime().getAccount(), str, str2);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
                return;
            }
            QLog.e("FaceSmsVerifyImpl", 1, "set face data onFailedResponse error, code : ", Integer.valueOf(i3), " message : ", str2, " cmd : ", str);
            QBaseActivity qBaseActivity = this.f242888d.get();
            q qVar = this.f242889e.get();
            if (a(qBaseActivity, qVar)) {
                QLog.e("FaceSmsVerifyImpl", 1, "onFailedResponse, but context is invalid");
                return;
            }
            qVar.clearWrongCode();
            if (i3 == -1) {
                str2 = qBaseActivity.getString(R.string.g0j);
            }
            QQToast.makeText(qBaseActivity, 1, str2, 0).show();
        }

        @Override // com.tencent.mobileqq.observer.c
        public void sendSmsCodeSuccess(oidb_0x87a$RspBody oidb_0x87a_rspbody) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0x87a_rspbody);
                return;
            }
            QLog.d("FaceSmsVerifyImpl", 1, "sendSmsCodeSuccess");
            QBaseActivity qBaseActivity = this.f242888d.get();
            q qVar = this.f242889e.get();
            if (a(qBaseActivity, qVar)) {
                QLog.e("FaceSmsVerifyImpl", 1, "sendSmsCodeSuccess, but context is invalid");
                return;
            }
            if (qBaseActivity.isFinishing()) {
                QLog.d("FaceSmsVerifyImpl", 1, "sendSmsCodeSuccess, activity is finish");
                return;
            }
            qVar.dismissDialog();
            if (QLog.isColorLevel()) {
                QLog.d("FaceSmsVerifyImpl", 2, "Set face data onRecvVerifyCode");
            }
            if (oidb_0x87a_rspbody.uint32_resend_interval.get() > 0) {
                i3 = oidb_0x87a_rspbody.uint32_resend_interval.get();
            } else {
                i3 = 60;
            }
            qVar.startTimer(i3);
        }

        @Override // com.tencent.mobileqq.observer.c
        public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x87c_rspbody);
                return;
            }
            QLog.d("FaceSmsVerifyImpl", 1, "verifySmsCodeSuccess");
            QBaseActivity qBaseActivity = this.f242888d.get();
            q qVar = this.f242889e.get();
            if (a(qBaseActivity, qVar)) {
                QLog.e("FaceSmsVerifyImpl", 1, "verifySmsCodeSuccess, but context is invalid");
                return;
            }
            qVar.dismissDialog();
            LoginVerifyServlet.g(101810106, qBaseActivity.getAppRuntime().getAccount(), "sms", Base64.encodeToString(oidb_0x87c_rspbody.toByteArray(), 11), this);
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void f(QBaseActivity qBaseActivity, q qVar) {
        if (this.f242887b == null) {
            this.f242887b = new a(qBaseActivity, qVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void a(QBaseActivity qBaseActivity, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qBaseActivity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 21) {
            QLog.d("FaceSmsVerifyImpl", 1, "onActivity requestCode == AuthDevActivity.REQ_LEGACY, resultCode is : " + i16);
            qBaseActivity.setResult(i16, intent);
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean b(QBaseActivity qBaseActivity, q qVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, qBaseActivity, qVar, str)).booleanValue();
        }
        if (!"f_SetFaceData".equals(this.f242886a)) {
            return false;
        }
        QLog.d("FaceSmsVerifyImpl", 2, "checkSms, smsCode : ", str);
        LoginVerifyServlet.s(qBaseActivity.getAppRuntime(), str, this.f242887b);
        ReportController.o(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean c(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        if (!"f_SetFaceData".equals(this.f242886a)) {
            return false;
        }
        qVar.startTimer(60);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void d(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) qVar);
            return;
        }
        Intent intent = qBaseActivity.getIntent();
        if (intent == null) {
            QLog.d("FaceSmsVerifyImpl", 1, "sendSms, intent is null");
        } else {
            this.f242886a = intent.getStringExtra(MQPSecJsPlugin.KEY_FROM);
            f(qBaseActivity, qVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean e(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        if (!"f_SetFaceData".equals(this.f242886a)) {
            return false;
        }
        f(qBaseActivity, qVar);
        QLog.d("FaceSmsVerifyImpl", 1, "Set Face Data startGetVerifyCode.begin");
        LoginVerifyServlet.r(qBaseActivity.getAppRuntime(), this.f242887b);
        ReportController.o(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if ("f_SetFaceData".equals(this.f242886a)) {
            ReportController.o(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
        }
    }
}
