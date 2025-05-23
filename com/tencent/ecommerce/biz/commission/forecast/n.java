package com.tencent.ecommerce.biz.commission.forecast;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$EntryReq;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$EntryRsp;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetReq;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetRsp;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetSummaryReq;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetSummaryRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/n;", "Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "", "cookie", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$GetRsp;", "loadList", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$GetSummaryRsp;", "fetchSummary", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$EntryRsp;", "fetchEntry", "<init>", "()V", "a", "b", "c", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class n implements IECCommissionForecastRepo {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/n$b;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$EntryRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "(Lkotlin/Unit;ILorg/json/JSONObject;)[B", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    private static final class b implements IECNetworkPBContracts<Unit, ECEstimateCommissionSvr$EntryRsp> {
        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECEstimateCommissionSvr$EntryRsp decodeResponse(byte[] rsp) {
            ECEstimateCommissionSvr$EntryRsp eCEstimateCommissionSvr$EntryRsp = new ECEstimateCommissionSvr$EntryRsp();
            eCEstimateCommissionSvr$EntryRsp.mergeFrom(rsp);
            return eCEstimateCommissionSvr$EntryRsp;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(Unit params, int channel, JSONObject reqExt) {
            ECEstimateCommissionSvr$EntryReq eCEstimateCommissionSvr$EntryReq = new ECEstimateCommissionSvr$EntryReq();
            eCEstimateCommissionSvr$EntryReq.channel.set(channel);
            return eCEstimateCommissionSvr$EntryReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/n$c;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$GetRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "b", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    private static final class c implements IECNetworkPBContracts<byte[], ECEstimateCommissionSvr$GetRsp> {
        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECEstimateCommissionSvr$GetRsp decodeResponse(byte[] rsp) {
            ECEstimateCommissionSvr$GetRsp eCEstimateCommissionSvr$GetRsp = new ECEstimateCommissionSvr$GetRsp();
            eCEstimateCommissionSvr$GetRsp.mergeFrom(rsp);
            return eCEstimateCommissionSvr$GetRsp;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(byte[] params, int channel, JSONObject reqExt) {
            ECEstimateCommissionSvr$GetReq eCEstimateCommissionSvr$GetReq = new ECEstimateCommissionSvr$GetReq();
            PBBytesField pBBytesField = eCEstimateCommissionSvr$GetReq.cookie;
            if (params == null) {
                params = new byte[0];
            }
            pBBytesField.set(ByteStringMicro.copyFrom(params));
            eCEstimateCommissionSvr$GetReq.channel.set(channel);
            return eCEstimateCommissionSvr$GetReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/n$d;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$GetSummaryRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "(Lkotlin/Unit;ILorg/json/JSONObject;)[B", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    private static final class d implements IECNetworkPBContracts<Unit, ECEstimateCommissionSvr$GetSummaryRsp> {
        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECEstimateCommissionSvr$GetSummaryRsp decodeResponse(byte[] rsp) {
            ECEstimateCommissionSvr$GetSummaryRsp eCEstimateCommissionSvr$GetSummaryRsp = new ECEstimateCommissionSvr$GetSummaryRsp();
            eCEstimateCommissionSvr$GetSummaryRsp.mergeFrom(rsp);
            return eCEstimateCommissionSvr$GetSummaryRsp;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(Unit params, int channel, JSONObject reqExt) {
            ECEstimateCommissionSvr$GetSummaryReq eCEstimateCommissionSvr$GetSummaryReq = new ECEstimateCommissionSvr$GetSummaryReq();
            eCEstimateCommissionSvr$GetSummaryReq.channel.set(channel);
            return eCEstimateCommissionSvr$GetSummaryReq.toByteArray();
        }
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.IECCommissionForecastRepo
    public Object fetchEntry(Continuation<? super ECNetworkResponse<ECEstimateCommissionSvr$EntryRsp>> continuation) {
        return com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.estimate_commission_svr.EstimateCommissionSvr", "/trpc.ecom.estimate_commission_svr.EstimateCommissionSvr/Entry", new b(), null, continuation);
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.IECCommissionForecastRepo
    public Object fetchSummary(Continuation<? super ECNetworkResponse<ECEstimateCommissionSvr$GetSummaryRsp>> continuation) {
        return com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.estimate_commission_svr.EstimateCommissionSvr", "/trpc.ecom.estimate_commission_svr.EstimateCommissionSvr/GetSummary", new d(), null, continuation);
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.IECCommissionForecastRepo
    public Object loadList(byte[] bArr, Continuation<? super ECNetworkResponse<ECEstimateCommissionSvr$GetRsp>> continuation) {
        return com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.estimate_commission_svr.EstimateCommissionSvr", "/trpc.ecom.estimate_commission_svr.EstimateCommissionSvr/Get", new c(), bArr, continuation);
    }
}
