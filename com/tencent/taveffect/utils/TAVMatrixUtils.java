package com.tencent.taveffect.utils;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVSize;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMatrixUtils {
    public static void applyMirror(Matrix matrix, int i3, int i16, int i17) {
        if (matrix == null) {
            return;
        }
        Matrix matrix2 = new Matrix();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    matrix2.postScale(-1.0f, -1.0f);
                    matrix2.postTranslate(i16, i17);
                }
            } else {
                matrix2.postScale(1.0f, -1.0f);
                matrix2.postTranslate(0.0f, i17);
            }
        } else {
            matrix2.postScale(-1.0f, 1.0f);
            matrix2.postTranslate(i16, 0.0f);
        }
        matrix.postConcat(matrix2);
    }

    public static TAVRectangle getMatrixAndCropRect(TAVSize tAVSize, int i3, float f16, float f17, Point point, Matrix matrix) {
        float f18;
        float f19;
        while (i3 < 0) {
            i3 += 4;
        }
        int i16 = i3 % 4;
        getRotationMatrix(matrix, i16, tAVSize.width, tAVSize.height);
        TAVSize transformedSize = getTransformedSize(tAVSize, i16, f17);
        if (f17 <= 0.0f && f16 <= 1.0f) {
            return null;
        }
        TAVSize tAVSize2 = new TAVSize();
        if (i16 % 2 == 1) {
            tAVSize2.width = tAVSize.height;
            tAVSize2.height = tAVSize.width;
        } else {
            tAVSize2.width = tAVSize.width;
            tAVSize2.height = tAVSize.height;
        }
        if (transformedSize.width != tAVSize2.width) {
            f18 = (r3 - r11) * 0.5f;
            f19 = 0.0f;
        } else {
            if (transformedSize.height != tAVSize2.height) {
                f19 = (r3 - r11) * 0.5f;
                f18 = 0.0f;
            } else {
                f18 = 0.0f;
                f19 = 0.0f;
            }
        }
        Matrix matrix2 = new Matrix();
        matrix2.setTranslate(-f18, -f19);
        int i17 = transformedSize.width;
        float f26 = i17 / f16;
        float f27 = transformedSize.height / f16;
        float f28 = (f16 - 1.0f) / f16;
        float f29 = (((-i17) * 0.5f) * f28) - point.x;
        float f36 = (((-r0) * 0.5f) * f28) - point.y;
        Matrix matrix3 = new Matrix();
        matrix3.setTranslate(f29, f36);
        float f37 = f18 - f29;
        float f38 = f19 - f36;
        matrix2.postConcat(matrix3);
        matrix2.postScale(f16, f16);
        Matrix matrix4 = new Matrix();
        matrix.invert(matrix4);
        RectF rectF = new RectF(f37, f38, f26 + f37, f27 + f38);
        matrix4.mapRect(rectF);
        TAVRectangle tAVRectangle = new TAVRectangle(rectF.left, rectF.top, rectF.width(), rectF.height());
        float f39 = tAVRectangle.f374471x;
        if (f39 < 0.0f) {
            tAVRectangle.width += f39;
            tAVRectangle.f374471x = 0.0f;
        }
        float f46 = tAVRectangle.f374472y;
        if (f46 < 0.0f) {
            tAVRectangle.height += f46;
            tAVRectangle.f374472y = 0.0f;
        }
        float f47 = tAVRectangle.f374471x;
        if (tAVRectangle.width + f47 > tAVSize.width) {
            tAVRectangle.width = tAVSize2.width - f47;
        }
        float f48 = tAVRectangle.f374472y;
        if (tAVRectangle.height + f48 > tAVSize.height) {
            tAVRectangle.height = tAVSize2.height - f48;
        }
        matrix.postConcat(matrix2);
        return tAVRectangle;
    }

    public static void getRotationMatrix(Matrix matrix, int i3, int i16, int i17) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        int i18 = i3 % 4;
        if (i18 < 0) {
            i18 += 4;
        }
        float f27 = -1.0f;
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 != 3) {
                    f27 = 1.0f;
                    f26 = 1.0f;
                    f16 = 0.0f;
                    f19 = 0.0f;
                    f17 = 0.0f;
                } else {
                    f19 = i16;
                    f18 = -1.0f;
                    f17 = 1.0f;
                    f16 = 0.0f;
                    f27 = 0.0f;
                }
            } else {
                f16 = i16;
                f19 = i17;
                f26 = -1.0f;
                f17 = 0.0f;
            }
            f18 = f17;
            matrix.setValues(new float[]{f27, f17, f16, f18, f26, f19, 0.0f, 0.0f, 1.0f});
        }
        f16 = i17;
        f17 = -1.0f;
        f18 = 1.0f;
        f19 = 0.0f;
        f27 = 0.0f;
        f26 = f27;
        matrix.setValues(new float[]{f27, f17, f16, f18, f26, f19, 0.0f, 0.0f, 1.0f});
    }

    public static TAVSize getTransformedSize(TAVSize tAVSize, int i3, float f16) {
        TAVSize m265clone = tAVSize.m265clone();
        if (Math.abs(i3) % 2 == 1) {
            int i16 = m265clone.width;
            m265clone.width = m265clone.height;
            m265clone.height = i16;
        }
        if (f16 > 0.0f) {
            int i17 = m265clone.width;
            if ((i17 * 1.0f) / m265clone.height > f16) {
                m265clone.width = (int) Math.ceil(r2 * f16);
            } else {
                m265clone.height = (int) Math.ceil((i17 * 1.0f) / f16);
            }
        }
        return m265clone;
    }

    private static void swap(float[] fArr, int i3, int i16) {
        float f16 = fArr[i3];
        fArr[i3] = fArr[i16];
        fArr[i16] = f16;
    }

    public static float[] toOpenGL2DMatrix(Matrix matrix) {
        float f16;
        float[] fArr = new float[9];
        if (matrix == null) {
            for (int i3 = 0; i3 < 9; i3++) {
                if (i3 % 4 == 0) {
                    f16 = 1.0f;
                } else {
                    f16 = 0.0f;
                }
                fArr[i3] = f16;
            }
        } else {
            matrix.getValues(fArr);
            swap(fArr, 1, 3);
            swap(fArr, 2, 6);
            swap(fArr, 5, 7);
        }
        return fArr;
    }
}
