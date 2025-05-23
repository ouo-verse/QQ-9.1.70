package com.tencent.state.service;

import com.tencent.mobileqq.vas.banner.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003JQ\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/service/VasLibraryFocusTask;", "", "startTimestamp", "", "endTimestamp", "finishTimestamp", "dailyResult", "", "", "hintRecovery", "serverTime", "(JJJLjava/util/Map;ZJ)V", "getDailyResult", "()Ljava/util/Map;", "getEndTimestamp", "()J", "getFinishTimestamp", "getHintRecovery", "()Z", "getServerTime", "getStartTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class VasLibraryFocusTask {
    private final Map<Long, Boolean> dailyResult;
    private final long endTimestamp;
    private final long finishTimestamp;
    private final boolean hintRecovery;
    private final long serverTime;
    private final long startTimestamp;

    public VasLibraryFocusTask(long j3, long j16, long j17, Map<Long, Boolean> dailyResult, boolean z16, long j18) {
        Intrinsics.checkNotNullParameter(dailyResult, "dailyResult");
        this.startTimestamp = j3;
        this.endTimestamp = j16;
        this.finishTimestamp = j17;
        this.dailyResult = dailyResult;
        this.hintRecovery = z16;
        this.serverTime = j18;
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final long getFinishTimestamp() {
        return this.finishTimestamp;
    }

    public final Map<Long, Boolean> component4() {
        return this.dailyResult;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getHintRecovery() {
        return this.hintRecovery;
    }

    /* renamed from: component6, reason: from getter */
    public final long getServerTime() {
        return this.serverTime;
    }

    public final VasLibraryFocusTask copy(long startTimestamp, long endTimestamp, long finishTimestamp, Map<Long, Boolean> dailyResult, boolean hintRecovery, long serverTime) {
        Intrinsics.checkNotNullParameter(dailyResult, "dailyResult");
        return new VasLibraryFocusTask(startTimestamp, endTimestamp, finishTimestamp, dailyResult, hintRecovery, serverTime);
    }

    public final Map<Long, Boolean> getDailyResult() {
        return this.dailyResult;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final long getFinishTimestamp() {
        return this.finishTimestamp;
    }

    public final boolean getHintRecovery() {
        return this.hintRecovery;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((c.a(this.startTimestamp) * 31) + c.a(this.endTimestamp)) * 31) + c.a(this.finishTimestamp)) * 31;
        Map<Long, Boolean> map = this.dailyResult;
        int hashCode = (a16 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z16 = this.hintRecovery;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + c.a(this.serverTime);
    }

    public String toString() {
        return "VasLibraryFocusTask(startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", finishTimestamp=" + this.finishTimestamp + ", dailyResult=" + this.dailyResult + ", hintRecovery=" + this.hintRecovery + ", serverTime=" + this.serverTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasLibraryFocusTask)) {
            return false;
        }
        VasLibraryFocusTask vasLibraryFocusTask = (VasLibraryFocusTask) other;
        return this.startTimestamp == vasLibraryFocusTask.startTimestamp && this.endTimestamp == vasLibraryFocusTask.endTimestamp && this.finishTimestamp == vasLibraryFocusTask.finishTimestamp && Intrinsics.areEqual(this.dailyResult, vasLibraryFocusTask.dailyResult) && this.hintRecovery == vasLibraryFocusTask.hintRecovery && this.serverTime == vasLibraryFocusTask.serverTime;
    }
}
