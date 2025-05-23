package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
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
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ObtainCouponItemView extends ComposeView<ObtainCouponItemAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ObtainCouponItemModel obtainCouponItemModel = ((ObtainCouponItemAttr) getAttr()).couponItem;
        if (obtainCouponItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponItem");
            obtainCouponItemModel = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ObtainCouponItemModel obtainCouponItemModel2 = ObtainCouponItemModel.this;
                CommonCouponContanerViewKt.CommonCouponContainerView(viewContainer, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                        ViewContainer<?, ?> viewContainer3 = viewContainer2;
                        CouponBackgroundViewKt.CouponBackground(viewContainer3, new Function1<CouponBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CouponBackgroundView couponBackgroundView) {
                                couponBackgroundView.attr(new Function1<CouponBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CouponBackgroundAttr couponBackgroundAttr) {
                                        CouponBackgroundAttr couponBackgroundAttr2 = couponBackgroundAttr;
                                        couponBackgroundAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        couponBackgroundAttr2.rightAreaWidth = 84.0f;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ObtainCouponItemModel obtainCouponItemModel3 = ObtainCouponItemModel.this;
                        CommonCouponItemViewKt.CommonCouponItemView(viewContainer3, new Function1<CommonCouponItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CommonCouponItemView commonCouponItemView) {
                                final ObtainCouponItemModel obtainCouponItemModel4 = ObtainCouponItemModel.this;
                                commonCouponItemView.attr(new Function1<CommonCouponItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CommonCouponItemAttr commonCouponItemAttr) {
                                        commonCouponItemAttr.commonCouponItem = ObtainCouponItemModel.this.commonItemModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ObtainCouponItemModel obtainCouponItemModel4 = ObtainCouponItemModel.this;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(84.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ObtainCouponItemModel obtainCouponItemModel5 = ObtainCouponItemModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ObtainCouponItemModel.this.getStatus();
                                    }
                                };
                                final ObtainCouponItemModel obtainCouponItemModel6 = ObtainCouponItemModel.this;
                                BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final ObtainCouponItemModel obtainCouponItemModel7 = ObtainCouponItemModel.this;
                                        cg.a(bindDirectivesView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ObtainCouponItemModel obtainCouponItemModel8 = ObtainCouponItemModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponItemView.body.1.1.3.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        ceVar2.value(ObtainCouponItemModel.this.getStatus().text);
                                                        AttrExtKt.colorToken(ceVar2, ObtainCouponItemModel.this.getStatus().colorToken);
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ObtainCouponItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ObtainCouponItemModel getItem() {
        ObtainCouponItemModel obtainCouponItemModel = ((ObtainCouponItemAttr) getAttr()).couponItem;
        if (obtainCouponItemModel != null) {
            return obtainCouponItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("couponItem");
        return null;
    }
}
