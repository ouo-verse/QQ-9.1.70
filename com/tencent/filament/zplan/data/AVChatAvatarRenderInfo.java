package com.tencent.filament.zplan.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010!\u001a\u00020\"R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/data/AVChatAvatarRenderInfo;", "", "firstFrameTimestamp", "", "firstRenderTimestamp", "lastAvatarAIData", "Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "(JJLcom/tencent/filament/zplan/data/AvatarAIInfo;)V", "continuousCacheEmptyCnt", "", "getContinuousCacheEmptyCnt", "()I", "setContinuousCacheEmptyCnt", "(I)V", "curDelayRenderMs", "getCurDelayRenderMs", "()J", "setCurDelayRenderMs", "(J)V", "getFirstFrameTimestamp", "setFirstFrameTimestamp", "getFirstRenderTimestamp", "setFirstRenderTimestamp", "getLastAvatarAIData", "()Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "setLastAvatarAIData", "(Lcom/tencent/filament/zplan/data/AvatarAIInfo;)V", "lastCacheEndSmoothDelay", "getLastCacheEndSmoothDelay", "setLastCacheEndSmoothDelay", "lastFrameCacheTimestamp", "getLastFrameCacheTimestamp", "setLastFrameCacheTimestamp", "reset", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AVChatAvatarRenderInfo {
    private int continuousCacheEmptyCnt;
    private long curDelayRenderMs;
    private long firstFrameTimestamp;
    private long firstRenderTimestamp;

    @Nullable
    private AvatarAIInfo lastAvatarAIData;
    private long lastCacheEndSmoothDelay;
    private long lastFrameCacheTimestamp;

    public AVChatAvatarRenderInfo() {
        this(0L, 0L, null, 7, null);
    }

    public final int getContinuousCacheEmptyCnt() {
        return this.continuousCacheEmptyCnt;
    }

    public final long getCurDelayRenderMs() {
        return this.curDelayRenderMs;
    }

    public final long getFirstFrameTimestamp() {
        return this.firstFrameTimestamp;
    }

    public final long getFirstRenderTimestamp() {
        return this.firstRenderTimestamp;
    }

    @Nullable
    public final AvatarAIInfo getLastAvatarAIData() {
        return this.lastAvatarAIData;
    }

    public final long getLastCacheEndSmoothDelay() {
        return this.lastCacheEndSmoothDelay;
    }

    public final long getLastFrameCacheTimestamp() {
        return this.lastFrameCacheTimestamp;
    }

    public final void reset() {
        this.firstFrameTimestamp = 0L;
        this.firstRenderTimestamp = 0L;
        this.lastFrameCacheTimestamp = 0L;
        this.curDelayRenderMs = this.lastCacheEndSmoothDelay;
        this.lastCacheEndSmoothDelay = 0L;
        this.continuousCacheEmptyCnt = 0;
    }

    public final void setContinuousCacheEmptyCnt(int i3) {
        this.continuousCacheEmptyCnt = i3;
    }

    public final void setCurDelayRenderMs(long j3) {
        this.curDelayRenderMs = j3;
    }

    public final void setFirstFrameTimestamp(long j3) {
        this.firstFrameTimestamp = j3;
    }

    public final void setFirstRenderTimestamp(long j3) {
        this.firstRenderTimestamp = j3;
    }

    public final void setLastAvatarAIData(@Nullable AvatarAIInfo avatarAIInfo) {
        this.lastAvatarAIData = avatarAIInfo;
    }

    public final void setLastCacheEndSmoothDelay(long j3) {
        this.lastCacheEndSmoothDelay = j3;
    }

    public final void setLastFrameCacheTimestamp(long j3) {
        this.lastFrameCacheTimestamp = j3;
    }

    public AVChatAvatarRenderInfo(long j3, long j16, @Nullable AvatarAIInfo avatarAIInfo) {
        this.firstFrameTimestamp = j3;
        this.firstRenderTimestamp = j16;
        this.lastAvatarAIData = avatarAIInfo;
    }

    public /* synthetic */ AVChatAvatarRenderInfo(long j3, long j16, AvatarAIInfo avatarAIInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? null : avatarAIInfo);
    }
}
