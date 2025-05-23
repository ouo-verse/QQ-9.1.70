package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f37501a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f37502b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f37503c = false;

    public static boolean a() {
        synchronized (f37501a) {
            if (!f37502b) {
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                f37502b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f37503c);
            }
        }
        return f37503c;
    }
}
