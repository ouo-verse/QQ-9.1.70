package com.tencent.state.square.chatland.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.state.map.MapItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/chatland/event/AppendOrUpdateChatLandUserItemEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "list", "", "Lcom/tencent/state/map/MapItem;", "(Ljava/util/List;)V", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AppendOrUpdateChatLandUserItemEvent extends SimpleBaseEvent {
    private final List<MapItem> list;

    /* JADX WARN: Multi-variable type inference failed */
    public AppendOrUpdateChatLandUserItemEvent(List<? extends MapItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public final List<MapItem> getList() {
        return this.list;
    }
}
