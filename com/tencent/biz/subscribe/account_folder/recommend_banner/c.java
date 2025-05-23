package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends RecyclerView.ItemDecoration {
    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            rect.left = x.c(view.getContext(), 3.0f);
            rect.right = 0;
            return;
        }
        if (recyclerView.getAdapter() != null && childAdapterPosition == r5.getItemCount() - 1) {
            rect.right = x.c(view.getContext(), 3.0f);
        } else {
            rect.right = 0;
        }
        rect.left = -x.c(view.getContext(), 6.0f);
    }
}
