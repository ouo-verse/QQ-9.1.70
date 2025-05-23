package com.tencent.mobileqq.zootopia.lua;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOpenIdLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "reAuthorization", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaOpenIdLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZootopiaOpenIdLuaPlugin> f328440e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOpenIdLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOpenIdLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaOpenIdLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaOpenIdLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaOpenIdLuaPlugin a() {
            return (ZootopiaOpenIdLuaPlugin) ZootopiaOpenIdLuaPlugin.f328440e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaOpenIdLuaPlugin$b", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.ipc.ab {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
            QLog.i("ZootopiaOpenIdLuaPlugin", 1, "onReAuthorization");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
        }
    }

    static {
        Lazy<ZootopiaOpenIdLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaOpenIdLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaOpenIdLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaOpenIdLuaPlugin invoke() {
                return new ZootopiaOpenIdLuaPlugin();
            }
        });
        f328440e = lazy;
    }

    @LuaEvent("L2N_Reauthorization")
    public final String reAuthorization(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaOpenIdLuaPlugin", 2, "receive, reAuthorization");
        ((com.tencent.mobileqq.zootopia.ipc.ac) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.ac.class)).reAuthorization(new b());
        return argument.ok();
    }
}
