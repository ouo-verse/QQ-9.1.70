package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards;

import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.p;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class QPDetailPieChartView extends ComposeView<QPDetailPieChartViewAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Long[] colorArray;
    public final Float[] ratioArray;

    public QPDetailPieChartView(Float[] fArr, Long[] lArr) {
        this.ratioArray = fArr;
        this.colorArray = lArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPDetailPieChartViewAttr access$getAttr(QPDetailPieChartView qPDetailPieChartView) {
        return (QPDetailPieChartViewAttr) qPDetailPieChartView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        Object first;
        Float maxOrNull;
        Float[] fArr = this.ratioArray;
        if (!(fArr.length == 0)) {
            first = ArraysKt___ArraysKt.first(fArr);
            if (!Float.isNaN(((Number) first).floatValue())) {
                maxOrNull = ArraysKt___ArraysKt.maxOrNull(this.ratioArray);
                if ((maxOrNull != null ? maxOrNull.floatValue() : 0.0f) >= 1.0E-6f) {
                    return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$body$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                            final QPDetailPieChartView qPDetailPieChartView = QPDetailPieChartView.this;
                            w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$body$2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    Ref.FloatRef floatRef;
                                    final QPDetailPieChartView qPDetailPieChartView2 = QPDetailPieChartView.this;
                                    vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView.body.2.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.size(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width(), QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QPDetailPieChartView qPDetailPieChartView3 = QPDetailPieChartView.this;
                                    int i3 = QPDetailPieChartView.$r8$clinit;
                                    qPDetailPieChartView3.getClass();
                                    Ref.FloatRef floatRef2 = new Ref.FloatRef();
                                    floatRef2.element = -1.5707964f;
                                    final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                                    floatRef3.element = -1.5707964f;
                                    final int min = Math.min(qPDetailPieChartView3.colorArray.length, qPDetailPieChartView3.ratioArray.length);
                                    Float[] fArr2 = qPDetailPieChartView3.ratioArray;
                                    int length = fArr2.length;
                                    final int i16 = 0;
                                    int i17 = 0;
                                    while (i17 < length) {
                                        int i18 = i16 + 1;
                                        final float floatValue = fArr2[i17].floatValue();
                                        if (Math.abs(floatValue - 1.0d) < 0.001d) {
                                            w.a(qPDetailPieChartView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar2) {
                                                    final QPDetailPieChartView qPDetailPieChartView4 = QPDetailPieChartView.this;
                                                    final int i19 = i16;
                                                    final int i26 = min;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$1$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.absolutePositionAllZero();
                                                            tVar2.size(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width(), QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height());
                                                            tVar2.borderRadius(Math.min(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width(), QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height()) / 2);
                                                            tVar2.mo113backgroundColor(new h(QPDetailPieChartView.this.colorArray[i19 % i26].longValue()));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            floatRef = floatRef2;
                                        } else {
                                            final Ref.FloatRef floatRef4 = floatRef2;
                                            floatRef = floatRef2;
                                            CanvasViewKt.a(qPDetailPieChartView3, new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$1$2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(CanvasView canvasView) {
                                                    canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$1$2.1
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
                                            }, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$1$3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(p pVar, Float f16, Float f17) {
                                                    p pVar2 = pVar;
                                                    f16.floatValue();
                                                    f17.floatValue();
                                                    pVar2.b();
                                                    pVar2.j(0.0f);
                                                    float f18 = 2;
                                                    pVar2.k(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width() / f18, QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height() / f18);
                                                    Ref.FloatRef floatRef5 = floatRef3;
                                                    float f19 = (floatValue * 6.2831855f) + floatRef5.element;
                                                    floatRef5.element = f19;
                                                    QPDetailPieChartView qPDetailPieChartView4 = QPDetailPieChartView.this;
                                                    float f26 = floatRef4.element;
                                                    float width = QPDetailPieChartView.access$getAttr(qPDetailPieChartView4).width() / f18;
                                                    float height = QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height() / f18;
                                                    pVar2.f(new h(QPDetailPieChartView.this.colorArray[i16 % min].longValue()));
                                                    pVar2.a(width, height, 100.0f, f26, f19, false);
                                                    pVar2.i(width, height);
                                                    pVar2.e();
                                                    pVar2.c();
                                                    floatRef4.element = floatRef3.element;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        i17++;
                                        floatRef2 = floatRef;
                                        i16 = i18;
                                    }
                                    w.a(qPDetailPieChartView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar2) {
                                            final QPDetailPieChartView qPDetailPieChartView4 = QPDetailPieChartView.this;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$pieChart$2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    float f16 = 2;
                                                    float width = QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width() / f16;
                                                    float height = QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height() / f16;
                                                    tVar2.size(width, height);
                                                    tVar2.borderRadius(Math.min(width, height) / f16);
                                                    Attr.absolutePosition$default(tVar2, height / f16, width / f16, 0.0f, 0.0f, 12, null);
                                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
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
                    };
                }
            }
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPDetailPieChartView qPDetailPieChartView = QPDetailPieChartView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QPDetailPieChartView qPDetailPieChartView2 = QPDetailPieChartView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width(), QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height());
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final float min = Math.min(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width(), QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height());
                        final QPDetailPieChartView qPDetailPieChartView3 = QPDetailPieChartView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final QPDetailPieChartView qPDetailPieChartView4 = QPDetailPieChartView.this;
                                final float f16 = min;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView.body.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).width(), QPDetailPieChartView.access$getAttr(QPDetailPieChartView.this).height());
                                        tVar2.borderRadius(f16);
                                        tVar2.backgroundColor(4291282887L);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPDetailPieChartViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
