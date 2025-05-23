package com.tencent.richmediabrowser.view.recyclerview;

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
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DragView extends RelativeLayout implements GestureDetector.OnGestureListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
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
    /* loaded from: classes25.dex */
    public interface OnDragChangeListener {
        int[] onModifyCurViewSize();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnGestureChangeListener {
        void onClickDragView();

        void onContentMove(float f16);

        void onGestureFinish();

        void onResetPosition();
    }

    public DragView(Context context) {
        this(context, null);
    }

    private void onContentMove(float f16) {
        OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
        if (onGestureChangeListener != null) {
            onGestureChangeListener.onContentMove(f16);
        }
    }

    private void onUP(MotionEvent motionEvent) {
        this.releaseAnim.setupStartValues();
        this.releaseAnim.start();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
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

    public void init() {
        this.curView.setScaleX(1.0f);
        this.curView.setScaleY(1.0f);
        this.curView.setTranslationX(0.0f);
        this.curView.setTranslationY(0.0f);
        this.mFinishAnimation = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        OnGestureChangeListener onGestureChangeListener;
        BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "DragView...onAnimationEnd");
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

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.isInAnimation = true;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f16;
        int height;
        float floatValue;
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
        BrowserLogHelper.getInstance().getGalleryLog().e("DragView", 2, "onAnimationUpdate : " + f17);
        onContentMove(f17.floatValue() - this.alphaOffset);
    }

    public void onDestroy() {
        BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "DragView...onDestroy");
        this.isInAnimation = false;
        this.mGestureDetector = null;
        setGestureChangeListener(null);
        setDragChangeListener(null);
        removeAllViews();
        AnimatorSet animatorSet = this.releaseAnim;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.quitAnim;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
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
                    BrowserLogHelper.getInstance().getGalleryLog().e("DragView", 2, "sonRatio : " + width2 + "  parentRatio : " + f18 + " getWidth() : " + getWidth() + " getHeight() : " + getHeight() + " oriHeight :" + this.originRect.height() + " oriWidth : " + this.originRect.width());
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
                    BrowserLogHelper.getInstance().getGalleryLog().e("DragView", 2, "exception = " + e16.getMessage());
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
        this.quitAnim.start();
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return true;
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        if (this.curView == null) {
            return false;
        }
        this.mScrollDisX -= f16;
        float f18 = this.mScrollDisY - f17;
        this.mScrollDisY = f18;
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        float height = 1.0f - (f18 / getHeight());
        this.curView.setPivotX(this.downX - r5.getLeft());
        this.curView.setPivotY(this.downY - r5.getTop());
        float f19 = this.scaleThreshold;
        if (height > f19) {
            f19 = height;
        }
        this.scale = f19;
        this.curView.setScaleX(f19);
        this.curView.setScaleY(this.scale);
        this.curView.setTranslationX(this.mScrollDisX);
        this.curView.setTranslationY(f18);
        onContentMove(height - this.alphaOffset);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        OnGestureChangeListener onGestureChangeListener = this.mGestureChangeListener;
        if (onGestureChangeListener != null) {
            onGestureChangeListener.onClickDragView();
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
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
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(obtain);
            }
            this.firstDown = true;
        }
        if (motionEvent.getAction() == 1) {
            z16 = true;
        }
        GestureDetector gestureDetector2 = this.mGestureDetector;
        if (gestureDetector2 != null && !gestureDetector2.onTouchEvent(motionEvent) && z16) {
            onUP(motionEvent);
        }
        return true;
    }

    public void setDragChangeListener(OnDragChangeListener onDragChangeListener) {
        this.mDragChangeListener = onDragChangeListener;
    }

    public void setEnableDrag(boolean z16) {
        this.enableDrag = z16;
    }

    public void setGestureChangeListener(OnGestureChangeListener onGestureChangeListener) {
        this.mGestureChangeListener = onGestureChangeListener;
    }

    public void setOriginRect(Rect rect) {
        this.originRect = rect;
    }

    public void setRatioModify(boolean z16) {
        this.ratioModify = z16;
    }

    public DragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFinishAnimation = false;
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
        this.enableDrag = true;
        this.ratioModify = false;
        this.mGestureDetector = new GestureDetector(context, this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
