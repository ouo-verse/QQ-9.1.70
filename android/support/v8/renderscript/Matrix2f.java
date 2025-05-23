package android.support.v8.renderscript;

/* compiled from: P */
/* loaded from: classes.dex */
public class Matrix2f {
    final float[] mMat;

    public Matrix2f() {
        this.mMat = new float[4];
        loadIdentity();
    }

    public float get(int i3, int i16) {
        return this.mMat[(i3 * 2) + i16];
    }

    public float[] getArray() {
        return this.mMat;
    }

    public void load(Matrix2f matrix2f) {
        float[] array = matrix2f.getArray();
        float[] fArr = this.mMat;
        System.arraycopy(array, 0, fArr, 0, fArr.length);
    }

    public void loadIdentity() {
        float[] fArr = this.mMat;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 1.0f;
    }

    public void loadMultiply(Matrix2f matrix2f, Matrix2f matrix2f2) {
        for (int i3 = 0; i3 < 2; i3++) {
            float f16 = 0.0f;
            float f17 = 0.0f;
            for (int i16 = 0; i16 < 2; i16++) {
                float f18 = matrix2f2.get(i3, i16);
                f16 += matrix2f.get(i16, 0) * f18;
                f17 += matrix2f.get(i16, 1) * f18;
            }
            set(i3, 0, f16);
            set(i3, 1, f17);
        }
    }

    public void loadRotate(float f16) {
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float[] fArr = this.mMat;
        fArr[0] = cos;
        fArr[1] = -sin;
        fArr[2] = sin;
        fArr[3] = cos;
    }

    public void loadScale(float f16, float f17) {
        loadIdentity();
        float[] fArr = this.mMat;
        fArr[0] = f16;
        fArr[3] = f17;
    }

    public void multiply(Matrix2f matrix2f) {
        Matrix2f matrix2f2 = new Matrix2f();
        matrix2f2.loadMultiply(this, matrix2f);
        load(matrix2f2);
    }

    public void rotate(float f16) {
        Matrix2f matrix2f = new Matrix2f();
        matrix2f.loadRotate(f16);
        multiply(matrix2f);
    }

    public void scale(float f16, float f17) {
        Matrix2f matrix2f = new Matrix2f();
        matrix2f.loadScale(f16, f17);
        multiply(matrix2f);
    }

    public void set(int i3, int i16, float f16) {
        this.mMat[(i3 * 2) + i16] = f16;
    }

    public void transpose() {
        float[] fArr = this.mMat;
        float f16 = fArr[1];
        fArr[1] = fArr[2];
        fArr[2] = f16;
    }

    public Matrix2f(float[] fArr) {
        float[] fArr2 = new float[4];
        this.mMat = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }
}
