package com.tencent.av.utils;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import mqq.util.WeakReference;

/* loaded from: classes3.dex */
public class PerfReporter {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f76680a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f76681b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f76682c;

    /* renamed from: d, reason: collision with root package name */
    private static String f76683d;

    /* renamed from: e, reason: collision with root package name */
    private static WeakReference<Context> f76684e;

    /* renamed from: h, reason: collision with root package name */
    private static HandlerThread f76687h;

    /* renamed from: i, reason: collision with root package name */
    private static Handler f76688i;

    /* renamed from: f, reason: collision with root package name */
    private static final a f76685f = new a();

    /* renamed from: g, reason: collision with root package name */
    private static final Vector<Integer> f76686g = new Vector<>(10000);

    /* renamed from: j, reason: collision with root package name */
    private static final Runnable f76689j = new Runnable() { // from class: com.tencent.av.utils.PerfReporter.1
        @Override // java.lang.Runnable
        public void run() {
            if (PerfReporter.f76686g.size() >= PerfReporter.f76686g.capacity()) {
                PerfReporter.f76685f.a(PerfReporter.e(PerfReporter.f76686g));
                PerfReporter.f76686g.clear();
            }
            PerfReporter.f76686g.add(Integer.valueOf(PerfReporter.h()));
            PerfReporter.f76688i.postDelayed(this, 30000L);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private static final Map<String, b> f76690k = new HashMap<String, b>() { // from class: com.tencent.av.utils.PerfReporter.2
        {
            put("prerender_time", new b());
            put("aefilter_time", new b());
            put("postrender_time", new b());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f76691a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f76692b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f76693c = -1;

        /* renamed from: d, reason: collision with root package name */
        public double f76694d = -1.0d;

        /* renamed from: e, reason: collision with root package name */
        public int f76695e = 0;

        a() {
        }

        public void a(a aVar) {
            int min;
            int i3;
            double d16;
            int i16 = aVar.f76691a;
            if (i16 >= 0 && aVar.f76692b >= 0 && aVar.f76693c >= 0 && aVar.f76694d >= 0.0d) {
                int i17 = this.f76695e;
                int i18 = aVar.f76695e;
                int i19 = i17 + i18;
                double d17 = i19;
                double d18 = (i17 * 1.0d) / d17;
                double d19 = (i18 * 1.0d) / d17;
                int i26 = this.f76691a;
                if (i26 >= 0) {
                    i16 = Math.max(i26, i16);
                }
                this.f76691a = i16;
                int i27 = this.f76692b;
                if (i27 < 0) {
                    min = aVar.f76692b;
                } else {
                    min = Math.min(i27, aVar.f76692b);
                }
                this.f76692b = min;
                int i28 = this.f76693c;
                if (i28 < 0) {
                    i3 = aVar.f76693c;
                } else {
                    i3 = (int) ((i28 * d18) + (aVar.f76693c * d19));
                }
                this.f76693c = i3;
                double d26 = this.f76694d;
                if (d26 < 0.0d) {
                    d16 = aVar.f76694d;
                } else {
                    d16 = (d26 * d18) + (aVar.f76694d * d19);
                }
                this.f76694d = d16;
                this.f76695e = i19;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f76696a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Vector<Integer> f76697b = new Vector<>(10000);

        /* renamed from: c, reason: collision with root package name */
        public a f76698c = new a();

        b() {
        }

        public void a() {
            this.f76696a = 0L;
            this.f76697b.clear();
        }

        public String toString() {
            return "DeltaTime{start=" + this.f76696a + ", deltas=" + this.f76697b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a e(Vector<Integer> vector) {
        int max;
        a aVar = new a();
        int size = vector.size();
        if (size > 0) {
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                int intValue = vector.get(i16).intValue();
                i3 += intValue;
                int i17 = aVar.f76691a;
                if (i17 < 0) {
                    max = intValue;
                } else {
                    max = Math.max(i17, intValue);
                }
                aVar.f76691a = max;
                int i18 = aVar.f76692b;
                if (i18 >= 0) {
                    intValue = Math.min(i18, intValue);
                }
                aVar.f76692b = intValue;
            }
            aVar.f76693c = i3 / size;
            double d16 = 0.0d;
            for (int i19 = 0; i19 < size; i19++) {
                int intValue2 = vector.get(i19).intValue();
                int i26 = aVar.f76693c;
                d16 += (intValue2 - i26) * (intValue2 - i26);
            }
            aVar.f76694d = Math.sqrt(d16 / size);
        }
        aVar.f76695e = size;
        return aVar;
    }

    public static Map<String, String> f(SessionInfo sessionInfo) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("app_subversion", f76683d);
        hashMap.put("user_uin", f76682c);
        if (sessionInfo == null) {
            QLog.w("PerfReporter", 2, "createParams with no sessionInfo found");
            str = "no_session";
        } else {
            if (!sessionInfo.M0) {
                if (sessionInfo.N) {
                    if (sessionInfo.O) {
                        str = "video";
                    } else {
                        str = "local video only";
                    }
                } else if (sessionInfo.O) {
                    str = "remote video only";
                }
            }
            str = "audio";
        }
        hashMap.put("call_type", str);
        int i3 = 0;
        while (i3 < 20) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("memory_node_");
            i3++;
            sb5.append(i3);
            hashMap.put(sb5.toString(), "0");
        }
        for (String str2 : f76690k.keySet()) {
            hashMap.put(str2 + "_max", "0");
            hashMap.put(str2 + "_min", "0");
            hashMap.put(str2 + "_avg", "0");
            hashMap.put(str2 + "_variance", "0");
        }
        return hashMap;
    }

    public static void g(String str, int i3) {
        if (!f76681b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = f76690k.get(str);
        if (i3 == 0) {
            bVar.f76696a = currentTimeMillis;
            return;
        }
        if (i3 == 1 && bVar.f76696a != 0) {
            if (bVar.f76697b.size() >= bVar.f76697b.capacity()) {
                bVar.f76698c.a(e(bVar.f76697b));
                bVar.f76697b.clear();
            }
            bVar.f76697b.add(Integer.valueOf((int) (currentTimeMillis - bVar.f76696a)));
            bVar.f76696a = 0L;
        }
    }

    public static int h() {
        long currentTimeMillis = System.currentTimeMillis();
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        try {
            Debug.getMemoryInfo(memoryInfo);
            int totalPss = memoryInfo.getTotalPss() / 1024;
            QLog.d("PerfReporter", 2, "getMemory: " + totalPss + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
            return totalPss;
        } catch (Throwable th5) {
            QLog.w("PerfReporter", 2, "getMemory fail to getProcessMemoryInfo by exception:" + th5.getMessage());
            return -1;
        }
    }

    public static void i(Context context, String str, String str2) {
        QLog.d("PerfReporter", 2, "init");
        if (!ah.a(str)) {
            QLog.d("PerfReporter", 2, "init QAVPerfTestConfig isPerfTestOpen returns false.");
            f76680a = false;
            f76681b = false;
            return;
        }
        f76684e = new WeakReference<>(context);
        f76682c = str;
        f76683d = str2;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("memory_report_handler_thread");
        f76687h = baseHandlerThread;
        baseHandlerThread.start();
        f76688i = new Handler(f76687h.getLooper());
        QQBeaconReport.start();
        f76680a = true;
    }

    public static void j(SessionInfo sessionInfo) {
        if (!f76681b) {
            QLog.w("PerfReporter", 2, "report not started yet:");
            return;
        }
        Map<String, String> f16 = f(sessionInfo);
        a e16 = e(f76686g);
        e16.a(f76685f);
        f16.put("memory_max", String.valueOf(e16.f76691a));
        f16.put("memory_min", String.valueOf(e16.f76692b));
        f16.put("memory_avg", String.valueOf(e16.f76693c));
        f16.put("memory_variance", String.valueOf(e16.f76694d));
        int i3 = 0;
        while (true) {
            Vector<Integer> vector = f76686g;
            if (i3 >= vector.size() || i3 >= 20) {
                break;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("memory_node_");
            int i16 = i3 + 1;
            sb5.append(i16);
            f16.put(sb5.toString(), String.valueOf(vector.get(i3)));
            i3 = i16;
        }
        for (String str : f76690k.keySet()) {
            b bVar = f76690k.get(str);
            a e17 = e(bVar.f76697b);
            e17.a(bVar.f76698c);
            f16.put(str + "_max", String.valueOf(e17.f76691a));
            f16.put(str + "_min", String.valueOf(e17.f76692b));
            f16.put(str + "_avg", String.valueOf(e17.f76693c));
            f16.put(str + "_variance", String.valueOf(e17.f76694d));
        }
        QQBeaconReport.reportWithAppKey("0AND0B5DQ74RHJ2R", f76682c, "av_perf", true, f16, true);
    }

    public static void k() {
        QLog.d("PerfReporter", 2, "start");
        if (f76680a && !f76681b) {
            l();
            f76688i.post(f76689j);
            f76681b = true;
            return;
        }
        QLog.w("PerfReporter", 2, "start not init yet, or already start.");
    }

    public static void l() {
        QLog.d("PerfReporter", 2, "stop");
        if (!f76681b) {
            return;
        }
        f76688i.removeCallbacks(f76689j);
        f76686g.clear();
        Iterator<Map.Entry<String, b>> it = f76690k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        f76681b = false;
    }
}
