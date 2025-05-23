package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import cooperation.qzone.remote.ServiceConst;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B/\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Ldi0/f;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "liveUserId", "", "b", "J", "liveRoomId", "", "c", "I", "openTabLevel", "d", "title", "e", "sessionId", "<init>", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class f implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String liveUserId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long liveRoomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int openTabLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String sessionId;

    public f(String str, long j3, int i3, String str2, String str3) {
        this.liveUserId = str;
        this.liveRoomId = j3;
        this.openTabLevel = i3;
        this.title = str2;
        this.sessionId = str3;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.CHANNEL, 8);
            jSONObject.put("qqlive_user_id", this.liveUserId);
            jSONObject.put(AudienceReportConst.ROOM_ID, this.liveRoomId);
            jSONObject.put("is_open_tab", this.openTabLevel);
            jSONObject.put("title", this.title);
            jSONObject.put(ServiceConst.PARA_SESSION_ID, this.sessionId);
            cg0.a.b("ECLiveOpenReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveOpenReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
