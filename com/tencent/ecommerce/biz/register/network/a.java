package com.tencent.ecommerce.biz.register.network;

import com.tencent.ecommerce.base.network.api.IECRequest;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/a;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "reqSource", "b", "ownerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String reqSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String ownerId;

    public a(String str, String str2) {
        this.reqSource = str;
        this.ownerId = str2;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_source", this.reqSource);
            jSONObject.put("owner_id", this.ownerId);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECGetGoodsRightConditionReq", "encodeParams", "[encodeData] error = " + e16);
            return new JSONObject();
        }
    }
}
