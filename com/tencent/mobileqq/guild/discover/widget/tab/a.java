package com.tencent.mobileqq.guild.discover.widget.tab;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.discover.widget.tab.TabLayout;
import com.tencent.mobileqq.guild.util.cw;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public class a {
    private static RectF a(@NonNull TabLayout.TabView tabView, int i3) {
        int f16 = tabView.f();
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i16 = i3 / 2;
        return new RectF(left - i16, top - (f16 / 2), i16 + left, top + (left / 2));
    }

    static RectF b(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.E() > 0 && (view instanceof TabLayout.TabView)) {
            return a((TabLayout.TabView) view, tabLayout.E());
        }
        if (!tabLayout.F() && (view instanceof TabLayout.TabView)) {
            return c((TabLayout.TabView) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF c(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i3) {
        int g16 = tabView.g();
        int f16 = tabView.f();
        int f17 = (int) cw.f(i3);
        if (g16 < f17) {
            g16 = f17;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i16 = g16 / 2;
        return new RectF(left - i16, top - (f16 / 2), i16 + left, top + (left / 2));
    }

    public static int d(int i3, int i16, float f16) {
        return i3 + Math.round(f16 * (i16 - i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f16, @NonNull Drawable drawable) {
        RectF b16 = b(tabLayout, view);
        RectF b17 = b(tabLayout, view2);
        drawable.setBounds(d((int) b16.left, (int) b17.left, f16), drawable.getBounds().top, d((int) b16.right, (int) b17.right, f16), drawable.getBounds().bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF b16 = b(tabLayout, view);
        drawable.setBounds((int) b16.left, drawable.getBounds().top, (int) b16.right, drawable.getBounds().bottom);
    }
}
