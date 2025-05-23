package com.huya.huyasdk.api;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface LiveRoomEventCallback {
    void onAttendeeCountChange(int i3);

    void onLiveBegin(HuyaLiveBeginLive huyaLiveBeginLive);

    void onLiveEnd(long j3);

    void onLiveInfoChange(HuyaLiveBeginLive huyaLiveBeginLive);
}
