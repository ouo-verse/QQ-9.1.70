package com.tencent.mobileqq.qqlive.api.anchor.room;

import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.report.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/anchor/room/IQQLiveAnchorObsRoom;", "Lcom/tencent/mobileqq/qqlive/api/anchor/room/IQQLiveAnchorRoom;", "getRtmpPushUrl", "", "params", "Lcom/tencent/mobileqq/qqlive/data/anchor/params/QQLiveAnchorAutoCheckPullPlayParams;", "pushInfoReady", "", "reconnectObsRoom", "setPushInfo", "pushInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public interface IQQLiveAnchorObsRoom extends IQQLiveAnchorRoom {
    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    void getRtmpPushUrl(@Nullable QQLiveAnchorAutoCheckPullPlayParams params);

    boolean pushInfoReady();

    void reconnectObsRoom();

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void setPushInfo(@Nullable QQLiveAnchorDataPushInfo pushInfo);

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);
}
