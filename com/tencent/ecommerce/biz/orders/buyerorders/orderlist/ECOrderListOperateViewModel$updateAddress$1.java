package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.repo.buyerorder.orderlist.d;
import com.tencent.ecommerce.repo.buyerorder.orderlist.f;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListOperateViewModel$updateAddress$1", f = "ECOrderListOperateViewModel.kt", i = {1, 2}, l = {82, 85, 88}, m = "invokeSuspend", n = {"opResult", "opResult"}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECOrderListOperateViewModel$updateAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECAddress $newAddress;
    final /* synthetic */ String $orderId;
    final /* synthetic */ OrderListScene $scene;
    final /* synthetic */ String $token;
    Object L$0;
    int label;
    final /* synthetic */ ECOrderListOperateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderListOperateViewModel$updateAddress$1(ECOrderListOperateViewModel eCOrderListOperateViewModel, String str, String str2, ECAddress eCAddress, OrderListScene orderListScene, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderListOperateViewModel;
        this.$orderId = str;
        this.$token = str2;
        this.$newAddress = eCAddress;
        this.$scene = orderListScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderListOperateViewModel$updateAddress$1(this.this$0, this.$orderId, this.$token, this.$newAddress, this.$scene, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderListOperateViewModel$updateAddress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.repo.buyerorder.orderlist.d dVar;
        MutableSharedFlow mutableSharedFlow;
        String str;
        com.tencent.ecommerce.repo.buyerorder.orderlist.f fVar;
        MutableSharedFlow mutableSharedFlow2;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            dVar = this.this$0.operateRepository;
            String str3 = this.$orderId;
            String str4 = this.$token;
            ECAddress eCAddress = this.$newAddress;
            this.label = 1;
            obj = d.a.c(dVar, str3, str4, eCAddress, false, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fVar = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                r14 = fVar;
                ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, g.a(this.$scene), ECOrderOperation.UpdateAddress, r14.requestInfo, null, 16, null);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        com.tencent.ecommerce.repo.buyerorder.orderlist.f fVar2 = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) obj;
        if (fVar2 instanceof f.Failed) {
            mutableSharedFlow2 = this.this$0._toastEvent;
            str2 = this.this$0.errorTip;
            OrderListToastEvent orderListToastEvent = new OrderListToastEvent(str2, ECToastIcon.ICON_ERROR);
            this.L$0 = fVar2;
            this.label = 2;
            if (mutableSharedFlow2.emit(orderListToastEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (fVar2 instanceof f.Succeed) {
                mutableSharedFlow = this.this$0._toastEvent;
                str = this.this$0.modifyAddressSucceedTips;
                OrderListToastEvent orderListToastEvent2 = new OrderListToastEvent(str, ECToastIcon.ICON_SUCCESS);
                this.L$0 = fVar2;
                this.label = 3;
                if (mutableSharedFlow.emit(orderListToastEvent2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, g.a(this.$scene), ECOrderOperation.UpdateAddress, fVar2.requestInfo, null, 16, null);
            return Unit.INSTANCE;
        }
        fVar = fVar2;
        fVar2 = fVar;
        ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, g.a(this.$scene), ECOrderOperation.UpdateAddress, fVar2.requestInfo, null, 16, null);
        return Unit.INSTANCE;
    }
}
