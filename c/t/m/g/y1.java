package c.t.m.g;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes.dex */
public class y1 {

    /* renamed from: a, reason: collision with root package name */
    public final float f30110a;

    /* renamed from: b, reason: collision with root package name */
    public final float f30111b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<r2> f30112c;

    /* renamed from: d, reason: collision with root package name */
    public s2 f30113d = null;

    /* renamed from: e, reason: collision with root package name */
    public s2 f30114e = null;

    /* renamed from: f, reason: collision with root package name */
    public float f30115f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f30116g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public long f30117h = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f30118i = true;

    /* renamed from: j, reason: collision with root package name */
    public float f30119j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    public z1 f30120k;

    public y1(float f16, float f17) {
        this.f30112c = null;
        this.f30112c = new LinkedList<>();
        this.f30110a = f16;
        this.f30111b = f17;
    }

    public void a(z1 z1Var) {
        this.f30120k = z1Var;
    }

    public final boolean b(r2 r2Var) {
        if (r2Var.a() >= 0.0f && r2Var.b() <= 0.0f) {
            return true;
        }
        return false;
    }

    public void a(float[] fArr, long j3) {
        a(j3, fArr[0], fArr[1], fArr[2]);
        float f16 = this.f30115f;
        if (f16 != 0.0f) {
            float f17 = this.f30116g;
            if (f17 != 0.0f) {
                this.f30112c.add(new r2(f16, f17, this.f30113d.a(), j3));
            }
        }
        if (this.f30117h == 0) {
            this.f30117h = j3;
        }
        if (((float) (j3 - this.f30117h)) >= this.f30111b * 1.0E9f) {
            if (this.f30118i) {
                int i3 = 0;
                for (int i16 = 0; i16 < this.f30112c.size(); i16++) {
                    if (b(this.f30112c.get(i16)) && this.f30119j < Math.abs(this.f30112c.get(i16).c() - this.f30112c.get(0).c())) {
                        this.f30119j = Math.abs(this.f30112c.get(i16).c() - this.f30112c.get(0).c());
                        i3 = i16;
                    }
                }
                if (i3 > 0 && i3 < this.f30112c.size()) {
                    this.f30117h = this.f30112c.get(i3).d();
                    for (int i17 = 0; i17 < i3; i17++) {
                        this.f30112c.removeFirst();
                    }
                    if (this.f30119j > this.f30110a) {
                        this.f30120k.a(j3);
                    }
                    this.f30119j = 0.0f;
                    this.f30118i = false;
                } else {
                    this.f30117h = 0L;
                }
            } else {
                int i18 = 0;
                for (int i19 = 0; i19 < this.f30112c.size(); i19++) {
                    if (a(this.f30112c.get(i19)) && this.f30119j < Math.abs(this.f30112c.get(i19).c() - this.f30112c.get(0).c())) {
                        this.f30119j = Math.abs(this.f30112c.get(i19).c() - this.f30112c.get(0).c());
                        i18 = i19;
                    }
                }
                if (i18 > 0 && i18 < this.f30112c.size()) {
                    this.f30117h = this.f30112c.get(i18).d();
                    for (int i26 = 0; i26 < i18; i26++) {
                        this.f30112c.removeFirst();
                    }
                    this.f30119j = 0.0f;
                    this.f30118i = true;
                } else {
                    this.f30117h = 0L;
                }
            }
        }
        this.f30114e = this.f30113d;
        this.f30116g = this.f30115f;
    }

    public final void a(long j3, float f16, float f17, float f18) {
        long currentTimeMillis = System.currentTimeMillis();
        s2 s2Var = this.f30113d;
        if (s2Var == null) {
            s2 s2Var2 = new s2(currentTimeMillis, j3, f16, f17, f18);
            this.f30113d = s2Var2;
            this.f30115f = s2Var2.a() - 0.0f;
        } else {
            s2 s2Var3 = new s2(currentTimeMillis, j3, (f16 * 0.1f) + (s2Var.b() * 0.9f), (f17 * 0.1f) + (this.f30113d.c() * 0.9f), (f18 * 0.1f) + (this.f30113d.d() * 0.9f));
            this.f30113d = s2Var3;
            if (this.f30114e != null) {
                this.f30115f = s2Var3.a() - this.f30114e.a();
            }
        }
    }

    public final boolean a(r2 r2Var) {
        return r2Var.a() <= 0.0f && r2Var.b() >= 0.0f;
    }
}
