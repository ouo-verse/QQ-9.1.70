package com.tencent.hippykotlin.demo.pages.retain.view;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowCardAttr;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowViewUtils$ButtonInfo;
import com.tencent.hippykotlin.demo.pages.retain.model.Button;
import com.tencent.hippykotlin.demo.pages.retain.model.CouponLabelInfo;
import com.tencent.hippykotlin.demo.pages.retain.model.Labelheader;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel$cancelBtnCallback$1;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel$successBtnCallback$1;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponBasicInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponShowDiscount;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUseTimeRule;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
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
import com.tencent.kuikly.core.views.ImageView;
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
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class RetainPopWindowCouponView extends ComposeView<RetainPopWindowCardAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final Function1 access$timeCubeView(RetainPopWindowCouponView retainPopWindowCouponView, String str) {
        retainPopWindowCouponView.getClass();
        return new RetainPopWindowCouponView$timeCubeView$1(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IRetainPopWindowViewModel iRetainPopWindowViewModel = ((RetainPopWindowCardAttr) getAttr()).viewModel;
        if (iRetainPopWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iRetainPopWindowViewModel = null;
        }
        Intrinsics.checkNotNull(iRetainPopWindowViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel");
        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel = (RetainPopWindowCouponViewModel) iRetainPopWindowViewModel;
        final float l3 = (getPagerData().l() - 262.0f) / 2.0f;
        final float m3 = (getPagerData().m() - 297.0f) / 2.0f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_mask_50", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        return Unit.INSTANCE;
                    }
                });
                final RetainPopWindowCouponView retainPopWindowCouponView = RetainPopWindowCouponView.this;
                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel2 = retainPopWindowCouponViewModel;
                final float f16 = l3;
                final float f17 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f18 = f16;
                        final float f19 = f17;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.body.1.2.1
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
                                tVar2.borderRadius(8.0f);
                                tVar2.justifyContentFlexStart();
                                tVar2.flexDirectionColumn();
                                tVar2.alignItemsCenter();
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        RetainPopWindowCouponView retainPopWindowCouponView2 = RetainPopWindowCouponView.this;
                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel3 = retainPopWindowCouponViewModel2;
                        int i3 = RetainPopWindowCouponView.$r8$clinit;
                        retainPopWindowCouponView2.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$titleView$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel4 = RetainPopWindowCouponViewModel.this;
                                cg.a(viewContainer3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$titleView$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel5 = RetainPopWindowCouponViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.titleView.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(24.0f);
                                                Labelheader labelheader = RetainPopWindowCouponViewModel.this.info.rsp.header;
                                                if (labelheader == null || (str = labelheader.topText) == null) {
                                                    str = "";
                                                }
                                                ceVar2.text(str);
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
                        final RetainPopWindowCouponView retainPopWindowCouponView3 = RetainPopWindowCouponView.this;
                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel4 = retainPopWindowCouponViewModel2;
                        retainPopWindowCouponView3.getClass();
                        retainPopWindowCouponViewModel4.updateTimeInfo();
                        retainPopWindowCouponViewModel4.countDown();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$countDownView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel5 = RetainPopWindowCouponViewModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$countDownView$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(RetainPopWindowCouponViewModel.this.countdownRemainTime() >= 0);
                                    }
                                };
                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel6 = RetainPopWindowCouponViewModel.this;
                                final RetainPopWindowCouponView retainPopWindowCouponView4 = retainPopWindowCouponView3;
                                ConditionViewKt.c(viewContainer3, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$countDownView$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel7 = RetainPopWindowCouponViewModel.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Long.valueOf(RetainPopWindowCouponViewModel.this.getCountDownSecond());
                                            }
                                        };
                                        final RetainPopWindowCouponView retainPopWindowCouponView5 = retainPopWindowCouponView4;
                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel8 = RetainPopWindowCouponViewModel.this;
                                        BindDirectivesViewKt.a(conditionView, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                final RetainPopWindowCouponView retainPopWindowCouponView6 = RetainPopWindowCouponView.this;
                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel9 = retainPopWindowCouponViewModel8;
                                                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.1
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
                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel10 = retainPopWindowCouponViewModel9;
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel11 = RetainPopWindowCouponViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        Labelheader labelheader = RetainPopWindowCouponViewModel.this.info.rsp.header;
                                                                        if (labelheader == null || (str = labelheader.countdownText) == null) {
                                                                            str = "";
                                                                        }
                                                                        ceVar2.text(str);
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ((RetainPopWindowCouponView$timeCubeView$1) RetainPopWindowCouponView.access$timeCubeView(RetainPopWindowCouponView.this, retainPopWindowCouponViewModel9.countDownStrArray.get(0))).invoke(vVar4);
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.3.1
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
                                                        ((RetainPopWindowCouponView$timeCubeView$1) RetainPopWindowCouponView.access$timeCubeView(RetainPopWindowCouponView.this, retainPopWindowCouponViewModel9.countDownStrArray.get(1))).invoke(vVar4);
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.4.1
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
                                                        ((RetainPopWindowCouponView$timeCubeView$1) RetainPopWindowCouponView.access$timeCubeView(RetainPopWindowCouponView.this, retainPopWindowCouponViewModel9.countDownStrArray.get(2))).invoke(vVar4);
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.5
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.countDownView.1.2.2.1.5.1
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
                                                        ((RetainPopWindowCouponView$timeCubeView$1) RetainPopWindowCouponView.access$timeCubeView(RetainPopWindowCouponView.this, retainPopWindowCouponViewModel9.countDownStrArray.get(3))).invoke(vVar4);
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
                        final RetainPopWindowCouponView retainPopWindowCouponView4 = RetainPopWindowCouponView.this;
                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel5 = retainPopWindowCouponViewModel2;
                        retainPopWindowCouponView4.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$couponView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel6 = RetainPopWindowCouponViewModel.this;
                                final RetainPopWindowCouponView retainPopWindowCouponView5 = retainPopWindowCouponView4;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$couponView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(249.0f, 92.0f);
                                                tVar2.marginTop(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ArrayList<CouponLabelInfo> arrayList = RetainPopWindowCouponViewModel.this.info.rsp.couponLables;
                                        if (arrayList == null) {
                                            arrayList = new ArrayList<>();
                                        }
                                        if (arrayList.size() > 1) {
                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                            afVar2.size(249.0f, 92.0f);
                                                            afVar2.transform(new com.tencent.kuikly.core.base.t(3.0f, 0.0f, 0.0f, 6, null));
                                                            ImageAttrExtKt.urlToken$default(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8933/tanchuang/qecommerce_skin_tanchuangquan_bg.png");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                        afVar2.size(249.0f, 92.0f);
                                                        ImageAttrExtKt.urlToken$default(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8933/tanchuang/qecommerce_skin_tanchuangquan_bg.png");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final RetainPopWindowCouponView retainPopWindowCouponView6 = retainPopWindowCouponView5;
                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel7 = RetainPopWindowCouponViewModel.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponView.1.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.justifyContentFlexStart();
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                RetainPopWindowCouponView retainPopWindowCouponView7 = RetainPopWindowCouponView.this;
                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel8 = retainPopWindowCouponViewModel7;
                                                int i16 = RetainPopWindowCouponView.$r8$clinit;
                                                retainPopWindowCouponView7.getClass();
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$couponLeftView$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel9 = RetainPopWindowCouponViewModel.this;
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$couponLeftView$1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(94.0f, 92.0f);
                                                                        tVar2.flexDirectionColumn();
                                                                        tVar2.justifyContentCenter();
                                                                        tVar2.alignItemsCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel10 = RetainPopWindowCouponViewModel.this;
                                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar9) {
                                                                        v vVar10 = vVar9;
                                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.flexDirectionRow();
                                                                                tVar2.justifyContentFlexStart();
                                                                                tVar2.alignItemsCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.2.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.2.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        h hVar;
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.text("\u00a5");
                                                                                        ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                                        ceVar2.fontWeightBold();
                                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                                        ceVar2.marginTop(8.0f);
                                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                                        ceVar2.color(hVar);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel11 = RetainPopWindowCouponViewModel.this;
                                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel12 = RetainPopWindowCouponViewModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.2.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        String str;
                                                                                        h hVar;
                                                                                        ShopCouponCouponShowInfo shopCouponCouponShowInfo;
                                                                                        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
                                                                                        ShopCouponShowDiscount shopCouponShowDiscount;
                                                                                        ce ceVar2 = ceVar;
                                                                                        CouponLabelInfo couponInfo = RetainPopWindowCouponViewModel.this.couponInfo();
                                                                                        if (couponInfo == null || (shopCouponCouponShowInfo = couponInfo.couponShowInfo) == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo.couponShowDiscount) == null || (str = shopCouponShowDiscount.discountAmount) == null) {
                                                                                            str = "";
                                                                                        }
                                                                                        ceVar2.text(str);
                                                                                        ce.fontSize$default(ceVar2, 32.0f, null, 2, null);
                                                                                        ceVar2.fontWeightBold();
                                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                                        ceVar2.marginTop(2.0f);
                                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                                        ceVar2.color(hVar);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel11 = RetainPopWindowCouponViewModel.this;
                                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel12 = RetainPopWindowCouponViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponLeftView.1.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                String str;
                                                                                h hVar;
                                                                                ShopCouponCouponShowInfo shopCouponCouponShowInfo;
                                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
                                                                                ShopCouponShowDiscount shopCouponShowDiscount;
                                                                                ce ceVar2 = ceVar;
                                                                                CouponLabelInfo couponInfo = RetainPopWindowCouponViewModel.this.couponInfo();
                                                                                if (couponInfo == null || (shopCouponCouponShowInfo = couponInfo.couponShowInfo) == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo.couponShowDiscount) == null || (str = shopCouponShowDiscount.discountThreshold) == null) {
                                                                                    str = "";
                                                                                }
                                                                                ceVar2.text(str);
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                ceVar2.fontWeightBold();
                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                                ceVar2.color(hVar);
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
                                                }.invoke(vVar6);
                                                RetainPopWindowCouponView retainPopWindowCouponView8 = RetainPopWindowCouponView.this;
                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel9 = retainPopWindowCouponViewModel7;
                                                retainPopWindowCouponView8.getClass();
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$couponRightView$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel10 = RetainPopWindowCouponViewModel.this;
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$couponRightView$1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(155.0f, 92.0f);
                                                                        tVar2.marginLeft(16.0f);
                                                                        tVar2.flexDirectionColumn();
                                                                        tVar2.justifyContentFlexStart();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel11 = RetainPopWindowCouponViewModel.this;
                                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar9) {
                                                                        v vVar10 = vVar9;
                                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.flexDirectionRow();
                                                                                tVar2.justifyContentFlexStart();
                                                                                tVar2.marginTop(16.0f);
                                                                                tVar2.alignItemsCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel12 = RetainPopWindowCouponViewModel.this;
                                                                        w.a(vVar10, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar11) {
                                                                                v vVar12 = vVar11;
                                                                                vVar12.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        h hVar;
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.allCenter();
                                                                                        tVar2.mo141height(16.0f);
                                                                                        tVar2.marginRight(4.0f);
                                                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_tag_secondary_40", false);
                                                                                        tVar2.mo113backgroundColor(hVar);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel13 = RetainPopWindowCouponViewModel.this;
                                                                                cg.a(vVar12, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.2.2
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel14 = RetainPopWindowCouponViewModel.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.2.2.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                h hVar;
                                                                                                ShopCouponCouponShowInfo shopCouponCouponShowInfo;
                                                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
                                                                                                ce ceVar2 = ceVar;
                                                                                                CouponLabelInfo couponInfo = RetainPopWindowCouponViewModel.this.couponInfo();
                                                                                                ceVar2.text(String.valueOf((couponInfo == null || (shopCouponCouponShowInfo = couponInfo.couponShowInfo) == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null) ? null : shopCouponCouponShowStyleInfo.couponTypeName));
                                                                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                                ceVar2.marginLeft(4.0f);
                                                                                                ceVar2.marginRight(4.0f);
                                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                                                                ceVar2.color(hVar);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel13 = RetainPopWindowCouponViewModel.this;
                                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel14 = RetainPopWindowCouponViewModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.2.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ShopCouponCouponShowInfo shopCouponCouponShowInfo;
                                                                                        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
                                                                                        ce ceVar2 = ceVar;
                                                                                        CouponLabelInfo couponInfo = RetainPopWindowCouponViewModel.this.couponInfo();
                                                                                        ceVar2.text(String.valueOf((couponInfo == null || (shopCouponCouponShowInfo = couponInfo.couponShowInfo) == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null) ? null : shopCouponCouponShowStyleInfo.couponIssuerName));
                                                                                        ceVar2.lines(1);
                                                                                        ceVar2.m144maxWidth(80.0f);
                                                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                        ceVar2.color(new h(4288256409L));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel12 = RetainPopWindowCouponViewModel.this;
                                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel13 = RetainPopWindowCouponViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ShopCouponCouponShowInfo shopCouponCouponShowInfo;
                                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
                                                                                ce ceVar2 = ceVar;
                                                                                CouponLabelInfo couponInfo = RetainPopWindowCouponViewModel.this.couponInfo();
                                                                                ceVar2.text(String.valueOf((couponInfo == null || (shopCouponCouponShowInfo = couponInfo.couponShowInfo) == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null) ? null : shopCouponCouponShowStyleInfo.couponUsableRange));
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                ceVar2.marginTop(8.0f);
                                                                                ceVar2.mo141height(17.0f);
                                                                                ceVar2.color(new h(4288256409L));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel13 = RetainPopWindowCouponViewModel.this;
                                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel14 = RetainPopWindowCouponViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.couponRightView.1.1.4.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ShopCouponCouponShowInfo shopCouponCouponShowInfo;
                                                                                ShopCouponCouponBasicInfo shopCouponCouponBasicInfo;
                                                                                ShopCouponUseTimeRule shopCouponUseTimeRule;
                                                                                ce ceVar2 = ceVar;
                                                                                RetainPopWindowCouponViewModel retainPopWindowCouponViewModel15 = RetainPopWindowCouponViewModel.this;
                                                                                retainPopWindowCouponViewModel15.getClass();
                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                sb5.append("\u9886\u53d6\u540e");
                                                                                CouponLabelInfo couponInfo = retainPopWindowCouponViewModel15.couponInfo();
                                                                                sb5.append((couponInfo == null || (shopCouponCouponShowInfo = couponInfo.couponShowInfo) == null || (shopCouponCouponBasicInfo = shopCouponCouponShowInfo.basicInfo) == null || (shopCouponUseTimeRule = shopCouponCouponBasicInfo.useTimeRule) == null) ? null : Integer.valueOf(shopCouponUseTimeRule.dayAfterReceive));
                                                                                sb5.append("\u5929\u6709\u6548");
                                                                                ceVar2.text(sb5.toString());
                                                                                ceVar2.marginTop(2.0f);
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                ceVar2.mo141height(17.0f);
                                                                                ceVar2.color(new h(4288256409L));
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
                                                }.invoke(vVar6);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        final RetainPopWindowCouponView retainPopWindowCouponView5 = RetainPopWindowCouponView.this;
                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel6 = retainPopWindowCouponViewModel2;
                        retainPopWindowCouponView5.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$buttonRowView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final RetainPopWindowCouponView retainPopWindowCouponView6 = RetainPopWindowCouponView.this;
                                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel7 = retainPopWindowCouponViewModel6;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$buttonRowView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        String str;
                                        h hVar;
                                        h hVar2;
                                        h hVar3;
                                        String str2;
                                        h hVar4;
                                        h hVar5;
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonRowView.1.1.1
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
                                        RetainPopWindowCouponView retainPopWindowCouponView7 = RetainPopWindowCouponView.this;
                                        Button button = retainPopWindowCouponViewModel7.info.rsp.button;
                                        if (button == null || (str = button.leftText) == null) {
                                            str = "\u653e\u5f03";
                                        }
                                        hVar = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false);
                                        hVar2 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false);
                                        j[] jVarArr = {new j(hVar, 0.0f), new j(hVar2, 1.0f)};
                                        RetainPopWindowCouponViewModel retainPopWindowCouponViewModel8 = retainPopWindowCouponViewModel7;
                                        retainPopWindowCouponViewModel8.getClass();
                                        RetainPopWindowCouponViewModel$cancelBtnCallback$1 retainPopWindowCouponViewModel$cancelBtnCallback$1 = new RetainPopWindowCouponViewModel$cancelBtnCallback$1(retainPopWindowCouponViewModel8);
                                        hVar3 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_text_primary", false);
                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo = new RetainPopWindowViewUtils$ButtonInfo(str, hVar3, jVarArr, retainPopWindowCouponViewModel$cancelBtnCallback$1);
                                        int i16 = RetainPopWindowCouponView.$r8$clinit;
                                        retainPopWindowCouponView7.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$buttonView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo2 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$buttonView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo3 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.1
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
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo5 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.2.1
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
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo6 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.3.1
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
                                        RetainPopWindowCouponView retainPopWindowCouponView8 = RetainPopWindowCouponView.this;
                                        Button button2 = retainPopWindowCouponViewModel7.info.rsp.button;
                                        if (button2 == null || (str2 = button2.rightText) == null) {
                                            str2 = "\u8d2d\u4e70";
                                        }
                                        hVar4 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                        hVar5 = IPagerIdKtxKt.getSkinColor(vVar4).tokenColor("qecommerce_skin_color_btn_gradient02_normal", false);
                                        j[] jVarArr2 = {new j(hVar4, 0.0f), new j(hVar5, 1.0f)};
                                        RetainPopWindowCouponViewModel retainPopWindowCouponViewModel9 = retainPopWindowCouponViewModel7;
                                        retainPopWindowCouponViewModel9.getClass();
                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo2 = new RetainPopWindowViewUtils$ButtonInfo(str2, h.INSTANCE.m(), jVarArr2, new RetainPopWindowCouponViewModel$successBtnCallback$1(retainPopWindowCouponViewModel9));
                                        retainPopWindowCouponView8.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$buttonView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo22 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$buttonView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo3 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.1
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
                                                                j[] jVarArr22 = RetainPopWindowViewUtils$ButtonInfo.this.backGroundGradientColor;
                                                                tVar2.mo135backgroundLinearGradient(direction, (j[]) Arrays.copyOf(jVarArr22, jVarArr22.length));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo4 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo5 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.2.1
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
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo6 = RetainPopWindowViewUtils$ButtonInfo.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.buttonView.1.1.3.1
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
                final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel3 = retainPopWindowCouponViewModel;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final RetainPopWindowCouponViewModel retainPopWindowCouponViewModel4 = RetainPopWindowCouponViewModel.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                RetainPopWindowCouponViewModel.this.expReport();
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
