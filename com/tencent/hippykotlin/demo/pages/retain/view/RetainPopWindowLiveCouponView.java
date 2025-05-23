package com.tencent.hippykotlin.demo.pages.retain.view;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowCardAttr;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowViewUtils$ButtonInfo;
import com.tencent.hippykotlin.demo.pages.retain.model.CouponLabelInfo;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowLiveViewModel;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponShowDiscount;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
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
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class RetainPopWindowLiveCouponView extends ComposeView<RetainPopWindowCardAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final Function1 access$timeCubeView(RetainPopWindowLiveCouponView retainPopWindowLiveCouponView, String str) {
        retainPopWindowLiveCouponView.getClass();
        return new RetainPopWindowLiveCouponView$timeCubeView$1(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IRetainPopWindowViewModel iRetainPopWindowViewModel = ((RetainPopWindowCardAttr) getAttr()).viewModel;
        if (iRetainPopWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iRetainPopWindowViewModel = null;
        }
        Intrinsics.checkNotNull(iRetainPopWindowViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowLiveViewModel");
        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel = (IRetainPopWindowLiveViewModel) iRetainPopWindowViewModel;
        final float l3 = (getPagerData().l() - 262.0f) / 2.0f;
        final float m3 = (getPagerData().m() - 297.0f) / 2.0f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(new h(2147483648L));
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        return Unit.INSTANCE;
                    }
                });
                final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView = RetainPopWindowLiveCouponView.this;
                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel2 = iRetainPopWindowLiveViewModel;
                final float f16 = l3;
                final float f17 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f18 = f16;
                        final float f19 = f17;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, f18, f19, 0.0f, 0.0f, 12, null);
                                tVar2.mo153width(297.0f);
                                tVar2.justifyContentFlexStart();
                                tVar2.flexDirectionColumn();
                                tVar2.alignItemsCenter();
                                tVar2.borderRadius(8.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        RetainPopWindowLiveCouponView retainPopWindowLiveCouponView2 = RetainPopWindowLiveCouponView.this;
                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel3 = iRetainPopWindowLiveViewModel2;
                        int i3 = RetainPopWindowLiveCouponView.$r8$clinit;
                        retainPopWindowLiveCouponView2.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$titleView$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel4 = IRetainPopWindowLiveViewModel.this;
                                cg.a(viewContainer3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$titleView$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel5 = IRetainPopWindowLiveViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.titleView.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(24.0f);
                                                ceVar2.marginLeft(24.0f);
                                                ceVar2.marginRight(24.0f);
                                                ceVar2.text(IRetainPopWindowLiveViewModel.this.title());
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.lineHeight(24.0f);
                                                ceVar2.fontWeightBold();
                                                ceVar2.textAlignCenter();
                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                ceVar2.color(hVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView3 = RetainPopWindowLiveCouponView.this;
                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel4 = iRetainPopWindowLiveViewModel2;
                        retainPopWindowLiveCouponView3.getClass();
                        iRetainPopWindowLiveViewModel4.updateTimeInfo();
                        iRetainPopWindowLiveViewModel4.countDown();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$countDownView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel5 = IRetainPopWindowLiveViewModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$countDownView$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(IRetainPopWindowLiveViewModel.this.shouldShowCountDown());
                                    }
                                };
                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel6 = IRetainPopWindowLiveViewModel.this;
                                final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView4 = retainPopWindowLiveCouponView3;
                                ConditionViewKt.c(viewContainer3, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$countDownView$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel7 = IRetainPopWindowLiveViewModel.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Long.valueOf(IRetainPopWindowLiveViewModel.this.getCountDownSecond());
                                            }
                                        };
                                        final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView5 = retainPopWindowLiveCouponView4;
                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel8 = IRetainPopWindowLiveViewModel.this;
                                        BindDirectivesViewKt.a(conditionView, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView6 = RetainPopWindowLiveCouponView.this;
                                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel9 = iRetainPopWindowLiveViewModel8;
                                                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(12.0f);
                                                                tVar2.marginBottom(8.0f);
                                                                tVar2.flexDirectionRow();
                                                                tVar2.justifyContentFlexStart();
                                                                tVar2.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u76f4\u64ad\u6d3b\u52a8\u8fd8\u5269");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ((RetainPopWindowLiveCouponView$timeCubeView$1) RetainPopWindowLiveCouponView.access$timeCubeView(RetainPopWindowLiveCouponView.this, iRetainPopWindowLiveViewModel9.getCountDownStrArray().get(0))).invoke(vVar4);
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u5929");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ((RetainPopWindowLiveCouponView$timeCubeView$1) RetainPopWindowLiveCouponView.access$timeCubeView(RetainPopWindowLiveCouponView.this, iRetainPopWindowLiveViewModel9.getCountDownStrArray().get(1))).invoke(vVar4);
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(":");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ((RetainPopWindowLiveCouponView$timeCubeView$1) RetainPopWindowLiveCouponView.access$timeCubeView(RetainPopWindowLiveCouponView.this, iRetainPopWindowLiveViewModel9.getCountDownStrArray().get(2))).invoke(vVar4);
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.5
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.countDownView.1.2.2.1.5.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(":");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ((RetainPopWindowLiveCouponView$timeCubeView$1) RetainPopWindowLiveCouponView.access$timeCubeView(RetainPopWindowLiveCouponView.this, iRetainPopWindowLiveViewModel9.getCountDownStrArray().get(3))).invoke(vVar4);
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
                        final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView4 = RetainPopWindowLiveCouponView.this;
                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel5 = iRetainPopWindowLiveViewModel2;
                        retainPopWindowLiveCouponView4.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$labelRowView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                if (!IRetainPopWindowLiveViewModel.this.liveActiveList().isEmpty()) {
                                    final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel6 = IRetainPopWindowLiveViewModel.this;
                                    final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView5 = retainPopWindowLiveCouponView4;
                                    w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$labelRowView$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.labelRowView.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.justifyContentFlexStart();
                                                    tVar2.marginBottom(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ArrayList<CouponLabelInfo> couponList = IRetainPopWindowLiveViewModel.this.couponList();
                                            RetainPopWindowLiveCouponView retainPopWindowLiveCouponView6 = retainPopWindowLiveCouponView5;
                                            for (final CouponLabelInfo couponLabelInfo : couponList) {
                                                int i16 = RetainPopWindowLiveCouponView.$r8$clinit;
                                                retainPopWindowLiveCouponView6.getClass();
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$labelView$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer5) {
                                                        final CouponLabelInfo couponLabelInfo2 = CouponLabelInfo.this;
                                                        w.a(viewContainer5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$labelView$1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.labelView.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        h hVar;
                                                                        t tVar2 = tVar;
                                                                        tVar2.borderRadius(0.5f);
                                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_tag_primary", false);
                                                                        tVar2.m136border(new e(0.5f, BorderStyle.SOLID, hVar));
                                                                        tVar2.marginRight(4.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final CouponLabelInfo couponLabelInfo3 = CouponLabelInfo.this;
                                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.labelView.1.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final CouponLabelInfo couponLabelInfo4 = CouponLabelInfo.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.labelView.1.1.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                h hVar;
                                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
                                                                                ShopCouponShowDiscount shopCouponShowDiscount;
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.margin(2.5f, 4.0f, 2.5f, 4.0f);
                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                                ceVar2.color(hVar);
                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                sb5.append("\u5238 | ");
                                                                                ShopCouponCouponShowInfo shopCouponCouponShowInfo = CouponLabelInfo.this.couponShowInfo;
                                                                                sb5.append((shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo.couponShowDiscount) == null) ? null : shopCouponShowDiscount.discountThreshold);
                                                                                ceVar2.text(sb5.toString());
                                                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
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
                                                }.invoke(vVar4);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView5 = RetainPopWindowLiveCouponView.this;
                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel6 = iRetainPopWindowLiveViewModel2;
                        retainPopWindowLiveCouponView5.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$priceView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView6 = RetainPopWindowLiveCouponView.this;
                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel7 = iRetainPopWindowLiveViewModel6;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$priceView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.priceView.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                h hVar2;
                                                t tVar2 = tVar;
                                                tVar2.borderRadius(8.0f);
                                                tVar2.size(249.0f, 92.0f);
                                                Direction direction = Direction.TO_BOTTOM;
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_tag_secondary", false);
                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                tVar2.flexDirectionColumn();
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentFlexStart();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        RetainPopWindowLiveCouponView retainPopWindowLiveCouponView7 = RetainPopWindowLiveCouponView.this;
                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel8 = iRetainPopWindowLiveViewModel7;
                                        int i16 = RetainPopWindowLiveCouponView.$r8$clinit;
                                        retainPopWindowLiveCouponView7.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$livePriceView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel9 = IRetainPopWindowLiveViewModel.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$livePriceView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.justifyContentFlexStart();
                                                                tVar2.marginTop(16.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u76f4\u64ad\u4ef7");
                                                                        ceVar2.marginTop(10.0f);
                                                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_red_brand", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u00a5");
                                                                        ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                        ceVar2.marginTop(10.0f);
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        ceVar2.fontWeightBold();
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel10 = IRetainPopWindowLiveViewModel.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel11 = IRetainPopWindowLiveViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.livePriceView.1.1.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(IRetainPopWindowLiveViewModel.this.livePrice());
                                                                        ce.fontSize$default(ceVar2, 32.0f, null, 2, null);
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        ceVar2.fontWeightBold();
                                                                        ceVar2.marginTop(1.0f);
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
                                        }.invoke(vVar4);
                                        RetainPopWindowLiveCouponView retainPopWindowLiveCouponView8 = RetainPopWindowLiveCouponView.this;
                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel9 = iRetainPopWindowLiveViewModel7;
                                        retainPopWindowLiveCouponView8.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$oriPriceView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel10 = IRetainPopWindowLiveViewModel.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$oriPriceView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(14.0f);
                                                                tVar2.flexDirectionRow();
                                                                tVar2.justifyContentFlexStart();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                                                        ceVar2.color(hVar);
                                                                        ceVar2.text("\u539f\u4ef7");
                                                                        ceVar2.fontWeightBold();
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u00a5");
                                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                        ceVar2.marginTop(2.0f);
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        ceVar2.fontWeightBold();
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                                                        ceVar2.color(hVar);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel11 = IRetainPopWindowLiveViewModel.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel12 = IRetainPopWindowLiveViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.oriPriceView.1.1.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                                                        ceVar2.color(hVar);
                                                                        ceVar2.text(IRetainPopWindowLiveViewModel.this.oriPrice());
                                                                        ceVar2.textDecorationLineThrough();
                                                                        ceVar2.fontWeightBold();
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                        ceVar2.marginTop(1.5f);
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
                                        }.invoke(vVar4);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView6 = RetainPopWindowLiveCouponView.this;
                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel7 = iRetainPopWindowLiveViewModel2;
                        retainPopWindowLiveCouponView6.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$buttonRowView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final RetainPopWindowLiveCouponView retainPopWindowLiveCouponView7 = RetainPopWindowLiveCouponView.this;
                                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel8 = iRetainPopWindowLiveViewModel7;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$buttonRowView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        h hVar;
                                        h hVar2;
                                        h hVar3;
                                        h hVar4;
                                        h hVar5;
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonRowView.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentSpaceBetween();
                                                tVar2.marginTop(16.0f);
                                                tVar2.mo153width(249.0f);
                                                tVar2.marginBottom(24.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        RetainPopWindowLiveCouponView retainPopWindowLiveCouponView8 = RetainPopWindowLiveCouponView.this;
                                        String cancelBtnText = iRetainPopWindowLiveViewModel8.cancelBtnText();
                                        hVar = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false);
                                        hVar2 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false);
                                        j[] jVarArr = {new j(hVar, 0.0f), new j(hVar2, 1.0f)};
                                        Function0<Unit> cancelBtnCallback = iRetainPopWindowLiveViewModel8.cancelBtnCallback();
                                        hVar3 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_text_primary", false);
                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo = new RetainPopWindowViewUtils$ButtonInfo(cancelBtnText, hVar3, jVarArr, cancelBtnCallback);
                                        int i16 = RetainPopWindowLiveCouponView.$r8$clinit;
                                        retainPopWindowLiveCouponView8.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$buttonView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo2 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$buttonView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo3 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(121.5f, 40.0f);
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.allCenter();
                                                                Direction direction = Direction.TO_RIGHT;
                                                                j[] jVarArr2 = RetainPopWindowViewUtils$ButtonInfo.this.backGroundGradientColor;
                                                                tVar2.mo135backgroundLinearGradient(direction, (j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo4 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo5 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        RetainPopWindowViewUtils$ButtonInfo.this.clickEvent.invoke();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo5 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo6 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(RetainPopWindowViewUtils$ButtonInfo.this.text);
                                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                        ceVar2.fontWeightBold();
                                                                        ceVar2.color(RetainPopWindowViewUtils$ButtonInfo.this.textColor);
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
                                        }.invoke(vVar4);
                                        RetainPopWindowLiveCouponView retainPopWindowLiveCouponView9 = RetainPopWindowLiveCouponView.this;
                                        String successBtnText = iRetainPopWindowLiveViewModel8.successBtnText();
                                        hVar4 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                        hVar5 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_gradient02_normal", false);
                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo2 = new RetainPopWindowViewUtils$ButtonInfo(successBtnText, h.INSTANCE.m(), new j[]{new j(hVar4, 0.0f), new j(hVar5, 1.0f)}, iRetainPopWindowLiveViewModel8.successBtnCallback());
                                        retainPopWindowLiveCouponView9.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$buttonView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo22 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$buttonView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo3 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(121.5f, 40.0f);
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.allCenter();
                                                                Direction direction = Direction.TO_RIGHT;
                                                                j[] jVarArr2 = RetainPopWindowViewUtils$ButtonInfo.this.backGroundGradientColor;
                                                                tVar2.mo135backgroundLinearGradient(direction, (j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo4 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo5 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        RetainPopWindowViewUtils$ButtonInfo.this.clickEvent.invoke();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo5 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo6 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.buttonView.1.1.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(RetainPopWindowViewUtils$ButtonInfo.this.text);
                                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                        ceVar2.fontWeightBold();
                                                                        ceVar2.color(RetainPopWindowViewUtils$ButtonInfo.this.textColor);
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
                                        }.invoke(vVar4);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel3 = iRetainPopWindowLiveViewModel;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final IRetainPopWindowLiveViewModel iRetainPopWindowLiveViewModel4 = IRetainPopWindowLiveViewModel.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowLiveCouponView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                IRetainPopWindowLiveViewModel.this.expReport();
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new RetainPopWindowCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
