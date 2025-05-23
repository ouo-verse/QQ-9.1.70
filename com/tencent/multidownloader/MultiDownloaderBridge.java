package com.tencent.multidownloader;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.soload.api.SoLoadConstants;

/* compiled from: P */
/* loaded from: classes34.dex */
public class MultiDownloaderBridge {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface MultiDownloaderListener {
        void onTaskComplete(int i3, String str, MDDownloadResInfo mDDownloadResInfo);

        void onTaskDeleted();

        void onTaskPaused();

        void onTaskPending();

        void onTaskProgressCallback(long j3, long j16, long j17, long j18);

        void onTaskStarted(long j3, String str);
    }

    static {
        if (MultiDownloaderSo.needLoadSo()) {
            System.loadLibrary(SoLoadConstants.SONAME_ZPLAN_MULTI_DOWNLOADER);
        } else {
            MDDownloadLog.log(MDLogLevel.LOG_INFO.ordinal(), "MultiDownloaderBridge", "skip load so");
        }
    }

    public native void deleteDownloadTask(String str);

    public String getDatabaseDirectory(Context context) {
        return Environment.getDataDirectory().getAbsolutePath() + "/";
    }

    public native void startDownloadTask(MultiDownloaderListener multiDownloaderListener, String str, MDDownloadConfig mDDownloadConfig);

    public native void stopDownloadTask(String str);
}
