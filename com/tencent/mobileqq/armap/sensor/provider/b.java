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
public class b extends d {
    static IPatchRedirector $redirector_;
    private float[] K;
    private float[] L;
    private float[] M;
    private float[] N;
    private float[] P;
    private float[] Q;
    boolean R;
    private float S;
    private float T;
    private float U;

    public b(Context context, int i3, SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) throws OrientationProviderNotFound {
        super(context, i3, sensorManager, interfaceC7424a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), sensorManager, interfaceC7424a);
            return;
        }
        this.K = new float[3];
        this.L = new float[3];
        this.M = new float[3];
        this.N = new float[3];
        this.P = new float[16];
        this.Q = new float[3];
        this.R = false;
        this.S = -1.0f;
        this.T = -1.0f;
        this.U = -1.0f;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
        Sensor defaultSensor2 = SensorMonitor.getDefaultSensor(sensorManager, 2);
        if (defaultSensor != null && defaultSensor2 != null) {
            this.f199771d.add(defaultSensor);
            this.f199771d.add(defaultSensor2);
            return;
        }
        throw new OrientationProviderNotFound("1,2");
    }

    private void h(float f16, float f17, float f18) {
        if (this.f199774h == null) {
            return;
        }
        if (Math.abs(f16 - this.S) > 2.0f) {
            this.S = f16;
            this.f199774h.updateAzimuth(f16);
        }
        if (Math.abs(f17 - this.T) > 2.0f) {
            this.T = f17;
            this.f199774h.updatePitch(f17);
        }
        if (Math.abs(f18 - this.U) > 2.0f) {
            this.U = f18;
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
        if (sensorEvent.sensor.getType() == 2) {
            System.arraycopy(sensorEvent.values, 0, this.K, 0, 3);
            com.tencent.mobileqq.armap.sensor.b.a(this.K, this.N);
            System.arraycopy(this.K, 0, this.N, 0, 3);
            this.R = true;
        } else if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, this.L, 0, 3);
            com.tencent.mobileqq.armap.sensor.b.a(this.L, this.M);
            System.arraycopy(this.L, 0, this.M, 0, 3);
        }
        if (this.R && SensorManager.getRotationMatrix(this.P, null, this.L, this.K)) {
            SensorManager.getOrientation(this.P, this.Q);
            if (this.J != 1) {
                super.g(this.P);
                return;
            }
            float degrees = ((float) (Math.toDegrees(this.Q[0] + a()) + 360.0d)) % 360.0f;
            float[] fArr = this.Q;
            h(degrees, (float) ((fArr[1] * 180.0f) / 3.141592653589793d), (float) ((fArr[2] * 180.0f) / 3.141592653589793d));
        }
    }
}
