package com.tencent.luggage.wxa.pg;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.qg.k;
import com.tencent.luggage.wxa.qg.l;
import com.tencent.luggage.wxa.qg.r;
import com.tencent.luggage.wxa.tn.m;
import com.tencent.luggage.wxa.tn.z;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements com.tencent.luggage.wxa.qg.e {

    /* renamed from: b, reason: collision with root package name */
    public int f137529b;

    /* renamed from: c, reason: collision with root package name */
    public long f137530c;

    /* renamed from: d, reason: collision with root package name */
    public long f137531d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.pg.a f137532e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.qg.e f137533f;

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.qg.e f137534g;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.qg.e f137535h;

    /* renamed from: i, reason: collision with root package name */
    public final a f137536i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f137537j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f137538k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.qg.e f137539l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f137540m;

    /* renamed from: n, reason: collision with root package name */
    public int f137541n;

    /* renamed from: o, reason: collision with root package name */
    public String f137542o;

    /* renamed from: p, reason: collision with root package name */
    public String f137543p;

    /* renamed from: q, reason: collision with root package name */
    public long f137544q;

    /* renamed from: r, reason: collision with root package name */
    public long f137545r;

    /* renamed from: s, reason: collision with root package name */
    public int f137546s;

    /* renamed from: t, reason: collision with root package name */
    public f f137547t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f137548u;

    /* renamed from: v, reason: collision with root package name */
    public long f137549v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f137550w;

    /* renamed from: a, reason: collision with root package name */
    public long f137528a = 0;

    /* renamed from: x, reason: collision with root package name */
    public String f137551x = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(long j3, long j16);

        void a(String str, int i3, long j3, long j16, long j17);

        void a(String str, long j3, long j16, long j17);
    }

    public c(com.tencent.luggage.wxa.pg.a aVar, com.tencent.luggage.wxa.qg.e eVar, com.tencent.luggage.wxa.qg.e eVar2, com.tencent.luggage.wxa.qg.d dVar, boolean z16, boolean z17, a aVar2) {
        this.f137532e = aVar;
        this.f137533f = eVar2;
        this.f137537j = z16;
        this.f137538k = z17;
        this.f137535h = eVar;
        if (dVar != null) {
            this.f137534g = new r(eVar, dVar);
        } else {
            this.f137534g = null;
        }
        this.f137536i = aVar2;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long a(com.tencent.luggage.wxa.qg.g gVar) {
        try {
            this.f137540m = gVar.f138703a;
            this.f137541n = gVar.f138708f;
            this.f137542o = gVar.f138709g;
            this.f137543p = gVar.f138707e;
            this.f137544q = gVar.f138705c;
            this.f137545r = gVar.f138706d;
            this.f137546s = gVar.f138710h;
            long currentTimeMillis = System.currentTimeMillis();
            long h16 = h();
            this.f137531d = c();
            this.f137528a = System.currentTimeMillis() - currentTimeMillis;
            return h16;
        } catch (IOException e16) {
            if (this.f137539l instanceof k) {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "open cache error " + e16.toString());
            } else {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "open error " + e16.toString());
            }
            a(e16);
            if (this.f137548u) {
                try {
                    d();
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.tg.h.a(5, e(), "open, failed on closeCurrentSource, shouldn't be a problem", e17);
                }
                com.tencent.luggage.wxa.tg.h.a(6, e(), "open cache error, try reopen without cache");
                long currentTimeMillis2 = System.currentTimeMillis();
                long h17 = h();
                this.f137531d = c();
                this.f137528a = System.currentTimeMillis() - currentTimeMillis2;
                return h17;
            }
            throw e16;
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long available() {
        com.tencent.luggage.wxa.qg.e eVar = this.f137539l;
        if (eVar == null) {
            return 0L;
        }
        return eVar.available();
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long c() {
        com.tencent.luggage.wxa.pg.a aVar;
        com.tencent.luggage.wxa.qg.e eVar = this.f137539l;
        if (eVar == null) {
            return -1L;
        }
        if (eVar == this.f137533f && (aVar = this.f137532e) != null) {
            return aVar.c(this.f137543p);
        }
        return eVar.c();
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void close() {
        try {
            d();
        } catch (IOException e16) {
            if (this.f137539l instanceof k) {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "close cache error " + e16.toString());
            } else {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "close error " + e16.toString());
            }
            a(e16);
            throw e16;
        }
    }

    public final void d() {
        com.tencent.luggage.wxa.qg.e eVar = this.f137539l;
        if (eVar == null) {
            return;
        }
        try {
            eVar.close();
            this.f137539l = null;
        } finally {
            f fVar = this.f137547t;
            if (fVar != null) {
                this.f137532e.b(fVar);
                this.f137547t = null;
            }
        }
    }

    public String e() {
        return this.f137551x + "CacheDataSource";
    }

    public com.tencent.luggage.wxa.qg.e f() {
        return this.f137535h;
    }

    public final void g() {
        a aVar = this.f137536i;
        if (aVar != null) {
            if (this.f137546s == 90) {
                aVar.a(this.f137542o, this.f137529b, this.f137530c, this.f137531d, this.f137549v);
            }
            this.f137529b = 0;
            this.f137530c = 0L;
            if (this.f137539l == this.f137533f && this.f137549v > 0) {
                this.f137536i.a(this.f137532e.a(), this.f137549v);
                this.f137549v = 0L;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public com.tencent.luggage.wxa.rg.b getFileType() {
        com.tencent.luggage.wxa.pg.a aVar;
        com.tencent.luggage.wxa.qg.e eVar = this.f137539l;
        if (eVar == null) {
            return com.tencent.luggage.wxa.rg.b.f139662c;
        }
        if (eVar == this.f137533f && (aVar = this.f137532e) != null) {
            return aVar.d(this.f137543p);
        }
        return eVar.getFileType();
    }

    public final long h() {
        f a16;
        long j3;
        com.tencent.luggage.wxa.qg.g gVar;
        try {
            if (this.f137548u) {
                a16 = null;
            } else if (this.f137537j) {
                a16 = this.f137532e.b(this.f137543p, this.f137544q);
            } else {
                a16 = this.f137532e.a(this.f137543p, this.f137544q);
            }
            if (a16 == null) {
                this.f137539l = this.f137535h;
                Uri uri = this.f137540m;
                long j16 = this.f137544q;
                gVar = new com.tencent.luggage.wxa.qg.g(uri, j16, j16, this.f137545r, this.f137543p, this.f137541n, this.f137542o, this.f137546s);
            } else if (a16.f137558f) {
                Uri a17 = m.a(z.c(), a16.f137559g);
                long j17 = this.f137544q;
                long j18 = j17 - a16.f137554b;
                long j19 = this.f137545r;
                if (j19 == -1) {
                    this.f137545r = a16.f137556d - j17;
                } else if (j19 > a16.f137556d - j17) {
                    com.tencent.luggage.wxa.tg.h.a(5, e(), "fix bytesRemaining, max=" + (a16.f137556d - this.f137544q) + " current=" + this.f137545r);
                    this.f137545r = a16.f137556d - this.f137544q;
                }
                gVar = new com.tencent.luggage.wxa.qg.g(a17, this.f137544q, j18, Math.min(a16.f137555c - j18, this.f137545r), this.f137543p, this.f137541n, this.f137542o, this.f137546s);
                this.f137539l = this.f137533f;
            } else {
                this.f137547t = a16;
                if (a16.a()) {
                    j3 = this.f137545r;
                } else {
                    long j26 = this.f137545r;
                    if (j26 != -1) {
                        j3 = Math.min(a16.f137555c, j26);
                    } else {
                        j3 = a16.f137555c;
                    }
                }
                long j27 = j3;
                Uri uri2 = this.f137540m;
                long j28 = this.f137544q;
                gVar = new com.tencent.luggage.wxa.qg.g(uri2, j28, j28, j27, this.f137543p, this.f137541n, this.f137542o, this.f137546s);
                com.tencent.luggage.wxa.qg.e eVar = this.f137534g;
                if (eVar == null) {
                    eVar = this.f137535h;
                }
                this.f137539l = eVar;
            }
            long a18 = this.f137539l.a(gVar);
            com.tencent.luggage.wxa.qg.e eVar2 = this.f137539l;
            if ((eVar2 instanceof l) && eVar2.c() != -1 && gVar.f138705c >= this.f137539l.c() - 1) {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "read position out of bound");
            }
            if (this.f137545r == -1 && this.f137539l.c() != -1) {
                this.f137545r = this.f137539l.c() - this.f137544q;
                com.tencent.luggage.wxa.tg.h.a(4, e(), "init bytesRemaining " + this.f137545r + ", readPosition=" + this.f137544q + ", totalLength=" + this.f137539l.c());
            }
            this.f137545r = Math.max(0L, Math.min(this.f137545r, c()));
            this.f137550w = false;
            return a18;
        } catch (InterruptedException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        a aVar;
        try {
            if (!this.f137550w && (this.f137539l instanceof k) && com.tencent.luggage.wxa.og.a.a().n()) {
                com.tencent.luggage.wxa.tg.h.a(4, e(), "read from cache " + ((k) this.f137539l).getUri() + ", fileSize=" + this.f137539l.available());
            }
            long currentTimeMillis = System.currentTimeMillis();
            int read = this.f137539l.read(bArr, i3, i16);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (!this.f137550w) {
                if (this.f137539l != this.f137533f && com.tencent.luggage.wxa.og.a.a().m() != null && this.f137546s == 90 && URLUtil.isNetworkUrl(this.f137540m.toString()) && (aVar = this.f137536i) != null) {
                    String str = this.f137542o;
                    long j3 = this.f137528a;
                    aVar.a(str, j3, j3, currentTimeMillis2);
                }
                this.f137550w = true;
            }
            if (read >= 0) {
                if (this.f137539l == this.f137533f) {
                    this.f137549v += read;
                } else {
                    this.f137529b += read;
                    this.f137530c += currentTimeMillis2;
                }
                long j16 = read;
                this.f137544q += j16;
                long j17 = this.f137545r;
                if (j17 != -1) {
                    this.f137545r = j17 - j16;
                    return read;
                }
                return read;
            }
            g();
            d();
            if (this.f137545r > 0) {
                h();
                return read(bArr, i3, i16);
            }
            return read;
        } catch (IOException e16) {
            if (this.f137539l instanceof k) {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "read cache error " + e16.toString());
            } else {
                com.tencent.luggage.wxa.tg.h.a(6, e(), "read error " + e16.toString());
            }
            a(e16);
            throw e16;
        }
    }

    public final void a(IOException iOException) {
        com.tencent.luggage.wxa.tg.h.a(3, e(), "handleBeforeThrow " + iOException + ", ignoreCacheOnError=" + this.f137538k + ", currentDataSource=" + this.f137539l);
        if (this.f137538k && this.f137539l == this.f137533f) {
            com.tencent.luggage.wxa.tg.h.a(4, e(), "handleBeforeThrow currentDataSource=" + this.f137539l + ", exception=" + iOException);
            this.f137548u = true;
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void a(String str) {
        this.f137551x = str;
    }
}
