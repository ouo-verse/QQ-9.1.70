package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.qqlive.report.a;

/* loaded from: classes15.dex */
public interface ILiveTPPlayerRoom extends ILiveMediaRoom<ITPPlayerVideoView> {
    @Override // com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    int getPlayStatus();

    void pause();

    void play();

    void playerOnlyPauseWhenReset(boolean z16);

    void preloadUrl(String str);

    void preloadWithCurrentUrl();

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void registerRoomPlayerListener(b32.a aVar);

    void setRetryParams(long j3, int i3);

    void startPlay(String str);

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);

    void unRegisterRoomPlayerListener(b32.a aVar);
}
