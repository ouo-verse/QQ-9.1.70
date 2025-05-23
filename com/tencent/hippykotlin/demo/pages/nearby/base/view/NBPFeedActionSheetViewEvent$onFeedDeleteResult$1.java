package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPFeedActionSheetViewEvent$onFeedDeleteResult$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ Function1<String, Unit> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPFeedActionSheetViewEvent$onFeedDeleteResult$1(Function1<? super String, Unit> function1) {
        super(1);
        this.$result = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        Function1<String, Unit> function1 = this.$result;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        function1.invoke((String) obj);
        return Unit.INSTANCE;
    }
}
