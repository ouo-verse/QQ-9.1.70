package com.tencent.mobileqq.guild.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f236381d;

    /* renamed from: e, reason: collision with root package name */
    private int f236382e;

    /* renamed from: f, reason: collision with root package name */
    private int f236383f;

    /* renamed from: h, reason: collision with root package name */
    private int f236384h = 1;

    public k(Drawable drawable, int i3, int i16) {
        this.f236381d = drawable;
        this.f236382e = i3;
        this.f236383f = i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, this.f236384h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft() + this.f236382e;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f236383f;
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f236381d.setBounds(paddingLeft, bottom, width, this.f236384h + bottom);
            this.f236381d.draw(canvas);
        }
    }
}
