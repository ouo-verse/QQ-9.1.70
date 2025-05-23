package oj0;

import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.ecommerce.biz.webviewplugin.IECWebViewPluginCallBack;
import com.tencent.ecommerce.biz.webviewplugin.processor.IECWebViewPluginProcessor;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Loj0/a;", "Lcom/tencent/ecommerce/biz/webviewplugin/processor/IECWebViewPluginProcessor;", "Lorg/json/JSONObject;", "data", "a", "b", "c", "reqData", "Lcom/tencent/ecommerce/biz/webviewplugin/IECWebViewPluginCallBack;", "callback", "", "invoke", "d", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a implements IECWebViewPluginProcessor {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Loj0/a$b;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "title", "b", "coverUrl", "c", "priceStr", "d", "getDetailUrl", "()Ljava/lang/String;", "detailUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: oj0.a$b, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class RespProductInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String coverUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String priceStr;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String detailUrl;

        public RespProductInfo() {
            this(null, null, null, null, 15, null);
        }

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.title);
            jSONObject.put("cover_url", this.coverUrl);
            jSONObject.put("price_str", this.priceStr);
            jSONObject.put("detail_url", this.detailUrl);
            return jSONObject;
        }

        public int hashCode() {
            String str = this.title;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.coverUrl;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.priceStr;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.detailUrl;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "RespProductInfo(title=" + this.title + ", coverUrl=" + this.coverUrl + ", priceStr=" + this.priceStr + ", detailUrl=" + this.detailUrl + ")";
        }

        public RespProductInfo(String str, String str2, String str3, String str4) {
            this.title = str;
            this.coverUrl = str2;
            this.priceStr = str3;
            this.detailUrl = str4;
        }

        public /* synthetic */ RespProductInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RespProductInfo)) {
                return false;
            }
            RespProductInfo respProductInfo = (RespProductInfo) other;
            return Intrinsics.areEqual(this.title, respProductInfo.title) && Intrinsics.areEqual(this.coverUrl, respProductInfo.coverUrl) && Intrinsics.areEqual(this.priceStr, respProductInfo.priceStr) && Intrinsics.areEqual(this.detailUrl, respProductInfo.detailUrl);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"oj0/a$c", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class c implements IECSchemeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECWebViewPluginCallBack f423016b;

        c(IECWebViewPluginCallBack iECWebViewPluginCallBack) {
            this.f423016b = iECWebViewPluginCallBack;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            if (data.optInt("code") != 1) {
                JSONObject d16 = a.this.d(data);
                this.f423016b.invoke(d16);
                cg0.a.b("ECAddProductProcessor", "[shopPromotionProcessor] call back invoked data = " + data + " respData = " + d16);
            }
        }
    }

    private final JSONObject a(JSONObject data) {
        String optString = data.optString("title", "");
        long optLong = data.optLong("coupon_price");
        JSONObject optJSONObject = data.optJSONObject("price_range");
        if (optJSONObject != null) {
            optLong = optJSONObject.optLong("lower");
        }
        String b16 = i.f104869a.b(optLong);
        JSONArray optJSONArray = data.optJSONArray("cdn_main_pics");
        if (optJSONArray != null) {
            String optString2 = optJSONArray.optString(0);
            String optString3 = data.optString("detail_url");
            if (optString3 != null) {
                return new RespProductInfo(optString, optString2, b16, optString3).a();
            }
        }
        return null;
    }

    private final JSONObject b(JSONObject data) {
        try {
            return new RespProductInfo(data.getString("title"), data.getString("cover"), data.getString("price_str"), data.getString("url")).a();
        } catch (Exception unused) {
            return null;
        }
    }

    private final JSONObject c(JSONObject data) {
        String optString;
        JSONObject optJSONObject;
        String optString2;
        String optString3 = data.optString("title", "");
        JSONArray optJSONArray = data.optJSONArray("carousel_pictures");
        if (optJSONArray == null || (optString = optJSONArray.optJSONObject(0).optString("url")) == null || (optJSONObject = data.optJSONObject("price")) == null || (optString2 = optJSONObject.optString("price_txt")) == null) {
            return null;
        }
        return new RespProductInfo(optString3, optString, optString2, "").a();
    }

    public final JSONObject d(JSONObject data) {
        JSONObject a16 = a(data);
        if (a16 != null) {
            return a16;
        }
        JSONObject b16 = b(data);
        if (b16 != null) {
            return b16;
        }
        JSONObject c16 = c(data);
        return c16 != null ? c16 : new JSONObject();
    }

    @Override // com.tencent.ecommerce.biz.webviewplugin.processor.IECWebViewPluginProcessor
    public void invoke(JSONObject reqData, IECWebViewPluginCallBack callback) {
        String optString = reqData.optString(WadlProxyConsts.CHANNEL, "0");
        String str = optString != null ? optString : "0";
        String optString2 = reqData.optString("scene", "1");
        ECScheme.f("mqqapi://ecommerce/open?target=54&is_trans_activity=1&channel=" + str + "&scene=" + (optString2 != null ? optString2 : "1"), new c(callback), null, 4, null);
    }
}
