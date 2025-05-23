package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DragImageView extends ImageView {
    public static final int MOVE_DELTA = 10;
    public static final int MOVE_FLOATAD = 0;
    public static final int MOVE_PENDANTAD = 1;
    public static final String TAG = "DragImageView";
    private float mDownPosX;
    private float mDownPosY;
    private int mDraggableMode;
    private boolean mHasMove;
    private boolean mHasScale;
    private int mLastAction;
    private float mLastPosX;
    private float mLastPosY;
    private int mMarginBottom;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMarginTop;
    private boolean mOnTouch;
    private int mOriginViewHeight;
    private int mOriginViewWidth;
    private float mScaleHeight;
    private float mScaleWidth;
    private float mScaleX;
    private float mScaleY;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mViewHeight;
    private int mViewWidth;

    public DragImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    private float getLimitX(float f16) {
        if (this.mOnTouch) {
            float f17 = this.mScaleWidth;
            int i3 = this.mMarginRight;
            float f18 = (f17 - this.mOriginViewWidth) / 2.0f;
            float f19 = ((f16 + f17) + i3) - f18;
            int i16 = this.mScreenWidth;
            if (f19 > i16) {
                return ((i16 - f17) - i3) + f18;
            }
            int i17 = this.mMarginLeft;
            if (f16 < i17) {
                return i17 - f18;
            }
            return f16;
        }
        int i18 = this.mOriginViewWidth;
        if (i18 + f16 + this.mMarginRight > this.mScreenWidth) {
            return (r3 - i18) - r2;
        }
        if (f16 < Math.abs(this.mMarginLeft)) {
            return this.mMarginLeft;
        }
        return f16;
    }

    private float getLimitY(float f16) {
        if (this.mOnTouch) {
            float f17 = this.mScaleHeight;
            float f18 = (f17 - this.mOriginViewHeight) / 2.0f;
            if (((this.mMarginBottom + f16) + f17) - f18 > this.mScreenHeight) {
                return ((r4 - r2) - f17) + f18;
            }
            int i3 = this.mMarginTop;
            if (f16 < i3) {
                return i3 - f18;
            }
            return f16;
        }
        int i16 = this.mMarginBottom;
        if (i16 + f16 + this.mOriginViewHeight > this.mScreenHeight) {
            return (r3 - i16) - r2;
        }
        int i17 = this.mMarginTop;
        if (f16 < i17) {
            return i17;
        }
        return f16;
    }

    private void getOriginSize() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        this.mOriginViewHeight = marginLayoutParams.height;
        this.mOriginViewWidth = marginLayoutParams.width;
    }

    private void getScreenConfig() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            this.mScreenWidth = point.x;
            this.mScreenHeight = point.y;
        } else {
            this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
            this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        QMLog.i(TAG, "getScreenConfig mScreenWidth: " + this.mScreenWidth + ", mScreenHeight: " + this.mScreenHeight);
    }

    private boolean handleActionDown(MotionEvent motionEvent) {
        getOriginSize();
        setColorFilter();
        this.mDownPosX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.mDownPosY = rawY;
        this.mLastPosX = this.mDownPosX;
        this.mLastPosY = rawY;
        return true;
    }

    private boolean handleActionMove(MotionEvent motionEvent) {
        int i3 = this.mDraggableMode;
        if (i3 == 1) {
            moveX(motionEvent);
        } else if (i3 == 0) {
            moveX(motionEvent);
            moveY(motionEvent);
        }
        boolean isMovingOrNot = isMovingOrNot(this.mDownPosX, this.mDownPosY, motionEvent.getRawX(), motionEvent.getRawY());
        this.mHasMove = isMovingOrNot;
        if (isMovingOrNot) {
            resetColorFilter();
            if (this.mDraggableMode == 0) {
                scaleView();
            }
        }
        bringToFront();
        return true;
    }

    private boolean handleActionUp() {
        resetColorFilter();
        if (this.mDraggableMode == 0) {
            restoreScale();
        }
        if (this.mLastAction == 0) {
            performClick();
        } else {
            if (!this.mHasMove) {
                performClick();
            }
            if (this.mDraggableMode == 0) {
                landSide();
            }
        }
        this.mHasMove = false;
        return false;
    }

    private boolean isMovingOrNot(float f16, float f17, float f18, float f19) {
        if (Math.abs(f16 - f18) <= 10.0f && Math.abs(f17 - f19) <= 10.0f) {
            return false;
        }
        return true;
    }

    private void landSide() {
        float x16 = getX();
        int i3 = this.mScreenWidth;
        if (x16 <= i3 / 2.0f) {
            i3 = 0;
        }
        animate().setInterpolator(new DecelerateInterpolator()).x(getLimitX(i3)).setDuration(300L).start();
    }

    private void moveX(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float limitX = getLimitX((getX() + rawX) - this.mLastPosX);
        this.mLastPosX = rawX;
        setX(limitX);
    }

    private void moveY(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        float limitY = getLimitY((getY() + rawY) - this.mLastPosY);
        this.mLastPosY = rawY;
        setY(limitY);
    }

    private void resetColorFilter() {
        clearColorFilter();
    }

    private void resetMargin() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        this.mMarginLeft = marginLayoutParams.leftMargin;
        this.mMarginRight = marginLayoutParams.rightMargin;
        this.mMarginTop = marginLayoutParams.topMargin;
        this.mMarginBottom = marginLayoutParams.bottomMargin;
    }

    private void resetViewSize() {
        this.mViewWidth = getMeasuredWidth();
        this.mViewHeight = getMeasuredHeight();
    }

    private void restoreScale() {
        if (!this.mHasScale) {
            return;
        }
        this.mHasScale = false;
        float f16 = this.mScaleWidth - this.mOriginViewWidth;
        float f17 = this.mScaleHeight - this.mOriginViewHeight;
        setX(getX() - (f16 / 2.0f));
        setY(getY() - (f17 / 2.0f));
        this.mOnTouch = false;
        requestLayout();
    }

    private void scaleView() {
        if (this.mHasScale) {
            return;
        }
        this.mHasScale = true;
        float f16 = this.mScaleHeight;
        if (f16 > 0.0f) {
            float f17 = this.mScaleWidth;
            if (f17 > 0.0f) {
                setX(getX() + ((f17 - this.mOriginViewWidth) / 2.0f));
                setY(getY() + ((f16 - this.mOriginViewHeight) / 2.0f));
                this.mScaleX = this.mScaleWidth / this.mViewWidth;
                this.mScaleY = this.mScaleHeight / this.mViewHeight;
                this.mOnTouch = true;
                requestLayout();
            }
        }
    }

    private void setColorFilter() {
        setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getScreenConfig();
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        resetMargin();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mOnTouch) {
            setMeasuredDimension((int) this.mScaleWidth, (int) this.mScaleHeight);
        } else {
            super.onMeasure(i3, i16);
        }
        resetViewSize();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean handleActionDown;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    return false;
                }
                handleActionDown = handleActionMove(motionEvent);
            } else {
                handleActionDown = handleActionUp();
            }
        } else {
            handleActionDown = handleActionDown(motionEvent);
        }
        this.mLastAction = actionMasked;
        return handleActionDown;
    }

    public void setScaleSize(float f16, float f17) {
        this.mScaleWidth = f16;
        this.mScaleHeight = f17;
    }

    public void setScreenWidth(int i3) {
        QMLog.i(TAG, "origWidth:" + this.mScreenWidth + ",newWidth:" + i3);
        this.mScreenWidth = i3;
    }

    public DragImageView(Context context, int i3) {
        this(context, (AttributeSet) null);
        this.mDraggableMode = i3;
    }

    public DragImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DragImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDraggableMode = 0;
        getScreenConfig();
    }
}
