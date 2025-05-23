package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeOrderView$bodyWithEmptyContent$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPlusTrafficHomeOrderView$bodyWithEmptyContent$1 INSTANCE = new QPlusTrafficHomeOrderView$bodyWithEmptyContent$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithEmptyContent$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithEmptyContent.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.alignItemsCenter();
                        tVar2.mo141height(92.0f).marginTop(35.0f);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithEmptyContent.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithEmptyContent.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u6682\u65e0\u8ba2\u5355");
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null).fontWeight400();
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                ceVar2.color(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPlusTrafficHomeOrderView$bodyWithEmptyContent$1() {
        super(1);
    }
}
