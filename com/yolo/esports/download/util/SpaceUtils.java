package com.yolo.esports.download.util;

import android.os.Environment;
import android.os.StatFs;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SpaceUtils {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes28.dex */
    public @interface FileStorageLocation {
        public static final int PHONE = 2;
        public static final int SDCARD = 3;
        public static final int UNKNOWN = 1;
    }

    public static long a(String str) {
        if (c(str) == 2) {
            return b();
        }
        return -1L;
    }

    public static long b() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Math.max(statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4), 0L);
    }

    public static int c(String str) {
        if (str != null && str.contains("/data/data")) {
            return 2;
        }
        return 1;
    }
}
