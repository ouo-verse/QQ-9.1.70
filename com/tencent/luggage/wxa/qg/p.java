package com.tencent.luggage.wxa.qg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p {

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator f138778h = new a();

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f138779i = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f138780a;

    /* renamed from: e, reason: collision with root package name */
    public int f138784e;

    /* renamed from: f, reason: collision with root package name */
    public int f138785f;

    /* renamed from: g, reason: collision with root package name */
    public int f138786g;

    /* renamed from: c, reason: collision with root package name */
    public final c[] f138782c = new c[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f138781b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f138783d = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return cVar.f138787a - cVar2.f138787a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            float f16 = cVar.f138789c;
            float f17 = cVar2.f138789c;
            if (f16 < f17) {
                return -1;
            }
            if (f17 < f16) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f138787a;

        /* renamed from: b, reason: collision with root package name */
        public int f138788b;

        /* renamed from: c, reason: collision with root package name */
        public float f138789c;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public p(int i3) {
        this.f138780a = i3;
    }

    public void a(int i3, float f16) {
        c cVar;
        a();
        int i16 = this.f138786g;
        if (i16 > 0) {
            c[] cVarArr = this.f138782c;
            int i17 = i16 - 1;
            this.f138786g = i17;
            cVar = cVarArr[i17];
        } else {
            cVar = new c(null);
        }
        int i18 = this.f138784e;
        this.f138784e = i18 + 1;
        cVar.f138787a = i18;
        cVar.f138788b = i3;
        cVar.f138789c = f16;
        this.f138781b.add(cVar);
        this.f138785f += i3;
        while (true) {
            int i19 = this.f138785f;
            int i26 = this.f138780a;
            if (i19 <= i26) {
                return;
            }
            int i27 = i19 - i26;
            c cVar2 = (c) this.f138781b.get(0);
            int i28 = cVar2.f138788b;
            if (i28 <= i27) {
                this.f138785f -= i28;
                this.f138781b.remove(0);
                int i29 = this.f138786g;
                if (i29 < 5) {
                    c[] cVarArr2 = this.f138782c;
                    this.f138786g = i29 + 1;
                    cVarArr2[i29] = cVar2;
                }
            } else {
                cVar2.f138788b = i28 - i27;
                this.f138785f -= i27;
            }
        }
    }

    public final void b() {
        if (this.f138783d != 0) {
            Collections.sort(this.f138781b, f138779i);
            this.f138783d = 0;
        }
    }

    public float a(float f16) {
        b();
        float f17 = f16 * this.f138785f;
        int i3 = 0;
        for (int i16 = 0; i16 < this.f138781b.size(); i16++) {
            c cVar = (c) this.f138781b.get(i16);
            i3 += cVar.f138788b;
            if (i3 >= f17) {
                return cVar.f138789c;
            }
        }
        if (this.f138781b.isEmpty()) {
            return Float.NaN;
        }
        return ((c) this.f138781b.get(r5.size() - 1)).f138789c;
    }

    public final void a() {
        if (this.f138783d != 1) {
            Collections.sort(this.f138781b, f138778h);
            this.f138783d = 1;
        }
    }
}
