package com.tencent.aelight.camera.ae.camera.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationListener;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a {
    private static final boolean DEBUG = false;
    public static final int ORIENTATION_UNKNOWN = -1;
    private static final String TAG = "AEOrientationEventListener";
    private static final boolean localLOGV = false;
    private boolean mEnabled;
    private OrientationListener mOldListener;
    private int mOrientation;
    private int mRate;
    private Sensor mSensor;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;

    public a(Context context) {
        this(context, 3);
    }

    public boolean canDetectOrientation() {
        return this.mSensor != null;
    }

    public void disable() {
        if (this.mSensor == null) {
            ms.a.i(TAG, "Cannot detect sensors. Invalid disable");
            return;
        }
        try {
            this.mSensorManager.unregisterListener(this.mSensorEventListener);
            this.mEnabled = false;
        } catch (Throwable th5) {
            ms.a.c(TAG, "unregisterListener listener exception:" + th5);
        }
    }

    public void enable() {
        Sensor sensor = this.mSensor;
        if (sensor == null) {
            ms.a.i(TAG, "Cannot detect sensors. Not enabled");
            return;
        }
        if (this.mEnabled) {
            return;
        }
        try {
            SensorMonitor.registerListener(this.mSensorManager, this.mSensorEventListener, sensor, this.mRate);
            this.mEnabled = true;
        } catch (IllegalStateException e16) {
            ms.a.c(TAG, "OrientationEventListener exception:" + e16.getMessage());
        }
    }

    public abstract void onOrientationChanged(int i3);

    public abstract void onPoseChanged(float f16, float f17, float f18);

    void registerListener(OrientationListener orientationListener) {
        this.mOldListener = orientationListener;
    }

    public a(Context context, int i3) {
        this.mOrientation = -1;
        this.mEnabled = false;
        SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.mSensorManager = sensorManager;
        this.mRate = i3;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
        this.mSensor = defaultSensor;
        if (defaultSensor != null) {
            this.mSensorEventListener = new C0548a();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0548a implements SensorEventListener {
        C0548a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int i3;
            float[] fArr = sensorEvent.values;
            float f16 = -fArr[0];
            float f17 = -fArr[1];
            float f18 = -fArr[2];
            if (((f16 * f16) + (f17 * f17)) * 35.0f >= f18 * f18) {
                i3 = 90 - Math.round(((float) Math.atan2(-f17, f16)) * 57.29578f);
                while (i3 >= 360) {
                    i3 -= 360;
                }
                while (i3 < 0) {
                    i3 += 360;
                }
            } else {
                i3 = -1;
            }
            if (a.this.mOldListener != null) {
                a.this.mOldListener.onSensorChanged(1, sensorEvent.values);
            }
            if (i3 != a.this.mOrientation) {
                a.this.mOrientation = i3;
                a.this.onOrientationChanged(i3);
            }
            a.this.onPoseChanged(((f16 + 9.8f) * 180.0f) / 19.6f, ((f17 + 9.8f) * 180.0f) / 19.6f, ((f18 + 9.8f) * 180.0f) / 19.6f);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
