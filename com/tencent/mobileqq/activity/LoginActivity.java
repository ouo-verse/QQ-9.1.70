package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment;
import com.tencent.mobileqq.login.restart.LoginProcessRestartMonitor;
import com.tencent.mobileqq.login.restart.Scene;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.reportlog.api.IReportLogWithLoginApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.xps.api.IQEstApi;
import com.tencent.qqprotect.xps.api.IQccApi;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u4e3b\u767b\u5f55\u9875\u9762", path = RouterConstants.UI_ROUTER_LOGIN)
/* loaded from: classes9.dex */
public class LoginActivity extends QBaseActivity implements Handler.Callback, com.tencent.mobileqq.login.aq {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoginActivity";
    private static LoginActivity sCurrent;
    private boolean isAddAccount;
    private BaseLoginFragment mCurrentLoginFragment;
    private final MqqHandler mHandler;
    private com.tencent.mobileqq.loginregister.w mLoginProxy;
    private String mLogoutUin;
    private final ec mQUIProfileTheme;
    private BroadcastReceiver mQrCodeLoginReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            QLog.d(LoginActivity.TAG, 1, "mQrCodeLoginReceiver onReceive action=" + intent.getAction());
            if (LoginActivity.this.mLoginProxy != null && LoginActivity.this.mLoginProxy.f(LoginActivity.this, intent.getStringExtra("param_qr_code_url"))) {
                com.tencent.mobileqq.login.fragment.l.f242160a.b(false);
            }
            String g16 = com.tencent.mobileqq.loginregister.z.g(LoginActivity.this.getIntent().getStringExtra("appid"));
            String g17 = com.tencent.mobileqq.loginregister.z.g(LoginActivity.this.getIntent().getStringExtra("oauth_app_name"));
            if (LoginActivity.this.getIntent().getBooleanExtra("is_open_sdk_add_account", false)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            ReportController.o(LoginActivity.this.getAppRuntime(), "dc00898", "", "", "0X800BA19", "0X800BA19", i3, 0, g16, "", g17, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements com.tencent.mobileqq.loginregister.x {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.x
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.login.fragment.l.f242160a.b(true);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.x
        public void hideLoading() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                com.tencent.mobileqq.login.fragment.l.f242160a.l();
            }
        }
    }

