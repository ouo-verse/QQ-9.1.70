package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/j;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/n;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "firstFeedId", "b", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.j, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class TopicFeedsRefreshIntent extends n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String firstFeedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String source;

    public TopicFeedsRefreshIntent() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFirstFeedId() {
        return this.firstFeedId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopicFeedsRefreshIntent)) {
            return false;
        }
        TopicFeedsRefreshIntent topicFeedsRefreshIntent = (TopicFeedsRefreshIntent) other;
        if (Intrinsics.areEqual(this.firstFeedId, topicFeedsRefreshIntent.firstFeedId) && Intrinsics.areEqual(this.source, topicFeedsRefreshIntent.source)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.firstFeedId.hashCode() * 31) + this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "TopicFeedsRefreshIntent(firstFeedId=" + this.firstFeedId + ", source=" + this.source + ")";
    }

    public /* synthetic */ TopicFeedsRefreshIntent(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedsRefreshIntent(@NotNull String firstFeedId, @NotNull String source) {
        super(null);
        Intrinsics.checkNotNullParameter(firstFeedId, "firstFeedId");
        Intrinsics.checkNotNullParameter(source, "source");
        this.firstFeedId = firstFeedId;
        this.source = source;
    }
}
