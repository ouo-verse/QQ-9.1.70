package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Sweep implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    public float f423643a;

    /* renamed from: a0, reason: collision with root package name */
    public float f423644a0;
    public float alpha0;
    public final Vec2 localCenter = new Vec2();

    /* renamed from: c0, reason: collision with root package name */
    public final Vec2 f423646c0 = new Vec2();

    /* renamed from: c, reason: collision with root package name */
    public final Vec2 f423645c = new Vec2();

    public final void advance(float f16) {
        Vec2 vec2 = this.f423646c0;
        float f17 = 1.0f - f16;
        float f18 = vec2.f423649x * f17;
        Vec2 vec22 = this.f423645c;
        vec2.f423649x = f18 + (vec22.f423649x * f16);
        vec2.f423650y = (vec2.f423650y * f17) + (vec22.f423650y * f16);
        this.f423644a0 = (f17 * this.f423644a0) + (f16 * this.f423643a);
    }

    public final void getTransform(Transform transform, float f16) {
        Vec2 vec2 = transform.f423647p;
        float f17 = 1.0f - f16;
        Vec2 vec22 = this.f423646c0;
        float f18 = vec22.f423649x * f17;
        Vec2 vec23 = this.f423645c;
        vec2.f423649x = f18 + (vec23.f423649x * f16);
        vec2.f423650y = (vec22.f423650y * f17) + (vec23.f423650y * f16);
        transform.f423648q.set((f17 * this.f423644a0) + (f16 * this.f423643a));
        Rot rot = transform.f423648q;
        Vec2 vec24 = transform.f423647p;
        float f19 = vec24.f423649x;
        float f26 = rot.f423641c;
        Vec2 vec25 = this.localCenter;
        float f27 = vec25.f423649x * f26;
        float f28 = rot.f423642s;
        float f29 = vec25.f423650y;
        vec24.f423649x = f19 - (f27 - (f28 * f29));
        vec24.f423650y -= (f28 * vec25.f423649x) + (f26 * f29);
    }

    public final void normalize() {
        float floor = MathUtils.floor(this.f423644a0 / 6.2831855f) * 6.2831855f;
        this.f423644a0 -= floor;
        this.f423643a -= floor;
    }

    public final Sweep set(Sweep sweep) {
        this.localCenter.set(sweep.localCenter);
        this.f423646c0.set(sweep.f423646c0);
        this.f423645c.set(sweep.f423645c);
        this.f423644a0 = sweep.f423644a0;
        this.f423643a = sweep.f423643a;
        return this;
    }

    public String toString() {
        return (("Sweep:\nlocalCenter: " + this.localCenter + "\n") + "c0: " + this.f423646c0 + ", c: " + this.f423645c + "\n") + "a0: " + this.f423644a0 + ", a: " + this.f423643a + "\n";
    }
}
