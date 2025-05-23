package di0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.ScrollDirection;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001\u0005Bs\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\b\u0003\u0010\"\u001a\u00020\f\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010#\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u000eR\"\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Ldi0/t;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "liveUserId", "", "b", "J", "liveRoomId", "", "c", "I", WadlProxyConsts.CHANNEL, "d", "cookie", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "e", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "f", "query", "", "Lcom/tencent/ecommerce/repo/live/q;", "g", "Ljava/util/List;", "dataList", "", tl.h.F, "Z", "isRefreshAll", "i", "scrollDirection", "", "j", "Ljava/util/Map;", "transKV", "<init>", "(Ljava/lang/String;JILjava/lang/String;Lcom/tencent/ecommerce/biz/live/LiveTabId;Ljava/lang/String;Ljava/util/List;ZILjava/util/Map;)V", "k", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class t implements IECRequest {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String liveUserId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long liveRoomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int channel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String cookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveTabId tabId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String query;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final List<LiveProduct> dataList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isRefreshAll;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int scrollDirection;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> transKV;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Ldi0/t$a;", "", "", "isMaster", "", "b", "a", "", "ACCOUNT_TYPE_LIVE", "I", "METHOD_GUEST", "Ljava/lang/String;", "METHOD_MASTER", "SERVICE_GUEST", "SERVICE_MASTER", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: di0.t$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(boolean isMaster) {
            if (isMaster) {
                return "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/Get";
            }
            return "/trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/Get";
        }

        public final String b(boolean isMaster) {
            if (isMaster) {
                return "trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr";
            }
            return "trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr";
        }
    }

    public t(String str, long j3, int i3, String str2, LiveTabId liveTabId, String str3, List<LiveProduct> list, boolean z16, @ScrollDirection int i16, Map<String, String> map) {
        this.liveUserId = str;
        this.liveRoomId = j3;
        this.channel = i3;
        this.cookie = str2;
        this.tabId = liveTabId;
        this.query = str3;
        this.dataList = list;
        this.isRefreshAll = z16;
        this.scrollDirection = i16;
        this.transKV = map;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        Object last;
        LiveProduct liveProduct;
        Object first;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AudienceReportConst.ROOM_ID, this.liveRoomId);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            if (!this.isRefreshAll) {
                jSONObject.put("cookie", this.cookie);
            }
            jSONObject.put(com.qzone.widget.u.COLUMN_TAB_ID, this.tabId.getValue());
            jSONObject.put("query", this.query);
            if ((!this.dataList.isEmpty()) && !this.isRefreshAll) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.scrollDirection == 1) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.dataList);
                    liveProduct = (LiveProduct) first;
                } else {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.dataList);
                    liveProduct = (LiveProduct) last;
                }
                jSONObject2.put(ReportDataBuilder.KEY_PRODUCT_ID, LiveProduct.INSTANCE.a(liveProduct));
                jSONObject2.put("direction", this.scrollDirection);
                jSONObject2.put("index", liveProduct.getIndex());
                jSONObject.put("pagingCookie", jSONObject2);
            }
            Map<String, String> map = this.transKV;
            if (map != null) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(entry.getKey(), entry.getValue());
                    Unit unit = Unit.INSTANCE;
                    jSONArray.mo162put(jSONObject3);
                }
                jSONObject.put("trans_kv", jSONArray);
            }
            cg0.a.b("ECLiveWindowGetProductsReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWindowGetProductsReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
