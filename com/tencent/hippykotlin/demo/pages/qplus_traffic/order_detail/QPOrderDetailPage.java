package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.QPOrderDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.page_model.QPOrderDetailPageModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBar;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.NavBarAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public QPOrderDetailPageModel pageModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QPOrderDetailPage qPOrderDetailPage = QPOrderDetailPage.this;
                ASDNavigationBarKt.NavBar(viewContainer2, new Function1<ASDNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ASDNavigationBar aSDNavigationBar) {
                        final QPOrderDetailPage qPOrderDetailPage2 = QPOrderDetailPage.this;
                        aSDNavigationBar.attr(new Function1<NavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NavBarAttr navBarAttr) {
                                NavBarAttr navBarAttr2 = navBarAttr;
                                QPOrderDetailPageModel qPOrderDetailPageModel = QPOrderDetailPage.this.pageModel;
                                if (qPOrderDetailPageModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                    qPOrderDetailPageModel = null;
                                }
                                qPOrderDetailPageModel.getClass();
                                navBarAttr2.setNavTitle("\u8ba2\u5355\u8be6\u60c5");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailPage qPOrderDetailPage2 = QPOrderDetailPage.this;
                qPOrderDetailPage2.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$bodyWithMainView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final QPOrderDetailPage qPOrderDetailPage3 = QPOrderDetailPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$bodyWithMainView$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                QPOrderDetailPageModel qPOrderDetailPageModel = QPOrderDetailPage.this.pageModel;
                                if (qPOrderDetailPageModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                    qPOrderDetailPageModel = null;
                                }
                                return Boolean.valueOf(((QPlusTrafficUIState) qPOrderDetailPageModel.pageState$delegate.getValue(qPOrderDetailPageModel, QPOrderDetailPageModel.$$delegatedProperties[0])) == QPlusTrafficUIState.COMPLETED);
                            }
                        };
                        final QPOrderDetailPage qPOrderDetailPage4 = QPOrderDetailPage.this;
                        ConditionViewKt.c(viewContainer3, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$bodyWithMainView$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QPOrderDetailPage qPOrderDetailPage5 = QPOrderDetailPage.this;
                                int i3 = QPOrderDetailPage.$r8$clinit;
                                qPOrderDetailPage5.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$orderDetailList$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                        final QPOrderDetailPage qPOrderDetailPage6 = QPOrderDetailPage.this;
                                        viewContainer4.addChild(new QPOrderDetailView(), new Function1<QPOrderDetailView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage$orderDetailList$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPOrderDetailView qPOrderDetailView) {
                                                final QPOrderDetailPage qPOrderDetailPage7 = QPOrderDetailPage.this;
                                                qPOrderDetailView.attr(new Function1<QPOrderDetailAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage.orderDetailList.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QPOrderDetailAttr qPOrderDetailAttr) {
                                                        QPOrderDetailAttr qPOrderDetailAttr2 = qPOrderDetailAttr;
                                                        qPOrderDetailAttr2.mo153width(qPOrderDetailAttr2.getPagerData().m());
                                                        qPOrderDetailAttr2.mo141height(qPOrderDetailAttr2.getPagerData().l() - QPOrderDetailPage.this.getPageData().getNavigationBarHeight());
                                                        qPOrderDetailAttr2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(qPOrderDetailAttr2).tokenColor("qecommerce_skin_color_bg_backplate", false));
                                                        QPOrderDetailPage qPOrderDetailPage8 = QPOrderDetailPage.this;
                                                        QPOrderDetailPageModel qPOrderDetailPageModel = qPOrderDetailPage8.pageModel;
                                                        if (qPOrderDetailPageModel == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                            qPOrderDetailPageModel = null;
                                                        }
                                                        QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp = qPOrderDetailPageModel.orderDetailInfo;
                                                        Intrinsics.checkNotNull(qPlusGetPromotionDetailRsp);
                                                        qPOrderDetailPage8.getPagerData().n();
                                                        qPOrderDetailAttr2.viewModel = new QPOrderDetailViewModel(qPlusGetPromotionDetailRsp);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(conditionView);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.pageModel = new QPOrderDetailPageModel(getPageData().n());
    }
}
