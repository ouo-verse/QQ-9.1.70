package com.tencent.luggage.wxa.lo;

import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static boolean a() {
        if (com.tencent.luggage.wxa.aa.i.b() && "Lenovo TB-9707F".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
            return true;
        }
        return false;
    }
}
