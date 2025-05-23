package f12;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.performance.report.data.GuildPerformanceInfo;
import com.tencent.mobileqq.guild.performance.report.data.InfoType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import f12.f;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0003J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0002R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010'R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010+\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-\u00a8\u00061"}, d2 = {"Lf12/b;", "Lf12/n;", "", "i", "d", "", "e", "kb", "g", "f", "Lf12/f$a;", ISchemeApi.KEY_SCENE_DATA, "a", "destroy", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "callback", "c", tl.h.F, "autoModeDelay", "k", "l", "", "b", "I", "count", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mGuildMemoryCpuCallbacks", "", "Z", "isBackground", "inGuildTab", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "runnableForCancel", "J", "mAutoModeDelay", "", "Ljava/lang/String;", "scene", "j", "sideScene", "isRunning", "Lfv1/a;", "Lfv1/a;", "perfTool", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f397591a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int count;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArraySet<com.tencent.mobileqq.guild.performance.report.data.a> mGuildMemoryCpuCallbacks;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isBackground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean inGuildTab;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable runnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Runnable runnableForCancel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long mAutoModeDelay;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String scene;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String sideScene;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isRunning;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Guild/Inject_IPerfTool.yml", version = 1)
    private static fv1.a perfTool;

    /* renamed from: m, reason: collision with root package name */
    private static ArrayList f397603m;

    static {
        ArrayList arrayList = new ArrayList();
        f397603m = arrayList;
        arrayList.add(gv1.a.class);
        f397591a = new b();
        mGuildMemoryCpuCallbacks = new CopyOnWriteArraySet<>();
        runnable = new Runnable() { // from class: f12.a
            @Override // java.lang.Runnable
            public final void run() {
                b.j();
            }
        };
        mAutoModeDelay = k.INSTANCE.d().getDelay();
        scene = "default";
        sideScene = "default";
        f();
    }

    b() {
    }

    private final void d() {
        isRunning = false;
        count = 0;
        Runnable runnable2 = runnableForCancel;
        if (runnable2 != null) {
            ThreadManagerV2.removeJob(runnable2, 16);
        }
        runnableForCancel = null;
    }

    private final long e() {
        if (o.f397685a.l()) {
            return mAutoModeDelay;
        }
        return k.INSTANCE.d().getDelay();
    }

    @JvmStatic
    @QAutoInitMethod
    private static final void f() {
        boolean z16;
        perfTool = (fv1.a) com.tencent.mobileqq.qroute.utils.b.a(f397603m);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildCpuMemoryCollector", 2, "injected..");
        }
        if (perfTool != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
        } else {
            throw new IllegalStateException("perfTool is not initialized".toString());
        }
    }

    private final long g(long kb5) {
        long j3 = 1024;
        return (kb5 / j3) / j3;
    }

    private final void i() {
        if (!isRunning) {
            return;
        }
        if (count >= k.INSTANCE.d().getMaxCPUReportTimes() && !o.f397685a.l()) {
            return;
        }
        count++;
        fv1.a aVar = perfTool;
        fv1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTool");
            aVar = null;
        }
        float totalPss = aVar.a().getTotalPss() / 1024.0f;
        long g16 = g(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        long c16 = com.tencent.mobileqq.guild.util.performance.d.c();
        fv1.a aVar3 = perfTool;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTool");
        } else {
            aVar2 = aVar3;
        }
        float cpuUsage = aVar2.getCpuUsage() * 100.0f;
        for (com.tencent.mobileqq.guild.performance.report.data.a aVar4 : mGuildMemoryCpuCallbacks) {
            GuildPerformanceInfo guildPerformanceInfo = new GuildPerformanceInfo(0.0f, 0.0f, 0.0f, cpuUsage, totalPss, (float) c16, (float) g16, scene, InfoType.MEMORY_CPU_INFO, isBackground, inGuildTab, sideScene, 0.0d, 0.0d, 12295, null);
            aVar4.a(guildPerformanceInfo, true);
            QLog.i("GuildCpuMemoryCollector", 1, guildPerformanceInfo.toString());
            c16 = c16;
            g16 = g16;
        }
        if (isRunning) {
            runnableForCancel = ThreadManagerV2.executeDelay(runnable, 16, null, true, e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        f397591a.i();
    }

    @Override // f12.n
    public void a(@NotNull f.a sceneData) {
        long delayFirst;
        Intrinsics.checkNotNullParameter(sceneData, "sceneData");
        if (!q.h()) {
            d();
            return;
        }
        if (isRunning) {
            d();
        }
        if (!Intrinsics.areEqual(sceneData.getMediaScene(), "null")) {
            scene = sceneData.getMediaScene();
            sideScene = sceneData.getBaseScene() + "-" + sceneData.getScene();
        } else if (!Intrinsics.areEqual(sceneData.getScene(), "null")) {
            scene = sceneData.getScene();
            sideScene = sceneData.getBaseScene();
        } else {
            scene = sceneData.getBaseScene();
            sideScene = "null";
        }
        if (Intrinsics.areEqual(scene, "null")) {
            d();
            return;
        }
        isBackground = sceneData.getBackGround();
        inGuildTab = sceneData.getInGuildTab();
        isRunning = true;
        if (o.f397685a.l()) {
            delayFirst = 0;
        } else {
            delayFirst = k.INSTANCE.d().getDelayFirst();
        }
        runnableForCancel = ThreadManagerV2.executeDelay(runnable, 16, null, true, delayFirst);
    }

    public final void c(@NotNull com.tencent.mobileqq.guild.performance.report.data.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        mGuildMemoryCpuCallbacks.add(callback);
    }

    @Override // f12.n
    public void destroy() {
        d();
    }

    public final void h(@NotNull com.tencent.mobileqq.guild.performance.report.data.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        mGuildMemoryCpuCallbacks.remove(callback);
    }

    public final void k(long autoModeDelay) {
        mAutoModeDelay = autoModeDelay;
    }

    public final void l() {
    }
}
