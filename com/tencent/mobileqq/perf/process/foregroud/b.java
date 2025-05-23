package com.tencent.mobileqq.perf.process.foregroud;

import android.app.ActivityManager;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.process.config.e;
import com.tencent.mobileqq.perf.process.foregroud.ProcessExitManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/perf/process/foregroud/b;", "", "", "processName", "", "b", TagName.ENTRY_NAME, "", "a", "e", "i", "j", "f", "c", h.F, "g", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/perf/process/foregroud/session/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "entryNameToSession", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257916a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.mobileqq.perf.process.foregroud.session.a> entryNameToSession;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f257916a = new b();
            entryNameToSession = new ConcurrentHashMap<>();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String entryName, String processName) {
        boolean z16;
        if (!e(processName)) {
            Collection<com.tencent.mobileqq.perf.process.foregroud.session.a> values = entryNameToSession.values();
            Intrinsics.checkNotNullExpressionValue(values, "entryNameToSession.values");
            ArrayList<com.tencent.mobileqq.perf.process.foregroud.session.a> arrayList = new ArrayList();
            for (Object obj : values) {
                com.tencent.mobileqq.perf.process.foregroud.session.a aVar = (com.tencent.mobileqq.perf.process.foregroud.session.a) obj;
                if (!Intrinsics.areEqual(aVar.c(), entryName) && Intrinsics.areEqual(aVar.d(), processName)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            for (com.tencent.mobileqq.perf.process.foregroud.session.a aVar2 : arrayList) {
                b bVar = f257916a;
                String c16 = aVar2.c();
                Intrinsics.checkNotNull(c16);
                bVar.f(c16);
            }
            ConcurrentHashMap<String, com.tencent.mobileqq.perf.process.foregroud.session.a> concurrentHashMap = entryNameToSession;
            if (!concurrentHashMap.containsKey(entryName)) {
                concurrentHashMap.put(entryName, new com.tencent.mobileqq.perf.process.foregroud.session.a(entryName, processName));
            }
            com.tencent.mobileqq.perf.process.foregroud.session.a aVar3 = concurrentHashMap.get(entryName);
            if (aVar3 != null) {
                aVar3.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00fd, code lost:
    
        if (((r2.availMem / r14) / r14) > r11.b().h()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0105, code lost:
    
        if (r2.lowMemory == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b(String processName) {
        List<ActivityManager.RunningAppProcessInfo> list;
        boolean z16;
        boolean startsWith$default;
        boolean z17;
        e.Companion companion = e.INSTANCE;
        boolean z18 = true;
        if (companion.b().i() && companion.b().k(processName)) {
            Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager activityManager = (ActivityManager) systemService;
            try {
                list = SystemMethodProxy.getRunningAppProcesses(activityManager);
            } catch (Exception unused) {
                list = null;
            }
            if (list != null) {
                List<ActivityManager.RunningAppProcessInfo> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list2) {
                        String str = runningAppProcessInfo.processName;
                        Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                        String packageName = BaseApplication.context.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, packageName, false, 2, null);
                        if (startsWith$default && runningAppProcessInfo.importance == 100) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                        }
                    }
                }
                z16 = false;
                if (z16) {
                    QLog.i("ProcessPreloadManager", 1, "canPreloadProcess false, app is background, processName:" + processName);
                    com.tencent.mobileqq.perf.process.foregroud.report.a.f257918a.e(processName, false, null);
                    return false;
                }
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                float f16 = (float) memoryInfo.availMem;
                long j3 = memoryInfo.totalMem;
                float f17 = f16 / ((float) j3);
                float f18 = ((float) memoryInfo.threshold) / ((float) j3);
                double d16 = f17;
                e.Companion companion2 = e.INSTANCE;
                if (d16 < companion2.b().e() || f17 < f18) {
                    if (!Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME)) {
                        ProcessExitManager.f257912d.g();
                    } else {
                        ProcessExitManager.f257912d.b(ProcessExitManager.FromTag.PreloadCheck);
                    }
                }
                if (d16 <= companion2.b().g()) {
                    long j16 = 1024;
                }
                if (f17 > f18) {
                }
                z18 = false;
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("canPreloadProcess ");
                    sb5.append(z18);
                    sb5.append(", processName:");
                    sb5.append(processName);
                    sb5.append(", availMem:");
                    long j17 = 1024;
                    sb5.append((memoryInfo.availMem / j17) / j17);
                    sb5.append(", totalMem:");
                    sb5.append((memoryInfo.totalMem / j17) / j17);
                    sb5.append(", threshold:");
                    sb5.append((memoryInfo.threshold / j17) / j17);
                    sb5.append(", lowMemory:");
                    sb5.append(memoryInfo.lowMemory);
                    sb5.append(", availMemRatio:");
                    sb5.append(f17);
                    sb5.append(", thresholdRatio:");
                    sb5.append(f18);
                    sb5.append(", configRatio:");
                    sb5.append(companion2.b().g());
                    sb5.append(", configThreshold:");
                    sb5.append(companion2.b().h());
                    QLog.i("ProcessPreloadManager", 2, sb5.toString());
                }
                com.tencent.mobileqq.perf.process.foregroud.report.a.f257918a.e(processName, z18, memoryInfo);
                return z18;
            }
            z16 = true;
            if (z16) {
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("ProcessPreloadManager", 2, "canPreloadProcess true, switch:" + companion.b().i() + ", processName:" + processName);
            }
            return true;
        }
    }

    private final boolean e(String processName) {
        try {
            Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
            if (runningAppProcesses == null) {
                return true;
            }
            Intrinsics.checkNotNullExpressionValue(runningAppProcesses, "runningAppProcesses");
            List<ActivityManager.RunningAppProcessInfo> list = runningAppProcesses;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) it.next()).processName, processName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.e("ProcessPreloadManager", 1, "checkProcessExist error", e16);
            return true;
        }
    }

    public final boolean c(@NotNull String entryName, @NotNull String processName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) entryName, (Object) processName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        Intrinsics.checkNotNullParameter(processName, "processName");
        if (!b(processName)) {
            return false;
        }
        a(entryName, processName);
        return true;
    }

    public final boolean d(@NotNull String processName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) processName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        Collection<com.tencent.mobileqq.perf.process.foregroud.session.a> values = entryNameToSession.values();
        Intrinsics.checkNotNullExpressionValue(values, "entryNameToSession.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((com.tencent.mobileqq.perf.process.foregroud.session.a) it.next()).d(), processName)) {
                return true;
            }
        }
        return false;
    }

    public final void f(@NotNull String entryName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entryName);
            return;
        }
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        ConcurrentHashMap<String, com.tencent.mobileqq.perf.process.foregroud.session.a> concurrentHashMap = entryNameToSession;
        com.tencent.mobileqq.perf.process.foregroud.session.a aVar = concurrentHashMap.get(entryName);
        if (aVar != null) {
            aVar.b();
        }
        concurrentHashMap.remove(entryName);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Collection<com.tencent.mobileqq.perf.process.foregroud.session.a> values = entryNameToSession.values();
        Intrinsics.checkNotNullExpressionValue(values, "entryNameToSession.values");
        for (com.tencent.mobileqq.perf.process.foregroud.session.a aVar : values) {
            b bVar = f257916a;
            String c16 = aVar.c();
            Intrinsics.checkNotNull(c16);
            bVar.f(c16);
        }
    }

    public final void h(@NotNull String processName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) processName);
            return;
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        Collection<com.tencent.mobileqq.perf.process.foregroud.session.a> values = entryNameToSession.values();
        Intrinsics.checkNotNullExpressionValue(values, "entryNameToSession.values");
        ArrayList<com.tencent.mobileqq.perf.process.foregroud.session.a> arrayList = new ArrayList();
        for (Object obj : values) {
            if (Intrinsics.areEqual(((com.tencent.mobileqq.perf.process.foregroud.session.a) obj).d(), processName)) {
                arrayList.add(obj);
            }
        }
        for (com.tencent.mobileqq.perf.process.foregroud.session.a aVar : arrayList) {
            b bVar = f257916a;
            String c16 = aVar.c();
            Intrinsics.checkNotNull(c16);
            bVar.f(c16);
        }
    }

    public final void i(@NotNull String entryName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) entryName);
            return;
        }
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        com.tencent.mobileqq.perf.process.foregroud.session.a aVar = entryNameToSession.get(entryName);
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void j(@NotNull String processName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) processName);
            return;
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        Collection<com.tencent.mobileqq.perf.process.foregroud.session.a> values = entryNameToSession.values();
        Intrinsics.checkNotNullExpressionValue(values, "entryNameToSession.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (Intrinsics.areEqual(((com.tencent.mobileqq.perf.process.foregroud.session.a) obj).d(), processName)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.perf.process.foregroud.session.a) it.next()).e();
        }
    }
}
