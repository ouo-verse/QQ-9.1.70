package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.ecommerce.repo.buyerorder.b;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListOperateViewModel$payOrder$1", f = "ECOrderListOperateViewModel.kt", i = {}, l = {104, 108, 111, 121}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderListOperateViewModel$payOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $payParams;
    final /* synthetic */ int $payTypeId;
    final /* synthetic */ long $price;
    final /* synthetic */ int $productType;
    final /* synthetic */ List $spuIds;
    int label;
    final /* synthetic */ ECOrderListOperateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderListOperateViewModel$payOrder$1(ECOrderListOperateViewModel eCOrderListOperateViewModel, String str, String str2, int i3, long j3, List list, int i16, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderListOperateViewModel;
        this.$payParams = str;
        this.$orderId = str2;
        this.$payTypeId = i3;
        this.$price = j3;
        this.$spuIds = list;
        this.$productType = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderListOperateViewModel$payOrder$1(this.this$0, this.$payParams, this.$orderId, this.$payTypeId, this.$price, this.$spuIds, this.$productType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderListOperateViewModel$payOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.repo.buyerorder.b U1;
        MutableSharedFlow mutableSharedFlow;
        String str;
        b.OrderPayStatusResult orderPayStatusResult;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$payParams.length() == 0) {
                cg0.a.a("ECOrderListOperateViewModel", "payOrder", "payParams is empty.");
                mutableSharedFlow = this.this$0._toastEvent;
                str = this.this$0.errorTip;
                OrderListToastEvent orderListToastEvent = new OrderListToastEvent(str, ECToastIcon.ICON_ERROR);
                this.label = 1;
                if (mutableSharedFlow.emit(orderListToastEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            cg0.a.b("ECOrderListOperateViewModel", "payOrder: orderId=" + this.$orderId + " payTypeId=" + this.$payTypeId);
            U1 = this.this$0.U1();
            String str2 = this.$orderId;
            String str3 = this.$payParams;
            this.label = 2;
            obj = U1.b(str2, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            orderPayStatusResult = (b.OrderPayStatusResult) obj;
            if (orderPayStatusResult.status != PayStatus.UNPAID) {
            }
        } else {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                orderPayStatusResult = (b.OrderPayStatusResult) obj;
                if (orderPayStatusResult.status != PayStatus.UNPAID) {
                    mutableSharedFlow3 = this.this$0._payOrderEvent;
                    PayOrderEventInfo payOrderEventInfo = new PayOrderEventInfo(this.$payParams, this.$orderId, this.$price, this.$spuIds, this.$productType, this.$payTypeId);
                    this.label = 3;
                    if (mutableSharedFlow3.emit(payOrderEventInfo, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (orderPayStatusResult.alertMsg.length() > 0) {
                        mutableSharedFlow2 = this.this$0._toastEvent;
                        OrderListToastEvent orderListToastEvent2 = new OrderListToastEvent(orderPayStatusResult.alertMsg, ECToastIcon.ICON_ERROR);
                        this.label = 4;
                        if (mutableSharedFlow2.emit(orderListToastEvent2, this) == coroutine_suspended) {
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
