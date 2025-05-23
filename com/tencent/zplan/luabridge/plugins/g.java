package com.tencent.zplan.luabridge.plugins;

import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zx4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/g;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleOpenSetting", "handleOpenSameStyle", "<init>", "()V", "e", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class g extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f385737d = "StorePlugin";

    @LuaEvent("L2N_SameStyle_EnterMainPanel")
    @Nullable
    public final String handleOpenSameStyle(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        boolean z16 = true;
        ZLog.f386189b.i(f385737d, 1, "handleOpenSameStyle");
        if (argument.getParams().length() <= 0) {
            z16 = false;
        }
        String str = "sameStyle";
        if (z16) {
            str = "sameStyle#" + argument.getParams();
        }
        u uVar = (u) mx4.a.f417748a.a(u.class);
        if (uVar != null) {
            uVar.a(str);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_OpenSettingsPanel")
    @Nullable
    public final String handleOpenSetting(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        ZLog.f386189b.i(f385737d, 1, "handleOpenSetting");
        u uVar = (u) mx4.a.f417748a.a(u.class);
        if (uVar != null) {
            uVar.a("setting");
        }
        return argument.ok();
    }
}
