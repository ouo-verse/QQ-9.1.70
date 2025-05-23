package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/FirstFrameStatistic;", "", "firstRenderTimeMs", "", "drawCallCount", "(JJ)V", "getDrawCallCount", "()J", "getFirstRenderTimeMs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class FirstFrameStatistic {
    private final long drawCallCount;
    private final long firstRenderTimeMs;

    public FirstFrameStatistic(long j3, long j16) {
        this.firstRenderTimeMs = j3;
        this.drawCallCount = j16;
    }

    public static /* synthetic */ FirstFrameStatistic copy$default(FirstFrameStatistic firstFrameStatistic, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = firstFrameStatistic.firstRenderTimeMs;
        }
        if ((i3 & 2) != 0) {
            j16 = firstFrameStatistic.drawCallCount;
        }
        return firstFrameStatistic.copy(j3, j16);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFirstRenderTimeMs() {
        return this.firstRenderTimeMs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDrawCallCount() {
        return this.drawCallCount;
    }

    @NotNull
    public final FirstFrameStatistic copy(long firstRenderTimeMs, long drawCallCount) {
        return new FirstFrameStatistic(firstRenderTimeMs, drawCallCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FirstFrameStatistic) {
                FirstFrameStatistic firstFrameStatistic = (FirstFrameStatistic) other;
                if (this.firstRenderTimeMs != firstFrameStatistic.firstRenderTimeMs || this.drawCallCount != firstFrameStatistic.drawCallCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getDrawCallCount() {
        return this.drawCallCount;
    }

    public final long getFirstRenderTimeMs() {
        return this.firstRenderTimeMs;
    }

    public int hashCode() {
        long j3 = this.firstRenderTimeMs;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        long j16 = this.drawCallCount;
        return i3 + ((int) ((j16 >>> 32) ^ j16));
    }

    @NotNull
    public String toString() {
        return "FirstFrameStatistic(firstRenderTimeMs=" + this.firstRenderTimeMs + ", drawCallCount=" + this.drawCallCount + ")";
    }
}
