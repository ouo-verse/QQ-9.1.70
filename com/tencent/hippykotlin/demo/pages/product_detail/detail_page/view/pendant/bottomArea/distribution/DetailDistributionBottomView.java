package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DetailDistributionBottomView extends ProductDetailPendantView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailPendantAttr access$getAttr(DetailDistributionBottomView detailDistributionBottomView) {
        return (ProductDetailPendantAttr) detailDistributionBottomView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float f16 = getPagerData().getIsIphoneX() ? 14.5f : 0.0f;
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomViewModel");
        final DetailDistributionBottomViewModel detailDistributionBottomViewModel = (DetailDistributionBottomViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final DetailDistributionBottomViewModel detailDistributionBottomViewModel2 = DetailDistributionBottomViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DetailDistributionBottomViewModel.this.getAddWindowBtnState());
                    }
                };
                final DetailDistributionBottomView detailDistributionBottomView = this;
                final DetailDistributionBottomViewModel detailDistributionBottomViewModel3 = DetailDistributionBottomViewModel.this;
                final float f17 = f16;
                BindDirectivesViewKt.a(viewContainer, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        final DetailDistributionBottomViewModel detailDistributionBottomViewModel4 = detailDistributionBottomViewModel3;
                        final float f18 = f17;
                        bindDirectivesView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                h hVar;
                                m mVar2 = mVar;
                                mVar2.flexDirectionColumn();
                                Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                float m3 = mVar2.getPagerData().m();
                                DetailDistributionBottomViewModel.this.getClass();
                                mVar2.size(m3, f18 + 80.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                mVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        DetailDistributionBottomView detailDistributionBottomView2 = DetailDistributionBottomView.this;
                        int i3 = DetailDistributionBottomView.$r8$clinit;
                        detailDistributionBottomView2.getClass();
                        DetailDistributionBottomView$bodyWithSepLine$1.INSTANCE.invoke(bindDirectivesView2);
                        final DetailDistributionBottomView detailDistributionBottomView3 = DetailDistributionBottomView.this;
                        final DetailDistributionBottomViewModel detailDistributionBottomViewModel5 = detailDistributionBottomViewModel3;
                        final float m3 = detailDistributionBottomView3.getPagerData().m();
                        float f19 = 2;
                        final float f26 = ((m3 - 38.0f) - (16.0f * f19)) / f19;
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithBtn$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                final DetailDistributionBottomViewModel detailDistributionBottomViewModel6 = DetailDistributionBottomViewModel.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithBtn$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        DetailDistributionBottomViewModel detailDistributionBottomViewModel7 = DetailDistributionBottomViewModel.this;
                                        return Boolean.valueOf(((Boolean) detailDistributionBottomViewModel7.isSample$delegate.getValue(detailDistributionBottomViewModel7, DetailDistributionBottomViewModel.$$delegatedProperties[1])).booleanValue());
                                    }
                                };
                                final DetailDistributionBottomView detailDistributionBottomView4 = detailDistributionBottomView3;
                                final float f27 = f26;
                                final DetailDistributionBottomViewModel detailDistributionBottomViewModel7 = DetailDistributionBottomViewModel.this;
                                final float f28 = 16.0f;
                                ConditionViewKt.c(viewContainer3, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithBtn$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final DetailDistributionBottomView detailDistributionBottomView5 = DetailDistributionBottomView.this;
                                        final float f29 = f27;
                                        final DetailDistributionBottomViewModel detailDistributionBottomViewModel8 = detailDistributionBottomViewModel7;
                                        final float f36 = f28;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithBtn.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final float f37 = f36;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithBtn.1.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.justifyContentSpaceEvenly();
                                                        float f38 = f37;
                                                        ((Attr) c.a.a(tVar2, 10.0f, f38, 0.0f, f38, 4, null)).mo141height(40.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                DetailDistributionBottomView detailDistributionBottomView6 = DetailDistributionBottomView.this;
                                                final float f38 = f29;
                                                detailDistributionBottomViewModel8.getClass();
                                                final ProductDetailButtonItem productDetailButtonItem = new ProductDetailButtonItem("\u514d\u8d39\u7533\u6837", 29);
                                                final DetailDistributionBottomView detailDistributionBottomView7 = DetailDistributionBottomView.this;
                                                int i16 = DetailDistributionBottomView.$r8$clinit;
                                                detailDistributionBottomView7.getClass();
                                                final Function1<ProductDetailButtonItem, Unit> function1 = new Function1<ProductDetailButtonItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$handleTapSampleApply$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ProductDetailButtonItem productDetailButtonItem2) {
                                                        IProductDetailPendantViewModel viewModel2 = DetailDistributionBottomView.access$getAttr(DetailDistributionBottomView.this).getViewModel();
                                                        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomViewModel");
                                                        DetailDistributionBottomViewModel detailDistributionBottomViewModel9 = (DetailDistributionBottomViewModel) viewModel2;
                                                        detailDistributionBottomViewModel9.getClass();
                                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://ecommerce/open?target=52&page_name=ApplySampleAgreement&modal_mode=1&is_sample=1&channel=");
                                                        m16.append(detailDistributionBottomViewModel9.params.k(WadlProxyConsts.CHANNEL, 0));
                                                        m16.append("&spu_id=");
                                                        m16.append(detailDistributionBottomViewModel9.params.p("spu_id"));
                                                        m16.append("&shop_id=");
                                                        m16.append(detailDistributionBottomViewModel9.params.p("shop_id"));
                                                        BridgeModule.openPage$default(currentBridgeModule, m16.toString(), false, null, null, 30);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                detailDistributionBottomView6.getClass();
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithWhiteBtn$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                        final float f39 = f38;
                                                        final Function1<ProductDetailButtonItem, Unit> function12 = function1;
                                                        final ProductDetailButtonItem productDetailButtonItem2 = productDetailButtonItem;
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithWhiteBtn$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                v vVar4 = vVar3;
                                                                final float f46 = f39;
                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithWhiteBtn.1.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.allCenter();
                                                                        tVar2.borderRadius(4.0f).mo153width(f46);
                                                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_btn_secondary_red_normal", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final Function1<ProductDetailButtonItem, Unit> function13 = function12;
                                                                final ProductDetailButtonItem productDetailButtonItem3 = productDetailButtonItem2;
                                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithWhiteBtn.1.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final Function1<ProductDetailButtonItem, Unit> function14 = function13;
                                                                        final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem3;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithWhiteBtn.1.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                function14.invoke(productDetailButtonItem4);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem2;
                                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithWhiteBtn.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final ProductDetailButtonItem productDetailButtonItem5 = ProductDetailButtonItem.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithWhiteBtn.1.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                h hVar;
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.text(ProductDetailButtonItem.this.txt);
                                                                                ce.fontSize$default(ceVar2.fontWeightBold(), 16.0f, null, 2, null);
                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
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
                                                }.invoke(vVar2);
                                                DetailDistributionBottomView detailDistributionBottomView8 = DetailDistributionBottomView.this;
                                                float f39 = f29;
                                                ButtonInfo currentButtonInfo = detailDistributionBottomViewModel8.currentButtonInfo();
                                                detailDistributionBottomView8.getClass();
                                                new DetailDistributionBottomView$bodyWithRedBtn$1(f39, currentButtonInfo).invoke(vVar2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final DetailDistributionBottomView detailDistributionBottomView5 = detailDistributionBottomView3;
                                final float f29 = m3;
                                final DetailDistributionBottomViewModel detailDistributionBottomViewModel8 = DetailDistributionBottomViewModel.this;
                                ConditionViewKt.a(viewContainer3, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithBtn$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final DetailDistributionBottomView detailDistributionBottomView6 = DetailDistributionBottomView.this;
                                        final float f36 = f29;
                                        final float f37 = f28;
                                        final DetailDistributionBottomViewModel detailDistributionBottomViewModel9 = detailDistributionBottomViewModel8;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithBtn.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithBtn.1.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.justifyContentSpaceEvenly();
                                                        ((Attr) c.a.a(tVar2, 10.0f, 16.0f, 0.0f, 16.0f, 4, null)).mo141height(40.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                DetailDistributionBottomView detailDistributionBottomView7 = DetailDistributionBottomView.this;
                                                float f38 = f36 - (f37 * 2);
                                                ButtonInfo currentButtonInfo = detailDistributionBottomViewModel9.currentButtonInfo();
                                                int i16 = DetailDistributionBottomView.$r8$clinit;
                                                detailDistributionBottomView7.getClass();
                                                new DetailDistributionBottomView$bodyWithRedBtn$1(f38, currentButtonInfo).invoke(vVar2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(bindDirectivesView2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
