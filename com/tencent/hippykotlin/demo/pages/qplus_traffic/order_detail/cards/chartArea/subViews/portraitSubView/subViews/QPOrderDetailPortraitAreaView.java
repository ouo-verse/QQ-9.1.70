package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.ProvinceModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailTableListCellView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPOrderDetailPortraitAreaView extends IQPOrderDetailCardView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailPortraitAreaView.class, "currentProvinceIndex", "getCurrentProvinceIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailPortraitAreaView.class, "provinceShowLimit", "getProvinceShowLimit()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailPortraitAreaView.class, "cityShowLimit", "getCityShowLimit()I", 0)};
    public final Lazy provincePercentSum$delegate;
    public final ReadWriteProperty provinceShowLimit$delegate;
    public final QPOrderDetailPortraitViewModel viewModel;
    public final ReadWriteProperty currentProvinceIndex$delegate = c.a(0);
    public final ReadWriteProperty cityShowLimit$delegate = c.a(0);

    public QPOrderDetailPortraitAreaView(QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel) {
        Lazy lazy;
        this.viewModel = qPOrderDetailPortraitViewModel;
        this.provinceShowLimit$delegate = c.a(Integer.valueOf(Math.min(7, qPOrderDetailPortraitViewModel.getProvinceInfoList().size())));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provincePercentSum$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int collectionSizeOrDefault;
                com.tencent.kuikly.core.reactive.collection.c<ProvinceModel> provinceInfoList = QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(provinceInfoList, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<ProvinceModel> it = provinceInfoList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    i3 += it.next().percent;
                    arrayList.add(Unit.INSTANCE);
                }
                return Integer.valueOf(i3);
            }
        });
        this.provincePercentSum$delegate = lazy;
        LazyKt__LazyJVMKt.lazy(new Function0<Integer[]>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityPercentSum$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer[] invoke() {
                int collectionSizeOrDefault;
                ArrayList arrayList = new ArrayList();
                com.tencent.kuikly.core.reactive.collection.c<ProvinceModel> provinceInfoList = QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(provinceInfoList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<ProvinceModel> it = provinceInfoList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Pair<String, Integer>[] pairArr = it.next().cityList;
                        ArrayList arrayList3 = new ArrayList(pairArr.length);
                        for (Pair<String, Integer> pair : pairArr) {
                            arrayList3.add(Boolean.valueOf(arrayList.add(pair.getSecond())));
                        }
                        arrayList2.add(arrayList3);
                    } else {
                        Object[] array = arrayList.toArray(new Integer[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        return (Integer[]) array;
                    }
                }
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.justifyContentFlexStart();
                        mVar2.alignItemsCenter();
                        mVar2.marginBottom(8.0f);
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView = QPOrderDetailPortraitAreaView.this;
                qPOrderDetailPortraitAreaView.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                        viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                m mVar2 = mVar;
                                mVar2.mo153width(mVar2.getPagerData().m());
                                mVar2.flexDirectionColumn();
                                mVar2.justifyContentFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.alignSelfFlexStart();
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginTop(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u5730\u533a\u5206\u5e03");
                                                ceVar2.fontWeightBold();
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 15.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.3.1
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
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u7701\u4efd");
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
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.3.3.1
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
                        final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView2 = QPOrderDetailPortraitAreaView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(QPOrderDetailPortraitAreaView.this.getProvinceShowLimit());
                            }
                        };
                        final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView3 = QPOrderDetailPortraitAreaView.this;
                        BindDirectivesViewKt.a(viewContainer4, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                com.tencent.kuikly.core.reactive.collection.c<ProvinceModel> provinceInfoList = QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList();
                                QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView4 = QPOrderDetailPortraitAreaView.this;
                                Iterator<ProvinceModel> it = provinceInfoList.iterator();
                                int i3 = 0;
                                while (it.hasNext()) {
                                    ProvinceModel next = it.next();
                                    int i16 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    ProvinceModel provinceModel = next;
                                    if (i3 < qPOrderDetailPortraitAreaView4.getProvinceShowLimit()) {
                                        String str = provinceModel.provinceName;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(((provinceModel.percent * 10000) / ((Number) qPOrderDetailPortraitAreaView4.provincePercentSum$delegate.getValue()).intValue()) / 100.0d);
                                        sb5.append('%');
                                        bindDirectivesView2.addChild(new QPDetailTableListCellView(str, sb5.toString(), false), new Function1<QPDetailTableListCellView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1$5$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(QPDetailTableListCellView qPDetailTableListCellView) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    i3 = i16;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView4 = QPOrderDetailPortraitAreaView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPOrderDetailPortraitAreaView.this.getProvinceShowLimit() != QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList().size());
                            }
                        };
                        final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView5 = QPOrderDetailPortraitAreaView.this;
                        ConditionViewKt.c(viewContainer4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$provinceTableList$1.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView6 = QPOrderDetailPortraitAreaView.this;
                                Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.provinceTableList.1.7.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView7 = QPOrderDetailPortraitAreaView.this;
                                        qPOrderDetailPortraitAreaView7.provinceShowLimit$delegate.setValue(qPOrderDetailPortraitAreaView7, QPOrderDetailPortraitAreaView.$$delegatedProperties[1], Integer.valueOf(qPOrderDetailPortraitAreaView7.viewModel.getProvinceInfoList().size()));
                                        return Unit.INSTANCE;
                                    }
                                };
                                KProperty<Object>[] kPropertyArr = QPOrderDetailPortraitAreaView.$$delegatedProperties;
                                qPOrderDetailPortraitAreaView6.getClass();
                                new QPOrderDetailPortraitAreaView$expandMoreView$1(function03).invoke(conditionView);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView2 = QPOrderDetailPortraitAreaView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(QPOrderDetailPortraitAreaView.this.getCurrentProvinceIndex());
                    }
                };
                final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView3 = QPOrderDetailPortraitAreaView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        Function1<ViewContainer<?, ?>, Unit> function1;
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView4 = QPOrderDetailPortraitAreaView.this;
                        qPOrderDetailPortraitAreaView4.cityShowLimit$delegate.setValue(qPOrderDetailPortraitAreaView4, QPOrderDetailPortraitAreaView.$$delegatedProperties[2], Integer.valueOf(Math.min(7, qPOrderDetailPortraitAreaView4.viewModel.getProvinceInfoList().get(QPOrderDetailPortraitAreaView.this.getCurrentProvinceIndex()).cityList.length)));
                        final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView5 = QPOrderDetailPortraitAreaView.this;
                        com.tencent.kuikly.core.reactive.collection.c<ProvinceModel> provinceInfoList = qPOrderDetailPortraitAreaView5.viewModel.getProvinceInfoList();
                        if (provinceInfoList != null && provinceInfoList.size() == 0) {
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                    viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(m mVar) {
                                            m mVar2 = mVar;
                                            mVar2.mo153width(mVar2.getPagerData().m());
                                            mVar2.flexDirectionColumn();
                                            mVar2.justifyContentFlexStart();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.alignSelfFlexStart();
                                                    tVar2.marginLeft(16.0f);
                                                    tVar2.marginTop(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.2.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.2.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text("\u5730\u7ea7\u5206\u5e03");
                                                            ceVar2.fontWeightBold();
                                                            ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 15.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView6 = QPOrderDetailPortraitAreaView.this;
                                    w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.1
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
                                            final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView7 = QPOrderDetailPortraitAreaView.this;
                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirectionRow();
                                                            tVar2.justifyContentFlexStart();
                                                            tVar2.alignItemsCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView8 = QPOrderDetailPortraitAreaView.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView9 = QPOrderDetailPortraitAreaView.this;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    int collectionSizeOrDefault;
                                                                    int collectionSizeOrDefault2;
                                                                    b k3 = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u());
                                                                    e eVar = new e();
                                                                    com.tencent.kuikly.core.reactive.collection.c<ProvinceModel> provinceInfoList2 = QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList();
                                                                    com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(provinceInfoList2, 10);
                                                                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                                                    Iterator<ProvinceModel> it = provinceInfoList2.iterator();
                                                                    while (it.hasNext()) {
                                                                        arrayList.add(bVar.t(it.next().provinceName));
                                                                    }
                                                                    Unit unit = Unit.INSTANCE;
                                                                    com.tencent.kuikly.core.nvi.serialization.json.b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "items", bVar);
                                                                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(provinceInfoList2, 10);
                                                                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                                                                    Iterator<ProvinceModel> it5 = provinceInfoList2.iterator();
                                                                    while (it5.hasNext()) {
                                                                        arrayList2.add(m3.t(it5.next().provinceName));
                                                                    }
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    eVar.v("values", m3);
                                                                    eVar.v("navTitle", "\u9009\u62e9\u57ce\u5e02");
                                                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView10 = QPOrderDetailPortraitAreaView.this;
                                                                    IPagerIdKtxKt.openPageForResult$default(k3, "mqqapi://kuikly/open?target=52&page_name=qplus_chooser_half_view&modal_mode=1&src_type=internal&version=1&bundle_name=new_qecommerce", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.2.1.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(e eVar2) {
                                                                            e eVar3 = eVar2;
                                                                            Integer valueOf = eVar3 != null ? Integer.valueOf(eVar3.j("choseIndex")) : null;
                                                                            if (valueOf != null) {
                                                                                QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView11 = QPOrderDetailPortraitAreaView.this;
                                                                                qPOrderDetailPortraitAreaView11.currentProvinceIndex$delegate.setValue(qPOrderDetailPortraitAreaView11, QPOrderDetailPortraitAreaView.$$delegatedProperties[0], Integer.valueOf(valueOf.intValue()));
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, 2);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView9 = QPOrderDetailPortraitAreaView.this;
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView10 = QPOrderDetailPortraitAreaView.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    h hVar;
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.text(QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList().get(QPOrderDetailPortraitAreaView.this.getCurrentProvinceIndex()).provinceName);
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
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.2.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(16.0f, 16.0f);
                                                                    afVar2.marginLeft(2.0f);
                                                                    b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_down_primary", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.3.3.1
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
                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView7 = QPOrderDetailPortraitAreaView.this;
                                    Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Integer.valueOf(QPOrderDetailPortraitAreaView.this.getCityShowLimit());
                                        }
                                    };
                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView8 = QPOrderDetailPortraitAreaView.this;
                                    BindDirectivesViewKt.a(viewContainer4, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                            BindDirectivesView bindDirectivesView4 = bindDirectivesView3;
                                            Pair<String, Integer>[] pairArr = QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList().get(QPOrderDetailPortraitAreaView.this.getCurrentProvinceIndex()).cityList;
                                            QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView9 = QPOrderDetailPortraitAreaView.this;
                                            int length = pairArr.length;
                                            int i3 = 0;
                                            int i16 = 0;
                                            while (i3 < length) {
                                                Pair<String, Integer> pair = pairArr[i3];
                                                int i17 = i16 + 1;
                                                if (i16 < qPOrderDetailPortraitAreaView9.getCityShowLimit()) {
                                                    String first = pair.getFirst();
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append(((pair.getSecond().intValue() * 10000) / qPOrderDetailPortraitAreaView9.viewModel.getProvinceInfoList().get(qPOrderDetailPortraitAreaView9.getCurrentProvinceIndex()).percent) / 100.0d);
                                                    sb5.append('%');
                                                    bindDirectivesView4.addChild(new QPDetailTableListCellView(first, sb5.toString(), false), new Function1<QPDetailTableListCellView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView$cityTableList$2$5$1$1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final /* bridge */ /* synthetic */ Unit invoke(QPDetailTableListCellView qPDetailTableListCellView) {
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                i3++;
                                                i16 = i17;
                                            }
                                            final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView10 = QPOrderDetailPortraitAreaView.this;
                                            Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.5.2
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return Boolean.valueOf(QPOrderDetailPortraitAreaView.this.getCityShowLimit() != QPOrderDetailPortraitAreaView.this.viewModel.getProvinceInfoList().get(QPOrderDetailPortraitAreaView.this.getCurrentProvinceIndex()).cityList.length);
                                                }
                                            };
                                            final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView11 = QPOrderDetailPortraitAreaView.this;
                                            ConditionViewKt.c(bindDirectivesView4, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.5.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ConditionView conditionView) {
                                                    final QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView12 = QPOrderDetailPortraitAreaView.this;
                                                    Function0<Unit> function04 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView.cityTableList.2.5.3.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView13 = QPOrderDetailPortraitAreaView.this;
                                                            qPOrderDetailPortraitAreaView13.cityShowLimit$delegate.setValue(qPOrderDetailPortraitAreaView13, QPOrderDetailPortraitAreaView.$$delegatedProperties[2], Integer.valueOf(qPOrderDetailPortraitAreaView13.viewModel.getProvinceInfoList().get(QPOrderDetailPortraitAreaView.this.getCurrentProvinceIndex()).cityList.length));
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr = QPOrderDetailPortraitAreaView.$$delegatedProperties;
                                                    qPOrderDetailPortraitAreaView12.getClass();
                                                    new QPOrderDetailPortraitAreaView$expandMoreView$1(function04).invoke(conditionView);
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
                        function1.invoke(bindDirectivesView2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public final int getCityShowLimit() {
        return ((Number) this.cityShowLimit$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final int getCurrentProvinceIndex() {
        return ((Number) this.currentProvinceIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final int getProvinceShowLimit() {
        return ((Number) this.provinceShowLimit$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }
}
