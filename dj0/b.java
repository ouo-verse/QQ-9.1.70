package dj0;

import ck0.Product;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import fj0.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 42\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\b\u001a\u0004\b\u0007\u0010\n\"\u0004\b!\u0010\fR(\u0010*\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u000f\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Ldj0/b;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "I", "f", "()I", "setTotal", "(I)V", "total", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setCookie", "(Ljava/lang/String;)V", "cookie", "Z", "g", "()Z", "setEnd", "(Z)V", "isEnd", h.F, "c", "setLiveProductCountLimit", "liveProductCountLimit", "i", "setLiveProductSelectedCount", "liveProductSelectedCount", "", "Lck0/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "()Ljava/util/List;", "setProducts", "(Ljava/util/List;)V", "products", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", "<init>", "()V", "D", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b implements IECResponse {

    /* renamed from: C, reason: from kotlin metadata */
    private JSONObject dataJson;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int liveProductSelectedCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String cookie = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int liveProductCountLimit = -1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<Product> products = new ArrayList();

    /* renamed from: a, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    /* renamed from: b, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    /* renamed from: c, reason: from getter */
    public final int getLiveProductCountLimit() {
        return this.liveProductCountLimit;
    }

    /* renamed from: d, reason: from getter */
    public final int getLiveProductSelectedCount() {
        return this.liveProductSelectedCount;
    }

    public final List<Product> e() {
        return this.products;
    }

    /* renamed from: f, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("LiveWindowGetProductRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.dataJson = data;
        this.total = data.optInt("total");
        this.cookie = data.optString("cookie");
        this.isEnd = data.optBoolean("is_end");
        this.liveProductCountLimit = data.optInt("live_window_limit", -1);
        this.liveProductSelectedCount = data.optInt("live_window_total");
        JSONArray optJSONArray = data.optJSONArray("products");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                JSONObject optJSONObject = jSONObject.optJSONObject("product");
                if (optJSONObject != null) {
                    optJSONObject.put("page_name", "live_window_product_card");
                }
                c cVar = c.f399474a;
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                Product d16 = c.d(cVar, optJSONObject, false, true, true, false, null, 32, null);
                d16.K(true);
                d16.V(jSONObject.optBoolean("is_selected"));
                this.products.add(d16);
            }
        }
        return true;
    }
}
