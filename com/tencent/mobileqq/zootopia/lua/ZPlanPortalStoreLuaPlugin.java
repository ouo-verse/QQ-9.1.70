package com.tencent.mobileqq.zootopia.lua;

import android.net.Uri;
import android.os.Handler;
import androidx.lifecycle.Observer;
import b94.e;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreControllerView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/sqshow/zootopia/data/f;", "data", "", DomainData.DOMAIN_NAME, "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "startTime", "t", "u", "", "handleBackPressedInNativeAvatarStore", "handleCreateNativeAvatarStore", "handleOpenNativeAvatarStore", "handleDressPrevAvatarCharacter", "handleDressNextAvatarCharacter", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "d", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView;", "e", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView;", "currentPortalStoreControllerView", "Landroidx/lifecycle/Observer;", "f", "Landroidx/lifecycle/Observer;", "coinUpdateObserver", "<init>", "(Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", tl.h.F, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanPortalStoreLuaPlugin extends LuaBasePlugin {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static boolean f328403i;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f328404m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PortalStoreControllerView currentPortalStoreControllerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.data.f> coinUpdateObserver;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin$a;", "", "", "url", "c", "", "d", "", "isSaveDressChanged", "Z", "b", "()Z", "f", "(Z)V", "isPayPanelShowing", "a", "e", "N2L_ON_COIN_ASSET_CHANGED", "Ljava/lang/String;", "N2L_ON_NATIVE_STORE_DESTROY", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ZPlanPortalStoreLuaPlugin.f328404m;
        }

        public final boolean b() {
            return ZPlanPortalStoreLuaPlugin.f328403i;
        }

        public final String c(String url) {
            SceneInfo b16;
            String f16;
            Intrinsics.checkNotNullParameter(url, "url");
            String queryParameter = Uri.parse(url).getQueryParameter(ISchemeApi.KEY_SCENE_DATA);
            return (queryParameter == null || (b16 = SceneInfo.INSTANCE.b(queryParameter)) == null || (f16 = b16.f()) == null) ? "" : f16;
        }

        public final void d() {
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnNativeStoreDestroy", new JSONObject(), null, false, 12, null);
            QLog.i("ZPlanPortalStoreLuaPlugin", 1, "portalStoreDestory");
        }

        public final void e(boolean z16) {
            ZPlanPortalStoreLuaPlugin.f328404m = z16;
        }

        public final void f(boolean z16) {
            ZPlanPortalStoreLuaPlugin.f328403i = z16;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin$b", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "Luv4/w;", "rsp", "", "hasCacheData", "", "B", "", "errorCode", "", "errorMsg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.sqshow.zootopia.nativeui.data.o {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328409e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f328410f;

        b(LuaArgument luaArgument, long j3) {
            this.f328409e = luaArgument;
            this.f328410f = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ZPlanPortalStoreLuaPlugin this$0, b this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            try {
                PortalStoreControllerView portalStoreControllerView = this$0.currentPortalStoreControllerView;
                if (portalStoreControllerView != null) {
                    portalStoreControllerView.s2(this$1);
                }
            } catch (Throwable th5) {
                QLog.e("ZPlanPortalStoreLuaPlugin", 1, "removeNativeUIDataListener error", th5);
            }
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.data.o
        public void B(uv4.w rsp, boolean hasCacheData) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZPlanPortalStoreLuaPlugin zPlanPortalStoreLuaPlugin = ZPlanPortalStoreLuaPlugin.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.w
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPortalStoreLuaPlugin.b.b(ZPlanPortalStoreLuaPlugin.this, this);
                }
            });
            ZPlanPortalStoreLuaPlugin.this.t(this.f328409e, this.f328410f);
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.data.o
        public void onFailed(int errorCode, String errorMsg) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", false);
            jSONObject.put("code", errorCode);
            jSONObject.put("msg", errorMsg);
            this.f328409e.callback(jSONObject.toString());
        }
    }

    public ZPlanPortalStoreLuaPlugin(UEActivityViewManager viewManager) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.viewManager = viewManager;
        this.coinUpdateObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.lua.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanPortalStoreLuaPlugin.o(ZPlanPortalStoreLuaPlugin.this, (com.tencent.sqshow.zootopia.data.f) obj);
            }
        };
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.t
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPortalStoreLuaPlugin.g(ZPlanPortalStoreLuaPlugin.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZPlanPortalStoreLuaPlugin this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gb4.a aVar = gb4.a.f401894a;
        aVar.b().observe(this$0.viewManager.getActivity(), this$0.coinUpdateObserver);
        aVar.e().postValue(aVar.f());
    }

    private final void n(com.tencent.sqshow.zootopia.data.f data) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gold", data.getGoldCoin());
        jSONObject.put("silver", data.getSilverCoin());
        a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnCoinAssetChanged", jSONObject, null, false, 12, null);
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "icon update param=" + jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final ZPlanPortalStoreLuaPlugin this$0, final com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.n(data);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.u
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPortalStoreLuaPlugin.p(ZPlanPortalStoreLuaPlugin.this, data);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZPlanPortalStoreLuaPlugin this$0, com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.n(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ZPlanPortalStoreLuaPlugin this$0, LuaArgument argument) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        JSONObject jSONObject = new JSONObject();
        PortalStoreControllerView portalStoreControllerView = this$0.currentPortalStoreControllerView;
        if (!(portalStoreControllerView != null ? portalStoreControllerView.l7(false, new ZPlanPortalStoreLuaPlugin$handleBackPressedInNativeAvatarStore$1$handleBackEvent$1(jSONObject, argument)) : false)) {
            jSONObject.put("shouldExit", true);
            argument.callback(jSONObject.toString());
        }
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleBackPressedInNativeAvatarStore end, callback=" + jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ZPlanPortalStoreLuaPlugin this$0, String sceneParams, String openSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sceneParams, "$sceneParams");
        UEActivityViewManager uEActivityViewManager = this$0.viewManager;
        Intrinsics.checkNotNullExpressionValue(openSource, "openSource");
        this$0.currentPortalStoreControllerView = uEActivityViewManager.h(sceneParams, openSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZPlanPortalStoreLuaPlugin this$0, LuaArgument argument, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        PortalStoreControllerView portalStoreControllerView = this$0.currentPortalStoreControllerView;
        if (Intrinsics.areEqual(portalStoreControllerView != null ? Boolean.valueOf(portalStoreControllerView.getMInitDataReady()) : null, Boolean.TRUE)) {
            QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleOpenNativeAvatarStore isReady");
            this$0.t(argument, j3);
            return;
        }
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleOpenNativeAvatarStore not ready, wait");
        b bVar = new b(argument, j3);
        PortalStoreControllerView portalStoreControllerView2 = this$0.currentPortalStoreControllerView;
        if (portalStoreControllerView2 != null) {
            portalStoreControllerView2.qg(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(LuaArgument argument, long startTime) {
        PortalStoreControllerView portalStoreControllerView;
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "realOpenPortalStore");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", true);
        argument.callback(jSONObject.toString());
        JSONObject jSONObject2 = new JSONObject(argument.getParams());
        String url = jSONObject2.optString("url");
        jSONObject2.optString("openSource");
        PortalStoreControllerView portalStoreControllerView2 = this.currentPortalStoreControllerView;
        if (portalStoreControllerView2 != null) {
            e.a.a(portalStoreControllerView2, true, null, null, 6, null);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if ((url.length() > 0) && (portalStoreControllerView = this.currentPortalStoreControllerView) != null) {
            portalStoreControllerView.I1();
        }
        yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
        u(startTime);
    }

    private final void u(long startTime) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_xiaowo");
        hashMap.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        hashMap.put("zplan_use_times", Long.valueOf(System.currentTimeMillis() - startTime));
        VideoReport.reportEvent("ev_zplan_open_exposure_times", null, hashMap);
    }

    @LuaEvent("L2N_BackPressedInNativeAvatarStore")
    public final String handleBackPressedInNativeAvatarStore(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleBackPressedInNativeAvatarStore param=" + argument.getParams());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.q
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPortalStoreLuaPlugin.q(ZPlanPortalStoreLuaPlugin.this, argument);
            }
        });
        return "";
    }

    @LuaEvent("L2N_CreateNativeAvatarStore")
    public final String handleCreateNativeAvatarStore(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleCreateNativeAvatarStore param=" + argument.getParams());
        try {
            JSONObject jSONObject = new JSONObject(argument.getParams());
            String url = jSONObject.optString("url");
            final String optString = jSONObject.optString("openSource");
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            final String c16 = companion.c(url);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.p
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPortalStoreLuaPlugin.r(ZPlanPortalStoreLuaPlugin.this, c16, optString);
                }
            });
            return argument.ok();
        } catch (Exception e16) {
            QLog.e("ZPlanPortalStoreLuaPlugin", 1, "parse json error " + e16);
            return argument.fail();
        }
    }

    @LuaEvent("L2N_DressNextAvatarCharacter")
    public final String handleDressNextAvatarCharacter(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressNextAvatarCharacter param=" + argument.getParams());
        final PortalStoreControllerView portalStoreControllerView = this.currentPortalStoreControllerView;
        m94.g R0 = portalStoreControllerView != null ? portalStoreControllerView.R0() : null;
        boolean z16 = false;
        if (R0 != null && R0.a()) {
            z16 = true;
        }
        if (!z16) {
            QLog.w("ZPlanPortalStoreLuaPlugin", 1, "no next history dress");
            argument.callback(argument.fail("no next history dress"));
            return "";
        }
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin$handleDressNextAvatarCharacter$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin$handleDressNextAvatarCharacter$1$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements m94.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ LuaArgument f328411a;

                a(LuaArgument luaArgument) {
                    this.f328411a = luaArgument;
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressNextAvatarCharacter fail, errorMsg=" + errorMsg);
                    LuaArgument luaArgument = this.f328411a;
                    luaArgument.callback(luaArgument.fail(errorMsg.getErrorMsg()));
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressNextAvatarCharacter success");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PortalStoreControllerView.this.E9(new a(argument));
                m94.g R02 = PortalStoreControllerView.this.R0();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("canPrev", R02 != null ? Boolean.valueOf(R02.b()) : null);
                jSONObject.put("canNext", R02 != null ? Boolean.valueOf(R02.a()) : null);
                argument.callback(jSONObject.toString());
                QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressNextAvatarCharacter end, callback=" + jSONObject);
            }
        });
        return "";
    }

    @LuaEvent("L2N_DressPrevAvatarCharacter")
    public final String handleDressPrevAvatarCharacter(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressPrevAvatarCharacter param=" + argument.getParams());
        final PortalStoreControllerView portalStoreControllerView = this.currentPortalStoreControllerView;
        m94.g R0 = portalStoreControllerView != null ? portalStoreControllerView.R0() : null;
        boolean z16 = false;
        if (R0 != null && R0.b()) {
            z16 = true;
        }
        if (!z16) {
            QLog.w("ZPlanPortalStoreLuaPlugin", 1, "no prev history dress");
            argument.callback(argument.fail("no prev history dress"));
            return "";
        }
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin$handleDressPrevAvatarCharacter$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin$handleDressPrevAvatarCharacter$1$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements m94.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ LuaArgument f328412a;

                a(LuaArgument luaArgument) {
                    this.f328412a = luaArgument;
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressPrevAvatarCharacter fail, errorMsg=" + errorMsg);
                    LuaArgument luaArgument = this.f328412a;
                    luaArgument.callback(luaArgument.fail(errorMsg.getErrorMsg()));
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressPrevAvatarCharacter success");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PortalStoreControllerView.this.Y6(new a(argument));
                m94.g R02 = PortalStoreControllerView.this.R0();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("canPrev", R02 != null ? Boolean.valueOf(R02.b()) : null);
                jSONObject.put("canNext", R02 != null ? Boolean.valueOf(R02.a()) : null);
                argument.callback(jSONObject.toString());
                QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleDressPrevAvatarCharacter end, callback=" + jSONObject);
            }
        });
        return "";
    }

    @LuaEvent("L2N_OpenNativeAvatarStore")
    public final String handleOpenNativeAvatarStore(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleOpenNativeAvatarStore param=" + argument.getParams());
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.r
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPortalStoreLuaPlugin.s(ZPlanPortalStoreLuaPlugin.this, argument, currentTimeMillis);
                }
            });
            return argument.ok();
        } catch (Exception e16) {
            QLog.e("ZPlanPortalStoreLuaPlugin", 1, "parse json error " + e16);
            return argument.fail();
        }
    }
}
