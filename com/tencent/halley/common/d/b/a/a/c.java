package com.tencent.halley.common.d.b.a.a;

import android.os.SystemClock;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.d.b.a.a.b;
import com.tencent.halley.common.d.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static volatile int f113438a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f113439b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f113440c;

    /* renamed from: d, reason: collision with root package name */
    private BlockingQueue<a> f113441d;

    /* renamed from: e, reason: collision with root package name */
    private b f113442e;

    /* renamed from: f, reason: collision with root package name */
    private final b.a f113443f;

    /* renamed from: g, reason: collision with root package name */
    private long f113444g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicInteger f113445h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.halley.common.a.e f113446i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f113439b = new Object();
        f113438a = 0;
        f113440c = null;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113443f = new b.a() { // from class: com.tencent.halley.common.d.b.a.a.c.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.halley.common.d.b.a.a.b.a
            public final void a() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    synchronized (c.f113439b) {
                        c.a(c.this);
                        c.b(c.this);
                        com.tencent.halley.common.a.c.a("halley-cloud-DetectorImpl");
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.f113444g = -1L;
        this.f113446i = new com.tencent.halley.common.a.e() { // from class: com.tencent.halley.common.d.b.a.a.c.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.halley.common.a.e
            public final void a(int i3, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                c.f113438a = com.tencent.halley.common.a.c.l().intValue();
                com.tencent.halley.common.utils.d.b("halley-cloud-DetectorImpl", "refresh opType:" + i3 + " apn:" + str + " sOpType:" + c.f113438a);
            }
        };
        this.f113445h = new AtomicInteger();
    }

    static /* synthetic */ b a(c cVar) {
        cVar.f113442e = null;
        return null;
    }

    public static c a() {
        if (f113440c == null) {
            synchronized (c.class) {
                if (f113440c == null) {
                    f113440c = new c();
                }
            }
        }
        return f113440c;
    }

    static /* synthetic */ BlockingQueue b(c cVar) {
        cVar.f113441d = null;
        return null;
    }

    private static boolean b(List<a> list) {
        int c16 = i.c("total_traffic");
        int a16 = h.a("detect_total_traffic_limit", 4, 32768, 1024) << 10;
        long b16 = i.b("next_clear_total_traffic_time");
        if (b16 != 0 && System.currentTimeMillis() > b16) {
            i.a("next_clear_total_traffic_time", System.currentTimeMillis() + (h.a("detect_traffic_clear_interval", 1, 672, 24) * 60 * 60 * 1000));
            com.tencent.halley.common.utils.d.b("halley-cloud-DetectorImpl", "clear total traffic reset nextClearTotalTraffic time.");
            i.a("total_traffic", 0);
            c16 = 0;
        } else if (b16 == 0) {
            i.a("next_clear_total_traffic_time", System.currentTimeMillis() + (h.a("detect_traffic_clear_interval", 1, 672, 24) * 60 * 60 * 1000));
            com.tencent.halley.common.utils.d.b("halley-cloud-DetectorImpl", "init nextClearTotalTrafficTime.");
        }
        if (c16 <= a16) {
            return true;
        }
        com.tencent.halley.common.utils.d.e("halley-cloud-DetectorImpl", "total traffic overflow, abandon detect task.And total traffic:".concat(String.valueOf(c16)));
        HashMap hashMap = new HashMap();
        hashMap.put("D32", String.valueOf(c16));
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3).f113428i = list.get(i3).f113427h;
            list.get(i3).a("HLDetectEvent", -503, null, hashMap, false);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f6 A[Catch: all -> 0x01a1, TryCatch #0 {all -> 0x01a1, blocks: (B:10:0x0017, B:12:0x003d, B:14:0x0054, B:15:0x005a, B:17:0x0060, B:19:0x0084, B:22:0x00f6, B:23:0x00fe, B:38:0x0181, B:44:0x019f, B:46:0x008f, B:48:0x0097, B:49:0x00be, B:51:0x00c4, B:53:0x00e8, B:55:0x00ee, B:25:0x00ff, B:27:0x0103, B:29:0x013a, B:30:0x0149, B:32:0x014f, B:34:0x0175, B:36:0x017b, B:37:0x0180, B:41:0x0107), top: B:9:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a0 A[RETURN] */
    @Override // com.tencent.halley.common.d.b.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(List<a> list) {
        boolean b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list)).booleanValue();
        }
        try {
            com.tencent.halley.common.utils.d.b("halley-cloud-DetectorImpl", "beforeQueue and remainingQueueCapacity is:" + this.f113445h.get());
            if (this.f113444g != -1) {
                if (SystemClock.elapsedRealtime() - this.f113444g < h.a("detect_received_interval", 1, 3600, 5) * 1000) {
                    HashMap hashMap = new HashMap();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        list.get(i3).f113428i = list.get(i3).f113427h;
                        list.get(i3).a("HLDetectEvent", -504, null, hashMap, false);
                    }
                    com.tencent.halley.common.utils.d.e("halley-cloud-DetectorImpl", "receive data too fast, abandon data..");
                    b16 = false;
                    if (!b16) {
                        return false;
                    }
                    this.f113444g = SystemClock.elapsedRealtime();
                    synchronized (f113439b) {
                        if (this.f113441d == null || this.f113442e == null) {
                            this.f113445h.set(h.a("detect_num_limit", 1, 1000, 100));
                            this.f113441d = new LinkedBlockingQueue();
                            this.f113442e = new b(this.f113441d, this.f113443f, this.f113445h);
                            com.tencent.halley.common.a.c.a("halley-cloud-DetectorImpl", this.f113446i);
                            com.tencent.halley.common.utils.d.b("halley-cloud-DetectorImpl", "DetectThread init..");
                        }
                        f113438a = com.tencent.halley.common.a.c.l().intValue();
                        int h16 = com.tencent.halley.common.a.c.h();
                        for (int i16 = 0; i16 < list.size(); i16++) {
                            a aVar = list.get(i16);
                            int i17 = f113438a;
                            aVar.f113425f = h16;
                            aVar.f113426g = i17;
                            this.f113441d.offer(list.get(i16));
                            this.f113445h.getAndAdd(-list.get(i16).f113427h);
                        }
                        if (!this.f113442e.f113434a) {
                            this.f113442e.start();
                        }
                    }
                    com.tencent.halley.common.utils.d.b("halley-cloud-DetectorImpl", "insert into detect queue..remaining capacity:" + this.f113445h.get());
                    return true;
                }
            }
            if (this.f113445h.get() < 0) {
                com.tencent.halley.common.utils.d.e("halley-cloud-DetectorImpl", "queue is full and remainingQueue:" + this.f113445h.get() + ", and abandon data..");
                HashMap hashMap2 = new HashMap();
                for (int i18 = 0; i18 < list.size(); i18++) {
                    list.get(i18).f113428i = list.get(i18).f113427h;
                    list.get(i18).a("HLDetectEvent", -502, null, hashMap2, false);
                }
                b16 = false;
                if (!b16) {
                }
            } else {
                b16 = com.tencent.halley.common.a.c.g() ? b(list) : true;
                if (!b16) {
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }
}
