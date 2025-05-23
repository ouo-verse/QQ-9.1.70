package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSRefreshEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "", "pageType", "I", "getPageType", "()I", "<init>", "(I)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSRefreshEvent extends WSSimpleBaseEvent {
    public static final int PAGE_TYPE_FOLLOW = 1;
    public static final int PAGE_TYPE_IMMERSE = 3;
    public static final int PAGE_TYPE_WATERFALL = 2;
    private final int pageType;

    public WSRefreshEvent(int i3) {
        this.pageType = i3;
    }

    public final int getPageType() {
        return this.pageType;
    }
}
