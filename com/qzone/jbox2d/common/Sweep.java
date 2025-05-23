package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Sweep implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    public float f48112a;

    /* renamed from: a0, reason: collision with root package name */
    public float f48113a0;
    public float alpha0;
    public final Vec2 localCenter = new Vec2();

    /* renamed from: c0, reason: collision with root package name */
    public final Vec2 f48115c0 = new Vec2();

    /* renamed from: c, reason: collision with root package name */
    public final Vec2 f48114c = new Vec2();

    public final void advance(float f16) {
        float f17 = this.alpha0;
        float f18 = (f16 - f17) / (1.0f - f17);
        Vec2 vec2 = this.f48115c0;
        float f19 = vec2.f48119x;
        Vec2 vec22 = this.f48114c;
        vec2.f48119x = f19 + ((vec22.f48119x - f19) * f18);
        float f26 = vec2.f48120y;
        vec2.f48120y = f26 + ((vec22.f48120y - f26) * f18);
        float f27 = this.f48113a0;
        this.f48113a0 = f27 + (f18 * (this.f48112a - f27));
        this.alpha0 = f16;
    }

    public final void getTransform(Transform transform, float f16) {
        Vec2 vec2 = transform.f48117p;
        float f17 = 1.0f - f16;
        Vec2 vec22 = this.f48115c0;
        float f18 = vec22.f48119x * f17;
        Vec2 vec23 = this.f48114c;
        vec2.f48119x = f18 + (vec23.f48119x * f16);
        vec2.f48120y = (vec22.f48120y * f17) + (vec23.f48120y * f16);
        transform.f48118q.set((f17 * this.f48113a0) + (f16 * this.f48112a));
        Rot rot = transform.f48118q;
        Vec2 vec24 = transform.f48117p;
        float f19 = vec24.f48119x;
        float f26 = rot.f48110c;
        Vec2 vec25 = this.localCenter;
        float f27 = vec25.f48119x * f26;
        float f28 = rot.f48111s;
        float f29 = vec25.f48120y;
        vec24.f48119x = f19 - (f27 - (f28 * f29));
        vec24.f48120y -= (f28 * vec25.f48119x) + (f26 * f29);
    }

    public final void normalize() {
        float i3 = b.i(this.f48113a0 / 6.2831855f) * 6.2831855f;
        this.f48113a0 -= i3;
        this.f48112a -= i3;
    }

    public final Sweep set(Sweep sweep) {
        this.localCenter.set(sweep.localCenter);
        this.f48115c0.set(sweep.f48115c0);
        this.f48114c.set(sweep.f48114c);
        this.f48113a0 = sweep.f48113a0;
        this.f48112a = sweep.f48112a;
        this.alpha0 = sweep.alpha0;
        return this;
    }

    public String toString() {
        return ((("Sweep:\nlocalCenter: " + this.localCenter + "\n") + "c0: " + this.f48115c0 + ", c: " + this.f48114c + "\n") + "a0: " + this.f48113a0 + ", a: " + this.f48112a + "\n") + "alpha0: " + this.alpha0;
    }
}
