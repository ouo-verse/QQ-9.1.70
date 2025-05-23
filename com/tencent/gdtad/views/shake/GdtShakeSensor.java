package com.tencent.gdtad.views.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtShakeSensor implements SensorEventListener {
    private static final float DEFAULT_SHAKE_FACTOR_X = 1.0f;
    private static final float DEFAULT_SHAKE_FACTOR_Y = 1.0f;
    private static final float DEFAULT_SHAKE_FACTOR_Z = 0.5f;
    private static final float DEFAULT_SHAKE_THRESHOLD = 1.7f;
    private static final int DEFAULT_SHAKE_VALID_COUNT = 1;
    private static final float EARTH_GRAVITY = 9.8f;
    private static final int STATUS_COMPLETED = 2;
    private static final int STATUS_RUNNING = 1;
    private static final int STATUS_UNREGISTERED = 0;
    private static final String TAG = "GdtShakeSensor";
    private static final int UPDATE_INTERVAL_TIME = 16;
    private int mCurrentShakeCount;
    private long mLastUpdateTime;
    private int mStatus = 0;
    private SensorManager mSensorManager = null;
    private volatile WeakReference<OnShakeListener> mWeakShakeListener = null;
    private volatile WeakReference<OnShakeWithValueListener> mWeakShakeWithValueListener = null;
    private Params mParams = new Params();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnShakeListener {
        void onShakeComplete();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnShakeWithValueListener {
        void onShakeComplete(float f16, float f17, float f18, float f19);
    }

    private void notifyComplete(final float f16, final float f17, final float f18, final float f19) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gdtad.views.shake.GdtShakeSensor.4
            @Override // java.lang.Runnable
            public void run() {
                GdtShakeSensor.this.notifyCompleteImpl(f16, f17, f18, f19);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompleteImpl(float f16, float f17, float f18, float f19) {
        boolean z16;
        OnShakeWithValueListener onShakeWithValueListener;
        OnShakeListener onShakeListener;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[notifyCompleteImpl] inMainThraed:");
        boolean z17 = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(" inCommonThraed:");
        if (Looper.myLooper() != ThreadManagerV2.getQQCommonThreadLooper()) {
            z17 = false;
        }
        sb5.append(z17);
        GdtLog.i(TAG, sb5.toString());
        WeakReference<OnShakeListener> weakReference = this.mWeakShakeListener;
        if (weakReference != null && (onShakeListener = weakReference.get()) != null) {
            onShakeListener.onShakeComplete();
        }
        WeakReference<OnShakeWithValueListener> weakReference2 = this.mWeakShakeWithValueListener;
        if (weakReference2 != null && (onShakeWithValueListener = weakReference2.get()) != null) {
            onShakeWithValueListener.onShakeComplete(f16, f17, f18, f19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerImpl(Context context) {
        boolean z16;
        if (this.mStatus != 0) {
            GdtLog.e(TAG, "[registerImpl] error, mStatus != STATUS_UNREGISTERED");
            return;
        }
        if (context == null) {
            return;
        }
        Object systemService = context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        if (!(systemService instanceof SensorManager)) {
            return;
        }
        SensorManager sensorManager = (SensorManager) systemService;
        boolean z17 = true;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
        if (defaultSensor == null) {
            return;
        }
        this.mSensorManager = sensorManager;
        try {
            boolean registerListener = SensorMonitor.registerListener(sensorManager, this, defaultSensor, 1, new Handler(ThreadManagerV2.getQQCommonThreadLooper()));
            if (registerListener) {
                resetImpl();
                this.mStatus = 1;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[registerImpl] result:");
            sb5.append(registerListener);
            sb5.append(" inMainThraed:");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" inCommonThraed:");
            if (Looper.myLooper() != ThreadManagerV2.getQQCommonThreadLooper()) {
                z17 = false;
            }
            sb5.append(z17);
            GdtLog.i(TAG, sb5.toString());
        } catch (Throwable th5) {
            GdtLog.e(TAG, "[registerImpl]", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetImpl() {
        this.mLastUpdateTime = 0L;
        this.mCurrentShakeCount = 0;
        if (this.mStatus == 2) {
            this.mStatus = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterImpl(Context context) {
        boolean z16;
        if (this.mStatus == 0) {
            GdtLog.e(TAG, "[unregisterImpl] error, mStatus == STATUS_UNREGISTERED");
            return;
        }
        if (context == null) {
            return;
        }
        Object systemService = context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        if (!(systemService instanceof SensorManager)) {
            return;
        }
        ((SensorManager) systemService).unregisterListener(this);
        boolean z17 = false;
        this.mStatus = 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[unregisterImpl] inMainThraed:");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(" inCommonThraed:");
        if (Looper.myLooper() == ThreadManagerV2.getQQCommonThreadLooper()) {
            z17 = true;
        }
        sb5.append(z17);
        GdtLog.i(TAG, sb5.toString());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        GdtLog.i(TAG, "[onAccuracyChanged] accuracy = " + i3);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        boolean z16;
        boolean z17;
        if (this.mStatus == 1 && sensorEvent != null && (fArr = sensorEvent.values) != null && fArr.length == 3) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastUpdateTime < 16) {
                return;
            }
            this.mLastUpdateTime = currentTimeMillis;
            float[] fArr2 = sensorEvent.values;
            float f16 = fArr2[0];
            Params params = this.mParams;
            float f17 = f16 * params.factorX;
            float f18 = fArr2[1] * params.factorY;
            float f19 = fArr2[2] * params.factorZ;
            double sqrt = Math.sqrt((Math.pow(f17, 2.0d) + Math.pow(f18, 2.0d)) + Math.pow(f19, 2.0d)) / 9.800000190734863d;
            if (sqrt < this.mParams.threshold) {
                return;
            }
            if (Double.isNaN(sqrt)) {
                QLog.e(TAG, 1, "[onSensorChanged] shakeValue is NaN");
                return;
            }
            int i3 = this.mCurrentShakeCount + 1;
            this.mCurrentShakeCount = i3;
            if (i3 < this.mParams.validCount) {
                return;
            }
            this.mStatus = 2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onSensorChanged] x:");
            sb5.append(f17);
            sb5.append(" y:");
            sb5.append(f18);
            sb5.append(" z:");
            sb5.append(f19);
            sb5.append(" shakeValue:");
            sb5.append(sqrt);
            sb5.append(" inMainThraed:");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" inCommonThraed:");
            if (Looper.myLooper() == ThreadManagerV2.getQQCommonThreadLooper()) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            GdtLog.i(TAG, sb5.toString());
            float[] fArr3 = sensorEvent.values;
            notifyComplete(fArr3[0], fArr3[1], fArr3[2], (float) sqrt);
        }
    }

    public void register(Context context) {
        final WeakReference weakReference = new WeakReference(context);
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.gdtad.views.shake.GdtShakeSensor.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                GdtShakeSensor gdtShakeSensor = GdtShakeSensor.this;
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    context2 = (Context) weakReference2.get();
                } else {
                    context2 = null;
                }
                gdtShakeSensor.registerImpl(context2);
            }
        });
    }

    public void reset() {
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.gdtad.views.shake.GdtShakeSensor.2
            @Override // java.lang.Runnable
            public void run() {
                GdtShakeSensor.this.resetImpl();
            }
        });
    }

    public void setShakeFactor(Params params) {
        if (params != null && params.isValid()) {
            this.mParams = params;
        }
    }

    public void setShakeListener(WeakReference<OnShakeListener> weakReference) {
        this.mWeakShakeListener = weakReference;
    }

    public void setShakeWithValueListener(WeakReference<OnShakeWithValueListener> weakReference) {
        this.mWeakShakeWithValueListener = weakReference;
    }

    public void unregister(Context context) {
        final WeakReference weakReference = new WeakReference(context);
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.gdtad.views.shake.GdtShakeSensor.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                GdtShakeSensor gdtShakeSensor = GdtShakeSensor.this;
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    context2 = (Context) weakReference2.get();
                } else {
                    context2 = null;
                }
                gdtShakeSensor.unregisterImpl(context2);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class Params {
        public float factorX;
        public float factorY;
        public float factorZ;
        public float threshold;
        public int validCount;

        public Params() {
            this.factorX = 1.0f;
            this.factorY = 1.0f;
            this.factorZ = 0.5f;
            this.threshold = GdtShakeSensor.DEFAULT_SHAKE_THRESHOLD;
            this.validCount = 1;
        }

        public boolean isValid() {
            float f16 = this.factorX;
            if (f16 >= 0.0f && f16 <= 1.0f) {
                float f17 = this.factorY;
                if (f17 >= 0.0f && f17 <= 1.0f) {
                    float f18 = this.factorZ;
                    if (f18 >= 0.0f && f18 <= 1.0f && this.threshold >= 1.0f && this.validCount >= 1) {
                        return true;
                    }
                }
            }
            return false;
        }

        @NonNull
        public String toString() {
            return String.format("x: %f, y: %f, z: %f, th: %f, count:%d", Float.valueOf(this.factorX), Float.valueOf(this.factorY), Float.valueOf(this.factorZ), Float.valueOf(this.threshold), Integer.valueOf(this.validCount));
        }

        public Params(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
            this.factorX = 1.0f;
            this.factorY = 1.0f;
            this.factorZ = 0.5f;
            this.threshold = GdtShakeSensor.DEFAULT_SHAKE_THRESHOLD;
            this.validCount = 1;
            if (adInfo == null) {
                return;
            }
            this.factorX = adInfo.display_info.interactive.x_axis_acceleration_rate.get() / 1000.0f;
            this.factorY = adInfo.display_info.interactive.y_axis_acceleration_rate.get() / 1000.0f;
            this.factorZ = adInfo.display_info.interactive.z_axis_acceleration_rate.get() / 1000.0f;
            this.threshold = adInfo.display_info.interactive.sensitivity.get() / 100.0f;
            this.validCount = adInfo.display_info.interactive.shake_times.get();
        }
    }
}
