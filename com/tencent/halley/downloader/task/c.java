package com.tencent.halley.downloader.task;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.halley.common.HalleyException;
import com.tencent.halley.common.a.f;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.g;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskCategory;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.DownloaderTaskPriority;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.c;
import com.tencent.halley.downloader.c.e;
import com.tencent.halley.downloader.task.b.a;
import com.tencent.halley.downloader.task.c.a;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.halley.downloader.task.section.DataSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements DownloaderTask, com.tencent.halley.downloader.a.c, com.tencent.halley.downloader.b.a, com.tencent.halley.downloader.task.b.c, Comparable<c>, Runnable {
    static IPatchRedirector $redirector_;
    public volatile long A;
    public volatile long B;
    public volatile long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public volatile long J;
    public volatile int K;
    public volatile int L;
    public volatile int M;
    public int N;
    public int O;
    public int P;
    public volatile boolean Q;
    public volatile boolean R;
    public volatile boolean S;
    public volatile boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public volatile DownloaderTaskPriority f113801a;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private Object aD;
    private com.tencent.halley.downloader.b.b aE;
    private long aF;
    private boolean aG;

    /* renamed from: aa, reason: collision with root package name */
    public boolean f113802aa;

    /* renamed from: ab, reason: collision with root package name */
    public boolean f113803ab;

    /* renamed from: ac, reason: collision with root package name */
    public List<com.tencent.halley.downloader.b.c> f113804ac;

    /* renamed from: ad, reason: collision with root package name */
    public Map<com.tencent.halley.downloader.task.d.a, com.tencent.halley.downloader.b.c> f113805ad;

    /* renamed from: ae, reason: collision with root package name */
    public Map<com.tencent.halley.downloader.task.d.a, List<String>> f113806ae;

    /* renamed from: af, reason: collision with root package name */
    public AtomicInteger f113807af;

    /* renamed from: ag, reason: collision with root package name */
    public AtomicInteger f113808ag;

    /* renamed from: ah, reason: collision with root package name */
    public String f113809ah;

    /* renamed from: ai, reason: collision with root package name */
    public int f113810ai;

    /* renamed from: aj, reason: collision with root package name */
    boolean f113811aj;

    /* renamed from: ak, reason: collision with root package name */
    public Map<String, List<String>> f113812ak;

    /* renamed from: al, reason: collision with root package name */
    public String f113813al;

    /* renamed from: am, reason: collision with root package name */
    private DownloaderTaskCategory f113814am;

    /* renamed from: an, reason: collision with root package name */
    private File f113815an;

    /* renamed from: ao, reason: collision with root package name */
    private RandomAccessFile f113816ao;

    /* renamed from: ap, reason: collision with root package name */
    private File f113817ap;

    /* renamed from: aq, reason: collision with root package name */
    private RandomAccessFile f113818aq;

    /* renamed from: ar, reason: collision with root package name */
    private AtomicInteger f113819ar;

    /* renamed from: at, reason: collision with root package name */
    private com.tencent.halley.downloader.task.section.c f113820at;

    /* renamed from: au, reason: collision with root package name */
    private com.tencent.halley.downloader.task.c.a f113821au;

    /* renamed from: av, reason: collision with root package name */
    private f f113822av;

    /* renamed from: aw, reason: collision with root package name */
    private String f113823aw;

    /* renamed from: ax, reason: collision with root package name */
    private long f113824ax;

    /* renamed from: ay, reason: collision with root package name */
    private volatile int f113825ay;

    /* renamed from: az, reason: collision with root package name */
    private int f113826az;

    /* renamed from: b, reason: collision with root package name */
    public volatile HashMap<String, Long> f113827b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicLong f113828c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicLong f113829d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f113830e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.halley.downloader.task.d.b f113831f;

    /* renamed from: g, reason: collision with root package name */
    public TaskDivider f113832g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.halley.downloader.task.b.a f113833h;

    /* renamed from: i, reason: collision with root package name */
    public b f113834i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.halley.downloader.task.a f113835j;

    /* renamed from: k, reason: collision with root package name */
    public Object f113836k;

    /* renamed from: l, reason: collision with root package name */
    public String f113837l;

    /* renamed from: m, reason: collision with root package name */
    public String f113838m;

    /* renamed from: n, reason: collision with root package name */
    public String f113839n;

    /* renamed from: o, reason: collision with root package name */
    public String f113840o;

    /* renamed from: p, reason: collision with root package name */
    public String f113841p;

    /* renamed from: q, reason: collision with root package name */
    public String f113842q;

    /* renamed from: r, reason: collision with root package name */
    public String f113843r;

    /* renamed from: s, reason: collision with root package name */
    public String f113844s;

    /* renamed from: t, reason: collision with root package name */
    public String f113845t;

    /* renamed from: u, reason: collision with root package name */
    public String f113846u;

    /* renamed from: v, reason: collision with root package name */
    public String f113847v;

    /* renamed from: w, reason: collision with root package name */
    public String f113848w;

    /* renamed from: x, reason: collision with root package name */
    public String f113849x;

    /* renamed from: y, reason: collision with root package name */
    public String f113850y;

    /* renamed from: z, reason: collision with root package name */
    public String f113851z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a extends RandomAccessFile {
        static IPatchRedirector $redirector_;

        public a(File file, String str) {
            super(file, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) str);
            }
        }
    }

    public c(com.tencent.halley.downloader.task.d.b bVar, String str, String str2, DownloaderTaskListener downloaderTaskListener, long j3, String str3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, str, str2, downloaderTaskListener, Long.valueOf(j3), str3);
            return;
        }
        this.f113801a = DownloaderTaskPriority.NORMAL;
        this.f113827b = new LinkedHashMap();
        this.f113828c = new AtomicLong(0L);
        this.f113829d = new AtomicLong(0L);
        this.f113830e = new HashMap();
        this.f113834i = new b(this);
        this.f113836k = new Object();
        this.f113837l = "";
        this.f113838m = "";
        this.f113839n = "";
        this.f113840o = "";
        this.f113841p = "";
        this.f113842q = "";
        this.f113843r = "";
        this.f113844s = "";
        this.f113845t = "";
        this.f113846u = "";
        this.f113847v = "";
        this.f113850y = null;
        this.f113851z = null;
        this.A = -1L;
        this.B = 0L;
        this.C = 0L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = 0L;
        this.J = -1L;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = -1;
        this.O = -1;
        this.P = 0;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = true;
        this.Z = false;
        this.f113802aa = false;
        if (h.a("down_use_multi_thread", 0, 1, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f113803ab = z16;
        this.f113804ac = Collections.synchronizedList(new ArrayList());
        this.f113805ad = new ConcurrentHashMap();
        this.f113806ae = new ConcurrentHashMap();
        this.f113807af = new AtomicInteger(0);
        this.f113808ag = new AtomicInteger(0);
        this.f113814am = DownloaderTaskCategory.Cate_DefaultMass;
        this.f113819ar = new AtomicInteger(0);
        this.f113823aw = "";
        this.f113809ah = "";
        this.f113824ax = 0L;
        this.f113825ay = 0;
        this.f113810ai = 0;
        this.f113826az = -1;
        this.aA = false;
        this.aB = true;
        this.aC = true;
        this.f113811aj = false;
        this.aD = new Object();
        this.aE = new com.tencent.halley.downloader.b.b();
        this.aF = 0L;
        this.f113812ak = new HashMap();
        this.f113813al = "";
        this.aG = false;
        d.b("halley-downloader-TaskImpl", "new BDTaskImpl()");
        this.f113831f = bVar;
        this.f113840o = str;
        this.f113841p = str2;
        this.f113834i.a(downloaderTaskListener);
        this.D = j3 > 0 ? j3 : -1L;
        this.f113847v = TextUtils.isEmpty(str3) ? "" : str3;
        this.f113850y = A();
        this.f113820at = new com.tencent.halley.downloader.task.section.c(this);
    }

    private String A() {
        try {
            return g.a(j.d() + j.f() + System.currentTimeMillis() + this.f113831f.f113911b.f113890c + j.c());
        } catch (Throwable unused) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(System.currentTimeMillis());
            return sb5.toString();
        }
    }

    private void B() {
        StringBuilder sb5;
        String str;
        String str2;
        String str3 = this.f113831f.f113911b.f113890c;
        String str4 = this.f113843r;
        String a16 = com.tencent.halley.downloader.a.b.a(this.f113844s);
        String str5 = "";
        if (a16 == null && (a16 = com.tencent.halley.downloader.a.b.b(str3)) == null) {
            a16 = "downloadfile".concat("");
        }
        int lastIndexOf = a16.lastIndexOf(".");
        if (lastIndexOf > 0) {
            if (!TextUtils.isEmpty("")) {
                if (a16.length() <= lastIndexOf + 1) {
                    str2 = "";
                } else {
                    String substring = a16.substring(0, lastIndexOf);
                    String substring2 = a16.substring(lastIndexOf);
                    a16 = substring;
                    str2 = substring2;
                }
                a16 = a16 + "" + str2;
            }
        } else {
            if (!TextUtils.isEmpty(str4) && str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                sb5 = new StringBuilder();
                sb5.append(a16);
                sb5.append("");
                sb5.append(".apk");
            } else {
                sb5 = new StringBuilder();
                sb5.append(a16);
                sb5.append("");
            }
            a16 = sb5.toString();
        }
        if (!TextUtils.isEmpty(a16)) {
            a16 = a16.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
        }
        this.f113842q = a16;
        File file = new File(this.f113840o, com.tencent.halley.downloader.a.a.f(this.f113842q));
        File file2 = new File(this.f113840o, this.f113842q);
        if (!file.exists() && !file2.exists()) {
            return;
        }
        int lastIndexOf2 = this.f113842q.lastIndexOf(".");
        if (lastIndexOf2 > 0 && this.f113842q.length() > lastIndexOf2 + 1) {
            str = this.f113842q.substring(0, lastIndexOf2);
            str5 = this.f113842q.substring(lastIndexOf2);
        } else {
            str = this.f113842q;
        }
        int i3 = 2;
        while (true) {
            String str6 = str + "(" + i3 + ")" + str5;
            File file3 = new File(this.f113840o, com.tencent.halley.downloader.a.a.f(str6));
            File file4 = new File(this.f113840o, str6);
            if (!file3.exists() && !file4.exists()) {
                this.f113842q = str6;
                return;
            }
            i3++;
        }
    }

    private boolean C() {
        try {
            this.f113818aq = new a(this.f113817ap, "rw");
            return true;
        } catch (Exception e16) {
            d.b("halley-downloader-TaskImpl", "initFileOnDetected...create RandomAccessFile for cfgFile failed.", e16);
            b(e16);
            return false;
        }
    }

    private boolean D() {
        try {
            this.f113816ao = new a(this.f113815an, "rw");
            return true;
        } catch (Exception e16) {
            b(e16);
            return false;
        }
    }

    private void E() {
        try {
            synchronized (this.f113836k) {
                this.f113836k.notifyAll();
                this.T = false;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private boolean F() {
        if (this.R || isPaused() || isDeleted() || isCompleted() || isFailed()) {
            return true;
        }
        return false;
    }

    private void G() {
        try {
            this.f113816ao.getChannel().force(true);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        J();
        synchronized (this.f113834i) {
            if (this.f113834i.f113769a == DownloaderTaskStatus.PAUSED) {
                return;
            }
            if (r()) {
                w();
                this.f113826az = j.a(this.f113831f, this.f113840o, this.f113842q);
                String str = "";
                if (this.aG && !TextUtils.isEmpty(this.f113813al)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    str = com.tencent.halley.common.utils.c.a(this.f113813al, this.f113840o, this.f113842q);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (!TextUtils.isEmpty(str)) {
                        str = str + ", fileMd5= " + a(this.f113840o, this.f113842q);
                    }
                    d.e("halley-downloader-TaskImpl_qqq", this.f113850y + " - doComplete checkCaculateCrc64 - " + this.f113813al + ", failInfo = " + str + ", costTime = " + currentTimeMillis2);
                }
                if (TextUtils.isEmpty(str)) {
                    d.a("halley-downloader-TaskImpl", "updateTaskStatus-COMPLETE, uniqueKey= " + this.f113850y + ", url= " + getFileUrl(), true);
                    this.f113834i.a(DownloaderTaskStatus.COMPLETE);
                } else {
                    a(false, -2001, str, DownloaderTaskStatus.FAILED);
                }
            } else {
                a(false, -72, "", DownloaderTaskStatus.FAILED);
            }
        }
    }

    private void H() {
        this.f113805ad.clear();
        synchronized (this.f113804ac) {
            this.f113804ac.clear();
        }
        this.f113806ae.clear();
    }

    private void I() {
        J();
        com.tencent.halley.downloader.task.section.b bVar = this.f113820at.f113989a;
        if (bVar != null) {
            bVar.f113959o = false;
        }
        com.tencent.halley.downloader.task.section.b bVar2 = this.f113820at.f113990b;
        if (bVar2 != null) {
            bVar2.f113959o = false;
        }
        if (this.f113820at.f113991c.size() > 0) {
            Iterator<com.tencent.halley.downloader.task.section.b> it = this.f113820at.f113991c.iterator();
            while (it.hasNext()) {
                it.next().f113959o = false;
            }
        }
    }

    private void J() {
        synchronized (this.f113804ac) {
            Iterator<com.tencent.halley.downloader.b.c> it = this.f113804ac.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    private int K() {
        int i3;
        if (com.tencent.halley.common.a.c.h() != 1) {
            return 20971520;
        }
        if (this.A <= 0 || (i3 = (int) (this.A * 0.2d)) <= 41943040) {
            return 41943040;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str, str2);
        if (!file.exists()) {
            return "";
        }
        try {
            String a16 = g.a(file);
            d.a("halley-downloader-TaskImpl_qqq", "calcMd5 =  " + a16 + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis), true);
            return a16;
        } catch (Throwable th5) {
            d.c("halley-downloader-TaskImpl_qqq", "calcMd5 error, " + str + " " + str2, th5);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean q() {
        boolean z16;
        boolean z17;
        StringBuilder sb5;
        int i3;
        if (F()) {
            y();
            x();
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i16 = 0;
        while (true) {
            if (F()) {
                y();
                break;
            }
            z16 = true;
            if (SystemClock.elapsedRealtime() - elapsedRealtime > com.tencent.halley.downloader.a.a.f113581d) {
                this.f113819ar.getAndIncrement();
                break;
            }
            synchronized (this.aD) {
                a.C1247a a16 = this.f113833h.a();
                if (a16 == null) {
                    break;
                }
                DataSection section = this.f113832g.getSection(a16.f113792a);
                if (section == null) {
                    sb5 = new StringBuilder("inner error: getRange null for sectionId:");
                } else if (section.save != a16.f113793b) {
                    sb5 = new StringBuilder("inner error: check offset fail for section:");
                    sb5.append(section);
                    sb5.append(",buffer offset:");
                    sb5.append(a16.f113793b);
                    sb5.append(",sectionId:");
                } else {
                    z17 = true;
                    if (z17) {
                        return false;
                    }
                    try {
                        long filePointer = this.f113816ao.getFilePointer();
                        long j3 = a16.f113793b;
                        if (filePointer != j3) {
                            this.f113816ao.seek(j3);
                        }
                        this.f113816ao.write(a16.f113794c, 0, (int) a16.f113795d);
                        section.save = a16.f113793b + a16.f113795d;
                        i16 = (int) (i16 + a16.f113795d);
                        a16.f113794c = null;
                        if (this.T) {
                            if (com.tencent.halley.downloader.c.j.a().f() >= 2097152) {
                                z16 = false;
                            }
                            if (z16) {
                                E();
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (!(e16 instanceof NullPointerException)) {
                            d.c("halley-downloader-TaskImpl", "saveData fail.", e16);
                            if (!this.f113815an.exists()) {
                                i3 = -14;
                            } else if (com.tencent.halley.downloader.a.b.a(e16)) {
                                i3 = -12;
                            } else if (com.tencent.halley.downloader.a.b.b(e16)) {
                                i3 = -17;
                            } else if (com.tencent.halley.downloader.a.b.c(e16)) {
                                i3 = -78;
                            } else {
                                i3 = -50;
                            }
                            a(false, i3, "saveData fail.|" + com.tencent.halley.downloader.a.b.a((Throwable) e16), DownloaderTaskStatus.FAILED);
                        }
                    }
                }
                sb5.append(a16.f113792a);
                a(false, -42, sb5.toString(), DownloaderTaskStatus.FAILED);
                z17 = false;
                if (z17) {
                }
            }
        }
        z16 = false;
        if (!z16) {
            E();
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        com.tencent.halley.downloader.task.a aVar = this.f113835j;
        if (aVar != null) {
            aVar.a(i16, (int) (elapsedRealtime2 - elapsedRealtime));
        }
        if (i16 > 0) {
            s();
        }
        if (F()) {
            x();
        } else if (this.A > 0) {
            long j16 = i16;
            long receivedLength = this.f113832g.getReceivedLength();
            boolean z18 = z16;
            if (elapsedRealtime2 - this.f113824ax > com.tencent.halley.downloader.a.a.f() || receivedLength == this.A) {
                if (j16 > 0 && !this.Y) {
                    try {
                        this.f113816ao.getFD().sync();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                this.B = receivedLength;
                this.f113832g.recordLastProgress(this.B, getPercentage());
                this.f113834i.a(DownloaderTaskStatus.DOWNLOADING);
                this.f113824ax = elapsedRealtime2;
            }
            if (receivedLength == this.A) {
                this.f113835j.f113760c = System.currentTimeMillis();
                this.H = elapsedRealtime2;
                if (!this.f113815an.exists()) {
                    a(false, -14, "", DownloaderTaskStatus.FAILED);
                    return z18;
                }
                G();
                return z18;
            }
            if (receivedLength > this.A) {
                d.e("halley-downloader-TaskImpl", "receivedLength > detectLength");
                a(false, -42, "inner error: receivedLength > detectLength:" + receivedLength + " > " + this.A, DownloaderTaskStatus.FAILED);
                w();
                return z18;
            }
            return z18;
        }
        return z16;
    }

    private boolean r() {
        if (!this.aC) {
            return true;
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < 3; i3++) {
            File file = new File(this.f113840o, com.tencent.halley.downloader.a.a.f(this.f113842q));
            File file2 = new File(this.f113840o, this.f113842q);
            if (file2.exists()) {
                d.e("halley-downloader-TaskImpl", "renameOnComplete delete exist old file - " + file2.getAbsolutePath());
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

    private synchronized void s() {
        File file;
        TaskDivider taskDivider = this.f113832g;
        if (taskDivider != null && (file = this.f113815an) != null && this.f113817ap != null) {
            taskDivider.lastModified = file.lastModified();
            this.f113832g.costTime = this.C;
            this.f113832g.flow = this.f113828c.get();
            if (!a(this.f113832g.toDbText())) {
                d.d("halley-downloader-TaskImpl", "saveRange...writeCfg false.");
            }
        }
    }

    private String t() {
        String str;
        String str2 = this.f113823aw;
        if (str2 != null && str2.length() != 0) {
            str = this.f113823aw;
            d.e("TAG", "currentCfg = " + this.f113823aw);
        } else {
            try {
                this.f113818aq.seek(0L);
                str = this.f113818aq.readUTF();
            } catch (Exception e16) {
                e16.printStackTrace();
                d.b("halley-downloader-TaskImpl", "readCfg fail.", e16);
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    private boolean u() {
        File file = new File(getFullSavePath());
        try {
            boolean a16 = com.tencent.halley.downloader.a.b.a(file);
            d.c("halley-downloader-TaskImpl", "deleteFile:" + file + ",result:" + a16);
            return a16;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean v() {
        String str;
        if (TextUtils.isEmpty(this.f113842q)) {
            str = this.f113841p;
        } else {
            str = this.f113842q;
        }
        File file = new File(getFileDir(), com.tencent.halley.downloader.a.a.f(str));
        try {
            boolean a16 = com.tencent.halley.downloader.a.b.a(file);
            d.c("halley-downloader-TaskImpl", "deleteFile:" + file + ",result:" + a16);
            return a16;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean w() {
        String str;
        if (TextUtils.isEmpty(this.f113842q)) {
            str = this.f113841p;
        } else {
            str = this.f113842q;
        }
        try {
            return com.tencent.halley.downloader.a.b.a(new File(this.f113840o, com.tencent.halley.downloader.a.a.e(str)));
        } catch (Exception unused) {
            return false;
        }
    }

    private synchronized void x() {
        RandomAccessFile randomAccessFile = this.f113816ao;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            this.f113816ao = null;
        }
        RandomAccessFile randomAccessFile2 = this.f113818aq;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            this.f113818aq = null;
        }
    }

    private void y() {
        com.tencent.halley.downloader.task.b.a aVar = this.f113833h;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0179, code lost:
    
        if (r1.getReceivedLength() <= r15.f113832g.totalLen) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean z() {
        boolean z16;
        int i3;
        File file;
        boolean z17;
        boolean z18;
        File file2;
        List<String> list;
        d.c("halley-downloader-TaskImpl", "initFileOnStart...begin");
        try {
            new File(this.f113840o).mkdirs();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.f113815an = null;
        this.f113817ap = null;
        if (c.a.a().f113688b) {
            d.c("halley-downloader-TaskImpl", "\u5f00\u542fHttpDns");
            try {
                URL url = new URL(this.f113831f.f113911b.f113890c);
                if (c.a.a().f113687a.contains(url.getHost())) {
                    c.a.a();
                    e eVar = new e(com.tencent.halley.downloader.c.c.a(url.getHost()));
                    String b16 = com.tencent.halley.common.a.c.b();
                    if (com.tencent.halley.common.a.c.i() == 1) {
                        list = eVar.f113692a.f113718a;
                    } else if (com.tencent.halley.common.a.c.i() == 3) {
                        a(url, eVar.f113692a.f113719b, b16, true);
                    } else {
                        a(url, eVar.f113692a.f113719b, b16, true);
                        list = eVar.f113692a.f113718a;
                    }
                    a(url, list, b16, false);
                }
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
            }
        }
        TaskDivider taskDivider = this.f113832g;
        if (taskDivider != null) {
            if (taskDivider.getReceivedLength() > 0 && !TextUtils.isEmpty(this.f113842q)) {
                if (this.aC) {
                    file2 = new File(this.f113840o, com.tencent.halley.downloader.a.a.f(this.f113842q));
                } else {
                    file2 = new File(this.f113840o, this.f113842q);
                }
                this.f113815an = file2;
                this.f113817ap = new File(this.f113840o, com.tencent.halley.downloader.a.a.e(this.f113842q));
                z16 = true;
            } else {
                z16 = false;
            }
            i3 = 0;
        } else if (com.tencent.halley.downloader.a.a.g(this.f113841p)) {
            if (this.aC) {
                file = new File(this.f113840o, com.tencent.halley.downloader.a.a.f(this.f113841p));
            } else {
                file = new File(this.f113840o, this.f113841p);
            }
            this.f113815an = file;
            this.f113817ap = new File(this.f113840o, com.tencent.halley.downloader.a.a.e(this.f113841p));
            i3 = 1;
            z16 = false;
        } else {
            z16 = false;
            i3 = 0;
        }
        if ((z16 || i3 != 0) && this.f113815an.exists()) {
            if (C()) {
                d.c("halley-downloader-TaskImpl", "initFileOnStart...create _cfgAccessFile");
                if (D()) {
                    z17 = true;
                    if (z17) {
                        return false;
                    }
                    String t16 = t();
                    d.c("halley-downloader-TaskImpl", "initFileOnStart...readCfg:".concat(String.valueOf(t16)));
                    this.f113832g = new TaskDivider(t16);
                    if (!TextUtils.isEmpty(t16) && this.f113832g.parseOk) {
                        long lastModified = this.f113815an.lastModified();
                        if (i3 != 0 && lastModified >= this.f113832g.lastModified) {
                            TaskDivider taskDivider2 = this.f113832g;
                            if (taskDivider2.totalLen > 0) {
                            }
                        }
                        if (!z16 || lastModified < this.f113832g.lastModified) {
                            z18 = false;
                            if (!z18) {
                                if (TextUtils.isEmpty(this.f113842q)) {
                                    this.f113842q = this.f113841p;
                                }
                                this.C = this.f113832g.costTime;
                                this.f113828c.set(this.f113832g.flow);
                                if (i3 != 0 && this.f113832g.totalLen > 0) {
                                    this.X = true;
                                }
                            } else {
                                this.f113846u = "resume failed. cfg:" + t16 + ",flm:" + lastModified + ",from:" + (i3 ^ 1);
                            }
                            if (!z18) {
                                x();
                                this.A = -1L;
                                this.f113842q = "";
                                this.C = 0L;
                                this.f113828c.set(0L);
                                this.Q = true;
                                this.f113843r = "";
                                this.f113844s = "";
                                this.K = 0;
                                this.W = false;
                                this.L = 0;
                                this.f113845t = "";
                                this.f113832g = new TaskDivider("");
                                this.X = false;
                            }
                            this.Z = z18;
                            return true;
                        }
                        z18 = true;
                        if (!z18) {
                        }
                        if (!z18) {
                        }
                        this.Z = z18;
                        return true;
                    }
                    this.f113846u = "resume failed. cfg:".concat(String.valueOf(t16));
                }
            }
            z17 = false;
            if (z17) {
            }
        }
        z18 = false;
        if (!z18) {
        }
        this.Z = z18;
        return true;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equalsIgnoreCase(DownloaderConstant.KEY_RANGE)) {
            this.f113830e.put(str, str2);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void addListener(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloaderTaskListener);
        } else {
            this.f113834i.a(downloaderTaskListener);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.E = SystemClock.elapsedRealtime();
        d.b("halley-downloader-TaskImpl", "try add task " + this.f113850y + " to pool...");
        try {
            this.f113834i.a(DownloaderTaskStatus.PENDING);
            this.f113822av = com.tencent.halley.downloader.f.a.a().a(this, this.f113814am);
            d.b("halley-downloader-TaskImpl", "task " + this.f113850y + " added to pool of category:" + this.f113814am.name());
        } catch (Exception e16) {
            throw new HalleyException(e16.getLocalizedMessage());
        } catch (OutOfMemoryError e17) {
            throw new HalleyException("OOM-" + e17.getLocalizedMessage());
        }
    }

    public final boolean c() {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        synchronized (c.class) {
            d.c("halley-downloader-TaskImpl", "initFileOnDetected...begin");
            this.f113827b.put("point0", 0L);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            new File(this.f113840o).mkdirs();
            if (!com.tencent.halley.downloader.a.a.g(this.f113841p)) {
                B();
            } else {
                this.f113842q = this.f113841p;
            }
            this.f113827b.put("point1", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (this.aC) {
                file = new File(this.f113840o, com.tencent.halley.downloader.a.a.f(this.f113842q));
            } else {
                file = new File(this.f113840o, this.f113842q);
            }
            this.f113815an = file;
            this.f113817ap = new File(this.f113840o, com.tencent.halley.downloader.a.a.e(this.f113842q));
            if (!C()) {
                return false;
            }
            this.f113827b.put("point2", Long.valueOf(System.currentTimeMillis() - valueOf2.longValue()));
            Long valueOf3 = Long.valueOf(System.currentTimeMillis());
            if (!D()) {
                return false;
            }
            this.f113827b.put("point3", Long.valueOf(System.currentTimeMillis() - valueOf3.longValue()));
            this.f113827b.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(System.currentTimeMillis()).longValue()));
            d.c("halley-downloader-TaskImpl", "initFileOnDetected...end");
            return true;
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(c cVar) {
        c cVar2 = cVar;
        int ordinal = cVar2.f113801a.ordinal() - this.f113801a.ordinal();
        if (ordinal == 0) {
            return (int) (this.E - cVar2.E);
        }
        return ordinal;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        w();
        u();
        v();
    }

    @Override // com.tencent.halley.downloader.task.b.c
    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (isRunning()) {
            return q();
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Long) iPatchRedirector.redirect((short) 78, (Object) this)).longValue();
        }
        TaskDivider taskDivider = this.f113832g;
        if (taskDivider != null) {
            return taskDivider.getDownSizeThisTime();
        }
        return 0L;
    }

    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (String) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        com.tencent.halley.downloader.task.c.a aVar = this.f113821au;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getAverageSpeed */
    public final int getCurAverageSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Integer) iPatchRedirector.redirect((short) 76, (Object) this)).intValue();
        }
        long j3 = this.C;
        if (j3 > 10 && this.A > 0) {
            return (int) ((getReceivedLen() * 1000) / j3);
        }
        return -1;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final DownloaderTaskCategory getCategory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (DownloaderTaskCategory) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.f113814am;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getCostTime */
    public final long getTotalCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Long) iPatchRedirector.redirect((short) 40, (Object) this)).longValue();
        }
        return this.C;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getFailCode */
    public final int getRet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        return this.L;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getFailInfo */
    public final synchronized String getFailInfoMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.f113845t;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final Map<String, List<String>> getHttpRspHeaderMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return (Map) iPatchRedirector.redirect((short) 92, (Object) this);
        }
        return this.f113812ak;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (String) iPatchRedirector.redirect((short) 73, (Object) this);
        }
        return this.f113837l;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getInitSaveName */
    public final String getFileName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.f113841p;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final long getKnownSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Long) iPatchRedirector.redirect((short) 43, (Object) this)).longValue();
        }
        return this.D;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final int getPercentage() {
        int i3;
        TaskDivider taskDivider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        long totalLen = getTotalLen();
        if (totalLen == -1 && (taskDivider = this.f113832g) != null) {
            totalLen = taskDivider.totalLen;
        }
        TaskDivider taskDivider2 = this.f113832g;
        int i16 = 0;
        if (taskDivider2 != null) {
            i3 = taskDivider2.getLastPercentage();
        } else {
            i3 = 0;
        }
        if (totalLen > 0) {
            i16 = (int) ((getReceivedLen() * 100) / totalLen);
        }
        if (i3 > i16) {
            return i3;
        }
        return i16;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final DownloaderTaskPriority getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (DownloaderTaskPriority) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f113801a;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final String getRealSaveName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f113842q;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getRealTimeSpeed */
    public final int getCurRealTimeSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }
        if (this.f113834i.f113769a != DownloaderTaskStatus.STARTED && this.f113834i.f113769a != DownloaderTaskStatus.DOWNLOADING) {
            d.d("CostTimeCounter", "statusInformer:" + this.f113834i.f113769a.name());
            return 0;
        }
        if (this.f113825ay > 0) {
            return Math.min(this.K, this.f113825ay * 1024);
        }
        return this.K;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getReceivedLength */
    public final long getReceivedLen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        TaskDivider taskDivider = this.f113832g;
        if (taskDivider != null) {
            long lastReceivedLength = taskDivider.getLastReceivedLength();
            if (lastReceivedLength > this.B && lastReceivedLength <= this.f113832g.totalLen) {
                return lastReceivedLength;
            }
        }
        return this.B;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getSaveDir */
    public final String getFileDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.f113840o;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getSavePath */
    public final String getFullSavePath() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (TextUtils.isEmpty(this.f113842q)) {
            str = this.f113841p;
        } else {
            str = this.f113842q;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new File(this.f113840o, str).getAbsolutePath();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getStartTime */
    public final long getTaskStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Long) iPatchRedirector.redirect((short) 53, (Object) this)).longValue();
        }
        return this.F;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final DownloaderTaskStatus getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (DownloaderTaskStatus) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f113834i.f113769a;
    }

    public final int getTaskSpeedLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        return this.f113825ay;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getTotalLength */
    public final long getTotalLen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        if (this.f113831f.f113918i > 0) {
            return this.f113831f.f113918i;
        }
        long j3 = this.D;
        if (j3 > 0) {
            return j3;
        }
        if (this.A > 0) {
            return this.A;
        }
        try {
            return this.f113832g.totalLen;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Integer) iPatchRedirector.redirect((short) 71, (Object) this)).intValue();
        }
        return this.N;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getUniqueKey */
    public final String getTaskUniqueKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (String) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return this.f113850y;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getUrl */
    public final String getFileUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (String) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        return this.f113831f.f113911b.f113890c;
    }

    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (String) iPatchRedirector.redirect((short) 80, (Object) this);
        }
        com.tencent.halley.downloader.task.d.b bVar = this.f113831f;
        if (bVar != null) {
            return bVar.d();
        }
        return "";
    }

    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (String) iPatchRedirector.redirect((short) 81, (Object) this);
        }
        com.tencent.halley.downloader.task.section.c cVar = this.f113820at;
        if (cVar != null) {
            return cVar.d();
        }
        return "";
    }

    public final boolean isCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (this.f113834i.f113769a == DownloaderTaskStatus.COMPLETE) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final boolean isDeleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if (this.f113834i.f113769a == DownloaderTaskStatus.DELETED) {
            return true;
        }
        return false;
    }

    public final boolean isEaseTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        if (this.f113814am == DownloaderTaskCategory.Cate_DefaultEase) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final boolean isFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        if (this.f113834i.f113769a == DownloaderTaskStatus.FAILED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (this.f113834i.f113769a == DownloaderTaskStatus.PAUSED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final boolean isPausedOnMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Boolean) iPatchRedirector.redirect((short) 64, (Object) this)).booleanValue();
        }
        return this.V;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.f113834i.f113769a != DownloaderTaskStatus.STARTED && this.f113834i.f113769a != DownloaderTaskStatus.DOWNLOADING) {
            return false;
        }
        return true;
    }

    public final boolean isSupportRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Boolean) iPatchRedirector.redirect((short) 68, (Object) this)).booleanValue();
        }
        return this.Q;
    }

    public final boolean isWaiting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Boolean) iPatchRedirector.redirect((short) 77, (Object) this)).booleanValue();
        }
        if (this.f113834i.f113769a == DownloaderTaskStatus.PENDING) {
            return true;
        }
        return false;
    }

    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return (String) iPatchRedirector.redirect((short) 82, (Object) this);
        }
        com.tencent.halley.downloader.task.section.c cVar = this.f113820at;
        if (cVar != null) {
            return cVar.e();
        }
        return "";
    }

    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (String) iPatchRedirector.redirect((short) 83, (Object) this);
        }
        com.tencent.halley.downloader.task.section.c cVar = this.f113820at;
        if (cVar != null) {
            return cVar.f();
        }
        return "";
    }

    public final String l() {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (String) iPatchRedirector.redirect((short) 84, (Object) this);
        }
        String str4 = "1";
        if (this.f113831f.c()) {
            str = "1";
        } else {
            str = "0";
        }
        if (this.f113831f.f113918i <= 0) {
            str2 = "0";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f113831f.f113918i);
            str2 = sb5.toString();
        }
        List<com.tencent.halley.downloader.e.a> a16 = this.f113831f.a();
        if (a16 != null && a16.size() > 0 && !TextUtils.isEmpty(this.f113831f.f113922m)) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        if (TextUtils.isEmpty(this.f113831f.f113921l)) {
            str4 = "0";
        }
        String str5 = str + "," + str2 + "," + str3 + "," + str4;
        d.c("hijack", str5);
        return str5;
    }

    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (String) iPatchRedirector.redirect((short) 85, (Object) this);
        }
        String a16 = this.aE.a(this.f113832g, this.f113804ac, this.f113826az, this.aF);
        d.c("hijack", a16);
        return a16;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void manualSetFailInfo(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3, (Object) str);
            return;
        }
        this.L = i3;
        this.f113845t = str;
        this.f113834i.a(DownloaderTaskStatus.FAILED, false);
    }

    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (String) iPatchRedirector.redirect((short) 86, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f113804ac.size() > 0) {
            Iterator<com.tencent.halley.downloader.b.c> it = this.f113804ac.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().f113633g.toString());
                sb5.append(";");
            }
            sb5.deleteCharAt(sb5.length() - 1);
        }
        String sb6 = sb5.toString();
        d.c("hijack", sb6);
        return sb6;
    }

    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (String) iPatchRedirector.redirect((short) 87, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f113804ac.size() > 0) {
            for (com.tencent.halley.downloader.b.c cVar : this.f113804ac) {
                String str = "";
                if (cVar.c() || cVar.f113637k == 7) {
                    str = "" + cVar.f113637k + "," + cVar.f113638l + "," + cVar.f113628b.f113892e + "," + cVar.f113639m + "," + j.b(cVar.f113636j.h());
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                    sb5.append(";");
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        String sb6 = sb5.toString();
        d.c("hijack", sb6);
        return sb6;
    }

    public final long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Long) iPatchRedirector.redirect((short) 88, (Object) this)).longValue();
        }
        com.tencent.halley.downloader.task.a aVar = this.f113835j;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        DownloaderTaskStatus downloaderTaskStatus = this.f113834i.f113769a;
        d.a("halley-downloader-TaskImpl", "trying pause...key:" + this.f113850y + ",url:" + getFileUrl() + ", now status:" + downloaderTaskStatus, true);
        if (downloaderTaskStatus != DownloaderTaskStatus.PENDING && downloaderTaskStatus != DownloaderTaskStatus.STARTED && downloaderTaskStatus != DownloaderTaskStatus.DOWNLOADING) {
            d.e("halley-downloader-TaskImpl", "pause error:" + this.f113850y + ",url:" + getFileUrl() + ", now status:" + downloaderTaskStatus);
            return;
        }
        TaskDivider taskDivider = this.f113832g;
        if (taskDivider != null && taskDivider.isReadFinish()) {
            return;
        }
        a(true, 0, "", DownloaderTaskStatus.PAUSED);
        d.d("halley-downloader-TaskImpl", "cancel task:" + this.f113850y);
        try {
            f fVar = this.f113822av;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void removeAllListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        b bVar = this.f113834i;
        synchronized (bVar.f113770b) {
            bVar.f113770b.clear();
        }
        synchronized (bVar.f113771c) {
            bVar.f113771c.clear();
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void removeListener(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloaderTaskListener);
            return;
        }
        b bVar = this.f113834i;
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (bVar.f113770b) {
                if (bVar.f113770b.contains(downloaderTaskListener)) {
                    bVar.f113770b.remove(downloaderTaskListener);
                }
            }
            synchronized (bVar.f113771c) {
                if (bVar.f113771c.contains(downloaderTaskListener)) {
                    bVar.f113771c.remove(downloaderTaskListener);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final boolean resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        synchronized (this.f113834i) {
            DownloaderTaskStatus downloaderTaskStatus = this.f113834i.f113769a;
            d.a("halley-downloader-TaskImpl", "trying resume...key:" + this.f113850y + ",url:" + getFileUrl() + ", now status:" + downloaderTaskStatus, true);
            if (downloaderTaskStatus != DownloaderTaskStatus.STARTED && downloaderTaskStatus != DownloaderTaskStatus.DOWNLOADING && downloaderTaskStatus != DownloaderTaskStatus.COMPLETE && downloaderTaskStatus != DownloaderTaskStatus.PENDING) {
                if (downloaderTaskStatus != DownloaderTaskStatus.DELETED && !this.f113834i.f113772d) {
                    this.W = false;
                    this.R = false;
                    this.Q = true;
                    this.K = 0;
                    this.V = false;
                    b();
                    return true;
                }
                return false;
            }
            return true;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.L = 0;
        this.f113845t = "";
        this.F = System.currentTimeMillis();
        this.G = SystemClock.elapsedRealtime();
        this.aF = 0L;
        this.f113804ac.clear();
        this.f113805ad.clear();
        this.f113806ae.clear();
        this.f113807af.set(0);
        this.f113808ag.set(0);
        this.aE = new com.tencent.halley.downloader.b.b();
        this.f113824ax = 0L;
        synchronized (this.f113820at) {
            this.A = -1L;
        }
        this.X = false;
        this.O = -1;
        this.f113829d.set(0L);
        d.c("halley-downloader-TaskImpl", "task " + this.f113850y + " start run... url:" + getFileUrl() + ",Thread:" + Thread.currentThread().getName());
        if (this.R) {
            d.c("halley-downloader-TaskImpl", "task stopped at the beginning. url:" + getFileUrl() + ",Thread:" + Thread.currentThread().getName());
            return;
        }
        this.f113834i.a();
        this.f113833h = new com.tencent.halley.downloader.task.b.a();
        com.tencent.halley.downloader.task.a aVar = new com.tencent.halley.downloader.task.a(this);
        this.f113835j = aVar;
        aVar.f113758a = SystemClock.elapsedRealtime();
        aVar.f113759b = 0L;
        aVar.f113760c = 0L;
        this.f113834i.a(DownloaderTaskStatus.STARTED);
        this.f113821au = new com.tencent.halley.downloader.task.c.a();
        a(com.tencent.halley.common.a.c.h(), com.tencent.halley.common.a.c.b());
        if (z()) {
            if (this.f113832g.checkAlreadyCompleted()) {
                d.c("halley-downloader-TaskImpl", "checkAlreadyCompleted");
                this.B = this.f113832g.totalLen;
                G();
            } else {
                com.tencent.halley.common.utils.h b16 = this.f113820at.b();
                int i3 = b16.f113557a;
                if (i3 != 0) {
                    a(false, i3, b16.f113558b, DownloaderTaskStatus.FAILED);
                }
            }
        } else {
            a(false, this.L, this.f113845t, DownloaderTaskStatus.FAILED);
        }
        this.f113834i.b();
        y();
        x();
        if (this.aA) {
            w();
            u();
            if (this.aC) {
                v();
            }
        } else if (isCompleted() || this.L == -75) {
            w();
        }
        H();
        this.f113829d.set(0L);
        this.f113821au = null;
        com.tencent.halley.downloader.task.section.c cVar = this.f113820at;
        cVar.f113989a = null;
        cVar.f113990b = null;
        if (cVar.f113991c.size() > 0) {
            cVar.f113991c.clear();
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void setCategory(DownloaderTaskCategory downloaderTaskCategory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) downloaderTaskCategory);
        } else if (downloaderTaskCategory != null) {
            this.f113814am = downloaderTaskCategory;
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void setEnableCrcCheck(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, z16);
        } else {
            this.aG = z16;
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public final void setTaskSpeedLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
            return;
        }
        if (i3 <= 0) {
            i3 = 0;
        }
        this.f113825ay = i3;
        int i16 = 2;
        if (this.f113803ab && this.f113820at.f113991c.size() > 0) {
            i16 = 2 + this.f113820at.f113991c.size();
        }
        this.M = this.f113825ay / i16;
        com.tencent.halley.downloader.task.section.b bVar = this.f113820at.f113989a;
        if (bVar != null) {
            bVar.a(this.M);
        }
        com.tencent.halley.downloader.task.section.b bVar2 = this.f113820at.f113990b;
        if (bVar2 != null) {
            bVar2.a(this.M);
        }
        if (this.f113803ab && this.f113820at.f113991c.size() > 0) {
            Iterator<com.tencent.halley.downloader.task.section.b> it = this.f113820at.f113991c.iterator();
            while (it.hasNext()) {
                it.next().a(this.M);
            }
        }
    }

    private void b(Exception exc) {
        exc.printStackTrace();
        this.L = -49;
        this.f113845t = "initFileOnDetected,new RAF:" + this.f113815an.getAbsolutePath() + ":" + com.tencent.halley.downloader.a.b.a((Throwable) exc);
        a(exc);
        d.d("halley-downloader-TaskImpl", "initFileOnDetected...Exception, _ret:" + this.L + ",_failInfo:" + this.f113845t);
        x();
    }

    public final void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
        } else {
            if (!isRunning() || this.f113821au == null) {
                return;
            }
            this.f113821au.a(new a.C1248a(System.currentTimeMillis() - this.F, i3, str));
        }
    }

    @Override // com.tencent.halley.downloader.b.a
    public final void a(long j3) {
        com.tencent.halley.downloader.a.a.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
            return;
        }
        synchronized (this.f113820at) {
            if (this.A == -1) {
                if (j3 <= 0) {
                    j3 = this.D;
                    if (j3 > 0) {
                    }
                }
                this.J = j3;
            } else {
                long j16 = this.A;
                long j17 = this.A;
                if (j3 <= 0) {
                    j3 = this.D;
                    if (j3 <= 0) {
                        j3 = j16;
                    }
                }
                if (this.A != j3) {
                    this.A = -1L;
                    this.J = j3;
                    if (this.f113832g != null) {
                        synchronized (this.aD) {
                            long lastReceivedLength = this.f113832g.getLastReceivedLength();
                            int lastPercentage = this.f113832g.getLastPercentage();
                            com.tencent.halley.downloader.b.b bVar = this.aE;
                            bVar.f113619a = 1;
                            bVar.f113622d = this.O;
                            bVar.f113621c = j17;
                            bVar.f113620b = this.f113828c.get();
                            if (this.f113820at.f113989a != null) {
                                this.aE.f113623e = r3.f113958n;
                                String e16 = this.f113820at.f113989a.e();
                                if (!TextUtils.isEmpty(e16)) {
                                    this.aE.f113624f = j.b(e16);
                                }
                            }
                            this.f113832g = new TaskDivider("");
                            com.tencent.halley.downloader.task.section.b bVar2 = this.f113820at.f113989a;
                            if (bVar2 != null && bVar2.f113947c && (dVar = this.f113820at.f113989a.f113957m) != null) {
                                dVar.a();
                            }
                            H();
                            this.f113832g.recordLastProgress(lastReceivedLength, lastPercentage);
                            y();
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.halley.downloader.b.a
    public final void a(com.tencent.halley.downloader.task.d.a aVar, com.tencent.halley.downloader.b.c cVar) {
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            if (this.f113832g == null || (list = this.f113806ae.get(aVar)) == null || list.size() <= 0) {
                return;
            }
            long receivedLength = this.f113832g.getReceivedLength();
            char c16 = 1;
            char c17 = 0;
            boolean z16 = receivedLength > ((long) K());
            if (z16) {
                this.aF = receivedLength;
                I();
                cVar.b();
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(",");
                if (split.length == 2) {
                    long parseLong = Long.parseLong(split[c17]);
                    long parseLong2 = Long.parseLong(split[c16]);
                    String str = parseLong + "-" + parseLong2;
                    DataSection dataSection = new DataSection(this.f113832g, parseLong, parseLong, parseLong, parseLong2);
                    if (z16) {
                        cVar.b(str);
                    } else {
                        this.f113832g.addRedownloadSection(dataSection);
                        cVar.a(str);
                    }
                }
                c16 = 1;
                c17 = 0;
            }
            this.f113806ae.remove(aVar);
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar, (Object) cVar);
    }

    private void a(Exception exc) {
        int i3;
        if (com.tencent.halley.downloader.a.b.a(exc)) {
            i3 = -12;
        } else {
            if (!com.tencent.halley.downloader.a.b.b(exc)) {
                if (com.tencent.halley.downloader.a.b.c(exc)) {
                    this.L = -78;
                    return;
                }
                return;
            }
            i3 = -13;
        }
        this.L = i3;
    }

    private void a(URL url, List<String> list, String str, boolean z16) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String a16 = com.tencent.halley.downloader.g.b.a(url, it.next(), z16);
            d.c("halley-downloader-TaskImpl", "use http dns url = ".concat(String.valueOf(a16)));
            if (!TextUtils.isEmpty(a16)) {
                this.f113831f.a(str, a16, a.EnumC1249a.f113908m);
            }
        }
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (isDeleted()) {
            return;
        }
        if (!isRunning() && z16) {
            d();
        }
        if (z16) {
            this.aA = z16;
        }
        a(true, 0, "", DownloaderTaskStatus.DELETED);
    }

    public final void a(boolean z16, int i3, String str, DownloaderTaskStatus downloaderTaskStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, downloaderTaskStatus);
            return;
        }
        d.a("halley-downloader-TaskImpl", "cancel task...key:" + this.f113850y + ",isFromUser:" + z16 + ",retCode:" + i3 + ",failInfo:" + str + ",newStatus:" + downloaderTaskStatus.name(), true);
        this.R = true;
        this.W = z16;
        if (!z16) {
            this.L = i3;
            this.f113845t = str;
        }
        this.f113834i.a(downloaderTaskStatus);
        J();
        this.f113820at.c();
    }

    @Override // com.tencent.halley.downloader.a.c
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) ? this.R : ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
    }

    @Override // com.tencent.halley.downloader.b.a
    public final boolean a(DataSection dataSection, com.tencent.halley.downloader.b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            TaskDivider taskDivider = this.f113832g;
            if (taskDivider == null) {
                return false;
            }
            long receivedLength = taskDivider.getReceivedLength();
            boolean z16 = receivedLength > ((long) K());
            long j3 = dataSection.start;
            long j16 = dataSection.read;
            String str = j3 + "-" + j16;
            if (!z16) {
                this.f113832g.addRedownloadSection(new DataSection(this.f113832g, j3, j3, j3, j16));
                cVar.a(str);
                return true;
            }
            this.aF = receivedLength;
            I();
            cVar.b();
            cVar.b(str);
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) dataSection, (Object) cVar)).booleanValue();
    }

    private boolean a(String str) {
        try {
            this.f113823aw = str;
            this.f113818aq.seek(0L);
            this.f113818aq.writeUTF(str);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            d.b("halley-downloader-TaskImpl", "writeCfg fail. cfg:".concat(String.valueOf(str)), e16);
            return false;
        }
    }
}
