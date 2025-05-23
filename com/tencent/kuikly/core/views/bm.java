package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\b\u001a\u00020\u0005*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/views/aq;", "", "inFooter", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/RefreshView;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bm {
    public static final void a(aq<?, ?> aqVar, boolean z16, Function1<? super RefreshView, Unit> init) {
        Intrinsics.checkNotNullParameter(aqVar, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        aqVar.addChild(new RefreshView(z16), init);
    }

    public static /* synthetic */ void b(aq aqVar, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        a(aqVar, z16, function1);
    }
}
