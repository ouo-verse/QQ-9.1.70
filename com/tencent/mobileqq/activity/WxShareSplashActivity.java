package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.InputStream;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@RoutePage(desc = "\u5fae\u4fe1\u5206\u4eab\u95ea\u5c4f\u9875", path = RouterConstants.UI_ROUTER_WX_SHARE)
/* loaded from: classes9.dex */
public class WxShareSplashActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    private static final int SPLASHING_TIME_MS = 1000;
    private static final String TAG = "WxShareSplashActivity";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f177643d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f177644e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f177645f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f177646h;

        a(QQCustomDialog qQCustomDialog, String str, String str2, String str3) {
            this.f177643d = qQCustomDialog;
            this.f177644e = str;
            this.f177645f = str2;
            this.f177646h = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WxShareSplashActivity.this, qQCustomDialog, str, str2, str3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            this.f177643d.setOnDismissListener(null);
            SimpleAccount simpleAccount = WxShareSplashActivity.this.getSimpleAccount(this.f177644e);
            if (simpleAccount != null) {
                QLog.d(WxShareSplashActivity.TAG, 2, "onConfirm auto switch account");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                peekAppRuntime.logout(true);
                peekAppRuntime.login(simpleAccount);
                WxShareSplashActivity.this.doJumpAction(this.f177645f, this.f177646h);
                dialogInterface.dismiss();
                return;
            }
            QLog.d(WxShareSplashActivity.TAG, 2, "onConfirm to LoginActivity switch account");
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, this.f177645f);
            intent.putExtra("is_change_account", true);
            intent.putExtra("pkg_name", this.f177646h);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra("loginFragmentType", 5);
            intent.putExtra("uin", this.f177644e);
            RouteUtils.startActivity(WxShareSplashActivity.this, intent, RouterConstants.UI_ROUTER_LOGIN);
            dialogInterface.dismiss();
            WxShareSplashActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WxShareSplashActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                QLog.d(WxShareSplashActivity.TAG, 2, "onCancel do not switch account");
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f177649d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f177650e;

        c(String str, String str2) {
            this.f177649d = str;
            this.f177650e = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WxShareSplashActivity.this, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            QLog.d(WxShareSplashActivity.TAG, 2, "onDismiss do not switch account");
            WxShareSplashActivity.this.doJumpAction(this.f177649d, this.f177650e);
            WxShareSplashActivity.this.finish();
        }
    }

    public WxShareSplashActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJumpAction(String str, String str2) {
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "doJumpAction");
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) getAppRuntime(), getActivity(), str);
            if (c16 != null) {
                c16.B(str2);
                c16.b();
            } else {
                QLog.e(TAG, 1, "ja == null");
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.f173065h22), 0).show();
            }
        } else {
            QLog.e(TAG, 1, "scheme is empty");
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.f173065h22), 0).show();
        }
        finish();
    }

    private void doJumpActionAfterDelay(String str, String str2) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(str, str2) { // from class: com.tencent.mobileqq.activity.WxShareSplashActivity.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f177641d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f177642e;

            {
                this.f177641d = str;
                this.f177642e = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, WxShareSplashActivity.this, str, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    WxShareSplashActivity.this.doJumpAction(this.f177641d, this.f177642e);
                    WxShareSplashActivity.this.finish();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SimpleAccount getSimpleAccount(String str) {
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (simpleAccount != null && TextUtils.equals(str, simpleAccount.getUin()) && simpleAccount.isLogined()) {
                    return simpleAccount;
                }
            }
            return null;
        }
        return null;
    }

    private Drawable loadLogoDrawable() {
        InputStream inputStream;
        try {
            inputStream = getAssets().open(com.tencent.mobileqq.splash.f.f288712a.b());
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            return new BitmapDrawable(getResources(), inputStream);
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e(TAG, 1, "logo drawable open:", th);
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (Throwable th7) {
                    QLog.e(TAG, 1, "logo drawable close:", th7);
                    return null;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th8) {
                        QLog.e(TAG, 1, "logo drawable close:", th8);
                    }
                }
            }
        }
    }

    private Drawable loadMainDrawable() {
        InputStream inputStream;
        try {
            inputStream = getAssets().open(com.tencent.mobileqq.splash.f.f288712a.d());
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            return new BitmapDrawable(getResources(), inputStream);
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e(TAG, 1, "main drawable open:", th);
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (Throwable th7) {
                    QLog.e(TAG, 1, "main drawable close:", th7);
                    return null;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th8) {
                        QLog.e(TAG, 1, "main drawable close:", th8);
                    }
                }
            }
        }
    }

    private void showSwitchAccountConfirmDialog(String str, String str2, String str3) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        createCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.f242227u0));
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f242237u1));
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f242217tz), new a(createCustomDialog, str, str2, str3));
        createCustomDialog.setNegativeButton(getString(R.string.f242207ty), new b());
        createCustomDialog.setOnDismissListener(new c(str2, str3));
        createCustomDialog.show();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.gx_, (ViewGroup) null);
        if (getIntent().getBooleanExtra(AppConstants.Key.SHARE_REQ_WX_USING_SPLASH_BACKGROUND, true)) {
            View splashWidget = ((IQJumpApi) QRoute.api(IQJumpApi.class)).getSplashWidget(this, loadMainDrawable(), loadLogoDrawable());
            if (splashWidget.getParent() != null) {
                ((ViewGroup) splashWidget.getParent()).removeView(splashWidget);
            }
            viewGroup.addView(splashWidget, -1, -1);
        }
        setContentView(viewGroup);
        String stringExtra = getIntent().getStringExtra(AppConstants.Key.SHARE_REQ_WX_UIN_FROM_WX);
        String currentAccountUin = getAppRuntime().getCurrentAccountUin();
        String stringExtra2 = getIntent().getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        String stringExtra3 = getIntent().getStringExtra("pkg_name");
        QLog.d(TAG, 1, "uinFromWx=" + stringExtra + " uinInQQ=" + currentAccountUin + " scheme=" + stringExtra2 + " pkgName=" + stringExtra3);
        if (((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).isUinValid(stringExtra) && !TextUtils.equals(stringExtra, currentAccountUin)) {
            showSwitchAccountConfirmDialog(stringExtra, stringExtra2, stringExtra3);
        } else {
            doJumpActionAfterDelay(stringExtra2, stringExtra3);
        }
        super.doOnCreate(bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d(TAG, 4, "finish onAccountChanged");
        super.onAccountChanged();
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
