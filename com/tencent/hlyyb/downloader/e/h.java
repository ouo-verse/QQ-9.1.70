package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskPriority;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.hlyyb.downloader.e.c;
import com.tencent.hlyyb.downloader.e.d;
import com.tencent.hlyyb.downloader.e.d.a;
import com.tencent.hlyyb.downloader.e.f.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class h implements DownloaderTask, com.tencent.hlyyb.downloader.a.a, com.tencent.hlyyb.downloader.b.a, f, Comparable<h>, Runnable {
    static IPatchRedirector $redirector_;
    public long A;
    public long B;
    public long C;
    public long D;
    public g E;
    public d F;
    public File G;
    public RandomAccessFile H;
    public File I;
    public RandomAccessFile J;
    public volatile boolean K;
    public c L;
    public boolean M;
    public com.tencent.hlyyb.downloader.e.a N;
    public int O;
    public volatile boolean P;
    public AtomicInteger Q;
    public Object R;
    public volatile boolean S;
    public boolean T;
    public String U;
    public Object V;
    public boolean W;
    public b X;
    public String Y;
    public com.tencent.hlyyb.downloader.e.d.a Z;

    /* renamed from: a, reason: collision with root package name */
    public int f114581a;

    /* renamed from: a0, reason: collision with root package name */
    public int f114582a0;

    /* renamed from: b, reason: collision with root package name */
    public String f114583b;

    /* renamed from: b0, reason: collision with root package name */
    public com.tencent.hlyyb.common.a.d f114584b0;

    /* renamed from: c, reason: collision with root package name */
    public String f114585c;

    /* renamed from: c0, reason: collision with root package name */
    public long f114586c0;

    /* renamed from: d, reason: collision with root package name */
    public String f114587d;

    /* renamed from: d0, reason: collision with root package name */
    public long f114588d0;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.f.b f114589e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f114590e0;

    /* renamed from: f, reason: collision with root package name */
    public DownloaderTaskCategory f114591f;

    /* renamed from: f0, reason: collision with root package name */
    public String f114592f0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f114593g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f114594g0;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f114595h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f114596h0;

    /* renamed from: i, reason: collision with root package name */
    public volatile DownloaderTaskPriority f114597i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f114598i0;

    /* renamed from: j, reason: collision with root package name */
    public long f114599j;

    /* renamed from: j0, reason: collision with root package name */
    public volatile HashMap<String, Long> f114600j0;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f114601k;

    /* renamed from: k0, reason: collision with root package name */
    public List<com.tencent.hlyyb.downloader.b.c> f114602k0;

    /* renamed from: l, reason: collision with root package name */
    public volatile long f114603l;

    /* renamed from: l0, reason: collision with root package name */
    public Map<com.tencent.hlyyb.downloader.e.f.a, com.tencent.hlyyb.downloader.b.c> f114604l0;

    /* renamed from: m, reason: collision with root package name */
    public String f114605m;

    /* renamed from: m0, reason: collision with root package name */
    public Map<com.tencent.hlyyb.downloader.e.f.a, List<String>> f114606m0;

    /* renamed from: n, reason: collision with root package name */
    public String f114607n;

    /* renamed from: n0, reason: collision with root package name */
    public volatile long f114608n0;

    /* renamed from: o, reason: collision with root package name */
    public String f114609o;

    /* renamed from: o0, reason: collision with root package name */
    public AtomicInteger f114610o0;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f114611p;

    /* renamed from: p0, reason: collision with root package name */
    public AtomicInteger f114612p0;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f114613q;

    /* renamed from: q0, reason: collision with root package name */
    public Object f114614q0;

    /* renamed from: r, reason: collision with root package name */
    public String f114615r;

    /* renamed from: r0, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.b.b f114616r0;

    /* renamed from: s, reason: collision with root package name */
    public String f114617s;

    /* renamed from: s0, reason: collision with root package name */
    public long f114618s0;

    /* renamed from: t, reason: collision with root package name */
    public String f114619t;

    /* renamed from: t0, reason: collision with root package name */
    public long f114620t0;

    /* renamed from: u, reason: collision with root package name */
    public AtomicLong f114621u;

    /* renamed from: u0, reason: collision with root package name */
    public int f114622u0;

    /* renamed from: v, reason: collision with root package name */
    public AtomicLong f114623v;

    /* renamed from: w, reason: collision with root package name */
    public volatile int f114624w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f114625x;

    /* renamed from: y, reason: collision with root package name */
    public volatile int f114626y;

    /* renamed from: z, reason: collision with root package name */
    public String f114627z;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a extends RandomAccessFile {
        static IPatchRedirector $redirector_;

        public a(File file, String str) {
            super(file, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) str);
            }
        }

        @Override // java.io.RandomAccessFile
        public final void finalize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                try {
                    super.finalize();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public c.d f114628a;

        /* renamed from: b, reason: collision with root package name */
        public c.d f114629b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
        }

        private void f(long j3, com.tencent.hlyyb.common.a.e eVar) {
            eVar.f114336a = -10;
            eVar.f114337b = "knownSize:" + h.this.f114599j + ",rspLength:" + j3;
        }

        private void g(c.d dVar, long j3, boolean z16, String str, String str2, String str3, String str4, com.tencent.hlyyb.common.a.e eVar) {
            boolean z17;
            h hVar = h.this;
            hVar.f114601k = j3;
            hVar.f114613q = z16;
            hVar.f114615r = str3;
            hVar.f114617s = str4;
            com.tencent.hlyyb.downloader.e.f.a aVar = dVar.f114488m;
            if (aVar != null) {
                hVar.f114582a0 = aVar.f114533c;
            }
            if (!h.this.f114613q) {
                h.this.E = new g("");
                dVar.f114487i = h.this.E.a();
            } else if (h.this.E.f114569a > 0) {
                if (h.this.E.f114569a != h.this.f114601k) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    h.this.E = new g("");
                    eVar.f114336a = 3;
                    eVar.f114337b = "can not resume from cfg, start over now";
                }
            }
            h.this.E.f114569a = j3;
            h.this.E.a(str);
            h.this.E.b(str2);
            i iVar = dVar.f114487i;
            if (iVar.f114634c == -1 && iVar.f114633b == -1) {
                h.this.E.b(dVar.f114487i);
            }
        }

        private void h(com.tencent.hlyyb.downloader.e.f.a aVar, long j3, com.tencent.hlyyb.common.a.e eVar) {
            StringBuilder sb5;
            if (aVar.f114532b == a.EnumC5821a.f114546j) {
                eVar.f114336a = -76;
                sb5 = new StringBuilder("sche size:");
            } else {
                eVar.f114336a = -73;
                sb5 = new StringBuilder("sche size:");
            }
            sb5.append(h.this.f114589e.a());
            sb5.append(",rsp size:");
            sb5.append(j3);
            eVar.f114337b = sb5.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x011c A[Catch: all -> 0x01e9, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0013, B:8:0x001a, B:12:0x0049, B:14:0x004f, B:16:0x0058, B:18:0x0063, B:20:0x0067, B:24:0x0070, B:29:0x007e, B:31:0x008e, B:36:0x00a1, B:38:0x00ab, B:40:0x00b2, B:45:0x00e1, B:47:0x0118, B:49:0x011c, B:51:0x0124, B:53:0x012c, B:54:0x0139, B:55:0x019b, B:57:0x019f, B:59:0x01a5, B:61:0x01ab, B:64:0x01b0, B:66:0x01b4, B:67:0x01c4, B:70:0x0102, B:71:0x00bd, B:73:0x00c5, B:75:0x00cf, B:77:0x00dd, B:78:0x00e7, B:79:0x0145, B:81:0x014e, B:83:0x015c, B:84:0x0160, B:86:0x0168, B:87:0x016c, B:88:0x018c, B:89:0x018f, B:91:0x0195, B:94:0x01d6, B:97:0x01df), top: B:3:0x000b }] */
        @Override // com.tencent.hlyyb.downloader.e.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized com.tencent.hlyyb.common.a.e a(c.d dVar, com.tencent.hlyyb.downloader.e.f.a aVar, String str, long j3, boolean z16, String str2, String str3, String str4, String str5) {
            com.tencent.hlyyb.common.a.e eVar;
            String str6;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.hlyyb.common.a.e) iPatchRedirector.redirect((short) 7, this, dVar, aVar, str, Long.valueOf(j3), Boolean.valueOf(z16), str2, str3, str4, str5);
            }
            if (h.this.f114596h0) {
                com.tencent.hlyyb.common.a.a.c();
                if (com.tencent.hlyyb.common.a.a.e()) {
                    h.this.pause();
                    h.this.f114598i0 = true;
                }
            }
            if ((dVar != null && (dVar == this.f114628a || dVar == this.f114629b)) && !dVar.b() && j3 > 0) {
                com.tencent.hlyyb.common.a.e eVar2 = new com.tencent.hlyyb.common.a.e(0, "");
                if (h.this.E != null) {
                    if (dVar.f114487i.f114640i == h.this.E) {
                        if (h.this.f114601k == -1) {
                            h hVar = h.this;
                            if (!hVar.f114590e0) {
                                long j16 = hVar.f114599j;
                                if (j16 > 0 && j3 != j16) {
                                    f(j3, eVar2);
                                    eVar = eVar2;
                                    z17 = false;
                                    if (eVar.f114336a == 0) {
                                        if (!h.this.W && !h.this.G()) {
                                            h hVar2 = h.this;
                                            hVar2.a(z17, hVar2.f114626y, h.this.f114627z, DownloaderTaskStatus.FAILED);
                                        }
                                        h.this.L.a(c.a.f114474c);
                                    }
                                }
                                z17 = false;
                                eVar = eVar2;
                                g(dVar, j3, z16, str2, str3, str4, str5, eVar);
                                if (eVar.f114336a == 0) {
                                }
                            } else {
                                if (hVar.f114608n0 != -1) {
                                    if (j3 != h.this.f114608n0) {
                                        if (h.this.f114589e.a() > 0) {
                                            h(aVar, j3, eVar2);
                                            eVar = eVar2;
                                            z17 = false;
                                            if (eVar.f114336a == 0) {
                                            }
                                        }
                                        f(j3, eVar2);
                                        eVar = eVar2;
                                        z17 = false;
                                        if (eVar.f114336a == 0) {
                                        }
                                    } else {
                                        eVar = eVar2;
                                        z17 = false;
                                        g(dVar, h.this.f114608n0, z16, str2, str3, str4, str5, eVar);
                                        if (eVar.f114336a == 0) {
                                        }
                                    }
                                }
                                z17 = false;
                                eVar = eVar2;
                                g(dVar, j3, z16, str2, str3, str4, str5, eVar);
                                if (eVar.f114336a == 0) {
                                }
                            }
                        } else {
                            eVar = eVar2;
                            if (j3 != h.this.f114601k) {
                                if (h.this.f114589e.a() > 0) {
                                    h(aVar, j3, eVar);
                                } else if (h.this.f114599j > 0) {
                                    f(j3, eVar);
                                } else {
                                    eVar.f114336a = -43;
                                    str6 = "detectLength:" + h.this.f114601k + ",rspLength:" + j3;
                                    eVar.f114337b = str6;
                                }
                            } else if (!h.this.f114613q) {
                                eVar.f114336a = 1;
                                str6 = "not support range";
                                eVar.f114337b = str6;
                            }
                        }
                        if (eVar.f114336a == 0 && !TextUtils.isEmpty(str)) {
                            int i3 = aVar.f114532b;
                            if (i3 != a.EnumC5821a.f114538b && i3 != a.EnumC5821a.f114537a) {
                                if (i3 == a.EnumC5821a.f114543g) {
                                    h.this.f114589e.p(com.tencent.hlyyb.common.a.a.b(), str);
                                }
                            }
                            h.this.f114589e.i(com.tencent.hlyyb.common.a.a.b(), str);
                        }
                        return eVar;
                    }
                }
                eVar2.f114336a = 2;
                eVar2.f114337b = "not the same divider";
                return eVar2;
            }
            return new com.tencent.hlyyb.common.a.e(4, "");
        }

        @Override // com.tencent.hlyyb.downloader.e.j
        public final boolean b(c.d dVar, long j3, byte[] bArr, int i3, boolean z16) {
            boolean z17;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z26 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, this, dVar, Long.valueOf(j3), bArr, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
            }
            if (dVar != null && (dVar == this.f114628a || dVar == this.f114629b)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
            if (i3 > 0) {
                long j16 = i3;
                h.this.f114621u.addAndGet(j16);
                h.this.f114623v.addAndGet(j16);
            }
            if (h.this.E != null) {
                g gVar = h.this.E;
                i iVar = dVar.f114487i;
                if (iVar.f114640i == gVar) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (z16 && iVar.f114633b == -1 && !h.this.E.b(dVar.f114487i)) {
                        return false;
                    }
                    if (i3 > 0 && !h.this.isPaused()) {
                        try {
                            long j17 = i3;
                            h.this.F.b(dVar.f114487i.f114633b, j3, bArr, j17);
                            dVar.f114487i.f114637f += j17;
                            g gVar2 = h.this.E;
                            long f16 = gVar2.f();
                            if (f16 > 0 && f16 == gVar2.f114569a) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (z19) {
                                h.this.N.b();
                                com.tencent.hlyyb.downloader.c.b.f().b();
                            }
                            if (com.tencent.hlyyb.downloader.c.b.f().e() > 4194304) {
                                z26 = true;
                            }
                            if (z26) {
                                h.a(h.this, true);
                                com.tencent.hlyyb.downloader.c.b.f().b();
                                try {
                                    h.b(h.this, true);
                                    synchronized (h.this.R) {
                                        h.this.R.wait(2000L);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        } catch (OutOfMemoryError e16) {
                            e16.printStackTrace();
                            h.this.a(false, -19, "append size:" + i3 + ",buffer size:" + com.tencent.hlyyb.downloader.c.b.f().e(), DownloaderTaskStatus.FAILED);
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.hlyyb.downloader.e.j
        public final void c(c.d dVar) {
            boolean z16;
            i iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
                return;
            }
            if (dVar != null && (dVar == this.f114628a || dVar == this.f114629b)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || (iVar = dVar.f114487i) == null) {
                return;
            }
            iVar.f114639h = false;
        }

        @Override // com.tencent.hlyyb.downloader.e.j
        public final void d(c.d dVar) {
            boolean z16;
            boolean z17;
            c.d dVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
                return;
            }
            boolean z18 = true;
            if (dVar != null && (dVar == this.f114628a || dVar == this.f114629b)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
            synchronized (h.this.X) {
                c.d dVar3 = this.f114628a;
                if ((dVar3 == null || dVar3.i()) && (!h.this.f114590e0 || (dVar2 = this.f114629b) == null || dVar2.i())) {
                    z17 = true;
                }
                z17 = false;
            }
            if (z17 && !h.this.K) {
                g gVar = h.this.E;
                long f16 = gVar.f();
                if (f16 <= 0 || f16 != gVar.f114569a) {
                    z18 = false;
                }
                if (z18) {
                    return;
                }
                h.this.f114626y = dVar.e();
                h.this.f114627z = dVar.f();
                if (h.this.f114626y == 0) {
                    h hVar = h.this;
                    hVar.f114626y = -69;
                    hVar.f114627z = "readLen:" + h.this.E.f();
                }
                h.this.L.a(DownloaderTaskStatus.FAILED);
            }
        }

        @Override // com.tencent.hlyyb.downloader.e.j
        public final i e(c.d dVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (i) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            }
            if (dVar != null && (dVar == this.f114628a || dVar == this.f114629b)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !h.this.f114613q) {
                return null;
            }
            return h.this.E.a();
        }

        public final synchronized com.tencent.hlyyb.common.a.e i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.hlyyb.common.a.e) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            h.this.f114620t0 = SystemClock.elapsedRealtime();
            com.tencent.hlyyb.common.a.e eVar = new com.tencent.hlyyb.common.a.e(0, "");
            com.tencent.hlyyb.downloader.e.f.b bVar = h.this.f114589e;
            h hVar = h.this;
            c.d dVar = new c.d(bVar, true, hVar, this, hVar.f114595h, hVar.f114590e0);
            this.f114628a = dVar;
            try {
                List<com.tencent.hlyyb.downloader.b.c> list = h.this.f114602k0;
                Map<com.tencent.hlyyb.downloader.e.f.a, com.tencent.hlyyb.downloader.b.c> map = h.this.f114604l0;
                Map<com.tencent.hlyyb.downloader.e.f.a, List<String>> map2 = h.this.f114606m0;
                h hVar2 = h.this;
                dVar.b(list, map, map2, hVar2, hVar2.f114610o0, h.this.f114612p0, h.this.f114620t0);
                com.tencent.hlyyb.downloader.f.a.a().a(this.f114628a);
            } catch (Exception e16) {
                this.f114628a = null;
                eVar.f114336a = -67;
                e16.printStackTrace();
            }
            if (eVar.f114336a == 0 && !h.this.isEaseTask()) {
                com.tencent.hlyyb.downloader.e.f.b bVar2 = h.this.f114589e;
                h hVar3 = h.this;
                c.d dVar2 = new c.d(bVar2, false, hVar3, this, hVar3.f114595h, hVar3.f114590e0);
                this.f114629b = dVar2;
                try {
                    List<com.tencent.hlyyb.downloader.b.c> list2 = h.this.f114602k0;
                    Map<com.tencent.hlyyb.downloader.e.f.a, com.tencent.hlyyb.downloader.b.c> map3 = h.this.f114604l0;
                    Map<com.tencent.hlyyb.downloader.e.f.a, List<String>> map4 = h.this.f114606m0;
                    h hVar4 = h.this;
                    dVar2.b(list2, map3, map4, hVar4, hVar4.f114610o0, h.this.f114612p0, h.this.f114620t0);
                    com.tencent.hlyyb.downloader.f.a.a().b(this.f114629b);
                } catch (Exception unused) {
                    this.f114629b = null;
                }
            }
            return eVar;
        }

        public /* synthetic */ b(h hVar, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, hVar, Byte.valueOf(b16));
        }

        @Override // com.tencent.hlyyb.downloader.e.j
        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? h.this.f114601k != -1 : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
    }

    public h(com.tencent.hlyyb.downloader.e.f.b bVar, String str, String str2, DownloaderTaskListener downloaderTaskListener, long j3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        byte b16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, str, str2, downloaderTaskListener, Long.valueOf(j3), str3);
            return;
        }
        this.f114581a = -1;
        this.f114583b = "";
        this.f114585c = "";
        this.f114587d = "";
        this.f114591f = DownloaderTaskCategory.Cate_DefaultMass;
        this.f114593g = true;
        this.f114595h = new HashMap();
        this.f114597i = DownloaderTaskPriority.NORMAL;
        this.f114599j = -1L;
        this.f114601k = -1L;
        this.f114603l = 0L;
        this.f114605m = "";
        this.f114607n = "";
        this.f114609o = "";
        this.f114611p = 0L;
        this.f114613q = true;
        this.f114615r = "";
        this.f114617s = "";
        this.f114619t = null;
        this.f114621u = new AtomicLong(0L);
        this.f114623v = new AtomicLong(0L);
        this.f114624w = 0;
        this.f114625x = false;
        this.f114626y = 0;
        this.f114627z = "";
        this.A = -1L;
        this.B = -1L;
        this.C = -1L;
        this.D = -1L;
        this.K = false;
        this.L = new c(this);
        this.M = false;
        this.O = 0;
        this.P = false;
        this.Q = new AtomicInteger(0);
        this.R = new Object();
        this.S = false;
        this.T = false;
        this.U = "";
        this.W = false;
        this.X = new b(this, b16);
        this.f114582a0 = -1;
        this.f114586c0 = 0L;
        this.f114588d0 = 0L;
        this.f114590e0 = true;
        this.f114592f0 = "";
        this.f114594g0 = false;
        this.f114596h0 = false;
        this.f114598i0 = false;
        this.f114600j0 = new LinkedHashMap();
        this.f114602k0 = Collections.synchronizedList(new ArrayList());
        this.f114604l0 = new ConcurrentHashMap();
        this.f114606m0 = new ConcurrentHashMap();
        this.f114608n0 = -1L;
        this.f114610o0 = new AtomicInteger(0);
        this.f114612p0 = new AtomicInteger(0);
        this.f114614q0 = new Object();
        this.f114616r0 = new com.tencent.hlyyb.downloader.b.b();
        this.f114618s0 = 0L;
        this.f114620t0 = 0L;
        this.f114622u0 = -1;
        this.f114589e = bVar;
        this.f114605m = str;
        this.f114607n = str2;
        this.L.a(downloaderTaskListener);
        this.f114599j = j3 > 0 ? j3 : -1L;
        TextUtils.isEmpty(str3);
        this.f114619t = com.tencent.hlyyb.common.b.a.a("" + com.tencent.hlyyb.common.b.b.b() + com.tencent.hlyyb.common.b.b.c() + System.currentTimeMillis() + this.f114589e.f114548a.f114531a + com.tencent.hlyyb.common.b.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        File file;
        String message;
        String message2;
        String str;
        String str2;
        String str3;
        synchronized (h.class) {
            this.f114600j0.put("point0", 0L);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            new File(this.f114605m).mkdirs();
            if (!com.tencent.hlyyb.downloader.a.b.g(this.f114607n)) {
                this.f114609o = com.tencent.hlyyb.common.a.e.a(this.f114589e.f114548a.f114531a, this.f114615r, this.f114617s, "");
                File file2 = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.f(this.f114609o));
                File file3 = new File(this.f114605m, this.f114609o);
                if (file2.exists() || file3.exists()) {
                    int lastIndexOf = this.f114609o.lastIndexOf(".");
                    if (lastIndexOf > 0 && this.f114609o.length() > lastIndexOf + 1) {
                        str = this.f114609o.substring(0, lastIndexOf);
                        str2 = this.f114609o.substring(lastIndexOf);
                    } else {
                        str = this.f114609o;
                        str2 = "";
                    }
                    int i3 = 2;
                    while (true) {
                        str3 = str + "(" + i3 + ")" + str2;
                        File file4 = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.f(str3));
                        File file5 = new File(this.f114605m, str3);
                        if (!file4.exists() && !file5.exists()) {
                            break;
                        }
                        i3++;
                    }
                    this.f114609o = str3;
                }
            } else {
                this.f114609o = this.f114607n;
            }
            this.f114600j0.put("point1", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (this.f114593g) {
                file = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.f(this.f114609o));
            } else {
                file = new File(this.f114605m, this.f114609o);
            }
            this.G = file;
            this.I = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.e(this.f114609o));
            boolean z16 = true;
            try {
                this.J = new a(this.I, "rw");
                this.f114600j0.put("point2", Long.valueOf(System.currentTimeMillis() - valueOf2.longValue()));
                Long valueOf3 = Long.valueOf(System.currentTimeMillis());
                try {
                    this.H = new a(this.G, "rw");
                    this.f114600j0.put("point3", Long.valueOf(System.currentTimeMillis() - valueOf3.longValue()));
                    this.f114600j0.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(System.currentTimeMillis()).longValue()));
                    System.currentTimeMillis();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    this.f114626y = -49;
                    this.f114627z = "initFileOnDetected...create RandomAccessFile of path:" + this.G.getAbsolutePath() + " fail.|" + e16;
                    if (com.tencent.hlyyb.common.a.e.a(e16)) {
                        this.f114626y = -12;
                    } else {
                        if (!(e16 instanceof IOException) || (message2 = e16.getMessage()) == null || !message2.contains("Read-only file system")) {
                            z16 = false;
                        }
                        if (z16) {
                            this.f114626y = -13;
                        }
                    }
                    K();
                    return false;
                }
            } catch (Exception e17) {
                this.f114626y = -49;
                this.f114627z = "initFileOnDetected...create RandomAccessFile of path:" + this.I.getAbsolutePath() + " fail.|" + e17;
                if (com.tencent.hlyyb.common.a.e.a(e17)) {
                    this.f114626y = -12;
                } else {
                    if (!(e17 instanceof IOException) || (message = e17.getMessage()) == null || !message.contains("Read-only file system")) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f114626y = -13;
                    }
                }
                K();
                return false;
            }
        }
        return true;
    }

    private void H() {
        try {
            synchronized (this.R) {
                this.R.notifyAll();
                this.S = false;
            }
        } catch (Exception unused) {
        }
    }

    private void I() {
        boolean z16;
        f();
        synchronized (this.L) {
            if (this.L.a() != DownloaderTaskStatus.PAUSED) {
                if (this.f114593g) {
                    z16 = false;
                    for (int i3 = 0; i3 < 3; i3++) {
                        File file = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.f(this.f114609o));
                        File file2 = new File(this.f114605m, this.f114609o);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        z16 = file.renameTo(file2);
                        if (z16) {
                            break;
                        }
                        SystemClock.sleep(50L);
                    }
                } else {
                    z16 = true;
                }
                if (z16) {
                    k();
                    g();
                    this.L.a(DownloaderTaskStatus.COMPLETE);
                } else {
                    a(false, -72, "", DownloaderTaskStatus.FAILED);
                }
            }
        }
    }

    private synchronized void J() {
        File file;
        g gVar = this.E;
        if (gVar != null && (file = this.G) != null && this.I != null) {
            gVar.f114571c = file.lastModified();
            this.E.f114572d = this.f114611p;
            this.E.f114573e = this.f114621u.get();
            a(this.E.c());
        }
    }

    private synchronized void K() {
        RandomAccessFile randomAccessFile = this.H;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            this.H = null;
        }
        RandomAccessFile randomAccessFile2 = this.J;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            this.J = null;
        }
    }

    private String c() {
        String str;
        try {
            String str2 = this.f114592f0;
            if (str2 == null || str2.length() == 0) {
                this.J.seek(0L);
                str = this.J.readUTF();
            } else {
                str = this.f114592f0;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    private int h() {
        int i3;
        if (com.tencent.hlyyb.common.a.a.f() != 1) {
            return 20971520;
        }
        if (this.f114601k <= 0 || (i3 = (int) (this.f114601k * 0.2d)) <= 41943040) {
            return 41943040;
        }
        return i3;
    }

    private boolean j() {
        try {
            File file = new File(getSaveDir(), com.tencent.hlyyb.downloader.a.b.f(this.f114609o));
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String A() {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        String str4 = "1";
        if (this.f114589e.u()) {
            str = "1";
        } else {
            str = "0";
        }
        if (this.f114589e.a() <= 0) {
            str2 = "0";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f114589e.a());
            str2 = sb5.toString();
        }
        List<com.tencent.hlyyb.downloader.d.a> s16 = this.f114589e.s();
        if (s16 != null && s16.size() > 0 && !TextUtils.isEmpty(this.f114589e.r())) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        if (TextUtils.isEmpty(this.f114589e.n())) {
            str4 = "0";
        }
        return str + "," + str2 + "," + str3 + "," + str4;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String B() {
        boolean z16;
        boolean z17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (String) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        com.tencent.hlyyb.downloader.b.b bVar = this.f114616r0;
        g gVar = this.E;
        List<com.tencent.hlyyb.downloader.b.c> list = this.f114602k0;
        int i3 = this.f114622u0;
        long j3 = this.f114618s0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(bVar.f114400a);
        sb5.append(",");
        sb5.append(bVar.f114401b);
        sb5.append(",");
        sb5.append(bVar.f114403d);
        sb5.append(",");
        sb5.append(bVar.f114402c);
        sb5.append(",");
        sb5.append(bVar.f114404e);
        sb5.append(",");
        sb5.append(bVar.f114405f);
        sb5.append(",");
        Iterator<com.tencent.hlyyb.downloader.b.c> it = list.iterator();
        while (true) {
            z16 = true;
            if (it.hasNext()) {
                if (it.next().f114412f) {
                    z17 = true;
                    break;
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (list.size() > 0) {
            Iterator<com.tencent.hlyyb.downloader.b.c> it5 = list.iterator();
            while (it5.hasNext()) {
                if (!it5.next().f114412f) {
                }
            }
            int b16 = gVar.b();
            sb5.append(0);
            sb5.append(",");
            String str2 = "1";
            Object obj = "0";
            if (!z17) {
                str = "1";
            } else {
                str = "0";
            }
            sb5.append(str);
            sb5.append(",");
            if (!z16) {
                str2 = "0";
            }
            sb5.append(str2);
            sb5.append(",");
            sb5.append(b16);
            sb5.append(",");
            if (j3 > 0) {
                obj = Long.valueOf(j3);
            }
            sb5.append(obj);
            sb5.append(",");
            sb5.append(i3);
            return sb5.toString();
        }
        z16 = false;
        int b162 = gVar.b();
        sb5.append(0);
        sb5.append(",");
        String str22 = "1";
        Object obj2 = "0";
        if (!z17) {
        }
        sb5.append(str);
        sb5.append(",");
        if (!z16) {
        }
        sb5.append(str22);
        sb5.append(",");
        sb5.append(b162);
        sb5.append(",");
        if (j3 > 0) {
        }
        sb5.append(obj2);
        sb5.append(",");
        sb5.append(i3);
        return sb5.toString();
    }

    public final String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (String) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f114602k0.size() > 0) {
            Iterator<com.tencent.hlyyb.downloader.b.c> it = this.f114602k0.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().f114425s.toString());
                sb5.append(";");
            }
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public final String D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (String) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f114602k0.size() > 0) {
            Iterator<com.tencent.hlyyb.downloader.b.c> it = this.f114602k0.iterator();
            while (it.hasNext()) {
                String b16 = it.next().b();
                if (!TextUtils.isEmpty(b16)) {
                    sb5.append(b16);
                    sb5.append(";");
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        return sb5.toString();
    }

    public final void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
            return;
        }
        if (!this.f114594g0) {
            return;
        }
        File file = new File(this.f114605m, this.f114609o);
        if (!file.exists()) {
            return;
        }
        try {
            com.tencent.hlyyb.common.b.a.a(file);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return ((Integer) iPatchRedirector.redirect((short) 86, (Object) this)).intValue();
        }
        return this.f114589e.f114556i;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equalsIgnoreCase(DownloaderConstant.KEY_RANGE)) {
            this.f114595h.put(str, str2);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void addListener(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloaderTaskListener);
        } else {
            this.L.a(downloaderTaskListener);
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(h hVar) {
        h hVar2 = hVar;
        int ordinal = hVar2.f114597i.ordinal() - this.f114597i.ordinal();
        if (ordinal == 0) {
            return (int) (this.A - hVar2.A);
        }
        return ordinal;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getAverageSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        if (this.f114611p > 10 && this.f114601k > 0) {
            return (int) ((getReceivedLength() * 1000) / this.f114611p);
        }
        return -1;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final DownloaderTaskCategory getCategory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (DownloaderTaskCategory) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        return this.f114591f;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getContentDisposition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.f114617s;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getContentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.f114615r;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Long) iPatchRedirector.redirect((short) 37, (Object) this)).longValue();
        }
        return this.f114611p;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getFailCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.f114626y;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final synchronized String getFailInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.f114627z;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getHtmlUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.f114627z;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f114583b;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getInitSaveName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f114607n;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getKnownSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Long) iPatchRedirector.redirect((short) 50, (Object) this)).longValue();
        }
        return this.f114599j;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getPercentage() {
        int i3;
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        long totalLength = getTotalLength();
        if (totalLength == -1 && (gVar = this.E) != null) {
            totalLength = gVar.f114569a;
        }
        g gVar2 = this.E;
        int i16 = 0;
        if (gVar2 != null) {
            i3 = gVar2.i();
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

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final DownloaderTaskPriority getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (DownloaderTaskPriority) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f114597i;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getRealSaveName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f114609o;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getRealTimeSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        if (this.L.a() != DownloaderTaskStatus.STARTED && this.L.a() != DownloaderTaskStatus.DOWNLOADING) {
            return 0;
        }
        return this.f114624w;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getReceivedLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        g gVar = this.E;
        if (gVar != null) {
            long h16 = gVar.h();
            if (h16 > this.f114603l && h16 <= this.E.f114569a) {
                return h16;
            }
        }
        return this.f114603l;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getSaveDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f114605m;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getSavePath() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        try {
            str = new File(this.f114605m, this.f114609o).getAbsolutePath();
        } catch (Exception unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return this.f114605m + "/" + this.f114609o;
        }
        return str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Long) iPatchRedirector.redirect((short) 69, (Object) this)).longValue();
        }
        return this.B;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final DownloaderTaskStatus getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (DownloaderTaskStatus) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.L.a();
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final Object getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return this.V;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final long getTotalLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        if (this.f114589e.a() > 0) {
            return this.f114589e.a();
        }
        long j3 = this.f114599j;
        if (j3 > 0) {
            return j3;
        }
        if (this.f114601k > 0) {
            return this.f114601k;
        }
        try {
            return this.E.f114569a;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f114581a;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getUniqueKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f114619t;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f114589e.f114548a.f114531a;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.L.a() == DownloaderTaskStatus.COMPLETE) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isDeleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (this.L.a() == DownloaderTaskStatus.DELETED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isEaseTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Boolean) iPatchRedirector.redirect((short) 75, (Object) this)).booleanValue();
        }
        if (this.f114591f == DownloaderTaskCategory.Cate_DefaultEase) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (this.L.a() == DownloaderTaskStatus.FAILED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if (this.L.a() == DownloaderTaskStatus.PAUSED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isPausedOnMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Boolean) iPatchRedirector.redirect((short) 80, (Object) this)).booleanValue();
        }
        return this.f114598i0;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.L.a() != DownloaderTaskStatus.STARTED && this.L.a() != DownloaderTaskStatus.DOWNLOADING) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isSupportRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f114613q;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isUsingTempFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return this.f114593g;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean isWaiting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (this.L.a() == DownloaderTaskStatus.PENDING) {
            return true;
        }
        return false;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 44)) ? this.L.f() : ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void pause() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        DownloaderTaskStatus a16 = this.L.a();
        if (a16 == DownloaderTaskStatus.PENDING || a16 == DownloaderTaskStatus.STARTED || a16 == DownloaderTaskStatus.DOWNLOADING) {
            g gVar = this.E;
            if (gVar != null) {
                long f16 = gVar.f();
                if (f16 > 0 && f16 == gVar.f114569a) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            }
            a(true, 0, "", DownloaderTaskStatus.PAUSED);
            try {
                com.tencent.hlyyb.common.a.d dVar = this.f114584b0;
                if (dVar != null) {
                    dVar.b();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return this.O;
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        return this.P;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void removeAllListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.L.b();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void removeListener(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloaderTaskListener);
        } else {
            this.L.b(downloaderTaskListener);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final boolean resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        synchronized (this.L) {
            DownloaderTaskStatus a16 = this.L.a();
            if (a16 != DownloaderTaskStatus.STARTED && a16 != DownloaderTaskStatus.DOWNLOADING && a16 != DownloaderTaskStatus.COMPLETE && a16 != DownloaderTaskStatus.PENDING) {
                if (a16 != DownloaderTaskStatus.DELETED && !this.L.e()) {
                    this.f114625x = false;
                    this.K = false;
                    this.f114613q = true;
                    this.f114624w = 0;
                    this.f114598i0 = false;
                    o();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f114626y = 0;
        this.f114627z = "";
        this.B = System.currentTimeMillis();
        this.C = SystemClock.elapsedRealtime();
        this.f114618s0 = 0L;
        this.f114602k0.clear();
        this.f114604l0.clear();
        this.f114606m0.clear();
        this.f114610o0.set(0);
        this.f114612p0.set(0);
        this.f114616r0 = new com.tencent.hlyyb.downloader.b.b();
        this.f114588d0 = 0L;
        synchronized (this.X) {
            this.f114601k = -1L;
        }
        this.T = false;
        this.f114582a0 = -1;
        this.f114623v.set(0L);
        if (this.K) {
            return;
        }
        this.L.c();
        this.F = new d();
        com.tencent.hlyyb.downloader.e.a aVar = new com.tencent.hlyyb.downloader.e.a(this);
        this.N = aVar;
        aVar.a();
        boolean m3 = m();
        this.L.a(DownloaderTaskStatus.STARTED);
        this.Z = new com.tencent.hlyyb.downloader.e.d.a();
        a(com.tencent.hlyyb.common.a.a.f(), com.tencent.hlyyb.common.a.a.b());
        if (!m3) {
            a(false, this.f114626y, this.f114627z, DownloaderTaskStatus.FAILED);
        } else if (this.E.e()) {
            this.f114603l = this.E.f114569a;
            I();
        } else {
            com.tencent.hlyyb.common.a.e i3 = this.X.i();
            int i16 = i3.f114336a;
            if (i16 != 0) {
                a(false, i16, i3.f114337b, DownloaderTaskStatus.FAILED);
            }
        }
        this.L.d();
        d dVar = this.F;
        if (dVar != null) {
            dVar.d();
        }
        K();
        if (this.M) {
            k();
            i();
            if (this.f114593g) {
                j();
            }
        } else if (isCompleted() || this.f114626y == -75) {
            k();
        }
        d();
        this.f114623v.set(0L);
        this.Z = null;
        b bVar = this.X;
        bVar.f114628a = null;
        bVar.f114629b = null;
    }

    public final long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Long) iPatchRedirector.redirect((short) 48, (Object) this)).longValue();
        }
        com.tencent.hlyyb.downloader.e.a aVar = this.N;
        if (aVar != null) {
            return aVar.d();
        }
        return -1L;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setApkId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f114587d = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setAppId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f114585c = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setAppScene(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.Y = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setBakUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) str);
        } else {
            this.f114589e.h(str);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setCategory(DownloaderTaskCategory downloaderTaskCategory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) downloaderTaskCategory);
        } else if (downloaderTaskCategory != null) {
            this.f114591f = downloaderTaskCategory;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setFullApkSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, j3);
        } else {
            this.f114586c0 = j3;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f114583b = str;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setMultiSectionOn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, z16);
        } else {
            this.f114590e0 = z16;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setNotPreOccupySpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setNotUseTempFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
        } else {
            this.f114593g = false;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setPauseTaskOnMobile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, z16);
        } else {
            this.f114596h0 = z16;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setPriority(DownloaderTaskPriority downloaderTaskPriority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) downloaderTaskPriority);
        } else if (this.f114597i != downloaderTaskPriority) {
            this.f114597i = downloaderTaskPriority;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setReportMd5(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, z16);
        } else {
            this.f114594g0 = z16;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setTag(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, obj);
        } else {
            this.V = obj;
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTask
    public final void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, i3);
        } else {
            this.f114581a = i3;
        }
    }

    public final long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Long) iPatchRedirector.redirect((short) 49, (Object) this)).longValue();
        }
        d dVar = this.F;
        if (dVar != null) {
            return dVar.a();
        }
        return 0L;
    }

    public final long u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Long) iPatchRedirector.redirect((short) 56, (Object) this)).longValue();
        }
        g gVar = this.E;
        if (gVar != null) {
            return gVar.g();
        }
        return 0L;
    }

    public final String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        com.tencent.hlyyb.downloader.e.d.a aVar = this.Z;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public final String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        com.tencent.hlyyb.downloader.e.f.b bVar = this.f114589e;
        if (bVar != null) {
            return bVar.v();
        }
        return "";
    }

    public final String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (String) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        b bVar = this.X;
        if (bVar != null) {
            StringBuilder sb5 = new StringBuilder();
            c.d dVar = bVar.f114628a;
            if (dVar != null) {
                sb5.append(dVar.j());
            }
            c.d dVar2 = bVar.f114629b;
            if (dVar2 != null) {
                sb5.append(dVar2.j());
            }
            return sb5.toString();
        }
        return "";
    }

    public final String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (String) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        b bVar = this.X;
        if (bVar != null) {
            StringBuilder sb5 = new StringBuilder();
            c.d dVar = bVar.f114628a;
            if (dVar != null) {
                sb5.append(dVar.k());
            }
            c.d dVar2 = bVar.f114629b;
            if (dVar2 != null) {
                sb5.append(dVar2.k());
            }
            return sb5.toString();
        }
        return "";
    }

    public final String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (String) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        b bVar = this.X;
        if (bVar != null) {
            StringBuilder sb5 = new StringBuilder();
            c.d dVar = bVar.f114628a;
            if (dVar != null) {
                sb5.append(dVar.l());
            }
            c.d dVar2 = bVar.f114629b;
            if (dVar2 != null) {
                sb5.append(dVar2.l());
            }
            return sb5.toString();
        }
        return "";
    }

    private void d() {
        this.f114604l0.clear();
        synchronized (this.f114602k0) {
            this.f114602k0.clear();
        }
        this.f114606m0.clear();
    }

    private void e() {
        f();
        c.d dVar = this.X.f114628a;
        if (dVar != null) {
            dVar.a(false);
        }
        c.d dVar2 = this.X.f114629b;
        if (dVar2 != null) {
            dVar2.a(false);
        }
    }

    private void f() {
        synchronized (this.f114602k0) {
            Iterator<com.tencent.hlyyb.downloader.b.c> it = this.f114602k0.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    private void g() {
        List<com.tencent.hlyyb.downloader.d.a> s16 = this.f114589e.s();
        if (this.f114589e.a() < 0) {
            this.f114622u0 = -2;
            return;
        }
        if (s16 == null || s16.size() <= 0) {
            this.f114622u0 = -3;
            return;
        }
        if (TextUtils.isEmpty(this.f114589e.r())) {
            this.f114622u0 = -3;
            return;
        }
        SystemClock.elapsedRealtime();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a aVar = new a(new File(this.f114605m, this.f114609o), "r");
            for (com.tencent.hlyyb.downloader.d.a aVar2 : s16) {
                long j3 = aVar2.f114444a;
                int i3 = aVar2.f114445b;
                byte[] bArr = new byte[i3];
                aVar.seek(j3);
                aVar.read(bArr, 0, i3);
                byteArrayOutputStream.write(bArr, 0, i3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (com.tencent.hlyyb.common.b.b.a(byteArray)) {
                this.f114622u0 = -4;
            }
            String a16 = com.tencent.hlyyb.common.b.a.a(byteArray);
            if (TextUtils.isEmpty(a16)) {
                this.f114622u0 = -5;
            } else if (a16.toLowerCase().equals(this.f114589e.r().toLowerCase())) {
                this.f114622u0 = 1;
            } else {
                this.f114622u0 = 0;
            }
            try {
                byteArrayOutputStream.close();
                aVar.close();
            } catch (IOException unused) {
                SystemClock.elapsedRealtime();
            }
        } catch (IOException e16) {
            this.f114622u0 = -4;
            e16.printStackTrace();
        }
    }

    private boolean i() {
        try {
            File file = new File(getSavePath());
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean k() {
        try {
            File file = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.e(this.f114609o));
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean l() {
        String message;
        String message2;
        try {
            this.J = new a(this.I, "rw");
            try {
                this.H = new a(this.G, "rw");
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                this.f114626y = -49;
                this.f114627z = "initFileOnStart...create RandomAccessFile of path:" + this.G.getAbsolutePath() + " fail.|" + e16;
                if (com.tencent.hlyyb.common.a.e.a(e16)) {
                    this.f114626y = -12;
                } else {
                    if ((e16 instanceof IOException) && (message2 = e16.getMessage()) != null && message2.contains("Read-only file system")) {
                        this.f114626y = -13;
                    }
                }
                K();
                return false;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            this.f114626y = -49;
            this.f114627z = "initFileOnStart...create RandomAccessFile of path:" + this.I.getAbsolutePath() + " fail.|" + e17;
            if (com.tencent.hlyyb.common.a.e.a(e17)) {
                this.f114626y = -12;
            } else {
                if ((e17 instanceof IOException) && (message = e17.getMessage()) != null && message.contains("Read-only file system")) {
                    this.f114626y = -13;
                }
            }
            K();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e3, code lost:
    
        if (r7.d() <= r15.E.f114569a) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m() {
        int i3;
        boolean z16;
        boolean z17;
        try {
            new File(this.f114605m).mkdirs();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.G = null;
        this.I = null;
        g gVar = this.E;
        if (gVar != null) {
            if (gVar.d() > 0 && !TextUtils.isEmpty(this.f114609o)) {
                this.G = this.f114593g ? new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.f(this.f114609o)) : new File(this.f114605m, this.f114609o);
                this.I = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.e(this.f114609o));
                z16 = true;
                i3 = 0;
            }
            z16 = false;
            i3 = 0;
        } else {
            if (com.tencent.hlyyb.downloader.a.b.g(this.f114607n)) {
                this.G = this.f114593g ? new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.f(this.f114607n)) : new File(this.f114605m, this.f114607n);
                this.I = new File(this.f114605m, com.tencent.hlyyb.downloader.a.b.e(this.f114607n));
                i3 = 1;
                z16 = false;
            }
            z16 = false;
            i3 = 0;
        }
        if ((z16 || i3 != 0) && this.G.exists()) {
            if (!l()) {
                return false;
            }
            String c16 = c();
            this.E = new g(c16);
            if (!TextUtils.isEmpty(c16) && this.E.f114576h) {
                long lastModified = this.G.lastModified();
                if (i3 != 0 && lastModified >= this.E.f114571c) {
                    g gVar2 = this.E;
                    if (gVar2.f114569a > 0) {
                    }
                }
                if (!z16 || lastModified < this.E.f114571c) {
                    z17 = false;
                    if (z17) {
                        this.U = "resume failed. cfg:" + c16 + ",flm:" + lastModified + ",from:" + (i3 ^ 1);
                    } else {
                        if (TextUtils.isEmpty(this.f114609o)) {
                            this.f114609o = this.f114607n;
                        }
                        this.f114611p = this.E.f114572d;
                        this.f114621u.set(this.E.f114573e);
                        if (i3 != 0 && this.E.f114569a > 0) {
                            this.T = true;
                        }
                    }
                    if (!z17) {
                        K();
                        this.f114601k = -1L;
                        this.f114609o = "";
                        this.f114611p = 0L;
                        this.f114621u.set(0L);
                        this.f114613q = true;
                        this.f114615r = "";
                        this.f114617s = "";
                        this.f114624w = 0;
                        this.f114625x = false;
                        this.f114626y = 0;
                        this.f114627z = "";
                        this.E = new g("");
                        this.T = false;
                    }
                    this.W = z17;
                    return true;
                }
                z17 = true;
                if (z17) {
                }
                if (!z17) {
                }
                this.W = z17;
                return true;
            }
            this.U = "resume failed. cfg:" + c16;
        }
        z17 = false;
        if (!z17) {
        }
        this.W = z17;
        return true;
    }

    @Override // com.tencent.hlyyb.downloader.a.a
    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) ? this.K : ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
    }

    public final boolean n() {
        boolean z16;
        StringBuilder sb5;
        int i3;
        String message;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.K || isPaused() || isDeleted() || isCompleted() || isFailed()) {
            d dVar = this.F;
            if (dVar != null) {
                dVar.d();
            }
            K();
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i16 = 0;
        while (!this.K && !isPaused() && !isDeleted() && !isCompleted() && !isFailed()) {
            if (SystemClock.elapsedRealtime() - elapsedRealtime > com.tencent.hlyyb.downloader.a.b.f114398f) {
                this.Q.getAndIncrement();
                break;
            }
            synchronized (this.f114614q0) {
                d.a c16 = this.F.c();
                if (c16 == null) {
                    break;
                }
                i a16 = this.E.a(c16.f114493a);
                if (a16 == null) {
                    sb5 = new StringBuilder("inner error: getRange null for sectionId:");
                } else if (a16.f114636e != c16.f114494b) {
                    sb5 = new StringBuilder("inner error: check offset fail for section:");
                    sb5.append(a16);
                    sb5.append(",buffer offset:");
                    sb5.append(c16.f114494b);
                    sb5.append(",sectionId:");
                } else {
                    try {
                        long filePointer = this.H.getFilePointer();
                        long j3 = c16.f114494b;
                        if (filePointer != j3) {
                            this.H.seek(j3);
                        }
                        this.H.write(c16.f114495c, 0, (int) c16.f114496d);
                        long j16 = c16.f114494b;
                        long j17 = c16.f114496d;
                        a16.f114636e = j16 + j17;
                        i16 = (int) (i16 + j17);
                        c16.f114495c = null;
                        if (this.S) {
                            if (com.tencent.hlyyb.downloader.c.b.f().e() < 2097152) {
                                H();
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (!(e16 instanceof NullPointerException)) {
                            if (!this.G.exists()) {
                                i3 = -14;
                            } else if (com.tencent.hlyyb.common.a.e.a(e16)) {
                                i3 = -12;
                            } else {
                                i3 = (e16 instanceof IOException) && (message = e16.getMessage()) != null && message.contains("Read-only file system") ? -17 : -50;
                            }
                            a(false, i3, "saveData fail.|" + e16, DownloaderTaskStatus.FAILED);
                        }
                    }
                }
                sb5.append(c16.f114493a);
                a(false, -42, sb5.toString(), DownloaderTaskStatus.FAILED);
                return false;
            }
        }
        d dVar2 = this.F;
        if (dVar2 != null) {
            dVar2.d();
        }
        z16 = false;
        if (!z16) {
            H();
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        com.tencent.hlyyb.downloader.e.a aVar = this.N;
        if (aVar != null) {
            aVar.a(i16, (int) (elapsedRealtime2 - elapsedRealtime));
        }
        if (i16 > 0) {
            J();
        }
        if (this.K || isPaused() || isDeleted() || isCompleted() || isFailed()) {
            K();
        } else if (this.f114601k > 0) {
            long d16 = this.E.d();
            if (elapsedRealtime2 - this.f114588d0 > com.tencent.hlyyb.downloader.a.b.c() || d16 == this.f114601k) {
                if (i16 > 0 && !this.f114590e0) {
                    try {
                        this.H.getFD().sync();
                    } catch (Throwable unused) {
                    }
                }
                this.f114603l = d16;
                this.E.a(this.f114603l, getPercentage());
                this.L.a(DownloaderTaskStatus.DOWNLOADING);
                this.f114588d0 = elapsedRealtime2;
            }
            if (d16 == this.f114601k) {
                this.N.c();
                this.D = elapsedRealtime2;
                I();
            } else if (d16 > this.f114601k) {
                a(false, -42, "inner error: receivedLength > detectLength:" + d16 + " > " + this.f114601k, DownloaderTaskStatus.FAILED);
                k();
            }
        }
        return z16;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.A = SystemClock.elapsedRealtime();
        try {
            this.L.a(DownloaderTaskStatus.PENDING);
            this.f114584b0 = com.tencent.hlyyb.downloader.f.a.a().a(this, this.f114591f);
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(e16);
            throw new HalleyException(sb5.toString());
        }
    }

    public static /* synthetic */ boolean b(h hVar, boolean z16) {
        hVar.S = true;
        return true;
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
        } else if (this.O < i3) {
            this.O = i3;
        }
    }

    public final void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, i3, (Object) str);
        } else {
            if (!isRunning() || this.Z == null) {
                return;
            }
            this.Z.a(new a.C5820a(System.currentTimeMillis() - this.B, i3, str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:
    
        if (r11 > 0) goto L17;
     */
    @Override // com.tencent.hlyyb.downloader.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, j3);
            return;
        }
        synchronized (this.X) {
            if (this.f114601k == -1) {
                if (j3 <= 0) {
                    j3 = this.f114599j;
                }
                this.f114608n0 = j3;
            } else {
                long j16 = this.f114601k;
                long j17 = this.f114601k;
                if (j3 <= 0) {
                    j3 = this.f114599j;
                    if (j3 <= 0) {
                        j3 = j16;
                    }
                }
                if (this.f114601k != j3) {
                    this.f114601k = -1L;
                    this.f114608n0 = j3;
                    if (this.E != null) {
                        synchronized (this.f114614q0) {
                            long h16 = this.E.h();
                            int i3 = this.E.i();
                            com.tencent.hlyyb.downloader.b.b bVar = this.f114616r0;
                            bVar.f114400a = 1;
                            bVar.f114403d = this.f114582a0;
                            bVar.f114402c = j17;
                            bVar.f114401b = this.f114621u.get();
                            if (this.X.f114628a != null) {
                                this.f114616r0.f114404e = r3.m();
                                String n3 = this.X.f114628a.n();
                                if (!TextUtils.isEmpty(n3)) {
                                    this.f114616r0.f114405f = com.tencent.hlyyb.common.b.b.b(n3);
                                }
                            }
                            this.E = new g("");
                            c.d dVar = this.X.f114628a;
                            if (dVar != null && dVar.R) {
                                this.X.f114628a.g();
                            }
                            d();
                            this.E.a(h16, i3);
                            d dVar2 = this.F;
                            if (dVar2 != null) {
                                dVar2.d();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.hlyyb.downloader.b.a
    public final void a(com.tencent.hlyyb.downloader.e.f.a aVar, com.tencent.hlyyb.downloader.b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 85)) {
            if (this.E != null) {
                List<String> list = this.f114606m0.get(aVar);
                if (list != null && list.size() > 0) {
                    long d16 = this.E.d();
                    char c16 = 1;
                    char c17 = 0;
                    boolean z16 = d16 > ((long) h());
                    if (z16) {
                        this.f114618s0 = d16;
                        e();
                        cVar.c();
                    }
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        String[] split = it.next().split(",");
                        if (split.length == 2) {
                            long parseLong = Long.parseLong(split[c17]);
                            long parseLong2 = Long.parseLong(split[c16]);
                            String str = parseLong + "-" + parseLong2;
                            i iVar = new i(this.E, parseLong, parseLong, parseLong, parseLong2);
                            if (z16) {
                                cVar.b(str);
                            } else {
                                this.E.a(iVar);
                                cVar.a(str);
                            }
                            c16 = 1;
                            c17 = 0;
                        }
                    }
                }
                this.f114606m0.remove(aVar);
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 85, (Object) this, (Object) aVar, (Object) cVar);
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
            return;
        }
        if (isDeleted()) {
            return;
        }
        if (!isRunning() && z16) {
            k();
            i();
            if (this.f114593g) {
                j();
            }
        }
        if (z16) {
            this.M = z16;
        }
        a(true, 0, "", DownloaderTaskStatus.DELETED);
    }

    public final void a(boolean z16, int i3, String str, DownloaderTaskStatus downloaderTaskStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, downloaderTaskStatus);
            return;
        }
        this.K = true;
        this.f114625x = z16;
        if (!z16) {
            this.f114626y = i3;
            this.f114627z = str;
        }
        this.L.a(downloaderTaskStatus);
        f();
        b bVar = this.X;
        try {
            c.d dVar = bVar.f114628a;
            if (dVar != null) {
                dVar.h();
            }
            c.d dVar2 = bVar.f114629b;
            if (dVar2 != null) {
                dVar2.h();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.hlyyb.downloader.e.f
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        if (isRunning()) {
            return n();
        }
        return false;
    }

    @Override // com.tencent.hlyyb.downloader.b.a
    public final boolean a(i iVar, com.tencent.hlyyb.downloader.b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 84)) {
            g gVar = this.E;
            if (gVar != null) {
                long d16 = gVar.d();
                boolean z16 = d16 > ((long) h());
                long j3 = iVar.f114635d;
                long j16 = iVar.f114637f;
                String str = j3 + "-" + j16;
                if (!z16) {
                    this.E.a(new i(this.E, j3, j3, j3, j16));
                    cVar.a(str);
                    return true;
                }
                this.f114618s0 = d16;
                e();
                cVar.c();
                cVar.b(str);
            }
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 84, (Object) this, (Object) iVar, (Object) cVar)).booleanValue();
    }

    public static /* synthetic */ boolean a(h hVar, boolean z16) {
        hVar.P = true;
        return true;
    }

    private boolean a(String str) {
        try {
            this.f114592f0 = str;
            this.J.seek(0L);
            this.J.writeUTF(str);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
