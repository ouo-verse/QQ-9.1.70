package com.tencent.ams.mosaic.jsengine.sensor.impl;

import android.hardware.SensorEvent;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends BaseSensorImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private long f71450d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f71451e;

    private Map<String, Object> a(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return null;
        }
        long j3 = this.f71450d;
        if (j3 == 0) {
            this.f71450d = sensorEvent.timestamp;
            return null;
        }
        long j16 = sensorEvent.timestamp;
        float f16 = ((float) (j16 - j3)) * 1.0E-9f;
        this.f71450d = j16;
        float[] fArr = sensorEvent.values;
        float f17 = fArr[0] * f16;
        float f18 = fArr[1] * f16;
        float f19 = fArr[2] * f16;
        float[] fArr2 = this.f71451e;
        float f26 = fArr2[0] + f17;
        fArr2[0] = f26;
        fArr2[1] = fArr2[1] + f18;
        fArr2[2] = fArr2[2] + f19;
        float degrees = (float) Math.toDegrees(f26);
        float degrees2 = (float) Math.toDegrees(this.f71451e[1]);
        float degrees3 = (float) Math.toDegrees(this.f71451e[2]);
        f.a("GyroscopeSensorImpl", "rotationX: " + degrees + ", rotationY: " + degrees2 + ", rotationZ: " + degrees3);
        HashMap hashMap = new HashMap();
        hashMap.put("rotationAngleX", Float.valueOf(degrees));
        hashMap.put("rotationAngleY", Float.valueOf(degrees2));
        hashMap.put("rotationAngleZ", Float.valueOf(degrees3));
        return hashMap;
    }

    private void b() {
        this.f71450d = 0L;
        float[] fArr = this.f71451e;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    @Override // com.tencent.ams.mosaic.jsengine.sensor.impl.BaseSensorImpl
    protected Object createSensorData(SensorEvent sensorEvent) {
        Map<String, Object> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
        }
        if (sensorEvent != null && (a16 = a(sensorEvent)) != null) {
            a16.put("rotateX", Float.valueOf(sensorEvent.values[0]));
            a16.put("rotateY", Float.valueOf(sensorEvent.values[1]));
            a16.put("rotateZ", Float.valueOf(sensorEvent.values[2]));
            return a16;
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.sensor.impl.BaseSensorImpl, com.tencent.ams.mosaic.jsengine.sensor.MosaicSensor
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.stop();
            b();
        }
    }
}
