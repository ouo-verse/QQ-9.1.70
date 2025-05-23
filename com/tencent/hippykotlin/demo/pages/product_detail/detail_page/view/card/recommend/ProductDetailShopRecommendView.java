package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopRecommendView extends ProductDetailCardView {
    public final float cardWidth = (c.f117352a.g().getPageData().m() - 43.0f) / 2;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$couponRowView(ProductDetailShopRecommendView productDetailShopRecommendView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailShopRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendViewModel");
        return new ProductDetailShopRecommendView$couponRowView$1((ProductDetailShopRecommendViewModel) viewModel, productDetailShopRecommendView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$couponView(ProductDetailShopRecommendView productDetailShopRecommendView, final ProductDetailLabelInfo productDetailLabelInfo) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailShopRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendViewModel");
        ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel = (ProductDetailShopRecommendViewModel) viewModel;
        productDetailShopRecommendViewModel.getClass();
        ArrayList<ProductDetailLabelInfo> arrayList = new ArrayList<>();
        ArrayList<ProductDetailLabelInfo> arrayList2 = productDetailShopRecommendViewModel.info.prodTags;
        if (arrayList2 != null) {
            arrayList = arrayList2;
        }
        if (arrayList.isEmpty()) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$couponView$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$couponView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$couponView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ProductDetailLabelInfo productDetailLabelInfo2 = ProductDetailLabelInfo.this;
                viewContainer.addChild(new ProductDetailCouponLabelView(productDetailLabelInfo2), new Function1<ProductDetailCouponLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$couponView$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ProductDetailCouponLabelView productDetailCouponLabelView) {
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$priceView(ProductDetailShopRecommendView productDetailShopRecommendView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailShopRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendViewModel");
        return new ProductDetailShopRecommendView$priceView$1((ProductDetailShopRecommendViewModel) viewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendViewModel");
        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel = (ProductDetailShopRecommendViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ProductDetailShopRecommendView productDetailShopRecommendView = ProductDetailShopRecommendView.this;
                final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel2 = productDetailShopRecommendViewModel;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailShopRecommendView productDetailShopRecommendView2 = ProductDetailShopRecommendView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.mo153width(ProductDetailShopRecommendView.this.cardWidth);
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignSelfCenter();
                                tVar2.borderRadius(4.0f);
                                tVar2.marginBottom(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel3 = productDetailShopRecommendViewModel2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel4 = ProductDetailShopRecommendViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel5 = ProductDetailShopRecommendViewModel.this;
                                        IReportParamsBuilder iReportParamsBuilder = productDetailShopRecommendViewModel5.reportParams;
                                        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
                                        if (eCDetailPageReportParamsBuilder != null) {
                                            eCDetailPageReportParamsBuilder.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
                                            Utils utils = Utils.INSTANCE;
                                            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_recommend_ck", "[ProductDetailReporter] reportRecommendClk, event cod = qstore_prd_detail_pg_recommend_ck, data = "), utils);
                                        }
                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), productDetailShopRecommendViewModel5.info.url, false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopRecommendView productDetailShopRecommendView3 = ProductDetailShopRecommendView.this;
                        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel4 = productDetailShopRecommendViewModel2;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final ProductDetailShopRecommendView productDetailShopRecommendView4 = ProductDetailShopRecommendView.this;
                                final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel5 = productDetailShopRecommendViewModel4;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        float f16 = ProductDetailShopRecommendView.this.cardWidth;
                                        afVar2.size(f16, f16);
                                        afVar2.marginBottom(8.0f);
                                        ImageAttrExtKt.srcUrl(afVar2, productDetailShopRecommendViewModel5.info.cover, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel5 = productDetailShopRecommendViewModel2;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel6 = ProductDetailShopRecommendViewModel.this;
                                richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        h hVar;
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.marginLeft(8.0f);
                                        richTextAttr2.marginRight(8.0f);
                                        richTextAttr2.text(ProductDetailShopRecommendViewModel.this.info.title);
                                        ce.fontSize$default(richTextAttr2, 14.0f, null, 2, null);
                                        richTextAttr2.lines(2);
                                        richTextAttr2.marginBottom(8.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(richTextAttr2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        richTextAttr2.color(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ((ProductDetailShopRecommendView$couponRowView$1) ProductDetailShopRecommendView.access$couponRowView(ProductDetailShopRecommendView.this)).invoke(vVar2);
                        final ProductDetailShopRecommendView productDetailShopRecommendView4 = ProductDetailShopRecommendView.this;
                        productDetailShopRecommendView4.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$bottomView$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                final ProductDetailShopRecommendView productDetailShopRecommendView5 = ProductDetailShopRecommendView.this;
                                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$bottomView$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.bottomView.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentFlexStart();
                                                tVar2.alignItemsFlexEnd();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ((ProductDetailShopRecommendView$priceView$1) ProductDetailShopRecommendView.access$priceView(ProductDetailShopRecommendView.this)).invoke(vVar4);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendViewModel");
        IReportParamsBuilder iReportParamsBuilder = ((ProductDetailShopRecommendViewModel) viewModel).reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
            Utils utils = Utils.INSTANCE;
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_recommend_exp", "[ProductDetailReporter] reportRecommendExp, event cod = qstore_prd_detail_pg_recommend_exp, data = "), utils);
        }
    }
}
