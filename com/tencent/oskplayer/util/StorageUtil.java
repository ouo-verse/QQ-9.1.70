package com.tencent.oskplayer.util;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StorageUtil {
    public static long getDirAvailableSpace(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static long getDirUsedSpace(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    j3 += getDirUsedSpace(file2.getAbsolutePath());
                }
            }
        }
        return j3;
    }

    public static long[] getSDCardMemory() {
        try {
            long[] jArr = new long[2];
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = statFs.getBlockSize();
                long blockCount = statFs.getBlockCount();
                long availableBlocks = statFs.getAvailableBlocks();
                jArr[0] = (blockCount * blockSize) / 1048576;
                jArr[1] = (blockSize * availableBlocks) / 1048576;
            }
            return jArr;
        } catch (Exception e16) {
            PlayerUtils.log(5, "StorageUtil", PlayerUtils.getPrintableStackTrace(e16));
            return new long[]{-1, -1};
        }
    }
}
