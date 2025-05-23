package com.tencent.rmonitor.manager;

import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.config.data.l;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.launch.AppLaunchReporter;
import com.tencent.rmonitor.sla.MetricAndSlaHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0016\u0010\u0018\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/rmonitor/manager/e;", "", "", "g", "b", h.F, "f", "j", "Lcom/tencent/rmonitor/manager/d;", "pluginFactory", "k", "", "", "monitorList", "i", "l", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pluginName", "", "needRegister", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "e", "c", "d", "Lcom/tencent/rmonitor/manager/b;", "Lcom/tencent/rmonitor/manager/b;", "environmentChecker", "Lcom/tencent/rmonitor/manager/c;", "Lcom/tencent/rmonitor/manager/c;", "pluginManager", "Z", "isMonitorInitiated", "hasPreLaunched", "Lcom/tencent/rmonitor/base/config/f;", "Lcom/tencent/rmonitor/base/config/f;", "configLoadListener", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isMonitorInitiated;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasPreLaunched;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.rmonitor.base.config.f configLoadListener;

    /* renamed from: f, reason: collision with root package name */
    public static final e f365703f = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static b environmentChecker = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static c pluginManager = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/rmonitor/base/config/data/l;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/rmonitor/base/config/data/l;)V"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.rmonitor.base.config.f {

        /* renamed from: a, reason: collision with root package name */
        public static final a f365704a = new a();

        a() {
        }

        @Override // com.tencent.rmonitor.base.config.f
        public final void a(l lVar) {
            if (Logger.debug && lVar != null) {
                lVar.a("onConfigLoad");
            }
            e.f365703f.m();
        }
    }

    e() {
    }

    private final void b() {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{BuglyMonitorName.BATTERY_ELEMENT_METRIC, BuglyMonitorName.BATTERY_ELEMENT, BuglyMonitorName.BATTERY_METRIC, BuglyMonitorName.PAGE_LAUNCH, BuglyMonitorName.ASAN, BuglyMonitorName.FD_ANALYZE, BuglyMonitorName.MEMORY_JAVA_CEILING, BuglyMonitorName.MEMORY_JAVA_LEAK, BuglyMonitorName.NATIVE_MEMORY_ANALYZE});
        RMonitorFeatureHelper rMonitorFeatureHelper = RMonitorFeatureHelper.getInstance();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            rMonitorFeatureHelper.addPluginNameForReportUserInfo(j.a((String) it.next()));
        }
    }

    private final void f() {
        if (configLoadListener == null) {
            configLoadListener = a.f365704a;
            ConfigProxy.INSTANCE.getConfig().d(configLoadListener);
        }
    }

    private final void g() {
        Application application = BaseInfo.app;
        if (application != null) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("BuglySdkInfos", 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "application.getSharedPre\u2026s\", Context.MODE_PRIVATE)");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("730dcb1b75", BaseInfo.userMeta.sdkVersion);
            edit.commit();
        }
    }

    private final void h() {
        Application application;
        if (AndroidVersion.INSTANCE.isOverIceScreamSandwich() && (application = BaseInfo.app) != null) {
            LifecycleCallback.i(application);
        }
    }

    public final void a() {
        com.tencent.rmonitor.base.db.c dbHandler;
        Logger.f365497g.i("RMonitor_manager_Launcher", "abolish");
        com.tencent.rmonitor.base.db.d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            dbHandler.e();
        }
        pluginManager.stopAll();
        NetworkWatcher.INSTANCE.unInit();
    }

    public final boolean c(@Nullable List<String> monitorList) {
        boolean z16 = true;
        if (monitorList != null && !monitorList.isEmpty()) {
            Iterator<T> it = monitorList.iterator();
            while (it.hasNext()) {
                if (!pluginManager.b((String) it.next())) {
                    z16 = false;
                }
            }
        }
        return z16;
    }

    public final boolean d(@Nullable List<String> monitorList) {
        if (monitorList == null || monitorList.isEmpty()) {
            return true;
        }
        Iterator<T> it = monitorList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (pluginManager.b((String) it.next())) {
                z16 = true;
            }
        }
        return z16;
    }

    @Nullable
    public final QAPMMonitorPlugin e(@NotNull String pluginName, boolean needRegister) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        return pluginManager.c(needRegister, pluginName);
    }

    public final void i(@Nullable List<String> monitorList) {
        if (monitorList != null && !monitorList.isEmpty()) {
            if (BaseInfo.app == null) {
                Logger.f365497g.w("RMonitor_manager_Launcher", "launch fail for app is null.");
                return;
            }
            if (!environmentChecker.b()) {
                Logger.f365497g.e("RMonitor_manager_Launcher", "launch fail, please check environment.");
                return;
            }
            Logger logger = Logger.f365497g;
            logger.i("RMonitor_manager_Launcher", "launch plugins of " + monitorList);
            NetworkWatcher.INSTANCE.init();
            List<String> a16 = environmentChecker.a(monitorList);
            if (a16 != null && (!a16.isEmpty())) {
                Iterator<T> it = a16.iterator();
                while (it.hasNext()) {
                    pluginManager.start((String) it.next());
                }
                if (!isMonitorInitiated) {
                    isMonitorInitiated = true;
                    ReporterMachine.f365411g.r();
                    return;
                }
                return;
            }
            l(monitorList);
            logger.w("RMonitor_manager_Launcher", "no monitor turned on!");
            return;
        }
        Logger.f365497g.e("RMonitor_manager_Launcher", "none plugin to launch.");
    }

    public final synchronized void j() {
        Logger.f365497g.i("RMonitor_manager_Launcher", "preLaunch, hasPreLaunched: " + hasPreLaunched);
        if (hasPreLaunched) {
            return;
        }
        MetricAndSlaHelper.l().d();
        hasPreLaunched = true;
        h();
        BaseInfo.Companion companion = BaseInfo.INSTANCE;
        companion.initUrl();
        companion.initInfo();
        g();
        AppLaunchReporter.getInstance().checkReport();
        f();
        LinkDataWrapper.initLinkage(BaseInfo.app, BaseInfo.userMeta.appId);
        b();
        MetricAndSlaHelper.l().k();
    }

    public final void k(@NotNull d pluginFactory) {
        Intrinsics.checkParameterIsNotNull(pluginFactory, "pluginFactory");
        pluginManager.a(pluginFactory);
    }

    public final void l(@Nullable List<String> monitorList) {
        if (monitorList != null && !monitorList.isEmpty()) {
            Logger.f365497g.i("RMonitor_manager_Launcher", "stop plugins of " + monitorList);
            Iterator<T> it = monitorList.iterator();
            while (it.hasNext()) {
                pluginManager.stop((String) it.next());
            }
            return;
        }
        Logger.f365497g.e("RMonitor_manager_Launcher", "none plugin to stop.");
    }

    public final void m() {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.rmonitor.base.config.d dVar : PluginCombination.INSTANCE.b()) {
            if (!dVar.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.enabled) {
                arrayList.add(dVar.pluginName);
            }
        }
        Logger.f365497g.i("RMonitor_manager_Launcher", "stop disabled plugins {" + arrayList + '}');
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            pluginManager.stop((String) it.next());
        }
    }
}
