package com.tencent.mobileqq.qqlive.api.anchor.room;

import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.report.a;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorThirdPushRoom extends IQQLiveAnchorRoom, ILiveTPPlayerRoom {
    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    boolean disableViewCallback();

    boolean enableViewCallback();

    void getRtmpPullUrl(QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams);

    void getRtmpPushUrl(QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams);

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);
}
