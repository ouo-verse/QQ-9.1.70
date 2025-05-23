package com.tdsrightly.tds.fg.observer;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.heytap.databaseengine.model.UserInfo;
import com.tdsrightly.tds.fg.observer.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import op.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0007\u00a2\u0006\u0004\b_\u0010`J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u001c\u0010\u001e\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u001fH\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u00101\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u00102R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00107R\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010?R\u0016\u0010J\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010?R\u0016\u0010M\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00120N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00120N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010OR\u0014\u0010X\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010SR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010^\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010[\u00a8\u0006b"}, d2 = {"Lcom/tdsrightly/tds/fg/observer/ActivityLifeCycleObserver;", "Lcom/tdsrightly/tds/fg/observer/d;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/content/ComponentCallbacks2;", "", "appState", "", "r", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", DomainData.DOMAIN_NAME, "o", "state", "p", "", "activityName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Application;", "app", "Lop/e;", "listener", "d", "getName", "getAppState", "Ljava/util/HashMap;", "map", "a", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityPreCreated", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "bundle", "onActivitySaveInstanceState", "onActivityDestroyed", "Landroid/content/res/Configuration;", "p0", "onConfigurationChanged", "onLowMemory", "level", "onTrimMemory", "i", h.F, "Landroid/app/Application;", "e", "Lop/e;", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "foregroundCount", "startCount", "resumeCount", "I", "lastAppState", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "checkAppStateOnActivityStop", "D", "isActivityOnCreate", "Landroid/os/Handler;", "E", "Landroid/os/Handler;", "mHandler", UserInfo.SEX_FEMALE, "pauseSent", "G", "stopSent", "H", "Ljava/lang/String;", "topActivityName", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "recentSceneList", "", "J", "Ljava/lang/Object;", "sceneListLock", "K", "recentOperateList", "L", "operateListLock", "Ljava/lang/Runnable;", "M", "Ljava/lang/Runnable;", "mDelayedPauseRunnable", "N", "mDelayedTrimRunnable", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ActivityLifeCycleObserver implements d, Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final ArrayList<String> P;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean checkAppStateOnActivityStop;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isActivityOnCreate;

    /* renamed from: E, reason: from kotlin metadata */
    private Handler mHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Application app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private op.e listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastAppState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AtomicInteger foregroundCount = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AtomicInteger startCount = new AtomicInteger(0);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AtomicInteger resumeCount = new AtomicInteger(0);

    /* renamed from: F, reason: from kotlin metadata */
    private boolean pauseSent = true;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean stopSent = true;

    /* renamed from: H, reason: from kotlin metadata */
    private String topActivityName = "";

    /* renamed from: I, reason: from kotlin metadata */
    private final LinkedList<String> recentSceneList = new LinkedList<>();

    /* renamed from: J, reason: from kotlin metadata */
    private final Object sceneListLock = new Object();

    /* renamed from: K, reason: from kotlin metadata */
    private final LinkedList<String> recentOperateList = new LinkedList<>();

    /* renamed from: L, reason: from kotlin metadata */
    private final Object operateListLock = new Object();

    /* renamed from: M, reason: from kotlin metadata */
    private final Runnable mDelayedPauseRunnable = new Runnable() { // from class: com.tdsrightly.tds.fg.observer.ActivityLifeCycleObserver$mDelayedPauseRunnable$1
        @Override // java.lang.Runnable
        public final void run() {
            ActivityLifeCycleObserver.this.j();
            ActivityLifeCycleObserver.this.k();
        }
    };

    /* renamed from: N, reason: from kotlin metadata */
    private final Runnable mDelayedTrimRunnable = new Runnable() { // from class: com.tdsrightly.tds.fg.observer.ActivityLifeCycleObserver$mDelayedTrimRunnable$1
        @Override // java.lang.Runnable
        public final void run() {
            ActivityLifeCycleObserver.this.o();
        }
    };

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("unknown", com.tencent.mobileqq.msf.core.net.r.a.f248963o, "background");
        P = arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.resumeCount.get() == 0) {
            this.pauseSent = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        if (this.startCount.get() == 0 && this.pauseSent) {
            this.stopSent = true;
            n();
        }
    }

    private final void l(Activity activity) {
        p(activity, 1);
        op.d dVar = op.d.f423287g;
        String name = activity.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "activity.javaClass.name");
        dVar.p(name);
        Handler handler = this.mHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        handler.removeCallbacks(this.mDelayedTrimRunnable);
        r(1);
    }

    private final void m(Activity activity) {
        Handler handler = this.mHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        handler.removeCallbacks(this.mDelayedTrimRunnable);
        this.foregroundCount.incrementAndGet();
        if (this.foregroundCount.get() < 0) {
            this.foregroundCount.set(0);
        }
        op.d.f423287g.j().d("ActivityLifeCycleObserver", "onActivityStarted, foregroundCount: " + this.foregroundCount.get());
        if (this.foregroundCount.get() <= 1) {
            r(1);
        }
        if (this.checkAppStateOnActivityStop) {
            this.checkAppStateOnActivityStop = false;
        }
    }

    private final void n() {
        int i3;
        this.foregroundCount.decrementAndGet();
        this.isActivityOnCreate = true;
        op.d dVar = op.d.f423287g;
        dVar.j().d("ActivityLifeCycleObserver", "onActivityStopped, foregroundCount: " + this.foregroundCount.get());
        if (this.foregroundCount.get() <= 0) {
            if (this.checkAppStateOnActivityStop && dVar.k("ProcessObserver").getLastAppState() == 1) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (i3 == 1) {
                this.foregroundCount.set(0);
            } else {
                this.foregroundCount.set(0);
            }
            r(i3);
        }
        if (this.checkAppStateOnActivityStop) {
            this.checkAppStateOnActivityStop = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        r(2);
    }

    private final void p(Activity activity, int state) {
        String str;
        if (activity != null) {
            str = activity.getClass().getName();
        } else {
            str = "UnknownActivity";
        }
        if (state < 4) {
            q(str);
        }
        synchronized (this.operateListLock) {
            this.recentOperateList.add(str + '#' + state);
            if (this.recentOperateList.size() > 15) {
                this.recentOperateList.remove(0);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void q(String activityName) {
        if (Intrinsics.areEqual(activityName, this.topActivityName)) {
            return;
        }
        this.topActivityName = activityName;
        synchronized (this.sceneListLock) {
            this.recentSceneList.add(this.topActivityName);
            if (this.recentSceneList.size() > 5) {
                this.recentSceneList.remove(0);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void r(int appState) {
        int i3 = this.lastAppState;
        int i16 = this.foregroundCount.get();
        if (appState != this.lastAppState) {
            this.lastAppState = appState;
            op.e eVar = this.listener;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            }
            eVar.a(getLastAppState(), this);
        }
        f j3 = op.d.f423287g.j();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateAppState, preAppState: ");
        ArrayList<String> arrayList = P;
        sb5.append(arrayList.get(i3));
        sb5.append(", ");
        sb5.append("curAppState: ");
        sb5.append(arrayList.get(this.lastAppState));
        sb5.append(", ");
        sb5.append("preForeCount: ");
        sb5.append(i16);
        sb5.append(", curForeCount: ");
        sb5.append(this.foregroundCount.get());
        j3.d("ActivityLifeCycleObserver", sb5.toString());
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void a(@NotNull HashMap<String, String> map) {
        List asReversedMutable;
        String joinToString$default;
        List asReversedMutable2;
        String joinToString$default2;
        Intrinsics.checkParameterIsNotNull(map, "map");
        synchronized (this.sceneListLock) {
            if (!this.recentSceneList.isEmpty()) {
                asReversedMutable2 = CollectionsKt__ReversedViewsKt.asReversedMutable(this.recentSceneList);
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(asReversedMutable2, ",", null, null, 0, null, null, 62, null);
                map.put("recentActivity", joinToString$default2);
            }
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.operateListLock) {
            if (!this.recentOperateList.isEmpty()) {
                asReversedMutable = CollectionsKt__ReversedViewsKt.asReversedMutable(this.recentOperateList);
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(asReversedMutable, ",", null, null, 0, null, null, 62, null);
                map.put("recentOperate", joinToString$default);
            }
        }
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void b(int i3, @NotNull d from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        d.a.c(this, i3, from);
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void d(@NotNull Application app, @NotNull op.e listener) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.app = app;
        this.listener = listener;
        if (this.lastAppState != 0) {
            op.d.f423287g.j().e("ActivityLifeCycleObserver", "init error. repeat init");
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        app.registerActivityLifecycleCallbacks(this);
        app.registerComponentCallbacks(this);
        this.checkAppStateOnActivityStop = true;
        op.d.f423287g.j().d("ActivityLifeCycleObserver", "init success");
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    /* renamed from: getAppState, reason: from getter */
    public int getLastAppState() {
        return this.lastAppState;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    @NotNull
    public String getName() {
        return "LifeCycle";
    }

    public final void h(@Nullable Activity activity) {
        p(activity, 7);
        r(1);
    }

    public final void i(@Nullable Activity activity) {
        p(activity, 8);
        r(1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            l(activity);
        }
        op.h.f423289b.b(activity, savedInstanceState);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        op.h.f423289b.c(activity);
        p(activity, 6);
        if (this.foregroundCount.get() <= 0) {
            r(2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        p(activity, 4);
        if (this.resumeCount.decrementAndGet() == 0) {
            Handler handler = this.mHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            }
            handler.postDelayed(this.mDelayedPauseRunnable, 700L);
        }
        op.h.f423289b.d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        l(activity);
        op.h.f423289b.e(activity, savedInstanceState);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        p(activity, 3);
        if (this.resumeCount.incrementAndGet() == 1) {
            if (this.pauseSent) {
                this.pauseSent = false;
            } else {
                Handler handler = this.mHandler;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHandler");
                }
                handler.removeCallbacks(this.mDelayedPauseRunnable);
            }
        }
        op.h.f423289b.f(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        op.h.f423289b.g(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        p(activity, 2);
        if (this.startCount.incrementAndGet() == 1 && this.stopSent) {
            this.stopSent = false;
            m(activity);
        } else if (this.startCount.get() != 1 || this.stopSent) {
            m(activity);
        }
        op.h.f423289b.h(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        op.h.f423289b.i(activity);
        p(activity, 5);
        if (this.startCount.decrementAndGet() == 0) {
            k();
        } else {
            n();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration p06) {
        Intrinsics.checkParameterIsNotNull(p06, "p0");
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        op.d.f423287g.j().d("ActivityLifeCycleObserver", "onTrimMemory, appState: " + P.get(this.lastAppState) + ", level: " + level);
        if ((level == 40 || level == 60 || level == 80) && this.lastAppState != 2 && !this.isActivityOnCreate) {
            Handler handler = this.mHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            }
            handler.postDelayed(this.mDelayedTrimRunnable, 700L);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
