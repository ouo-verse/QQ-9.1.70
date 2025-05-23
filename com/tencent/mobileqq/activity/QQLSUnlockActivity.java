package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.IQWalletConst;
import mqq.app.AppRuntime;
import mqq.util.AndroidOUIWrapperUtil;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQLSUnlockActivity extends Activity implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    static int f176846e;

    /* renamed from: d, reason: collision with root package name */
    Handler f176847d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67364);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f176846e = 30000;
        }
    }

    public QQLSUnlockActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int a() {
        int i3;
        try {
            i3 = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QQLSActivity", 4, "getScreenOffTime e=" + e16.getMessage());
            }
            i3 = 10000;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QQLSActivity", 4, "getScreenOffTime " + i3);
        }
        int i16 = f176846e;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        }
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("LSUnlockActivity", 2, "QQLSUnlockActivity finish");
            }
            finish();
            return false;
        }
        return false;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("LSUnlockActivity", 2, "onBackPressed ");
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        BaseApplicationImpl.getApplication().addCommonActivity(this);
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 26) {
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
            if (keyguardManager != null) {
                keyguardManager.requestDismissKeyguard(this, null);
            }
        } else {
            getWindow().addFlags(4194304);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
        }
        this.f176847d = new Handler(this);
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "enter QQLSUnlockActivity");
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            ((PowerManager) getSystemService("power")).newWakeLock(268435462, "test").acquire(a());
        }
        this.f176847d.sendEmptyMessageDelayed(0, 1500L);
        if (getIntent().getBooleanExtra(IQWalletConst.FROM_WALLET_UNLOCK, false)) {
            QQNotificationManager.getInstance().cancel("QQLSActivity", 238);
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).onQQForeground((QQAppInterface) runtime, false);
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            BaseApplicationImpl.getApplication().removeCommonActivity(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPause();
            com.tencent.qqperf.monitor.crash.tools.b.h(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onResume();
            com.tencent.qqperf.monitor.crash.tools.b.i(this);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
        } else if (QLog.isColorLevel()) {
            QLog.d("LSUnlockActivity", 2, "onSaveInstanceState ");
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            super.setRequestedOrientation(i3);
        }
    }
}
