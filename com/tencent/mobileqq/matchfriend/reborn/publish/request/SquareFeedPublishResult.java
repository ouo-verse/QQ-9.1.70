package com.tencent.mobileqq.matchfriend.reborn.publish.request;

import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\t\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/request/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "I", "getResultCode", "()I", QzoneIPCModule.RESULT_CODE, "c", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "d", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "()Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "<init>", "(ZILjava/lang/String;Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.request.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class SquareFeedPublishResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resultCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final FeedPB$Feed feed;

    public SquareFeedPublishResult(boolean z16, int i3, String errMsg, FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.isSuccess = z16;
        this.resultCode = i3;
        this.errMsg = errMsg;
        this.feed = feedPB$Feed;
    }

    /* renamed from: a, reason: from getter */
    public final FeedPB$Feed getFeed() {
        return this.feed;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((r06 * 31) + this.resultCode) * 31) + this.errMsg.hashCode()) * 31;
        FeedPB$Feed feedPB$Feed = this.feed;
        return hashCode + (feedPB$Feed == null ? 0 : feedPB$Feed.hashCode());
    }

    public String toString() {
        return "SquareFeedPublishResult(isSuccess=" + this.isSuccess + ", resultCode=" + this.resultCode + ", errMsg=" + this.errMsg + ", feed=" + this.feed + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareFeedPublishResult)) {
            return false;
        }
        SquareFeedPublishResult squareFeedPublishResult = (SquareFeedPublishResult) other;
        return this.isSuccess == squareFeedPublishResult.isSuccess && this.resultCode == squareFeedPublishResult.resultCode && Intrinsics.areEqual(this.errMsg, squareFeedPublishResult.errMsg) && Intrinsics.areEqual(this.feed, squareFeedPublishResult.feed);
    }

    public /* synthetic */ SquareFeedPublishResult(boolean z16, int i3, String str, FeedPB$Feed feedPB$Feed, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, i3, str, (i16 & 8) != 0 ? null : feedPB$Feed);
    }
}
