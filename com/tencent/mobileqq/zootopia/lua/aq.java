package com.tencent.mobileqq.zootopia.lua;

import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/aq;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleUEData", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class aq extends LuaBasePlugin {
    @LuaEvent("L2N_HandleUEData")
    public final String handleUEData(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getParams());
        jSONObject.put("isToUE", false);
        if (((hc3.a) k74.i.INSTANCE.a(hc3.a.class)).toMain(jSONObject)) {
            return argument.ok();
        }
        return argument.fail();
    }
}
