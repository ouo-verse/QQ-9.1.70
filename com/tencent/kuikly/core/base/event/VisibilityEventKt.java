package com.tencent.kuikly.core.base.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\t\u001a\u00020\u0006*\u00020\u00002'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007\u001a3\u0010\n\u001a\u00020\u0006*\u00020\u00002'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007\u001a3\u0010\u000b\u001a\u00020\u0006*\u00020\u00002'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007\u001a3\u0010\f\u001a\u00020\u0006*\u00020\u00002'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007\u001a-\u0010\u000f\u001a\u00020\u0006*\u00020\u00002!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\u0001\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "handler", "e", "b", "f", "c", "", "percentage01", "a", "Lcom/tencent/kuikly/core/base/event/d;", "d", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VisibilityEventKt {
    public static final void a(Event event, final Function1<? super Float, Unit> handler) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        d(event).register("appearPercentage", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.VisibilityEventKt$appearPercentage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Function1<Float, Unit> function1 = handler;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                function1.invoke((Float) obj);
            }
        });
    }

    public static final void b(Event event, Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        d(event).register(VisibilityState.DID_APPEAR.getValue(), handler);
    }

    public static final void c(Event event, Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        d(event).register(VisibilityState.DID_DISAPPEAR.getValue(), handler);
    }

    private static final d d(Event event) {
        d pluginEvent = event.getPluginEvent("VisibilityEvent");
        if (pluginEvent != null) {
            return pluginEvent;
        }
        VisibilityEvent visibilityEvent = new VisibilityEvent();
        visibilityEvent.init(event.getPagerId(), event.getViewId());
        event.putPluginEvent("VisibilityEvent", visibilityEvent);
        return visibilityEvent;
    }

    public static final void e(Event event, Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        d(event).register(VisibilityState.WILL_APPEAR.getValue(), handler);
    }

    public static final void f(Event event, Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        d(event).register(VisibilityState.WILL_DISAPPEAR.getValue(), handler);
    }
}
