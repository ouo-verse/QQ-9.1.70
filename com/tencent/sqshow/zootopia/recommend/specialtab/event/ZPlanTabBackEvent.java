package com.tencent.sqshow.zootopia.recommend.specialtab.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/specialtab/event/ZPlanTabBackEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "from", "Lcom/tencent/sqshow/zootopia/recommend/specialtab/event/TabBackFrom;", "(Lcom/tencent/sqshow/zootopia/recommend/specialtab/event/TabBackFrom;)V", "getFrom", "()Lcom/tencent/sqshow/zootopia/recommend/specialtab/event/TabBackFrom;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanTabBackEvent extends SimpleBaseEvent {
    private final TabBackFrom from;

    public ZPlanTabBackEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final TabBackFrom getFrom() {
        return this.from;
    }

    public ZPlanTabBackEvent(TabBackFrom from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.from = from;
    }

    public /* synthetic */ ZPlanTabBackEvent(TabBackFrom tabBackFrom, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TabBackFrom.H5 : tabBackFrom);
    }
}
