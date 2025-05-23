package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: classes12.dex */
public interface IQavMultiObserverProxy extends IBaseService {
    void onAudioEngineReady();

    void onCloseMicBySelf(Long l3);

    void onCreateSuc();

    void onEnterRoom();

    void onError(int i3);

    void onGetSignResponse(long j3, String str, String str2);

    void onGoOffStageRet(boolean z16, long j3, int i3);

    void onGoOnStageRet(boolean z16, long j3, int i3);

    void onMemberVideoInOrOut(boolean z16, long j3, long j16, int i3, long j17, int i16);

    void onMultiVideoChatMembersInfoChange(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18);

    void onOpenMicFail();

    void onSelfVolumeUpdate(int i3);

    void onStartRemoteVideoRequestResult(int i3);

    void onSystemCallStateChanged(boolean z16);

    void onUserAudioAvailable(MultiUserInfo multiUserInfo, boolean z16);

    void onUserEnter(MultiUserInfo multiUserInfo);

    void onUserExit(MultiUserInfo multiUserInfo);

    void onUserFirstVideoFrameIn(long j3, int i3);

    void onUserSpeaking(MultiUserInfo multiUserInfo, boolean z16);

    void onUserSpeaking(MultiUserInfo multiUserInfo, boolean z16, int i3);

    void onUserUpdate(List<MultiUserInfo> list);

    void onUserVideoSrcChange(long j3, int i3, long j16, int i16);

    void onVideoChatCallStateChanged(boolean z16);
}
