package com.tencent.luggage.wxa.w;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.w.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class u implements com.tencent.luggage.wxa.q.d {

    /* renamed from: l, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.q.g f143949l = new a();

    /* renamed from: m, reason: collision with root package name */
    public static final long f143950m = com.tencent.luggage.wxa.n0.v.b("AC-3");

    /* renamed from: n, reason: collision with root package name */
    public static final long f143951n = com.tencent.luggage.wxa.n0.v.b("EAC3");

    /* renamed from: o, reason: collision with root package name */
    public static final long f143952o = com.tencent.luggage.wxa.n0.v.b("HEVC");

    /* renamed from: a, reason: collision with root package name */
    public final int f143953a;

    /* renamed from: b, reason: collision with root package name */
    public final List f143954b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143955c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f143956d;

    /* renamed from: e, reason: collision with root package name */
    public final v.c f143957e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray f143958f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseBooleanArray f143959g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.f f143960h;

    /* renamed from: i, reason: collision with root package name */
    public int f143961i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f143962j;

    /* renamed from: k, reason: collision with root package name */
    public v f143963k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new u()};
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements q {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.k f143964a = new com.tencent.luggage.wxa.n0.k(new byte[4]);

        public b() {
        }

        @Override // com.tencent.luggage.wxa.w.q
        public void a(com.tencent.luggage.wxa.n0.s sVar, com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        }

        @Override // com.tencent.luggage.wxa.w.q
        public void a(com.tencent.luggage.wxa.n0.l lVar) {
            if (lVar.q() != 0) {
                return;
            }
            lVar.f(7);
            int a16 = lVar.a() / 4;
            for (int i3 = 0; i3 < a16; i3++) {
                lVar.a(this.f143964a, 4);
                int a17 = this.f143964a.a(16);
                this.f143964a.c(3);
                if (a17 == 0) {
                    this.f143964a.c(13);
                } else {
                    int a18 = this.f143964a.a(13);
                    u.this.f143958f.put(a18, new r(new c(a18)));
                    u.c(u.this);
                }
            }
            if (u.this.f143953a != 2) {
                u.this.f143958f.remove(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements q {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.k f143966a = new com.tencent.luggage.wxa.n0.k(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray f143967b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        public final SparseIntArray f143968c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        public final int f143969d;

        public c(int i3) {
            this.f143969d = i3;
        }

        @Override // com.tencent.luggage.wxa.w.q
        public void a(com.tencent.luggage.wxa.n0.s sVar, com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        }

        @Override // com.tencent.luggage.wxa.w.q
        public void a(com.tencent.luggage.wxa.n0.l lVar) {
            com.tencent.luggage.wxa.n0.s sVar;
            if (lVar.q() != 2) {
                return;
            }
            if (u.this.f143953a == 1 || u.this.f143953a == 2 || u.this.f143961i == 1) {
                sVar = (com.tencent.luggage.wxa.n0.s) u.this.f143954b.get(0);
            } else {
                sVar = new com.tencent.luggage.wxa.n0.s(((com.tencent.luggage.wxa.n0.s) u.this.f143954b.get(0)).a());
                u.this.f143954b.add(sVar);
            }
            lVar.f(2);
            int w3 = lVar.w();
            int i3 = 5;
            lVar.f(5);
            lVar.a(this.f143966a, 2);
            int i16 = 4;
            this.f143966a.c(4);
            lVar.f(this.f143966a.a(12));
            if (u.this.f143953a == 2 && u.this.f143963k == null) {
                v.b bVar = new v.b(21, null, null, new byte[0]);
                u uVar = u.this;
                uVar.f143963k = uVar.f143957e.a(21, bVar);
                u.this.f143963k.a(sVar, u.this.f143960h, new v.d(w3, 21, 8192));
            }
            this.f143967b.clear();
            this.f143968c.clear();
            int a16 = lVar.a();
            while (a16 > 0) {
                lVar.a(this.f143966a, i3);
                int a17 = this.f143966a.a(8);
                this.f143966a.c(3);
                int a18 = this.f143966a.a(13);
                this.f143966a.c(i16);
                int a19 = this.f143966a.a(12);
                v.b a26 = a(lVar, a19);
                if (a17 == 6) {
                    a17 = a26.f143974a;
                }
                a16 -= a19 + 5;
                int i17 = u.this.f143953a == 2 ? a17 : a18;
                if (!u.this.f143959g.get(i17)) {
                    v a27 = (u.this.f143953a == 2 && a17 == 21) ? u.this.f143963k : u.this.f143957e.a(a17, a26);
                    if (u.this.f143953a != 2 || a18 < this.f143968c.get(i17, 8192)) {
                        this.f143968c.put(i17, a18);
                        this.f143967b.put(i17, a27);
                    }
                }
                i3 = 5;
                i16 = 4;
            }
            int size = this.f143968c.size();
            for (int i18 = 0; i18 < size; i18++) {
                int keyAt = this.f143968c.keyAt(i18);
                u.this.f143959g.put(keyAt, true);
                v vVar = (v) this.f143967b.valueAt(i18);
                if (vVar != null) {
                    if (vVar != u.this.f143963k) {
                        vVar.a(sVar, u.this.f143960h, new v.d(w3, keyAt, 8192));
                    }
                    u.this.f143958f.put(this.f143968c.valueAt(i18), vVar);
                }
            }
            if (u.this.f143953a == 2) {
                if (u.this.f143962j) {
                    return;
                }
                u.this.f143960h.e();
                u.this.f143961i = 0;
                u.this.f143962j = true;
                return;
            }
            u.this.f143958f.remove(this.f143969d);
            u uVar2 = u.this;
            uVar2.f143961i = uVar2.f143953a != 1 ? u.this.f143961i - 1 : 0;
            if (u.this.f143961i == 0) {
                u.this.f143960h.e();
                u.this.f143962j = true;
            }
        }

        public final v.b a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
            int c16 = lVar.c();
            int i16 = i3 + c16;
            int i17 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (lVar.c() < i16) {
                int q16 = lVar.q();
                int c17 = lVar.c() + lVar.q();
                if (q16 == 5) {
                    long s16 = lVar.s();
                    if (s16 != u.f143950m) {
                        if (s16 != u.f143951n) {
                            if (s16 == u.f143952o) {
                                i17 = 36;
                            }
                        }
                        i17 = 135;
                    }
                    i17 = 129;
                } else {
                    if (q16 != 106) {
                        if (q16 != 122) {
                            if (q16 == 123) {
                                i17 = 138;
                            } else if (q16 == 10) {
                                str = lVar.b(3).trim();
                            } else if (q16 == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (lVar.c() < c17) {
                                    String trim = lVar.b(3).trim();
                                    int q17 = lVar.q();
                                    byte[] bArr = new byte[4];
                                    lVar.a(bArr, 0, 4);
                                    arrayList2.add(new v.a(trim, q17, bArr));
                                }
                                arrayList = arrayList2;
                                i17 = 89;
                            }
                        }
                        i17 = 135;
                    }
                    i17 = 129;
                }
                lVar.f(c17 - lVar.c());
            }
            lVar.e(i16);
            return new v.b(i17, str, arrayList, Arrays.copyOfRange(lVar.f135088a, c16, i16));
        }
    }

    public u() {
        this(0);
    }

    public static /* synthetic */ int c(u uVar) {
        int i3 = uVar.f143961i;
        uVar.f143961i = i3 + 1;
        return i3;
    }

    public u(int i3) {
        this(1, i3);
    }

    public final void d() {
        this.f143959g.clear();
        this.f143958f.clear();
        SparseArray a16 = this.f143957e.a();
        int size = a16.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f143958f.put(a16.keyAt(i3), a16.valueAt(i3));
        }
        this.f143958f.put(0, new r(new b()));
        this.f143963k = null;
    }

    public u(int i3, int i16) {
        this(i3, new com.tencent.luggage.wxa.n0.s(0L), new e(i16));
    }

    public u(int i3, com.tencent.luggage.wxa.n0.s sVar, v.c cVar) {
        this.f143957e = (v.c) com.tencent.luggage.wxa.n0.a.a(cVar);
        this.f143953a = i3;
        if (i3 != 1 && i3 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f143954b = arrayList;
            arrayList.add(sVar);
        } else {
            this.f143954b = Collections.singletonList(sVar);
        }
        this.f143955c = new com.tencent.luggage.wxa.n0.l(9400);
        this.f143959g = new SparseBooleanArray();
        this.f143958f = new SparseArray();
        this.f143956d = new SparseIntArray();
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.tencent.luggage.wxa.q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        byte[] bArr = this.f143955c.f135088a;
        eVar.b(bArr, 0, 940);
        int i3 = 0;
        while (i3 < 188) {
            for (int i16 = 0; i16 != 5; i16++) {
                if (bArr[(i16 * 188) + i3] != 71) {
                    break;
                }
            }
            eVar.c(i3);
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f143960h = fVar;
        fVar.a(new k.a(-9223372036854775807L));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        int size = this.f143954b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((com.tencent.luggage.wxa.n0.s) this.f143954b.get(i3)).d();
        }
        this.f143955c.y();
        this.f143956d.clear();
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
    
        if (r0 != ((r7 + 1) & 15)) goto L49;
     */
    @Override // com.tencent.luggage.wxa.q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        v vVar;
        com.tencent.luggage.wxa.n0.l lVar = this.f143955c;
        byte[] bArr = lVar.f135088a;
        if (9400 - lVar.c() < 188) {
            int a16 = this.f143955c.a();
            if (a16 > 0) {
                System.arraycopy(bArr, this.f143955c.c(), bArr, 0, a16);
            }
            this.f143955c.a(bArr, a16);
        }
        while (this.f143955c.a() < 188) {
            int d16 = this.f143955c.d();
            int read = eVar.read(bArr, d16, 9400 - d16);
            if (read == -1) {
                return -1;
            }
            this.f143955c.d(d16 + read);
        }
        int d17 = this.f143955c.d();
        int c16 = this.f143955c.c();
        while (c16 < d17 && bArr[c16] != 71) {
            c16++;
        }
        this.f143955c.e(c16);
        int i3 = c16 + 188;
        if (i3 > d17) {
            return 0;
        }
        int f16 = this.f143955c.f();
        if ((8388608 & f16) != 0) {
            this.f143955c.e(i3);
            return 0;
        }
        boolean z16 = true;
        boolean z17 = (4194304 & f16) != 0;
        int i16 = (2096896 & f16) >> 8;
        boolean z18 = (f16 & 32) != 0;
        boolean z19 = (f16 & 16) != 0;
        if (this.f143953a != 2) {
            int i17 = f16 & 15;
            int i18 = this.f143956d.get(i16, i17 - 1);
            this.f143956d.put(i16, i17);
            if (i18 == i17) {
                if (z19) {
                    this.f143955c.e(i3);
                    return 0;
                }
            }
        }
        z16 = false;
        if (z18) {
            this.f143955c.f(this.f143955c.q());
        }
        if (z19 && (vVar = (v) this.f143958f.get(i16)) != null) {
            if (z16) {
                vVar.a();
            }
            this.f143955c.d(i3);
            vVar.a(this.f143955c, z17);
            this.f143955c.d(d17);
        }
        this.f143955c.e(i3);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }
}
