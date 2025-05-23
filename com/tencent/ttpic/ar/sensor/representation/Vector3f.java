package com.tencent.ttpic.ar.sensor.representation;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Vector3f {
    protected float[] points;

    public Vector3f(float f16, float f17, float f18) {
        this.points = r0;
        float[] fArr = {f16, f17, f18};
    }

    public void add(Vector3f vector3f) {
        float[] fArr = this.points;
        float f16 = fArr[0];
        float[] fArr2 = vector3f.points;
        fArr[0] = f16 + fArr2[0];
        fArr[1] = fArr[1] + fArr2[1];
        fArr[2] = fArr[2] + fArr2[2];
    }

    public void crossProduct(Vector3f vector3f, Vector3f vector3f2) {
        float[] fArr = this.points;
        float f16 = fArr[1];
        float[] fArr2 = vector3f.points;
        vector3f2.setX((f16 * fArr2[2]) - (fArr[2] * fArr2[1]));
        float[] fArr3 = this.points;
        float f17 = fArr3[2];
        float[] fArr4 = vector3f.points;
        vector3f2.setY((f17 * fArr4[0]) - (fArr3[0] * fArr4[2]));
        float[] fArr5 = this.points;
        float f18 = fArr5[0];
        float[] fArr6 = vector3f.points;
        vector3f2.setZ((f18 * fArr6[1]) - (fArr5[1] * fArr6[0]));
    }

    public float dotProduct(Vector3f vector3f) {
        float[] fArr = this.points;
        float f16 = fArr[0];
        float[] fArr2 = vector3f.points;
        return (f16 * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public float getLength() {
        float[] fArr = this.points;
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        return (float) Math.sqrt((f16 * f16) + (f17 * f17) + (f18 * f18));
    }

    public float getX() {
        return this.points[0];
    }

    public float getY() {
        return this.points[1];
    }

    public float getZ() {
        return this.points[2];
    }

    public void multiplyByScalar(float f16) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f16;
        fArr[1] = fArr[1] * f16;
        fArr[2] = fArr[2] * f16;
    }

    public void normalize() {
        float[] fArr = this.points;
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        double sqrt = Math.sqrt((f16 * f16) + (f17 * f17) + (f18 * f18));
        float[] fArr2 = this.points;
        fArr2[0] = (float) (fArr2[0] / sqrt);
        fArr2[1] = (float) (fArr2[1] / sqrt);
        fArr2[2] = (float) (fArr2[2] / sqrt);
    }

    public void set(Vector3f vector3f) {
        set(vector3f.points);
    }

    public void setX(float f16) {
        this.points[0] = f16;
    }

    public void setXYZ(float f16, float f17, float f18) {
        float[] fArr = this.points;
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
    }

    public void setY(float f16) {
        this.points[1] = f16;
    }

    public void setZ(float f16) {
        this.points[2] = f16;
    }

    public void subtract(Vector3f vector3f) {
        float[] fArr = this.points;
        float f16 = fArr[0];
        float[] fArr2 = vector3f.points;
        fArr[0] = f16 - fArr2[0];
        fArr[1] = fArr[1] - fArr2[1];
        fArr[2] = fArr[2] - fArr2[2];
    }

    public float[] toArray() {
        return this.points;
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
    }

    public float x() {
        return this.points[0];
    }

    public float y() {
        return this.points[1];
    }

    public float z() {
        return this.points[2];
    }

    public void set(float[] fArr) {
        System.arraycopy(fArr, 0, this.points, 0, 3);
    }

    public void x(float f16) {
        this.points[0] = f16;
    }

    public void y(float f16) {
        this.points[1] = f16;
    }

    public void z(float f16) {
        this.points[2] = f16;
    }

    public Vector3f(float f16) {
        this.points = r0;
        float[] fArr = {f16, f16, f16};
    }

    public void add(float f16) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + f16;
        fArr[1] = fArr[1] + f16;
        fArr[2] = fArr[2] + f16;
    }

    public Vector3f() {
        this.points = new float[3];
    }

    public Vector3f(Vector3f vector3f) {
        this.points = r0;
        float[] fArr = vector3f.points;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
    }

    public Vector3f(Vector4f vector4f) {
        this.points = new float[3];
        if (vector4f.w() != 0.0f) {
            this.points[0] = vector4f.x() / vector4f.w();
            this.points[1] = vector4f.y() / vector4f.w();
            this.points[2] = vector4f.z() / vector4f.w();
        } else {
            this.points[0] = vector4f.x();
            this.points[1] = vector4f.y();
            this.points[2] = vector4f.z();
        }
    }
}
