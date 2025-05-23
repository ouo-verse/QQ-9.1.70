package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerBigPicUpdateLikeFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "isLiked", "", "(Ljava/lang/String;IZ)V", "getFeedId", "()Ljava/lang/String;", "()Z", "getLikeCount", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerBigPicUpdateLikeFeedEvent extends SimpleBaseEvent {
    private final String feedId;
    private final boolean isLiked;
    private final int likeCount;

    public QQStrangerBigPicUpdateLikeFeedEvent(String feedId, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.likeCount = i3;
        this.isLiked = z16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsLiked() {
        return this.isLiked;
    }

    public final QQStrangerBigPicUpdateLikeFeedEvent copy(String feedId, int likeCount, boolean isLiked) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return new QQStrangerBigPicUpdateLikeFeedEvent(feedId, likeCount, isLiked);
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.feedId.hashCode() * 31) + this.likeCount) * 31;
        boolean z16 = this.isLiked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    public String toString() {
        return "QQStrangerBigPicUpdateLikeFeedEvent(feedId=" + this.feedId + ", likeCount=" + this.likeCount + ", isLiked=" + this.isLiked + ")";
    }

    public static /* synthetic */ QQStrangerBigPicUpdateLikeFeedEvent copy$default(QQStrangerBigPicUpdateLikeFeedEvent qQStrangerBigPicUpdateLikeFeedEvent, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = qQStrangerBigPicUpdateLikeFeedEvent.feedId;
        }
        if ((i16 & 2) != 0) {
            i3 = qQStrangerBigPicUpdateLikeFeedEvent.likeCount;
        }
        if ((i16 & 4) != 0) {
            z16 = qQStrangerBigPicUpdateLikeFeedEvent.isLiked;
        }
        return qQStrangerBigPicUpdateLikeFeedEvent.copy(str, i3, z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerBigPicUpdateLikeFeedEvent)) {
            return false;
        }
        QQStrangerBigPicUpdateLikeFeedEvent qQStrangerBigPicUpdateLikeFeedEvent = (QQStrangerBigPicUpdateLikeFeedEvent) other;
        return Intrinsics.areEqual(this.feedId, qQStrangerBigPicUpdateLikeFeedEvent.feedId) && this.likeCount == qQStrangerBigPicUpdateLikeFeedEvent.likeCount && this.isLiked == qQStrangerBigPicUpdateLikeFeedEvent.isLiked;
    }
}
