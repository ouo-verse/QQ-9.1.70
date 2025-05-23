package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel$cancelApplyAbortConsign$1", f = "ECApplySampleOrderListViewModel.kt", i = {}, l = {36, 37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListViewModel$cancelApplyAbortConsign$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ ECApplySampleOrderListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleOrderListViewModel$cancelApplyAbortConsign$1(ECApplySampleOrderListViewModel eCApplySampleOrderListViewModel, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCApplySampleOrderListViewModel;
        this.$orderId = str;
        this.$token = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECApplySampleOrderListViewModel$cancelApplyAbortConsign$1(this.this$0, this.$orderId, this.$token, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECApplySampleOrderListViewModel$cancelApplyAbortConsign$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.repo.sampleorder.d dVar;
        MutableSharedFlow mutableSharedFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            dVar = this.this$0.repo;
            String str = this.$orderId;
            String str2 = this.$token;
            this.label = 1;
            obj = dVar.g(str, str2, this);
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
            ResultKt.throwOnFailure(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        mutableSharedFlow = this.this$0._operateEvent;
        ECApplySampleOrderListViewModel.b.C1079b c1079b = new ECApplySampleOrderListViewModel.b.C1079b(booleanValue);
        this.label = 2;
        if (mutableSharedFlow.emit(c1079b, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
