package com.tencent.mobileqq.zootopia.ue;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZPlanExitMapEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mapId", "", "mapName", "", "(ILjava/lang/String;)V", "getMapId", "()I", "getMapName", "()Ljava/lang/String;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanExitMapEvent extends SimpleBaseEvent {
    private final int mapId;
    private final String mapName;

    public ZPlanExitMapEvent(int i3, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        this.mapId = i3;
        this.mapName = mapName;
    }

    public final int getMapId() {
        return this.mapId;
    }

    public final String getMapName() {
        return this.mapName;
    }
}
