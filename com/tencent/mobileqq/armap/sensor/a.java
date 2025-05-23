package com.tencent.mobileqq.armap.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import com.tencent.mobileqq.armap.sensor.provider.e;
import com.tencent.mobileqq.armap.sensor.provider.f;
import com.tencent.mobileqq.armap.sensor.provider.g;
import com.tencent.mobileqq.armap.sensor.provider.h;
import com.tencent.mobileqq.armap.sensor.provider.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f199762a;

    /* renamed from: b, reason: collision with root package name */
    private Context f199763b;

    /* renamed from: c, reason: collision with root package name */
    private SensorManager f199764c;

    /* renamed from: d, reason: collision with root package name */
    private e f199765d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f199766e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.armap.sensor.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC7424a {
        void onRotationUpdateOriginal(float[] fArr);

        void onRotationUpdateQuaternion(float[] fArr);

        void onSensorSupport(int i3, boolean z16);

        void updateAccelerometer(float f16, float f17, float f18, long j3);

        void updateAzimuth(float f16);

        void updateGyroscope(float f16, float f17, float f18, long j3);

        void updatePitch(float f16);

        void updateRoll(float f16);

        void updateRotation(float f16, float f17, float f18);

        void updateSensor(float f16, float f17, float f18);
    }

    public a(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.f199765d = null;
        this.f199766e = false;
        this.f199763b = context;
        this.f199762a = i3;
        try {
            this.f199764c = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        } catch (Throwable th5) {
            QLog.e("ARSensorManager", 1, "ARSensorManager getSystemService error:" + th5.getMessage());
            this.f199764c = null;
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (c(2) && (c(1) || c(4))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(4:(3:25|26|27)|(0)(0)|22|23)|29|30|(2:39|40)|(2:35|36)|(2:34|26)|27|(0)(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e b(int i3, SensorManager sensorManager, InterfaceC7424a interfaceC7424a) {
        String simpleName;
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), sensorManager, interfaceC7424a);
        }
        e eVar2 = null;
        if (sensorManager == null) {
            return null;
        }
        if (i3 == 1) {
            try {
                eVar = new i(this.f199763b, i3, sensorManager, interfaceC7424a);
            } catch (OrientationProviderNotFound unused) {
                eVar = null;
            }
            if (eVar == null) {
                try {
                    eVar = new g(this.f199763b, i3, sensorManager, interfaceC7424a);
                } catch (OrientationProviderNotFound unused2) {
                    eVar = null;
                }
            }
            if (eVar == null) {
                eVar = new com.tencent.mobileqq.armap.sensor.provider.b(this.f199763b, i3, sensorManager, interfaceC7424a);
            }
            eVar2 = eVar;
            if (eVar2 == null) {
                simpleName = "null";
            } else {
                simpleName = eVar2.getClass().getSimpleName();
            }
            QLog.d("ARSensorManager", 1, "getProvider:" + simpleName);
            return eVar2;
        }
        if (i3 == 0) {
            try {
                eVar = new f(this.f199763b, i3, sensorManager, interfaceC7424a);
            } catch (OrientationProviderNotFound unused3) {
                eVar = null;
            }
            if (eVar == null) {
                try {
                    eVar = new g(this.f199763b, i3, sensorManager, interfaceC7424a);
                } catch (OrientationProviderNotFound unused4) {
                    eVar = null;
                }
            }
            if (eVar == null) {
                try {
                    eVar = new i(this.f199763b, i3, sensorManager, interfaceC7424a);
                } catch (OrientationProviderNotFound unused5) {
                    eVar = null;
                }
            }
            if (eVar == null) {
                try {
                    eVar = new com.tencent.mobileqq.armap.sensor.provider.a(this.f199763b, i3, sensorManager, interfaceC7424a);
                } catch (OrientationProviderNotFound unused6) {
                    eVar = null;
                }
            }
            if (eVar == null) {
                eVar = new com.tencent.mobileqq.armap.sensor.provider.c(this.f199763b, i3, sensorManager, interfaceC7424a);
            }
            eVar2 = eVar;
            if (eVar2 == null) {
            }
            QLog.d("ARSensorManager", 1, "getProvider:" + simpleName);
            return eVar2;
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 == 4 || i3 == 5) {
                eVar = new h(this.f199763b, i3, sensorManager, interfaceC7424a);
                eVar2 = eVar;
            }
            if (eVar2 == null) {
            }
            QLog.d("ARSensorManager", 1, "getProvider:" + simpleName);
            return eVar2;
        }
        eVar = new g(this.f199763b, i3, sensorManager, interfaceC7424a);
        if (eVar == null) {
            try {
                eVar = new i(this.f199763b, i3, sensorManager, interfaceC7424a);
            } catch (OrientationProviderNotFound unused7) {
                eVar = null;
            }
        }
        if (eVar == null) {
            try {
                eVar = new com.tencent.mobileqq.armap.sensor.provider.a(this.f199763b, i3, sensorManager, interfaceC7424a);
            } catch (OrientationProviderNotFound unused8) {
                eVar = null;
            }
        }
        if (eVar == null) {
            eVar = new com.tencent.mobileqq.armap.sensor.provider.b(this.f199763b, i3, sensorManager, interfaceC7424a);
        }
        eVar2 = eVar;
        if (eVar2 == null) {
        }
        QLog.d("ARSensorManager", 1, "getProvider:" + simpleName);
        return eVar2;
        if (eVar2 == null) {
        }
        QLog.d("ARSensorManager", 1, "getProvider:" + simpleName);
        return eVar2;
    }

    public boolean c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        SensorManager sensorManager = this.f199764c;
        if (sensorManager == null || SensorMonitor.getDefaultSensor(sensorManager, i3) == null) {
            return false;
        }
        return true;
    }

    public boolean d() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        SensorManager sensorManager = this.f199764c;
        if (sensorManager == null) {
            return false;
        }
        if (this.f199762a == 5) {
            i3 = 15;
        } else {
            i3 = 11;
        }
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, i3);
        if (SensorMonitor.getDefaultSensor(this.f199764c, 4) == null || defaultSensor == null) {
            return false;
        }
        return true;
    }

    public boolean e(InterfaceC7424a interfaceC7424a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) interfaceC7424a)).booleanValue();
        }
        if (!this.f199766e) {
            e b16 = b(this.f199762a, this.f199764c, interfaceC7424a);
            this.f199765d = b16;
            if (b16 != null) {
                b16.c();
                this.f199766e = true;
            } else {
                this.f199766e = false;
            }
        }
        return this.f199766e;
    }

    public boolean f(InterfaceC7424a interfaceC7424a, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) interfaceC7424a, i3)).booleanValue();
        }
        if (!this.f199766e) {
            e b16 = b(this.f199762a, this.f199764c, interfaceC7424a);
            this.f199765d = b16;
            if (b16 != null) {
                if (i3 != 2 && i3 != 1 && i3 != 0 && i3 != 3) {
                    i3 = 2;
                }
                b16.d(i3);
                this.f199766e = true;
            } else {
                this.f199766e = false;
            }
        }
        return this.f199766e;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f199766e) {
            this.f199766e = false;
            e eVar = this.f199765d;
            if (eVar != null) {
                eVar.e();
            }
        }
    }
}
