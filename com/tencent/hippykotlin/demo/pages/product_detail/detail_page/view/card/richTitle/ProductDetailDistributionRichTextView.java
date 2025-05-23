package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
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
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRichTextView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTitleViewModel");
        final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel = (ProductDetailDistributionRichTitleViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.paddingRight(40.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel2 = ProductDetailDistributionRichTitleViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.margin(6.0f, 16.0f, 12.0f, 16.0f);
                                tVar2.alignSelfFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel3 = ProductDetailDistributionRichTitleViewModel.this;
                        vVar2.addChild(new ProductDetailLabelView(), new Function1<ProductDetailLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ProductDetailLabelView productDetailLabelView) {
                                ProductDetailLabelView productDetailLabelView2 = productDetailLabelView;
                                final Ref.ObjectRef<aa<ProductDetailLabelView>> objectRef2 = objectRef;
                                productDetailLabelView2.ref(productDetailLabelView2, new Function1<aa<ProductDetailLabelView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.tencent.kuikly.core.base.aa] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<ProductDetailLabelView> aaVar) {
                                        objectRef2.element = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel4 = productDetailDistributionRichTitleViewModel3;
                                productDetailLabelView2.attr(new Function1<ProductDetailLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ProductDetailLabelAttr productDetailLabelAttr) {
                                        ArrayList<ProductDetailLabelInfo> arrayList;
                                        SellerProductCardRsp sellerProductCardRsp;
                                        ProductDetailLabelAttr productDetailLabelAttr2 = productDetailLabelAttr;
                                        ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailDistributionRichTitleViewModel.this.info;
                                        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (arrayList = sellerProductCardRsp.labels) == null) {
                                            arrayList = new ArrayList<>();
                                        }
                                        productDetailLabelAttr2.labels = arrayList;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel4 = ProductDetailDistributionRichTitleViewModel.this;
                        final float f16 = 56.0f;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                final float f17 = f16;
                                final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel5 = productDetailDistributionRichTitleViewModel4;
                                final Ref.ObjectRef<aa<ProductDetailLabelView>> objectRef2 = objectRef;
                                richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        String str;
                                        h hVar;
                                        ProductDetailLabelView b16;
                                        SellerProductCardRsp sellerProductCardRsp;
                                        Product product;
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.mo153width(((richTextAttr2.getPagerData().m() - f17) - 16.0f) - 16.0f);
                                        ce.fontSize$default(richTextAttr2, 15.0f, null, 2, null).fontWeight500().lines(2);
                                        ProductDetailDistributionInfo productDetailDistributionInfo = productDetailDistributionRichTitleViewModel5.info;
                                        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (str = product.title) == null) {
                                            str = "";
                                        }
                                        richTextAttr2.value(str);
                                        ce.fontSize$default(richTextAttr2, 16.0f, null, 2, null);
                                        richTextAttr2.lineHeight(20.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(richTextAttr2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        richTextAttr2.color(hVar);
                                        aa<ProductDetailLabelView> aaVar = objectRef2.element;
                                        richTextAttr2.firstLineHeadIndent((aaVar == null || (b16 = aaVar.b()) == null) ? 0.0f : b16.getHeadLabelIndent());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel3 = ProductDetailDistributionRichTitleViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f16 = 56.0f;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexEnd();
                                tVar2.size(f16, 23.0f);
                                Attr.absolutePosition$default(tVar2, 2.0f, 0.0f, 0.0f, 0.0f, 6, null);
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                                tVar2.mo113backgroundColor(hVar);
                                tVar2.m137borderRadius(new f(11.5f, 0.0f, 11.5f, 0.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel4 = ProductDetailDistributionRichTitleViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final ProductDetailDistributionRichTitleViewModel productDetailDistributionRichTitleViewModel5 = ProductDetailDistributionRichTitleViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        SellerProductCardRsp sellerProductCardRsp;
                                        String str;
                                        ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailDistributionRichTitleViewModel.this.info;
                                        if (productDetailDistributionInfo != null && (sellerProductCardRsp = productDetailDistributionInfo.detail) != null && (str = sellerProductCardRsp.url) != null) {
                                            BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), str, false, null, null, 30);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u8be6\u60c5");
                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_secondary", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTextView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(14.0f, 14.0f);
                                        afVar2.marginRight(12.0f);
                                        ImageAttrExtKt.srcUrl(afVar2, "qecommerce_skin_icon_general_arrow_right_light", null);
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
