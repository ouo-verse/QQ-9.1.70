package com.tencent.ecommerce.repo.logistics;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_trace_svr.ECQshopLogisticsTraceSvr$GetLogisticsInfoReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_trace_svr.ECQshopLogisticsTraceSvr$GetLogisticsInfoRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/repo/logistics/ECLogisticsRepo;", "Lcom/tencent/ecommerce/repo/logistics/a;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "logisticsCode", "Lcom/tencent/ecommerce/biz/orders/common/e;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLogisticsRepo implements com.tencent.ecommerce.repo.logistics.a {

    /* renamed from: a, reason: collision with root package name */
    public static final ECLogisticsRepo f105220a = new ECLogisticsRepo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/logistics/ECLogisticsRepo$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/biz/orders/common/e;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkPBContracts<String, LogisticsInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f105221a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105222b;

        a(String str, String str2) {
            this.f105221a = str;
            this.f105222b = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogisticsInfo decodeResponse(byte[] rsp) {
            return LogisticsInfo.INSTANCE.a(new ECQshopLogisticsTraceSvr$GetLogisticsInfoRsp().mergeFrom(rsp).logistics_infos.get(0));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopLogisticsTraceSvr$GetLogisticsInfoReq eCQshopLogisticsTraceSvr$GetLogisticsInfoReq = new ECQshopLogisticsTraceSvr$GetLogisticsInfoReq();
            eCQshopLogisticsTraceSvr$GetLogisticsInfoReq.order_id.set(this.f105221a);
            eCQshopLogisticsTraceSvr$GetLogisticsInfoReq.logistics_code.set(this.f105222b);
            return eCQshopLogisticsTraceSvr$GetLogisticsInfoReq.toByteArray();
        }
    }

    ECLogisticsRepo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.logistics.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, String str2, Continuation<? super LogisticsInfo> continuation) {
        ECLogisticsRepo$requestLogisticsTraceInfo$1 eCLogisticsRepo$requestLogisticsTraceInfo$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECLogisticsRepo$requestLogisticsTraceInfo$1) {
            eCLogisticsRepo$requestLogisticsTraceInfo$1 = (ECLogisticsRepo$requestLogisticsTraceInfo$1) continuation;
            int i16 = eCLogisticsRepo$requestLogisticsTraceInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCLogisticsRepo$requestLogisticsTraceInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCLogisticsRepo$requestLogisticsTraceInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCLogisticsRepo$requestLogisticsTraceInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = new a(str, str2);
                    eCLogisticsRepo$requestLogisticsTraceInfo$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_logistics_trace_svr.QshopLogisticsTraceSvr", "/trpc.ecom.qshop_logistics_trace_svr.QshopLogisticsTraceSvr/GetLogisticsInfo", aVar, "", eCLogisticsRepo$requestLogisticsTraceInfo$1);
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
                    cg0.a.a("ECLogisticsRepo", "requestLogisticsTraceInfo", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCLogisticsRepo$requestLogisticsTraceInfo$1 = new ECLogisticsRepo$requestLogisticsTraceInfo$1(this, continuation);
        Object obj2 = eCLogisticsRepo$requestLogisticsTraceInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCLogisticsRepo$requestLogisticsTraceInfo$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECLogisticsRepo", "requestLogisticsTraceInfo", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse.b();
    }
}
