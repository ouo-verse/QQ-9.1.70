package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends d {
    static IPatchRedirector $redirector_;
    private float[] K;

    public g(Context context, int i3, SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) throws OrientationProviderNotFound {
        super(context, i3, sensorManager, interfaceC7424a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), sensorManager, interfaceC7424a);
            return;
        }
        this.K = new float[16];
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 11);
        if (defaultSensor != null) {
            this.f199771d.add(defaultSensor);
            return;
        }
        throw new OrientationProviderNotFound(String.valueOf(3));
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
        } else {
            com.tencent.mobileqq.armap.sensor.c.b(this.K, sensorEvent);
            super.g(this.K);
        }
    }
}
