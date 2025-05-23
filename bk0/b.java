package bk0;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a8\u0006\u000b"}, d2 = {"Lbk0/b;", "", "Lbk0/a;", "params", "Lkotlin/Function1;", "", "", "callback", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f28528a = new b();

    b() {
    }

    public final void a(ECProductArkShareRequestParams params, Function1<? super String, Unit> callback) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.shop_product_detail_server.ProductInfo", "/trpc.ecom.shop_product_detail_server.ProductInfo/ShareProductDetail", params.a(), new a(callback));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"bk0/b$a", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes39.dex */
    public static final class a implements IECJsonNetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f28529a;

        a(Function1 function1) {
            this.f28529a = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("request network failed, errCode: ");
            sb5.append(errorResponse != null ? Integer.valueOf(errorResponse.getCode()) : null);
            sb5.append(", errMsg: ");
            sb5.append(errorResponse != null ? errorResponse.getMsg() : null);
            sb5.append(", errData: ");
            sb5.append(errorResponse != null ? errorResponse.getData() : null);
            cg0.a.a("ECShareRepo", "requestArkShareData", sb5.toString());
            this.f28529a.invoke("");
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            if (respData == null) {
                cg0.a.a("ECShareRepo", "requestArkShareData", "rsp data is null");
                this.f28529a.invoke("");
            } else {
                this.f28529a.invoke(respData.optString("share_info"));
            }
        }
    }
}
