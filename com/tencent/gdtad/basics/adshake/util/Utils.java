package com.tencent.gdtad.basics.adshake.util;

import android.graphics.Paint;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Utils {
    public static int buildColorFromARGB(float f16, float f17, float f18, float f19) {
        return (((int) ((f16 * 255.0f) + 0.5f)) << 24) | (((int) ((f17 * 255.0f) + 0.5f)) << 16) | (((int) ((f18 * 255.0f) + 0.5f)) << 8) | ((int) ((f19 * 255.0f) + 0.5f));
    }

    public static int getRelativeSize(int i3) {
        return (ViewUtils.getScreenWidth() * i3) / 750;
    }

    public static float getTextPaintBaselineToBottom(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        return Math.abs(paint.getFontMetrics().bottom);
    }

    public static float getTextPaintHeight(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return Math.abs((fontMetrics.leading + fontMetrics.bottom) - fontMetrics.top);
    }
}
