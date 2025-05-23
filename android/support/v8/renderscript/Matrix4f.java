package android.support.v8.renderscript;

/* compiled from: P */
/* loaded from: classes.dex */
public class Matrix4f {
    final float[] mMat;

    public Matrix4f() {
        this.mMat = new float[16];
        loadIdentity();
    }

    private float computeCofactor(int i3, int i16) {
        int i17 = (i3 + 1) % 4;
        int i18 = (i3 + 2) % 4;
        int i19 = (i3 + 3) % 4;
        float[] fArr = this.mMat;
        int i26 = ((i16 + 1) % 4) * 4;
        float f16 = fArr[i17 + i26];
        int i27 = ((i16 + 2) % 4) * 4;
        float f17 = fArr[i18 + i27];
        int i28 = ((i16 + 3) % 4) * 4;
        float f18 = fArr[i19 + i28];
        float f19 = fArr[i18 + i28];
        float f26 = fArr[i19 + i27];
        float f27 = fArr[i27 + i17];
        float f28 = fArr[i18 + i26];
        float f29 = fArr[i19 + i26];
        float f36 = ((f16 * ((f17 * f18) - (f19 * f26))) - (f27 * ((f18 * f28) - (f19 * f29)))) + (fArr[i17 + i28] * ((f28 * f26) - (f17 * f29)));
        if (((i3 + i16) & 1) != 0) {
            return -f36;
        }
        return f36;
    }

    public float get(int i3, int i16) {
        return this.mMat[(i3 * 4) + i16];
    }

    public float[] getArray() {
        return this.mMat;
    }

