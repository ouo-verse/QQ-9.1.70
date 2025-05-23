package com.tencent.luggage.wxa.k0;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.d0.o;
import com.tencent.luggage.wxa.m.s;
import com.tencent.luggage.wxa.m.t;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e extends h {

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f131395b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f131396c = new SparseBooleanArray();

    /* renamed from: d, reason: collision with root package name */
    public int f131397d = 0;

    /* renamed from: e, reason: collision with root package name */
    public a f131398e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f131399a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f131400b;

        /* renamed from: c, reason: collision with root package name */
        public final o[] f131401c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f131402d;

        /* renamed from: e, reason: collision with root package name */
        public final int[][][] f131403e;

        /* renamed from: f, reason: collision with root package name */
        public final o f131404f;

        public a(int[] iArr, o[] oVarArr, int[] iArr2, int[][][] iArr3, o oVar) {
            this.f131400b = iArr;
            this.f131401c = oVarArr;
            this.f131403e = iArr3;
            this.f131402d = iArr2;
            this.f131404f = oVar;
            this.f131399a = oVarArr.length;
        }

        public o a(int i3) {
            return this.f131401c[i3];
        }

        public int a(int i3, int i16, int i17) {
            return this.f131403e[i3][i16][i17] & 7;
        }

        public int a(int i3, int i16, boolean z16) {
            int i17 = this.f131401c[i3].a(i16).f124048a;
            int[] iArr = new int[i17];
            int i18 = 0;
            for (int i19 = 0; i19 < i17; i19++) {
                int a16 = a(i3, i16, i19);
                if (a16 == 4 || (z16 && a16 == 3)) {
                    iArr[i18] = i19;
                    i18++;
                }
            }
            return a(i3, i16, Arrays.copyOf(iArr, i18));
        }

        public int a(int i3, int i16, int[] iArr) {
            int i17 = 0;
            int i18 = 16;
            String str = null;
            boolean z16 = false;
            int i19 = 0;
            while (i17 < iArr.length) {
                String str2 = this.f131401c[i3].a(i16).a(iArr[i17]).f133896f;
                int i26 = i19 + 1;
                if (i19 == 0) {
                    str = str2;
                } else {
                    z16 |= !v.a(str, str2);
                }
                i18 = Math.min(i18, this.f131403e[i3][i16][i17] & 24);
                i17++;
                i19 = i26;
            }
            return z16 ? Math.min(i18, this.f131402d[i3]) : i18;
        }

        public o a() {
            return this.f131404f;
        }
    }

    public final a a() {
        return this.f131398e;
    }

    public abstract f[] a(s[] sVarArr, o[] oVarArr, int[][][] iArr);

    public final boolean a(int i3, o oVar) {
        Map map = (Map) this.f131395b.get(i3);
        return map != null && map.containsKey(oVar);
    }

    @Override // com.tencent.luggage.wxa.k0.h
    public final i a(s[] sVarArr, o oVar) {
        int[] iArr = new int[sVarArr.length + 1];
        int length = sVarArr.length + 1;
        n[][] nVarArr = new n[length];
        int[][][] iArr2 = new int[sVarArr.length + 1][];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = oVar.f124052a;
            nVarArr[i3] = new n[i16];
            iArr2[i3] = new int[i16];
        }
        int[] a16 = a(sVarArr);
        for (int i17 = 0; i17 < oVar.f124052a; i17++) {
            n a17 = oVar.a(i17);
            int a18 = a(sVarArr, a17);
            int[] a19 = a18 == sVarArr.length ? new int[a17.f124048a] : a(sVarArr[a18], a17);
            int i18 = iArr[a18];
            nVarArr[a18][i18] = a17;
            iArr2[a18][i18] = a19;
            iArr[a18] = i18 + 1;
        }
        o[] oVarArr = new o[sVarArr.length];
        int[] iArr3 = new int[sVarArr.length];
        for (int i19 = 0; i19 < sVarArr.length; i19++) {
            int i26 = iArr[i19];
            oVarArr[i19] = new o((n[]) Arrays.copyOf(nVarArr[i19], i26));
            iArr2[i19] = (int[][]) Arrays.copyOf(iArr2[i19], i26);
            iArr3[i19] = sVarArr[i19].a();
        }
        o oVar2 = new o((n[]) Arrays.copyOf(nVarArr[sVarArr.length], iArr[sVarArr.length]));
        f[] a26 = a(sVarArr, oVarArr, iArr2);
        for (int i27 = 0; i27 < sVarArr.length; i27++) {
            if (this.f131396c.get(i27)) {
                a26[i27] = null;
            } else {
                o oVar3 = oVarArr[i27];
                if (a(i27, oVar3)) {
                    d.a(((Map) this.f131395b.get(i27)).get(oVar3));
                    a26[i27] = null;
                }
            }
        }
        a aVar = new a(iArr3, oVarArr, a16, iArr2, oVar2);
        t[] tVarArr = new t[sVarArr.length];
        for (int i28 = 0; i28 < sVarArr.length; i28++) {
            tVarArr[i28] = a26[i28] != null ? t.f133923b : null;
        }
        a(sVarArr, oVarArr, iArr2, tVarArr, a26, this.f131397d);
        return new i(oVar, new g(a26), aVar, tVarArr);
    }

    @Override // com.tencent.luggage.wxa.k0.h
    public final void a(Object obj) {
        this.f131398e = (a) obj;
    }

    public static int a(s[] sVarArr, n nVar) {
        int length = sVarArr.length;
        int i3 = 0;
        for (int i16 = 0; i16 < sVarArr.length; i16++) {
            s sVar = sVarArr[i16];
            for (int i17 = 0; i17 < nVar.f124048a; i17++) {
                int a16 = sVar.a(nVar.a(i17)) & 7;
                if (a16 > i3) {
                    if (a16 == 4) {
                        return i16;
                    }
                    length = i16;
                    i3 = a16;
                }
            }
        }
        return length;
    }

    public static int[] a(s sVar, n nVar) {
        int[] iArr = new int[nVar.f124048a];
        for (int i3 = 0; i3 < nVar.f124048a; i3++) {
            iArr[i3] = sVar.a(nVar.a(i3));
        }
        return iArr;
    }

    public static int[] a(s[] sVarArr) {
        int length = sVarArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = sVarArr[i3].k();
        }
        return iArr;
    }

    public static void a(s[] sVarArr, o[] oVarArr, int[][][] iArr, t[] tVarArr, f[] fVarArr, int i3) {
        boolean z16;
        if (i3 == 0) {
            return;
        }
        boolean z17 = false;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < sVarArr.length; i18++) {
            int a16 = sVarArr[i18].a();
            f fVar = fVarArr[i18];
            if ((a16 == 1 || a16 == 2) && fVar != null && a(iArr[i18], oVarArr[i18], fVar)) {
                if (a16 == 1) {
                    if (i17 != -1) {
                        z16 = false;
                        break;
                    }
                    i17 = i18;
                } else {
                    if (i16 != -1) {
                        z16 = false;
                        break;
                    }
                    i16 = i18;
                }
            }
        }
        z16 = true;
        if (i17 != -1 && i16 != -1) {
            z17 = true;
        }
        if (z16 && z17) {
            t tVar = new t(i3);
            tVarArr[i17] = tVar;
            tVarArr[i16] = tVar;
        }
    }

    public static boolean a(int[][] iArr, o oVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int a16 = oVar.a(fVar.c());
        for (int i3 = 0; i3 < fVar.length(); i3++) {
            if ((iArr[a16][fVar.b(i3)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }
}
