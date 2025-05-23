package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.ecommerce.biz.router.ECScheme;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$dealBlindBoxPayResult$1", f = "ECShopOrderDetailFragment.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopOrderDetailFragment$dealBlindBoxPayResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $loadingDialog;
    final /* synthetic */ String $orderId;
    final /* synthetic */ IECPayApi.PayResult $payResult;
    final /* synthetic */ String $spuId;
    int label;
    final /* synthetic */ ECShopOrderDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopOrderDetailFragment$dealBlindBoxPayResult$1(ECShopOrderDetailFragment eCShopOrderDetailFragment, IECPayApi.PayResult payResult, String str, String str2, d dVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopOrderDetailFragment;
        this.$payResult = payResult;
        this.$orderId = str;
        this.$spuId = str2;
        this.$loadingDialog = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopOrderDetailFragment$dealBlindBoxPayResult$1(this.this$0, this.$payResult, this.$orderId, this.$spuId, this.$loadingDialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopOrderDetailFragment$dealBlindBoxPayResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean isBlank;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io5 = Dispatchers.getIO();
            ECShopOrderDetailFragment$dealBlindBoxPayResult$1$url$1 eCShopOrderDetailFragment$dealBlindBoxPayResult$1$url$1 = new ECShopOrderDetailFragment$dealBlindBoxPayResult$1$url$1(this, null);
            this.label = 1;
            obj = BuildersKt.withContext(io5, eCShopOrderDetailFragment$dealBlindBoxPayResult$1$url$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
            }
        }
        if (!z16) {
            this.this$0.li().B2(this.$orderId);
            ECScheme.g(str, null, 2, null);
        }
        this.$loadingDialog.dismiss();
        return Unit.INSTANCE;
    }
}
