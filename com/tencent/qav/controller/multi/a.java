package com.tencent.qav.controller.multi;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface a {
    int e(com.tencent.qav.a aVar);

    int enableLocalAudio(boolean z16);

    void enableRemoteAudio(boolean z16);

    void exitRoom();

    int getAudioRoute();

    String getNetWorkQualityRTT();

    boolean isLocalAudioEnable();

    void setAudioRoute(int i3);

    void setEncodeDecodePtr(long j3, boolean z16, boolean z17);

    void updateRoomInfo();
}
