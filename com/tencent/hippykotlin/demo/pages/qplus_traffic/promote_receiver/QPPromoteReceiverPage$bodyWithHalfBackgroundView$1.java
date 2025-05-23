package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver;

import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPage$bodyWithHalfBackgroundView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPPromoteReceiverPage$bodyWithHalfBackgroundView$1 INSTANCE = new QPPromoteReceiverPage$bodyWithHalfBackgroundView$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ECTransitionViewKt.TransitionFadeInOutView(viewContainer, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage$bodyWithHalfBackgroundView$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECTransitionView eCTransitionView) {
                eCTransitionView.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage.bodyWithHalfBackgroundView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                        ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                        eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        eCTransitionAttr2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPPromoteReceiverPage$bodyWithHalfBackgroundView$1() {
        super(1);
    }
}
