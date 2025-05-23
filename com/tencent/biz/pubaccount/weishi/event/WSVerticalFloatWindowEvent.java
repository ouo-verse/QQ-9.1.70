package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSVerticalFloatWindowEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "", "type", "I", "getType", "()I", "", "isNotNeedSeamLess", "Z", "()Z", "setNotNeedSeamLess", "(Z)V", "<init>", "(I)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVerticalFloatWindowEvent extends WSSimpleBaseEvent {
    public static final int EVENT_TYPE_CLICK = 1;
    public static final int EVENT_TYPE_GUIDE_EXPOSURE = 2;
    private boolean isNotNeedSeamLess;
    private final int type;

    public WSVerticalFloatWindowEvent(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: isNotNeedSeamLess, reason: from getter */
    public final boolean getIsNotNeedSeamLess() {
        return this.isNotNeedSeamLess;
    }

    public final void setNotNeedSeamLess(boolean z16) {
        this.isNotNeedSeamLess = z16;
    }
}
