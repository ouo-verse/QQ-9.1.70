package com.tencent.halley.common.c;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.a.i;
import com.tencent.halley.common.c.b;
import com.tencent.halley.common.c.f;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static int f113350e;

    /* renamed from: a, reason: collision with root package name */
    public final String f113351a;

    /* renamed from: b, reason: collision with root package name */
    protected AtomicInteger f113352b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f113353c;

    /* renamed from: d, reason: collision with root package name */
    public int f113354d;

    /* renamed from: f, reason: collision with root package name */
    private Handler f113355f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.halley.common.c.b f113356g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicInteger f113357h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f113358i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f113359j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f113360k;

    /* renamed from: l, reason: collision with root package name */
    private int f113361l;

    /* renamed from: m, reason: collision with root package name */
    private long f113362m;

    /* renamed from: n, reason: collision with root package name */
    private AtomicInteger f113363n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f113364o;

    /* renamed from: p, reason: collision with root package name */
    private final Runnable f113365p;

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f113366q;

    /* renamed from: r, reason: collision with root package name */
    private b.a f113367r;

    /* compiled from: P */
    /* renamed from: com.tencent.halley.common.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public abstract class AbstractRunnableC1240a implements Runnable {
        static IPatchRedirector $redirector_;

        AbstractRunnableC1240a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
        }

        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                if (z16) {
                    if (!a.this.f113355f.postAtFrontOfQueue(this)) {
                        a.this.f113355f.post(this);
                        return;
                    }
                    return;
                }
                a.this.f113355f.post(this);
            }
        }

        /* synthetic */ AbstractRunnableC1240a(a aVar, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, aVar, Byte.valueOf(b16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class b extends AbstractRunnableC1240a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        private String f113377c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f113378d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f113379e;

        public b(String str, boolean z16) {
            super(a.this, (byte) 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, Boolean.valueOf(z16));
                return;
            }
            this.f113377c = str;
            this.f113378d = z16;
            this.f113379e = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            a.this.f113353c.decrementAndGet();
            if (TextUtils.isEmpty(this.f113377c)) {
                return;
            }
            a.f(a.this);
            int a16 = h.a("report_new_record_num", 1, 50, 10);
            if (!this.f113378d) {
                com.tencent.halley.common.utils.d.a(a.this.f113351a, "try insert HalleyAction Record to db. content:" + this.f113377c);
                long b16 = f.a(a.this.c()).b(this.f113377c);
                if (b16 != -1) {
                    if (a.this.f113364o) {
                        com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger insert to db and reset timer");
                        a.this.f113364o = false;
                        a.this.b(false, false);
                    }
                    int incrementAndGet = a.this.f113357h.incrementAndGet();
                    com.tencent.halley.common.utils.d.b(a.this.f113351a, "insert record to db succ. id:" + b16 + ",newCount:" + incrementAndGet + ",newRecordCount2Report:" + a16);
                    if (incrementAndGet >= a16) {
                        com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger upload...");
                        a.this.a(this.f113378d, this.f113379e);
                        return;
                    }
                    return;
                }
                com.tencent.halley.common.utils.d.d(a.this.f113351a, "insert record to db failed.");
                return;
            }
            a.this.f113358i.add(this.f113377c);
            if (this.f113379e) {
                if (a.this.f113358i.size() >= a16) {
                    com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger upload by cache num...");
                    a.this.f113363n.set(1);
                    a.this.a(this.f113378d, this.f113379e);
                    return;
                } else {
                    if (a.this.f113363n.get() == 0) {
                        com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger real timer...");
                        a.this.f113363n.set(1);
                        a.this.b(false, true);
                        return;
                    }
                    return;
                }
            }
            com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger upload right now...");
            a.this.a(this.f113378d, this.f113379e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    final class d extends AbstractRunnableC1240a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        private e f113381c;

        public d(e eVar) {
            super(a.this, (byte) 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) eVar);
            } else {
                this.f113381c = eVar;
            }
        }

        private void a() {
            a aVar;
            int i3;
            if (com.tencent.halley.common.a.c.j()) {
                if (a.this.f113361l > 0) {
                    if (a.this.f113361l < h.a("report_interval_forbid_limit", 30, 1440, 60)) {
                        aVar = a.this;
                        i3 = aVar.f113361l * 2;
                    }
                } else {
                    aVar = a.this;
                    i3 = 5;
                }
                aVar.f113361l = i3;
            }
            e eVar = this.f113381c;
            if (eVar.f113384d && eVar.f113383c) {
                int size = eVar.f113386f.size();
                com.tencent.halley.common.utils.d.b(a.this.f113351a, "CacheData has been transferred to dbData..Size:".concat(String.valueOf(size)));
                for (int i16 = 0; i16 < size; i16++) {
                    f.a(a.this.c()).b(this.f113381c.f113386f.get(i16).f113403b);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            a.i(a.this);
            a aVar = a.this;
            e eVar = this.f113381c;
            aVar.getClass();
            a.this.f113362m = SystemClock.elapsedRealtime();
            if (this.f113381c.f113385e) {
                if (a.this.f113361l > 0) {
                    a aVar2 = a.this;
                    aVar2.f113361l -= 10;
                }
                a.this.f113352b.addAndGet(this.f113381c.f113387g);
                e eVar2 = this.f113381c;
                if (!eVar2.f113383c) {
                    int size = eVar2.f113386f.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList.add(Long.valueOf(this.f113381c.f113386f.get(i3).f113402a));
                    }
                    f.a(a.this.c()).a(arrayList);
                    if (a.this.f113360k) {
                        a.n(a.this);
                        com.tencent.halley.common.utils.d.b(a.this.f113351a, "reportFinishTask: needReportFinishing right now");
                        a.this.a(true, this.f113381c.f113384d);
                        return;
                    }
                }
                if (this.f113381c.f113382b) {
                    a.this.f113364o = true;
                    return;
                }
                SystemClock.sleep(200L);
                com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger reportFinishTask: notClear and reReport needReportRightNow:" + this.f113381c.f113383c);
                a aVar3 = a.this;
                e eVar3 = this.f113381c;
                aVar3.a(eVar3.f113383c, eVar3.f113384d);
                return;
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class e extends AbstractRunnableC1240a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        public boolean f113382b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f113383c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f113384d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f113385e;

        /* renamed from: f, reason: collision with root package name */
        public List<f.a> f113386f;

        /* renamed from: g, reason: collision with root package name */
        int f113387g;

        /* renamed from: i, reason: collision with root package name */
        private int f113389i;

        public e(boolean z16, boolean z17) {
            super(a.this, (byte) 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            this.f113385e = false;
            this.f113383c = z16;
            this.f113384d = z17;
            this.f113389i = 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f113382b = false;
            int unused = a.f113350e = h.a("report_max_report_count", 10, 100, 20);
            List<f.a> list = null;
            if (this.f113383c) {
                int size = a.this.f113358i.size();
                if (size != 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = 0;
                    for (int i16 = 0; i3 < size && i16 < a.f113350e; i16++) {
                        String str = (String) a.this.f113358i.get(i3);
                        arrayList2.add(new f.a(0L, str));
                        arrayList.add(str);
                        i3++;
                    }
                    for (int i17 = 0; i17 < arrayList.size(); i17++) {
                        a.this.f113358i.remove(arrayList.get(i17));
                    }
                    if (a.this.f113358i.size() == 0) {
                        this.f113382b = true;
                    }
                    list = arrayList2;
                }
            } else {
                int a16 = h.a("report_clear_db_num", 1, 10000, 1000);
                if (f.a(a.this.c()).a(a16)) {
                    com.tencent.halley.common.utils.d.d(a.this.f113351a, "!!!clearOverCount max:".concat(String.valueOf(a16)));
                } else {
                    list = f.a(a.this.c()).b(a.f113350e + 1);
                    if (list.size() <= a.f113350e) {
                        this.f113382b = true;
                        a.this.f113364o = true;
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
            this.f113386f = list;
            List<f.a> list2 = this.f113386f;
            if (list2 != null && list2.size() != 0) {
                StringBuilder sb5 = new StringBuilder();
                for (int i18 = 0; i18 < this.f113386f.size(); i18++) {
                    sb5.append(this.f113386f.get(i18).f113403b);
                    sb5.append("\n");
                }
                String sb6 = sb5.toString();
                com.tencent.halley.common.utils.d.b(a.this.f113351a, "reportData:".concat(String.valueOf(sb6)));
                if (this.f113383c && sb6.contains("client_report_time")) {
                    sb6 = sb6.replace("client_report_time", j.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                }
                byte[] bytes = sb6.getBytes();
                int length = bytes.length;
                this.f113387g = length;
                byte[] a17 = com.tencent.halley.common.c.d.a(bytes);
                a.this.f113356g.a(a17, length, this.f113383c, this, a.this.f113367r, this.f113389i);
                com.tencent.halley.common.utils.d.c(a.this.f113351a, "ReportTask count:" + this.f113386f.size() + " compressLen:" + a17.length + ",oriLen:" + length + ",isCleared:" + this.f113382b);
                return;
            }
            a.i(a.this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f113350e = 20;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113352b = new AtomicInteger(0);
        this.f113357h = new AtomicInteger(0);
        this.f113358i = new ArrayList();
        this.f113359j = false;
        this.f113360k = false;
        this.f113353c = new AtomicInteger(0);
        this.f113361l = 0;
        this.f113362m = 0L;
        this.f113363n = new AtomicInteger(0);
        this.f113364o = false;
        this.f113365p = new Runnable() { // from class: com.tencent.halley.common.c.a.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (a.this.f113358i.size() == 0) {
                    a.this.f113363n.incrementAndGet();
                    com.tencent.halley.common.utils.d.c(a.this.f113351a, "trigger incrementAndGet()...mRealTimerMissNum:" + a.this.f113363n.get());
                    a.this.b(false, true);
                    return;
                }
                com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger report in real timer...");
                a.this.a(true, true);
            }
        };
        this.f113366q = new Runnable() { // from class: com.tencent.halley.common.c.a.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.halley.common.utils.d.b(a.this.f113351a, "trigger reportTimer...");
                    a.this.a(false, true);
                }
            }
        };
        this.f113367r = new b.a() { // from class: com.tencent.halley.common.c.a.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.halley.common.c.b.a
            public final void a(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                e eVar = (e) obj;
                eVar.f113385e = z16;
                com.tencent.halley.common.utils.d.b(a.this.f113351a, "reportUploadFinishCallback..ret:".concat(String.valueOf(z16)));
                new d(eVar).a(true);
            }
        };
        this.f113351a = a();
        com.tencent.halley.common.c.c.a(com.tencent.halley.common.a.a());
        this.f113355f = i.a("ReportAction");
        this.f113356g = new com.tencent.halley.common.c.a.a();
        b(true, false);
        this.f113354d = b();
    }

    static /* synthetic */ c f(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* synthetic */ boolean i(a aVar) {
        aVar.f113359j = false;
        return false;
    }

    static /* synthetic */ boolean n(a aVar) {
        aVar.f113360k = false;
        return false;
    }

    public abstract String a();

    public abstract int b();

    public abstract String c();

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z16, boolean z17) {
        if (z17) {
            if (this.f113363n.get() <= 3) {
                com.tencent.halley.common.a.j.a().a(this.f113365p, h.a("report_real_timer_interval", 1, 60, 5) * 1000);
                return;
            } else {
                com.tencent.halley.common.utils.d.b(this.f113351a, "trigger close real timer...");
                this.f113363n.set(0);
                return;
            }
        }
        com.tencent.halley.common.utils.d.b(this.f113351a, "trigger to reset reportTimer and isInit:" + z16 + " isDbClear:" + this.f113364o);
        if (z16) {
            com.tencent.halley.common.a.j.a().a(this.f113366q, 10000L);
        } else {
            if (this.f113364o) {
                return;
            }
            com.tencent.halley.common.a.j.a().a(this.f113366q, h.a("report_timer_interval", 30000, 600000, 300000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z16, boolean z17) {
        if (z16 && z17) {
            b(false, true);
        } else {
            b(false, false);
        }
        if (this.f113359j) {
            com.tencent.halley.common.utils.d.b(this.f113351a, "isReporting, failed to execute report");
            if (z16) {
                this.f113360k = true;
            }
        } else {
            if (!z16) {
                this.f113357h.set(0);
            }
            if (this.f113362m != 0 && SystemClock.elapsedRealtime() - this.f113362m < this.f113361l * 60 * 1000) {
                this.f113358i.clear();
                com.tencent.halley.common.utils.d.b(this.f113351a, "report time more frequently: mReportLimitTime:" + this.f113361l + " and clear cacheEvents");
                return;
            }
            this.f113359j = true;
            try {
                com.tencent.halley.common.utils.d.b(this.f113351a, "ready to execute reportTask");
                new e(z16, z17).a(true);
            } catch (Throwable unused) {
                this.f113359j = false;
            }
        }
    }
}
