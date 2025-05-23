package com.tencent.luggage.wxa.f0;

import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.luggage.wxa.a0.a;
import com.tencent.luggage.wxa.g0.a;
import com.tencent.luggage.wxa.n0.s;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.w.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.e0.d {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public j D;
    public volatile boolean E;
    public volatile boolean F;

    /* renamed from: j, reason: collision with root package name */
    public final int f125127j;

    /* renamed from: k, reason: collision with root package name */
    public final int f125128k;

    /* renamed from: l, reason: collision with root package name */
    public final a.C6226a f125129l;

    /* renamed from: m, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f125130m;

    /* renamed from: n, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.j f125131n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f125132o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f125133p;

    /* renamed from: q, reason: collision with root package name */
    public final s f125134q;

    /* renamed from: r, reason: collision with root package name */
    public final String f125135r;

    /* renamed from: s, reason: collision with root package name */
    public final com.tencent.luggage.wxa.q.d f125136s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f125137t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f125138u;

    /* renamed from: v, reason: collision with root package name */
    public final List f125139v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f125140w;

    /* renamed from: x, reason: collision with root package name */
    public final com.tencent.luggage.wxa.c0.g f125141x;

    /* renamed from: y, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f125142y;

    /* renamed from: z, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.d f125143z;

    public f(com.tencent.luggage.wxa.l0.g gVar, com.tencent.luggage.wxa.l0.j jVar, com.tencent.luggage.wxa.l0.j jVar2, a.C6226a c6226a, List list, int i3, Object obj, long j3, long j16, int i16, int i17, boolean z16, s sVar, f fVar, byte[] bArr, byte[] bArr2) {
        super(a(gVar, bArr, bArr2), jVar, c6226a.f126317b, i3, obj, j3, j16, i16);
        this.f125128k = i17;
        this.f125131n = jVar2;
        this.f125129l = c6226a;
        this.f125139v = list;
        this.f125133p = z16;
        this.f125134q = sVar;
        this.f125132o = this.f124465h instanceof a;
        String lastPathSegment = jVar.f132782a.getLastPathSegment();
        this.f125135r = lastPathSegment;
        boolean z17 = lastPathSegment.endsWith(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.AC3_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.EC3_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION);
        this.f125140w = z17;
        if (fVar != null) {
            this.f125141x = fVar.f125141x;
            this.f125142y = fVar.f125142y;
            this.f125136s = fVar.f125143z;
            boolean z18 = fVar.f125129l != c6226a;
            this.f125137t = z18;
            this.f125138u = fVar.f125128k != i17 || z18;
        } else {
            this.f125141x = z17 ? new com.tencent.luggage.wxa.c0.g() : null;
            this.f125142y = z17 ? new com.tencent.luggage.wxa.n0.l(10) : null;
            this.f125136s = null;
            this.f125137t = false;
            this.f125138u = true;
        }
        this.f125130m = gVar;
        this.f125127j = G.getAndIncrement();
    }

    public void a(j jVar) {
        this.D = jVar;
        jVar.a(this.f125127j, this.f125137t);
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public void b() {
        if (this.f125143z == null && !this.f125140w) {
            this.f125143z = f();
        }
        i();
        if (!this.E) {
            h();
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public void c() {
        this.E = true;
    }

    @Override // com.tencent.luggage.wxa.e0.a
    public long d() {
        return this.B;
    }

    public final com.tencent.luggage.wxa.q.d f() {
        com.tencent.luggage.wxa.q.d lVar;
        int i3;
        boolean z16 = true;
        if (!"text/vtt".equals(this.f125129l.f126317b.f133896f) && !this.f125135r.endsWith(DefaultHlsExtractorFactory.WEBVTT_FILE_EXTENSION) && !this.f125135r.endsWith(DefaultHlsExtractorFactory.VTT_FILE_EXTENSION)) {
            if (!this.f125138u) {
                lVar = this.f125136s;
                z16 = false;
            } else {
                if (!this.f125135r.endsWith(".mp4")) {
                    if (!this.f125135r.startsWith(DefaultHlsExtractorFactory.M4_FILE_EXTENSION_PREFIX, r0.length() - 4)) {
                        List list = this.f125139v;
                        if (list != null) {
                            i3 = 48;
                        } else {
                            list = Collections.emptyList();
                            i3 = 16;
                        }
                        String str = this.f124460c.f133893c;
                        if (!TextUtils.isEmpty(str)) {
                            if (!"audio/mp4a-latm".equals(com.tencent.luggage.wxa.n0.i.a(str))) {
                                i3 |= 2;
                            }
                            if (!"video/avc".equals(com.tencent.luggage.wxa.n0.i.f(str))) {
                                i3 |= 4;
                            }
                        }
                        lVar = new u(2, this.f125134q, new com.tencent.luggage.wxa.w.e(i3, list));
                    }
                }
                lVar = new com.tencent.luggage.wxa.u.e(0, this.f125134q);
            }
        } else {
            lVar = new l(this.f124460c.N, this.f125134q);
        }
        if (z16) {
            lVar.a(this.D);
        }
        return lVar;
    }

    public boolean g() {
        return this.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: all -> 0x009d, TryCatch #1 {all -> 0x009d, blocks: (B:10:0x0038, B:12:0x004a, B:14:0x0057, B:15:0x0060, B:16:0x005e, B:18:0x0068, B:26:0x0089, B:32:0x007c, B:33:0x0088, B:22:0x006f, B:24:0x0073), top: B:9:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #1 {all -> 0x009d, blocks: (B:10:0x0038, B:12:0x004a, B:14:0x0057, B:15:0x0060, B:16:0x005e, B:18:0x0068, B:26:0x0089, B:32:0x007c, B:33:0x0088, B:22:0x006f, B:24:0x0073), top: B:9:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        com.tencent.luggage.wxa.l0.j a16;
        boolean z16;
        long j3;
        int i3 = 0;
        try {
            if (this.f125132o) {
                a16 = this.f124458a;
                if (this.B != 0) {
                    z16 = true;
                    if (this.f125133p) {
                        this.f125134q.e();
                    } else if (this.f125134q.a() == Long.MAX_VALUE) {
                        this.f125134q.d(this.f124463f);
                    }
                    com.tencent.luggage.wxa.l0.g gVar = this.f124465h;
                    com.tencent.luggage.wxa.q.b bVar = new com.tencent.luggage.wxa.q.b(gVar, a16.f132784c, gVar.a(a16));
                    if (this.f125143z == null) {
                        long a17 = a(bVar);
                        if (a17 != -9223372036854775807L) {
                            j3 = this.f125134q.b(a17);
                        } else {
                            j3 = this.f124463f;
                        }
                        this.f125143z = a(j3);
                    }
                    if (z16) {
                        bVar.c(this.B);
                    }
                    while (i3 == 0) {
                        try {
                            if (this.E) {
                                break;
                            } else {
                                i3 = this.f125143z.a(bVar, (com.tencent.luggage.wxa.q.j) null);
                            }
                        } finally {
                            this.B = (int) (bVar.getPosition() - this.f124458a.f132784c);
                        }
                    }
                    v.a(this.f124465h);
                    this.F = true;
                    return;
                }
            } else {
                a16 = this.f124458a.a(this.B);
            }
            com.tencent.luggage.wxa.l0.g gVar2 = this.f124465h;
            com.tencent.luggage.wxa.q.b bVar2 = new com.tencent.luggage.wxa.q.b(gVar2, a16.f132784c, gVar2.a(a16));
            if (this.f125143z == null) {
            }
            if (z16) {
            }
            while (i3 == 0) {
            }
            v.a(this.f124465h);
            this.F = true;
            return;
        } catch (Throwable th5) {
            v.a(this.f124465h);
            throw th5;
        }
        z16 = false;
        if (this.f125133p) {
        }
    }

    public final void i() {
        com.tencent.luggage.wxa.l0.j jVar;
        if (this.f125136s != this.f125143z && !this.C && (jVar = this.f125131n) != null) {
            com.tencent.luggage.wxa.l0.j a16 = jVar.a(this.A);
            try {
                com.tencent.luggage.wxa.l0.g gVar = this.f125130m;
                com.tencent.luggage.wxa.q.b bVar = new com.tencent.luggage.wxa.q.b(gVar, a16.f132784c, gVar.a(a16));
                int i3 = 0;
                while (i3 == 0) {
                    try {
                        if (this.E) {
                            break;
                        } else {
                            i3 = this.f125143z.a(bVar, (com.tencent.luggage.wxa.q.j) null);
                        }
                    } finally {
                        this.A = (int) (bVar.getPosition() - this.f125131n.f132784c);
                    }
                }
                v.a(this.f124465h);
                this.C = true;
            } catch (Throwable th5) {
                v.a(this.f124465h);
                throw th5;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public boolean a() {
        return this.E;
    }

    public final long a(com.tencent.luggage.wxa.q.e eVar) {
        com.tencent.luggage.wxa.a0.a a16;
        eVar.a();
        if (!eVar.a(this.f125142y.f135088a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.f125142y.c(10);
        if (this.f125142y.t() != com.tencent.luggage.wxa.c0.g.f123185b) {
            return -9223372036854775807L;
        }
        this.f125142y.f(3);
        int p16 = this.f125142y.p();
        int i3 = p16 + 10;
        if (i3 > this.f125142y.b()) {
            com.tencent.luggage.wxa.n0.l lVar = this.f125142y;
            byte[] bArr = lVar.f135088a;
            lVar.c(i3);
            System.arraycopy(bArr, 0, this.f125142y.f135088a, 0, 10);
        }
        if (!eVar.a(this.f125142y.f135088a, 10, p16, true) || (a16 = this.f125141x.a(this.f125142y.f135088a, p16)) == null) {
            return -9223372036854775807L;
        }
        int a17 = a16.a();
        for (int i16 = 0; i16 < a17; i16++) {
            a.b a18 = a16.a(i16);
            if (a18 instanceof com.tencent.luggage.wxa.c0.i) {
                com.tencent.luggage.wxa.c0.i iVar = (com.tencent.luggage.wxa.c0.i) a18;
                if ("com.apple.streaming.transportStreamTimestamp".equals(iVar.f123191b)) {
                    System.arraycopy(iVar.f123192c, 0, this.f125142y.f135088a, 0, 8);
                    this.f125142y.c(8);
                    return this.f125142y.m();
                }
            }
        }
        return -9223372036854775807L;
    }

    public static com.tencent.luggage.wxa.l0.g a(com.tencent.luggage.wxa.l0.g gVar, byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? gVar : new a(gVar, bArr, bArr2);
    }

    public final com.tencent.luggage.wxa.q.d a(long j3) {
        com.tencent.luggage.wxa.q.d aVar;
        if (this.f125135r.endsWith(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION)) {
            aVar = new com.tencent.luggage.wxa.w.c(j3);
        } else if (!this.f125135r.endsWith(DefaultHlsExtractorFactory.AC3_FILE_EXTENSION) && !this.f125135r.endsWith(DefaultHlsExtractorFactory.EC3_FILE_EXTENSION)) {
            if (this.f125135r.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
                aVar = new com.tencent.luggage.wxa.t.b(0, j3);
            } else {
                throw new IllegalArgumentException("Unknown extension for audio file: " + this.f125135r);
            }
        } else {
            aVar = new com.tencent.luggage.wxa.w.a(j3);
        }
        aVar.a(this.D);
        return aVar;
    }
}
