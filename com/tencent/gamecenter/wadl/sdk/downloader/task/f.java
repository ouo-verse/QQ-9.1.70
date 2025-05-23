package com.tencent.gamecenter.wadl.sdk.downloader.task;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gamecenter.wadl.sdk.common.DownloaderException;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskCategory;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskPriority;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskStatus;
import com.tencent.gamecenter.wadl.sdk.downloader.IFlowCallback;
import com.tencent.gamecenter.wadl.sdk.downloader.manager.MultiThreadManager;
import com.tencent.gamecenter.wadl.sdk.downloader.manager.TaskManager;
import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.PCDNInitParam;
import com.tencent.gamecenter.wadl.sdk.downloader.task.d;
import com.tencent.gamecenter.wadl.sdk.downloader.task.h.a;
import com.tencent.gamecenter.wadl.sdk.downloader.task.j.a;
import com.tencent.gamecenter.wadl.sdk.downloader.task.k.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f implements Runnable, DownloaderTask, com.tencent.gamecenter.wadl.sdk.downloader.task.h.c, Comparable<f>, com.tencent.gamecenter.wadl.sdk.downloader.c.a {
    private RandomAccessFile A;
    private volatile boolean B;
    private d C;
    private boolean D;
    private com.tencent.gamecenter.wadl.sdk.downloader.task.a E;
    private int F;
    private AtomicInteger G;
    private Object H;
    private volatile boolean I;
    private Object J;
    private boolean K;
    private final b L;
    private com.tencent.gamecenter.wadl.sdk.downloader.task.j.a M;
    public int N;
    private com.tencent.gamecenter.wadl.sdk.common.b.e O;
    private long P;
    private String Q;
    public volatile HashMap<String, Long> R;
    private List<com.tencent.gamecenter.wadl.sdk.downloader.c.b> S;
    private Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, com.tencent.gamecenter.wadl.sdk.downloader.c.b> T;
    private Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, List<String>> U;
    private volatile long V;
    private AtomicInteger W;
    private AtomicInteger X;
    private Object Y;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    public DownloaderTaskAttr f107499a;

    /* renamed from: a0, reason: collision with root package name */
    private long f107500a0;

    /* renamed from: b, reason: collision with root package name */
    public String f107501b;

    /* renamed from: b0, reason: collision with root package name */
    private long f107502b0;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.task.k.b f107503c;

    /* renamed from: c0, reason: collision with root package name */
    private int f107504c0;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f107505d;

    /* renamed from: e, reason: collision with root package name */
    public long f107506e;

    /* renamed from: f, reason: collision with root package name */
    public volatile long f107507f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f107508g;

    /* renamed from: h, reason: collision with root package name */
    public String f107509h;

    /* renamed from: i, reason: collision with root package name */
    public String f107510i;

    /* renamed from: j, reason: collision with root package name */
    public String f107511j;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f107512k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f107513l;

    /* renamed from: m, reason: collision with root package name */
    public String f107514m;

    /* renamed from: n, reason: collision with root package name */
    public String f107515n;

    /* renamed from: o, reason: collision with root package name */
    public String f107516o;

    /* renamed from: p, reason: collision with root package name */
    public volatile int f107517p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f107518q;

    /* renamed from: r, reason: collision with root package name */
    public volatile int f107519r;

    /* renamed from: s, reason: collision with root package name */
    public String f107520s;

    /* renamed from: t, reason: collision with root package name */
    public long f107521t;

    /* renamed from: u, reason: collision with root package name */
    public long f107522u;

    /* renamed from: v, reason: collision with root package name */
    private e f107523v;

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.task.h.a f107524w;

    /* renamed from: x, reason: collision with root package name */
    private File f107525x;

    /* renamed from: y, reason: collision with root package name */
    private RandomAccessFile f107526y;

    /* renamed from: z, reason: collision with root package name */
    private File f107527z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.resume();
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "checkIfResumeWhenReceiveStandStill lastReceivedLen over time, resume failed.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements com.tencent.gamecenter.wadl.sdk.downloader.task.i.b, c {

        /* renamed from: b, reason: collision with root package name */
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.d f107530b;

        /* renamed from: c, reason: collision with root package name */
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.d f107531c;

        /* renamed from: f, reason: collision with root package name */
        private long f107534f;

        /* renamed from: n, reason: collision with root package name */
        private int f107542n;

        /* renamed from: a, reason: collision with root package name */
        private byte[] f107529a = new byte[0];

        /* renamed from: d, reason: collision with root package name */
        final ArrayList<com.tencent.gamecenter.wadl.sdk.downloader.task.i.d> f107532d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private volatile AtomicInteger f107533e = new AtomicInteger();

        /* renamed from: g, reason: collision with root package name */
        private long f107535g = 0;

        /* renamed from: h, reason: collision with root package name */
        private long f107536h = 0;

        /* renamed from: i, reason: collision with root package name */
        private long f107537i = 0;

        /* renamed from: j, reason: collision with root package name */
        private long f107538j = 0;

        /* renamed from: k, reason: collision with root package name */
        private long f107539k = 0;

        /* renamed from: l, reason: collision with root package name */
        private long f107540l = 0;

        /* renamed from: m, reason: collision with root package name */
        private com.tencent.gamecenter.wadl.sdk.downloader.task.b f107541m = null;

        public b() {
            this.f107542n = 5000;
            IFlowCallback iFlowCallback = com.tencent.gamecenter.wadl.sdk.common.a.f106994q;
            if (iFlowCallback != null) {
                this.f107542n = iFlowCallback.getIntervalTime();
            }
        }

        private com.tencent.gamecenter.wadl.sdk.downloader.task.i.d b(boolean z16, int i3) {
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar = f.this.f107503c;
            f fVar = f.this;
            com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.i.d(i3, bVar, z16, this, fVar.f107505d, fVar.f107499a, fVar.getId());
            List<com.tencent.gamecenter.wadl.sdk.downloader.c.b> list = f.this.S;
            Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, com.tencent.gamecenter.wadl.sdk.downloader.c.b> map = f.this.T;
            Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, List<String>> map2 = f.this.U;
            f fVar2 = f.this;
            dVar.a(list, map, map2, fVar2, fVar2.W, f.this.X, f.this.f107502b0);
            return dVar;
        }

        private void c(int i3, int i16, boolean z16) {
            com.tencent.gamecenter.wadl.sdk.downloader.task.b bVar = this.f107541m;
            if (bVar != null) {
                bVar.a(i3, i16, Thread.currentThread().getId(), Thread.currentThread().getName());
            }
            if (com.tencent.gamecenter.wadl.sdk.common.a.f106994q == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f107534f == 0) {
                this.f107534f = currentTimeMillis;
            }
            synchronized (this.f107529a) {
                long j3 = currentTimeMillis - this.f107534f;
                if (i16 == 1) {
                    long j16 = i3;
                    this.f107537i += j16;
                    this.f107539k += j16;
                } else if (i16 == 2) {
                    this.f107538j += i3;
                } else {
                    long j17 = i3;
                    this.f107536h += j17;
                    this.f107540l += j17;
                }
                long j18 = this.f107535g + i3;
                this.f107535g = j18;
                if (this.f107542n < 5000) {
                    this.f107542n = 5000;
                }
                if ((j3 >= this.f107542n || z16) && j18 > 0) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "callbackFlow, totalMobileLen:" + this.f107539k + ",totalDefLen:" + this.f107540l + ",threadID:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName());
                    com.tencent.gamecenter.wadl.sdk.common.a.f106994q.onFlow(com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(), f.this.getId(), j3, this.f107535g, this.f107536h, this.f107537i, this.f107538j);
                    this.f107542n = com.tencent.gamecenter.wadl.sdk.common.a.f106994q.getIntervalTime();
                    this.f107534f = currentTimeMillis;
                    this.f107535g = 0L;
                    this.f107536h = 0L;
                    this.f107537i = 0L;
                    this.f107538j = 0L;
                }
                if (z16) {
                    this.f107534f = 0L;
                }
            }
        }

        private void d(long j3, com.tencent.gamecenter.wadl.sdk.common.e.e eVar) {
            eVar.f107237a = -10;
            eVar.f107238b = "knownSize:" + f.this.f107506e + ",rspLength:" + j3;
        }

        private void e(com.tencent.gamecenter.wadl.sdk.common.e.e eVar) {
            eVar.f107237a = 1;
            eVar.f107238b = "not support range";
        }

        private void f(com.tencent.gamecenter.wadl.sdk.common.e.e eVar, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, String str) {
            if (eVar.f107237a == 0 && !TextUtils.isEmpty(str)) {
                a.EnumC1136a enumC1136a = aVar.f107609b;
                if (enumC1136a != a.EnumC1136a.Type_CDN_Domain && enumC1136a != a.EnumC1136a.Type_Outer) {
                    if (enumC1136a == a.EnumC1136a.Type_Src_Domain) {
                        f.this.f107503c.c(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), str);
                        return;
                    }
                    return;
                }
                f.this.f107503c.b(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), str);
            }
        }

        private void g(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar, com.tencent.gamecenter.wadl.sdk.downloader.a.e.e eVar, com.tencent.gamecenter.wadl.sdk.common.e.e eVar2) {
            boolean z16;
            f.this.f107507f = eVar.f107304a;
            f.this.f107513l = eVar.f107309f;
            f fVar = f.this;
            fVar.f107514m = eVar.f107305b;
            fVar.f107515n = eVar.f107306c;
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = dVar.f107587i;
            if (aVar != null) {
                fVar.N = aVar.f107610c;
            }
            if (!fVar.f107513l) {
                f.this.f107523v = new e("");
                dVar.f107586h = f.this.f107523v.f();
            } else if (f.this.f107523v.f107488a > 0) {
                if (f.this.f107523v.f107488a != f.this.f107507f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    f.this.f107523v = new e("");
                    eVar2.f107237a = 3;
                    eVar2.f107238b = "can not resume from cfg, start over now";
                }
            }
            f.this.f107523v.f107488a = eVar.f107304a;
            f.this.f107523v.a(eVar.f107307d);
            f.this.f107523v.b(eVar.f107308e);
            com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 = dVar.f107586h;
            if (aVar2.f107559c == -1 && aVar2.f107558b == -1 && !Thread.currentThread().getName().contains("GameDownload-SchedulePool")) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "-----------SchedulePool NOT add first section-------------");
                f.this.f107523v.a(dVar.f107586h);
            }
        }

        private void h(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, com.tencent.gamecenter.wadl.sdk.downloader.a.e.e eVar, com.tencent.gamecenter.wadl.sdk.common.e.e eVar2) {
            f fVar = f.this;
            if (!fVar.f107499a.multiSection) {
                long j3 = fVar.f107506e;
                if (j3 > 0) {
                    long j16 = eVar.f107304a;
                    if (j16 != j3) {
                        d(j16, eVar2);
                    }
                }
                g(dVar, eVar, eVar2);
            } else {
                if (fVar.V != -1 && eVar.f107304a != f.this.V) {
                    if (f.this.f107503c.f() > 0) {
                        k(aVar, eVar.f107304a, eVar2);
                    } else {
                        d(eVar.f107304a, eVar2);
                    }
                }
                g(dVar, eVar, eVar2);
            }
            if (eVar2.f107237a == 0) {
                if (!f.this.K && !f.this.r()) {
                    f fVar2 = f.this;
                    fVar2.a(false, fVar2.f107519r, f.this.f107520s, DownloaderTaskStatus.FAILED);
                }
                f.this.C.a(d.b.INFORM_DETECTED_SIZE);
            }
        }

        private void i(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, long j3, com.tencent.gamecenter.wadl.sdk.common.e.e eVar) {
            if (f.this.f107503c.f() > 0) {
                k(aVar, j3, eVar);
                return;
            }
            if (f.this.f107506e > 0) {
                d(j3, eVar);
                return;
            }
            eVar.f107237a = -43;
            eVar.f107238b = "detectLength:" + f.this.f107507f + ",rspLength:" + j3;
        }

        private void k(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, long j3, com.tencent.gamecenter.wadl.sdk.common.e.e eVar) {
            StringBuilder sb5;
            if (aVar.f107609b == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https) {
                eVar.f107237a = -76;
                sb5 = new StringBuilder();
            } else {
                eVar.f107237a = -73;
                sb5 = new StringBuilder();
            }
            sb5.append("sche size:");
            sb5.append(f.this.f107503c.f());
            sb5.append(",rsp size:");
            sb5.append(j3);
            eVar.f107238b = sb5.toString();
        }

        private int l() {
            int i3;
            int i16;
            int i17;
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "[getNextSectionType]");
            if (!f.this.f107499a.validSectionPercent()) {
                return 0;
            }
            synchronized (this.f107532d) {
                Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.d> it = this.f107532d.iterator();
                i3 = 0;
                i16 = 0;
                i17 = 0;
                while (it.hasNext()) {
                    int j3 = it.next().j();
                    if (j3 == 1) {
                        i3++;
                    } else if (j3 == 2) {
                        i17++;
                    } else {
                        i16++;
                    }
                }
            }
            int e16 = com.tencent.gamecenter.wadl.sdk.common.a.e();
            DownloaderTaskAttr downloaderTaskAttr = f.this.f107499a;
            float f16 = e16;
            int i18 = (int) ((downloaderTaskAttr.sectionMobilePercent / 100.0f) * f16);
            int i19 = (int) ((downloaderTaskAttr.sectionDefPercent / 100.0f) * f16);
            int i26 = (int) ((downloaderTaskAttr.sectionP2PPercent / 100.0f) * f16);
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "maxMobileCount:" + i18 + ",maxWiFiCount:" + i19 + ",sectionMobileCount:" + i3 + ",sectionDefCount:" + i16);
            boolean d16 = com.tencent.gamecenter.wadl.sdk.downloader.manager.b.c().d();
            if (!d16) {
                i18 = 0;
            }
            if (i3 < i18) {
                return 1;
            }
            if (i16 < i19) {
                return 0;
            }
            if (i17 < i26) {
                return 2;
            }
            if (!d16) {
                return 0;
            }
            return 1;
        }

        private int m() {
            com.tencent.gamecenter.wadl.sdk.downloader.task.b bVar = this.f107541m;
            if (bVar != null) {
                return bVar.c();
            }
            return l();
        }

        private void n(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar) {
            if (dVar.l() && !dVar.q()) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "handleMultiThreadDownload false");
            } else if (f.this.getTotalLength() > MultiThreadManager.getInstance().getMultiThreadDownFileSize()) {
                r();
            }
        }

        private boolean p(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar) {
            if (dVar != null) {
                if (dVar == this.f107530b || dVar == this.f107531c || this.f107532d.contains(dVar)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        private void r() {
            String str;
            if (f.this.f107499a.multiSection) {
                int e16 = com.tencent.gamecenter.wadl.sdk.common.a.e();
                if (this.f107533e.get() >= e16) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "startMultiThreadDownload is limit, mThreadCount:" + this.f107533e + ",core_num:" + e16);
                    return;
                }
                int m3 = m();
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "sectionType:" + m3);
                if (m3 < 0) {
                    return;
                }
                a(m3);
                str = "startMultiThreadDownload sectionType=" + m3 + ", mThreadCount: " + this.f107533e.get() + ",maxThreadNum=" + com.tencent.gamecenter.wadl.sdk.common.a.e();
            } else {
                str = "startMultiThreadDownload is not multiSection";
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", str);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.i.b
        public synchronized com.tencent.gamecenter.wadl.sdk.common.e.e a(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, String str, com.tencent.gamecenter.wadl.sdk.downloader.a.e.e eVar) {
            if (p(dVar) && !dVar.s() && eVar.f107304a > 0) {
                com.tencent.gamecenter.wadl.sdk.common.e.e eVar2 = new com.tencent.gamecenter.wadl.sdk.common.e.e(0, "");
                if (f.this.f107523v != null && f.this.f107523v.c(dVar.f107586h)) {
                    if (f.this.f107507f == -1) {
                        h(dVar, aVar, eVar, eVar2);
                    } else if (eVar.f107304a != f.this.f107507f) {
                        i(aVar, eVar.f107304a, eVar2);
                    } else if (!f.this.f107513l) {
                        e(eVar2);
                    }
                    f(eVar2, aVar, str);
                    return eVar2;
                }
                eVar2.f107237a = 2;
                eVar2.f107238b = "not the same divider";
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "onValidResponse... fail...not self section:" + dVar.f107586h);
                return eVar2;
            }
            return new com.tencent.gamecenter.wadl.sdk.common.e.e(4, "");
        }

        public void j() {
            this.f107530b = null;
            this.f107531c = null;
            synchronized (this.f107532d) {
                if (this.f107532d.size() > 0) {
                    this.f107532d.clear();
                }
                this.f107533e.set(0);
            }
        }

        public void o() {
            try {
                if (this.f107532d.size() > 0) {
                    synchronized (this.f107532d) {
                        Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.d> it = this.f107532d.iterator();
                        while (it.hasNext()) {
                            it.next().w();
                        }
                    }
                }
                com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b.a(f.this.getId(), f.this.f107503c.f107627a.f107608a, f.this.getAverageSpeed());
                com.tencent.gamecenter.wadl.sdk.downloader.task.b bVar = this.f107541m;
                if (bVar != null) {
                    bVar.d();
                }
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", th5.toString());
            }
        }

        public synchronized com.tencent.gamecenter.wadl.sdk.common.e.e q() {
            com.tencent.gamecenter.wadl.sdk.common.e.e eVar;
            if (com.tencent.gamecenter.wadl.sdk.downloader.manager.b.c().d()) {
                f fVar = f.this;
                if (fVar.f107499a.useDynamicSection) {
                    this.f107541m = new com.tencent.gamecenter.wadl.sdk.downloader.task.b(this, fVar.getUrl(), f.this.getId());
                }
            }
            this.f107540l = 0L;
            this.f107539k = 0L;
            f.this.f107502b0 = SystemClock.elapsedRealtime();
            eVar = new com.tencent.gamecenter.wadl.sdk.common.e.e(0, "");
            this.f107530b = b(true, m());
            try {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "startDownload excuteDirectDownload");
                com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().a(this.f107530b);
            } catch (Exception e16) {
                this.f107530b = null;
                eVar.f107237a = -67;
                eVar.f107238b = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a((Throwable) e16);
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "startDownload excuteDirectDownload exception", e16);
            }
            if (eVar.f107237a == 0 && !f.this.isEaseTask()) {
                this.f107531c = b(false, m());
                try {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "startDownload excuteScheduleDownload");
                    com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().c(this.f107531c);
                } catch (Exception e17) {
                    this.f107531c = null;
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "startDownload excuteScheduleDownload exception", e17);
                }
            }
            com.tencent.gamecenter.wadl.sdk.downloader.task.b bVar = this.f107541m;
            if (bVar != null) {
                bVar.e();
            }
            return eVar;
        }

        public void s() {
            try {
                com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar = this.f107530b;
                if (dVar != null) {
                    dVar.d();
                }
                com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar2 = this.f107531c;
                if (dVar2 != null) {
                    dVar2.d();
                }
                if (this.f107532d.size() > 0) {
                    synchronized (this.f107532d) {
                        Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.d> it = this.f107532d.iterator();
                        while (it.hasNext()) {
                            it.next().d();
                        }
                    }
                }
                com.tencent.gamecenter.wadl.sdk.downloader.task.b bVar = this.f107541m;
                if (bVar != null) {
                    bVar.f();
                }
                c(0, 0, true);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.c
        public void a(int i3) {
            Log.i("Wadl-downloader-TaskImpl", "=====================createNextTask++++++++++++ sectionType:" + i3);
            int e16 = com.tencent.gamecenter.wadl.sdk.common.a.e();
            if (this.f107533e.get() >= e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "createNextTask->startMultiThreadDownload is limit, mThreadCount:" + this.f107533e + ",core_num:" + e16);
                return;
            }
            com.tencent.gamecenter.wadl.sdk.downloader.task.i.d b16 = b(false, i3);
            b16.d(true);
            try {
                Log.i("Wadl-downloader-TaskImpl", "[before] mThreadCount:" + this.f107533e.get() + ",transportList.size:" + this.f107532d.size());
                com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().c(b16);
                synchronized (this.f107532d) {
                    this.f107532d.add(b16);
                    this.f107533e.getAndIncrement();
                }
                Log.i("Wadl-downloader-TaskImpl", "[after] mThreadCount:" + this.f107533e.get() + ",transportList.size:" + this.f107532d.size());
            } catch (Exception e17) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "startMultiThreadDownload exception", e17);
            }
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.i.b
        public void b(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar) {
            if (p(dVar) && dVar.f107586h != null) {
                f.this.f107523v.d(dVar.f107586h);
            }
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.i.b
        public com.tencent.gamecenter.wadl.sdk.downloader.task.i.a c(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar) {
            if (p(dVar) && f.this.f107513l) {
                return f.this.f107523v.f();
            }
            return null;
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.i.b
        public void a(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar) {
            boolean z16;
            com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar2;
            if (p(dVar)) {
                synchronized (f.this.L) {
                    com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar3 = this.f107530b;
                    if ((dVar3 == null || dVar3.n()) && (!f.this.f107499a.multiSection || (dVar2 = this.f107531c) == null || dVar2.n())) {
                        if (this.f107532d.size() > 0) {
                            synchronized (this.f107532d) {
                                Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.d> it = this.f107532d.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z16 = true;
                                        break;
                                    } else if (!it.next().n()) {
                                        z16 = false;
                                        break;
                                    }
                                }
                            }
                        } else {
                            z16 = true;
                        }
                    }
                    z16 = false;
                }
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "onTransportFinished allTransportFinished:" + z16);
                if (z16) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "onTransportFinished allTransportFinished uniqueKey:" + f.this.getUniqueKey());
                    c(0, dVar.j(), true);
                    if (f.this.B) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "onTransportFinished allTransportFinished isStop");
                        return;
                    }
                    if (f.this.f107523v.k()) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "onTransportFinished allTransportFinished isReadFinish");
                        return;
                    }
                    f.this.f107519r = dVar.i();
                    f.this.f107520s = dVar.g();
                    if (f.this.f107519r == 0) {
                        f.this.f107519r = -69;
                        f.this.f107520s = "readLen:" + f.this.f107523v.g();
                    }
                    f.this.C.b(DownloaderTaskStatus.FAILED);
                }
            }
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.i.b
        public boolean a() {
            return f.this.f107507f != -1;
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.i.b
        public boolean a(com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar, long j3, byte[] bArr, int i3, boolean z16) {
            if (!p(dVar)) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "onSectionReceiveData isRightTransport false");
                return false;
            }
            c(i3, dVar.j(), false);
            if (f.this.f107523v == null || !f.this.f107523v.c(dVar.f107586h)) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "onSectionReceiveData taskDivider invalid");
                return false;
            }
            if (z16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "onSectionReceiveData isFirstData is Direct:" + dVar.l() + " section:" + dVar.f107586h);
                com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar = dVar.f107586h;
                if (aVar.f107558b == -1) {
                    boolean a16 = f.this.f107523v.a(dVar.f107586h);
                    if (MultiThreadManager.getInstance().isMultiTheadDownOpen()) {
                        n(dVar);
                    }
                    if (!a16) {
                        return false;
                    }
                } else if (aVar.f107565i && MultiThreadManager.getInstance().isMultiTheadDownOpen()) {
                    n(dVar);
                }
            }
            if (i3 > 0 && !f.this.isPaused()) {
                try {
                    long j16 = i3;
                    f.this.f107524w.a(dVar.f107586h.f107558b, j3, bArr, j16);
                    dVar.f107586h.f107562f += j16;
                    if (f.this.f107523v.k()) {
                        f.this.E.b();
                        TaskManager.getInstance().wakeSaveService();
                    }
                    if (TaskManager.getInstance().isBufferFull()) {
                        TaskManager.getInstance().wakeSaveService();
                        com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "onRangeReceiveData... _dataBuffer too large, task:" + f.this.f107516o + ", try wait...");
                        try {
                            f.this.I = true;
                            synchronized (f.this.H) {
                                f.this.H.wait(2000L);
                            }
                        } catch (Exception unused) {
                        }
                    }
                } catch (OutOfMemoryError unused2) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "onSectionReceiveData OutOfMemoryError");
                    f.this.a(false, -19, "append size:" + i3 + ",buffer size:" + TaskManager.getInstance().getRunningBufferSize(), DownloaderTaskStatus.FAILED);
                    return false;
                }
            }
            return true;
        }
    }

    public f(com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar, String str, String str2, long j3) {
        this.f107499a = DownloaderTaskAttr.DEFAULT_TASK_ATTR;
        this.f107501b = "";
        this.f107505d = new HashMap();
        this.f107506e = -1L;
        this.f107507f = -1L;
        this.f107508g = 0L;
        this.f107509h = "";
        this.f107510i = "";
        this.f107511j = "";
        this.f107512k = 0L;
        this.f107513l = true;
        this.f107514m = "";
        this.f107515n = "";
        this.f107516o = null;
        this.f107517p = 0;
        this.f107518q = false;
        this.f107519r = 0;
        this.f107520s = "";
        this.f107521t = -1L;
        this.f107522u = -1L;
        this.B = false;
        this.C = new d(this);
        this.D = false;
        this.F = 0;
        this.G = new AtomicInteger(0);
        this.H = new Object();
        this.I = false;
        this.K = false;
        this.L = new b();
        this.P = 0L;
        this.Q = "";
        this.R = new LinkedHashMap();
        this.S = Collections.synchronizedList(new ArrayList());
        this.T = new ConcurrentHashMap();
        this.U = new ConcurrentHashMap();
        this.V = -1L;
        this.W = new AtomicInteger(0);
        this.X = new AtomicInteger(0);
        this.Y = new Object();
        this.Z = 0L;
        this.f107500a0 = 0L;
        this.f107502b0 = 0L;
        this.f107504c0 = -1;
        this.f107503c = bVar;
        this.f107509h = str;
        this.f107510i = str2;
        this.f107506e = j3 <= 0 ? -1L : j3;
        this.f107516o = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(bVar.f107627a.f107608a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0090, code lost:
    
        a(false, -42, a(r6, r5), com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskStatus.FAILED);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (SystemClock.elapsedRealtime() - elapsedRealtime > com.tencent.gamecenter.wadl.sdk.downloader.a.a.f107278c) {
                this.G.getAndIncrement();
                z16 = true;
                break;
            }
            synchronized (this.Y) {
                a.C1134a c16 = this.f107524w.c();
                if (c16 == null) {
                    break;
                }
                com.tencent.gamecenter.wadl.sdk.downloader.task.i.a a16 = this.f107523v.a(c16.f107547a);
                if (a16 == null || a16.f107561e != c16.f107548b) {
                    break;
                }
                if (!a(c16)) {
                    break;
                }
                a16.f107561e = c16.f107548b + c16.f107550d;
                i3 = (int) (i3 + c16.f107550d);
                c16.f107549c = null;
                if (this.I && TaskManager.getInstance().isBufferCanAdd()) {
                    B();
                }
            }
        }
        if (!z16) {
            B();
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        com.tencent.gamecenter.wadl.sdk.downloader.task.a aVar = this.E;
        if (aVar != null) {
            aVar.a(i3, (int) (elapsedRealtime2 - elapsedRealtime));
        }
        if (i3 > 0) {
            z();
        }
        if (!v()) {
            h();
        } else if (this.f107507f > 0) {
            a(elapsedRealtime2, i3);
        }
        return z16;
    }

    private void B() {
        try {
            synchronized (this.H) {
                this.H.notifyAll();
                this.I = false;
            }
        } catch (Exception unused) {
        }
    }

    private int a(Exception exc) {
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(exc)) {
            return -12;
        }
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.c(exc)) {
            return -13;
        }
        return com.tencent.gamecenter.wadl.sdk.downloader.a.c.b(exc) ? -78 : -49;
    }

    private int b(Exception exc) {
        if (!this.f107525x.exists()) {
            return -14;
        }
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(exc)) {
            return -12;
        }
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.c(exc)) {
            return -17;
        }
        return com.tencent.gamecenter.wadl.sdk.downloader.a.c.b(exc) ? -78 : -50;
    }

    private void c() {
        b();
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar = this.L.f107530b;
        if (dVar != null) {
            dVar.a(false);
        }
        com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar2 = this.L.f107531c;
        if (dVar2 != null) {
            dVar2.a(false);
        }
        if (this.L.f107532d.size() > 0) {
            synchronized (this.L.f107532d) {
                Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.i.d> it = this.L.f107532d.iterator();
                while (it.hasNext()) {
                    it.next().a(false);
                }
            }
        }
    }

    private int q() {
        int p16;
        if (com.tencent.gamecenter.wadl.sdk.common.b.c.d() != 1) {
            return 20971520;
        }
        if (p() <= 0 || (p16 = (int) (p() * 0.2d)) <= 41943040) {
            return 41943040;
        }
        return p16;
    }

    private boolean s() {
        String str;
        boolean z16;
        boolean z17;
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initFileOnStart...begin");
        e eVar = this.f107523v;
        boolean z18 = false;
        if (eVar != null) {
            if (eVar.h() > 0 && !TextUtils.isEmpty(this.f107511j)) {
                str = this.f107511j;
                z17 = true;
                z16 = false;
            }
            str = "";
            z17 = false;
            z16 = false;
        } else {
            if (!com.tencent.gamecenter.wadl.sdk.common.e.g.e(this.f107510i)) {
                str = this.f107510i;
                z16 = true;
                z17 = false;
            }
            str = "";
            z17 = false;
            z16 = false;
        }
        a(str);
        if (this.f107525x.exists() && (z17 || z16)) {
            if (!t()) {
                return false;
            }
            String w3 = w();
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initFileOnStart...readCfg:" + w3);
            this.f107523v = new e(w3);
            z18 = a(w3, z16, z17);
            if (z18) {
                if (TextUtils.isEmpty(this.f107511j)) {
                    this.f107511j = this.f107510i;
                }
                this.f107512k = this.f107523v.f107490c;
                if (z16) {
                    long j3 = this.f107523v.f107488a;
                }
            }
        }
        if (!z18) {
            h();
            e();
        }
        this.K = z18;
        return true;
    }

    private boolean t() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initRandomAccessFile create RandomAccessFile");
        try {
            this.A = new g(this.f107527z, "rw");
            this.f107526y = new g(this.f107525x, "rw");
            return true;
        } catch (Exception e16) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initRandomAccessFile...create RandomAccessFile failed.", e16);
            this.f107519r = a(e16);
            this.f107520s = "initRandomAccessFile,new RAF:" + this.f107525x.getAbsolutePath() + ":" + com.tencent.gamecenter.wadl.sdk.downloader.a.c.a((Throwable) e16);
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "initRandomAccessFile...Exception, ret=" + this.f107519r + ",failInfo=" + this.f107520s);
            h();
            return false;
        }
    }

    private boolean v() {
        if (!this.B && !isPaused() && !isDeleted() && !isCompleted() && !isFailed()) {
            return true;
        }
        return false;
    }

    private void y() {
        com.tencent.gamecenter.wadl.sdk.common.a.g().postDelayed(new a(), 1000L);
    }

    private synchronized void z() {
        File file;
        e eVar = this.f107523v;
        if (eVar != null && (file = this.f107525x) != null && this.f107527z != null) {
            eVar.f107489b = file.lastModified();
            this.f107523v.f107490c = this.f107512k;
            if (!b(this.f107523v.l())) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "saveRange...writeCfg false.");
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equalsIgnoreCase(DownloaderConstant.KEY_RANGE)) {
            this.f107505d.put(str, str2);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void addListener(DownloaderTaskListener downloaderTaskListener) {
        if (downloaderTaskListener != null) {
            this.C.a(downloaderTaskListener);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public DownloaderTaskAttr getAttribute() {
        return this.f107499a;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public int getAverageSpeed() {
        long j3 = this.f107512k;
        if (j3 > 10 && this.f107507f > 0) {
            return (int) ((getReceivedLength() * 1000) / j3);
        }
        return -1;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public DownloaderTaskCategory getCategory() {
        return this.f107499a.taskCategory;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getContentDisposition() {
        return this.f107515n;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getContentType() {
        return this.f107514m;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public long getCostTime() {
        return this.f107512k;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public int getFailCode() {
        return this.f107519r;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public synchronized String getFailInfo() {
        return this.f107520s;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getHtmlUrl() {
        return this.f107520s;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getId() {
        return this.f107501b;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getInitSaveName() {
        return this.f107510i;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public long getKnownSize() {
        return this.f107506e;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public int getPercentage() {
        int i3;
        e eVar;
        long totalLength = getTotalLength();
        if (totalLength == -1 && (eVar = this.f107523v) != null) {
            totalLength = eVar.f107488a;
        }
        e eVar2 = this.f107523v;
        int i16 = 0;
        if (eVar2 != null) {
            i3 = eVar2.d();
        } else {
            i3 = 0;
        }
        if (totalLength > 0) {
            i16 = (int) ((getReceivedLength() * 100) / totalLength);
        }
        if (i3 > i16) {
            return i3;
        }
        return i16;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public DownloaderTaskPriority getPriority() {
        return this.f107499a.priority;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getRealSaveName() {
        return this.f107511j;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public int getRealTimeSpeed() {
        if (this.C.b() != DownloaderTaskStatus.STARTED && this.C.b() != DownloaderTaskStatus.DOWNLOADING) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("CostTimeCounter", "statusInformer:" + this.C.b().name());
            return 0;
        }
        return this.f107517p;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public long getReceivedLength() {
        e eVar = this.f107523v;
        if (eVar != null) {
            long e16 = eVar.e();
            if (e16 > this.f107508g && e16 <= this.f107523v.f107488a) {
                return e16;
            }
        }
        return this.f107508g;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getSaveDir() {
        return this.f107509h;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getSavePath() {
        String str;
        if (TextUtils.isEmpty(this.f107511j)) {
            str = this.f107510i;
        } else {
            str = this.f107511j;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return new File(this.f107509h, str).getAbsolutePath();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public long getStartTime() {
        return this.f107522u;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public DownloaderTaskStatus getStatus() {
        return this.C.b();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public Object getTag() {
        return this.J;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public long getTotalLength() {
        if (this.f107503c.f() > 0) {
            return this.f107503c.f();
        }
        long j3 = this.f107506e;
        if (j3 > 0) {
            return j3;
        }
        if (this.f107507f > 0) {
            return this.f107507f;
        }
        try {
            return this.f107523v.f107488a;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getUniqueKey() {
        return this.f107516o;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public String getUrl() {
        return this.f107503c.f107627a.f107608a;
    }

    public boolean i() {
        try {
            return com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.a(TextUtils.isEmpty(this.f107511j) ? this.f107510i : this.f107511j)));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isCompleted() {
        if (this.C.b() == DownloaderTaskStatus.COMPLETE) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isDeleted() {
        if (this.C.b() == DownloaderTaskStatus.DELETED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isEaseTask() {
        if (this.f107499a.taskCategory == DownloaderTaskCategory.CATE_DEFAULT_EASE) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isFailed() {
        if (this.C.b() == DownloaderTaskStatus.FAILED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isPaused() {
        if (this.C.b() == DownloaderTaskStatus.PAUSED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isRunning() {
        if (this.C.b() != DownloaderTaskStatus.STARTED && this.C.b() != DownloaderTaskStatus.DOWNLOADING) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isSupportRange() {
        return this.f107513l;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean isWaiting() {
        if (this.C.b() == DownloaderTaskStatus.PENDING) {
            return true;
        }
        return false;
    }

    public long o() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.h.a aVar = this.f107524w;
        if (aVar != null) {
            return aVar.b();
        }
        return 0L;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.h.c
    public boolean onSave() {
        if (!isRunning()) {
            return false;
        }
        if (!v()) {
            d();
            h();
            return false;
        }
        return A();
    }

    public long p() {
        return this.f107507f;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void pause() {
        DownloaderTaskStatus b16 = this.C.b();
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "trying pause...key:" + this.f107516o + ",url:" + getUrl() + ", now status:" + b16);
        if (b16 == DownloaderTaskStatus.PENDING || b16 == DownloaderTaskStatus.STARTED || b16 == DownloaderTaskStatus.DOWNLOADING) {
            e eVar = this.f107523v;
            if (eVar != null && eVar.k()) {
                return;
            }
            a(true, 0, "", DownloaderTaskStatus.PAUSED);
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "cancel task:" + this.f107516o);
            try {
                com.tencent.gamecenter.wadl.sdk.common.b.e eVar2 = this.O;
                if (eVar2 != null) {
                    eVar2.a();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int ordinal = fVar.f107499a.priority.ordinal() - this.f107499a.priority.ordinal();
        return ordinal == 0 ? (int) (this.f107521t - fVar.f107521t) : ordinal;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void removeAllListeners() {
        this.C.l();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void removeListener(DownloaderTaskListener downloaderTaskListener) {
        if (downloaderTaskListener != null) {
            this.C.b(downloaderTaskListener);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void resume() {
        synchronized (this.C) {
            DownloaderTaskStatus b16 = this.C.b();
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "trying resume...key:" + this.f107516o + ",url:" + getUrl() + ", now status:" + b16);
            if (b16 != DownloaderTaskStatus.STARTED && b16 != DownloaderTaskStatus.DOWNLOADING && b16 != DownloaderTaskStatus.PENDING) {
                if (b16 != DownloaderTaskStatus.DELETED && !this.C.c()) {
                    if (b16 != DownloaderTaskStatus.PAUSED && b16 != DownloaderTaskStatus.FAILED && b16 != DownloaderTaskStatus.NONE) {
                        if (b16 == DownloaderTaskStatus.COMPLETE) {
                            b(true);
                            return;
                        }
                        return;
                    }
                    start();
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f107519r = 0;
        this.f107520s = "";
        this.f107522u = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        g();
        this.P = 0L;
        synchronized (this.L) {
            this.f107507f = -1L;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "task " + this.f107516o + " start run... url:" + getUrl() + ",Thread:" + Thread.currentThread().getName());
        if (this.B) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "task stopped at the beginning. url:" + getUrl() + ",Thread:" + Thread.currentThread().getName());
            return;
        }
        this.C.a();
        this.f107524w = new com.tencent.gamecenter.wadl.sdk.downloader.task.h.a();
        com.tencent.gamecenter.wadl.sdk.downloader.task.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.a(this);
        this.E = aVar;
        aVar.d();
        boolean s16 = s();
        this.C.b(DownloaderTaskStatus.STARTED);
        this.M = new com.tencent.gamecenter.wadl.sdk.downloader.task.j.a();
        a(com.tencent.gamecenter.wadl.sdk.common.b.c.d(), com.tencent.gamecenter.wadl.sdk.common.b.c.b());
        if (!s16) {
            a(false, this.f107519r, this.f107520s, DownloaderTaskStatus.FAILED);
        } else if (this.f107523v.a()) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "checkAlreadyCompleted");
            this.f107508g = this.f107523v.f107488a;
            b(false);
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.e q16 = this.L.q();
            int i3 = q16.f107237a;
            if (i3 != 0) {
                a(false, i3, q16.f107238b, DownloaderTaskStatus.FAILED);
            }
        }
        this.C.d();
        d();
        h();
        if (this.D) {
            i();
            j();
            m();
        } else if (isCompleted() || this.f107519r == -75) {
            i();
        }
        f();
        this.M = null;
        this.L.j();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void setAttribute(DownloaderTaskAttr downloaderTaskAttr) {
        if (downloaderTaskAttr != null) {
            this.f107499a = downloaderTaskAttr;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void setBakUrl(String str) {
        this.f107503c.d(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public boolean setHttpsUrl(String str) {
        return this.f107503c.c(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void setId(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f107501b = str;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void setOcUrlList(List<String> list) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f107503c.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), it.next(), a.EnumC1136a.Type_CDN_Ip_App_Input);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void setTag(Object obj) {
        this.J = obj;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask
    public void start() {
        this.f107518q = false;
        this.B = false;
        this.f107513l = true;
        this.f107517p = 0;
        n();
    }

    public boolean u() {
        return !com.tencent.gamecenter.wadl.sdk.common.e.g.e(this.f107510i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String w() {
        String str;
        try {
            String str2 = this.Q;
            if (str2 != null && str2.length() != 0) {
                str = this.Q;
                try {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("TAG", "currentCfg = " + this.Q);
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "readCfg fail.", e);
                    if (!TextUtils.isEmpty(str)) {
                    }
                }
            } else {
                this.A.seek(0L);
                str = this.A.readUTF();
            }
        } catch (Exception e17) {
            e = e17;
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public boolean x() {
        boolean z16 = false;
        for (int i3 = 0; i3 < 3; i3++) {
            File file = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(this.f107511j));
            File file2 = new File(this.f107509h, this.f107511j);
            if (file2.exists()) {
                file2.delete();
            }
            z16 = file.renameTo(file2);
            if (z16) {
                break;
            }
            SystemClock.sleep(50L);
        }
        return z16;
    }

    public f(String str, String str2) {
        this.f107499a = DownloaderTaskAttr.DEFAULT_TASK_ATTR;
        this.f107501b = "";
        this.f107505d = new HashMap();
        this.f107506e = -1L;
        this.f107507f = -1L;
        this.f107508g = 0L;
        this.f107509h = "";
        this.f107510i = "";
        this.f107511j = "";
        this.f107512k = 0L;
        this.f107513l = true;
        this.f107514m = "";
        this.f107515n = "";
        this.f107516o = null;
        this.f107517p = 0;
        this.f107518q = false;
        this.f107519r = 0;
        this.f107520s = "";
        this.f107521t = -1L;
        this.f107522u = -1L;
        this.B = false;
        this.C = new d(this);
        this.D = false;
        this.F = 0;
        this.G = new AtomicInteger(0);
        this.H = new Object();
        this.I = false;
        this.K = false;
        this.L = new b();
        this.P = 0L;
        this.Q = "";
        this.R = new LinkedHashMap();
        this.S = Collections.synchronizedList(new ArrayList());
        this.T = new ConcurrentHashMap();
        this.U = new ConcurrentHashMap();
        this.V = -1L;
        this.W = new AtomicInteger(0);
        this.X = new AtomicInteger(0);
        this.Y = new Object();
        this.Z = 0L;
        this.f107500a0 = 0L;
        this.f107502b0 = 0L;
        this.f107504c0 = -1;
        this.f107509h = str;
        this.f107510i = str2;
    }

    private void e() {
        this.f107507f = -1L;
        this.f107511j = "";
        this.f107512k = 0L;
        this.f107513l = true;
        this.f107514m = "";
        this.f107515n = "";
        this.f107517p = 0;
        this.f107518q = false;
        this.f107519r = 0;
        this.f107520s = "";
        this.f107523v = new e("");
    }

    private void f() {
        this.T.clear();
        synchronized (this.S) {
            this.S.clear();
        }
        this.U.clear();
    }

    private void g() {
        this.S.clear();
        this.T.clear();
        this.U.clear();
        this.W.set(0);
        this.X.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        String str;
        String str2;
        String str3;
        synchronized (f.class) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initFileOnDetected...begin");
            this.R.put("point0", 0L);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            new File(this.f107509h).mkdirs();
            if (com.tencent.gamecenter.wadl.sdk.common.e.g.e(this.f107510i)) {
                this.f107511j = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(this.f107503c.f107627a.f107608a, this.f107514m, this.f107515n, "");
                File file = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(this.f107511j));
                File file2 = new File(this.f107509h, this.f107511j);
                if (file.exists() || file2.exists()) {
                    int lastIndexOf = this.f107511j.lastIndexOf(".");
                    if (lastIndexOf <= 0 || this.f107511j.length() <= lastIndexOf + 1) {
                        str = this.f107511j;
                        str2 = "";
                    } else {
                        str = this.f107511j.substring(0, lastIndexOf);
                        str2 = this.f107511j.substring(lastIndexOf);
                    }
                    int i3 = 2;
                    while (true) {
                        str3 = str + "(" + i3 + ")" + str2;
                        File file3 = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(str3));
                        File file4 = new File(this.f107509h, str3);
                        if (!file3.exists() && !file4.exists()) {
                            break;
                        }
                        i3++;
                    }
                    this.f107511j = str3;
                }
            } else {
                this.f107511j = this.f107510i;
            }
            this.R.put("point1", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            this.f107525x = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(this.f107511j));
            this.f107527z = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.a(this.f107511j));
            try {
                this.A = new g(this.f107527z, "rw");
                this.R.put("point2", Long.valueOf(System.currentTimeMillis() - valueOf2.longValue()));
                Long valueOf3 = Long.valueOf(System.currentTimeMillis());
                try {
                    this.f107526y = new g(this.f107525x, "rw");
                    this.R.put("point3", Long.valueOf(System.currentTimeMillis() - valueOf3.longValue()));
                    this.R.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(System.currentTimeMillis()).longValue()));
                    com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initFileOnDetected...end");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    this.f107520s = "initFileOnDetected,new RAF:" + this.f107525x.getAbsolutePath() + ":" + com.tencent.gamecenter.wadl.sdk.downloader.a.c.a((Throwable) e16);
                    this.f107519r = a(e16);
                    com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "initFileOnDetected...Exception, _ret:" + this.f107519r + ",_failInfo:" + this.f107520s);
                    h();
                    return false;
                }
            } catch (Exception e17) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "initFileOnDetected...create RandomAccessFile for cfgFile failed.", e17);
                this.f107520s = "initFileOnDetected,new RAF:" + this.f107525x.getAbsolutePath() + ":" + com.tencent.gamecenter.wadl.sdk.downloader.a.c.a((Throwable) e17);
                this.f107519r = a(e17);
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-TaskImpl", "initFileOnDetected...Exception, _ret:" + this.f107519r + ",_failInfo:" + this.f107520s);
                h();
                return false;
            }
        }
        return true;
    }

    public void d() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.h.a aVar = this.f107524w;
        if (aVar != null) {
            aVar.a();
        }
    }

    public synchronized void h() {
        RandomAccessFile randomAccessFile = this.f107526y;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            this.f107526y = null;
        }
        RandomAccessFile randomAccessFile2 = this.A;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            this.A = null;
        }
    }

    public boolean j() {
        try {
            File file = new File(getSavePath());
            boolean a16 = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(file);
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "deleteFile:" + file + ",result:" + a16);
            return a16;
        } catch (Exception unused) {
            return false;
        }
    }

    public void k() {
        i();
        j();
        m();
    }

    public void l() {
        com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b.a(getId());
    }

    public boolean m() {
        try {
            File file = new File(getSaveDir(), com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(TextUtils.isEmpty(this.f107511j) ? this.f107510i : this.f107511j));
            boolean a16 = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(file);
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "deleteFile:" + file + ",result:" + a16);
            return a16;
        } catch (Exception unused) {
            return false;
        }
    }

    public void n() {
        this.f107521t = SystemClock.elapsedRealtime();
        try {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "try add task " + this.f107516o + " to pool...");
            this.C.b(DownloaderTaskStatus.PENDING);
            this.O = com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().b(this);
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "task " + this.f107516o + " added to pool of category:" + this.f107499a.taskCategory.name());
        } catch (Exception e16) {
            throw new DownloaderException("" + e16);
        }
    }

    private void b() {
        synchronized (this.S) {
            Iterator<com.tencent.gamecenter.wadl.sdk.downloader.c.b> it = this.S.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if (r2 > 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(long j3) {
        long j16;
        if (j3 == 0) {
            return;
        }
        if (this.Z != j3) {
            this.Z = j3;
            this.f107500a0 = SystemClock.elapsedRealtime();
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "checkIfResumeWhenReceiveStandStill receivedLen:" + j3 + ",detectLength:" + this.f107507f);
        PCDNInitParam pCDNInitParam = com.tencent.gamecenter.wadl.sdk.common.a.f106996s;
        if (pCDNInitParam != null) {
            j16 = pCDNInitParam.pcdnReceiveOverTime;
        }
        j16 = 10000;
        if (Math.abs(SystemClock.elapsedRealtime() - this.f107500a0) > j16) {
            com.tencent.gamecenter.wadl.sdk.downloader.pcdn.c.b(getId(), getUrl(), -2000);
            this.Z = 0L;
            this.f107500a0 = 0L;
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-TaskImpl", "checkIfResumeWhenReceiveStandStill lastReceivedLen over time,just try resume");
            try {
                pause();
                y();
            } catch (Throwable unused) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "checkIfResumeWhenReceiveStandStill lastReceivedLen over time, resume failed.");
            }
        }
    }

    private String a(com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar, a.C1134a c1134a) {
        if (aVar == null) {
            return "inner error: getRange null for sectionId:" + c1134a.f107547a;
        }
        return "inner error: check offset fail for section:" + aVar + ",buffer offset:" + c1134a.f107548b + ",sectionId:" + c1134a.f107547a;
    }

    private void b(boolean z16) {
        this.L.o();
        try {
            RandomAccessFile randomAccessFile = this.f107526y;
            if (randomAccessFile != null) {
                randomAccessFile.getChannel().force(true);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        b();
        synchronized (this.C) {
            if (z16) {
                this.C.a(d.a(DownloaderTaskStatus.COMPLETE));
                this.C.d();
                return;
            }
            if (this.C.b() != DownloaderTaskStatus.PAUSED) {
                if (x()) {
                    i();
                    l();
                    a();
                    this.C.b(DownloaderTaskStatus.COMPLETE);
                } else {
                    a(false, -72, "", DownloaderTaskStatus.FAILED);
                }
            }
        }
    }

    private void a() {
        List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> d16 = this.f107503c.d();
        if (this.f107503c.f() < 0) {
            this.f107504c0 = -2;
            return;
        }
        if (d16 == null || d16.size() <= 0) {
            this.f107504c0 = -3;
            return;
        }
        if (TextUtils.isEmpty(this.f107503c.e())) {
            this.f107504c0 = -3;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f107509h, this.f107511j), "r");
            for (com.tencent.gamecenter.wadl.sdk.downloader.d.a aVar : d16) {
                long j3 = aVar.f107366a;
                int i3 = aVar.f107367b;
                byte[] bArr = new byte[i3];
                randomAccessFile.seek(j3);
                randomAccessFile.read(bArr, 0, i3);
                byteArrayOutputStream.write(bArr, 0, i3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (com.tencent.gamecenter.wadl.sdk.common.e.g.a(byteArray)) {
                this.f107504c0 = -4;
            }
            str = com.tencent.gamecenter.wadl.sdk.common.e.d.c(byteArray);
            if (TextUtils.isEmpty(str)) {
                this.f107504c0 = -5;
            } else if (str.toLowerCase().equals(this.f107503c.e().toLowerCase())) {
                this.f107504c0 = 1;
            } else {
                this.f107504c0 = 0;
            }
            try {
                byteArrayOutputStream.close();
                randomAccessFile.close();
            } catch (IOException unused) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("hijack", "md5:" + str + " cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms result:" + this.f107504c0);
            }
        } catch (IOException e16) {
            this.f107504c0 = -4;
            e16.printStackTrace();
        }
    }

    public boolean b(String str) {
        try {
            this.Q = str;
            this.A.seek(0L);
            this.A.writeUTF(str);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "writeCfg fail. cfg:" + str, e16);
            return false;
        }
    }

    public void a(int i3) {
        if (this.F < i3) {
            this.F = i3;
        }
    }

    public void a(int i3, String str) {
        if (!isRunning() || this.M == null) {
            return;
        }
        this.M.a(new a.C1135a(System.currentTimeMillis() - this.f107522u, i3, str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
    
        if (r9 > 0) goto L11;
     */
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(long j3) {
        synchronized (this.L) {
            if (this.f107507f == -1) {
                if (j3 <= 0) {
                    j3 = this.f107506e;
                }
                this.V = j3;
            } else {
                long j16 = this.f107507f;
                if (j3 <= 0) {
                    j3 = this.f107506e;
                    if (j3 <= 0) {
                        j3 = j16;
                    }
                }
                if (this.f107507f != j3) {
                    this.f107507f = -1L;
                    this.V = j3;
                    if (this.f107523v != null) {
                        synchronized (this.Y) {
                            long e16 = this.f107523v.e();
                            int d16 = this.f107523v.d();
                            this.f107523v = new e("");
                            com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar = this.L.f107530b;
                            if (dVar != null && dVar.f107597s) {
                                this.L.f107530b.b();
                            }
                            f();
                            this.f107523v.a(e16, d16);
                            d();
                        }
                    }
                }
            }
        }
    }

    private void a(long j3, int i3) {
        long h16 = this.f107523v.h();
        if (j3 - this.P > com.tencent.gamecenter.wadl.sdk.downloader.a.a.f() || h16 == this.f107507f) {
            if (i3 > 0 && !this.f107499a.multiSection) {
                try {
                    this.f107526y.getFD().sync();
                } catch (Throwable th5) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "checkTaskStatus error", th5);
                }
            }
            this.f107508g = h16;
            this.f107523v.a(this.f107508g, getPercentage());
            this.C.b(DownloaderTaskStatus.DOWNLOADING);
            this.P = j3;
        }
        if (h16 == this.f107507f) {
            this.E.c();
            if (this.f107525x.exists()) {
                b(false);
                return;
            } else {
                a(false, -14, "", DownloaderTaskStatus.FAILED);
                return;
            }
        }
        if (h16 <= this.f107507f) {
            if (com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b.d(getId())) {
                b(h16);
                return;
            }
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "checkTaskStatus receivedLength > detectLength");
        a(false, -42, "inner error: receivedLength > detectLength:" + h16 + " > " + this.f107507f, DownloaderTaskStatus.FAILED);
        i();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.c.a
    public void a(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar) {
        if (this.f107523v != null) {
            List<String> list = this.U.get(aVar);
            if (list != null && list.size() > 0) {
                char c16 = 1;
                char c17 = 0;
                boolean z16 = this.f107523v.h() > ((long) q());
                if (z16) {
                    c();
                    bVar.e();
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String[] split = it.next().split(",");
                    if (split.length == 2) {
                        long parseLong = Long.parseLong(split[c17]);
                        long parseLong2 = Long.parseLong(split[c16]);
                        String str = parseLong + "-" + parseLong2;
                        com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar2 = new com.tencent.gamecenter.wadl.sdk.downloader.task.i.a(this.f107523v, parseLong, parseLong, parseLong, parseLong2);
                        if (z16) {
                            bVar.a(str);
                        } else {
                            this.f107523v.b(aVar2);
                            bVar.b(str);
                        }
                        c16 = 1;
                        c17 = 0;
                    }
                }
            }
            this.U.remove(aVar);
        }
    }

    private void a(String str) {
        try {
            new File(this.f107509h).mkdirs();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.f107525x = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(str));
        this.f107527z = new File(this.f107509h, com.tencent.gamecenter.wadl.sdk.downloader.a.a.a(str));
    }

    public void a(boolean z16) {
        if (isDeleted()) {
            return;
        }
        if (!isRunning() && z16) {
            k();
        }
        if (z16) {
            this.D = z16;
        }
        a(true, 0, "", DownloaderTaskStatus.DELETED);
    }

    public void a(boolean z16, int i3, String str, DownloaderTaskStatus downloaderTaskStatus) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskImpl", "cancel task...key:" + this.f107516o + ",isFromUser:" + z16 + ",retCode:" + i3 + ",failInfo:" + str + ",newStatus:" + downloaderTaskStatus.name());
        this.B = true;
        this.f107518q = z16;
        if (!z16) {
            this.f107519r = i3;
            this.f107520s = str;
        }
        this.C.b(downloaderTaskStatus);
        b();
        this.L.s();
    }

    private boolean a(a.C1134a c1134a) {
        try {
            long filePointer = this.f107526y.getFilePointer();
            long j3 = c1134a.f107548b;
            if (filePointer != j3) {
                this.f107526y.seek(j3);
            }
            this.f107526y.write(c1134a.f107549c, 0, (int) c1134a.f107550d);
            return true;
        } catch (Exception e16) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-TaskImpl", "writeFile fail.", e16);
            if (!(e16 instanceof NullPointerException)) {
                a(false, b(e16), "saveData fail.|" + com.tencent.gamecenter.wadl.sdk.downloader.a.c.a((Throwable) e16), DownloaderTaskStatus.FAILED);
            }
            return false;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.c.a
    public boolean a(com.tencent.gamecenter.wadl.sdk.downloader.task.i.a aVar, com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar) {
        e eVar = this.f107523v;
        if (eVar != null) {
            boolean z16 = eVar.h() > ((long) q());
            long j3 = aVar.f107560d;
            long j16 = aVar.f107562f;
            String str = j3 + "-" + j16;
            if (!z16) {
                this.f107523v.b(new com.tencent.gamecenter.wadl.sdk.downloader.task.i.a(this.f107523v, j3, j3, j3, j16));
                bVar.b(str);
                return true;
            }
            c();
            bVar.e();
            bVar.a(str);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r8.h() <= r7.f107523v.f107488a) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long lastModified = this.f107525x.lastModified();
        if (z16 && lastModified >= this.f107523v.f107489b) {
            e eVar = this.f107523v;
            if (eVar.f107494g) {
                if (eVar.f107488a > 0) {
                }
            }
        }
        return z17 && lastModified >= this.f107523v.f107489b;
    }
}
