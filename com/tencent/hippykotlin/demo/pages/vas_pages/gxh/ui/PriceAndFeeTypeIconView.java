package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.vas_base.extensions.p002float.ImplKt;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.FeeType;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.DressItem;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.User;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes33.dex */
public final class PriceAndFeeTypeIconView extends ComposeView<PriceAndFeeTypeIconViewAttr, PriceAndFeeTypeIconViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PriceAndFeeTypeIconViewAttr access$getAttr(PriceAndFeeTypeIconView priceAndFeeTypeIconView) {
        return (PriceAndFeeTypeIconViewAttr) priceAndFeeTypeIconView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final PriceAndFeeTypeIconView priceAndFeeTypeIconView = PriceAndFeeTypeIconView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView2 = PriceAndFeeTypeIconView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean z16;
                                boolean contains$default;
                                c cVar = c.f117352a;
                                boolean z17 = false;
                                if (cVar.g().getPageData().n().g("isIosInCheck", false)) {
                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).getQua(), (CharSequence) "_RDM_", false, 2, (Object) null);
                                    if (!contains$default) {
                                        z16 = true;
                                        if (!z16 && PriceAndFeeTypeIconView.this.getFeeType() == FeeType.SVIP_FREE) {
                                            z17 = true;
                                        }
                                        return Boolean.valueOf(z17);
                                    }
                                }
                                z16 = false;
                                if (!z16) {
                                    z17 = true;
                                }
                                return Boolean.valueOf(z17);
                            }
                        };
                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView3 = PriceAndFeeTypeIconView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView4 = PriceAndFeeTypeIconView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView5 = PriceAndFeeTypeIconView.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                PriceAndFeeTypeIconViewAttr access$getAttr = PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this);
                                                User user = (User) access$getAttr.user$delegate.getValue(access$getAttr, PriceAndFeeTypeIconViewAttr.$$delegatedProperties[1]);
                                                return Boolean.valueOf(((Boolean) user.isSvip$delegate.getValue(user, User.$$delegatedProperties[1])).booleanValue());
                                            }
                                        };
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView6 = PriceAndFeeTypeIconView.this;
                                        ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                ConditionView conditionView3 = conditionView2;
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView7 = PriceAndFeeTypeIconView.this;
                                                FeeTypeIconKt.FeeTypeIcon(conditionView3, new Function1<FeeTypeIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(FeeTypeIconView feeTypeIconView) {
                                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView8 = PriceAndFeeTypeIconView.this;
                                                        feeTypeIconView.attr(new Function1<FeeTypeIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(FeeTypeIconViewAttr feeTypeIconViewAttr) {
                                                                FeeTypeIconViewAttr feeTypeIconViewAttr2 = feeTypeIconViewAttr;
                                                                feeTypeIconViewAttr2.setItem$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release());
                                                                feeTypeIconViewAttr2.setViewScale$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView8 = PriceAndFeeTypeIconView.this;
                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        boolean z16;
                                                        if (PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release().getPrice() <= 0.0f) {
                                                            DressItem item$qecommerce_biz_release = PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release();
                                                            if (((Boolean) item$qecommerce_biz_release.hideZeroPrice$delegate.getValue(item$qecommerce_biz_release, DressItem.$$delegatedProperties[12])).booleanValue()) {
                                                                z16 = false;
                                                                return Boolean.valueOf(z16);
                                                            }
                                                        }
                                                        z16 = true;
                                                        return Boolean.valueOf(z16);
                                                    }
                                                };
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView9 = PriceAndFeeTypeIconView.this;
                                                ConditionViewKt.c(conditionView3, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView4) {
                                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView10 = PriceAndFeeTypeIconView.this;
                                                        PriceKt.Price(conditionView4, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(PriceView priceView) {
                                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView11 = PriceAndFeeTypeIconView.this;
                                                                priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.3.3.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                                        PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                                        priceViewAttr2.marginLeft(ImplKt.getW(6.0f));
                                                                        priceViewAttr2.setPrice$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release().getPrice());
                                                                        priceViewAttr2.setViewScale$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release());
                                                                        priceViewAttr2.isInvalid$delegate.setValue(priceViewAttr2, PriceViewAttr.$$delegatedProperties[1], Boolean.TRUE);
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
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView7 = PriceAndFeeTypeIconView.this;
                                        ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                ConditionView conditionView3 = conditionView2;
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView8 = PriceAndFeeTypeIconView.this;
                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        boolean z16;
                                                        if (PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release().getPrice() <= 0.0f) {
                                                            DressItem item$qecommerce_biz_release = PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release();
                                                            if (((Boolean) item$qecommerce_biz_release.hideZeroPrice$delegate.getValue(item$qecommerce_biz_release, DressItem.$$delegatedProperties[12])).booleanValue()) {
                                                                z16 = false;
                                                                return Boolean.valueOf(z16);
                                                            }
                                                        }
                                                        z16 = true;
                                                        return Boolean.valueOf(z16);
                                                    }
                                                };
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView9 = PriceAndFeeTypeIconView.this;
                                                ConditionViewKt.c(conditionView3, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView4) {
                                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView10 = PriceAndFeeTypeIconView.this;
                                                        PriceKt.Price(conditionView4, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(PriceView priceView) {
                                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView11 = PriceAndFeeTypeIconView.this;
                                                                priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4.2.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                                        PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                                        priceViewAttr2.setPrice$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release().getPrice());
                                                                        priceViewAttr2.setViewScale$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView10 = PriceAndFeeTypeIconView.this;
                                                FeeTypeIconKt.FeeTypeIcon(conditionView3, new Function1<FeeTypeIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(FeeTypeIconView feeTypeIconView) {
                                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView11 = PriceAndFeeTypeIconView.this;
                                                        feeTypeIconView.attr(new Function1<FeeTypeIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.3.1.4.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(FeeTypeIconViewAttr feeTypeIconViewAttr) {
                                                                FeeTypeIconViewAttr feeTypeIconViewAttr2 = feeTypeIconViewAttr;
                                                                feeTypeIconViewAttr2.marginLeft(ImplKt.getW(4.0f));
                                                                feeTypeIconViewAttr2.setItem$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release());
                                                                feeTypeIconViewAttr2.setViewScale$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release());
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
                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView4 = PriceAndFeeTypeIconView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean z16;
                                boolean contains$default;
                                c cVar = c.f117352a;
                                boolean z17 = false;
                                if (cVar.g().getPageData().n().g("isIosInCheck", false)) {
                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).getQua(), (CharSequence) "_RDM_", false, 2, (Object) null);
                                    if (!contains$default) {
                                        z16 = true;
                                        if (!z16 && PriceAndFeeTypeIconView.this.getFeeType() == FeeType.MEIHUA_AT) {
                                            z17 = true;
                                        }
                                        return Boolean.valueOf(z17);
                                    }
                                }
                                z16 = false;
                                if (!z16) {
                                    z17 = true;
                                }
                                return Boolean.valueOf(z17);
                            }
                        };
                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView5 = PriceAndFeeTypeIconView.this;
                        ConditionViewKt.b(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView6 = PriceAndFeeTypeIconView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView7 = PriceAndFeeTypeIconView.this;
                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(PriceAndFeeTypeIconView.this.isSvipDiscount());
                                            }
                                        };
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView8 = PriceAndFeeTypeIconView.this;
                                        ConditionViewKt.c(vVar4, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView9 = PriceAndFeeTypeIconView.this;
                                                conditionView2.addChild(new SvipDiscountIconView(), new Function1<SvipDiscountIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(SvipDiscountIconView svipDiscountIconView) {
                                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView10 = PriceAndFeeTypeIconView.this;
                                                        svipDiscountIconView.attr(new Function1<SvipDiscountIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.2.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(SvipDiscountIconViewAttr svipDiscountIconViewAttr) {
                                                                SvipDiscountIconViewAttr svipDiscountIconViewAttr2 = svipDiscountIconViewAttr;
                                                                DressItem item$qecommerce_biz_release = PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release();
                                                                ReadWriteProperty readWriteProperty = svipDiscountIconViewAttr2.item$delegate;
                                                                KProperty<?>[] kPropertyArr = SvipDiscountIconViewAttr.$$delegatedProperties;
                                                                readWriteProperty.setValue(svipDiscountIconViewAttr2, kPropertyArr[0], item$qecommerce_biz_release);
                                                                PriceAndFeeTypeIconViewAttr access$getAttr = PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this);
                                                                svipDiscountIconViewAttr2.user$delegate.setValue(svipDiscountIconViewAttr2, kPropertyArr[1], (User) access$getAttr.user$delegate.getValue(access$getAttr, PriceAndFeeTypeIconViewAttr.$$delegatedProperties[1]));
                                                                svipDiscountIconViewAttr2.viewScale$delegate.setValue(svipDiscountIconViewAttr2, kPropertyArr[2], Float.valueOf(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release()));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView9 = PriceAndFeeTypeIconView.this;
                                        ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView10 = PriceAndFeeTypeIconView.this;
                                                PriceKt.Price(conditionView2, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PriceView priceView) {
                                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView11 = PriceAndFeeTypeIconView.this;
                                                        priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.5.1.3.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                                PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                                priceViewAttr2.setPrice$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release().getPrice());
                                                                priceViewAttr2.setViewScale$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release());
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
                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView6 = PriceAndFeeTypeIconView.this;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final PriceAndFeeTypeIconView priceAndFeeTypeIconView7 = PriceAndFeeTypeIconView.this;
                                FeeTypeIconKt.FeeTypeIcon(conditionView, new Function1<FeeTypeIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FeeTypeIconView feeTypeIconView) {
                                        final PriceAndFeeTypeIconView priceAndFeeTypeIconView8 = PriceAndFeeTypeIconView.this;
                                        feeTypeIconView.attr(new Function1<FeeTypeIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView.body.1.1.6.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FeeTypeIconViewAttr feeTypeIconViewAttr) {
                                                FeeTypeIconViewAttr feeTypeIconViewAttr2 = feeTypeIconViewAttr;
                                                feeTypeIconViewAttr2.setItem$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getItem$qecommerce_biz_release());
                                                feeTypeIconViewAttr2.setViewScale$qecommerce_biz_release(PriceAndFeeTypeIconView.access$getAttr(PriceAndFeeTypeIconView.this).getViewScale$qecommerce_biz_release());
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new PriceAndFeeTypeIconViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new PriceAndFeeTypeIconViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FeeType getFeeType() {
        return ((PriceAndFeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release().getFeeType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isSvipDiscount() {
        if (((PriceAndFeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release().getFeeType() != FeeType.MEIHUA_AT) {
            return false;
        }
        DressItem item$qecommerce_biz_release = ((PriceAndFeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release();
        DressItem.Discount discount = (DressItem.Discount) item$qecommerce_biz_release.discount$delegate.getValue(item$qecommerce_biz_release, DressItem.$$delegatedProperties[13]);
        return Intrinsics.areEqual((String) discount.type$delegate.getValue(discount, DressItem.Discount.$$delegatedProperties[0]), "DISCOUNT_SVIP_PAY");
    }
}
