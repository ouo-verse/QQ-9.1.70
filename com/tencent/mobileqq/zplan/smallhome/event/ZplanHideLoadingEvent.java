package com.tencent.mobileqq.zplan.smallhome.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/event/ZplanHideLoadingEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mapId", "", "(Ljava/lang/Integer;)V", "getMapId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanHideLoadingEvent extends SimpleBaseEvent {
    private final Integer mapId;

    public ZplanHideLoadingEvent(Integer num) {
        this.mapId = num;
    }

    public final Integer getMapId() {
        return this.mapId;
    }
}
