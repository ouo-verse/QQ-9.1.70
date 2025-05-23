package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "c", "(Z)V", "isLike", "", "J", "()J", "d", "(J)V", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "<init>", "(ZJ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.j, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class LikeData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLike;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long likeCount;

    public LikeData() {
        this(false, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getLikeCount() {
        return this.likeCount;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    public final void c(boolean z16) {
        this.isLike = z16;
    }

    public final void d(long j3) {
        this.likeCount = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isLike;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + com.tencent.mobileqq.vas.banner.c.a(this.likeCount);
    }

    public String toString() {
        return "LikeData(isLike=" + this.isLike + ", likeCount=" + this.likeCount + ")";
    }

    public LikeData(boolean z16, long j3) {
        this.isLike = z16;
        this.likeCount = j3;
    }

    public /* synthetic */ LikeData(boolean z16, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? 0L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeData)) {
            return false;
        }
        LikeData likeData = (LikeData) other;
        return this.isLike == likeData.isLike && this.likeCount == likeData.likeCount;
    }
}
