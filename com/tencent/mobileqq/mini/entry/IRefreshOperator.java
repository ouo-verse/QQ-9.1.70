package com.tencent.mobileqq.mini.entry;

import android.animation.Animator;
import android.view.View;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IRefreshOperator {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface UIReadyCallback {
        void onUIReady();
    }

    void close();

    boolean isTwoLevelShow();

    void maskFullScreenView(View view, boolean z16);

    boolean needInterceptTouch();

    void openTwoLevel(Animator.AnimatorListener animatorListener);

    void switchTwoLevel(boolean z16);
}
