package com.tencent.gamecenter.wadl.sdk.downloader;

import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface Downloader {
    void deleteAllTask(boolean z16);

    void deleteHistoryTask(HistoryTask historyTask, boolean z16);

    void deleteTask(DownloaderTask downloaderTask, boolean z16);

    DownloaderTask genDownloadTask(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener, DownloaderTaskAttr downloaderTaskAttr);

    List<DownloaderTask> getAllTasks();

    List<HistoryTask> getHistoryTasks();

    String getVersion();

    void pauseTasks(boolean z16, boolean z17);

    void resumeTasks(boolean z16, boolean z17);

    void setDetectedSpeedTime(long j3);

    void setDualDownloadSwitch(boolean z16);

    void setEnhanceThreadNums(int i3);

    void setMultiTheadDownOpen(boolean z16);

    void setMultiThreadDownFileSize(long j3);

    void setNotNetworkWaitMillis(int i3);

    void setPhoneGuid(String str);

    void setProgressInterval(int i3);

    void setQua1(String str);

    void setQua2(String str);

    void setSaveHistoryTasks(boolean z16);

    void setTaskNumForCategory(DownloaderTaskCategory downloaderTaskCategory, int i3);

    void setTempFileSubfix(String str);

    void startDownload(DownloaderTask downloaderTask);

    void updateGlobalSpeedBuffer(int i3);
}
