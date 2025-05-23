package com.tencent.mobileqq.qqlive.api.av;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IAVChatAbility {
    void addAVChatRoomListener(AVChatRoomListener aVChatRoomListener);

    void closeCamera();

    void closeMic();

    void enableBitmapUploader(boolean z16, Bitmap bitmap);

    boolean isCameraOpened();

    boolean isMicOpened();

    void openCamera(ViewGroup viewGroup);

    void openMic();

    void removeAVChatRoomListener(AVChatRoomListener aVChatRoomListener);

    boolean sendSEIMsg(byte[] bArr, int i3);

    void setBeautyPreProcess(a aVar);

    void setPreview(ViewGroup viewGroup);

    void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams);

    void startPublish();

    void startRemoteAudio(String str);

    void startRemoteVideo(String str, ViewGroup viewGroup);

    void stopAllRemoteAudio();

    void stopAllRemoteVideo();

    void stopPublish();

    void stopRemoteAudio(String str);

    void stopRemoteVideo(String str);

    void switchCamera();

    void updateMediaConfig(LiveMediaConfig liveMediaConfig);
}
