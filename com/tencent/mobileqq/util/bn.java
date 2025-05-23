package com.tencent.mobileqq.util;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bn {
    private static void a() {
        c();
    }

    public static String b() {
        a();
        QLog.w("LocationMethodMonitor", 1, "inject failed, call String: LOCATION_LBS_SDK");
        return null;
    }

    public static void d(Object obj) {
        a();
        QLog.w("LocationMethodMonitor", 1, "inject failed, call onPandoraEvent");
    }

    @QAutoInitMethod
    static void c() {
    }
}
