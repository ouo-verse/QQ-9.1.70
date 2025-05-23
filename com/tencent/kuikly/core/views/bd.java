package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ/\u0010\n\u001a\u00020\u00072'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bJ/\u0010\u000b\u001a\u00020\u00072'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bJ/\u0010\f\u001a\u00020\u00072'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/views/bd;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "handler", "j", "i", tl.h.F, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bd extends Event {
    public final void h(Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("animationEnd", handler);
    }

    public final void i(Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("animationStart", handler);
    }

    public final void j(Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("loadFailure", handler);
    }
}
