package com.tencent.mobileqq.zootopia.lua;

import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
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

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZplanPreLoadPeakProcessLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handlePreloadPeakProcess", "", "b", "", "d", "Z", "isFeedsLoaded", "()Z", "setFeedsLoaded", "(Z)V", "e", "shouldTriggerPeak", "<init>", "()V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanPreLoadPeakProcessLuaPlugin extends LuaBasePlugin {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy<ZplanPreLoadPeakProcessLuaPlugin> f328462h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isFeedsLoaded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean shouldTriggerPeak;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZplanPreLoadPeakProcessLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZplanPreLoadPeakProcessLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZplanPreLoadPeakProcessLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZplanPreLoadPeakProcessLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZplanPreLoadPeakProcessLuaPlugin a() {
            return (ZplanPreLoadPeakProcessLuaPlugin) ZplanPreLoadPeakProcessLuaPlugin.f328462h.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZplanPreLoadPeakProcessLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZplanPreLoadPeakProcessLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZplanPreLoadPeakProcessLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPreLoadPeakProcessLuaPlugin invoke() {
                return new ZplanPreLoadPeakProcessLuaPlugin(null);
            }
        });
        f328462h = lazy;
    }

    public /* synthetic */ ZplanPreLoadPeakProcessLuaPlugin(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void b() {
        if (!this.isFeedsLoaded) {
            QLog.d("ZplanPreLoadPeakProcess", 1, "waiting for feeds loaded");
            return;
        }
        if (!this.shouldTriggerPeak) {
            QLog.d("ZplanPreLoadPeakProcess", 1, "skip trigger peak as triggered");
            return;
        }
        this.shouldTriggerPeak = false;
        if (((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(BaseApplication.getContext())) {
            QLog.d("ZplanPreLoadPeakProcess", 1, "skip preload peak process as peak is alive");
        } else {
            ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplication.getContext());
            QLog.d("ZplanPreLoadPeakProcess", 1, "preloadPeakProcess");
        }
    }

    @LuaEvent("L2N_PreloadPeakProcess")
    public final String handlePreloadPeakProcess(LuaArgument argument) {
        QLog.i("ZplanPreLoadPeakProcess", 1, "trigger preload peak process");
        this.shouldTriggerPeak = true;
        b();
        return null;
    }

    ZplanPreLoadPeakProcessLuaPlugin() {
        this.isFeedsLoaded = true;
    }
}
