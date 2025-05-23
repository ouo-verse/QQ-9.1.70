package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
class a extends c {
    private static float e(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return (float) (1.0d - Math.cos((f16 * 3.141592653589793d) / 2.0d));
    }

    private static float f(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return (float) Math.sin((f16 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f16, @NonNull Drawable drawable) {
        boolean z16;
        float f17;
        float e16;
        RectF a16 = c.a(tabLayout, view);
        RectF a17 = c.a(tabLayout, view2);
        if (a16.left < a17.left) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f17 = e(f16);
            e16 = f(f16);
        } else {
            f17 = f(f16);
            e16 = e(f16);
        }
        drawable.setBounds(x0.a.c((int) a16.left, (int) a17.left, f17), drawable.getBounds().top, x0.a.c((int) a16.right, (int) a17.right, e16), drawable.getBounds().bottom);
    }
}
