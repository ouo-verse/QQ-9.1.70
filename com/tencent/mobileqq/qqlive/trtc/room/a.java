package com.tencent.mobileqq.qqlive.trtc.room;

import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a {
    void a(QQLiveRoomParams qQLiveRoomParams) throws IllegalStateException, IllegalArgumentException;

    void b(ITRTCRoomListener iTRTCRoomListener);

    void destroy();

    void enterRoom(QQLiveRoomParams qQLiveRoomParams) throws IllegalStateException, IllegalArgumentException;

    void exitRoom() throws IllegalStateException;

    boolean sendSEIMsg(byte[] bArr, int i3);

    void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams);

    void startRemoteVideo(String str, ViewGroup viewGroup);

    void stopAllRemoteVideo();

    void stopRemoteVideo(String str);
}
