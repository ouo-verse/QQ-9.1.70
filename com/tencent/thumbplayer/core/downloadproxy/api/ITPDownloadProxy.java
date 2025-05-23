package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;

/* loaded from: classes26.dex */
public interface ITPDownloadProxy {
    long GetTotalMemorySizeKB();

    int checkResourceStatus(String str, String str2, int i3);

    int clearCache(String str, String str2, int i3);

    int clearRangeCache(String str, int i3, int i16);

    int deinit();

    String getClipPlayUrl(int i3, int i16, int i17);

    String getDownloadProxyInfo(int i3, Object obj, Object obj2, Object obj3);

    String getNativeInfo(int i3);

    String getPlayErrorCodeStr(int i3);

    @Deprecated
    String getPlayUrl(int i3, int i16);

    long getResourceSize(String str, String str2);

    int init(Context context, TPDLProxyInitParam tPDLProxyInitParam);

    boolean isInit();

    int pauseDownload(int i3);

    void pushEvent(int i3);

    int removeStorageCache(String str);

    int resumeDownload(int i3);

    void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19);

    boolean setClipInfo(int i3, int i16, String str, TPDownloadParam tPDownloadParam);

    void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener);

    void setMaxStorageSizeMB(long j3);

    void setPlayState(int i3, int i16);

    void setUpdatePlayerInfoInterval(int i3);

    void setUserData(String str, Object obj);

    int startClipOfflineDownload(String str, int i3, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startClipPlay(String str, int i3, ITPPlayListener iTPPlayListener);

    int startClipPreload(String str, int i3, ITPPreLoadListener iTPPreLoadListener);

    int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener);

    int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener);

    void startTask(int i3);

    void stopOfflineDownload(int i3);

    void stopPlay(int i3);

    void stopPreload(int i3);

    void updateStoragePath(String str);

    void updateTaskInfo(int i3, String str, Object obj);
}
