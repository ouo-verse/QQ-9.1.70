package com.tencent.luggage.wxa.f0;

import android.net.Uri;
import android.os.SystemClock;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.g0.a;
import com.tencent.luggage.wxa.g0.b;
import com.tencent.luggage.wxa.n0.u;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f125102a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f125103b;

    /* renamed from: c, reason: collision with root package name */
    public final k f125104c;

    /* renamed from: d, reason: collision with root package name */
    public final a.C6226a[] f125105d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.g0.e f125106e;

    /* renamed from: f, reason: collision with root package name */
    public final n f125107f;

    /* renamed from: g, reason: collision with root package name */
    public final List f125108g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f125109h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f125110i;

    /* renamed from: j, reason: collision with root package name */
    public IOException f125111j;

    /* renamed from: k, reason: collision with root package name */
    public a.C6226a f125112k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f125113l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f125114m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f125115n;

    /* renamed from: o, reason: collision with root package name */
    public String f125116o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f125117p;

    /* renamed from: q, reason: collision with root package name */
    public com.tencent.luggage.wxa.k0.f f125118q;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.e0.c {

        /* renamed from: l, reason: collision with root package name */
        public final String f125119l;

        /* renamed from: m, reason: collision with root package name */
        public byte[] f125120m;

        public a(com.tencent.luggage.wxa.l0.g gVar, com.tencent.luggage.wxa.l0.j jVar, com.tencent.luggage.wxa.m.j jVar2, int i3, Object obj, byte[] bArr, String str) {
            super(gVar, jVar, 3, jVar2, i3, obj, bArr);
            this.f125119l = str;
        }

        @Override // com.tencent.luggage.wxa.e0.c
        public void a(byte[] bArr, int i3) {
            this.f125120m = Arrays.copyOf(bArr, i3);
        }

        public byte[] g() {
            return this.f125120m;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.e0.a f125121a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f125122b;

        /* renamed from: c, reason: collision with root package name */
        public a.C6226a f125123c;

        public b() {
            a();
        }

        public void a() {
            this.f125121a = null;
            this.f125122b = false;
            this.f125123c = null;
        }
    }

    public c(com.tencent.luggage.wxa.g0.e eVar, a.C6226a[] c6226aArr, d dVar, k kVar, List list) {
        this.f125106e = eVar;
        this.f125105d = c6226aArr;
        this.f125104c = kVar;
        this.f125108g = list;
        com.tencent.luggage.wxa.m.j[] jVarArr = new com.tencent.luggage.wxa.m.j[c6226aArr.length];
        int[] iArr = new int[c6226aArr.length];
        for (int i3 = 0; i3 < c6226aArr.length; i3++) {
            jVarArr[i3] = c6226aArr[i3].f126317b;
            iArr[i3] = i3;
        }
        this.f125102a = dVar.a(1);
        this.f125103b = dVar.a(3);
        n nVar = new n(jVarArr);
        this.f125107f = nVar;
        this.f125118q = new C6182c(nVar, iArr);
    }

    public void a(com.tencent.luggage.wxa.k0.f fVar) {
        this.f125118q = fVar;
    }

    public n b() {
        return this.f125107f;
    }

    public com.tencent.luggage.wxa.k0.f c() {
        return this.f125118q;
    }

    public void d() {
        IOException iOException = this.f125111j;
        if (iOException == null) {
            a.C6226a c6226a = this.f125112k;
            if (c6226a != null) {
                this.f125106e.d(c6226a);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void e() {
        this.f125111j = null;
    }

    public void a(boolean z16) {
        this.f125109h = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(f fVar, long j3, b bVar) {
        long j16;
        int i3;
        a.C6226a c6226a;
        int size;
        int i16;
        int a16 = fVar == null ? -1 : this.f125107f.a(fVar.f124460c);
        this.f125112k = null;
        long j17 = 0;
        if (fVar != null) {
            j17 = Math.max(0L, (this.f125113l ? fVar.f124464g : fVar.f124463f) - j3);
        }
        this.f125118q.a(j17);
        int d16 = this.f125118q.d();
        boolean z16 = a16 != d16;
        a.C6226a c6226a2 = this.f125105d[d16];
        if (!this.f125106e.b(c6226a2)) {
            bVar.f125123c = c6226a2;
            this.f125112k = c6226a2;
            return;
        }
        com.tencent.luggage.wxa.g0.b a17 = this.f125106e.a(c6226a2);
        boolean z17 = a17.f126326k;
        this.f125113l = z17;
        if (fVar != null && !z16) {
            size = fVar.e();
        } else {
            if (fVar == null) {
                j16 = j3;
            } else {
                j16 = z17 ? fVar.f124464g : fVar.f124463f;
            }
            if (!a17.f126327l && j16 >= a17.b()) {
                size = a17.f126323h + a17.f126330o.size();
            } else {
                int a18 = v.a(a17.f126330o, (Object) Long.valueOf(j16 - a17.f126320e), true, !this.f125106e.b() || fVar == null);
                int i17 = a17.f126323h;
                i3 = a18 + i17;
                if (i3 < i17 && fVar != null) {
                    a.C6226a c6226a3 = this.f125105d[a16];
                    a17 = this.f125106e.a(c6226a3);
                    i3 = fVar.e();
                    d16 = a16;
                    c6226a = c6226a3;
                    i16 = a17.f126323h;
                    if (i3 < i16) {
                        this.f125111j = new com.tencent.luggage.wxa.d0.b();
                        return;
                    }
                    int i18 = i3 - i16;
                    if (i18 >= a17.f126330o.size()) {
                        if (a17.f126327l) {
                            bVar.f125122b = true;
                            return;
                        } else {
                            bVar.f125123c = c6226a;
                            this.f125112k = c6226a;
                            return;
                        }
                    }
                    b.a aVar = (b.a) a17.f126330o.get(i18);
                    if (aVar.f126336e) {
                        Uri b16 = u.b(a17.f126341a, aVar.f126337f);
                        if (!b16.equals(this.f125114m)) {
                            bVar.f125121a = a(b16, aVar.f126338g, d16, this.f125118q.f(), this.f125118q.b());
                            return;
                        } else if (!v.a(aVar.f126338g, this.f125116o)) {
                            a(b16, aVar.f126338g, this.f125115n);
                        }
                    } else {
                        a();
                    }
                    b.a aVar2 = a17.f126329n;
                    com.tencent.luggage.wxa.l0.j jVar = aVar2 != null ? new com.tencent.luggage.wxa.l0.j(u.b(a17.f126341a, aVar2.f126332a), aVar2.f126339h, aVar2.f126340i, null) : null;
                    long j18 = a17.f126320e + aVar.f126335d;
                    int i19 = a17.f126322g + aVar.f126334c;
                    bVar.f125121a = new f(this.f125102a, new com.tencent.luggage.wxa.l0.j(u.b(a17.f126341a, aVar.f126332a), aVar.f126339h, aVar.f126340i, null), jVar, c6226a, this.f125108g, this.f125118q.f(), this.f125118q.b(), j18, j18 + aVar.f126333b, i3, i19, this.f125109h, this.f125104c.a(i19), fVar, this.f125115n, this.f125117p);
                    return;
                }
                c6226a = c6226a2;
                i16 = a17.f126323h;
                if (i3 < i16) {
                }
            }
        }
        i3 = size;
        c6226a = c6226a2;
        i16 = a17.f126323h;
        if (i3 < i16) {
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f0.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6182c extends com.tencent.luggage.wxa.k0.a {

        /* renamed from: g, reason: collision with root package name */
        public int f125124g;

        public C6182c(n nVar, int[] iArr) {
            super(nVar, iArr);
            this.f125124g = a(nVar.a(0));
        }

        @Override // com.tencent.luggage.wxa.k0.f
        public void a(long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f125124g, elapsedRealtime)) {
                for (int i3 = this.f131370b - 1; i3 >= 0; i3--) {
                    if (!b(i3, elapsedRealtime)) {
                        this.f125124g = i3;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.tencent.luggage.wxa.k0.f
        public Object b() {
            return null;
        }

        @Override // com.tencent.luggage.wxa.k0.f
        public int f() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.k0.f
        public int a() {
            return this.f125124g;
        }
    }

    public void a(com.tencent.luggage.wxa.e0.a aVar) {
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            this.f125110i = aVar2.e();
            a(aVar2.f124458a.f132782a, aVar2.f125119l, aVar2.g());
        }
    }

    public boolean a(com.tencent.luggage.wxa.e0.a aVar, boolean z16, IOException iOException) {
        if (z16) {
            com.tencent.luggage.wxa.k0.f fVar = this.f125118q;
            if (com.tencent.luggage.wxa.e0.b.a(fVar, fVar.c(this.f125107f.a(aVar.f124460c)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public void a(a.C6226a c6226a, long j3) {
        int c16;
        int a16 = this.f125107f.a(c6226a.f126317b);
        if (a16 == -1 || (c16 = this.f125118q.c(a16)) == -1) {
            return;
        }
        this.f125118q.a(c16, j3);
    }

    public final a a(Uri uri, String str, int i3, int i16, Object obj) {
        return new a(this.f125103b, new com.tencent.luggage.wxa.l0.j(uri, 0L, -1L, null, 1), this.f125105d[i3].f126317b, i16, obj, this.f125110i, str);
    }

    public final void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.g(str).startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING) ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.f125114m = uri;
        this.f125115n = bArr;
        this.f125116o = str;
        this.f125117p = bArr2;
    }

    public final void a() {
        this.f125114m = null;
        this.f125115n = null;
        this.f125116o = null;
        this.f125117p = null;
    }
}
