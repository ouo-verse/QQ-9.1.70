package com.tencent.mobileqq.icgame.api.room;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b32.c;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IAudienceRoom extends ILiveRoom {
    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    void enterRoom(@NonNull EnterRoomInfo enterRoomInfo, @NonNull EnterRoomReqConfig enterRoomReqConfig, boolean z16, @Nullable c cVar);

    void enterRoom(@NonNull EnterRoomInfo enterRoomInfo, boolean z16, @Nullable c cVar);

    AudienceRoomConfig getAudienceRoomConfig();

    LiveInfo getRoomLiveInfo();

    int getRoomType();

    boolean isQQAnchor();

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void setExtraData(Bundle bundle);

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);
}
