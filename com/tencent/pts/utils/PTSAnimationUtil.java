package com.tencent.pts.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

/* loaded from: classes22.dex */
public class PTSAnimationUtil {
    static IPatchRedirector $redirector_;

    /* loaded from: classes22.dex */
    public static class AnimationInfo {
        static IPatchRedirector $redirector_;
        private double delay;
        private double duration;
        private int keyCount;
        private String[] keys;
        private String timingFunction;

        /* loaded from: classes22.dex */
        public static class Builder {
            static IPatchRedirector $redirector_;
            private double delay;
            private double duration;
            private int keyCount;
            private String[] keys;
            private String timingFunction;

            public Builder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public AnimationInfo build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (AnimationInfo) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                AnimationInfo animationInfo = new AnimationInfo();
                animationInfo.keyCount = this.keyCount;
                animationInfo.keys = this.keys;
                animationInfo.duration = this.duration;
                animationInfo.timingFunction = this.timingFunction;
                animationInfo.delay = this.delay;
                return animationInfo;
            }

            public Builder withDelay(double d16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
                }
                this.delay = d16;
                return this;
            }

            public Builder withDuration(double d16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Builder) iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16));
                }
                this.duration = d16;
                return this;
            }

            public Builder withTimingFuction(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                this.timingFunction = str;
                return this;
            }
        }

        public AnimationInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PTSAnimationUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void playAnimation(AnimationInfo animationInfo, PTSNodeVirtual pTSNodeVirtual, PTSNodeInfo pTSNodeInfo, PTSNodeInfo pTSNodeInfo2) {
        if (animationInfo != null && pTSNodeVirtual != null && pTSNodeInfo != null && pTSNodeInfo2 != null) {
            View view = pTSNodeVirtual.getView();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(pTSNodeInfo.getStyle().getHeight(), pTSNodeInfo2.getStyle().getHeight());
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams, view) { // from class: com.tencent.pts.utils.PTSAnimationUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ FrameLayout.LayoutParams val$lp;
                final /* synthetic */ View val$view;

                {
                    this.val$lp = layoutParams;
                    this.val$view = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) layoutParams, (Object) view);
                    }
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                        return;
                    }
                    this.val$lp.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.val$view.setLayoutParams(this.val$lp);
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(pTSNodeInfo.getStyle().getTop(), pTSNodeInfo2.getStyle().getTop());
            ofInt2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams, view) { // from class: com.tencent.pts.utils.PTSAnimationUtil.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ FrameLayout.LayoutParams val$lp;
                final /* synthetic */ View val$view;

                {
                    this.val$lp = layoutParams;
                    this.val$view = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) layoutParams, (Object) view);
                    }
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                        return;
                    }
                    this.val$lp.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.val$view.setLayoutParams(this.val$lp);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter(pTSNodeInfo2) { // from class: com.tencent.pts.utils.PTSAnimationUtil.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ PTSNodeInfo val$newNodeInfo;

                {
                    this.val$newNodeInfo = pTSNodeInfo2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeVirtual.this, (Object) pTSNodeInfo2);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                    } else {
                        super.onAnimationEnd(animator);
                        PTSNodeVirtual.this.bindNodeInfo(this.val$newNodeInfo);
                    }
                }
            });
            animatorSet.setDuration((long) animationInfo.duration);
            animatorSet.setStartDelay((long) animationInfo.delay);
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        }
    }
}
