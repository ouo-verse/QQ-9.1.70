package com.tencent.state.common.push;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/common/push/PushBasic;", "", "seq", "", "ts", "trigger", "(JJJ)V", "getSeq", "()J", "getTrigger", "getTs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class PushBasic {
    private final long seq;
    private final long trigger;
    private final long ts;

    public PushBasic(long j3, long j16, long j17) {
        this.seq = j3;
        this.ts = j16;
        this.trigger = j17;
    }

    /* renamed from: component1, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTs() {
        return this.ts;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTrigger() {
        return this.trigger;
    }

    public final PushBasic copy(long seq, long ts5, long trigger) {
        return new PushBasic(seq, ts5, trigger);
    }

    public final long getSeq() {
        return this.seq;
    }

    public final long getTrigger() {
        return this.trigger;
    }

    public final long getTs() {
        return this.ts;
    }

    public int hashCode() {
        return (((c.a(this.seq) * 31) + c.a(this.ts)) * 31) + c.a(this.trigger);
    }

    public String toString() {
        return "PushBasic(seq=" + this.seq + ", ts=" + this.ts + ", trigger=" + this.trigger + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushBasic)) {
            return false;
        }
        PushBasic pushBasic = (PushBasic) other;
        return this.seq == pushBasic.seq && this.ts == pushBasic.ts && this.trigger == pushBasic.trigger;
    }

    public static /* synthetic */ PushBasic copy$default(PushBasic pushBasic, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = pushBasic.seq;
        }
        long j18 = j3;
        if ((i3 & 2) != 0) {
            j16 = pushBasic.ts;
        }
        long j19 = j16;
        if ((i3 & 4) != 0) {
            j17 = pushBasic.trigger;
        }
        return pushBasic.copy(j18, j19, j17);
    }
}
