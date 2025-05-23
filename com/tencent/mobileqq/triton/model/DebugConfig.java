package com.tencent.mobileqq.triton.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\bH\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/triton/model/DebugConfig;", "", "debugEnabled", "", "presentDetectIntervalMillis", "", "noPresentDurationToCheckLimitMillis", "frameNoChangeToCheckLimit", "", "noPresentTouchLimit", "enablePremultipliedAlpha", "enableWebAudio", "(ZJJIIZZ)V", "getDebugEnabled", "()Z", "getEnablePremultipliedAlpha", "getEnableWebAudio", "getFrameNoChangeToCheckLimit", "()I", "getNoPresentDurationToCheckLimitMillis", "()J", "getNoPresentTouchLimit", "getPresentDetectIntervalMillis", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class DebugConfig {
    private final boolean debugEnabled;
    private final boolean enablePremultipliedAlpha;
    private final boolean enableWebAudio;
    private final int frameNoChangeToCheckLimit;
    private final long noPresentDurationToCheckLimitMillis;
    private final int noPresentTouchLimit;
    private final long presentDetectIntervalMillis;

    public DebugConfig() {
        this(false, 0L, 0L, 0, 0, false, false, 127, null);
    }

    public static /* synthetic */ DebugConfig copy$default(DebugConfig debugConfig, boolean z16, long j3, long j16, int i3, int i16, boolean z17, boolean z18, int i17, Object obj) {
        boolean z19;
        long j17;
        long j18;
        int i18;
        int i19;
        boolean z26;
        boolean z27;
        if ((i17 & 1) != 0) {
            z19 = debugConfig.debugEnabled;
        } else {
            z19 = z16;
        }
        if ((i17 & 2) != 0) {
            j17 = debugConfig.presentDetectIntervalMillis;
        } else {
            j17 = j3;
        }
        if ((i17 & 4) != 0) {
            j18 = debugConfig.noPresentDurationToCheckLimitMillis;
        } else {
            j18 = j16;
        }
        if ((i17 & 8) != 0) {
            i18 = debugConfig.frameNoChangeToCheckLimit;
        } else {
            i18 = i3;
        }
        if ((i17 & 16) != 0) {
            i19 = debugConfig.noPresentTouchLimit;
        } else {
            i19 = i16;
        }
        if ((i17 & 32) != 0) {
            z26 = debugConfig.enablePremultipliedAlpha;
        } else {
            z26 = z17;
        }
        if ((i17 & 64) != 0) {
            z27 = debugConfig.enableWebAudio;
        } else {
            z27 = z18;
        }
        return debugConfig.copy(z19, j17, j18, i18, i19, z26, z27);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDebugEnabled() {
        return this.debugEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPresentDetectIntervalMillis() {
        return this.presentDetectIntervalMillis;
    }

    /* renamed from: component3, reason: from getter */
    public final long getNoPresentDurationToCheckLimitMillis() {
        return this.noPresentDurationToCheckLimitMillis;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFrameNoChangeToCheckLimit() {
        return this.frameNoChangeToCheckLimit;
    }

    /* renamed from: component5, reason: from getter */
    public final int getNoPresentTouchLimit() {
        return this.noPresentTouchLimit;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnablePremultipliedAlpha() {
        return this.enablePremultipliedAlpha;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableWebAudio() {
        return this.enableWebAudio;
    }

    @NotNull
    public final DebugConfig copy(boolean debugEnabled, long presentDetectIntervalMillis, long noPresentDurationToCheckLimitMillis, int frameNoChangeToCheckLimit, int noPresentTouchLimit, boolean enablePremultipliedAlpha, boolean enableWebAudio) {
        return new DebugConfig(debugEnabled, presentDetectIntervalMillis, noPresentDurationToCheckLimitMillis, frameNoChangeToCheckLimit, noPresentTouchLimit, enablePremultipliedAlpha, enableWebAudio);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DebugConfig) {
                DebugConfig debugConfig = (DebugConfig) other;
                if (this.debugEnabled != debugConfig.debugEnabled || this.presentDetectIntervalMillis != debugConfig.presentDetectIntervalMillis || this.noPresentDurationToCheckLimitMillis != debugConfig.noPresentDurationToCheckLimitMillis || this.frameNoChangeToCheckLimit != debugConfig.frameNoChangeToCheckLimit || this.noPresentTouchLimit != debugConfig.noPresentTouchLimit || this.enablePremultipliedAlpha != debugConfig.enablePremultipliedAlpha || this.enableWebAudio != debugConfig.enableWebAudio) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getDebugEnabled() {
        return this.debugEnabled;
    }

    public final boolean getEnablePremultipliedAlpha() {
        return this.enablePremultipliedAlpha;
    }

    public final boolean getEnableWebAudio() {
        return this.enableWebAudio;
    }

    public final int getFrameNoChangeToCheckLimit() {
        return this.frameNoChangeToCheckLimit;
    }

    public final long getNoPresentDurationToCheckLimitMillis() {
        return this.noPresentDurationToCheckLimitMillis;
    }

    public final int getNoPresentTouchLimit() {
        return this.noPresentTouchLimit;
    }

    public final long getPresentDetectIntervalMillis() {
        return this.presentDetectIntervalMillis;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.debugEnabled;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        long j3 = this.presentDetectIntervalMillis;
        int i16 = ((r06 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.noPresentDurationToCheckLimitMillis;
        int i17 = (((((i16 + ((int) (j16 ^ (j16 >>> 32)))) * 31) + this.frameNoChangeToCheckLimit) * 31) + this.noPresentTouchLimit) * 31;
        ?? r26 = this.enablePremultipliedAlpha;
        int i18 = r26;
        if (r26 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z17 = this.enableWebAudio;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "DebugConfig(debugEnabled=" + this.debugEnabled + ", presentDetectIntervalMillis=" + this.presentDetectIntervalMillis + ", noPresentDurationToCheckLimitMillis=" + this.noPresentDurationToCheckLimitMillis + ", frameNoChangeToCheckLimit=" + this.frameNoChangeToCheckLimit + ", noPresentTouchLimit=" + this.noPresentTouchLimit + ", enablePremultipliedAlpha=" + this.enablePremultipliedAlpha + ", enableWebAudio=" + this.enableWebAudio + ")";
    }

    public DebugConfig(boolean z16, long j3, long j16, int i3, int i16, boolean z17, boolean z18) {
        this.debugEnabled = z16;
        this.presentDetectIntervalMillis = j3;
        this.noPresentDurationToCheckLimitMillis = j16;
        this.frameNoChangeToCheckLimit = i3;
        this.noPresentTouchLimit = i16;
        this.enablePremultipliedAlpha = z17;
        this.enableWebAudio = z18;
    }

    public /* synthetic */ DebugConfig(boolean z16, long j3, long j16, int i3, int i16, boolean z17, boolean z18, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 5000L : j3, (i17 & 4) != 0 ? 3000L : j16, (i17 & 8) != 0 ? 6 : i3, (i17 & 16) != 0 ? 1 : i16, (i17 & 32) != 0 ? false : z17, (i17 & 64) == 0 ? z18 : false);
    }
}
