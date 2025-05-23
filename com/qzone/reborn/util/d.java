package com.qzone.reborn.util;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {
    private static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long b() {
        try {
            if (!a()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576;
        } catch (Exception e16) {
            QLog.e("QZoneDeviceUtils", 1, "getAvailableExternalMemorySize  e=" + e16);
            return 0L;
        }
    }
}
