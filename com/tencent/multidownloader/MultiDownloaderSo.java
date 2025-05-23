package com.tencent.multidownloader;

/* compiled from: P */
/* loaded from: classes34.dex */
public class MultiDownloaderSo {
    private static volatile boolean isSoPreloaded = false;

    public static boolean needLoadSo() {
        return !isSoPreloaded;
    }

    public static void setSoPreloaded(boolean z16) {
        MDDownloadLog.log(MDLogLevel.LOG_ERROR.ordinal(), "MultiDownloaderSo", "setSoPreloaded- " + z16);
        isSoPreloaded = z16;
    }
}
