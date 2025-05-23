package com.tencent.mobileqq.armap.sensor.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.mobileqq.armap.sensor.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends d {
    static IPatchRedirector $redirector_;
    private float[] K;

    public h(Context context, int i3, SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) throws OrientationProviderNotFound {
        super(context, i3, sensorManager, interfaceC7424a);
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), sensorManager, interfaceC7424a);
            return;
        }
        this.K = new float[4];
        if (i3 == 5) {
            i16 = 15;
        } else {
            i16 = 11;
        }
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, i16);
        Sensor defaultSensor2 = SensorMonitor.getDefaultSensor(sensorManager, 1);
        Sensor defaultSensor3 = SensorMonitor.getDefaultSensor(sensorManager, 4);
        if (defaultSensor3 != null && defaultSensor != null) {
            interfaceC7424a.onSensorSupport(4, true);
            this.f199771d.add(defaultSensor);
            QLog.i("OrientationProvider2", 2, "Gyroscope support,model:" + DeviceInfoMonitor.getModel() + ", manufacture:" + Build.MANUFACTURER);
        } else {
            interfaceC7424a.onSensorSupport(4, false);
            if (defaultSensor3 == null) {
                QLog.i("OrientationProvider2", 2, "Gyroscope not support,model:" + DeviceInfoMonitor.getModel() + ", manufacture:" + Build.MANUFACTURER);
            } else if (defaultSensor == null) {
                QLog.i("OrientationProvider2", 2, "Gyroscope not support(rotationVectorSensor),model:" + DeviceInfoMonitor.getModel() + ", manufacture:" + Build.MANUFACTURER);
            }
        }
        if (defaultSensor2 != null) {
            interfaceC7424a.onSensorSupport(1, true);
            this.f199771d.add(defaultSensor2);
        } else {
            interfaceC7424a.onSensorSupport(1, false);
        }
    }

    private void h(float f16, float f17, float f18, long j3) {
        a.InterfaceC7424a interfaceC7424a = this.f199774h;
        if (interfaceC7424a == null) {
            return;
        }
        interfaceC7424a.updateAccelerometer(f16, f17, f18, j3);
    }

    @Override // android.hardware.SensorEventListener
    @TargetApi(9)
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
            return;
        }
        if (sensorEvent.sensor.getType() != 11 && sensorEvent.sensor.getType() != 15) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                h(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
                return;
            }
            return;
        }
        try {
            SensorManager.getQuaternionFromVector(this.K, sensorEvent.values);
            this.f199774h.onRotationUpdateQuaternion(this.K);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
