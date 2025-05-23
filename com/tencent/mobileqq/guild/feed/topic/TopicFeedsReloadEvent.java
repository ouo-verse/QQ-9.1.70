package com.tencent.mobileqq.guild.feed.topic;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicFeedsReloadEvent;", "Lcom/tencent/mobileqq/guild/feed/topic/TopicSimpleEvent;", "topicId", "", "(J)V", "getTopicId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class TopicFeedsReloadEvent extends TopicSimpleEvent {
    private final long topicId;

    public TopicFeedsReloadEvent(long j3) {
        super(j3);
        this.topicId = j3;
    }

    public static /* synthetic */ TopicFeedsReloadEvent copy$default(TopicFeedsReloadEvent topicFeedsReloadEvent, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = topicFeedsReloadEvent.getTopicId();
        }
        return topicFeedsReloadEvent.copy(j3);
    }

    public final long component1() {
        return getTopicId();
    }

    @NotNull
    public final TopicFeedsReloadEvent copy(long topicId) {
        return new TopicFeedsReloadEvent(topicId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TopicFeedsReloadEvent) && getTopicId() == ((TopicFeedsReloadEvent) other).getTopicId()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.TopicSimpleEvent
    public long getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        return androidx.fragment.app.a.a(getTopicId());
    }

    @NotNull
    public String toString() {
        return "TopicFeedsReloadEvent(topicId=" + getTopicId() + ")";
    }
}
