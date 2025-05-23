package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageView;
import com.tencent.richmediabrowser.listener.IBrowserFlingControlListener;
import com.tencent.richmediabrowser.listener.IBrowserFlingEventListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleControlListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import e04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserScaleView extends GalleryUrlImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, IBrowserScaleControlListener, IBrowserScaleEventListener, IBrowserFlingControlListener, IBrowserFlingEventListener {
    private static final String TAG = "BrowserScaleView";
    private int defaultDx;
    private int defaultDy;
    private int degrees;
    private volatile boolean isAutoScale;
    private boolean isCheckLeftAndRight;
    private boolean isCheckTopAndBottom;
    private boolean isDoubleTapEnable;
    private boolean isScaleEnable;
    private float mDefaultScale;
    private Drawable mDrawable;
    private BrowserFlingAnimator mFlingAnimator;
    private GestureDetector mGestureDetector;
    private int mHeight;
    private c mItemEventListener;
    private int mLastDownPointerCount;
    private float mLastDownX;
    private float mLastDownY;
    private int mLastPointerCount;
    private float mLastX;
    private float mLastY;
    private MainBrowserPresenter mMainBrowserPresenter;
    private float mMaxOverScale;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private RegionRectHelper mRegionRectHelper;
    private ScaleGestureDetector mScaleGestureDetector;
    private Matrix mScaleMatrix;
    protected int mScrollDirection;
    private int mTurnPageMaxDistance;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private int privorX;
    private int privorY;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        boolean c(RectF rectF, int i3, int i16);

        boolean d(float f16, float f17, int i3, MotionEvent motionEvent);
    }

    public BrowserScaleView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canUpdateRegionRect() {
        if (this.mDrawable == null) {
            return false;
        }
        return getRegionRectHelper().canUpdateRegionRect((int) (r0.getIntrinsicWidth() * getScale()), (int) (this.mDrawable.getIntrinsicHeight() * getScale()), this.mWidth, this.mHeight);
    }

    private void checkBorderAndCenterWhenScale() {
        float f16;
        if (this.mDrawable == null) {
            return;
        }
        RectF matrixRectF = getMatrixRectF();
        float width = matrixRectF.width();
        int i3 = this.mWidth;
        float f17 = 0.0f;
        if (width >= i3) {
            float f18 = matrixRectF.left;
            if (f18 > 0.0f) {
                f16 = -f18;
            } else {
                f16 = 0.0f;
            }
            float f19 = matrixRectF.right;
            if (f19 < i3) {
                f16 = i3 - f19;
            }
        } else {
            f16 = 0.0f;
        }
        float height = matrixRectF.height();
        int i16 = this.mHeight;
        if (height >= i16) {
            float f26 = matrixRectF.top;
            if (f26 > 0.0f) {
                f17 = -f26;
            }
            float f27 = matrixRectF.bottom;
            if (f27 < i16) {
                f17 = i16 - f27;
            }
        }
        float width2 = matrixRectF.width();
        int i17 = this.mWidth;
        if (width2 < i17) {
            f16 = ((i17 / 2.0f) - matrixRectF.right) + (matrixRectF.width() / 2.0f);
        }
        float height2 = matrixRectF.height();
        int i18 = this.mHeight;
        if (height2 < i18) {
            f17 = ((i18 / 2.0f) - matrixRectF.bottom) + (matrixRectF.height() / 2.0f);
        }
        this.mScaleMatrix.postTranslate(f16, f17);
    }

    private void checkBorderWhenTranslate() {
        float f16;
        RectF matrixRectF = getMatrixRectF();
        float f17 = 0.0f;
        if (this.isCheckLeftAndRight) {
            float f18 = matrixRectF.left;
            if (f18 > 0.0f) {
                f16 = -f18;
            } else {
                f16 = 0.0f;
            }
            float f19 = matrixRectF.right;
            int i3 = this.mWidth;
            if (f19 < i3) {
                f16 = i3 - f19;
            }
        } else {
            f16 = 0.0f;
        }
        if (this.isCheckTopAndBottom) {
            float f26 = matrixRectF.top;
            if (f26 > 0.0f) {
                f17 = -f26;
            }
            float f27 = matrixRectF.bottom;
            int i16 = this.mHeight;
            if (f27 < i16) {
                f17 = i16 - f27;
            }
        }
        this.mScaleMatrix.postTranslate(f16, f17);
    }

    private void dealScaleEvent() {
        if (!this.isAutoScale) {
            if (isVerticalLongPhoto(this.degrees)) {
                float scale = getScale();
                float f16 = this.mDefaultScale;
                if (scale < f16) {
                    startScale(f16, this.mWidth / 2, this.mHeight / 2);
                    return;
                }
            } else {
                float scale2 = getScale();
                float f17 = this.mDefaultScale;
                if (scale2 < f17) {
                    startScale(f17, this.mWidth / 2, this.mHeight / 2);
                }
            }
            float scale3 = getScale();
            float f18 = this.mMaxScale;
            if (scale3 > f18) {
                startScale(f18, this.mWidth / 2, this.mHeight / 2);
            }
        }
    }

    private boolean enableScrollLeft() {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null && mainBrowserPresenter.enableScrollLeft()) {
            return true;
        }
        return false;
    }

    private boolean enableScrollRight() {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null && mainBrowserPresenter.enableScrollRight()) {
            return true;
        }
        return false;
    }

    private a getCustomLister() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            return mainBrowserScene.bsvCustomLister;
        }
        return null;
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.mScaleMatrix;
        RectF rectF = new RectF();
        if (this.mDrawable != null && matrix != null) {
            rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegionRectHelper getRegionRectHelper() {
        if (this.mRegionRectHelper == null) {
            this.mRegionRectHelper = new RegionRectHelper(this.mMainBrowserPresenter);
        }
        return this.mRegionRectHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getScale() {
        float[] fArr = new float[9];
        Matrix matrix = this.mScaleMatrix;
        if (matrix != null) {
            matrix.getValues(fArr);
            if (isHorizonRotate(this.degrees)) {
                return Math.abs(fArr[1]);
            }
            return Math.abs(fArr[0]);
        }
        return this.mDefaultScale;
    }

    private void handleCancel(MotionEvent motionEvent) {
        a customLister;
        this.mLastPointerCount = 0;
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "onTouch...action = " + motionEvent.getAction());
        dealScaleEvent();
        if (isVerticalLongPhoto(this.degrees) && getScale() == this.mDefaultScale) {
            a customLister2 = getCustomLister();
            if (customLister2 != null) {
                customLister2.c(getMatrixRectF(), this.mWidth, this.mHeight);
            }
        } else if (isSingle() && getScale() == this.mDefaultScale && (customLister = getCustomLister()) != null) {
            customLister.d(this.mLastDownX, this.mLastDownY, this.mLastDownPointerCount, motionEvent);
        }
        if (isNeedRebound() && getScale() == this.mDefaultScale) {
            if (isVerticalLongPhoto(this.degrees)) {
                checkBorderWhenTranslate();
                setImageMatrix(this.mScaleMatrix);
            } else {
                reset();
            }
        } else {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                startFling(this.mWidth, this.mHeight, (int) (-this.mVelocityTracker.getXVelocity()), (int) (-this.mVelocityTracker.getYVelocity()));
            }
        }
        this.mScrollDirection = 0;
        if (canUpdateRegionRect()) {
            getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void handleDown(MotionEvent motionEvent, RectF rectF) {
        VelocityTracker obtain = VelocityTracker.obtain();
        this.mVelocityTracker = obtain;
        if (obtain != null) {
            obtain.addMovement(motionEvent);
        }
        BrowserFlingAnimator browserFlingAnimator = this.mFlingAnimator;
        if (browserFlingAnimator != null) {
            browserFlingAnimator.cancelFling();
            this.mFlingAnimator = null;
        }
        if (rectF.width() > this.mWidth || rectF.height() > this.mHeight) {
            requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean handleInterceptEvent(RectF rectF, float f16) {
        if (getScale() == this.mDefaultScale && !isVerticalLongPhoto(this.degrees)) {
            if ((f16 > 0.0f && enableScrollLeft()) || (f16 < 0.0f && enableScrollRight())) {
                requestDisallowInterceptTouchEvent(false);
                return true;
            }
        } else if (rectF.width() > this.mWidth || rectF.height() > this.mHeight) {
            requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    private float handleLeftScroll(RectF rectF, float f16) {
        if (rectF.left > 0.0f) {
            if (enableScrollLeft()) {
                if (Math.abs(rectF.left) > this.mTurnPageMaxDistance) {
                    requestDisallowInterceptTouchEvent(false);
                    requestDisallowInterceptDragEvent(true);
                } else {
                    return f16;
                }
            } else {
                requestDisallowInterceptTouchEvent(true);
                if (Math.abs(rectF.left) <= this.mWidth / 4.0f) {
                    return f16;
                }
            }
            return 0.0f;
        }
        return f16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        if (isVerticalLongPhoto(r8.degrees) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        if (java.lang.Math.abs(r8.mWidth - r13.right) > (r8.mWidth / 4.0f)) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleMove(MotionEvent motionEvent, float f16, float f17, int i3, RectF rectF) {
        float f18 = f16 - this.mLastX;
        float f19 = f17 - this.mLastY;
        if (handleInterceptEvent(rectF, f18)) {
            return true;
        }
        if (this.mDrawable != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.isCheckLeftAndRight = true;
            this.isCheckTopAndBottom = true;
            if (rectF.width() < this.mWidth && rectF.height() < this.mHeight) {
                this.isCheckLeftAndRight = false;
                this.isCheckTopAndBottom = false;
                f18 = 0.0f;
                f19 = 0.0f;
            }
            float handleLeftScroll = handleLeftScroll(rectF, f18);
            if (rectF.right < this.mWidth) {
                if (enableScrollRight()) {
                    if (Math.abs(this.mWidth - rectF.right) > this.mTurnPageMaxDistance) {
                        requestDisallowInterceptTouchEvent(false);
                        requestDisallowInterceptDragEvent(true);
                        f18 = 0.0f;
                    }
                } else {
                    requestDisallowInterceptTouchEvent(true);
                }
                if (getScale() == this.mDefaultScale) {
                    float f26 = rectF.top;
                    if (f26 > 0.0f && Math.abs(f26) > this.mWidth / 4.0f) {
                        requestDisallowInterceptDragEvent(false);
                        f19 = 0.0f;
                    }
                    float f27 = rectF.bottom;
                    int i16 = this.mHeight;
                    if (f27 < i16 && Math.abs(i16 - f27) > this.mWidth / 4.0f) {
                        requestDisallowInterceptDragEvent(true);
                        f19 = 0.0f;
                    }
                }
            }
            f18 = handleLeftScroll;
            if (getScale() == this.mDefaultScale) {
            }
        }
        if (handlePhotoTranslate(i3, rectF, f18, f19)) {
            return true;
        }
        this.mLastX = f16;
        this.mLastY = f17;
        return false;
    }

    private boolean handlePhotoTranslate(int i3, RectF rectF, float f16, float f17) {
        if (isVerticalLongPhoto(this.degrees) && getScale() == this.mDefaultScale) {
            if (Math.abs(f16) / Math.abs(f17) >= 6.0f && Math.abs(f17) < 10.0f) {
                requestDisallowInterceptTouchEvent(false);
                requestDisallowInterceptDragEvent(true);
                return true;
            }
            if (i3 < 2 && rectF.top > 0.0f && Math.abs(f17) / Math.abs(f16) >= 6.0f && Math.abs(f16) < 10.0f) {
                requestDisallowInterceptTouchEvent(true);
                requestDisallowInterceptDragEvent(false);
            } else {
                f16 = 0.0f;
            }
        }
        Matrix matrix = this.mScaleMatrix;
        if (matrix != null) {
            matrix.postTranslate(f16, f17);
            setImageMatrix(this.mScaleMatrix);
        }
        handleRegionRect(f16);
        return false;
    }

    private void handleRegionRect(float f16) {
        if (canUpdateRegionRect()) {
            if (f16 == 0.0f) {
                this.mScrollDirection = 0;
            } else if (f16 < 0.0f) {
                this.mScrollDirection = 1;
            } else {
                this.mScrollDirection = 2;
            }
            getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, 1, this.mScrollDirection);
        }
    }

    private void initScaleValue(float f16) {
        this.mDefaultScale = f16;
        if (isHorizonLongPhoto()) {
            float intrinsicWidth = (this.mDrawable.getIntrinsicWidth() * 1.0f) / this.mWidth;
            this.mMaxScale = intrinsicWidth;
            this.mMaxOverScale = intrinsicWidth * 1.1f;
        } else {
            float max = Math.max(this.mDefaultScale * 4.0f, 1.0f);
            this.mMaxScale = max;
            this.mMaxOverScale = max * 5.0f;
        }
        float f17 = this.mDefaultScale;
        this.mMidScale = 2.0f * f17;
        this.mMinScale = f17 * 0.6f;
    }

    private boolean isHorizonLongPhoto() {
        if (this.mDrawable == null || r0.getIntrinsicWidth() < this.mDrawable.getIntrinsicHeight() * 3) {
            return false;
        }
        return true;
    }

    private boolean isHorizonRotate(int i3) {
        if (i3 != 90 && i3 != 270) {
            return false;
        }
        return true;
    }

    private boolean isLongPhoto() {
        if (this.mDrawable == null) {
            return false;
        }
        if (this.mDrawable.getIntrinsicHeight() < r0.getIntrinsicWidth() * 3) {
            return false;
        }
        return true;
    }

    private boolean isNeedRebound() {
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF.left <= 0.0f && matrixRectF.right >= this.mWidth && matrixRectF.top <= 0.0f && matrixRectF.bottom >= this.mHeight) {
            return false;
        }
        return true;
    }

    private boolean isSingle() {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null && mainBrowserPresenter.getItemCount() == 1) {
            return true;
        }
        return false;
    }

    private boolean isVerticalLongPhoto(int i3) {
        if (!isHorizonRotate(i3) && isLongPhoto()) {
            return true;
        }
        return false;
    }

    private void requestDisallowInterceptDragEvent(boolean z16) {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.requestDisallowInterceptDragEvent(z16);
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z16) {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void showDefaultImage(int i3, int i16, int i17, float f16, float f17, float f18) {
        if (isVerticalLongPhoto(i17)) {
            showLongImage(i3, i16, i17, f16, f17, f18);
        } else {
            showNormalImage(i3, i16, i17, f16, f17, f18);
        }
    }

    private void showLongImage(int i3, int i16, int i17, float f16, float f17, float f18) {
        Matrix matrix = new Matrix();
        this.mScaleMatrix = matrix;
        if (f16 != 1.0f) {
            matrix.postScale(f16, f16, f17, f18);
            setImageMatrix(this.mScaleMatrix);
            float f19 = 1.0f - f16;
            this.mScaleMatrix.postTranslate(-((this.mDrawable.getIntrinsicWidth() * f19) / 2.0f), -((this.mDrawable.getIntrinsicHeight() * f19) / 2.0f));
            setImageMatrix(this.mScaleMatrix);
        }
    }

    private void showNormalImage(int i3, int i16, int i17, float f16, float f17, float f18) {
        Matrix matrix = new Matrix();
        this.mScaleMatrix = matrix;
        matrix.postRotate(i17, f17, f18);
        setImageMatrix(this.mScaleMatrix);
        this.mScaleMatrix.postTranslate(i3, i16);
        setImageMatrix(this.mScaleMatrix);
        this.mScaleMatrix.postScale(f16, f16, this.mWidth / 2, this.mHeight / 2);
        setImageMatrix(this.mScaleMatrix);
    }

    private void startFling(int i3, int i16, int i17, int i18) {
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "startFling...velocityX = " + i17 + ", velocityY = " + i18);
        if (this.mFlingAnimator == null) {
            BrowserFlingAnimator browserFlingAnimator = new BrowserFlingAnimator(getContext());
            this.mFlingAnimator = browserFlingAnimator;
            browserFlingAnimator.setBrowserFlingControlListener(this);
            this.mFlingAnimator.setBrowserFlingEventListener(this);
        }
        this.mFlingAnimator.startFling(i3, i16, i17, i18, enableScrollLeft(), enableScrollRight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScale(float f16, float f17, float f18) {
        BrowserScaleAnimator browserScaleAnimator = new BrowserScaleAnimator(f16, f17, f18);
        browserScaleAnimator.setBrowserScaleControlListener(this);
        browserScaleAnimator.setBrowserScaleEventListener(this);
        browserScaleAnimator.initAnimator();
        browserScaleAnimator.start();
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingControlListener
    public RectF getCurrentMatrixRectF() {
        return getMatrixRectF();
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleControlListener
    public float getCurrentScale() {
        return getScale();
    }

    public void initDrawable(Drawable drawable, int i3, int i16, int i17) {
        initDrawable(drawable, i3, i16, i17, false);
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingEventListener
    public void onFlingAnimationEnd() {
        if (canUpdateRegionRect()) {
            getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (!this.isScaleEnable || this.mDrawable == null) {
            return false;
        }
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onScale();
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float scale = getScale();
        if ((scaleFactor > 1.0f && scale * scaleFactor < this.mMaxOverScale) || (scaleFactor < 1.0f && scale * scaleFactor > this.mMinScale)) {
            float f16 = scale * scaleFactor;
            float f17 = this.mMaxOverScale;
            if (f16 > f17) {
                scaleFactor = f17 / scale;
            }
            float f18 = scale * scaleFactor;
            float f19 = this.mMinScale;
            if (f18 < f19) {
                scaleFactor = f19 / scale;
            }
            this.mScaleMatrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            checkBorderAndCenterWhenScale();
            setImageMatrix(this.mScaleMatrix);
            return true;
        }
        return true;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationCancel() {
        this.isAutoScale = false;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationEnd() {
        this.isAutoScale = false;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationStart() {
        this.isAutoScale = true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onScaleBegin();
        }
        if (canUpdateRegionRect()) {
            getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, false, this.mScrollDirection);
            return true;
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onScaleEnd();
        }
        float scale = getScale();
        if (scale > this.mDefaultScale && scale <= this.mMaxScale) {
            if (canUpdateRegionRect()) {
                getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
                return;
            }
            return;
        }
        getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, false, this.mScrollDirection);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r1 != 3) goto L24;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        int pointerCount = motionEvent.getPointerCount();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            f16 += motionEvent.getX(i3);
            f17 += motionEvent.getY(i3);
        }
        float f18 = pointerCount;
        float f19 = f16 / f18;
        float f26 = f17 / f18;
        if (this.mLastPointerCount != pointerCount) {
            this.mLastX = f19;
            this.mLastY = f26;
        }
        this.mLastPointerCount = pointerCount;
        RectF matrixRectF = getMatrixRectF();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (handleMove(motionEvent, f19, f26, pointerCount, matrixRectF)) {
                        return false;
                    }
                }
            }
            handleCancel(motionEvent);
        } else {
            this.mLastDownX = motionEvent.getX();
            this.mLastDownY = motionEvent.getY();
            this.mLastDownPointerCount = motionEvent.getPointerCount();
            handleDown(motionEvent, matrixRectF);
        }
        return true;
    }

    public void reset() {
        showDefaultImage(this.defaultDx, this.defaultDy, this.degrees, this.mDefaultScale, this.privorX, this.privorY);
    }

    public void setDoubleTapEnable(boolean z16) {
        this.isDoubleTapEnable = z16;
    }

    public void setMainBrowserPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.mMainBrowserPresenter = mainBrowserPresenter;
    }

    public void setOnItemEventListener(c cVar) {
        this.mItemEventListener = cVar;
    }

    public void setScaleEnable(boolean z16) {
        this.isScaleEnable = z16;
    }

    public BrowserScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDoubleTapEnable = true;
        this.isScaleEnable = true;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mTurnPageMaxDistance = ScreenUtils.dip2px(context, 80.0f);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!BrowserScaleView.this.isDoubleTapEnable) {
                    return false;
                }
                if (BrowserScaleView.this.mMainBrowserPresenter != null) {
                    BrowserScaleView.this.mMainBrowserPresenter.onDoubleTap();
                }
                if (BrowserScaleView.this.isAutoScale) {
                    return true;
                }
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                if (BrowserScaleView.this.getScale() < BrowserScaleView.this.mMidScale) {
                    BrowserScaleView browserScaleView = BrowserScaleView.this;
                    browserScaleView.startScale(browserScaleView.mMidScale, x16, y16);
                } else {
                    BrowserScaleView browserScaleView2 = BrowserScaleView.this;
                    browserScaleView2.startScale(browserScaleView2.mDefaultScale, x16, y16);
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (BrowserScaleView.this.mItemEventListener != null) {
                    BrowserScaleView.this.mItemEventListener.onLongClickEvent();
                }
                super.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (f16 == 0.0f) {
                    BrowserScaleView.this.mScrollDirection = 0;
                } else if (f16 < 0.0f) {
                    BrowserScaleView.this.mScrollDirection = 1;
                } else {
                    BrowserScaleView.this.mScrollDirection = 2;
                }
                if (BrowserScaleView.this.canUpdateRegionRect()) {
                    RegionRectHelper regionRectHelper = BrowserScaleView.this.getRegionRectHelper();
                    Drawable drawable = BrowserScaleView.this.mDrawable;
                    Matrix matrix = BrowserScaleView.this.mScaleMatrix;
                    float f18 = BrowserScaleView.this.mDefaultScale;
                    float scale = BrowserScaleView.this.getScale();
                    BrowserScaleView browserScaleView = BrowserScaleView.this;
                    regionRectHelper.updateShowArea(drawable, matrix, f18, scale, browserScaleView, true, 1, browserScaleView.mScrollDirection);
                }
                return super.onScroll(motionEvent, motionEvent2, f16, f17);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (BrowserScaleView.this.mItemEventListener != null) {
                    BrowserScaleView.this.mItemEventListener.onClickEvent();
                    return true;
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    public void initDrawable(Drawable drawable, int i3, int i16, int i17, boolean z16) {
        float f16;
        float f17;
        float f18;
        float f19;
        this.mDrawable = drawable;
        this.degrees = i17;
        this.mScaleMatrix = new Matrix();
        this.mWidth = i3;
        this.mHeight = i16;
        Drawable drawable2 = this.mDrawable;
        if (drawable2 == null) {
            return;
        }
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        if (isHorizonRotate(i17)) {
            intrinsicWidth = this.mDrawable.getIntrinsicHeight();
            intrinsicHeight = this.mDrawable.getIntrinsicWidth();
        }
        float f26 = (intrinsicWidth < i3 || intrinsicHeight > i16) ? 1.0f : (i3 * 1.0f) / intrinsicWidth;
        if (intrinsicWidth <= i3 && intrinsicHeight >= i16) {
            if (isVerticalLongPhoto(i17)) {
                f18 = i3 * 1.0f;
                f19 = intrinsicWidth;
            } else {
                f18 = i16 * 1.0f;
                f19 = intrinsicHeight;
            }
            f26 = f18 / f19;
        }
        if (intrinsicWidth <= i3 && intrinsicHeight <= i16) {
            if (!isVerticalLongPhoto(i17)) {
                if (z16) {
                    if (intrinsicWidth * i16 <= intrinsicHeight * i3) {
                        f16 = i16 * 1.0f;
                        f17 = intrinsicHeight;
                        f26 = f16 / f17;
                    }
                }
            }
            f16 = i3 * 1.0f;
            f17 = intrinsicWidth;
            f26 = f16 / f17;
        }
        if (intrinsicWidth >= i3 && intrinsicHeight >= i16) {
            f26 = isVerticalLongPhoto(i17) ? (i3 * 1.0f) / intrinsicWidth : Math.min((i3 * 1.0f) / intrinsicWidth, (i16 * 1.0f) / intrinsicHeight);
        }
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dw = " + intrinsicWidth + ", dh = " + intrinsicHeight + ", width = " + i3 + ", height" + i16 + ", degrees = " + i17 + ", scale = " + f26);
        this.defaultDx = (i3 / 2) - (this.mDrawable.getIntrinsicWidth() / 2);
        this.defaultDy = (i16 / 2) - (this.mDrawable.getIntrinsicHeight() / 2);
        this.privorX = this.mDrawable.getIntrinsicWidth() / 2;
        int intrinsicHeight2 = this.mDrawable.getIntrinsicHeight() / 2;
        this.privorY = intrinsicHeight2;
        showDefaultImage(this.defaultDx, this.defaultDy, i17, f26, (float) this.privorX, (float) intrinsicHeight2);
        if (isVerticalLongPhoto(i17)) {
            this.mDefaultScale = f26;
            this.mMidScale = 2.0f * f26;
            this.mMinScale = 0.6f * f26;
            float max = Math.max(f26 * 4.0f, 1.0f);
            this.mMaxScale = max;
            this.mMaxOverScale = max * 5.0f;
            return;
        }
        initScaleValue(f26);
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleControlListener
    public void startScale(float f16, float f17, float f18, float f19) {
        Matrix matrix = this.mScaleMatrix;
        if (matrix != null) {
            matrix.postScale(f16, f17, f18, f19);
            checkBorderAndCenterWhenScale();
            setImageMatrix(this.mScaleMatrix);
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingControlListener
    public void startFling(float f16, float f17) {
        this.mScaleMatrix.postTranslate(f16, f17);
        setImageMatrix(this.mScaleMatrix);
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingEventListener
    public void onFlingAnimationCancel() {
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingEventListener
    public void onFlingAnimationRepeat() {
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingEventListener
    public void onFlingAnimationStart() {
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationRepeat() {
    }
}
