package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOidbPushPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "buf", "", QQBrowserActivity.KEY_MSG_TYPE, "", "f", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "exitToRootPage", "i", "d", "Ljava/lang/String;", "EVENT_RECEIVE_OIDB_PUSH", "Lcom/tencent/mobileqq/zplan/push/i;", "e", "Lcom/tencent/mobileqq/zplan/push/i;", "zplanKickOutOIDBPushObserver", "zplanRedDotOIDBPushObserver", tl.h.F, "EVENT_NET_STATUS_CHANGE", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "netEventHandler", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaOidbPushPlugin extends LuaBasePlugin {
    private static final Lazy<ZootopiaOidbPushPlugin> C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String EVENT_RECEIVE_OIDB_PUSH = "N2L_DidReceiveOidbPush";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.push.i zplanKickOutOIDBPushObserver = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.push.i zplanRedDotOIDBPushObserver = new c();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String EVENT_NET_STATUS_CHANGE = "N2L_NetworkReachabilityChanged";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final INetEventHandler netEventHandler = new INetEventHandler() { // from class: com.tencent.mobileqq.zootopia.lua.as
        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public final void onNetChangeEvent(boolean z16) {
            ZootopiaOidbPushPlugin.g(ZootopiaOidbPushPlugin.this, z16);
        }
    };

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOidbPushPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOidbPushPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOidbPushPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "POLLING_DELAY", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaOidbPushPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaOidbPushPlugin a() {
            return (ZootopiaOidbPushPlugin) ZootopiaOidbPushPlugin.C.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaOidbPushPlugin$b", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.zplan.push.i {
        b() {
            super(338);
        }

        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            ZootopiaOidbPushPlugin.this.f(buf, "0x152");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaOidbPushPlugin$c", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.zplan.push.i {
        c() {
            super(337);
        }

        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            try {
                if (mv4.e.c(buf).f417675a == 6) {
                    ZootopiaOidbPushPlugin.this.f(buf, "0x151");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    static {
        Lazy<ZootopiaOidbPushPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaOidbPushPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaOidbPushPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaOidbPushPlugin invoke() {
                INetEventHandler iNetEventHandler;
                ZootopiaOidbPushPlugin zootopiaOidbPushPlugin = new ZootopiaOidbPushPlugin();
                zootopiaOidbPushPlugin.i();
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                iNetEventHandler = zootopiaOidbPushPlugin.netEventHandler;
                AppNetConnInfo.registerNetChangeReceiver(mobileQQ, iNetEventHandler);
                return zootopiaOidbPushPlugin;
            }
        });
        C = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(byte[] buf, String msgType) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", Base64.encodeToString(buf, 2));
        jSONObject.put("dataLength", buf.length);
        jSONObject.put("isActive", BaseGesturePWDUtil.isAppOnForeground(BaseApplication.context) ? 1 : 0);
        jSONObject.put("subMsgType", msgType);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        QLog.i("ZootopiaOidbPushPlugin", 1, "--onReceivePush " + jSONObject2);
        a.C10063a.b(ZPlanLuaBridge.INSTANCE, this.EVENT_RECEIVE_OIDB_PUSH, jSONObject2, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final ZootopiaOidbPushPlugin this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.at
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaOidbPushPlugin.h(ZootopiaOidbPushPlugin.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZootopiaOidbPushPlugin this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int min = Math.min(2, NetworkUtil.getNetWorkType());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("networkStatus", min);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        QLog.i("ZootopiaOidbPushPlugin", 1, "--onNetChangeEvent isNetEffective:" + jSONObject2);
        a.C10063a.b(ZPlanLuaBridge.INSTANCE, this$0.EVENT_NET_STATUS_CHANGE, jSONObject2, null, 4, null);
    }

    @LuaEvent("L2N_ExitToRootPage")
    public final String exitToRootPage(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaOidbPushPlugin", 1, "event: " + argument.getF440573b() + " ,params:" + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        if (jSONObject.has("tipStr") && !TextUtils.isEmpty(jSONObject.getString("tipStr"))) {
            String string = jSONObject.getString("tipStr");
            com.tencent.mobileqq.zplan.push.g gVar = com.tencent.mobileqq.zplan.push.g.f335038a;
            Activity e16 = gVar.e();
            if (e16 != null && !e16.isFinishing() && !e16.isDestroyed()) {
                gVar.f(e16, string);
            } else {
                ((com.tencent.mobileqq.zplan.push.d) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.push.d.class)).dialogAndKickOff(string);
            }
        } else {
            com.tencent.mobileqq.zplan.push.g.f335038a.c();
        }
        return argument.ok();
    }

    public final void i() {
        ZPlanOIDBPushHandler.Companion companion = ZPlanOIDBPushHandler.INSTANCE;
        ZPlanOIDBPushHandler a16 = companion.a();
        if (a16 != null) {
            a16.F2(this.zplanKickOutOIDBPushObserver);
        }
        ZPlanOIDBPushHandler a17 = companion.a();
        if (a17 != null) {
            a17.F2(this.zplanRedDotOIDBPushObserver);
        }
    }
}
