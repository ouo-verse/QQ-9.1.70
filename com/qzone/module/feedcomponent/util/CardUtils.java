package com.qzone.module.feedcomponent.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CardUtils {
    public static final int CARD_RADIUS_12 = 12;
    public static final int CARD_RADIUS_8 = 8;
    public static final int CARD_SHADOW_SIZE;
    private static final int CARD_SHADOW_START_COLOR = 352321536;
    public static final int CARD_SHADOW_TOP_SPACE;
    public static final int CARD_SHADOW_WIDTH_SPACE;
    private static final Xfermode SHADOW_PAINT_XFERMODE;
    public static final float SHADOW_TOP_POWER = 0.1f;
    public static final float SHADOW_WIDTH_POWER = 0.5f;

    static {
        int i3 = AreaConst.f48749dp4;
        CARD_SHADOW_SIZE = i3;
        CARD_SHADOW_WIDTH_SPACE = (int) (i3 * 0.5f);
        CARD_SHADOW_TOP_SPACE = (int) (i3 * 0.1f);
        SHADOW_PAINT_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    }

    public static void drawCardShadow(Canvas canvas, RectF rectF, int i3, Paint paint) {
        drawCardShadow(canvas, rectF, true, i3, CARD_SHADOW_START_COLOR, CARD_SHADOW_SIZE, paint, 0);
    }

    private static int getTransparentColor(int i3) {
        return Color.blue(i3) | (Color.red(i3) << 16) | (Color.green(i3) << 8);
    }

    public static void drawCardShadow(Canvas canvas, RectF rectF, int i3, Paint paint, int i16) {
        drawCardShadow(canvas, rectF, true, i3, CARD_SHADOW_START_COLOR, CARD_SHADOW_SIZE, paint, i16);
    }

    public static void drawCardShadow(Canvas canvas, RectF rectF, boolean z16, int i3, Paint paint) {
        drawCardShadow(canvas, rectF, z16, i3, CARD_SHADOW_START_COLOR, CARD_SHADOW_SIZE, paint, 0);
    }

    public static void drawCardShadow(Canvas canvas, RectF rectF, boolean z16, int i3, int i16, int i17, Paint paint, int i18) {
        int i19 = CARD_SHADOW_WIDTH_SPACE;
        int i26 = CARD_SHADOW_TOP_SPACE;
        canvas.translate(-i19, -i26);
        rectF.left += i19;
        rectF.top += i26;
        if (z16) {
            rectF.right += i19;
            rectF.bottom += i26;
        } else {
            rectF.right -= i19;
            rectF.bottom -= i26;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(false);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        paint.setXfermode(SHADOW_PAINT_XFERMODE);
        RectF rectF2 = new RectF();
        for (int i27 = i17 - 1; i27 > -1; i27--) {
            float f16 = i27;
            paint.setColor(evaluate(shadowFractionTransform(f16 / i17), i16, getTransparentColor(i16)));
            float f17 = 0.5f * f16;
            rectF2.left = (rectF.left - 1.0f) - f17;
            rectF2.top = (rectF.top - 1.0f) - (0.1f * f16);
            rectF2.right = rectF.right + 1.0f + f17;
            rectF2.bottom = rectF.bottom + 1.0f + f16;
            float f18 = i3;
            canvas.drawRoundRect(rectF2, f18, f18, paint);
        }
        paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        paint.setAntiAlias(true);
        paint.setColor(j.H());
        float f19 = i3;
        canvas.drawRoundRect(rectF, f19, f19, paint);
        if (i18 != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(i18);
            canvas.drawRoundRect(rectF, f19, f19, paint);
        }
        int i28 = CARD_SHADOW_WIDTH_SPACE;
        int i29 = CARD_SHADOW_TOP_SPACE;
        canvas.translate(i28, i29);
        rectF.left -= i28;
        rectF.top -= i29;
        if (z16) {
            rectF.right -= i28;
            rectF.bottom -= i29;
        } else {
            rectF.right += i28;
            rectF.bottom += i29;
        }
    }

    private static float shadowFractionTransform(float f16) {
        return (float) Math.pow(f16, 0.8d);
    }

    private static int evaluate(float f16, int i3, int i16) {
        if (i3 == i16) {
            return i3;
        }
        float f17 = ((i3 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((i3 >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((i3 >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((i3 & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((i16 >> 16) & 255) / 255.0f, 2.2d);
        float f18 = f17 + (((((i16 >> 24) & 255) / 255.0f) - f17) * f16);
        float pow5 = pow2 + ((((float) Math.pow(((i16 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f16);
        float pow6 = pow3 + (f16 * (((float) Math.pow((i16 & 255) / 255.0f, 2.2d)) - pow3));
        return (Math.round(((float) Math.pow(pow + ((pow4 - pow) * f16), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f18 * 255.0f) << 24) | (Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow6, 0.45454545454545453d)) * 255.0f);
    }
}
