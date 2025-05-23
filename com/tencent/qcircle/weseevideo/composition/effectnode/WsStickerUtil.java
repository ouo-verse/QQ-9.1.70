package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WsStickerUtil {
    private static final int CLICK_MARGIN = 35;

    public static PointF[] computeRectanglePoints(Matrix matrix, float f16, float f17) {
        PointF[] pointFArr = {new PointF(), new PointF(), new PointF(), new PointF()};
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preTranslate(-35.0f, -35.0f);
        float f18 = f16 + 70.0f;
        float f19 = f17 + 70.0f;
        if (f18 > 0.0f && f19 > 0.0f) {
            float[] fArr = new float[9];
            matrix2.getValues(fArr);
            pointFArr[0].set(fArr[2], fArr[5]);
            pointFArr[1].set((fArr[0] * f18) + fArr[2], (fArr[3] * f18) + fArr[5]);
            pointFArr[2].set((fArr[0] * f18) + (fArr[1] * f19) + fArr[2], (fArr[3] * f18) + (fArr[4] * f19) + fArr[5]);
            pointFArr[3].set((fArr[1] * f19) + fArr[2], (fArr[4] * f19) + fArr[5]);
        }
        return pointFArr;
    }

    public static PointF[] computeRectanglePointsForBlurSticker(Matrix matrix, float f16, float f17) {
        PointF[] pointFArr = {new PointF(), new PointF(), new PointF(), new PointF()};
        if (matrix != null && f16 > 0.0f && f17 > 0.0f) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            pointFArr[0].set(fArr[2] - 35.0f, fArr[5] - 35.0f);
            pointFArr[1].set((fArr[0] * f16) + fArr[2] + 35.0f, ((fArr[3] * f16) + fArr[5]) - 35.0f);
            pointFArr[2].set((fArr[0] * f16) + (fArr[1] * f17) + fArr[2] + 35.0f, (fArr[3] * f16) + (fArr[4] * f17) + fArr[5] + 35.0f);
            pointFArr[3].set(((fArr[1] * f17) + fArr[2]) - 35.0f, (fArr[4] * f17) + fArr[5] + 35.0f);
        }
        return pointFArr;
    }

    public static Matrix getRatioChangeMatrix(TAVSticker tAVSticker, int i3, int i16) {
        RectF stickerRect;
        Matrix matrix = new Matrix();
        if (tAVSticker != null && (stickerRect = getStickerRect(tAVSticker, i3, i16, TAVStickerExKt.getStickerScaleX(tAVSticker), TAVStickerExKt.getStickerScaleY(tAVSticker))) != null) {
            int width = tAVSticker.getWidth();
            int height = tAVSticker.getHeight();
            matrix.setTranslate((-width) * 0.5f, (-height) * 0.5f);
            float f16 = stickerRect.right - stickerRect.left;
            float f17 = stickerRect.bottom - stickerRect.top;
            if (width != 0 && height != 0) {
                matrix.postScale((f16 * 1.0f) / width, (1.0f * f17) / height);
            }
            matrix.postRotate(tAVSticker.getRotate());
            matrix.postTranslate((float) Math.ceil(stickerRect.left + (f16 / 2.0f)), (float) Math.ceil(stickerRect.top + (f17 / 2.0f)));
        }
        return matrix;
    }

    public static RectF getStickerRect(TAVSticker tAVSticker, int i3, int i16, float f16, float f17) {
        if (tAVSticker != null && i3 > 0 && i16 > 0) {
            if (i3 % 2 != 0) {
                i3++;
            }
            if (i16 % 2 != 0) {
                i16++;
            }
            RectF rectF = new RectF();
            float f18 = i3;
            float f19 = f16 * f18;
            float height = (((tAVSticker.getHeight() * f19) * 1.0f) * f17) / (f16 * tAVSticker.getWidth());
            if (tAVSticker.getScaleMode() == 1) {
                float max = Math.max((f18 * 1.0f) / f19, (i16 * 1.0f) / height);
                f19 *= max;
                height *= max;
            }
            float centerX = (tAVSticker.getCenterX() * f18) - (f19 / 2.0f);
            float centerY = (tAVSticker.getCenterY() * i16) - (height / 2.0f);
            rectF.left = (float) Math.floor(centerX);
            rectF.top = (float) Math.floor(centerY);
            rectF.bottom = (float) Math.ceil(centerY + height);
            rectF.right = (float) Math.ceil(centerX + f19);
            return rectF;
        }
        return null;
    }
}
