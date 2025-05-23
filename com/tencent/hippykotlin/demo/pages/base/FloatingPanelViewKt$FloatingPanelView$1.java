package com.tencent.hippykotlin.demo.pages.base;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class FloatingPanelViewKt$FloatingPanelView$1 extends Lambda implements Function1<FloatingPanelView, Unit> {
    public final /* synthetic */ Function1<FloatingPanelAttr, Unit> $attr;
    public final /* synthetic */ Function1<FloatingPanelEvent, Unit> $event;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FloatingPanelViewKt$FloatingPanelView$1(Function1<? super FloatingPanelAttr, Unit> function1, Function1<? super FloatingPanelEvent, Unit> function12) {
        super(1);
        this.$attr = function1;
        this.$event = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(FloatingPanelView floatingPanelView) {
        FloatingPanelView floatingPanelView2 = floatingPanelView;
        floatingPanelView2.attr(this.$attr);
        floatingPanelView2.event(this.$event);
        return Unit.INSTANCE;
    }
}
