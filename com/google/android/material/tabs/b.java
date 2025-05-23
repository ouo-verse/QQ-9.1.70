package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
class b extends c {
    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f16, @NonNull Drawable drawable) {
        float b16;
        if (f16 >= 0.5f) {
            view = view2;
        }
        RectF a16 = c.a(tabLayout, view);
        if (f16 < 0.5f) {
            b16 = x0.a.b(1.0f, 0.0f, 0.0f, 0.5f, f16);
        } else {
            b16 = x0.a.b(0.0f, 1.0f, 0.5f, 1.0f, f16);
        }
        drawable.setBounds((int) a16.left, drawable.getBounds().top, (int) a16.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (b16 * 255.0f));
    }
}
