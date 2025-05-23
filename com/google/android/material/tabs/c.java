package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.I() && (view instanceof TabLayout.TabView)) {
            return b((TabLayout.TabView) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF b(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i3) {
        int l3 = tabView.l();
        int k3 = tabView.k();
        int c16 = (int) ViewUtils.c(tabView.getContext(), i3);
        if (l3 < c16) {
            l3 = c16;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i16 = l3 / 2;
        return new RectF(left - i16, top - (k3 / 2), i16 + left, top + (left / 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a16 = a(tabLayout, view);
        drawable.setBounds((int) a16.left, drawable.getBounds().top, (int) a16.right, drawable.getBounds().bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f16, @NonNull Drawable drawable) {
        RectF a16 = a(tabLayout, view);
        RectF a17 = a(tabLayout, view2);
        drawable.setBounds(x0.a.c((int) a16.left, (int) a17.left, f16), drawable.getBounds().top, x0.a.c((int) a16.right, (int) a17.right, f16), drawable.getBounds().bottom);
    }
}
