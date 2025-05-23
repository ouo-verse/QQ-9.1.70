package com.tencent.mobileqq.wink.editor.templatecoll;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f322478d;

    public a(int i3) {
        this.f322478d = ViewUtils.dpToPx(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int itemCount = recyclerView.getLayoutManager().getItemCount();
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        int i3 = this.f322478d;
        rect.left = i3;
        if (viewLayoutPosition == itemCount - 1) {
            rect.right = i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
    }
}
