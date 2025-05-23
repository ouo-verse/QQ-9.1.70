package ir3;

import com.tencent.qmethod.monitor.base.util.d;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.n;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.ext.file.ContentObserverHelper;
import com.tencent.qmethod.pandoraex.core.ext.file.FileObserverHelper;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wr3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lir3/a;", "", "", "scene", "Lcom/tencent/qmethod/monitor/report/SampleHelper$SampleStatus;", "d", "info", "", "f", "c", "e", "Lwr3/b;", "a", "Lwr3/b;", "getReport", "()Lwr3/b;", "report", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f408442b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b report = new C10549a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"ir3/a$a", "Lwr3/b;", "", "scene", "", "", "args", "", "b", "(Ljava/lang/String;[Ljava/lang/Object;)Z", "", "a", "(Ljava/lang/String;[Ljava/lang/Object;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ir3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10549a implements b {
        C10549a() {
        }

        @Override // wr3.b
        public void a(@NotNull String scene, @NotNull Object... args) {
            Intrinsics.checkParameterIsNotNull(scene, "scene");
            Intrinsics.checkParameterIsNotNull(args, "args");
            if (args.length == 1) {
                a.f408442b.f(scene, args[0]);
            }
        }

        @Override // wr3.b
        public boolean b(@NotNull String scene, @NotNull Object... args) {
            boolean z16;
            Intrinsics.checkParameterIsNotNull(scene, "scene");
            Intrinsics.checkParameterIsNotNull(args, "args");
            SampleHelper.SampleStatus d16 = a.f408442b.d(scene);
            if (SampleHelper.SampleStatus.PASS == d16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                o.a("ScreenshotReport", "ignore report, because of " + d16);
            }
            return z16;
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SampleHelper.SampleStatus d(String scene) {
        double d16;
        int i3;
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            return SampleHelper.SampleStatus.PASS;
        }
        ConfigManager configManager = ConfigManager.f343549h;
        e eVar = configManager.p().g().get(scene);
        if (eVar != null) {
            d16 = eVar.getRate();
        } else {
            d16 = 0.0d;
        }
        double d17 = d16;
        e eVar2 = configManager.p().g().get(scene);
        if (eVar2 != null) {
            i3 = eVar2.getMaxReport();
        } else {
            i3 = 0;
        }
        d dVar = d.f343534a;
        if (dVar.b(2, "KEY_SCREENSHOT_REPORT", i3)) {
            return SampleHelper.SampleStatus.GLOBAL_LIMIT;
        }
        if (!SampleHelper.z(SampleHelper.f343779l, d17, 0, 0, 6, null)) {
            return SampleHelper.SampleStatus.GLOBAL_RATE;
        }
        dVar.d(2, "KEY_SCREENSHOT_REPORT");
        return SampleHelper.SampleStatus.PASS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String scene, Object info) {
        String str;
        T t16;
        String joinToString$default;
        List<t> listOf;
        T t17;
        ArrayList arrayList = new ArrayList();
        if (info instanceof CopyOnWriteArrayList) {
            for (Object obj : (Iterable) info) {
                if ((obj instanceof wr3.a) && (t17 = ((wr3.a) obj).get()) != 0) {
                    String name = t17.getClass().getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "observer.javaClass.name");
                    arrayList.add(name);
                }
            }
            str = "FO#STW";
        } else if (info instanceof ConcurrentHashMap) {
            Set keySet = ((ConcurrentHashMap) info).keySet();
            Intrinsics.checkExpressionValueIsNotNull(keySet, "info.keys");
            for (Object obj2 : keySet) {
                if ((obj2 instanceof wr3.a) && (t16 = ((wr3.a) obj2).get()) != 0) {
                    String name2 = t16.getClass().getName();
                    Intrinsics.checkExpressionValueIsNotNull(name2, "observer.javaClass.name");
                    arrayList.add(name2);
                }
            }
            str = "CR#REG";
        } else {
            str = "";
        }
        if (!arrayList.isEmpty() && (q.j() instanceof PMonitorReporter)) {
            n j3 = q.j();
            if (j3 != null) {
                u uVar = new u("mediaFile", str);
                uVar.f343970g = false;
                uVar.f343968e = "ban";
                uVar.f343967d = "back";
                uVar.f343969f = false;
                t tVar = new t();
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
                tVar.f343962b = joinToString$default;
                tVar.f343963c = 1;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(tVar);
                uVar.f343980q = listOf;
                uVar.f343977n = System.currentTimeMillis();
                uVar.f343979p = com.tencent.qmethod.pandoraex.core.collector.utils.a.a();
                uVar.f343978o = "0.9.15-rc2+build.1";
                ((PMonitorReporter) j3).e(uVar);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.qmethod.monitor.report.PMonitorReporter");
        }
    }

    public final void c() {
        e eVar = ConfigManager.f343549h.p().g().get("func_screenshot_monitor");
        if (eVar == null || eVar.getMaxReport() != 0) {
            b bVar = report;
            FileObserverHelper.i(bVar);
            ContentObserverHelper.h(bVar);
        }
    }

    public final void e() {
        e eVar = ConfigManager.f343549h.p().g().get("func_screenshot_monitor");
        if (eVar != null && eVar.getMaxReport() == 0) {
            FileObserverHelper.i(null);
            ContentObserverHelper.h(null);
        } else {
            b bVar = report;
            FileObserverHelper.i(bVar);
            ContentObserverHelper.h(bVar);
        }
    }
}
