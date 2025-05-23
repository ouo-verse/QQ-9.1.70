package ej0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.repo.live.ECShopBaseInfo;
import com.tencent.ecommerce.repo.live.ECShopDetail;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lej0/b;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/live/h;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "shopList", "", "<set-?>", "e", "I", "a", "()I", "liveWindowTotal", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ECShopDetail> shopList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int liveWindowTotal;

    /* renamed from: a, reason: from getter */
    public final int getLiveWindowTotal() {
        return this.liveWindowTotal;
    }

    public final ArrayList<ECShopDetail> b() {
        return this.shopList;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECLiveQShopShowWindowGetAllShopRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONArray optJSONArray = data.optJSONArray("shops");
        this.liveWindowTotal = data.optInt("live_window_total");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return true;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i3);
            this.shopList.add(new ECShopDetail(new ECShopBaseInfo(jSONObject.optString("shop_id"), jSONObject.optString("shop_name"), jSONObject.optString("shop_logo"), jSONObject.optInt("shop_status"))));
        }
        return true;
    }
}
