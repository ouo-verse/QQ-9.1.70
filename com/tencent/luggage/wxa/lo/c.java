package com.tencent.luggage.wxa.lo;

import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a() {
        if (com.tencent.luggage.wxa.aa.i.a() && NowProxyConstants.AccountInfoKey.A2.equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (com.tencent.luggage.wxa.aa.i.a() && "X2".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
            return true;
        }
        return false;
    }
}
