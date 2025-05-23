package com.tencent.mobileqq.perf.tracker;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.tool.AppInfoUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b=\u0010>J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\u0003H\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0001J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0001R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0001008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00103R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00108R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0003008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00101R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/SceneTracker;", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "", "fragmentClassNames", "", "b", "([Ljava/lang/String;)V", "", "j", "f", "e", "Landroidx/fragment/app/Fragment;", "fragment", "d", "scene", "k", "i", "g", "stage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "delay", "traceStart", "traceEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Landroidx/fragment/app/FragmentManager;", "fm", "onFragmentResumed", "onFragmentPaused", "onQFragmentResumed", "onQFragmentPaused", "onQFragmentDestroy", "onProcessForeground", "onProcessBackground", "cb", "l", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sceneChangedListeners", "Z", "isProcessForeground", tl.h.F, "Ljava/lang/String;", "nowScene", "[Ljava/lang/String;", "activityClassNamesForFilterFragment", "fragmentClassNamesForFilterFragment", BdhLogUtil.LogTag.Tag_Conn, "filterPackages", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SceneTracker extends com.tencent.mobileqq.perf.tracker.callback.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static String[] filterPackages;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final SceneTracker f258213d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<com.tencent.mobileqq.perf.tracker.callback.a> sceneChangedListeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isProcessForeground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String nowScene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String[] activityClassNamesForFilterFragment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<String> fragmentClassNamesForFilterFragment;

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        f258213d = new SceneTracker();
        sceneChangedListeners = new CopyOnWriteArrayList<>();
        nowScene = "not init scene";
        fragmentClassNamesForFilterFragment = new CopyOnWriteArrayList<>();
        filterPackages = new String[]{"com.tencent.biz.qqcircle", "com.qzone"};
        if (Foreground.isCurrentProcessForeground() && !Intrinsics.areEqual(nowScene, "not init scene")) {
            z16 = true;
        } else {
            z16 = false;
        }
        isProcessForeground = z16;
    }

    SceneTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@NotNull String... fragmentClassNames) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(fragmentClassNames, "fragmentClassNames");
        CollectionsKt__MutableCollectionsKt.addAll(fragmentClassNamesForFilterFragment, fragmentClassNames);
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addFragmentForFilterFragment ");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(fragmentClassNamesForFilterFragment, null, null, null, 0, null, SceneTracker$addFragmentForFilterFragment$1.INSTANCE, 31, null);
            sb5.append(joinToString$default);
            QLog.d("SceneTracker", 1, sb5.toString());
        }
    }

    private final boolean d(Fragment fragment) {
        boolean z16;
        Boolean bool;
        if (MainProcConfig.INSTANCE.e().n() && !fragment.isVisible()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onFragmentResumed, ");
            sb5.append(fragment.isVisible());
            sb5.append(", ");
            View view = fragment.getView();
            Boolean bool2 = null;
            if (view != null) {
                bool = Boolean.valueOf(view.isShown());
            } else {
                bool = null;
            }
            sb5.append(bool);
            sb5.append(", ");
            View view2 = fragment.getView();
            if (view2 != null) {
                bool2 = Boolean.valueOf(view2.isAttachedToWindow());
            }
            sb5.append(bool2);
            sb5.append(", ");
            sb5.append(fragment.getClass().getSimpleName());
            QLog.d("SceneTracker", 1, sb5.toString());
        }
        return z16;
    }

    @JvmStatic
    @NotNull
    public static final String e() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("st_now_process_name", "not init scene");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(NOW_PROCESS_NAME, NO_SCENE)");
        return decodeString;
    }

    @JvmStatic
    @NotNull
    public static final String f() {
        return nowScene;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        com.tencent.mobileqq.perf.receiver.c cVar = com.tencent.mobileqq.perf.receiver.c.f257962a;
        QQPerfHandlerThreadManager.Companion companion = QQPerfHandlerThreadManager.INSTANCE;
        Looper looper = companion.d().getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "QQPerfHandlerThreadManager.handlerThread.looper");
        cVar.d(looper);
        com.tencent.mobileqq.perf.tracker.printer.a.f258261a.k();
        d.f258240l.n();
        bd2.b.f28286a.c();
        gd2.g.f401968a.a();
        if (Build.VERSION.SDK_INT > 28) {
            g.f258254a.h();
        }
        AppInfoUtil appInfoUtil = AppInfoUtil.f258158a;
        if (appInfoUtil.c() && appInfoUtil.b() && appInfoUtil.d()) {
            com.tencent.mobileqq.perf.terrible.b.f258047a.A(companion.d());
            RegularLogTracker.f258208a.h();
        }
        com.tencent.mobileqq.perf.metric.a.f257803d.i();
        c cVar2 = c.f258237d;
    }

    private final boolean i(String scene) {
        boolean startsWith$default;
        for (String str : filterPackages) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scene, str, false, 2, null);
            if (startsWith$default) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean j() {
        return isProcessForeground;
    }

    private final boolean k(String scene) {
        boolean contains$default;
        boolean contains$default2;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return false;
        }
        String[] strArr = activityClassNamesForFilterFragment;
        if (strArr != null) {
            for (String str : strArr) {
                String name = topActivity.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) str, false, 2, (Object) null);
                if (contains$default2) {
                    return false;
                }
            }
        }
        for (String it : fragmentClassNamesForFilterFragment) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) scene, (CharSequence) it, false, 2, (Object) null);
            if (contains$default) {
                return false;
            }
        }
        return true;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Foreground.addActivityLifeCallback(this);
        com.tencent.mobileqq.perf.tracker.printer.b.f258267a.a();
        QQPerfHandlerThreadManager.INSTANCE.b(new Runnable() { // from class: com.tencent.mobileqq.perf.tracker.h
            @Override // java.lang.Runnable
            public final void run() {
                SceneTracker.h();
            }
        }, 15000L);
    }

    public final void l(@Nullable com.tencent.mobileqq.perf.tracker.callback.a cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) cb5);
        } else if (cb5 != null) {
            CopyOnWriteArrayList<com.tencent.mobileqq.perf.tracker.callback.a> copyOnWriteArrayList = sceneChangedListeners;
            if (!copyOnWriteArrayList.contains(cb5)) {
                copyOnWriteArrayList.add(cb5);
            }
        }
    }

    public final void m(@NotNull String stage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) stage);
        } else {
            Intrinsics.checkNotNullParameter(stage, "stage");
            traceStart(stage, false);
        }
    }

    public final void n(@NotNull com.tencent.mobileqq.perf.tracker.callback.a cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        CopyOnWriteArrayList<com.tencent.mobileqq.perf.tracker.callback.a> copyOnWriteArrayList = sceneChangedListeners;
        if (copyOnWriteArrayList.contains(cb5)) {
            copyOnWriteArrayList.remove(cb5);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivityCreated(activity, savedInstanceState);
        }
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this, true);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivityDestroyed(activity);
        }
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivityPaused(activity);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivityResumed(activity);
        }
        String name2 = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "activity.javaClass.name");
        nowScene = name2;
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity, (Object) outState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivitySaveInstanceState(activity, outState);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivityStarted(activity);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        if (i(name)) {
            return;
        }
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onActivityStopped(activity);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) fm5, (Object) f16);
            return;
        }
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(f16, "f");
        if (f16 instanceof QBaseFragment) {
            return;
        }
        String scene = f16.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(scene, "scene");
        if (!i(scene) && k(scene) && !d(f16)) {
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onQFragmentPaused(f16);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) fm5, (Object) f16);
            return;
        }
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(f16, "f");
        if (f16 instanceof QBaseFragment) {
            return;
        }
        String scene = f16.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(scene, "scene");
        if (!i(scene) && k(scene) && !d(f16)) {
            nowScene = scene;
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onQFragmentResumed(f16);
            }
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        isProcessForeground = false;
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onProcessBackground();
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("st_now_process_name", MobileQQ.processName);
        isProcessForeground = true;
        Iterator<T> it = sceneChangedListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onProcessForeground();
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void onQFragmentDestroy(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        String scene = fragment.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(scene, "scene");
        if (!i(scene) && k(scene)) {
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onQFragmentDestroy(fragment);
            }
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void onQFragmentPaused(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        String scene = fragment.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(scene, "scene");
        if (!i(scene) && k(scene) && !d(fragment)) {
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onQFragmentPaused(fragment);
            }
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void onQFragmentResumed(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        String scene = fragment.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(scene, "scene");
        if (!i(scene) && k(scene) && !d(fragment)) {
            nowScene = scene;
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).onQFragmentResumed(fragment);
            }
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void traceEnd(@NotNull String stage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) stage);
            return;
        }
        Intrinsics.checkNotNullParameter(stage, "stage");
        if (!i(stage) && k(stage)) {
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).traceEnd(stage);
            }
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void traceStart(@NotNull String stage, boolean delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, stage, Boolean.valueOf(delay));
            return;
        }
        Intrinsics.checkNotNullParameter(stage, "stage");
        if (!i(stage) && k(stage)) {
            nowScene = stage;
            Iterator<T> it = sceneChangedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.tracker.callback.a) it.next()).traceStart(stage, delay);
            }
        }
    }
}
