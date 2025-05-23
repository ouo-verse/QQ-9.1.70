package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxCountdownView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
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
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ BlindBoxProductDetailShopPriceViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1(BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel) {
        super(1);
        this.$viewModel = blindBoxProductDetailShopPriceViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(m mVar) {
                m mVar2 = mVar;
                mVar2.size(mVar2.getPagerData().m(), 64.0f);
                mVar2.flexDirectionRow().justifyContentSpaceBetween();
                mVar2.mo135backgroundLinearGradient(Direction.TO_LEFT, new j(new h(4294914928L), 0.0f), new j(new h(4294925407L), 1.0f));
                return Unit.INSTANCE;
            }
        });
        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel = this.$viewModel;
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionColumn();
                        tVar2.marginLeft(16.0f);
                        tVar2.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel2 = BlindBoxProductDetailShopPriceViewModel.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.fontWeight500();
                                        ceVar2.lines(1);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.text("\u9884\u552e\u4ef7");
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.mo141height(17.0f);
                                        ceVar2.marginTop(26.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(24.5f);
                                        ceVar2.lines(1);
                                        ceVar2.fontWeightBold();
                                        ceVar2.fontFamily("Qvideo Digit");
                                        ce.fontSize$default(ceVar2, ceVar2.getPagerData().getIsIOS() ? 15.0f : 20.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.marginLeft(2.0f);
                                        ceVar2.text("\uffe5");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel3 = BlindBoxProductDetailShopPriceViewModel.this;
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel4 = BlindBoxProductDetailShopPriceViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.2.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(21.0f);
                                        ceVar2.fontFamily("Qvideo Digit");
                                        ceVar2.lines(1);
                                        ce.fontSize$default(ceVar2, 26.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.value(BlindBoxProductDetailShopPriceViewModel.this.priceTxt());
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
        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel2 = this.$viewModel;
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$bodyWithPreSaleMode$1.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionColumn();
                        tVar2.alignItemsFlexEnd();
                        tVar2.justifyContentCenter();
                        tVar2.marginRight(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.fontWeight500();
                                ceVar2.lines(1);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.color(h.INSTANCE.m());
                                ceVar2.mo141height(19.6f);
                                ceVar2.text("\u9884\u552e\u4e2d");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel3 = BlindBoxProductDetailShopPriceViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Long.valueOf(BlindBoxProductDetailShopPriceViewModel.this.getCountdownSec());
                    }
                };
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel4 = BlindBoxProductDetailShopPriceViewModel.this;
                BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel5 = BlindBoxProductDetailShopPriceViewModel.this;
                        bindDirectivesView.addChild(new BlindBoxCountdownView(), new Function1<BlindBoxCountdownView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BlindBoxCountdownView blindBoxCountdownView) {
                                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel6 = BlindBoxProductDetailShopPriceViewModel.this;
                                blindBoxCountdownView.attr(new Function1<BlindBoxCountdownView.BlindBoxCountDownViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithPreSaleMode.1.3.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BlindBoxCountdownView.BlindBoxCountDownViewAttr blindBoxCountDownViewAttr) {
                                        BlindBoxCountdownView.BlindBoxCountDownViewAttr blindBoxCountDownViewAttr2 = blindBoxCountDownViewAttr;
                                        blindBoxCountDownViewAttr2.marginTop(4.0f);
                                        blindBoxCountDownViewAttr2.countdownSec = BlindBoxProductDetailShopPriceViewModel.this.getCountdownSec();
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
}
