package com.tencent.gamecenter.wadl.sdk.downloader;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface DownloaderTaskListener {
    void onTaskCompletedSubloop(DownloaderTask downloaderTask);

    void onTaskDetectedSubloop(DownloaderTask downloaderTask);

    void onTaskFailedSubloop(DownloaderTask downloaderTask);

    void onTaskPausedSubloop(DownloaderTask downloaderTask);

    void onTaskReceivedSubloop(DownloaderTask downloaderTask);

    void onTaskStartedSubloop(DownloaderTask downloaderTask);
}
