package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Vec2 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: x, reason: collision with root package name */
    public float f423649x;

    /* renamed from: y, reason: collision with root package name */
    public float f423650y;

    public Vec2() {
        this(0.0f, 0.0f);
    }

    public static final void absToOut(Vec2 vec2, Vec2 vec22) {
        vec22.f423649x = MathUtils.abs(vec2.f423649x);
        vec22.f423650y = MathUtils.abs(vec2.f423650y);
    }

    public static final float cross(Vec2 vec2, Vec2 vec22) {
        return (vec2.f423649x * vec22.f423650y) - (vec2.f423650y * vec22.f423649x);
    }

    public static final void crossToOut(Vec2 vec2, float f16, Vec2 vec22) {
        float f17 = (-f16) * vec2.f423649x;
        vec22.f423649x = f16 * vec2.f423650y;
        vec22.f423650y = f17;
    }

    public static final void crossToOutUnsafe(Vec2 vec2, float f16, Vec2 vec22) {
        vec22.f423649x = vec2.f423650y * f16;
        vec22.f423650y = (-f16) * vec2.f423649x;
    }

    public static final float dot(Vec2 vec2, Vec2 vec22) {
        return (vec2.f423649x * vec22.f423649x) + (vec2.f423650y * vec22.f423650y);
    }

    public static final Vec2 max(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        float f17 = vec22.f423649x;
        if (f16 <= f17) {
            f16 = f17;
        }
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        if (f18 <= f19) {
            f18 = f19;
        }
        return new Vec2(f16, f18);
    }

    public static final void maxToOut(Vec2 vec2, Vec2 vec22, Vec2 vec23) {
        float f16 = vec2.f423649x;
        float f17 = vec22.f423649x;
        if (f16 <= f17) {
            f16 = f17;
        }
        vec23.f423649x = f16;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        if (f18 <= f19) {
            f18 = f19;
        }
        vec23.f423650y = f18;
    }

    public static final Vec2 min(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        float f17 = vec22.f423649x;
        if (f16 >= f17) {
            f16 = f17;
        }
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        if (f18 >= f19) {
            f18 = f19;
        }
        return new Vec2(f16, f18);
    }

    public static final void minToOut(Vec2 vec2, Vec2 vec22, Vec2 vec23) {
        float f16 = vec2.f423649x;
        float f17 = vec22.f423649x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec23.f423649x = f16;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec23.f423650y = f18;
    }

    public static final void negateToOut(Vec2 vec2, Vec2 vec22) {
        vec22.f423649x = -vec2.f423649x;
        vec22.f423650y = -vec2.f423650y;
    }

    public final Vec2 abs() {
        return new Vec2(MathUtils.abs(this.f423649x), MathUtils.abs(this.f423650y));
    }

    public final void absLocal() {
        this.f423649x = MathUtils.abs(this.f423649x);
        this.f423650y = MathUtils.abs(this.f423650y);
    }

    public final Vec2 add(Vec2 vec2) {
        return new Vec2(this.f423649x + vec2.f423649x, this.f423650y + vec2.f423650y);
    }

    public final Vec2 addLocal(Vec2 vec2) {
        this.f423649x += vec2.f423649x;
        this.f423650y += vec2.f423650y;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vec2 vec2 = (Vec2) obj;
        if (Float.floatToIntBits(this.f423649x) == Float.floatToIntBits(vec2.f423649x) && Float.floatToIntBits(this.f423650y) == Float.floatToIntBits(vec2.f423650y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.f423649x) + 31) * 31) + Float.floatToIntBits(this.f423650y);
    }

    public final boolean isValid() {
        if (!Float.isNaN(this.f423649x) && !Float.isInfinite(this.f423649x) && !Float.isNaN(this.f423650y) && !Float.isInfinite(this.f423650y)) {
            return true;
        }
        return false;
    }

    public final float length() {
        float f16 = this.f423649x;
        float f17 = this.f423650y;
        return MathUtils.sqrt((f16 * f16) + (f17 * f17));
    }

    public final float lengthSquared() {
        float f16 = this.f423649x;
        float f17 = this.f423650y;
        return (f16 * f16) + (f17 * f17);
    }

    public final Vec2 mul(float f16) {
        return new Vec2(this.f423649x * f16, this.f423650y * f16);
    }

    public final Vec2 mulLocal(float f16) {
        this.f423649x *= f16;
        this.f423650y *= f16;
        return this;
    }

    public final Vec2 negate() {
        return new Vec2(-this.f423649x, -this.f423650y);
    }

    public final Vec2 negateLocal() {
        this.f423649x = -this.f423649x;
        this.f423650y = -this.f423650y;
        return this;
    }

    public final float normalize() {
        float length = length();
        if (length < 1.1920929E-7f) {
            return 0.0f;
        }
        float f16 = 1.0f / length;
        this.f423649x *= f16;
        this.f423650y *= f16;
        return length;
    }

    public final Vec2 set(float f16, float f17) {
        this.f423649x = f16;
        this.f423650y = f17;
        return this;
    }

    public final void setZero() {
        this.f423649x = 0.0f;
        this.f423650y = 0.0f;
    }

    public final Vec2 skew() {
        return new Vec2(-this.f423650y, this.f423649x);
    }

    public final Vec2 sub(Vec2 vec2) {
        return new Vec2(this.f423649x - vec2.f423649x, this.f423650y - vec2.f423650y);
    }

    public final Vec2 subLocal(Vec2 vec2) {
        this.f423649x -= vec2.f423649x;
        this.f423650y -= vec2.f423650y;
        return this;
    }

    public final String toString() {
        return "(" + this.f423649x + "," + this.f423650y + ")";
    }

    public Vec2(float f16, float f17) {
        this.f423649x = f16;
        this.f423650y = f17;
    }

    public static final Vec2 abs(Vec2 vec2) {
        return new Vec2(MathUtils.abs(vec2.f423649x), MathUtils.abs(vec2.f423650y));
    }

    public static final Vec2 cross(Vec2 vec2, float f16) {
        return new Vec2(vec2.f423650y * f16, (-f16) * vec2.f423649x);
    }

    public final Vec2 clone() {
        return new Vec2(this.f423649x, this.f423650y);
    }

    public final void skew(Vec2 vec2) {
        vec2.f423649x = -this.f423650y;
        vec2.f423650y = this.f423649x;
    }

    public static final Vec2 cross(float f16, Vec2 vec2) {
        return new Vec2((-f16) * vec2.f423650y, f16 * vec2.f423649x);
    }

    public static final void crossToOutUnsafe(float f16, Vec2 vec2, Vec2 vec22) {
        vec22.f423649x = (-f16) * vec2.f423650y;
        vec22.f423650y = f16 * vec2.f423649x;
    }

    public final Vec2 addLocal(float f16, float f17) {
        this.f423649x += f16;
        this.f423650y += f17;
        return this;
    }

    public final Vec2 set(Vec2 vec2) {
        this.f423649x = vec2.f423649x;
        this.f423650y = vec2.f423650y;
        return this;
    }

    public static final void crossToOut(float f16, Vec2 vec2, Vec2 vec22) {
        float f17 = vec2.f423649x * f16;
        vec22.f423649x = (-f16) * vec2.f423650y;
        vec22.f423650y = f17;
    }

    public Vec2(Vec2 vec2) {
        this(vec2.f423649x, vec2.f423650y);
    }
}
