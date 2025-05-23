package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    private final Context f201692b;

    /* renamed from: g, reason: collision with root package name */
    private ea1.f[] f201697g;

    /* renamed from: h, reason: collision with root package name */
    private ea1.f[] f201698h;

    /* renamed from: i, reason: collision with root package name */
    private ea1.f[] f201699i;

    /* renamed from: a, reason: collision with root package name */
    private int f201691a = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f201693c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f201694d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f201695e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f201696f = 6;

    public q(Context context) {
        this.f201692b = context;
        f();
    }

    private void f() {
        int i3 = this.f201696f;
        this.f201697g = new ea1.f[i3];
        this.f201698h = new ea1.f[i3];
        this.f201699i = new ea1.f[i3];
        for (int i16 = 0; i16 < this.f201696f; i16++) {
            this.f201697g[i16] = new ea1.f();
            this.f201697g[i16].f396029d = 1.0f;
            this.f201698h[i16] = new ea1.f();
            this.f201699i[i16] = new ea1.f();
        }
    }

    private void l(ea1.f[] fVarArr) {
        float f16;
        float f17;
        boolean z16;
        float applyDimension = TypedValue.applyDimension(1, 19.0f, this.f201692b.getResources().getDisplayMetrics());
        int i3 = this.f201691a;
        if (i3 == 3) {
            f16 = TypedValue.applyDimension(1, -0.5f, this.f201692b.getResources().getDisplayMetrics());
        } else if (i3 == 5) {
            f16 = TypedValue.applyDimension(1, 1.0f, this.f201692b.getResources().getDisplayMetrics());
        } else if (i3 == 6) {
            f16 = TypedValue.applyDimension(1, 2.0f, this.f201692b.getResources().getDisplayMetrics());
        } else {
            f16 = 0.0f;
        }
        float f18 = (applyDimension / 2.0f) + f16;
        int i16 = this.f201691a;
        double d16 = 6.283185307179586d / i16;
        for (int i17 = i16 - 1; i17 >= 0; i17--) {
            ea1.f fVar = fVarArr[i17];
            fVar.f396028c = applyDimension;
            int i18 = this.f201691a;
            fVar.f396027b = (float) (((i18 - 1) - i17) * d16);
            fVar.f396026a = f18;
            fVar.f396029d = 1.0f;
            if (i18 < 5) {
                f17 = 0.0f;
            } else {
                f17 = 1.0f;
            }
            fVar.f396030e = f17;
            if (i18 < 5) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.f396031f = z16;
        }
    }

    private void m(ea1.f[] fVarArr) {
        ea1.f fVar = fVarArr[0];
        fVar.f396030e = 0.0f;
        fVar.f396029d = 1.0f;
        fVar.f396026a = 0.0f;
        fVar.f396031f = true;
        fVar.f396027b = 4.712389f;
        fVar.f396028c = TypedValue.applyDimension(1, 31.0f, this.f201692b.getResources().getDisplayMetrics());
    }

    private void n(ea1.f[] fVarArr) {
        float applyDimension = TypedValue.applyDimension(1, 23.0f, this.f201692b.getResources().getDisplayMetrics());
        float applyDimension2 = (applyDimension / 2.0f) - (TypedValue.applyDimension(1, 5.0f, this.f201692b.getResources().getDisplayMetrics()) / 2.0f);
        ea1.f fVar = fVarArr[0];
        fVar.f396028c = applyDimension;
        fVar.f396026a = applyDimension2;
        fVar.f396027b = 4.712389f;
        fVar.f396029d = 1.0f;
        fVar.f396030e = 0.0f;
        fVar.f396031f = true;
        ea1.f fVar2 = fVarArr[1];
        fVar2.f396028c = applyDimension;
        fVar2.f396026a = applyDimension2;
        fVar2.f396027b = 1.5707964f;
        fVar2.f396029d = 1.0f;
        fVar2.f396030e = 0.0f;
        fVar2.f396031f = true;
    }

    private void o() {
        int i3 = this.f201691a;
        if (i3 == 0) {
            return;
        }
        if (i3 == 1) {
            this.f201697g[0].f396032g = null;
            return;
        }
        if (i3 == 2) {
            ea1.f[] fVarArr = this.f201697g;
            ea1.f fVar = fVarArr[0];
            fVar.f396032g = null;
            fVarArr[1].f396032g = fVar;
            return;
        }
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (i16 == 0) {
                ea1.f[] fVarArr2 = this.f201697g;
                fVarArr2[i16].f396032g = fVarArr2[this.f201691a - 1];
            } else {
                ea1.f[] fVarArr3 = this.f201697g;
                fVarArr3[i16].f396032g = fVarArr3[i16 - 1];
            }
        }
    }

    private void p(ea1.f[] fVarArr) {
        int i3 = this.f201691a;
        if (i3 == 0) {
            return;
        }
        if (i3 == 1) {
            m(fVarArr);
        } else if (i3 == 2) {
            n(fVarArr);
        } else {
            l(fVarArr);
        }
    }

    public void a() {
        int i3 = this.f201691a;
        if (i3 == this.f201696f) {
            return;
        }
        this.f201691a = i3 + 1;
        o();
    }

    public ea1.f[] b() {
        return this.f201697g;
    }

    public long c() {
        return 300L;
    }

    public int d() {
        return this.f201696f;
    }

    public int e() {
        return this.f201691a;
    }

    public void g() {
        if (!this.f201693c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.f201695e;
        if (j3 > 48) {
            this.f201694d += j3 - 48;
        }
        this.f201695e = currentTimeMillis;
        float c16 = ((float) (currentTimeMillis - this.f201694d)) / ((float) c());
        if (c16 >= 1.0f) {
            c16 = 1.0f;
        }
        for (int i3 = 0; i3 < this.f201691a; i3++) {
            this.f201697g[i3].b(this.f201698h[i3], this.f201699i[i3], c16);
        }
        if (c16 >= 1.0f) {
            this.f201693c = false;
        }
    }

    public boolean h() {
        return this.f201693c;
    }

    public void i() {
        if (this.f201691a < 2) {
            return;
        }
        for (int i3 = 0; i3 < this.f201691a - 1; i3++) {
            this.f201698h[i3].a(this.f201697g[i3]);
        }
        p(this.f201699i);
        ea1.f[] fVarArr = this.f201698h;
        int i16 = this.f201691a;
        fVarArr[i16 - 1].a(this.f201699i[i16 - 1]);
        ea1.f[] fVarArr2 = this.f201698h;
        int i17 = this.f201691a;
        fVarArr2[i17 - 1].f396028c *= 0.4f;
        this.f201697g[i17 - 1].a(fVarArr2[i17 - 1]);
    }

    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f201694d = currentTimeMillis;
        this.f201695e = currentTimeMillis;
    }

    public void k() {
        if (!this.f201693c) {
            p(this.f201697g);
        } else {
            g();
        }
    }

    public void q(int i3) {
        int i16 = this.f201696f;
        if (i3 > i16) {
            this.f201691a = i16;
        } else {
            this.f201691a = Math.max(i3, 0);
        }
        o();
    }

    public void r(int i3) {
        if (i3 > 0 && this.f201696f != i3) {
            this.f201696f = i3;
            f();
        }
    }

    public void s() {
        if (this.f201691a < 2) {
            return;
        }
        this.f201693c = true;
        i();
    }

    public void t() {
        this.f201693c = false;
    }
}
