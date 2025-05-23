package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u001a+\u0010\b\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/views/ScrollerView;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/ab;", "", "Lkotlin/ExtensionFunctionType;", "init", "b", "Lcom/tencent/kuikly/core/base/ab;", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ac {
    public static final void a(com.tencent.kuikly.core.base.ab<?, ?> abVar, Function1<? super ab, Unit> init) {
        Intrinsics.checkNotNullParameter(abVar, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        abVar.addChild(new ab(), init);
    }

    public static final void b(ScrollerView<?, ?> scrollerView, Function1<? super ab, Unit> init) {
        Intrinsics.checkNotNullParameter(scrollerView, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        scrollerView.addChild(new ab(), init);
    }
}
