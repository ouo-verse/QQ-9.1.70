package com.tencent.richframework.widget.matrix;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* loaded from: classes25.dex */
public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    private float mBaseRotation;
    private FlingRunnable mCurrentFlingRunnable;
    private GestureDetector mGestureDetector;
    private final ImageView mImageView;
    private boolean mIsAutoMagnified;
    private boolean mIsLockScale;
    private View.OnLongClickListener mLongClickListener;
    private OnDoubleTapListener mOnDoubleTapListener;
    private OnScaleBeginListener mOnScaleBeginListener;
    private OnScaleEndListener mOnScaleEndListener;
    private CustomGestureDetector mScaleDragDetector;
    private float mScaleFocusX;
    private float mScaleFocusY;
    private OnViewTapListener mViewTapListener;
    private final OnGestureListener onGestureListener;
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private int mZoomDuration = 150;
    private float mMinScale = 1.0f;
    private float mMidScale = 1.75f;
    private float mMaxScale = 3.5f;
    private boolean mAllowParentInterceptOnEdge = true;
    private boolean mBlockParentIntercept = false;
    private final Matrix mBaseMatrix = new Matrix();
    private final Matrix mDrawMatrix = new Matrix();
    private final Matrix mSuppMatrix = new Matrix();
    private final RectF mDisplayRect = new RectF();
    private final float[] mMatrixValues = new float[9];
    private int mHorizontalScrollEdge = 2;
    private int mVerticalScrollEdge = 2;
    private boolean mZoomEnabled = true;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.richframework.widget.matrix.PhotoViewAttacher$4, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private final long mAnimatedDuration;
        private final float mFocalX;
        private final float mFocalY;
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(PhotoViewAttacher photoViewAttacher, float f16, float f17, float f18, float f19) {
            this(f16, f17, f18, f19, photoViewAttacher.mZoomDuration);
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(this.mAnimatedDuration);
            duration.setInterpolator(PhotoViewAttacher.this.mInterpolator);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.widget.matrix.PhotoViewAttacher.AnimatedZoomRunnable.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float scale = (AnimatedZoomRunnable.this.mZoomStart + ((AnimatedZoomRunnable.this.mZoomEnd - AnimatedZoomRunnable.this.mZoomStart) * floatValue)) / PhotoViewAttacher.this.getScale();
                    PhotoViewAttacher.this.onGestureListener.onScale(scale, AnimatedZoomRunnable.this.mFocalX, AnimatedZoomRunnable.this.mFocalY);
                    RFWLog.d("PhotoViewAttacher", RFWLog.DEV, "AnimatedZoomRunnable t:" + floatValue + " deltaScale:" + scale + " mFocalX:" + AnimatedZoomRunnable.this.mFocalX + " mFocalY:" + AnimatedZoomRunnable.this.mFocalY);
                }
            });
            duration.start();
        }

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19, long j3) {
            this.mFocalX = f18;
            this.mFocalY = f19;
            this.mZoomStart = f16;
            this.mZoomEnd = f17;
            this.mAnimatedDuration = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i3, int i16, int i17, int i18) {
            int i19;
            int i26;
            int i27;
            int i28;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f16 = i3;
            if (f16 < displayRect.width()) {
                i26 = Math.round(displayRect.width() - f16);
                i19 = 0;
            } else {
                i19 = round;
                i26 = i19;
            }
            int round2 = Math.round(-displayRect.top);
            float f17 = i16;
            if (f17 < displayRect.height()) {
                i28 = Math.round(displayRect.height() - f17);
                i27 = 0;
            } else {
                i27 = round2;
                i28 = i27;
            }
            this.mCurrentX = round;
            this.mCurrentY = round2;
            if (round != i26 || round2 != i28) {
                this.mScroller.fling(round, round2, i17, i18, i19, i26, i27, i28, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                PhotoViewAttacher.this.mImageView.postOnAnimation(this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        OnGestureListener onGestureListener = new OnGestureListener() { // from class: com.tencent.richframework.widget.matrix.PhotoViewAttacher.1
            @Override // com.tencent.richframework.widget.matrix.OnGestureListener
            public void onDrag(float f16, float f17) {
                if (PhotoViewAttacher.this.mScaleDragDetector.isScaling()) {
                    return;
                }
                PhotoViewAttacher.access$100(PhotoViewAttacher.this);
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(f16, f17);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                ViewParent parent = PhotoViewAttacher.this.mImageView.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(PhotoViewAttacher.this.isNeedToDisAllowParentInterceptEvent(f16, f17));
                }
            }

            @Override // com.tencent.richframework.widget.matrix.OnGestureListener
            public void onFling(float f16, float f17, float f18, float f19) {
                RFWLog.d("PhotoViewAttacher", RFWLog.CLR, "onFling startX:" + f16 + " startY:" + f17 + " getScale:" + PhotoViewAttacher.this.getScale() + " velocityX:" + f18 + " velocityY:" + f19);
                if (PhotoViewAttacher.this.getScale() == 1.0f) {
                    return;
                }
                PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                photoViewAttacher.mCurrentFlingRunnable = new FlingRunnable(photoViewAttacher.mImageView.getContext());
                FlingRunnable flingRunnable = PhotoViewAttacher.this.mCurrentFlingRunnable;
                PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                int imageViewWidth = photoViewAttacher2.getImageViewWidth(photoViewAttacher2.mImageView);
                PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                flingRunnable.fling(imageViewWidth, photoViewAttacher3.getImageViewHeight(photoViewAttacher3.mImageView), (int) f18, (int) f19);
                PhotoViewAttacher.this.mImageView.post(PhotoViewAttacher.this.mCurrentFlingRunnable);
            }

            @Override // com.tencent.richframework.widget.matrix.OnGestureListener
            public void onScale(float f16, float f17, float f18) {
                float scale = PhotoViewAttacher.this.getScale();
                PhotoViewAttacher.this.mScaleFocusX = f17;
                PhotoViewAttacher.this.mScaleFocusY = f18;
                if (scale <= PhotoViewAttacher.this.mMaxScale * 2.0f || f16 <= 1.0f) {
                    if (scale < 0.6f && f16 < 1.0f) {
                        return;
                    }
                    PhotoViewAttacher.access$1100(PhotoViewAttacher.this);
                    PhotoViewAttacher.this.mSuppMatrix.postScale(f16, f16, f17, f18);
                    PhotoViewAttacher.this.checkAndDisplayMatrix();
                }
            }
        };
        this.onGestureListener = onGestureListener;
        this.mImageView = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.mBaseRotation = 0.0f;
        this.mScaleDragDetector = new CustomGestureDetector(imageView.getContext(), onGestureListener);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.richframework.widget.matrix.PhotoViewAttacher.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                PhotoViewAttacher.access$1400(PhotoViewAttacher.this);
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.mLongClickListener != null) {
                    PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.mImageView);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                RFWLog.d("PhotoViewAttacher", RFWLog.DEV, "onScroll distanceX:" + f16 + " distanceY:" + f17);
                float f18 = 0.0f - f16;
                float f19 = 0.0f - f17;
                PhotoViewAttacher.this.onGestureListener.onDrag(f18, f19);
                return PhotoViewAttacher.this.isNeedToDisAllowParentInterceptEvent(f18, f19);
            }
        }, new Handler(Looper.getMainLooper()));
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.tencent.richframework.widget.matrix.PhotoViewAttacher.3
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                RFWLog.i("PhotoViewAttacher", RFWLog.USR, " onDoubleTap" + motionEvent);
                if (PhotoViewAttacher.this.mOnDoubleTapListener != null) {
                    PhotoViewAttacher.this.mOnDoubleTapListener.onDoubleTap();
                }
                try {
                    float scale = PhotoViewAttacher.this.getScale();
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    if (scale < PhotoViewAttacher.this.getMediumScale()) {
                        PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                        photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x16, y16, true);
                    } else if (scale >= PhotoViewAttacher.this.getMediumScale() && scale < PhotoViewAttacher.this.getMaximumScale()) {
                        PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                        photoViewAttacher2.setScale(photoViewAttacher2.getMaximumScale(), x16, y16, true);
                    } else {
                        PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                        photoViewAttacher3.setScale(photoViewAttacher3.getMinimumScale(), x16, y16, true);
                    }
                    RFWLog.i("PhotoViewAttacher", RFWLog.DEV, "onDoubleTap ev:" + motionEvent.getAction() + " x:" + x16 + " y:" + y16 + " scale:" + scale);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                RFWLog.i("PhotoViewAttacher", RFWLog.USR, " onDoubleTapEvent" + motionEvent);
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                RFWLog.i("PhotoViewAttacher", RFWLog.USR, " onSingleTapConfirmed" + motionEvent);
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                if (PhotoViewAttacher.this.mViewTapListener != null) {
                    PhotoViewAttacher.this.mViewTapListener.onViewTap(PhotoViewAttacher.this.mImageView, x16, y16);
                    return false;
                }
                return false;
            }
        });
    }

    static /* synthetic */ OnViewDragListener access$100(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* synthetic */ OnScaleChangedListener access$1100(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* synthetic */ OnSingleFlingListener access$1400(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private boolean checkMatrixBounds() {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        RectF displayRect = getDisplayRect(getDrawMatrix());
        if (displayRect == null) {
            return false;
        }
        float height = displayRect.height();
        float width = displayRect.width();
        float imageViewHeight = getImageViewHeight(this.mImageView);
        float f27 = 0.0f;
        if (height <= imageViewHeight) {
            int i3 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f19 = (imageViewHeight - height) / 2.0f;
                    f26 = displayRect.top;
                } else {
                    f19 = imageViewHeight - height;
                    f26 = displayRect.top;
                }
                f16 = f19 - f26;
            } else {
                f16 = -displayRect.top;
            }
            this.mVerticalScrollEdge = 2;
        } else {
            float f28 = displayRect.top;
            if (f28 > 0.0f) {
                this.mVerticalScrollEdge = 0;
                f16 = -f28;
            } else {
                float f29 = displayRect.bottom;
                if (f29 < imageViewHeight) {
                    this.mVerticalScrollEdge = 1;
                    f16 = imageViewHeight - f29;
                } else {
                    this.mVerticalScrollEdge = -1;
                    f16 = 0.0f;
                }
            }
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        if (width <= imageViewWidth) {
            int i16 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i16 != 2) {
                if (i16 != 3) {
                    f17 = (imageViewWidth - width) / 2.0f;
                    f18 = displayRect.left;
                } else {
                    f17 = imageViewWidth - width;
                    f18 = displayRect.left;
                }
                f27 = f17 - f18;
            } else {
                f27 = -displayRect.left;
            }
            this.mHorizontalScrollEdge = 2;
        } else {
            float f36 = displayRect.left;
            if (f36 > 0.0f) {
                this.mHorizontalScrollEdge = 0;
                f27 = -f36;
            } else {
                float f37 = displayRect.right;
                if (f37 < imageViewWidth) {
                    f27 = imageViewWidth - f37;
                    this.mHorizontalScrollEdge = 1;
                } else {
                    this.mHorizontalScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f27, f16);
        return true;
    }

    private boolean checkNeedIntercept() {
        if (this.mAllowParentInterceptOnEdge && !this.mScaleDragDetector.isScaling() && !this.mBlockParentIntercept) {
            return true;
        }
        return false;
    }

    private Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageViewHeight(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageViewWidth(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float getValue(Matrix matrix, int i3) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i3];
    }

    private boolean isScrollHorizontalInEdge(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f16) > Math.abs(f17)) {
            int i3 = this.mHorizontalScrollEdge;
            if (i3 == 2 || ((i3 == 0 && f16 >= f18) || (i3 == 1 && f16 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isScrollVerticalInEdge(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f17) > Math.abs(f16)) {
            int i3 = this.mVerticalScrollEdge;
            if (i3 == 2 || ((i3 == 0 && f17 >= f18) || (i3 == 1 && f17 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean leftBottomScrollInEdge(float f16, float f17, float f18) {
        if (this.mVerticalScrollEdge == 1 && this.mHorizontalScrollEdge == 0 && f17 <= 0.0f - f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private boolean leftTopScrollInEdge(float f16, float f17, float f18) {
        if (this.mVerticalScrollEdge == 0 && this.mHorizontalScrollEdge == 0 && f17 >= f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    private boolean rightBottomScrollInEdge(float f16, float f17, float f18) {
        if (this.mVerticalScrollEdge == 1 && this.mHorizontalScrollEdge == 1) {
            float f19 = 0.0f - f18;
            if (f17 <= f19 && f16 <= f19) {
                return true;
            }
        }
        return false;
    }

    private boolean rightTopScrollInEdge(float f16, float f17, float f18) {
        if (this.mVerticalScrollEdge == 0 && this.mHorizontalScrollEdge == 1 && f17 >= f18 && f16 <= 0.0f - f18) {
            return true;
        }
        return false;
    }

    private void setImageViewMatrix(Matrix matrix) {
        this.mImageView.setImageMatrix(matrix);
    }

    private void updateBaseMatrix(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        float imageViewHeight = getImageViewHeight(this.mImageView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        RFWLog.d("PhotoViewAttacher", RFWLog.DEV, "updateBaseMatrix viewWidth:" + imageViewWidth + " viewHeight:" + imageViewHeight + " drawableWidth:" + intrinsicWidth + " drawableHeight:" + intrinsicHeight + " drawableHash:" + drawable.hashCode());
        this.mBaseMatrix.reset();
        float f16 = (float) intrinsicWidth;
        float f17 = imageViewWidth / f16;
        float f18 = (float) intrinsicHeight;
        float f19 = imageViewHeight / f18;
        ImageView.ScaleType scaleType = this.mScaleType;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((imageViewWidth - f16) / 2.0f, (imageViewHeight - f18) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f17, f19);
            this.mBaseMatrix.postScale(max, max);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f16 * max)) / 2.0f, (imageViewHeight - (f18 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f17, f19));
            this.mBaseMatrix.postScale(min, min);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f16 * min)) / 2.0f, (imageViewHeight - (f18 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f16, f18);
            RectF rectF2 = new RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
            if (((int) this.mBaseRotation) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f18, f16);
            }
            int i3 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            } else {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        resetMatrix();
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow(getValue(this.mSuppMatrix, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    public boolean isAutoMagnified() {
        return this.mIsAutoMagnified;
    }

    public boolean isNeedToDisAllowParentInterceptEvent(float f16, float f17) {
        boolean z16;
        boolean z17;
        if (!checkNeedIntercept()) {
            return true;
        }
        if (Math.abs(f17) > 8.0f && Math.abs(f17) > Math.abs(f16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Math.abs(f16) > 8.0f && Math.abs(f16) > Math.abs(f17)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (isScrollVerticalInEdge(f16, f17, 8.0f, 0.6f, z16) || isScrollHorizontalInEdge(f16, f17, 8.0f, 0.6f, z17)) {
            return false;
        }
        if (!leftTopScrollInEdge(f16, f17, 8.0f) && !rightTopScrollInEdge(f16, f17, 8.0f) && !leftBottomScrollInEdge(f16, f17, 8.0f) && !rightBottomScrollInEdge(f16, f17, 8.0f)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
            updateBaseMatrix(this.mImageView.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0167  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z16;
        CustomGestureDetector customGestureDetector;
        boolean z17;
        GestureDetector gestureDetector;
        boolean z18;
        boolean z19;
        boolean z26;
        float f16;
        if (!this.mZoomEnabled || !Util.hasDrawable((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (getScale() < this.mMinScale) {
                    float scale = getScale();
                    if (scale < 0.6f) {
                        f16 = 0.6f;
                    } else {
                        f16 = scale;
                    }
                    RectF displayRect = getDisplayRect();
                    if (displayRect != null) {
                        view.post(new AnimatedZoomRunnable(this, f16, this.mMinScale, displayRect.centerX(), displayRect.centerY()));
                        z16 = true;
                    }
                } else if (getScale() > this.mMaxScale) {
                    float scale2 = getScale();
                    float f17 = this.mMaxScale;
                    if (scale2 > f17 * 2.0f) {
                        scale2 = f17 * 2.0f;
                    }
                    float f18 = scale2;
                    RFWLog.d("PhotoViewAttacher", RFWLog.DEV, "postAnimationZoom maxscale event:" + motionEvent.getAction() + " scale:" + getScale() + " startScale:" + f18 + " mMaxScale:" + this.mMaxScale + " scaleX:" + this.mScaleFocusX + " scaleY:" + this.mScaleFocusY);
                    view.post(new AnimatedZoomRunnable(this, f18, this.mMaxScale, this.mScaleFocusX, this.mScaleFocusY));
                    z16 = true;
                }
                customGestureDetector = this.mScaleDragDetector;
                if (customGestureDetector == null) {
                    boolean isScaling = customGestureDetector.isScaling();
                    boolean isDragging = this.mScaleDragDetector.isDragging();
                    boolean onTouchEvent = this.mScaleDragDetector.onTouchEvent(motionEvent);
                    if (!isScaling && !this.mScaleDragDetector.isScaling()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!isDragging && !this.mScaleDragDetector.isDragging()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    int pointerCount = motionEvent.getPointerCount();
                    if ((z18 && z19) || pointerCount > 1) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    this.mBlockParentIntercept = z26;
                    RFWLog.d("PhotoViewAttacher", RFWLog.DEV, "onTouch scaleDragDetector wasScaling:" + isScaling + " wasDragging:" + isDragging + " didntScale:" + z18 + " didntDrag:" + z19 + " mBlockParentIntercept:" + this.mBlockParentIntercept);
                    if (pointerCount > 1) {
                        this.mIsAutoMagnified = false;
                    }
                    z17 = onTouchEvent;
                } else {
                    z17 = z16;
                }
                gestureDetector = this.mGestureDetector;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } else {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            cancelFling();
        }
        z16 = false;
        customGestureDetector = this.mScaleDragDetector;
        if (customGestureDetector == null) {
        }
        gestureDetector = this.mGestureDetector;
        return gestureDetector == null ? z17 : z17;
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.mAllowParentInterceptOnEdge = z16;
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix != null) {
            if (this.mImageView.getDrawable() == null) {
                return false;
            }
            this.mSuppMatrix.set(matrix);
            checkAndDisplayMatrix();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    public void setIsAutoMagnified(boolean z16) {
        this.mIsAutoMagnified = z16;
    }

    public void setMaximumScale(float f16) {
        Util.checkZoomLevels(this.mMinScale, this.mMidScale, f16);
        this.mMaxScale = f16;
    }

    public void setMediumScale(float f16) {
        Util.checkZoomLevels(this.mMinScale, f16, this.mMaxScale);
        this.mMidScale = f16;
    }

    public void setMinimumScale(float f16) {
        Util.checkZoomLevels(f16, this.mMidScale, this.mMaxScale);
        this.mMinScale = f16;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnScaleBeginListener(OnScaleBeginListener onScaleBeginListener) {
        this.mOnScaleBeginListener = onScaleBeginListener;
        CustomGestureDetector customGestureDetector = this.mScaleDragDetector;
        if (customGestureDetector != null) {
            customGestureDetector.setOnScaleBeginListener(onScaleBeginListener);
        }
    }

    public void setOnScaleEndListener(OnScaleEndListener onScaleEndListener) {
        this.mOnScaleEndListener = onScaleEndListener;
        CustomGestureDetector customGestureDetector = this.mScaleDragDetector;
        if (customGestureDetector != null) {
            customGestureDetector.setOnScaleEndListener(onScaleEndListener);
        }
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public void setRotationBy(float f16) {
        this.mSuppMatrix.postRotate(f16 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f16) {
        this.mSuppMatrix.setRotate(f16 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setScale(float f16) {
        setScale(f16, false);
    }

    public void setScaleLevels(float f16, float f17, float f18) {
        Util.checkZoomLevels(f16, f17, f18);
        this.mMinScale = f16;
        this.mMidScale = f17;
        this.mMaxScale = f18;
    }

    public void setScaleLockState(boolean z16) {
        this.mIsLockScale = z16;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (Util.isSupportedScaleType(scaleType) && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            update();
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.mZoomDuration = i3;
    }

    public void setZoomable(boolean z16) {
        this.mZoomEnabled = z16;
        update();
    }

    public void update() {
        if (this.mZoomEnabled) {
            updateBaseMatrix(this.mImageView.getDrawable());
        } else {
            resetMatrix();
        }
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mOnDoubleTapListener = onDoubleTapListener;
    }

    public void setScale(float f16, boolean z16) {
        setScale(f16, this.mImageView.getRight() / 2, this.mImageView.getBottom() / 2, z16);
    }

    private RectF getDisplayRect(Matrix matrix) {
        if (this.mImageView.getDrawable() == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        RFWLog.i("PhotoViewAttacher", RFWLog.USR, "setScale animate:" + z16 + "  mImageView:" + this.mImageView.getParent() + " mIsLockScale:" + this.mIsLockScale);
        if (this.mIsLockScale) {
            return;
        }
        if (f16 < this.mMinScale || f16 > this.mMaxScale) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z16) {
            this.mImageView.post(new AnimatedZoomRunnable(this, getScale(), f16, f17, f18));
        } else {
            this.mSuppMatrix.setScale(f16, f16, f17, f18);
            checkAndDisplayMatrix();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
    }
}
