package com.qq.e.comm.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RoundRectUtil {
    public static Drawable createRoundRectBorderDrawable(float f16, int i3, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f16);
        gradientDrawable.setStroke(i16, i3);
        gradientDrawable.setColor(i17);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    public static ShapeDrawable createRoundRectDrawable(float f16, int i3, int i16) {
        float[] fArr = new float[8];
        for (int i17 = 0; i17 < 8; i17++) {
            fArr[i17] = f16;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i3);
        shapeDrawable.getPaint().setAlpha(i16);
        return shapeDrawable;
    }

    public static ShapeDrawable createRoundRectDrawable(float[] fArr, int i3, int i16) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i3);
        shapeDrawable.getPaint().setAlpha(i16);
        return shapeDrawable;
    }
}
