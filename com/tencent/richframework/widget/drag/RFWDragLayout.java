package com.tencent.richframework.widget.drag;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.richframework.widget.drag.RFWDragLayout;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWDragLayout extends FrameLayout implements GestureDetector.OnGestureListener {
    private static final int THRESHOLD_SPEED_END_DRAG = ImmersiveUtils.getScreenHeight();
    private int mClipHeight;
    private int mClipTop;
    private final PointF mDownPoint;
    private long mDownTime;
    private DragInterceptDelegate mDragInterceptDelegate;
    private int mDraggingType;
    private boolean mEnableSetWindowBg;
    private GestureDetector mGestureDetector;
    private boolean mIsDragging;
    private boolean mIsEnableDragHorizontal;
    private boolean mIsEnableDragVertical;
    private boolean mIsFeatureEnable;
    private final PointF mLastPoint;
    private OnDragListener mOnDragListener;
    private GestureDetector.OnGestureListener mOuterGestureListener;
    private final PointF mStartDragPoint;
    private View mTargetDragView;
    private int mTouchSlop;
    private final ColorDrawable mWindowBgDrawable;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface DragInterceptDelegate {
        boolean needIntercept(MotionEvent motionEvent, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnDragListener {
        void onDragging(float f16);

        void onEndDrag(boolean z16);

        void onStartDrag();
    }

    public RFWDragLayout(@NonNull Context context) {
        this(context, null);
    }

    private void animToRecover() {
        final float translationX = getTargetDragView().getTranslationX();
        final float translationY = getTargetDragView().getTranslationY();
        final float scaleX = getTargetDragView().getScaleX();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: zz3.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFWDragLayout.this.lambda$animToRecover$0(translationX, translationY, scaleX, valueAnimator);
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
        if (z16 && this.mIsEnableDragHorizontal && Math.abs(f16) > this.mTouchSlop) {
            return 1;
        }
        if (z16 || !this.mIsEnableDragVertical || Math.abs(f17) <= this.mTouchSlop) {
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
        this.mTargetDragView = this;
        this.mGestureDetector = new GestureDetector(getContext(), this, new Handler(Looper.getMainLooper()));
    }

    private boolean isFastDrag(PointF pointF, float f16, float f17, long j3) {
        float f18 = f16 - pointF.x;
        float f19 = f17 - pointF.y;
        float f26 = ((float) j3) / 1000.0f;
        float f27 = f18 / f26;
        int i3 = THRESHOLD_SPEED_END_DRAG;
        if (f27 <= i3 && f19 / f26 <= i3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animToRecover$0(float f16, float f17, float f18, ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        getTargetDragView().setTranslationX(f16 * animatedFraction);
        getTargetDragView().setTranslationY(f17 * animatedFraction);
        float f19 = 1.0f - f18;
        setScale((valueAnimator.getAnimatedFraction() * f19) + f18);
        setWindowBgAlpha(f18 + (f19 * valueAnimator.getAnimatedFraction()));
    }

    private void setDeltaTranslation(float f16, float f17) {
        getTargetDragView().setTranslationX(getTargetDragView().getTranslationX() + f16);
        getTargetDragView().setTranslationY(getTargetDragView().getTranslationY() + f17);
    }

    private void setScale(float f16) {
        if (Float.isNaN(f16)) {
            return;
        }
        setPivotX(getTargetDragView().getWidth() / 2.0f);
        setPivotY(getTargetDragView().getHeight() / 2.0f);
        getTargetDragView().setScaleX(f16);
        getTargetDragView().setScaleY(f16);
    }

    public View getTargetDragView() {
        return this.mTargetDragView;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mOuterGestureListener;
        if (onGestureListener != null) {
            return onGestureListener.onDown(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mClipHeight > 0) {
            canvas.clipRect(0, this.mClipTop, getWidth(), this.mClipTop + this.mClipHeight);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        GestureDetector.OnGestureListener onGestureListener = this.mOuterGestureListener;
        if (onGestureListener != null) {
            return onGestureListener.onFling(motionEvent, motionEvent2, f16, f17);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (motionEvent.getPointerCount() == 1) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (!this.mIsFeatureEnable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float rawX = motionEvent.getRawX() - this.mDownPoint.x;
                float rawY = motionEvent.getRawY() - this.mDownPoint.y;
                DragInterceptDelegate dragInterceptDelegate = this.mDragInterceptDelegate;
                if (dragInterceptDelegate != null) {
                    z16 = dragInterceptDelegate.needIntercept(motionEvent, rawX, rawY);
                } else {
                    z16 = true;
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

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mOuterGestureListener;
        if (onGestureListener != null) {
            onGestureListener.onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        GestureDetector.OnGestureListener onGestureListener = this.mOuterGestureListener;
        if (onGestureListener != null) {
            return onGestureListener.onScroll(motionEvent, motionEvent2, f16, f17);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mOuterGestureListener;
        if (onGestureListener != null) {
            onGestureListener.onShowPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.mOuterGestureListener;
        if (onGestureListener != null) {
            return onGestureListener.onSingleTapUp(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsFeatureEnable) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                PointF pointF = this.mLastPoint;
                float f16 = rawX - pointF.x;
                float f17 = rawY - pointF.y;
                pointF.set(rawX, rawY);
                int i3 = this.mDraggingType;
                PointF pointF2 = this.mStartDragPoint;
                float scaleFactor = getScaleFactor(i3, rawX - pointF2.x, rawY - pointF2.y, getWidth() * 1.1f, getHeight() * 1.1f);
                setScale(scaleFactor);
                setDeltaTranslation(f16, f17);
                setWindowBgAlpha(scaleFactor);
                OnDragListener onDragListener = this.mOnDragListener;
                if (onDragListener != null) {
                    onDragListener.onDragging(scaleFactor);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        this.mIsDragging = false;
        this.mDraggingType = 0;
        boolean isFastDrag = isFastDrag(this.mDownPoint, motionEvent.getRawX(), motionEvent.getRawY(), System.currentTimeMillis() - this.mDownTime);
        if (getTargetDragView().getScaleX() >= 0.7f && !isFastDrag) {
            OnDragListener onDragListener2 = this.mOnDragListener;
            if (onDragListener2 != null) {
                onDragListener2.onEndDrag(false);
            }
            animToRecover();
        } else {
            OnDragListener onDragListener3 = this.mOnDragListener;
            if (onDragListener3 != null) {
                onDragListener3.onEndDrag(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClipVertical(int i3, int i16) {
        this.mClipTop = i3;
        this.mClipHeight = i16;
    }

    public void setDragInterceptDelegate(DragInterceptDelegate dragInterceptDelegate) {
        this.mDragInterceptDelegate = dragInterceptDelegate;
    }

    public void setEnableChangeWindowBg(boolean z16) {
        this.mEnableSetWindowBg = z16;
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

    public void setGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.mOuterGestureListener = onGestureListener;
    }

    public void setOnDragListener(OnDragListener onDragListener) {
        this.mOnDragListener = onDragListener;
    }

    public void setTargetDragView(View view) {
        this.mTargetDragView = view;
    }

    public void setWindowBgAlpha(float f16) {
        if (!this.mEnableSetWindowBg) {
            return;
        }
        int i3 = (int) (f16 * 1.0f * 255.0f);
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        this.mWindowBgDrawable.setAlpha(i3);
        if ((getContext() instanceof Activity) && ((Activity) getContext()).getWindow() != null) {
            ((Activity) getContext()).getWindow().setBackgroundDrawable(this.mWindowBgDrawable);
        }
    }

    public RFWDragLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWDragLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mWindowBgDrawable = new ColorDrawable(-16777216);
        this.mEnableSetWindowBg = true;
        this.mDownPoint = new PointF();
        this.mLastPoint = new PointF();
        this.mStartDragPoint = new PointF();
        init();
    }
}
