package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Vec2 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: x, reason: collision with root package name */
    public float f48119x;

    /* renamed from: y, reason: collision with root package name */
    public float f48120y;

    public Vec2() {
        this(0.0f, 0.0f);
    }

    public static void absToOut(Vec2 vec2, Vec2 vec22) {
        vec22.f48119x = b.a(vec2.f48119x);
        vec22.f48120y = b.a(vec2.f48120y);
    }

    public static float cross(Vec2 vec2, Vec2 vec22) {
        return (vec2.f48119x * vec22.f48120y) - (vec2.f48120y * vec22.f48119x);
    }

    public static void crossToOut(Vec2 vec2, float f16, Vec2 vec22) {
        float f17 = (-f16) * vec2.f48119x;
        vec22.f48119x = f16 * vec2.f48120y;
        vec22.f48120y = f17;
    }

    public static void crossToOutUnsafe(Vec2 vec2, float f16, Vec2 vec22) {
        vec22.f48119x = vec2.f48120y * f16;
        vec22.f48120y = (-f16) * vec2.f48119x;
    }

    public static float dot(Vec2 vec2, Vec2 vec22) {
        return (vec2.f48119x * vec22.f48119x) + (vec2.f48120y * vec22.f48120y);
    }

    public static Vec2 max(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        float f17 = vec22.f48119x;
        if (f16 <= f17) {
            f16 = f17;
        }
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        if (f18 <= f19) {
            f18 = f19;
        }
        return new Vec2(f16, f18);
    }

    public static void maxToOut(Vec2 vec2, Vec2 vec22, Vec2 vec23) {
        float f16 = vec2.f48119x;
        float f17 = vec22.f48119x;
        if (f16 <= f17) {
            f16 = f17;
        }
        vec23.f48119x = f16;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        if (f18 <= f19) {
            f18 = f19;
        }
        vec23.f48120y = f18;
    }

    public static Vec2 min(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        float f17 = vec22.f48119x;
        if (f16 >= f17) {
            f16 = f17;
        }
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        if (f18 >= f19) {
            f18 = f19;
        }
        return new Vec2(f16, f18);
    }

    public static void minToOut(Vec2 vec2, Vec2 vec22, Vec2 vec23) {
        float f16 = vec2.f48119x;
        float f17 = vec22.f48119x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec23.f48119x = f16;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec23.f48120y = f18;
    }

    public static void negateToOut(Vec2 vec2, Vec2 vec22) {
        vec22.f48119x = -vec2.f48119x;
        vec22.f48120y = -vec2.f48120y;
    }

    public final Vec2 abs() {
        return new Vec2(b.a(this.f48119x), b.a(this.f48120y));
    }

    public final void absLocal() {
        this.f48119x = b.a(this.f48119x);
        this.f48120y = b.a(this.f48120y);
    }

    public final Vec2 add(Vec2 vec2) {
        return new Vec2(this.f48119x + vec2.f48119x, this.f48120y + vec2.f48120y);
    }

    public final Vec2 addLocal(Vec2 vec2) {
        this.f48119x += vec2.f48119x;
        this.f48120y += vec2.f48120y;
        return this;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.f48119x) + 31) * 31) + Float.floatToIntBits(this.f48120y);
    }

    public final boolean isValid() {
        return (Float.isNaN(this.f48119x) || Float.isInfinite(this.f48119x) || Float.isNaN(this.f48120y) || Float.isInfinite(this.f48120y)) ? false : true;
    }

    public final float length() {
        float f16 = this.f48119x;
        float f17 = this.f48120y;
        return b.p((f16 * f16) + (f17 * f17));
    }

    public final float lengthSquared() {
        float f16 = this.f48119x;
        float f17 = this.f48120y;
        return (f16 * f16) + (f17 * f17);
    }

    public final Vec2 mul(float f16) {
        return new Vec2(this.f48119x * f16, this.f48120y * f16);
    }

    public final Vec2 mulLocal(float f16) {
        this.f48119x *= f16;
        this.f48120y *= f16;
        return this;
    }

    public final Vec2 negate() {
        return new Vec2(-this.f48119x, -this.f48120y);
    }

    public final Vec2 negateLocal() {
        this.f48119x = -this.f48119x;
        this.f48120y = -this.f48120y;
        return this;
    }

    public final float normalize() {
        float length = length();
        if (length < 1.1920929E-7f) {
            return 0.0f;
        }
        float f16 = 1.0f / length;
        this.f48119x *= f16;
        this.f48120y *= f16;
        return length;
    }

    public final Vec2 set(float f16, float f17) {
        this.f48119x = f16;
        this.f48120y = f17;
        return this;
    }

    public final Vec2 skew() {
        return new Vec2(-this.f48120y, this.f48119x);
    }

    public final Vec2 sub(Vec2 vec2) {
        return new Vec2(this.f48119x - vec2.f48119x, this.f48120y - vec2.f48120y);
    }

    public final Vec2 subLocal(Vec2 vec2) {
        this.f48119x -= vec2.f48119x;
        this.f48120y -= vec2.f48120y;
        return this;
    }

    public final String toString() {
        return "(" + this.f48119x + "," + this.f48120y + ")";
    }

    public Vec2(float f16, float f17) {
        this.f48119x = f16;
        this.f48120y = f17;
    }

    public static Vec2 abs(Vec2 vec2) {
        return new Vec2(b.a(vec2.f48119x), b.a(vec2.f48120y));
    }

    public static Vec2 cross(Vec2 vec2, float f16) {
        return new Vec2(vec2.f48120y * f16, (-f16) * vec2.f48119x);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final Vec2 m79clone() {
        return new Vec2(this.f48119x, this.f48120y);
    }

    public final void setZero() {
        this.f48119x = 0.0f;
        this.f48120y = 0.0f;
    }

    public final void skew(Vec2 vec2) {
        vec2.f48119x = -this.f48120y;
        vec2.f48120y = this.f48119x;
    }

    public static Vec2 cross(float f16, Vec2 vec2) {
        return new Vec2((-f16) * vec2.f48120y, f16 * vec2.f48119x);
    }

    public static void crossToOutUnsafe(float f16, Vec2 vec2, Vec2 vec22) {
        vec22.f48119x = (-f16) * vec2.f48120y;
        vec22.f48120y = f16 * vec2.f48119x;
    }

    public final Vec2 addLocal(float f16, float f17) {
        this.f48119x += f16;
        this.f48120y += f17;
        return this;
    }

    public final Vec2 set(Vec2 vec2) {
        this.f48119x = vec2.f48119x;
        this.f48120y = vec2.f48120y;
        return this;
    }

    public static void crossToOut(float f16, Vec2 vec2, Vec2 vec22) {
        float f17 = vec2.f48119x * f16;
        vec22.f48119x = (-f16) * vec2.f48120y;
        vec22.f48120y = f17;
    }

    public Vec2(Vec2 vec2) {
        this(vec2.f48119x, vec2.f48120y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vec2 vec2 = (Vec2) obj;
        return Float.floatToIntBits(this.f48119x) == Float.floatToIntBits(vec2.f48119x) && Float.floatToIntBits(this.f48120y) == Float.floatToIntBits(vec2.f48120y);
    }
}
