package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CommonCouponContanerViewKt {
    public static final void CommonCouponContainerView(ViewContainer<?, ?> viewContainer, final Function1<? super ViewContainer<?, ?>, Unit> function1) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponContanerViewKt$CommonCouponContainerView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponContanerViewKt$CommonCouponContainerView$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.marginBottom(12.0f);
                        tVar2.mo141height(104.0f);
                        return Unit.INSTANCE;
                    }
                });
                function1.invoke(vVar2);
                return Unit.INSTANCE;
            }
        });
    }
}
