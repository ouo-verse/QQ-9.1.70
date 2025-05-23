package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IRoomGetInfoModule extends IQQLiveModule {
    void getRoomRealTimeInfo(long j3, String str, GetRoomInfoCallback getRoomInfoCallback);
}
