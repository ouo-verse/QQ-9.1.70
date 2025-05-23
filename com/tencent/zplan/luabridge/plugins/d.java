package com.tencent.zplan.luabridge.plugins;

import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/d;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "getGraphicsQuality", "<init>", "()V", "d", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class d extends LuaBasePlugin {
    @LuaEvent("L2N_GraphicsQuality")
    @Nullable
    public final String getGraphicsQuality(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        ZLog.f386189b.k("GraphicsPlugin", "getGraphicsQuality, params:" + argument.getParams());
        zx4.f fVar = (zx4.f) mx4.a.f417748a.a(zx4.f.class);
        if (fVar != null) {
            fVar.a(argument.getParams());
        }
        return argument.ok();
    }
}
