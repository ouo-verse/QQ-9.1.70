package com.tencent.mobileqq.perf.process.startup;

import android.app.Activity;
import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.memory.dump.c;
import com.tencent.mobileqq.perf.process.util.b;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/perf/process/startup/BootMonitor;", "", "", "e", "", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "startupFirstScene", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "c", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "()Lcom/tencent/mobileqq/perf/tracker/callback/a;", "sceneChangerListener", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class BootMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final BootMonitor f257924a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String startupFirstScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.tracker.callback.a sceneChangerListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/perf/process/startup/BootMonitor$a", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "stage", "", "delay", "", "traceStart", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityResumed", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            BootMonitor bootMonitor = BootMonitor.f257924a;
            if (Intrinsics.areEqual(bootMonitor.d(), "com.tencent.mobileqq.activity.home.Conversation") && !Intrinsics.areEqual(activity.getClass().getName(), "com.tencent.mobileqq.activity.SplashActivity")) {
                bootMonitor.e();
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceStart(@NotNull String stage, boolean delay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, stage, Boolean.valueOf(delay));
                return;
            }
            Intrinsics.checkNotNullParameter(stage, "stage");
            BootMonitor bootMonitor = BootMonitor.f257924a;
            if (bootMonitor.d() == null) {
                bootMonitor.g(stage);
            }
            if (Intrinsics.areEqual(bootMonitor.d(), "com.tencent.mobileqq.activity.home.Conversation") && !Intrinsics.areEqual(stage, "com.tencent.mobileqq.activity.home.Conversation")) {
                bootMonitor.e();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257924a = new BootMonitor();
            sceneChangerListener = new a();
        }
    }

    BootMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        if (AppSetting.isPublicVersion()) {
            return;
        }
        QLog.d("BootMonitor", 1, "leaveConversation");
        SceneTracker.f258213d.n(sceneChangerListener);
        b.f257946a.p(new Runnable() { // from class: com.tencent.mobileqq.perf.process.startup.a
            @Override // java.lang.Runnable
            public final void run() {
                BootMonitor.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.processName, mqq.app.MobileQQ.PACKAGE_NAME + ":raftkit") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void f() {
        String joinToString$default;
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
            if (!Intrinsics.areEqual(runningAppProcessInfo.processName, MobileQQ.PACKAGE_NAME)) {
                if (!Intrinsics.areEqual(runningAppProcessInfo.processName, MobileQQ.PACKAGE_NAME + ":MSF")) {
                }
            }
            z16 = false;
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Pair<String, Long> f16 = c.f257726a.f();
            if (f16.getFirst() == null) {
                return;
            }
            String component1 = f16.component1();
            long longValue = f16.component2().longValue();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("illegal_process_log_size", String.valueOf(longValue));
            Intrinsics.checkNotNull(component1);
            hashMap.put("illegal_process_log_url", component1);
            hashMap.put("illegal_process_num", String.valueOf(arrayList.size()));
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, BootMonitor$leaveConversation$1$2.INSTANCE, 31, null);
            hashMap.put("illegal_process_list", joinToString$default);
            com.tencent.mobileqq.perf.process.foregroud.report.a.f257918a.a("event_process_num_error", hashMap);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.perf.tracker.callback.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.perf.tracker.callback.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return sceneChangerListener;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return startupFirstScene;
    }

    public final void g(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            startupFirstScene = str;
        }
    }
}
