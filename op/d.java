package op;

import android.app.Activity;
import android.app.Application;
import com.tdsrightly.tds.fg.observer.ActivityLifeCycleObserver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0002J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0018J\u001a\u0010$\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u0012J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010)\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u0004R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u0010=\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R0\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0>j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b`?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010@R \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lop/d;", "Lop/e;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", tl.h.F, "g", "d", "Lcom/tdsrightly/tds/fg/observer/d;", "filterObserver", "Lop/a;", "e", "appState", HippyTKDListViewAdapter.X, "w", "v", "u", "observer", "", "isCustom", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "", "name", "k", "Landroid/app/Application;", "app", "Lop/b;", DownloadInfo.spKey_Config, "l", "componentName", "p", "onlyCurrentProcess", "needExtraInfo", "b", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "type", DomainData.DOMAIN_NAME, "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "Lop/b;", "i", "()Lop/b;", "setConfig$fg_release", "(Lop/b;)V", "c", "Z", "isInit", "Lop/f;", "Lop/f;", "j", "()Lop/f;", "setLog", "(Lop/f;)V", "log", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "observerList", "Ljava/util/concurrent/ConcurrentHashMap;", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "customObserverList", "<init>", "()V", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static Application app;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isInit;

    /* renamed from: g, reason: collision with root package name */
    public static final d f423287g = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Config config = new Config(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static f log = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, com.tdsrightly.tds.fg.observer.d> observerList = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, com.tdsrightly.tds.fg.observer.d> customObserverList = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"op/d$a", "Lop/f;", "fg_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class a implements f {
        a() {
        }

        @Override // op.f
        public void d(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            f.a.a(this, tag, msg2);
        }

        @Override // op.f
        public void e(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            f.a.b(this, tag, msg2);
        }
    }

    d() {
    }

    public static /* synthetic */ AppStateInfo c(d dVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        return dVar.b(z16, z17);
    }

    private final int d() {
        int lastAppState = k("ApplicationLockObserver").getLastAppState();
        if (config.getIsDebug()) {
            log.d("ForegroundCore", "getAppState: ApplicationLockObserver=" + lastAppState);
        }
        return lastAppState;
    }

    private final AppStateInfo e(com.tdsrightly.tds.fg.observer.d filterObserver) {
        for (Map.Entry<String, com.tdsrightly.tds.fg.observer.d> entry : customObserverList.entrySet()) {
            if ((!Intrinsics.areEqual(entry.getValue(), filterObserver)) && entry.getValue().getLastAppState() == 1) {
                if (config.getIsDebug()) {
                    log.d("ForegroundCore", "getAppState: " + entry.getValue().getName() + '=' + entry.getValue().getLastAppState());
                }
                return new AppStateInfo(entry.getValue().getName(), 1);
            }
        }
        return new AppStateInfo("custom", 0, 2, null);
    }

    static /* synthetic */ AppStateInfo f(d dVar, com.tdsrightly.tds.fg.observer.d dVar2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dVar2 = null;
        }
        return dVar.e(dVar2);
    }

    private final int g() {
        int lastAppState = k("LifeCycle").getLastAppState();
        if (config.getIsDebug()) {
            log.d("ForegroundCore", "getAppState: LifeCycle=" + lastAppState);
        }
        return lastAppState;
    }

    private final int h() {
        int lastAppState = k("FileLockObserver").getLastAppState();
        if (config.getIsDebug()) {
            log.d("ForegroundCore", "getAppState: FileLockObserver=" + lastAppState);
        }
        return lastAppState;
    }

    private final void m() {
        t(this, new com.tdsrightly.tds.fg.observer.e(), false, 2, null);
        t(this, new com.tdsrightly.tds.fg.observer.c(), false, 2, null);
        t(this, new com.tdsrightly.tds.fg.observer.a(), false, 2, null);
        t(this, new ActivityLifeCycleObserver(), false, 2, null);
    }

    private final void o(int appState, com.tdsrightly.tds.fg.observer.d observer) {
        k("FileLockObserver").b(appState, observer);
        Iterator<Map.Entry<String, com.tdsrightly.tds.fg.observer.d>> it = customObserverList.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(appState, observer);
        }
    }

    private final void q(com.tdsrightly.tds.fg.observer.d observer) {
        int g16;
        int i3 = 2;
        if ((!Intrinsics.areEqual("LifeCycle", observer.getName())) && (g16 = g()) != 0) {
            i3 = g16;
        }
        if (i3 != 1) {
            AppStateInfo e16 = e(observer);
            if (e16.getState() != 0) {
                i3 = e16.getState();
            }
        }
        o(i3, observer);
    }

    private final void r(com.tdsrightly.tds.fg.observer.d observer) {
        o(1, observer);
    }

    private final void s(com.tdsrightly.tds.fg.observer.d observer, boolean isCustom) {
        if (isCustom) {
            customObserverList.put(observer.getName(), observer);
        } else {
            observerList.put(observer.getName(), observer);
        }
        Application application = app;
        if (application == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app");
        }
        observer.d(application, this);
    }

    static /* synthetic */ void t(d dVar, com.tdsrightly.tds.fg.observer.d dVar2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        dVar.s(dVar2, z16);
    }

    private final void u(AppStateInfo appState) {
        Iterator<Map.Entry<String, com.tdsrightly.tds.fg.observer.d>> it = observerList.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(appState.a());
        }
        Iterator<Map.Entry<String, com.tdsrightly.tds.fg.observer.d>> it5 = customObserverList.entrySet().iterator();
        while (it5.hasNext()) {
            it5.next().getValue().a(appState.a());
        }
    }

    private final AppStateInfo v(AppStateInfo appState) {
        if (appState.getState() != 1) {
            AppStateInfo appStateInfo = new AppStateInfo("ApplicationLockObserver", d());
            if (appStateInfo.getState() != 0) {
                return appStateInfo;
            }
            return appState;
        }
        p(appState.getName());
        return appState;
    }

    private final AppStateInfo w(AppStateInfo appState) {
        if (appState.getState() != 1) {
            AppStateInfo f16 = f(this, null, 1, null);
            if (f16.getState() != 0) {
                return f16;
            }
            return appState;
        }
        return appState;
    }

    private final AppStateInfo x(AppStateInfo appState) {
        if (appState.getState() != 1) {
            AppStateInfo appStateInfo = new AppStateInfo("FileLockObserver", h());
            if (appStateInfo.getState() != 0) {
                return appStateInfo;
            }
            return appState;
        }
        return appState;
    }

    @Override // op.e
    public void a(int appState, @NotNull com.tdsrightly.tds.fg.observer.d observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (appState != 1) {
            if (appState == 2) {
                q(observer);
            }
        } else {
            r(observer);
        }
        e stateChangeListener = config.getStateChangeListener();
        if (stateChangeListener != null) {
            stateChangeListener.a(appState, observer);
        }
    }

    @NotNull
    public final AppStateInfo b(boolean onlyCurrentProcess, boolean needExtraInfo) {
        if (!isInit) {
            log.e("ForegroundCore", "call before init");
            return new AppStateInfo(null, 0, 3, null);
        }
        AppStateInfo appStateInfo = new AppStateInfo("LifeCycle", g());
        if (!onlyCurrentProcess) {
            appStateInfo = x(appStateInfo);
        }
        AppStateInfo v3 = v(w(appStateInfo));
        if (needExtraInfo) {
            u(v3);
        }
        return v3;
    }

    @NotNull
    public final Config i() {
        return config;
    }

    @NotNull
    public final f j() {
        return log;
    }

    @NotNull
    public final com.tdsrightly.tds.fg.observer.d k(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        com.tdsrightly.tds.fg.observer.d dVar = observerList.get(name);
        if (dVar == null) {
            return new com.tdsrightly.tds.fg.observer.b();
        }
        return dVar;
    }

    public final void l(@Nullable Application app2, @Nullable Config config2) {
        long nanoTime = System.nanoTime();
        if (app2 == null) {
            log.e("ForegroundCore", "App is null!");
            return;
        }
        if (isInit) {
            log.e("ForegroundCore", "repeat init");
            return;
        }
        app = app2;
        if (config2 != null) {
            config = config2;
            f logger = config2.getLogger();
            if (logger != null) {
                log = logger;
            }
        }
        m();
        isInit = true;
        log.d("ForegroundCore", "init cost=" + ((System.nanoTime() - nanoTime) / 1000000));
    }

    public final void n(@Nullable Activity activity, int type) {
        com.tdsrightly.tds.fg.observer.d k3 = k("LifeCycle");
        if (k3 instanceof ActivityLifeCycleObserver) {
            if (type != 0) {
                if (type == 1) {
                    ((ActivityLifeCycleObserver) k3).i(activity);
                    return;
                }
                return;
            }
            ((ActivityLifeCycleObserver) k3).h(activity);
        }
    }

    public final void p(@NotNull String componentName) {
        Intrinsics.checkParameterIsNotNull(componentName, "componentName");
        com.tdsrightly.tds.fg.observer.d k3 = k("ApplicationLockObserver");
        if (!(k3 instanceof com.tdsrightly.tds.fg.observer.a)) {
            k3 = null;
        }
        com.tdsrightly.tds.fg.observer.a aVar = (com.tdsrightly.tds.fg.observer.a) k3;
        if (aVar != null) {
            aVar.c(componentName);
        }
    }
}
