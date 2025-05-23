package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailEventDataCardFrame;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewReviewDetail;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopCommentView extends ProductDetailCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailCommentViewModel");
        final ProductDetailCommentViewModel productDetailCommentViewModel = (ProductDetailCommentViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.paddingBottom(12.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailCommentViewModel productDetailCommentViewModel2 = ProductDetailCommentViewModel.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final ProductDetailCommentViewModel productDetailCommentViewModel3 = ProductDetailCommentViewModel.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                ProductDetailCommentViewModel productDetailCommentViewModel4 = ProductDetailCommentViewModel.this;
                                if (((Boolean) productDetailCommentViewModel4.canJumpToList$delegate.getValue(productDetailCommentViewModel4, ProductDetailCommentViewModel.$$delegatedProperties[0])).booleanValue()) {
                                    ProductDetailCommentViewModel.this.handleTapCard();
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopCommentView productDetailShopCommentView = this;
                final ProductDetailCommentViewModel productDetailCommentViewModel3 = ProductDetailCommentViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        ProductDetailShopCommentView productDetailShopCommentView2 = ProductDetailShopCommentView.this;
                        int i3 = ProductDetailShopCommentView.$r8$clinit;
                        productDetailShopCommentView2.getClass();
                        w.a(productDetailShopCommentView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithDivLine$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar2) {
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithDivLine$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        h hVar;
                                        t tVar2 = tVar;
                                        tVar2.mo141height(8.0f).marginLeft(0.0f).marginRight(0.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                                        tVar2.mo113backgroundColor(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ProductDetailShopCommentView productDetailShopCommentView3 = ProductDetailShopCommentView.this;
                        final ProductDetailCommentViewModel productDetailCommentViewModel4 = productDetailCommentViewModel3;
                        productDetailShopCommentView3.getClass();
                        w.a(productDetailShopCommentView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithTitleArea$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar2) {
                                v vVar3 = vVar2;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithTitleArea$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.marginTop(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithTitleArea$1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithTitleArea.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(16.0f).marginBottom(6.0f);
                                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeight500().lines(1);
                                                ceVar2.value("\u8bc4\u4ef7");
                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                ceVar2.color(hVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailCommentViewModel productDetailCommentViewModel5 = ProductDetailCommentViewModel.this;
                                cg.a(vVar3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithTitleArea$1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailCommentViewModel productDetailCommentViewModel6 = ProductDetailCommentViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithTitleArea.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.m140flex(1.0f).marginLeft(3.0f).marginBottom(3.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeight500().textAlignLeft().lines(1);
                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                ceVar2.color(hVar);
                                                ceVar2.value(ProductDetailCommentViewModel.this.commentCountText());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailCommentViewModel productDetailCommentViewModel6 = ProductDetailCommentViewModel.this;
                                ah.a(vVar3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithTitleArea$1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final ProductDetailCommentViewModel productDetailCommentViewModel7 = ProductDetailCommentViewModel.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithTitleArea.1.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.marginRight(16.0f);
                                                afVar2.size(16.0f, 16.0f);
                                                ProductDetailCommentViewModel productDetailCommentViewModel8 = ProductDetailCommentViewModel.this;
                                                afVar2.m152visibility(((Boolean) productDetailCommentViewModel8.canJumpToList$delegate.getValue(productDetailCommentViewModel8, ProductDetailCommentViewModel.$$delegatedProperties[0])).booleanValue());
                                                b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopCommentView productDetailShopCommentView4 = ProductDetailShopCommentView.this;
                        final ProductDetailCommentViewModel productDetailCommentViewModel5 = productDetailCommentViewModel3;
                        productDetailShopCommentView4.getClass();
                        int i16 = 0;
                        for (Object obj : productDetailCommentViewModel5.commentAllItems()) {
                            int i17 = i16 + 1;
                            if (i16 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final ProductReviewReviewDetail productReviewReviewDetail = (ProductReviewReviewDetail) obj;
                            if (i16 < Math.min(productDetailCommentViewModel5.commentAllItems().size(), 3)) {
                                w.a(productDetailShopCommentView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithContent$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar2) {
                                        ProductDetailShopCommentView productDetailShopCommentView5 = ProductDetailShopCommentView.this;
                                        final ProductReviewReviewDetail productReviewReviewDetail2 = productReviewReviewDetail;
                                        final ProductDetailCommentViewModel productDetailCommentViewModel6 = productDetailCommentViewModel5;
                                        productDetailShopCommentView5.getClass();
                                        w.a(productDetailShopCommentView5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithCommentItemHead$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithCommentItemHead$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f).marginLeft(16.0f).marginRight(16.0f).marginTop(13.0f);
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ProductReviewReviewDetail productReviewReviewDetail3 = ProductReviewReviewDetail.this;
                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithCommentItemHead$1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final ProductReviewReviewDetail productReviewReviewDetail4 = ProductReviewReviewDetail.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(28.0f, 28.0f).borderRadius(14.0f);
                                                                b.a.b(afVar2, ProductReviewReviewDetail.this.userIcon, false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ProductReviewReviewDetail productReviewReviewDetail4 = ProductReviewReviewDetail.this;
                                                final ProductDetailCommentViewModel productDetailCommentViewModel7 = productDetailCommentViewModel6;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithCommentItemHead$1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionColumn();
                                                                tVar2.marginLeft(8.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ProductReviewReviewDetail productReviewReviewDetail5 = ProductReviewReviewDetail.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ProductReviewReviewDetail productReviewReviewDetail6 = ProductReviewReviewDetail.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.m140flex(1.0f);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeight500().textAlignLeft().lines(1);
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                        ceVar2.color(hVar);
                                                                        ceVar2.value(ProductReviewReviewDetail.this.userNick + APLogFileUtil.SEPARATOR_LOG + ProductReviewReviewDetail.this.productSpecification);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ProductDetailCommentViewModel productDetailCommentViewModel8 = productDetailCommentViewModel7;
                                                        final ProductReviewReviewDetail productReviewReviewDetail6 = ProductReviewReviewDetail.this;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.flexDirectionRow();
                                                                        tVar2.marginTop(4.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                for (final int i18 = 1; i18 < 6; i18++) {
                                                                    final ProductDetailCommentViewModel productDetailCommentViewModel9 = ProductDetailCommentViewModel.this;
                                                                    final ProductReviewReviewDetail productReviewReviewDetail7 = productReviewReviewDetail6;
                                                                    ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.3.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final int i19 = i18;
                                                                            final ProductDetailCommentViewModel productDetailCommentViewModel10 = productDetailCommentViewModel9;
                                                                            final ProductReviewReviewDetail productReviewReviewDetail8 = productReviewReviewDetail7;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView.bodyWithCommentItemHead.1.3.3.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    String str;
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(10.0f, 10.0f);
                                                                                    afVar2.marginRight(2.0f);
                                                                                    if (i19 <= productDetailCommentViewModel10.scoreStars(productReviewReviewDetail8)) {
                                                                                        str = "qecommerce_skin_icon_evaluate_selected";
                                                                                    } else {
                                                                                        str = "qecommerce_skin_icon_evaluate_normal";
                                                                                    }
                                                                                    b.a.b(afVar2, str, false, 2, null);
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
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ProductDetailShopCommentView productDetailShopCommentView6 = ProductDetailShopCommentView.this;
                                        final ProductReviewReviewDetail productReviewReviewDetail3 = productReviewReviewDetail;
                                        final ProductDetailCommentViewModel productDetailCommentViewModel7 = productDetailCommentViewModel5;
                                        productDetailShopCommentView6.getClass();
                                        cg.a(productDetailShopCommentView6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithCommentItemContent$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailCommentViewModel productDetailCommentViewModel8 = ProductDetailCommentViewModel.this;
                                                final ProductReviewReviewDetail productReviewReviewDetail4 = productReviewReviewDetail3;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentView$bodyWithCommentItemContent$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        h hVar;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m140flex(1.0f).marginLeft(16.0f).marginRight(16.0f).marginTop(9.0f);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).textAlignLeft().lines(3);
                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                        ceVar2.color(hVar);
                                                        ceVar2.value(ProductDetailCommentViewModel.this.reviewContent(productReviewReviewDetail4));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            i16 = i17;
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void layoutFrameDidChanged(d dVar) {
        super.layoutFrameDidChanged(dVar);
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel");
        String cardFrameChangeEventName = ((IProductDetailShopCommentViewModel) viewModel).cardFrameChangeEventName();
        if (cardFrameChangeEventName == null || dVar.getY() <= 0.0f) {
            return;
        }
        ((ProductDetailEvent) getEvent()).onFireProductDetailEvent(cardFrameChangeEventName, new ProductDetailEventDataCardFrame(new d(0.0f, dVar.getY(), 0.0f, 0.0f, 12, null)));
    }
}
