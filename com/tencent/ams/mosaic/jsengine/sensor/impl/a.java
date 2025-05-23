package com.tencent.ams.mosaic.jsengine.sensor.impl;

import android.hardware.SensorEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends BaseSensorImpl {
    static IPatchRedirector $redirector_;

    @Override // com.tencent.ams.mosaic.jsengine.sensor.impl.BaseSensorImpl
    protected Object createSensorData(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
        }
        if (sensorEvent != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("accelerateX", Float.valueOf(sensorEvent.values[0]));
            hashMap.put("accelerateY", Float.valueOf(sensorEvent.values[1]));
            hashMap.put("accelerateZ", Float.valueOf(sensorEvent.values[2]));
            return hashMap;
        }
        return null;
    }
}
