package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSHomeBackBtnClickEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "isSingleClick", "", "(Z)V", "()Z", "setSingleClick", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSHomeBackBtnClickEvent extends WSSimpleBaseEvent {
    private boolean isSingleClick;

    public WSHomeBackBtnClickEvent() {
        this(false, 1, null);
    }

    /* renamed from: isSingleClick, reason: from getter */
    public final boolean getIsSingleClick() {
        return this.isSingleClick;
    }

    public final void setSingleClick(boolean z16) {
        this.isSingleClick = z16;
    }

    public /* synthetic */ WSHomeBackBtnClickEvent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public WSHomeBackBtnClickEvent(boolean z16) {
        this.isSingleClick = z16;
    }
}
