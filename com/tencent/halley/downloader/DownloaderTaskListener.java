package com.tencent.halley.downloader;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface DownloaderTaskListener {
    void onTaskCompletedMainloop(DownloaderTask downloaderTask);

    void onTaskCompletedSubloop(DownloaderTask downloaderTask);

    void onTaskDetectedMainloop(DownloaderTask downloaderTask);

    void onTaskDetectedSubloop(DownloaderTask downloaderTask);

    void onTaskFailedMainloop(DownloaderTask downloaderTask);

    void onTaskFailedSubloop(DownloaderTask downloaderTask);

    void onTaskPausedMainloop(DownloaderTask downloaderTask);

    void onTaskPausedSubloop(DownloaderTask downloaderTask);

    void onTaskPendingMainloop(DownloaderTask downloaderTask);

    void onTaskReceivedMainloop(DownloaderTask downloaderTask);

    void onTaskReceivedSubloop(DownloaderTask downloaderTask);

    void onTaskStartedMainloop(DownloaderTask downloaderTask);

    void onTaskStartedSubloop(DownloaderTask downloaderTask);
}
