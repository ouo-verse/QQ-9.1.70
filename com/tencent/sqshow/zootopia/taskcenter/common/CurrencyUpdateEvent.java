package com.tencent.sqshow.zootopia.taskcenter.common;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/common/CurrencyUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "forceUpdate", "", "(Z)V", "getForceUpdate", "()Z", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class CurrencyUpdateEvent extends SimpleBaseEvent {
    private final boolean forceUpdate;

    public CurrencyUpdateEvent() {
        this(false, 1, null);
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public CurrencyUpdateEvent(boolean z16) {
        this.forceUpdate = z16;
    }

    public /* synthetic */ CurrencyUpdateEvent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
