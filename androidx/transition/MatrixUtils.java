package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f16, float f17, float f18) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f16, float f17, float f18, float f19) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f16, float f17, float f18, float f19) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f16, float f17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f16, float f17, float f18) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f16, float f17, float f18, float f19) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f16, float f17, float f18, float f19) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f16, float f17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i3, float[] fArr2, int i16, int i17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f16, float f17, float f18) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f16, float f17, float f18, float f19) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f16, float f17, float f18, float f19) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f16, float f17, float f18, float f19) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f16, float f17) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f16) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f16, float f17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f16, float f17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f16) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f16, float f17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f16, float f17) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f16) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f16, float f17) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f16, float f17) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f16, float f17) {
            oops();
        }
    };

    MatrixUtils() {
    }
}
