package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyOptionInfo;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListExtraInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$AbortFulfilOrderReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$CancelAbortFulfilOrderReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$CancelOrderReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$GetAbortFulfilDetailReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$GetAbortFulfilDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$OrderDetail;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$SignConfirmReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$UpdateOrderAddressReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$UpdateOrderAddressRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$AbortReason;
import com.tencent.ecommerce.repo.sampleorder.e;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJA\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J3\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u00020\u001e*\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo;", "Lcom/tencent/ecommerce/repo/sampleorder/d;", "", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/sampleorder/a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "reason", "desc", "", "imageUrls", "e", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/apply/j;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "g", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "needLatestOrderInfo", "Lcom/tencent/ecommerce/repo/sampleorder/e;", "d", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$GetAbortFulfilDetailRsp;", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "i", "(Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$GetAbortFulfilDetailRsp;)Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "applyOptionInfo", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECApplySampleRepo implements com.tencent.ecommerce.repo.sampleorder.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "([B)Ljava/lang/Boolean;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f105286a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105287b;

        b(String str, String str2) {
            this.f105286a = str;
            this.f105287b = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean decodeResponse(byte[] rsp) {
            return Boolean.TRUE;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopSampleSvr$CancelAbortFulfilOrderReq eCQshopSampleSvr$CancelAbortFulfilOrderReq = new ECQshopSampleSvr$CancelAbortFulfilOrderReq();
            eCQshopSampleSvr$CancelAbortFulfilOrderReq.order_id.set(this.f105286a);
            eCQshopSampleSvr$CancelAbortFulfilOrderReq.token.set(this.f105287b);
            return eCQshopSampleSvr$CancelAbortFulfilOrderReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo$c", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "([B)Ljava/lang/Boolean;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkPBContracts<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f105288a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105289b;

        c(String str, String str2) {
            this.f105288a = str;
            this.f105289b = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean decodeResponse(byte[] rsp) {
            return Boolean.TRUE;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopSampleSvr$CancelOrderReq eCQshopSampleSvr$CancelOrderReq = new ECQshopSampleSvr$CancelOrderReq();
            eCQshopSampleSvr$CancelOrderReq.order_id.set(this.f105288a);
            eCQshopSampleSvr$CancelOrderReq.token.set(this.f105289b);
            return eCQshopSampleSvr$CancelOrderReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo$d", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "([B)Ljava/lang/Boolean;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECNetworkPBContracts<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OptionValue f105290a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105291b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f105292c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f105293d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f105294e;

        d(OptionValue optionValue, String str, String str2, List list, String str3) {
            this.f105290a = optionValue;
            this.f105291b = str;
            this.f105292c = str2;
            this.f105293d = list;
            this.f105294e = str3;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean decodeResponse(byte[] rsp) {
            return Boolean.TRUE;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECSampleData$AbortReason eCSampleData$AbortReason = new ECSampleData$AbortReason();
            eCSampleData$AbortReason.reason_id.set(this.f105290a.getValue());
            eCSampleData$AbortReason.f105257msg.set(this.f105290a.getText());
            ECQshopSampleSvr$AbortFulfilOrderReq eCQshopSampleSvr$AbortFulfilOrderReq = new ECQshopSampleSvr$AbortFulfilOrderReq();
            eCQshopSampleSvr$AbortFulfilOrderReq.order_id.set(this.f105291b);
            eCQshopSampleSvr$AbortFulfilOrderReq.abort_reason.set(eCSampleData$AbortReason);
            eCQshopSampleSvr$AbortFulfilOrderReq.desc.set(this.f105292c);
            eCQshopSampleSvr$AbortFulfilOrderReq.img_list.set(this.f105293d);
            eCQshopSampleSvr$AbortFulfilOrderReq.token.set(this.f105294e);
            return eCQshopSampleSvr$AbortFulfilOrderReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo$e", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/sampleorder/a;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECNetworkPBContracts<String, ECAbortFulfillOption> {
        e() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECAbortFulfillOption decodeResponse(byte[] rsp) {
            ECQshopSampleSvr$GetAbortFulfilDetailRsp mergeFrom = new ECQshopSampleSvr$GetAbortFulfilDetailRsp().mergeFrom(rsp);
            return new ECAbortFulfillOption(mergeFrom.token.get(), ECAfterSaleProductCard.INSTANCE.a(mergeFrom.order_fulfil_detail.get()), ECApplySampleRepo.this.i(mergeFrom));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopSampleSvr$GetAbortFulfilDetailReq eCQshopSampleSvr$GetAbortFulfilDetailReq = new ECQshopSampleSvr$GetAbortFulfilDetailReq();
            eCQshopSampleSvr$GetAbortFulfilDetailReq.order_id.set(params);
            return eCQshopSampleSvr$GetAbortFulfilDetailReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo$f", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "([B)Ljava/lang/Boolean;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements IECNetworkPBContracts<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f105296a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105297b;

        f(String str, String str2) {
            this.f105296a = str;
            this.f105297b = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean decodeResponse(byte[] rsp) {
            return Boolean.TRUE;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopSampleSvr$SignConfirmReq eCQshopSampleSvr$SignConfirmReq = new ECQshopSampleSvr$SignConfirmReq();
            eCQshopSampleSvr$SignConfirmReq.order_id.set(this.f105296a);
            eCQshopSampleSvr$SignConfirmReq.token.set(this.f105297b);
            return eCQshopSampleSvr$SignConfirmReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/sampleorder/ECApplySampleRepo$g", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$UpdateOrderAddressRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements IECNetworkPBContracts<String, ECQshopSampleSvr$UpdateOrderAddressRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f105298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECAddress f105299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f105300c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f105301d;

        g(String str, ECAddress eCAddress, boolean z16, String str2) {
            this.f105298a = str;
            this.f105299b = eCAddress;
            this.f105300c = z16;
            this.f105301d = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQshopSampleSvr$UpdateOrderAddressRsp decodeResponse(byte[] rsp) {
            return new ECQshopSampleSvr$UpdateOrderAddressRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopSampleSvr$UpdateOrderAddressReq eCQshopSampleSvr$UpdateOrderAddressReq = new ECQshopSampleSvr$UpdateOrderAddressReq();
            eCQshopSampleSvr$UpdateOrderAddressReq.order_id.set(this.f105298a);
            eCQshopSampleSvr$UpdateOrderAddressReq.address.set(com.tencent.ecommerce.biz.orders.address.b.e(this.f105299b));
            eCQshopSampleSvr$UpdateOrderAddressReq.refresh.set(this.f105300c);
            eCQshopSampleSvr$UpdateOrderAddressReq.token.set(this.f105301d);
            return eCQshopSampleSvr$UpdateOrderAddressReq.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAfterSaleApplyOptionInfo i(ECQshopSampleSvr$GetAbortFulfilDetailRsp eCQshopSampleSvr$GetAbortFulfilDetailRsp) {
        int collectionSizeOrDefault;
        String string = wg0.a.a().getString(R.string.wgz);
        List<ECSampleData$AbortReason> list = eCQshopSampleSvr$GetAbortFulfilDetailRsp.abort_reason_list.get();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(OptionValue.INSTANCE.a((ECSampleData$AbortReason) it.next()));
        }
        return new ECAfterSaleApplyOptionInfo(string, -1, arrayList, null, null, false, 56, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, Continuation<? super ECNetworkResponse<ECAbortFulfillOption>> continuation) {
        ECApplySampleRepo$requestAbortFulfillOrderReasonOption$1 eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECApplySampleRepo$requestAbortFulfillOrderReasonOption$1) {
            eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1 = (ECApplySampleRepo$requestAbortFulfillOrderReasonOption$1) continuation;
            int i16 = eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECSampleRepo", "requestAbortFulfillOrderReasonOption");
                    e eVar = new e();
                    eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/GetAbortFulfilDetail", eVar, str, eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0 || eCNetworkResponse.b() == null) {
                    cg0.a.a("ECSampleRepo", "requestCancelOrderReasonOption", "request data error, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse;
            }
        }
        eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1 = new ECApplySampleRepo$requestAbortFulfillOrderReasonOption$1(this, continuation);
        Object obj2 = eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$requestAbortFulfillOrderReasonOption$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECSampleRepo", "requestCancelOrderReasonOption", "request data error, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, String str2, Continuation<? super Boolean> continuation) {
        ECApplySampleRepo$signConfirmApplySample$1 eCApplySampleRepo$signConfirmApplySample$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECApplySampleRepo$signConfirmApplySample$1) {
            eCApplySampleRepo$signConfirmApplySample$1 = (ECApplySampleRepo$signConfirmApplySample$1) continuation;
            int i16 = eCApplySampleRepo$signConfirmApplySample$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$signConfirmApplySample$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleRepo$signConfirmApplySample$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$signConfirmApplySample$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECSampleRepo", "signConfirmApplySample");
                    f fVar = new f(str, str2);
                    eCApplySampleRepo$signConfirmApplySample$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/SignConfirm", fVar, str, eCApplySampleRepo$signConfirmApplySample$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    cg0.a.a("ECSampleRepo", "signConfirmApplySample", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                    return Boxing.boxBoolean(false);
                }
                return Boxing.boxBoolean(true);
            }
        }
        eCApplySampleRepo$signConfirmApplySample$1 = new ECApplySampleRepo$signConfirmApplySample$1(this, continuation);
        Object obj2 = eCApplySampleRepo$signConfirmApplySample$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$signConfirmApplySample$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(String str, String str2, Continuation<? super Boolean> continuation) {
        ECApplySampleRepo$cancelApplySampleOrder$1 eCApplySampleRepo$cancelApplySampleOrder$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECApplySampleRepo$cancelApplySampleOrder$1) {
            eCApplySampleRepo$cancelApplySampleOrder$1 = (ECApplySampleRepo$cancelApplySampleOrder$1) continuation;
            int i16 = eCApplySampleRepo$cancelApplySampleOrder$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$cancelApplySampleOrder$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleRepo$cancelApplySampleOrder$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$cancelApplySampleOrder$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECSampleRepo", "cancelApplySampleOrder");
                    c cVar = new c(str, str2);
                    eCApplySampleRepo$cancelApplySampleOrder$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/CancelOrder", cVar, str, eCApplySampleRepo$cancelApplySampleOrder$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    cg0.a.a("ECSampleRepo", "cancelApplySampleOrder", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                    return Boxing.boxBoolean(false);
                }
                return Boxing.boxBoolean(true);
            }
        }
        eCApplySampleRepo$cancelApplySampleOrder$1 = new ECApplySampleRepo$cancelApplySampleOrder$1(this, continuation);
        Object obj2 = eCApplySampleRepo$cancelApplySampleOrder$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$cancelApplySampleOrder$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object f(Continuation<? super Boolean> continuation) {
        ECApplySampleRepo$hasApplySampleOrder$1 eCApplySampleRepo$hasApplySampleOrder$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECApplySampleRepo$hasApplySampleOrder$1) {
            eCApplySampleRepo$hasApplySampleOrder$1 = (ECApplySampleRepo$hasApplySampleOrder$1) continuation;
            int i16 = eCApplySampleRepo$hasApplySampleOrder$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$hasApplySampleOrder$1.label = i16 - Integer.MIN_VALUE;
                obj = eCApplySampleRepo$hasApplySampleOrder$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$hasApplySampleOrder$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (ECLocalConfig.f100650f.getBoolean("has_apply_sample_orders", false, Boxing.boxBoolean(true))) {
                        return Boxing.boxBoolean(true);
                    }
                    BaseListDataSource<ECApplySampleOrderListRequest, ECOrderListItem, ECOrderListExtraInfo> c16 = ServiceLocator.f104891i.c();
                    ECApplySampleOrderListRequest eCApplySampleOrderListRequest = new ECApplySampleOrderListRequest("", ECApplySampleQueryType.ALL);
                    eCApplySampleRepo$hasApplySampleOrder$1.label = 1;
                    obj = c16.d(eCApplySampleOrderListRequest, eCApplySampleRepo$hasApplySampleOrder$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((IListRepository.Result) obj).isSucceeded && (!r9.d().isEmpty())) {
                    ECLocalConfig.f100650f.set("has_apply_sample_orders", Boxing.boxBoolean(true), Boxing.boxBoolean(true));
                    return Boxing.boxBoolean(true);
                }
                return Boxing.boxBoolean(false);
            }
        }
        eCApplySampleRepo$hasApplySampleOrder$1 = new ECApplySampleRepo$hasApplySampleOrder$1(this, continuation);
        obj = eCApplySampleRepo$hasApplySampleOrder$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$hasApplySampleOrder$1.label;
        if (i3 != 0) {
        }
        if (!((IListRepository.Result) obj).isSucceeded) {
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object g(String str, String str2, Continuation<? super Boolean> continuation) {
        ECApplySampleRepo$cancelAbortFulfilOrder$1 eCApplySampleRepo$cancelAbortFulfilOrder$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECApplySampleRepo$cancelAbortFulfilOrder$1) {
            eCApplySampleRepo$cancelAbortFulfilOrder$1 = (ECApplySampleRepo$cancelAbortFulfilOrder$1) continuation;
            int i16 = eCApplySampleRepo$cancelAbortFulfilOrder$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$cancelAbortFulfilOrder$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleRepo$cancelAbortFulfilOrder$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$cancelAbortFulfilOrder$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECSampleRepo", "cancelAbortFulfilOrder");
                    b bVar = new b(str, str2);
                    eCApplySampleRepo$cancelAbortFulfilOrder$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/CancelAbortFulfilOrder", bVar, str, eCApplySampleRepo$cancelAbortFulfilOrder$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    cg0.a.a("ECSampleRepo", "cancelAbortFulfilOrder", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                    return Boxing.boxBoolean(false);
                }
                return Boxing.boxBoolean(true);
            }
        }
        eCApplySampleRepo$cancelAbortFulfilOrder$1 = new ECApplySampleRepo$cancelAbortFulfilOrder$1(this, continuation);
        Object obj2 = eCApplySampleRepo$cancelAbortFulfilOrder$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$cancelAbortFulfilOrder$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object e(String str, String str2, OptionValue optionValue, String str3, List<String> list, Continuation<? super Boolean> continuation) {
        ECApplySampleRepo$requestAbortFulfillOrder$1 eCApplySampleRepo$requestAbortFulfillOrder$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECApplySampleRepo$requestAbortFulfillOrder$1) {
            eCApplySampleRepo$requestAbortFulfillOrder$1 = (ECApplySampleRepo$requestAbortFulfillOrder$1) continuation;
            int i16 = eCApplySampleRepo$requestAbortFulfillOrder$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$requestAbortFulfillOrder$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleRepo$requestAbortFulfillOrder$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$requestAbortFulfillOrder$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECSampleRepo", "requestAbortFulfillOrder");
                    d dVar = new d(optionValue, str2, str3, list, str);
                    eCApplySampleRepo$requestAbortFulfillOrder$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/AbortFulfilOrder", dVar, str2, eCApplySampleRepo$requestAbortFulfillOrder$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    cg0.a.a("ECSampleRepo", "requestCancelApplySample", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage() + ",data:" + ((Boolean) eCNetworkResponse.b()));
                    return Boxing.boxBoolean(false);
                }
                return Boxing.boxBoolean(true);
            }
        }
        eCApplySampleRepo$requestAbortFulfillOrder$1 = new ECApplySampleRepo$requestAbortFulfillOrder$1(this, continuation);
        Object obj2 = eCApplySampleRepo$requestAbortFulfillOrder$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$requestAbortFulfillOrder$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // com.tencent.ecommerce.repo.sampleorder.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(String str, String str2, ECAddress eCAddress, boolean z16, Continuation<? super com.tencent.ecommerce.repo.sampleorder.e> continuation) {
        ECApplySampleRepo$updateOrderAddress$1 eCApplySampleRepo$updateOrderAddress$1;
        Object coroutine_suspended;
        int i3;
        int code;
        ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail;
        if (continuation instanceof ECApplySampleRepo$updateOrderAddress$1) {
            eCApplySampleRepo$updateOrderAddress$1 = (ECApplySampleRepo$updateOrderAddress$1) continuation;
            int i16 = eCApplySampleRepo$updateOrderAddress$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleRepo$updateOrderAddress$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleRepo$updateOrderAddress$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleRepo$updateOrderAddress$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECSampleRepo", "updateOrderAddress");
                    g gVar = new g(str, eCAddress, z16, str2);
                    eCApplySampleRepo$updateOrderAddress$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/UpdateOrderAddress", gVar, str, eCApplySampleRepo$updateOrderAddress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                code = eCNetworkResponse.getCode();
                ECOrderSpan.OrderRequestInfo orderRequestInfo = new ECOrderSpan.OrderRequestInfo(code, eCNetworkResponse.getTraceInfo());
                ECQshopSampleSvr$UpdateOrderAddressRsp eCQshopSampleSvr$UpdateOrderAddressRsp = (ECQshopSampleSvr$UpdateOrderAddressRsp) eCNetworkResponse.b();
                ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail2 = (eCQshopSampleSvr$UpdateOrderAddressRsp != null || (eCQshopSampleSvr$OrderDetail = eCQshopSampleSvr$UpdateOrderAddressRsp.order_detail) == null) ? null : eCQshopSampleSvr$OrderDetail.get();
                if (code == 0) {
                    cg0.a.a("ECSampleRepo", "updateOrderAddress", "errCode:" + code + ", errMsg:" + eCNetworkResponse.getMessage());
                    return new e.Failed(code, eCNetworkResponse.getMessage(), orderRequestInfo, null, 8, null);
                }
                return new e.Succeed(orderRequestInfo, eCQshopSampleSvr$OrderDetail2);
            }
        }
        eCApplySampleRepo$updateOrderAddress$1 = new ECApplySampleRepo$updateOrderAddress$1(this, continuation);
        Object obj2 = eCApplySampleRepo$updateOrderAddress$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleRepo$updateOrderAddress$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        code = eCNetworkResponse2.getCode();
        ECOrderSpan.OrderRequestInfo orderRequestInfo2 = new ECOrderSpan.OrderRequestInfo(code, eCNetworkResponse2.getTraceInfo());
        ECQshopSampleSvr$UpdateOrderAddressRsp eCQshopSampleSvr$UpdateOrderAddressRsp2 = (ECQshopSampleSvr$UpdateOrderAddressRsp) eCNetworkResponse2.b();
        if (eCQshopSampleSvr$UpdateOrderAddressRsp2 != null) {
        }
        if (code == 0) {
        }
    }
}
