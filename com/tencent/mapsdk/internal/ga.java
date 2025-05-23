package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ga {

    /* renamed from: a, reason: collision with root package name */
    public static final int f148419a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f148420b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f148421c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f148422d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f148423e = 9;

    /* renamed from: f, reason: collision with root package name */
    public static final int f148424f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static final float f148425g = 200.0f;

    /* renamed from: h, reason: collision with root package name */
    public static final float f148426h = 60.0f;

    /* renamed from: i, reason: collision with root package name */
    public static final String f148427i = "color_texture_flat_style.png";

    /* renamed from: j, reason: collision with root package name */
    public static final String f148428j = "color_point_texture.png";

    /* renamed from: k, reason: collision with root package name */
    public static final String f148429k = "color_texture_line_v2.png";
    public boolean O;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<GeoPoint> f148430l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<GeoPoint> f148431m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f148432n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f148433o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f148434p;

    /* renamed from: q, reason: collision with root package name */
    public int[] f148435q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f148436r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f148437s;

    /* renamed from: t, reason: collision with root package name */
    public int[] f148438t;

    /* renamed from: u, reason: collision with root package name */
    public float f148439u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f148440v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f148441w;

    /* renamed from: x, reason: collision with root package name */
    public float f148442x = 9.0f;

    /* renamed from: y, reason: collision with root package name */
    public String f148443y = "";

    /* renamed from: z, reason: collision with root package name */
    public boolean f148444z = true;
    public float A = 1.0f;
    public boolean B = true;
    public int C = 0;
    public boolean D = false;
    public boolean E = false;
    public Rect F = new Rect();
    public int G = 0;
    public String H = "";
    public float I = -1.0f;
    public int J = -1;
    public int K = -15248742;
    public List<Integer> L = null;
    public int M = 2;
    public int N = -7829368;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f148445a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final int f148446b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f148447c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final int f148448d = 3;

        /* renamed from: e, reason: collision with root package name */
        public static final int f148449e = 4;

        /* renamed from: f, reason: collision with root package name */
        public static final int f148450f = 5;

        /* renamed from: g, reason: collision with root package name */
        public static final int f148451g = 6;

        /* renamed from: h, reason: collision with root package name */
        public static final int f148452h = 7;

        /* renamed from: i, reason: collision with root package name */
        public static final int f148453i = 8;

        /* renamed from: j, reason: collision with root package name */
        public static final int f148454j = 9;

        /* renamed from: k, reason: collision with root package name */
        public static final int f148455k = 33;

        /* renamed from: l, reason: collision with root package name */
        public static final int f148456l = 19;

        /* renamed from: m, reason: collision with root package name */
        public static final int f148457m = 20;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b {

        /* renamed from: a, reason: collision with root package name */
        public int f148458a;

        /* renamed from: b, reason: collision with root package name */
        public int f148459b;

        public b(int i3, int i16) {
            this.f148459b = i3;
            this.f148458a = i16;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            if (bVar.f148458a != this.f148458a || bVar.f148459b != this.f148459b) {
                return false;
            }
            return true;
        }
    }

    private ga b(String str) {
        this.f148443y = str;
        return this;
    }

    private ga c(float f16) {
        this.f148442x = f16;
        return this;
    }

    private ga d(float f16) {
        this.f148439u = f16;
        return this;
    }

    private ga e(boolean z16) {
        this.E = z16;
        return this;
    }

    private int f() {
        return this.M;
    }

    public final ga a(List<GeoPoint> list) {
        if (list != null && list.size() >= 2) {
            ArrayList<GeoPoint> arrayList = new ArrayList<>(list.size());
            this.f148431m = arrayList;
            arrayList.addAll(list);
            if (this.f148431m.size() < 2) {
                LogUtil.c("\u53c2\u6570points\u5b58\u5728null\u503c");
                return this;
            }
            ArrayList<GeoPoint> arrayList2 = new ArrayList<>(list.size());
            this.f148430l = arrayList2;
            arrayList2.addAll(this.f148431m);
            return this;
        }
        LogUtil.c("\u53c2\u6570points\u4e0d\u80fd\u5c0f\u4e8e2!");
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ga.class == obj.getClass()) {
            ga gaVar = (ga) obj;
            if (Float.compare(gaVar.f148439u, this.f148439u) == 0 && this.f148440v == gaVar.f148440v && this.f148441w == gaVar.f148441w && Float.compare(gaVar.f148442x, this.f148442x) == 0 && this.f148444z == gaVar.f148444z && Float.compare(gaVar.A, this.A) == 0 && this.B == gaVar.B && this.C == gaVar.C && this.D == gaVar.D && this.E == gaVar.E && this.G == gaVar.G && Float.compare(gaVar.I, this.I) == 0 && this.J == gaVar.J && this.K == gaVar.K && this.M == gaVar.M && this.N == gaVar.N && this.O == gaVar.O && Util.equals(this.f148430l, gaVar.f148430l) && Util.equals(this.f148431m, gaVar.f148431m) && Arrays.equals(this.f148432n, gaVar.f148432n) && Arrays.equals(this.f148433o, gaVar.f148433o) && Arrays.equals(this.f148434p, gaVar.f148434p) && Arrays.equals(this.f148435q, gaVar.f148435q) && Arrays.equals(this.f148436r, gaVar.f148436r) && Arrays.equals(this.f148437s, gaVar.f148437s) && Arrays.equals(this.f148438t, gaVar.f148438t) && Util.equals(this.f148443y, gaVar.f148443y) && Util.equals(this.F, gaVar.F) && Util.equals(this.H, gaVar.H) && Util.equals(this.L, gaVar.L)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((Util.hash(this.f148430l, this.f148431m, Float.valueOf(this.f148439u), Boolean.valueOf(this.f148440v), Boolean.valueOf(this.f148441w), Float.valueOf(this.f148442x), this.f148443y, Boolean.valueOf(this.f148444z), Float.valueOf(this.A), Boolean.valueOf(this.B), Integer.valueOf(this.C), Boolean.valueOf(this.D), Boolean.valueOf(this.E), this.F, Integer.valueOf(this.G), this.H, Float.valueOf(this.I), Integer.valueOf(this.J), Integer.valueOf(this.K), this.L, Integer.valueOf(this.M), Integer.valueOf(this.N), Boolean.valueOf(this.O)) * 31) + Arrays.hashCode(this.f148432n)) * 31) + Arrays.hashCode(this.f148433o)) * 31) + Arrays.hashCode(this.f148434p)) * 31) + Arrays.hashCode(this.f148435q)) * 31) + Arrays.hashCode(this.f148436r)) * 31) + Arrays.hashCode(this.f148437s)) * 31) + Arrays.hashCode(this.f148438t);
    }

    @Deprecated
    private void b(float f16) {
        this.A = f16;
    }

    private ga c(boolean z16) {
        this.B = z16;
        return this;
    }

    private ga d(boolean z16) {
        this.D = z16;
        return this;
    }

    private ga e(float f16) {
        this.I = f16;
        return this;
    }

    private int c() {
        return this.C;
    }

    private ga d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.f148433o = iArr;
            return this;
        }
        LogUtil.c("\u53c2\u6570endNums\u4e0d\u80fd\u4e3a\u7a7a!");
        return this;
    }

    private float e() {
        return this.I;
    }

    public final ga b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            if (!this.f148440v) {
                this.f148436r = iArr;
                return this;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.N));
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (!arrayList.contains(Integer.valueOf(iArr[i3]))) {
                    arrayList.add(Integer.valueOf(iArr[i3]));
                }
                iArr[i3] = arrayList.indexOf(Integer.valueOf(iArr[i3]));
            }
            this.f148436r = iArr;
            int size = arrayList.size();
            this.f148437s = new int[size];
            for (int i16 = 0; i16 < size; i16++) {
                this.f148437s[i16] = ((Integer) arrayList.get(i16)).intValue();
            }
            return this;
        }
        LogUtil.c("\u53c2\u6570colors\u4e0d\u80fd\u4e3a\u7a7a!");
        return this;
    }

    private ga c(int i3) {
        this.G = i3;
        return this;
    }

    private ga c(String str) {
        this.H = str;
        return this;
    }

    private ga c(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.f148432n = iArr;
            return this;
        }
        LogUtil.c("\u53c2\u6570startNums\u4e0d\u80fd\u4e3a\u7a7a!");
        return this;
    }

    private int[] d() {
        return new int[]{this.J, this.K};
    }

    private void d(int i3) {
        this.M = i3;
    }

    public final ga a(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.f148435q = iArr;
            return this;
        }
        LogUtil.c("\u53c2\u6570startIndexes\u4e0d\u80fd\u4e3a\u7a7a!");
        return this;
    }

    private ga a(int i3) {
        this.N = i3;
        return this;
    }

    @Deprecated
    private void a(String str) {
        this.f148443y = str;
    }

    @Deprecated
    private void a(boolean z16) {
        this.f148444z = z16;
    }

    private ga a(float f16) {
        this.A = f16;
        return this;
    }

    public final ga a(int[] iArr, int[] iArr2) {
        if (iArr != null && iArr.length > 0 && iArr2 != null && iArr2.length > 0) {
            if (!this.f148440v) {
                this.f148436r = iArr;
                return this;
            }
            if (iArr2.length < iArr.length) {
                int[] iArr3 = new int[iArr.length];
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    if (i3 < iArr2.length) {
                        iArr3[i3] = iArr2[i3];
                    } else {
                        iArr3[i3] = iArr2[iArr2.length - 1];
                    }
                }
                iArr2 = iArr3;
            }
            ArrayList arrayList = new ArrayList();
            int i16 = this.N;
            arrayList.add(new b(i16, i16));
            this.f148436r = new int[iArr.length];
            for (int i17 = 0; i17 < iArr.length; i17++) {
                b bVar = new b(iArr[i17], iArr2[i17]);
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
                this.f148436r[i17] = arrayList.indexOf(bVar);
            }
            int size = arrayList.size();
            this.f148437s = new int[size];
            this.f148438t = new int[size];
            for (int i18 = 0; i18 < size; i18++) {
                this.f148437s[i18] = ((b) arrayList.get(i18)).f148459b;
                this.f148438t[i18] = ((b) arrayList.get(i18)).f148458a;
            }
            return this;
        }
        LogUtil.c("\u53c2\u6570colors \u3001borderColors\u4e3a\u7a7a\uff0c\u6216\u8005\u4e24\u8005\u957f\u5ea6\u4e0d\u540c");
        return this;
    }

    private ga b() {
        this.f148440v = true;
        return this;
    }

    private ga b(boolean z16) {
        this.f148441w = z16;
        return this;
    }

    private ga b(int i3) {
        this.C = i3;
        return this;
    }

    public final ga b(List<Integer> list) {
        if (list != null && list.size() % 2 != 0) {
            list.add(list.get(list.size() - 1));
        }
        this.L = list;
        return this;
    }

    private ga a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f148434p = strArr;
            return this;
        }
        LogUtil.c("\u53c2\u6570roadNames\u4e0d\u80fd\u4e3a\u7a7a!");
        return this;
    }

    private ga a(int i3, int i16) {
        this.J = i3;
        this.K = i16;
        return this;
    }

    public final boolean a() {
        ArrayList<GeoPoint> arrayList = this.f148431m;
        if (arrayList != null && arrayList.size() >= 2) {
            int[] iArr = this.f148435q;
            if (iArr != null && iArr.length > 0) {
                int[] iArr2 = this.f148436r;
                if (iArr2 != null && iArr2.length > 0) {
                    return true;
                }
                LogUtil.c("\u53c2\u6570colors\u4e0d\u80fd\u4e3a\u7a7a!");
                return false;
            }
            LogUtil.c("\u53c2\u6570startIndexes\u4e0d\u80fd\u4e3a\u7a7a!");
            return false;
        }
        LogUtil.c("LineOptions\u4e2d\u70b9\u7684\u4e2a\u6570\u4e0d\u80fd\u5c0f\u4e8e2");
        return false;
    }
}
