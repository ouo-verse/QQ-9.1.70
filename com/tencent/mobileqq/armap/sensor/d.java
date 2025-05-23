package com.tencent.mobileqq.armap.sensor;

import com.tencent.mobileqq.armap.sensor.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements a.InterfaceC7424a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void onRotationUpdateOriginal(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fArr);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void onSensorSupport(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateAccelerometer(float f16, float f17, float f18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateAzimuth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateGyroscope(float f16, float f17, float f18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updatePitch(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateRoll(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateRotation(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateSensor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
    }
}
