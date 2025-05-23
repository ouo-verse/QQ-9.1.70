package com.tencent.luggage.wxa.bh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static final c f122715h = new c(null);

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f122716i = a.f122725a;

    /* renamed from: j, reason: collision with root package name */
    public static final Comparator f122717j = C6068b.f122726a;

    /* renamed from: a, reason: collision with root package name */
    public final int f122718a;

    /* renamed from: e, reason: collision with root package name */
    public int f122722e;

    /* renamed from: f, reason: collision with root package name */
    public int f122723f;

    /* renamed from: g, reason: collision with root package name */
    public int f122724g;

    /* renamed from: c, reason: collision with root package name */
    public final d[] f122720c = new d[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f122719b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f122721d = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final a f122725a = new a();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(d dVar, d dVar2) {
            return dVar.a() - dVar2.a();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6068b implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final C6068b f122726a = new C6068b();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(d dVar, d dVar2) {
            if (dVar.b() < dVar2.b()) {
                return -1;
            }
            if (dVar2.b() < dVar.b()) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public int f122727a;

        /* renamed from: b, reason: collision with root package name */
        public int f122728b;

        /* renamed from: c, reason: collision with root package name */
        public float f122729c;

        public final int a() {
            return this.f122727a;
        }

        public final void b(int i3) {
            this.f122728b = i3;
        }

        public final int c() {
            return this.f122728b;
        }

        public final void a(int i3) {
            this.f122727a = i3;
        }

        public final float b() {
            return this.f122729c;
        }

        public final void a(float f16) {
            this.f122729c = f16;
        }
    }

    public b(int i3) {
        this.f122718a = i3;
    }

    public final void a(int i3, float f16) {
        d dVar;
        a();
        int i16 = this.f122724g;
        if (i16 > 0) {
            d[] dVarArr = this.f122720c;
            int i17 = i16 - 1;
            this.f122724g = i17;
            dVar = dVarArr[i17];
        } else {
            dVar = new d();
        }
        Intrinsics.checkNotNull(dVar);
        int i18 = this.f122722e;
        this.f122722e = i18 + 1;
        dVar.a(i18);
        dVar.b(i3);
        dVar.a(f16);
        this.f122719b.add(dVar);
        this.f122723f += i3;
        while (true) {
            int i19 = this.f122723f;
            int i26 = this.f122718a;
            if (i19 <= i26) {
                return;
            }
            int i27 = i19 - i26;
            Object obj = this.f122719b.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "this.samples[0]");
            d dVar2 = (d) obj;
            if (dVar2.c() <= i27) {
                this.f122723f -= dVar2.c();
                this.f122719b.remove(0);
                int i28 = this.f122724g;
                if (i28 < 5) {
                    d[] dVarArr2 = this.f122720c;
                    this.f122724g = i28 + 1;
                    dVarArr2[i28] = dVar2;
                }
            } else {
                dVar2.b(dVar2.c() - i27);
                this.f122723f -= i27;
            }
        }
    }

    public final float b() {
        int size = this.f122719b.size();
        boolean z16 = false;
        float f16 = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            f16 += (((d) this.f122719b.get(i3)).c() / this.f122723f) * ((d) this.f122719b.get(i3)).b();
        }
        if (f16 == 0.0f) {
            z16 = true;
        }
        if (z16) {
            if (this.f122719b.isEmpty()) {
                return -1.0f;
            }
            ArrayList arrayList = this.f122719b;
            return ((d) arrayList.get(arrayList.size() - 1)).b();
        }
        return f16;
    }

    public final void a() {
        if (this.f122721d != 1) {
            Collections.sort(this.f122719b, f122716i);
            this.f122721d = 1;
        }
    }
}
