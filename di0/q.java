package di0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.LiveProduct;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Ldi0/q;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Lcom/tencent/ecommerce/repo/live/q;", "d", "Lcom/tencent/ecommerce/repo/live/q;", "a", "()Lcom/tencent/ecommerce/repo/live/q;", "setProduct", "(Lcom/tencent/ecommerce/repo/live/q;)V", "product", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "e", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "getTabId", "()Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class q implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LiveProduct product;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveTabId tabId = LiveTabId.LIVE_TAB_PRODUCT;

    /* renamed from: a, reason: from getter */
    public final LiveProduct getProduct() {
        return this.product;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECLiveWindowGetExplainingProductRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("product");
        if (optJSONObject != null) {
            this.product = LiveProduct.INSTANCE.b(optJSONObject);
        }
        return true;
    }
}
