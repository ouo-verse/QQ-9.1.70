package com.tencent.mobileqq.guild.message.summary;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/message/summary/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getLatestEndSeq", "()J", "latestEndSeq", "b", "getNextPullMsgTime", "nextPullMsgTime", "<init>", "(JJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.message.summary.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuestNextPullSummaryMsgParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long latestEndSeq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long nextPullMsgTime;

    public GuestNextPullSummaryMsgParams(long j3, long j16) {
        this.latestEndSeq = j3;
        this.nextPullMsgTime = j16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuestNextPullSummaryMsgParams)) {
            return false;
        }
        GuestNextPullSummaryMsgParams guestNextPullSummaryMsgParams = (GuestNextPullSummaryMsgParams) other;
        if (this.latestEndSeq == guestNextPullSummaryMsgParams.latestEndSeq && this.nextPullMsgTime == guestNextPullSummaryMsgParams.nextPullMsgTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.latestEndSeq) * 31) + androidx.fragment.app.a.a(this.nextPullMsgTime);
    }

    @NotNull
    public String toString() {
        return "GuestNextPullSummaryMsgParams(latestEndSeq=" + this.latestEndSeq + ", nextPullMsgTime=" + this.nextPullMsgTime + ")";
    }
}
