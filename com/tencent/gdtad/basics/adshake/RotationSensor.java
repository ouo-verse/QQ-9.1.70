package com.tencent.gdtad.basics.adshake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RotationSensor implements SensorEventListener {
    private static final float NS2S = 1.0E-9f;
    private static final String TAG = "RotationSensor";
    private static final String THREAD_NAME = "RotationSensor-Handler-Thread";
    private Context mContext;
    private Handler mHandler;
    private long mLastTimestamp;
    private OnRotationChangeListener mOnRotationChangeListener;
    private final float[] mRotationVector = new float[3];
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private int mStatus;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnRotationChangeListener {
        void onChanged(float f16, float f17, float f18);

        void onError();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    @interface Status {
        public static final int ERROR = -1;
        public static final int IDLE = 0;
        public static final int PAUSE = 2;
        public static final int RUNNING = 1;
    }

    public RotationSensor(Context context) {
        this.mContext = context;
        initRotationVector();
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        }
        return this.mHandler;
    }

    private void initRotationVector() {
        float[] fArr = this.mRotationVector;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private void initSensorManager() {
        SensorManager sensorManager;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        boolean z16 = false;
        try {
            if (this.mSensorManager == null) {
                this.mSensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            }
            if (this.mSensor == null && (sensorManager = this.mSensorManager) != null) {
                this.mSensor = SensorMonitor.getDefaultSensor(sensorManager, 4);
            }
            SensorManager sensorManager2 = this.mSensorManager;
            if (sensorManager2 != null) {
                z16 = SensorMonitor.registerListener(sensorManager2, this, this.mSensor, 2, getHandler());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initSensorManager error.", th5);
        }
        if (!z16) {
            this.mStatus = -1;
            OnRotationChangeListener onRotationChangeListener = this.mOnRotationChangeListener;
            if (onRotationChangeListener != null) {
                onRotationChangeListener.onError();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        long j3 = this.mLastTimestamp;
        if (j3 == 0) {
            this.mLastTimestamp = sensorEvent.timestamp;
            return;
        }
        long j16 = sensorEvent.timestamp;
        float f16 = ((float) (j16 - j3)) * NS2S;
        this.mLastTimestamp = j16;
        float[] fArr = sensorEvent.values;
        float f17 = fArr[0] * f16;
        float f18 = fArr[1] * f16;
        float f19 = fArr[2] * f16;
        float[] fArr2 = this.mRotationVector;
        float f26 = fArr2[0] + f17;
        fArr2[0] = f26;
        fArr2[1] = fArr2[1] + f18;
        fArr2[2] = fArr2[2] + f19;
        float degrees = (float) Math.toDegrees(f26);
        float degrees2 = (float) Math.toDegrees(this.mRotationVector[1]);
        float degrees3 = (float) Math.toDegrees(this.mRotationVector[2]);
        OnRotationChangeListener onRotationChangeListener = this.mOnRotationChangeListener;
        if (onRotationChangeListener != null) {
            onRotationChangeListener.onChanged(degrees, degrees2, degrees3);
        }
    }

    public void pause() {
        if (this.mStatus == 1) {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.mLastTimestamp = 0L;
            this.mStatus = 2;
        }
    }

    public void resetRotation() {
        this.mLastTimestamp = 0L;
        initRotationVector();
    }

    public void resume() {
        if (this.mStatus == 2) {
            initSensorManager();
            this.mStatus = 1;
        }
    }

    public void setOnRotationChangeListener(OnRotationChangeListener onRotationChangeListener) {
        this.mOnRotationChangeListener = onRotationChangeListener;
    }

    public void start() {
        if (this.mStatus == 0) {
            initRotationVector();
            initSensorManager();
            this.mStatus = 1;
        }
    }

    public void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.mSensor = null;
        this.mHandler = null;
        this.mStatus = 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
