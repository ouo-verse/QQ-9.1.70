package com.tencent.mobileqq.zootopia.lua;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/PortalTabBarLuaPlugin;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lcom/tencent/mobileqq/zootopia/lua/k;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleShowBottomButtons", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PortalTabBarLuaPlugin extends com.tencent.mobileqq.z1.lua.b<k> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<PortalTabBarLuaPlugin> f328377f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/PortalTabBarLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/PortalTabBarLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/PortalTabBarLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.PortalTabBarLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PortalTabBarLuaPlugin a() {
            return (PortalTabBarLuaPlugin) PortalTabBarLuaPlugin.f328377f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<PortalTabBarLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PortalTabBarLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.PortalTabBarLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PortalTabBarLuaPlugin invoke() {
                return new PortalTabBarLuaPlugin();
            }
        });
        f328377f = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PortalTabBarLuaPlugin this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.a().iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(z16);
        }
    }

    @LuaEvent("L2N_ShowBottomButtons")
    public final String handleShowBottomButtons(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (QLog.isColorLevel()) {
            QLog.i("PortalLuaPlugin", 2, "handleShowBottomButtons, params:" + argument.getF440574c());
        }
        final boolean optBoolean = new JSONObject(argument.getF440574c()).optBoolean("Show");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.j
            @Override // java.lang.Runnable
            public final void run() {
                PortalTabBarLuaPlugin.f(PortalTabBarLuaPlugin.this, optBoolean);
            }
        });
        return argument.ok();
    }
}
