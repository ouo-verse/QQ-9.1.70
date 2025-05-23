package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/views/aq;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/PullDownHeaderView;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bj {
    public static final void a(aq<?, ?> aqVar, Function1<? super PullDownHeaderView, Unit> init) {
        Intrinsics.checkNotNullParameter(aqVar, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        aqVar.addChild(new PullDownHeaderView(), init);
    }
}
