package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.module.CalendarModule;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductTradeInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailShopPriceView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithPreSaleMode(BlindBoxProductDetailShopPriceView blindBoxProductDetailShopPriceView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) blindBoxProductDetailShopPriceView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceViewModel");
        return new BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1((BlindBoxProductDetailShopPriceViewModel) viewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithSpotGoodsMode(BlindBoxProductDetailShopPriceView blindBoxProductDetailShopPriceView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) blindBoxProductDetailShopPriceView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceViewModel");
        return new BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1((BlindBoxProductDetailShopPriceViewModel) viewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceViewModel");
        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel = (BlindBoxProductDetailShopPriceViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel2 = BlindBoxProductDetailShopPriceViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BlindBoxProductDetailShopPriceViewModel.this.getShouldShowCountDown());
                    }
                };
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel3 = BlindBoxProductDetailShopPriceViewModel.this;
                final BlindBoxProductDetailShopPriceView blindBoxProductDetailShopPriceView = this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel4 = BlindBoxProductDetailShopPriceViewModel.this;
                        final BlindBoxProductDetailShopPriceView blindBoxProductDetailShopPriceView2 = blindBoxProductDetailShopPriceView;
                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                if (BlindBoxProductDetailShopPriceViewModel.this.getShouldShowCountDown()) {
                                    ((BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1) BlindBoxProductDetailShopPriceView.access$bodyWithPreSaleMode(blindBoxProductDetailShopPriceView2)).invoke(vVar2);
                                } else {
                                    ((BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1) BlindBoxProductDetailShopPriceView.access$bodyWithSpotGoodsMode(blindBoxProductDetailShopPriceView2)).invoke(vVar2);
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

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        tick();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r0.getCountdownSec() > 0) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void tick() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceViewModel");
        BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel = (BlindBoxProductDetailShopPriceViewModel) viewModel;
        CalendarModule calendarModule = IPagerIdKtxKt.getCalendarModule(this);
        int i3 = CalendarModule.$r8$clinit;
        long timeInMillis = ((CalendarModule.Calendar) calendarModule.newCalendarInstance(0L)).timeInMillis() / 1000;
        ProductDetailInfo productDetailInfo = blindBoxProductDetailShopPriceViewModel.info;
        ProductDetailProductTradeInfo productDetailProductTradeInfo = (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null) ? null : productDetailProduct.tradeInfo;
        long j3 = productDetailProductTradeInfo != null ? productDetailProductTradeInfo.presaleEndTime - timeInMillis : 0L;
        ReadWriteProperty readWriteProperty = blindBoxProductDetailShopPriceViewModel.countdownSec$delegate;
        KProperty<?>[] kPropertyArr = BlindBoxProductDetailShopPriceViewModel.$$delegatedProperties;
        boolean z16 = true;
        readWriteProperty.setValue(blindBoxProductDetailShopPriceViewModel, kPropertyArr[1], Long.valueOf(j3));
        if (productDetailProductTradeInfo != null && productDetailProductTradeInfo.deliveryMode == 1) {
            if (productDetailProductTradeInfo != null && productDetailProductTradeInfo.hasEndTime == 1) {
            }
        }
        z16 = false;
        blindBoxProductDetailShopPriceViewModel.shouldShowCountDown$delegate.setValue(blindBoxProductDetailShopPriceViewModel, kPropertyArr[0], Boolean.valueOf(z16));
        if (blindBoxProductDetailShopPriceViewModel.getShouldShowCountDown()) {
            TimerKt.e(getPagerId(), 1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$tick$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    BlindBoxProductDetailShopPriceView.this.tick();
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
