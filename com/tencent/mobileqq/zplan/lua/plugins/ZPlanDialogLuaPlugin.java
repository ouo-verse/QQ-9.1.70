package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEShowDialogEvent;
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
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanDialogLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleOpenAlert", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanDialogLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanDialogLuaPlugin> f333816e;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanDialogLuaPlugin$a;", "", "", "isCancel", "", "a", "Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanDialogLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanDialogLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "PARAMS_BTNTEXTS", "Ljava/lang/String;", "PARAMS_MSG", "PARAMS_TITLE", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.lua.plugins.ZPlanDialogLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(boolean isCancel) {
            JSONObject jSONObject = new JSONObject();
            if (isCancel) {
                jSONObject.put("selectBtn", 0);
            } else {
                jSONObject.put("selectBtn", 1);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
            return jSONObject2;
        }

        public final ZPlanDialogLuaPlugin b() {
            return (ZPlanDialogLuaPlugin) ZPlanDialogLuaPlugin.f333816e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanDialogLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanDialogLuaPlugin>() { // from class: com.tencent.mobileqq.zplan.lua.plugins.ZPlanDialogLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanDialogLuaPlugin invoke() {
                return new ZPlanDialogLuaPlugin();
            }
        });
        f333816e = lazy;
    }

    @LuaEvent("L2N_ShowAlert")
    public final String handleOpenAlert(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanDialogLuaPlugin", 1, "handleOpenAlert, argument: argument" + argument);
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String title = jSONObject.optString("title");
        String msg2 = jSONObject.optString("msg");
        JSONArray optJSONArray = jSONObject.optJSONArray("btnTexts");
        QLog.d("ZPlanDialogLuaPlugin", 1, "handleOpenAlert, params: " + jSONObject);
        if (optJSONArray != null && optJSONArray.length() >= 0) {
            boolean isFloat = ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat();
            int length = optJSONArray.length();
            if (length == 1) {
                String confirmBtn = optJSONArray.optString(0);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                Intrinsics.checkNotNullExpressionValue(confirmBtn, "confirmBtn");
                simpleEventBus.dispatchEvent(new ZPlanUEShowDialogEvent(title, msg2, confirmBtn, "", argument, null, isFloat ? 1 : 0, 32, null));
            } else if (length == 2) {
                String cancelBtn = optJSONArray.optString(0);
                String confirmBtn2 = optJSONArray.optString(1);
                SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                Intrinsics.checkNotNullExpressionValue(confirmBtn2, "confirmBtn");
                Intrinsics.checkNotNullExpressionValue(cancelBtn, "cancelBtn");
                simpleEventBus2.dispatchEvent(new ZPlanUEShowDialogEvent(title, msg2, confirmBtn2, cancelBtn, argument, null, isFloat ? 1 : 0, 32, null));
            }
            return argument.ok();
        }
        QLog.d("ZPlanDialogLuaPlugin", 1, "handleOpenAlert, brn array is empty, return");
        return argument.ok();
    }
}
