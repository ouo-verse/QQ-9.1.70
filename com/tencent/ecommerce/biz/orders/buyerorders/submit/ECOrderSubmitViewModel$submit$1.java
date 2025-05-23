package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.report.api.IECMobileReportManager;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$BriefYiFanAward;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CaptchaToken;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderResult;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$OrderCommitBizErrorMsg;
import com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$submit$1", f = "ECOrderSubmitViewModel.kt", i = {1, 3, 4, 6, 6, 7, 7}, l = {643, 648, MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, 682, 716, 733, 749, com.tencent.luggage.wxa.sm.e.Q}, m = "invokeSuspend", n = {"address", "remoteResponse", "riskControlLimitCount", "remoteResponse", "submitResult", "remoteResponse", "submitResult"}, s = {"L$0", "L$0", "I$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECQshopOrderSvr$CaptchaToken $captchaToken;
    final /* synthetic */ boolean $hasDoubleCheckVirtualProductAccount;
    final /* synthetic */ boolean $isUserAction;
    final /* synthetic */ OrderSubmitDetailInfo $orderDetail;
    final /* synthetic */ ECQshopOrderQuerySvr$OrderPageDetailRsp $orderRsp;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$submit$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, OrderSubmitDetailInfo orderSubmitDetailInfo, boolean z16, boolean z17, ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitViewModel;
        this.$orderDetail = orderSubmitDetailInfo;
        this.$isUserAction = z16;
        this.$hasDoubleCheckVirtualProductAccount = z17;
        this.$orderRsp = eCQshopOrderQuerySvr$OrderPageDetailRsp;
        this.$captchaToken = eCQshopOrderSvr$CaptchaToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitViewModel$submit$1(this.this$0, this.$orderDetail, this.$isUserAction, this.$hasDoubleCheckVirtualProductAccount, this.$orderRsp, this.$captchaToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderSubmitViewModel$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0313 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0173 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0356 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0163 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECAddress eCAddress;
        Object s26;
        MutableSharedFlow mutableSharedFlow;
        MutableLiveData mutableLiveData;
        IECOrderSubmitRepo iECOrderSubmitRepo;
        String str;
        String str2;
        String str3;
        String str4;
        Boolean bool;
        List<ECOrderCommon$BriefYiFanAward> list;
        String str5;
        String str6;
        Object submit;
        Object obj2;
        ECNetworkResponse<?> eCNetworkResponse;
        String str7;
        MutableSharedFlow mutableSharedFlow2;
        ECOrderSubmitViewModel.h.SubmitFailedResult submitFailedResult;
        MutableLiveData mutableLiveData2;
        ECOrderSubmitViewModel.h.SubmitSucceedResult Y2;
        MutableSharedFlow mutableSharedFlow3;
        ECNetworkResponse<?> eCNetworkResponse2;
        ECOrderSubmitViewModel.h.SubmitSucceedResult submitSucceedResult;
        Map<String, String> mapOf;
        MutableSharedFlow mutableSharedFlow4;
        MutableLiveData mutableLiveData3;
        MutableSharedFlow mutableSharedFlow5;
        int i3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        MutableLiveData mutableLiveData7;
        MutableSharedFlow mutableSharedFlow6;
        ECOrderSubmitViewModel.OrderSubmitReportInfo b16;
        ECNetworkResponse<?> eCNetworkResponse3;
        Map<String, String> mapOf2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                OrderSubmitDetailInfo orderSubmitDetailInfo = this.$orderDetail;
                eCAddress = orderSubmitDetailInfo.address;
                com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar = orderSubmitDetailInfo.orderSkusDetail.productType;
                if ((jVar instanceof j.PhysicalProduct) && eCAddress == null) {
                    mutableSharedFlow = this.this$0._submitResult;
                    ECOrderSubmitViewModel.h.SubmitFailedResult submitFailedResult2 = new ECOrderSubmitViewModel.h.SubmitFailedResult(0, -1111, null, 5, null);
                    this.label = 1;
                    if (mutableSharedFlow.emit(submitFailedResult2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (jVar instanceof j.VirtualProduct) {
                    boolean z16 = this.$isUserAction;
                    boolean z17 = this.$hasDoubleCheckVirtualProductAccount;
                    this.L$0 = eCAddress;
                    this.label = 2;
                    s26 = this.this$0.s2((j.VirtualProduct) jVar, z16, z17, this);
                    if (s26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) s26).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                }
                ECAddress eCAddress2 = eCAddress;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("aid", "vip.card.shelfGoods.qqshopGoods_xiaodian");
                IECMobileReportManager.a.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMobileReporter(), "card_collect", "pg_xd_order_submit", "1", null, "order_submit", null, "4", 109, 0, 0, null, jSONObject.toString(), null, null, 14120, null);
                mutableLiveData = this.this$0._pageState;
                mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
                iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
                OrderSubmitDetailInfo orderSubmitDetailInfo2 = this.$orderDetail;
                ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp = this.$orderRsp;
                str = this.this$0.pageExt;
                ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken = this.$captchaToken;
                str2 = this.this$0.activityId;
                str3 = this.this$0.adClickId;
                List<String> c16 = this.$orderDetail.c();
                str4 = this.this$0.groupId;
                bool = this.this$0.isBuyAll;
                list = this.$orderRsp.buy_all_awards.get();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                this.L$0 = null;
                this.label = 3;
                str5 = null;
                str6 = "ECOrderSubmitViewModel";
                submit = iECOrderSubmitRepo.submit(orderSubmitDetailInfo2, eCQshopOrderQuerySvr$OrderPageDetailRsp, eCAddress2, str, eCQshopOrderSvr$CaptchaToken, str2, str3, c16, str4, bool, list, "vip.card.shelfGoods.qqshopGoods_xiaodian", this);
                obj2 = coroutine_suspended;
                if (submit == obj2) {
                    return obj2;
                }
                eCNetworkResponse = (ECNetworkResponse) submit;
                ECQshopOrderSvr$CommitOrderRsp eCQshopOrderSvr$CommitOrderRsp = (ECQshopOrderSvr$CommitOrderRsp) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() == 0 || eCQshopOrderSvr$CommitOrderRsp == null) {
                    str7 = str6;
                    mutableSharedFlow2 = this.this$0._submitResult;
                    submitFailedResult = new ECOrderSubmitViewModel.h.SubmitFailedResult(0, -2222, null, 5, null);
                    this.L$0 = eCNetworkResponse;
                    this.label = 4;
                    if (mutableSharedFlow2.emit(submitFailedResult, this) == obj2) {
                        return obj2;
                    }
                    mutableLiveData4 = this.this$0._pageState;
                    mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                    cg0.a.a(str7, "submit", "network error, rsp=" + eCNetworkResponse.e());
                    ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                    ECOrderSpan.c(eCOrderSpan, this.$orderDetail.orderId, ECOrderSpanScene.OrderSubmit, ECOrderOperation.SubmitOrder, eCOrderSpan.d(eCNetworkResponse), null, 16, null);
                    return Unit.INSTANCE;
                }
                ECQshopOrderSvr$CommitOrderResult eCQshopOrderSvr$CommitOrderResult = eCQshopOrderSvr$CommitOrderRsp.commit_order_result.get();
                if (!((eCQshopOrderSvr$CommitOrderResult == null || eCQshopOrderSvr$CommitOrderRsp.has_biz_error.get()) ? false : true)) {
                    ECQshopOrderSvr$OrderCommitBizErrorMsg eCQshopOrderSvr$OrderCommitBizErrorMsg = eCQshopOrderSvr$CommitOrderRsp.order_commit_biz_error_msg;
                    int i16 = eCQshopOrderSvr$OrderCommitBizErrorMsg.biz_error_type.get();
                    String str8 = eCQshopOrderSvr$OrderCommitBizErrorMsg.f105256msg.get();
                    int i17 = eCQshopOrderSvr$OrderCommitBizErrorMsg.action_type.get();
                    this.this$0.pageExt = eCQshopOrderSvr$OrderCommitBizErrorMsg.refresh_req_ext.get();
                    if (eCQshopOrderSvr$OrderCommitBizErrorMsg.clear_active_id.get()) {
                        this.this$0.activityId = str5;
                    }
                    ECOrderSpan eCOrderSpan2 = ECOrderSpan.f103884c;
                    String str9 = this.$orderDetail.orderId;
                    ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderSubmit;
                    ECOrderOperation eCOrderOperation = ECOrderOperation.SubmitOrder;
                    ECOrderSpan.OrderRequestInfo b17 = ECOrderSpan.OrderRequestInfo.b(eCOrderSpan2.d(eCNetworkResponse), -1, str5, 2, str5);
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bizErrorType", String.valueOf(i16)), TuplesKt.to("errorMsg", str8), TuplesKt.to("actionType", String.valueOf(i17)));
                    eCOrderSpan2.b(str9, eCOrderSpanScene, eCOrderOperation, b17, mapOf);
                    if (i16 != 11) {
                        if (i16 == 1) {
                            this.this$0._isAddressReachable.setValue(Boxing.boxBoolean(false));
                            mutableLiveData3 = this.this$0._pageState;
                            mutableLiveData3.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                            return Unit.INSTANCE;
                        }
                        mutableSharedFlow4 = this.this$0._submitResult;
                        ECOrderSubmitViewModel.h.SubmitFailedResult submitFailedResult3 = new ECOrderSubmitViewModel.h.SubmitFailedResult(i17, i16, str8);
                        this.label = 6;
                        if (mutableSharedFlow4.emit(submitFailedResult3, this) == obj2) {
                            return obj2;
                        }
                        mutableLiveData6 = this.this$0._pageState;
                        mutableLiveData6.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                        return Unit.INSTANCE;
                    }
                    int i18 = eCQshopOrderSvr$OrderCommitBizErrorMsg.intercepted_info.sku_num.get();
                    cg0.a.b(str6, "\u89e6\u53d1\u98ce\u63a7\u9650\u8d2d\uff0c\u6700\u5927\u8d2d\u4e70\u6570\u4e3a " + i18);
                    mutableSharedFlow5 = this.this$0._submitResult;
                    ECOrderSubmitViewModel.h.SubmitFailedResult submitFailedResult4 = new ECOrderSubmitViewModel.h.SubmitFailedResult(4, 11, str8);
                    this.I$0 = i18;
                    this.label = 5;
                    if (mutableSharedFlow5.emit(submitFailedResult4, this) == obj2) {
                        return obj2;
                    }
                    i3 = i18;
                    mutableLiveData5 = this.this$0._pageState;
                    mutableLiveData5.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                    ECOrderSubmitViewModel.n2(this.this$0, this.$orderDetail.orderSkusDetail.skuId, i3, CalculatePriceScene.SUBMIT_ORDER_INTERCEPT, true, null, 16, null);
                    return Unit.INSTANCE;
                }
                cg0.a.b(str6, "submit succeed, orderId=" + eCQshopOrderSvr$CommitOrderResult.order_id.get());
                mutableLiveData2 = this.this$0._submitEnabled;
                mutableLiveData2.setValue(Boxing.boxBoolean(false));
                Y2 = this.this$0.Y2(eCQshopOrderSvr$CommitOrderResult, this.$orderRsp, this.$orderDetail);
                mutableSharedFlow3 = this.this$0._submitResult;
                this.L$0 = eCNetworkResponse;
                this.L$1 = Y2;
                this.label = 7;
                if (mutableSharedFlow3.emit(Y2, this) == obj2) {
                    return obj2;
                }
                eCNetworkResponse2 = eCNetworkResponse;
                submitSucceedResult = Y2;
                mutableLiveData7 = this.this$0._pageState;
                mutableLiveData7.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                mutableSharedFlow6 = this.this$0._reportSubmitEvent;
                b16 = k.b(this.$orderRsp, this.$orderDetail.selectedPayType, false);
                this.L$0 = eCNetworkResponse2;
                this.L$1 = submitSucceedResult;
                this.label = 8;
                if (mutableSharedFlow6.emit(b16, this) != obj2) {
                    return obj2;
                }
                eCNetworkResponse3 = eCNetworkResponse2;
                ECOrderSpan eCOrderSpan3 = ECOrderSpan.f103884c;
                String str10 = this.$orderDetail.orderId;
                ECOrderSpanScene eCOrderSpanScene2 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation2 = ECOrderOperation.SubmitOrder;
                ECOrderSpan.OrderRequestInfo d16 = eCOrderSpan3.d(eCNetworkResponse3);
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("submitResult", String.valueOf(submitSucceedResult)));
                eCOrderSpan3.b(str10, eCOrderSpanScene2, eCOrderOperation2, d16, mapOf2);
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 2:
                ECAddress eCAddress3 = (ECAddress) this.L$0;
                ResultKt.throwOnFailure(obj);
                eCAddress = eCAddress3;
                s26 = obj;
                if (!((Boolean) s26).booleanValue()) {
                }
                ECAddress eCAddress22 = eCAddress;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", "vip.card.shelfGoods.qqshopGoods_xiaodian");
                IECMobileReportManager.a.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMobileReporter(), "card_collect", "pg_xd_order_submit", "1", null, "order_submit", null, "4", 109, 0, 0, null, jSONObject2.toString(), null, null, 14120, null);
                mutableLiveData = this.this$0._pageState;
                mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
                iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
                OrderSubmitDetailInfo orderSubmitDetailInfo22 = this.$orderDetail;
                ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp2 = this.$orderRsp;
                str = this.this$0.pageExt;
                ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken2 = this.$captchaToken;
                str2 = this.this$0.activityId;
                str3 = this.this$0.adClickId;
                List<String> c162 = this.$orderDetail.c();
                str4 = this.this$0.groupId;
                bool = this.this$0.isBuyAll;
                list = this.$orderRsp.buy_all_awards.get();
                if (list == null) {
                }
                this.L$0 = null;
                this.label = 3;
                str5 = null;
                str6 = "ECOrderSubmitViewModel";
                submit = iECOrderSubmitRepo.submit(orderSubmitDetailInfo22, eCQshopOrderQuerySvr$OrderPageDetailRsp2, eCAddress22, str, eCQshopOrderSvr$CaptchaToken2, str2, str3, c162, str4, bool, list, "vip.card.shelfGoods.qqshopGoods_xiaodian", this);
                obj2 = coroutine_suspended;
                if (submit == obj2) {
                }
                eCNetworkResponse = (ECNetworkResponse) submit;
                ECQshopOrderSvr$CommitOrderRsp eCQshopOrderSvr$CommitOrderRsp2 = (ECQshopOrderSvr$CommitOrderRsp) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() == 0) {
                }
                str7 = str6;
                mutableSharedFlow2 = this.this$0._submitResult;
                submitFailedResult = new ECOrderSubmitViewModel.h.SubmitFailedResult(0, -2222, null, 5, null);
                this.L$0 = eCNetworkResponse;
                this.label = 4;
                if (mutableSharedFlow2.emit(submitFailedResult, this) == obj2) {
                }
                mutableLiveData4 = this.this$0._pageState;
                mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                cg0.a.a(str7, "submit", "network error, rsp=" + eCNetworkResponse.e());
                ECOrderSpan eCOrderSpan4 = ECOrderSpan.f103884c;
                ECOrderSpan.c(eCOrderSpan4, this.$orderDetail.orderId, ECOrderSpanScene.OrderSubmit, ECOrderOperation.SubmitOrder, eCOrderSpan4.d(eCNetworkResponse), null, 16, null);
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure(obj);
                submit = obj;
                str6 = "ECOrderSubmitViewModel";
                obj2 = coroutine_suspended;
                str5 = null;
                eCNetworkResponse = (ECNetworkResponse) submit;
                ECQshopOrderSvr$CommitOrderRsp eCQshopOrderSvr$CommitOrderRsp22 = (ECQshopOrderSvr$CommitOrderRsp) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() == 0) {
                }
                str7 = str6;
                mutableSharedFlow2 = this.this$0._submitResult;
                submitFailedResult = new ECOrderSubmitViewModel.h.SubmitFailedResult(0, -2222, null, 5, null);
                this.L$0 = eCNetworkResponse;
                this.label = 4;
                if (mutableSharedFlow2.emit(submitFailedResult, this) == obj2) {
                }
                mutableLiveData4 = this.this$0._pageState;
                mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                cg0.a.a(str7, "submit", "network error, rsp=" + eCNetworkResponse.e());
                ECOrderSpan eCOrderSpan42 = ECOrderSpan.f103884c;
                ECOrderSpan.c(eCOrderSpan42, this.$orderDetail.orderId, ECOrderSpanScene.OrderSubmit, ECOrderOperation.SubmitOrder, eCOrderSpan42.d(eCNetworkResponse), null, 16, null);
                return Unit.INSTANCE;
            case 4:
                eCNetworkResponse = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                str7 = "ECOrderSubmitViewModel";
                mutableLiveData4 = this.this$0._pageState;
                mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                cg0.a.a(str7, "submit", "network error, rsp=" + eCNetworkResponse.e());
                ECOrderSpan eCOrderSpan422 = ECOrderSpan.f103884c;
                ECOrderSpan.c(eCOrderSpan422, this.$orderDetail.orderId, ECOrderSpanScene.OrderSubmit, ECOrderOperation.SubmitOrder, eCOrderSpan422.d(eCNetworkResponse), null, 16, null);
                return Unit.INSTANCE;
            case 5:
                int i19 = this.I$0;
                ResultKt.throwOnFailure(obj);
                i3 = i19;
                mutableLiveData5 = this.this$0._pageState;
                mutableLiveData5.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                ECOrderSubmitViewModel.n2(this.this$0, this.$orderDetail.orderSkusDetail.skuId, i3, CalculatePriceScene.SUBMIT_ORDER_INTERCEPT, true, null, 16, null);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                mutableLiveData6 = this.this$0._pageState;
                mutableLiveData6.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                return Unit.INSTANCE;
            case 7:
                submitSucceedResult = (ECOrderSubmitViewModel.h.SubmitSucceedResult) this.L$1;
                ECNetworkResponse<?> eCNetworkResponse4 = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                eCNetworkResponse2 = eCNetworkResponse4;
                obj2 = coroutine_suspended;
                mutableLiveData7 = this.this$0._pageState;
                mutableLiveData7.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                mutableSharedFlow6 = this.this$0._reportSubmitEvent;
                b16 = k.b(this.$orderRsp, this.$orderDetail.selectedPayType, false);
                this.L$0 = eCNetworkResponse2;
                this.L$1 = submitSucceedResult;
                this.label = 8;
                if (mutableSharedFlow6.emit(b16, this) != obj2) {
                }
                break;
            case 8:
                submitSucceedResult = (ECOrderSubmitViewModel.h.SubmitSucceedResult) this.L$1;
                eCNetworkResponse3 = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                ECOrderSpan eCOrderSpan32 = ECOrderSpan.f103884c;
                String str102 = this.$orderDetail.orderId;
                ECOrderSpanScene eCOrderSpanScene22 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation22 = ECOrderOperation.SubmitOrder;
                ECOrderSpan.OrderRequestInfo d162 = eCOrderSpan32.d(eCNetworkResponse3);
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("submitResult", String.valueOf(submitSucceedResult)));
                eCOrderSpan32.b(str102, eCOrderSpanScene22, eCOrderOperation22, d162, mapOf2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
