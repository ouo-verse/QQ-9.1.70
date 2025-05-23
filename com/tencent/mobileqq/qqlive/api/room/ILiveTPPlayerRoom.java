package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.report.a;

/* loaded from: classes17.dex */
public interface ILiveTPPlayerRoom extends ILiveMediaRoom<ITPPlayerVideoView> {
    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    int getPlayStatus();

    boolean isPlaying();

    void pause();

    void play();

    void playerOnlyPauseWhenReset(boolean z16);

    void preloadUrl(String str);

    void preloadWithCurrentUrl();

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void registerRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener);

    void setIgnoreRoomPush(boolean z16);

    void setRetryParams(long j3, int i3);

    void startPlay(String str);

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);

    void unRegisterRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener);
}
