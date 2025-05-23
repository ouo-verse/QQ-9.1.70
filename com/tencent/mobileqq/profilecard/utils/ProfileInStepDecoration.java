package com.tencent.mobileqq.profilecard.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* loaded from: classes35.dex */
public class ProfileInStepDecoration extends RecyclerView.ItemDecoration {
    private int mMinPageVisibleWidth;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.mMinPageVisibleWidth == 0) {
            this.mMinPageVisibleWidth = (view.getResources().getDisplayMetrics().widthPixels - view.getResources().getDimensionPixelSize(R.dimen.d_m)) / 2;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (recyclerView.getAdapter() == null) {
            return;
        }
        int itemCount = recyclerView.getAdapter().getItemCount();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (childAdapterPosition == 0) {
            dimensionPixelSize = this.mMinPageVisibleWidth;
        } else {
            dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.f158700mp);
        }
        if (childAdapterPosition == itemCount - 1) {
            dimensionPixelSize2 = this.mMinPageVisibleWidth;
        } else {
            dimensionPixelSize2 = view.getResources().getDimensionPixelSize(R.dimen.f158700mp);
        }
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize2, 0);
        view.setLayoutParams(layoutParams);
        super.getItemOffsets(rect, view, recyclerView, state);
    }
}
