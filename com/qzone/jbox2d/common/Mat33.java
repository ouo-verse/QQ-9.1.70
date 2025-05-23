package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Mat33 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Mat33 IDENTITY = new Mat33(new Vec3(1.0f, 0.0f, 0.0f), new Vec3(0.0f, 1.0f, 0.0f), new Vec3(0.0f, 0.0f, 1.0f));
    private static final long serialVersionUID = 2;

    /* renamed from: ex, reason: collision with root package name */
    public final Vec3 f48107ex;

    /* renamed from: ey, reason: collision with root package name */
    public final Vec3 f48108ey;

    /* renamed from: ez, reason: collision with root package name */
    public final Vec3 f48109ez;

    public Mat33() {
        this.f48107ex = new Vec3();
        this.f48108ey = new Vec3();
        this.f48109ez = new Vec3();
    }

    public static Vec3 mul(Mat33 mat33, Vec3 vec3) {
        float f16 = vec3.f48121x;
        Vec3 vec32 = mat33.f48107ex;
        float f17 = vec32.f48121x * f16;
        float f18 = vec3.f48122y;
        Vec3 vec33 = mat33.f48108ey;
        float f19 = f17 + (vec33.f48121x * f18);
        float f26 = vec3.f48123z;
        Vec3 vec34 = mat33.f48109ez;
        return new Vec3(f19 + f26 + vec34.f48121x, (vec32.f48122y * f16) + (vec33.f48122y * f18) + (vec34.f48122y * f26), (f16 * vec32.f48123z) + (f18 * vec33.f48123z) + (f26 * vec34.f48123z));
    }

    public static Vec2 mul22(Mat33 mat33, Vec2 vec2) {
        Vec3 vec3 = mat33.f48107ex;
        float f16 = vec3.f48121x;
        float f17 = vec2.f48119x;
        Vec3 vec32 = mat33.f48108ey;
        float f18 = vec32.f48121x;
        float f19 = vec2.f48120y;
        return new Vec2((f16 * f17) + (f18 * f19), (vec3.f48122y * f17) + (vec32.f48122y * f19));
    }

    public static void mul22ToOut(Mat33 mat33, Vec2 vec2, Vec2 vec22) {
        Vec3 vec3 = mat33.f48107ex;
        float f16 = vec3.f48121x;
        float f17 = vec2.f48119x;
        Vec3 vec32 = mat33.f48108ey;
        float f18 = vec32.f48121x;
        float f19 = vec2.f48120y;
        vec22.f48120y = (vec3.f48122y * f17) + (vec32.f48122y * f19);
        vec22.f48119x = (f16 * f17) + (f18 * f19);
    }

    public static void mul22ToOutUnsafe(Mat33 mat33, Vec2 vec2, Vec2 vec22) {
        Vec3 vec3 = mat33.f48107ex;
        float f16 = vec3.f48122y;
        float f17 = vec2.f48119x;
        Vec3 vec32 = mat33.f48108ey;
        vec22.f48120y = (f16 * f17) + (vec32.f48122y * vec2.f48120y);
        vec22.f48119x = (vec3.f48121x * f17) + (vec32.f48121x * vec2.f48120y);
    }

    public static void mulToOut(Mat33 mat33, Vec3 vec3, Vec3 vec32) {
        float f16 = vec3.f48121x;
        Vec3 vec33 = mat33.f48107ex;
        float f17 = vec33.f48122y * f16;
        float f18 = vec3.f48122y;
        Vec3 vec34 = mat33.f48108ey;
        float f19 = f17 + (vec34.f48122y * f18);
        float f26 = vec3.f48123z;
        Vec3 vec35 = mat33.f48109ez;
        float f27 = f19 + (vec35.f48122y * f26);
        float f28 = (vec33.f48123z * f16) + (vec34.f48123z * f18) + (vec35.f48123z * f26);
        vec32.f48121x = (f16 * vec33.f48121x) + (f18 * vec34.f48121x) + (f26 * vec35.f48121x);
        vec32.f48122y = f27;
        vec32.f48123z = f28;
    }

    public static void mulToOutUnsafe(Mat33 mat33, Vec3 vec3, Vec3 vec32) {
        float f16 = vec3.f48121x;
        Vec3 vec33 = mat33.f48107ex;
        float f17 = f16 * vec33.f48121x;
        float f18 = vec3.f48122y;
        Vec3 vec34 = mat33.f48108ey;
        float f19 = f17 + (vec34.f48121x * f18);
        float f26 = vec3.f48123z;
        Vec3 vec35 = mat33.f48109ez;
        vec32.f48121x = f19 + (vec35.f48121x * f26);
        float f27 = vec3.f48121x;
        vec32.f48122y = (vec33.f48122y * f27) + (f18 * vec34.f48122y) + (vec35.f48122y * f26);
        vec32.f48123z = (f27 * vec33.f48123z) + (vec3.f48122y * vec34.f48123z) + (f26 * vec35.f48123z);
    }

    public static void setScaleTransform(float f16, Mat33 mat33) {
        mat33.f48107ex.f48121x = f16;
        mat33.f48108ey.f48122y = f16;
    }

    public void getInverse22(Mat33 mat33) {
        Vec3 vec3 = this.f48107ex;
        float f16 = vec3.f48121x;
        Vec3 vec32 = this.f48108ey;
        float f17 = vec32.f48121x;
        float f18 = vec3.f48122y;
        float f19 = vec32.f48122y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        Vec3 vec33 = mat33.f48107ex;
        vec33.f48121x = f19 * f26;
        Vec3 vec34 = mat33.f48108ey;
        float f27 = -f26;
        vec34.f48121x = f17 * f27;
        vec33.f48123z = 0.0f;
        vec33.f48122y = f27 * f18;
        vec34.f48122y = f26 * f16;
        vec34.f48123z = 0.0f;
        Vec3 vec35 = mat33.f48109ez;
        vec35.f48121x = 0.0f;
        vec35.f48122y = 0.0f;
        vec35.f48123z = 0.0f;
    }

    public void getSymInverse33(Mat33 mat33) {
        Vec3 vec3 = this.f48108ey;
        float f16 = vec3.f48122y;
        Vec3 vec32 = this.f48109ez;
        float f17 = vec32.f48123z;
        float f18 = vec3.f48123z;
        float f19 = vec32.f48122y;
        float f26 = vec32.f48121x;
        float f27 = vec3.f48121x;
        Vec3 vec33 = this.f48107ex;
        float f28 = vec33.f48121x;
        float f29 = (((f16 * f17) - (f18 * f19)) * f28) + (vec33.f48122y * ((f18 * f26) - (f27 * f17))) + (vec33.f48123z * ((f27 * f19) - (f16 * f26)));
        if (f29 != 0.0f) {
            f29 = 1.0f / f29;
        }
        Vec3 vec34 = mat33.f48107ex;
        vec34.f48121x = ((f16 * f17) - (f19 * f19)) * f29;
        float f36 = ((f26 * f19) - (f27 * f17)) * f29;
        vec34.f48122y = f36;
        vec34.f48123z = ((f27 * f19) - (f26 * f16)) * f29;
        Vec3 vec35 = mat33.f48108ey;
        vec35.f48121x = f36;
        vec35.f48122y = ((f17 * f28) - (f26 * f26)) * f29;
        float f37 = ((f26 * f27) - (f19 * f28)) * f29;
        vec35.f48123z = f37;
        Vec3 vec36 = mat33.f48109ez;
        vec36.f48121x = vec34.f48123z;
        vec36.f48122y = f37;
        vec36.f48123z = f29 * ((f28 * f16) - (f27 * f27));
    }

    public int hashCode() {
        Vec3 vec3 = this.f48107ex;
        int hashCode = ((vec3 == null ? 0 : vec3.hashCode()) + 31) * 31;
        Vec3 vec32 = this.f48108ey;
        int hashCode2 = (hashCode + (vec32 == null ? 0 : vec32.hashCode())) * 31;
        Vec3 vec33 = this.f48109ez;
        return hashCode2 + (vec33 != null ? vec33.hashCode() : 0);
    }

    public void set(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36) {
        Vec3 vec3 = this.f48107ex;
        vec3.f48121x = f16;
        vec3.f48122y = f17;
        vec3.f48123z = f18;
        Vec3 vec32 = this.f48108ey;
        vec32.f48121x = f19;
        vec32.f48122y = f26;
        vec32.f48123z = f27;
        Vec3 vec33 = this.f48109ez;
        vec33.f48121x = f19;
        vec33.f48122y = f26;
        vec33.f48123z = f27;
    }

    public void setIdentity() {
        Vec3 vec3 = this.f48107ex;
        vec3.f48121x = 1.0f;
        vec3.f48122y = 0.0f;
        vec3.f48123z = 0.0f;
        Vec3 vec32 = this.f48108ey;
        vec32.f48121x = 0.0f;
        vec32.f48122y = 1.0f;
        vec32.f48123z = 0.0f;
        Vec3 vec33 = this.f48109ez;
        vec33.f48121x = 0.0f;
        vec33.f48122y = 0.0f;
        vec33.f48123z = 1.0f;
    }

    public void setZero() {
        this.f48107ex.setZero();
        this.f48108ey.setZero();
        this.f48109ez.setZero();
    }

    public final Vec2 solve22(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        solve22ToOut(vec2, vec22);
        return vec22;
    }

    public final void solve22ToOut(Vec2 vec2, Vec2 vec22) {
        Vec3 vec3 = this.f48107ex;
        float f16 = vec3.f48121x;
        Vec3 vec32 = this.f48108ey;
        float f17 = vec32.f48121x;
        float f18 = vec3.f48122y;
        float f19 = vec32.f48122y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        float f27 = f19 * vec2.f48119x;
        float f28 = vec2.f48120y;
        vec22.f48119x = (f27 - (f17 * f28)) * f26;
        vec22.f48120y = f26 * ((f16 * f28) - (f18 * vec2.f48119x));
    }

    public final Vec3 solve33(Vec3 vec3) {
        Vec3 vec32 = new Vec3();
        solve33ToOut(vec3, vec32);
        return vec32;
    }

    public final void solve33ToOut(Vec3 vec3, Vec3 vec32) {
        Vec3.crossToOutUnsafe(this.f48108ey, this.f48109ez, vec32);
        float dot = Vec3.dot(this.f48107ex, vec32);
        if (dot != 0.0f) {
            dot = 1.0f / dot;
        }
        Vec3.crossToOutUnsafe(this.f48108ey, this.f48109ez, vec32);
        float dot2 = Vec3.dot(vec3, vec32) * dot;
        Vec3.crossToOutUnsafe(vec3, this.f48109ez, vec32);
        float dot3 = Vec3.dot(this.f48107ex, vec32) * dot;
        Vec3.crossToOutUnsafe(this.f48108ey, vec3, vec32);
        float dot4 = dot * Vec3.dot(this.f48107ex, vec32);
        vec32.f48121x = dot2;
        vec32.f48122y = dot3;
        vec32.f48123z = dot4;
    }

    public Mat33(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36) {
        this.f48107ex = new Vec3(f16, f17, f18);
        this.f48108ey = new Vec3(f19, f26, f27);
        this.f48109ez = new Vec3(f28, f29, f36);
    }

    public Mat33(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        this.f48107ex = vec3.m80clone();
        this.f48108ey = vec32.m80clone();
        this.f48109ez = vec33.m80clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mat33 mat33 = (Mat33) obj;
        Vec3 vec3 = this.f48107ex;
        if (vec3 == null) {
            if (mat33.f48107ex != null) {
                return false;
            }
        } else if (!vec3.equals(mat33.f48107ex)) {
            return false;
        }
        Vec3 vec32 = this.f48108ey;
        if (vec32 == null) {
            if (mat33.f48108ey != null) {
                return false;
            }
        } else if (!vec32.equals(mat33.f48108ey)) {
            return false;
        }
        Vec3 vec33 = this.f48109ez;
        if (vec33 == null) {
            if (mat33.f48109ez != null) {
                return false;
            }
        } else if (!vec33.equals(mat33.f48109ez)) {
            return false;
        }
        return true;
    }

    public void set(Mat33 mat33) {
        Vec3 vec3 = mat33.f48107ex;
        Vec3 vec32 = this.f48107ex;
        vec32.f48121x = vec3.f48121x;
        vec32.f48122y = vec3.f48122y;
        vec32.f48123z = vec3.f48123z;
        Vec3 vec33 = mat33.f48108ey;
        Vec3 vec34 = this.f48108ey;
        vec34.f48121x = vec33.f48121x;
        vec34.f48122y = vec33.f48122y;
        vec34.f48123z = vec33.f48123z;
        Vec3 vec35 = mat33.f48109ez;
        Vec3 vec36 = this.f48109ez;
        vec36.f48121x = vec35.f48121x;
        vec36.f48122y = vec35.f48122y;
        vec36.f48123z = vec35.f48123z;
    }
}
