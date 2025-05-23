package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Mat33 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Mat33 IDENTITY = new Mat33(new Vec3(1.0f, 0.0f, 0.0f), new Vec3(0.0f, 1.0f, 0.0f), new Vec3(0.0f, 0.0f, 1.0f));
    private static final long serialVersionUID = 2;

    /* renamed from: ex, reason: collision with root package name */
    public final Vec3 f423638ex;

    /* renamed from: ey, reason: collision with root package name */
    public final Vec3 f423639ey;

    /* renamed from: ez, reason: collision with root package name */
    public final Vec3 f423640ez;

    public Mat33() {
        this.f423638ex = new Vec3();
        this.f423639ey = new Vec3();
        this.f423640ez = new Vec3();
    }

    public static final Vec3 mul(Mat33 mat33, Vec3 vec3) {
        float f16 = vec3.f423651x;
        Vec3 vec32 = mat33.f423638ex;
        float f17 = vec32.f423651x * f16;
        float f18 = vec3.f423652y;
        Vec3 vec33 = mat33.f423639ey;
        float f19 = f17 + (vec33.f423651x * f18);
        float f26 = vec3.f423653z;
        Vec3 vec34 = mat33.f423640ez;
        return new Vec3(f19 + f26 + vec34.f423651x, (vec32.f423652y * f16) + (vec33.f423652y * f18) + (vec34.f423652y * f26), (f16 * vec32.f423653z) + (f18 * vec33.f423653z) + (f26 * vec34.f423653z));
    }

    public static final Vec2 mul22(Mat33 mat33, Vec2 vec2) {
        Vec3 vec3 = mat33.f423638ex;
        float f16 = vec3.f423651x;
        float f17 = vec2.f423649x;
        Vec3 vec32 = mat33.f423639ey;
        float f18 = vec32.f423651x;
        float f19 = vec2.f423650y;
        return new Vec2((f16 * f17) + (f18 * f19), (vec3.f423652y * f17) + (vec32.f423652y * f19));
    }

    public static final void mul22ToOut(Mat33 mat33, Vec2 vec2, Vec2 vec22) {
        Vec3 vec3 = mat33.f423638ex;
        float f16 = vec3.f423651x;
        float f17 = vec2.f423649x;
        Vec3 vec32 = mat33.f423639ey;
        float f18 = vec32.f423651x;
        float f19 = vec2.f423650y;
        vec22.f423650y = (vec3.f423652y * f17) + (vec32.f423652y * f19);
        vec22.f423649x = (f16 * f17) + (f18 * f19);
    }

    public static final void mul22ToOutUnsafe(Mat33 mat33, Vec2 vec2, Vec2 vec22) {
        Vec3 vec3 = mat33.f423638ex;
        float f16 = vec3.f423652y;
        float f17 = vec2.f423649x;
        Vec3 vec32 = mat33.f423639ey;
        vec22.f423650y = (f16 * f17) + (vec32.f423652y * vec2.f423650y);
        vec22.f423649x = (vec3.f423651x * f17) + (vec32.f423651x * vec2.f423650y);
    }

    public static final void mulToOut(Mat33 mat33, Vec3 vec3, Vec3 vec32) {
        float f16 = vec3.f423651x;
        Vec3 vec33 = mat33.f423638ex;
        float f17 = vec33.f423652y * f16;
        float f18 = vec3.f423652y;
        Vec3 vec34 = mat33.f423639ey;
        float f19 = f17 + (vec34.f423652y * f18);
        float f26 = vec3.f423653z;
        Vec3 vec35 = mat33.f423640ez;
        float f27 = f19 + (vec35.f423652y * f26);
        float f28 = (vec33.f423653z * f16) + (vec34.f423653z * f18) + (vec35.f423653z * f26);
        vec32.f423651x = (f16 * vec33.f423651x) + (f18 * vec34.f423651x) + (f26 * vec35.f423651x);
        vec32.f423652y = f27;
        vec32.f423653z = f28;
    }

    public static final void mulToOutUnsafe(Mat33 mat33, Vec3 vec3, Vec3 vec32) {
        float f16 = vec3.f423651x;
        Vec3 vec33 = mat33.f423638ex;
        float f17 = f16 * vec33.f423651x;
        float f18 = vec3.f423652y;
        Vec3 vec34 = mat33.f423639ey;
        float f19 = f17 + (vec34.f423651x * f18);
        float f26 = vec3.f423653z;
        Vec3 vec35 = mat33.f423640ez;
        vec32.f423651x = f19 + (vec35.f423651x * f26);
        float f27 = vec3.f423651x;
        vec32.f423652y = (vec33.f423652y * f27) + (f18 * vec34.f423652y) + (vec35.f423652y * f26);
        vec32.f423653z = (f27 * vec33.f423653z) + (vec3.f423652y * vec34.f423653z) + (f26 * vec35.f423653z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mat33 mat33 = (Mat33) obj;
        Vec3 vec3 = this.f423638ex;
        if (vec3 == null) {
            if (mat33.f423638ex != null) {
                return false;
            }
        } else if (!vec3.equals(mat33.f423638ex)) {
            return false;
        }
        Vec3 vec32 = this.f423639ey;
        if (vec32 == null) {
            if (mat33.f423639ey != null) {
                return false;
            }
        } else if (!vec32.equals(mat33.f423639ey)) {
            return false;
        }
        Vec3 vec33 = this.f423640ez;
        if (vec33 == null) {
            if (mat33.f423640ez != null) {
                return false;
            }
        } else if (!vec33.equals(mat33.f423640ez)) {
            return false;
        }
        return true;
    }

    public void getInverse22(Mat33 mat33) {
        Vec3 vec3 = this.f423638ex;
        float f16 = vec3.f423651x;
        Vec3 vec32 = this.f423639ey;
        float f17 = vec32.f423651x;
        float f18 = vec3.f423652y;
        float f19 = vec32.f423652y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        Vec3 vec33 = mat33.f423638ex;
        vec33.f423651x = f19 * f26;
        Vec3 vec34 = mat33.f423639ey;
        float f27 = -f26;
        vec34.f423651x = f17 * f27;
        vec33.f423653z = 0.0f;
        vec33.f423652y = f27 * f18;
        vec34.f423652y = f26 * f16;
        vec34.f423653z = 0.0f;
        Vec3 vec35 = mat33.f423640ez;
        vec35.f423651x = 0.0f;
        vec35.f423652y = 0.0f;
        vec35.f423653z = 0.0f;
    }

    public void getSymInverse33(Mat33 mat33) {
        Vec3 vec3 = this.f423639ey;
        float f16 = vec3.f423652y;
        Vec3 vec32 = this.f423640ez;
        float f17 = vec32.f423653z;
        float f18 = vec3.f423653z;
        float f19 = vec32.f423652y;
        float f26 = vec32.f423651x;
        float f27 = vec3.f423651x;
        Vec3 vec33 = this.f423638ex;
        float f28 = vec33.f423651x;
        float f29 = (((f16 * f17) - (f18 * f19)) * f28) + (vec33.f423652y * ((f18 * f26) - (f27 * f17))) + (vec33.f423653z * ((f27 * f19) - (f16 * f26)));
        if (f29 != 0.0f) {
            f29 = 1.0f / f29;
        }
        Vec3 vec34 = mat33.f423638ex;
        vec34.f423651x = ((f16 * f17) - (f19 * f19)) * f29;
        float f36 = ((f26 * f19) - (f27 * f17)) * f29;
        vec34.f423652y = f36;
        vec34.f423653z = ((f27 * f19) - (f26 * f16)) * f29;
        Vec3 vec35 = mat33.f423639ey;
        vec35.f423651x = f36;
        vec35.f423652y = ((f17 * f28) - (f26 * f26)) * f29;
        float f37 = ((f26 * f27) - (f19 * f28)) * f29;
        vec35.f423653z = f37;
        Vec3 vec36 = mat33.f423640ez;
        vec36.f423651x = vec34.f423653z;
        vec36.f423652y = f37;
        vec36.f423653z = f29 * ((f28 * f16) - (f27 * f27));
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Vec3 vec3 = this.f423638ex;
        int i3 = 0;
        if (vec3 == null) {
            hashCode = 0;
        } else {
            hashCode = vec3.hashCode();
        }
        int i16 = (hashCode + 31) * 31;
        Vec3 vec32 = this.f423639ey;
        if (vec32 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = vec32.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Vec3 vec33 = this.f423640ez;
        if (vec33 != null) {
            i3 = vec33.hashCode();
        }
        return i17 + i3;
    }

    public void setZero() {
        this.f423638ex.setZero();
        this.f423639ey.setZero();
        this.f423640ez.setZero();
    }

    public final Vec2 solve22(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        solve22ToOut(vec2, vec22);
        return vec22;
    }

    public final void solve22ToOut(Vec2 vec2, Vec2 vec22) {
        Vec3 vec3 = this.f423638ex;
        float f16 = vec3.f423651x;
        Vec3 vec32 = this.f423639ey;
        float f17 = vec32.f423651x;
        float f18 = vec3.f423652y;
        float f19 = vec32.f423652y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        float f27 = f19 * vec2.f423649x;
        float f28 = vec2.f423650y;
        vec22.f423649x = (f27 - (f17 * f28)) * f26;
        vec22.f423650y = f26 * ((f16 * f28) - (f18 * vec2.f423649x));
    }

    public final Vec3 solve33(Vec3 vec3) {
        Vec3 vec32 = new Vec3();
        solve33ToOut(vec3, vec32);
        return vec32;
    }

    public final void solve33ToOut(Vec3 vec3, Vec3 vec32) {
        Vec3.crossToOutUnsafe(this.f423639ey, this.f423640ez, vec32);
        float dot = Vec3.dot(this.f423638ex, vec32);
        if (dot != 0.0f) {
            dot = 1.0f / dot;
        }
        Vec3.crossToOutUnsafe(this.f423639ey, this.f423640ez, vec32);
        float dot2 = Vec3.dot(vec3, vec32) * dot;
        Vec3.crossToOutUnsafe(vec3, this.f423640ez, vec32);
        float dot3 = Vec3.dot(this.f423638ex, vec32) * dot;
        Vec3.crossToOutUnsafe(this.f423639ey, vec3, vec32);
        float dot4 = dot * Vec3.dot(this.f423638ex, vec32);
        vec32.f423651x = dot2;
        vec32.f423652y = dot3;
        vec32.f423653z = dot4;
    }

    public Mat33(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        this.f423638ex = vec3.clone();
        this.f423639ey = vec32.clone();
        this.f423640ez = vec33.clone();
    }
}
