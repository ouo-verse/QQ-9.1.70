package com.tencent.luggage.wxa.u;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.s;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.p.a;
import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.q.l;
import com.tencent.luggage.wxa.u.a;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements com.tencent.luggage.wxa.q.d {
    public static final com.tencent.luggage.wxa.q.g F = new a();
    public static final int G = v.b("seig");
    public static final byte[] H = {-94, 57, 79, 82, 90, -101, 79, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, -94, 68, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 66, 124, 100, -115, -12};
    public boolean A;
    public com.tencent.luggage.wxa.q.f B;
    public com.tencent.luggage.wxa.q.l C;
    public com.tencent.luggage.wxa.q.l[] D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public final int f141883a;

    /* renamed from: b, reason: collision with root package name */
    public final j f141884b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f141885c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141886d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141887e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141888f;

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141889g;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141890h;

    /* renamed from: i, reason: collision with root package name */
    public final s f141891i;

    /* renamed from: j, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f141892j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f141893k;

    /* renamed from: l, reason: collision with root package name */
    public final Stack f141894l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedList f141895m;

    /* renamed from: n, reason: collision with root package name */
    public int f141896n;

    /* renamed from: o, reason: collision with root package name */
    public int f141897o;

    /* renamed from: p, reason: collision with root package name */
    public long f141898p;

    /* renamed from: q, reason: collision with root package name */
    public int f141899q;

    /* renamed from: r, reason: collision with root package name */
    public com.tencent.luggage.wxa.n0.l f141900r;

    /* renamed from: s, reason: collision with root package name */
    public long f141901s;

    /* renamed from: t, reason: collision with root package name */
    public int f141902t;

    /* renamed from: u, reason: collision with root package name */
    public long f141903u;

    /* renamed from: v, reason: collision with root package name */
    public long f141904v;

    /* renamed from: w, reason: collision with root package name */
    public c f141905w;

    /* renamed from: x, reason: collision with root package name */
    public int f141906x;

    /* renamed from: y, reason: collision with root package name */
    public int f141907y;

    /* renamed from: z, reason: collision with root package name */
    public int f141908z;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new e()};
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f141909a;

        /* renamed from: b, reason: collision with root package name */
        public final int f141910b;

        public b(long j3, int i3) {
            this.f141909a = j3;
            this.f141910b = i3;
        }
    }

    public e() {
        this(0);
    }

    public static Pair d(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(12);
        return Pair.create(Integer.valueOf(lVar.f()), new com.tencent.luggage.wxa.u.c(lVar.u() - 1, lVar.u(), lVar.u(), lVar.f()));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        return i.a(eVar);
    }

    public final boolean b(com.tencent.luggage.wxa.q.e eVar) {
        if (this.f141899q == 0) {
            if (!eVar.b(this.f141892j.f135088a, 0, 8, true)) {
                return false;
            }
            this.f141899q = 8;
            this.f141892j.e(0);
            this.f141898p = this.f141892j.s();
            this.f141897o = this.f141892j.f();
        }
        long j3 = this.f141898p;
        if (j3 == 1) {
            eVar.a(this.f141892j.f135088a, 8, 8);
            this.f141899q += 8;
            this.f141898p = this.f141892j.v();
        } else if (j3 == 0) {
            long length = eVar.getLength();
            if (length == -1 && !this.f141894l.isEmpty()) {
                length = ((a.C6775a) this.f141894l.peek()).Q0;
            }
            if (length != -1) {
                this.f141898p = (length - eVar.getPosition()) + this.f141899q;
            }
        }
        if (this.f141898p >= this.f141899q) {
            long position = eVar.getPosition() - this.f141899q;
            if (this.f141897o == com.tencent.luggage.wxa.u.a.L) {
                int size = this.f141885c.size();
                for (int i3 = 0; i3 < size; i3++) {
                    l lVar = ((c) this.f141885c.valueAt(i3)).f141911a;
                    lVar.f141984b = position;
                    lVar.f141986d = position;
                    lVar.f141985c = position;
                }
            }
            int i16 = this.f141897o;
            if (i16 == com.tencent.luggage.wxa.u.a.f141805i) {
                this.f141905w = null;
                this.f141901s = position + this.f141898p;
                if (!this.E) {
                    this.B.a(new k.a(this.f141903u));
                    this.E = true;
                }
                this.f141896n = 2;
                return true;
            }
            if (a(i16)) {
                long position2 = (eVar.getPosition() + this.f141898p) - 8;
                this.f141894l.add(new a.C6775a(this.f141897o, position2));
                if (this.f141898p == this.f141899q) {
                    a(position2);
                } else {
                    a();
                }
            } else if (b(this.f141897o)) {
                if (this.f141899q == 8) {
                    long j16 = this.f141898p;
                    if (j16 <= TTL.MAX_VALUE) {
                        com.tencent.luggage.wxa.n0.l lVar2 = new com.tencent.luggage.wxa.n0.l((int) j16);
                        this.f141900r = lVar2;
                        System.arraycopy(this.f141892j.f135088a, 0, lVar2.f135088a, 0, 8);
                        this.f141896n = 1;
                    } else {
                        throw new o("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new o("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.f141898p <= TTL.MAX_VALUE) {
                this.f141900r = null;
                this.f141896n = 1;
            } else {
                throw new o("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new o("Atom size less than header length (unsupported).");
    }

    public final void c(com.tencent.luggage.wxa.q.e eVar) {
        int i3 = ((int) this.f141898p) - this.f141899q;
        com.tencent.luggage.wxa.n0.l lVar = this.f141900r;
        if (lVar != null) {
            eVar.a(lVar.f135088a, 8, i3);
            a(new a.b(this.f141897o, this.f141900r), eVar.getPosition());
        } else {
            eVar.c(i3);
        }
        a(eVar.getPosition());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e(com.tencent.luggage.wxa.q.e eVar) {
        int i3;
        l.a aVar;
        int a16;
        boolean z16;
        int i16 = 4;
        int i17 = 1;
        int i18 = 0;
        if (this.f141896n == 3) {
            if (this.f141905w == null) {
                c a17 = a(this.f141885c);
                if (a17 == null) {
                    int position = (int) (this.f141901s - eVar.getPosition());
                    if (position >= 0) {
                        eVar.c(position);
                        a();
                        return false;
                    }
                    throw new o("Offset to end of mdat was negative.");
                }
                int position2 = (int) (a17.f141911a.f141989g[a17.f141917g] - eVar.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                eVar.c(position2);
                this.f141905w = a17;
            }
            c cVar = this.f141905w;
            l lVar = cVar.f141911a;
            this.f141906x = lVar.f141991i[cVar.f141915e];
            if (lVar.f141995m) {
                int a18 = a(cVar);
                this.f141907y = a18;
                this.f141906x += a18;
            } else {
                this.f141907y = 0;
            }
            if (this.f141905w.f141913c.f141973g == 1) {
                this.f141906x -= 8;
                eVar.c(8);
            }
            this.f141896n = 4;
            this.f141908z = 0;
        }
        c cVar2 = this.f141905w;
        l lVar2 = cVar2.f141911a;
        j jVar = cVar2.f141913c;
        com.tencent.luggage.wxa.q.l lVar3 = cVar2.f141912b;
        int i19 = cVar2.f141915e;
        int i26 = jVar.f141976j;
        if (i26 == 0) {
            while (true) {
                int i27 = this.f141907y;
                int i28 = this.f141906x;
                if (i27 >= i28) {
                    break;
                }
                this.f141907y += lVar3.a(eVar, i28 - i27, false);
            }
        } else {
            byte[] bArr = this.f141887e.f135088a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i29 = i26 + 1;
            int i36 = 4 - i26;
            while (this.f141907y < this.f141906x) {
                int i37 = this.f141908z;
                if (i37 == 0) {
                    eVar.a(bArr, i36, i29);
                    this.f141887e.e(i18);
                    this.f141908z = this.f141887e.u() - i17;
                    this.f141886d.e(i18);
                    lVar3.a(this.f141886d, i16);
                    lVar3.a(this.f141887e, i17);
                    if (this.D != null && com.tencent.luggage.wxa.n0.j.a(jVar.f141972f.f133896f, bArr[i16])) {
                        z16 = i17;
                    } else {
                        z16 = i18;
                    }
                    this.A = z16;
                    this.f141907y += 5;
                    this.f141906x += i36;
                } else {
                    if (this.A) {
                        this.f141888f.c(i37);
                        eVar.a(this.f141888f.f135088a, i18, this.f141908z);
                        lVar3.a(this.f141888f, this.f141908z);
                        a16 = this.f141908z;
                        com.tencent.luggage.wxa.n0.l lVar4 = this.f141888f;
                        int c16 = com.tencent.luggage.wxa.n0.j.c(lVar4.f135088a, lVar4.d());
                        this.f141888f.e("video/hevc".equals(jVar.f141972f.f133896f) ? 1 : 0);
                        this.f141888f.d(c16);
                        com.tencent.luggage.wxa.i0.a.a(lVar2.a(i19) * 1000, this.f141888f, this.D);
                    } else {
                        a16 = lVar3.a(eVar, i37, i18);
                    }
                    this.f141907y += a16;
                    this.f141908z -= a16;
                    i16 = 4;
                    i17 = 1;
                    i18 = 0;
                }
            }
        }
        long a19 = lVar2.a(i19) * 1000;
        s sVar = this.f141891i;
        if (sVar != null) {
            a19 = sVar.a(a19);
        }
        boolean z17 = lVar2.f141994l[i19];
        if (lVar2.f141995m) {
            int i38 = (z17 ? 1 : 0) | 1073741824;
            k kVar = lVar2.f141997o;
            if (kVar == null) {
                kVar = jVar.a(lVar2.f141983a.f141874a);
            }
            i3 = i38;
            aVar = kVar.f141980c;
        } else {
            i3 = z17 ? 1 : 0;
            aVar = null;
        }
        lVar3.a(a19, i3, this.f141906x, 0, aVar);
        while (!this.f141895m.isEmpty()) {
            b bVar = (b) this.f141895m.removeFirst();
            int i39 = this.f141902t;
            int i46 = bVar.f141910b;
            int i47 = i39 - i46;
            this.f141902t = i47;
            this.C.a(a19 + bVar.f141909a, 1, i46, i47, null);
        }
        c cVar3 = this.f141905w;
        cVar3.f141915e++;
        int i48 = cVar3.f141916f + 1;
        cVar3.f141916f = i48;
        int[] iArr = lVar2.f141990h;
        int i49 = cVar3.f141917g;
        if (i48 == iArr[i49]) {
            cVar3.f141917g = i49 + 1;
            cVar3.f141916f = 0;
            this.f141905w = null;
        }
        this.f141896n = 3;
        return true;
    }

    public e(int i3) {
        this(i3, null);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.B = fVar;
        j jVar = this.f141884b;
        if (jVar != null) {
            c cVar = new c(fVar.a(0, jVar.f141968b));
            cVar.a(this.f141884b, new com.tencent.luggage.wxa.u.c(0, 0, 0, 0));
            this.f141885c.put(0, cVar);
            b();
            this.B.e();
        }
    }

    public e(int i3, s sVar) {
        this(i3, sVar, null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final l f141911a = new l();

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.l f141912b;

        /* renamed from: c, reason: collision with root package name */
        public j f141913c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.u.c f141914d;

        /* renamed from: e, reason: collision with root package name */
        public int f141915e;

        /* renamed from: f, reason: collision with root package name */
        public int f141916f;

        /* renamed from: g, reason: collision with root package name */
        public int f141917g;

        public c(com.tencent.luggage.wxa.q.l lVar) {
            this.f141912b = lVar;
        }

        public void a(j jVar, com.tencent.luggage.wxa.u.c cVar) {
            this.f141913c = (j) com.tencent.luggage.wxa.n0.a.a(jVar);
            this.f141914d = (com.tencent.luggage.wxa.u.c) com.tencent.luggage.wxa.n0.a.a(cVar);
            this.f141912b.a(jVar.f141972f);
            a();
        }

        public void a() {
            this.f141911a.a();
            this.f141915e = 0;
            this.f141917g = 0;
            this.f141916f = 0;
        }

        public void a(com.tencent.luggage.wxa.p.a aVar) {
            k a16 = this.f141913c.a(this.f141911a.f141983a.f141874a);
            this.f141912b.a(this.f141913c.f141972f.a(aVar.a(a16 != null ? a16.f141979b : null)));
        }
    }

    public e(int i3, s sVar, j jVar) {
        this.f141883a = i3 | (jVar != null ? 16 : 0);
        this.f141891i = sVar;
        this.f141884b = jVar;
        this.f141892j = new com.tencent.luggage.wxa.n0.l(16);
        this.f141886d = new com.tencent.luggage.wxa.n0.l(com.tencent.luggage.wxa.n0.j.f135067a);
        this.f141887e = new com.tencent.luggage.wxa.n0.l(5);
        this.f141888f = new com.tencent.luggage.wxa.n0.l();
        this.f141889g = new com.tencent.luggage.wxa.n0.l(1);
        this.f141890h = new com.tencent.luggage.wxa.n0.l();
        this.f141893k = new byte[16];
        this.f141894l = new Stack();
        this.f141895m = new LinkedList();
        this.f141885c = new SparseArray();
        this.f141903u = -9223372036854775807L;
        this.f141904v = -9223372036854775807L;
        a();
    }

    public final void c(a.C6775a c6775a) {
        int i3;
        int i16;
        int i17 = 0;
        com.tencent.luggage.wxa.n0.a.b(this.f141884b == null, "Unexpected moov box.");
        com.tencent.luggage.wxa.p.a a16 = a(c6775a.R0);
        a.C6775a d16 = c6775a.d(com.tencent.luggage.wxa.u.a.N);
        SparseArray sparseArray = new SparseArray();
        int size = d16.R0.size();
        long j3 = -9223372036854775807L;
        for (int i18 = 0; i18 < size; i18++) {
            a.b bVar = (a.b) d16.R0.get(i18);
            int i19 = bVar.f141841a;
            if (i19 == com.tencent.luggage.wxa.u.a.f141839z) {
                Pair d17 = d(bVar.Q0);
                sparseArray.put(((Integer) d17.first).intValue(), d17.second);
            } else if (i19 == com.tencent.luggage.wxa.u.a.O) {
                j3 = b(bVar.Q0);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c6775a.S0.size();
        int i26 = 0;
        while (i26 < size2) {
            a.C6775a c6775a2 = (a.C6775a) c6775a.S0.get(i26);
            if (c6775a2.f141841a == com.tencent.luggage.wxa.u.a.E) {
                i3 = i26;
                i16 = size2;
                j a17 = com.tencent.luggage.wxa.u.b.a(c6775a2, c6775a.e(com.tencent.luggage.wxa.u.a.D), j3, a16, (this.f141883a & 32) != 0, false);
                if (a17 != null) {
                    sparseArray2.put(a17.f141967a, a17);
                }
            } else {
                i3 = i26;
                i16 = size2;
            }
            i26 = i3 + 1;
            size2 = i16;
        }
        int size3 = sparseArray2.size();
        if (this.f141885c.size() == 0) {
            while (i17 < size3) {
                j jVar = (j) sparseArray2.valueAt(i17);
                c cVar = new c(this.B.a(i17, jVar.f141968b));
                cVar.a(jVar, (com.tencent.luggage.wxa.u.c) sparseArray.get(jVar.f141967a));
                this.f141885c.put(jVar.f141967a, cVar);
                this.f141903u = Math.max(this.f141903u, jVar.f141971e);
                i17++;
            }
            b();
            this.B.e();
            return;
        }
        com.tencent.luggage.wxa.n0.a.b(this.f141885c.size() == size3);
        while (i17 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i17);
            ((c) this.f141885c.get(jVar2.f141967a)).a(jVar2, (com.tencent.luggage.wxa.u.c) sparseArray.get(jVar2.f141967a));
            i17++;
        }
    }

    public final void d(com.tencent.luggage.wxa.q.e eVar) {
        int size = this.f141885c.size();
        c cVar = null;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            l lVar = ((c) this.f141885c.valueAt(i3)).f141911a;
            if (lVar.f142000r) {
                long j16 = lVar.f141986d;
                if (j16 < j3) {
                    cVar = (c) this.f141885c.valueAt(i3);
                    j3 = j16;
                }
            }
        }
        if (cVar == null) {
            this.f141896n = 3;
            return;
        }
        int position = (int) (j3 - eVar.getPosition());
        if (position >= 0) {
            eVar.c(position);
            cVar.f141911a.a(eVar);
            return;
        }
        throw new o("Offset to encryption data was negative.");
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        int size = this.f141885c.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((c) this.f141885c.valueAt(i3)).a();
        }
        this.f141895m.clear();
        this.f141902t = 0;
        this.f141894l.clear();
        a();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        while (true) {
            int i3 = this.f141896n;
            if (i3 != 0) {
                if (i3 == 1) {
                    c(eVar);
                } else if (i3 != 2) {
                    if (e(eVar)) {
                        return 0;
                    }
                } else {
                    d(eVar);
                }
            } else if (!b(eVar)) {
                return -1;
            }
        }
    }

    public final void a() {
        this.f141896n = 0;
        this.f141899q = 0;
    }

    public final void a(long j3) {
        while (!this.f141894l.isEmpty() && ((a.C6775a) this.f141894l.peek()).Q0 == j3) {
            a((a.C6775a) this.f141894l.pop());
        }
        a();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }

    public final void a(a.b bVar, long j3) {
        if (!this.f141894l.isEmpty()) {
            ((a.C6775a) this.f141894l.peek()).a(bVar);
            return;
        }
        int i3 = bVar.f141841a;
        if (i3 == com.tencent.luggage.wxa.u.a.B) {
            Pair a16 = a(bVar.Q0, j3);
            this.f141904v = ((Long) a16.first).longValue();
            this.B.a((com.tencent.luggage.wxa.q.k) a16.second);
            this.E = true;
            return;
        }
        if (i3 == com.tencent.luggage.wxa.u.a.H0) {
            a(bVar.Q0);
        }
    }

    public final void a(a.C6775a c6775a) {
        int i3 = c6775a.f141841a;
        if (i3 == com.tencent.luggage.wxa.u.a.C) {
            c(c6775a);
        } else if (i3 == com.tencent.luggage.wxa.u.a.L) {
            b(c6775a);
        } else {
            if (this.f141894l.isEmpty()) {
                return;
            }
            ((a.C6775a) this.f141894l.peek()).a(c6775a);
        }
    }

    public static long c(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(8);
        return com.tencent.luggage.wxa.u.a.c(lVar.f()) == 1 ? lVar.v() : lVar.s();
    }

    public final void a(com.tencent.luggage.wxa.n0.l lVar) {
        if (this.C == null) {
            return;
        }
        lVar.e(12);
        lVar.n();
        lVar.n();
        long b16 = v.b(lVar.s(), 1000000L, lVar.s());
        lVar.e(12);
        int a16 = lVar.a();
        this.C.a(lVar, a16);
        long j3 = this.f141904v;
        if (j3 != -9223372036854775807L) {
            this.C.a(j3 + b16, 1, a16, 0, null);
        } else {
            this.f141895m.addLast(new b(b16, a16));
            this.f141902t += a16;
        }
    }

    public final void b(a.C6775a c6775a) {
        a(c6775a, this.f141885c, this.f141883a, this.f141893k);
        com.tencent.luggage.wxa.p.a a16 = a(c6775a.R0);
        if (a16 != null) {
            int size = this.f141885c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((c) this.f141885c.valueAt(i3)).a(a16);
            }
        }
    }

    public static void a(a.C6775a c6775a, SparseArray sparseArray, int i3, byte[] bArr) {
        int size = c6775a.S0.size();
        for (int i16 = 0; i16 < size; i16++) {
            a.C6775a c6775a2 = (a.C6775a) c6775a.S0.get(i16);
            if (c6775a2.f141841a == com.tencent.luggage.wxa.u.a.M) {
                b(c6775a2, sparseArray, i3, bArr);
            }
        }
    }

    public final void b() {
        if ((this.f141883a & 4) != 0 && this.C == null) {
            com.tencent.luggage.wxa.q.l a16 = this.B.a(this.f141885c.size(), 4);
            this.C = a16;
            a16.a(com.tencent.luggage.wxa.m.j.a((String) null, "application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.f141883a & 8) == 0 || this.D != null) {
            return;
        }
        com.tencent.luggage.wxa.q.l a17 = this.B.a(this.f141885c.size() + 1, 3);
        a17.a(com.tencent.luggage.wxa.m.j.a(null, "application/cea-608", 0, null));
        this.D = new com.tencent.luggage.wxa.q.l[]{a17};
    }

    public static void a(a.C6775a c6775a, c cVar, long j3, int i3) {
        List list = c6775a.R0;
        int size = list.size();
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            a.b bVar = (a.b) list.get(i18);
            if (bVar.f141841a == com.tencent.luggage.wxa.u.a.A) {
                com.tencent.luggage.wxa.n0.l lVar = bVar.Q0;
                lVar.e(12);
                int u16 = lVar.u();
                if (u16 > 0) {
                    i17 += u16;
                    i16++;
                }
            }
        }
        cVar.f141917g = 0;
        cVar.f141916f = 0;
        cVar.f141915e = 0;
        cVar.f141911a.a(i16, i17);
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < size; i27++) {
            a.b bVar2 = (a.b) list.get(i27);
            if (bVar2.f141841a == com.tencent.luggage.wxa.u.a.A) {
                i26 = a(cVar, i19, j3, i3, bVar2.Q0, i26);
                i19++;
            }
        }
    }

    public static long b(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(8);
        return com.tencent.luggage.wxa.u.a.c(lVar.f()) == 0 ? lVar.s() : lVar.v();
    }

    public static void b(a.C6775a c6775a, SparseArray sparseArray, int i3, byte[] bArr) {
        c a16 = a(c6775a.e(com.tencent.luggage.wxa.u.a.f141837y).Q0, sparseArray, i3);
        if (a16 == null) {
            return;
        }
        l lVar = a16.f141911a;
        long j3 = lVar.f142001s;
        a16.a();
        int i16 = com.tencent.luggage.wxa.u.a.f141835x;
        if (c6775a.e(i16) != null && (i3 & 2) == 0) {
            j3 = c(c6775a.e(i16).Q0);
        }
        a(c6775a, a16, j3, i3);
        k a17 = a16.f141913c.a(lVar.f141983a.f141874a);
        a.b e16 = c6775a.e(com.tencent.luggage.wxa.u.a.f141796d0);
        if (e16 != null) {
            a(a17, e16.Q0, lVar);
        }
        a.b e17 = c6775a.e(com.tencent.luggage.wxa.u.a.f141798e0);
        if (e17 != null) {
            a(e17.Q0, lVar);
        }
        a.b e18 = c6775a.e(com.tencent.luggage.wxa.u.a.f141806i0);
        if (e18 != null) {
            b(e18.Q0, lVar);
        }
        a.b e19 = c6775a.e(com.tencent.luggage.wxa.u.a.f141800f0);
        a.b e26 = c6775a.e(com.tencent.luggage.wxa.u.a.f141802g0);
        if (e19 != null && e26 != null) {
            a(e19.Q0, e26.Q0, a17 != null ? a17.f141979b : null, lVar);
        }
        int size = c6775a.R0.size();
        for (int i17 = 0; i17 < size; i17++) {
            a.b bVar = (a.b) c6775a.R0.get(i17);
            if (bVar.f141841a == com.tencent.luggage.wxa.u.a.f141804h0) {
                a(bVar.Q0, lVar, bArr);
            }
        }
    }

    public static void a(k kVar, com.tencent.luggage.wxa.n0.l lVar, l lVar2) {
        int i3;
        int i16 = kVar.f141981d;
        lVar.e(8);
        if ((com.tencent.luggage.wxa.u.a.b(lVar.f()) & 1) == 1) {
            lVar.f(8);
        }
        int q16 = lVar.q();
        int u16 = lVar.u();
        if (u16 == lVar2.f141988f) {
            if (q16 == 0) {
                boolean[] zArr = lVar2.f141996n;
                i3 = 0;
                for (int i17 = 0; i17 < u16; i17++) {
                    int q17 = lVar.q();
                    i3 += q17;
                    zArr[i17] = q17 > i16;
                }
            } else {
                i3 = (q16 * u16) + 0;
                Arrays.fill(lVar2.f141996n, 0, u16, q16 > i16);
            }
            lVar2.b(i3);
            return;
        }
        throw new o("Length mismatch: " + u16 + ", " + lVar2.f141988f);
    }

    public static void a(com.tencent.luggage.wxa.n0.l lVar, l lVar2) {
        lVar.e(8);
        int f16 = lVar.f();
        if ((com.tencent.luggage.wxa.u.a.b(f16) & 1) == 1) {
            lVar.f(8);
        }
        int u16 = lVar.u();
        if (u16 == 1) {
            lVar2.f141986d += com.tencent.luggage.wxa.u.a.c(f16) == 0 ? lVar.s() : lVar.v();
        } else {
            throw new o("Unexpected saio entry count: " + u16);
        }
    }

    public static void b(com.tencent.luggage.wxa.n0.l lVar, l lVar2) {
        a(lVar, 0, lVar2);
    }

    public static boolean b(int i3) {
        return i3 == com.tencent.luggage.wxa.u.a.T || i3 == com.tencent.luggage.wxa.u.a.S || i3 == com.tencent.luggage.wxa.u.a.D || i3 == com.tencent.luggage.wxa.u.a.B || i3 == com.tencent.luggage.wxa.u.a.U || i3 == com.tencent.luggage.wxa.u.a.f141835x || i3 == com.tencent.luggage.wxa.u.a.f141837y || i3 == com.tencent.luggage.wxa.u.a.P || i3 == com.tencent.luggage.wxa.u.a.f141839z || i3 == com.tencent.luggage.wxa.u.a.A || i3 == com.tencent.luggage.wxa.u.a.V || i3 == com.tencent.luggage.wxa.u.a.f141796d0 || i3 == com.tencent.luggage.wxa.u.a.f141798e0 || i3 == com.tencent.luggage.wxa.u.a.f141806i0 || i3 == com.tencent.luggage.wxa.u.a.f141804h0 || i3 == com.tencent.luggage.wxa.u.a.f141800f0 || i3 == com.tencent.luggage.wxa.u.a.f141802g0 || i3 == com.tencent.luggage.wxa.u.a.R || i3 == com.tencent.luggage.wxa.u.a.O || i3 == com.tencent.luggage.wxa.u.a.H0;
    }

    public static c a(com.tencent.luggage.wxa.n0.l lVar, SparseArray sparseArray, int i3) {
        lVar.e(8);
        int b16 = com.tencent.luggage.wxa.u.a.b(lVar.f());
        int f16 = lVar.f();
        if ((i3 & 16) != 0) {
            f16 = 0;
        }
        c cVar = (c) sparseArray.get(f16);
        if (cVar == null) {
            return null;
        }
        if ((b16 & 1) != 0) {
            long v3 = lVar.v();
            l lVar2 = cVar.f141911a;
            lVar2.f141985c = v3;
            lVar2.f141986d = v3;
        }
        com.tencent.luggage.wxa.u.c cVar2 = cVar.f141914d;
        cVar.f141911a.f141983a = new com.tencent.luggage.wxa.u.c((b16 & 2) != 0 ? lVar.u() - 1 : cVar2.f141874a, (b16 & 8) != 0 ? lVar.u() : cVar2.f141875b, (b16 & 16) != 0 ? lVar.u() : cVar2.f141876c, (b16 & 32) != 0 ? lVar.u() : cVar2.f141877d);
        return cVar;
    }

    public static int a(c cVar, int i3, long j3, int i16, com.tencent.luggage.wxa.n0.l lVar, int i17) {
        boolean z16;
        int i18;
        boolean z17;
        int i19;
        boolean z18;
        int i26;
        boolean z19;
        int i27;
        int i28;
        boolean z26;
        lVar.e(8);
        int b16 = com.tencent.luggage.wxa.u.a.b(lVar.f());
        j jVar = cVar.f141913c;
        l lVar2 = cVar.f141911a;
        com.tencent.luggage.wxa.u.c cVar2 = lVar2.f141983a;
        lVar2.f141990h[i3] = lVar.u();
        long[] jArr = lVar2.f141989g;
        long j16 = lVar2.f141985c;
        jArr[i3] = j16;
        if ((b16 & 1) != 0) {
            jArr[i3] = j16 + lVar.f();
        }
        boolean z27 = (b16 & 4) != 0;
        int i29 = cVar2.f141877d;
        if (z27) {
            i29 = lVar.u();
        }
        boolean z28 = (b16 & 256) != 0;
        boolean z29 = (b16 & 512) != 0;
        boolean z36 = (b16 & 1024) != 0;
        boolean z37 = (b16 & 2048) != 0;
        long[] jArr2 = jVar.f141974h;
        long j17 = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            j17 = v.b(jVar.f141975i[0], 1000L, jVar.f141969c);
        }
        int[] iArr = lVar2.f141991i;
        int[] iArr2 = lVar2.f141992j;
        long[] jArr3 = lVar2.f141993k;
        boolean[] zArr = lVar2.f141994l;
        int i36 = i29;
        boolean z38 = jVar.f141968b == 2 && (i16 & 1) != 0;
        int i37 = i17 + lVar2.f141990h[i3];
        long j18 = jVar.f141969c;
        long j19 = j17;
        long j26 = i3 > 0 ? lVar2.f142001s : j3;
        int i38 = i17;
        while (i38 < i37) {
            if (z28) {
                z16 = z28;
                i18 = lVar.u();
            } else {
                z16 = z28;
                i18 = cVar2.f141875b;
            }
            if (z29) {
                z17 = z29;
                i19 = lVar.u();
            } else {
                z17 = z29;
                i19 = cVar2.f141876c;
            }
            if (i38 == 0 && z27) {
                z18 = z27;
                i26 = i36;
            } else if (z36) {
                z18 = z27;
                i26 = lVar.f();
            } else {
                z18 = z27;
                i26 = cVar2.f141877d;
            }
            if (z37) {
                z19 = z37;
                i27 = i37;
                i28 = i18;
                iArr2[i38] = (int) ((lVar.f() * 1000) / j18);
                z26 = false;
            } else {
                z19 = z37;
                i27 = i37;
                i28 = i18;
                z26 = false;
                iArr2[i38] = 0;
            }
            jArr3[i38] = v.b(j26, 1000L, j18) - j19;
            iArr[i38] = i19;
            zArr[i38] = (((i26 >> 16) & 1) != 0 || (z38 && i38 != 0)) ? z26 : true;
            j26 += i28;
            i38++;
            z28 = z16;
            z29 = z17;
            z27 = z18;
            z37 = z19;
            i37 = i27;
        }
        int i39 = i37;
        lVar2.f142001s = j26;
        return i39;
    }

    public static void a(com.tencent.luggage.wxa.n0.l lVar, l lVar2, byte[] bArr) {
        lVar.e(8);
        lVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, H)) {
            a(lVar, 16, lVar2);
        }
    }

    public static void a(com.tencent.luggage.wxa.n0.l lVar, int i3, l lVar2) {
        lVar.e(i3 + 8);
        int b16 = com.tencent.luggage.wxa.u.a.b(lVar.f());
        if ((b16 & 1) == 0) {
            boolean z16 = (b16 & 2) != 0;
            int u16 = lVar.u();
            if (u16 == lVar2.f141988f) {
                Arrays.fill(lVar2.f141996n, 0, u16, z16);
                lVar2.b(lVar.a());
                lVar2.a(lVar);
                return;
            } else {
                throw new o("Length mismatch: " + u16 + ", " + lVar2.f141988f);
            }
        }
        throw new o("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public static void a(com.tencent.luggage.wxa.n0.l lVar, com.tencent.luggage.wxa.n0.l lVar2, String str, l lVar3) {
        byte[] bArr;
        lVar.e(8);
        int f16 = lVar.f();
        int f17 = lVar.f();
        int i3 = G;
        if (f17 != i3) {
            return;
        }
        if (com.tencent.luggage.wxa.u.a.c(f16) == 1) {
            lVar.f(4);
        }
        if (lVar.f() == 1) {
            lVar2.e(8);
            int f18 = lVar2.f();
            if (lVar2.f() != i3) {
                return;
            }
            int c16 = com.tencent.luggage.wxa.u.a.c(f18);
            if (c16 == 1) {
                if (lVar2.s() == 0) {
                    throw new o("Variable length description in sgpd found (unsupported)");
                }
            } else if (c16 >= 2) {
                lVar2.f(4);
            }
            if (lVar2.s() == 1) {
                lVar2.f(1);
                int q16 = lVar2.q();
                int i16 = (q16 & 240) >> 4;
                int i17 = q16 & 15;
                boolean z16 = lVar2.q() == 1;
                if (z16) {
                    int q17 = lVar2.q();
                    byte[] bArr2 = new byte[16];
                    lVar2.a(bArr2, 0, 16);
                    if (z16 && q17 == 0) {
                        int q18 = lVar2.q();
                        byte[] bArr3 = new byte[q18];
                        lVar2.a(bArr3, 0, q18);
                        bArr = bArr3;
                    } else {
                        bArr = null;
                    }
                    lVar3.f141995m = true;
                    lVar3.f141997o = new k(z16, str, q17, bArr2, i16, i17, bArr);
                    return;
                }
                return;
            }
            throw new o("Entry count in sgpd != 1 (unsupported).");
        }
        throw new o("Entry count in sbgp != 1 (unsupported).");
    }

    public static Pair a(com.tencent.luggage.wxa.n0.l lVar, long j3) {
        long v3;
        long v16;
        lVar.e(8);
        int c16 = com.tencent.luggage.wxa.u.a.c(lVar.f());
        lVar.f(4);
        long s16 = lVar.s();
        if (c16 == 0) {
            v3 = lVar.s();
            v16 = lVar.s();
        } else {
            v3 = lVar.v();
            v16 = lVar.v();
        }
        long j16 = v3;
        long j17 = j3 + v16;
        long b16 = v.b(j16, 1000000L, s16);
        lVar.f(2);
        int w3 = lVar.w();
        int[] iArr = new int[w3];
        long[] jArr = new long[w3];
        long[] jArr2 = new long[w3];
        long[] jArr3 = new long[w3];
        long j18 = b16;
        int i3 = 0;
        long j19 = j16;
        while (i3 < w3) {
            int f16 = lVar.f();
            if ((f16 & Integer.MIN_VALUE) == 0) {
                long s17 = lVar.s();
                iArr[i3] = f16 & Integer.MAX_VALUE;
                jArr[i3] = j17;
                jArr3[i3] = j18;
                long j26 = j19 + s17;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i16 = w3;
                long b17 = v.b(j26, 1000000L, s16);
                jArr4[i3] = b17 - jArr5[i3];
                lVar.f(4);
                j17 += r1[i3];
                i3++;
                iArr = iArr;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                w3 = i16;
                j19 = j26;
                j18 = b17;
            } else {
                throw new o("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(b16), new com.tencent.luggage.wxa.q.a(iArr, jArr, jArr2, jArr3));
    }

    public static c a(SparseArray sparseArray) {
        int size = sparseArray.size();
        c cVar = null;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            c cVar2 = (c) sparseArray.valueAt(i3);
            int i16 = cVar2.f141917g;
            l lVar = cVar2.f141911a;
            if (i16 != lVar.f141987e) {
                long j16 = lVar.f141989g[i16];
                if (j16 < j3) {
                    cVar = cVar2;
                    j3 = j16;
                }
            }
        }
        return cVar;
    }

    public final int a(c cVar) {
        com.tencent.luggage.wxa.n0.l lVar;
        l lVar2 = cVar.f141911a;
        int i3 = lVar2.f141983a.f141874a;
        k kVar = lVar2.f141997o;
        if (kVar == null) {
            kVar = cVar.f141913c.a(i3);
        }
        int i16 = kVar.f141981d;
        if (i16 != 0) {
            lVar = lVar2.f141999q;
        } else {
            byte[] bArr = kVar.f141982e;
            this.f141890h.a(bArr, bArr.length);
            lVar = this.f141890h;
            i16 = bArr.length;
        }
        boolean z16 = lVar2.f141996n[cVar.f141915e];
        com.tencent.luggage.wxa.n0.l lVar3 = this.f141889g;
        lVar3.f135088a[0] = (byte) ((z16 ? 128 : 0) | i16);
        lVar3.e(0);
        com.tencent.luggage.wxa.q.l lVar4 = cVar.f141912b;
        lVar4.a(this.f141889g, 1);
        lVar4.a(lVar, i16);
        if (!z16) {
            return i16 + 1;
        }
        com.tencent.luggage.wxa.n0.l lVar5 = lVar2.f141999q;
        int w3 = lVar5.w();
        lVar5.f(-2);
        int i17 = (w3 * 6) + 2;
        lVar4.a(lVar5, i17);
        return i16 + 1 + i17;
    }

    public static com.tencent.luggage.wxa.p.a a(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = (a.b) list.get(i3);
            if (bVar.f141841a == com.tencent.luggage.wxa.u.a.V) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.Q0.f135088a;
                UUID b16 = h.b(bArr);
                if (b16 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new a.b(b16, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.tencent.luggage.wxa.p.a(arrayList);
    }

    public static boolean a(int i3) {
        return i3 == com.tencent.luggage.wxa.u.a.C || i3 == com.tencent.luggage.wxa.u.a.E || i3 == com.tencent.luggage.wxa.u.a.F || i3 == com.tencent.luggage.wxa.u.a.G || i3 == com.tencent.luggage.wxa.u.a.H || i3 == com.tencent.luggage.wxa.u.a.L || i3 == com.tencent.luggage.wxa.u.a.M || i3 == com.tencent.luggage.wxa.u.a.N || i3 == com.tencent.luggage.wxa.u.a.Q;
    }
}
