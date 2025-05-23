package jj0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Ljj0/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "setStartTime", "(J)V", "startTime", "setEndTime", "endTime", "<init>", "(JJ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: jj0.d, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ECTransactionReqTimeRange {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long endTime;

    public ECTransactionReqTimeRange() {
        this(0L, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (com.tencent.ecommerce.biz.commission.forecast.b.a(this.startTime) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.endTime);
    }

    public String toString() {
        return "ECTransactionReqTimeRange(startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
    }

    public ECTransactionReqTimeRange(long j3, long j16) {
        this.startTime = j3;
        this.endTime = j16;
    }

    public /* synthetic */ ECTransactionReqTimeRange(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECTransactionReqTimeRange)) {
            return false;
        }
        ECTransactionReqTimeRange eCTransactionReqTimeRange = (ECTransactionReqTimeRange) other;
        return this.startTime == eCTransactionReqTimeRange.startTime && this.endTime == eCTransactionReqTimeRange.endTime;
    }
}
