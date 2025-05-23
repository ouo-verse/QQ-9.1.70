package jr3;

import android.content.BroadcastReceiver;
import android.os.Handler;
import com.tencent.qmethod.monitor.base.util.d;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.n;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.ext.broadcast.ReceiverDispatchHelper;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wr3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002Jl\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022F\u0010\f\u001aB\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u00070\u0006j \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007`\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Ljr3/a;", "", "", "scene", "Lcom/tencent/qmethod/monitor/report/SampleHelper$SampleStatus;", "d", "Ljava/util/HashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lwr3/a;", "Landroid/content/BroadcastReceiver;", "Landroid/os/Handler;", "Lkotlin/collections/HashMap;", "map", "", "whiteMap", "", "f", "c", "e", "Lwr3/b;", "a", "Lwr3/b;", "getReport", "()Lwr3/b;", "report", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f410877b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b report = new C10611a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"jr3/a$a", "Lwr3/b;", "", "scene", "", "", "args", "", "b", "(Ljava/lang/String;[Ljava/lang/Object;)Z", "", "a", "(Ljava/lang/String;[Ljava/lang/Object;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: jr3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10611a implements b {
        C10611a() {
        }

        @Override // wr3.b
        public void a(@NotNull String scene, @NotNull Object... args) {
            Intrinsics.checkParameterIsNotNull(scene, "scene");
            Intrinsics.checkParameterIsNotNull(args, "args");
            if (args.length == 2) {
                a aVar = a.f410877b;
                Object obj = args[0];
                if (obj != null) {
                    HashMap hashMap = (HashMap) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        aVar.f(scene, hashMap, (ConcurrentHashMap) obj2);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.String, kotlin.Long>");
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, java.util.concurrent.ConcurrentHashMap<com.tencent.qmethod.pandoraex.core.ext.ComparableWeakRef<android.content.BroadcastReceiver>, android.os.Handler>> /* = java.util.HashMap<kotlin.String, java.util.concurrent.ConcurrentHashMap<com.tencent.qmethod.pandoraex.core.ext.ComparableWeakRef<android.content.BroadcastReceiver>, android.os.Handler>> */");
            }
        }

        @Override // wr3.b
        public boolean b(@NotNull String scene, @NotNull Object... args) {
            boolean z16;
            Intrinsics.checkParameterIsNotNull(scene, "scene");
            Intrinsics.checkParameterIsNotNull(args, "args");
            SampleHelper.SampleStatus d16 = a.f410877b.d(scene);
            if (SampleHelper.SampleStatus.PASS == d16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                o.a("ReceiverReport", "ignore report, because of " + d16);
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
        if (dVar.b(2, "KEY_RECEIVER_REPORT", i3)) {
            return SampleHelper.SampleStatus.GLOBAL_LIMIT;
        }
        if (!SampleHelper.z(SampleHelper.f343779l, d17, 0, 0, 6, null)) {
            return SampleHelper.SampleStatus.GLOBAL_RATE;
        }
        dVar.d(2, "KEY_RECEIVER_REPORT");
        return SampleHelper.SampleStatus.PASS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String scene, HashMap<String, ConcurrentHashMap<wr3.a<BroadcastReceiver>, Handler>> map, ConcurrentHashMap<String, Long> whiteMap) {
        String joinToString$default;
        List<t> listOf;
        String str;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ConcurrentHashMap<wr3.a<BroadcastReceiver>, Handler>> entry : map.entrySet()) {
            for (Map.Entry<wr3.a<BroadcastReceiver>, Handler> entry2 : entry.getValue().entrySet()) {
                BroadcastReceiver broadcastReceiver = entry2.getKey().get();
                String str2 = null;
                if (broadcastReceiver != null) {
                    str = broadcastReceiver.getClass().getName();
                } else {
                    str = null;
                }
                if (str != null && !whiteMap.containsKey(str)) {
                    StringBuilder sb5 = new StringBuilder();
                    BroadcastReceiver broadcastReceiver2 = entry2.getKey().get();
                    if (broadcastReceiver2 != null) {
                        str2 = broadcastReceiver2.getClass().getName();
                    }
                    sb5.append(str2);
                    sb5.append("#");
                    sb5.append(entry.getKey());
                    arrayList.add(sb5.toString());
                }
            }
        }
        if (!arrayList.isEmpty() && (q.j() instanceof PMonitorReporter)) {
            n j3 = q.j();
            if (j3 != null) {
                u uVar = new u("appinfo", "CON#RR");
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
        e eVar = ConfigManager.f343549h.p().g().get("func_receiver_monitor");
        if (eVar == null || eVar.getMaxReport() != 0) {
            ReceiverDispatchHelper.q(report);
        }
    }

    public final void e() {
        e eVar = ConfigManager.f343549h.p().g().get("func_receiver_monitor");
        if (eVar != null && eVar.getMaxReport() == 0) {
            ReceiverDispatchHelper.q(null);
        } else {
            ReceiverDispatchHelper.q(report);
        }
    }
}
