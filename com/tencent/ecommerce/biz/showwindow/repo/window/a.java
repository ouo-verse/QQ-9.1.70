package com.tencent.ecommerce.biz.showwindow.repo.window;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/a;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", "getChannel", "()I", "setChannel", "(I)V", WadlProxyConsts.CHANNEL, "", "", "b", "Ljava/util/List;", "getMediaProductIdList", "()Ljava/util/List;", "setMediaProductIdList", "(Ljava/util/List;)V", "mediaProductIdList", "<init>", "(ILjava/util/List;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<String> mediaProductIdList;

    public a(int i3, List<String> list) {
        this.channel = i3;
        this.mediaProductIdList = list;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mediaProductIdList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            jSONObject.put("media_product_id", jSONArray);
            cg0.a.b("ECShowWindowDeleteProductReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowDeleteProductReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
