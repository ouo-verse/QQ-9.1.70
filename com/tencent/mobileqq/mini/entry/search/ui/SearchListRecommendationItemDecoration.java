package com.tencent.mobileqq.mini.entry.search.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchListRecommendationItemDecoration extends RecyclerView.ItemDecoration {
    private int middleMargin = ViewUtils.dip2px(4.5f);
    private int headTailMargin = ViewUtils.dip2px(15.0f);
    private int topMargin = ViewUtils.dip2px(12.0f);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        int i16;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (recyclerView.getAdapter() == null) {
            return;
        }
        int itemCount = recyclerView.getAdapter().getItemCount();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (childAdapterPosition == 0) {
            i3 = this.headTailMargin;
        } else {
            i3 = this.middleMargin;
        }
        if (childAdapterPosition == itemCount - 1) {
            i16 = this.headTailMargin;
        } else {
            i16 = this.middleMargin;
        }
        layoutParams.setMargins(i3, this.topMargin, i16, 0);
        view.setLayoutParams(layoutParams);
        super.getItemOffsets(rect, view, recyclerView, state);
    }
}
