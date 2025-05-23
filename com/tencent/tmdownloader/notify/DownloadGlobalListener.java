package com.tencent.tmdownloader.notify;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface DownloadGlobalListener {
    void onTaskCompleted(DownloadTaskInfo downloadTaskInfo);

    void onTaskFailed(DownloadTaskInfo downloadTaskInfo);

    void onTaskPaused(DownloadTaskInfo downloadTaskInfo);

    void onTaskStarted(DownloadTaskInfo downloadTaskInfo);
}
