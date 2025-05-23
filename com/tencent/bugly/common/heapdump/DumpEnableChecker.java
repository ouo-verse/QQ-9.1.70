package com.tencent.bugly.common.heapdump;

import android.os.StatFs;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ContextUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DumpEnableChecker {
    private static long getSdCardAvailableSize() {
        try {
            StatFs statFs = new StatFs(ContextUtil.getGlobalContext().getExternalCacheDir().getAbsolutePath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean isDiskSpaceEnough() {
        if (getSdCardAvailableSize() * 1024 > Runtime.getRuntime().totalMemory()) {
            return true;
        }
        return false;
    }

    public static boolean isForkDumpVersionPermitted() {
        return AndroidVersion.isOverL();
    }

    public static boolean isHprofStripVersionPermitted() {
        return AndroidVersion.isOverM();
    }
}
