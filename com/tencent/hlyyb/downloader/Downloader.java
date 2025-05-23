package com.tencent.hlyyb.downloader;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface Downloader {
    void addNewTask(DownloaderTask downloaderTask);

    DownloaderTask createNewTask(int i3, String str, String str2, String str3, String str4, DownloaderTaskListener downloaderTaskListener);

    DownloaderTask createNewTask(int i3, String str, String str2, String str3, String str4, DownloaderTaskListener downloaderTaskListener, long j3);

    DownloaderTask createNewTask(int i3, String str, String str2, String str3, String str4, DownloaderTaskListener downloaderTaskListener, long j3, String str5);

    DownloaderTask createNewTask(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener);

    DownloaderTask createNewTask(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener, long j3, String str4);

    void deleteTask(DownloaderTask downloaderTask, boolean z16);

    void deleteTaskByKey(String str, boolean z16);

    void enableUserAction(boolean z16);

    List<DownloaderTask> getAllTasks();

    List<DownloaderTask> getCancelledTasks();

    List<DownloaderTask> getCompletedTasks();

    List<DownloaderTask> getFailedTasks();

    List<DownloaderTask> getIncompleteTasks();

    List<DownloaderTask> getRunningTasks();

    String getVersion();

    List<DownloaderTask> getWaitingTasks();

    void pauseTasks(boolean z16, boolean z17);

    void resumeTasks(boolean z16, boolean z17);

    void setNotNetworkWaitMillis(int i3);

    void setPhoneGuid(String str);

    void setProgressInterval(int i3);

    void setQua1(String str);

    void setQua2(String str);

    void setTaskNumForCategory(DownloaderTaskCategory downloaderTaskCategory, int i3);

    void setTempFileSubfix(String str);
}
