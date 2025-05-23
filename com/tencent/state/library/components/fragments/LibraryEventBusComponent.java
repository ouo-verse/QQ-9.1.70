package com.tencent.state.library.components.fragments;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.template.map.component.TemplateEventBusComponent;
import com.tencent.state.utils.IEventHandler;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u000422\u0010\u0005\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t`\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryEventBusComponent;", "Lcom/tencent/state/template/map/component/TemplateEventBusComponent;", "()V", "registerEvent", "", "map", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryEventBusComponent extends TemplateEventBusComponent {
    @Override // com.tencent.state.template.map.component.TemplateEventBusComponent
    public void registerEvent(HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> map) {
        Intrinsics.checkNotNullParameter(map, "map");
    }
}
