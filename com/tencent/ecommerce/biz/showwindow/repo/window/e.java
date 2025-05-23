package com.tencent.ecommerce.biz.showwindow.repo.window;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/e;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", "getChannel", "()I", "setChannel", "(I)V", WadlProxyConsts.CHANNEL, "", "b", "Ljava/lang/String;", "getMediaProductId", "()Ljava/lang/String;", "setMediaProductId", "(Ljava/lang/String;)V", "mediaProductId", "<init>", "(ILjava/lang/String;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mediaProductId;

    public e(int i3, String str) {
        this.channel = i3;
        this.mediaProductId = str;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(this.mediaProductId);
            jSONObject.put("media_product_id", jSONArray);
            cg0.a.b("ECShowWindowSetTopProductReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowSetTopProductReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
