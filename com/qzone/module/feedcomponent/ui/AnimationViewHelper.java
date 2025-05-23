package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AnimationViewHelper {
    private static final int angle = 15;
    private static final int extraWidth = 200;
    private static int height = dp2px(133.0f);
    private static final int height_dp = 133;
    private static TextView mask = null;
    private static final float speed = 0.15f;
    private static int viewWidth = 0;
    private static final int width = 80;

    private static boolean checkDoAnimation(CellFeedCommInfo cellFeedCommInfo) {
        return cellFeedCommInfo.hasDoAdvBtnAnimation;
    }

    private static void doAnimation(View view, Context context, int i3) {
        if (mask == null) {
            TextView textView = new TextView(context);
            mask = textView;
            textView.setLayoutParams(new RelativeLayout.LayoutParams(80, height));
        }
        int height2 = view.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mask.getLayoutParams();
        int i16 = (height2 - height) / 2;
        layoutParams.bottomMargin = i16;
        layoutParams.topMargin = i16;
        mask.setLayoutParams(layoutParams);
        if (mask.getParent() != null && (mask.getParent() instanceof ViewGroup)) {
            ((ViewGroup) mask.getParent()).removeView(mask);
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).addView(mask, 1);
        }
        mask.setBackgroundColor(i3);
        int width2 = view.getWidth();
        viewWidth = width2;
        AnimationSet animationSet = getAnimationSet(width2);
        if (animationSet == null) {
            return;
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.AnimationViewHelper.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AnimationViewHelper.mask.setVisibility(4);
                AnimationSet animationSet2 = AnimationViewHelper.getAnimationSet(AnimationViewHelper.viewWidth);
                if (animationSet2 == null) {
                    return;
                }
                animationSet2.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.AnimationViewHelper.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        AnimationViewHelper.mask.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                        AnimationViewHelper.mask.setVisibility(0);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                AnimationViewHelper.mask.startAnimation(animationSet2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AnimationViewHelper.mask.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mask.startAnimation(animationSet);
    }

    private static final int dp2px(float f16) {
        return (int) ((f16 * FeedGlobalEnv.g().getDensity()) + 0.5f);
    }

    private static void setDoAnimation(CellFeedCommInfo cellFeedCommInfo, boolean z16) {
        cellFeedCommInfo.hasDoAdvBtnAnimation = z16;
    }

    public static int getAdvButtonAnimation(CellFeedCommInfo cellFeedCommInfo) {
        if (cellFeedCommInfo == null || cellFeedCommInfo.getStMapABTest() == null || !cellFeedCommInfo.getStMapABTest().containsKey(13)) {
            return 0;
        }
        return cellFeedCommInfo.getStMapABTest().get(13).intValue();
    }

    public static void updateUI(View view, Context context, int i3, CellFeedCommInfo cellFeedCommInfo) {
        if (view == null || context == null || checkDoAnimation(cellFeedCommInfo) || getAdvButtonAnimation(cellFeedCommInfo) <= 0) {
            return;
        }
        doAnimation(view, context, i3);
        setDoAnimation(cellFeedCommInfo, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ExScaleAnimation extends ScaleAnimation {
        private float angle;
        private int height;
        private int transtX_end;
        private int transtX_start;
        private int width;

        @Override // android.view.animation.ScaleAnimation, android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            super.applyTransformation(f16, transformation);
            transformation.getMatrix().postTranslate(this.transtX_end + ((r1 - this.transtX_start) * (f16 - 1.0f)), 0.0f);
            transformation.getMatrix().postRotate(this.angle, this.width / 2, this.height / 2);
        }

        public void setTranst(int i3, int i16, int i17, int i18, int i19) {
            this.transtX_start = i3;
            this.transtX_end = i16;
            this.width = i17;
            this.height = i18;
            this.angle = i19;
        }

        public ExScaleAnimation(float f16, float f17, float f18, float f19) {
            super(f16, f17, f18, f19, 1, 0.5f, 1, 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AnimationSet getAnimationSet(int i3) {
        long j3 = (i3 + 200) / speed;
        ExScaleAnimation exScaleAnimation = new ExScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f);
        int i16 = (i3 - 80) / 2;
        exScaleAnimation.setTranst(-140, i16, 80, height, 15);
        long j16 = j3 / 2;
        exScaleAnimation.setDuration(j16);
        ExScaleAnimation exScaleAnimation2 = new ExScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f);
        exScaleAnimation2.setTranst(i16, (i3 + 100) - 40, 80, height, 15);
        exScaleAnimation2.setDuration(j16);
        exScaleAnimation2.setStartOffset(j16);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.6f);
        alphaAnimation.setDuration(j16);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.6f, 0.0f);
        alphaAnimation2.setDuration(j16);
        alphaAnimation2.setStartOffset(j16);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(exScaleAnimation);
        animationSet.addAnimation(exScaleAnimation2);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.setInterpolator(new LinearInterpolator());
        return animationSet;
    }
}
