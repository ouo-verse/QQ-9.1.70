package com.tencent.mobileqq.app.lifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.IModuleCallback;
import com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.app.api.IScreenShotService;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ca;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ActivityModuleCallback implements IModuleCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final IGuardInterface f195812a;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivityModuleCallback.this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QBaseActivity f16 = ActivityModuleCallback.this.f();
            if (f16 != null && ScreenShotActivityModule.getShakeListener() != null) {
                boolean z16 = false;
                if (SettingCloneUtil.readValue((Context) f16, (String) null, f16.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false)) {
                    z16 = true;
                }
                if (z16) {
                    ActivityModuleCallback.this.e(f16).turnOffShake();
                }
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QBaseActivity f16 = ActivityModuleCallback.this.f();
            if (f16 != null && ScreenShotActivityModule.getShakeListener() == null) {
                boolean z16 = false;
                if (SettingCloneUtil.readValue((Context) f16, (String) null, f16.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false)) {
                    z16 = true;
                }
                if (z16) {
                    ActivityModuleCallback.this.e(f16).turnOnShake();
                }
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivityModuleCallback.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else {
                ActivityModuleCallback.this.b(context, intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class c extends ShakeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivityModuleCallback.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ShakeListener
        public void shake() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ActivityModuleCallback.this.c();
            }
        }
    }

    public ActivityModuleCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195812a = new a();
        }
    }

    private IScreenShot d(QBaseActivity qBaseActivity) {
        Context context;
        ScreenShotActivityModule e16 = e(qBaseActivity);
        IScreenShot screenShot = e16.getScreenShot();
        if (screenShot == null) {
            if (!qBaseActivity.isResume()) {
                context = qBaseActivity.getApplicationContext();
            } else {
                context = qBaseActivity;
            }
            IScreenShot newInstance = ((IScreenShotService) QRoute.api(IScreenShotService.class)).newInstance(context, qBaseActivity.getWindow());
            e16.setScreenShot(newInstance);
            return newInstance;
        }
        return screenShot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ScreenShotActivityModule e(QBaseActivity qBaseActivity) {
        return (ScreenShotActivityModule) qBaseActivity.getModule(ScreenShotActivityModule.class);
    }

    private boolean g() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            return guardManager.isApplicationForeground();
        }
        return Foreground.isCurrentProcessForeground();
    }

    public void b(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) intent);
            return;
        }
        QBaseActivity f16 = f();
        if (f16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("qqBaseActivity", 2, intent.getAction());
            }
        } else if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
            h(context, f16);
        } else if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
            i(context, f16);
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QBaseActivity f16 = f();
        if (f16 == null) {
            ScreenShot.s("MyShakeListener - top activity is null");
            return false;
        }
        if (!f16.mCurrentActivityShakeFlag) {
            ScreenShot.s("MyShakeListener - shake flag is false");
            return false;
        }
        if (ThreadManager.getSubThreadHandler().hasMessages(1001)) {
            return false;
        }
        ThreadManager.getSubThreadHandler().sendMessage(ThreadManager.getSubThreadHandler().obtainMessage(1001, new Runnable(f16) { // from class: com.tencent.mobileqq.app.lifecycle.ActivityModuleCallback.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f195813d;

            {
                this.f195813d = f16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActivityModuleCallback.this, (Object) f16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ActivityModuleCallback.this.j(this.f195813d);
                }
            }
        }));
        return true;
    }

    public QBaseActivity f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return QBaseActivity.sTopActivity;
    }

    public void h(Context context, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) qBaseActivity);
            return;
        }
        ILoginRegisterApi iLoginRegisterApi = (ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class);
        if (qBaseActivity.getStopFlag() != 0 || !qBaseActivity.isCanLock() || BaseGesturePWDUtil.getGesturePWDState(qBaseActivity, qBaseActivity.getCurrentAccountUinFromRuntime()) != 2 || BaseGesturePWDUtil.getGesturePWDMode(qBaseActivity, qBaseActivity.getCurrentAccountUinFromRuntime()) != 21 || (qBaseActivity instanceof GesturePWDUnlockActivity) || iLoginRegisterApi.getLoginActivityClass().isInstance(qBaseActivity) || BaseGesturePWDUtil.getGestureLocking(qBaseActivity)) {
            qBaseActivity.receiveScreenOff();
        }
        boolean z16 = false;
        QBaseActivity.mAppForground = false;
        GesturePWDUtils.setAppForground(context, false);
        QBaseActivity.isUnLockSuccess = false;
        if (ScreenShotActivityModule.getShakeListener() != null && g()) {
            if (SettingCloneUtil.readValue(context, (String) null, context.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false)) {
                z16 = true;
            }
            if (z16) {
                e(qBaseActivity).turnOffShake();
            }
        }
    }

    public void i(Context context, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) qBaseActivity);
            return;
        }
        if (ScreenShotActivityModule.getShakeListener() == null && g()) {
            boolean z16 = false;
            if (SettingCloneUtil.readValue(context, (String) null, context.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false)) {
                z16 = true;
            }
            if (z16) {
                e(qBaseActivity).turnOnShake();
            }
        }
    }

    public void j(QBaseActivity qBaseActivity) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!qBaseActivity.isResume()) {
            z16 = qBaseActivity.getClass().getName().equals(qBaseActivity.getSharedPreferences(AppConstants.PREF_SCREEN_SHOT, 4).getString("currentactivity", null));
        } else {
            z16 = true;
        }
        if (z16 && SettingCloneUtil.readValue((Context) qBaseActivity, (String) null, qBaseActivity.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false) && ca.b(BaseApplicationImpl.sApplication)) {
            if (!qBaseActivity.isSupportScreenShot()) {
                ScreenShot.s("MyShakeListener - not support screen shot");
                return;
            }
            IScreenShot d16 = d(qBaseActivity);
            if (!d16.isInit()) {
                return;
            }
            boolean isShowing = d16.isShowing();
            if (isShowing) {
                ScreenShot.s("MyShakeListener - screenshot is showing");
                return;
            }
            if (!d16.activate()) {
                ScreenShot.s("MyShakeListener - screenshot cant activate");
                e(qBaseActivity).cleanScreenShot();
            } else {
                boolean z17 = wy2.d.f446757g;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseActivity", 2, "snapshot activate " + isShowing);
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "cost:" + (uptimeMillis2 - uptimeMillis));
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IModuleCallback
    public BroadcastReceiver newScreenReceiverInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BroadcastReceiver) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IModuleCallback
    public ShakeListener newShakeListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ShakeListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.f195812a);
        }
        return new c();
    }
}
