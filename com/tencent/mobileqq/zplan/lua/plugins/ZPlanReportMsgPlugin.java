package com.tencent.mobileqq.zplan.lua.plugins;

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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanReportMsgPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleReportMsg", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanReportMsgPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanReportMsgPlugin> f333818e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanReportMsgPlugin$a;", "", "Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanReportMsgPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanReportMsgPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "PARAM_MSG_BODY", "Ljava/lang/String;", "PARAM_MSG_ID", "PARAM_MSG_TYPE", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.lua.plugins.ZPlanReportMsgPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanReportMsgPlugin a() {
            return (ZPlanReportMsgPlugin) ZPlanReportMsgPlugin.f333818e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/lua/plugins/ZPlanReportMsgPlugin$b", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements rh3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f333819a;

        b(LuaArgument luaArgument) {
            this.f333819a = luaArgument;
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            LuaArgument luaArgument = this.f333819a;
            luaArgument.callback(luaArgument.fail());
        }

        @Override // rh3.b
        public void onSuccess() {
            LuaArgument luaArgument = this.f333819a;
            luaArgument.callback(luaArgument.ok());
        }
    }

    static {
        Lazy<ZPlanReportMsgPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanReportMsgPlugin>() { // from class: com.tencent.mobileqq.zplan.lua.plugins.ZPlanReportMsgPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanReportMsgPlugin invoke() {
                return new ZPlanReportMsgPlugin();
            }
        });
        f333818e = lazy;
    }

    public ZPlanReportMsgPlugin() {
        QLog.w("ZPlanReportMsgPlugin", 1, "ZPlanReportMsgPlugin init.");
    }

    @LuaEvent("L2N_ReportMsg")
    public final String handleReportMsg(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.d("ZPlanReportMsgPlugin", 1, "handleReportMsg, argument: argument" + argument);
        ((rh3.a) k74.i.INSTANCE.a(rh3.a.class)).reportMsg(argument.getF440574c(), new b(argument));
        QLog.d("ZPlanReportMsgPlugin", 1, "end");
        return null;
    }
}
