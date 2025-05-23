package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedActionSheetViewEvent extends l {
    public final void closedActionSheet(final Function0<Unit> function0) {
        register("closedActionSheet", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewEvent$closedActionSheet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj).booleanValue()) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        });
    }
}
