package com.tencent.qmethod.monitor;

import android.app.Application;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import com.tencent.qmethod.monitor.base.defaultImpl.d;
import com.tencent.qmethod.monitor.base.exception.InitFailException;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.c;
import com.tencent.qmethod.monitor.ext.auto.JumpInterrupt;
import com.tencent.qmethod.monitor.ext.overcall.OverCallMonitor;
import com.tencent.qmethod.monitor.ext.remote.Report;
import com.tencent.qmethod.monitor.network.NetworkWatcher;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.monitor.report.api.ApiInvokeAnalyse;
import com.tencent.qmethod.pandoraex.api.f;
import com.tencent.qmethod.pandoraex.api.m;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.api.v;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.s;
import com.tencent.qmethod.pandoraex.core.x;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yr3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bE\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0007J\u000f\u0010\u001e\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0000\u00a2\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0000\u00a2\u0006\u0004\b$\u0010%J\u001e\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\b2\u0006\u0010)\u001a\u00020(R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\"\u00102\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010+\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00103R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\"05j\b\u0012\u0004\u0012\u00020\"`68\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010:R\u001a\u0010?\u001a\u00020\u00108\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b7\u0010>R$\u0010D\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00028@@BX\u0080\u000e\u00a2\u0006\f\u001a\u0004\b<\u0010A\"\u0004\bB\u0010C\u00a8\u0006F"}, d2 = {"Lcom/tencent/qmethod/monitor/a;", "", "Lcom/tencent/qmethod/monitor/base/PMonitorInitParam;", "monitorConfig", "", "i", "Lcom/tencent/qmethod/pandoraex/api/f;", "stateManager", "", "isDelay", "j", "Lcom/tencent/qmethod/pandoraex/api/q$a;", "c", "l", "isAllow", "p", "Lcom/tencent/qmethod/monitor/config/c;", "f", "Lcom/tencent/qmethod/monitor/base/PMonitorInitParam$Property;", "property", "", "value", "r", "Landroid/app/Application;", "app", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lyr3/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "()V", "d", "(Lcom/tencent/qmethod/monitor/base/PMonitorInitParam$Property;)Ljava/lang/String;", "Lcom/tencent/qmethod/monitor/base/a;", "listener", "o", "(Lcom/tencent/qmethod/monitor/base/a;)V", "tag", "fullSample", "", "ts", "a", "Z", "hadInit", "isInitNetWork", h.F, "()Z", "setHasAgreeUserPolicy$qmethod_privacy_monitor_tencentBuglyRelease", "(Z)V", "hasAgreeUserPolicy", "Lcom/tencent/qmethod/monitor/base/PMonitorInitParam;", "innerConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "pMonitorConfigChangeListeners", "Ljava/lang/Object;", "CONFIG_LIST_LOCK", "g", "Lcom/tencent/qmethod/monitor/config/c;", "()Lcom/tencent/qmethod/monitor/config/c;", "appRuleConfig", "<anonymous parameter 0>", "()Lcom/tencent/qmethod/monitor/base/PMonitorInitParam;", "setConfig", "(Lcom/tencent/qmethod/monitor/base/PMonitorInitParam;)V", DownloadInfo.spKey_Config, "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean hadInit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInitNetWork;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean hasAgreeUserPolicy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static PMonitorInitParam innerConfig;

    /* renamed from: h, reason: collision with root package name */
    public static final a f343451h = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<com.tencent.qmethod.monitor.base.a> pMonitorConfigChangeListeners = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Object CONFIG_LIST_LOCK = new Object();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final c appRuleConfig = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qmethod/monitor/a$a", "Lcom/tencent/qmethod/pandoraex/api/m;", "", "module", "apiName", "Lcom/tencent/qmethod/pandoraex/api/v;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "b", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9328a implements m {
        C9328a() {
        }

        @Override // com.tencent.qmethod.pandoraex.api.m
        public boolean a() {
            return false;
        }

        @Override // com.tencent.qmethod.pandoraex.api.m
        public boolean b(@Nullable String module, @Nullable String apiName, @Nullable v rule) {
            return false;
        }
    }

    a() {
    }

    @JvmStatic
    public static final void b(@NotNull Application app) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        boolean b16 = s.b();
        r.a(app);
        r.b();
        if (b16) {
            s.c(true);
        }
    }

    private final q.a c(PMonitorInitParam monitorConfig) {
        q.r(monitorConfig.getDebug());
        q.a u16 = new q.a(monitorConfig.getContext()).x(monitorConfig.getLogger()).E(monitorConfig.getThreadExecutor()).s(monitorConfig.getAppStateManager()).t(monitorConfig.getUvReportSamplingRate()).v(true).w(true).u(true);
        monitorConfig.j();
        q.a B = u16.B(null);
        if (!monitorConfig.getIsDelay()) {
            com.tencent.qmethod.monitor.base.util.h hVar = com.tencent.qmethod.monitor.base.util.h.f343541c;
            hVar.e("PMonitor#ReportInit");
            B.z(new PMonitorReporter(monitorConfig.getAppReporter()));
            hVar.b("PMonitor#ReportInit");
            hVar.e("PMonitor#ReportControlinit");
            B.y(com.tencent.qmethod.monitor.report.sample.b.f343868c);
            hVar.b("PMonitor#ReportControlinit");
        } else {
            com.tencent.qmethod.monitor.base.util.h hVar2 = com.tencent.qmethod.monitor.base.util.h.f343541c;
            hVar2.e("PMonitor#ReportControlinit");
            B.y(new C9328a());
            hVar2.b("PMonitor#ReportControlinit");
        }
        com.tencent.qmethod.monitor.base.util.h hVar3 = com.tencent.qmethod.monitor.base.util.h.f343541c;
        hVar3.e("PMonitor#MMVKInit");
        if (monitorConfig.getStorage() != null) {
            B.A(monitorConfig.getStorage());
        } else if (monitorConfig.getUseMMKVStrategy()) {
            B.D(false);
            B.C(monitorConfig.getMmkvRootDir());
        }
        hVar3.b("PMonitor#MMVKInit");
        hVar3.e("PMonitor#AppStateManager");
        if (monitorConfig.getAppStateManager() instanceof com.tencent.qmethod.monitor.base.defaultImpl.c) {
            f appStateManager = monitorConfig.getAppStateManager();
            if (appStateManager != null) {
                ((com.tencent.qmethod.monitor.base.defaultImpl.c) appStateManager).init();
                f appStateManager2 = monitorConfig.getAppStateManager();
                if (appStateManager2 != null) {
                    ((com.tencent.qmethod.monitor.base.defaultImpl.c) appStateManager2).b(new d());
                    com.tencent.qmethod.pandoraex.core.a.f344013c.set(true);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.qmethod.monitor.base.defaultImpl.IAppStateInit");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.qmethod.monitor.base.defaultImpl.IAppStateInit");
            }
        }
        hVar3.b("PMonitor#AppStateManager");
        Intrinsics.checkExpressionValueIsNotNull(B, "PandoraEx.Builder(monito\u2026E_SCENE_AM)\n            }");
        monitorConfig.m();
        B.getClass();
        return B;
    }

    @JvmStatic
    @NotNull
    public static final c f() {
        PMonitorInitParam pMonitorInitParam = innerConfig;
        if (pMonitorInitParam != null && pMonitorInitParam.getDebug()) {
            throw new IllegalStateException("You should call it before SDK init");
        }
        return appRuleConfig;
    }

    @JvmStatic
    public static final void i(@NotNull PMonitorInitParam monitorConfig) throws InitFailException {
        Intrinsics.checkParameterIsNotNull(monitorConfig, "monitorConfig");
        j(monitorConfig, null, false);
    }

    @JvmStatic
    public static final void j(@NotNull PMonitorInitParam monitorConfig, @Nullable f stateManager, boolean isDelay) throws InitFailException {
        Intrinsics.checkParameterIsNotNull(monitorConfig, "monitorConfig");
        synchronized (a.class) {
            if (!hadInit) {
                com.tencent.qmethod.monitor.base.util.h hVar = com.tencent.qmethod.monitor.base.util.h.f343541c;
                hVar.d();
                if (stateManager != null) {
                    monitorConfig.z(stateManager);
                }
                monitorConfig.A(isDelay);
                innerConfig = monitorConfig;
                hVar.e("PMonitor#init");
                qr3.a aVar = qr3.a.f429371j;
                aVar.l("launch_cost");
                hVar.e("PMonitor#PandoraExBuilder");
                q.a c16 = f343451h.c(monitorConfig);
                hVar.a("PMonitor#PandoraExBuilder", "PMonitor#PandoraEx");
                if (q.l(c16)) {
                    if (q().l()) {
                        q().j(monitorConfig.getContext());
                    }
                    q.s(Boolean.valueOf(monitorConfig.getIsOpenCheckPermission()));
                    hVar.a("PMonitor#PandoraEx", "PMonitor#ConfigManager");
                    ConfigManager.f343549h.A();
                    hVar.a("PMonitor#ConfigManager", "PMonitor#AutoCore");
                    com.tencent.qmethod.monitor.ext.auto.a.f343622g.e(monitorConfig.getAutoStartListener());
                    JumpInterrupt.f343605d.e();
                    hVar.a("PMonitor#AutoCore", "PMonitor#APIInvoker");
                    if (monitorConfig.getIsOpenApiInvokeAnalyse()) {
                        ApiInvokeAnalyse.f343783d.b();
                    }
                    hVar.a("PMonitor#APIInvoker", "PMonitor#SILENCE");
                    if (monitorConfig.getIsOpenSilenceHook()) {
                        kr3.d.f412911b.a();
                    }
                    hVar.a("PMonitor#SILENCE", "PMonitor#NETWORK");
                    com.tencent.qmethod.monitor.ext.traffic.a aVar2 = com.tencent.qmethod.monitor.ext.traffic.a.f343721k;
                    aVar2.l();
                    if (monitorConfig.getIsOpenNetworkCapture()) {
                        aVar2.m(true);
                    }
                    hVar.a("PMonitor#NETWORK", "PMonitor#RNIHOOK");
                    monitorConfig.m();
                    hVar.a("PMonitor#RNIHOOK", "PMonitor#DEVICECLONE");
                    if (monitorConfig.getShouldClearCacheOnDeviceClone()) {
                        com.tencent.qmethod.monitor.base.util.b.f343532a.a();
                    }
                    hVar.a("PMonitor#DEVICECLONE", "PMonitor#SSLA");
                    hadInit = true;
                    monitorConfig.getLogger().i("PandoraEx", "Init success! appId=" + monitorConfig.getAppId());
                    aVar.c("launch_cost");
                    aVar.k("launch_succ", true);
                    hVar.b("PMonitor#SSLA");
                    hVar.b("PMonitor#init");
                    return;
                }
                aVar.k("launch_succ", false);
                InitFailException.InitFailType initFailType = InitFailException.InitFailType.PROTECTION;
                aVar.j("launch_error_code", aVar.d(initFailType));
                throw new InitFailException(initFailType);
            }
            monitorConfig.getLogger().e("PandoraEx", "repeat call init@" + new IllegalStateException().getStackTrace());
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final boolean l() {
        return x.w();
    }

    private final synchronized void m() {
        synchronized (CONFIG_LIST_LOCK) {
            Iterator<T> it = pMonitorConfigChangeListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.qmethod.monitor.base.a) it.next()).b();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final synchronized void n() {
        synchronized (CONFIG_LIST_LOCK) {
            Iterator<T> it = pMonitorConfigChangeListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.qmethod.monitor.base.a) it.next()).a(hasAgreeUserPolicy);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final synchronized void p(boolean isAllow) {
        synchronized (a.class) {
            if (hasAgreeUserPolicy == isAllow) {
                o.e("", "setAllowPolicy ignore, value=" + isAllow);
                return;
            }
            hasAgreeUserPolicy = isAllow;
            if (hadInit) {
                q.q(isAllow);
                f343451h.n();
                o.e("", "setAllowPolicy success, value=" + isAllow);
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final e q() {
        e c16 = e.c();
        Intrinsics.checkExpressionValueIsNotNull(c16, "SplitModuleGranter.getInstance()");
        return c16;
    }

    @JvmStatic
    public static final void r(@NotNull PMonitorInitParam.Property property, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(property, "property");
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (hadInit) {
            a aVar = f343451h;
            aVar.g().d().put(property, value);
            aVar.m();
            o.e("", "update App property key=" + property + ", value=" + value);
        }
    }

    public final void a(@NotNull String tag, boolean fullSample, long ts5) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (f343451h.g().getDebug()) {
            o.e("", "appendTag " + tag + ", ts=" + ts5);
        }
        SampleHelper.f343779l.B(fullSample);
        com.tencent.qmethod.pandoraex.core.v.a(tag, Long.valueOf(ts5));
    }

    @NotNull
    public final String d(@NotNull PMonitorInitParam.Property property) {
        String str;
        Intrinsics.checkParameterIsNotNull(property, "property");
        if (innerConfig == null || (str = g().d().get(property)) == null) {
            return "unknown";
        }
        return str;
    }

    @NotNull
    public final c e() {
        return appRuleConfig;
    }

    @NotNull
    public final PMonitorInitParam g() {
        PMonitorInitParam pMonitorInitParam = innerConfig;
        if (pMonitorInitParam != null) {
            return pMonitorInitParam;
        }
        throw new IllegalStateException("\u521d\u59cb\u5316\u540e\u624d\u80fd\u83b7\u53d6\u914d\u7f6e");
    }

    public final boolean h() {
        return hasAgreeUserPolicy;
    }

    public final void k() {
        synchronized (a.class) {
            if (!isInitNetWork) {
                com.tencent.qmethod.monitor.base.util.h hVar = com.tencent.qmethod.monitor.base.util.h.f343541c;
                hVar.e("PMonitor#NetworkWatcher");
                NetworkWatcher.f343743h.j();
                hVar.a("PMonitor#NetworkWatcher", "PMonitor#ReportBaseInfo");
                nr3.a.INSTANCE.c();
                hVar.a("PMonitor#ReportBaseInfo", "PMonitor#ReporterMachine");
                or3.d.f423470e.e();
                hVar.a("PMonitor#ReporterMachine", "PMonitor#ReporterSLA");
                qr3.a.f429371j.f();
                hVar.a("PMonitor#ReporterSLA", "PMonitor#ReporterOVC");
                OverCallMonitor.f343654b.e();
                hVar.a("PMonitor#ReporterOVC", "PMonitor#APIInvokerLater");
                ApiInvokeAnalyse.f343783d.f();
                hVar.a("PMonitor#APIInvokerLater", "PMonitor#DynamicReport");
                Report.f343665c.f();
                hVar.a("PMonitor#DynamicReport", "PMonitor#ReceiverMonitor");
                jr3.a.f410877b.c();
                hVar.a("PMonitor#ReceiverMonitor", "PMonitor#ScreenMonitor");
                ir3.a.f408442b.c();
                hVar.b("PMonitor#ScreenMonitor");
                isInitNetWork = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void o(@NotNull com.tencent.qmethod.monitor.base.a listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (CONFIG_LIST_LOCK) {
            pMonitorConfigChangeListeners.add(listener);
        }
    }
}
