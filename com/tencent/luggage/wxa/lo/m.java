package com.tencent.luggage.wxa.lo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {
    public static int a(int i3, int i16) {
        if (i16 >= 0 && i16 <= 100) {
            return (i3 & 16777215) | (((int) ((i16 * 0.01d) * 255.0d)) << 24);
        }
        n.b("alphaColor", "alpha must be between 0 and 100", new Object[0]);
        return i3;
    }

    public static int b(int i3, int i16) {
        return 255 - (((255 - i16) * (255 - i3)) / 255);
    }

    public static int c(int i3, int i16) {
        int alpha = Color.alpha(i16);
        int alpha2 = Color.alpha(i3);
        int b16 = b(alpha2, alpha);
        return Color.argb(b16, a(Color.red(i3), alpha2, Color.red(i16), alpha, b16), a(Color.green(i3), alpha2, Color.green(i16), alpha, b16), a(Color.blue(i3), alpha2, Color.blue(i16), alpha, b16));
    }

    public static Drawable a(Context context, int i3, int i16) {
        Drawable drawable = context.getResources().getDrawable(i3);
        if (drawable != null) {
            int i17 = i16 != 0 ? (16777215 & i16) | (-16777216) : i16;
            int alpha = Color.alpha(i16);
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i17, PorterDuff.Mode.SRC_ATOP));
            if (i16 != 0) {
                drawable.setAlpha(alpha);
            }
        }
        return drawable;
    }

    public static Drawable a(Drawable drawable, int i3) {
        if (drawable != null) {
            int i16 = i3 != 0 ? (16777215 & i3) | (-16777216) : i3;
            int alpha = Color.alpha(i3);
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i16, PorterDuff.Mode.SRC_ATOP));
            if (i3 != 0) {
                drawable.setAlpha(alpha);
            }
        }
        return drawable;
    }

    public static boolean a(int i3) {
        return 1.0d - ((((((double) Color.red(i3)) * 0.299d) + (((double) Color.green(i3)) * 0.587d)) + (((double) Color.blue(i3)) * 0.114d)) / 255.0d) >= 0.3d;
    }

    public static int a(int i3, int i16, int i17, int i18, int i19) {
        if (i19 == 0) {
            return 0;
        }
        return (((i3 * 255) * i16) + ((i17 * i18) * (255 - i16))) / (i19 * 255);
    }
}
