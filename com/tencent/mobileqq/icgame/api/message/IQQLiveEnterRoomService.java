package com.tencent.mobileqq.icgame.api.message;

import a32.a;
import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveEnterRoomService extends IQQLiveModule {
    void addEnterRoomMessageListener(a aVar);

    void bindRoom(ILiveRoom iLiveRoom);

    void delEnterRoomMessageListener(a aVar);
}
