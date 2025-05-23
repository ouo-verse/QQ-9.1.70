package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zplan.smallhome.ZPlanUEActivityHelper;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanCloseLoadingViewEvent;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanShowClearResourceBtnEvent;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEScaleEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import defpackage.UEBuglyInfoRecorder;
import k74.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanSmallHomeLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "nativeId", "type", "source", "", "e", "", "success", "msg", "Lorg/json/JSONObject;", "c", "isFloatingWindow", "b", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "handleSwitchFloatWindow", "handleMapSelfExit", "handleMapIsFloatingWindow", "handleMapCloseLoadingView", "handleMapSetLoadingProgress", "handleMapSetGameVer", "handleShowClearResourceBtn", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSmallHomeLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static String f333821e = "mapId";

    /* renamed from: f, reason: collision with root package name */
    private static String f333822f = "jumpScheme";

    /* renamed from: h, reason: collision with root package name */
    private static String f333823h = "nativeId";

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy<ZPlanSmallHomeLuaPlugin> f333824i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanSmallHomeLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanSmallHomeLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanSmallHomeLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "PARAMS_PRONUM", "Ljava/lang/String;", "PARAMS_TXT1", "PARAMS_TXT2", "PARAMS_VER1", "PARAMS_VER2", "PARAMS_VER3", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.lua.plugins.ZPlanSmallHomeLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanSmallHomeLuaPlugin a() {
            return (ZPlanSmallHomeLuaPlugin) ZPlanSmallHomeLuaPlugin.f333824i.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanSmallHomeLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanSmallHomeLuaPlugin>() { // from class: com.tencent.mobileqq.zplan.lua.plugins.ZPlanSmallHomeLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanSmallHomeLuaPlugin invoke() {
                return new ZPlanSmallHomeLuaPlugin();
            }
        });
        f333824i = lazy;
    }

    private final JSONObject b(boolean isFloatingWindow) {
        JSONObject jSONObject = new JSONObject();
        if (isFloatingWindow) {
            jSONObject.put("isFloatingWindow", 1);
            jSONObject.put("nativeId", "fake native id");
        } else {
            jSONObject.put("isFloatingWindow", 0);
            jSONObject.put("nativeId", "");
        }
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "getIsFloatCallBackResult, resultJson: " + jSONObject);
        return jSONObject;
    }

    private final JSONObject c(boolean success, String msg2) {
        JSONObject jSONObject = new JSONObject();
        if (success) {
            jSONObject.put("errorCode", 0);
            jSONObject.put("errorMsg", msg2);
        } else {
            jSONObject.put("errorCode", -1);
            jSONObject.put("errorMsg", msg2);
        }
        return jSONObject;
    }

    private final void e(int mapId, String scheme, String nativeId, int type, int source) {
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanUEScaleEvent(mapId, scheme, nativeId, type, source));
    }

    @LuaEvent("L2N_MapCloseLoadingView")
    public final String handleMapCloseLoadingView(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapCloseLoadingView, argument: argument" + argument);
        int optInt = new JSONObject(argument.getF440574c()).optInt(f333821e);
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanCloseLoadingViewEvent(optInt), true);
        ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).mapCloseLoadingView(optInt);
        return argument.ok();
    }

    @LuaEvent("L2N_MapIsFloatingWindow")
    public final String handleMapIsFloatingWindow(LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapIsFloatingWindow, argument: argument" + argument);
        try {
            z16 = ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat();
        } catch (Exception e16) {
            QLog.e("ZPlanSmallHomeLuaPlugin", 1, "L2N_MapIsFloatingWindow, exception", e16);
            z16 = false;
        }
        argument.callback(b(z16).toString());
        return argument.ok();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0097, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7, r0) != false) goto L25;
     */
    @LuaEvent("L2N_MapSelfExit")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String handleMapSelfExit(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapSelfExit, argument: argument" + argument);
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt(f333821e);
        String optString = jSONObject.optString(f333823h);
        String j3 = ZPlanUEActivityHelper.INSTANCE.a().j();
        i.Companion companion = k74.i.INSTANCE;
        ((ic3.a) companion.a(ic3.a.class)).modExit(optInt);
        ((com.tencent.mobileqq.zootopia.ipc.d) companion.a(com.tencent.mobileqq.zootopia.ipc.d.class)).onModExit(optInt);
        if (t74.h.e()) {
            UEBuglyInfoRecorder.f25109a.onSmallHomeExit();
        } else {
            ((defpackage.c) companion.a(defpackage.c.class)).onSmallHomeExit();
        }
        if (!Intrinsics.areEqual(j3, "null")) {
            if (j3.length() > 0) {
                if (!(optString == null || optString.length() == 0)) {
                }
            }
            QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapSelfExit, currentId: " + j3 + ", nativeId: " + optString + ", do not exit");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("native nativeId is ");
            sb5.append(j3);
            argument.callback(c(false, sb5.toString()).toString());
            rk3.b.f431651a.d(optInt, "");
            return argument.ok();
        }
        f(this, optInt, "", optString, 1, 0, 16, null);
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapSelfExit, currentId: " + j3 + ", notify exit");
        argument.callback(d(this, true, null, 2, null).toString());
        return argument.ok();
    }

    @LuaEvent("L2N_MapSetGameVersion")
    public final String handleMapSetGameVer(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapSetGameVer, argument: argument" + argument);
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt(f333821e);
        String ver1 = jSONObject.optString("ver1");
        String ver2 = jSONObject.optString("ver2");
        String ver3 = jSONObject.optString("ver3");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapSetGameVer, ver1: " + ver1 + ", ver2: " + ver2 + ", ver3: " + ver3 + ", " + jSONObject);
        com.tencent.mobileqq.zootopia.ipc.f fVar = (com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class);
        Intrinsics.checkNotNullExpressionValue(ver1, "ver1");
        Intrinsics.checkNotNullExpressionValue(ver2, "ver2");
        Intrinsics.checkNotNullExpressionValue(ver3, "ver3");
        fVar.mapSetGameVer(optInt, ver1, ver2, ver3);
        return argument.ok();
    }

    @LuaEvent("L2N_MapSetLoadingProgress")
    public final String handleMapSetLoadingProgress(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt(f333821e);
        int optInt2 = jSONObject.optInt("progress");
        String tips1 = jSONObject.optString("tips1");
        String tips2 = jSONObject.optString("tips2");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleMapSetLoadingProgress, mapId: " + optInt + ", progress: " + optInt2 + ", tips1: " + tips1 + ", tips2: " + tips2 + ", " + jSONObject);
        com.tencent.mobileqq.zootopia.ipc.f fVar = (com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class);
        Intrinsics.checkNotNullExpressionValue(tips1, "tips1");
        Intrinsics.checkNotNullExpressionValue(tips2, "tips2");
        fVar.mapSetLoadingProgress(optInt, optInt2, tips1, tips2);
        return argument.ok();
    }

    @LuaEvent("L2N_ShowClearResourceBtn")
    public final String handleShowClearResourceBtn(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleShowClearResourceBtn, argument: argument" + argument);
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanShowClearResourceBtnEvent(new JSONObject(argument.getF440574c()).optInt(f333821e)));
        return argument.ok();
    }

    @LuaEvent("L2N_MapSwitchToFloatingWindow")
    public final String handleSwitchFloatWindow(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanSmallHomeLuaPlugin", 1, "handleSwitchFloatWindow, argument: argument" + argument);
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt(f333821e);
        String optString = jSONObject.optString(f333822f);
        String j3 = ZPlanUEActivityHelper.INSTANCE.a().j();
        JSONObject d16 = d(this, true, null, 2, null);
        d16.put(f333823h, j3);
        argument.callback(d16.toString());
        e(optInt, optString, j3, 0, 3);
        rk3.b.f431651a.e(optInt, optString, 3);
        return argument.ok();
    }

    static /* synthetic */ JSONObject d(ZPlanSmallHomeLuaPlugin zPlanSmallHomeLuaPlugin, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        return zPlanSmallHomeLuaPlugin.c(z16, str);
    }

    static /* synthetic */ void f(ZPlanSmallHomeLuaPlugin zPlanSmallHomeLuaPlugin, int i3, String str, String str2, int i16, int i17, int i18, Object obj) {
        if ((i18 & 16) != 0) {
            i17 = -1;
        }
        zPlanSmallHomeLuaPlugin.e(i3, str, str2, i16, i17);
    }
}
