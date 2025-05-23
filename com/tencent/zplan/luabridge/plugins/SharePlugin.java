package com.tencent.zplan.luabridge.plugins;

import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.proxy.api.IZPlanShareProxy;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/SharePlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleShareVideo", "<init>", "()V", "d", "Companion", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class SharePlugin extends LuaBasePlugin {
    @LuaEvent("L2N_SameStyle_Share")
    @Nullable
    public final String handleShareVideo(@NotNull LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        ZLog zLog = ZLog.f386189b;
        zLog.f("SharePlugin", "handleShareVideo with params: " + argument.getParams());
        JSONObject jSONObject = new JSONObject(argument.getParams());
        String optString = jSONObject.optString("Url");
        if (optString == null) {
            optString = "";
        }
        int optInt = jSONObject.optInt("SameStyleID", 0);
        int optInt2 = jSONObject.optInt("ContentType", -1);
        if (optString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            zLog.f("SharePlugin", "share url = " + optString + ", is not valid");
            return argument.fail("invalid params: url is empty");
        }
        int optInt3 = jSONObject.optInt("SameStyleMode", 0);
        int optInt4 = jSONObject.optInt("TemplateTab", 0);
        if (optInt3 == 1) {
            IZPlanShareProxy iZPlanShareProxy = (IZPlanShareProxy) mx4.a.f417748a.a(IZPlanShareProxy.class);
            if (iZPlanShareProxy != null) {
                iZPlanShareProxy.b(new IZPlanShareProxy.ShareData(optInt, optInt2, optString, optInt4));
            }
        } else {
            IZPlanShareProxy iZPlanShareProxy2 = (IZPlanShareProxy) mx4.a.f417748a.a(IZPlanShareProxy.class);
            if (iZPlanShareProxy2 != null) {
                iZPlanShareProxy2.a(null, new IZPlanShareProxy.ShareData(optInt, optInt2, optString, optInt4));
            }
        }
        return argument.ok();
    }
}