    public boolean inverse() {
        Matrix4f matrix4f = new Matrix4f();
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i16 = 0; i16 < 4; i16++) {
                matrix4f.mMat[(i3 * 4) + i16] = computeCofactor(i3, i16);
            }
        }
        float[] fArr = this.mMat;
        float f16 = fArr[0];
        float[] fArr2 = matrix4f.mMat;
        float f17 = (f16 * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[8] * fArr2[2]) + (fArr[12] * fArr2[3]);
        if (Math.abs(f17) < 1.0E-6d) {
            return false;
        }
        float f18 = 1.0f / f17;
        for (int i17 = 0; i17 < 16; i17++) {
            this.mMat[i17] = matrix4f.mMat[i17] * f18;
        }
        return true;
    }

    public boolean inverseTranspose() {
        Matrix4f matrix4f = new Matrix4f();
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i16 = 0; i16 < 4; i16++) {
                matrix4f.mMat[(i16 * 4) + i3] = computeCofactor(i3, i16);
            }
        }
        float[] fArr = this.mMat;
        float f16 = fArr[0];
        float[] fArr2 = matrix4f.mMat;
        float f17 = (f16 * fArr2[0]) + (fArr[4] * fArr2[4]) + (fArr[8] * fArr2[8]) + (fArr[12] * fArr2[12]);
        if (Math.abs(f17) < 1.0E-6d) {
            return false;
        }
        float f18 = 1.0f / f17;
        for (int i17 = 0; i17 < 16; i17++) {
            this.mMat[i17] = matrix4f.mMat[i17] * f18;
        }
        return true;
    }

    public void load(Matrix4f matrix4f) {
        float[] array = matrix4f.getArray();
        float[] fArr = this.mMat;
        System.arraycopy(array, 0, fArr, 0, fArr.length);
    }

    public void loadFrustum(float f16, float f17, float f18, float f19, float f26, float f27) {
        loadIdentity();
        float[] fArr = this.mMat;
        float f28 = 2.0f * f26;
        float f29 = f17 - f16;
        fArr[0] = f28 / f29;
        float f36 = f19 - f18;
        fArr[5] = f28 / f36;
        fArr[8] = (f17 + f16) / f29;
        fArr[9] = (f19 + f18) / f36;
        float f37 = f27 - f26;
        fArr[10] = (-(f27 + f26)) / f37;
        fArr[11] = -1.0f;
        fArr[14] = ((f27 * (-2.0f)) * f26) / f37;
        fArr[15] = 0.0f;
    }

    public void loadIdentity() {
        float[] fArr = this.mMat;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public void loadMultiply(Matrix4f matrix4f, Matrix4f matrix4f2) {
        for (int i3 = 0; i3 < 4; i3++) {
            float f16 = 0.0f;
            float f17 = 0.0f;
            float f18 = 0.0f;
            float f19 = 0.0f;
            for (int i16 = 0; i16 < 4; i16++) {
                float f26 = matrix4f2.get(i3, i16);
                f16 += matrix4f.get(i16, 0) * f26;
                f17 += matrix4f.get(i16, 1) * f26;
                f18 += matrix4f.get(i16, 2) * f26;
                f19 += matrix4f.get(i16, 3) * f26;
            }
            set(i3, 0, f16);
            set(i3, 1, f17);
            set(i3, 2, f18);
            set(i3, 3, f19);
        }
    }

    public void loadOrtho(float f16, float f17, float f18, float f19, float f26, float f27) {
        loadIdentity();
        float[] fArr = this.mMat;
        float f28 = f17 - f16;
        fArr[0] = 2.0f / f28;
        float f29 = f19 - f18;
        fArr[5] = 2.0f / f29;
        float f36 = f27 - f26;
        fArr[10] = (-2.0f) / f36;
        fArr[12] = (-(f17 + f16)) / f28;
        fArr[13] = (-(f19 + f18)) / f29;
        fArr[14] = (-(f27 + f26)) / f36;
    }

    public void loadOrthoWindow(int i3, int i16) {
        loadOrtho(0.0f, i3, i16, 0.0f, -1.0f, 1.0f);
    }

    public void loadPerspective(float f16, float f17, float f18, float f19) {
        float tan = f18 * ((float) Math.tan((float) ((f16 * 3.141592653589793d) / 360.0d)));
        float f26 = -tan;
        loadFrustum(f26 * f17, tan * f17, f26, tan, f18, f19);
    }

    public void loadProjectionNormalized(int i3, int i16) {
        Matrix4f matrix4f = new Matrix4f();
        Matrix4f matrix4f2 = new Matrix4f();
        if (i3 > i16) {
            float f16 = i3 / i16;
            matrix4f.loadFrustum(-f16, f16, -1.0f, 1.0f, 1.0f, 100.0f);
        } else {
            float f17 = i16 / i3;
            matrix4f.loadFrustum(-1.0f, 1.0f, -f17, f17, 1.0f, 100.0f);
        }
        matrix4f2.loadRotate(180.0f, 0.0f, 1.0f, 0.0f);
        matrix4f.loadMultiply(matrix4f, matrix4f2);
        matrix4f2.loadScale(-2.0f, 2.0f, 1.0f);
        matrix4f.loadMultiply(matrix4f, matrix4f2);
        matrix4f2.loadTranslate(0.0f, 0.0f, 2.0f);
        matrix4f.loadMultiply(matrix4f, matrix4f2);
        load(matrix4f);
    }

    public void loadRotate(float f16, float f17, float f18, float f19) {
        float[] fArr = this.mMat;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float sqrt = (float) Math.sqrt((f17 * f17) + (f18 * f18) + (f19 * f19));
        if (sqrt == 1.0f) {
            float f26 = 1.0f / sqrt;
            f17 *= f26;
            f18 *= f26;
            f19 *= f26;
        }
        float f27 = 1.0f - cos;
        float f28 = f17 * sin;
        float f29 = f18 * sin;
        float f36 = sin * f19;
        float[] fArr2 = this.mMat;
        fArr2[0] = (f17 * f17 * f27) + cos;
        float f37 = f17 * f18 * f27;
        fArr2[4] = f37 - f36;
        float f38 = f19 * f17 * f27;
        fArr2[8] = f38 + f29;
        fArr2[1] = f37 + f36;
        fArr2[5] = (f18 * f18 * f27) + cos;
        float f39 = f18 * f19 * f27;
        fArr2[9] = f39 - f28;
        fArr2[2] = f38 - f29;
        fArr2[6] = f39 + f28;
        fArr2[10] = (f19 * f19 * f27) + cos;
    }

    public void loadScale(float f16, float f17, float f18) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[0] = f16;
        fArr[5] = f17;
        fArr[10] = f18;
    }

    public void loadTranslate(float f16, float f17, float f18) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[12] = f16;
        fArr[13] = f17;
        fArr[14] = f18;
    }

    public void multiply(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = new Matrix4f();
        matrix4f2.loadMultiply(this, matrix4f);
        load(matrix4f2);
    }

    public void rotate(float f16, float f17, float f18, float f19) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadRotate(f16, f17, f18, f19);
        multiply(matrix4f);
    }

    public void scale(float f16, float f17, float f18) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadScale(f16, f17, f18);
        multiply(matrix4f);
    }

    public void set(int i3, int i16, float f16) {
        this.mMat[(i3 * 4) + i16] = f16;
    }

    public void translate(float f16, float f17, float f18) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadTranslate(f16, f17, f18);
        multiply(matrix4f);
    }

    public void transpose() {
        int i3 = 0;
        while (i3 < 3) {
            int i16 = i3 + 1;
            for (int i17 = i16; i17 < 4; i17++) {
                float[] fArr = this.mMat;
                int i18 = (i3 * 4) + i17;
                float f16 = fArr[i18];
                int i19 = (i17 * 4) + i3;
                fArr[i18] = fArr[i19];
                fArr[i19] = f16;
            }
            i3 = i16;
        }
    }

    public void load(Matrix3f matrix3f) {
        float[] fArr = this.mMat;
        float[] fArr2 = matrix3f.mMat;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = 0.0f;
        fArr[4] = fArr2[3];
        fArr[5] = fArr2[4];
        fArr[6] = fArr2[5];
        fArr[7] = 0.0f;
        fArr[8] = fArr2[6];
        fArr[9] = fArr2[7];
        fArr[10] = fArr2[8];
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public Matrix4f(float[] fArr) {
        float[] fArr2 = new float[16];
        this.mMat = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }
}
