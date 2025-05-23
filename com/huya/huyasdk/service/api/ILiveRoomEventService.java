package com.huya.huyasdk.service.api;

import com.huya.huyasdk.api.HuyaLiveJoinCallback;
import com.huya.huyasdk.api.HuyaLiveJoinConfig;
import com.huya.huyasdk.api.LiveRoomEventCallback;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ILiveRoomEventService {
    void enterLiveRoom(HuyaLiveJoinConfig huyaLiveJoinConfig, HuyaLiveJoinCallback huyaLiveJoinCallback);

    long getCurrentPid();

    boolean inLiveRoom();

    long quitLiveRoom();

    void registerLiveEvent(LiveRoomEventCallback liveRoomEventCallback);
}
