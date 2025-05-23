package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSRequestRefreshEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "", "pageId", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "", "refreshState", "I", "getRefreshState", "()I", "setRefreshState", "(I)V", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSRequestRefreshEvent extends WSSimpleBaseEvent {
    public static final String PAGE_DISCOVER_FOLLOW = "page_discover_follow";
    public static final String PAGE_DISCOVER_HOT_GRID = "page_discover_hot_grid";
    public static final String PAGE_WONDER_FOLLOW = "page_wonder_follow";
    public static final String PAGE_WONDER_IMMERSION = "page_wonder_immersion";
    public static final int REFRESH_ERROR = -2;
    public static final int REFRESH_IDLE = 0;
    public static final int REFRESH_START = 1;
    public static final int REFRESH_SUCCESS = 2;
    private final String pageId;
    private int refreshState;

    public WSRequestRefreshEvent(String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.pageId = pageId;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final int getRefreshState() {
        return this.refreshState;
    }

    public final void setRefreshState(int i3) {
        this.refreshState = i3;
    }
}
