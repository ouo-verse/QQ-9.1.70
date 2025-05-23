package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedVideoSensorManager {
    private ShakeListener mOnShakeInterface;

    public void register(Context context, ShakeListener shakeListener) {
        this.mOnShakeInterface = shakeListener;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        SensorMonitor.registerListener(sensorManager, this.mOnShakeInterface, SensorMonitor.getDefaultSensor(sensorManager, 1), 0);
    }

    public void unregister(Context context) {
        ((SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.mOnShakeInterface);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ShakeListener implements SensorEventListener {
        private static final int TOTAL_THRESHOLD = 180;
        private int mCnt = 0;
        private long mLastTime;
        private float mLastX;
        private float mLastY;
        private float mLastZ;
        private float mTotalShake;

        private void initShake(long j3) {
            this.mLastTime = j3;
            this.mLastX = 0.0f;
            this.mLastY = 0.0f;
            this.mLastZ = 0.0f;
            this.mTotalShake = 0.0f;
            this.mCnt = 0;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float f16 = fArr[0];
                float f17 = fArr[1];
                float f18 = fArr[2];
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - this.mLastTime;
                if (j3 > 5000) {
                    initShake(currentTimeMillis);
                    return;
                }
                if (j3 > 80) {
                    float f19 = this.mLastX;
                    float f26 = 0.0f;
                    if (f19 != 0.0f || this.mLastY != 0.0f || this.mLastZ != 0.0f) {
                        f26 = Math.abs(f18 - this.mLastZ) + Math.abs(f16 - f19) + Math.abs(f17 - this.mLastY);
                    }
                    float f27 = this.mTotalShake + f26;
                    this.mTotalShake = f27;
                    if (f27 > 180.0f && this.mCnt >= 3) {
                        shake();
                        initShake(currentTimeMillis);
                        return;
                    }
                    int i3 = this.mCnt;
                    if (i3 < 10) {
                        this.mCnt = i3 + 1;
                        this.mLastX = f16;
                        this.mLastY = f17;
                        this.mLastZ = f18;
                        this.mLastTime = currentTimeMillis;
                        return;
                    }
                    initShake(currentTimeMillis);
                }
            }
        }

        protected void shake() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
