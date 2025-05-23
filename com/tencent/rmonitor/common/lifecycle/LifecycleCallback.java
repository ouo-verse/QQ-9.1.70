package com.tencent.rmonitor.common.lifecycle;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.utils.ThreadUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\"\u0010\u001d\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\fJ\u001a\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010$\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010(\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u000102J\u0006\u00106\u001a\u000205J\f\u00109\u001a\b\u0012\u0004\u0012\u00020807R$\u0010=\u001a\u0012\u0012\u0004\u0012\u0002080:j\b\u0012\u0004\u0012\u000208`;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010<R$\u0010>\u001a\u0012\u0012\u0004\u0012\u0002080:j\b\u0012\u0004\u0012\u000208`;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010<R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00140E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010FR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010HR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR*\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\b@\u0010P\"\u0004\bQ\u0010RR*\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010P\"\u0004\bV\u0010RR*\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010O\u001a\u0004\bY\u0010P\"\u0004\bZ\u0010R\u00a8\u0006^"}, d2 = {"Lcom/tencent/rmonitor/common/lifecycle/LifecycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/content/ComponentCallbacks2;", "Lcom/tencent/rmonitor/common/lifecycle/b;", "callback", "", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/app/Application;", "application", "k", "i", "", "isForeground", "j", "Landroid/os/Handler;", "e", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "", "activityHash", "t", "appState", "u", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "state", "o", "p", "v", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityPostCreated", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "outState", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "onLowMemory", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "level", "onTrimMemory", "Landroid/content/Context;", "context", "l", "Lorg/json/JSONArray;", "g", "", "", h.F, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "APP_LIFECYCLE_DES", "APP_STATE_DESC", "Ljava/util/concurrent/CopyOnWriteArraySet;", "f", "Ljava/util/concurrent/CopyOnWriteArraySet;", "callbackSet", "I", "lastAppState", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "foregroundActivityList", "Landroid/app/Application;", "Lcom/tencent/rmonitor/common/lifecycle/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/rmonitor/common/lifecycle/e;", "operationLog", "Ljava/lang/ref/WeakReference;", "D", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "setLastResumeActivityRef", "(Ljava/lang/ref/WeakReference;)V", "lastResumeActivityRef", "E", "getLastStartActivityRef", "setLastStartActivityRef", "lastStartActivityRef", UserInfo.SEX_FEMALE, "getLastStopActivityRef", "setLastStopActivityRef", "lastStopActivityRef", "<init>", "()V", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LifecycleCallback implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: C, reason: from kotlin metadata */
    private static final e operationLog;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private static WeakReference<Activity> lastResumeActivityRef;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private static WeakReference<Activity> lastStartActivityRef;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private static WeakReference<Activity> lastStopActivityRef;
    public static final LifecycleCallback G = new LifecycleCallback();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> APP_LIFECYCLE_DES;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> APP_STATE_DESC;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<b> callbackSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int lastAppState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentLinkedQueue<Integer> foregroundActivityList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static Application application;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        APP_LIFECYCLE_DES = arrayList;
        arrayList.add("unknown");
        arrayList.add("created");
        arrayList.add("started");
        arrayList.add("resumed");
        arrayList.add("paused");
        arrayList.add("stopped");
        arrayList.add("destroyed");
        arrayList.add(com.tencent.mobileqq.msf.core.net.r.a.f248963o);
        arrayList.add("background");
        arrayList.add("postCreated");
        ArrayList<String> arrayList2 = new ArrayList<>();
        APP_STATE_DESC = arrayList2;
        arrayList2.add("unknown");
        arrayList2.add(com.tencent.mobileqq.msf.core.net.r.a.f248963o);
        arrayList2.add("background");
        callbackSet = new CopyOnWriteArraySet<>();
        foregroundActivityList = new ConcurrentLinkedQueue<>();
        operationLog = new e();
    }

    LifecycleCallback() {
    }

    private final void b() {
        d();
        u(2);
    }

    private final void d() {
        try {
            foregroundActivityList.clear();
        } catch (Throwable unused) {
        }
    }

    private final Handler e() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new Handler(mainLooper);
        }
        return null;
    }

    @JvmStatic
    public static final void i(@NotNull Application application2) {
        Intrinsics.checkParameterIsNotNull(application2, "application");
        LifecycleCallback lifecycleCallback = G;
        if (lifecycleCallback.n(application2)) {
            return;
        }
        j(application2, lifecycleCallback.l(application2));
    }

    @JvmStatic
    public static final void j(@NotNull final Application application2, final boolean isForeground) {
        Intrinsics.checkParameterIsNotNull(application2, "application");
        if (ThreadUtil.isInMainThread()) {
            G.q(application2, isForeground);
            return;
        }
        Handler e16 = G.e();
        if (e16 != null) {
            e16.post(new Runnable() { // from class: com.tencent.rmonitor.common.lifecycle.LifecycleCallback$init$1
                @Override // java.lang.Runnable
                public final void run() {
                    LifecycleCallback.G.q(application2, isForeground);
                }
            });
        }
    }

    @JvmStatic
    public static final void k(@NotNull Application application2) {
        Intrinsics.checkParameterIsNotNull(application2, "application");
        j(application2, false);
    }

    private final boolean n(Application application2) {
        return Intrinsics.areEqual(application2, application);
    }

    private final void o(Activity activity, int state) {
        String str = "";
        if (activity != null) {
            try {
                str = activity.getClass().getName();
                Intrinsics.checkExpressionValueIsNotNull(str, "activity.javaClass.name");
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_looper_lifecycle", "notify", th5);
                return;
            }
        }
        e eVar = operationLog;
        String str2 = APP_LIFECYCLE_DES.get(state);
        Intrinsics.checkExpressionValueIsNotNull(str2, "APP_LIFECYCLE_DES[state]");
        eVar.d(str, str2);
        Iterator<b> it = callbackSet.iterator();
        while (it.hasNext()) {
            b callback = it.next();
            Intrinsics.checkExpressionValueIsNotNull(callback, "callback");
            p(activity, state, callback);
        }
    }

    private final void p(Activity activity, int state, b callback) {
        try {
            if (activity != null) {
                if (state != 9) {
                    switch (state) {
                        case 1:
                            callback.onCreate(activity);
                            break;
                        case 2:
                            callback.onStart(activity);
                            break;
                        case 3:
                            callback.onResume(activity);
                            break;
                        case 4:
                            callback.onPause(activity);
                            break;
                        case 5:
                            callback.onStop(activity);
                            break;
                        case 6:
                            callback.onDestroy(activity);
                            break;
                        default:
                            return;
                    }
                } else {
                    callback.onPostCreate(activity);
                }
            } else if (state != 7) {
                if (state == 8) {
                    callback.onBackground();
                }
            } else {
                callback.onForeground();
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_looper_lifecycle", "notify", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Application application2, boolean isForeground) {
        if (n(application2)) {
            return;
        }
        Application application3 = application;
        application = application2;
        if (application3 != null) {
            LifecycleCallback lifecycleCallback = G;
            application3.unregisterActivityLifecycleCallbacks(lifecycleCallback);
            application3.unregisterComponentCallbacks(lifecycleCallback);
        }
        t(0, isForeground);
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_looper_lifecycle", "realInit, appState: " + APP_STATE_DESC.get(lastAppState) + ", isForeground: " + isForeground);
        }
        LifecycleCallback lifecycleCallback2 = G;
        application2.registerActivityLifecycleCallbacks(lifecycleCallback2);
        application2.registerComponentCallbacks(lifecycleCallback2);
    }

    @JvmStatic
    public static final void r(@NotNull b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            callbackSet.add(callback);
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_looper_lifecycle", "register", th5);
        }
    }

    @JvmStatic
    public static final void s(@NotNull b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            callbackSet.remove(callback);
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_looper_lifecycle", "unRegister", th5);
        }
    }

    private final void t(int activityHash, boolean isForeground) {
        int i3;
        v(activityHash, isForeground);
        if (foregroundActivityList.isEmpty()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        u(i3);
    }

    private final void u(int appState) {
        int i3 = lastAppState;
        if (appState == i3) {
            return;
        }
        lastAppState = appState;
        if (appState == 1) {
            o(null, 7);
        } else if (appState == 2) {
            o(null, 8);
        }
        if (Logger.debug) {
            Logger logger = Logger.f365497g;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateAppState, ");
            ArrayList<String> arrayList = APP_STATE_DESC;
            sb5.append(arrayList.get(i3));
            sb5.append(" --> ");
            sb5.append(arrayList.get(lastAppState));
            sb5.append(", curForeCount: ");
            sb5.append(foregroundActivityList.size());
            logger.d("RMonitor_looper_lifecycle", sb5.toString());
        }
    }

    private final void v(int activityHash, boolean isForeground) {
        try {
            if (isForeground) {
                foregroundActivityList.add(Integer.valueOf(activityHash));
            } else {
                ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = foregroundActivityList;
                concurrentLinkedQueue.remove(Integer.valueOf(activityHash));
                concurrentLinkedQueue.remove(0);
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final WeakReference<Activity> f() {
        return lastResumeActivityRef;
    }

    @NotNull
    public final JSONArray g() {
        return operationLog.b();
    }

    @NotNull
    public final List<String> h() {
        return operationLog.c();
    }

    public final boolean l(@Nullable Context context) {
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList;
        boolean z16;
        boolean z17 = false;
        if (context == null) {
            return false;
        }
        try {
            int myPid = Process.myPid();
            Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
                if (runningAppProcesses != null) {
                    arrayList = new ArrayList();
                    for (Object obj : runningAppProcesses) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    return false;
                }
                while (true) {
                    boolean z18 = false;
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : arrayList) {
                        try {
                            if (runningAppProcessInfo2.importance == 100 && runningAppProcessInfo2.importanceReasonCode == 0) {
                                z18 = true;
                            }
                        } catch (Throwable unused) {
                            z17 = z18;
                            Unit unit = Unit.INSTANCE;
                            return z17;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return z18;
                }
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
        } catch (Throwable unused2) {
        }
    }

    public final boolean m() {
        if (lastAppState == 1) {
            return true;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        o(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        o(activity, 6);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        o(activity, 4);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        o(activity, 9);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        a.i().l(activity);
        lastResumeActivityRef = new WeakReference<>(activity);
        o(activity, 3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        lastStartActivityRef = new WeakReference<>(activity);
        t(activity.hashCode(), true);
        o(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        lastStopActivityRef = new WeakReference<>(activity);
        t(activity.hashCode(), false);
        o(activity, 5);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        int i3;
        if (level != 20 && level != 40) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        if (i3 == 2) {
            if (Logger.debug) {
                Logger.f365497g.d("RMonitor_looper_lifecycle", "onTrimMemory, appState: " + APP_STATE_DESC.get(i3) + ", level: " + level);
            }
            b();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
