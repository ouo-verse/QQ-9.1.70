package com.tencent.mobileqq.shortvideo.dancemachine.utils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class Vec3f {

    /* renamed from: x, reason: collision with root package name */
    public float f287861x;

    /* renamed from: y, reason: collision with root package name */
    public float f287862y;

    /* renamed from: z, reason: collision with root package name */
    public float f287863z;

    public Vec3f() {
    }

    public void add(Vec3f vec3f, Vec3f vec3f2) {
        this.f287861x = vec3f.f287861x + vec3f2.f287861x;
        this.f287862y = vec3f.f287862y + vec3f2.f287862y;
        this.f287863z = vec3f.f287863z + vec3f2.f287863z;
    }

    public void cross(Vec3f vec3f, Vec3f vec3f2) {
        float f16 = vec3f.f287862y;
        float f17 = vec3f2.f287863z;
        float f18 = vec3f.f287863z;
        float f19 = vec3f2.f287862y;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = vec3f2.f287861x;
        float f28 = vec3f.f287861x;
        this.f287863z = (f28 * f19) - (f16 * f27);
        this.f287861x = f26;
        this.f287862y = (f18 * f27) - (f17 * f28);
    }

    public float dot(Vec3f vec3f) {
        return (this.f287861x * vec3f.f287861x) + (this.f287862y * vec3f.f287862y) + (this.f287863z * vec3f.f287863z);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vec3f)) {
            return false;
        }
        Vec3f vec3f = (Vec3f) obj;
        if (this.f287861x == vec3f.f287861x && this.f287862y == vec3f.f287862y && this.f287863z == vec3f.f287863z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((217 + Float.floatToIntBits(this.f287861x)) * 31) + Float.floatToIntBits(this.f287862y)) * 31) + Float.floatToIntBits(this.f287863z);
    }

    public float length() {
        float f16 = this.f287861x;
        float f17 = this.f287862y;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.f287863z;
        return (float) Math.sqrt(f18 + (f19 * f19));
    }

    public final void mul(float f16) {
        this.f287861x *= f16;
        this.f287862y *= f16;
        this.f287863z *= f16;
    }

    public void normalize() {
        float length = 1.0f / length();
        this.f287861x *= length;
        this.f287862y *= length;
        this.f287863z *= length;
    }

    public void set(Vec3f vec3f) {
        this.f287861x = vec3f.f287861x;
        this.f287862y = vec3f.f287862y;
        this.f287863z = vec3f.f287863z;
    }

    public void sub(Vec3f vec3f, Vec3f vec3f2) {
        this.f287861x = vec3f.f287861x - vec3f2.f287861x;
        this.f287862y = vec3f.f287862y - vec3f2.f287862y;
        this.f287863z = vec3f.f287863z - vec3f2.f287863z;
    }

    public String toString() {
        return "Vec3f[" + this.f287861x + ", " + this.f287862y + ", " + this.f287863z + "]";
    }

    public Vec3f(float f16, float f17, float f18) {
        this.f287861x = f16;
        this.f287862y = f17;
        this.f287863z = f18;
    }

    public void add(Vec3f vec3f) {
        this.f287861x += vec3f.f287861x;
        this.f287862y += vec3f.f287862y;
        this.f287863z += vec3f.f287863z;
    }

    public void set(float f16, float f17, float f18) {
        this.f287861x = f16;
        this.f287862y = f17;
        this.f287863z = f18;
    }

    public void sub(Vec3f vec3f) {
        this.f287861x -= vec3f.f287861x;
        this.f287862y -= vec3f.f287862y;
        this.f287863z -= vec3f.f287863z;
    }

    public Vec3f(Vec3f vec3f) {
        this.f287861x = vec3f.f287861x;
        this.f287862y = vec3f.f287862y;
        this.f287863z = vec3f.f287863z;
    }
}
