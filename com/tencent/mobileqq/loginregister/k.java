package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f242875a;

    /* renamed from: b, reason: collision with root package name */
    private int f242876b;

    /* renamed from: c, reason: collision with root package name */
    private String f242877c;

    /* renamed from: d, reason: collision with root package name */
    private int f242878d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f242879e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.login.z f242880f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a implements com.tencent.mobileqq.login.z {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QBaseActivity> f242881d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<q> f242882e;

        /* renamed from: f, reason: collision with root package name */
        private final String f242883f;

        public a(QBaseActivity qBaseActivity, q qVar, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qBaseActivity, qVar, str);
                return;
            }
            this.f242881d = new WeakReference<>(qBaseActivity);
            this.f242882e = new WeakReference<>(qVar);
            this.f242883f = str;
        }

        @Override // com.tencent.mobileqq.login.z
        public void a(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.i("DevLockSmsImpl", 1, "onSmsVerifyLogin ret = " + i3 + " errMsg = " + str);
            QBaseActivity qBaseActivity = this.f242881d.get();
            q qVar = this.f242882e.get();
            if (c(qBaseActivity, qVar)) {
                QLog.w("DevLockSmsImpl", 1, "onSmsVerifyLogin, context is invalid");
                return;
            }
            qVar.dismissDialog();
            if (i3 == 0) {
                qVar.loginSuccessCallBack();
                Intent intent = new Intent();
                intent.putExtra("devlock_verify_result", true);
                intent.putExtra("devlock_verify_login_bundle", bundle);
                intent.putExtra("devlock_verify_is_login", true);
                qBaseActivity.setResult(-1, intent);
                qBaseActivity.finish();
                EquipmentLockImpl.o().H(qBaseActivity.getAppRuntime(), qBaseActivity, this.f242883f, true);
                return;
            }
            QLog.d("DevLockSmsImpl", 2, "onRecvCheckSMSResult ret = " + i3 + " errMsg=" + str);
            if (i3 == 9 || i3 == 155) {
                qBaseActivity.setResult(-1);
                qBaseActivity.finish();
            }
            qVar.clearWrongCode();
            if (!TextUtils.isEmpty(str)) {
                QQToast.makeText(qBaseActivity, 1, str, 1).show();
            } else {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.g0j), 1).show();
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
            QLog.i("DevLockSmsImpl", 1, "onGetSmsVerifyCode ret = " + i3 + " errMsg = " + str);
            QBaseActivity qBaseActivity = this.f242881d.get();
            q qVar = this.f242882e.get();
            if (c(qBaseActivity, qVar)) {
                QLog.w("DevLockSmsImpl", 1, "onGetSmsVerifyCode, context is invalid");
                return;
            }
            qVar.dismissDialog();
            if (i3 == 0) {
                if (devlockInfo == null || (i16 = devlockInfo.TimeLimit) <= 0) {
                    i16 = 60;
                }
                qVar.startTimer(i16);
                return;
            }
            if (i3 == 9 || i3 == 155) {
                qBaseActivity.setResult(-1);
                qBaseActivity.finish();
            }
            if (!TextUtils.isEmpty(str)) {
                QQToast.makeText(qBaseActivity, 1, str, 1).show();
            } else {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.g0j), 1).show();
            }
        }

        public boolean c(QBaseActivity qBaseActivity, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
            }
            if (qBaseActivity != null && qVar != null) {
                return qBaseActivity.isFinishing();
            }
            return true;
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void a(QBaseActivity qBaseActivity, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qBaseActivity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean b(QBaseActivity qBaseActivity, q qVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, qBaseActivity, qVar, str)).booleanValue();
        }
        if (!this.f242875a) {
            return false;
        }
        QLog.i("DevLockSmsImpl", 1, "submitSms smsCode=" + str);
        ((ILoginServletService) qBaseActivity.getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).devLockSmsVerifyLogin(this.f242878d, this.f242877c, str, this.f242879e, this.f242880f);
        qVar.showLoadingDialog();
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean c(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        if (!this.f242875a) {
            return false;
        }
        QLog.i("DevLockSmsImpl", 1, "sendSms");
        ILoginServletService iLoginServletService = (ILoginServletService) qBaseActivity.getAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        int i3 = this.f242876b;
        if (i3 != -1) {
            iLoginServletService.setDevLockMobileType(i3);
        }
        iLoginServletService.getDevLockSmsVerifyCode(this.f242877c, this.f242879e, this.f242880f);
        qVar.showLoadingDialog();
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
            QLog.d("DevLockSmsImpl", 1, "sendSms, intent is null");
            return;
        }
        this.f242875a = intent.getBooleanExtra(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN, false);
        this.f242876b = intent.getIntExtra("mobile_type", -1);
        this.f242877c = intent.getStringExtra("uin");
        this.f242878d = intent.getIntExtra("account_login_type", 1);
        this.f242879e = intent.getBundleExtra("pass_through_param");
        this.f242880f = new a(qBaseActivity, qVar, this.f242877c);
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean e(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        return c(qBaseActivity, qVar);
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
        }
    }
}
