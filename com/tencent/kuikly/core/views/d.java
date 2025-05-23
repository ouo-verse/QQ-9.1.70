package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J-\u0010\n\u001a\u00020\u00072%\u0010\t\u001a!\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bJ\u001a\u0010\f\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u0002J\u0014\u0010\u000e\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\rRE\u0010\u0015\u001a%\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/kuikly/core/views/d;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "buttonIndex", "", "Lcom/tencent/kuikly/core/views/AlertButtonClickCallback;", "handler", "i", "Lcom/tencent/kuikly/core/base/event/c;", "j", "Lkotlin/Function0;", tl.h.F, "a", "Lkotlin/jvm/functions/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lkotlin/jvm/functions/Function1;", "setDidClickActionButtonHandlerFn$core_release", "(Lkotlin/jvm/functions/Function1;)V", "didClickActionButtonHandlerFn", "b", "l", "setClickBackgroundMaskHandlerFn$core_release", "clickBackgroundMaskHandlerFn", "c", "Lkotlin/jvm/functions/Function0;", "k", "()Lkotlin/jvm/functions/Function0;", "setActionSheetDidExitHandlerFn$core_release", "(Lkotlin/jvm/functions/Function0;)V", "actionSheetDidExitHandlerFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends Event {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> didClickActionButtonHandlerFn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ClickParams, Unit> clickBackgroundMaskHandlerFn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> actionSheetDidExitHandlerFn;

    public final void h(Function0<Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.actionSheetDidExitHandlerFn = handler;
    }

    public final void i(Function1<? super Integer, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.didClickActionButtonHandlerFn = handler;
    }

    public final void j(Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.clickBackgroundMaskHandlerFn = handler;
    }

    public final Function0<Unit> k() {
        return this.actionSheetDidExitHandlerFn;
    }

    public final Function1<ClickParams, Unit> l() {
        return this.clickBackgroundMaskHandlerFn;
    }

    public final Function1<Integer, Unit> m() {
        return this.didClickActionButtonHandlerFn;
    }
}
