package com.tencent.ecommerce.repo.aftersale.apply;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyRepo$submitApplyDataReq$2", f = "ECAfterSaleApplyRepo.kt", i = {}, l = {137, 150}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyRepo$submitApplyDataReq$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $afterSalesId;
    final /* synthetic */ ECAfterSaleApplyExtraItem $extraItem;
    final /* synthetic */ String $orderId;
    final /* synthetic */ PageType $pageType;
    final /* synthetic */ String $processId;
    final /* synthetic */ String $skuId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAfterSaleApplyRepo$submitApplyDataReq$2(PageType pageType, String str, ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem, String str2, String str3, String str4, Continuation continuation) {
        super(2, continuation);
        this.$pageType = pageType;
        this.$orderId = str;
        this.$extraItem = eCAfterSaleApplyExtraItem;
        this.$skuId = str2;
        this.$processId = str3;
        this.$afterSalesId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAfterSaleApplyRepo$submitApplyDataReq$2(this.$pageType, this.$orderId, this.$extraItem, this.$skuId, this.$processId, this.$afterSalesId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ECAfterSaleApplyRepo$submitApplyDataReq$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0117, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0115, code lost:
    
        if (r13.getCode() != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00c0, code lost:
    
        if (r13.getCode() != 0) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = false;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b("ECAfterSaleApplyRepo", "submitApplyPageData pageType:" + this.$pageType + ", orderId:" + this.$orderId + ", extraItem:" + this.$extraItem);
            int i16 = h.f104940b[this.$pageType.ordinal()];
            if (i16 == 1 || i16 == 2) {
                if (this.$pageType == PageType.PAGE_TYPE_REFUND_ONLY) {
                    ECAfterSaleApplyRepo eCAfterSaleApplyRepo = ECAfterSaleApplyRepo.f104899h;
                    eCAfterSaleApplyInfo = ECAfterSaleApplyRepo.onlyRefundInfo;
                } else {
                    ECAfterSaleApplyRepo eCAfterSaleApplyRepo2 = ECAfterSaleApplyRepo.f104899h;
                    eCAfterSaleApplyInfo = ECAfterSaleApplyRepo.returnAndRefundInfo;
                }
                JSONObject encodeParams = new i(this.$orderId, this.$skuId, this.$processId, eCAfterSaleApplyInfo, this.$extraItem).encodeParams();
                Intrinsics.checkNotNull(encodeParams);
                com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                this.label = 1;
                obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/SubmitAfterSales", bVar, encodeParams, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECAfterSaleApplyRepo", "submitApplySubmitReq rsp:" + eCNetworkResponse);
            } else if (i16 != 3) {
                cg0.a.a("ECAfterSaleApplyRepo", "submitApplyPageData", "wrong pageType: " + this.$pageType);
            } else {
                JSONObject encodeParams2 = new f(this.$afterSalesId, this.$processId, this.$extraItem).encodeParams();
                Intrinsics.checkNotNull(encodeParams2);
                com.tencent.ecommerce.base.network.api.b bVar2 = com.tencent.ecommerce.base.network.api.b.f100803a;
                this.label = 2;
                obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/ApplyJudgement", bVar2, encodeParams2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj;
                cg0.a.b("ECAfterSaleApplyRepo", "submitApplyJudgementSubmitReq rsp:" + eCNetworkResponse2);
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            ECNetworkResponse eCNetworkResponse3 = (ECNetworkResponse) obj;
            cg0.a.b("ECAfterSaleApplyRepo", "submitApplySubmitReq rsp:" + eCNetworkResponse3);
        } else if (i3 == 2) {
            ResultKt.throwOnFailure(obj);
            ECNetworkResponse eCNetworkResponse22 = (ECNetworkResponse) obj;
            cg0.a.b("ECAfterSaleApplyRepo", "submitApplyJudgementSubmitReq rsp:" + eCNetworkResponse22);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z16);
    }
}
