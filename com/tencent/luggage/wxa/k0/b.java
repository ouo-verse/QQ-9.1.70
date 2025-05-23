package com.tencent.luggage.wxa.k0;

import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.d0.o;
import com.tencent.luggage.wxa.k0.f;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.m.s;
import com.tencent.luggage.wxa.n0.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends e {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f131375h = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public final f.a f131376f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f131377g = new AtomicReference(new C6352b());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f131378a;

        /* renamed from: b, reason: collision with root package name */
        public final int f131379b;

        /* renamed from: c, reason: collision with root package name */
        public final String f131380c;

        public a(int i3, int i16, String str) {
            this.f131378a = i3;
            this.f131379b = i16;
            this.f131380c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f131378a == aVar.f131378a && this.f131379b == aVar.f131379b && TextUtils.equals(this.f131380c, aVar.f131380c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16 = ((this.f131378a * 31) + this.f131379b) * 31;
            String str = this.f131380c;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k0.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6352b {

        /* renamed from: a, reason: collision with root package name */
        public final String f131381a;

        /* renamed from: b, reason: collision with root package name */
        public final String f131382b;

        /* renamed from: c, reason: collision with root package name */
        public final int f131383c;

        /* renamed from: d, reason: collision with root package name */
        public final int f131384d;

        /* renamed from: e, reason: collision with root package name */
        public final int f131385e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f131386f;

        /* renamed from: g, reason: collision with root package name */
        public final int f131387g;

        /* renamed from: h, reason: collision with root package name */
        public final int f131388h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f131389i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f131390j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f131391k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f131392l;

        public C6352b() {
            this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C6352b.class != obj.getClass()) {
                return false;
            }
            C6352b c6352b = (C6352b) obj;
            if (this.f131390j == c6352b.f131390j && this.f131391k == c6352b.f131391k && this.f131383c == c6352b.f131383c && this.f131384d == c6352b.f131384d && this.f131386f == c6352b.f131386f && this.f131392l == c6352b.f131392l && this.f131389i == c6352b.f131389i && this.f131387g == c6352b.f131387g && this.f131388h == c6352b.f131388h && this.f131385e == c6352b.f131385e && TextUtils.equals(this.f131381a, c6352b.f131381a) && TextUtils.equals(this.f131382b, c6352b.f131382b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((this.f131381a.hashCode() * 31) + this.f131382b.hashCode()) * 31) + (this.f131390j ? 1 : 0)) * 31) + (this.f131391k ? 1 : 0)) * 31) + this.f131383c) * 31) + this.f131384d) * 31) + this.f131385e) * 31) + (this.f131386f ? 1 : 0)) * 31) + (this.f131392l ? 1 : 0)) * 31) + (this.f131389i ? 1 : 0)) * 31) + this.f131387g) * 31) + this.f131388h;
        }

        public C6352b(String str, String str2, boolean z16, boolean z17, int i3, int i16, int i17, boolean z18, boolean z19, int i18, int i19, boolean z26) {
            this.f131381a = str;
            this.f131382b = str2;
            this.f131390j = z16;
            this.f131391k = z17;
            this.f131383c = i3;
            this.f131384d = i16;
            this.f131385e = i17;
            this.f131386f = z18;
            this.f131392l = z19;
            this.f131387g = i18;
            this.f131388h = i19;
            this.f131389i = z26;
        }
    }

    public b(f.a aVar) {
        this.f131376f = aVar;
    }

    public static int a(int i3, int i16) {
        if (i3 == -1) {
            return i16 == -1 ? 0 : -1;
        }
        if (i16 == -1) {
            return 1;
        }
        return i3 - i16;
    }

    public f b(s sVar, o oVar, int[][] iArr, C6352b c6352b, f.a aVar) {
        f a16 = aVar != null ? a(sVar, oVar, iArr, c6352b, aVar) : null;
        return a16 == null ? a(oVar, iArr, c6352b) : a16;
    }

    public static boolean a(int i3, boolean z16) {
        int i16 = i3 & 7;
        return i16 == 4 || (z16 && i16 == 3);
    }

    public static int b(n nVar, int[] iArr, int i3, String str, int i16, int i17, int i18, List list) {
        int i19 = 0;
        for (int i26 = 0; i26 < list.size(); i26++) {
            int intValue = ((Integer) list.get(i26)).intValue();
            if (a(nVar.a(intValue), str, iArr[intValue], i3, i16, i17, i18)) {
                i19++;
            }
        }
        return i19;
    }

    @Override // com.tencent.luggage.wxa.k0.e
    public f[] a(s[] sVarArr, o[] oVarArr, int[][][] iArr) {
        int length = sVarArr.length;
        f[] fVarArr = new f[length];
        C6352b c6352b = (C6352b) this.f131377g.get();
        boolean z16 = false;
        int i3 = 0;
        boolean z17 = false;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (2 == sVarArr[i3].a()) {
                if (!z16) {
                    f b16 = b(sVarArr[i3], oVarArr[i3], iArr[i3], c6352b, this.f131376f);
                    fVarArr[i3] = b16;
                    z16 = b16 != null;
                }
                z17 |= oVarArr[i3].f124052a > 0;
            }
            i3++;
        }
        boolean z18 = false;
        boolean z19 = false;
        for (int i16 = 0; i16 < length; i16++) {
            int a16 = sVarArr[i16].a();
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3) {
                        fVarArr[i16] = a(sVarArr[i16].a(), oVarArr[i16], iArr[i16], c6352b);
                    } else if (!z19) {
                        f b17 = b(oVarArr[i16], iArr[i16], c6352b);
                        fVarArr[i16] = b17;
                        z19 = b17 != null;
                    }
                }
            } else if (!z18) {
                f a17 = a(oVarArr[i16], iArr[i16], c6352b, z17 ? null : this.f131376f);
                fVarArr[i16] = a17;
                z18 = a17 != null;
            }
        }
        return fVarArr;
    }

    public f b(o oVar, int[][] iArr, C6352b c6352b) {
        n nVar = null;
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < oVar.f124052a; i17++) {
            n a16 = oVar.a(i17);
            int[] iArr2 = iArr[i17];
            for (int i18 = 0; i18 < a16.f124048a; i18++) {
                if (a(iArr2[i18], c6352b.f131392l)) {
                    j a17 = a16.a(i18);
                    int i19 = a17.M;
                    int i26 = 1;
                    boolean z16 = (i19 & 1) != 0;
                    boolean z17 = (i19 & 2) != 0;
                    if (a(a17, c6352b.f131382b)) {
                        i26 = z16 ? 6 : !z17 ? 5 : 4;
                    } else if (z16) {
                        i26 = 3;
                    } else if (z17) {
                        if (a(a17, c6352b.f131381a)) {
                            i26 = 2;
                        }
                    }
                    if (a(iArr2[i18], false)) {
                        i26 += 1000;
                    }
                    if (i26 > i16) {
                        nVar = a16;
                        i3 = i18;
                        i16 = i26;
                    }
                }
            }
        }
        if (nVar == null) {
            return null;
        }
        return new c(nVar, i3);
    }

    public static f a(s sVar, o oVar, int[][] iArr, C6352b c6352b, f.a aVar) {
        int i3 = c6352b.f131391k ? 24 : 16;
        boolean z16 = c6352b.f131390j && (sVar.k() & i3) != 0;
        for (int i16 = 0; i16 < oVar.f124052a; i16++) {
            n a16 = oVar.a(i16);
            int[] a17 = a(a16, iArr[i16], z16, i3, c6352b.f131383c, c6352b.f131384d, c6352b.f131385e, c6352b.f131387g, c6352b.f131388h, c6352b.f131389i);
            if (a17.length > 0) {
                return aVar.a(a16, a17);
            }
        }
        return null;
    }

    public static int[] a(n nVar, int[] iArr, boolean z16, int i3, int i16, int i17, int i18, int i19, int i26, boolean z17) {
        String str;
        int b16;
        if (nVar.f124048a < 2) {
            return f131375h;
        }
        List a16 = a(nVar, i19, i26, z17);
        if (a16.size() < 2) {
            return f131375h;
        }
        if (z16) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i27 = 0;
            for (int i28 = 0; i28 < a16.size(); i28++) {
                String str3 = nVar.a(((Integer) a16.get(i28)).intValue()).f133896f;
                if (hashSet.add(str3) && (b16 = b(nVar, iArr, i3, str3, i16, i17, i18, a16)) > i27) {
                    i27 = b16;
                    str2 = str3;
                }
            }
            str = str2;
        }
        a(nVar, iArr, i3, str, i16, i17, i18, a16);
        return a16.size() < 2 ? f131375h : v.a(a16);
    }

    public static void a(n nVar, int[] iArr, int i3, String str, int i16, int i17, int i18, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!a(nVar.a(intValue), str, iArr[intValue], i3, i16, i17, i18)) {
                list.remove(size);
            }
        }
    }

    public static boolean a(j jVar, String str, int i3, int i16, int i17, int i18, int i19) {
        if (!a(i3, false) || (i3 & i16) == 0) {
            return false;
        }
        if (str != null && !v.a(jVar.f133896f, str)) {
            return false;
        }
        int i26 = jVar.f133900j;
        if (i26 != -1 && i26 > i17) {
            return false;
        }
        int i27 = jVar.f133901k;
        if (i27 != -1 && i27 > i18) {
            return false;
        }
        int i28 = jVar.f133892b;
        return i28 == -1 || i28 <= i19;
    }

    public static f a(o oVar, int[][] iArr, C6352b c6352b) {
        int a16;
        int i3;
        int i16;
        int i17;
        o oVar2 = oVar;
        int i18 = -1;
        int i19 = -1;
        int i26 = -1;
        int i27 = 0;
        n nVar = null;
        int i28 = 0;
        int i29 = 0;
        while (i27 < oVar2.f124052a) {
            n a17 = oVar2.a(i27);
            List a18 = a(a17, c6352b.f131387g, c6352b.f131388h, c6352b.f131389i);
            int[] iArr2 = iArr[i27];
            int i36 = 0;
            while (i36 < a17.f124048a) {
                if (a(iArr2[i36], c6352b.f131392l)) {
                    j a19 = a17.a(i36);
                    boolean z16 = true;
                    boolean z17 = a18.contains(Integer.valueOf(i36)) && ((i3 = a19.f133900j) == i18 || i3 <= c6352b.f131383c) && (((i16 = a19.f133901k) == i18 || i16 <= c6352b.f131384d) && ((i17 = a19.f133892b) == i18 || i17 <= c6352b.f131385e));
                    if (z17 || c6352b.f131386f) {
                        int i37 = z17 ? 2 : 1;
                        boolean a26 = a(iArr2[i36], false);
                        if (a26) {
                            i37 += 1000;
                        }
                        boolean z18 = i37 > i29;
                        if (i37 == i29) {
                            if (a19.b() != i19) {
                                a16 = a(a19.b(), i19);
                            } else {
                                a16 = a(a19.f133892b, i26);
                            }
                            if (!a26 || !z17 ? a16 >= 0 : a16 <= 0) {
                                z16 = false;
                            }
                        } else {
                            z16 = z18;
                        }
                        if (z16) {
                            i26 = a19.f133892b;
                            i19 = a19.b();
                            nVar = a17;
                            i28 = i36;
                            i29 = i37;
                        }
                    }
                }
                i36++;
                i18 = -1;
            }
            i27++;
            oVar2 = oVar;
            i18 = -1;
        }
        if (nVar == null) {
            return null;
        }
        return new c(nVar, i28);
    }

    public f a(o oVar, int[][] iArr, C6352b c6352b, f.a aVar) {
        int i3 = -1;
        int i16 = -1;
        int i17 = 0;
        for (int i18 = 0; i18 < oVar.f124052a; i18++) {
            n a16 = oVar.a(i18);
            int[] iArr2 = iArr[i18];
            for (int i19 = 0; i19 < a16.f124048a; i19++) {
                if (a(iArr2[i19], c6352b.f131392l)) {
                    int a17 = a(iArr2[i19], c6352b.f131381a, a16.a(i19));
                    if (a17 > i17) {
                        i3 = i18;
                        i16 = i19;
                        i17 = a17;
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        n a18 = oVar.a(i3);
        if (aVar != null) {
            int[] a19 = a(a18, iArr[i3], c6352b.f131390j);
            if (a19.length > 0) {
                return aVar.a(a18, a19);
            }
        }
        return new c(a18, i16);
    }

    public static int a(int i3, String str, j jVar) {
        int i16 = 1;
        boolean z16 = (jVar.M & 1) != 0;
        if (a(jVar, str)) {
            i16 = z16 ? 4 : 3;
        } else if (z16) {
            i16 = 2;
        }
        return a(i3, false) ? i16 + 1000 : i16;
    }

    public static int[] a(n nVar, int[] iArr, boolean z16) {
        int a16;
        HashSet hashSet = new HashSet();
        int i3 = 0;
        a aVar = null;
        for (int i16 = 0; i16 < nVar.f124048a; i16++) {
            j a17 = nVar.a(i16);
            a aVar2 = new a(a17.G, a17.H, z16 ? null : a17.f133896f);
            if (hashSet.add(aVar2) && (a16 = a(nVar, iArr, aVar2)) > i3) {
                i3 = a16;
                aVar = aVar2;
            }
        }
        if (i3 > 1) {
            int[] iArr2 = new int[i3];
            int i17 = 0;
            for (int i18 = 0; i18 < nVar.f124048a; i18++) {
                if (a(nVar.a(i18), iArr[i18], aVar)) {
                    iArr2[i17] = i18;
                    i17++;
                }
            }
            return iArr2;
        }
        return f131375h;
    }

    public static int a(n nVar, int[] iArr, a aVar) {
        int i3 = 0;
        for (int i16 = 0; i16 < nVar.f124048a; i16++) {
            if (a(nVar.a(i16), iArr[i16], aVar)) {
                i3++;
            }
        }
        return i3;
    }

    public static boolean a(j jVar, int i3, a aVar) {
        if (!a(i3, false) || jVar.G != aVar.f131378a || jVar.H != aVar.f131379b) {
            return false;
        }
        String str = aVar.f131380c;
        return str == null || TextUtils.equals(str, jVar.f133896f);
    }

    public f a(int i3, o oVar, int[][] iArr, C6352b c6352b) {
        n nVar = null;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < oVar.f124052a; i18++) {
            n a16 = oVar.a(i18);
            int[] iArr2 = iArr[i18];
            for (int i19 = 0; i19 < a16.f124048a; i19++) {
                if (a(iArr2[i19], c6352b.f131392l)) {
                    int i26 = (a16.a(i19).M & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i19], false)) {
                        i26 += 1000;
                    }
                    if (i26 > i17) {
                        nVar = a16;
                        i16 = i19;
                        i17 = i26;
                    }
                }
            }
        }
        if (nVar == null) {
            return null;
        }
        return new c(nVar, i16);
    }

    public static boolean a(j jVar, String str) {
        return str != null && TextUtils.equals(str, v.e(jVar.N));
    }

    public static List a(n nVar, int i3, int i16, boolean z16) {
        int i17;
        ArrayList arrayList = new ArrayList(nVar.f124048a);
        for (int i18 = 0; i18 < nVar.f124048a; i18++) {
            arrayList.add(Integer.valueOf(i18));
        }
        if (i3 != Integer.MAX_VALUE && i16 != Integer.MAX_VALUE) {
            int i19 = Integer.MAX_VALUE;
            for (int i26 = 0; i26 < nVar.f124048a; i26++) {
                j a16 = nVar.a(i26);
                int i27 = a16.f133900j;
                if (i27 > 0 && (i17 = a16.f133901k) > 0) {
                    Point a17 = a(z16, i3, i16, i27, i17);
                    int i28 = a16.f133900j;
                    int i29 = a16.f133901k;
                    int i36 = i28 * i29;
                    if (i28 >= ((int) (a17.x * 0.98f)) && i29 >= ((int) (a17.y * 0.98f)) && i36 < i19) {
                        i19 = i36;
                    }
                }
            }
            if (i19 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int b16 = nVar.a(((Integer) arrayList.get(size)).intValue()).b();
                    if (b16 == -1 || b16 > i19) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point a(boolean z16, int i3, int i16, int i17, int i18) {
        if (z16) {
        }
        i16 = i3;
        i3 = i16;
        int i19 = i17 * i3;
        int i26 = i18 * i16;
        if (i19 >= i26) {
            return new Point(i16, v.a(i26, i17));
        }
        return new Point(v.a(i19, i18), i3);
    }
}
