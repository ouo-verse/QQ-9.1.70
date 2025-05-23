package com.tencent.gamecenter.wadl.sdk.downloader;

import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface DownloaderTask {
    void addHeader(String str, String str2);

    void addListener(DownloaderTaskListener downloaderTaskListener);

    DownloaderTaskAttr getAttribute();

    int getAverageSpeed();

    DownloaderTaskCategory getCategory();

    String getContentDisposition();

    String getContentType();

    long getCostTime();

    int getFailCode();

    String getFailInfo();

    String getHtmlUrl();

    String getId();

    String getInitSaveName();

    long getKnownSize();

    int getPercentage();

    DownloaderTaskPriority getPriority();

    String getRealSaveName();

    int getRealTimeSpeed();

    long getReceivedLength();

    String getSaveDir();

    String getSavePath();

    long getStartTime();

    DownloaderTaskStatus getStatus();

    Object getTag();

    long getTotalLength();

    String getUniqueKey();

    String getUrl();

    boolean isCompleted();

    boolean isDeleted();

    boolean isEaseTask();

    boolean isFailed();

    boolean isPaused();

    boolean isRunning();

    boolean isSupportRange();

    boolean isWaiting();

    void pause();

    void removeAllListeners();

    void removeListener(DownloaderTaskListener downloaderTaskListener);

    void resume();

    void setAttribute(DownloaderTaskAttr downloaderTaskAttr);

    void setBakUrl(String str);

    boolean setHttpsUrl(String str);

    void setId(String str);

    void setOcUrlList(List<String> list);

    void setTag(Object obj);

    void start();
}
