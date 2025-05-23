package com.tencent.mobileqq.zplan.aigc.impl;

import android.view.View;
import com.tencent.mobileqq.zplan.aigc.IZPlanAIGCHelper;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import zd3.d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0019\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/impl/ZPlanAIGCHelperImpl;", "Lcom/tencent/mobileqq/zplan/aigc/IZPlanAIGCHelper;", "()V", "reportZPlanAIGCCouponBuyClick", "", "view", "Landroid/view/View;", "payNum", "", "payPrice", "", "requestBuyAIGCCoupon", "buyCount", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanAIGCHelperImpl implements IZPlanAIGCHelper {
    @Override // com.tencent.mobileqq.zplan.aigc.IZPlanAIGCHelper
    public void reportZPlanAIGCCouponBuyClick(View view, long payNum, int payPrice) {
        Intrinsics.checkNotNullParameter(view, "view");
        d.f452376a.e(view, payNum, payPrice);
    }

    @Override // com.tencent.mobileqq.zplan.aigc.IZPlanAIGCHelper
    public Object requestBuyAIGCCoupon(long j3, Continuation<? super Long> continuation) {
        return ZPlanAIGCRequest.f335341a.f(j3, continuation);
    }
}
