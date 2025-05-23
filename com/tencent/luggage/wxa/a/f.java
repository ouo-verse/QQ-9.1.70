package com.tencent.luggage.wxa.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f120469c = new f(null, null);

    /* renamed from: d, reason: collision with root package name */
    public static final f f120470d = new f(a.none, null);

    /* renamed from: e, reason: collision with root package name */
    public static final f f120471e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f120472f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f120473g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f120474h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f120475i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f120476j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f120477k;

    /* renamed from: a, reason: collision with root package name */
    public a f120478a;

    /* renamed from: b, reason: collision with root package name */
    public b f120479b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        meet,
        slice
    }

    static {
        a aVar = a.xMidYMid;
        b bVar = b.meet;
        f120471e = new f(aVar, bVar);
        a aVar2 = a.xMinYMin;
        f120472f = new f(aVar2, bVar);
        f120473g = new f(a.xMaxYMax, bVar);
        f120474h = new f(a.xMidYMin, bVar);
        f120475i = new f(a.xMidYMax, bVar);
        b bVar2 = b.slice;
        f120476j = new f(aVar, bVar2);
        f120477k = new f(aVar2, bVar2);
    }

    public f(a aVar, b bVar) {
        this.f120478a = aVar;
        this.f120479b = bVar;
    }

    public a a() {
        return this.f120478a;
    }

    public b b() {
        return this.f120479b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f120478a == fVar.f120478a && this.f120479b == fVar.f120479b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f120478a + " " + this.f120479b;
    }
}
