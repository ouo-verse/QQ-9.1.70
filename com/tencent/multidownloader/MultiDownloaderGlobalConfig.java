package com.tencent.multidownloader;

import com.tencent.mobileqq.soload.api.SoLoadConstants;

/* compiled from: P */
/* loaded from: classes34.dex */
public class MultiDownloaderGlobalConfig {
    static {
        if (MultiDownloaderSo.needLoadSo()) {
            System.loadLibrary(SoLoadConstants.SONAME_ZPLAN_MULTI_DOWNLOADER);
        } else {
            MDDownloadLog.log(MDLogLevel.LOG_INFO.ordinal(), "MultiDownloaderGlobalConfig", "skip load so");
        }
    }

    public static native void cancel_speed_limit();

    public static native void config_db_path(String str);

    public static native void update_speed_limit(long j3);
}
