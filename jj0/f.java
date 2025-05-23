package jj0;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Ljj0/f;", "", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "callback", "", "c", "b", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONArray;", "a", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "saasData", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<JSONArray> saasData = new MutableLiveData<>();

    private final void c(IECJsonNetworkCallback callback) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr", "/trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr/GetSaasInfos", new JSONObject(), callback);
    }

    public final MutableLiveData<JSONArray> a() {
        return this.saasData;
    }

    public final void b() {
        c(new b());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"jj0/f$b", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IECJsonNetworkCallback {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            cg0.a.a("ECTransactionSaasInfoReq", "getSaasInfoList", "getSaasInfoList rsp with error: " + errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            if (respData == null) {
                return;
            }
            f.this.a().postValue(respData.optJSONArray("saas_infos"));
        }
    }
}
