package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Ldi0/d;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "liveUid", "", "b", "J", "roomId", "<init>", "(Ljava/lang/String;J)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class d implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String liveUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    public d(String str, long j3) {
        this.liveUid = str;
        this.roomId = j3;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("account_type", 4);
            jSONObject2.put("qq_live_room_id", this.roomId);
            jSONObject2.put("qq_live_user_id", this.liveUid);
            jSONObject2.put("qqlive_user_id", this.liveUid);
            jSONObject.put("account", jSONObject2);
            jSONObject.put(AudienceReportConst.ROOM_ID, this.roomId);
            jSONObject.put("qqlive_user_id", this.liveUid);
            jSONObject.put("qq_live_user_id", this.liveUid);
            jSONObject.put(WadlProxyConsts.CHANNEL, 8);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECQQLiveEntryRequest", "encodeParams", "error:" + e16.getLocalizedMessage());
            return jSONObject;
        }
    }
}
