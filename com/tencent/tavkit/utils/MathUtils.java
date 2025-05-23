package com.tencent.tavkit.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MathUtils {
    public static CGRect rect(CGRect cGRect, CGRect cGRect2) {
        CGSize size = size(cGRect.size, cGRect2.size);
        PointF pointF = cGRect2.origin;
        float f16 = pointF.x;
        CGSize cGSize = cGRect2.size;
        float f17 = cGSize.width;
        float f18 = size.width;
        float f19 = pointF.y;
        float f26 = cGSize.height;
        float f27 = size.height;
        return new CGRect(f16 + ((f17 - f18) / 2.0f), f19 + ((f26 - f27) / 2.0f), f18, f27);
    }

    public static CGRect rectFill(CGRect cGRect, CGRect cGRect2) {
        CGSize sizeFill = sizeFill(cGRect.size, cGRect2.size);
        PointF pointF = cGRect2.origin;
        float f16 = pointF.x;
        CGSize cGSize = cGRect2.size;
        float f17 = cGSize.width;
        float f18 = sizeFill.width;
        float f19 = pointF.y;
        float f26 = cGSize.height;
        float f27 = sizeFill.height;
        return new CGRect(f16 + ((f17 - f18) / 2.0f), f19 + ((f26 - f27) / 2.0f), f18, f27);
    }

    public static CGRect rectFit(CGRect cGRect, CGRect cGRect2) {
        CGSize sizeFit = sizeFit(cGRect.size, cGRect2.size);
        PointF pointF = cGRect2.origin;
        float f16 = pointF.x;
        CGSize cGSize = cGRect2.size;
        float f17 = cGSize.width;
        float f18 = sizeFit.width;
        float f19 = pointF.y;
        float f26 = cGSize.height;
        float f27 = sizeFit.height;
        return new CGRect(f16 + ((f17 - f18) / 2.0f), f19 + ((f26 - f27) / 2.0f), f18, f27);
    }

    public static CGSize size(CGSize cGSize, CGSize cGSize2) {
        CGSize m258clone = cGSize2.m258clone();
        float f16 = cGSize2.width;
        float f17 = cGSize.width;
        float f18 = f16 / f17;
        float f19 = cGSize2.height;
        float f26 = cGSize.height;
        float f27 = f19 / f26;
        if (f27 > f18) {
            m258clone.width = f27 * f17;
        } else if (f18 > f27) {
            m258clone.height = f18 * f26;
        }
        return m258clone;
    }

    public static CGSize sizeFill(CGSize cGSize, CGSize cGSize2) {
        CGSize m258clone = cGSize2.m258clone();
        float f16 = cGSize2.width;
        float f17 = cGSize.width;
        float f18 = f16 / f17;
        float f19 = cGSize2.height;
        float f26 = cGSize.height;
        float f27 = f19 / f26;
        if (f27 > f18) {
            m258clone.width = f27 * f17;
        } else if (f18 > f27) {
            m258clone.height = f18 * f26;
        }
        return m258clone;
    }

    public static CGSize sizeFit(CGSize cGSize, CGSize cGSize2) {
        CGSize m258clone = cGSize2.m258clone();
        float f16 = cGSize2.width / cGSize.width;
        float f17 = cGSize2.height / cGSize.height;
        if (f17 < f16) {
            m258clone.width = Math.round(f17 * r2);
        } else if (f16 < f17) {
            m258clone.height = Math.round(f16 * r4);
        }
        return m258clone;
    }

    public static Matrix transformBySourceRect(CGRect cGRect, CGRect cGRect2) {
        CGRect rect = rect(cGRect, cGRect2);
        CGSize cGSize = rect.size;
        float f16 = cGSize.width;
        CGSize cGSize2 = cGRect.size;
        float f17 = f16 / cGSize2.width;
        float f18 = cGSize.height / cGSize2.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f17, f18);
        PointF pointF = rect.origin;
        float f19 = pointF.x;
        PointF pointF2 = cGRect.origin;
        matrix.postTranslate(f19 - (pointF2.x * f17), pointF.y - (pointF2.y * f18));
        return matrix;
    }

    public static Matrix transformBySourceRectFill(CGRect cGRect, CGRect cGRect2) {
        CGRect rectFill = rectFill(cGRect, cGRect2);
        CGSize cGSize = rectFill.size;
        float f16 = cGSize.width;
        CGSize cGSize2 = cGRect.size;
        float f17 = f16 / cGSize2.width;
        float f18 = cGSize.height / cGSize2.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f17, f18);
        PointF pointF = rectFill.origin;
        float f19 = pointF.x;
        PointF pointF2 = cGRect.origin;
        matrix.postTranslate(f19 - (pointF2.x * f17), pointF.y - (pointF2.y * f18));
        return matrix;
    }

    public static Matrix transformBySourceRectFit(CGRect cGRect, CGRect cGRect2) {
        CGRect rectFit = rectFit(cGRect, cGRect2);
        CGSize cGSize = rectFit.size;
        float f16 = cGSize.width;
        CGSize cGSize2 = cGRect.size;
        float f17 = f16 / cGSize2.width;
        float f18 = cGSize.height / cGSize2.height;
        Matrix matrix = new Matrix();
        PointF pointF = rectFit.origin;
        float f19 = pointF.x;
        PointF pointF2 = cGRect.origin;
        float f26 = f19 - (pointF2.x * f17);
        float f27 = pointF.y - (pointF2.y * f18);
        matrix.postScale(f17, f18);
        matrix.postTranslate(f26, f27);
        return matrix;
    }

    public static CGSize sizeScale(CGSize cGSize, CGSize cGSize2) {
        return cGSize2;
    }
}
