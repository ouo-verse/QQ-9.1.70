package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.a;
import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class d extends e {
    static IPatchRedirector $redirector_;
    protected com.tencent.mobileqq.armap.sensor.rotation.c E;
    public Matrix4 F;
    protected Context G;
    public float[] H;
    public float[] I;
    public int J;

    public d(Context context, int i3, SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) {
        super(sensorManager, interfaceC7424a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), sensorManager, interfaceC7424a);
            return;
        }
        this.F = new Matrix4();
        this.H = new float[3];
        this.I = new float[3];
        this.J = i3;
        this.G = context;
        f(context);
    }

    private void f(Context context) {
        this.F = new Matrix4();
        this.E = new com.tencent.mobileqq.armap.sensor.rotation.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fArr);
            return;
        }
        if (this.f199774h != null && fArr != null) {
            this.F.set(fArr);
            this.E.a(this.F, 0, this.I);
            int i3 = this.J;
            if (i3 == 1) {
                this.f199774h.updateAzimuth(this.I[0]);
                return;
            }
            float[] fArr2 = this.H;
            float[] fArr3 = this.I;
            float f16 = fArr3[1];
            fArr2[0] = f16;
            float f17 = -fArr3[0];
            fArr2[1] = f17;
            float f18 = -fArr3[2];
            fArr2[2] = f18;
            if (i3 == 0) {
                this.f199774h.updateRotation(f16, f17, f18);
                return;
            }
            if (i3 != 2 && i3 != 3) {
                return;
            }
            this.f199774h.updateRotation(f16, f17, f18);
            if (this.J == 3 && fArr.length == 16) {
                this.f199774h.onRotationUpdateOriginal(fArr);
            }
        }
    }
}
