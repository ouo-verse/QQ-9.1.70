package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view;

import com.tencent.hippykotlin.demo.pages.base.ISkinColor;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CouponBackgroundView extends ComposeView<CouponBackgroundAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ CouponBackgroundAttr access$getAttr(CouponBackgroundView couponBackgroundView) {
        return (CouponBackgroundAttr) couponBackgroundView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$renderDashLine(CouponBackgroundView couponBackgroundView, p pVar, float f16) {
        h hVar;
        couponBackgroundView.getClass();
        pVar.b();
        CouponBackgroundAttr couponBackgroundAttr = (CouponBackgroundAttr) couponBackgroundView.getAttr();
        ReadWriteProperty readWriteProperty = couponBackgroundAttr.dashLineColorToken$delegate;
        KProperty<?>[] kPropertyArr = CouponBackgroundAttr.$$delegatedProperties;
        int length = ((String) readWriteProperty.getValue(couponBackgroundAttr, kPropertyArr[5])).length();
        if (length > 0) {
            ISkinColor skinColor = IPagerIdKtxKt.getSkinColor(couponBackgroundView);
            CouponBackgroundAttr couponBackgroundAttr2 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
            hVar = skinColor.tokenColor((String) couponBackgroundAttr2.dashLineColorToken$delegate.getValue(couponBackgroundAttr2, kPropertyArr[5]), false);
        } else if (((CouponBackgroundAttr) couponBackgroundView.getAttr()).getShowStyleDisable()) {
            hVar = IPagerIdKtxKt.getSkinColor(couponBackgroundView).tokenColor("qecommerce_skin_color_divider", false);
        } else {
            hVar = IPagerIdKtxKt.getSkinColor(couponBackgroundView).tokenColor("qecommerce_skin_color_tag_secondary", false);
        }
        pVar.n(hVar);
        pVar.j(0.5f);
        pVar.k(2.0f, 8.0f);
        pVar.h();
        float f17 = 2 + 8.0f;
        pVar.i(2.0f, f17);
        float f18 = f17 + 1.5f;
        pVar.k(2.0f, f18);
        int i3 = (int) (((f16 - f18) - f18) / 8);
        for (int i16 = 0; i16 < i3; i16++) {
            float f19 = f18 + 2.5f;
            pVar.k(2.0f, f19);
            float f26 = f19 + 3;
            pVar.i(2.0f, f26);
            f18 = f26 + 2.5f;
            pVar.k(2.0f, f18);
        }
        float f27 = f18 + 1.5f;
        pVar.k(2.0f, f27);
        pVar.i(2.0f, f27 + 2.0f);
        pVar.m();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final CouponBackgroundView couponBackgroundView = CouponBackgroundView.this;
                Function1<CanvasView, Unit> function1 = new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(CanvasView canvasView) {
                        final CouponBackgroundView couponBackgroundView2 = CouponBackgroundView.this;
                        canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Attr attr) {
                                Attr attr2 = attr;
                                attr2.m147opacity(CouponBackgroundView.access$getAttr(CouponBackgroundView.this).couponBgOpacity);
                                attr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                final CouponBackgroundView couponBackgroundView2 = CouponBackgroundView.this;
                CanvasViewKt.a(viewContainer2, function1, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView$body$1.2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(p pVar, Float f16, Float f17) {
                        float floatValue = f16.floatValue();
                        float floatValue2 = f17.floatValue();
                        CouponBackgroundView.access$renderBackground(CouponBackgroundView.this, pVar, floatValue, floatValue2);
                        return Unit.INSTANCE;
                    }
                });
                final CouponBackgroundView couponBackgroundView3 = CouponBackgroundView.this;
                Function1<CanvasView, Unit> function12 = new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(CanvasView canvasView) {
                        final CouponBackgroundView couponBackgroundView4 = CouponBackgroundView.this;
                        canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Attr attr) {
                                Attr attr2 = attr;
                                Attr.absolutePosition$default(attr2, 0.0f, 0.0f, 0.0f, CouponBackgroundView.access$getAttr(CouponBackgroundView.this).rightAreaWidth - 4.5f, 2, null);
                                attr2.mo153width(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                final CouponBackgroundView couponBackgroundView4 = CouponBackgroundView.this;
                CanvasViewKt.a(viewContainer2, function12, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView$body$1.4
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(p pVar, Float f16, Float f17) {
                        f16.floatValue();
                        float floatValue = f17.floatValue();
                        CouponBackgroundView.access$renderDashLine(CouponBackgroundView.this, pVar, floatValue);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new CouponBackgroundAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void setFrameToRenderView(d dVar) {
        super.setFrameToRenderView(dVar);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$renderBackground(CouponBackgroundView couponBackgroundView, p pVar, float f16, float f17) {
        h hVar;
        h hVar2;
        float f18 = ((CouponBackgroundAttr) couponBackgroundView.getAttr()).rightAreaWidth;
        pVar.b();
        pVar.j(0.5f);
        CouponBackgroundAttr couponBackgroundAttr = (CouponBackgroundAttr) couponBackgroundView.getAttr();
        ReadWriteProperty readWriteProperty = couponBackgroundAttr.borderColor$delegate;
        KProperty<?>[] kPropertyArr = CouponBackgroundAttr.$$delegatedProperties;
        if (((Number) readWriteProperty.getValue(couponBackgroundAttr, kPropertyArr[3])).longValue() != 0) {
            CouponBackgroundAttr couponBackgroundAttr2 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
            hVar = new h(((Number) couponBackgroundAttr2.borderColor$delegate.getValue(couponBackgroundAttr2, kPropertyArr[3])).longValue());
        } else {
            CouponBackgroundAttr couponBackgroundAttr3 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
            if (((String) couponBackgroundAttr3.borderColorToken$delegate.getValue(couponBackgroundAttr3, kPropertyArr[1])).length() > 0) {
                ISkinColor skinColor = IPagerIdKtxKt.getSkinColor(couponBackgroundView);
                CouponBackgroundAttr couponBackgroundAttr4 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
                hVar = skinColor.tokenColor((String) couponBackgroundAttr4.borderColorToken$delegate.getValue(couponBackgroundAttr4, kPropertyArr[1]), false);
            } else {
                hVar = ((CouponBackgroundAttr) couponBackgroundView.getAttr()).getShowStyleDisable() ? IPagerIdKtxKt.getSkinColor(couponBackgroundView).tokenColor("qecommerce_skin_color_divider", false) : IPagerIdKtxKt.getSkinColor(couponBackgroundView).tokenColor("qecommerce_skin_color_tag_secondary", false);
            }
        }
        pVar.n(hVar);
        pVar.k(0.25f, 4.25f);
        pVar.a(4.25f, 4.25f, 4.0f, 3.1415927f, 4.712389f, false);
        float f19 = (f16 - f18) - 5.0f;
        pVar.i(f19, 0.25f);
        pVar.a(f19, 5.25f, 5.0f, 4.712389f, 5.497787f, false);
        float cos = ((float) Math.cos(0.7853982f)) * 10.0f;
        float f26 = f19 + cos;
        pVar.a(f26, 5.25f - cos, 5.0f, 2.3561945f, 0.7853982f, true);
        float f27 = (2 * cos) + f19;
        pVar.a(f27, 5.25f, 5.0f, 3.9269907f, 4.712389f, false);
        float f28 = f16 - 0.25f;
        float f29 = f28 - 4.0f;
        pVar.i(f29, 0.25f);
        pVar.a(f29, 4.25f, 4.0f, 4.712389f, 6.2831855f, false);
        float f36 = f17 - 0.25f;
        float f37 = f36 - 4.0f;
        pVar.i(f28, f37);
        pVar.a(f29, f37, 4.0f, 0.0f, 1.5707964f, false);
        pVar.k(0.25f, 4.25f);
        pVar.i(0.25f, f37);
        pVar.a(4.25f, f37, 4.0f, 3.1415927f, 1.5707964f, true);
        pVar.i(f19, f36);
        float f38 = f36 - 5.0f;
        pVar.a(f19, f38, 5.0f, 1.5707964f, 0.7853982f, true);
        pVar.a(f26, f38 + cos, 5.0f, 3.926991f, 5.4977875f, false);
        pVar.a(f27, f38, 5.0f, 2.3561945f, 1.5707964f, true);
        pVar.i(f29, f36);
        pVar.m();
        CouponBackgroundAttr couponBackgroundAttr5 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
        if (((Number) couponBackgroundAttr5.backgroundColor$delegate.getValue(couponBackgroundAttr5, kPropertyArr[4])).longValue() != 0) {
            CouponBackgroundAttr couponBackgroundAttr6 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
            hVar2 = new h(((Number) couponBackgroundAttr6.backgroundColor$delegate.getValue(couponBackgroundAttr6, kPropertyArr[4])).longValue());
        } else {
            CouponBackgroundAttr couponBackgroundAttr7 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
            if (((String) couponBackgroundAttr7.backgroundColorToken$delegate.getValue(couponBackgroundAttr7, kPropertyArr[2])).length() > 0) {
                ISkinColor skinColor2 = IPagerIdKtxKt.getSkinColor(couponBackgroundView);
                CouponBackgroundAttr couponBackgroundAttr8 = (CouponBackgroundAttr) couponBackgroundView.getAttr();
                hVar2 = skinColor2.tokenColor((String) couponBackgroundAttr8.backgroundColorToken$delegate.getValue(couponBackgroundAttr8, kPropertyArr[2]), false);
            } else {
                hVar2 = ((CouponBackgroundAttr) couponBackgroundView.getAttr()).getShowStyleDisable() ? IPagerIdKtxKt.getSkinColor(couponBackgroundView).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false) : IPagerIdKtxKt.getSkinColor(couponBackgroundView).tokenColor("qecommerce_skin_color_tag_light", false);
            }
        }
        pVar.f(hVar2);
        pVar.e();
    }
}
