package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerReportFeedSubmitEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "(Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerReportFeedSubmitEvent extends SimpleBaseEvent {
    private final String feedId;

    public QQStrangerReportFeedSubmitEvent(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
    }

    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    public final QQStrangerReportFeedSubmitEvent copy(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return new QQStrangerReportFeedSubmitEvent(feedId);
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public int hashCode() {
        return this.feedId.hashCode();
    }

    public String toString() {
        return "QQStrangerReportFeedSubmitEvent(feedId=" + this.feedId + ")";
    }

    public static /* synthetic */ QQStrangerReportFeedSubmitEvent copy$default(QQStrangerReportFeedSubmitEvent qQStrangerReportFeedSubmitEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qQStrangerReportFeedSubmitEvent.feedId;
        }
        return qQStrangerReportFeedSubmitEvent.copy(str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QQStrangerReportFeedSubmitEvent) && Intrinsics.areEqual(this.feedId, ((QQStrangerReportFeedSubmitEvent) other).feedId);
    }
}
