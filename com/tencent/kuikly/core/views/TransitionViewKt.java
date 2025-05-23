package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\b\u001a\u00020\u0005*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/TransitionType;", "type", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/TransitionView;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TransitionViewKt {
    public static final void a(ViewContainer<?, ?> viewContainer, final TransitionType type, final Function1<? super TransitionView, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(init, "init");
        viewContainer.addChild(new TransitionView(), new Function1<TransitionView, Unit>() { // from class: com.tencent.kuikly.core.views.TransitionViewKt$TransitionView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransitionView transitionView) {
                invoke2(transitionView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransitionView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                final TransitionType transitionType = type;
                addChild.attr(new Function1<ci, Unit>() { // from class: com.tencent.kuikly.core.views.TransitionViewKt$TransitionView$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ci ciVar) {
                        invoke2(ciVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ci attr) {
                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                        attr.q(TransitionType.this);
                    }
                });
                init.invoke(addChild);
            }
        });
    }
}
