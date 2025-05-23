package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Vec3 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: x, reason: collision with root package name */
    public float f48121x;

    /* renamed from: y, reason: collision with root package name */
    public float f48122y;

    /* renamed from: z, reason: collision with root package name */
    public float f48123z;

    public Vec3() {
        this.f48123z = 0.0f;
        this.f48122y = 0.0f;
        this.f48121x = 0.0f;
    }

    public static Vec3 cross(Vec3 vec3, Vec3 vec32) {
        float f16 = vec3.f48122y;
        float f17 = vec32.f48123z;
        float f18 = vec3.f48123z;
        float f19 = vec32.f48122y;
        float f26 = vec32.f48121x;
        float f27 = vec3.f48121x;
        return new Vec3((f16 * f17) - (f18 * f19), (f18 * f26) - (f17 * f27), (f27 * f19) - (f16 * f26));
    }

    public static void crossToOut(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        float f16 = vec3.f48123z;
        float f17 = vec32.f48121x;
        float f18 = vec3.f48121x;
        float f19 = vec32.f48123z;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = vec32.f48122y;
        float f28 = vec3.f48122y;
        vec33.f48121x = (f28 * f19) - (f16 * f27);
        vec33.f48122y = f26;
        vec33.f48123z = (f18 * f27) - (f17 * f28);
    }

    public static void crossToOutUnsafe(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        float f16 = vec3.f48122y;
        float f17 = vec32.f48123z;
        float f18 = vec3.f48123z;
        vec33.f48121x = (f16 * f17) - (vec32.f48122y * f18);
        float f19 = vec32.f48121x;
        float f26 = vec3.f48121x;
        vec33.f48122y = (f18 * f19) - (f17 * f26);
        vec33.f48123z = (f26 * vec32.f48122y) - (vec3.f48122y * f19);
    }

    public static float dot(Vec3 vec3, Vec3 vec32) {
        return (vec3.f48121x * vec32.f48121x) + (vec3.f48122y * vec32.f48122y) + (vec3.f48123z * vec32.f48123z);
    }

    public Vec3 add(Vec3 vec3) {
        return new Vec3(this.f48121x + vec3.f48121x, this.f48122y + vec3.f48122y, this.f48123z + vec3.f48123z);
    }

    public Vec3 addLocal(Vec3 vec3) {
        this.f48121x += vec3.f48121x;
        this.f48122y += vec3.f48122y;
        this.f48123z += vec3.f48123z;
        return this;
    }

    public int hashCode() {
        return ((((Float.floatToIntBits(this.f48121x) + 31) * 31) + Float.floatToIntBits(this.f48122y)) * 31) + Float.floatToIntBits(this.f48123z);
    }

    public Vec3 mul(float f16) {
        return new Vec3(this.f48121x * f16, this.f48122y * f16, this.f48123z * f16);
    }

    public Vec3 mulLocal(float f16) {
        this.f48121x *= f16;
        this.f48122y *= f16;
        this.f48123z *= f16;
        return this;
    }

    public Vec3 negate() {
        return new Vec3(-this.f48121x, -this.f48122y, -this.f48123z);
    }

    public Vec3 negateLocal() {
        this.f48121x = -this.f48121x;
        this.f48122y = -this.f48122y;
        this.f48123z = -this.f48123z;
        return this;
    }

    public Vec3 set(Vec3 vec3) {
        this.f48121x = vec3.f48121x;
        this.f48122y = vec3.f48122y;
        this.f48123z = vec3.f48123z;
        return this;
    }

    public Vec3 sub(Vec3 vec3) {
        return new Vec3(this.f48121x - vec3.f48121x, this.f48122y - vec3.f48122y, this.f48123z - vec3.f48123z);
    }

    public Vec3 subLocal(Vec3 vec3) {
        this.f48121x -= vec3.f48121x;
        this.f48122y -= vec3.f48122y;
        this.f48123z -= vec3.f48123z;
        return this;
    }

    public String toString() {
        return "(" + this.f48121x + "," + this.f48122y + "," + this.f48123z + ")";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Vec3 m80clone() {
        return new Vec3(this);
    }

    public void setZero() {
        this.f48121x = 0.0f;
        this.f48122y = 0.0f;
        this.f48123z = 0.0f;
    }

    public Vec3(float f16, float f17, float f18) {
        this.f48121x = f16;
        this.f48122y = f17;
        this.f48123z = f18;
    }

    public Vec3 set(float f16, float f17, float f18) {
        this.f48121x = f16;
        this.f48122y = f17;
        this.f48123z = f18;
        return this;
    }

    public Vec3(Vec3 vec3) {
        this.f48121x = vec3.f48121x;
        this.f48122y = vec3.f48122y;
        this.f48123z = vec3.f48123z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vec3 vec3 = (Vec3) obj;
        return Float.floatToIntBits(this.f48121x) == Float.floatToIntBits(vec3.f48121x) && Float.floatToIntBits(this.f48122y) == Float.floatToIntBits(vec3.f48122y) && Float.floatToIntBits(this.f48123z) == Float.floatToIntBits(vec3.f48123z);
    }
}
