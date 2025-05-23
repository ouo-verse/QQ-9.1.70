package com.tencent.richframework.widget.refresh.layout.api;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.richframework.widget.refresh.layout.listener.ScrollBoundaryDecider;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRefreshContent {
    boolean canLoadMore();

    boolean canRefresh();

    @NonNull
    View getScrollableView();

    @NonNull
    View getView();

    void moveSpinner(int i3, int i16, int i17);

    void onActionDown(MotionEvent motionEvent);

    ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int i3);

    void setEnableLoadMoreWhenContentNotFull(boolean z16);

    void setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider);

    void setUpComponent(IRefreshKernel iRefreshKernel, View view, View view2);
}
