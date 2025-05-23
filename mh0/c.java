package mh0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lmh0/c;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "b", "Lorg/json/JSONObject;", CacheTable.TABLE_NAME, "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String requestId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final JSONObject reportInfo;

    public c(String str, JSONObject jSONObject) {
        this.requestId = str;
        this.reportInfo = jSONObject;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", this.requestId);
            jSONObject.put("device", new JSONObject("{\"os\":1}"));
            jSONObject.put("recall_report_info", this.reportInfo);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("QQECCGoodsReportRequest", "encodeParams", "error:" + e16.getLocalizedMessage());
            return jSONObject;
        }
    }
}
