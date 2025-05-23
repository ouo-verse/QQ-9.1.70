package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.l;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageBizErrorMsg;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$PageBizPopup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.view.FilterEnum;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$fetchOrderSubmitDetails$1", f = "ECOrderSubmitViewModel.kt", i = {2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {220, 225, 253, FilterEnum.MIC_PTU_BAIXI, 297, 303}, m = "invokeSuspend", n = {"rsp", "orderDetailRsp", "detail", "rsp", "orderDetailRsp", "detail", "errorMsg", "isExceedLimit", "rsp", "orderDetailRsp", "detail", "isExceedLimit", "isAddressNotReachable", "rsp", "orderDetailRsp", "detail", "isExceedLimit", "isAddressNotReachable"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "I$0"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$fetchOrderSubmitDetails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ SimpleSku $simpleSku;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$fetchOrderSubmitDetails$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, SimpleSku simpleSku, boolean z16, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitViewModel;
        this.$simpleSku = simpleSku;
        this.$isRefresh = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitViewModel$fetchOrderSubmitDetails$1(this.this$0, this.$simpleSku, this.$isRefresh, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderSubmitViewModel$fetchOrderSubmitDetails$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x02e2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SimpleSku simpleSku;
        MutableSharedFlow mutableSharedFlow;
        MutableLiveData mutableLiveData;
        IECOrderSubmitRepo iECOrderSubmitRepo;
        String str;
        String str2;
        String str3;
        Boolean bool;
        Object fetchOrderSubmitDetails;
        ECNetworkResponse<?> eCNetworkResponse;
        IECOrderSubmitRepo.OrderSubmitDetailWrapper orderSubmitDetailWrapper;
        MutableLiveData mutableLiveData2;
        ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp;
        OrderSubmitDetailInfo orderSubmitDetailInfo;
        MutableSharedFlow mutableSharedFlow2;
        ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp2;
        ECNetworkResponse<?> eCNetworkResponse2;
        OrderSubmitDetailInfo orderSubmitDetailInfo2;
        PBBoolField pBBoolField;
        boolean z16;
        String str4;
        MutableSharedFlow mutableSharedFlow3;
        String str5;
        MutableLiveData mutableLiveData3;
        Map<String, String> mapOf;
        PBStringField pBStringField;
        boolean z17;
        int i3;
        MutableLiveData mutableLiveData4;
        MutableSharedFlow mutableSharedFlow4;
        MutableSharedFlow mutableSharedFlow5;
        Map<String, String> mapOf2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$simpleSku.getQuantity() <= 0) {
                    mutableSharedFlow = this.this$0._errorEvent;
                    l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent = new l.ErrorToastWithMsgResIdEvent(R.string.wvh);
                    this.label = 1;
                    if (mutableSharedFlow.emit(errorToastWithMsgResIdEvent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cg0.a.b("ECOrderSubmitViewModel", "fix quantity old=" + this.$simpleSku.getQuantity() + " new=1");
                    simpleSku = SimpleSku.c(this.$simpleSku, null, 1, 1, null);
                    SimpleSku simpleSku2 = simpleSku;
                    mutableLiveData = this.this$0._pageState;
                    mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
                    iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
                    str = this.this$0.pageExt;
                    str2 = this.this$0.activityId;
                    str3 = this.this$0.groupId;
                    bool = this.this$0.isBuyAll;
                    this.label = 2;
                    fetchOrderSubmitDetails = iECOrderSubmitRepo.fetchOrderSubmitDetails(simpleSku2, str, str2, str3, bool, this);
                    if (fetchOrderSubmitDetails == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCNetworkResponse = (ECNetworkResponse) fetchOrderSubmitDetails;
                    orderSubmitDetailWrapper = (IECOrderSubmitRepo.OrderSubmitDetailWrapper) eCNetworkResponse.b();
                    if (eCNetworkResponse.getCode() != 0 && orderSubmitDetailWrapper != null) {
                        eCQshopOrderQuerySvr$OrderPageDetailRsp = orderSubmitDetailWrapper.originRsp;
                        OrderSubmitDetailInfo orderSubmitDetailInfo3 = (OrderSubmitDetailInfo) this.this$0._orderSubmitDetailInfo.getValue();
                        if (this.$isRefresh && orderSubmitDetailInfo3 != null) {
                            orderSubmitDetailInfo = this.this$0.P2(orderSubmitDetailInfo3, orderSubmitDetailWrapper.uiData);
                        } else {
                            orderSubmitDetailInfo = orderSubmitDetailWrapper.uiData;
                        }
                        ECQshopOrderQuerySvr$PageBizPopup eCQshopOrderQuerySvr$PageBizPopup = eCQshopOrderQuerySvr$OrderPageDetailRsp.page_biz_popup;
                        if (eCQshopOrderQuerySvr$PageBizPopup.has()) {
                            this.this$0.pageExt = eCQshopOrderQuerySvr$PageBizPopup.refresh_req_ext.get();
                            if (eCQshopOrderQuerySvr$PageBizPopup.clear_active_id.get()) {
                                this.this$0.activityId = null;
                            }
                            mutableSharedFlow2 = this.this$0._errorEvent;
                            l.ErrorWithSpecificType errorWithSpecificType = new l.ErrorWithSpecificType(eCQshopOrderQuerySvr$PageBizPopup.action_type.get(), eCQshopOrderQuerySvr$PageBizPopup.buzi_code.get(), eCQshopOrderQuerySvr$PageBizPopup.f105254msg.get());
                            this.L$0 = eCNetworkResponse;
                            this.L$1 = eCQshopOrderQuerySvr$OrderPageDetailRsp;
                            this.L$2 = orderSubmitDetailInfo;
                            this.label = 3;
                            if (mutableSharedFlow2.emit(errorWithSpecificType, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        eCQshopOrderQuerySvr$OrderPageDetailRsp2 = eCQshopOrderQuerySvr$OrderPageDetailRsp;
                        eCNetworkResponse2 = eCNetworkResponse;
                        orderSubmitDetailInfo2 = orderSubmitDetailInfo;
                        pBBoolField = eCQshopOrderQuerySvr$OrderPageDetailRsp2.has_biz_error;
                        if (pBBoolField != null || !pBBoolField.get()) {
                            this.this$0.orderDetailRsp = eCQshopOrderQuerySvr$OrderPageDetailRsp2;
                            this.this$0._orderSubmitDetailInfo.setValue(orderSubmitDetailInfo2);
                            z16 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.sku_buy_num_limit.exceed_limit.get();
                            if (z16) {
                                str4 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.sku_buy_num_limit.excceed_limit_msg.get();
                                mutableSharedFlow3 = this.this$0._errorEvent;
                                l.ErrorToastWithMsgEvent errorToastWithMsgEvent = new l.ErrorToastWithMsgEvent(str4);
                                this.L$0 = eCNetworkResponse2;
                                this.L$1 = eCQshopOrderQuerySvr$OrderPageDetailRsp2;
                                this.L$2 = orderSubmitDetailInfo2;
                                this.L$3 = str4;
                                this.Z$0 = z16;
                                this.label = 4;
                                if (mutableSharedFlow3.emit(errorToastWithMsgEvent, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                cg0.a.a("ECOrderSubmitViewModel", "exceed max quantity", str4);
                            }
                            z17 = z16;
                            i3 = (eCQshopOrderQuerySvr$OrderPageDetailRsp2.address_info.has() || eCQshopOrderQuerySvr$OrderPageDetailRsp2.enable_shiped.get()) ? 0 : 1;
                            this.this$0._isAddressReachable.setValue(Boxing.boxBoolean(i3 ^ 1));
                            mutableLiveData4 = this.this$0._pageState;
                            mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                            if (!this.$isRefresh) {
                                if (eCQshopOrderQuerySvr$OrderPageDetailRsp2.coupon_info.has() && eCQshopOrderQuerySvr$OrderPageDetailRsp2.coupon_info.is_best_discount.get()) {
                                    mutableSharedFlow4 = this.this$0._bestCouponSelectedEvent;
                                    Integer boxInt = Boxing.boxInt(0);
                                    this.L$0 = eCNetworkResponse2;
                                    this.L$1 = eCQshopOrderQuerySvr$OrderPageDetailRsp2;
                                    this.L$2 = orderSubmitDetailInfo2;
                                    this.L$3 = null;
                                    this.Z$0 = z17;
                                    this.I$0 = i3;
                                    this.label = 5;
                                    if (mutableSharedFlow4.emit(boxInt, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            if (!this.$isRefresh) {
                                mutableSharedFlow5 = this.this$0._reportExposureEvent;
                                ECOrderSubmitViewModel.OrderSubmitReportInfo c16 = k.c(eCQshopOrderQuerySvr$OrderPageDetailRsp2, null, !eCQshopOrderQuerySvr$OrderPageDetailRsp2.address_info.has(), 1, null);
                                this.L$0 = eCNetworkResponse2;
                                this.L$1 = eCQshopOrderQuerySvr$OrderPageDetailRsp2;
                                this.L$2 = orderSubmitDetailInfo2;
                                this.L$3 = null;
                                this.Z$0 = z17;
                                this.I$0 = i3;
                                this.label = 6;
                                if (mutableSharedFlow5.emit(c16, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                            String str6 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get();
                            ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderSubmit;
                            ECOrderOperation eCOrderOperation = ECOrderOperation.OrderSubmitDetail;
                            ECOrderSpan.OrderRequestInfo d16 = eCOrderSpan.d(eCNetworkResponse2);
                            Pair[] pairArr = new Pair[3];
                            pairArr[0] = TuplesKt.to("isRefresh", String.valueOf(this.$isRefresh));
                            pairArr[1] = TuplesKt.to("isAddressReachable", String.valueOf(i3 == 0));
                            pairArr[2] = TuplesKt.to("isExceedLimit", String.valueOf(z17));
                            mapOf2 = MapsKt__MapsKt.mapOf(pairArr);
                            eCOrderSpan.b(str6, eCOrderSpanScene, eCOrderOperation, d16, mapOf2);
                            if (orderSubmitDetailInfo2.bulletinInfo != null) {
                                OrderSkuDetail orderSkuDetail = orderSubmitDetailInfo2.orderSkusDetail;
                                com.tencent.ecommerce.biz.bulletin.b.f101349a.d(orderSkuDetail.shop.id, orderSkuDetail.skuId, BulletinScene.ORDER_SUBMIT_PAGE, orderSubmitDetailInfo2.orderId);
                            }
                            return Unit.INSTANCE;
                        }
                        ECQshopOrderQuerySvr$OrderPageBizErrorMsg eCQshopOrderQuerySvr$OrderPageBizErrorMsg = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_page_biz_error_msg.get();
                        if (eCQshopOrderQuerySvr$OrderPageBizErrorMsg == null || (pBStringField = eCQshopOrderQuerySvr$OrderPageBizErrorMsg.f105253msg) == null || (str5 = pBStringField.get()) == null) {
                            str5 = "";
                        }
                        mutableLiveData3 = this.this$0._pageState;
                        mutableLiveData3.setValue(new ECOrderSubmitViewModel.g.Empty(str5));
                        cg0.a.a("ECOrderSubmitViewModel", "fetchOrderSubmitDetails", str5);
                        ECOrderSpan eCOrderSpan2 = ECOrderSpan.f103884c;
                        String str7 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get();
                        ECOrderSpanScene eCOrderSpanScene2 = ECOrderSpanScene.OrderSubmit;
                        ECOrderOperation eCOrderOperation2 = ECOrderOperation.OrderSubmitDetail;
                        ECOrderSpan.OrderRequestInfo d17 = eCOrderSpan2.d(eCNetworkResponse2);
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("hasBizError", "true"), TuplesKt.to("errorMsg", str5));
                        eCOrderSpan2.b(str7, eCOrderSpanScene2, eCOrderOperation2, d17, mapOf);
                        return Unit.INSTANCE;
                    }
                    cg0.a.a("ECOrderSubmitViewModel", "fetchOrderSubmitDetails", "failed, isRefresh=" + this.$isRefresh + " sku=" + this.$simpleSku + " code=" + eCNetworkResponse.getCode() + " data=" + orderSubmitDetailWrapper);
                    mutableLiveData2 = this.this$0._pageState;
                    mutableLiveData2.setValue(new ECOrderSubmitViewModel.g.Error(-2222, eCNetworkResponse.getMessage()));
                    return Unit.INSTANCE;
                }
                simpleSku = this.$simpleSku;
                SimpleSku simpleSku22 = simpleSku;
                mutableLiveData = this.this$0._pageState;
                mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
                iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
                str = this.this$0.pageExt;
                str2 = this.this$0.activityId;
                str3 = this.this$0.groupId;
                bool = this.this$0.isBuyAll;
                this.label = 2;
                fetchOrderSubmitDetails = iECOrderSubmitRepo.fetchOrderSubmitDetails(simpleSku22, str, str2, str3, bool, this);
                if (fetchOrderSubmitDetails == coroutine_suspended) {
                }
                eCNetworkResponse = (ECNetworkResponse) fetchOrderSubmitDetails;
                orderSubmitDetailWrapper = (IECOrderSubmitRepo.OrderSubmitDetailWrapper) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0) {
                }
                cg0.a.a("ECOrderSubmitViewModel", "fetchOrderSubmitDetails", "failed, isRefresh=" + this.$isRefresh + " sku=" + this.$simpleSku + " code=" + eCNetworkResponse.getCode() + " data=" + orderSubmitDetailWrapper);
                mutableLiveData2 = this.this$0._pageState;
                mutableLiveData2.setValue(new ECOrderSubmitViewModel.g.Error(-2222, eCNetworkResponse.getMessage()));
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                cg0.a.b("ECOrderSubmitViewModel", "fix quantity old=" + this.$simpleSku.getQuantity() + " new=1");
                simpleSku = SimpleSku.c(this.$simpleSku, null, 1, 1, null);
                SimpleSku simpleSku222 = simpleSku;
                mutableLiveData = this.this$0._pageState;
                mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
                iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
                str = this.this$0.pageExt;
                str2 = this.this$0.activityId;
                str3 = this.this$0.groupId;
                bool = this.this$0.isBuyAll;
                this.label = 2;
                fetchOrderSubmitDetails = iECOrderSubmitRepo.fetchOrderSubmitDetails(simpleSku222, str, str2, str3, bool, this);
                if (fetchOrderSubmitDetails == coroutine_suspended) {
                }
                eCNetworkResponse = (ECNetworkResponse) fetchOrderSubmitDetails;
                orderSubmitDetailWrapper = (IECOrderSubmitRepo.OrderSubmitDetailWrapper) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0) {
                }
                cg0.a.a("ECOrderSubmitViewModel", "fetchOrderSubmitDetails", "failed, isRefresh=" + this.$isRefresh + " sku=" + this.$simpleSku + " code=" + eCNetworkResponse.getCode() + " data=" + orderSubmitDetailWrapper);
                mutableLiveData2 = this.this$0._pageState;
                mutableLiveData2.setValue(new ECOrderSubmitViewModel.g.Error(-2222, eCNetworkResponse.getMessage()));
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure(obj);
                fetchOrderSubmitDetails = obj;
                eCNetworkResponse = (ECNetworkResponse) fetchOrderSubmitDetails;
                orderSubmitDetailWrapper = (IECOrderSubmitRepo.OrderSubmitDetailWrapper) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0) {
                }
                cg0.a.a("ECOrderSubmitViewModel", "fetchOrderSubmitDetails", "failed, isRefresh=" + this.$isRefresh + " sku=" + this.$simpleSku + " code=" + eCNetworkResponse.getCode() + " data=" + orderSubmitDetailWrapper);
                mutableLiveData2 = this.this$0._pageState;
                mutableLiveData2.setValue(new ECOrderSubmitViewModel.g.Error(-2222, eCNetworkResponse.getMessage()));
                return Unit.INSTANCE;
            case 3:
                orderSubmitDetailInfo = (OrderSubmitDetailInfo) this.L$2;
                eCQshopOrderQuerySvr$OrderPageDetailRsp = (ECQshopOrderQuerySvr$OrderPageDetailRsp) this.L$1;
                eCNetworkResponse = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                eCQshopOrderQuerySvr$OrderPageDetailRsp2 = eCQshopOrderQuerySvr$OrderPageDetailRsp;
                eCNetworkResponse2 = eCNetworkResponse;
                orderSubmitDetailInfo2 = orderSubmitDetailInfo;
                pBBoolField = eCQshopOrderQuerySvr$OrderPageDetailRsp2.has_biz_error;
                if (pBBoolField != null) {
                    break;
                }
                this.this$0.orderDetailRsp = eCQshopOrderQuerySvr$OrderPageDetailRsp2;
                this.this$0._orderSubmitDetailInfo.setValue(orderSubmitDetailInfo2);
                z16 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.sku_buy_num_limit.exceed_limit.get();
                if (z16) {
                }
                z17 = z16;
                if (eCQshopOrderQuerySvr$OrderPageDetailRsp2.address_info.has()) {
                    break;
                }
                this.this$0._isAddressReachable.setValue(Boxing.boxBoolean(i3 ^ 1));
                mutableLiveData4 = this.this$0._pageState;
                mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                if (!this.$isRefresh) {
                }
                if (!this.$isRefresh) {
                }
                ECOrderSpan eCOrderSpan3 = ECOrderSpan.f103884c;
                String str62 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get();
                ECOrderSpanScene eCOrderSpanScene3 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation3 = ECOrderOperation.OrderSubmitDetail;
                ECOrderSpan.OrderRequestInfo d162 = eCOrderSpan3.d(eCNetworkResponse2);
                Pair[] pairArr2 = new Pair[3];
                pairArr2[0] = TuplesKt.to("isRefresh", String.valueOf(this.$isRefresh));
                pairArr2[1] = TuplesKt.to("isAddressReachable", String.valueOf(i3 == 0));
                pairArr2[2] = TuplesKt.to("isExceedLimit", String.valueOf(z17));
                mapOf2 = MapsKt__MapsKt.mapOf(pairArr2);
                eCOrderSpan3.b(str62, eCOrderSpanScene3, eCOrderOperation3, d162, mapOf2);
                if (orderSubmitDetailInfo2.bulletinInfo != null) {
                }
                return Unit.INSTANCE;
            case 4:
                z16 = this.Z$0;
                str4 = (String) this.L$3;
                orderSubmitDetailInfo2 = (OrderSubmitDetailInfo) this.L$2;
                eCQshopOrderQuerySvr$OrderPageDetailRsp2 = (ECQshopOrderQuerySvr$OrderPageDetailRsp) this.L$1;
                eCNetworkResponse2 = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                cg0.a.a("ECOrderSubmitViewModel", "exceed max quantity", str4);
                z17 = z16;
                if (eCQshopOrderQuerySvr$OrderPageDetailRsp2.address_info.has()) {
                }
                this.this$0._isAddressReachable.setValue(Boxing.boxBoolean(i3 ^ 1));
                mutableLiveData4 = this.this$0._pageState;
                mutableLiveData4.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                if (!this.$isRefresh) {
                }
                if (!this.$isRefresh) {
                }
                ECOrderSpan eCOrderSpan32 = ECOrderSpan.f103884c;
                String str622 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get();
                ECOrderSpanScene eCOrderSpanScene32 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation32 = ECOrderOperation.OrderSubmitDetail;
                ECOrderSpan.OrderRequestInfo d1622 = eCOrderSpan32.d(eCNetworkResponse2);
                Pair[] pairArr22 = new Pair[3];
                pairArr22[0] = TuplesKt.to("isRefresh", String.valueOf(this.$isRefresh));
                pairArr22[1] = TuplesKt.to("isAddressReachable", String.valueOf(i3 == 0));
                pairArr22[2] = TuplesKt.to("isExceedLimit", String.valueOf(z17));
                mapOf2 = MapsKt__MapsKt.mapOf(pairArr22);
                eCOrderSpan32.b(str622, eCOrderSpanScene32, eCOrderOperation32, d1622, mapOf2);
                if (orderSubmitDetailInfo2.bulletinInfo != null) {
                }
                return Unit.INSTANCE;
            case 5:
                i3 = this.I$0;
                z17 = this.Z$0;
                orderSubmitDetailInfo2 = (OrderSubmitDetailInfo) this.L$2;
                eCQshopOrderQuerySvr$OrderPageDetailRsp2 = (ECQshopOrderQuerySvr$OrderPageDetailRsp) this.L$1;
                eCNetworkResponse2 = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (!this.$isRefresh) {
                }
                ECOrderSpan eCOrderSpan322 = ECOrderSpan.f103884c;
                String str6222 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get();
                ECOrderSpanScene eCOrderSpanScene322 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation322 = ECOrderOperation.OrderSubmitDetail;
                ECOrderSpan.OrderRequestInfo d16222 = eCOrderSpan322.d(eCNetworkResponse2);
                Pair[] pairArr222 = new Pair[3];
                pairArr222[0] = TuplesKt.to("isRefresh", String.valueOf(this.$isRefresh));
                pairArr222[1] = TuplesKt.to("isAddressReachable", String.valueOf(i3 == 0));
                pairArr222[2] = TuplesKt.to("isExceedLimit", String.valueOf(z17));
                mapOf2 = MapsKt__MapsKt.mapOf(pairArr222);
                eCOrderSpan322.b(str6222, eCOrderSpanScene322, eCOrderOperation322, d16222, mapOf2);
                if (orderSubmitDetailInfo2.bulletinInfo != null) {
                }
                return Unit.INSTANCE;
            case 6:
                i3 = this.I$0;
                z17 = this.Z$0;
                orderSubmitDetailInfo2 = (OrderSubmitDetailInfo) this.L$2;
                eCQshopOrderQuerySvr$OrderPageDetailRsp2 = (ECQshopOrderQuerySvr$OrderPageDetailRsp) this.L$1;
                eCNetworkResponse2 = (ECNetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                ECOrderSpan eCOrderSpan3222 = ECOrderSpan.f103884c;
                String str62222 = eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get();
                ECOrderSpanScene eCOrderSpanScene3222 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation3222 = ECOrderOperation.OrderSubmitDetail;
                ECOrderSpan.OrderRequestInfo d162222 = eCOrderSpan3222.d(eCNetworkResponse2);
                Pair[] pairArr2222 = new Pair[3];
                pairArr2222[0] = TuplesKt.to("isRefresh", String.valueOf(this.$isRefresh));
                pairArr2222[1] = TuplesKt.to("isAddressReachable", String.valueOf(i3 == 0));
                pairArr2222[2] = TuplesKt.to("isExceedLimit", String.valueOf(z17));
                mapOf2 = MapsKt__MapsKt.mapOf(pairArr2222);
                eCOrderSpan3222.b(str62222, eCOrderSpanScene3222, eCOrderOperation3222, d162222, mapOf2);
                if (orderSubmitDetailInfo2.bulletinInfo != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
