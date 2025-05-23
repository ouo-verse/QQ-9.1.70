package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.Keep;
import com.tencent.mobileqq.groupvideo.bridgeengine.GroupLiveTRTCCloudListener;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface ITrtcSdkService extends IBaseService {
    void enableCustomVideoCapture(int i3, boolean z16);

    int enableEncSmallVideoStream(boolean z16, GroupLiveTRTCVideoEncParam groupLiveTRTCVideoEncParam);

    void enableMixExternalAudioFrame(boolean z16, boolean z17);

    void enterRoom(GroupLiveTRTCParams groupLiveTRTCParams, int i3);

    void exitRoom();

    int getAudioCaptureVolume();

    int getAudioPlayoutVolume();

    boolean init(GroupLiveTRTCCloudListener groupLiveTRTCCloudListener);

    int mixExternalAudioFrame(GroupLiveTRTCAudioFrame groupLiveTRTCAudioFrame);

    void muteAllRemoteAudio(boolean z16);

    void muteAllRemoteVideoStreams(boolean z16);

    void muteLocalAudio(boolean z16);

    void muteLocalVideo(int i3, boolean z16);

    void muteRemoteAudio(String str, boolean z16);

    void muteRemoteVideoStream(String str, int i3, boolean z16);

    void sendCustomVideoData(int i3, GroupLiveTRTCVideoFrame groupLiveTRTCVideoFrame);

    void setAudioCaptureVolume(int i3);

    void setAudioPlayoutVolume(int i3);

    void setAudioRoute(int i3);

    void setDefaultStreamRecvMode(boolean z16, boolean z17);

    void setLocalRenderParams(GroupLiveTRTCRenderParams groupLiveTRTCRenderParams);

    int setLocalVideoRenderListener(int i3, int i16, GroupLiveTRTCCloudListener.GroupLiveTRTCVideoRenderListener groupLiveTRTCVideoRenderListener);

    void setMixExternalAudioVolume(int i3, int i16);

    void setNetworkQosParam(GroupLiveTRTCNetworkQosParam groupLiveTRTCNetworkQosParam);

    void setRemoteAudioVolume(String str, int i3);

    void setRemoteRenderParams(String str, int i3, GroupLiveTRTCRenderParams groupLiveTRTCRenderParams);

    int setRemoteVideoRenderListener(String str, int i3, int i16, GroupLiveTRTCCloudListener.GroupLiveTRTCVideoRenderListener groupLiveTRTCVideoRenderListener);

    int setRemoteVideoStreamType(String str, int i3);

    void setVideoEncoderParam(GroupLiveTRTCVideoEncParam groupLiveTRTCVideoEncParam);

    void startLocalAudio(int i3);

    void startLocalPreview(boolean z16, Context context, TextureView textureView);

    void startRemoteView(String str, int i3, Context context, TextureView textureView);

    void stopAllRemoteView();

    void stopLocalAudio();

    void stopLocalPreview();

    void stopRemoteView(String str, int i3);

    void switchRole(int i3);

    void switchRole(int i3, String str);

    void uninit();

    void updateLocalView(Context context, TextureView textureView);

    void updateRemoteView(String str, int i3, Context context, TextureView textureView);
}
