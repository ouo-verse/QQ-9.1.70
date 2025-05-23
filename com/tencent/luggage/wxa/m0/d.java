package com.tencent.luggage.wxa.m0;

import android.net.Uri;
import com.tencent.luggage.wxa.l0.t;
import com.tencent.luggage.wxa.m0.a;
import java.io.IOException;
import java.io.InterruptedIOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements com.tencent.luggage.wxa.l0.g {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m0.a f133960a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f133961b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f133962c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f133963d;

    /* renamed from: e, reason: collision with root package name */
    public final a f133964e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f133965f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f133966g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f133967h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.l0.g f133968i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f133969j;

    /* renamed from: k, reason: collision with root package name */
    public Uri f133970k;

    /* renamed from: l, reason: collision with root package name */
    public int f133971l;

    /* renamed from: m, reason: collision with root package name */
    public String f133972m;

    /* renamed from: n, reason: collision with root package name */
    public long f133973n;

    /* renamed from: o, reason: collision with root package name */
    public long f133974o;

    /* renamed from: p, reason: collision with root package name */
    public g f133975p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f133976q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f133977r;

    /* renamed from: s, reason: collision with root package name */
    public long f133978s;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(long j3, long j16);
    }

    public d(com.tencent.luggage.wxa.m0.a aVar, com.tencent.luggage.wxa.l0.g gVar, com.tencent.luggage.wxa.l0.g gVar2, com.tencent.luggage.wxa.l0.f fVar, int i3, a aVar2) {
        boolean z16;
        boolean z17;
        this.f133960a = aVar;
        this.f133961b = gVar2;
        if ((i3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f133965f = z16;
        if ((i3 & 2) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f133966g = z17;
        this.f133967h = (i3 & 4) != 0;
        this.f133963d = gVar;
        if (fVar != null) {
            this.f133962c = new t(gVar, fVar);
        } else {
            this.f133962c = null;
        }
        this.f133964e = aVar2;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(com.tencent.luggage.wxa.l0.j jVar) {
        try {
            this.f133970k = jVar.f132782a;
            this.f133971l = jVar.f132788g;
            String a16 = h.a(jVar);
            this.f133972m = a16;
            this.f133973n = jVar.f132785d;
            boolean z16 = (this.f133966g && this.f133976q) || (jVar.f132786e == -1 && this.f133967h);
            this.f133977r = z16;
            long j3 = jVar.f132786e;
            if (j3 == -1 && !z16) {
                long a17 = this.f133960a.a(a16);
                this.f133974o = a17;
                if (a17 != -1) {
                    long j16 = a17 - jVar.f132785d;
                    this.f133974o = j16;
                    if (j16 <= 0) {
                        throw new com.tencent.luggage.wxa.l0.h(0);
                    }
                }
                a(true);
                return this.f133974o;
            }
            this.f133974o = j3;
            a(true);
            return this.f133974o;
        } catch (IOException e16) {
            a(e16);
            throw e16;
        }
    }

    public final void b() {
        a aVar = this.f133964e;
        if (aVar != null && this.f133978s > 0) {
            aVar.a(this.f133960a.a(), this.f133978s);
            this.f133978s = 0L;
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        this.f133970k = null;
        b();
        try {
            a();
        } catch (IOException e16) {
            a(e16);
            throw e16;
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        com.tencent.luggage.wxa.l0.g gVar = this.f133968i;
        if (gVar == this.f133963d) {
            return gVar.getUri();
        }
        return this.f133970k;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        if (this.f133974o == 0) {
            return -1;
        }
        try {
            int read = this.f133968i.read(bArr, i3, i16);
            if (read >= 0) {
                if (this.f133968i == this.f133961b) {
                    this.f133978s += read;
                }
                long j3 = read;
                this.f133973n += j3;
                long j16 = this.f133974o;
                if (j16 != -1) {
                    this.f133974o = j16 - j3;
                }
            } else {
                if (this.f133969j) {
                    a(this.f133973n);
                    this.f133974o = 0L;
                }
                a();
                long j17 = this.f133974o;
                if ((j17 > 0 || j17 == -1) && a(false)) {
                    return read(bArr, i3, i16);
                }
            }
            return read;
        } catch (IOException e16) {
            a(e16);
            throw e16;
        }
    }

    public final boolean a(boolean z16) {
        g b16;
        long j3;
        com.tencent.luggage.wxa.l0.j jVar;
        long j16;
        IOException iOException = null;
        if (this.f133977r) {
            b16 = null;
        } else if (this.f133965f) {
            try {
                b16 = this.f133960a.b(this.f133972m, this.f133973n);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            b16 = this.f133960a.a(this.f133972m, this.f133973n);
        }
        if (b16 == null) {
            this.f133968i = this.f133963d;
            jVar = new com.tencent.luggage.wxa.l0.j(this.f133970k, this.f133973n, this.f133974o, this.f133972m, this.f133971l);
        } else if (b16.f133988d) {
            Uri fromFile = Uri.fromFile(b16.f133989e);
            long j17 = this.f133973n - b16.f133986b;
            long j18 = b16.f133987c - j17;
            long j19 = this.f133974o;
            if (j19 != -1) {
                j18 = Math.min(j18, j19);
            }
            com.tencent.luggage.wxa.l0.j jVar2 = new com.tencent.luggage.wxa.l0.j(fromFile, this.f133973n, j17, j18, this.f133972m, this.f133971l);
            this.f133968i = this.f133961b;
            jVar = jVar2;
        } else {
            if (b16.b()) {
                j3 = this.f133974o;
            } else {
                j3 = b16.f133987c;
                long j26 = this.f133974o;
                if (j26 != -1) {
                    j3 = Math.min(j3, j26);
                }
            }
            jVar = new com.tencent.luggage.wxa.l0.j(this.f133970k, this.f133973n, j3, this.f133972m, this.f133971l);
            com.tencent.luggage.wxa.l0.g gVar = this.f133962c;
            if (gVar != null) {
                this.f133968i = gVar;
                this.f133975p = b16;
            } else {
                this.f133968i = this.f133963d;
                this.f133960a.a(b16);
            }
        }
        boolean z17 = true;
        this.f133969j = jVar.f132786e == -1;
        try {
            j16 = this.f133968i.a(jVar);
        } catch (IOException e16) {
            if (!z16 && this.f133969j) {
                for (Throwable th5 = e16; th5 != null; th5 = th5.getCause()) {
                    if ((th5 instanceof com.tencent.luggage.wxa.l0.h) && ((com.tencent.luggage.wxa.l0.h) th5).f132775a == 0) {
                        break;
                    }
                }
            }
            iOException = e16;
            if (iOException != null) {
                throw iOException;
            }
            z17 = false;
            j16 = 0;
        }
        if (this.f133969j && j16 != -1) {
            this.f133974o = j16;
            a(jVar.f132785d + j16);
        }
        return z17;
    }

    public final void a(long j3) {
        if (this.f133968i == this.f133962c) {
            this.f133960a.c(this.f133972m, j3);
        }
    }

    public final void a() {
        com.tencent.luggage.wxa.l0.g gVar = this.f133968i;
        if (gVar == null) {
            return;
        }
        try {
            gVar.close();
            this.f133968i = null;
            this.f133969j = false;
        } finally {
            g gVar2 = this.f133975p;
            if (gVar2 != null) {
                this.f133960a.a(gVar2);
                this.f133975p = null;
            }
        }
    }

    public final void a(IOException iOException) {
        if (this.f133968i == this.f133961b || (iOException instanceof a.C6454a)) {
            this.f133976q = true;
        }
    }
}
