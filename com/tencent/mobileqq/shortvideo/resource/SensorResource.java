package com.tencent.mobileqq.shortvideo.resource;

import android.hardware.SensorEventListener;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface SensorResource {
    boolean checkSensorEnable();

    boolean getCameraIsFront();

    int getRotation();

    void registerListener(SensorEventListener sensorEventListener);

    void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack cameraChangedCallBack);

    void unregisterListener(SensorEventListener sensorEventListener);
}
