package com.tencent.luggage.wxa.eh;

import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f124856a;

    /* renamed from: b, reason: collision with root package name */
    public g.h f124857b = g.h.DEFAULT;

    /* renamed from: c, reason: collision with root package name */
    public int f124858c;

    /* renamed from: d, reason: collision with root package name */
    public int f124859d;

    /* renamed from: e, reason: collision with root package name */
    public int f124860e;

    /* renamed from: f, reason: collision with root package name */
    public int f124861f;

    /* renamed from: g, reason: collision with root package name */
    public int f124862g;

    /* renamed from: h, reason: collision with root package name */
    public int f124863h;

    public void a() {
        this.f124859d = 0;
        this.f124858c = 0;
        this.f124861f = 0;
        this.f124860e = 0;
        this.f124863h = 0;
        this.f124862g = 0;
    }

    public final void b(float f16, float f17) {
        int i3 = this.f124858c;
        int i16 = this.f124859d;
        if (i3 > i16) {
            int i17 = (int) (i3 / f16);
            this.f124863h = i17;
            this.f124862g = i3;
            if (i17 < i16) {
                this.f124862g = (int) (i16 * f16);
                this.f124863h = i16;
                return;
            }
            return;
        }
        int i18 = (int) (i16 * f16);
        this.f124862g = i18;
        this.f124863h = i16;
        if (i18 < i3) {
            this.f124863h = (int) (i3 / f16);
            this.f124862g = i3;
        }
    }

    public final void c(float f16, float f17) {
        if (!this.f124856a) {
            int i3 = this.f124858c;
            int i16 = this.f124859d;
            if (i3 < i16) {
                this.f124863h = (int) (i3 / f16);
                this.f124862g = i3;
                return;
            } else {
                this.f124862g = (int) (i16 * f16);
                this.f124863h = i16;
                return;
            }
        }
        if (Math.abs(f16 - f17) > 0.05d) {
            int i17 = this.f124858c;
            int i18 = this.f124859d;
            if (i17 < i18) {
                this.f124863h = (int) (i17 / f16);
                this.f124862g = i17;
                return;
            } else {
                this.f124862g = (int) (i18 * f16);
                this.f124863h = i18;
                return;
            }
        }
        int i19 = this.f124858c;
        int i26 = this.f124859d;
        if (i19 > i26) {
            this.f124863h = (int) (i19 / f16);
            this.f124862g = i19;
        } else {
            this.f124862g = (int) (i26 * f16);
            this.f124863h = i26;
        }
    }

    public final void d(float f16, float f17) {
        this.f124863h = this.f124859d;
        this.f124862g = this.f124858c;
    }

    public boolean a(g.h hVar) {
        g.h hVar2 = this.f124857b;
        boolean z16 = hVar2 == hVar;
        w.d("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", hVar2, hVar);
        this.f124857b = hVar;
        a();
        return !z16;
    }

    public boolean a(int i3, int i16, int i17, int i18) {
        if (this.f124858c == i3 && this.f124859d == i16 && this.f124860e == i17 && this.f124861f == i18) {
            return true;
        }
        this.f124858c = i3;
        this.f124859d = i16;
        this.f124860e = i17;
        this.f124861f = i18;
        float f16 = (i17 * 1.0f) / i18;
        float f17 = (i3 * 1.0f) / i16;
        g.h hVar = this.f124857b;
        if (hVar == g.h.DEFAULT) {
            c(f16, f17);
        } else if (hVar == g.h.CONTAIN) {
            a(f16, f17);
        } else if (hVar == g.h.FILL) {
            d(f16, f17);
        } else if (hVar == g.h.COVER) {
            b(f16, f17);
        } else {
            c(f16, f17);
        }
        w.a("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.f124858c), Integer.valueOf(this.f124859d), Integer.valueOf(this.f124860e), Integer.valueOf(this.f124861f), Integer.valueOf(this.f124862g), Integer.valueOf(this.f124863h), Float.valueOf(f17), Float.valueOf(f16));
        return false;
    }

    public final void a(float f16, float f17) {
        int i3 = this.f124858c;
        int i16 = this.f124859d;
        if (i3 < i16) {
            int i17 = (int) (i3 / f16);
            this.f124863h = i17;
            this.f124862g = i3;
            if (i17 > i16) {
                this.f124862g = (int) (i16 * f16);
                this.f124863h = i16;
                return;
            }
            return;
        }
        int i18 = (int) (i16 * f16);
        this.f124862g = i18;
        this.f124863h = i16;
        if (i18 > i3) {
            this.f124863h = (int) (i3 / f16);
            this.f124862g = i3;
        }
    }
}
