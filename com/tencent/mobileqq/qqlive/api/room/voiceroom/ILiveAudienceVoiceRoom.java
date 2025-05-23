package com.tencent.mobileqq.qqlive.api.room.voiceroom;

import com.tencent.mobileqq.qqlive.api.av.IAudioAbility;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ILiveAudienceVoiceRoom extends IAudienceRoom, IAudioAbility {
    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    void enterTrtcRoom(String str, long j3, QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo);

    void exitTrtcRoom();

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);

    void updateVoiceAnchorInfo(VoiceAnchorInfo voiceAnchorInfo);
}
