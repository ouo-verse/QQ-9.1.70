package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.p;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class QPDetailRingChartView extends ComposeView<QPDetailRingChartViewAttr, QPDetailRingChartViewEvent> {
    public final int progress;

    public QPDetailRingChartView(int i3) {
        this.progress = i3;
    }

    public static final void access$drawRing(QPDetailRingChartView qPDetailRingChartView, p pVar, float f16, float f17, float f18, h hVar) {
        qPDetailRingChartView.getClass();
        pVar.b();
        pVar.j(10.0f);
        pVar.k(f16, 5.0f);
        pVar.a(f16, f17, 67.0f, -1.5707964f, (f18 * 6.2831855f) - 1.5707964f, false);
        pVar.n(hVar);
        pVar.h();
        pVar.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPDetailRingChartViewAttr access$getAttr(QPDetailRingChartView qPDetailRingChartView) {
        return (QPDetailRingChartViewAttr) qPDetailRingChartView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPDetailRingChartView qPDetailRingChartView = QPDetailRingChartView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final v vVar2 = vVar;
                        final QPDetailRingChartView qPDetailRingChartView2 = QPDetailRingChartView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                FlexNode flexNode = QPDetailRingChartView.access$getAttr(QPDetailRingChartView.this).getFlexNode();
                                float U = flexNode != null ? flexNode.U() : 0.0f;
                                FlexNode flexNode2 = QPDetailRingChartView.access$getAttr(QPDetailRingChartView.this).getFlexNode();
                                tVar2.size(U, flexNode2 != null ? flexNode2.K() : 0.0f);
                                tVar2.allCenter();
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        AnonymousClass2 anonymousClass2 = new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CanvasView canvasView) {
                                canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        Attr attr2 = attr;
                                        attr2.absolutePositionAllZero();
                                        attr2.mo113backgroundColor(h.INSTANCE.k());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        final QPDetailRingChartView qPDetailRingChartView3 = QPDetailRingChartView.this;
                        CanvasViewKt.a(vVar2, anonymousClass2, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(p pVar, Float f16, Float f17) {
                                h hVar;
                                p pVar2 = pVar;
                                float floatValue = f16.floatValue();
                                float f18 = 2;
                                float floatValue2 = f17.floatValue() / f18;
                                hVar = IPagerIdKtxKt.getSkinColor(vVar2).tokenColor("qecommerce_skin_color_tag_normal", false);
                                QPDetailRingChartView.access$drawRing(QPDetailRingChartView.this, pVar2, floatValue / f18, floatValue2, 0.999f, hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        AnonymousClass4 anonymousClass4 = new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CanvasView canvasView) {
                                canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        Attr attr2 = attr;
                                        attr2.absolutePositionAllZero();
                                        attr2.mo113backgroundColor(h.INSTANCE.k());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        final QPDetailRingChartView qPDetailRingChartView4 = QPDetailRingChartView.this;
                        CanvasViewKt.a(vVar2, anonymousClass4, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(p pVar, Float f16, Float f17) {
                                h hVar;
                                p pVar2 = pVar;
                                float floatValue = f16.floatValue();
                                float floatValue2 = f17.floatValue();
                                QPDetailRingChartView qPDetailRingChartView5 = QPDetailRingChartView.this;
                                float f18 = 2;
                                float min = Math.min(qPDetailRingChartView5.progress / 100.0f, 0.999f);
                                hVar = IPagerIdKtxKt.getSkinColor(vVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                QPDetailRingChartView.access$drawRing(qPDetailRingChartView5, pVar2, floatValue / f18, floatValue2 / f18, min, hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPDetailRingChartView qPDetailRingChartView5 = QPDetailRingChartView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QPDetailRingChartView qPDetailRingChartView6 = QPDetailRingChartView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(QPDetailRingChartView.this.progress);
                                        sb5.append('%');
                                        ceVar2.text(sb5.toString());
                                        ceVar2.fontFamily("Qvideo Digit");
                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 20.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_red_brand", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPDetailRingChartView qPDetailRingChartView6 = QPDetailRingChartView.this;
                        int i3 = qPDetailRingChartView6.progress;
                        if (i3 > 100) {
                            final float f16 = (i3 / 100.0f) - ((int) r1);
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    final QPDetailRingChartView qPDetailRingChartView7 = QPDetailRingChartView.this;
                                    final float f17 = f16;
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView.body.1.1.7.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.absolutePositionAllZero();
                                            FlexNode flexNode = QPDetailRingChartView.access$getAttr(QPDetailRingChartView.this).getFlexNode();
                                            float U = flexNode != null ? flexNode.U() : 0.0f;
                                            FlexNode flexNode2 = QPDetailRingChartView.access$getAttr(QPDetailRingChartView.this).getFlexNode();
                                            afVar2.size(U, flexNode2 != null ? flexNode2.K() : 0.0f);
                                            afVar2.transform(new com.tencent.kuikly.core.base.t(f17 * 360, 0.0f, 0.0f, 6, null));
                                            ImageAttrExtKt.srcUrl(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8938/zuopintuiguang/qecommerce_icon_zuopintuiguang_jindutiao_over.png", null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPDetailRingChartViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QPDetailRingChartViewEvent();
    }
}
