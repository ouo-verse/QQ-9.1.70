package com.tencent.qmethod.monitor.ext.auto;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.tdsrightly.tds.fg.FileLockNativeCore;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import com.tencent.qmethod.pandoraex.monitor.RelationBootMonitor;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010\u0017J1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ.\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010%R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/qmethod/monitor/ext/auto/a;", "", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$AutoStartBean;", "bean", "obj", "", "param", "", "d", "(Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$AutoStartBean;Ljava/lang/Object;[Ljava/lang/Object;)V", "", "type", "", "to", "from", "", "throwable", "f", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", "businessListener", "e", "(Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;)V", "c", "()V", "Lcom/tdsrightly/tds/fg/FileLockNativeCore;", "a", "Lcom/tdsrightly/tds/fg/FileLockNativeCore;", "fileLockLib", "", "b", "Z", "isInit", "I", "fileLockCode", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", "listener", "Lcom/tencent/qmethod/pandoraex/monitor/RelationBootMonitor$RelationBootListener;", "Lcom/tencent/qmethod/pandoraex/monitor/RelationBootMonitor$RelationBootListener;", "relationBootListener", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static FileLockNativeCore fileLockLib;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static AutoStartMonitor.ComponentStartListener businessListener;

    /* renamed from: g, reason: collision with root package name */
    public static final a f343622g = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int fileLockCode = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AutoStartMonitor.ComponentStartListener listener = b.f343623a;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static RelationBootMonitor.RelationBootListener relationBootListener = c.f343624a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qmethod/monitor/ext/auto/a$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityPreCreated", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.ext.auto.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9333a implements Application.ActivityLifecycleCallbacks {
        C9333a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                AutoStartMonitor.activityOnCreate(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            AutoStartMonitor.activityOnCreate(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062.\u0010\u0007\u001a*\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00060\u0006\u0018\u0001 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\b0\bH\n\u00a2\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "bean", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$AutoStartBean;", "kotlin.jvm.PlatformType", "obj", "", "param", "", "onFirstStart", "(Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$AutoStartBean;Ljava/lang/Object;[Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    static final class b implements AutoStartMonitor.ComponentStartListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f343623a = new b();

        b() {
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor.ComponentStartListener
        public final void onFirstStart(AutoStartMonitor.AutoStartBean bean, @Nullable Object obj, @Nullable Object[] objArr) {
            a aVar = a.f343622g;
            Intrinsics.checkExpressionValueIsNotNull(bean, "bean");
            aVar.d(bean, obj, objArr);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "type", "", "to", "", "kotlin.jvm.PlatformType", "from", "throwable", "", "monitor"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    static final class c implements RelationBootMonitor.RelationBootListener {

        /* renamed from: a, reason: collision with root package name */
        public static final c f343624a = new c();

        c() {
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.RelationBootMonitor.RelationBootListener
        public final void monitor(int i3, String str, String str2, Throwable th5) {
            try {
                a.f343622g.f(i3, str, str2, th5);
            } catch (Throwable th6) {
                o.b("AutoCore", "Report error", th6);
            }
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(AutoStartMonitor.AutoStartBean bean, Object obj, Object[] param) {
        if (fileLockLib != null && fileLockCode > 0) {
            if (!isInit) {
                o.c("AutoCore", "call before init, info=" + bean + ", ignore");
                return;
            }
            e eVar = ConfigManager.f343549h.p().g().get("func_auto_monitor");
            if (eVar != null && eVar.getMaxReport() == 0) {
                o.c("AutoCore", "AutoStartMonitor Disable by Config");
                return;
            }
            FileLockNativeCore fileLockNativeCore = fileLockLib;
            if (fileLockNativeCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileLockLib");
            }
            if (fileLockNativeCore.b()) {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("AutoCore", "currentProcessComponentStart, find lock, info=" + bean);
                    return;
                }
                return;
            }
            FileLockNativeCore fileLockNativeCore2 = fileLockLib;
            if (fileLockNativeCore2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileLockLib");
            }
            fileLockNativeCore2.c(true);
            AutoStartMonitor.ComponentStartListener componentStartListener = businessListener;
            if (componentStartListener != null) {
                componentStartListener.onFirstStart(bean, obj, param);
            }
            String componentInfo = bean.getComponentInfo();
            Intrinsics.checkExpressionValueIsNotNull(componentInfo, "bean.componentInfo");
            np.a.d(componentInfo);
            Reporter.f343614c.e(bean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int type, String to5, String from, Throwable throwable) {
        o.b("AutoCore", "monitorRelationBoot, find " + type + " at[" + to5 + "], from=[" + from + ']', throwable);
        e eVar = ConfigManager.f343549h.p().g().get("func_auto_monitor");
        if (eVar != null && eVar.getMaxReport() == 0) {
            o.c("AutoCore", "RelationBoot Disable by Config");
            return;
        }
        Reporter reporter = Reporter.f343614c;
        AutoStartMonitor.AutoStartBean autoStartBean = new AutoStartMonitor.AutoStartBean();
        autoStartBean.setType(type);
        if (to5 == null) {
            to5 = "null";
        }
        autoStartBean.setComponentInfo(to5);
        autoStartBean.setTimeStamp(System.currentTimeMillis());
        if (from == null) {
            from = "null";
        }
        autoStartBean.addExtraInfo(AutoStartMonitor.AutoStartBean.KEY_INTENT, from);
        autoStartBean.addExtraInfo(AutoStartMonitor.AutoStartBean.KEY_AUTO_CALL_SELF, 2);
        autoStartBean.addExtraInfo(AutoStartMonitor.AutoStartBean.KEY_TRACE, x.M(throwable, 2, 25));
        reporter.e(autoStartBean);
    }

    public final void c() {
        e eVar;
        if (isInit && ((eVar = ConfigManager.f343549h.p().g().get("func_auto_monitor")) == null || eVar.getMaxReport() != 0)) {
            AutoStartMonitor.setListener(listener);
            RelationBootMonitor.setListener(relationBootListener);
        } else {
            AutoStartMonitor.setListener(null);
            RelationBootMonitor.setListener(null);
        }
    }

    public final void e(@Nullable AutoStartMonitor.ComponentStartListener businessListener2) {
        if (!AutoStartMonitor.ENABLE) {
            o.c("AutoCore", "AutoStartMonitor Disable");
            return;
        }
        try {
            if (FileLockNativeCore.f61293b == 0) {
                o.c("AutoCore", "init fail, FileLockNativeCore so load fail");
                return;
            }
            FileLockNativeCore fileLockNativeCore = new FileLockNativeCore();
            fileLockLib = fileLockNativeCore;
            StringBuilder sb5 = new StringBuilder();
            com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
            File filesDir = aVar.g().getContext().getFilesDir();
            Intrinsics.checkExpressionValueIsNotNull(filesDir, "PMonitor.config.context.filesDir");
            sb5.append(filesDir.getAbsolutePath());
            sb5.append(File.separator);
            sb5.append("Rightly.auto.tds");
            int a16 = fileLockNativeCore.a(sb5.toString());
            fileLockCode = a16;
            if (a16 <= 0) {
                o.c("AutoCore", "init fail, FileLockNativeCore init fail, code=" + fileLockCode);
                return;
            }
            aVar.g().getContext().registerActivityLifecycleCallbacks(new C9333a());
            businessListener = businessListener2;
            isInit = true;
            AutoStartMonitor.setListener(listener);
            RelationBootMonitor.setListener(relationBootListener);
            o.e("AutoCore", "AutoMonitor Start");
        } catch (Throwable th5) {
            o.d("AutoCore", "init fail, FileLockNativeCore init fail", th5);
        }
    }
}
