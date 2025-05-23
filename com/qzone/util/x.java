package com.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static int f59843a;

    /* renamed from: b, reason: collision with root package name */
    private static long f59844b;

    /* renamed from: c, reason: collision with root package name */
    private static long f59845c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f59846d;

    private static long a() {
        if (f59844b == 0) {
            f59844b = com.tencent.mobileqq.utils.ah.l() * 1024;
        }
        return f59844b;
    }

    public static int b() {
        if (f59843a == 0) {
            f59843a = com.tencent.mobileqq.utils.ah.n();
        }
        return f59843a;
    }

    public static long c() {
        return com.tencent.mobileqq.utils.m.c() / 1048576;
    }

    public static void d() {
        if (f59846d) {
            return;
        }
        f59846d = true;
        f59843a = b();
        f59844b = a();
        f59845c = c();
    }

    public static boolean e() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_SUPERCOVER_MEMORY_LEVEL, 1);
        int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_SUPERCOVER_CPU_LEVEL, 0);
        boolean meetHardwareRestriction = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(config, config2);
        if (QZLog.isColorLevel()) {
            QZLog.i("PerformanceUtil", "supportSuperCover meetHardwareRestriction=" + meetHardwareRestriction + ",memoryLevel=" + config + ",cpuLevel=" + config2);
        }
        return meetHardwareRestriction;
    }
}
