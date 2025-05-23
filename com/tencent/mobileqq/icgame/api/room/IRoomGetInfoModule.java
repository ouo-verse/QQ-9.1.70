package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IRoomGetInfoModule extends IQQLiveModule {
    void getRoomRealTimeInfo(long j3, String str, GetRoomInfoCallback getRoomInfoCallback);
}
