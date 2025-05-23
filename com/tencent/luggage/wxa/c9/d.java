package com.tencent.luggage.wxa.c9;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f123420b;

    /* renamed from: c, reason: collision with root package name */
    public String f123421c;

    /* renamed from: d, reason: collision with root package name */
    public long f123422d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f123423e;

    /* renamed from: j, reason: collision with root package name */
    public a f123428j;

    /* renamed from: k, reason: collision with root package name */
    public String f123429k;

    /* renamed from: l, reason: collision with root package name */
    public String f123430l;

    /* renamed from: f, reason: collision with root package name */
    public int f123424f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f123425g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f123426h = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f123427i = false;

    /* renamed from: m, reason: collision with root package name */
    public int f123431m = 44100;

    /* renamed from: n, reason: collision with root package name */
    public int f123432n = 2;

    /* renamed from: o, reason: collision with root package name */
    public int f123433o = 2;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f123419a = new ArrayList();

    public d(String str) {
        this.f123421c = str;
    }

    public synchronized boolean a(String str) {
        if (this.f123427i) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", this.f123421c);
            return true;
        }
        this.f123429k = str;
        int size = this.f123419a.size();
        if (size > 0) {
            j();
        }
        if (this.f123428j == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
            this.f123427i = false;
            return false;
        }
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) this.f123419a.get(i3);
            if (i3 == 0) {
                a(eVar);
            }
            if (eVar != null) {
                byte[] bArr = eVar.f123439f;
                if (!b(bArr, i3 * 3536, bArr.length)) {
                    d();
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
                    this.f123427i = false;
                    return false;
                }
            }
        }
        this.f123427i = true;
        for (int i16 = size - 1; i16 >= 0; i16--) {
            e eVar2 = (e) this.f123419a.remove(i16);
            if (eVar2 != null) {
                com.tencent.luggage.wxa.d9.e.a().a(eVar2);
            }
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish, src:%s", this.f123421c);
        return true;
    }

    public void b(e eVar) {
        this.f123424f = this.f123424f + 1;
        eVar.f123438e = r0 * 20;
        ArrayList arrayList = this.f123419a;
        if (arrayList != null) {
            arrayList.add(eVar);
        }
    }

    public final void c(int i3) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", this.f123421c, Integer.valueOf(i3), Boolean.valueOf(this.f123420b), Long.valueOf(this.f123422d), Boolean.valueOf(this.f123423e), Long.valueOf(this.f123426h));
        this.f123419a.clear();
        this.f123420b = false;
        this.f123422d = 0L;
        this.f123423e = false;
        this.f123424f = 0;
        this.f123426h = 0L;
        a();
    }

    public void d() {
        a aVar = this.f123428j;
        if (aVar != null) {
            aVar.a();
            this.f123428j.b();
            this.f123428j = null;
        }
    }

    public long e() {
        long j3 = this.f123426h;
        if (j3 > 0) {
            return j3;
        }
        long m3 = m() * 3536;
        this.f123426h = m3;
        return m3;
    }

    public long f() {
        return this.f123422d;
    }

    public boolean g() {
        return this.f123427i;
    }

    public boolean h() {
        return this.f123420b;
    }

    public boolean i() {
        return this.f123423e;
    }

    public void j() {
        if (this.f123428j == null) {
            a aVar = new a(this.f123429k, this.f123421c);
            this.f123428j = aVar;
            if (aVar.a(this.f123427i)) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
                this.f123428j.a(e());
            } else {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
                this.f123427i = false;
                d();
            }
        }
    }

    public synchronized void k() {
        int size = this.f123419a.size();
        for (int i3 = size - 1; i3 >= 0; i3--) {
            e eVar = (e) this.f123419a.remove(i3);
            if (eVar != null) {
                com.tencent.luggage.wxa.d9.e.a().a(eVar);
            }
        }
        c(size);
    }

    public synchronized void l() {
        int size = this.f123419a.size();
        for (int i3 = size - 1; i3 >= 0; i3--) {
            e eVar = (e) this.f123419a.remove(i3);
            if (eVar != null) {
                eVar.f123434a = null;
                eVar.f123439f = null;
            }
        }
        c(size);
    }

    public int m() {
        int i3 = this.f123425g;
        if (i3 > 0 && this.f123420b) {
            return i3;
        }
        return this.f123419a.size();
    }

    public synchronized void n() {
        j();
    }

    public synchronized void b() {
        if (this.f123428j != null) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
            this.f123428j.a();
            this.f123428j = null;
        }
    }

    public boolean b(byte[] bArr, long j3, int i3) {
        a aVar = this.f123428j;
        if (aVar != null) {
            return aVar.b(bArr, j3, i3);
        }
        return false;
    }

    public e b(int i3) {
        a aVar;
        int i16;
        e b16;
        if (i3 >= this.f123425g || (aVar = this.f123428j) == null || (i16 = i3 * 3536) > aVar.c() || (b16 = com.tencent.luggage.wxa.d9.d.a().b()) == null) {
            return null;
        }
        byte[] bArr = b16.f123439f;
        if (bArr == null) {
            b16.f123439f = new byte[3536];
        } else {
            Arrays.fill(bArr, 0, bArr.length, (byte) 0);
        }
        System.nanoTime();
        byte[] bArr2 = b16.f123439f;
        if (a(bArr2, i16, bArr2.length) <= 0) {
            com.tencent.luggage.wxa.d9.d.a().a(b16);
            return null;
        }
        b16.f123434a = this.f123430l;
        b16.f123435b = this.f123431m;
        b16.f123436c = this.f123432n;
        b16.f123437d = this.f123433o;
        b16.f123438e = i3 * 20;
        return b16;
    }

    public void c() {
        this.f123420b = true;
        this.f123425g = m();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", this.f123421c);
    }

    public final void a(e eVar) {
        this.f123430l = eVar.f123434a;
        this.f123431m = eVar.f123435b;
        this.f123433o = eVar.f123437d;
        this.f123432n = eVar.f123436c;
    }

    public e a(int i3) {
        boolean z16 = this.f123427i;
        if (z16 && this.f123428j != null) {
            return b(i3);
        }
        if (z16 && this.f123428j == null) {
            n();
            return b(i3);
        }
        ArrayList arrayList = this.f123419a;
        if (arrayList == null || arrayList.size() == 0 || i3 >= this.f123419a.size()) {
            return null;
        }
        return (e) this.f123419a.get(i3);
    }

    public void a(long j3) {
        this.f123422d = j3;
    }

    public void a(boolean z16) {
        this.f123423e = z16;
    }

    public void a() {
        this.f123427i = false;
        d();
    }

    public int a(byte[] bArr, long j3, int i3) {
        a aVar = this.f123428j;
        if (aVar != null) {
            return aVar.a(bArr, j3, i3);
        }
        return 0;
    }
}
