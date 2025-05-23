package com.tencent.hippykotlin.demo.pages.vas_base.frequency_control;

import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class DebounceKt$debounce$2 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ int $delay = 300;
    public final /* synthetic */ Function1<Object, Unit> $executor;
    public final /* synthetic */ Ref.ObjectRef<String> $timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebounceKt$debounce$2(Ref.ObjectRef objectRef, Function1 function1) {
        super(1);
        this.$timer = objectRef;
        this.$executor = function1;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.String] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(final Object obj) {
        if (!Intrinsics.areEqual(this.$timer.element, "")) {
            TimerKt.a(this.$timer.element);
        }
        Ref.ObjectRef<String> objectRef = this.$timer;
        int i3 = this.$delay;
        final Function1<Object, Unit> function1 = this.$executor;
        objectRef.element = TimerKt.d(i3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.frequency_control.DebounceKt$debounce$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                function1.invoke(obj);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
