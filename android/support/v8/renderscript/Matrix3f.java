package android.support.v8.renderscript;

/* compiled from: P */
/* loaded from: classes.dex */
public class Matrix3f {
    final float[] mMat;

    public Matrix3f() {
        this.mMat = new float[9];
        loadIdentity();
    }

    public float get(int i3, int i16) {
        return this.mMat[(i3 * 3) + i16];
    }

    public float[] getArray() {
        return this.mMat;
    }

    public void load(Matrix3f matrix3f) {
        float[] array = matrix3f.getArray();
        float[] fArr = this.mMat;
        System.arraycopy(array, 0, fArr, 0, fArr.length);
    }

    public void loadIdentity() {
        float[] fArr = this.mMat;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    public void loadMultiply(Matrix3f matrix3f, Matrix3f matrix3f2) {
        for (int i3 = 0; i3 < 3; i3++) {
            float f16 = 0.0f;
            float f17 = 0.0f;
            float f18 = 0.0f;
            for (int i16 = 0; i16 < 3; i16++) {
                float f19 = matrix3f2.get(i3, i16);
                f16 += matrix3f.get(i16, 0) * f19;
                f17 += matrix3f.get(i16, 1) * f19;
                f18 += matrix3f.get(i16, 2) * f19;
            }
            set(i3, 0, f16);
            set(i3, 1, f17);
            set(i3, 2, f18);
        }
    }

    public void loadRotate(float f16, float f17, float f18, float f19) {
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
        float[] fArr = this.mMat;
        fArr[0] = (f17 * f17 * f27) + cos;
        float f37 = f17 * f18 * f27;
        fArr[3] = f37 - f36;
        float f38 = f19 * f17 * f27;
        fArr[6] = f38 + f29;
        fArr[1] = f37 + f36;
        fArr[4] = (f18 * f18 * f27) + cos;
        float f39 = f18 * f19 * f27;
        fArr[7] = f39 - f28;
        fArr[2] = f38 - f29;
        fArr[5] = f39 + f28;
        fArr[8] = (f19 * f19 * f27) + cos;
    }

    public void loadScale(float f16, float f17) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[0] = f16;
        fArr[4] = f17;
    }

    public void loadTranslate(float f16, float f17) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[6] = f16;
        fArr[7] = f17;
    }

    public void multiply(Matrix3f matrix3f) {
        Matrix3f matrix3f2 = new Matrix3f();
        matrix3f2.loadMultiply(this, matrix3f);
        load(matrix3f2);
    }

    public void rotate(float f16, float f17, float f18, float f19) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadRotate(f16, f17, f18, f19);
        multiply(matrix3f);
    }

    public void scale(float f16, float f17) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadScale(f16, f17);
        multiply(matrix3f);
    }

    public void set(int i3, int i16, float f16) {
        this.mMat[(i3 * 3) + i16] = f16;
    }

    public void translate(float f16, float f17) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadTranslate(f16, f17);
        multiply(matrix3f);
    }

    public void transpose() {
        int i3 = 0;
        while (i3 < 2) {
            int i16 = i3 + 1;
            for (int i17 = i16; i17 < 3; i17++) {
                float[] fArr = this.mMat;
                int i18 = (i3 * 3) + i17;
                float f16 = fArr[i18];
                int i19 = (i17 * 3) + i3;
                fArr[i18] = fArr[i19];
                fArr[i19] = f16;
            }
            i3 = i16;
        }
    }

    public Matrix3f(float[] fArr) {
        float[] fArr2 = new float[9];
        this.mMat = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }

    public void loadScale(float f16, float f17, float f18) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[0] = f16;
        fArr[4] = f17;
        fArr[8] = f18;
    }

    public void rotate(float f16) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadRotate(f16);
        multiply(matrix3f);
    }

    public void scale(float f16, float f17, float f18) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadScale(f16, f17, f18);
        multiply(matrix3f);
    }

    public void loadRotate(float f16) {
        loadIdentity();
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float[] fArr = this.mMat;
        fArr[0] = cos;
        fArr[1] = -sin;
        fArr[3] = sin;
        fArr[4] = cos;
    }
}
