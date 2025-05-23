package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j implements p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f242870a;

    /* renamed from: b, reason: collision with root package name */
    private String f242871b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.servlet.h f242872c;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QBaseActivity> f242873d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<q> f242874e;

        public a(QBaseActivity qBaseActivity, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) qVar);
            } else {
                this.f242873d = new WeakReference<>(qBaseActivity);
                this.f242874e = new WeakReference<>(qVar);
            }
        }

        public boolean G(QBaseActivity qBaseActivity, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
            }
            if (qBaseActivity != null && qVar != null) {
                return qBaseActivity.isFinishing();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void a(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
                return;
            }
            QBaseActivity qBaseActivity = this.f242873d.get();
            q qVar = this.f242874e.get();
            if (G(qBaseActivity, qVar)) {
                QLog.e("DefaultSmsImpl", 1, "onAskDevLockSms, context is invalid");
                return;
            }
            qVar.dismissDialog();
            if (i3 == 0 && devlockInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("DefaultSmsImpl", 2, "OnAskDevLockSms DevlockInfo.TimeLimit:" + devlockInfo.TimeLimit + " AvailableMsgCount:" + devlockInfo.AvailableMsgCount);
                }
                if (devlockInfo.TimeLimit <= 0) {
                    devlockInfo.TimeLimit = 60;
                }
                qVar.startTimer(devlockInfo.TimeLimit);
                return;
            }
            QLog.d("DefaultSmsImpl", 1, "OnAskDevLockSms ret = " + i3);
            if (errMsg != null) {
                QLog.d("DefaultSmsImpl", 1, "OnAskDevLockSms  errMsg:" + errMsg.getMessage());
            }
            if (errMsg != null && !TextUtils.isEmpty(errMsg.getMessage())) {
                QQToast.makeText(qBaseActivity, 1, errMsg.getMessage(), 0).show();
            } else {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.g0j), 0).show();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void b(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
                return;
            }
            QLog.d("DefaultSmsImpl", 1, "OnCheckDevLockSms ret = " + i3);
            if (errMsg != null) {
                QLog.d("DefaultSmsImpl", 1, "OnCheckDevLockSms  errMsg:" + errMsg.getMessage());
            }
            QBaseActivity qBaseActivity = this.f242873d.get();
            q qVar = this.f242874e.get();
            if (G(qBaseActivity, qVar)) {
                QLog.e("DefaultSmsImpl", 1, "onCheckDevLockSms, context is invalid");
                return;
            }
            qVar.dismissDialog();
            if (i3 == 0) {
                String currentAccountUinFromRuntime = qBaseActivity.getCurrentAccountUinFromRuntime();
                EquipmentLockImpl.o().C(null, currentAccountUinFromRuntime, 9);
                qBaseActivity.setResult(-1);
                qBaseActivity.finish();
                EquipmentLockImpl.o().H(qBaseActivity.getAppRuntime(), qBaseActivity, currentAccountUinFromRuntime, true);
                return;
            }
            if (errMsg != null && !TextUtils.isEmpty(errMsg.getMessage())) {
                QQToast.makeText(qBaseActivity, 1, errMsg.getMessage(), 0).show();
            } else {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.g0j), 0).show();
            }
        }
    }

    public j() {
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
        QLog.d("DefaultSmsImpl", 1, "checkSms smsCode=" + str);
        if ("f_SetFaceData".equals(this.f242871b) || this.f242870a) {
            return false;
        }
        int e16 = EquipmentLockImpl.o().e(qBaseActivity.getAppRuntime(), qBaseActivity.getCurrentAccountUinFromRuntime(), str, null, this.f242872c);
        if (e16 == 0) {
            qVar.showLoadingDialog();
        } else {
            QLog.d("DefaultSmsImpl", 1, "checkSms failed ret=" + e16);
            QQToast.makeText(qBaseActivity, 1, R.string.g1q, 0).show();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean c(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        if (!"f_SetFaceData".equals(this.f242871b) && !this.f242870a && !"from_phone_bind_account_manager".equals(this.f242871b)) {
            QLog.d("DefaultSmsImpl", 1, "sendSms : AskDevLockSms");
            int d16 = EquipmentLockImpl.o().d(qBaseActivity.getAppRuntime(), qBaseActivity.getCurrentAccountUinFromRuntime(), this.f242872c);
            if (d16 == 0) {
                qVar.showLoadingDialog();
            } else {
                QLog.d("DefaultSmsImpl", 1, "sendSms failed ret=" + d16);
            }
            return true;
        }
        return false;
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
            QLog.d("DefaultSmsImpl", 1, "sendSms, intent is null");
            return;
        }
        this.f242870a = intent.getBooleanExtra(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN, false);
        this.f242871b = intent.getStringExtra(MQPSecJsPlugin.KEY_FROM);
        this.f242872c = new a(qBaseActivity, qVar);
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
