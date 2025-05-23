package com.tencent.mobileqq.emosm.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends RecyclerView.LayoutManager {

    /* renamed from: a, reason: collision with root package name */
    private View.OnClickListener f204443a;

    public a(View.OnClickListener onClickListener) {
        this.f204443a = onClickListener;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void layoutDecoratedWithMargins(View view, int i3, int i16, int i17, int i18) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutDecorated(view, i3 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i16 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount > 3) {
            for (int i3 = 3; i3 >= 0; i3--) {
                View viewForPosition = recycler.getViewForPosition(i3);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int width = getWidth() - getDecoratedMeasuredWidth(viewForPosition);
                int height = getHeight() - getDecoratedMeasuredHeight(viewForPosition);
                int i16 = width / 2;
                layoutDecoratedWithMargins(viewForPosition, i16, height, i16 + getDecoratedMeasuredWidth(viewForPosition), getDecoratedMeasuredHeight(viewForPosition) + height);
                if (i3 == 3) {
                    float f16 = 1.0f - ((i3 - 1) * 0.1f);
                    viewForPosition.setScaleX(f16);
                    viewForPosition.setScaleY(f16);
                    viewForPosition.setTranslationY((r4 * viewForPosition.getMeasuredHeight()) / (-10));
                    viewForPosition.setAlpha(0.8f);
                } else if (i3 > 0) {
                    float f17 = 1.0f - (i3 * 0.1f);
                    viewForPosition.setScaleX(f17);
                    viewForPosition.setScaleY(f17);
                    viewForPosition.setTranslationY((viewForPosition.getMeasuredHeight() * i3) / (-10));
                    viewForPosition.setAlpha(0.6f);
                } else {
                    View.OnClickListener onClickListener = this.f204443a;
                    if (onClickListener != null) {
                        viewForPosition.setOnClickListener(onClickListener);
                    }
                }
            }
            return;
        }
        for (int i17 = itemCount - 1; i17 >= 0; i17--) {
            View viewForPosition2 = recycler.getViewForPosition(i17);
            addView(viewForPosition2);
            measureChildWithMargins(viewForPosition2, 0, 0);
            int width2 = getWidth() - getDecoratedMeasuredWidth(viewForPosition2);
            int height2 = getHeight() - getDecoratedMeasuredHeight(viewForPosition2);
            int i18 = width2 / 2;
            layoutDecoratedWithMargins(viewForPosition2, i18, height2, i18 + getDecoratedMeasuredWidth(viewForPosition2), getDecoratedMeasuredHeight(viewForPosition2) + height2);
            if (i17 > 0) {
                float f18 = 1.0f - (i17 * 0.1f);
                viewForPosition2.setScaleX(f18);
                viewForPosition2.setScaleY(f18);
                viewForPosition2.setTranslationY((viewForPosition2.getMeasuredHeight() * i17) / (-10));
            } else {
                View.OnClickListener onClickListener2 = this.f204443a;
                if (onClickListener2 != null) {
                    viewForPosition2.setOnClickListener(onClickListener2);
                }
            }
        }
    }
}
