package com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.SensorUtil;
import com.tencent.sveffects.SdkContext;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SensorEventHandler implements SensorEventListener {
    public static String TAG = "SensorEventHandler";
    private Context mContext;
    private int mDeviceRotation;
    private float[] rotationMatrix = new float[16];
    private SensorHandlerCallback sensorHandlerCallback;
    private SensorManager sensorManager;
    private boolean sensorRegistered;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface CameraChangedCallBack {
        void onCameraChanged(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface SensorHandlerCallback {
        void updateSensorMatrix(float[] fArr);
    }

    public SensorEventHandler(Context context) {
        this.mContext = context;
    }

    public void init() {
        this.sensorRegistered = false;
        if (!SdkContext.getInstance().getResources().getSensorResource().checkSensorEnable()) {
            return;
        }
        SdkContext.getInstance().getResources().getSensorResource().registerListener(this);
        this.sensorRegistered = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.accuracy != 0 && sensorEvent.sensor.getType() == 11) {
            int rotation = SdkContext.getInstance().getResources().getSensorResource().getRotation();
            this.mDeviceRotation = rotation;
            SensorUtil.sensorRotationVectorToMatrix(sensorEvent, rotation, this.rotationMatrix);
            this.sensorHandlerCallback.updateSensorMatrix(this.rotationMatrix);
        }
    }

    public void releaseResources() {
        if (!this.sensorRegistered) {
            return;
        }
        SdkContext.getInstance().getResources().getSensorResource().unregisterListener(this);
        this.sensorRegistered = false;
    }

    public void setSensorHandlerCallback(SensorHandlerCallback sensorHandlerCallback) {
        this.sensorHandlerCallback = sensorHandlerCallback;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
