package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface ILiveMediaRoom<F> extends ILiveRoom {
    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    F getDisplayView();

    boolean isOutputMute();

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void setMute(boolean z16);

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);
}
