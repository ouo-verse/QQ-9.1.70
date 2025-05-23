package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPDetailSimpleDataView extends IQPOrderDetailCardView {
    public final String title;
    public final String value;

    public QPDetailSimpleDataView(String str, String str2) {
        this.value = str;
        this.title = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.justifyContentFlexStart();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final QPDetailSimpleDataView qPDetailSimpleDataView = QPDetailSimpleDataView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final QPDetailSimpleDataView qPDetailSimpleDataView2 = QPDetailSimpleDataView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text(QPDetailSimpleDataView.this.value);
                                ceVar2.fontFamily("Qvideo Digit");
                                ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                ceVar2.color(hVar);
                                ceVar2.marginBottom(2.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPDetailSimpleDataView qPDetailSimpleDataView2 = QPDetailSimpleDataView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final QPDetailSimpleDataView qPDetailSimpleDataView3 = QPDetailSimpleDataView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text(QPDetailSimpleDataView.this.title);
                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_secondary", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
