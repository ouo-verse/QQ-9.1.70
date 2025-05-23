package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\n\u001a\u00020\u00072'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bJ)\u0010\u000e\u001a\u00020\u00072!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\u0002RG\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R?\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/views/bi;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "callback", tl.h.F, "", "percentage01", "handler", "k", "a", "Lkotlin/jvm/functions/Function1;", "i", "()Lkotlin/jvm/functions/Function1;", "setDidPullDownFn$core_release", "(Lkotlin/jvm/functions/Function1;)V", "didPullDownFn", "b", "j", "setPullPercentageFn$core_release", "pullPercentageFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bi extends Event {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> didPullDownFn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Float, Unit> pullPercentageFn;

    public final void h(Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.didPullDownFn = callback;
    }

    public final Function1<Object, Unit> i() {
        return this.didPullDownFn;
    }

    public final Function1<Float, Unit> j() {
        return this.pullPercentageFn;
    }

    public final void k(Function1<? super Float, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.pullPercentageFn = handler;
    }
}
