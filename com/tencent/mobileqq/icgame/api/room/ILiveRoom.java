package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface ILiveRoom extends ILiveRoomBase, ILiveRoomMessage, ILiveRoomOperation, ILiveRoomTime {
    /* synthetic */ void clearReportCallback();

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    BaseAnchorInfo getAnchorInfo();

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    BaseRoomInfo getRoomInfo();

    boolean isAnchorRoom();

    void registerMessageSmoothConfig(MessagePushConfig messagePushConfig);

    /* synthetic */ void registerReportCallback(a aVar);

    void unRegisterMessageSmooth();

    /* synthetic */ void unRegisterReportCallback(a aVar);
}
