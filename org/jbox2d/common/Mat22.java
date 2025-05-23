package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Mat22 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2;

    /* renamed from: ex, reason: collision with root package name */
    public final Vec2 f423636ex;

    /* renamed from: ey, reason: collision with root package name */
    public final Vec2 f423637ey;

    public Mat22() {
        this.f423636ex = new Vec2();
        this.f423637ey = new Vec2();
    }

    public static void absToOut(Mat22 mat22, Mat22 mat222) {
        mat222.f423636ex.f423649x = MathUtils.abs(mat22.f423636ex.f423649x);
        mat222.f423636ex.f423650y = MathUtils.abs(mat22.f423636ex.f423650y);
        mat222.f423637ey.f423649x = MathUtils.abs(mat22.f423637ey.f423649x);
        mat222.f423637ey.f423650y = MathUtils.abs(mat22.f423637ey.f423650y);
    }

    public static final Mat22 createRotationalTransform(float f16) {
        Mat22 mat22 = new Mat22();
        float cos = MathUtils.cos(f16);
        float sin = MathUtils.sin(f16);
        Vec2 vec2 = mat22.f423636ex;
        vec2.f423649x = cos;
        Vec2 vec22 = mat22.f423637ey;
        vec22.f423649x = -sin;
        vec2.f423650y = sin;
        vec22.f423650y = cos;
        return mat22;
    }

    public static final Mat22 createScaleTransform(float f16) {
        Mat22 mat22 = new Mat22();
        mat22.f423636ex.f423649x = f16;
        mat22.f423637ey.f423650y = f16;
        return mat22;
    }

    public final Mat22 abs() {
        return new Mat22(MathUtils.abs(this.f423636ex.f423649x), MathUtils.abs(this.f423637ey.f423649x), MathUtils.abs(this.f423636ex.f423650y), MathUtils.abs(this.f423637ey.f423650y));
    }

    public final void absLocal() {
        this.f423636ex.absLocal();
        this.f423637ey.absLocal();
    }

    public final Mat22 add(Mat22 mat22) {
        Mat22 mat222 = new Mat22();
        Vec2 vec2 = mat222.f423636ex;
        Vec2 vec22 = this.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat22.f423636ex;
        vec2.f423649x = f16 + vec23.f423649x;
        vec2.f423650y = vec22.f423650y + vec23.f423650y;
        Vec2 vec24 = mat222.f423637ey;
        Vec2 vec25 = this.f423637ey;
        float f17 = vec25.f423649x;
        Vec2 vec26 = mat22.f423637ey;
        vec24.f423649x = f17 + vec26.f423649x;
        vec24.f423650y = vec25.f423650y + vec26.f423650y;
        return mat222;
    }

    public final Mat22 addLocal(Mat22 mat22) {
        Vec2 vec2 = this.f423636ex;
        float f16 = vec2.f423649x;
        Vec2 vec22 = mat22.f423636ex;
        vec2.f423649x = f16 + vec22.f423649x;
        vec2.f423650y += vec22.f423650y;
        Vec2 vec23 = this.f423637ey;
        float f17 = vec23.f423649x;
        Vec2 vec24 = mat22.f423637ey;
        vec23.f423649x = f17 + vec24.f423649x;
        vec23.f423650y += vec24.f423650y;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mat22 mat22 = (Mat22) obj;
        Vec2 vec2 = this.f423636ex;
        if (vec2 == null) {
            if (mat22.f423636ex != null) {
                return false;
            }
        } else if (!vec2.equals(mat22.f423636ex)) {
            return false;
        }
        Vec2 vec22 = this.f423637ey;
        if (vec22 == null) {
            if (mat22.f423637ey != null) {
                return false;
            }
        } else if (!vec22.equals(mat22.f423637ey)) {
            return false;
        }
        return true;
    }

    public final float getAngle() {
        Vec2 vec2 = this.f423636ex;
        return MathUtils.atan2(vec2.f423650y, vec2.f423649x);
    }

    public int hashCode() {
        int hashCode;
        Vec2 vec2 = this.f423636ex;
        int i3 = 0;
        if (vec2 == null) {
            hashCode = 0;
        } else {
            hashCode = vec2.hashCode();
        }
        int i16 = (hashCode + 31) * 31;
        Vec2 vec22 = this.f423637ey;
        if (vec22 != null) {
            i3 = vec22.hashCode();
        }
        return i16 + i3;
    }

    public final Mat22 invert() {
        Vec2 vec2 = this.f423636ex;
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.f423637ey;
        float f17 = vec22.f423649x;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        Mat22 mat22 = new Mat22();
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        Vec2 vec23 = mat22.f423636ex;
        vec23.f423649x = f19 * f26;
        Vec2 vec24 = mat22.f423637ey;
        float f27 = -f26;
        vec24.f423649x = f17 * f27;
        vec23.f423650y = f27 * f18;
        vec24.f423650y = f26 * f16;
        return mat22;
    }

    public final Mat22 invertLocal() {
        Vec2 vec2 = this.f423636ex;
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.f423637ey;
        float f17 = vec22.f423649x;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        vec2.f423649x = f19 * f26;
        float f27 = -f26;
        vec22.f423649x = f17 * f27;
        vec2.f423650y = f27 * f18;
        vec22.f423650y = f26 * f16;
        return this;
    }

    public final void invertToOut(Mat22 mat22) {
        Vec2 vec2 = this.f423636ex;
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.f423637ey;
        float f17 = vec22.f423649x;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        float f26 = 1.0f / ((f16 * f19) - (f17 * f18));
        Vec2 vec23 = mat22.f423636ex;
        vec23.f423649x = f19 * f26;
        Vec2 vec24 = mat22.f423637ey;
        float f27 = -f26;
        vec24.f423649x = f17 * f27;
        vec23.f423650y = f27 * f18;
        vec24.f423650y = f26 * f16;
    }

    public final Vec2 mul(Vec2 vec2) {
        Vec2 vec22 = this.f423636ex;
        float f16 = vec22.f423649x;
        float f17 = vec2.f423649x;
        Vec2 vec23 = this.f423637ey;
        float f18 = vec23.f423649x;
        float f19 = vec2.f423650y;
        return new Vec2((f16 * f17) + (f18 * f19), (vec22.f423650y * f17) + (vec23.f423650y * f19));
    }

    public final Mat22 mulLocal(Mat22 mat22) {
        mulToOut(mat22, this);
        return this;
    }

    public final void mulToOut(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f423636ex;
        float f16 = vec23.f423650y;
        float f17 = vec2.f423649x;
        Vec2 vec24 = this.f423637ey;
        float f18 = vec24.f423650y;
        float f19 = vec2.f423650y;
        vec22.f423649x = (vec23.f423649x * f17) + (vec24.f423649x * f19);
        vec22.f423650y = (f16 * f17) + (f18 * f19);
    }

    public final void mulToOutUnsafe(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f423636ex;
        float f16 = vec23.f423649x * vec2.f423649x;
        Vec2 vec24 = this.f423637ey;
        float f17 = vec24.f423649x;
        float f18 = vec2.f423650y;
        vec22.f423649x = f16 + (f17 * f18);
        vec22.f423650y = (vec23.f423650y * vec2.f423649x) + (vec24.f423650y * f18);
    }

    public final Mat22 mulTrans(Mat22 mat22) {
        Mat22 mat222 = new Mat22();
        mat222.f423636ex.f423649x = Vec2.dot(this.f423636ex, mat22.f423636ex);
        mat222.f423636ex.f423650y = Vec2.dot(this.f423637ey, mat22.f423636ex);
        mat222.f423637ey.f423649x = Vec2.dot(this.f423636ex, mat22.f423637ey);
        mat222.f423637ey.f423650y = Vec2.dot(this.f423637ey, mat22.f423637ey);
        return mat222;
    }

    public final Mat22 mulTransLocal(Mat22 mat22) {
        mulTransToOut(mat22, this);
        return this;
    }

    public final void mulTransToOut(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = this.f423636ex;
        float f16 = vec2.f423649x;
        Vec2 vec22 = mat22.f423636ex;
        float f17 = vec22.f423649x;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        float f26 = (f16 * f17) + (f18 * f19);
        Vec2 vec23 = this.f423637ey;
        float f27 = vec23.f423649x;
        float f28 = vec23.f423650y;
        float f29 = (f17 * f27) + (f19 * f28);
        Vec2 vec24 = mat22.f423637ey;
        float f36 = vec24.f423649x;
        float f37 = vec24.f423650y;
        float f38 = (f16 * f36) + (f18 * f37);
        float f39 = (f27 * f36) + (f28 * f37);
        Vec2 vec25 = mat222.f423636ex;
        vec25.f423649x = f26;
        Vec2 vec26 = mat222.f423637ey;
        vec26.f423649x = f38;
        vec25.f423650y = f29;
        vec26.f423650y = f39;
    }

    public final void mulTransToOutUnsafe(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = mat222.f423636ex;
        Vec2 vec22 = this.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat22.f423636ex;
        float f17 = f16 * vec23.f423649x;
        float f18 = vec22.f423650y;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        Vec2 vec24 = mat222.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec25 = mat22.f423637ey;
        vec24.f423649x = (f26 * vec25.f423649x) + (f18 * vec25.f423650y);
        Vec2 vec26 = this.f423637ey;
        float f27 = vec26.f423649x;
        vec2.f423650y = (vec23.f423649x * f27) + (vec26.f423650y * f19);
        vec24.f423650y = (f27 * vec25.f423649x) + (vec26.f423650y * vec25.f423650y);
    }

    public final Mat22 set(Mat22 mat22) {
        Vec2 vec2 = this.f423636ex;
        Vec2 vec22 = mat22.f423636ex;
        vec2.f423649x = vec22.f423649x;
        vec2.f423650y = vec22.f423650y;
        Vec2 vec23 = this.f423637ey;
        Vec2 vec24 = mat22.f423637ey;
        vec23.f423649x = vec24.f423649x;
        vec23.f423650y = vec24.f423650y;
        return this;
    }

    public final void setIdentity() {
        Vec2 vec2 = this.f423636ex;
        vec2.f423649x = 1.0f;
        Vec2 vec22 = this.f423637ey;
        vec22.f423649x = 0.0f;
        vec2.f423650y = 0.0f;
        vec22.f423650y = 1.0f;
    }

    public final void setZero() {
        Vec2 vec2 = this.f423636ex;
        vec2.f423649x = 0.0f;
        Vec2 vec22 = this.f423637ey;
        vec22.f423649x = 0.0f;
        vec2.f423650y = 0.0f;
        vec22.f423650y = 0.0f;
    }

    public final Vec2 solve(Vec2 vec2) {
        Vec2 vec22 = this.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = this.f423637ey;
        float f17 = vec23.f423649x;
        float f18 = vec22.f423650y;
        float f19 = vec23.f423650y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        float f27 = vec2.f423649x;
        float f28 = vec2.f423650y;
        return new Vec2(((f19 * f27) - (f17 * f28)) * f26, f26 * ((f16 * f28) - (f18 * f27)));
    }

    public final void solveToOut(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f423636ex;
        float f16 = vec23.f423649x;
        Vec2 vec24 = this.f423637ey;
        float f17 = vec24.f423649x;
        float f18 = vec23.f423650y;
        float f19 = vec24.f423650y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        float f27 = vec2.f423650y;
        float f28 = vec2.f423649x;
        vec22.f423649x = f26 * ((f19 * f28) - (f17 * f27));
        vec22.f423650y = ((f16 * f27) - (f18 * f28)) * f26;
    }

    public String toString() {
        return ("[" + this.f423636ex.f423649x + "," + this.f423637ey.f423649x + "]\n") + "[" + this.f423636ex.f423650y + "," + this.f423637ey.f423650y + "]";
    }

    public static final Mat22 abs(Mat22 mat22) {
        return mat22.abs();
    }

    public final Mat22 clone() {
        return new Mat22(this.f423636ex, this.f423637ey);
    }

    public final Mat22 mul(Mat22 mat22) {
        Mat22 mat222 = new Mat22();
        Vec2 vec2 = mat222.f423636ex;
        Vec2 vec22 = this.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat22.f423636ex;
        float f17 = f16 * vec23.f423649x;
        Vec2 vec24 = this.f423637ey;
        float f18 = vec24.f423649x;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        vec2.f423650y = (vec22.f423650y * vec23.f423649x) + (vec24.f423650y * f19);
        Vec2 vec25 = mat222.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec26 = mat22.f423637ey;
        float f27 = f26 * vec26.f423649x;
        float f28 = vec24.f423649x;
        float f29 = vec26.f423650y;
        vec25.f423649x = f27 + (f28 * f29);
        vec25.f423650y = (vec22.f423650y * vec26.f423649x) + (vec24.f423650y * f29);
        return mat222;
    }

    public final void mulToOutUnsafe(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = mat222.f423636ex;
        Vec2 vec22 = this.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat22.f423636ex;
        float f17 = f16 * vec23.f423649x;
        Vec2 vec24 = this.f423637ey;
        float f18 = vec24.f423649x;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        vec2.f423650y = (vec22.f423650y * vec23.f423649x) + (vec24.f423650y * f19);
        Vec2 vec25 = mat222.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec26 = mat22.f423637ey;
        float f27 = f26 * vec26.f423649x;
        float f28 = vec24.f423649x;
        float f29 = vec26.f423650y;
        vec25.f423649x = f27 + (f28 * f29);
        vec25.f423650y = (vec22.f423650y * vec26.f423649x) + (vec24.f423650y * f29);
    }

    public Mat22(Vec2 vec2, Vec2 vec22) {
        this.f423636ex = vec2.clone();
        this.f423637ey = vec22.clone();
    }

    public static final void createScaleTransform(float f16, Mat22 mat22) {
        mat22.f423636ex.f423649x = f16;
        mat22.f423637ey.f423650y = f16;
    }

    public final void mulToOut(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = this.f423636ex;
        float f16 = vec2.f423650y;
        Vec2 vec22 = mat22.f423636ex;
        float f17 = vec22.f423649x;
        Vec2 vec23 = this.f423637ey;
        float f18 = vec23.f423650y;
        float f19 = vec22.f423650y;
        float f26 = (f16 * f17) + (f18 * f19);
        float f27 = (vec2.f423649x * f17) + (vec23.f423649x * f19);
        Vec2 vec24 = mat222.f423636ex;
        vec24.f423649x = f27;
        vec24.f423650y = f26;
        float f28 = vec2.f423650y;
        Vec2 vec25 = mat22.f423637ey;
        float f29 = vec25.f423649x;
        float f36 = vec23.f423650y;
        float f37 = vec25.f423650y;
        float f38 = (f28 * f29) + (f36 * f37);
        float f39 = (vec2.f423649x * f29) + (vec23.f423649x * f37);
        Vec2 vec26 = mat222.f423637ey;
        vec26.f423649x = f39;
        vec26.f423650y = f38;
    }

    public static final void mulTransToOutUnsafe(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        Vec2 vec23 = mat22.f423637ey;
        vec22.f423650y = (vec23.f423649x * f16) + (vec2.f423650y * vec23.f423650y);
        Vec2 vec24 = mat22.f423636ex;
        vec22.f423649x = (f16 * vec24.f423649x) + (vec2.f423650y * vec24.f423650y);
    }

    public final Mat22 set(float f16, float f17, float f18, float f19) {
        Vec2 vec2 = this.f423636ex;
        vec2.f423649x = f16;
        vec2.f423650y = f18;
        Vec2 vec22 = this.f423637ey;
        vec22.f423649x = f17;
        vec22.f423650y = f19;
        return this;
    }

    public final Vec2 mulTrans(Vec2 vec2) {
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.f423636ex;
        float f17 = vec22.f423649x * f16;
        float f18 = vec2.f423650y;
        float f19 = f17 + (vec22.f423650y * f18);
        Vec2 vec23 = this.f423637ey;
        return new Vec2(f19, (f16 * vec23.f423649x) + (f18 * vec23.f423650y));
    }

    public Mat22(float f16, float f17, float f18, float f19) {
        this.f423636ex = new Vec2(f16, f18);
        this.f423637ey = new Vec2(f17, f19);
    }

    public static final Vec2 mul(Mat22 mat22, Vec2 vec2) {
        Vec2 vec22 = mat22.f423636ex;
        float f16 = vec22.f423649x;
        float f17 = vec2.f423649x;
        Vec2 vec23 = mat22.f423637ey;
        float f18 = vec23.f423649x;
        float f19 = vec2.f423650y;
        return new Vec2((f16 * f17) + (f18 * f19), (vec22.f423650y * f17) + (vec23.f423650y * f19));
    }

    public static final void mulToOutUnsafe(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = mat22.f423636ex;
        float f16 = vec23.f423649x * vec2.f423649x;
        Vec2 vec24 = mat22.f423637ey;
        float f17 = vec24.f423649x;
        float f18 = vec2.f423650y;
        vec22.f423649x = f16 + (f17 * f18);
        vec22.f423650y = (vec23.f423650y * vec2.f423649x) + (vec24.f423650y * f18);
    }

    public static final Vec2 mulTrans(Mat22 mat22, Vec2 vec2) {
        float f16 = vec2.f423649x;
        Vec2 vec22 = mat22.f423636ex;
        float f17 = vec22.f423649x * f16;
        float f18 = vec2.f423650y;
        float f19 = f17 + (vec22.f423650y * f18);
        Vec2 vec23 = mat22.f423637ey;
        return new Vec2(f19, (f16 * vec23.f423649x) + (f18 * vec23.f423650y));
    }

    public static final void mulTransToOutUnsafe(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat223.f423636ex;
        Vec2 vec22 = mat22.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat222.f423636ex;
        float f17 = f16 * vec23.f423649x;
        float f18 = vec22.f423650y;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        Vec2 vec24 = mat22.f423637ey;
        vec2.f423650y = (vec24.f423649x * vec23.f423649x) + (vec24.f423650y * f19);
        Vec2 vec25 = mat223.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec26 = mat222.f423637ey;
        float f27 = f26 * vec26.f423649x;
        float f28 = vec22.f423650y;
        float f29 = vec26.f423650y;
        vec25.f423649x = f27 + (f28 * f29);
        vec25.f423650y = (vec24.f423649x * vec26.f423649x) + (vec24.f423650y * f29);
    }

    public static final void createRotationalTransform(float f16, Mat22 mat22) {
        float cos = MathUtils.cos(f16);
        float sin = MathUtils.sin(f16);
        Vec2 vec2 = mat22.f423636ex;
        vec2.f423649x = cos;
        Vec2 vec22 = mat22.f423637ey;
        vec22.f423649x = -sin;
        vec2.f423650y = sin;
        vec22.f423650y = cos;
    }

    public static final Mat22 mul(Mat22 mat22, Mat22 mat222) {
        Mat22 mat223 = new Mat22();
        Vec2 vec2 = mat223.f423636ex;
        Vec2 vec22 = mat22.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat222.f423636ex;
        float f17 = f16 * vec23.f423649x;
        Vec2 vec24 = mat22.f423637ey;
        float f18 = vec24.f423649x;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        vec2.f423650y = (vec22.f423650y * vec23.f423649x) + (vec24.f423650y * f19);
        Vec2 vec25 = mat223.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec26 = mat222.f423637ey;
        float f27 = f26 * vec26.f423649x;
        float f28 = vec24.f423649x;
        float f29 = vec26.f423650y;
        vec25.f423649x = f27 + (f28 * f29);
        vec25.f423650y = (vec22.f423650y * vec26.f423649x) + (vec24.f423650y * f29);
        return mat223;
    }

    public static final Mat22 mulTrans(Mat22 mat22, Mat22 mat222) {
        Mat22 mat223 = new Mat22();
        Vec2 vec2 = mat223.f423636ex;
        Vec2 vec22 = mat22.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat222.f423636ex;
        float f17 = f16 * vec23.f423649x;
        float f18 = vec22.f423650y;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        Vec2 vec24 = mat22.f423637ey;
        vec2.f423650y = (vec24.f423649x * vec23.f423649x) + (vec24.f423650y * f19);
        Vec2 vec25 = mat223.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec26 = mat222.f423637ey;
        float f27 = f26 * vec26.f423649x;
        float f28 = vec22.f423650y;
        float f29 = vec26.f423650y;
        vec25.f423649x = f27 + (f28 * f29);
        vec25.f423650y = (vec24.f423649x * vec26.f423649x) + (vec24.f423650y * f29);
        return mat223;
    }

    public final void mulTransToOut(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        Vec2 vec23 = this.f423636ex;
        float f17 = vec23.f423649x * f16;
        float f18 = vec2.f423650y;
        float f19 = f17 + (vec23.f423650y * f18);
        Vec2 vec24 = this.f423637ey;
        vec22.f423650y = (f16 * vec24.f423649x) + (f18 * vec24.f423650y);
        vec22.f423649x = f19;
    }

    public static final void mulToOutUnsafe(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat223.f423636ex;
        Vec2 vec22 = mat22.f423636ex;
        float f16 = vec22.f423649x;
        Vec2 vec23 = mat222.f423636ex;
        float f17 = f16 * vec23.f423649x;
        Vec2 vec24 = mat22.f423637ey;
        float f18 = vec24.f423649x;
        float f19 = vec23.f423650y;
        vec2.f423649x = f17 + (f18 * f19);
        vec2.f423650y = (vec22.f423650y * vec23.f423649x) + (vec24.f423650y * f19);
        Vec2 vec25 = mat223.f423637ey;
        float f26 = vec22.f423649x;
        Vec2 vec26 = mat222.f423637ey;
        float f27 = f26 * vec26.f423649x;
        float f28 = vec24.f423649x;
        float f29 = vec26.f423650y;
        vec25.f423649x = f27 + (f28 * f29);
        vec25.f423650y = (vec22.f423650y * vec26.f423649x) + (vec24.f423650y * f29);
    }

    public final void set(float f16) {
        float cos = MathUtils.cos(f16);
        float sin = MathUtils.sin(f16);
        Vec2 vec2 = this.f423636ex;
        vec2.f423649x = cos;
        Vec2 vec22 = this.f423637ey;
        vec22.f423649x = -sin;
        vec2.f423650y = sin;
        vec22.f423650y = cos;
    }

    public static final void mulTransToOut(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        Vec2 vec23 = mat22.f423636ex;
        float f17 = vec23.f423649x * f16;
        float f18 = vec2.f423650y;
        float f19 = f17 + (vec23.f423650y * f18);
        Vec2 vec24 = mat22.f423637ey;
        vec22.f423650y = (f16 * vec24.f423649x) + (f18 * vec24.f423650y);
        vec22.f423649x = f19;
    }

    public static final void mulToOut(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = mat22.f423636ex;
        float f16 = vec23.f423650y;
        float f17 = vec2.f423649x;
        Vec2 vec24 = mat22.f423637ey;
        float f18 = vec24.f423650y;
        float f19 = vec2.f423650y;
        vec22.f423649x = (vec23.f423649x * f17) + (vec24.f423649x * f19);
        vec22.f423650y = (f16 * f17) + (f18 * f19);
    }

    public static final void mulTransToOut(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat22.f423636ex;
        float f16 = vec2.f423649x;
        Vec2 vec22 = mat222.f423636ex;
        float f17 = vec22.f423649x;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        float f26 = (f16 * f17) + (f18 * f19);
        Vec2 vec23 = mat22.f423637ey;
        float f27 = vec23.f423649x;
        float f28 = vec23.f423650y;
        float f29 = (f17 * f27) + (f19 * f28);
        Vec2 vec24 = mat222.f423637ey;
        float f36 = vec24.f423649x;
        float f37 = vec24.f423650y;
        float f38 = (f27 * f36) + (f28 * f37);
        Vec2 vec25 = mat223.f423636ex;
        vec25.f423649x = f26;
        vec25.f423650y = f29;
        Vec2 vec26 = mat223.f423637ey;
        vec26.f423649x = (f16 * f36) + (f18 * f37);
        vec26.f423650y = f38;
    }

    public final void set(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f423636ex;
        vec23.f423649x = vec2.f423649x;
        Vec2 vec24 = this.f423637ey;
        vec24.f423649x = vec22.f423649x;
        vec23.f423650y = vec2.f423650y;
        vec24.f423650y = vec22.f423650y;
    }

    public static final void mulToOut(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat22.f423636ex;
        float f16 = vec2.f423650y;
        Vec2 vec22 = mat222.f423636ex;
        float f17 = vec22.f423649x;
        Vec2 vec23 = mat22.f423637ey;
        float f18 = vec23.f423650y;
        float f19 = vec22.f423650y;
        float f26 = (f16 * f17) + (f18 * f19);
        float f27 = vec2.f423649x;
        float f28 = vec23.f423649x;
        float f29 = (f17 * f27) + (f19 * f28);
        Vec2 vec24 = mat222.f423637ey;
        float f36 = vec24.f423649x;
        float f37 = vec24.f423650y;
        float f38 = (f27 * f36) + (f28 * f37);
        Vec2 vec25 = mat223.f423636ex;
        vec25.f423649x = f29;
        vec25.f423650y = f26;
        Vec2 vec26 = mat223.f423637ey;
        vec26.f423649x = f38;
        vec26.f423650y = (f16 * f36) + (f18 * f37);
    }
}
