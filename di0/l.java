package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B/\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Ldi0/l;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "J", "liveRoomId", "", "b", "I", WadlProxyConsts.CHANNEL, "", "", "c", "Ljava/util/Map;", "transKV", "<init>", "(JILjava/util/Map;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class l implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long liveRoomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int channel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> transKV;

    public l(long j3, int i3, Map<String, String> map) {
        this.liveRoomId = j3;
        this.channel = i3;
        this.transKV = map;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AudienceReportConst.ROOM_ID, this.liveRoomId);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
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
            cg0.a.b("ECLiveWindowGetExplainProductReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWindowGetExplainProductReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }

    public /* synthetic */ l(long j3, int i3, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, (i16 & 4) != 0 ? null : map);
    }
}
