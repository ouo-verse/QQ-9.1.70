package com.tencent.mobileqq.login;

import android.os.Bundle;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class k<T extends l> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "LoginMainline";
    private WeakReference<QBaseActivity> mActivityRef;
    protected final AtomicBoolean mIsLoggingIn;
    protected aa mLoginCallback;
    private y mLoginLoading;
    protected T mLoginParams;
    protected long mLoginStartTime;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsLoggingIn = new AtomicBoolean(false);
            this.mLoginStartTime = 0L;
        }
    }

    private boolean isLoginTimeout() {
        if (Math.abs(System.currentTimeMillis() - this.mLoginStartTime) > 10000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideLoading$2(boolean z16) {
        y yVar = this.mLoginLoading;
        if (yVar != null) {
            yVar.b(z16);
            if (z16) {
                this.mLoginLoading = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$login$0(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY && lifecycleOwner == getActivity() && isLoggingIn()) {
            onActivityDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoginCancel$6() {
        aa aaVar = this.mLoginCallback;
        if (aaVar != null) {
            aaVar.a();
            this.mLoginCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoginFailed$5(aj ajVar) {
        aa aaVar = this.mLoginCallback;
        if (aaVar != null) {
            aaVar.b(ajVar);
            this.mLoginCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoginSuccess$3(String str) {
        ((IAccountApi) QRoute.api(IAccountApi.class)).clearAccountIdentityStatus(str);
        updateNickname(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoginSuccess$4(String str, Bundle bundle) {
        String str2;
        T t16 = this.mLoginParams;
        if (!t16.f242204e) {
            an anVar = an.f241884a;
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            anVar.a(t16, str2, bundle);
        }
        aa aaVar = this.mLoginCallback;
        if (aaVar != null) {
            aaVar.c(str, bundle);
            this.mLoginCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$1(String str) {
        y yVar = this.mLoginLoading;
        if (yVar != null) {
            yVar.a(str);
        }
    }

    public boolean canLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mIsLoggingIn.get() && !isLoginTimeout()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkBeforeLoginSuccess(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        if (com.tencent.mobileqq.loginregister.z.p(str)) {
            return true;
        }
        QLog.i(TAG, 1, "checkBeforeLoginSuccess uin is invalid " + str);
        onLoginFailed(new aj(-999, BaseApplication.getContext().getString(R.string.f200704su)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QBaseActivity getActivity() {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null || qBaseActivity.isFinishing() || qBaseActivity.isDestroyed()) {
            return QBaseActivity.sTopActivity;
        }
        return qBaseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    protected String getReportUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideLoading(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.d
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.lambda$hideLoading$2(z16);
                }
            });
        }
    }

    public boolean isLoggingIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mIsLoggingIn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLoginActivityInvalid() {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public void login(QBaseActivity qBaseActivity, T t16, y yVar, aa aaVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qBaseActivity, t16, yVar, aaVar);
            return;
        }
        QLog.d(TAG, 1, "login params=" + t16);
        if (!canLogin()) {
            QLog.i(TAG, 1, "cannot login, is logging in now");
            return;
        }
        this.mActivityRef = new WeakReference<>(qBaseActivity);
        this.mLoginParams = t16;
        this.mLoginLoading = new ak(qBaseActivity, yVar);
        this.mLoginCallback = aaVar;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            qBaseActivity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.login.i
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    k.this.lambda$login$0(lifecycleOwner, event);
                }
            });
        }
        com.tencent.mobileqq.loginregister.w h16 = com.tencent.mobileqq.login.fragment.l.f242160a.h();
        if (h16 != null) {
            h16.i(qBaseActivity);
        }
        this.mIsLoggingIn.set(true);
        this.mLoginStartTime = System.currentTimeMillis();
        if (!t16.f242204e) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginStart(t16.f242201b, t16.f242200a, getReportUin());
        }
        startLogin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.i(TAG, 1, "onActivityDestroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mIsLoggingIn.set(false);
        hideLoading(false);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.e
            @Override // java.lang.Runnable
            public final void run() {
                k.this.lambda$onLoginCancel$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoginFailed(final aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) ajVar);
            return;
        }
        this.mIsLoggingIn.set(false);
        hideLoading(false);
        if (!this.mLoginParams.f242204e) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(false, String.valueOf(ajVar.f241864a));
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.j
            @Override // java.lang.Runnable
            public final void run() {
                k.this.lambda$onLoginFailed$5(ajVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoginSuccess(final String str, final Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        this.mIsLoggingIn.set(false);
        hideLoading(true);
        if (!this.mLoginParams.f242204e) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(true, "");
            if (com.tencent.mobileqq.phonelogin.a.a().c()) {
                QuestionnaireForLoginManager.h(2);
            }
        }
        QuestionnaireForLoginManager.f(System.currentTimeMillis() - this.mLoginStartTime);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.f
            @Override // java.lang.Runnable
            public final void run() {
                k.this.lambda$onLoginSuccess$3(str);
            }
        }, 16, null, false);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.g
            @Override // java.lang.Runnable
            public final void run() {
                k.this.lambda$onLoginSuccess$4(str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            QLog.i(TAG, 2, "onReLogin");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            runOnUiThread(runnable, 0L);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            showLoading(BaseApplication.getContext().getString(R.string.f211335kj));
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    protected abstract void startLogin();

    protected void updateNickname(String str) {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        if (getAppRuntime() != null && (c16 = com.tencent.mobileqq.login.account.b.c(str)) != null) {
            QLog.i(TAG, 1, "updateNickname uin:" + StringUtil.getSimpleUinForPrint(str));
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.nickName.toString() + str, c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, runnable, Long.valueOf(j3));
            return;
        }
        if (j3 <= 0) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
                return;
            } else {
                ThreadManager.getUIHandler().post(runnable);
                return;
            }
        }
        ThreadManager.getUIHandler().postDelayed(runnable, j3);
    }

    protected void showLoading(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.h
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.lambda$showLoading$1(str);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }
}
