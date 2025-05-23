package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository;

import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isSuccess", "b", "c", "isCacheData", "", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "Ljava/util/List;", "()Ljava/util/List;", "feedList", "d", "noMore", "f", "(Z)V", "isRefresh", "<init>", "(ZZLjava/util/List;Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerFeedResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCacheData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<FeedPB$Feed> feedList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean noMore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRefresh;

    public QQStrangerFeedResult() {
        this(false, false, null, false, 15, null);
    }

    public final List<FeedPB$Feed> a() {
        return this.feedList;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNoMore() {
        return this.noMore;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsCacheData() {
        return this.isCacheData;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final void f(boolean z16) {
        this.isRefresh = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ?? r26 = this.isCacheData;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int hashCode = (((i3 + i16) * 31) + this.feedList.hashCode()) * 31;
        boolean z17 = this.noMore;
        return hashCode + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "QQStrangerFeedResult(isSuccess=" + this.isSuccess + ", isCacheData=" + this.isCacheData + ", feedList=" + this.feedList + ", noMore=" + this.noMore + ")";
    }

    public QQStrangerFeedResult(boolean z16, boolean z17, List<FeedPB$Feed> feedList, boolean z18) {
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        this.isSuccess = z16;
        this.isCacheData = z17;
        this.feedList = feedList;
        this.noMore = z18;
        this.isRefresh = true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerFeedResult)) {
            return false;
        }
        QQStrangerFeedResult qQStrangerFeedResult = (QQStrangerFeedResult) other;
        return this.isSuccess == qQStrangerFeedResult.isSuccess && this.isCacheData == qQStrangerFeedResult.isCacheData && Intrinsics.areEqual(this.feedList, qQStrangerFeedResult.feedList) && this.noMore == qQStrangerFeedResult.noMore;
    }

    public /* synthetic */ QQStrangerFeedResult(boolean z16, boolean z17, List list, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? false : z18);
    }
}
