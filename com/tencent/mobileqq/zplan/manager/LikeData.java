package com.tencent.mobileqq.zplan.manager;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0017\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/manager/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/concurrent/atomic/AtomicLong;", "a", "Ljava/util/concurrent/atomic/AtomicLong;", "f", "()Ljava/util/concurrent/atomic/AtomicLong;", "vipMaxVoteNum", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "svipFriendMaxVoteNotice", "c", "friendUin", "d", "todayVotedCount", "e", "todayAvailableVotedCount", "totalVoted", "<init>", "(Ljava/util/concurrent/atomic/AtomicLong;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicLong;Ljava/util/concurrent/atomic/AtomicLong;Ljava/util/concurrent/atomic/AtomicLong;Ljava/util/concurrent/atomic/AtomicLong;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.manager.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class LikeData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final AtomicLong vipMaxVoteNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String svipFriendMaxVoteNotice;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final AtomicLong friendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final AtomicLong todayVotedCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final AtomicLong todayAvailableVotedCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final AtomicLong totalVoted;

    public LikeData() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final AtomicLong getFriendUin() {
        return this.friendUin;
    }

    /* renamed from: b, reason: from getter */
    public final String getSvipFriendMaxVoteNotice() {
        return this.svipFriendMaxVoteNotice;
    }

    /* renamed from: c, reason: from getter */
    public final AtomicLong getTodayAvailableVotedCount() {
        return this.todayAvailableVotedCount;
    }

    /* renamed from: d, reason: from getter */
    public final AtomicLong getTodayVotedCount() {
        return this.todayVotedCount;
    }

    /* renamed from: e, reason: from getter */
    public final AtomicLong getTotalVoted() {
        return this.totalVoted;
    }

    /* renamed from: f, reason: from getter */
    public final AtomicLong getVipMaxVoteNum() {
        return this.vipMaxVoteNum;
    }

    public int hashCode() {
        return (((((((((this.vipMaxVoteNum.hashCode() * 31) + this.svipFriendMaxVoteNotice.hashCode()) * 31) + this.friendUin.hashCode()) * 31) + this.todayVotedCount.hashCode()) * 31) + this.todayAvailableVotedCount.hashCode()) * 31) + this.totalVoted.hashCode();
    }

    public String toString() {
        return "LikeData(vipMaxVoteNum=" + this.vipMaxVoteNum + ", svipFriendMaxVoteNotice=" + this.svipFriendMaxVoteNotice + ", friendUin=" + this.friendUin + ", todayVotedCount=" + this.todayVotedCount + ", todayAvailableVotedCount=" + this.todayAvailableVotedCount + ", totalVoted=" + this.totalVoted + ")";
    }

    public LikeData(AtomicLong vipMaxVoteNum, String svipFriendMaxVoteNotice, AtomicLong friendUin, AtomicLong todayVotedCount, AtomicLong todayAvailableVotedCount, AtomicLong totalVoted) {
        Intrinsics.checkNotNullParameter(vipMaxVoteNum, "vipMaxVoteNum");
        Intrinsics.checkNotNullParameter(svipFriendMaxVoteNotice, "svipFriendMaxVoteNotice");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(todayVotedCount, "todayVotedCount");
        Intrinsics.checkNotNullParameter(todayAvailableVotedCount, "todayAvailableVotedCount");
        Intrinsics.checkNotNullParameter(totalVoted, "totalVoted");
        this.vipMaxVoteNum = vipMaxVoteNum;
        this.svipFriendMaxVoteNotice = svipFriendMaxVoteNotice;
        this.friendUin = friendUin;
        this.todayVotedCount = todayVotedCount;
        this.todayAvailableVotedCount = todayAvailableVotedCount;
        this.totalVoted = totalVoted;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeData)) {
            return false;
        }
        LikeData likeData = (LikeData) other;
        return Intrinsics.areEqual(this.vipMaxVoteNum, likeData.vipMaxVoteNum) && Intrinsics.areEqual(this.svipFriendMaxVoteNotice, likeData.svipFriendMaxVoteNotice) && Intrinsics.areEqual(this.friendUin, likeData.friendUin) && Intrinsics.areEqual(this.todayVotedCount, likeData.todayVotedCount) && Intrinsics.areEqual(this.todayAvailableVotedCount, likeData.todayAvailableVotedCount) && Intrinsics.areEqual(this.totalVoted, likeData.totalVoted);
    }

    public /* synthetic */ LikeData(AtomicLong atomicLong, String str, AtomicLong atomicLong2, AtomicLong atomicLong3, AtomicLong atomicLong4, AtomicLong atomicLong5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new AtomicLong(0L) : atomicLong, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? new AtomicLong(0L) : atomicLong2, (i3 & 8) != 0 ? new AtomicLong(0L) : atomicLong3, (i3 & 16) != 0 ? new AtomicLong(0L) : atomicLong4, (i3 & 32) != 0 ? new AtomicLong(0L) : atomicLong5);
    }
}
