package com.tencent.mobileqq.zplan.smallhome.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/event/ZPlanShowClearResourceBtnEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mapId", "", "(I)V", "getMapId", "()I", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanShowClearResourceBtnEvent extends SimpleBaseEvent {
    private final int mapId;

    public ZPlanShowClearResourceBtnEvent(int i3) {
        this.mapId = i3;
    }

    public final int getMapId() {
        return this.mapId;
    }
}
