package com.tencent.ecommerce.biz.showwindow.repo.window;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/f;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "d", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "a", "()Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "setResult", "(Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;)V", "result", "<init>", "()V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private k result;

    /* renamed from: a, reason: from getter */
    public final k getResult() {
        return this.result;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        String optString;
        cg0.a.b("ECShowWindowSetTopProductRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("result");
        this.result = new k(optJSONObject != null ? optJSONObject.optInt("result_type", -1) : -1, (optJSONObject == null || (optString = optJSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "")) == null) ? "" : optString, null, null, 0, 28, null);
        return true;
    }
}
