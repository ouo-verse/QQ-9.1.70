package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Mat22 implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2;

    /* renamed from: ex, reason: collision with root package name */
    public final Vec2 f48105ex;

    /* renamed from: ey, reason: collision with root package name */
    public final Vec2 f48106ey;

    public Mat22() {
        this.f48105ex = new Vec2();
        this.f48106ey = new Vec2();
    }

    public static void absToOut(Mat22 mat22, Mat22 mat222) {
        mat222.f48105ex.f48119x = b.a(mat22.f48105ex.f48119x);
        mat222.f48105ex.f48120y = b.a(mat22.f48105ex.f48120y);
        mat222.f48106ey.f48119x = b.a(mat22.f48106ey.f48119x);
        mat222.f48106ey.f48120y = b.a(mat22.f48106ey.f48120y);
    }

    public static Mat22 createRotationalTransform(float f16) {
        Mat22 mat22 = new Mat22();
        float d16 = b.d(f16);
        float n3 = b.n(f16);
        Vec2 vec2 = mat22.f48105ex;
        vec2.f48119x = d16;
        Vec2 vec22 = mat22.f48106ey;
        vec22.f48119x = -n3;
        vec2.f48120y = n3;
        vec22.f48120y = d16;
        return mat22;
    }

    public static Mat22 createScaleTransform(float f16) {
        Mat22 mat22 = new Mat22();
        mat22.f48105ex.f48119x = f16;
        mat22.f48106ey.f48120y = f16;
        return mat22;
    }

    public final Mat22 abs() {
        return new Mat22(b.a(this.f48105ex.f48119x), b.a(this.f48106ey.f48119x), b.a(this.f48105ex.f48120y), b.a(this.f48106ey.f48120y));
    }

    public final void absLocal() {
        this.f48105ex.absLocal();
        this.f48106ey.absLocal();
    }

    public final Mat22 add(Mat22 mat22) {
        Mat22 mat222 = new Mat22();
        Vec2 vec2 = mat222.f48105ex;
        Vec2 vec22 = this.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat22.f48105ex;
        vec2.f48119x = f16 + vec23.f48119x;
        vec2.f48120y = vec22.f48120y + vec23.f48120y;
        Vec2 vec24 = mat222.f48106ey;
        Vec2 vec25 = this.f48106ey;
        float f17 = vec25.f48119x;
        Vec2 vec26 = mat22.f48106ey;
        vec24.f48119x = f17 + vec26.f48119x;
        vec24.f48120y = vec25.f48120y + vec26.f48120y;
        return mat222;
    }

    public final Mat22 addLocal(Mat22 mat22) {
        Vec2 vec2 = this.f48105ex;
        float f16 = vec2.f48119x;
        Vec2 vec22 = mat22.f48105ex;
        vec2.f48119x = f16 + vec22.f48119x;
        vec2.f48120y += vec22.f48120y;
        Vec2 vec23 = this.f48106ey;
        float f17 = vec23.f48119x;
        Vec2 vec24 = mat22.f48106ey;
        vec23.f48119x = f17 + vec24.f48119x;
        vec23.f48120y += vec24.f48120y;
        return this;
    }

    public final float getAngle() {
        Vec2 vec2 = this.f48105ex;
        return b.b(vec2.f48120y, vec2.f48119x);
    }

    public int hashCode() {
        Vec2 vec2 = this.f48105ex;
        int hashCode = ((vec2 == null ? 0 : vec2.hashCode()) + 31) * 31;
        Vec2 vec22 = this.f48106ey;
        return hashCode + (vec22 != null ? vec22.hashCode() : 0);
    }

    public final Mat22 invert() {
        Vec2 vec2 = this.f48105ex;
        float f16 = vec2.f48119x;
        Vec2 vec22 = this.f48106ey;
        float f17 = vec22.f48119x;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        Mat22 mat22 = new Mat22();
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        Vec2 vec23 = mat22.f48105ex;
        vec23.f48119x = f19 * f26;
        Vec2 vec24 = mat22.f48106ey;
        float f27 = -f26;
        vec24.f48119x = f17 * f27;
        vec23.f48120y = f27 * f18;
        vec24.f48120y = f26 * f16;
        return mat22;
    }

    public final Mat22 invertLocal() {
        Vec2 vec2 = this.f48105ex;
        float f16 = vec2.f48119x;
        Vec2 vec22 = this.f48106ey;
        float f17 = vec22.f48119x;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        vec2.f48119x = f19 * f26;
        float f27 = -f26;
        vec22.f48119x = f17 * f27;
        vec2.f48120y = f27 * f18;
        vec22.f48120y = f26 * f16;
        return this;
    }

    public final void invertToOut(Mat22 mat22) {
        Vec2 vec2 = this.f48105ex;
        float f16 = vec2.f48119x;
        Vec2 vec22 = this.f48106ey;
        float f17 = vec22.f48119x;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        float f26 = 1.0f / ((f16 * f19) - (f17 * f18));
        Vec2 vec23 = mat22.f48105ex;
        vec23.f48119x = f19 * f26;
        Vec2 vec24 = mat22.f48106ey;
        float f27 = -f26;
        vec24.f48119x = f17 * f27;
        vec23.f48120y = f27 * f18;
        vec24.f48120y = f26 * f16;
    }

    public final Vec2 mul(Vec2 vec2) {
        Vec2 vec22 = this.f48105ex;
        float f16 = vec22.f48119x;
        float f17 = vec2.f48119x;
        Vec2 vec23 = this.f48106ey;
        float f18 = vec23.f48119x;
        float f19 = vec2.f48120y;
        return new Vec2((f16 * f17) + (f18 * f19), (vec22.f48120y * f17) + (vec23.f48120y * f19));
    }

    public final Mat22 mulLocal(Mat22 mat22) {
        mulToOut(mat22, this);
        return this;
    }

    public final void mulToOut(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f48105ex;
        float f16 = vec23.f48120y;
        float f17 = vec2.f48119x;
        Vec2 vec24 = this.f48106ey;
        float f18 = vec24.f48120y;
        float f19 = vec2.f48120y;
        vec22.f48119x = (vec23.f48119x * f17) + (vec24.f48119x * f19);
        vec22.f48120y = (f16 * f17) + (f18 * f19);
    }

    public final void mulToOutUnsafe(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f48105ex;
        float f16 = vec23.f48119x * vec2.f48119x;
        Vec2 vec24 = this.f48106ey;
        float f17 = vec24.f48119x;
        float f18 = vec2.f48120y;
        vec22.f48119x = f16 + (f17 * f18);
        vec22.f48120y = (vec23.f48120y * vec2.f48119x) + (vec24.f48120y * f18);
    }

    public final Mat22 mulTrans(Mat22 mat22) {
        Mat22 mat222 = new Mat22();
        mat222.f48105ex.f48119x = Vec2.dot(this.f48105ex, mat22.f48105ex);
        mat222.f48105ex.f48120y = Vec2.dot(this.f48106ey, mat22.f48105ex);
        mat222.f48106ey.f48119x = Vec2.dot(this.f48105ex, mat22.f48106ey);
        mat222.f48106ey.f48120y = Vec2.dot(this.f48106ey, mat22.f48106ey);
        return mat222;
    }

    public final Mat22 mulTransLocal(Mat22 mat22) {
        mulTransToOut(mat22, this);
        return this;
    }

    public final void mulTransToOut(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = this.f48105ex;
        float f16 = vec2.f48119x;
        Vec2 vec22 = mat22.f48105ex;
        float f17 = vec22.f48119x;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        float f26 = (f16 * f17) + (f18 * f19);
        Vec2 vec23 = this.f48106ey;
        float f27 = vec23.f48119x;
        float f28 = vec23.f48120y;
        float f29 = (f17 * f27) + (f19 * f28);
        Vec2 vec24 = mat22.f48106ey;
        float f36 = vec24.f48119x;
        float f37 = vec24.f48120y;
        float f38 = (f16 * f36) + (f18 * f37);
        float f39 = (f27 * f36) + (f28 * f37);
        Vec2 vec25 = mat222.f48105ex;
        vec25.f48119x = f26;
        Vec2 vec26 = mat222.f48106ey;
        vec26.f48119x = f38;
        vec25.f48120y = f29;
        vec26.f48120y = f39;
    }

    public final void mulTransToOutUnsafe(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = mat222.f48105ex;
        Vec2 vec22 = this.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat22.f48105ex;
        float f17 = f16 * vec23.f48119x;
        float f18 = vec22.f48120y;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        Vec2 vec24 = mat222.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec25 = mat22.f48106ey;
        vec24.f48119x = (f26 * vec25.f48119x) + (f18 * vec25.f48120y);
        Vec2 vec26 = this.f48106ey;
        float f27 = vec26.f48119x;
        vec2.f48120y = (vec23.f48119x * f27) + (vec26.f48120y * f19);
        vec24.f48120y = (f27 * vec25.f48119x) + (vec26.f48120y * vec25.f48120y);
    }

    public final Mat22 set(Mat22 mat22) {
        Vec2 vec2 = this.f48105ex;
        Vec2 vec22 = mat22.f48105ex;
        vec2.f48119x = vec22.f48119x;
        vec2.f48120y = vec22.f48120y;
        Vec2 vec23 = this.f48106ey;
        Vec2 vec24 = mat22.f48106ey;
        vec23.f48119x = vec24.f48119x;
        vec23.f48120y = vec24.f48120y;
        return this;
    }

    public final void setIdentity() {
        Vec2 vec2 = this.f48105ex;
        vec2.f48119x = 1.0f;
        Vec2 vec22 = this.f48106ey;
        vec22.f48119x = 0.0f;
        vec2.f48120y = 0.0f;
        vec22.f48120y = 1.0f;
    }

    public final void setZero() {
        Vec2 vec2 = this.f48105ex;
        vec2.f48119x = 0.0f;
        Vec2 vec22 = this.f48106ey;
        vec22.f48119x = 0.0f;
        vec2.f48120y = 0.0f;
        vec22.f48120y = 0.0f;
    }

    public final Vec2 solve(Vec2 vec2) {
        Vec2 vec22 = this.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = this.f48106ey;
        float f17 = vec23.f48119x;
        float f18 = vec22.f48120y;
        float f19 = vec23.f48120y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        float f27 = vec2.f48119x;
        float f28 = vec2.f48120y;
        return new Vec2(((f19 * f27) - (f17 * f28)) * f26, f26 * ((f16 * f28) - (f18 * f27)));
    }

    public final void solveToOut(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f48105ex;
        float f16 = vec23.f48119x;
        Vec2 vec24 = this.f48106ey;
        float f17 = vec24.f48119x;
        float f18 = vec23.f48120y;
        float f19 = vec24.f48120y;
        float f26 = (f16 * f19) - (f17 * f18);
        if (f26 != 0.0f) {
            f26 = 1.0f / f26;
        }
        float f27 = vec2.f48120y;
        float f28 = vec2.f48119x;
        vec22.f48119x = f26 * ((f19 * f28) - (f17 * f27));
        vec22.f48120y = ((f16 * f27) - (f18 * f28)) * f26;
    }

    public String toString() {
        return ("[" + this.f48105ex.f48119x + "," + this.f48106ey.f48119x + "]\n") + "[" + this.f48105ex.f48120y + "," + this.f48106ey.f48120y + "]";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final Mat22 m77clone() {
        return new Mat22(this.f48105ex, this.f48106ey);
    }

    public final Mat22 mul(Mat22 mat22) {
        Mat22 mat222 = new Mat22();
        Vec2 vec2 = mat222.f48105ex;
        Vec2 vec22 = this.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat22.f48105ex;
        float f17 = f16 * vec23.f48119x;
        Vec2 vec24 = this.f48106ey;
        float f18 = vec24.f48119x;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        vec2.f48120y = (vec22.f48120y * vec23.f48119x) + (vec24.f48120y * f19);
        Vec2 vec25 = mat222.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec26 = mat22.f48106ey;
        float f27 = f26 * vec26.f48119x;
        float f28 = vec24.f48119x;
        float f29 = vec26.f48120y;
        vec25.f48119x = f27 + (f28 * f29);
        vec25.f48120y = (vec22.f48120y * vec26.f48119x) + (vec24.f48120y * f29);
        return mat222;
    }

    public static Mat22 abs(Mat22 mat22) {
        return mat22.abs();
    }

    public final void mulToOutUnsafe(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = mat222.f48105ex;
        Vec2 vec22 = this.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat22.f48105ex;
        float f17 = f16 * vec23.f48119x;
        Vec2 vec24 = this.f48106ey;
        float f18 = vec24.f48119x;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        vec2.f48120y = (vec22.f48120y * vec23.f48119x) + (vec24.f48120y * f19);
        Vec2 vec25 = mat222.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec26 = mat22.f48106ey;
        float f27 = f26 * vec26.f48119x;
        float f28 = vec24.f48119x;
        float f29 = vec26.f48120y;
        vec25.f48119x = f27 + (f28 * f29);
        vec25.f48120y = (vec22.f48120y * vec26.f48119x) + (vec24.f48120y * f29);
    }

    public Mat22(Vec2 vec2, Vec2 vec22) {
        this.f48105ex = vec2.m79clone();
        this.f48106ey = vec22.m79clone();
    }

    public static void createScaleTransform(float f16, Mat22 mat22) {
        mat22.f48105ex.f48119x = f16;
        mat22.f48106ey.f48120y = f16;
    }

    public final void mulToOut(Mat22 mat22, Mat22 mat222) {
        Vec2 vec2 = this.f48105ex;
        float f16 = vec2.f48120y;
        Vec2 vec22 = mat22.f48105ex;
        float f17 = vec22.f48119x;
        Vec2 vec23 = this.f48106ey;
        float f18 = vec23.f48120y;
        float f19 = vec22.f48120y;
        float f26 = (f16 * f17) + (f18 * f19);
        float f27 = (vec2.f48119x * f17) + (vec23.f48119x * f19);
        Vec2 vec24 = mat222.f48105ex;
        vec24.f48119x = f27;
        vec24.f48120y = f26;
        float f28 = vec2.f48120y;
        Vec2 vec25 = mat22.f48106ey;
        float f29 = vec25.f48119x;
        float f36 = vec23.f48120y;
        float f37 = vec25.f48120y;
        float f38 = (f28 * f29) + (f36 * f37);
        float f39 = (vec2.f48119x * f29) + (vec23.f48119x * f37);
        Vec2 vec26 = mat222.f48106ey;
        vec26.f48119x = f39;
        vec26.f48120y = f38;
    }

    public static void mulTransToOutUnsafe(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        Vec2 vec23 = mat22.f48106ey;
        vec22.f48120y = (vec23.f48119x * f16) + (vec2.f48120y * vec23.f48120y);
        Vec2 vec24 = mat22.f48105ex;
        vec22.f48119x = (f16 * vec24.f48119x) + (vec2.f48120y * vec24.f48120y);
    }

    public final Mat22 set(float f16, float f17, float f18, float f19) {
        Vec2 vec2 = this.f48105ex;
        vec2.f48119x = f16;
        vec2.f48120y = f18;
        Vec2 vec22 = this.f48106ey;
        vec22.f48119x = f17;
        vec22.f48120y = f19;
        return this;
    }

    public final Vec2 mulTrans(Vec2 vec2) {
        float f16 = vec2.f48119x;
        Vec2 vec22 = this.f48105ex;
        float f17 = vec22.f48119x * f16;
        float f18 = vec2.f48120y;
        float f19 = f17 + (vec22.f48120y * f18);
        Vec2 vec23 = this.f48106ey;
        return new Vec2(f19, (f16 * vec23.f48119x) + (f18 * vec23.f48120y));
    }

    public Mat22(float f16, float f17, float f18, float f19) {
        this.f48105ex = new Vec2(f16, f18);
        this.f48106ey = new Vec2(f17, f19);
    }

    public static Vec2 mul(Mat22 mat22, Vec2 vec2) {
        Vec2 vec22 = mat22.f48105ex;
        float f16 = vec22.f48119x;
        float f17 = vec2.f48119x;
        Vec2 vec23 = mat22.f48106ey;
        float f18 = vec23.f48119x;
        float f19 = vec2.f48120y;
        return new Vec2((f16 * f17) + (f18 * f19), (vec22.f48120y * f17) + (vec23.f48120y * f19));
    }

    public static void mulToOutUnsafe(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = mat22.f48105ex;
        float f16 = vec23.f48119x * vec2.f48119x;
        Vec2 vec24 = mat22.f48106ey;
        float f17 = vec24.f48119x;
        float f18 = vec2.f48120y;
        vec22.f48119x = f16 + (f17 * f18);
        vec22.f48120y = (vec23.f48120y * vec2.f48119x) + (vec24.f48120y * f18);
    }

    public static Vec2 mulTrans(Mat22 mat22, Vec2 vec2) {
        float f16 = vec2.f48119x;
        Vec2 vec22 = mat22.f48105ex;
        float f17 = vec22.f48119x * f16;
        float f18 = vec2.f48120y;
        float f19 = f17 + (vec22.f48120y * f18);
        Vec2 vec23 = mat22.f48106ey;
        return new Vec2(f19, (f16 * vec23.f48119x) + (f18 * vec23.f48120y));
    }

    public static void mulTransToOutUnsafe(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat223.f48105ex;
        Vec2 vec22 = mat22.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat222.f48105ex;
        float f17 = f16 * vec23.f48119x;
        float f18 = vec22.f48120y;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        Vec2 vec24 = mat22.f48106ey;
        vec2.f48120y = (vec24.f48119x * vec23.f48119x) + (vec24.f48120y * f19);
        Vec2 vec25 = mat223.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec26 = mat222.f48106ey;
        float f27 = f26 * vec26.f48119x;
        float f28 = vec22.f48120y;
        float f29 = vec26.f48120y;
        vec25.f48119x = f27 + (f28 * f29);
        vec25.f48120y = (vec24.f48119x * vec26.f48119x) + (vec24.f48120y * f29);
    }

    public static void createRotationalTransform(float f16, Mat22 mat22) {
        float d16 = b.d(f16);
        float n3 = b.n(f16);
        Vec2 vec2 = mat22.f48105ex;
        vec2.f48119x = d16;
        Vec2 vec22 = mat22.f48106ey;
        vec22.f48119x = -n3;
        vec2.f48120y = n3;
        vec22.f48120y = d16;
    }

    public static Mat22 mul(Mat22 mat22, Mat22 mat222) {
        Mat22 mat223 = new Mat22();
        Vec2 vec2 = mat223.f48105ex;
        Vec2 vec22 = mat22.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat222.f48105ex;
        float f17 = f16 * vec23.f48119x;
        Vec2 vec24 = mat22.f48106ey;
        float f18 = vec24.f48119x;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        vec2.f48120y = (vec22.f48120y * vec23.f48119x) + (vec24.f48120y * f19);
        Vec2 vec25 = mat223.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec26 = mat222.f48106ey;
        float f27 = f26 * vec26.f48119x;
        float f28 = vec24.f48119x;
        float f29 = vec26.f48120y;
        vec25.f48119x = f27 + (f28 * f29);
        vec25.f48120y = (vec22.f48120y * vec26.f48119x) + (vec24.f48120y * f29);
        return mat223;
    }

    public static Mat22 mulTrans(Mat22 mat22, Mat22 mat222) {
        Mat22 mat223 = new Mat22();
        Vec2 vec2 = mat223.f48105ex;
        Vec2 vec22 = mat22.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat222.f48105ex;
        float f17 = f16 * vec23.f48119x;
        float f18 = vec22.f48120y;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        Vec2 vec24 = mat22.f48106ey;
        vec2.f48120y = (vec24.f48119x * vec23.f48119x) + (vec24.f48120y * f19);
        Vec2 vec25 = mat223.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec26 = mat222.f48106ey;
        float f27 = f26 * vec26.f48119x;
        float f28 = vec22.f48120y;
        float f29 = vec26.f48120y;
        vec25.f48119x = f27 + (f28 * f29);
        vec25.f48120y = (vec24.f48119x * vec26.f48119x) + (vec24.f48120y * f29);
        return mat223;
    }

    public final void mulTransToOut(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        Vec2 vec23 = this.f48105ex;
        float f17 = vec23.f48119x * f16;
        float f18 = vec2.f48120y;
        float f19 = f17 + (vec23.f48120y * f18);
        Vec2 vec24 = this.f48106ey;
        vec22.f48120y = (f16 * vec24.f48119x) + (f18 * vec24.f48120y);
        vec22.f48119x = f19;
    }

    public static void mulToOutUnsafe(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat223.f48105ex;
        Vec2 vec22 = mat22.f48105ex;
        float f16 = vec22.f48119x;
        Vec2 vec23 = mat222.f48105ex;
        float f17 = f16 * vec23.f48119x;
        Vec2 vec24 = mat22.f48106ey;
        float f18 = vec24.f48119x;
        float f19 = vec23.f48120y;
        vec2.f48119x = f17 + (f18 * f19);
        vec2.f48120y = (vec22.f48120y * vec23.f48119x) + (vec24.f48120y * f19);
        Vec2 vec25 = mat223.f48106ey;
        float f26 = vec22.f48119x;
        Vec2 vec26 = mat222.f48106ey;
        float f27 = f26 * vec26.f48119x;
        float f28 = vec24.f48119x;
        float f29 = vec26.f48120y;
        vec25.f48119x = f27 + (f28 * f29);
        vec25.f48120y = (vec22.f48120y * vec26.f48119x) + (vec24.f48120y * f29);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mat22 mat22 = (Mat22) obj;
        Vec2 vec2 = this.f48105ex;
        if (vec2 == null) {
            if (mat22.f48105ex != null) {
                return false;
            }
        } else if (!vec2.equals(mat22.f48105ex)) {
            return false;
        }
        Vec2 vec22 = this.f48106ey;
        if (vec22 == null) {
            if (mat22.f48106ey != null) {
                return false;
            }
        } else if (!vec22.equals(mat22.f48106ey)) {
            return false;
        }
        return true;
    }

    public final void set(float f16) {
        float d16 = b.d(f16);
        float n3 = b.n(f16);
        Vec2 vec2 = this.f48105ex;
        vec2.f48119x = d16;
        Vec2 vec22 = this.f48106ey;
        vec22.f48119x = -n3;
        vec2.f48120y = n3;
        vec22.f48120y = d16;
    }

    public static void mulTransToOut(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        Vec2 vec23 = mat22.f48105ex;
        float f17 = vec23.f48119x * f16;
        float f18 = vec2.f48120y;
        float f19 = f17 + (vec23.f48120y * f18);
        Vec2 vec24 = mat22.f48106ey;
        vec22.f48120y = (f16 * vec24.f48119x) + (f18 * vec24.f48120y);
        vec22.f48119x = f19;
    }

    public static void mulToOut(Mat22 mat22, Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = mat22.f48105ex;
        float f16 = vec23.f48120y;
        float f17 = vec2.f48119x;
        Vec2 vec24 = mat22.f48106ey;
        float f18 = vec24.f48120y;
        float f19 = vec2.f48120y;
        vec22.f48119x = (vec23.f48119x * f17) + (vec24.f48119x * f19);
        vec22.f48120y = (f16 * f17) + (f18 * f19);
    }

    public static void mulTransToOut(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat22.f48105ex;
        float f16 = vec2.f48119x;
        Vec2 vec22 = mat222.f48105ex;
        float f17 = vec22.f48119x;
        float f18 = vec2.f48120y;
        float f19 = vec22.f48120y;
        float f26 = (f16 * f17) + (f18 * f19);
        Vec2 vec23 = mat22.f48106ey;
        float f27 = vec23.f48119x;
        float f28 = vec23.f48120y;
        float f29 = (f17 * f27) + (f19 * f28);
        Vec2 vec24 = mat222.f48106ey;
        float f36 = vec24.f48119x;
        float f37 = vec24.f48120y;
        float f38 = (f27 * f36) + (f28 * f37);
        Vec2 vec25 = mat223.f48105ex;
        vec25.f48119x = f26;
        vec25.f48120y = f29;
        Vec2 vec26 = mat223.f48106ey;
        vec26.f48119x = (f16 * f36) + (f18 * f37);
        vec26.f48120y = f38;
    }

    public final void set(Vec2 vec2, Vec2 vec22) {
        Vec2 vec23 = this.f48105ex;
        vec23.f48119x = vec2.f48119x;
        Vec2 vec24 = this.f48106ey;
        vec24.f48119x = vec22.f48119x;
        vec23.f48120y = vec2.f48120y;
        vec24.f48120y = vec22.f48120y;
    }

    public static void mulToOut(Mat22 mat22, Mat22 mat222, Mat22 mat223) {
        Vec2 vec2 = mat22.f48105ex;
        float f16 = vec2.f48120y;
        Vec2 vec22 = mat222.f48105ex;
        float f17 = vec22.f48119x;
        Vec2 vec23 = mat22.f48106ey;
        float f18 = vec23.f48120y;
        float f19 = vec22.f48120y;
        float f26 = (f16 * f17) + (f18 * f19);
        float f27 = vec2.f48119x;
        float f28 = vec23.f48119x;
        float f29 = (f17 * f27) + (f19 * f28);
        Vec2 vec24 = mat222.f48106ey;
        float f36 = vec24.f48119x;
        float f37 = vec24.f48120y;
        float f38 = (f27 * f36) + (f28 * f37);
        Vec2 vec25 = mat223.f48105ex;
        vec25.f48119x = f29;
        vec25.f48120y = f26;
        Vec2 vec26 = mat223.f48106ey;
        vec26.f48119x = f38;
        vec26.f48120y = (f16 * f36) + (f18 * f37);
    }
}
