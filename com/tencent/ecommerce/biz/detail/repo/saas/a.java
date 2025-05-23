package com.tencent.ecommerce.biz.detail.repo.saas;

import com.tencent.ecommerce.base.network.api.IECRequest;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/a;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "saasType", "b", "sassProductId", "", "c", "I", "goodsType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String saasType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String sassProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int goodsType;

    public a(String str, String str2, int i3) {
        this.saasType = str;
        this.sassProductId = str2;
        this.goodsType = i3;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("saas_type", this.saasType);
            jSONObject.put("saas_product_id", this.sassProductId);
            jSONObject.put("goods_type", this.goodsType);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECGetProductDetailBySellerReq", "encodeParams", "[encodeParams] error = " + e16);
            return null;
        }
    }
}
