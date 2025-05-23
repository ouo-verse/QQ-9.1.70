package com.tencent.gdtad.basics.adshake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ShakeSensor implements SensorEventListener {
    public static final float DEFAULT_SHAKE_FACTOR_X = 1.0f;
    public static final float DEFAULT_SHAKE_FACTOR_Y = 1.0f;
    public static final float DEFAULT_SHAKE_FACTOR_Z = 0.5f;
    public static final float DEFAULT_SHAKE_THRESHOLD = 3.0f;
    public static final int DEFAULT_SHAKE_VALID_COUNT = 60;
    private static final String TAG = "ShakeSensor";
    private static final int UPDATE_INTERVAL_TIME = 16;
    private Context mContext;
    private int mCurrentShakeCount;
    private boolean mIsComplete;
    private boolean mIsStart;
    private long mLastUpdateTime;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private float mShakeFactorX;
    private float mShakeFactorY;
    private float mShakeFactorZ;
    private OnShakeListener mShakeListener;
    private float mShakeThreshold;
    private int mShakeValidCount;

    public ShakeSensor(Context context) {
        this(context, 3.0f, 60);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        QLog.d(TAG, 1, " - onAccuracyChanged,  accuracy = " + i3);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mIsComplete) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastUpdateTime < 16) {
            return;
        }
        this.mLastUpdateTime = currentTimeMillis;
        float[] fArr = sensorEvent.values;
        double sqrt = Math.sqrt((Math.pow(fArr[0] * this.mShakeFactorX, 2.0d) + Math.pow(fArr[1] * this.mShakeFactorY, 2.0d)) + Math.pow(fArr[2] * this.mShakeFactorZ, 2.0d)) / 9.8d;
        if (sqrt >= this.mShakeThreshold) {
            this.mCurrentShakeCount++;
        }
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null && !this.mIsComplete) {
            onShakeListener.onShaking(sqrt, this.mCurrentShakeCount);
            if (this.mCurrentShakeCount >= this.mShakeValidCount) {
                this.mIsComplete = true;
                onShakeListener.onShakeComplete(sqrt);
            }
        }
    }

    public boolean register() {
        SensorManager sensorManager = (SensorManager) this.mContext.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.mSensorManager = sensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
            this.mSensor = defaultSensor;
            if (defaultSensor != null) {
                this.mIsStart = SensorMonitor.registerListener(this.mSensorManager, this, defaultSensor, 1);
            } else {
                QLog.w(TAG, 1, " - \u4f20\u611f\u5668\u521d\u59cb\u5316\u5931\u8d25!");
            }
        }
        return this.mIsStart;
    }

    public void reset() {
        this.mIsComplete = false;
        this.mLastUpdateTime = 0L;
        this.mCurrentShakeCount = 0;
    }

    public void setShakeFactor(float f16, float f17, float f18) {
        this.mShakeFactorX = f16;
        this.mShakeFactorY = f17;
        this.mShakeFactorZ = f18;
    }

    public void setShakeListener(OnShakeListener onShakeListener) {
        this.mShakeListener = onShakeListener;
    }

    public void unregister() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.mIsStart = false;
        this.mShakeListener = null;
        this.mShakeValidCount = 0;
    }

    public ShakeSensor(Context context, float f16, int i3) {
        this.mSensorManager = null;
        this.mSensor = null;
        this.mShakeListener = null;
        this.mShakeFactorX = 1.0f;
        this.mShakeFactorY = 1.0f;
        this.mShakeFactorZ = 0.5f;
        this.mIsStart = false;
        this.mContext = context;
        this.mShakeThreshold = f16;
        this.mShakeValidCount = i3;
        QLog.d(TAG, 1, " - threshold: " + f16 + "\uff0c validCount: " + i3);
    }
}
