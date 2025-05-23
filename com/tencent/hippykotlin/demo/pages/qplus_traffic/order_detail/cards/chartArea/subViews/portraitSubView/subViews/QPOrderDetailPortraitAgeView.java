package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailPieChartViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailTableListCellView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailTableListCellViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailPortraitAgeView extends IQPOrderDetailCardView {
    public final Pair<String, Float>[] infoArray;

    public QPOrderDetailPortraitAgeView(Pair<String, Float>[] pairArr) {
        this.infoArray = pairArr;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ArrayList arrayListOf;
        int i3 = 0;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(4294914928L, 4278229503L, 4287839231L, 4294949120L, 4278241114L, 4294914877L, 4278237359L, 4294923558L, 4282084351L, 4294012160L, 4285286399L, 4294908655L);
        Pair<String, Float>[] pairArr = this.infoArray;
        int length = pairArr.length;
        int i16 = 0;
        int i17 = -1;
        while (i3 < length) {
            int i18 = i16 + 1;
            if (Intrinsics.areEqual(pairArr[i3].getFirst(), "\u672a\u77e5")) {
                i17 = i16;
            }
            i3++;
            i16 = i18;
        }
        if (i17 != -1) {
            arrayListOf.add(i17, 4291282887L);
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.marginTop(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                Pair<String, Float>[] pairArr2 = QPOrderDetailPortraitAgeView.this.infoArray;
                ArrayList arrayList = new ArrayList(pairArr2.length);
                for (Pair<String, Float> pair : pairArr2) {
                    arrayList.add(Float.valueOf(pair.getSecond().floatValue()));
                }
                Object[] array = arrayList.toArray(new Float[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Object[] array2 = arrayListOf.toArray(new Long[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                final QPOrderDetailPortraitAgeView qPOrderDetailPortraitAgeView = QPOrderDetailPortraitAgeView.this;
                viewContainer2.addChild(new QPDetailPieChartView((Float[]) array, (Long[]) array2), new Function1<QPDetailPieChartView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$body$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPDetailPieChartView qPDetailPieChartView) {
                        QPDetailPieChartView qPDetailPieChartView2 = qPDetailPieChartView;
                        final QPOrderDetailPortraitAgeView qPOrderDetailPortraitAgeView2 = QPOrderDetailPortraitAgeView.this;
                        qPDetailPieChartView2.ref(qPDetailPieChartView2, new Function1<aa<QPDetailPieChartView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.body.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<QPDetailPieChartView> aaVar) {
                                QPOrderDetailPortraitAgeView.this.getClass();
                                return Unit.INSTANCE;
                            }
                        });
                        qPDetailPieChartView2.attr(new Function1<QPDetailPieChartViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.body.2.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPDetailPieChartViewAttr qPDetailPieChartViewAttr) {
                                QPDetailPieChartViewAttr qPDetailPieChartViewAttr2 = qPDetailPieChartViewAttr;
                                qPDetailPieChartViewAttr2.size(200.0f, 200.0f);
                                qPDetailPieChartViewAttr2.marginTop(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final Pair<String, Float>[] pairArr3 = QPOrderDetailPortraitAgeView.this.infoArray;
                Object[] array3 = arrayListOf.toArray(new Long[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                final Long[] lArr = (Long[]) array3;
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$labelView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final Pair<String, Float>[] pairArr4 = pairArr3;
                        final Long[] lArr2 = lArr;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$labelView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.labelView.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(200.0f);
                                        tVar2.flexWrapWrap();
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                Pair<String, Float>[] pairArr5 = pairArr4;
                                ArrayList arrayList2 = new ArrayList(pairArr5.length);
                                final int i19 = 0;
                                for (Pair<String, Float> pair2 : pairArr5) {
                                    arrayList2.add(pair2.getFirst());
                                }
                                final Long[] lArr3 = lArr2;
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    int i26 = i19 + 1;
                                    if (i19 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final String str = (String) next;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$labelView$1$1$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$labelView$1$1$3$1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.alignItemsCenter();
                                                    tVar2.marginTop(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final Long[] lArr4 = lArr3;
                                            final int i27 = i19;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$labelView$1$1$3$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    final Long[] lArr5 = lArr4;
                                                    final int i28 = i27;
                                                    vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.labelView.1.1.3.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.size(8.0f, 8.0f);
                                                            tVar2.borderRadius(4.0f);
                                                            tVar2.backgroundColor(lArr5[i28].longValue());
                                                            tVar2.marginRight(4.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str2 = str;
                                            final Long[] lArr5 = lArr3;
                                            final int i28 = i19;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$labelView$1$1$3$1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final String str3 = str2;
                                                    final Long[] lArr6 = lArr5;
                                                    final int i29 = i28;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.labelView.1.1.3.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(str3);
                                                            ceVar2.marginRight(8.0f);
                                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                            ceVar2.color(lArr6[i29].longValue());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    i19 = i26;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                final Pair<String, Float>[] pairArr4 = QPOrderDetailPortraitAgeView.this.infoArray;
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$tableListView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                        viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$tableListView$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                m mVar2 = mVar;
                                mVar2.flexDirectionColumn();
                                mVar2.justifyContentFlexStart();
                                mVar2.marginBottom(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$tableListView$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.tableListView.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m() - 32);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.marginBottom(8.0f);
                                        tVar2.marginTop(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.tableListView.1.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.tableListView.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u5e74\u9f84");
                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                ceVar2.color(hVar);
                                                ceVar2.fontWeightBold();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.tableListView.1.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView.tableListView.1.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u5360\u6bd4");
                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                ceVar2.color(hVar);
                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        for (Pair<String, Float> pair2 : pairArr4) {
                            String first = pair2.getFirst();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(((int) (r3.getSecond().floatValue() * 10000)) / 100.0d);
                            sb5.append('%');
                            QPDetailTableListCellViewKt.QPDetailTableListCellView$default(viewContainer4, first, sb5.toString(), new Function1<QPDetailTableListCellView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView$tableListView$1$3$1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(QPDetailTableListCellView qPDetailTableListCellView) {
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }
}
