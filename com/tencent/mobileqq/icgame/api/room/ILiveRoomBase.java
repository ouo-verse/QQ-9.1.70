package com.tencent.mobileqq.icgame.api.room;

import a32.b;
import b32.d;
import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface ILiveRoomBase extends IQQLiveModule {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public enum ServiceType {
        PUSH,
        DATA
    }

    void exitRoom(ExitRoomCallback exitRoomCallback);

    BaseAnchorInfo getAnchorInfo();

    void getLiveEndPageInfo(d dVar);

    BaseRoomInfo getRoomInfo();

    void getUserNumber(long j3, b bVar);

    boolean isDestroyed();

    boolean isExitRoom();

    boolean isInited();

    void preloadService(long j3, ServiceType serviceType);
}
