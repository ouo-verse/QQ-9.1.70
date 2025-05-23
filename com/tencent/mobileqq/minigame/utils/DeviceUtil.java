package com.tencent.mobileqq.minigame.utils;

import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DeviceUtil {
    public static int getDeviceBenchmarkLevel() {
        int m3;
        int c16;
        try {
            int n3 = ah.n();
            if (n3 <= 0 || (m3 = (int) (ah.m() / JsonGrayBusiId.UI_RESERVE_100000_110000)) <= 0 || (c16 = (int) (m.c() / 1048576)) <= 0) {
                return -1;
            }
            int i3 = (((n3 * 200) + ((m3 * m3) * 10)) + (((c16 / 1024) * (c16 / 1024)) * 100)) / 400;
            if (i3 > 50) {
                i3 = 50;
            }
            QLog.d("getDeviceBenchmarkLevel", 1, "getDeviceBenchmarkLevel coreNum:" + n3 + " cpuFreq:" + m3 + " ramSize:" + c16 + " score:" + i3);
            return i3;
        } catch (Throwable th5) {
            QLog.e("getDeviceBenchmarkLevel", 1, "getDeviceBenchmarkLevel error", th5);
            return -1;
        }
    }
}
