package com.tencent.gamecenter.wadl.sdk.downloader.task;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private final String f107455d;

    /* renamed from: e, reason: collision with root package name */
    private final String f107456e;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.gamecenter.wadl.sdk.downloader.task.c f107458g;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f107452a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f107453b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f107454c = new AtomicLong(0);

    /* renamed from: f, reason: collision with root package name */
    private final Map<Long, C1133b> f107457f = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Timer f107459d;

        a(Timer timer) {
            this.f107459d = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (b.this.f107458g == null) {
                return;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[startNextTaskLater->TimerTask], start to create next task+++++");
            b.this.f107458g.a(b.this.a().a());
            this.f107459d.cancel();
            cancel();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.task.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1133b {

        /* renamed from: a, reason: collision with root package name */
        public int f107461a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f107462b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f107463c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f107464d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f107465e;

        /* renamed from: f, reason: collision with root package name */
        public String f107466f;

        public float a() {
            return ((float) (this.f107463c - this.f107462b)) / 1000.0f;
        }

        public float b() {
            float a16 = a();
            if (a16 <= 0.0f) {
                return 0.0f;
            }
            return ((float) ((this.f107464d / 1024) / 1024)) / a16;
        }

        public String toString() {
            return "[" + this.f107466f + "][" + this.f107465e + "]:speed->" + b() + "M/s,downloadedTime->" + a() + "s,totalFlow:" + ((this.f107464d / 1024) / 1024) + "M,netType->" + this.f107461a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f107467a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f107468b = 0;

        /* renamed from: c, reason: collision with root package name */
        public float f107469c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f107470d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f107471e = 0.0f;

        public int a() {
            if (this.f107469c > this.f107470d) {
                return 1;
            }
            return 0;
        }

        public String toString() {
            return " mobileSectionNum:" + this.f107467a + ",avgMobileSpeed:" + this.f107469c + ",wifiSectionNum:" + this.f107468b + ",agvWifiSpeed:" + this.f107470d;
        }
    }

    public b(com.tencent.gamecenter.wadl.sdk.downloader.task.c cVar, String str, String str2) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[FlowRecordHandler], Creator+++++++++");
        this.f107458g = cVar;
        this.f107455d = str;
        this.f107456e = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a() {
        c cVar = new c();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (C1133b c1133b : this.f107457f.values()) {
            int i3 = c1133b.f107461a;
            if (i3 == 0) {
                float b16 = c1133b.b();
                if (b16 > 0.0f) {
                    f17 += b16;
                    cVar.f107468b++;
                }
            } else if (i3 == 1) {
                float b17 = c1133b.b();
                if (b17 > 0.0f) {
                    f16 += b17;
                    cVar.f107467a++;
                }
            }
        }
        int i16 = cVar.f107467a;
        if (i16 > 0) {
            cVar.f107469c = f16 / i16;
        }
        int i17 = cVar.f107468b;
        if (i17 > 0) {
            cVar.f107470d = f17 / i17;
        }
        cVar.f107471e = f16 + f17;
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[getFastestNetType], avgMobileSpeed:" + cVar.f107469c + "M/s,avgWifiSpeed:" + cVar.f107470d + "M/s");
        return cVar;
    }

    private float b() {
        Iterator<C1133b> it = this.f107457f.values().iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            float a16 = it.next().a();
            if (a16 < f16) {
                f16 = a16;
            }
        }
        return f16;
    }

    private void g() {
        if (System.currentTimeMillis() - this.f107454c.get() < 2000) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[startNextTaskLater] begins, name:" + Thread.currentThread().getName());
        float b16 = b();
        int ceil = (int) Math.ceil((double) (4.0f - b16));
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "minTimeSpan:" + b16 + ",leftSecond:" + ceil);
        if (ceil < 0 || ceil > 4) {
            ceil = 4;
        }
        BaseTimer baseTimer = new BaseTimer();
        baseTimer.schedule(new a(baseTimer), ceil * 1000);
        this.f107454c.set(System.currentTimeMillis());
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[startNextTaskLater] ends");
    }

    public int c() {
        if (this.f107452a.compareAndSet(0, 1)) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[getNetTypeDynamically], SECTION_TYPE_MOBILE");
            return 1;
        }
        if (this.f107453b.compareAndSet(0, 1)) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[getNetTypeDynamically], SECTION_TYPE_DEFAULT");
            return 0;
        }
        if (this.f107458g != null) {
            g();
            return -1;
        }
        return -1;
    }

    public void d() {
        a(this.f107456e, this.f107455d, a());
        f();
    }

    public void f() {
        try {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[clearTask]");
            this.f107457f.clear();
            this.f107452a.getAndSet(0);
            this.f107453b.getAndSet(0);
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("FlowRecordHandler", "[onStopDownload], th:" + th5);
        }
    }

    public void a(int i3, int i16, long j3, String str) {
        C1133b c1133b = this.f107457f.get(Long.valueOf(j3));
        if (c1133b == null) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "[onFlowArrived], create FlowRecorder++++, threadID:" + j3 + ",sectionType:" + i16 + ",readLen:" + i3);
            c1133b = new C1133b();
            c1133b.f107465e = j3;
            c1133b.f107466f = str;
            c1133b.f107461a = i16;
            this.f107457f.put(Long.valueOf(j3), c1133b);
        }
        if (c1133b.f107462b == 0) {
            c1133b.f107462b = System.currentTimeMillis();
        }
        c1133b.f107463c = System.currentTimeMillis();
        if (i3 > 0) {
            c1133b.f107464d += i3;
        }
    }

    private static void a(String str, String str2, c cVar) {
        if (cVar == null) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("FlowRecordHandler", "reportOnComplete,id:" + str + ",url:" + str2 + cVar);
        HashMap hashMap = new HashMap();
        hashMap.put("ext11", "1");
        hashMap.put("ext12", WadlProxyConsts.PAGE_ID_DOWNLOAD);
        hashMap.put("oper_module", "9728");
        hashMap.put("ext1", WadlProxyConsts.BUSINESS_ID_DOWNLOAD);
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "990113");
        hashMap.put(WadlReportBuilder.TableElem.GAME_APPID, str);
        hashMap.put("ext15", String.valueOf(cVar.f107467a));
        hashMap.put("ext16", String.valueOf((int) (cVar.f107469c * 1024.0f)));
        hashMap.put("ext17", String.valueOf(cVar.f107468b));
        hashMap.put("ext18", String.valueOf((int) (cVar.f107470d * 1024.0f)));
        hashMap.put(QQLiveReportConstants.AttaColumn.EXT19, String.valueOf((int) cVar.f107471e));
        hashMap.put("ext20", str2);
        a((HashMap<String, String>) hashMap);
    }

    private static void a(HashMap<String, String> hashMap) {
        BaseEvent baseEvent = new BaseEvent("", "", true, hashMap);
        IRReport iRReport = com.tencent.gamecenter.wadl.sdk.common.a.f106990m;
        if (iRReport != null) {
            iRReport.report(baseEvent);
        }
    }

    public void e() {
    }
}
