package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.bz;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u001a@\u0010\r\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002,\u0010\u0005\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/TabsView;", "", "Lkotlin/ExtensionFunctionType;", "init", "b", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/bz;", "Lcom/tencent/kuikly/core/views/bz$a;", "Lkotlin/ParameterName;", "name", "newState", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TabsViewKt {
    public static final void a(ViewContainer<?, ?> viewContainer, final Function2<? super bz, ? super bz.a, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        viewContainer.addChild(new bz(), new Function1<bz, Unit>() { // from class: com.tencent.kuikly.core.views.TabsViewKt$TabItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bz bzVar) {
                invoke2(bzVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bz addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                init.invoke(addChild, addChild.getState());
            }
        });
    }

    public static final void b(ViewContainer<?, ?> viewContainer, Function1<? super TabsView, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        viewContainer.addChild(new TabsView(), init);
    }
}
