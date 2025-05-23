package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* loaded from: classes9.dex */
public class VerifyPhoneNumActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ViewGroup f177486a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f177487b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f177488c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f177489d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f177490e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f177491f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f177492g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f177493h0;

    /* renamed from: i0, reason: collision with root package name */
    private byte[] f177494i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f177495j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f177496k0;

    /* renamed from: l0, reason: collision with root package name */
    private Handler f177497l0;

    /* renamed from: m0, reason: collision with root package name */
    protected Dialog f177498m0;

    /* renamed from: n0, reason: collision with root package name */
    com.tencent.mobileqq.loginregister.servlet.h f177499n0;

    /* renamed from: o0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f177500o0;

    /* renamed from: p0, reason: collision with root package name */
    private Handler f177501p0;

    /* renamed from: q0, reason: collision with root package name */
    private QQProgressDialog f177502q0;

    /* renamed from: com.tencent.mobileqq.activity.VerifyPhoneNumActivity$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f177503d;
        final /* synthetic */ VerifyPhoneNumActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            VerifyPhoneNumActivity verifyPhoneNumActivity = this.this$0;
            verifyPhoneNumActivity.f177498m0 = new ReportDialog(verifyPhoneNumActivity, R.style.qZoneInputDialog);
            this.this$0.f177498m0.setContentView(R.layout.account_wait);
            ((TextView) this.this$0.f177498m0.findViewById(R.id.dialogText)).setText(this.this$0.getString(this.f177503d));
            this.this$0.f177498m0.show();
        }
    }

    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
            }
        }
    }

    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void p(int i3, String str, com.tencent.mobileqq.login.aj ajVar, DevlockInfo devlockInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VerifyPhoneNumActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + str + " ret=" + i3);
                if (ajVar != null) {
                    QLog.d("VerifyPhoneNumActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + ajVar.f241866c);
                }
            }
            if (i3 != 0) {
                VerifyPhoneNumActivity.this.hideProgerssDialog();
                VerifyPhoneNumActivity.this.Q2();
            }
        }
    }

    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onReBindMblWTLogin(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VerifyPhoneNumActivity", 2, "VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = " + z16 + "; resultOk = " + z17);
            }
            VerifyPhoneNumActivity.this.closeDialog();
            if (!z16) {
                VerifyPhoneNumActivity.this.N2();
            } else if (z17) {
                VerifyPhoneNumActivity.this.f177496k0 = true;
                VerifyPhoneNumActivity.this.N2();
            } else {
                VerifyPhoneNumActivity.this.N2();
            }
        }
    }

    public VerifyPhoneNumActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177494i0 = null;
        this.f177495j0 = null;
        this.f177496k0 = false;
        this.f177497l0 = new a();
        this.f177499n0 = new b();
        this.f177500o0 = new c();
        this.f177501p0 = new Handler();
    }

    private void M2() {
        ContactBindServlet.B(this.app, this.f177494i0, this.f177493h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        if (QLog.isColorLevel()) {
            QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
        }
        com.tencent.mobileqq.phonelogin.a.a().e(true);
        int stViaSMSVerifyLogin = ((ILoginServletService) this.mRuntime.getRuntimeService(ILoginServletService.class, "all")).getStViaSMSVerifyLogin(this.f177491f0, this.f177490e0, false, false, null, this.f177499n0);
        if (stViaSMSVerifyLogin != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("VerifyPhoneNumActivity", 4, "startLogin.GetStViaSMSVerifyLogin ret =" + stViaSMSVerifyLogin);
            }
            hideProgerssDialog();
            Q2();
        }
    }

    private void P2() {
        MqqHandler handler = this.app.getHandler(com.tencent.mobileqq.loginregister.v.class);
        if (handler != null) {
            handler.sendEmptyMessage(2004);
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this);
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        aliasIntent.addFlags(67108864);
        startActivity(aliasIntent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2() {
        Intent intent = new Intent();
        intent.putExtra("uin", this.f177493h0);
        intent.putExtra(NotificationActivity.PASSWORD, this.f177495j0);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.addFlags(131072);
        RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgerssDialog() {
        this.f177501p0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.VerifyPhoneNumActivity.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
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
                    if (VerifyPhoneNumActivity.this.f177502q0 != null && VerifyPhoneNumActivity.this.f177502q0.isShowing()) {
                        VerifyPhoneNumActivity.this.f177502q0.dismiss();
                        VerifyPhoneNumActivity.this.f177502q0.cancel();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                VerifyPhoneNumActivity.this.f177502q0 = null;
            }
        });
    }

    private void initViews() {
        this.leftView.setVisibility(8);
        Button button = (Button) this.f177486a0.findViewById(R.id.afw);
        this.f177487b0 = button;
        button.setOnClickListener(this);
        Button button2 = (Button) this.f177486a0.findViewById(R.id.aim);
        this.f177488c0 = button2;
        button2.setOnClickListener(this);
        this.f177489d0 = (TextView) this.f177486a0.findViewById(R.id.kdb);
        try {
            String str = this.f177492g0;
            if (str != null && str.length() > 4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("***");
                String str2 = this.f177492g0;
                sb5.append(str2.substring(str2.length() - 4, this.f177492g0.length()));
                this.f177489d0.setText(getString(R.string.csd, this.f177490e0, sb5.toString(), this.f177493h0));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void showProgressDialog() {
        this.f177501p0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.VerifyPhoneNumActivity.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
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
                    if (VerifyPhoneNumActivity.this.f177502q0 == null && !VerifyPhoneNumActivity.this.isFinishing()) {
                        VerifyPhoneNumActivity.this.f177502q0 = new QQProgressDialog(VerifyPhoneNumActivity.this.getActivity(), VerifyPhoneNumActivity.this.getTitleBarHeight());
                        VerifyPhoneNumActivity.this.f177502q0.setMessage(R.string.cpr);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (VerifyPhoneNumActivity.this.f177502q0 != null && !VerifyPhoneNumActivity.this.f177502q0.isShowing()) {
                    VerifyPhoneNumActivity.this.f177502q0.show();
                }
            }
        });
    }

    protected void closeDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            this.f177497l0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.VerifyPhoneNumActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Dialog dialog = VerifyPhoneNumActivity.this.f177498m0;
                    if (dialog != null && dialog.isShowing() && !VerifyPhoneNumActivity.this.isFinishing()) {
                        VerifyPhoneNumActivity.this.f177498m0.dismiss();
                    }
                    VerifyPhoneNumActivity.this.f177498m0 = null;
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f177486a0 = (ViewGroup) setContentViewB(R.layout.c2s);
        setTitle(R.string.ctp);
        this.f177490e0 = getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        this.f177491f0 = getIntent().getStringExtra("key");
        this.f177492g0 = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_BINDUIN);
        this.f177493h0 = getIntent().getStringExtra("uin");
        this.f177494i0 = getIntent().getByteArrayExtra(AppConstants.Key.KEY_REGISTER_SIGN);
        this.f177495j0 = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_PASSWORD);
        this.app.registObserver(this.f177500o0);
        initViews();
        setRightButton(R.string.cancel, this);
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
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onAccountChanged();
        QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
        if (isFinishing()) {
            return;
        }
        if (!com.tencent.mobileqq.phonelogin.a.a().c()) {
            QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
            return;
        }
        this.app.unRegistObserver(this.f177500o0);
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        this.app = qQAppInterface;
        qQAppInterface.registObserver(this.f177500o0);
        if (this.f177496k0) {
            this.app.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.VerifyPhoneNumActivity.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerifyPhoneNumActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IPhoneContactService) VerifyPhoneNumActivity.this.app.getRuntimeService(IPhoneContactService.class, "")).uploadPhoneContact();
                    }
                }
            });
            QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.uyc), 0).show();
        }
        QQAppInterface qQAppInterface2 = this.app;
        BusinessUtils.Z(qQAppInterface2, qQAppInterface2.getAccount());
        P2();
        hideProgerssDialog();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.afw) {
                showProgressDialog();
                M2();
            } else if (id5 == R.id.aim) {
                showProgressDialog();
                N2();
            } else if (id5 == R.id.ivTitleBtnRightText) {
                Q2();
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        closeDialog();
        this.app.unRegistObserver(this.f177500o0);
    }
}
