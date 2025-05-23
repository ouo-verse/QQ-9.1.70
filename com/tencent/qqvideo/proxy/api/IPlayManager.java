package com.tencent.qqvideo.proxy.api;

import android.content.Context;

/* loaded from: classes34.dex */
public interface IPlayManager {
    void appToBack();

    void appToFront();

    String buildClipPlayURL(int i3, int i16);

    String buildPlayURLMp4(int i3);

    int cleanMemory();

    int cleanStorage();

    void deinit();

    int deleteClipFileOnDisk(String str, int i3);

    int deleteFileOnDisk(String str);

    long getClipFileSizeOnDisk(String str, int i3);

    long getCurrentOffset(int i3);

    int getLocalServerPort();

    String getProxyVersion();

    long getTotalOffset(int i3);

    int init(Context context, String str);

    boolean isClipCompleteOnDisk(String str, int i3);

    int pauseAllPreLoad();

    int pauseStorageIO();

    int preLoad(int i3, int i16);

    int preLoadClip(int i3, int i16, int i17, boolean z16, int i18);

    int resumeAllPreLoad();

    int resumeStorageIO();

    int setClipInfo(int i3, int i16, String str, long j3, int i17);

    void setCookie(String str);

    void setHttpLowSpeedParams(int i3, int i16);

    int setMaxMemorySize(long j3);

    int setMaxStorageSize(long j3);

    void setNetWorkState(int i3);

    void setPlayerState(int i3, int i16);

    void setRemainTime(int i3, int i16);

    void setUtilsObject(IUtils iUtils);

    int startPlay(int i3, String str, boolean z16, int i16);

    int startPlay(String str, int i3, String str2, long j3, int i16);

    int startPreLoad(int i3, String str, boolean z16, int i16);

    int stopAllPreLoad();

    void stopPlay(int i3);

    int stopPreLoad(int i3);
}
