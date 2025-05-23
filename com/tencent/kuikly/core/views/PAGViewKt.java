package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u001a\u001e\u0010\u000b\u001a\u00020\u0003*\u00020\u00072\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00030\bj\u0002`\tH\u0002\u001a\f\u0010\f\u001a\u00020\u0003*\u00020\u0007H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/bc;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "Lcom/tencent/kuikly/core/views/PAGViewAttr;", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/manager/Task;", "task", "e", "d", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PAGViewKt {
    public static final void a(ViewContainer<?, ?> viewContainer, Function1<? super bc, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        viewContainer.addChild(new bc(), init);
    }

    public static final /* synthetic */ void c(PAGViewAttr pAGViewAttr, Function0 function0) {
        e(pAGViewAttr, function0);
    }

    public static final void e(PAGViewAttr pAGViewAttr, final Function0<Unit> function0) {
        if (pAGViewAttr.getDidInit()) {
            function0.invoke();
        } else {
            pAGViewAttr.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.PAGViewKt$performTaskWhenAttrDidInit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                }
            });
        }
    }

    public static final void d(PAGViewAttr pAGViewAttr) {
        pAGViewAttr.k(true);
        Function0<Unit> h16 = pAGViewAttr.h();
        if (h16 != null) {
            h16.invoke();
        }
        pAGViewAttr.j(null);
    }
}
