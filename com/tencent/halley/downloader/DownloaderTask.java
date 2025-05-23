package com.tencent.halley.downloader;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface DownloaderTask {
    void addHeader(String str, String str2);

    void addListener(DownloaderTaskListener downloaderTaskListener);

    int getAverageSpeed();

    DownloaderTaskCategory getCategory();

    long getCostTime();

    int getFailCode();

    String getFailInfo();

    Map<String, List<String>> getHttpRspHeaderMap();

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

    long getTotalLength();

    int getType();

    String getUniqueKey();

    String getUrl();

    boolean isDeleted();

    boolean isFailed();

    boolean isPaused();

    boolean isPausedOnMobile();

    boolean isRunning();

    void manualSetFailInfo(int i3, String str);

    void pause();

    void removeAllListeners();

    void removeListener(DownloaderTaskListener downloaderTaskListener);

    boolean resume();

    void setCategory(DownloaderTaskCategory downloaderTaskCategory);

    void setEnableCrcCheck(boolean z16);

    void setTaskSpeedLimit(int i3);
}
