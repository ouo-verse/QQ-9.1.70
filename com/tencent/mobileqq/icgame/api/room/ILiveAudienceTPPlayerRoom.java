package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayUrlHandler;
import com.tencent.mobileqq.qqlive.report.a;
import java.util.List;

/* loaded from: classes15.dex */
public interface ILiveAudienceTPPlayerRoom extends ILiveTPPlayerRoom, IAudienceRoom {
    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom, com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    boolean disableViewCallback();

    boolean enableViewCallback();

    List<EnterRoomInfo.VideoDefinition> getDefinitionList();

    StreamType getStreamType();

    String getTargetUrl(EnterRoomInfo.VideoDefinition videoDefinition);

    EnterRoomInfo.VideoDefinition getVideoDefinition();

    i getVideoSize();

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom, com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void replay();

    void setUrlHandler(AudienceRoomPlayUrlHandler audienceRoomPlayUrlHandler);

    void setXYAxis(int i3);

    void switchVideoDefinition(EnterRoomInfo.VideoDefinition videoDefinition);

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom, com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);

    void updateCurrentDefinitionFromOutPlayer(EnterRoomInfo.VideoDefinition videoDefinition);
}
