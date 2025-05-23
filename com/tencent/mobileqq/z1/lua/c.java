package com.tencent.mobileqq.z1.lua;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0002\r\u000eB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/z1/lua/c;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleLeaveAvatarScene", "Lcom/tencent/mobileqq/z1/lua/c$b;", "d", "Lcom/tencent/mobileqq/z1/lua/c$b;", "leaveCallback", "<init>", "(Lcom/tencent/mobileqq/z1/lua/c$b;)V", "e", "a", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b leaveCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/z1/lua/c$b;", "", "", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        boolean a();
    }

    public c(@NotNull b leaveCallback) {
        Intrinsics.checkNotNullParameter(leaveCallback, "leaveCallback");
        this.leaveCallback = leaveCallback;
    }

    @LuaEvent("L2N_LeaveAvatarScene")
    @NotNull
    public final String handleLeaveAvatarScene(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaLeaveAvatarScenePlugin", 1, "handleLeaveAvatarScene :: " + argument.getParams());
        if (this.leaveCallback.a()) {
            return argument.ok();
        }
        return argument.fail();
    }
}
