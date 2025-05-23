package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSGridAdCardExposeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "isRefresh", "", "(Z)V", "()Z", "setRefresh", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSGridAdCardExposeEvent extends WSSimpleBaseEvent {
    private boolean isRefresh;

    public WSGridAdCardExposeEvent(boolean z16) {
        this.isRefresh = z16;
    }

    /* renamed from: isRefresh, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void setRefresh(boolean z16) {
        this.isRefresh = z16;
    }
}
