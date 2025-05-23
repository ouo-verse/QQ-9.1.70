package com.tencent.mobileqq.zplan.aigc;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \r2\u00020\u0001:\u0001\u000eJ\u001b\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/IZPlanAIGCHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "buyCount", "requestBuyAIGCCoupon", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/View;", "view", "payNum", "", "payPrice", "", "reportZPlanAIGCCouponBuyClick", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZPlanAIGCHelper extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f329866a;
    public static final long INVALID_COUPON_COUNT = -1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/IZPlanAIGCHelper$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.IZPlanAIGCHelper$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f329866a = new Companion();

        Companion() {
        }
    }

    void reportZPlanAIGCCouponBuyClick(@NotNull View view, long payNum, int payPrice);

    @Nullable
    Object requestBuyAIGCCoupon(long j3, @NotNull Continuation<? super Long> continuation);
}
