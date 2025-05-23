package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECTransitionEvent extends l {
    public final void transitionFinish(final Function1<? super Boolean, Unit> function1) {
        registerEvent("transitionFinish", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent$transitionFinish$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Function1<Boolean, Unit> function12 = function1;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr");
                function12.invoke(Boolean.valueOf(((ECTransitionAttr) obj).getTransitionAppear()));
                return Unit.INSTANCE;
            }
        });
    }
}
