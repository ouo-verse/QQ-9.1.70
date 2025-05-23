package com.tencent.mobileqq.qqlive.api.room;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IAudienceRoom extends ILiveRoom {
    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    void enterRoom(@NonNull EnterRoomInfo enterRoomInfo, @NonNull EnterRoomReqConfig enterRoomReqConfig, boolean z16, @Nullable EnterAudienceRoomCallback enterAudienceRoomCallback);

    void enterRoom(@NonNull EnterRoomInfo enterRoomInfo, boolean z16, @Nullable EnterAudienceRoomCallback enterAudienceRoomCallback);

    AudienceRoomConfig getAudienceRoomConfig();

    LiveInfo getRoomLiveInfo();

    int getRoomType();

    boolean isQQAnchor();

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void setExtraData(Bundle bundle);

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);
}
