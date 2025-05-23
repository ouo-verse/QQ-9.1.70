package com.tencent.mobileqq.zootopia.ue;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ipc.y;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZPlanLua2H5Plugin;", "Lcom/tencent/mobileqq/z1/lua/b;", "", "", "g", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "", "sendFashionDesignerEvent", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanLua2H5Plugin extends com.tencent.mobileqq.z1.lua.b<Object> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<ZPlanLua2H5Plugin> f329336f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZPlanLua2H5Plugin$a;", "", "Lcom/tencent/mobileqq/zootopia/ue/ZPlanLua2H5Plugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/ue/ZPlanLua2H5Plugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ue.ZPlanLua2H5Plugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanLua2H5Plugin a() {
            return (ZPlanLua2H5Plugin) ZPlanLua2H5Plugin.f329336f.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/ue/ZPlanLua2H5Plugin$b", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ZPlanEngineStatusUpdateListener {
        b() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            QLog.i("ZPlanLua2H5Plugin", 1, "engineInitFinish success:" + success);
            if (success) {
                ar.f328509a.b(ZPlanLua2H5Plugin.INSTANCE.a());
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    static {
        Lazy<ZPlanLua2H5Plugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanLua2H5Plugin>() { // from class: com.tencent.mobileqq.zootopia.ue.ZPlanLua2H5Plugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanLua2H5Plugin invoke() {
                return new ZPlanLua2H5Plugin(null);
            }
        });
        f329336f = lazy;
    }

    public /* synthetic */ ZPlanLua2H5Plugin(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZPlanLua2H5Plugin this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    private final void g() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).registerZPlanEngineStatusUpdateListener(new b());
    }

    @LuaEvent("L2N_FashionDesignerEvent")
    public final String sendFashionDesignerEvent(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.i("ZPlanLua2H5Plugin", 1, "sendFashionDesignerEvent :: params == " + arg.getF440574c());
        String f440573b = arg.getF440573b();
        if (f440573b == null || f440573b.length() == 0) {
            QLog.e("ZPlanLua2H5Plugin", 1, "sendFashionDesignerShippingResult :: eventName is empty");
            return arg.fail();
        }
        ((y) k74.i.INSTANCE.a(y.class)).sendLuaEventToH5(arg.getF440573b(), arg.getF440574c(), null);
        return arg.ok();
    }

    ZPlanLua2H5Plugin() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ue.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanLua2H5Plugin.e(ZPlanLua2H5Plugin.this);
            }
        });
    }
}
