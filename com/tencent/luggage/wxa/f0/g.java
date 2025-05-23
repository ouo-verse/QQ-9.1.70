package com.tencent.luggage.wxa.f0;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.d0.a;
import com.tencent.luggage.wxa.d0.g;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.d0.o;
import com.tencent.luggage.wxa.f0.j;
import com.tencent.luggage.wxa.g0.a;
import com.tencent.luggage.wxa.g0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements com.tencent.luggage.wxa.d0.g, j.b, e.c {
    public com.tencent.luggage.wxa.d0.d C;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.g0.e f125144a;

    /* renamed from: b, reason: collision with root package name */
    public final d f125145b;

    /* renamed from: c, reason: collision with root package name */
    public final int f125146c;

    /* renamed from: d, reason: collision with root package name */
    public final a.C6124a f125147d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.b f125148e;

    /* renamed from: i, reason: collision with root package name */
    public g.a f125152i;

    /* renamed from: j, reason: collision with root package name */
    public int f125153j;

    /* renamed from: k, reason: collision with root package name */
    public o f125154k;

    /* renamed from: f, reason: collision with root package name */
    public final IdentityHashMap f125149f = new IdentityHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final k f125150g = new k();

    /* renamed from: h, reason: collision with root package name */
    public final Handler f125151h = new Handler();

    /* renamed from: l, reason: collision with root package name */
    public j[] f125155l = new j[0];

    /* renamed from: m, reason: collision with root package name */
    public j[] f125156m = new j[0];

    public g(com.tencent.luggage.wxa.g0.e eVar, d dVar, int i3, a.C6124a c6124a, com.tencent.luggage.wxa.l0.b bVar) {
        this.f125144a = eVar;
        this.f125145b = dVar;
        this.f125146c = i3;
        this.f125147d = c6124a;
        this.f125148e = bVar;
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public long b() {
        return this.C.b();
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void c(long j3) {
        for (j jVar : this.f125156m) {
            jVar.c(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long d() {
        return -9223372036854775807L;
    }

    @Override // com.tencent.luggage.wxa.g0.e.c
    public void e() {
        h();
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void f() {
        for (j jVar : this.f125155l) {
            jVar.f();
        }
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public o g() {
        return this.f125154k;
    }

    public final void h() {
        if (this.f125154k != null) {
            this.f125152i.a((com.tencent.luggage.wxa.d0.l) this);
            return;
        }
        for (j jVar : this.f125155l) {
            jVar.i();
        }
    }

    public void i() {
        this.f125144a.b(this);
        this.f125151h.removeCallbacksAndMessages(null);
        for (j jVar : this.f125155l) {
            jVar.m();
        }
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void a(g.a aVar, long j3) {
        this.f125152i = aVar;
        this.f125144a.a(this);
        d(j3);
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long b(long j3) {
        j[] jVarArr = this.f125156m;
        if (jVarArr.length > 0) {
            boolean a16 = jVarArr[0].a(j3, false);
            int i3 = 1;
            while (true) {
                j[] jVarArr2 = this.f125156m;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                jVarArr2[i3].a(j3, a16);
                i3++;
            }
            if (a16) {
                this.f125150g.a();
            }
        }
        return j3;
    }

    public final void d(long j3) {
        com.tencent.luggage.wxa.g0.a a16 = this.f125144a.a();
        ArrayList arrayList = new ArrayList(a16.f126311c);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            a.C6226a c6226a = (a.C6226a) arrayList.get(i3);
            if (c6226a.f126317b.f133901k <= 0 && !a(c6226a, "avc")) {
                if (a(c6226a, "mp4a")) {
                    arrayList3.add(c6226a);
                }
            } else {
                arrayList2.add(c6226a);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List list = a16.f126312d;
        List list2 = a16.f126313e;
        int size = list.size() + 1 + list2.size();
        this.f125155l = new j[size];
        this.f125153j = size;
        com.tencent.luggage.wxa.n0.a.a(!arrayList.isEmpty());
        a.C6226a[] c6226aArr = new a.C6226a[arrayList.size()];
        arrayList.toArray(c6226aArr);
        j a17 = a(0, c6226aArr, a16.f126314f, a16.f126315g, j3);
        this.f125155l[0] = a17;
        a17.a(true);
        a17.i();
        int i16 = 0;
        int i17 = 1;
        while (i16 < list.size()) {
            j a18 = a(1, new a.C6226a[]{(a.C6226a) list.get(i16)}, (com.tencent.luggage.wxa.m.j) null, Collections.emptyList(), j3);
            this.f125155l[i17] = a18;
            a18.i();
            i16++;
            i17++;
        }
        int i18 = 0;
        while (i18 < list2.size()) {
            a.C6226a c6226a2 = (a.C6226a) list2.get(i18);
            j a19 = a(3, new a.C6226a[]{c6226a2}, (com.tencent.luggage.wxa.m.j) null, Collections.emptyList(), j3);
            a19.b(c6226a2.f126317b);
            this.f125155l[i17] = a19;
            i18++;
            i17++;
        }
        this.f125156m = this.f125155l;
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public long c() {
        return this.C.c();
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long a(com.tencent.luggage.wxa.k0.f[] fVarArr, boolean[] zArr, com.tencent.luggage.wxa.d0.k[] kVarArr, boolean[] zArr2, long j3) {
        com.tencent.luggage.wxa.d0.k[] kVarArr2 = kVarArr;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            com.tencent.luggage.wxa.d0.k kVar = kVarArr2[i3];
            iArr[i3] = kVar == null ? -1 : ((Integer) this.f125149f.get(kVar)).intValue();
            iArr2[i3] = -1;
            com.tencent.luggage.wxa.k0.f fVar = fVarArr[i3];
            if (fVar != null) {
                n c16 = fVar.c();
                int i16 = 0;
                while (true) {
                    j[] jVarArr = this.f125155l;
                    if (i16 >= jVarArr.length) {
                        break;
                    }
                    if (jVarArr[i16].g().a(c16) != -1) {
                        iArr2[i3] = i16;
                        break;
                    }
                    i16++;
                }
            }
        }
        this.f125149f.clear();
        int length = fVarArr.length;
        com.tencent.luggage.wxa.d0.k[] kVarArr3 = new com.tencent.luggage.wxa.d0.k[length];
        com.tencent.luggage.wxa.d0.k[] kVarArr4 = new com.tencent.luggage.wxa.d0.k[fVarArr.length];
        com.tencent.luggage.wxa.k0.f[] fVarArr2 = new com.tencent.luggage.wxa.k0.f[fVarArr.length];
        j[] jVarArr2 = new j[this.f125155l.length];
        int i17 = 0;
        int i18 = 0;
        boolean z16 = false;
        while (i18 < this.f125155l.length) {
            for (int i19 = 0; i19 < fVarArr.length; i19++) {
                com.tencent.luggage.wxa.k0.f fVar2 = null;
                kVarArr4[i19] = iArr[i19] == i18 ? kVarArr2[i19] : null;
                if (iArr2[i19] == i18) {
                    fVar2 = fVarArr[i19];
                }
                fVarArr2[i19] = fVar2;
            }
            j jVar = this.f125155l[i18];
            int i26 = i17;
            int i27 = length;
            int i28 = i18;
            com.tencent.luggage.wxa.k0.f[] fVarArr3 = fVarArr2;
            j[] jVarArr3 = jVarArr2;
            boolean a16 = jVar.a(fVarArr2, zArr, kVarArr4, zArr2, j3, z16);
            int i29 = 0;
            boolean z17 = false;
            while (true) {
                if (i29 >= fVarArr.length) {
                    break;
                }
                if (iArr2[i29] == i28) {
                    com.tencent.luggage.wxa.n0.a.b(kVarArr4[i29] != null);
                    kVarArr3[i29] = kVarArr4[i29];
                    this.f125149f.put(kVarArr4[i29], Integer.valueOf(i28));
                    z17 = true;
                } else if (iArr[i29] == i28) {
                    com.tencent.luggage.wxa.n0.a.b(kVarArr4[i29] == null);
                }
                i29++;
            }
            if (z17) {
                jVarArr3[i26] = jVar;
                i17 = i26 + 1;
                if (i26 == 0) {
                    jVar.a(true);
                    if (!a16) {
                        j[] jVarArr4 = this.f125156m;
                        if (jVarArr4.length != 0) {
                            if (jVar == jVarArr4[0]) {
                            }
                            this.f125150g.a();
                            z16 = true;
                        }
                    }
                    this.f125150g.a();
                    z16 = true;
                } else {
                    jVar.a(false);
                }
            } else {
                i17 = i26;
            }
            i18 = i28 + 1;
            kVarArr2 = kVarArr;
            jVarArr2 = jVarArr3;
            length = i27;
            fVarArr2 = fVarArr3;
        }
        System.arraycopy(kVarArr3, 0, kVarArr2, 0, length);
        j[] jVarArr5 = (j[]) Arrays.copyOf(jVarArr2, i17);
        this.f125156m = jVarArr5;
        this.C = new com.tencent.luggage.wxa.d0.d(jVarArr5);
        return j3;
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public boolean a(long j3) {
        return this.C.a(j3);
    }

    @Override // com.tencent.luggage.wxa.f0.j.b
    public void a() {
        int i3 = this.f125153j - 1;
        this.f125153j = i3;
        if (i3 > 0) {
            return;
        }
        int i16 = 0;
        for (j jVar : this.f125155l) {
            i16 += jVar.g().f124052a;
        }
        n[] nVarArr = new n[i16];
        int i17 = 0;
        for (j jVar2 : this.f125155l) {
            int i18 = jVar2.g().f124052a;
            int i19 = 0;
            while (i19 < i18) {
                nVarArr[i17] = jVar2.g().a(i19);
                i19++;
                i17++;
            }
        }
        this.f125154k = new o(nVarArr);
        this.f125152i.a((com.tencent.luggage.wxa.d0.g) this);
    }

    @Override // com.tencent.luggage.wxa.f0.j.b
    public void a(a.C6226a c6226a) {
        this.f125144a.e(c6226a);
    }

    @Override // com.tencent.luggage.wxa.d0.l.a
    public void a(j jVar) {
        if (this.f125154k == null) {
            return;
        }
        this.f125152i.a((com.tencent.luggage.wxa.d0.l) this);
    }

    @Override // com.tencent.luggage.wxa.g0.e.c
    public void a(a.C6226a c6226a, long j3) {
        for (j jVar : this.f125155l) {
            jVar.a(c6226a, j3);
        }
        h();
    }

    public final j a(int i3, a.C6226a[] c6226aArr, com.tencent.luggage.wxa.m.j jVar, List list, long j3) {
        return new j(i3, this, new c(this.f125144a, c6226aArr, this.f125145b, this.f125150g, list), this.f125148e, j3, jVar, this.f125146c, this.f125147d);
    }

    public static boolean a(a.C6226a c6226a, String str) {
        String str2 = c6226a.f126317b.f133893c;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (str3.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
