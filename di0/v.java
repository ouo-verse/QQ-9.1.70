package di0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.biz.live.LiveScene;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Ldi0/v;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", WadlProxyConsts.CHANNEL, "", "b", "J", "roomId", "Lcom/tencent/ecommerce/biz/live/LiveScene;", "c", "Lcom/tencent/ecommerce/biz/live/LiveScene;", "scene", "<init>", "(IJLcom/tencent/ecommerce/biz/live/LiveScene;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class v implements IECRequest {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LiveScene scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Ldi0/v$a;", "", "", "isMaster", "", "b", "a", "METHOD_GUEST", "Ljava/lang/String;", "METHOD_MASTER", "SERVICE_GUEST", "SERVICE_MASTER", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: di0.v$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(boolean isMaster) {
            if (isMaster) {
                return "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/GetWindowTabs";
            }
            return "/trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetWindowTabs";
        }

        public final String b(boolean isMaster) {
            if (isMaster) {
                return "trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr";
            }
            return "trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr";
        }
    }

    public v(int i3, long j3, LiveScene liveScene) {
        this.channel = i3;
        this.roomId = j3;
        this.scene = liveScene;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            jSONObject.put(AudienceReportConst.ROOM_ID, this.roomId);
            jSONObject.put("scene", this.scene.getValue());
            cg0.a.b("ECLiveWindowGetTabsReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWindowGetTabsReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
