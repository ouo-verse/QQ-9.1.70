package com.tencent.mobileqq.guild.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes14.dex */
class t implements ItemTouchUIUtil {

    /* renamed from: a, reason: collision with root package name */
    static final ItemTouchUIUtil f236633a = new t();

    t() {
    }

    private static float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt != view) {
                float elevation = ViewCompat.getElevation(childAt);
                if (elevation > f16) {
                    f16 = elevation;
                }
            }
        }
        return f16;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View view) {
        Object tag = view.getTag(R.id.dr8);
        if (tag instanceof Float) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(R.id.dr8, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
        if (z16 && view.getTag(R.id.dr8) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
            ViewCompat.setElevation(view, a(recyclerView, view) + 1.0f);
            view.setTag(R.id.dr8, valueOf);
        }
        view.setTranslationX(f16);
        view.setTranslationY(f17);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View view) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
    }
}
