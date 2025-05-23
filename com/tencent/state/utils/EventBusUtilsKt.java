package com.tencent.state.utils;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001ab\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n\u00a8\u0006\u000b"}, d2 = {"register", "", "T", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "eventClass", "handler", "Lkotlin/Function1;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EventBusUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends SimpleBaseEvent> void register(HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> register, Class<T> eventClass, final Function1<? super T, Unit> handler) {
        Intrinsics.checkNotNullParameter(register, "$this$register");
        Intrinsics.checkNotNullParameter(eventClass, "eventClass");
        Intrinsics.checkNotNullParameter(handler, "handler");
        register.put(eventClass, new IEventHandler() { // from class: com.tencent.state.utils.EventBusUtilsKt$register$1
            @Override // com.tencent.state.utils.IEventHandler
            public void handleEvent(Object event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!(event instanceof SimpleBaseEvent)) {
                    event = null;
                }
                SimpleBaseEvent simpleBaseEvent = (SimpleBaseEvent) event;
                if (simpleBaseEvent != null) {
                    Function1.this.invoke(simpleBaseEvent);
                }
            }
        });
    }
}
