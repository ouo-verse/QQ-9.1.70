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
public class a extends d {
    static IPatchRedirector $redirector_;
    private final float[] K;
    private float L;
    private float[] M;
    private float[] N;
    private float[] P;
    private float[] Q;
    private float[] R;
    private float[] S;
    private float[] T;
    boolean U;
    boolean V;
    private float[] W;
    private float[] X;
    boolean Y;
    private float Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f199769a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f199770b0;

    public a(Context context, int i3, SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) throws OrientationProviderNotFound {
        super(context, i3, sensorManager, interfaceC7424a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), sensorManager, interfaceC7424a);
            return;
        }
        this.K = new float[4];
        this.M = new float[3];
        this.N = new float[3];
        this.P = new float[3];
        this.Q = new float[3];
        this.R = new float[3];
        this.S = new float[9];
        this.T = new float[3];
        this.U = false;
        this.V = false;
        this.W = new float[9];
        this.X = new float[16];
        this.Y = false;
        this.Z = -1.0f;
        this.f199769a0 = -1.0f;
        this.f199770b0 = -1.0f;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 4);
        Sensor defaultSensor2 = SensorMonitor.getDefaultSensor(sensorManager, 1);
        Sensor defaultSensor3 = SensorMonitor.getDefaultSensor(sensorManager, 2);
        if (defaultSensor != null && defaultSensor2 != null && defaultSensor3 != null) {
            this.f199771d.add(defaultSensor);
            this.f199771d.add(defaultSensor2);
            this.f199771d.add(defaultSensor3);
            j();
            return;
        }
        throw new OrientationProviderNotFound("4,1,2");
    }

    private void h() {
        if (SensorManager.getRotationMatrix(this.S, null, this.Q, this.P)) {
            SensorManager.getOrientation(this.S, this.T);
            this.U = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i() {
        double d16;
        float f16;
        float f17;
        double d17;
        float f18;
        float f19;
        double d18;
        double d19;
        float[] fArr = this.M;
        float f26 = fArr[0];
        double d26 = 6.283185307179586d;
        if (f26 < -1.5707963267948966d) {
            if (this.T[0] > 0.0d) {
                float[] fArr2 = this.N;
                float f27 = (float) (((f26 + 6.283185307179586d) * 0.9980000257492065d) + (r4 * 0.0019999743f));
                fArr2[0] = f27;
                double d27 = f27;
                if (f27 > 3.141592653589793d) {
                    d19 = 6.283185307179586d;
                } else {
                    d19 = 0.0d;
                }
                fArr2[0] = (float) (d27 - d19);
                f16 = fArr[1];
                if (f16 < -1.5707963267948966d) {
                    if (this.T[1] > 0.0d) {
                        float[] fArr3 = this.N;
                        float f28 = (float) (((f16 + 6.283185307179586d) * 0.9980000257492065d) + (r6 * 0.0019999743f));
                        fArr3[1] = f28;
                        double d28 = f28;
                        if (f28 > 3.141592653589793d) {
                            d18 = 6.283185307179586d;
                        } else {
                            d18 = 0.0d;
                        }
                        fArr3[1] = (float) (d28 - d18);
                        f18 = fArr[2];
                        if (f18 < -1.5707963267948966d) {
                            if (this.T[2] > 0.0d) {
                                float[] fArr4 = this.N;
                                float f29 = (float) (((f18 + 6.283185307179586d) * 0.9980000257492065d) + (r5 * 0.0019999743f));
                                fArr4[2] = f29;
                                double d29 = f29;
                                if (f29 <= 3.141592653589793d) {
                                    d26 = 0.0d;
                                }
                                fArr4[2] = (float) (d29 - d26);
                                float[] a16 = com.tencent.mobileqq.armap.sensor.c.a(this.N);
                                this.W = a16;
                                com.tencent.mobileqq.armap.sensor.c.d(a16, this.X);
                                if (this.J != 1) {
                                    super.g(this.X);
                                }
                                System.arraycopy(this.N, 0, this.M, 0, 3);
                            }
                        }
                        f19 = this.T[2];
                        if (f19 >= -1.5707963267948966d && f18 > 0.0d) {
                            float[] fArr5 = this.N;
                            float f36 = (float) ((f18 * 0.998f) + (0.0019999743f * (f19 + 6.283185307179586d)));
                            fArr5[2] = f36;
                            double d36 = f36;
                            if (f36 <= 3.141592653589793d) {
                                d26 = 0.0d;
                            }
                            fArr5[2] = (float) (d36 - d26);
                        } else {
                            this.N[2] = (f18 * 0.998f) + (f19 * 0.0019999743f);
                        }
                        float[] a162 = com.tencent.mobileqq.armap.sensor.c.a(this.N);
                        this.W = a162;
                        com.tencent.mobileqq.armap.sensor.c.d(a162, this.X);
                        if (this.J != 1) {
                        }
                        System.arraycopy(this.N, 0, this.M, 0, 3);
                    }
                }
                f17 = this.T[1];
                if (f17 >= -1.5707963267948966d && f16 > 0.0d) {
                    float[] fArr6 = this.N;
                    float f37 = (float) ((f16 * 0.998f) + (0.0019999743f * (f17 + 6.283185307179586d)));
                    fArr6[1] = f37;
                    double d37 = f37;
                    if (f37 > 3.141592653589793d) {
                        d17 = 6.283185307179586d;
                    } else {
                        d17 = 0.0d;
                    }
                    fArr6[1] = (float) (d37 - d17);
                } else {
                    this.N[1] = (f16 * 0.998f) + (f17 * 0.0019999743f);
                }
                f18 = fArr[2];
                if (f18 < -1.5707963267948966d) {
                }
                f19 = this.T[2];
                if (f19 >= -1.5707963267948966d) {
                }
                this.N[2] = (f18 * 0.998f) + (f19 * 0.0019999743f);
                float[] a1622 = com.tencent.mobileqq.armap.sensor.c.a(this.N);
                this.W = a1622;
                com.tencent.mobileqq.armap.sensor.c.d(a1622, this.X);
                if (this.J != 1) {
                }
                System.arraycopy(this.N, 0, this.M, 0, 3);
            }
        }
        float f38 = this.T[0];
        if (f38 < -1.5707963267948966d && f26 > 0.0d) {
            float[] fArr7 = this.N;
            float f39 = (float) ((f26 * 0.998f) + (0.0019999743f * (f38 + 6.283185307179586d)));
            fArr7[0] = f39;
            double d38 = f39;
            if (f39 > 3.141592653589793d) {
                d16 = 6.283185307179586d;
            } else {
                d16 = 0.0d;
            }
            fArr7[0] = (float) (d38 - d16);
        } else {
            this.N[0] = (f26 * 0.998f) + (f38 * 0.0019999743f);
        }
        f16 = fArr[1];
        if (f16 < -1.5707963267948966d) {
        }
        f17 = this.T[1];
        if (f17 >= -1.5707963267948966d) {
        }
        this.N[1] = (f16 * 0.998f) + (f17 * 0.0019999743f);
        f18 = fArr[2];
        if (f18 < -1.5707963267948966d) {
        }
        f19 = this.T[2];
        if (f19 >= -1.5707963267948966d) {
        }
        this.N[2] = (f18 * 0.998f) + (f19 * 0.0019999743f);
        float[] a16222 = com.tencent.mobileqq.armap.sensor.c.a(this.N);
        this.W = a16222;
        com.tencent.mobileqq.armap.sensor.c.d(a16222, this.X);
        if (this.J != 1) {
        }
        System.arraycopy(this.N, 0, this.M, 0, 3);
    }

    private void k(float f16, float f17, float f18, long j3) {
        a.InterfaceC7424a interfaceC7424a = this.f199774h;
        if (interfaceC7424a == null) {
            return;
        }
        interfaceC7424a.updateAccelerometer(f16, f17, f18, j3);
    }

    private void l(float f16, float f17, float f18, long j3) {
        a.InterfaceC7424a interfaceC7424a = this.f199774h;
        if (interfaceC7424a == null) {
            return;
        }
        interfaceC7424a.updateGyroscope(f16, f17, f18, j3);
    }

    private void m(float f16, float f17, float f18) {
        if (this.f199774h == null) {
            return;
        }
        if (Math.abs(f16 - this.Z) > 1.0f) {
            this.Z = f16;
            this.f199774h.updateAzimuth(f16);
        }
        if (Math.abs(f17 - this.f199769a0) > 1.0f) {
            this.f199769a0 = f17;
            this.f199774h.updatePitch(f17);
        }
        if (Math.abs(f18 - this.f199770b0) > 1.0f) {
            this.f199770b0 = f18;
            this.f199774h.updateRoll(f18);
        }
        this.f199774h.updateSensor(f16, f17, f18);
    }

    private void n(SensorEvent sensorEvent) {
        if (!this.U) {
            return;
        }
        if (!this.Y) {
            float[] a16 = com.tencent.mobileqq.armap.sensor.c.a(this.T);
            SensorManager.getOrientation(a16, new float[3]);
            this.W = com.tencent.mobileqq.armap.sensor.c.e(this.W, a16);
            this.Y = true;
        }
        float f16 = this.L;
        if (f16 != 0.0f && this.Y) {
            float f17 = (((float) sensorEvent.timestamp) - f16) * 1.0E-9f;
            System.arraycopy(sensorEvent.values, 0, this.R, 0, 3);
            float[] fArr = this.R;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f26 = fArr[2];
            float sqrt = (float) Math.sqrt((f18 * f18) + (f19 * f19) + (f26 * f26));
            if (sqrt > 1.0E-9f) {
                f18 /= sqrt;
                f19 /= sqrt;
                f26 /= sqrt;
            }
            double d16 = (sqrt * f17) / 2.0f;
            float sin = (float) Math.sin(d16);
            float cos = (float) Math.cos(d16);
            float[] fArr2 = this.K;
            fArr2[0] = f18 * sin;
            fArr2[1] = f19 * sin;
            fArr2[2] = sin * f26;
            fArr2[3] = cos;
            float[] fArr3 = new float[9];
            com.tencent.mobileqq.armap.sensor.c.c(fArr3, fArr2);
            float[] e16 = com.tencent.mobileqq.armap.sensor.c.e(this.W, fArr3);
            this.W = e16;
            SensorManager.getOrientation(e16, this.M);
            i();
            if (this.J == 1 && this.f199774h != null) {
                float degrees = ((float) (Math.toDegrees(this.M[0] + a()) + 360.0d)) % 360.0f;
                float[] fArr4 = this.M;
                m(degrees, (float) ((fArr4[1] * 180.0f) / 3.141592653589793d), (float) ((fArr4[2] * 180.0f) / 3.141592653589793d));
            }
        }
        this.L = (float) sensorEvent.timestamp;
    }

    void j() {
        float[] fArr = this.M;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        float[] fArr2 = this.W;
        fArr2[0] = 1.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 1.0f;
        fArr2[5] = 0.0f;
        fArr2[6] = 0.0f;
        fArr2[7] = 0.0f;
        fArr2[8] = 1.0f;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
            return;
        }
        if (sensorEvent.sensor.getType() == 4) {
            n(sensorEvent);
            float[] fArr = sensorEvent.values;
            l(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
        } else if (sensorEvent.sensor.getType() == 2) {
            System.arraycopy(sensorEvent.values, 0, this.P, 0, 3);
            this.V = true;
        } else if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, this.Q, 0, 3);
            h();
            float[] fArr2 = sensorEvent.values;
            k(fArr2[0], fArr2[1], fArr2[2], sensorEvent.timestamp);
        }
    }
}
