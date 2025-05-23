package com.tencent.qmethod.pandoraex.core;

import android.os.SystemClock;
import com.tencent.qmethod.pandoraex.api.p;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonitorReporter {
    private static final String TAG = "MonitorReporter";
    private static final Object lock = new Object();
    private static final HashMap<String, vr3.c> sReportMap = new HashMap<>();
    private static boolean sReporterStarted = false;
    private static final Set<String> highFreqApiSet = new HashSet<String>() { // from class: com.tencent.qmethod.pandoraex.core.MonitorReporter.1
        {
            add("BU#MODEL");
            add("WI#G_SSID");
            add("WI#G_BSSID");
            add("NI#G_TYPE");
            add("WM#G_CON_INFO");
        }
    };
    private static final Runnable sReportCheckRunnable = new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.MonitorReporter.4
        private void a(vr3.c cVar) {
            Iterator<Map.Entry<Integer, vr3.b>> it = cVar.f443277b.entrySet().iterator();
            while (it.hasNext()) {
                MonitorReporter.report(it.next().getValue());
                it.remove();
            }
        }

        private void b(vr3.c cVar) {
            Iterator<Map.Entry<Integer, vr3.b>> it = cVar.f443277b.entrySet().iterator();
            while (it.hasNext()) {
                vr3.b value = it.next().getValue();
                if (value.f443250i > 1) {
                    MonitorReporter.report(value);
                    it.remove();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (MonitorReporter.lock) {
                Iterator it = MonitorReporter.sReportMap.entrySet().iterator();
                while (it.hasNext()) {
                    vr3.c cVar = (vr3.c) ((Map.Entry) it.next()).getValue();
                    int size = cVar.f443277b.size();
                    if (size > 1) {
                        a(cVar);
                    } else if (size == 1) {
                        b(cVar);
                    }
                }
            }
            x.j(MonitorReporter.sReportCheckRunnable, MiniBoxNoticeInfo.MIN_5);
        }
    };

    private static com.tencent.qmethod.pandoraex.api.d getRealStrategyByReportItem(vr3.b bVar) {
        if (bVar == null) {
            return new com.tencent.qmethod.pandoraex.api.d("normal", true, 0L, "", bVar.f443249h);
        }
        return new com.tencent.qmethod.pandoraex.api.d(bVar.f443245d, bVar.f443246e, bVar.f443251j, bVar.f443244c, bVar.f443249h);
    }

    private static vr3.b getReportItem(String str, String str2, vr3.a aVar, HashMap<String, String> hashMap) {
        vr3.b k3 = x.k(str, str2, aVar, hashMap);
        vr3.b L = x.L(k3, handleSplitGranterControl(k3, x.i(aVar, k3, x.s(k3))), aVar, hashMap);
        if (x.x(L.f443245d) && d.b(str2)) {
            if (com.tencent.qmethod.pandoraex.api.q.m()) {
                o.e(TAG, "netChange toSysCall");
            }
            L.f443246e = true;
        }
        L.f443263v = p.a();
        L.f443258q.put("ShiplyKey", v.b(SystemClock.elapsedRealtime()));
        L.f443259r = com.tencent.qmethod.pandoraex.api.q.n();
        return L;
    }

    public static com.tencent.qmethod.pandoraex.api.d getStrategyAndReport(String str, String str2, vr3.a aVar, HashMap<String, String> hashMap) {
        boolean z16;
        vr3.b reportItem = getReportItem(str, str2, aVar, hashMap);
        if (reportItem != null && reportItem.f443249h) {
            if (reportItem.d()) {
                reportItem.f443254m = c.b();
            }
            reportItem(reportItem);
        }
        if (!reportItem.f443249h && !(z16 = com.tencent.qmethod.pandoraex.api.q.f343925a)) {
            if ((z16 || com.tencent.qmethod.pandoraex.api.q.m()) && isHighFreqCanLog(reportItem)) {
                o.a(TAG, "module[" + reportItem.f443242a + "], systemApi[" + reportItem.f443243b + "], scene[" + reportItem.f443244c + "], strategy[" + reportItem.f443245d + "], isSystemCall[" + reportItem.f443246e);
            }
        } else {
            o.e(TAG, "=====>report:" + reportItem);
        }
        com.tencent.qmethod.pandoraex.api.d realStrategyByReportItem = getRealStrategyByReportItem(reportItem);
        boolean z17 = com.tencent.qmethod.pandoraex.api.q.f343925a;
        return realStrategyByReportItem;
    }

    public static void handleEventReport(String str, String str2) {
        com.tencent.qmethod.pandoraex.api.k g16 = com.tencent.qmethod.pandoraex.api.q.g();
        if (g16 == null) {
            return;
        }
        g16.a(new p.a().c(str).b(str2).a());
    }

    private static com.tencent.qmethod.pandoraex.api.v handleSplitGranterControl(vr3.b bVar, com.tencent.qmethod.pandoraex.api.v vVar) {
        if (bVar.e()) {
            int i3 = bVar.f443261t;
            if (i3 == 2) {
                vVar.f343991b = "ban";
                return vVar;
            }
            if (i3 == 1) {
                if (bVar.d() && !"ban".equals(vVar.f343991b) && !"cache_only".equals(vVar.f343991b)) {
                    vVar.f343991b = "ban";
                    return vVar;
                }
                return vVar;
            }
            if (bVar.d()) {
                return x.m(bVar.f443242a, bVar.f443243b, bVar.f443256o, "normal");
            }
            return vVar;
        }
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleUnRealtimeReport(vr3.b bVar) {
        synchronized (lock) {
            HashMap<String, vr3.c> hashMap = sReportMap;
            vr3.c cVar = hashMap.get(bVar.f443242a);
            if (cVar == null) {
                cVar = new vr3.c();
                String str = bVar.f443242a;
                cVar.f443276a = str;
                hashMap.put(str, cVar);
            }
            Integer valueOf = Integer.valueOf((bVar.f443257p.get(0).f343962b + bVar.f443244c + bVar.f443245d + x.a(bVar.f443246e)).hashCode());
            vr3.b bVar2 = cVar.f443277b.get(valueOf);
            if (bVar2 == null) {
                cVar.f443277b.put(valueOf, bVar);
            } else {
                bVar2.f443250i++;
            }
            if (!sReporterStarted) {
                sReporterStarted = true;
                x.j(sReportCheckRunnable, MiniBoxNoticeInfo.MIN_5);
            }
        }
    }

    private static boolean isHighFreqCanLog(vr3.b bVar) {
        if (!highFreqApiSet.contains(bVar.f443243b) || new Random().nextInt(100) < 1) {
            return true;
        }
        return false;
    }

    public static void report(vr3.b bVar) {
        if (com.tencent.qmethod.pandoraex.api.q.j() == null) {
            return;
        }
        reportStrategy(x.l(bVar));
    }

    private static void reportItem(final vr3.b bVar) {
        com.tencent.qmethod.pandoraex.api.b n3 = x.n(bVar.f443242a, bVar.f443243b, bVar.f443256o);
        if (!com.tencent.qmethod.pandoraex.api.q.i() && (n3 == null || !n3.f343884g)) {
            x.j(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.MonitorReporter.3
                @Override // java.lang.Runnable
                public void run() {
                    MonitorReporter.handleUnRealtimeReport(vr3.b.this);
                }
            }, 0L);
        } else {
            x.j(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.MonitorReporter.2
                @Override // java.lang.Runnable
                public void run() {
                    MonitorReporter.report(vr3.b.this);
                }
            }, 0L);
        }
    }

    public static void reportStrategy(com.tencent.qmethod.pandoraex.api.u uVar) {
        com.tencent.qmethod.pandoraex.api.n j3 = com.tencent.qmethod.pandoraex.api.q.j();
        if (j3 == null) {
            return;
        }
        j3.a(uVar);
    }
}
