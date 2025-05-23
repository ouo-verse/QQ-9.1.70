package com.tencent.kuikly.core.views.layout;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexAlign;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\b\u001a\u00020\u0005*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u001a+\u0010\t\u001a\u00020\u0005*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/layout/FlexAlign;", "align", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/layout/ColumnView;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "b", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    public static final void a(ViewContainer<?, ?> viewContainer, FlexAlign align, Function1<? super ColumnView, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(init, "init");
        ColumnView columnView = new ColumnView();
        columnView.j(align);
        viewContainer.addChild(columnView, init);
    }

    public static final void b(ViewContainer<?, ?> viewContainer, Function1<? super ColumnView, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        a(viewContainer, FlexAlign.STRETCH, init);
    }
}
