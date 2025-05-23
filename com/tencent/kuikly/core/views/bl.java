package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002R?\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/views/bl;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/RefreshViewState;", "Lkotlin/ParameterName;", "name", "state", "", "handler", "j", "a", "Lkotlin/jvm/functions/Function1;", "i", "()Lkotlin/jvm/functions/Function1;", "setRefreshStateDidChangeHandlerFn$core_release", "(Lkotlin/jvm/functions/Function1;)V", "refreshStateDidChangeHandlerFn", "", "b", tl.h.F, "setPullingPercentageChangedEventHandlerFn$core_release", "pullingPercentageChangedEventHandlerFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bl extends Event {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super RefreshViewState, Unit> refreshStateDidChangeHandlerFn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Float, Unit> pullingPercentageChangedEventHandlerFn;

    public final Function1<Float, Unit> h() {
        return this.pullingPercentageChangedEventHandlerFn;
    }

    public final Function1<RefreshViewState, Unit> i() {
        return this.refreshStateDidChangeHandlerFn;
    }

    public final void j(Function1<? super RefreshViewState, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.refreshStateDidChangeHandlerFn = handler;
    }
}
