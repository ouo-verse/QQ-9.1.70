package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007RE\u0010\u0014\u001a%\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/kuikly/core/views/k;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "", "handler", "i", "Lkotlin/Function0;", tl.h.F, "", "Lkotlin/ParameterName;", "name", "buttonIndex", "Lcom/tencent/kuikly/core/views/AlertButtonClickCallback;", "a", "Lkotlin/jvm/functions/Function1;", "l", "()Lkotlin/jvm/functions/Function1;", "setDidClickActionButtonHandlerFn$core_release", "(Lkotlin/jvm/functions/Function1;)V", "didClickActionButtonHandlerFn", "b", "k", "setClickBackgroundMaskHandlerFn$core_release", "clickBackgroundMaskHandlerFn", "c", "Lkotlin/jvm/functions/Function0;", "j", "()Lkotlin/jvm/functions/Function0;", "setAlertDidExitHandlerFn$core_release", "(Lkotlin/jvm/functions/Function0;)V", "alertDidExitHandlerFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends Event {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> didClickActionButtonHandlerFn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ClickParams, Unit> clickBackgroundMaskHandlerFn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> alertDidExitHandlerFn;

    public final void h(Function0<Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.alertDidExitHandlerFn = handler;
    }

    public final void i(Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.clickBackgroundMaskHandlerFn = handler;
    }

    public final Function0<Unit> j() {
        return this.alertDidExitHandlerFn;
    }

    public final Function1<ClickParams, Unit> k() {
        return this.clickBackgroundMaskHandlerFn;
    }

    public final Function1<Integer, Unit> l() {
        return this.didClickActionButtonHandlerFn;
    }
}
