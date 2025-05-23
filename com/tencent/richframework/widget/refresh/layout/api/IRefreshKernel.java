package com.tencent.richframework.widget.refresh.layout.api;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRefreshKernel {
    ValueAnimator animSpinner(int i3);

    IRefreshKernel finishTwoLevel();

    @NonNull
    IRefreshLayout getRefreshLayout();

    IRefreshKernel moveSpinner(int i3, boolean z16);

    IRefreshKernel onAutoLoadMoreAnimationEnd(Animator animator, boolean z16);

    IRefreshKernel onAutoRefreshAnimationEnd(Animator animator, boolean z16);

    IRefreshKernel requestDrawBackgroundFor(@NonNull IRefreshComponent iRefreshComponent, int i3);

    IRefreshKernel setState(@NonNull RefreshState refreshState);
}
