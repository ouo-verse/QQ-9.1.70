package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel$updateAddress$1", f = "ECApplySampleOrderListViewModel.kt", i = {}, l = {54, 54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListViewModel$updateAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECAddress $newAddress;
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $token;
    Object L$0;
    int label;
    final /* synthetic */ ECApplySampleOrderListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleOrderListViewModel$updateAddress$1(ECApplySampleOrderListViewModel eCApplySampleOrderListViewModel, String str, String str2, ECAddress eCAddress, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCApplySampleOrderListViewModel;
        this.$orderId = str;
        this.$token = str2;
        this.$newAddress = eCAddress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECApplySampleOrderListViewModel$updateAddress$1(this.this$0, this.$orderId, this.$token, this.$newAddress, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECApplySampleOrderListViewModel$updateAddress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        com.tencent.ecommerce.repo.sampleorder.d dVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableSharedFlow = this.this$0._operateEvent;
            dVar = this.this$0.repo;
            String str = this.$orderId;
            String str2 = this.$token;
            ECAddress eCAddress = this.$newAddress;
            this.L$0 = mutableSharedFlow;
            this.label = 1;
            obj = d.a.a(dVar, str, str2, eCAddress, false, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableSharedFlow = (MutableSharedFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ECApplySampleOrderListViewModel.b.e eVar = new ECApplySampleOrderListViewModel.b.e((com.tencent.ecommerce.repo.sampleorder.e) obj);
        this.L$0 = null;
        this.label = 2;
        if (mutableSharedFlow.emit(eVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
