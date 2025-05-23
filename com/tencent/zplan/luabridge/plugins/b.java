package com.tencent.zplan.luabridge.plugins;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/b;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "getDeviceInfo", "<init>", "()V", "e", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f385728d = "DeviceInfoPlugin";

    @LuaEvent("L2N_GetDeviceInfo")
    @Nullable
    public final String getDeviceInfo(@NotNull LuaArgument argument) {
        String str;
        Intrinsics.checkNotNullParameter(argument, "argument");
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        String str2 = null;
        if (aVar != null) {
            str = aVar.getImei();
        } else {
            str = null;
        }
        if (aVar != null) {
            str2 = aVar.c();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("DeviceName", DeviceInfoMonitor.getModel());
        jSONObject.put("DeviceID", str);
        jSONObject.put("OSVersion", Build.VERSION.RELEASE);
        com.tencent.zplan.utils.a aVar2 = com.tencent.zplan.utils.a.f386200a;
        jSONObject.put("NetworkProvider", aVar2.a());
        jSONObject.put("IP", str2);
        jSONObject.put("NetworkType", aVar2.b());
        String ok5 = argument.ok(jSONObject);
        argument.callback(ok5);
        ZLog.f386189b.i(f385728d, 1, "L2N_GetDeviceInfo:" + jSONObject);
        return ok5;
    }
}
