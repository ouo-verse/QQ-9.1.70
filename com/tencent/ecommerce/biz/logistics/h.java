package com.tencent.ecommerce.biz.logistics;

import com.tencent.ecommerce.base.network.api.IECResponse;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/h;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "I", "a", "()I", "setCode", "(I)V", "code", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "msg", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int code;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String msg = "";

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        String str;
        cg0.a.b("SubmitLogisticsRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("result");
        this.code = optJSONObject != null ? optJSONObject.optInt("result_code") : 0;
        if (optJSONObject == null || (str = optJSONObject.optString("result_string")) == null) {
            str = "success";
        }
        this.msg = str;
        return true;
    }
}
