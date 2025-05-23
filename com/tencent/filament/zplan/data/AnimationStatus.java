package com.tencent.filament.zplan.data;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/data/AnimationStatus;", "", "()V", "isFirstFrame", "", "()Z", "setFirstFrame", "(Z)V", "isFirstFrameSuccess", "setFirstFrameSuccess", "lastFrameTime", "", "getLastFrameTime", "()D", "setLastFrameTime", "(D)V", "offsetDuration", "getOffsetDuration", "setOffsetDuration", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "Lcom/tencent/filament/zplan/data/AnimationStatus$PLAY_STATE;", "getPlayState", "()Lcom/tencent/filament/zplan/data/AnimationStatus$PLAY_STATE;", "setPlayState", "(Lcom/tencent/filament/zplan/data/AnimationStatus$PLAY_STATE;)V", "totalFrameTime", "getTotalFrameTime", "setTotalFrameTime", "playFromHead", "", "stop", "PLAY_STATE", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AnimationStatus {
    private boolean isFirstFrame;
    private boolean isFirstFrameSuccess;
    private double lastFrameTime;
    private double offsetDuration;

    @NotNull
    private PLAY_STATE playState = PLAY_STATE.STOPPED;
    private double totalFrameTime;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/data/AnimationStatus$PLAY_STATE;", "", "(Ljava/lang/String;I)V", "PLAYING", "PAUSED", "STOPPED", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum PLAY_STATE {
        PLAYING,
        PAUSED,
        STOPPED
    }

    public final double getLastFrameTime() {
        return this.lastFrameTime;
    }

    public final double getOffsetDuration() {
        return this.offsetDuration;
    }

    @NotNull
    public final PLAY_STATE getPlayState() {
        return this.playState;
    }

    public final double getTotalFrameTime() {
        return this.totalFrameTime;
    }

    /* renamed from: isFirstFrame, reason: from getter */
    public final boolean getIsFirstFrame() {
        return this.isFirstFrame;
    }

    /* renamed from: isFirstFrameSuccess, reason: from getter */
    public final boolean getIsFirstFrameSuccess() {
        return this.isFirstFrameSuccess;
    }

    public final void playFromHead() {
        this.totalFrameTime = 0.0d;
        this.playState = PLAY_STATE.PLAYING;
        this.isFirstFrame = true;
        this.isFirstFrameSuccess = false;
    }

    public final void setFirstFrame(boolean z16) {
        this.isFirstFrame = z16;
    }

    public final void setFirstFrameSuccess(boolean z16) {
        this.isFirstFrameSuccess = z16;
    }

    public final void setLastFrameTime(double d16) {
        this.lastFrameTime = d16;
    }

    public final void setOffsetDuration(double d16) {
        this.offsetDuration = d16;
    }

    public final void setPlayState(@NotNull PLAY_STATE play_state) {
        Intrinsics.checkNotNullParameter(play_state, "<set-?>");
        this.playState = play_state;
    }

    public final void setTotalFrameTime(double d16) {
        this.totalFrameTime = d16;
    }

    public final void stop() {
        this.totalFrameTime = 0.0d;
        this.playState = PLAY_STATE.STOPPED;
        this.isFirstFrameSuccess = false;
    }
}
