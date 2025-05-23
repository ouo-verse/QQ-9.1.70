package com.tencent.hlyyb.downloader.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.a.d;
import com.tencent.hlyyb.downloader.a.a.a;
import com.tencent.hlyyb.downloader.e.f.a;
import com.tencent.hlyyb.downloader.e.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name */
    public static AtomicInteger f114406u;

    /* renamed from: a, reason: collision with root package name */
    public boolean f114407a;

    /* renamed from: b, reason: collision with root package name */
    public List<c> f114408b;

    /* renamed from: c, reason: collision with root package name */
    public h f114409c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.f.a f114410d;

    /* renamed from: e, reason: collision with root package name */
    public a f114411e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f114412f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f114413g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f114414h;

    /* renamed from: i, reason: collision with root package name */
    public d f114415i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.f.b f114416j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.a.a.d f114417k;

    /* renamed from: l, reason: collision with root package name */
    public List<com.tencent.hlyyb.downloader.d.a> f114418l;

    /* renamed from: m, reason: collision with root package name */
    public int f114419m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f114420n;

    /* renamed from: o, reason: collision with root package name */
    public AtomicInteger f114421o;

    /* renamed from: p, reason: collision with root package name */
    public AtomicInteger f114422p;

    /* renamed from: q, reason: collision with root package name */
    public int f114423q;

    /* renamed from: r, reason: collision with root package name */
    public int f114424r;

    /* renamed from: s, reason: collision with root package name */
    public b f114425s;

    /* renamed from: t, reason: collision with root package name */
    public long f114426t;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        com.tencent.hlyyb.downloader.e.f.a a();

        void a(com.tencent.hlyyb.downloader.e.f.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f114427a;

        /* renamed from: b, reason: collision with root package name */
        public int f114428b;

        /* renamed from: c, reason: collision with root package name */
        public int f114429c;

        /* renamed from: d, reason: collision with root package name */
        public int f114430d;

        /* renamed from: e, reason: collision with root package name */
        public List<String> f114431e;

        /* renamed from: f, reason: collision with root package name */
        public int f114432f;

        /* renamed from: g, reason: collision with root package name */
        public String f114433g;

        /* renamed from: h, reason: collision with root package name */
        public int f114434h;

        /* renamed from: i, reason: collision with root package name */
        public int f114435i;

        /* renamed from: j, reason: collision with root package name */
        public List<String> f114436j;

        /* renamed from: k, reason: collision with root package name */
        public int f114437k;

        /* renamed from: l, reason: collision with root package name */
        public List<String> f114438l;

        /* renamed from: m, reason: collision with root package name */
        public String f114439m;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f114428b = -1;
            this.f114429c = -1;
            this.f114430d = -1;
            this.f114431e = new ArrayList();
            this.f114433g = "";
            this.f114436j = new ArrayList();
            this.f114438l = new ArrayList();
            this.f114439m = "";
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f114427a);
            sb5.append(",");
            sb5.append(this.f114428b);
            sb5.append(",");
            sb5.append(this.f114429c);
            sb5.append(",");
            sb5.append(this.f114430d);
            sb5.append(",");
            if (this.f114431e.size() > 0) {
                Iterator<String> it = this.f114431e.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f114432f);
            sb5.append(",");
            sb5.append(this.f114433g);
            sb5.append(",");
            sb5.append(this.f114434h);
            sb5.append(",");
            sb5.append(this.f114435i);
            sb5.append(",");
            if (this.f114436j.size() > 0) {
                Iterator<String> it5 = this.f114436j.iterator();
                while (it5.hasNext()) {
                    sb5.append(it5.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f114437k);
            sb5.append(",");
            if (this.f114438l.size() > 0) {
                Iterator<String> it6 = this.f114438l.iterator();
                while (it6.hasNext()) {
                    sb5.append(it6.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f114439m);
            return sb5.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f114406u = new AtomicInteger(1);
        }
    }

    public c(h hVar, com.tencent.hlyyb.downloader.e.f.b bVar, com.tencent.hlyyb.downloader.e.f.a aVar, List<c> list, Map<com.tencent.hlyyb.downloader.e.f.a, c> map, a aVar2, boolean z16, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hVar, bVar, aVar, list, map, aVar2, Boolean.valueOf(z16), atomicInteger, atomicInteger2);
            return;
        }
        this.f114412f = false;
        this.f114413g = false;
        this.f114414h = false;
        this.f114419m = -88;
        this.f114420n = false;
        this.f114423q = -1;
        this.f114424r = -1;
        this.f114425s = new b();
        this.f114426t = 0L;
        this.f114409c = hVar;
        this.f114416j = bVar;
        this.f114418l = bVar.s();
        this.f114410d = aVar;
        this.f114408b = list;
        this.f114411e = aVar2;
        this.f114420n = z16;
        this.f114422p = atomicInteger;
        this.f114421o = atomicInteger2;
    }

    private void d() {
        if (this.f114410d.f114532b == a.EnumC5821a.f114546j) {
            this.f114419m = 0;
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<a.C5817a> f16 = f();
        if (f16 != null) {
            String r16 = this.f114416j.r();
            for (int i3 = 0; i3 < f16.size(); i3++) {
                byte[] a16 = a(this.f114410d, f16.get(i3));
                if (a16 != null) {
                    arrayList.add(a16);
                } else {
                    if (this.f114419m != 7) {
                        this.f114419m = 4;
                        return;
                    }
                    return;
                }
            }
            a(arrayList, r16);
            return;
        }
        this.f114419m = 2;
    }

    private List<c> e() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f114408b) {
            for (c cVar : this.f114408b) {
                if (cVar.f114412f) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    private List<a.C5817a> f() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f114418l.size(); i3++) {
            long j3 = this.f114418l.get(i3).f114444a;
            long j16 = (r2.f114445b + j3) - 1;
            if (j3 >= 0 && j3 <= j16) {
                arrayList.add(new a.C5817a(j3, j16));
            } else {
                return null;
            }
        }
        return arrayList;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f114414h = true;
        try {
            com.tencent.hlyyb.downloader.a.a.d dVar = this.f114417k;
            if (dVar != null) {
                dVar.b();
            }
            d dVar2 = this.f114415i;
            if (dVar2 != null) {
                dVar2.b();
            }
        } catch (Exception unused) {
        }
    }

    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int i3 = this.f114419m;
        if (!(i3 == -1) && i3 != 7) {
            return "";
        }
        return "" + this.f114419m + "," + this.f114423q + "," + this.f114410d.f114533c + "," + this.f114424r + "," + com.tencent.hlyyb.common.b.b.b(this.f114417k.f());
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f114425s.f114437k = -1;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z16;
        boolean equals;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f114406u.getAndIncrement();
        String str7 = "";
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (this.f114414h) {
                if (!equals) {
                    return;
                } else {
                    return;
                }
            }
            d();
            if (!this.f114414h) {
                int i3 = this.f114419m;
                boolean z17 = false;
                if (i3 == 0) {
                    this.f114416j.g(this.f114410d);
                } else {
                    if (i3 == -1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.f114412f = true;
                        this.f114421o.incrementAndGet();
                    }
                }
                if (!this.f114420n) {
                    if (this.f114416j.t() > 0) {
                        List<c> e16 = e();
                        synchronized (c.class) {
                            for (c cVar : e16) {
                                cVar.f114413g = true;
                                this.f114411e.a(cVar.f114410d);
                            }
                        }
                    } else {
                        this.f114411e.a();
                    }
                } else {
                    if (this.f114419m == -1) {
                        z17 = true;
                    }
                    if (z17) {
                        this.f114413g = true;
                        this.f114411e.a(this.f114410d);
                    }
                }
            }
            if (this.f114414h && this.f114419m == -88) {
                this.f114419m = 5;
                str7 = "";
            }
            b bVar = this.f114425s;
            bVar.f114429c = this.f114410d.f114533c;
            bVar.f114432f = this.f114419m;
            bVar.f114433g = str7;
            bVar.f114434h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f114425s.f114435i = (int) (SystemClock.elapsedRealtime() - this.f114426t);
            this.f114425s.f114427a = this.f114422p.incrementAndGet();
            com.tencent.hlyyb.downloader.e.f.a aVar = this.f114410d;
            String str8 = aVar.f114531a;
            if (!TextUtils.isEmpty(aVar.f114535e)) {
                str5 = aVar.f114535e;
            } else {
                str5 = aVar.f114531a;
            }
            if (!str8.equals(str5)) {
                b bVar2 = this.f114425s;
                com.tencent.hlyyb.downloader.e.f.a aVar2 = this.f114410d;
                if (!TextUtils.isEmpty(aVar2.f114535e)) {
                    str6 = aVar2.f114535e;
                } else {
                    str6 = aVar2.f114531a;
                }
                bVar2.f114439m = str6;
            }
        } catch (Throwable th5) {
            try {
                this.f114419m = 1;
                String str9 = th5.getClass().getSimpleName() + "(" + th5.getLocalizedMessage() + ")";
                if (this.f114414h && this.f114419m == -88) {
                    this.f114419m = 5;
                    str9 = "";
                }
                b bVar3 = this.f114425s;
                bVar3.f114429c = this.f114410d.f114533c;
                bVar3.f114432f = this.f114419m;
                bVar3.f114433g = str9;
                bVar3.f114434h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f114425s.f114435i = (int) (SystemClock.elapsedRealtime() - this.f114426t);
                this.f114425s.f114427a = this.f114422p.incrementAndGet();
                com.tencent.hlyyb.downloader.e.f.a aVar3 = this.f114410d;
                String str10 = aVar3.f114531a;
                if (!TextUtils.isEmpty(aVar3.f114535e)) {
                    str3 = aVar3.f114535e;
                } else {
                    str3 = aVar3.f114531a;
                }
                if (!str10.equals(str3)) {
                    b bVar4 = this.f114425s;
                    com.tencent.hlyyb.downloader.e.f.a aVar4 = this.f114410d;
                    if (!TextUtils.isEmpty(aVar4.f114535e)) {
                        str4 = aVar4.f114535e;
                    } else {
                        str4 = aVar4.f114531a;
                    }
                    bVar4.f114439m = str4;
                }
            } finally {
                if (this.f114414h && this.f114419m == -88) {
                    this.f114419m = 5;
                    str7 = "";
                }
                b bVar5 = this.f114425s;
                bVar5.f114429c = this.f114410d.f114533c;
                bVar5.f114432f = this.f114419m;
                bVar5.f114433g = str7;
                bVar5.f114434h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f114425s.f114435i = (int) (SystemClock.elapsedRealtime() - this.f114426t);
                this.f114425s.f114427a = this.f114422p.incrementAndGet();
                com.tencent.hlyyb.downloader.e.f.a aVar5 = this.f114410d;
                String str11 = aVar5.f114531a;
                if (!TextUtils.isEmpty(aVar5.f114535e)) {
                    str = aVar5.f114535e;
                } else {
                    str = aVar5.f114531a;
                }
                if (!str11.equals(str)) {
                    b bVar6 = this.f114425s;
                    com.tencent.hlyyb.downloader.e.f.a aVar6 = this.f114410d;
                    if (!TextUtils.isEmpty(aVar6.f114535e)) {
                        str2 = aVar6.f114535e;
                    } else {
                        str2 = aVar6.f114531a;
                    }
                    bVar6.f114439m = str2;
                }
            }
        }
    }

    public final void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f114423q = i3;
        this.f114424r = i16;
        b bVar = this.f114425s;
        bVar.f114428b = i3;
        bVar.f114430d = i16;
    }

    public final void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f114425s.f114438l.add(str);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f114425s.f114436j.add(str);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    private void a(List<byte[]> list, String str) {
        int i3;
        if (list.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr : list) {
                byteArrayOutputStream.write(bArr, 0, bArr.length);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            if (com.tencent.hlyyb.common.b.b.a(byteArray)) {
                this.f114419m = 6;
                return;
            } else {
                if (str.toLowerCase().equals(com.tencent.hlyyb.common.b.a.a(byteArray).toLowerCase())) {
                    this.f114419m = 0;
                    return;
                }
                i3 = -1;
            }
        } else {
            i3 = 3;
        }
        this.f114419m = i3;
    }

    private byte[] a(com.tencent.hlyyb.downloader.e.f.a aVar, a.C5817a c5817a) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < 2; i3++) {
            boolean z16 = true;
            com.tencent.hlyyb.downloader.a.a.d dVar = new com.tencent.hlyyb.downloader.a.a.d(aVar, null, c5817a, false, this.f114409c, !this.f114407a, 2);
            this.f114417k = dVar;
            dVar.q();
            int a16 = this.f114417k.a();
            List<String> list = this.f114425s.f114431e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a16);
            list.add(sb5.toString());
            if (a16 == 0) {
                bArr = this.f114417k.r();
            } else if (a16 == -74) {
                this.f114419m = 7;
                bArr = null;
            }
            if (a16 != 0 && a16 != -66 && a16 != -15 && a16 != -16) {
                z16 = false;
            }
            if (z16) {
                break;
            }
            SystemClock.sleep(50L);
        }
        return bArr;
    }
}
