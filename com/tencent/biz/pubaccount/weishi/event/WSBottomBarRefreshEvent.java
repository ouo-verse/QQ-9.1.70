package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSBottomBarRefreshEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "", "pagerIndex", "I", "getPagerIndex", "()I", "setPagerIndex", "(I)V", "Lvy/a;", "barInfo", "Lvy/a;", "getBarInfo", "()Lvy/a;", "setBarInfo", "(Lvy/a;)V", "", "<set-?>", "barId", "Ljava/lang/String;", "getBarId", "()Ljava/lang/String;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSBottomBarRefreshEvent extends WSSimpleBaseEvent {
    private WSNavigationBarInfo barInfo;
    private int pagerIndex = -1;
    private String barId = "";

    public final String getBarId() {
        String barId;
        WSNavigationBarInfo wSNavigationBarInfo = this.barInfo;
        return (wSNavigationBarInfo == null || (barId = wSNavigationBarInfo.getBarId()) == null) ? "" : barId;
    }

    public final WSNavigationBarInfo getBarInfo() {
        return this.barInfo;
    }

    public final int getPagerIndex() {
        return this.pagerIndex;
    }

    public final void setBarInfo(WSNavigationBarInfo wSNavigationBarInfo) {
        this.barInfo = wSNavigationBarInfo;
    }

    public final void setPagerIndex(int i3) {
        this.pagerIndex = i3;
    }
}
