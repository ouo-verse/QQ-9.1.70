package com.tencent.state.square.like;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/like/LikeListInfo;", "", "list", "", "Lcom/tencent/state/square/like/LikeData;", "unReadCount", "", "(Ljava/util/List;I)V", "hasReaded", "", "getHasReaded", "()Z", "setHasReaded", "(Z)V", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "getUnReadCount", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LikeListInfo {
    private boolean hasReaded;
    private final List<LikeData> list;
    private final int unReadCount;

    public LikeListInfo(List<LikeData> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.unReadCount = i3;
    }

    public final List<LikeData> component1() {
        return this.list;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUnReadCount() {
        return this.unReadCount;
    }

    public final LikeListInfo copy(List<LikeData> list, int unReadCount) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new LikeListInfo(list, unReadCount);
    }

    public final boolean getHasReaded() {
        return this.hasReaded;
    }

    public final List<LikeData> getList() {
        return this.list;
    }

    public final int getUnReadCount() {
        return this.unReadCount;
    }

    public int hashCode() {
        List<LikeData> list = this.list;
        return ((list != null ? list.hashCode() : 0) * 31) + this.unReadCount;
    }

    public final void setHasReaded(boolean z16) {
        this.hasReaded = z16;
    }

    public String toString() {
        return "LikeListInfo(list=" + this.list + ", unReadCount=" + this.unReadCount + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeListInfo)) {
            return false;
        }
        LikeListInfo likeListInfo = (LikeListInfo) other;
        return Intrinsics.areEqual(this.list, likeListInfo.list) && this.unReadCount == likeListInfo.unReadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LikeListInfo copy$default(LikeListInfo likeListInfo, List list, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            list = likeListInfo.list;
        }
        if ((i16 & 2) != 0) {
            i3 = likeListInfo.unReadCount;
        }
        return likeListInfo.copy(list, i3);
    }
}
