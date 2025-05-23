package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.os.Bundle;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface GroupLiveTRTCCloudListener extends IBaseService {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface GroupLiveTRTCVideoRenderListener {
        void onRenderVideoFrame(String str, int i3, GroupLiveTRTCVideoFrame groupLiveTRTCVideoFrame);
    }

    void onAudioRouteChanged(int i3, int i16);

    void onCameraDidReady();

    void onCdnStreamStateChanged(String str, int i3, int i16, String str2, Bundle bundle);

    void onConnectOtherRoom(String str, int i3, String str2);

    void onConnectionLost();

    void onConnectionRecovery();

    void onDisConnectOtherRoom(int i3, String str);

    void onEnterRoom(long j3);

    void onError(int i3, String str, Bundle bundle);

    void onExitRoom(int i3);

    void onFirstAudioFrame(String str);

    void onFirstVideoFrame(String str, int i3, int i16, int i17);

    void onLocalRecordBegin(int i3, String str);

    void onLocalRecordComplete(int i3, String str);

    void onLocalRecording(long j3, String str);

    void onMicDidReady();

    void onMissCustomCmdMsg(String str, int i3, int i16, int i17);

    void onNetworkQuality(int i3, int i16);

    void onRecvCustomCmdMsg(String str, int i3, int i16, byte[] bArr);

    void onRecvSEIMsg(String str, byte[] bArr);

    void onRemoteAudioStatusUpdated(String str, int i3, int i16, Bundle bundle);

    void onRemoteUserEnterRoom(String str);

    void onRemoteUserLeaveRoom(String str, int i3);

    void onRemoteVideoStatusUpdated(String str, int i3, int i16, int i17, Bundle bundle);

    void onScreenCapturePaused();

    void onScreenCaptureResumed();

    void onScreenCaptureStarted();

    void onScreenCaptureStopped(int i3);

    void onSendFirstLocalAudioFrame();

    void onSendFirstLocalVideoFrame(int i3);

    void onSetMixTranscodingConfig(int i3, String str);

    void onSpeedTestResult(String str);

    void onStartPublishCDNStream(int i3, String str);

    void onStartPublishMediaStream(String str, int i3, String str2, Bundle bundle);

    void onStartPublishing(int i3, String str);

    void onStatistics(GroupLiveTRTCStatistics groupLiveTRTCStatistics);

    void onStopPublishCDNStream(int i3, String str);

    void onStopPublishMediaStream(String str, int i3, String str2, Bundle bundle);

    void onStopPublishing(int i3, String str);

    void onSwitchRole(int i3, String str);

    void onSwitchRoom(int i3, String str);

    void onTryToReconnect();

    void onUpdatePublishMediaStream(String str, int i3, String str2, Bundle bundle);

    void onUserAudioAvailable(String str, boolean z16);

    void onUserSubStreamAvailable(String str, boolean z16);

    void onUserVideoAvailable(String str, boolean z16);

    void onUserVideoSizeChanged(String str, int i3, int i16, int i17);

    void onUserVoiceVolume(int i3);

    void onWarning(int i3, String str, Bundle bundle);
}
