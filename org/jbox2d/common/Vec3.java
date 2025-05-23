package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Vec3 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: x, reason: collision with root package name */
    public float f423651x;

    /* renamed from: y, reason: collision with root package name */
    public float f423652y;

    /* renamed from: z, reason: collision with root package name */
    public float f423653z;

    public Vec3() {
        this.f423653z = 0.0f;
        this.f423652y = 0.0f;
        this.f423651x = 0.0f;
    }

    public static final Vec3 cross(Vec3 vec3, Vec3 vec32) {
        float f16 = vec3.f423652y;
        float f17 = vec32.f423653z;
        float f18 = vec3.f423653z;
        float f19 = vec32.f423652y;
        float f26 = vec32.f423651x;
        float f27 = vec3.f423651x;
        return new Vec3((f16 * f17) - (f18 * f19), (f18 * f26) - (f17 * f27), (f27 * f19) - (f16 * f26));
    }

    public static final void crossToOut(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        float f16 = vec3.f423653z;
        float f17 = vec32.f423651x;
        float f18 = vec3.f423651x;
        float f19 = vec32.f423653z;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = vec32.f423652y;
        float f28 = vec3.f423652y;
        vec33.f423651x = (f28 * f19) - (f16 * f27);
        vec33.f423652y = f26;
        vec33.f423653z = (f18 * f27) - (f17 * f28);
    }

    public static final void crossToOutUnsafe(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        float f16 = vec3.f423652y;
        float f17 = vec32.f423653z;
        float f18 = vec3.f423653z;
        vec33.f423651x = (f16 * f17) - (vec32.f423652y * f18);
        float f19 = vec32.f423651x;
        float f26 = vec3.f423651x;
        vec33.f423652y = (f18 * f19) - (f17 * f26);
        vec33.f423653z = (f26 * vec32.f423652y) - (vec3.f423652y * f19);
    }

    public static final float dot(Vec3 vec3, Vec3 vec32) {
        return (vec3.f423651x * vec32.f423651x) + (vec3.f423652y * vec32.f423652y) + (vec3.f423653z * vec32.f423653z);
    }

    public Vec3 add(Vec3 vec3) {
        return new Vec3(this.f423651x + vec3.f423651x, this.f423652y + vec3.f423652y, this.f423653z + vec3.f423653z);
    }

    public Vec3 addLocal(Vec3 vec3) {
        this.f423651x += vec3.f423651x;
        this.f423652y += vec3.f423652y;
        this.f423653z += vec3.f423653z;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vec3 vec3 = (Vec3) obj;
        if (Float.floatToIntBits(this.f423651x) == Float.floatToIntBits(vec3.f423651x) && Float.floatToIntBits(this.f423652y) == Float.floatToIntBits(vec3.f423652y) && Float.floatToIntBits(this.f423653z) == Float.floatToIntBits(vec3.f423653z)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((Float.floatToIntBits(this.f423651x) + 31) * 31) + Float.floatToIntBits(this.f423652y)) * 31) + Float.floatToIntBits(this.f423653z);
    }

    public Vec3 mul(float f16) {
        return new Vec3(this.f423651x * f16, this.f423652y * f16, this.f423653z * f16);
    }

    public Vec3 mulLocal(float f16) {
        this.f423651x *= f16;
        this.f423652y *= f16;
        this.f423653z *= f16;
        return this;
    }

    public Vec3 negate() {
        return new Vec3(-this.f423651x, -this.f423652y, -this.f423653z);
    }

    public Vec3 negateLocal() {
        this.f423651x = -this.f423651x;
        this.f423652y = -this.f423652y;
        this.f423653z = -this.f423653z;
        return this;
    }

    public Vec3 set(Vec3 vec3) {
        this.f423651x = vec3.f423651x;
        this.f423652y = vec3.f423652y;
        this.f423653z = vec3.f423653z;
        return this;
    }

    public void setZero() {
        this.f423651x = 0.0f;
        this.f423652y = 0.0f;
        this.f423653z = 0.0f;
    }

    public Vec3 sub(Vec3 vec3) {
        return new Vec3(this.f423651x - vec3.f423651x, this.f423652y - vec3.f423652y, this.f423653z - vec3.f423653z);
    }

    public Vec3 subLocal(Vec3 vec3) {
        this.f423651x -= vec3.f423651x;
        this.f423652y -= vec3.f423652y;
        this.f423653z -= vec3.f423653z;
        return this;
    }

    public String toString() {
        return "(" + this.f423651x + "," + this.f423652y + "," + this.f423653z + ")";
    }

    public Vec3 clone() {
        return new Vec3(this);
    }

    public Vec3(float f16, float f17, float f18) {
        this.f423651x = f16;
        this.f423652y = f17;
        this.f423653z = f18;
    }

    public Vec3 set(float f16, float f17, float f18) {
        this.f423651x = f16;
        this.f423652y = f17;
        this.f423653z = f18;
        return this;
    }

    public Vec3(Vec3 vec3) {
        this.f423651x = vec3.f423651x;
        this.f423652y = vec3.f423652y;
        this.f423653z = vec3.f423653z;
    }
}
