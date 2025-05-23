package com.tencent.biz.richframework.animation.transition;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionDragLayout extends FrameLayout {
    private int mClipHeight;
    private int mClipTop;
    private PointF mDownPoint;
    private long mDownTime;
    private DragInterceptDelegate mDragInterceptDelegate;
    private int mDraggingType;
    private boolean mIsDragging;
    private boolean mIsEnableDragHorizontal;
    private boolean mIsEnableDragVertical;
    private boolean mIsFeatureEnable;
    private boolean mIsMultiTouch;
    private PointF mLastPoint;
    private OnDragListener mOnDragListener;
    private PointF mStartDragPoint;
    private int mTouchSlop;
    private ColorDrawable mWindowBgDrawable;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface DragInterceptDelegate {
        boolean needIntercept(MotionEvent motionEvent, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnDragListener {
        void onDragging();

        void onEndDrag(boolean z16);

        void onStartDrag();
    }

    public TransitionDragLayout(@NonNull Context context) {
        this(context, null);
    }

    private void animToRecover(final float f16, final float f17, final float f18) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.richframework.animation.transition.TransitionDragLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
                TransitionDragLayout.this.setTranslationX(f16 * animatedFraction);
                TransitionDragLayout.this.setTranslationY(f17 * animatedFraction);
                TransitionDragLayout transitionDragLayout = TransitionDragLayout.this;
                float f19 = f18;
                transitionDragLayout.setScaleX(f19 + ((1.0f - f19) * valueAnimator.getAnimatedFraction()));
                TransitionDragLayout transitionDragLayout2 = TransitionDragLayout.this;
                transitionDragLayout2.setScaleY(transitionDragLayout2.getScaleX());
            }
        });
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private int getDragType(float f16, float f17) {
        boolean z16;
        if (Math.abs(f16) > Math.abs(f17)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.mIsEnableDragHorizontal && f16 > this.mTouchSlop) {
            return 1;
        }
        if (z16 || !this.mIsEnableDragVertical || f17 <= this.mTouchSlop) {
            return 0;
        }
        return 2;
    }

    private float getScaleFactor(int i3, float f16, float f17, float f18, float f19) {
        float f26;
        if (i3 != 1) {
            if (i3 != 2) {
                f26 = 1.0f;
            } else {
                f26 = 1.0f - (f17 / f19);
            }
        } else {
            f26 = 1.0f - (f16 / f18);
        }
        if (f26 < 0.5f) {
            return 0.5f;
        }
        return Math.min(f26, 1.0f);
    }

    private void init() {
        this.mTouchSlop = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 3.0f);
        setWillNotDraw(false);
    }

    private boolean isFastDrag(PointF pointF, float f16, float f17, long j3) {
        float f18 = f16 - pointF.x;
        float f19 = f17 - pointF.y;
        float f26 = ((float) j3) / 1000.0f;
        if (f18 / f26 <= 500.0f && f19 / f26 <= 500.0f) {
            return false;
        }
        return true;
    }

    private void setScale(float f16, float f17, float f18) {
        setPivotX(f17 / 2.0f);
        setPivotY(f18 / 2.0f);
        setScaleX(f16);
        setScaleY(f16);
    }

    private void setTranslation(float f16, float f17) {
        setTranslationX(getTranslationX() + f16);
        setTranslationY(getTranslationY() + f17);
    }

    private void setWindowBgAlpha(float f16) {
        int i3 = (int) (f16 * 1.0f * 255.0f);
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        this.mWindowBgDrawable.setAlpha(i3);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().setBackgroundDrawable(this.mWindowBgDrawable);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mClipHeight > 0) {
            canvas.clipRect(0, this.mClipTop, getWidth(), this.mClipTop + this.mClipHeight);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (!this.mIsFeatureEnable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 2) {
                float rawX = motionEvent.getRawX() - this.mDownPoint.x;
                float rawY = motionEvent.getRawY() - this.mDownPoint.y;
                DragInterceptDelegate dragInterceptDelegate = this.mDragInterceptDelegate;
                if (dragInterceptDelegate != null) {
                    z16 = dragInterceptDelegate.needIntercept(motionEvent, rawX, rawY);
                } else {
                    z16 = false;
                }
                if (z16) {
                    int dragType = getDragType(rawX, rawY);
                    this.mDraggingType = dragType;
                    if (this.mIsDragging || dragType == 1 || dragType == 2) {
                        OnDragListener onDragListener = this.mOnDragListener;
                        if (onDragListener != null) {
                            onDragListener.onStartDrag();
                        }
                        this.mIsDragging = true;
                        this.mLastPoint.set(motionEvent.getRawX(), motionEvent.getRawY());
                        this.mStartDragPoint.set(motionEvent.getRawX(), motionEvent.getRawY());
                        return true;
                    }
                }
            }
        } else {
            this.mDownTime = System.currentTimeMillis();
            this.mDownPoint.set(motionEvent.getRawX(), motionEvent.getRawY());
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        if (r0 != 3) goto L38;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsFeatureEnable) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z16 = true;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                PointF pointF = this.mLastPoint;
                float f16 = rawX - pointF.x;
                float f17 = rawY - pointF.y;
                pointF.set(rawX, rawY);
                int i3 = this.mDraggingType;
                PointF pointF2 = this.mStartDragPoint;
                float scaleFactor = getScaleFactor(i3, rawX - pointF2.x, rawY - pointF2.y, getWidth() * 1.5f, getHeight() * 1.5f);
                setScale(scaleFactor, getWidth(), getHeight());
                setTranslation(f16, f17);
                setWindowBgAlpha(scaleFactor);
                OnDragListener onDragListener = this.mOnDragListener;
                if (onDragListener != null) {
                    onDragListener.onDragging();
                }
                if (!this.mIsMultiTouch) {
                    if (motionEvent.getPointerCount() <= 1) {
                        z16 = false;
                    }
                    this.mIsMultiTouch = z16;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        this.mIsDragging = false;
        this.mDraggingType = 0;
        if (!this.mIsMultiTouch && (getScaleX() < 0.7f || isFastDrag(this.mDownPoint, motionEvent.getRawX(), motionEvent.getRawY(), System.currentTimeMillis() - this.mDownTime))) {
            OnDragListener onDragListener2 = this.mOnDragListener;
            if (onDragListener2 != null) {
                onDragListener2.onEndDrag(true);
            }
        } else {
            OnDragListener onDragListener3 = this.mOnDragListener;
            if (onDragListener3 != null) {
                onDragListener3.onEndDrag(false);
            }
            animToRecover(getTranslationX(), getTranslationY(), getScaleX());
        }
        this.mIsMultiTouch = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setClipVertical(int i3, int i16) {
        this.mClipTop = i3;
        this.mClipHeight = i16;
    }

    public void setDragInterceptDelegate(DragInterceptDelegate dragInterceptDelegate) {
        this.mDragInterceptDelegate = dragInterceptDelegate;
    }

    public void setEnableDragHorizontal(boolean z16) {
        this.mIsEnableDragHorizontal = z16;
    }

    public void setEnableDragVertical(boolean z16) {
        this.mIsEnableDragVertical = z16;
    }

    public void setFeatureEnable(boolean z16) {
        this.mIsFeatureEnable = z16;
    }

    public void setOnDragListener(OnDragListener onDragListener) {
        this.mOnDragListener = onDragListener;
    }

    public TransitionDragLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransitionDragLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mWindowBgDrawable = new ColorDrawable(-33554432);
        this.mDownPoint = new PointF();
        this.mLastPoint = new PointF();
        this.mStartDragPoint = new PointF();
        init();
    }
}
