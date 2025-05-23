package com.tencent.kuikly.core.base.event;

import com.tencent.kuikly.core.base.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u001a-\u0010\t\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u001a-\u0010\f\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\u0001\u001a3\u0010\u0010\u001a\u00020\u0006*\u00020\u00002'\u0010\u0007\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u000f\u001a3\u0010\u0011\u001a\u00020\u0006*\u00020\u00002'\u0010\u0007\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u000f\u001a-\u0010\u0012\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u001a\f\u0010\u0014\u001a\u00020\u0013*\u00020\u0000H\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/layout/d;", "Lkotlin/ParameterName;", "name", "layoutFrame", "", "handlerFn", "d", "c", "Lcom/tencent/kuikly/core/base/w;", "size", "e", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "f", "g", "a", "Lcom/tencent/kuikly/core/base/event/FrameEvent;", "b", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class FrameEventKt {
    public static final void a(Event event, final Function1<? super com.tencent.kuikly.core.layout.d, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        final Function1<com.tencent.kuikly.core.layout.d, Unit> i3 = b(event).i();
        if (i3 == null) {
            b(event).l(handlerFn);
        } else {
            b(event).l(new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.base.event.FrameEventKt$addLayoutFrameDidChange$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                    invoke2(dVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.kuikly.core.layout.d frame) {
                    Intrinsics.checkNotNullParameter(frame, "frame");
                    handlerFn.invoke(frame);
                    i3.invoke(frame);
                }
            });
        }
    }

    private static final FrameEvent b(Event event) {
        d pluginEvent = event.getPluginEvent("FrameEvent");
        d dVar = pluginEvent;
        if (pluginEvent == null) {
            FrameEvent frameEvent = new FrameEvent();
            frameEvent.init(event.getPagerId(), event.getViewId());
            event.putPluginEvent("FrameEvent", frameEvent);
            dVar = frameEvent;
        }
        return (FrameEvent) dVar;
    }

    public static final void c(Event event, Function1<? super com.tencent.kuikly.core.layout.d, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        b(event).k(handlerFn);
    }

    public static final void d(Event event, Function1<? super com.tencent.kuikly.core.layout.d, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        b(event).l(handlerFn);
    }

    public static final void e(Event event, Function1<? super w, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        b(event).o(handlerFn);
    }

    public static final void f(Event event, Function1<Object, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        b(event).m(handlerFn);
    }

    public static final void g(Event event, Function1<Object, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        b(event).n(handlerFn);
    }
}
