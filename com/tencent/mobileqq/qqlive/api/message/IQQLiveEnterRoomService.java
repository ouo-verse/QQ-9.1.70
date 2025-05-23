package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveEnterRoomService extends IQQLiveModule {
    void addEnterRoomMessageListener(RoomAudienceInfoListener roomAudienceInfoListener);

    void bindRoom(ILiveRoom iLiveRoom);

    void delEnterRoomMessageListener(RoomAudienceInfoListener roomAudienceInfoListener);
}
