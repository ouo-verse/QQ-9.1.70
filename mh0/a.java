package mh0;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lmh0/a;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "Lcom/google/gson/Gson;", "a", "Lcom/google/gson/Gson;", "gson", "", "b", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "c", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "content", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Gson gson = new Gson();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String requestId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ECContentInfo content;

    public a(String str, ECContentInfo eCContentInfo) {
        this.requestId = str;
        this.content = eCContentInfo;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", this.requestId);
            jSONObject.put("device", new JSONObject("{\"os\":1}"));
            jSONObject.put("app_source", this.content.getBusinessId());
            jSONObject.put("app_scene", this.content.getContentScene());
            jSONObject.put("content", new JSONObject(this.gson.toJson(this.content)));
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(this.content.getSealTransfer())) {
                jSONObject2.put(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, this.content.getSealTransfer());
            }
            if (!TextUtils.isEmpty(this.content.getTraceId())) {
                jSONObject2.put("request_id", this.content.getTraceId());
                jSONObject2.put("trace_id", this.content.getTraceId());
            }
            jSONObject2.put("source_from", String.valueOf(this.content.getSourceFrom()));
            jSONObject3.put("ext", jSONObject2);
            jSONObject.put("ext", jSONObject3);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("QQECCGoodsAdRequest", "encodeParams", "error:" + e16.getLocalizedMessage());
            return jSONObject;
        }
    }
}
