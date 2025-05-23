package com.tencent.tavsticker.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerUtil {
    private static final String TAG = "TAVStickerUtil";

    public static PointF[] computeRectanglePoints(Matrix matrix, float f16, float f17) {
        PointF[] pointFArr = {new PointF(), new PointF(), new PointF(), new PointF()};
        if (matrix != null && f16 > 0.0f && f17 > 0.0f) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            pointFArr[0].set(fArr[2], fArr[5]);
            pointFArr[1].set((fArr[0] * f16) + fArr[2], (fArr[3] * f16) + fArr[5]);
            pointFArr[2].set((fArr[0] * f16) + (fArr[1] * f17) + fArr[2], (fArr[3] * f16) + (fArr[4] * f17) + fArr[5]);
            pointFArr[3].set((fArr[1] * f17) + fArr[2], (fArr[4] * f17) + fArr[5]);
        }
        return pointFArr;
    }

    public static float covertCoordinate(float f16, int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            return (f16 / i3) * i16;
        }
        return f16;
    }

    public static float getDistance(PointF pointF, PointF pointF2) {
        if (pointF != null && pointF2 != null) {
            float f16 = pointF.x - pointF2.x;
            float f17 = pointF.y - pointF2.y;
            return (float) Math.sqrt((f16 * f16) + (f17 * f17));
        }
        return 0.0f;
    }

    public static Matrix getMatrix(TAVSticker tAVSticker, int i3, int i16) {
        RectF stickerRect;
        Matrix matrix = new Matrix();
        if (tAVSticker != null && (stickerRect = getStickerRect(tAVSticker, i3, i16, tAVSticker.getScale())) != null) {
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

    public static float getMaxXBy4Point(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f16 = pointF.x;
        float f17 = pointF2.x;
        if (f16 < f17) {
            f16 = f17;
        }
        float f18 = pointF3.x;
        if (f16 < f18) {
            f16 = f18;
        }
        float f19 = pointF4.x;
        if (f16 < f19) {
            return f19;
        }
        return f16;
    }

    public static float getMaxYBy4Point(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f16 = pointF.y;
        float f17 = pointF2.y;
        if (f16 < f17) {
            f16 = f17;
        }
        float f18 = pointF3.y;
        if (f16 < f18) {
            f16 = f18;
        }
        float f19 = pointF4.y;
        if (f16 < f19) {
            return f19;
        }
        return f16;
    }

    public static PointF getMiddlePoint(PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        if (pointF != null && pointF2 != null) {
            pointF3.set((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        }
        return pointF3;
    }

    public static float getMinXBy4Point(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f16 = pointF.x;
        float f17 = pointF2.x;
        if (f16 > f17) {
            f16 = f17;
        }
        float f18 = pointF3.x;
        if (f16 > f18) {
            f16 = f18;
        }
        float f19 = pointF4.x;
        if (f16 > f19) {
            return f19;
        }
        return f16;
    }

    public static float getMinYBy4Point(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f16 = pointF.y;
        float f17 = pointF2.y;
        if (f16 > f17) {
            f16 = f17;
        }
        float f18 = pointF3.y;
        if (f16 > f18) {
            f16 = f18;
        }
        float f19 = pointF4.y;
        if (f16 > f19) {
            return f19;
        }
        return f16;
    }

    public static float getRotation(PointF pointF, PointF pointF2) {
        if (pointF == null || pointF2 == null) {
            return 0.0f;
        }
        return getRotation(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    public static RectF getStickerRect(TAVSticker tAVSticker, int i3, int i16, float f16) {
        if (tAVSticker != null && i3 > 0 && i16 > 0) {
            if (i3 % 2 != 0) {
                i3++;
            }
            if (i16 % 2 != 0) {
                i16++;
            }
            RectF rectF = new RectF();
            int width = tAVSticker.getWidth();
            int height = tAVSticker.getHeight();
            float f17 = i3;
            float f18 = f16 * f17;
            float f19 = 0.0f;
            if (width > 0 && f18 > 0.0f) {
                f19 = ((height * 1.0f) / width) * f18;
            }
            if (tAVSticker.getScaleMode() == 1) {
                float max = Math.max((f17 * 1.0f) / f18, (i16 * 1.0f) / f19);
                f18 *= max;
                f19 *= max;
            }
            float centerX = (tAVSticker.getCenterX() * f17) - (f18 / 2.0f);
            float centerY = (tAVSticker.getCenterY() * i16) - (f19 / 2.0f);
            rectF.left = (float) Math.floor(centerX);
            rectF.top = (float) Math.floor(centerY);
            rectF.bottom = (float) Math.ceil(centerY + f19);
            rectF.right = (float) Math.ceil(centerX + f18);
            TLog.d(TAG, "getStickerRect -> parentWidth: " + i3 + ", parentHeight:" + i16 + ", StickerRect-left: " + rectF.left + ", top: " + rectF.top + ", bottom: " + rectF.bottom + ", right: " + rectF.right);
            return rectF;
        }
        return null;
    }

    public static boolean inQuadrangle(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5) {
        if (Math.abs((((triangleArea(pointF, pointF2, pointF5) + triangleArea(pointF2, pointF3, pointF5)) + triangleArea(pointF3, pointF4, pointF5)) + triangleArea(pointF4, pointF, pointF5)) - (triangleArea(pointF, pointF2, pointF3) + triangleArea(pointF3, pointF4, pointF))) < 4.0d) {
            return true;
        }
        return false;
    }

    public static boolean isPresentationTimeInStickerTimeRange(long j3, TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            CMTimeRange timeRange = tAVSticker.getTimeRange();
            if (timeRange == null) {
                return true;
            }
            return TimeRangeUtil.isInTimeRange(timeRange, j3);
        }
        return false;
    }

    public static boolean isSameTAVSticker(TAVSticker tAVSticker, TAVSticker tAVSticker2) {
        if (tAVSticker == null && tAVSticker2 == null) {
            return true;
        }
        if (tAVSticker != null && tAVSticker2 != null) {
            return TextUtils.equals(tAVSticker.getUniqueId(), tAVSticker2.getUniqueId());
        }
        return false;
    }

    public static boolean isValidCGSize(CGSize cGSize) {
        if (cGSize != null && cGSize.width > 0.0f && cGSize.height > 0.0f) {
            return true;
        }
        return false;
    }

    public static float microsecond2Seconds(long j3) {
        return (((float) j3) * 1.0f) / 1000000.0f;
    }

    public static float millisecond2Seconds(long j3) {
        return (((float) j3) * 1.0f) / 1000.0f;
    }

    private static double triangleArea(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF.x;
        float f17 = pointF2.y;
        float f18 = pointF2.x;
        float f19 = pointF3.y;
        float f26 = pointF3.x;
        float f27 = pointF.y;
        return Math.abs(((((((f16 * f17) + (f18 * f19)) + (f26 * f27)) - (f18 * f27)) - (f26 * f17)) - (f16 * f19)) / 2.0d);
    }

    public static float getRotation(MotionEvent motionEvent) {
        return getRotation(motionEvent.getX(1) - motionEvent.getX(0), motionEvent.getY(1) - motionEvent.getY(0));
    }

    public static float getRotation(double d16, double d17) {
        return (float) Math.toDegrees(Math.atan2(d17, d16));
    }
}
