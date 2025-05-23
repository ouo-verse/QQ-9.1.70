package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.cache.Cache;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ITcDataSourceUtils {
    int cleanStorage();

    boolean deleteFileOnDisk(String str);

    DataSourceBuilder getDataSourceBuilder(Cache cache, HttpRetryLogic httpRetryLogic, VideoRequest videoRequest);

    String getFileId(String str);

    String getLocalUrl(String str, String str2, String str3, String str4);

    boolean isClipCompleteOnDisk(String str, int i3);

    boolean isEnabled();

    boolean isUseDefaultSourceBuilder(String str);

    int pauseStorageIO();

    boolean preload(String str, long j3, int i3, int i16, int i17, String str2);

    int resumeStorageIO();

    void setPlayerState(String str, int i3);

    void setRemainTime(String str, int i3);

    void stopAllPreload();

    void stopPlay(int i3);

    void stopPlay(String str);

    void stopPlay(String str, String str2);
}
