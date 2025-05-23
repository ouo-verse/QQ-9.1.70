package dj0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B7\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Ldj0/a;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", WadlProxyConsts.CHANNEL, "", "b", "J", "roomId", "", "c", "Ljava/lang/String;", "userId", "d", "query", "e", "windowType", "f", "getCookie", "()Ljava/lang/String;", "cookie", "<init>", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "g", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String userId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String query;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int windowType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String cookie;

    public a(int i3, long j3, String str, String str2, int i16, String str3) {
        this.channel = i3;
        this.roomId = j3;
        this.userId = str;
        this.query = str2;
        this.windowType = i16;
        this.cookie = str3;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            jSONObject.put("query", this.query);
            jSONObject.put("window_type", this.windowType);
            jSONObject.put("cookie", this.cookie);
            jSONObject.put(AudienceReportConst.ROOM_ID, this.roomId);
            jSONObject.put("qqlive_user_id", this.userId);
            cg0.a.b("LiveWindowGetProductReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("LiveWindowGetProductReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
