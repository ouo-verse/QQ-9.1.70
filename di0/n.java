package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\u0005BO\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Ldi0/n;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "a", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "", "b", "J", "liveRoomId", "", "c", "I", WadlProxyConsts.CHANNEL, "", "d", "Ljava/lang/String;", "cookie", "e", "couponId", "", "f", "Z", "isRefreshAll", "", "g", "Ljava/util/Map;", "transKV", "<init>", "(Lcom/tencent/ecommerce/biz/live/LiveTabId;JILjava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class n implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LiveTabId tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long liveRoomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int channel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String cookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String couponId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isRefreshAll;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> transKV;

    public n(LiveTabId liveTabId, long j3, int i3, String str, String str2, boolean z16, Map<String, String> map) {
        this.tabId = liveTabId;
        this.liveRoomId = j3;
        this.channel = i3;
        this.cookie = str;
        this.couponId = str2;
        this.isRefreshAll = z16;
        this.transKV = map;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.qzone.widget.u.COLUMN_TAB_ID, this.tabId.getValue());
            jSONObject.put(AudienceReportConst.ROOM_ID, this.liveRoomId);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            jSONObject.put("coupon_id", this.couponId);
            if (!this.isRefreshAll) {
                jSONObject.put("cookie", this.cookie);
            }
            Map<String, String> map = this.transKV;
            if (map != null) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(entry.getKey(), entry.getValue());
                    Unit unit = Unit.INSTANCE;
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put("trans_kv", jSONArray);
            }
            cg0.a.b("ECLiveWindowGetCouponProductsReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWindowGetCouponProductsReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
