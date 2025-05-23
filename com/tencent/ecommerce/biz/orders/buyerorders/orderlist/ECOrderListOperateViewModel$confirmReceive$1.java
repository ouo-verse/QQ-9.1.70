package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListOperateViewModel$confirmReceive$1", f = "ECOrderListOperateViewModel.kt", i = {1}, l = {62, 64}, m = "invokeSuspend", n = {"opResult"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECOrderListOperateViewModel$confirmReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ OrderListScene $scene;
    final /* synthetic */ String $token;
    Object L$0;
    int label;
    final /* synthetic */ ECOrderListOperateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderListOperateViewModel$confirmReceive$1(ECOrderListOperateViewModel eCOrderListOperateViewModel, String str, String str2, OrderListScene orderListScene, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderListOperateViewModel;
        this.$orderId = str;
        this.$token = str2;
        this.$scene = orderListScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderListOperateViewModel$confirmReceive$1(this.this$0, this.$orderId, this.$token, this.$scene, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderListOperateViewModel$confirmReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.repo.buyerorder.orderlist.d dVar;
        com.tencent.ecommerce.repo.buyerorder.orderlist.f fVar;
        MutableSharedFlow mutableSharedFlow;
        String str;
        com.tencent.ecommerce.repo.buyerorder.orderlist.f fVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            dVar = this.this$0.operateRepository;
            String str2 = this.$orderId;
            String str3 = this.$token;
            this.label = 1;
            obj = d.a.b(dVar, str2, str3, false, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    fVar2 = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    fVar = fVar2;
                    ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, g.a(this.$scene), ECOrderOperation.ConfirmReceive, fVar.requestInfo, null, 16, null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fVar = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) obj;
        if (fVar instanceof f.Failed) {
            mutableSharedFlow = this.this$0._toastEvent;
            str = this.this$0.errorTip;
            OrderListToastEvent orderListToastEvent = new OrderListToastEvent(str, ECToastIcon.ICON_ERROR);
            this.L$0 = fVar;
            this.label = 2;
            if (mutableSharedFlow.emit(orderListToastEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            fVar2 = fVar;
            fVar = fVar2;
        }
        ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, g.a(this.$scene), ECOrderOperation.ConfirmReceive, fVar.requestInfo, null, 16, null);
        return Unit.INSTANCE;
    }
}
