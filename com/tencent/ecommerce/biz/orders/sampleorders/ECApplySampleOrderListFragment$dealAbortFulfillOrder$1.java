package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$dealAbortFulfillOrder$1", f = "ECApplySampleOrderListFragment.kt", i = {}, l = {452}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListFragment$dealAbortFulfillOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECApplySampleOrderListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleOrderListFragment$dealAbortFulfillOrder$1(ECApplySampleOrderListFragment eCApplySampleOrderListFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCApplySampleOrderListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECApplySampleOrderListFragment$dealAbortFulfillOrder$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECApplySampleOrderListFragment$dealAbortFulfillOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e fi5;
        ECApplySampleQueryType eCApplySampleQueryType;
        Set<? extends ECApplySampleQueryType> of5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            fi5 = this.this$0.fi();
            eCApplySampleQueryType = this.this$0.queryType;
            of5 = SetsKt__SetsKt.setOf((Object[]) new ECApplySampleQueryType[]{eCApplySampleQueryType, ECApplySampleQueryType.ALL, ECApplySampleQueryType.FULFILLING, ECApplySampleQueryType.AUDITING});
            this.label = 1;
            if (fi5.N1(of5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
