package com.tencent.ecommerce.biz.showwindow.repo.window;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 &2\u00020\u0001:\u0001\u0005BC\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001a\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/c;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "query", "b", "getCategoryId", "setCategoryId", "categoryId", "c", "getCookie", "setCookie", "cookie", "", "d", "I", "getChannel", "()I", "setChannel", "(I)V", WadlProxyConsts.CHANNEL, "e", "getWindowType", "setWindowType", "windowType", "f", "getSource", "setSource", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "g", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String query;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String categoryId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String cookie;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int windowType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int source;

    public c() {
        this(null, null, null, 0, 0, 0, 63, null);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("query", this.query);
            jSONObject.put("cookie", this.cookie);
            jSONObject.put("window_type", this.windowType);
            jSONObject.put("source", this.source);
            cg0.a.b("ECShowWindowGetProductListReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowGetProductListReq", "encodeParams", "[encodeParams] error, e = " + e16);
            return new JSONObject();
        }
    }

    public c(String str, String str2, String str3, int i3, int i16, int i17) {
        this.query = str;
        this.categoryId = str2;
        this.cookie = str3;
        this.channel = i3;
        this.windowType = i16;
        this.source = i17;
    }

    public /* synthetic */ c(String str, String str2, String str3, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) == 0 ? str3 : "", (i18 & 8) != 0 ? 1 : i3, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) != 0 ? 0 : i17);
    }
}
