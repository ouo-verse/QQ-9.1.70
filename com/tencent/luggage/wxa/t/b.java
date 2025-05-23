package com.tencent.luggage.wxa.t;

import com.tencent.luggage.wxa.c0.g;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.q.e;
import com.tencent.luggage.wxa.q.f;
import com.tencent.luggage.wxa.q.g;
import com.tencent.luggage.wxa.q.h;
import com.tencent.luggage.wxa.q.i;
import com.tencent.luggage.wxa.q.j;
import com.tencent.luggage.wxa.q.k;
import java.io.EOFException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements com.tencent.luggage.wxa.q.d {

    /* renamed from: n, reason: collision with root package name */
    public static final g f140791n = new a();

    /* renamed from: o, reason: collision with root package name */
    public static final int f140792o = v.b("Xing");

    /* renamed from: p, reason: collision with root package name */
    public static final int f140793p = v.b("Info");

    /* renamed from: q, reason: collision with root package name */
    public static final int f140794q = v.b("VBRI");

    /* renamed from: a, reason: collision with root package name */
    public final int f140795a;

    /* renamed from: b, reason: collision with root package name */
    public final long f140796b;

    /* renamed from: c, reason: collision with root package name */
    public final l f140797c;

    /* renamed from: d, reason: collision with root package name */
    public final i f140798d;

    /* renamed from: e, reason: collision with root package name */
    public final h f140799e;

    /* renamed from: f, reason: collision with root package name */
    public f f140800f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f140801g;

    /* renamed from: h, reason: collision with root package name */
    public int f140802h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.a0.a f140803i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC6729b f140804j;

    /* renamed from: k, reason: collision with root package name */
    public long f140805k;

    /* renamed from: l, reason: collision with root package name */
    public long f140806l;

    /* renamed from: m, reason: collision with root package name */
    public int f140807m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new b()};
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6729b extends k {
        long b(long j3);
    }

    public b() {
        this(0);
    }

    public static boolean a(int i3, long j3) {
        return ((long) (i3 & (-128000))) == (j3 & (-128000));
    }

    public final InterfaceC6729b b(e eVar) {
        eVar.b(this.f140797c.f135088a, 0, 4);
        this.f140797c.e(0);
        i.a(this.f140797c.f(), this.f140798d);
        return new com.tencent.luggage.wxa.t.a(eVar.getPosition(), this.f140798d.f137767f, eVar.getLength());
    }

    public final InterfaceC6729b c(e eVar) {
        int i3;
        l lVar = new l(this.f140798d.f137764c);
        eVar.b(lVar.f135088a, 0, this.f140798d.f137764c);
        i iVar = this.f140798d;
        int i16 = iVar.f137762a & 1;
        int i17 = iVar.f137766e;
        if (i16 != 0) {
            if (i17 != 1) {
                i3 = 36;
            }
            i3 = 21;
        } else {
            if (i17 == 1) {
                i3 = 13;
            }
            i3 = 21;
        }
        int i18 = i3;
        int a16 = a(lVar, i18);
        if (a16 != f140792o && a16 != f140793p) {
            if (a16 == f140794q) {
                c a17 = c.a(this.f140798d, lVar, eVar.getPosition(), eVar.getLength());
                eVar.c(this.f140798d.f137764c);
                return a17;
            }
            eVar.a();
            return null;
        }
        d a18 = d.a(this.f140798d, lVar, eVar.getPosition(), eVar.getLength());
        if (a18 != null && !this.f140799e.a()) {
            eVar.a();
            eVar.a(i18 + 141);
            eVar.b(this.f140797c.f135088a, 0, 3);
            this.f140797c.e(0);
            this.f140799e.a(this.f140797c.t());
        }
        eVar.c(this.f140798d.f137764c);
        if (a18 != null && !a18.a() && a16 == f140793p) {
            return b(eVar);
        }
        return a18;
    }

    public final void d(e eVar) {
        g.a aVar;
        int i3 = 0;
        while (true) {
            eVar.b(this.f140797c.f135088a, 0, 10);
            this.f140797c.e(0);
            if (this.f140797c.t() != com.tencent.luggage.wxa.c0.g.f123185b) {
                eVar.a();
                eVar.a(i3);
                return;
            }
            this.f140797c.f(3);
            int p16 = this.f140797c.p();
            int i16 = p16 + 10;
            if (this.f140803i == null) {
                byte[] bArr = new byte[i16];
                System.arraycopy(this.f140797c.f135088a, 0, bArr, 0, 10);
                eVar.b(bArr, 10, p16);
                if ((this.f140795a & 2) != 0) {
                    aVar = h.f137751c;
                } else {
                    aVar = null;
                }
                com.tencent.luggage.wxa.a0.a a16 = new com.tencent.luggage.wxa.c0.g(aVar).a(bArr, i16);
                this.f140803i = a16;
                if (a16 != null) {
                    this.f140799e.a(a16);
                }
            } else {
                eVar.a(p16);
            }
            i3 += i16;
        }
    }

    public final int e(e eVar) {
        if (this.f140807m == 0) {
            eVar.a();
            if (!eVar.a(this.f140797c.f135088a, 0, 4, true)) {
                return -1;
            }
            this.f140797c.e(0);
            int f16 = this.f140797c.f();
            if (a(f16, this.f140802h) && i.a(f16) != -1) {
                i.a(f16, this.f140798d);
                if (this.f140805k == -9223372036854775807L) {
                    this.f140805k = this.f140804j.b(eVar.getPosition());
                    if (this.f140796b != -9223372036854775807L) {
                        this.f140805k += this.f140796b - this.f140804j.b(0L);
                    }
                }
                this.f140807m = this.f140798d.f137764c;
            } else {
                eVar.c(1);
                this.f140802h = 0;
                return 0;
            }
        }
        int a16 = this.f140801g.a(eVar, this.f140807m, true);
        if (a16 == -1) {
            return -1;
        }
        int i3 = this.f140807m - a16;
        this.f140807m = i3;
        if (i3 > 0) {
            return 0;
        }
        this.f140801g.a(this.f140805k + ((this.f140806l * 1000000) / r14.f137765d), 1, this.f140798d.f137764c, 0, null);
        this.f140806l += this.f140798d.f137768g;
        this.f140807m = 0;
        return 0;
    }

    public b(int i3) {
        this(i3, -9223372036854775807L);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(e eVar) {
        return a(eVar, true);
    }

    public b(int i3, long j3) {
        this.f140795a = i3;
        this.f140796b = j3;
        this.f140797c = new l(10);
        this.f140798d = new i();
        this.f140799e = new h();
        this.f140805k = -9223372036854775807L;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(f fVar) {
        this.f140800f = fVar;
        this.f140801g = fVar.a(0, 1);
        this.f140800f.e();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f140802h = 0;
        this.f140805k = -9223372036854775807L;
        this.f140806l = 0L;
        this.f140807m = 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(e eVar, j jVar) {
        if (this.f140802h == 0) {
            try {
                a(eVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f140804j == null) {
            InterfaceC6729b c16 = c(eVar);
            this.f140804j = c16;
            if (c16 == null || (!c16.a() && (this.f140795a & 1) != 0)) {
                this.f140804j = b(eVar);
            }
            this.f140800f.a(this.f140804j);
            com.tencent.luggage.wxa.q.l lVar = this.f140801g;
            i iVar = this.f140798d;
            String str = iVar.f137763b;
            int i3 = iVar.f137766e;
            int i16 = iVar.f137765d;
            h hVar = this.f140799e;
            lVar.a(com.tencent.luggage.wxa.m.j.a((String) null, str, (String) null, -1, 4096, i3, i16, -1, hVar.f137753a, hVar.f137754b, (List) null, (com.tencent.luggage.wxa.p.a) null, 0, (String) null, (this.f140795a & 2) != 0 ? null : this.f140803i));
        }
        return e(eVar);
    }

    public final boolean a(e eVar, boolean z16) {
        int i3;
        int i16;
        int a16;
        int i17 = z16 ? 16384 : 131072;
        eVar.a();
        if (eVar.getPosition() == 0) {
            d(eVar);
            i3 = (int) eVar.b();
            if (!z16) {
                eVar.c(i3);
            }
            i16 = 0;
        } else {
            i3 = 0;
            i16 = 0;
        }
        int i18 = i16;
        int i19 = i18;
        while (true) {
            if (!eVar.a(this.f140797c.f135088a, 0, 4, i16 > 0)) {
                break;
            }
            this.f140797c.e(0);
            int f16 = this.f140797c.f();
            if ((i18 == 0 || a(f16, i18)) && (a16 = i.a(f16)) != -1) {
                i16++;
                if (i16 != 1) {
                    if (i16 == 4) {
                        break;
                    }
                } else {
                    i.a(f16, this.f140798d);
                    i18 = f16;
                }
                eVar.a(a16 - 4);
            } else {
                int i26 = i19 + 1;
                if (i19 == i17) {
                    if (z16) {
                        return false;
                    }
                    throw new o("Searched too many bytes.");
                }
                if (z16) {
                    eVar.a();
                    eVar.a(i3 + i26);
                } else {
                    eVar.c(1);
                }
                i18 = 0;
                i19 = i26;
                i16 = 0;
            }
        }
        if (z16) {
            eVar.c(i3 + i19);
        } else {
            eVar.a();
        }
        this.f140802h = i18;
        return true;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }

    public static int a(l lVar, int i3) {
        if (lVar.d() >= i3 + 4) {
            lVar.e(i3);
            int f16 = lVar.f();
            if (f16 == f140792o || f16 == f140793p) {
                return f16;
            }
        }
        if (lVar.d() < 40) {
            return 0;
        }
        lVar.e(36);
        int f17 = lVar.f();
        int i16 = f140794q;
        if (f17 == i16) {
            return i16;
        }
        return 0;
    }
}
