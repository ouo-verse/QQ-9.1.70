package com.tencent.mobileqq.zootopia.ipc.handle_ipc;

import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.dresskey.b;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import hc3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tj3.a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/handle_ipc/HandlerIPCImpl;", "Lhc3/a;", "Lorg/json/JSONObject;", "data", "", "handleNative", "toMain", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class HandlerIPCImpl implements a {
    public static final String KEY_BUSINESS = "business";
    public static final String KEY_METHOD = "method";
    public static final String KEY_PARAMS = "params";

    private final boolean handleNative(JSONObject data) {
        String optString = data.optString("business");
        String optString2 = data.optString("method");
        String params = data.optString("params");
        QLog.i("HandlerIPCImpl", 1, "handleNative business:" + optString + " method:" + optString2 + " params:" + params);
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode != -1563081780) {
                if (hashCode != -1068833864) {
                    if (hashCode == -695505019 && optString.equals(IZplanHandleApi.BUSINESS_DRESS_INFO) && Intrinsics.areEqual(optString2, IZplanHandleApi.METHOD_REFRESH_DRESS_INFO)) {
                        b bVar = b.f369818a;
                        Intrinsics.checkNotNullExpressionValue(params, "params");
                        bVar.t(params, true);
                    }
                } else if (optString.equals(IZplanHandleApi.BUSINESS_MOD_API) && Intrinsics.areEqual(optString2, IZplanHandleApi.METHOD_SILENCE_DOWNLOAD)) {
                    String sceneName = new JSONObject(params).optString("sceneName");
                    si3.b bVar2 = (si3.b) vb3.a.f441346a.a(si3.b.class);
                    Intrinsics.checkNotNullExpressionValue(sceneName, "sceneName");
                    bVar2.Q(sceneName, true);
                }
            } else if (optString.equals(IZplanHandleApi.BUSINESS_RESERVE) && Intrinsics.areEqual(optString2, IZplanHandleApi.METHOD_REFRESH_RESERVE)) {
                a.C11293a.a((tj3.a) vb3.a.f441346a.a(tj3.a.class), 0, 0, null, 7, null);
            }
        }
        return true;
    }

    @Override // hc3.a
    public boolean toMain(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("HandlerIPCImpl", 1, "toMain data=" + data);
        if (data.optBoolean("isToUE")) {
            com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
            if (S != null) {
                String jSONObject = data.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
                a.C10063a.b(S, "N2L_HandleNativeData", jSONObject, null, 4, null);
            }
        } else {
            handleNative(data);
        }
        return true;
    }
}
