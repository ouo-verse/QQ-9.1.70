package com.qzone.common.activities.base;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShakeScreenShotLogic {

    /* renamed from: a, reason: collision with root package name */
    private ScreenShot f45435a;

    /* renamed from: b, reason: collision with root package name */
    ShakeListener f45436b;

    /* renamed from: c, reason: collision with root package name */
    Runnable f45437c;

    private void h() {
        j();
    }

    public void c() {
        h();
    }

    public void d() {
        try {
            i();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void e() {
        ScreenShot screenShot = this.f45435a;
        if (screenShot != null) {
            screenShot.i();
            this.f45435a = null;
        }
    }

    public void f(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.ShakeScreenShotLogic.1
            @Override // java.lang.Runnable
            public void run() {
                LocalMultiProcConfig.putString(AppConstants.PREF_SCREEN_SHOT, "currentactivity", str);
            }
        });
    }

    public void g() {
        ScreenShot screenShot = this.f45435a;
        if (screenShot != null) {
            screenShot.i();
            this.f45435a = null;
        }
    }

    public void i() {
        if (this.f45437c != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).removeTask(this.f45437c);
        }
        if (this.f45436b == null) {
            return;
        }
        ((SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.f45436b);
    }

    public void j() {
        if (this.f45437c == null) {
            this.f45437c = new Runnable() { // from class: com.qzone.common.activities.base.ShakeScreenShotLogic.2

                /* compiled from: P */
                /* renamed from: com.qzone.common.activities.base.ShakeScreenShotLogic$2$a */
                /* loaded from: classes39.dex */
                class a extends ShakeListener {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.app.ShakeListener
                    public void shake() {
                        BaseActivity baseActivity = (BaseActivity) BaseActivity.getTopActivity();
                        if (baseActivity == null) {
                            return;
                        }
                        String string = LocalMultiProcConfig.getString(AppConstants.PREF_SCREEN_SHOT, "currentactivity", null);
                        if (baseActivity.getClass().getName().equals(string)) {
                            boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false);
                            boolean b16 = com.tencent.mobileqq.util.ca.b(BaseApplication.getContext());
                            if (readValue && b16) {
                                if (ShakeScreenShotLogic.this.f45435a == null) {
                                    ShakeScreenShotLogic.this.f45435a = new ScreenShot(baseActivity.isMoveToBG ? baseActivity.getApplicationContext() : baseActivity, baseActivity.getWindow());
                                }
                                boolean isShowing = ShakeScreenShotLogic.this.f45435a.isShowing();
                                if (isShowing) {
                                    return;
                                }
                                ShakeScreenShotLogic.this.f45435a.f();
                                if (QLog.isColorLevel()) {
                                    QLog.d("BaseActivity", 2, "qzsnapshot activate " + string + isShowing);
                                }
                            }
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false)) {
                        SensorManager sensorManager = (SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                        ShakeScreenShotLogic shakeScreenShotLogic = ShakeScreenShotLogic.this;
                        if (shakeScreenShotLogic.f45436b == null) {
                            shakeScreenShotLogic.f45436b = new a();
                        }
                        SensorMonitor.registerListener(sensorManager, ShakeScreenShotLogic.this.f45436b, SensorMonitor.getDefaultSensor(sensorManager, 1), 0);
                    }
                }
            };
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(this.f45437c);
    }
}
