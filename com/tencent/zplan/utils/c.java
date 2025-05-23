package com.tencent.zplan.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.zplan.engine.service.ZPlanEngineQualityReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@RequiresApi(23)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J*\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/utils/c;", "", "", "Lcom/tencent/zplan/utils/c$a;", "Landroid/os/Debug$MemoryInfo;", "d", "memoryInfo", "", "", "b", "c", "", "viewType", "", "a", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f386201a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/utils/c$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "", "b", "Z", "()Z", "isBackGround", "<init>", "(Ljava/lang/String;Z)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isBackGround;

        public a(@NotNull String name, boolean z16) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.isBackGround = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsBackGround() {
            return this.isBackGround;
        }
    }

    c() {
    }

    private final Map<String, String> b(Map<a, ? extends Debug.MemoryInfo> memoryInfo) {
        boolean z16;
        String str;
        Map<String, String> mutableMapOf;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<T> it = memoryInfo.values().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            i16 += ((Debug.MemoryInfo) it.next()).getTotalPss();
        }
        Iterator<T> it5 = memoryInfo.values().iterator();
        int i17 = 0;
        while (it5.hasNext()) {
            i17 += ((Debug.MemoryInfo) it5.next()).nativePss;
        }
        Iterator<T> it6 = memoryInfo.values().iterator();
        int i18 = 0;
        while (it6.hasNext()) {
            i18 += ((Debug.MemoryInfo) it6.next()).dalvikPss;
        }
        Iterator<T> it7 = memoryInfo.values().iterator();
        int i19 = 0;
        while (it7.hasNext()) {
            i19 += ((Debug.MemoryInfo) it7.next()).otherPss;
        }
        Iterator<T> it8 = memoryInfo.values().iterator();
        int i26 = 0;
        while (it8.hasNext()) {
            try {
                String memoryStat = ((Debug.MemoryInfo) it8.next()).getMemoryStat("summary.graphics");
                Intrinsics.checkNotNullExpressionValue(memoryStat, "it.getMemoryStat(\"summary.graphics\")");
                i3 = Integer.parseInt(memoryStat);
            } catch (NumberFormatException unused) {
                i3 = (int) (-1);
            }
            i26 += i3;
        }
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        if (aVar != null) {
            z16 = aVar.b();
        } else {
            z16 = false;
        }
        ZLog.f386189b.k("MemoryReportUtil", "getAppMemory, appTotalPss: " + i16 + ", appNativePss: " + i17 + ", appDalvikPss: " + i18 + ", appOtherPss: " + i19 + ", appGraphicPss: " + i26 + ", appRunningBackGround: " + z16 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        if (i16 > 0) {
            Pair[] pairArr = new Pair[6];
            pairArr[0] = TuplesKt.to("appTotalPss", String.valueOf(i16));
            pairArr[1] = TuplesKt.to("appNativePss", String.valueOf(i17));
            pairArr[2] = TuplesKt.to("appDalvikPss", String.valueOf(i18));
            pairArr[3] = TuplesKt.to("appOtherPss", String.valueOf(i19));
            pairArr[4] = TuplesKt.to("appGraphicPss", String.valueOf(i26));
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            pairArr[5] = TuplesKt.to("appRunningBackGround", str);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return mutableMapOf;
        }
        return null;
    }

    private final Map<String, String> c(Map<a, ? extends Debug.MemoryInfo> memoryInfo) {
        boolean endsWith$default;
        long j3;
        String str;
        Map<String, String> mutableMapOf;
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<a, ? extends Debug.MemoryInfo> entry : memoryInfo.entrySet()) {
            a key = entry.getKey();
            Debug.MemoryInfo value = entry.getValue();
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(key.getName(), ":zplan", false, 2, null);
            if (endsWith$default) {
                String name = key.getName();
                int totalPss = value.getTotalPss();
                int i3 = value.nativePss;
                int i16 = value.dalvikPss;
                int i17 = value.otherPss;
                try {
                    String memoryStat = value.getMemoryStat("summary.graphics");
                    Intrinsics.checkNotNullExpressionValue(memoryStat, "memInfo.getMemoryStat(\"summary.graphics\")");
                    j3 = Long.parseLong(memoryStat);
                } catch (NumberFormatException unused) {
                    j3 = -1;
                }
                boolean isBackGround = key.getIsBackGround();
                ZLog.f386189b.k("MemoryReportUtil", "getProcessMemory, processName: " + name + ", processTotalPss: " + totalPss + ", processNativePss: " + i3 + ", processDalvikPss: " + i16 + ", processOtherPss: " + i17 + ", processGraphicsPss: " + j3 + ", processBackGround: " + isBackGround + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (totalPss > 0) {
                    Pair[] pairArr = new Pair[7];
                    pairArr[0] = TuplesKt.to("processName", name);
                    pairArr[1] = TuplesKt.to("processTotalPss", String.valueOf(totalPss));
                    pairArr[2] = TuplesKt.to("processNativePss", String.valueOf(i3));
                    pairArr[3] = TuplesKt.to("processDalvikPss", String.valueOf(i16));
                    pairArr[4] = TuplesKt.to("processOtherPss", String.valueOf(i17));
                    pairArr[5] = TuplesKt.to("processGraphicsPss", String.valueOf(j3));
                    if (isBackGround) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    pairArr[6] = TuplesKt.to("processBackGround", str);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    return mutableMapOf;
                }
                return null;
            }
        }
        return null;
    }

    private final Map<a, Debug.MemoryInfo> d() {
        Context context;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        boolean z16;
        int collectionSizeOrDefault2;
        boolean startsWith$default;
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        ArrayList arrayList = null;
        if (aVar != null) {
            context = aVar.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return new LinkedHashMap();
        }
        String a16 = com.tencent.zplan.common.utils.a.f385286a.a(context);
        if (a16 == null) {
            return new LinkedHashMap();
        }
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
            if (runningAppProcesses != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : runningAppProcesses) {
                    String str = ((ActivityManager.RunningAppProcessInfo) obj).processName;
                    Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, a16, false, 2, null);
                    if (startsWith$default) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add((ActivityManager.RunningAppProcessInfo) it.next());
                }
            }
            if (arrayList != null) {
                ArrayList<ActivityManager.RunningAppProcessInfo> arrayList3 = arrayList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList3) {
                    String str2 = runningAppProcessInfo.processName;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.processName");
                    if (runningAppProcessInfo.importance != 100) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Pair pair = TuplesKt.to(new a(str2, z16), com.tencent.zplan.common.utils.e.f385291b.a(context, runningAppProcessInfo.pid));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                return linkedHashMap;
            }
            return new HashMap();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final void a(int viewType) {
        Context context;
        Long l3;
        boolean z16;
        String str;
        Map<a, Debug.MemoryInfo> d16 = d();
        Map<String, String> b16 = b(d16);
        Map<String, String> c16 = c(d16);
        com.tencent.zplan.common.utils.e eVar = com.tencent.zplan.common.utils.e.f385291b;
        long c17 = eVar.c();
        mx4.a aVar = mx4.a.f417748a;
        lx4.a aVar2 = (lx4.a) aVar.a(lx4.a.class);
        Long l16 = null;
        if (aVar2 != null) {
            context = aVar2.getContext();
        } else {
            context = null;
        }
        if (context != null) {
            l3 = Long.valueOf(eVar.d(context));
        } else {
            l3 = null;
        }
        if (context != null) {
            l16 = Long.valueOf(eVar.b(context));
        }
        zx4.d dVar = (zx4.d) aVar.a(zx4.d.class);
        if (dVar != null) {
            z16 = dVar.o();
        } else {
            z16 = false;
        }
        ZLog.f386189b.k("MemoryReportUtil", "getSystemTotalMemory, totalProc: " + c17 + ", totalAm: " + l3 + ", getSystemAvaialbeMemory: " + l16 + ", enableParallelWorld: " + z16 + TokenParser.SP);
        String str2 = "1";
        if (b16 != null) {
            b16.put("viewType", String.valueOf(viewType));
            b16.put("totalProc", String.valueOf(c17));
            b16.put("totalAm", String.valueOf(l3));
            b16.put("avaialbe", String.valueOf(l16));
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            b16.put("zplan_parallel_world_enable", str);
        }
        if (c16 != null) {
            c16.put("viewType", String.valueOf(viewType));
            c16.put("totalProc", String.valueOf(c17));
            c16.put("totalAm", String.valueOf(l3));
            c16.put("avaialbe", String.valueOf(l16));
            if (!z16) {
                str2 = "0";
            }
            c16.put("zplan_parallel_world_enable", str2);
            ZPlanEngineQualityReporter.f385585b.b("zplan_first_frame_process_memory", c16);
        }
    }
}
