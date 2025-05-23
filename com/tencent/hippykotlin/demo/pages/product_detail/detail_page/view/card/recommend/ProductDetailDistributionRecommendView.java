package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
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
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRecommendView extends ProductDetailCardView {
    public final float cardWidth = (c.f117352a.g().getPageData().m() - 43.0f) / 2;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bottomView(ProductDetailDistributionRecommendView productDetailDistributionRecommendView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailDistributionRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel");
        return new ProductDetailDistributionRecommendView$bottomView$1((ProductDetailDistributionRecommendViewModel) viewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$couponRowView(ProductDetailDistributionRecommendView productDetailDistributionRecommendView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailDistributionRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel");
        return new ProductDetailDistributionRecommendView$couponRowView$1((ProductDetailDistributionRecommendViewModel) viewModel, productDetailDistributionRecommendView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$couponView(ProductDetailDistributionRecommendView productDetailDistributionRecommendView, final ProductDetailLabelInfo productDetailLabelInfo) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailDistributionRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel");
        if (((ProductDetailDistributionRecommendViewModel) viewModel).couponList().length == 0) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$couponView$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$couponView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ProductDetailLabelInfo productDetailLabelInfo2 = ProductDetailLabelInfo.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$couponView$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailLabelInfo productDetailLabelInfo3 = ProductDetailLabelInfo.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.mo141height(16.0f);
                                tVar2.borderRadius(2.0f);
                                tVar2.allCenter();
                                BorderStyle borderStyle = BorderStyle.SOLID;
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor(ProductDetailLabelInfo.this.borderColor, false);
                                tVar2.m136border(new e(0.5f, borderStyle, hVar));
                                tVar2.padding(2.5f, 6.0f, 2.5f, 6.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                tVar2.marginRight(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        if (ProductDetailLabelInfo.this.textPrefix.length() > 0) {
                            final ProductDetailLabelInfo productDetailLabelInfo4 = ProductDetailLabelInfo.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final ProductDetailLabelInfo productDetailLabelInfo5 = ProductDetailLabelInfo.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            h hVar;
                                            ce ceVar2 = ceVar;
                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                            ceVar2.fontFamily("PingFang SC");
                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor(ProductDetailLabelInfo.this.textColor, false);
                                            ceVar2.color(hVar);
                                            ceVar2.text(ProductDetailLabelInfo.this.textPrefix);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final ProductDetailLabelInfo productDetailLabelInfo5 = ProductDetailLabelInfo.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    final ProductDetailLabelInfo productDetailLabelInfo6 = ProductDetailLabelInfo.this;
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            h hVar;
                                            t tVar2 = tVar;
                                            tVar2.size(0.5f, 9.0f);
                                            tVar2.marginLeft(4.0f);
                                            tVar2.marginRight(4.0f);
                                            hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor(ProductDetailLabelInfo.this.borderColor, false);
                                            tVar2.mo113backgroundColor(hVar);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final ProductDetailLabelInfo productDetailLabelInfo6 = ProductDetailLabelInfo.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailLabelInfo productDetailLabelInfo7 = ProductDetailLabelInfo.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponView.2.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor(ProductDetailLabelInfo.this.textColor, false);
                                        ceVar2.color(hVar);
                                        ceVar2.text(ProductDetailLabelInfo.this.text);
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$priceRow(ProductDetailDistributionRecommendView productDetailDistributionRecommendView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailDistributionRecommendView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel");
        return new ProductDetailDistributionRecommendView$priceRow$1((ProductDetailDistributionRecommendViewModel) viewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel");
        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel = (ProductDetailDistributionRecommendViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ProductDetailDistributionRecommendView productDetailDistributionRecommendView = ProductDetailDistributionRecommendView.this;
                final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel2 = productDetailDistributionRecommendViewModel;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailDistributionRecommendView productDetailDistributionRecommendView2 = ProductDetailDistributionRecommendView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.mo153width(ProductDetailDistributionRecommendView.this.cardWidth);
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
                        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel3 = productDetailDistributionRecommendViewModel2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel4 = ProductDetailDistributionRecommendViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel5 = ProductDetailDistributionRecommendViewModel.this;
                                        IReportParamsBuilder iReportParamsBuilder = productDetailDistributionRecommendViewModel5.reportParams;
                                        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
                                        if (eCDetailPageReportParamsBuilder != null) {
                                            eCDetailPageReportParamsBuilder.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
                                            Utils utils = Utils.INSTANCE;
                                            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_recommend_ck", "[ProductDetailReporter] reportRecommendClk, event cod = qstore_prd_detail_pg_recommend_ck, data = "), utils);
                                        }
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://ecommerce/open?target=52&page_name=product_detail&&src_type=internal&version=1&biz_type=1&channel=2&goods_type=101&is_distributor=1&is_select=0&shop_id=135581001236873219&source_from=5&spu_id=");
                                        m3.append(productDetailDistributionRecommendViewModel5.info.spu_id);
                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), m3.toString(), false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailDistributionRecommendView productDetailDistributionRecommendView3 = ProductDetailDistributionRecommendView.this;
                        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel4 = productDetailDistributionRecommendViewModel2;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final ProductDetailDistributionRecommendView productDetailDistributionRecommendView4 = ProductDetailDistributionRecommendView.this;
                                final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel5 = productDetailDistributionRecommendViewModel4;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        float f16 = ProductDetailDistributionRecommendView.this.cardWidth;
                                        afVar2.size(f16, f16);
                                        afVar2.marginBottom(8.0f);
                                        ImageAttrExtKt.srcUrl(afVar2, productDetailDistributionRecommendViewModel5.info.cover, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel5 = productDetailDistributionRecommendViewModel2;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel6 = ProductDetailDistributionRecommendViewModel.this;
                                richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        h hVar;
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.marginLeft(8.0f);
                                        richTextAttr2.marginRight(8.0f);
                                        richTextAttr2.text(ProductDetailDistributionRecommendViewModel.this.info.title);
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
                        ((ProductDetailDistributionRecommendView$priceRow$1) ProductDetailDistributionRecommendView.access$priceRow(ProductDetailDistributionRecommendView.this)).invoke(vVar2);
                        ((ProductDetailDistributionRecommendView$couponRowView$1) ProductDetailDistributionRecommendView.access$couponRowView(ProductDetailDistributionRecommendView.this)).invoke(vVar2);
                        ((ProductDetailDistributionRecommendView$bottomView$1) ProductDetailDistributionRecommendView.access$bottomView(ProductDetailDistributionRecommendView.this)).invoke(vVar2);
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
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel");
        IReportParamsBuilder iReportParamsBuilder = ((ProductDetailDistributionRecommendViewModel) viewModel).reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
            Utils utils = Utils.INSTANCE;
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_recommend_exp", "[ProductDetailReporter] reportRecommendExp, event cod = qstore_prd_detail_pg_recommend_exp, data = "), utils);
        }
    }
}
