package cj0;

import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0003B!\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcj0/c;", "", "Lorg/json/JSONObject;", "a", "", "Ljava/lang/String;", "getSaasTypeStr", "()Ljava/lang/String;", "setSaasTypeStr", "(Ljava/lang/String;)V", "saasTypeStr", "b", "getSaasProductId", "setSaasProductId", "saasProductId", "", "c", "I", "getGoodsType", "()I", "setGoodsType", "(I)V", "goodsType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String saasTypeStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String saasProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int goodsType;

    public c(String str, String str2, int i3) {
        this.saasTypeStr = str;
        this.saasProductId = str2;
        this.goodsType = i3;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("saas_type_str", this.saasTypeStr);
            jSONObject.put("saas_product_id", this.saasProductId);
            jSONObject.put("goods_type", this.goodsType);
            cg0.a.b("ECShowWindowAddProductEncoder", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowAddProductEncoder", "encodeParams", "[encodeParams] e = " + e16);
            cg0.a.b("ECShowWindowAddProductEncoder", "[encodeParams] req is empty.");
            return new JSONObject();
        }
    }
}
