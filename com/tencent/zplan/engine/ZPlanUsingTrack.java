package com.tencent.zplan.engine;

import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.zplan.utils.ZLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lx4.b;
import lx4.f;
import org.jetbrains.annotations.NotNull;
import tl.h;
import zx4.d;
import zx4.s;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/zplan/engine/ZPlanUsingTrack;", "", "", h.F, "", "processName", "", "e", "i", "f", "d", "j", "", "preStatus", "curStatus", "c", "g", "isUsing", "k", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "usingMap", "b", "Z", "usingReport", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanUsingTrack {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean usingReport;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ZPlanUsingTrack f385555c = new ZPlanUsingTrack();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Integer> usingMap = new ConcurrentHashMap<>();

    ZPlanUsingTrack() {
    }

    private final void c(boolean preStatus, boolean curStatus) {
        s sVar = (s) mx4.a.f417748a.a(s.class);
        if (curStatus && !preStatus) {
            if (sVar != null) {
                sVar.e(false);
            }
        } else if (!curStatus && preStatus && sVar != null) {
            sVar.e(true);
        }
    }

    private final void d() {
        f fVar = (f) mx4.a.f417748a.a(f.class);
        if (fVar != null) {
            f.a.a(fVar, new Runnable() { // from class: com.tencent.zplan.engine.ZPlanUsingTrack$clearUselessProcessCount$1
                @Override // java.lang.Runnable
                public final void run() {
                    ConcurrentHashMap concurrentHashMap;
                    long currentTimeMillis = System.currentTimeMillis();
                    Object a16 = mx4.a.f417748a.a(lx4.a.class);
                    Intrinsics.checkNotNull(a16);
                    Object systemService = ((lx4.a) a16).getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    if (systemService != null) {
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
                        ZPlanUsingTrack zPlanUsingTrack = ZPlanUsingTrack.f385555c;
                        concurrentHashMap = ZPlanUsingTrack.usingMap;
                        for (Object obj : concurrentHashMap.entrySet()) {
                            Intrinsics.checkNotNullExpressionValue(obj, "iterator.next()");
                            Map.Entry entry = (Map.Entry) obj;
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            boolean z16 = false;
                            while (it.hasNext()) {
                                if (Intrinsics.areEqual((String) entry.getKey(), it.next().processName)) {
                                    z16 = true;
                                }
                            }
                            if (!z16) {
                                ZLog.f386189b.k("ZPlanUsingTrack", "clearProcessUsingIfNotExist precess=" + ((String) entry.getKey()) + " not exist, clear it, count=" + ((Integer) entry.getValue()));
                                ZPlanUsingTrack zPlanUsingTrack2 = ZPlanUsingTrack.f385555c;
                                Object key = entry.getKey();
                                Intrinsics.checkNotNullExpressionValue(key, "item.key");
                                zPlanUsingTrack2.e((String) key);
                            }
                        }
                        ZLog.f386189b.k("ZPlanUsingTrack", "clearProcessUsingIfNotExist, cost=" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void e(String processName) {
        ZLog zLog = ZLog.f386189b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("clearUsing, processName=");
        sb5.append(processName);
        sb5.append(", count=");
        ConcurrentHashMap<String, Integer> concurrentHashMap = usingMap;
        sb5.append(concurrentHashMap.get(processName));
        zLog.k("ZPlanUsingTrack", sb5.toString());
        if (concurrentHashMap.containsKey(processName)) {
            concurrentHashMap.remove(processName);
        }
    }

    private final synchronized void f(String processName) {
        ZLog zLog = ZLog.f386189b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("decreaseUsing, processName=");
        sb5.append(processName);
        sb5.append(", count=");
        ConcurrentHashMap<String, Integer> concurrentHashMap = usingMap;
        sb5.append(concurrentHashMap.get(processName));
        zLog.k("ZPlanUsingTrack", sb5.toString());
        if (concurrentHashMap.get(processName) == null) {
            zLog.o("ZPlanUsingTrack", "decreaseUsing failed, please call increaseUsing first");
            return;
        }
        Integer valueOf = Integer.valueOf(r1.intValue() - 1);
        if (valueOf.intValue() <= 0) {
            concurrentHashMap.remove(processName);
        } else {
            concurrentHashMap.put(processName, valueOf);
        }
    }

    private final int h() {
        int i3 = 0;
        for (Map.Entry<String, Integer> entry : usingMap.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "iterator.next()");
            Map.Entry<String, Integer> entry2 = entry;
            Integer value = entry2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "item.value");
            i3 += value.intValue();
            ZLog.f386189b.k("ZPlanUsingTrack", "getUsingCount, processName=" + entry2.getKey() + ", count=" + entry2.getValue());
        }
        return i3;
    }

    private final synchronized void i(String processName) {
        ZLog zLog = ZLog.f386189b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("increaseUsing, processName=");
        sb5.append(processName);
        sb5.append(", count=");
        ConcurrentHashMap<String, Integer> concurrentHashMap = usingMap;
        sb5.append(concurrentHashMap.get(processName));
        zLog.k("ZPlanUsingTrack", sb5.toString());
        if (concurrentHashMap.containsKey(processName)) {
            Integer num = concurrentHashMap.get(processName);
            Intrinsics.checkNotNull(num);
            concurrentHashMap.put(processName, Integer.valueOf(num.intValue() + 1));
        } else {
            concurrentHashMap.put(processName, 1);
        }
        Object a16 = mx4.a.f417748a.a(s.class);
        Intrinsics.checkNotNull(a16);
        ((s) a16).a();
    }

    private final void j() {
        boolean z16;
        mx4.a aVar = mx4.a.f417748a;
        d dVar = (d) aVar.a(d.class);
        if (dVar != null) {
            z16 = dVar.isPreloadEnable();
        } else {
            z16 = false;
        }
        if (!usingReport && g() && z16) {
            lx4.b bVar = (lx4.b) aVar.a(lx4.b.class);
            if (bVar != null) {
                b.C10752b.a(bVar, null, "zplan_engine_use", null, 5, null);
            }
            usingReport = true;
        }
    }

    public final boolean g() {
        boolean z16;
        if (h() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ZLog.f386189b.k("ZPlanUsingTrack", "getIsUsing, isUsing=" + z16 + ", count=" + h());
        return z16;
    }

    public final void k(@NotNull String processName, boolean isUsing) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        ZLog.f386189b.k("ZPlanUsingTrack", "setIsUsing isUsing " + isUsing);
        d();
        boolean g16 = g();
        if (isUsing) {
            i(processName);
        } else {
            f(processName);
        }
        j();
        c(g16, g());
    }
}
