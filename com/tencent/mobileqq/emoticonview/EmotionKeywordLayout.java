package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionKeywordLayout extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final int Height_Normal = 81;
    private static final int Height_WidthTitle = 100;
    private static final String TAG = "EmotionKeywordLayout";
    private LinearLayout mAnimationContainer;
    private Animator.AnimatorListener mAnimatorListener;
    private EmotionKeywordHorizonListView mEmotionView;
    private boolean mEnableAnim;
    private int mHeight;
    private ValueAnimator mHideAnim;
    private OnVisibilityListener mOnVisibilityListener;
    private ValueAnimator mShowAnim;
    private LinearLayout mTitleContainer;
    private TextView mTitleView;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface OnVisibilityListener {
        void onVisibilityChanged(int i3);
    }

    public EmotionKeywordLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mAnimatorListener = new com.tencent.mobileqq.widget.f() { // from class: com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                        return;
                    }
                    if (animator == EmotionKeywordLayout.this.mHideAnim) {
                        EmotionKeywordLayout.this.setVisibility(8);
                    }
                    if (EmotionKeywordLayout.this.mEmotionView != null) {
                        EmotionKeywordLayout.this.mEmotionView.resetCurrentX(0);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                    }
                }
            };
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void initUIView() {
        if (this.mTitleContainer == null) {
            this.mTitleContainer = (LinearLayout) findViewById(R.id.uso);
        }
        if (this.mTitleView == null) {
            this.mTitleView = (TextView) findViewById(R.id.usn);
        }
        if (this.mEmotionView == null) {
            this.mEmotionView = (EmotionKeywordHorizonListView) findViewById(R.id.bvm);
        }
        if (this.mAnimationContainer == null) {
            this.mAnimationContainer = (LinearLayout) findViewById(R.id.spu);
        }
    }

    private void updateHeight() {
        int i3;
        if (this.mTitleContainer.getVisibility() == 0) {
            i3 = 100;
        } else {
            i3 = 81;
        }
        this.mHeight = Utils.n(i3, getResources());
    }

    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        initUIView();
        if (getVisibility() == 8) {
            return;
        }
        if (!this.mEnableAnim) {
            setVisibility(8);
            return;
        }
        ValueAnimator valueAnimator = this.mHideAnim;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator valueAnimator2 = this.mShowAnim;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mShowAnim.cancel();
        }
        if (this.mHideAnim == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.mHeight);
            this.mHideAnim = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
                    }
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator3);
                        return;
                    }
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    if (EmotionKeywordLayout.this.mAnimationContainer != null) {
                        EmotionKeywordLayout.this.mAnimationContainer.setTranslationY(floatValue);
                    }
                }
            });
            this.mHideAnim.setDuration(200L);
            this.mHideAnim.addListener(this.mAnimatorListener);
        }
        this.mHideAnim.start();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setEnableAnim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mEnableAnim = z16;
        }
    }

    public void setOnVisibilityListener(OnVisibilityListener onVisibilityListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onVisibilityListener);
        } else {
            this.mOnVisibilityListener = onVisibilityListener;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        OnVisibilityListener onVisibilityListener = this.mOnVisibilityListener;
        if (onVisibilityListener != null) {
            onVisibilityListener.onVisibilityChanged(i3);
        }
    }

    public void show(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "show");
        }
        initUIView();
        if (StringUtil.isEmpty(str)) {
            this.mTitleView.setText("");
            this.mTitleContainer.setVisibility(8);
        } else {
            this.mTitleView.setText(str);
            this.mTitleContainer.setVisibility(0);
        }
        updateHeight();
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        ValueAnimator valueAnimator = this.mShowAnim;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator valueAnimator2 = this.mHideAnim;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mHideAnim.cancel();
        }
        if (this.mShowAnim == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mHeight, 0.0f);
            this.mShowAnim = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
                    }
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator3);
                        return;
                    }
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    if (QLog.isColorLevel()) {
                        QLog.d(EmotionKeywordLayout.TAG, 2, "show:offset=" + floatValue);
                    }
                    if (EmotionKeywordLayout.this.mAnimationContainer != null) {
                        EmotionKeywordLayout.this.mAnimationContainer.setTranslationY(floatValue);
                    }
                }
            });
            this.mShowAnim.setDuration(200L);
            this.mShowAnim.addListener(this.mAnimatorListener);
        }
        this.mShowAnim.start();
        invalidate();
    }

    public EmotionKeywordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mAnimatorListener = new com.tencent.mobileqq.widget.f() { // from class: com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionKeywordLayout.this);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                        return;
                    }
                    if (animator == EmotionKeywordLayout.this.mHideAnim) {
                        EmotionKeywordLayout.this.setVisibility(8);
                    }
                    if (EmotionKeywordLayout.this.mEmotionView != null) {
                        EmotionKeywordLayout.this.mEmotionView.resetCurrentX(0);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                    }
                }
            };
            this.mHeight = Utils.n(81.0f, context.getResources());
        }
    }
}
