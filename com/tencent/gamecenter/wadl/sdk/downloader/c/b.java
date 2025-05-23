package com.tencent.gamecenter.wadl.sdk.downloader.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.e;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamecenter.wadl.sdk.downloader.a.d;
import com.tencent.gamecenter.wadl.sdk.downloader.task.k.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: r, reason: collision with root package name */
    private static AtomicInteger f107335r = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public boolean f107336a;

    /* renamed from: b, reason: collision with root package name */
    private List<b> f107337b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107338c;

    /* renamed from: d, reason: collision with root package name */
    private a f107339d;

    /* renamed from: h, reason: collision with root package name */
    public e f107343h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.task.k.b f107344i;

    /* renamed from: j, reason: collision with root package name */
    private d f107345j;

    /* renamed from: k, reason: collision with root package name */
    private List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> f107346k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f107348m;

    /* renamed from: n, reason: collision with root package name */
    private AtomicInteger f107349n;

    /* renamed from: o, reason: collision with root package name */
    private AtomicInteger f107350o;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f107340e = false;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f107341f = false;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f107342g = false;

    /* renamed from: l, reason: collision with root package name */
    private int f107347l = -88;

    /* renamed from: p, reason: collision with root package name */
    public C1130b f107351p = new C1130b();

    /* renamed from: q, reason: collision with root package name */
    public long f107352q = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a();

        void a(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1130b {

        /* renamed from: a, reason: collision with root package name */
        int f107353a;

        /* renamed from: f, reason: collision with root package name */
        int f107358f;

        /* renamed from: h, reason: collision with root package name */
        int f107360h;

        /* renamed from: i, reason: collision with root package name */
        int f107361i;

        /* renamed from: k, reason: collision with root package name */
        int f107363k;

        /* renamed from: b, reason: collision with root package name */
        int f107354b = -1;

        /* renamed from: c, reason: collision with root package name */
        int f107355c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f107356d = -1;

        /* renamed from: e, reason: collision with root package name */
        List<String> f107357e = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        String f107359g = "";

        /* renamed from: j, reason: collision with root package name */
        List<String> f107362j = new ArrayList();

        /* renamed from: l, reason: collision with root package name */
        List<String> f107364l = new ArrayList();

        /* renamed from: m, reason: collision with root package name */
        String f107365m = "";

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f107353a);
            sb5.append(",");
            sb5.append(this.f107354b);
            sb5.append(",");
            sb5.append(this.f107355c);
            sb5.append(",");
            sb5.append(this.f107356d);
            sb5.append(",");
            if (this.f107357e.size() > 0) {
                Iterator<String> it = this.f107357e.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f107358f);
            sb5.append(",");
            sb5.append(this.f107359g);
            sb5.append(",");
            sb5.append(this.f107360h);
            sb5.append(",");
            sb5.append(this.f107361i);
            sb5.append(",");
            if (this.f107362j.size() > 0) {
                Iterator<String> it5 = this.f107362j.iterator();
                while (it5.hasNext()) {
                    sb5.append(it5.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f107363k);
            sb5.append(",");
            if (this.f107364l.size() > 0) {
                Iterator<String> it6 = this.f107364l.iterator();
                while (it6.hasNext()) {
                    sb5.append(it6.next());
                    sb5.append("-");
                }
                sb5.deleteCharAt(sb5.length() - 1);
            }
            sb5.append(",");
            sb5.append(this.f107365m);
            return sb5.toString();
        }
    }

    public b(com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, List<b> list, a aVar2, boolean z16, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        this.f107348m = false;
        this.f107344i = bVar;
        this.f107346k = bVar.d();
        this.f107338c = aVar;
        this.f107337b = list;
        this.f107339d = aVar2;
        this.f107348m = z16;
        this.f107350o = atomicInteger;
        this.f107349n = atomicInteger2;
    }

    private String a(byte[] bArr) {
        Matcher matcher = Pattern.compile("(?<=channelId=).*(?=\r\n)").matcher(new String(bArr));
        return matcher.find() ? matcher.group() : "";
    }

    private List<b> c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f107337b) {
            for (b bVar : this.f107337b) {
                if (bVar.f107340e) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private boolean d() {
        if (this.f107347l == -1) {
            return true;
        }
        return false;
    }

    public List<com.tencent.gamecenter.wadl.sdk.downloader.a.e.b> b() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f107346k.size(); i3++) {
            long j3 = this.f107346k.get(i3).f107366a;
            long j16 = (r2.f107367b + j3) - 1;
            if (j3 < 0 || j3 > j16) {
                return null;
            }
            arrayList.add(new com.tencent.gamecenter.wadl.sdk.downloader.a.e.b(j3, j16));
        }
        return arrayList;
    }

    public void e() {
        this.f107351p.f107363k = -1;
    }

    public void f() {
        if (this.f107338c.f107609b == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https) {
            this.f107347l = 0;
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-HijackTask", "verify success when https");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<com.tencent.gamecenter.wadl.sdk.downloader.a.e.b> b16 = b();
        if (b16 != null) {
            String e16 = this.f107344i.e();
            for (int i3 = 0; i3 < b16.size(); i3++) {
                byte[] a16 = a(this.f107338c, b16.get(i3));
                if (a16 != null) {
                    arrayList.add(a16);
                } else {
                    if (this.f107347l != 7) {
                        this.f107347l = 4;
                        return;
                    }
                    return;
                }
            }
            a(arrayList, e16);
            return;
        }
        this.f107347l = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean equals;
        f107335r.getAndIncrement();
        String str = "";
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
        } catch (Throwable th5) {
            try {
                this.f107347l = 1;
                String str2 = th5.getClass().getSimpleName() + "(" + th5.getLocalizedMessage() + ")";
                if (this.f107342g && this.f107347l == -88) {
                    this.f107347l = 5;
                    str2 = "";
                }
                C1130b c1130b = this.f107351p;
                c1130b.f107355c = this.f107338c.f107610c;
                c1130b.f107358f = this.f107347l;
                c1130b.f107359g = str2;
                c1130b.f107360h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f107351p.f107361i = (int) (SystemClock.elapsedRealtime() - this.f107352q);
                this.f107351p.f107353a = this.f107350o.incrementAndGet();
                com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107338c;
                if (aVar.f107608a.equals(aVar.a())) {
                    return;
                }
            } finally {
                if (this.f107342g && this.f107347l == -88) {
                    this.f107347l = 5;
                    str = "";
                }
                C1130b c1130b2 = this.f107351p;
                c1130b2.f107355c = this.f107338c.f107610c;
                c1130b2.f107358f = this.f107347l;
                c1130b2.f107359g = str;
                c1130b2.f107360h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f107351p.f107361i = (int) (SystemClock.elapsedRealtime() - this.f107352q);
                this.f107351p.f107353a = this.f107350o.incrementAndGet();
                com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar2 = this.f107338c;
                if (!aVar2.f107608a.equals(aVar2.a())) {
                    this.f107351p.f107365m = this.f107338c.a();
                }
            }
        }
        if (this.f107342g) {
            if (!equals) {
                return;
            } else {
                return;
            }
        }
        f();
        if (!this.f107342g) {
            if (this.f107347l == 0) {
                this.f107344i.a(this.f107338c);
            } else if (d()) {
                this.f107340e = true;
                this.f107349n.incrementAndGet();
            }
            if (!this.f107348m) {
                if (this.f107344i.g() > 0) {
                    List<b> c16 = c();
                    synchronized (b.class) {
                        for (b bVar : c16) {
                            bVar.f107341f = true;
                            this.f107339d.a(bVar.f107338c);
                        }
                    }
                } else {
                    this.f107339d.a();
                }
            } else if (d()) {
                this.f107341f = true;
                this.f107339d.a(this.f107338c);
            }
        }
        if (this.f107342g && this.f107347l == -88) {
            this.f107347l = 5;
            str = "";
        }
        C1130b c1130b3 = this.f107351p;
        c1130b3.f107355c = this.f107338c.f107610c;
        c1130b3.f107358f = this.f107347l;
        c1130b3.f107359g = str;
        c1130b3.f107360h = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f107351p.f107361i = (int) (SystemClock.elapsedRealtime() - this.f107352q);
        this.f107351p.f107353a = this.f107350o.incrementAndGet();
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar3 = this.f107338c;
        if (aVar3.f107608a.equals(aVar3.a())) {
            return;
        }
        this.f107351p.f107365m = this.f107338c.a();
    }

    public void a() {
        this.f107342g = true;
        try {
            d dVar = this.f107345j;
            if (dVar != null) {
                dVar.d();
            }
            e eVar = this.f107343h;
            if (eVar != null) {
                eVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        this.f107351p.f107362j.add(str);
    }

    public void a(int i3, int i16) {
        C1130b c1130b = this.f107351p;
        c1130b.f107354b = i3;
        c1130b.f107356d = i16;
    }

    public void a(String str) {
        this.f107351p.f107364l.add(str);
    }

    private void a(List<byte[]> list, String str) {
        if (list == null || list.size() <= 0) {
            this.f107347l = 3;
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte[] bArr : list) {
            byteArrayOutputStream.write(bArr, 0, bArr.length);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        if (g.a(byteArray)) {
            this.f107347l = 6;
            return;
        }
        if (str.toLowerCase().equals(com.tencent.gamecenter.wadl.sdk.common.e.d.c(byteArray).toLowerCase())) {
            this.f107347l = 0;
            return;
        }
        this.f107347l = -1;
        String a16 = a(byteArray);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("md5Verify", "channel was hijack,hijackChannel=" + a16);
    }

    private byte[] a(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, com.tencent.gamecenter.wadl.sdk.downloader.a.e.b bVar) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < 2; i3++) {
            boolean z16 = true;
            com.tencent.gamecenter.wadl.sdk.downloader.a.e.d dVar = new com.tencent.gamecenter.wadl.sdk.downloader.a.e.d(aVar, null, bVar, false, !this.f107336a, this.f107344i, 2, "");
            this.f107345j = dVar;
            dVar.a();
            int g16 = this.f107345j.g();
            this.f107351p.f107357e.add(g16 + "");
            if (g16 == 0) {
                bArr = this.f107345j.c();
            } else if (g16 == -74) {
                this.f107347l = 7;
                bArr = null;
            }
            if (g16 != 0 && g16 != -66 && g16 != -15 && g16 != -16) {
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
