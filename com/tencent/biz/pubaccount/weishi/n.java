package com.tencent.biz.pubaccount.weishi;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    public static final int f80927d = com.tencent.biz.pubaccount.weishi.util.r.H(5.0f);

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            int spanIndex = layoutParams.getSpanIndex();
            if (layoutParams.isFullSpan()) {
                int i3 = f80927d;
                rect.left = i3;
                rect.right = i3;
            } else if (spanIndex % 2 == 0) {
                int i16 = f80927d;
                rect.left = i16;
                rect.right = i16 / 2;
            } else {
                int i17 = f80927d;
                rect.left = i17 / 2;
                rect.right = i17;
            }
            rect.top = f80927d;
            return;
        }
        if ((recyclerView.getLayoutManager() instanceof LinearLayoutManager) && ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 0) {
            rect.right = f80927d;
        }
    }
}
