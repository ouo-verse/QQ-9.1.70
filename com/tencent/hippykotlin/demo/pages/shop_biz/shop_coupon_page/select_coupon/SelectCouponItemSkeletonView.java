package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponContanerViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemSkeletonViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SelectCouponItemSkeletonView extends ComposeView<k, l> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                CommonCouponContanerViewKt.CommonCouponContainerView(viewContainer, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                        ViewContainer<?, ?> viewContainer3 = viewContainer2;
                        CouponBackgroundViewKt.CouponBackground(viewContainer3, new Function1<CouponBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CouponBackgroundView couponBackgroundView) {
                                couponBackgroundView.attr(new Function1<CouponBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView.body.1.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CouponBackgroundAttr couponBackgroundAttr) {
                                        CouponBackgroundAttr couponBackgroundAttr2 = couponBackgroundAttr;
                                        couponBackgroundAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        ReadWriteProperty readWriteProperty = couponBackgroundAttr2.backgroundColorToken$delegate;
                                        KProperty<?>[] kPropertyArr = CouponBackgroundAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(couponBackgroundAttr2, kPropertyArr[2], "qecommerce_skin_color_btn_secondary_red_normal_50");
                                        couponBackgroundAttr2.borderColorToken$delegate.setValue(couponBackgroundAttr2, kPropertyArr[1], "qecommerce_skin_color_btn_secondary_red_pressed_40");
                                        couponBackgroundAttr2.setDashLineColorToken("qecommerce_skin_color_divider");
                                        couponBackgroundAttr2.rightAreaWidth = 84.0f;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        CommonCouponItemSkeletonViewKt.CommonCouponItemSkeleton(viewContainer3);
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(84.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView.body.1.1.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemSkeletonView.body.1.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(20.0f, 20.0f);
                                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_btn_secondary_red_pressed_40");
                                                tVar2.borderRadius(10.0f);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
