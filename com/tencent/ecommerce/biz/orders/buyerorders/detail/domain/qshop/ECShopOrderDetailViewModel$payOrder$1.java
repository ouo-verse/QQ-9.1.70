package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.ecommerce.repo.buyerorder.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECShopOrderDetailViewModel$payOrder$1", f = "ECShopOrderDetailViewModel.kt", i = {1}, l = {396, 400, 403, 405}, m = "invokeSuspend", n = {"payParams"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopOrderDetailViewModel$payOrder$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    Object L$0;
    int label;
    final /* synthetic */ ECShopOrderDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopOrderDetailViewModel$payOrder$1(ECShopOrderDetailViewModel eCShopOrderDetailViewModel, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = eCShopOrderDetailViewModel;
        this.$orderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ECShopOrderDetailViewModel$payOrder$1(this.this$0, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ECShopOrderDetailViewModel$payOrder$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        com.tencent.ecommerce.repo.buyerorder.b bVar;
        MutableSharedFlow mutableSharedFlow;
        String str2;
        b.OrderPayStatusResult orderPayStatusResult;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.t2().getValue().payInfo.payParams;
            if (!(str.length() == 0)) {
                bVar = this.this$0.orderRepository;
                String str3 = this.$orderId;
                this.L$0 = str;
                this.label = 2;
                obj = bVar.b(str3, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                orderPayStatusResult = (b.OrderPayStatusResult) obj;
                if (orderPayStatusResult.status != PayStatus.UNPAID) {
                }
            } else {
                cg0.a.a("ECShopOrderDetailViewModel", "payOrder", "payParams is empty.");
                mutableSharedFlow = this.this$0._toastEvent;
                str2 = this.this$0.paramsErrorMsg;
                OrderDetailToastEvent orderDetailToastEvent = new OrderDetailToastEvent(str2, ECToastIcon.ICON_ERROR);
                this.label = 1;
                if (mutableSharedFlow.emit(orderDetailToastEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i3 == 2) {
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                orderPayStatusResult = (b.OrderPayStatusResult) obj;
                if (orderPayStatusResult.status != PayStatus.UNPAID) {
                    int i16 = this.this$0.t2().getValue().payInfo.payType.id;
                    mutableSharedFlow3 = this.this$0._payOrderEvent;
                    PayOrderEventInfo payOrderEventInfo = new PayOrderEventInfo(str, i16);
                    this.L$0 = null;
                    this.label = 3;
                    if (mutableSharedFlow3.emit(payOrderEventInfo, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (orderPayStatusResult.alertMsg.length() > 0) {
                        mutableSharedFlow2 = this.this$0._alertDialogEvent;
                        String str4 = orderPayStatusResult.alertMsg;
                        this.L$0 = null;
                        this.label = 4;
                        if (mutableSharedFlow2.emit(str4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else {
                if (i3 != 3 && i3 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        return Unit.INSTANCE;
    }
}
