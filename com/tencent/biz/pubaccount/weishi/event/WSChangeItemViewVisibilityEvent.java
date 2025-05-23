package com.tencent.biz.pubaccount.weishi.event;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSChangeItemViewVisibilityEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "feedId", "", ViewStickEventHelper.IS_SHOW, "", "(Ljava/lang/String;Z)V", "isChangeFirstItem", "(ZZ)V", "<set-?>", "getFeedId", "()Ljava/lang/String;", "()Z", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSChangeItemViewVisibilityEvent extends WSSimpleBaseEvent {
    private String feedId;
    private boolean isChangeFirstItem;
    private boolean isShow;

    public WSChangeItemViewVisibilityEvent(String feedId, boolean z16) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.isShow = z16;
        this.isChangeFirstItem = false;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: isChangeFirstItem, reason: from getter */
    public final boolean getIsChangeFirstItem() {
        return this.isChangeFirstItem;
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public WSChangeItemViewVisibilityEvent(boolean z16, boolean z17) {
        this.feedId = "";
        this.isShow = z17;
        this.isChangeFirstItem = z16;
    }
}
