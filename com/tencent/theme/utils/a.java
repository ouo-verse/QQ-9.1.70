package com.tencent.theme.utils;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    @TargetApi(24)
    public static ColorStateList a(GradientDrawable gradientDrawable) {
        ColorStateList color;
        color = gradientDrawable.getColor();
        return color;
    }

    public static ColorStateList b(Drawable.ConstantState constantState) {
        if (constantState == null) {
            return null;
        }
        try {
            return (ColorStateList) constantState.getClass().getField("mColorStateList").get(constantState);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ColorStateList c(Drawable.ConstantState constantState) {
        if (constantState == null) {
            return null;
        }
        try {
            return (ColorStateList) constantState.getClass().getField("mSolidColors").get(constantState);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ColorStateList d(Drawable.ConstantState constantState) {
        if (constantState == null) {
            return null;
        }
        try {
            return (ColorStateList) constantState.getClass().getField("mStrokeColors").get(constantState);
        } catch (Exception unused) {
            return null;
        }
    }

    public static float e(Drawable.ConstantState constantState) {
        if (constantState == null) {
            return 0.0f;
        }
        try {
            return ((Float) constantState.getClass().getField("mStrokeDashGap").get(constantState)).floatValue();
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static float f(Drawable.ConstantState constantState) {
        if (constantState == null) {
            return 0.0f;
        }
        try {
            return ((Float) constantState.getClass().getField("mStrokeDashWidth").get(constantState)).floatValue();
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int g(Drawable.ConstantState constantState) {
        if (constantState == null) {
            return -1;
        }
        try {
            return ((Integer) constantState.getClass().getField("mStrokeWidth").get(constantState)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }
}
