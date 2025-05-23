package com.tencent.avcore.jni.dav;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NtrtcRoomCallback {
    void onCommonTips(String str);

    void onCustomCommand(String str, long j3, long j16, long j17);

    void onGroundGlassSwitch(int i3);

    void onGroundGlassWaitTime(int i3);

    void onNetLevelChanged(int i3, String str);

    void onNotifyBusinessCheckNetworkState();

    void onPeerEnableAudio(String str, boolean z16);

    void onPeerEnableVideo(String str, boolean z16);

    void onPeerMidiaFileOrVirtualCameraStateChanged(int i3, String str);

    void onPeerStateInfo(String str, int i3);

    void onPeerSwitchAV(String str, int i3);

    void onPeerSysPhoneCalling(boolean z16);

    void onRecvFunChatMsg(String str, int i3, byte[] bArr);

    void onRecvSuperAvatarInfo(byte[] bArr, long j3);

    void onRecvTransferMsg(byte[] bArr);

    void onStateInfo(String str);

    void onSuperAvatarInputFpsChanged(int i3);
}
