package com.tencent.hlyyb.downloader;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface DownloaderTask {
    void addHeader(String str, String str2);

    void addListener(DownloaderTaskListener downloaderTaskListener);

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

    int getType();

    String getUniqueKey();

    String getUrl();

    boolean isCompleted();

    boolean isDeleted();

    boolean isEaseTask();

    boolean isFailed();

    boolean isPaused();

    boolean isPausedOnMobile();

    boolean isRunning();

    boolean isSupportRange();

    boolean isUsingTempFile();

    boolean isWaiting();

    void pause();

    void removeAllListeners();

    void removeListener(DownloaderTaskListener downloaderTaskListener);

    boolean resume();

    void setApkId(String str);

    void setAppId(String str);

    void setAppScene(String str);

    void setBakUrl(String str);

    void setCategory(DownloaderTaskCategory downloaderTaskCategory);

    void setFullApkSize(long j3);

    void setId(String str);

    void setMultiSectionOn(boolean z16);

    void setNotPreOccupySpace();

    void setNotUseTempFile();

    void setPauseTaskOnMobile(boolean z16);

    void setPriority(DownloaderTaskPriority downloaderTaskPriority);

    void setReportMd5(boolean z16);

    void setTag(Object obj);

    void setType(int i3);
}
