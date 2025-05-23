package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$OrderDetail;
import com.tencent.ecommerce.repo.sampleorder.d;
import com.tencent.ecommerce.repo.sampleorder.e;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample.ECSampleOrderDetailViewModel$updateAddressInfo$1", f = "ECSampleOrderDetailViewModel.kt", i = {2, 3}, l = {173, 177, 180, 182}, m = "invokeSuspend", n = {"opResult", "opResult"}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECSampleOrderDetailViewModel$updateAddressInfo$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ECAddress $newAddress;
    final /* synthetic */ String $orderId;
    Object L$0;
    int label;
    final /* synthetic */ ECSampleOrderDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSampleOrderDetailViewModel$updateAddressInfo$1(ECSampleOrderDetailViewModel eCSampleOrderDetailViewModel, String str, ECAddress eCAddress, Continuation continuation) {
        super(1, continuation);
        this.this$0 = eCSampleOrderDetailViewModel;
        this.$orderId = str;
        this.$newAddress = eCAddress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ECSampleOrderDetailViewModel$updateAddressInfo$1(this.this$0, this.$orderId, this.$newAddress, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ECSampleOrderDetailViewModel$updateAddressInfo$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String h26;
        MutableSharedFlow mutableSharedFlow;
        String str;
        String str2;
        d dVar;
        String str3;
        e eVar;
        MutableSharedFlow mutableSharedFlow2;
        e eVar2;
        MutableSharedFlow mutableSharedFlow3;
        String str4;
        ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(this.$orderId.length() == 0)) {
                str2 = this.this$0.token;
                if (!(str2.length() == 0)) {
                    dVar = this.this$0.operateRepository;
                    String str5 = this.$orderId;
                    str3 = this.this$0.token;
                    ECAddress eCAddress = this.$newAddress;
                    this.label = 2;
                    obj = dVar.d(str5, str3, eCAddress, true, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eVar = (e) obj;
                    if (!(eVar instanceof e.Succeed)) {
                    }
                    eVar2 = eVar;
                    eVar = eVar2;
                    eCQshopSampleSvr$OrderDetail = eVar.latestOrderInfo;
                    if (eCQshopSampleSvr$OrderDetail != null) {
                    }
                    ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.UpdateAddress, eVar.requestInfo, null, 16, null);
                    return Unit.INSTANCE;
                }
            }
            h26 = this.this$0.h2(this.$orderId);
            cg0.a.a("ECSampleOrderDetailViewModel", "updateAddressInfo", h26);
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
            if (i3 != 3 && i3 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar2 = (e) this.L$0;
            ResultKt.throwOnFailure(obj);
            eVar = eVar2;
            eCQshopSampleSvr$OrderDetail = eVar.latestOrderInfo;
            if (eCQshopSampleSvr$OrderDetail != null) {
                this.this$0.y2(eCQshopSampleSvr$OrderDetail);
            }
            ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.UpdateAddress, eVar.requestInfo, null, 16, null);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        eVar = (e) obj;
        if (!(eVar instanceof e.Succeed)) {
            mutableSharedFlow3 = this.this$0._toastEvent;
            str4 = this.this$0.modifyAddressSucceedTips;
            OrderDetailToastEvent orderDetailToastEvent2 = new OrderDetailToastEvent(str4, ECToastIcon.ICON_SUCCESS);
            this.L$0 = eVar;
            this.label = 3;
            if (mutableSharedFlow3.emit(orderDetailToastEvent2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (eVar instanceof e.Failed) {
                mutableSharedFlow2 = this.this$0._alertDialogEvent;
                String str6 = ((e.Failed) eVar).errorMsg;
                this.L$0 = eVar;
                this.label = 4;
                if (mutableSharedFlow2.emit(str6, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            eCQshopSampleSvr$OrderDetail = eVar.latestOrderInfo;
            if (eCQshopSampleSvr$OrderDetail != null) {
            }
            ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.UpdateAddress, eVar.requestInfo, null, 16, null);
            return Unit.INSTANCE;
        }
        eVar2 = eVar;
        eVar = eVar2;
        eCQshopSampleSvr$OrderDetail = eVar.latestOrderInfo;
        if (eCQshopSampleSvr$OrderDetail != null) {
        }
        ECOrderSpan.c(ECOrderSpan.f103884c, this.$orderId, ECOrderSpanScene.OrderDetail, ECOrderOperation.UpdateAddress, eVar.requestInfo, null, 16, null);
        return Unit.INSTANCE;
    }
}
