package com.tencent.tavsticker.utils;

import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RectUtil {
    private static final String TAG = "RectUtil";

    public static int getRectHeight(Rect rect) {
        int i3 = rect != null ? rect.bottom - rect.top : 0;
        if (i3 > 0) {
            return i3;
        }
        return 0;
    }

    public static int getRectWidth(Rect rect) {
        int i3 = rect != null ? rect.right - rect.left : 0;
        if (i3 > 0) {
            return i3;
        }
        return 0;
    }

    public static Rect getStickerMoveLimitRect(RectF rectF, int i3, int i16) {
        if (rectF == null) {
            return null;
        }
        Rect rect = new Rect();
        float f16 = i3;
        rect.left = (int) (rectF.left * f16);
        float f17 = i16;
        rect.top = (int) (rectF.top * f17);
        rect.right = (int) (rectF.right * f16);
        rect.bottom = (int) (rectF.bottom * f17);
        if (!rectIsValid(rect)) {
            return null;
        }
        return rect;
    }

    public static Rect rectInset(Rect rect, int i3, int i16) {
        if (rect != null) {
            int i17 = rect.left;
            int i18 = rect.right;
            int i19 = rect.top;
            int i26 = rect.bottom;
            rect.left = i17 + i3;
            rect.top = i19 + i16;
            rect.right = i18 - i3;
            rect.bottom = i26 - i16;
            return rect;
        }
        return null;
    }

    public static boolean rectIsEmpty(Rect rect) {
        if (rect != null && rect.right - rect.left > 0 && rect.bottom - rect.top > 0) {
            return false;
        }
        return true;
    }

    public static boolean rectIsValid(Rect rect) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (rect != null && (i3 = rect.left) >= 0 && (i16 = rect.top) >= 0 && (i17 = rect.right) > 0 && (i18 = rect.bottom) > 0 && i17 - i3 > 0 && i18 - i16 > 0) {
            return true;
        }
        return false;
    }

    public static float getRectHeight(RectF rectF) {
        float f16 = rectF != null ? rectF.bottom - rectF.top : 0.0f;
        if (f16 > 0.0f) {
            return f16;
        }
        return 0.0f;
    }

    public static float getRectWidth(RectF rectF) {
        float f16 = rectF != null ? rectF.right - rectF.left : 0.0f;
        if (f16 > 0.0f) {
            return f16;
        }
        return 0.0f;
    }
}
