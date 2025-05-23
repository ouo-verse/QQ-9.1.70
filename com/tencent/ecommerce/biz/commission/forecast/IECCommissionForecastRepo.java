package com.tencent.ecommerce.biz.commission.forecast;

import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$EntryRsp;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetRsp;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetSummaryRsp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "", "", "cookie", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$GetRsp;", "loadList", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$GetSummaryRsp;", "fetchSummary", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$EntryRsp;", "fetchEntry", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECCommissionForecastRepo {
    Object fetchEntry(Continuation<? super com.tencent.ecommerce.base.network.api.d<ECEstimateCommissionSvr$EntryRsp>> continuation);

    Object fetchSummary(Continuation<? super com.tencent.ecommerce.base.network.api.d<ECEstimateCommissionSvr$GetSummaryRsp>> continuation);

    Object loadList(byte[] bArr, Continuation<? super com.tencent.ecommerce.base.network.api.d<ECEstimateCommissionSvr$GetRsp>> continuation);
}
