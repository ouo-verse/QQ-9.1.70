package gg3;

import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.perf.tool.b;
import com.tencent.mobileqq.zplan.cloudmod.impl.cloudgame.data.CloudModEvent;
import com.tencent.mobileqq.zplan.cloudmod.impl.cloudgame.data.CloudUpdateProgressEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lg3.CloudNetworkData;
import lg3.c;
import org.json.JSONObject;
import zx4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lgg3/a;", "", "Lorg/json/JSONObject;", "jsonData", "", "b", ark.ARKMETADATA_JSON, "c", "", "data", "", "a", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f402031a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Gson gson = new Gson();

    a() {
    }

    private final void b(JSONObject jsonData) {
        String msg2 = jsonData.optString("msg");
        String status = jsonData.optString("status");
        String deviceId = jsonData.optString(Constants.SP_DEVICE_ID);
        String gmUid = jsonData.optString("gmUid");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(status, "status");
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        Intrinsics.checkNotNullExpressionValue(deviceId, "deviceId");
        Intrinsics.checkNotNullExpressionValue(gmUid, "gmUid");
        simpleEventBus.dispatchEvent(new CloudUpdateProgressEvent(status, msg2, deviceId, gmUid));
    }

    private final void c(JSONObject json) {
        QLog.i("ZPlanMsgHandler", 1, "updateNetworkStatus json:" + json);
        CloudNetworkData cloudNetworkData = new CloudNetworkData(json.optInt("delay"), json.optInt("packetsLost"), json.optInt("packetsReceived"), json.optInt("frameRate"), json.optInt("frameWidth"), json.optInt("frameHeight"));
        lg3.a.f414537a.e(cloudNetworkData);
        c.f414549a.b(cloudNetworkData);
    }

    public final boolean a(String data) {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d("ZPlanMsgHandler", 1, "handleMsg, data:" + data);
        if (data == null || data.length() == 0) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(data);
        String g16 = b.g(jSONObject, "cmd", "");
        int hashCode = g16.hashCode();
        if (hashCode != -988489396) {
            if (hashCode != -417601148) {
                if (hashCode == -332077845 && g16.equals("CG_GAME_EVENT_SEND_MSG_2_QQ")) {
                    int optInt = jSONObject.optInt("type");
                    String extraData = jSONObject.getString(WadlProxyConsts.EXTRA_DATA);
                    long optLong = jSONObject.optLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
                    String jSONObject2 = b.e(jSONObject, "msg", new JSONObject()).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.getJSONObject(\"\u2026 JSONObject()).toString()");
                    Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
                    ZPlanModRPCData zPlanModRPCData = new ZPlanModRPCData(optInt, null, null, jSONObject2, optLong, g16, extraData, 6, null);
                    QLog.d("ZPlanMsgHandler", 1, "handleMsg, rpcData:" + zPlanModRPCData);
                    if (zPlanModRPCData.getType() == 0) {
                        QLog.d("ZPlanMsgHandler", 1, "handle req");
                        ux4.b.f440566e.d(zPlanModRPCData);
                        kg3.a.f412316a.o(zPlanModRPCData, currentTimeMillis);
                    } else if (zPlanModRPCData.getType() == 1) {
                        QLog.d("ZPlanMsgHandler", 1, "handle rsp");
                        l lVar = (l) mx4.a.f417748a.a(l.class);
                        if (lVar != null) {
                            lVar.b(zPlanModRPCData);
                        }
                    } else if (zPlanModRPCData.getType() == 2) {
                        SimpleEventBus.getInstance().dispatchEvent(new CloudModEvent(1));
                    }
                    return true;
                }
            } else if (g16.equals("CG_GAME_EVENT_UPDATE_NETWORK_STAT")) {
                c(jSONObject);
            }
        } else if (g16.equals("CG_GAME_EVENT_UPDATE_PROGRESS")) {
            b(jSONObject);
        }
        return true;
    }
}
