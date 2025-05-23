package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Ldi0/i;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", "startTimeSec", "b", "endTimeSec", "c", WadlProxyConsts.CHANNEL, "<init>", "(III)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class i implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int startTimeSec;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int endTimeSec;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int channel;

    public i(int i3, int i16, int i17) {
        this.startTimeSec = i3;
        this.endTimeSec = i16;
        this.channel = i17;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("start", this.startTimeSec);
            jSONObject2.put("end", this.endTimeSec);
            jSONObject.put("time_range", jSONObject2);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            cg0.a.b("LiveTransactionGetStatReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("LiveTransactionGetStatReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
