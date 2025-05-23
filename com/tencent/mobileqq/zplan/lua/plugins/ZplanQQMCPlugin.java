package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZplanQQMCPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "", "loadQQMCConfig", "loadQQMCSwitch", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanQQMCPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZplanQQMCPlugin> f333828e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZplanQQMCPlugin$a;", "", "Lcom/tencent/mobileqq/zplan/lua/plugins/ZplanQQMCPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/lua/plugins/ZplanQQMCPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.lua.plugins.ZplanQQMCPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZplanQQMCPlugin a() {
            return (ZplanQQMCPlugin) ZplanQQMCPlugin.f333828e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZplanQQMCPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZplanQQMCPlugin>() { // from class: com.tencent.mobileqq.zplan.lua.plugins.ZplanQQMCPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanQQMCPlugin invoke() {
                return new ZplanQQMCPlugin();
            }
        });
        f333828e = lazy;
    }

    @LuaEvent("L2N_LoadQQMCConfig")
    public final String loadQQMCConfig(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        String configId = new JSONObject(arg.getF440574c()).optString("configId");
        QLog.i("ZplanQQMCPlugin", 1, "loadQQMCConfig configId = " + configId);
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(configId, "configId");
        byte[] loadRawConfig = iUnitedConfigManager.loadRawConfig(configId, new byte[0]);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isSuccess", (loadRawConfig.length == 0 ? 1 : 0) ^ 1);
        jSONObject.put("result", com.tencent.mobileqq.wifi.a.f(loadRawConfig, 2));
        arg.callback(arg.ok(jSONObject));
        return arg.ok();
    }

    @LuaEvent("L2N_LoadQQMCSwitch")
    public final String loadQQMCSwitch(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        JSONObject jSONObject = new JSONObject(arg.getF440574c());
        String configId = jSONObject.optString("configId");
        boolean optBoolean = jSONObject.optBoolean(AdMetricTag.FALLBACK, false);
        QLog.i("ZplanQQMCPlugin", 1, "loadQQMCSwitch configId = " + configId + " fallback = " + optBoolean);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("isSuccess", 1);
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(configId, "configId");
        jSONObject2.put("result", iUnitedConfigManager.isSwitchOn(configId, optBoolean));
        arg.callback(arg.ok(jSONObject2));
        return arg.ok();
    }
}
