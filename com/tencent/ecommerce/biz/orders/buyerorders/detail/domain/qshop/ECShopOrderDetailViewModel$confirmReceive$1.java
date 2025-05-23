package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.buyerorder.orderlist.f;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.luggage.wxa.nf.f;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECShopOrderDetailViewModel$confirmReceive$1", f = "ECShopOrderDetailViewModel.kt", i = {2}, l = {com.tencent.mm.plugin.appbrand.jsapi.coverview.a.CTRL_INDEX, 346, f.b.CTRL_INDEX}, m = "invokeSuspend", n = {"opResult"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopOrderDetailViewModel$confirmReceive$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    Object L$0;
    int label;
    final /* synthetic */ ECShopOrderDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopOrderDetailViewModel$confirmReceive$1(ECShopOrderDetailViewModel eCShopOrderDetailViewModel, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = eCShopOrderDetailViewModel;
        this.$orderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ECShopOrderDetailViewModel$confirmReceive$1(this.this$0, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ECShopOrderDetailViewModel$confirmReceive$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String o26;
        MutableSharedFlow mutableSharedFlow;
        String str;
        String str2;
        com.tencent.ecommerce.repo.buyerorder.orderlist.d dVar;
        String str3;
        com.tencent.ecommerce.repo.buyerorder.orderlist.f fVar;
        MutableSharedFlow mutableSharedFlow2;
        com.tencent.ecommerce.repo.buyerorder.orderlist.f fVar2;
        ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(this.$orderId.length() == 0)) {
                str2 = this.this$0.token;
                if (!(str2.length() == 0)) {
                    dVar = this.this$0.operateRepository;
                    String str4 = this.$orderId;
                    str3 = this.this$0.token;
                    this.label = 2;
                    obj = dVar.d(str4, str3, true, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fVar = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) obj;
                    if (fVar instanceof f.Failed) {
                    }
                    eCOrderInfo$OrderInfo = fVar.latestOrderInfo;
                    if (eCOrderInfo$OrderInfo != null) {
                    }
                    ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.ConfirmReceive, fVar.requestInfo, null, 16, null);
                    return Unit.INSTANCE;
                }
            }
            o26 = this.this$0.o2(this.$orderId);
            cg0.a.a("ECShopOrderDetailViewModel", "confirmReceive", o26);
            mutableSharedFlow = this.this$0._toastEvent;
            str = this.this$0.paramsErrorMsg;
            OrderDetailToastEvent orderDetailToastEvent = new OrderDetailToastEvent(str, ECToastIcon.ICON_ERROR);
            this.label = 1;
            if (mutableSharedFlow.emit(orderDetailToastEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                fVar2 = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                fVar = fVar2;
                eCOrderInfo$OrderInfo = fVar.latestOrderInfo;
                if (eCOrderInfo$OrderInfo != null) {
                    this.this$0.N2(eCOrderInfo$OrderInfo);
                }
                ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.ConfirmReceive, fVar.requestInfo, null, 16, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        fVar = (com.tencent.ecommerce.repo.buyerorder.orderlist.f) obj;
        if (fVar instanceof f.Failed) {
            mutableSharedFlow2 = this.this$0._alertDialogEvent;
            String str5 = ((f.Failed) fVar).errorMsg;
            this.L$0 = fVar;
            this.label = 3;
            if (mutableSharedFlow2.emit(str5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            fVar2 = fVar;
            fVar = fVar2;
        }
        eCOrderInfo$OrderInfo = fVar.latestOrderInfo;
        if (eCOrderInfo$OrderInfo != null) {
        }
        ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.ConfirmReceive, fVar.requestInfo, null, 16, null);
        return Unit.INSTANCE;
    }
}
