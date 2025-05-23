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
public class c extends d {
    static IPatchRedirector $redirector_;
    private float[] K;
    private float[] L;
    private float[] M;
    boolean N;
    private float P;
    private float Q;
    private float R;

    public c(Context context, int i3, SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) throws OrientationProviderNotFound {
        super(context, i3, sensorManager, interfaceC7424a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), sensorManager, interfaceC7424a);
            return;
        }
        this.K = new float[3];
        this.L = new float[3];
        this.M = new float[16];
        this.N = false;
        this.P = -1.0f;
        this.Q = -1.0f;
        this.R = -1.0f;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
        if (defaultSensor != null) {
            this.f199771d.add(defaultSensor);
            return;
        }
        throw new OrientationProviderNotFound(String.valueOf(1));
    }

    private void h(float f16, float f17, float f18) {
        if (this.f199774h == null) {
            return;
        }
        if (Math.abs(f16 - this.P) > 1.0f) {
            this.P = f16;
            this.f199774h.updateAzimuth(f16);
        }
        if (Math.abs(f17 - this.Q) > 1.0f) {
            this.Q = f17;
            this.f199774h.updatePitch(f17);
        }
        if (Math.abs(f18 - this.R) > 1.0f) {
            this.R = f18;
            this.f199774h.updateRoll(f18);
        }
        this.f199774h.updateSensor(f16, f17, f18);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
            return;
        }
        if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, this.f199772e, 0, 3);
            float[] fArr = this.f199772e;
            float f16 = fArr[0];
            this.K[1] = -((float) Math.atan2(fArr[1], fArr[2]));
            this.K[2] = (float) Math.atan2(-f16, Math.sqrt((r5 * r5) + (r12 * r12)));
            if (this.N) {
                this.K = com.tencent.mobileqq.armap.sensor.b.a(this.K, this.L);
            }
            System.arraycopy(this.K, 0, this.L, 0, 3);
            this.N = true;
            com.tencent.mobileqq.armap.sensor.c.d(com.tencent.mobileqq.armap.sensor.c.a(this.K), this.M);
            if (this.J != 1) {
                super.g(this.M);
            } else {
                float[] fArr2 = this.K;
                h(0.0f, (float) ((fArr2[1] * 180.0f) / 3.141592653589793d), (float) ((fArr2[2] * 180.0f) / 3.141592653589793d));
            }
        }
    }
}
