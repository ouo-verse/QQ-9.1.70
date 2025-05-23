package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class p extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f319319d;

    public p(int i3) {
        this.f319319d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        rect.left = this.f319319d;
        if (recyclerView.getAdapter() != null) {
            i3 = recyclerView.getAdapter().getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 != 0 && recyclerView.getChildLayoutPosition(view) == i3 - 1) {
            rect.right = this.f319319d;
        }
    }
}
