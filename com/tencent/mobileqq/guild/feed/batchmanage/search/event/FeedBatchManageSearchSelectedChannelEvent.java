package com.tencent.mobileqq.guild.feed.batchmanage.search.event;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/event/FeedBatchManageSearchSelectedChannelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "selectedChannelId", "", "selectedChannelName", "", "(JLjava/lang/String;)V", "getSelectedChannelId", "()J", "getSelectedChannelName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class FeedBatchManageSearchSelectedChannelEvent extends SimpleBaseEvent {
    private final long selectedChannelId;

    @NotNull
    private final String selectedChannelName;

    public FeedBatchManageSearchSelectedChannelEvent(long j3, @NotNull String selectedChannelName) {
        Intrinsics.checkNotNullParameter(selectedChannelName, "selectedChannelName");
        this.selectedChannelId = j3;
        this.selectedChannelName = selectedChannelName;
    }

    public static /* synthetic */ FeedBatchManageSearchSelectedChannelEvent copy$default(FeedBatchManageSearchSelectedChannelEvent feedBatchManageSearchSelectedChannelEvent, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = feedBatchManageSearchSelectedChannelEvent.selectedChannelId;
        }
        if ((i3 & 2) != 0) {
            str = feedBatchManageSearchSelectedChannelEvent.selectedChannelName;
        }
        return feedBatchManageSearchSelectedChannelEvent.copy(j3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getSelectedChannelId() {
        return this.selectedChannelId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSelectedChannelName() {
        return this.selectedChannelName;
    }

    @NotNull
    public final FeedBatchManageSearchSelectedChannelEvent copy(long selectedChannelId, @NotNull String selectedChannelName) {
        Intrinsics.checkNotNullParameter(selectedChannelName, "selectedChannelName");
        return new FeedBatchManageSearchSelectedChannelEvent(selectedChannelId, selectedChannelName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedBatchManageSearchSelectedChannelEvent)) {
            return false;
        }
        FeedBatchManageSearchSelectedChannelEvent feedBatchManageSearchSelectedChannelEvent = (FeedBatchManageSearchSelectedChannelEvent) other;
        if (this.selectedChannelId == feedBatchManageSearchSelectedChannelEvent.selectedChannelId && Intrinsics.areEqual(this.selectedChannelName, feedBatchManageSearchSelectedChannelEvent.selectedChannelName)) {
            return true;
        }
        return false;
    }

    public final long getSelectedChannelId() {
        return this.selectedChannelId;
    }

    @NotNull
    public final String getSelectedChannelName() {
        return this.selectedChannelName;
    }

    public int hashCode() {
        return (a.a(this.selectedChannelId) * 31) + this.selectedChannelName.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedBatchManageSearchSelectedChannelEvent(selectedChannelId=" + this.selectedChannelId + ", selectedChannelName=" + this.selectedChannelName + ")";
    }
}
