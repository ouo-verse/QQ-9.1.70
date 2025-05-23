package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.login.verify.t;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
@RoutePage(desc = "\u8f93\u5165\u77ed\u4fe1\u9a8c\u8bc1\u7801\u9875\u9762", path = "/base/login/authDevVerifyCode")
/* loaded from: classes9.dex */
public class AuthDevVerifyCodeActivity extends RegisterNewBaseActivity implements View.OnClickListener, VerifyCodeView.a, com.tencent.mobileqq.loginregister.q {
    static IPatchRedirector $redirector_ = null;
    public static final int SECOND = 1000;
    private static final String TAG = "Q.devlock.AuthDevVerifyCodeActivity";
    public static int mSecond;
    private TextView btnLeftBack;
    private long clickOtherVerifyBtnLastTime;
    private boolean hasClickSendSms;
    private boolean hasUserClickStay;
    private boolean isSmsChecked;
    private String mEntrance;
    protected Handler mHandler;
    private QQProgressDialog mProDialog;
    private com.tencent.mobileqq.loginregister.e mVerifyProxy;
    private Runnable runnableCountdown;
    private com.tencent.mobileqq.activity.verifysms.a verifyCodeView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f174992d;

        a(boolean z16) {
            this.f174992d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AuthDevVerifyCodeActivity.this, Boolean.valueOf(z16));
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
            AuthDevVerifyCodeActivity.this.hasUserClickStay = true;
            if (this.f174992d) {
                AuthDevVerifyCodeActivity.this.report898ForFunctionTipDialog("0X800C296");
            } else {
                AuthDevVerifyCodeActivity.this.report898("0X800BB53");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f174994d;

        b(boolean z16) {
            this.f174994d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AuthDevVerifyCodeActivity.this, Boolean.valueOf(z16));
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
            if (this.f174994d) {
                AuthDevVerifyCodeActivity.this.report898ForFunctionTipDialog("0X800C297");
            } else {
                AuthDevVerifyCodeActivity.this.report898("0X800BB52");
            }
            AuthDevVerifyCodeActivity.this.onUserCancel();
            AuthDevVerifyCodeActivity.super.onBackEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements t.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevVerifyCodeActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d(AuthDevVerifyCodeActivity.TAG, 1, "WebAuxiliaryVerify onVerifyCancel");
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void b(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.d(AuthDevVerifyCodeActivity.TAG, 1, "WebAuxiliaryVerify onVerifySuccess");
            Intent intent = new Intent();
            intent.putExtra("devlock_verify_result", true);
            intent.putExtra("devlock_verify_is_login", z16);
            AuthDevVerifyCodeActivity.this.setResult(-1, intent);
            AuthDevVerifyCodeActivity.this.finish();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28358);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            mSecond = 1;
        }
    }

    public AuthDevVerifyCodeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hasClickSendSms = false;
        this.clickOtherVerifyBtnLastTime = 0L;
        this.mHandler = new Handler();
        this.runnableCountdown = new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthDevVerifyCodeActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = AuthDevVerifyCodeActivity.mSecond;
                if (i3 <= 1) {
                    AuthDevVerifyCodeActivity.this.refreshSendCodeBtn(true);
                    return;
                }
                AuthDevVerifyCodeActivity.mSecond = i3 - 1;
                AuthDevVerifyCodeActivity.this.refreshSendCodeBtn(false);
                AuthDevVerifyCodeActivity.this.mHandler.postDelayed(this, 1000L);
            }
        };
    }

    private boolean checkNetworkAvailable() {
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(getString(R.string.b3j));
            return false;
        }
        return true;
    }

    private void hideProgressDialog() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevVerifyCodeActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AuthDevVerifyCodeActivity.this.mProDialog != null && AuthDevVerifyCodeActivity.this.mProDialog.isShowing()) {
                        AuthDevVerifyCodeActivity.this.mProDialog.dismiss();
                        AuthDevVerifyCodeActivity.this.mProDialog.cancel();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                AuthDevVerifyCodeActivity.this.mProDialog = null;
            }
        });
    }

    private void initViews() {
        setTitleText(this.verifyCodeView.b());
        setTitleHint();
        setProgressBarVisible(false);
        long currentTimeMillis = System.currentTimeMillis() - com.tencent.mobileqq.loginregister.y.f243060b;
        if (currentTimeMillis >= 59000) {
            mSecond = 1;
        } else {
            mSecond = (int) ((60000 - currentTimeMillis) / 1000);
        }
        if (mSecond > 1) {
            refreshSendCodeBtn(false);
            this.mHandler.postDelayed(this.runnableCountdown, 1000L);
        } else {
            refreshSendCodeBtn(true);
        }
        TextView textView = (TextView) findViewById(R.id.an9);
        this.btnLeftBack = textView;
        textView.setOnClickListener(this);
    }

    private void jumpToOtherVerify() {
        Bundle extras;
        DevlockInfo devlockInfo;
        boolean z16;
        Intent intent = getIntent();
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
            if (devlockInfo == null) {
                return;
            }
            String string = extras.getString("uin");
            extras.getString("from_where");
            String string2 = extras.getString("mainaccount");
            if (string2 != null && !string2.equals(string)) {
                z16 = true;
            } else {
                z16 = false;
            }
            startWebAuxiliaryVerify(devlockInfo, string, z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "get devInfo error : ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserCancel() {
        ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
        if (iSmsVerifyCodeService != null) {
            iSmsVerifyCodeService.handleSmsVerifyCodeCancel(this, new Bundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSendCodeBtn(boolean z16) {
        this.verifyCodeView.c(z16, this.hasClickSendSms, mSecond);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report898ForFunctionTipDialog(String str) {
        int i3;
        String loginUinForReport = ((ILoginReporter) QRoute.api(ILoginReporter.class)).getLoginUinForReport();
        if (this.hasClickSendSms) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        ReportController.r(this.mRuntime, "dc00898", "", loginUinForReport, str, str, i3, 0, "", "", "", "");
    }

    private void restartTimer(int i3) {
        mSecond = i3;
        com.tencent.mobileqq.loginregister.y.f243060b = System.currentTimeMillis();
        if (this.verifyCodeView != null) {
            refreshSendCodeBtn(false);
        }
        this.mHandler.postDelayed(this.runnableCountdown, 1000L);
    }

    private void showProgressDialog() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevVerifyCodeActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AuthDevVerifyCodeActivity.this.mProDialog == null && !AuthDevVerifyCodeActivity.this.isFinishing()) {
                        AuthDevVerifyCodeActivity authDevVerifyCodeActivity = AuthDevVerifyCodeActivity.this;
                        AuthDevVerifyCodeActivity authDevVerifyCodeActivity2 = AuthDevVerifyCodeActivity.this;
                        authDevVerifyCodeActivity.mProDialog = new QQProgressDialog(authDevVerifyCodeActivity2, authDevVerifyCodeActivity2.getTitleBarHeight());
                        AuthDevVerifyCodeActivity.this.mProDialog.setMessage(AuthDevVerifyCodeActivity.this.getString(R.string.f211275kd));
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (AuthDevVerifyCodeActivity.this.mProDialog != null && !AuthDevVerifyCodeActivity.this.mProDialog.isShowing()) {
                    AuthDevVerifyCodeActivity.this.mProDialog.show();
                }
            }
        });
    }

    private void showToast(String str) {
        QQToast.makeText(this, str, 0).show(getTitleBarHeight());
        com.tencent.mobileqq.util.as.g(this.mRuntime, "0X800C19B", "", 0, str);
    }

    private void startWebAuxiliaryVerify(DevlockInfo devlockInfo, String str, boolean z16) {
        QLog.d(TAG, 1, "startWebAuxiliaryVerify");
        Bundle bundle = new Bundle();
        bundle.putString("subAccountUin", str);
        bundle.putBoolean("isSubaccount", z16);
        bundle.putBoolean("avoidLoginWeb", z16);
        String str2 = devlockInfo.OtherDevLockVerifyUrl;
        String g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g();
        if (!TextUtils.isEmpty(g16)) {
            str2 = DevLockVerifyComponent.h(str2, g16);
        }
        com.tencent.mobileqq.login.verify.t.e(this, str2, bundle, 1, str, false, new c());
    }

    @Override // com.tencent.mobileqq.loginregister.q
    public void clearWrongCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.verifysms.a aVar = this.verifyCodeView;
        if (aVar != null) {
            aVar.clearWrongCode();
        }
    }

    protected void commitSmsCode() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(getString(R.string.b3j));
            return;
        }
        com.tencent.mobileqq.activity.verifysms.a aVar = this.verifyCodeView;
        if (aVar != null) {
            str = aVar.a();
        } else {
            str = null;
        }
        if (str != null) {
            str = str.trim();
        }
        this.mVerifyProxy.b(this, this, str);
        this.isSmsChecked = true;
    }

    @Override // com.tencent.mobileqq.loginregister.q
    public void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            hideProgressDialog();
        }
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.doOnActivityResult(i3, i16, intent);
            this.mVerifyProxy.a(this, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.dzd);
        AppRuntime appRuntime = this.mRuntime;
        if (appRuntime == null) {
            appRuntime = getAppRuntime();
        }
        if (appRuntime == null) {
            finish();
            return false;
        }
        this.mVerifyProxy = new com.tencent.mobileqq.loginregister.e();
        Intent intent = getIntent();
        this.phoneNum = intent.getExtras().getString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
        this.mEntrance = intent.getStringExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        String string = intent.getExtras().getString("country_code");
        if (!TextUtils.isEmpty(string)) {
            this.countryCode = string;
        }
        boolean booleanExtra = intent.getBooleanExtra(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN, false);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_layout);
        if (booleanExtra) {
            com.tencent.mobileqq.util.w.a(this, relativeLayout);
            this.verifyCodeView = new com.tencent.mobileqq.activity.verifysms.d(getLayoutInflater(), relativeLayout, this);
        } else {
            getWindow().setSoftInputMode(5);
            this.verifyCodeView = new com.tencent.mobileqq.activity.verifysms.b(getLayoutInflater(), relativeLayout, this, this);
        }
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        setTitleText(this.verifyCodeView.b());
        initViews();
        this.isSmsChecked = false;
        this.hasUserClickStay = false;
        this.mVerifyProxy.d(this, this);
        if (this.verifyCodeView.f() && mSecond <= 1 && checkNetworkAvailable()) {
            this.hasClickSendSms = this.mVerifyProxy.c(this, this);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        com.tencent.mobileqq.loginregister.e eVar = this.mVerifyProxy;
        if (eVar != null) {
            eVar.onActivityResume();
        }
    }

    protected AppRuntime getReportRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return getAppRuntime();
    }

    @Override // com.tencent.mobileqq.loginregister.q
    public void loginSuccessCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.hasUserClickStay) {
            report898("0X800BB54");
        }
        ILoginReporter iLoginReporter = (ILoginReporter) QRoute.api(ILoginReporter.class);
        ReportController.r(getReportRuntime(), "dc00898", "", iLoginReporter.getLoginUinForReport(), "0X800BC48", "0X800BC48", iLoginReporter.getLoginEntranceForReport(), 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        boolean z16;
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        report898ForAutoGatewayVerify("0X800C10C");
        boolean z17 = false;
        if (getIntent().getBooleanExtra(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN, false) && !this.hasClickSendSms && this.clickOtherVerifyBtnLastTime == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            string = getString(R.string.f200294rq);
            string2 = getString(R.string.f200194rg);
            z17 = true;
        } else {
            if (this.hasClickSendSms && !this.isSmsChecked) {
                z17 = true;
            }
            string = getString(R.string.f211655le);
            string2 = getString(R.string.f212165ms);
        }
        if (z17) {
            DialogUtil.createCustomDialog(this, 230, (String) null, string, getString(R.string.f200394s0), string2, new a(z16), new b(z16)).show();
            if (z16) {
                report898ForFunctionTipDialog("0X800C295");
            } else {
                report898("0X800BB51");
            }
            return true;
        }
        onUserCancel();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.aji) {
                if (mSecond <= 1 && checkNetworkAvailable()) {
                    this.mVerifyProxy.e(this, this);
                    if (this.hasClickSendSms) {
                        str = "0X800C10A";
                    } else {
                        str = "0X800C109";
                    }
                    report898ForAutoGatewayVerify(str);
                    this.hasClickSendSms = true;
                }
            } else if (view.getId() == R.id.an9) {
                onBackEvent();
                String currentUin = getAppRuntime().getCurrentUin();
                if (TextUtils.isEmpty(currentUin)) {
                    currentUin = this.phoneNum;
                }
                ReportController.r(this.mRuntime, "dc00898", "", currentUin, "0X800BB50", "0X800BB50", 0, 0, "", "", "", "");
            } else if (id5 == R.id.tfu) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.clickOtherVerifyBtnLastTime >= 500) {
                    this.clickOtherVerifyBtnLastTime = currentTimeMillis;
                    jumpToOtherVerify();
                    report898ForAutoGatewayVerify("0X800C10B");
                }
            } else if (id5 == R.id.b7p) {
                commitSmsCode();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        this.mHandler.removeCallbacksAndMessages(null);
        hideProgressDialog();
        com.tencent.mobileqq.loginregister.e eVar = this.mVerifyProxy;
        if (eVar != null) {
            eVar.onActivityDestroy();
        }
    }

    @Override // com.tencent.mobileqq.widget.VerifyCodeView.a
    public void onVerifyCodeChanged(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str);
        } else if (z16) {
            commitSmsCode();
        }
    }

    public void report898(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        ILoginReporter iLoginReporter = (ILoginReporter) QRoute.api(ILoginReporter.class);
        ReportController.r(this.mRuntime, "dc00898", "", iLoginReporter.getLoginUinForReport(), str, str, iLoginReporter.getLoginEntranceForReport(), 0, "", "", "", "");
    }

    public void report898ForAutoGatewayVerify(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            report898(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity
    public void setTitleHint() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this.verifyCodeView == null || (str = this.phoneNum) == null || str.length() < 3 || this.verifyCodeView.d(this.countryCode, getMaskedPhoneNum())) {
                return;
            }
            super.setTitleHint();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.q
    public void showLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            showProgressDialog();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.q
    public void startTimer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            restartTimer(i3);
        }
    }
}
