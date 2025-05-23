package com.tencent.ecommerce.biz.orders.address;

import com.tencent.ecommerce.repo.ServiceLocator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECEditAddressViewModel$addAddress$1", f = "ECEditAddressViewModel.kt", i = {0}, l = {21, 22}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECEditAddressViewModel$addAddress$1 extends SuspendLambda implements Function2<FlowCollector<? super ECAddress>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECAddress $address;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECEditAddressViewModel$addAddress$1(ECAddress eCAddress, Continuation continuation) {
        super(2, continuation);
        this.$address = eCAddress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECEditAddressViewModel$addAddress$1 eCEditAddressViewModel$addAddress$1 = new ECEditAddressViewModel$addAddress$1(this.$address, continuation);
        eCEditAddressViewModel$addAddress$1.L$0 = obj;
        return eCEditAddressViewModel$addAddress$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ECAddress> flowCollector, Continuation<? super Unit> continuation) {
        return ((ECEditAddressViewModel$addAddress$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            IECAddressRepository b16 = ServiceLocator.f104891i.b();
            ECAddress eCAddress = this.$address;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = b16.addAddress(eCAddress, this);
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
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit((ECAddress) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
