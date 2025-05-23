package com.tencent.mobileqq.zootopia.lua;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/z;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "isFolderScreenOpenMode", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class z extends LuaBasePlugin {
    @LuaEvent("L2N_GetScreenStatus")
    public final String isFolderScreenOpenMode(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        u.Companion companion = t74.u.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        boolean e16 = u.Companion.e(companion, context, false, 2, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isFolderScreenOpenMode", e16 ? 1 : 0);
        String ok5 = argument.ok(jSONObject);
        QLog.i("ZplanScreenParams", 1, "isFolderScreenOpenMode, " + ok5);
        argument.callback(ok5);
        return "";
    }
}
