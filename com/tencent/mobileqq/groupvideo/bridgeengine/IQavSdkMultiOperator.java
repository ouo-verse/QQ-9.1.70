package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IQavSdkMultiOperator {
    void changeAvRole(String str);

    int enableLocalAudio(boolean z16);

    void enableRemoteAudio(boolean z16);

    int enterRoom(QavSdkMultiParams qavSdkMultiParams);

    void exitRoom();

    String getAVGQuality();

    int getAudioRoute();

    String getNetWorkQualityRTT();

    int getVideoAbilityLevel();

    boolean goOffStage();

    boolean goOnStage();

    boolean isLocalAudioEnable();

    boolean isRemoteAudioEnable();

    void registAudioDataUpdateListener(RegistAudioDataCompleteCallback registAudioDataCompleteCallback);

    void restartService(boolean z16);

    void setAudioDataVolume(int i3, float f16);

    void setAudioRoute(int i3);

    void setEncodeDecodePtr(long j3, boolean z16, boolean z17);

    void setGAudioFormat(int i3, int i16, int i17, int i18);

    void spearAddParamByRole(String str, String str2);

    void spearClear();

    void startFetchVideo(List<StageUserVideoInfo> list);

    void stopFetchVideo();

    void unregistAudioDataCallback(RegistAudioDataCompleteCallback registAudioDataCompleteCallback);

    void updateRoomInfo();
}
