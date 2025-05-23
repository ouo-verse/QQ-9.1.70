package com.tencent.mobileqq.app.activitymodule;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.app.api.IScreenShotService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScreenShotActivityModule extends AbsActivityModule {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ScreenShotActivityModule";
    private static boolean sSensorReady;
    private static BroadcastReceiver screenReceiver;
    private static ShakeListener shakeListener;
    private WeakReference<QBaseActivity> actRef;
    private IScreenShot screenShot;

    public ScreenShotActivityModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ShakeListener getShakeListener() {
        return shakeListener;
    }

    public static void setShakeListener(ShakeListener shakeListener2) {
        shakeListener = shakeListener2;
    }

    public void cleanScreenShot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IScreenShot iScreenShot = this.screenShot;
        if (iScreenShot != null) {
            iScreenShot.disactivate();
            this.screenShot = null;
            ((IScreenShotService) QRoute.api(IScreenShotService.class)).logForDev("BaseActivity cleanScreenShot");
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, (Object) bundle);
        } else if (!sSensorReady) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(activity) { // from class: com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f195243d;

                {
                    this.f195243d = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShotActivityModule.this, (Object) activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity2 = this.f195243d;
                    boolean z16 = false;
                    if (SettingCloneUtil.readValue((Context) activity2, (String) null, activity2.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false)) {
                        z16 = true;
                    }
                    if (z16) {
                        ScreenShotActivityModule.this.turnOnShake();
                    }
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                    intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                    BroadcastReceiver unused = ScreenShotActivityModule.screenReceiver = QQActivityModuleInjectUtil.sModuleCallback.newScreenReceiverInstance();
                    try {
                        this.f195243d.getApplicationContext().registerReceiver(ScreenShotActivityModule.screenReceiver, intentFilter);
                    } catch (Exception e16) {
                        QLog.e(ScreenShotActivityModule.TAG, 1, "", e16);
                    }
                }
            }, 300L);
            sSensorReady = true;
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShotActivityModule.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(AppConstants.PREF_SCREEN_SHOT, 4).edit();
                    edit.putString("currentactivity", getClass().getName());
                    edit.commit();
                }
            }, 64, null, true);
            super.doOnActivityResume(activity);
        }
    }

    public IScreenShot getScreenShot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IScreenShot) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.screenShot;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.activitymodule.IActivityModule
    public void init(IActivityPropertyProvider iActivityPropertyProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iActivityPropertyProvider);
        } else {
            this.actRef = new WeakReference<>((QBaseActivity) iActivityPropertyProvider.getActivity());
        }
    }

    public void setScreenShot(IScreenShot iScreenShot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iScreenShot);
        } else {
            this.screenShot = iScreenShot;
        }
    }

    public void turnOffShake() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShotActivityModule.this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (QBaseActivity.class) {
                    Activity activity = (Activity) ScreenShotActivityModule.this.actRef.get();
                    if (ScreenShotActivityModule.shakeListener != null && activity != null) {
                        QLog.d(ScreenShotActivityModule.TAG, 1, "unRegister Listener For Screen Shot");
                        ((SensorManager) activity.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(ScreenShotActivityModule.shakeListener);
                        ShakeListener unused = ScreenShotActivityModule.shakeListener = null;
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManager.getSubThreadHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    public void turnOnShake() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShotActivityModule.this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00d3 A[Catch: all -> 0x00dd, TryCatch #4 {, blocks: (B:11:0x0012, B:14:0x0026, B:16:0x0043, B:17:0x004a, B:25:0x00cd, B:27:0x00d3, B:28:0x00d9, B:38:0x007f, B:34:0x0093, B:36:0x00a7, B:32:0x00bb, B:39:0x00db, B:19:0x004f, B:20:0x006e, B:22:0x0074), top: B:10:0x0012, inners: #6, #5 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (QBaseActivity.class) {
                    Activity activity = (Activity) ScreenShotActivityModule.this.actRef.get();
                    if (ScreenShotActivityModule.shakeListener == null && activity != null) {
                        QLog.d(ScreenShotActivityModule.TAG, 1, "Register Listener For Screen Shot");
                        ShakeListener newShakeListener = QQActivityModuleInjectUtil.sModuleCallback.newShakeListener();
                        SensorManager sensorManager = (SensorManager) activity.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                        try {
                            try {
                                try {
                                    SensorMonitor.registerListener(sensorManager, newShakeListener, SensorMonitor.getDefaultSensor(sensorManager, 1), 2);
                                    ShakeListener unused = ScreenShotActivityModule.shakeListener = newShakeListener;
                                } catch (NoSuchFieldException e16) {
                                    str = "turnOnShake NoSuchFieldException=" + e16;
                                    if (!TextUtils.isEmpty(str)) {
                                    }
                                } catch (Throwable th5) {
                                    str = "turnOnShake Throwable=" + th5;
                                    if (!TextUtils.isEmpty(str)) {
                                    }
                                }
                            } catch (ClassNotFoundException e17) {
                                str = "turnOnShake ClassNotFoundException=" + e17;
                                if (!TextUtils.isEmpty(str)) {
                                }
                            } catch (IllegalAccessException e18) {
                                str = "turnOnShake IllegalAccessException=" + e18;
                                if (!TextUtils.isEmpty(str)) {
                                }
                            }
                        } catch (IllegalStateException unused2) {
                            Field declaredField = Class.forName("android.hardware.SystemSensorManager").getDeclaredField("mSensorListeners");
                            declaredField.setAccessible(true);
                            Iterator it = ((HashMap) declaredField.get(sensorManager)).keySet().iterator();
                            while (it.hasNext()) {
                                Objects.toString(it.next());
                            }
                            str = null;
                            if (!TextUtils.isEmpty(str)) {
                                QLog.d(ScreenShotActivityModule.TAG, 1, str);
                            }
                        }
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManager.getSubThreadHandler().post(runnable);
        } else {
            runnable.run();
        }
    }
}
