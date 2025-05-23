package com.tencent.component.network.utils;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SDCardUtil {
    private static final String NO_SDCARD_TIPS = "\u65e0SD Card";
    private static final long UNIT = 1048576;
    private static final String UNIT_NAME = "MB";

    private static String calcCapUnit(long j3) {
        return calcCapUnit(0, (float) j3);
    }

    private static String countToUnit(int i3) {
        if (i3 == 0) {
            return "byte";
        }
        if (i3 == 1) {
            return "KB";
        }
        if (i3 == 2) {
            return UNIT_NAME;
        }
        if (i3 == 3) {
            return "GB";
        }
        if (i3 == 4) {
            return "TB";
        }
        if (i3 == 5) {
            return "PB";
        }
        return "";
    }

    public static long getSDCardCapability() {
        if (!isSDCardMounted()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static String getSDCardCapabilityForDisplay() {
        long sDCardCapability = getSDCardCapability();
        if (sDCardCapability >= 0) {
            return calcCapUnit(sDCardCapability);
        }
        return NO_SDCARD_TIPS;
    }

    public static long getSDCardRemain() {
        if (!isSDCardMounted()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public static String getSDCardRemainForDisplay() {
        long sDCardRemain = getSDCardRemain();
        if (sDCardRemain >= 0) {
            return calcCapUnit(sDCardRemain);
        }
        return NO_SDCARD_TIPS;
    }

    public static String getSDCardState() {
        return Environment.getExternalStorageState();
    }

    public static boolean isSDCardMounted() {
        return getSDCardState().equals("mounted");
    }

    public static boolean isSdCardHasEnoughCapability() {
        if (getSDCardRemain() > 10485760) {
            return true;
        }
        return false;
    }

    private static String calcCapUnit(int i3, float f16) {
        if (f16 < 0.0f) {
            return "";
        }
        if (f16 < 1024.0f) {
            return String.format("%.2f", Float.valueOf(f16)) + countToUnit(i3);
        }
        return calcCapUnit(i3 + 1, f16 / 1024.0f);
    }
}
