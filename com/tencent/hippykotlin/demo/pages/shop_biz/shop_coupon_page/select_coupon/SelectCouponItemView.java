package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponContanerViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SelectCouponItemView extends ComposeView<SelectCouponItemAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final CouponItem couponItem = ((SelectCouponItemAttr) getAttr()).couponItem;
        if (couponItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponItem");
            couponItem = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final CouponItem couponItem2 = CouponItem.this;
                CommonCouponContanerViewKt.CommonCouponContainerView(viewContainer, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                        ViewContainer<?, ?> viewContainer3 = viewContainer2;
                        final CouponItem couponItem3 = CouponItem.this;
                        CouponBackgroundViewKt.CouponBackground(viewContainer3, new Function1<CouponBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CouponBackgroundView couponBackgroundView) {
                                final CouponItem couponItem4 = CouponItem.this;
                                couponBackgroundView.attr(new Function1<CouponBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CouponBackgroundAttr couponBackgroundAttr) {
                                        CouponBackgroundAttr couponBackgroundAttr2 = couponBackgroundAttr;
                                        couponBackgroundAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        couponBackgroundAttr2.rightAreaWidth = 84.0f;
                                        couponBackgroundAttr2.setShowStyleDisable(!CouponItem.this.commonCouponItem.isEnabled);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final CouponItem couponItem4 = CouponItem.this;
                        CommonCouponItemViewKt.CommonCouponItemView(viewContainer3, new Function1<CommonCouponItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CommonCouponItemView commonCouponItemView) {
                                final CouponItem couponItem5 = CouponItem.this;
                                commonCouponItemView.attr(new Function1<CommonCouponItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CommonCouponItemAttr commonCouponItemAttr) {
                                        commonCouponItemAttr.commonCouponItem = CouponItem.this.commonCouponItem;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final CouponItem couponItem5 = CouponItem.this;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(84.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final CouponItem couponItem6 = CouponItem.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final CouponItem couponItem7 = CouponItem.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponItemView.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String str;
                                                af afVar2 = afVar;
                                                afVar2.size(20.0f, 20.0f);
                                                CouponItem couponItem8 = CouponItem.this;
                                                if (!couponItem8.commonCouponItem.isEnabled) {
                                                    str = "qecommerce_skin_checkbox_image_disable";
                                                } else if (couponItem8.isSelected) {
                                                    str = "qecommerce_skin_checkbox_general_selected_red";
                                                } else {
                                                    str = "qecommerce_skin_checkbox_general_normal";
                                                }
                                                b.a.b(afVar2, str, false, 2, null);
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
        return new SelectCouponItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
