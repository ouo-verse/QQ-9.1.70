package com.tencent.state.library.focus.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes34.dex */
final /* synthetic */ class FocusCalendarComponent$onFragmentResumed$1 extends FunctionReferenceImpl implements Function0<Unit> {
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusCalendarComponent$onFragmentResumed$1(FocusCalendarComponent focusCalendarComponent) {
        super(0, focusCalendarComponent, FocusCalendarComponent.class, "onCalendarEntryClick", "onCalendarEntryClick()V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((FocusCalendarComponent) this.receiver).onCalendarEntryClick();
    }
}