    public LoginActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHandler = new MqqHandler(this);
            this.mQUIProfileTheme = new ec(this);
        }
    }

    private void changeLoginFragment(Intent intent) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        BaseLoginFragment d16 = com.tencent.mobileqq.login.fragment.l.f242160a.d(intent);
        if (supportFragmentManager.findFragmentById(R.id.cze) != null) {
            beginTransaction.replace(R.id.cze, d16);
        } else {
            beginTransaction.add(R.id.cze, d16);
        }
        beginTransaction.commitAllowingStateLoss();
        this.mCurrentLoginFragment = d16;
    }

    private void dispatchLoginSuccessWhenRestore() {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.login.ao d16 = com.tencent.mobileqq.login.am.d();
        if (d16 == null) {
            return;
        }
        boolean z18 = false;
        if (getAppRuntime() != null && getAppRuntime().isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        if (d16.b() != null && d16.b().f242202c) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (d16.b() != null && d16.b().f242203d) {
            z18 = true;
        }
        QLog.i(TAG, 1, "dispatchLoginSuccessWhenRestore subLogin=" + z17 + " openSdkLogin=" + z18);
        if (!z17 && !z18) {
            onAccountChanged();
        } else {
            onLoginSuccess(d16.b(), d16.d(), d16.a());
        }
    }

    private boolean enableLoginSuccessAnim() {
        boolean z16;
        if (!isResume() || !(this.mCurrentLoginFragment instanceof ReLoginFragment)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.getCurAccLoginType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return !filterDevice();
    }

    private static boolean filterDevice() {
        boolean z16 = false;
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        if (screenHeight > 0 && screenWidth > 0) {
            if (Math.max(screenWidth, screenHeight) / Math.min(screenWidth, screenHeight) <= 1.3d) {
                z16 = true;
            }
            if (z16) {
                QLog.e(TAG, 1, "filterDevice height=" + screenHeight + " width=" + screenWidth);
            }
            return z16;
        }
        QLog.e(TAG, 1, "filterDevice height=" + screenHeight + " width=" + screenWidth);
        return true;
    }

    public static boolean isLoginActivityDestroyed() {
        LoginActivity loginActivity = sCurrent;
        if (loginActivity != null && !loginActivity.isDestroyed()) {
            return false;
        }
        return true;
    }

    private void registerQrCodeLoginReceiver() {
        if (!TextUtils.isEmpty(getIntent().getStringExtra("param_qr_code_url")) && this.mQrCodeLoginReceiver == null) {
            a aVar = new a();
            this.mQrCodeLoginReceiver = aVar;
            registerReceiver(aVar, new IntentFilter(NewIntent.ACTION_QRCODE_LOGIN_FINISH));
        }
    }

    private void showReleaseAccountDialog() {
        if (!isFinishing() && !isDestroyed()) {
            QLog.i(TAG, 1, "showReleaseAccountDialog");
            String stringExtra = getIntent().getStringExtra("release_success_text");
            String stringExtra2 = getIntent().getStringExtra("release_bold_text");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = getString(R.string.f5w);
                stringExtra2 = getString(R.string.f5x);
            }
            SpannableString spannableString = new SpannableString(stringExtra);
            if (!TextUtils.isEmpty(stringExtra2) && stringExtra.contains(stringExtra2)) {
                int indexOf = stringExtra.indexOf(stringExtra2);
                spannableString.setSpan(new StyleSpan(1), indexOf, stringExtra2.length() + indexOf, 33);
            }
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.f5y)).setMessage(spannableString).setPositiveButton(getString(R.string.f5v), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ea
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LoginActivity.lambda$showReleaseAccountDialog$1(dialogInterface, i3);
                }
            });
            positiveButton.setCancelable(false);
            positiveButton.show();
        }
    }

    private void unregisterQrCodeLoginReceiver() {
        BroadcastReceiver broadcastReceiver = this.mQrCodeLoginReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.mQrCodeLoginReceiver = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void checkUnlockForSpecial() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (this.isAddAccount && getAppRuntime() != null && com.tencent.mobileqq.loginregister.z.j(this, getAppRuntime())) {
            startUnlockActivity();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected void doAfterLoginSuccess() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "LoginActivity doAfterLoginSuccess");
        if (com.tencent.mobileqq.phonelogin.a.a().c()) {
            return;
        }
        if (getAppRuntime().isLogin()) {
            z16 = this.mLoginProxy.a(getAppRuntime(), this, getAppRuntime().getAccount());
        } else {
            QLog.w(TAG, 1, "doAfterLoginSuccess appRuntime is not login");
            z16 = false;
        }
        com.tencent.mobileqq.login.fragment.l.f242160a.r(getAppRuntime().getAccount(), z16);
        if (this.isAddAccount) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        ((IQccApi) QRoute.api(IQccApi.class)).rtReportSecInfo(i3);
        ((IQEstApi) QRoute.api(IQEstApi.class)).rtReportSecInfo(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        com.tencent.mobileqq.util.aj.f306554f.o();
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            finish();
            QLog.e(TAG, 1, "app is null, finish");
            return true;
        }
        if (!appRuntime.isLogin()) {
            ((IReportLogWithLoginApi) QRoute.api(IReportLogWithLoginApi.class)).fetchLogReportConfig();
        }
        ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).initSdk();
        this.isAddAccount = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
        boolean booleanExtra = getIntent().getBooleanExtra("login_from_account_change", false);
        LoginActivity loginActivity = sCurrent;
        if (loginActivity != null) {
            loginActivity.finish();
        }
        sCurrent = this;
        com.tencent.mobileqq.loginregister.z.v(appRuntime, com.tencent.mobileqq.loginregister.v.class, this.mHandler);
        com.tencent.mobileqq.loginregister.w wVar = new com.tencent.mobileqq.loginregister.w();
        this.mLoginProxy = wVar;
        com.tencent.mobileqq.login.fragment.l.f242160a.t(wVar);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LoginActivity app is " + appRuntime);
        }
        super.setContentView(R.layout.bwk);
        changeLoginFragment(getIntent());
        if (getIntent().getBooleanExtra("logout_intent", false)) {
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null) {
                this.mLogoutUin = firstSimpleAccount.getUin();
                QLog.i(TAG, 1, "Enter from logout, setAutoLogin " + StringUtil.getSimpleUinForPrint(this.mLogoutUin) + " false");
                if (!TextUtils.isEmpty(this.mLogoutUin)) {
                    AutoLoginUtil.setAutoLogin(this.mLogoutUin, false);
                }
            }
            com.tencent.mobileqq.login.relogin.vm.j.b();
        }
        if (getIntent().getBooleanExtra("show_release_account_dialog", false)) {
            getIntent().putExtra("show_release_account_dialog", false);
            showReleaseAccountDialog();
        }
        this.mLoginProxy.j(this, getIntent().getExtras());
        com.tencent.mobileqq.login.an.f241884a.b(this);
        registerQrCodeLoginReceiver();
        if (bundle != null) {
            dispatchLoginSuccessWhenRestore();
        }
        AccessibilityUtil.A(getApplicationContext());
        LoginProcessRestartMonitor.i(Scene.LOGOUT);
        if (this.isAddAccount && booleanExtra) {
            ReportController.o(appRuntime, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
            ReportController.o(appRuntime, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
        }
        com.tencent.mobileqq.login.remind.n.f242580a.b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnDestroy();
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            return;
        }
        sCurrent = null;
        this.mLoginProxy.g();
        com.tencent.mobileqq.login.fragment.l.f242160a.a(this.mLoginProxy);
        com.tencent.mobileqq.loginregister.z.s(appRuntime, com.tencent.mobileqq.loginregister.v.class);
        unregisterQrCodeLoginReceiver();
        com.tencent.mobileqq.login.an.f241884a.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (intent != null) {
            if (getIntent() != null) {
                getIntent().putExtras(intent);
            }
            int e16 = com.tencent.mobileqq.login.fragment.l.f242160a.e(intent);
            BaseLoginFragment baseLoginFragment = this.mCurrentLoginFragment;
            if (baseLoginFragment != null && baseLoginFragment.rh() == e16) {
                this.mCurrentLoginFragment.onNewIntent(intent);
            } else {
                changeLoginFragment(intent);
            }
            if (getIntent().getBooleanExtra("show_release_account_dialog", false)) {
                getIntent().putExtra("show_release_account_dialog", false);
                showReleaseAccountDialog();
            }
        }
        QLog.d(TAG, 1, "doOnNewIntent in LoginActivity");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnResume();
        com.tencent.mobileqq.phonelogin.a.a().e(false);
        if (getAppRuntime() != null) {
            getAppRuntime().cancelSyncOnlineFriend(-1L);
        }
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (NewIntent.ACTION_KICK_TO_LOGIN.equals(getIntent().getAction())) {
            String stringExtra = getIntent().getStringExtra("login_page_action");
            Intent intent = new Intent(stringExtra);
            intent.putExtras(getIntent());
            intent.putExtra("is_from_login_page", true);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
            getIntent().setAction("");
            QLog.d(TAG, 1, "doOnResume kick out route to action: " + stringExtra);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.finish();
            QLog.i(TAG, 1, "finish");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Resources) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mQUIProfileTheme.b(super.getResources());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        if ("layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            if (systemService instanceof LayoutInflater) {
                return this.mQUIProfileTheme.a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 2004) {
            if (i3 == 2006 && isResume()) {
                showReleaseAccountDialog();
            }
        } else {
            QLog.d(TAG, 1, "recv message FINISH_ACTIVITY.. finish activity");
            finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onAccountChanged();
        QLog.d(TAG, 1, "LoginActivity onAccountChanged");
        final AppRuntime appRuntime = getAppRuntime();
        com.tencent.mobileqq.loginregister.z.v(appRuntime, com.tencent.mobileqq.loginregister.v.class, this.mHandler);
        if (!TextUtils.isEmpty(this.mLogoutUin)) {
            this.mLoginProxy.k(this, appRuntime, this.mLogoutUin);
        }
        this.mLoginProxy.b(appRuntime, getClass(), System.currentTimeMillis());
        doAfterLoginSuccess();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.eb
            @Override // java.lang.Runnable
            public final void run() {
                ReportController.r(AppRuntime.this, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onAccoutChangeFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            QLog.w(TAG, 1, "LoginActivity onAccoutChangeFailed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean booleanExtra = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
        if (getIntent().getBooleanExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, false)) {
            if (booleanExtra) {
                moveTaskToBack(true);
            } else {
                try {
                    getAppRuntime().exit(false);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "onBackEvent app exit exception: " + e16.getMessage());
                    e16.printStackTrace();
                }
            }
            finish();
        } else if (com.tencent.mobileqq.loginregister.z.l(this)) {
            finish();
        } else {
            try {
                getAppRuntime().exit(false);
            } catch (Exception e17) {
                QLog.e(TAG, 1, "onBackEvent app exit exception: " + e17.getMessage());
                e17.printStackTrace();
            }
            finish();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.login.aq
    public void onLoginSuccess(@NonNull com.tencent.mobileqq.login.l lVar, @NonNull String str, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, lVar, str, bundle);
        } else if (lVar.f242202c) {
            this.mLoginProxy.d(this, str, new b());
        } else if (lVar.f242203d) {
            this.mLoginProxy.c(this, lVar.f242200a, str, bundle, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) logoutReason);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        BaseLoginFragment baseLoginFragment = this.mCurrentLoginFragment;
        if (baseLoginFragment != null) {
            baseLoginFragment.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void receiveScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.receiveScreenOff();
        if (this.isAddAccount && getAppRuntime() != null && com.tencent.mobileqq.loginregister.z.j(this, getAppRuntime())) {
            startUnlockActivity();
        }
    }

    public void startLoginSuccessAnim(e72.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bVar);
        } else {
            if (!enableLoginSuccessAnim()) {
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            }
            ((ReLoginFragment) this.mCurrentLoginFragment).Rh(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showReleaseAccountDialog$1(DialogInterface dialogInterface, int i3) {
    }
}
