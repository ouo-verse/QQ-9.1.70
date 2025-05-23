package com.tencent.mobileqq.guild.feed.topic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicFeedsRspEvent;", "Lcom/tencent/mobileqq/guild/feed/topic/TopicSimpleEvent;", "", "component1", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "component2", "topicId", "rsp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTopicId", "()J", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "getRsp", "()Lcom/tencent/mobileqq/guild/feed/topic/g;", "<init>", "(JLcom/tencent/mobileqq/guild/feed/topic/g;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class TopicFeedsRspEvent extends TopicSimpleEvent {

    @NotNull
    private final g rsp;
    private final long topicId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedsRspEvent(long j3, @NotNull g rsp) {
        super(j3);
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.topicId = j3;
        this.rsp = rsp;
    }

    public static /* synthetic */ TopicFeedsRspEvent copy$default(TopicFeedsRspEvent topicFeedsRspEvent, long j3, g gVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = topicFeedsRspEvent.getTopicId();
        }
        if ((i3 & 2) != 0) {
            gVar = topicFeedsRspEvent.rsp;
        }
        return topicFeedsRspEvent.copy(j3, gVar);
    }

    public final long component1() {
        return getTopicId();
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final g getRsp() {
        return this.rsp;
    }

    @NotNull
    public final TopicFeedsRspEvent copy(long topicId, @NotNull g rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        return new TopicFeedsRspEvent(topicId, rsp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopicFeedsRspEvent)) {
            return false;
        }
        TopicFeedsRspEvent topicFeedsRspEvent = (TopicFeedsRspEvent) other;
        if (getTopicId() == topicFeedsRspEvent.getTopicId() && Intrinsics.areEqual(this.rsp, topicFeedsRspEvent.rsp)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final g getRsp() {
        return this.rsp;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.TopicSimpleEvent
    public long getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(getTopicId()) * 31) + this.rsp.hashCode();
    }

    @NotNull
    public String toString() {
        return "TopicFeedsRspEvent(topicId=" + getTopicId() + ", rsp=" + this.rsp + ")";
    }
}
