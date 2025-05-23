package com.qqnt.widget.smartrefreshlayout.layout.constant;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f41236c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f41237d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f41238e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f41239f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f41240g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f41241h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f41242i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f41243j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f41244k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f41245l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f41246m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f41247n;

    /* renamed from: o, reason: collision with root package name */
    public static final a[] f41248o;

    /* renamed from: a, reason: collision with root package name */
    public final int f41249a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f41250b;

    static {
        a aVar = new a(0, false);
        f41236c = aVar;
        a aVar2 = new a(1, true);
        f41237d = aVar2;
        a aVar3 = new a(2, false);
        f41238e = aVar3;
        a aVar4 = new a(3, true);
        f41239f = aVar4;
        a aVar5 = new a(4, false);
        f41240g = aVar5;
        a aVar6 = new a(5, true);
        f41241h = aVar6;
        a aVar7 = new a(6, false);
        f41242i = aVar7;
        a aVar8 = new a(7, true);
        f41243j = aVar8;
        a aVar9 = new a(8, false);
        f41244k = aVar9;
        a aVar10 = new a(9, true);
        f41245l = aVar10;
        a aVar11 = new a(10, false);
        f41246m = aVar11;
        a aVar12 = new a(10, true);
        f41247n = aVar12;
        f41248o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    a(int i3, boolean z16) {
        this.f41249a = i3;
        this.f41250b = z16;
    }

    public boolean a(a aVar) {
        int i3 = this.f41249a;
        int i16 = aVar.f41249a;
        if (i3 >= i16 && ((this.f41250b && f41245l != this) || i3 != i16)) {
            return false;
        }
        return true;
    }

    public a b() {
        if (!this.f41250b) {
            return f41248o[this.f41249a + 1];
        }
        return this;
    }

    public a c() {
        if (this.f41250b) {
            a aVar = f41248o[this.f41249a - 1];
            if (!aVar.f41250b) {
                return aVar;
            }
            return f41236c;
        }
        return this;
    }
}
