package com.tencent.mobileqq.zootopia.lua;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanPauseDownloadLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "pauseDownload", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanPauseDownloadLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanPauseDownloadLuaPlugin> f328400e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanPauseDownloadLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanPauseDownloadLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanPauseDownloadLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZPlanPauseDownloadLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanPauseDownloadLuaPlugin a() {
            return (ZPlanPauseDownloadLuaPlugin) ZPlanPauseDownloadLuaPlugin.f328400e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZPlanPauseDownloadLuaPlugin$b", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "", "response", "", "onSuccess", "", "errorCode", "errorMessage", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.ipc.ah {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328401a;

        b(LuaArgument luaArgument) {
            this.f328401a = luaArgument;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            LuaArgument luaArgument = this.f328401a;
            luaArgument.callback(luaArgument.fail(errorMessage));
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onSuccess(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            LuaArgument luaArgument = this.f328401a;
            luaArgument.callback(luaArgument.ok());
        }
    }

    static {
        Lazy<ZPlanPauseDownloadLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanPauseDownloadLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanPauseDownloadLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanPauseDownloadLuaPlugin invoke() {
                return new ZPlanPauseDownloadLuaPlugin();
            }
        });
        f328400e = lazy;
    }

    @LuaEvent("L2N_PauseDownload")
    public final String pauseDownload(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanPauseDownloadLuaPlugin", 1, "pauseDownload, " + argument);
        String optString = new JSONObject(argument.getF440574c()).optString("downloadUrl");
        if (TextUtils.isEmpty(optString)) {
            argument.callback(argument.fail());
            return "";
        }
        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).pauseFileDownload(ZPlanFileCategory.LuaDownload.getValue(), optString, new b(argument));
        return "";
    }
}
