package com.tencent.ecommerce.biz.applysample;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.sampleorder.ECAbortFulfillOption;
import com.tencent.ecommerce.repo.sampleorder.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel$requestAbortFulfillOrderReasonOption$1", f = "ECAbortFulfillOrderViewModel.kt", i = {}, l = {35, 38, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAbortFulfillOrderViewModel$requestAbortFulfillOrderReasonOption$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $oderId;
    int label;
    final /* synthetic */ ECAbortFulfillOrderViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAbortFulfillOrderViewModel$requestAbortFulfillOrderReasonOption$1(ECAbortFulfillOrderViewModel eCAbortFulfillOrderViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAbortFulfillOrderViewModel;
        this.$oderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAbortFulfillOrderViewModel$requestAbortFulfillOrderReasonOption$1(this.this$0, this.$oderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAbortFulfillOrderViewModel$requestAbortFulfillOrderReasonOption$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            d d16 = ServiceLocator.f104891i.d();
            String str = this.$oderId;
            this.label = 1;
            obj = d16.a(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        ECAbortFulfillOption eCAbortFulfillOption = (ECAbortFulfillOption) eCNetworkResponse.b();
        if (eCAbortFulfillOption == null) {
            mutableStateFlow2 = this.this$0._uiState;
            ECAbortFulfillOrderViewModel.a.C1041a c1041a = new ECAbortFulfillOrderViewModel.a.C1041a(eCNetworkResponse.getCode(), eCNetworkResponse.getMessage());
            this.label = 2;
            if (mutableStateFlow2.emit(c1041a, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            mutableStateFlow = this.this$0._uiState;
            ECAbortFulfillOrderViewModel.a.c cVar = new ECAbortFulfillOrderViewModel.a.c(eCAbortFulfillOption);
            this.label = 3;
            if (mutableStateFlow.emit(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
