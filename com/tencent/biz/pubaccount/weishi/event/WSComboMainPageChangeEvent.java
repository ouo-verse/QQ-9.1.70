package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vy.WSNavigationBarInfo;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSComboMainPageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "Lvy/a;", "barInfo", "Lvy/a;", "", "<set-?>", "barId", "Ljava/lang/String;", "getBarId", "()Ljava/lang/String;", "<init>", "(Lvy/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSComboMainPageChangeEvent extends WSSimpleBaseEvent {
    private String barId;
    private final WSNavigationBarInfo barInfo;

    public WSComboMainPageChangeEvent(WSNavigationBarInfo barInfo) {
        Intrinsics.checkNotNullParameter(barInfo, "barInfo");
        this.barInfo = barInfo;
        this.barId = "";
    }

    public final String getBarId() {
        return this.barInfo.getBarId();
    }
}
