package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class IHIDSensorManager {
    private static final String TAG = "IHIDSensorManager";
    public static volatile IHIDSensorManager mSensorManager;
    public Map<Integer, SensorEventListener> mListeners = new HashMap();
    public Map<Integer, Sensor> mSensors = new HashMap();
    public Map<Integer, Integer> mPeriods = new HashMap();

    public IHIDSensorManager() {
        try {
            Constructor declaredConstructor = SensorManager.class.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e16) {
            Log.e(TAG, e16.toString());
        }
        Log.i(TAG, "Created IHIDSensorManager");
    }

    public static IHIDSensorManager getSensorManager() {
        if (mSensorManager == null) {
            mSensorManager = new IHIDSensorManager();
        }
        return mSensorManager;
    }

    public Sensor getDefaultSensor(int i3) {
        Sensor sensor;
        Sensor sensor2 = this.mSensors.get(Integer.valueOf(i3));
        if (sensor2 == null) {
            try {
                Constructor declaredConstructor = Sensor.class.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                sensor = (Sensor) declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e16) {
                e = e16;
            }
            try {
                Field declaredField = Sensor.class.getDeclaredField(HttpMsg.MTYPE);
                declaredField.setAccessible(true);
                declaredField.set(sensor, Integer.valueOf(i3));
                this.mSensors.put(Integer.valueOf(i3), sensor);
                return sensor;
            } catch (Exception e17) {
                e = e17;
                sensor2 = sensor;
                Log.e(TAG, "Failed to get getDefaultSensor: " + e);
                return sensor2;
            }
        }
        return sensor2;
    }

    public boolean registerListener(SensorEventListener sensorEventListener, Sensor sensor, int i3) {
        synchronized (this.mListeners) {
            if (sensor != null) {
                this.mListeners.put(Integer.valueOf(sensor.getType()), sensorEventListener);
                this.mPeriods.put(Integer.valueOf(sensor.getType()), Integer.valueOf(i3));
            }
        }
        return true;
    }

    public void sendSensorEvent(int i3, float[] fArr) {
        int length = fArr.length;
        try {
            Constructor declaredConstructor = SensorEvent.class.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor.setAccessible(true);
            SensorEvent sensorEvent = (SensorEvent) declaredConstructor.newInstance(Integer.valueOf(length));
            sensorEvent.sensor = this.mSensors.get(Integer.valueOf(i3));
            sensorEvent.timestamp = System.currentTimeMillis();
            sensorEvent.accuracy = 1;
            for (int i16 = 0; i16 < length; i16++) {
                sensorEvent.values[i16] = fArr[i16];
            }
            if (this.mListeners.get(Integer.valueOf(i3)) != null) {
                synchronized (this.mListeners) {
                    this.mListeners.get(Integer.valueOf(i3)).onSensorChanged(sensorEvent);
                }
            }
        } catch (Exception e16) {
            Log.e(TAG, "Error: " + e16);
        }
    }

    public void unregisterListener(SensorEventListener sensorEventListener, Sensor sensor) {
        if (sensorEventListener != null && sensor != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(Integer.valueOf(sensor.getType()));
                this.mPeriods.remove(Integer.valueOf(sensor.getType()));
            }
        }
    }
}
