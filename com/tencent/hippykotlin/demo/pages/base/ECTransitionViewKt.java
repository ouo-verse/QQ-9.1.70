package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECTransitionViewKt {
    public static final void TransitionFadeInOutView(ViewContainer<?, ?> viewContainer, final Function1<? super ECTransitionView, Unit> function1) {
        viewContainer.addChild(new ECTransitionView(), new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFadeInOutView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECTransitionView eCTransitionView) {
                ECTransitionView eCTransitionView2 = eCTransitionView;
                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFadeInOutView$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                        eCTransitionAttr.transitionType = 5;
                        return Unit.INSTANCE;
                    }
                });
                function1.invoke(eCTransitionView2);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void TransitionFromBottomView(ViewContainer<?, ?> viewContainer, final Function1<? super ECTransitionView, Unit> function1) {
        viewContainer.addChild(new ECTransitionView(), new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFromBottomView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECTransitionView eCTransitionView) {
                ECTransitionView eCTransitionView2 = eCTransitionView;
                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFromBottomView$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                        eCTransitionAttr.transitionType = 1;
                        return Unit.INSTANCE;
                    }
                });
                function1.invoke(eCTransitionView2);
                return Unit.INSTANCE;
            }
        });
    }
}
