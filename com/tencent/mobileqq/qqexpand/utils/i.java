package com.tencent.mobileqq.qqexpand.utils;

import android.graphics.drawable.GradientDrawable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    public static GradientDrawable a(int i3, float f16, float f17, float f18, float f19) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f17, f17, f18, f18, f19, f19});
        return gradientDrawable;
    }
}
