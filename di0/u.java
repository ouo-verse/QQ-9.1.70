package di0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 *2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014\u00a8\u0006+"}, d2 = {"Ldi0/u;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "Lcom/tencent/ecommerce/repo/live/q;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "setLiveProducts", "(Ljava/util/List;)V", "liveProducts", "", "e", "I", "()I", "setTotal", "(I)V", "total", "f", "Z", "()Z", "setEnd", "(Z)V", "isEnd", "", tl.h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setCookie", "(Ljava/lang/String;)V", "cookie", "i", "c", "setPollingTickSecs", "pollingTickSecs", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class u implements IECResponse {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int pollingTickSecs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<LiveProduct> liveProducts = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String cookie = "";

    /* renamed from: a, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    public final List<LiveProduct> b() {
        return this.liveProducts;
    }

    /* renamed from: c, reason: from getter */
    public final int getPollingTickSecs() {
        return this.pollingTickSecs;
    }

    /* renamed from: d, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECLiveWindowGetProductsRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONArray optJSONArray = data.optJSONArray("products");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = optJSONArray.get(i3);
                if (obj != null) {
                    this.liveProducts.add(LiveProduct.INSTANCE.b((JSONObject) obj));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        }
        this.total = data.optInt("total");
        this.isEnd = data.optBoolean("is_end");
        this.cookie = data.optString("cookie");
        this.pollingTickSecs = data.optInt("polling_tick");
        cg0.a.b("ECLiveWindowGetProductsRsp", "[decodeData] total=" + this.total + ", isEnd=" + this.isEnd);
        return true;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }
}
