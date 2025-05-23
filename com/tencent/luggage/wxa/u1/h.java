package com.tencent.luggage.wxa.u1;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum h {
    INST;


    /* renamed from: b, reason: collision with root package name */
    public static String[] f142074b = {"summary.native-heap", "summary.graphics"};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function0 {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b invoke() {
            return h.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f142077a;

        /* renamed from: b, reason: collision with root package name */
        public int f142078b;

        /* renamed from: c, reason: collision with root package name */
        public int f142079c;

        /* renamed from: d, reason: collision with root package name */
        public int f142080d;

        /* renamed from: e, reason: collision with root package name */
        public int f142081e;

        /* renamed from: f, reason: collision with root package name */
        public int f142082f;

        /* renamed from: g, reason: collision with root package name */
        public int f142083g;

        /* renamed from: h, reason: collision with root package name */
        public int f142084h;

        /* renamed from: i, reason: collision with root package name */
        public int f142085i;

        /* renamed from: j, reason: collision with root package name */
        public int f142086j;

        /* renamed from: k, reason: collision with root package name */
        public String f142087k;
    }

    public final Debug.MemoryInfo b(int i3) {
        Debug.MemoryInfo[] processMemoryInfo;
        ActivityManager activityManager = (ActivityManager) z.c().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null || (processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{i3})) == null || processMemoryInfo.length <= 0) {
            return null;
        }
        return processMemoryInfo[0];
    }

    public int c() {
        b bVar = (b) com.tencent.luggage.wxa.e5.g.a("MemoryInspector.getMemoryMB", new a());
        if (bVar == null) {
            return 0;
        }
        return bVar.f142077a;
    }

    public b a(int i3) {
        return a(b(i3));
    }

    public static b a(Debug.MemoryInfo memoryInfo) {
        b bVar = new b();
        if (memoryInfo == null) {
            return bVar;
        }
        bVar.f142077a = memoryInfo.getTotalPss() / 1024;
        bVar.f142078b = memoryInfo.nativePss / 1024;
        bVar.f142079c = memoryInfo.dalvikPss / 1024;
        bVar.f142080d = w0.f(memoryInfo.getMemoryStat("summary.graphics")) / 1024;
        bVar.f142081e = w0.f(memoryInfo.getMemoryStat("summary.system")) / 1024;
        bVar.f142082f = w0.f(memoryInfo.getMemoryStat("summary.total-swap")) / 1024;
        bVar.f142083g = w0.f(memoryInfo.getMemoryStat("summary.java-heap")) / 1024;
        bVar.f142084h = w0.f(memoryInfo.getMemoryStat("summary.private-other")) / 1024;
        bVar.f142085i = w0.f(memoryInfo.getMemoryStat("summary.code")) / 1024;
        bVar.f142086j = w0.f(memoryInfo.getMemoryStat("summary.stack")) / 1024;
        StringBuilder sb5 = new StringBuilder(100);
        Map<String, String> memoryStats = memoryInfo.getMemoryStats();
        for (String str : memoryStats.keySet()) {
            if (!w0.c(str) && com.tencent.luggage.wxa.u9.a.a(f142074b, str)) {
                sb5.append(str);
                sb5.append(":");
                String str2 = memoryStats.get(str);
                Objects.requireNonNull(str2);
                sb5.append(w0.f(str2) / 1024);
                sb5.append("m ");
                sb5.append(System.getProperty("line.separator"));
            }
        }
        bVar.f142087k = sb5.toString();
        return bVar;
    }

    public b b() {
        return a(Process.myPid());
    }
}
