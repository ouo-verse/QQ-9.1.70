package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActivePrice;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveSales;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveStock;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailDetailSelling;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.RemainingTime;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailLivePriceView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceViewModel");
        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel = (ProductDetailLivePriceViewModel) viewModel;
        productDetailLivePriceViewModel.countDown();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel2 = ProductDetailLivePriceViewModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 64.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                Direction direction = Direction.TO_RIGHT;
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                tVar2.mo135backgroundLinearGradient(direction, new j(new h(4294925407L), 0.0f), new j(hVar, 1.0f));
                                a.C5863a.a(tVar2, 8.0f, 16.0f, 0.0f, 16.0f, 4, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel3 = ProductDetailLivePriceViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.mo141height(64.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel4 = ProductDetailLivePriceViewModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentFlexStart();
                                                tVar2.marginBottom(2.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel5 = ProductDetailLivePriceViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel6 = ProductDetailLivePriceViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                                        ProductDetailActiveInfo productDetailActiveInfo;
                                                        ProductDetailDetailSelling productDetailDetailSelling;
                                                        ce ceVar2 = ceVar;
                                                        ProductDetailInfo productDetailInfo = ProductDetailLivePriceViewModel.this.info;
                                                        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null || (productDetailDetailSelling = productDetailActiveInfo.detailSelling) == null || (str = productDetailDetailSelling.label) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u00a5");
                                                        ceVar2.fontFamily("Qvideo Digit");
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ceVar2.marginTop(3.0f);
                                                        ceVar2.marginLeft(4.0f);
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel6 = ProductDetailLivePriceViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                                        ProductDetailActiveInfo productDetailActiveInfo;
                                                        ProductDetailActivePrice productDetailActivePrice;
                                                        ce ceVar2 = ceVar;
                                                        ProductDetailInfo productDetailInfo = ProductDetailLivePriceViewModel.this.info;
                                                        ceVar2.text(String.valueOf((productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null || (productDetailActivePrice = productDetailActiveInfo.livePrice) == null) ? null : Float.valueOf(((float) productDetailActivePrice.liveSpecial) / 100.0f)));
                                                        ceVar2.fontFamily("Qvideo Digit");
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ce.fontSize$default(ceVar2, 26.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel8 = ProductDetailLivePriceViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.2.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                                        ProductDetailActiveInfo productDetailActiveInfo;
                                                        ProductDetailActivePrice productDetailActivePrice;
                                                        ce ceVar2 = ceVar;
                                                        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u00a5');
                                                        ProductDetailInfo productDetailInfo = ProductDetailLivePriceViewModel.this.info;
                                                        m3.append(String.valueOf((productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null || (productDetailActivePrice = productDetailActiveInfo.livePrice) == null) ? null : Long.valueOf(productDetailActivePrice.original)));
                                                        ceVar2.text(m3.toString());
                                                        ceVar2.textDecorationLineThrough();
                                                        ceVar2.marginLeft(4.0f);
                                                        ceVar2.fontFamily("Qvideo Digit");
                                                        ceVar2.marginTop(3.0f);
                                                        ceVar2.color(new h(2365587455L));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel5 = ProductDetailLivePriceViewModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentFlexStart();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("");
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel6 = ProductDetailLivePriceViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.2.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                                        ProductDetailActiveInfo productDetailActiveInfo;
                                                        ProductDetailActiveSales productDetailActiveSales;
                                                        ce ceVar2 = ceVar;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u9500\u91cf ");
                                                        ProductDetailInfo productDetailInfo = ProductDetailLivePriceViewModel.this.info;
                                                        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null || (productDetailActiveSales = productDetailActiveInfo.liveSales) == null || (str = productDetailActiveSales.salesNumsTxt) == null) {
                                                            str = "";
                                                        }
                                                        m3.append(str);
                                                        ceVar2.text(m3.toString());
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
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
                        });
                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel4 = ProductDetailLivePriceViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                ProductDetailProductCardRsp productDetailProductCardRsp;
                                ProductDetailActiveInfo productDetailActiveInfo;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignItemsFlexEnd();
                                        tVar2.mo141height(64.0f);
                                        tVar2.marginTop(3.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel5 = ProductDetailLivePriceViewModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.justifyContentFlexStart();
                                                tVar2.flexDirectionRow();
                                                tVar2.marginBottom(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel6 = ProductDetailLivePriceViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ProductDetailProductCardRsp productDetailProductCardRsp2;
                                                        ProductDetailActiveInfo productDetailActiveInfo2;
                                                        ProductDetailDetailSelling productDetailDetailSelling;
                                                        ce ceVar2 = ceVar;
                                                        ProductDetailInfo productDetailInfo = ProductDetailLivePriceViewModel.this.info;
                                                        if (productDetailInfo == null || (productDetailProductCardRsp2 = productDetailInfo.detail) == null || (productDetailActiveInfo2 = productDetailProductCardRsp2.activeInfo) == null || (productDetailDetailSelling = productDetailActiveInfo2.detailSelling) == null || (str = productDetailDetailSelling.hotIcon) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        ceVar2.fontWeightBold();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.marginRight(4.0f);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel8 = ProductDetailLivePriceViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ProductDetailProductCardRsp productDetailProductCardRsp2;
                                                        ProductDetailActiveInfo productDetailActiveInfo2;
                                                        ProductDetailActiveStock productDetailActiveStock;
                                                        ce ceVar2 = ceVar;
                                                        ProductDetailLivePriceViewModel productDetailLivePriceViewModel9 = ProductDetailLivePriceViewModel.this;
                                                        productDetailLivePriceViewModel9.getClass();
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("\u8fd8\u5269");
                                                        ProductDetailInfo productDetailInfo = productDetailLivePriceViewModel9.info;
                                                        sb5.append((productDetailInfo == null || (productDetailProductCardRsp2 = productDetailInfo.detail) == null || (productDetailActiveInfo2 = productDetailProductCardRsp2.activeInfo) == null || (productDetailActiveStock = productDetailActiveInfo2.liveStock) == null) ? null : productDetailActiveStock.remainTxt);
                                                        sb5.append('\u4ef6');
                                                        ceVar2.text(sb5.toString());
                                                        ceVar2.fontWeightBold();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailLivePriceViewModel productDetailLivePriceViewModel6 = ProductDetailLivePriceViewModel.this;
                                ProductDetailInfo productDetailInfo = productDetailLivePriceViewModel6.info;
                                if (((productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null) ? 0 : productDetailActiveInfo.activeDetailStatus) == 1) {
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u6d3b\u52a8\u672a\u5f00\u59cb");
                                                    ceVar2.marginTop(4.0f);
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.color(h.INSTANCE.m());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                            return (RemainingTime) productDetailLivePriceViewModel7.remainingTime$delegate.getValue(productDetailLivePriceViewModel7, ProductDetailLivePriceViewModel.$$delegatedProperties[0]);
                                        }
                                    };
                                    final ProductDetailLivePriceViewModel productDetailLivePriceViewModel7 = ProductDetailLivePriceViewModel.this;
                                    BindDirectivesViewKt.a(vVar4, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                            final ProductDetailLivePriceViewModel productDetailLivePriceViewModel8 = ProductDetailLivePriceViewModel.this;
                                            bindDirectivesView.addChild(new TimerCountDownView(), new Function1<TimerCountDownView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.5.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TimerCountDownView timerCountDownView) {
                                                    final ProductDetailLivePriceViewModel productDetailLivePriceViewModel9 = ProductDetailLivePriceViewModel.this;
                                                    timerCountDownView.attr(new Function1<TimerCountDownAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceView.body.1.1.3.5.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TimerCountDownAttr timerCountDownAttr) {
                                                            TimerCountDownAttr timerCountDownAttr2 = timerCountDownAttr;
                                                            ProductDetailLivePriceViewModel productDetailLivePriceViewModel10 = ProductDetailLivePriceViewModel.this;
                                                            timerCountDownAttr2.remainingTime$delegate.setValue(timerCountDownAttr2, TimerCountDownAttr.$$delegatedProperties[0], (RemainingTime) productDetailLivePriceViewModel10.remainingTime$delegate.getValue(productDetailLivePriceViewModel10, ProductDetailLivePriceViewModel.$$delegatedProperties[0]));
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
