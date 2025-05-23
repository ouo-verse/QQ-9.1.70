package com.tencent.superplayer.seamless;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
/* loaded from: classes26.dex */
class VideoMoveAnimator implements VideoAnimator {
    private Animator.AnimatorListener animatorListener;
    private long duration;
    private ViewInfo fromViewInfo;
    private View targetView;
    private ViewInfo toViewInfo;

    public VideoMoveAnimator(View view, ViewInfo viewInfo, ViewInfo viewInfo2, long j3, Animator.AnimatorListener animatorListener) {
        this.targetView = view;
        this.fromViewInfo = viewInfo;
        this.toViewInfo = viewInfo2;
        this.duration = j3;
        this.animatorListener = animatorListener;
    }

    @Override // com.tencent.superplayer.seamless.VideoAnimator
    public void start() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.targetView, HippyTKDListViewAdapter.X, this.fromViewInfo.f373955x, this.toViewInfo.f373955x);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.targetView, "y", this.fromViewInfo.f373956y, this.toViewInfo.f373956y);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.fromViewInfo.width, this.toViewInfo.width);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.fromViewInfo.height, this.toViewInfo.height);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.superplayer.seamless.VideoMoveAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && valueAnimator.getAnimatedValue() != null) {
                    ViewGroup.LayoutParams layoutParams = VideoMoveAnimator.this.targetView.getLayoutParams();
                    layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    VideoMoveAnimator.this.targetView.setLayoutParams(layoutParams);
                }
            }
        });
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.superplayer.seamless.VideoMoveAnimator.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && valueAnimator.getAnimatedValue() != null) {
                    ViewGroup.LayoutParams layoutParams = VideoMoveAnimator.this.targetView.getLayoutParams();
                    layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    VideoMoveAnimator.this.targetView.setLayoutParams(layoutParams);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt, ofInt2);
        animatorSet.setDuration(this.duration);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(this.animatorListener);
        animatorSet.start();
    }
}
