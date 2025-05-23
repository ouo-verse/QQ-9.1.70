package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f275385d;

    public k(int i3) {
        this.f275385d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        rect.left = this.f275385d;
        if (recyclerView.getAdapter() != null) {
            i3 = recyclerView.getAdapter().getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 != 0 && recyclerView.getChildLayoutPosition(view) == i3 - 1) {
            rect.right = this.f275385d;
        }
    }
}
