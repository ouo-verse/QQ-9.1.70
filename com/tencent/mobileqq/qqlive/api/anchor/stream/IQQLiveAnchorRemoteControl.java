package com.tencent.mobileqq.qqlive.api.anchor.stream;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorRemoteControl {
    void addRemoteListener(ITRTCRemoteListener iTRTCRemoteListener);

    void connectRemote(long j3, long j16);

    void disconnectRemote();

    int getAudioPlayOutVolume();

    void muteAllRemoteAudio(boolean z16);

    void muteRemoteAudio(String str, boolean z16);

    void removeRemoteListener(ITRTCRemoteListener iTRTCRemoteListener);

    boolean sendSEIMsg(byte[] bArr, int i3);

    void setAudioPlayOutVolume(int i3);

    void setRemoteAudioVolume(String str, int i3);

    void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams);

    void startRemoteVideo(String str, ViewGroup viewGroup);

    void startRemoteView(String str, FrameLayout frameLayout);

    void stopAllRemoteVideo();

    void stopRemoteVideo(String str);

    void stopRemoteView(String str);
}
