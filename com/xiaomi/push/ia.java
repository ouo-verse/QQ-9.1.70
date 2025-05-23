package com.xiaomi.push;

import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ia {

    /* renamed from: a, reason: collision with root package name */
    private static String f389402a;

    /* renamed from: b, reason: collision with root package name */
    private static long f389403b;

    public static synchronized String a() {
        String str;
        synchronized (ia.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f389403b) > 86400000) {
                f389403b = currentTimeMillis;
                f389402a = DeviceInfoMonitor.getModel();
            }
            str = f389402a;
            if (str == null) {
                str = "";
            }
        }
        return str;
    }
}
