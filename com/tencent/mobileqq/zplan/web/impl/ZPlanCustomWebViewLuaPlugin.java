package com.tencent.mobileqq.zplan.web.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.BaseApplication;
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
import mqq.app.Foreground;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/ZPlanCustomWebViewLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleOpenWebView", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanCustomWebViewLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanCustomWebViewLuaPlugin> f336053e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/ZPlanCustomWebViewLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zplan/web/impl/ZPlanCustomWebViewLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/web/impl/ZPlanCustomWebViewLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.web.impl.ZPlanCustomWebViewLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanCustomWebViewLuaPlugin a() {
            return (ZPlanCustomWebViewLuaPlugin) ZPlanCustomWebViewLuaPlugin.f336053e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanCustomWebViewLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanCustomWebViewLuaPlugin>() { // from class: com.tencent.mobileqq.zplan.web.impl.ZPlanCustomWebViewLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanCustomWebViewLuaPlugin invoke() {
                return new ZPlanCustomWebViewLuaPlugin();
            }
        });
        f336053e = lazy;
    }

    @LuaEvent("L2N_OpenWebView")
    public final String handleOpenWebView(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanCustomWebViewLuaPlugin", 1, "ZPlanCustomWebViewLuaPlugin :: L2N_OpenWebView == " + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("url");
        if (optString == null) {
            return argument.fail();
        }
        String optString2 = jSONObject.optString("webViewId", "");
        Context context = Foreground.getTopActivity();
        if (context == null) {
            context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
        }
        Bundle bundle = new Bundle();
        bundle.putString("webViewId", optString2);
        bundle.putString("url", optString);
        ((cl3.b) vb3.a.f441346a.a(cl3.b.class)).C0(context, optString, bundle);
        return argument.ok();
    }
}
