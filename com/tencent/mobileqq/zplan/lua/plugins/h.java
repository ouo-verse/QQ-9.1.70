package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/h;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "", "setRedDotUnreadCount", "setRedDotUnreadCountV2", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final h f333848d = new h();

    h() {
    }

    @LuaEvent("L2N_SetUnreadCount")
    public final String setRedDotUnreadCount(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.d("ZPlanRedDotLuaPlugin", 1, "setRedDotUnreadCount " + new JSONObject(arg.getF440574c()).opt("Count") + ".");
        return arg.ok();
    }

    @LuaEvent("L2N_SetUnreadCountV2")
    public final String setRedDotUnreadCountV2(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        Object opt = new JSONObject(arg.getF440574c()).opt("Count");
        QLog.d("ZPlanRedDotLuaPlugin", 1, "setRedDotUnreadCountV2 " + opt + ".");
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.notifyUI(4, true, opt);
        }
        return arg.ok();
    }
}
