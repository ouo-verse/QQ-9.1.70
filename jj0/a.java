package jj0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0006R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Ljj0/a;", "", "Ljj0/d;", "reqTimeRange", "Ljj0/e;", "transactionSaasInfo", "Lorg/json/JSONObject;", "c", "reqSaasInfo", "", "shouldRestoreData", "", "f", "d", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "_transactionInfo", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "e", "()Landroidx/lifecycle/LiveData;", "transactionInfo", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<JSONObject> _transactionInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LiveData<JSONObject> transactionInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"jj0/a$c", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class c implements IECRequest {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECTransactionReqTimeRange f409955b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECTransactionSaasInfo f409956c;

        c(ECTransactionReqTimeRange eCTransactionReqTimeRange, ECTransactionSaasInfo eCTransactionSaasInfo) {
            this.f409955b = eCTransactionReqTimeRange;
            this.f409956c = eCTransactionSaasInfo;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECRequest
        public JSONObject encodeParams() {
            return a.this.c(this.f409955b, this.f409956c);
        }
    }

    public a() {
        MutableLiveData<JSONObject> mutableLiveData = new MutableLiveData<>();
        this._transactionInfo = mutableLiveData;
        this.transactionInfo = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject c(ECTransactionReqTimeRange reqTimeRange, ECTransactionSaasInfo transactionSaasInfo) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("start", reqTimeRange.getStartTime());
        jSONObject2.put("end", reqTimeRange.getEndTime());
        jSONObject.put("time_range", jSONObject2);
        if (!Intrinsics.areEqual(transactionSaasInfo.typeStr, "all")) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type_str", transactionSaasInfo.typeStr);
            jSONObject3.put("type_name", transactionSaasInfo.typeName);
            jSONObject3.put("type_num", transactionSaasInfo.getTypeNum());
            jSONObject.put("saas_info", jSONObject3);
        }
        return jSONObject;
    }

    public final JSONObject d() {
        String f16 = IECLocalConfig.a.f(ECLocalConfig.f100650f, "lc_transaction_sum_info_data_key", "", null, 4, null);
        if (Intrinsics.areEqual(f16, "")) {
            return new JSONObject();
        }
        return new JSONObject(f16);
    }

    public final LiveData<JSONObject> e() {
        return this.transactionInfo;
    }

    public final void f(ECTransactionReqTimeRange reqTimeRange, ECTransactionSaasInfo reqSaasInfo, boolean shouldRestoreData) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr", "/trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr/GetStatData", new c(reqTimeRange, reqSaasInfo).encodeParams(), new b(shouldRestoreData));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"jj0/a$b", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IECJsonNetworkCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f409953b;

        b(boolean z16) {
            this.f409953b = z16;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            cg0.a.a("ECTransactionDataViewModel", "getTransactionSumData$\\reqTransactionSumData$\\onError", String.valueOf(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            if (respData == null) {
                return;
            }
            i iVar = i.f104869a;
            respData.put(WidgetCacheConstellationData.MONEY, iVar.b(respData.optLong(WidgetCacheConstellationData.MONEY)));
            respData.put("last_modified_time", new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT).format(new Date()));
            JSONObject optJSONObject = respData.optJSONObject("android_data");
            if (optJSONObject != null) {
                optJSONObject.put(WidgetCacheConstellationData.MONEY, iVar.b(optJSONObject.optLong(WidgetCacheConstellationData.MONEY)));
            }
            JSONObject optJSONObject2 = respData.optJSONObject("ios_data");
            if (optJSONObject2 != null) {
                optJSONObject2.put(WidgetCacheConstellationData.MONEY, iVar.b(optJSONObject2.optLong(WidgetCacheConstellationData.MONEY)));
            }
            a.this._transactionInfo.postValue(respData);
            if (this.f409953b) {
                IECLocalConfig.a.j(ECLocalConfig.f100650f, "lc_transaction_sum_info_data_key", respData.toString(), null, 4, null);
            }
        }
    }
}
