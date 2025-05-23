package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeOrderView$bodyWithSafeArea$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPlusTrafficHomeOrderView$bodyWithSafeArea$1 INSTANCE = new QPlusTrafficHomeOrderView$bodyWithSafeArea$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithSafeArea$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithSafeArea.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo153width(tVar2.getPagerData().m()).mo141height(34.0f);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPlusTrafficHomeOrderView$bodyWithSafeArea$1() {
        super(1);
    }
}
