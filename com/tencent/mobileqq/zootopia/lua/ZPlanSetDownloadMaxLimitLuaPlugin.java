package com.tencent.mobileqq.zootopia.lua;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanSetDownloadMaxLimitLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "setDownloadMaxLimit", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanSetDownloadMaxLimitLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanSetDownloadMaxLimitLuaPlugin> f328414e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanSetDownloadMaxLimitLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanSetDownloadMaxLimitLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanSetDownloadMaxLimitLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZPlanSetDownloadMaxLimitLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanSetDownloadMaxLimitLuaPlugin a() {
            return (ZPlanSetDownloadMaxLimitLuaPlugin) ZPlanSetDownloadMaxLimitLuaPlugin.f328414e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanSetDownloadMaxLimitLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanSetDownloadMaxLimitLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanSetDownloadMaxLimitLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanSetDownloadMaxLimitLuaPlugin invoke() {
                return new ZPlanSetDownloadMaxLimitLuaPlugin();
            }
        });
        f328414e = lazy;
    }

    @LuaEvent("L2N_SetDownloadMaxLimit")
    public final String setDownloadMaxLimit(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanSetDownloadMaxLimitLuaPlugin", 1, "setDownloadMaxLimit, " + argument);
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("modId");
        int optInt = jSONObject.optInt("maxLimit", 0);
        if (!TextUtils.isEmpty(optString) && optInt > 0) {
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).setLuaDownloadMaxLimit(optString, optInt);
            argument.callback(argument.ok());
            return "";
        }
        argument.callback(argument.fail());
        return "";
    }
}
