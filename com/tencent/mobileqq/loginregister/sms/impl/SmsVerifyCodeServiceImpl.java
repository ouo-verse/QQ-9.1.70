package com.tencent.mobileqq.loginregister.sms.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.SmsVerifyComponentFragment;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.loginregister.sms.PhoneLoginSmsVerifyResult;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyFirstPageFragment;
import com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifySecondPageFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.request.WUserSigInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SmsVerifyCodeServiceImpl implements ISmsVerifyCodeService {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_ACTIVITY_HASH_CODE = "key_activity_hash_code";
    private static final String TAG = "SmsVerifyCodeServiceImpl";
    private static ConcurrentHashMap<String, SmsVerifyCodeCallbackWrapper> mCallbackMap;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class SmsVerifyCodeCallbackWrapper implements ISmsVerifyCodeService.b, LifecycleObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ISmsVerifyCodeService.b f242934d;

        SmsVerifyCodeCallbackWrapper(ISmsVerifyCodeService.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SmsVerifyCodeServiceImpl.this, (Object) bVar);
            } else {
                this.f242934d = bVar;
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void a(QBaseActivity qBaseActivity, Bundle bundle, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, qBaseActivity, bundle, obj);
                return;
            }
            SmsVerifyComponent.c(qBaseActivity.getIntent().getIntExtra("key_sms_verify_function_code", 0), qBaseActivity.getIntent().getStringExtra("key"), qBaseActivity.getIntent().getStringExtra(AppConstants.Key.PHONENUM), 0L);
            ISmsVerifyCodeService.b bVar = this.f242934d;
            if (bVar != null) {
                bVar.a(qBaseActivity, bundle, obj);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void b(QBaseActivity qBaseActivity, int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, qBaseActivity, Integer.valueOf(i3), str, bundle);
                return;
            }
            ISmsVerifyCodeService.b bVar = this.f242934d;
            if (bVar != null) {
                bVar.b(qBaseActivity, i3, str, bundle);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void c(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
                return;
            }
            ISmsVerifyCodeService.b bVar = this.f242934d;
            if (bVar != null) {
                bVar.c(bundle);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void d(QBaseActivity qBaseActivity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) bundle);
                return;
            }
            ISmsVerifyCodeService.b bVar = this.f242934d;
            if (bVar != null) {
                bVar.d(qBaseActivity, bundle);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            mCallbackMap = new ConcurrentHashMap<>();
        }
    }

    public SmsVerifyCodeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addCallback(@NonNull QBaseActivity qBaseActivity, @NonNull ISmsVerifyCodeService.b bVar, @NonNull com.tencent.mobileqq.loginregister.sms.d dVar) {
        SmsVerifyCodeCallbackWrapper smsVerifyCodeCallbackWrapper = new SmsVerifyCodeCallbackWrapper(bVar);
        qBaseActivity.getLifecycle().addObserver(smsVerifyCodeCallbackWrapper);
        mCallbackMap.put(qBaseActivity.getClass().getSimpleName() + qBaseActivity.hashCode(), smsVerifyCodeCallbackWrapper);
    }

    private void appendParams(@NonNull QBaseActivity qBaseActivity, @NonNull Intent intent, @NonNull com.tencent.mobileqq.loginregister.sms.d dVar) {
        intent.putExtra(KEY_ACTIVITY_HASH_CODE, qBaseActivity.getClass().getSimpleName() + qBaseActivity.hashCode());
        intent.putExtra("key_sms_verify_function_code", dVar.f242919a);
        dVar.a(intent);
    }

    private void doStartSendUpSms(QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.d dVar, ISmsVerifyCodeService.b bVar) {
        if (qBaseActivity != null && dVar != null && bVar != null) {
            Intent intent = new Intent(qBaseActivity, (Class<?>) RegisterSendUpSms.class);
            appendParams(qBaseActivity, intent, dVar);
            addCallback(qBaseActivity, bVar, dVar);
            qBaseActivity.startActivity(intent);
        }
    }

    private void doStartVerifyCode(QBaseActivity qBaseActivity, int i3, com.tencent.mobileqq.loginregister.sms.d dVar, ISmsVerifyCodeService.b bVar) {
        Class cls;
        if (qBaseActivity != null && dVar != null && bVar != null) {
            Intent intent = new Intent();
            appendParams(qBaseActivity, intent, dVar);
            addCallback(qBaseActivity, bVar, dVar);
            int i16 = dVar.f242919a;
            if (i16 != 1 && i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 5 && i16 != 6) {
                        cls = SmsVerifyComponentFragment.class;
                    }
                } else {
                    cls = SmsVerifyFirstPageFragment.class;
                }
                LoginPublicFragmentActivity.F2(qBaseActivity, intent, cls, i3);
            }
            cls = SmsVerifySecondPageFragment.class;
            LoginPublicFragmentActivity.F2(qBaseActivity, intent, cls, i3);
        }
    }

    @Nullable
    private ISmsVerifyCodeService.b getSmsVerifyCodeCallback(QBaseActivity qBaseActivity) {
        if (qBaseActivity == null) {
            QLog.e(TAG, 1, "getSmsVerifyCodeCallback activity is null");
            return null;
        }
        Intent intent = qBaseActivity.getIntent();
        if (intent == null) {
            QLog.e(TAG, 1, "getSmsVerifyCodeCallback intent is null");
            return null;
        }
        String stringExtra = intent.getStringExtra(KEY_ACTIVITY_HASH_CODE);
        if (stringExtra == null) {
            QLog.e(TAG, 1, "getSmsVerifyCodeCallback callbackKey is null");
            return null;
        }
        SmsVerifyCodeCallbackWrapper remove = mCallbackMap.remove(stringExtra);
        if (remove == null) {
            QLog.e(TAG, 1, "getSmsVerifyCodeCallback callback is null");
        }
        return remove;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleLoginSmsVerifySuccess(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) bundle)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        smsVerifyCodeCallback.a(qBaseActivity, bundle, null);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleNTPhoneLoginSmsVerifySuccess(QBaseActivity qBaseActivity, LoginResult loginResult) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) loginResult)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handlePhoneLoginSmsVerifySuccess callback is null? ");
        if (smsVerifyCodeCallback == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i(TAG, 1, sb5.toString());
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        smsVerifyCodeCallback.a(qBaseActivity, null, loginResult);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleNTRegisterVerifySuccess(QBaseActivity qBaseActivity, String str, RegisterVerifyResult registerVerifyResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, qBaseActivity, str, registerVerifyResult)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_verify_result", registerVerifyResult);
        smsVerifyCodeCallback.a(qBaseActivity, bundle, null);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handlePhoneLoginSmsVerifySuccess(QBaseActivity qBaseActivity, WUserSigInfo wUserSigInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) wUserSigInfo)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handlePhoneLoginSmsVerifySuccess callback is null? ");
        if (smsVerifyCodeCallback == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i(TAG, 1, sb5.toString());
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        PhoneLoginSmsVerifyResult phoneLoginSmsVerifyResult = new PhoneLoginSmsVerifyResult(true);
        phoneLoginSmsVerifyResult.f242902e = wUserSigInfo;
        bundle.putParcelable("key_verify_result", phoneLoginSmsVerifyResult);
        smsVerifyCodeCallback.a(qBaseActivity, bundle, null);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleRegisterSendUpSmsSuccess(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qBaseActivity, (Object) bundle)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        smsVerifyCodeCallback.a(qBaseActivity, bundle, null);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleRegisterVerifySuccess(QBaseActivity qBaseActivity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, qBaseActivity, str, str2)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        RegisterVerifyResult registerVerifyResult = new RegisterVerifyResult(true);
        registerVerifyResult.f242903e = str;
        registerVerifyResult.f242904f = str2;
        registerVerifyResult.f242905h = false;
        registerVerifyResult.f242907m = qBaseActivity.getIntent().getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
        bundle.putParcelable("key_verify_result", registerVerifyResult);
        smsVerifyCodeCallback.a(qBaseActivity, bundle, null);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleSmsVerifyCodeCancel(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) qBaseActivity, (Object) bundle)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        smsVerifyCodeCallback.d(qBaseActivity, bundle);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public boolean handleSmsVerifyCodeFail(QBaseActivity qBaseActivity, int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, qBaseActivity, Integer.valueOf(i3), str, bundle)).booleanValue();
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return false;
        }
        smsVerifyCodeCallback.b(qBaseActivity, i3, str, bundle);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public void handleTransToSendUpSms(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        ISmsVerifyCodeService.b smsVerifyCodeCallback = getSmsVerifyCodeCallback(qBaseActivity);
        if (smsVerifyCodeCallback == null) {
            return;
        }
        smsVerifyCodeCallback.c(bundle);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService
    public void startVerifyCode(QBaseActivity qBaseActivity, int i3, com.tencent.mobileqq.loginregister.sms.d dVar, ISmsVerifyCodeService.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, Integer.valueOf(i3), dVar, bVar);
            return;
        }
        if (qBaseActivity != null && dVar != null && bVar != null) {
            switch (dVar.f242919a) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                    doStartVerifyCode(qBaseActivity, i3, dVar, bVar);
                    return;
                case 4:
                    doStartSendUpSms(qBaseActivity, dVar, bVar);
                    return;
                default:
                    return;
            }
        }
    }
}
