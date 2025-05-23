package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPrice;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSpuDynamic;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.RemainingTime;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
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
public final class ProductDetailPreSalePriceView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailEvent access$getEvent(ProductDetailPreSalePriceView productDetailPreSalePriceView) {
        return (ProductDetailEvent) productDetailPreSalePriceView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceViewModel");
        final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel = (ProductDetailPreSalePriceViewModel) viewModel;
        if (productDetailPreSalePriceViewModel.getIsInPreSale()) {
            productDetailPreSalePriceViewModel.countDown();
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel2 = ProductDetailPreSalePriceViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 64.0f);
                                tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                a.C5863a.a(tVar2, 0.0f, 16.0f, 9.0f, 16.0f, 1, null);
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel3 = ProductDetailPreSalePriceViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(32.0f);
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.value("\u9884\u552e\u4ef7");
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.lineHeight(17.0f);
                                                ceVar2.fontFamily("PingFang SC");
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.marginTop(15.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.value("\u00a5");
                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                ceVar2.fontWeight700();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.fontFamily("Qvideo Digit");
                                                c.a.a(ceVar2, 0.0f, 4.0f, 1.0f, 0.0f, 9, null);
                                                ceVar2.marginTop(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel4 = ProductDetailPreSalePriceViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel5 = ProductDetailPreSalePriceViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ProductDetailProductCardRsp productDetailProductCardRsp;
                                                ProductDetailProduct productDetailProduct;
                                                ProductDetailPrice productDetailPrice;
                                                ce ceVar2 = ceVar;
                                                ProductDetailInfo productDetailInfo = ProductDetailPreSalePriceViewModel.this.info;
                                                if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null || (str = productDetailPrice.priceTxt) == null) {
                                                    str = "";
                                                }
                                                ceVar2.value(str);
                                                ce.fontSize$default(ceVar2, 26.0f, null, 2, null);
                                                ceVar2.fontWeight700();
                                                ceVar2.fontFamily("Qvideo Digit");
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.marginTop(9.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.2.6.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.value("\u9884\u552e\u4e2d");
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.lineHeight(19.6f);
                                                ceVar2.alignSelfFlexEnd();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.fontFamily("PingFang SC");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel4 = ProductDetailPreSalePriceViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(20.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(6.0f);
                                        tVar2.justifyContentFlexEnd();
                                        tVar2.alignItemsFlexEnd();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel5 = ProductDetailPreSalePriceViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel6 = ProductDetailPreSalePriceViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ProductDetailProductCardRsp productDetailProductCardRsp;
                                                ProductDetailProduct productDetailProduct;
                                                ProductDetailSpuDynamic productDetailSpuDynamic;
                                                ce ceVar2 = ceVar;
                                                ProductDetailInfo productDetailInfo = ProductDetailPreSalePriceViewModel.this.info;
                                                if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailSpuDynamic = productDetailProduct.dynamic) == null || (str = productDetailSpuDynamic.sales) == null) {
                                                    str = "";
                                                }
                                                ceVar2.value(str);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                ceVar2.fontFamily("Qvideo Digit");
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.marginBottom(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel6 = ProductDetailPreSalePriceViewModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel7 = ProductDetailPreSalePriceViewModel.this;
                                        return (RemainingTime) productDetailPreSalePriceViewModel7.remainingTime$delegate.getValue(productDetailPreSalePriceViewModel7, ProductDetailPreSalePriceViewModel.$$delegatedProperties[0]);
                                    }
                                };
                                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel7 = ProductDetailPreSalePriceViewModel.this;
                                BindDirectivesViewKt.a(vVar4, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel8 = ProductDetailPreSalePriceViewModel.this;
                                        bindDirectivesView.addChild(new TimerCountDownView(), new Function1<TimerCountDownView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TimerCountDownView timerCountDownView) {
                                                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel9 = ProductDetailPreSalePriceViewModel.this;
                                                timerCountDownView.attr(new Function1<TimerCountDownAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView.body.1.2.3.5.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TimerCountDownAttr timerCountDownAttr) {
                                                        TimerCountDownAttr timerCountDownAttr2 = timerCountDownAttr;
                                                        ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel10 = ProductDetailPreSalePriceViewModel.this;
                                                        timerCountDownAttr2.remainingTime$delegate.setValue(timerCountDownAttr2, TimerCountDownAttr.$$delegatedProperties[0], (RemainingTime) productDetailPreSalePriceViewModel10.remainingTime$delegate.getValue(productDetailPreSalePriceViewModel10, ProductDetailPreSalePriceViewModel.$$delegatedProperties[0]));
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
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel3 = ProductDetailPreSalePriceViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProductDetailPreSalePriceViewModel.this.getSendCountDownEndEvent();
                    }
                };
                final ProductDetailPreSalePriceViewModel productDetailPreSalePriceViewModel4 = ProductDetailPreSalePriceViewModel.this;
                final ProductDetailPreSalePriceView productDetailPreSalePriceView = this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        if (ProductDetailPreSalePriceViewModel.this.getSendCountDownEndEvent() != null) {
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("sendCountDownEndEvent == ");
                            m3.append(ProductDetailPreSalePriceViewModel.this.getSendCountDownEndEvent());
                            kLog.i("sendCountDownEndEvent", m3.toString());
                            ProductDetailPreSalePriceView.access$getEvent(productDetailPreSalePriceView).onFireProductDetailEvent("refresh_detail_page", null);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
