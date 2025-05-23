package com.tencent.mobileqq.zootopia.lua;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/aa;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleUeCacheAction", "handleGetFaceControlConfig", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class aa extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final aa f328467d = new aa();

    aa() {
    }

    @LuaEvent("L2N_GetFaceControlConfig")
    public final String handleGetFaceControlConfig(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        String faceEditorFaceControlCfg = ((cj3.a) k74.i.INSTANCE.a(cj3.a.class)).getFaceEditorFaceControlCfg();
        QLog.i("ZPlanUECachePlugin_", 1, "handleGetFaceControlConfig cbData:" + faceEditorFaceControlCfg);
        argument.callback(faceEditorFaceControlCfg);
        return "";
    }

    @LuaEvent("L2N_CacheInfoAction")
    public final String handleUeCacheAction(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanUECachePlugin_", 1, "handleUeCacheAction, params:" + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        JSONArray optJSONArray = jSONObject.optJSONArray("cacheKeyList");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int optInt = jSONObject.optInt("action");
            int length = optJSONArray.length();
            QLog.i("ZPlanUECachePlugin_", 1, "handleUeCacheAction, action:" + optInt + ", cacheKeyList:" + optJSONArray);
            int i3 = 0;
            if (optInt == 1) {
                JSONObject jSONObject2 = new JSONObject();
                int i16 = 0;
                while (i16 < length) {
                    String cacheKey = optJSONArray.optString(i16);
                    i16++;
                    Intrinsics.checkNotNullExpressionValue(cacheKey, "cacheKey");
                    if (!(cacheKey.length() == 0)) {
                        String queryCache = ((ue3.b) vb3.a.f441346a.b(ue3.b.class)).queryCache(cacheKey);
                        if (!(queryCache.length() == 0)) {
                            jSONObject2.put(cacheKey, queryCache);
                            QLog.i("ZPlanUECachePlugin_", 1, "handleUeCacheAction, callbackData cacheKey:" + cacheKey + ", cacheData:" + CommonExKt.g(queryCache));
                        }
                    }
                }
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "result.toString()");
                argument.callback(jSONObject3);
            } else if (optInt == 2) {
                while (i3 < length) {
                    String cacheKey2 = optJSONArray.optString(i3);
                    i3++;
                    ue3.c cVar = (ue3.c) k74.i.INSTANCE.a(ue3.c.class);
                    Intrinsics.checkNotNullExpressionValue(cacheKey2, "cacheKey");
                    cVar.deleteCache(cacheKey2);
                }
                ((ue3.c) k74.i.INSTANCE.a(ue3.c.class)).sync();
            }
            return "";
        }
        QLog.e("ZPlanUECachePlugin_", 1, "handleUeCacheAction, cacheKeyList is empty!");
        return "";
    }
}
