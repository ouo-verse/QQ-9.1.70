package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aigc.IZPlanAIGCHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$buyCouponRequest$1", f = "ShoppingCartControl.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ShoppingCartControl$buyCouponRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Long> $callback;
    final /* synthetic */ long $totalCount;
    int label;
    final /* synthetic */ ShoppingCartControl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShoppingCartControl$buyCouponRequest$1(long j3, com.tencent.mobileqq.zootopia.api.e<Long> eVar, ShoppingCartControl shoppingCartControl, Continuation<? super ShoppingCartControl$buyCouponRequest$1> continuation) {
        super(2, continuation);
        this.$totalCount = j3;
        this.$callback = eVar;
        this.this$0 = shoppingCartControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShoppingCartControl$buyCouponRequest$1(this.$totalCount, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                IZPlanAIGCHelper iZPlanAIGCHelper = (IZPlanAIGCHelper) QRoute.api(IZPlanAIGCHelper.class);
                long j16 = this.$totalCount;
                this.label = 1;
                obj = iZPlanAIGCHelper.requestBuyAIGCCoupon(j16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = ((Number) obj).longValue();
        } catch (Throwable th5) {
            QLog.e("ShoppingCart_", 1, "buyCouponRequest failed.", th5);
            j3 = -1;
        }
        if (j3 < 1) {
            this.$callback.onResultFailure(-100, "request buy coupon failed.");
            ShoppingCartControl shoppingCartControl = this.this$0;
            String string = shoppingCartControl.getContext().getResources().getString(R.string.xm6);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.string.zplan_bug_failed)");
            ShoppingCartControl.H(shoppingCartControl, string, false, 2, null);
            return Unit.INSTANCE;
        }
        this.$callback.onResultSuccess(Boxing.boxLong(j3));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShoppingCartControl$buyCouponRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
