package com.tencent.mobileqq.guild.feed.batchmanage.search.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/event/FeedBatchManageSearchResultFragmentEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "requestToken", "", QzoneIPCModule.RESULT_CODE, "operationType", "(III)V", "getOperationType", "()I", "getRequestToken", "getResultCode", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class FeedBatchManageSearchResultFragmentEvent extends SimpleBaseEvent {
    private final int operationType;
    private final int requestToken;
    private final int resultCode;

    public FeedBatchManageSearchResultFragmentEvent(int i3, int i16, int i17) {
        this.requestToken = i3;
        this.resultCode = i16;
        this.operationType = i17;
    }

    public static /* synthetic */ FeedBatchManageSearchResultFragmentEvent copy$default(FeedBatchManageSearchResultFragmentEvent feedBatchManageSearchResultFragmentEvent, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = feedBatchManageSearchResultFragmentEvent.requestToken;
        }
        if ((i18 & 2) != 0) {
            i16 = feedBatchManageSearchResultFragmentEvent.resultCode;
        }
        if ((i18 & 4) != 0) {
            i17 = feedBatchManageSearchResultFragmentEvent.operationType;
        }
        return feedBatchManageSearchResultFragmentEvent.copy(i3, i16, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRequestToken() {
        return this.requestToken;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getOperationType() {
        return this.operationType;
    }

    @NotNull
    public final FeedBatchManageSearchResultFragmentEvent copy(int requestToken, int resultCode, int operationType) {
        return new FeedBatchManageSearchResultFragmentEvent(requestToken, resultCode, operationType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedBatchManageSearchResultFragmentEvent)) {
            return false;
        }
        FeedBatchManageSearchResultFragmentEvent feedBatchManageSearchResultFragmentEvent = (FeedBatchManageSearchResultFragmentEvent) other;
        if (this.requestToken == feedBatchManageSearchResultFragmentEvent.requestToken && this.resultCode == feedBatchManageSearchResultFragmentEvent.resultCode && this.operationType == feedBatchManageSearchResultFragmentEvent.operationType) {
            return true;
        }
        return false;
    }

    public final int getOperationType() {
        return this.operationType;
    }

    public final int getRequestToken() {
        return this.requestToken;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public int hashCode() {
        return (((this.requestToken * 31) + this.resultCode) * 31) + this.operationType;
    }

    @NotNull
    public String toString() {
        return "FeedBatchManageSearchResultFragmentEvent(requestToken=" + this.requestToken + ", resultCode=" + this.resultCode + ", operationType=" + this.operationType + ")";
    }
}
