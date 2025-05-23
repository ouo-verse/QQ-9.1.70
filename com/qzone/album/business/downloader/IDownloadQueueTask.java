package com.qzone.album.business.downloader;

import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IDownloadQueueTask extends SmartParcelable {
    boolean cancel();

    int getCount();

    int getFailCount();

    int getRunningCount();

    int getState();

    long getTaskId();

    long getTime();

    int getType();

    boolean isNullTask();

    void onRestore();

    void onResume();

    void run();

    void setState(int i3);

    void setTaskId(long j3);

    void setTime(long j3);

    void updateTask();
}
