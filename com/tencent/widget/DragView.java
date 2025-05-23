package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DragView extends RelativeLayout implements GestureDetector.OnGestureListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "DragView";
    private float alphaOffset;
    private View curView;
    private float downX;
    private float downY;
    private boolean enableDrag;
    private boolean firstDown;
    private boolean isInAnimation;
    private OnDragChangeListener mDragChangeListener;
    public boolean mFinishAnimation;
    private OnGestureChangeListener mGestureChangeListener;
    private GestureDetector mGestureDetector;
    private float mScrollDisX;
    private float mScrollDisY;
    private Rect originRect;
    private AnimatorSet quitAnim;
    private boolean ratioModify;
    private AnimatorSet releaseAnim;
    private float scale;
    private float scaleThreshold;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnDragChangeListener {
        int[] onModifyCurViewSize();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnGestureChangeListener {
        void onClickDragView();

        void onContentMove(float f16);

        void onGestureFinish();

        void onResetPosition();
    }

    public DragView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void onContentMove(float f16) {
        OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
        if (onGestureChangeListener != null) {
            onGestureChangeListener.onContentMove(f16);
        }
    }

    private void onUP(MotionEvent motionEvent) {
        this.releaseAnim.setupStartValues();
        startReleaseAnim();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Integer.valueOf(i3), layoutParams);
            return;
        }
        if (this.curView != null) {
            return;
        }
        super.addView(view, i3, layoutParams);
        this.curView = view;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.curView, "translationY", 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.curView, BasicAnimation.KeyPath.SCALE_X, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.curView, BasicAnimation.KeyPath.SCALE_Y, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.releaseAnim = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ofFloat4.addUpdateListener(this);
        this.releaseAnim.addListener(this);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.curView, "translationX", 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.curView, "translationY", 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.curView, BasicAnimation.KeyPath.SCALE_X, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.curView, BasicAnimation.KeyPath.SCALE_Y, 0.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.quitAnim = animatorSet2;
        animatorSet2.playTogether(ofFloat5, ofFloat6, ofFloat7, ofFloat8);
        ofFloat8.addUpdateListener(this);
        this.quitAnim.addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getCurView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.curView;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.curView.setScaleX(1.0f);
        this.curView.setScaleY(1.0f);
        this.curView.setTranslationX(0.0f);
        this.curView.setTranslationY(0.0f);
        this.mFinishAnimation = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, animator, Boolean.valueOf(z16));
        } else {
            this.isInAnimation = false;
            onAnimationEnd(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            this.isInAnimation = true;
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) animator);
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f16;
        int height;
        float floatValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) valueAnimator);
            return;
        }
        Float f17 = (Float) valueAnimator.getAnimatedValue();
        if (this.quitAnim.getChildAnimations().contains(valueAnimator)) {
            Rect rect = this.originRect;
            if (rect == null) {
                f16 = getHeight();
                height = this.curView.getHeight();
            } else {
                f16 = rect.bottom - rect.top;
                height = this.curView.getHeight();
            }
            Float valueOf = Float.valueOf((f16 / height) / f17.floatValue());
            if (valueOf.floatValue() > 1.0f) {
                floatValue = 1.0f;
            } else {
                floatValue = valueOf.floatValue();
            }
            f17 = Float.valueOf(1.0f - Float.valueOf(floatValue).floatValue());
        }
        if (QLog.isColorLevel()) {
            QLog.d("DragView", 2, "onAnimationUpdate : " + f17);
        }
        onContentMove(f17.floatValue() - this.alphaOffset);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.mScrollDisY = 0.0f;
        this.mScrollDisX = 0.0f;
        this.downX = motionEvent.getX();
        this.downY = motionEvent.getY();
        this.scale = 1.0f;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        int[] onModifyCurViewSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (this.curView == null) {
            return false;
        }
        ArrayList<Animator> childAnimations = this.quitAnim.getChildAnimations();
        if (this.originRect != null && this.curView != null && childAnimations != null && childAnimations.size() == 4) {
            int width = this.curView.getWidth();
            int height = this.curView.getHeight();
            OnDragChangeListener onDragChangeListener = this.mDragChangeListener;
            if (onDragChangeListener != null && (onModifyCurViewSize = onDragChangeListener.onModifyCurViewSize()) != null) {
                width = onModifyCurViewSize[0];
                height = onModifyCurViewSize[1];
            }
            Rect rect = new Rect(this.originRect);
            if (this.ratioModify) {
                float f18 = width / height;
                try {
                    float width2 = this.originRect.width() / this.originRect.height();
                    if (QLog.isColorLevel()) {
                        QLog.d("DragView", 2, "sonRatio : " + width2 + "  parentRatio : " + f18 + " getWidth() : " + getWidth() + " getHeight() : " + getHeight() + " oriHeight :" + this.originRect.height() + " oriWidth : " + this.originRect.width());
                    }
                    if (width2 < f18) {
                        int height2 = ((int) ((this.originRect.height() * f18) - this.originRect.width())) / 2;
                        rect.left -= height2;
                        rect.right += height2;
                    } else if (width2 > f18) {
                        int width3 = ((int) ((this.originRect.width() / f18) - this.originRect.height())) / 2;
                        rect.top -= width3;
                        rect.bottom += width3;
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DragView", 2, ThrowablesUtils.getStackTraceAsString(e16));
                    }
                }
            }
            float width4 = ((rect.left + rect.right) / 2) - (getWidth() / 2);
            float height3 = ((rect.top + rect.bottom) / 2) - (getHeight() / 2);
            float f19 = (rect.right - rect.left) / width;
            ((ObjectAnimator) childAnimations.get(0)).setFloatValues(width4);
            ((ObjectAnimator) childAnimations.get(1)).setFloatValues(height3);
            ((ObjectAnimator) childAnimations.get(2)).setFloatValues(f19);
            ((ObjectAnimator) childAnimations.get(3)).setFloatValues((rect.bottom - rect.top) / height);
            this.curView.setPivotX(r10.getWidth() / 2);
            this.curView.setPivotY(r10.getHeight() / 2);
        } else {
            this.curView.setPivotX(getWidth() / 2);
            this.curView.setPivotY(getHeight() / 2);
        }
        this.quitAnim.setupStartValues();
        startQuitAnim();
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.enableDrag) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return true;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (this.curView == null) {
            return false;
        }
        this.mScrollDisX -= f16;
        float f18 = this.mScrollDisY - f17;
        this.mScrollDisY = f18;
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        int height = getHeight();
        float f19 = 1.0f;
        if (height > 0) {
            f19 = 1.0f - (f18 / height);
        }
        this.curView.setPivotX(this.downX - r6.getLeft());
        this.curView.setPivotY(this.downY - r6.getTop());
        float f26 = this.scaleThreshold;
        if (f19 > f26) {
            f26 = f19;
        }
        this.scale = f26;
        this.curView.setScaleX(f26);
        this.curView.setScaleY(this.scale);
        this.curView.setTranslationX(this.mScrollDisX);
        this.curView.setTranslationY(f18);
        onContentMove(f19 - this.alphaOffset);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
        if (onGestureChangeListener != null) {
            onGestureChangeListener.onClickDragView();
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z16 = false;
        if (this.isInAnimation) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.firstDown = true;
        } else if (action == 1) {
            this.firstDown = false;
        } else if (action == 2 && !this.firstDown) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            this.mGestureDetector.onTouchEvent(obtain);
            this.firstDown = true;
        }
        if (motionEvent.getAction() == 1) {
            z16 = true;
        }
        if (!this.mGestureDetector.onTouchEvent(motionEvent) && z16) {
            onUP(motionEvent);
        }
        return true;
    }

    public void setDragChangeListener(OnDragChangeListener onDragChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onDragChangeListener);
        } else {
            this.mDragChangeListener = onDragChangeListener;
        }
    }

    public void setEnableDrag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.enableDrag = z16;
        }
    }

    public void setGestureChangeListener(OnGestureChangeListener onGestureChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onGestureChangeListener);
        } else {
            this.mGestureChangeListener = onGestureChangeListener;
        }
    }

    public void setOriginRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rect);
        } else {
            this.originRect = rect;
        }
    }

    public void setRatioModify(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.ratioModify = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startQuitAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.quitAnim.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startReleaseAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.releaseAnim.start();
        }
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.scale = 0.0f;
        this.mScrollDisX = 0.0f;
        this.mScrollDisY = 0.0f;
        this.downX = 0.0f;
        this.downY = 0.0f;
        this.scaleThreshold = 0.25f;
        this.alphaOffset = 0.0f;
        this.mGestureChangeListener = null;
        this.originRect = null;
        this.isInAnimation = false;
        this.firstDown = false;
        this.mFinishAnimation = false;
        this.enableDrag = true;
        this.ratioModify = false;
        this.mGestureDetector = new GestureDetector(context, this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            this.isInAnimation = true;
        } else {
            iPatchRedirector.redirect((short) 22, this, animator, Boolean.valueOf(z16));
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        OnGestureChangeListener onGestureChangeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) animator);
            return;
        }
        this.isInAnimation = false;
        if (animator == this.quitAnim) {
            this.mFinishAnimation = true;
            OnGestureChangeListener onGestureChangeListener2 = this.mGestureChangeListener;
            if (onGestureChangeListener2 != null) {
                onGestureChangeListener2.onGestureFinish();
                return;
            }
            return;
        }
        if (animator != this.releaseAnim || (onGestureChangeListener = this.mGestureChangeListener) == null) {
            return;
        }
        onGestureChangeListener.onResetPosition();
    }
}
