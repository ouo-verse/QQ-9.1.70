package com.tencent.ecommerce.biz.showwindow.repo.window;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\u0005B7\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\n\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/g;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", "getChannel", "()I", "setChannel", "(I)V", WadlProxyConsts.CHANNEL, "", "b", "Ljava/lang/String;", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "mediaId", "c", "getSellerUin", "sellerUin", "d", "getCookie", "setCookie", "cookie", "e", "getSource", "setSource", "source", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mediaId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String sellerUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String cookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int source;

    public g(int i3, String str, String str2, String str3, int i16) {
        this.channel = i3;
        this.mediaId = str;
        this.sellerUin = str2;
        this.cookie = str3;
        this.source = i16;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        boolean isBlank;
        try {
            JSONObject jSONObject = new JSONObject();
            isBlank = StringsKt__StringsJVMKt.isBlank(this.mediaId);
            if (isBlank) {
                jSONObject.put("seller_uin", this.sellerUin);
            } else {
                jSONObject.put("media_id", this.mediaId);
            }
            jSONObject.put("cookie", this.cookie);
            jSONObject.put("source", this.source);
            cg0.a.b("ECShowWindowViewProductListReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowViewProductListReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
