package com.tencent.ecommerce.repo.buyerorder;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002Jk\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/a;", "", "", "productId", "sellerId", "orderData", "Lorg/json/JSONObject;", "a", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "url", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "callback", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f104991a = new a();

    a() {
    }

    private final JSONObject a(String productId, String sellerId, String orderData) {
        JSONObject optJSONObject = new JSONObject(orderData).optJSONObject("basic_info");
        int optInt = optJSONObject.optInt("goods_type");
        int optInt2 = optJSONObject.optInt(WadlProxyConsts.CHANNEL);
        String optString = optJSONObject.optString("pindao_id");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("seller_id", sellerId);
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        jSONObject.put("goods_type", optInt);
        jSONObject.put(WadlProxyConsts.CHANNEL, optInt2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pindao_id", optString);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("req_ext", jSONObject2);
        return jSONObject;
    }

    public final void b(String productId, String sellerId, String orderData, Function3<? super Integer, ? super String, ? super String, Unit> callback) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.shop_url_distribute_svr.ShopUrlDistribute", "/trpc.ecom.shop_url_distribute_svr.ShopUrlDistribute/GetShopJumpInfo", a(productId, sellerId, orderData), new C1108a(callback));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/repo/buyerorder/a$a", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.buyerorder.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1108a implements IECJsonNetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3 f104992a;

        C1108a(Function3 function3) {
            this.f104992a = function3;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            String str;
            Function3 function3 = this.f104992a;
            Integer valueOf = Integer.valueOf(errorResponse != null ? errorResponse.getCode() : -1);
            if (errorResponse == null || (str = errorResponse.getTraceInfo()) == null) {
                str = "";
            }
            function3.invoke(valueOf, "", str);
            cg0.a.a("ECBuyAgainLinkRepo", "getBuyAgainLink", String.valueOf(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            if (respData == null) {
                cg0.a.b("ECBuyAgainLinkRepo", "getBuyAgainLink success and rspData = null");
            } else {
                this.f104992a.invoke(0, respData.optString("url"), traceInfo);
            }
        }
    }
}
