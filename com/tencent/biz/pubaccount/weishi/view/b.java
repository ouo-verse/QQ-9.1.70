package com.tencent.biz.pubaccount.weishi.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f82441d;

    /* renamed from: e, reason: collision with root package name */
    private int f82442e;

    public b(int i3, int i16) {
        this.f82441d = i3;
        this.f82442e = i16;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition < 0) {
            return;
        }
        int i3 = this.f82441d;
        int i16 = childAdapterPosition % i3;
        int i17 = this.f82442e;
        rect.left = (i16 * i17) / i3;
        rect.right = i17 - (((i16 + 1) * i17) / i3);
    }
}
