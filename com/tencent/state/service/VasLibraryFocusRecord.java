package com.tencent.state.service;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/service/VasLibraryFocusRecord;", "", "isFinish", "", "totalTime", "", "(ZJ)V", "()Z", "getTotalTime", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class VasLibraryFocusRecord {
    private final boolean isFinish;
    private final long totalTime;

    public VasLibraryFocusRecord(boolean z16, long j3) {
        this.isFinish = z16;
        this.totalTime = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTotalTime() {
        return this.totalTime;
    }

    public final VasLibraryFocusRecord copy(boolean isFinish, long totalTime) {
        return new VasLibraryFocusRecord(isFinish, totalTime);
    }

    public final long getTotalTime() {
        return this.totalTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isFinish;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + c.a(this.totalTime);
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public String toString() {
        return "VasLibraryFocusRecord(isFinish=" + this.isFinish + ", totalTime=" + this.totalTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasLibraryFocusRecord)) {
            return false;
        }
        VasLibraryFocusRecord vasLibraryFocusRecord = (VasLibraryFocusRecord) other;
        return this.isFinish == vasLibraryFocusRecord.isFinish && this.totalTime == vasLibraryFocusRecord.totalTime;
    }

    public static /* synthetic */ VasLibraryFocusRecord copy$default(VasLibraryFocusRecord vasLibraryFocusRecord, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = vasLibraryFocusRecord.isFinish;
        }
        if ((i3 & 2) != 0) {
            j3 = vasLibraryFocusRecord.totalTime;
        }
        return vasLibraryFocusRecord.copy(z16, j3);
    }
}
