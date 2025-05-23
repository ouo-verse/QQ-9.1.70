package com.tencent.qcircle.tavcut.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qcircle.tavcut.util.FloatUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import common.config.service.QzoneConfig;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SliderView extends FrameLayout {
    private static final String TAG = "SliderView";
    private boolean canAdjust;
    private int frameColor;
    private int mBarWidth;
    private boolean mDragging;
    private String mDuration;
    private Bitmap mDurationBgBitmap;
    private Paint mDurationBgPaint;
    private float mDurationBgRadius;
    private Paint mDurationTextPaint;
    private float mDurationTextSize;
    private Paint mFramePaint;
    private int mFrameRadius;
    private int mFrameStrokeWidth;
    private Drawable mImgLockLeft;
    private Drawable mImgLockRight;
    private Drawable mImgRangeLeft;
    private Drawable mImgRangeRight;
    private Bitmap mIndicatorBitmap;
    private boolean mIndicatorMoved;
    private Paint mIndicatorPaint;
    private boolean mIndicatorPressed;
    private float mIndicatorProgress;
    private float mIndicatorWidth;
    private int mLastX;
    private boolean mLeftBarHandle;
    private ImageView mLeftBarIv;
    private boolean mLeftBarMoved;
    private boolean mLeftBarPressed;
    private boolean mLockMode;
    private String mMaxDurationTips;
    private int mMaxSelectAreaWidth;
    private long mMaxSelectDurationMs;
    private int mMinSelectAreaWidth;
    private int mOriginX;
    private int mPaddingBottom;
    private int mPaddingTop;
    private ImageView mRightBarIv;
    private boolean mRightBarMoved;
    private boolean mRightBarPressed;
    private Paint mSelectAreaPaint;
    private Rect mSelectAreaRect;
    private boolean mShowDuration;
    private boolean mSliderBarMode;
    private SliderChangeListener mSliderChangeListener;
    private long mTotalDurationMs;
    private int mTouchSlop;
    private boolean showIndicator;

    public SliderView(Context context) {
        this(context, null);
    }

    private void drawDuration(Canvas canvas) {
        if (!this.mShowDuration) {
            return;
        }
        Rect rect = new Rect();
        Paint paint = this.mDurationTextPaint;
        String str = this.mDuration;
        paint.getTextBounds(str, 0, str.length(), rect);
        int width = rect.width();
        float dp2px = width + (((int) Util.dp2px(getContext(), 4.5f)) * 2.0f);
        float height = rect.height() + 0.0f;
        RectF rectF = new RectF();
        if (dp2px < this.mSelectAreaRect.width()) {
            rectF.set(this.mSelectAreaRect.left + Util.dp2px(getContext(), 3.0f), (this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0f)) - height, this.mSelectAreaRect.left + Util.dp2px(getContext(), 3.0f) + dp2px, this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0f));
        } else if (this.mSelectAreaRect.centerX() * 2 < getWidth()) {
            float f16 = this.mSelectAreaRect.right + this.mBarWidth;
            float dp2px2 = (r4.bottom - Util.dp2px(getContext(), 5.0f)) - height;
            Rect rect2 = this.mSelectAreaRect;
            rectF.set(f16, dp2px2, rect2.right + this.mBarWidth + dp2px, rect2.bottom - Util.dp2px(getContext(), 5.0f));
        } else {
            Rect rect3 = this.mSelectAreaRect;
            float f17 = (rect3.left - this.mBarWidth) - dp2px;
            float dp2px3 = (rect3.bottom - Util.dp2px(getContext(), 5.0f)) - height;
            Rect rect4 = this.mSelectAreaRect;
            rectF.set(f17, dp2px3, rect4.left - this.mBarWidth, rect4.bottom - Util.dp2px(getContext(), 5.0f));
        }
        Paint.FontMetrics fontMetrics = this.mDurationTextPaint.getFontMetrics();
        canvas.drawText(this.mDuration, rectF.centerX(), (((rectF.bottom + rectF.top) - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.mDurationTextPaint);
    }

    private void drawFrame(Canvas canvas) {
        if (this.mSelectAreaRect == null) {
            this.mSelectAreaRect = new Rect();
        }
        if (this.mSliderBarMode) {
            this.mFramePaint.setColor(this.frameColor);
            this.mFramePaint.setStrokeWidth(0.0f);
            this.mFramePaint.setStyle(Paint.Style.FILL);
            this.mSelectAreaRect.set((int) (this.mLeftBarIv.getX() + this.mBarWidth), this.mPaddingTop, (int) this.mRightBarIv.getX(), getMeasuredHeight() - this.mPaddingBottom);
            Rect rect = this.mSelectAreaRect;
            canvas.drawRect(rect.left - (this.mBarWidth >> 1), rect.top, rect.right + (r2 >> 1), r1 + this.mFrameStrokeWidth, this.mFramePaint);
            Rect rect2 = this.mSelectAreaRect;
            canvas.drawRect(rect2.left - (this.mBarWidth >> 1), r1 - this.mFrameStrokeWidth, rect2.right + (r2 >> 1), rect2.bottom, this.mFramePaint);
            return;
        }
        this.mFramePaint.setColor(this.frameColor);
        this.mFramePaint.setStrokeWidth(this.mFrameStrokeWidth);
        this.mFramePaint.setStyle(Paint.Style.STROKE);
        this.mSelectAreaRect.set(getPaddingLeft(), this.mPaddingTop, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - this.mPaddingBottom);
        RectF rectF = new RectF();
        Rect rect3 = this.mSelectAreaRect;
        rectF.set(rect3.left, rect3.top, rect3.right, rect3.bottom);
        int i3 = this.mFrameRadius;
        canvas.drawRoundRect(rectF, i3, i3, this.mFramePaint);
    }

    private void drawIndicator(Canvas canvas) {
        float dp2px = (this.mSelectAreaRect.left - Util.dp2px(getContext(), 8.0f)) + ((this.mSelectAreaRect.width() - Util.dp2px(getContext(), 4.0f)) * this.mIndicatorProgress);
        if (this.mIndicatorBitmap != null) {
            canvas.drawBitmap(this.mIndicatorBitmap, new Rect(0, 0, this.mIndicatorBitmap.getWidth(), this.mIndicatorBitmap.getHeight()), new Rect((int) dp2px, 0, (int) (dp2px + this.mIndicatorWidth), getMeasuredHeight()), this.mIndicatorPaint);
            return;
        }
        canvas.drawRect(dp2px, 0.0f, dp2px + this.mIndicatorWidth, getMeasuredHeight(), this.mIndicatorPaint);
    }

    private void init() {
        initConfig();
        initView();
    }

    private void initConfig() {
        int parseColor;
        Paint.Style style;
        float f16;
        this.mPaddingTop = (int) Util.dp2px(getContext(), 12.5f);
        this.mPaddingBottom = (int) Util.dp2px(getContext(), 11.5f);
        this.mBarWidth = (int) Util.dp2px(getContext(), 17.0f);
        this.mFrameStrokeWidth = (int) Util.dp2px(getContext(), 1.0f);
        this.mFrameRadius = (int) Util.dp2px(getContext(), 4.0f);
        this.mIndicatorWidth = (int) Util.dp2px(getContext(), 3.0f);
        Paint paint = new Paint();
        this.mSelectAreaPaint = paint;
        paint.setColor(Color.parseColor("#33FFFFFF"));
        Paint paint2 = new Paint();
        this.mFramePaint = paint2;
        if (this.mSliderBarMode) {
            parseColor = Color.parseColor("#FFFFFFFF");
        } else {
            parseColor = Color.parseColor("#66FFFFFF");
        }
        paint2.setColor(parseColor);
        Paint paint3 = this.mFramePaint;
        if (this.mSliderBarMode) {
            style = Paint.Style.FILL;
        } else {
            style = Paint.Style.STROKE;
        }
        paint3.setStyle(style);
        Paint paint4 = this.mFramePaint;
        if (this.mSliderBarMode) {
            f16 = 0.0f;
        } else {
            f16 = this.mFrameStrokeWidth;
        }
        paint4.setStrokeWidth(f16);
        Paint paint5 = new Paint();
        this.mIndicatorPaint = paint5;
        paint5.setColor(Color.parseColor("#FFFFFFFF"));
        this.mMaxDurationTips = "\u5df2\u8fbe\u5230\u6a21\u677f\u6700\u5927\u65f6\u957f";
        this.mDurationTextSize = (int) Util.sp2px(getContext(), 12.0f);
        Paint paint6 = new Paint();
        this.mDurationTextPaint = paint6;
        paint6.setColor(Color.parseColor("#FFFFFFFF"));
        this.mDurationTextPaint.setAntiAlias(true);
        this.mDurationTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mDurationTextPaint.setTextSize(this.mDurationTextSize);
        this.mDurationBgRadius = (int) Util.dp2px(getContext(), 1.0f);
        Paint paint7 = new Paint();
        this.mDurationBgPaint = paint7;
        paint7.setColor(Color.parseColor("#80000000"));
        this.mDurationBgPaint.setAntiAlias(true);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void initSliderBar() {
        ImageView imageView = new ImageView(getContext());
        this.mLeftBarIv = imageView;
        imageView.setImageDrawable(this.mImgLockLeft);
        this.mLeftBarIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mBarWidth, -1);
        layoutParams.gravity = 8388611;
        this.mLeftBarIv.setLayoutParams(layoutParams);
        this.mLeftBarIv.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mLeftBarIv);
        ImageView imageView2 = new ImageView(getContext());
        this.mRightBarIv = imageView2;
        imageView2.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
        this.mRightBarIv.setImageDrawable(this.mImgLockRight);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.mBarWidth, -1);
        layoutParams2.gravity = 8388613;
        this.mRightBarIv.setLayoutParams(layoutParams2);
        this.mRightBarIv.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mRightBarIv);
    }

    private void initView() {
        initSliderBar();
        setWillNotDraw(false);
    }

    private boolean isPressBar(boolean z16, int i3, int i16) {
        Rect rect = new Rect();
        if (z16) {
            this.mLeftBarIv.getHitRect(rect);
        } else {
            this.mRightBarIv.getHitRect(rect);
        }
        int i17 = rect.left;
        int i18 = this.mTouchSlop;
        rect.left = i17 - i18;
        rect.top -= i18;
        rect.right += i18;
        rect.bottom += i18;
        return rect.contains(i3, i16);
    }

    private boolean isPressIndicator(int i3) {
        Rect rect = this.mSelectAreaRect;
        float width = rect.left + (rect.width() * this.mIndicatorProgress);
        float f16 = this.mIndicatorWidth;
        float f17 = width - (f16 / 2.0f);
        float f18 = i3;
        if (f18 >= f17 - (f16 * 2.0f) && f18 <= f17 + (f16 * 2.0f)) {
            return true;
        }
        return false;
    }

    private void moveIndicator(int i3) {
        Rect rect = this.mSelectAreaRect;
        float width = rect.left + (rect.width() * this.mIndicatorProgress);
        float f16 = this.mIndicatorWidth;
        float f17 = (width - (f16 / 2.0f)) + i3;
        float f18 = (f16 / 2.0f) + f17;
        Rect rect2 = this.mSelectAreaRect;
        if (f18 > rect2.left + rect2.width()) {
            Rect rect3 = this.mSelectAreaRect;
            f17 = (rect3.left + rect3.width()) - (this.mIndicatorWidth / 2.0f);
        }
        Rect rect4 = this.mSelectAreaRect;
        this.mIndicatorProgress = Math.max(0.0f, ((f17 - rect4.left) + (this.mIndicatorWidth / 2.0f)) / rect4.width());
        this.mIndicatorMoved = true;
    }

    private void moveLeftBar(int i3) {
        if (!this.canAdjust && i3 > 0) {
            return;
        }
        float x16 = this.mLeftBarIv.getX() + i3;
        if (x16 < 0.0f) {
            x16 = 0.0f;
        }
        if ((this.mRightBarIv.getX() - x16) - this.mBarWidth < this.mMinSelectAreaWidth) {
            x16 = (this.mRightBarIv.getX() - this.mBarWidth) - this.mMinSelectAreaWidth;
        }
        if ((this.mRightBarIv.getX() - x16) - this.mBarWidth > this.mMaxSelectAreaWidth) {
            x16 = (this.mRightBarIv.getX() - this.mBarWidth) - this.mMaxSelectAreaWidth;
        }
        if (FloatUtils.isEquals(x16, this.mLeftBarIv.getX())) {
            return;
        }
        this.mLeftBarIv.setX(x16);
        this.mLeftBarMoved = true;
        this.mIndicatorProgress = 0.0f;
        notifySliderBarMove();
    }

    private void moveRightBar(int i3) {
        if (!this.canAdjust && i3 < 0) {
            return;
        }
        float x16 = this.mRightBarIv.getX() + i3;
        float measuredWidth = getMeasuredWidth() - this.mBarWidth;
        if (x16 > measuredWidth) {
            x16 = measuredWidth;
        }
        if ((x16 - this.mLeftBarIv.getX()) - this.mBarWidth < this.mMinSelectAreaWidth) {
            x16 = this.mMinSelectAreaWidth + this.mLeftBarIv.getX() + this.mBarWidth;
        }
        if ((x16 - this.mLeftBarIv.getX()) - this.mBarWidth > this.mMaxSelectAreaWidth) {
            x16 = this.mMaxSelectAreaWidth + this.mLeftBarIv.getX() + this.mBarWidth;
        }
        if (FloatUtils.isEquals(x16, this.mRightBarIv.getX())) {
            return;
        }
        this.mRightBarIv.setX(x16);
        this.mRightBarMoved = true;
        this.mIndicatorProgress = 1.0f;
        notifySliderBarMove();
    }

    private void notifyIndicatorMove() {
        if (this.mSliderChangeListener != null) {
            Logger.d(TAG, "notifyIndicatorMove: indicatorProgress is " + this.mIndicatorProgress);
            this.mSliderChangeListener.onIndicatorMove(this.mIndicatorProgress);
        }
    }

    private void notifyIndicatorPress() {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onIndicatorPress();
        }
    }

    private void notifyIndicatorRelease() {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onIndicatorRelease();
        }
    }

    private void notifySliderBarMove() {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onSliderBarMove(this.mLeftBarHandle, this.mLeftBarIv.getX() + this.mLeftBarIv.getWidth(), this.mRightBarIv.getX());
        }
    }

    private void notifySliderBarRelease() {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onSliderBarRelease(this.mLeftBarHandle);
        }
    }

    private String translateDuration(long j3) {
        return String.format(Locale.US, "%.1fs", Double.valueOf(Math.round(((float) j3) / 100.0f) / 10.0d));
    }

    private void updateSliderBarSource() {
        Drawable drawable;
        Drawable drawable2;
        ImageView imageView = this.mLeftBarIv;
        if (imageView != null) {
            if (this.mLockMode) {
                drawable2 = this.mImgLockLeft;
            } else {
                drawable2 = this.mImgRangeLeft;
            }
            imageView.setImageDrawable(drawable2);
            this.mLeftBarIv.setEnabled(!this.mLockMode);
        }
        ImageView imageView2 = this.mRightBarIv;
        if (imageView2 != null) {
            if (this.mLockMode) {
                drawable = this.mImgLockRight;
            } else {
                drawable = this.mImgRangeRight;
            }
            imageView2.setImageDrawable(drawable);
            this.mRightBarIv.setEnabled(!this.mLockMode);
        }
    }

    private void updateSliderBarVisible() {
        int i3;
        ImageView imageView = this.mLeftBarIv;
        int i16 = 0;
        if (imageView != null) {
            if (this.mSliderBarMode) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        ImageView imageView2 = this.mRightBarIv;
        if (imageView2 != null) {
            if (!this.mSliderBarMode) {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
        }
    }

    public float getIndicatorProgress() {
        return this.mIndicatorProgress;
    }

    public ImageView getLeftBarIv() {
        return this.mLeftBarIv;
    }

    public ImageView getRightBarIv() {
        return this.mRightBarIv;
    }

    public int getSelectAreaWidth() {
        if (this.mSelectAreaRect == null) {
            this.mSelectAreaRect = new Rect();
        }
        if (this.mSliderBarMode) {
            this.mSelectAreaRect.set(this.mLeftBarIv.getWidth(), this.mPaddingTop, getMeasuredWidth() - this.mRightBarIv.getWidth(), getMeasuredHeight() - this.mPaddingBottom);
        } else {
            this.mSelectAreaRect.set(getPaddingLeft(), this.mPaddingTop, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - this.mPaddingBottom);
        }
        return this.mSelectAreaRect.width();
    }

    public boolean isDragging() {
        return this.mDragging;
    }

    public boolean isIndicatorMoving() {
        return this.mIndicatorMoved;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        drawFrame(canvas);
        drawDuration(canvas);
        canvas.restore();
        if (this.showIndicator) {
            drawIndicator(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r0 != 3) goto L67;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z16 = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.mLeftBarMoved = false;
                    this.mRightBarMoved = false;
                    this.mIndicatorMoved = false;
                    int x16 = (int) motionEvent.getX();
                    if (!this.mDragging && Math.abs(x16 - this.mOriginX) > this.mTouchSlop) {
                        this.mDragging = true;
                    }
                    if (this.mDragging) {
                        int i3 = x16 - this.mLastX;
                        if (!this.mLeftBarPressed && !this.mRightBarPressed) {
                            if (this.mIndicatorPressed) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                moveIndicator(i3);
                                invalidate();
                            }
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            if (this.mLeftBarPressed) {
                                this.mLeftBarMoved = true;
                                this.mLeftBarHandle = true;
                                moveLeftBar(i3);
                            } else if (this.mRightBarPressed) {
                                this.mRightBarMoved = true;
                                this.mLeftBarHandle = false;
                                moveRightBar(i3);
                            }
                            invalidate();
                        }
                        if (this.mLeftBarMoved && !this.mRightBarMoved) {
                            if (this.mIndicatorMoved) {
                                notifyIndicatorMove();
                            }
                        } else {
                            notifySliderBarMove();
                        }
                        this.mLastX = x16;
                        return z16;
                    }
                    z16 = false;
                    if (this.mLeftBarMoved) {
                    }
                    notifySliderBarMove();
                    this.mLastX = x16;
                    return z16;
                }
            }
            this.mDragging = false;
            this.mOriginX = 0;
            this.mLastX = 0;
            if (!this.mLeftBarMoved && !this.mRightBarMoved) {
                if (this.mIndicatorMoved || this.mIndicatorPressed) {
                    this.mIndicatorPressed = false;
                    this.mIndicatorMoved = false;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    invalidate();
                    notifyIndicatorRelease();
                    return true;
                }
            } else {
                this.mLeftBarMoved = false;
                this.mRightBarMoved = false;
                this.mLeftBarPressed = false;
                this.mRightBarPressed = false;
                getParent().requestDisallowInterceptTouchEvent(false);
                invalidate();
                notifySliderBarRelease();
                return true;
            }
        } else {
            int x17 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            this.mLeftBarPressed = false;
            this.mRightBarPressed = false;
            this.mIndicatorPressed = false;
            this.mOriginX = x17;
            this.mLastX = x17;
            this.mDragging = false;
            if (isPressBar(true, x17, y16) && this.mLeftBarIv.isEnabled()) {
                this.mLeftBarPressed = true;
                return true;
            }
            if (isPressBar(false, x17, y16) && this.mRightBarIv.isEnabled()) {
                this.mRightBarPressed = true;
                return true;
            }
            if (isPressIndicator(x17)) {
                this.mIndicatorPressed = true;
                notifyIndicatorPress();
                return true;
            }
        }
        return false;
    }

    public void release() {
        this.mSliderChangeListener = null;
    }

    public void setCanAdjust(boolean z16) {
        this.canAdjust = z16;
    }

    public void setDurationBgRes(int i3) {
        this.mDurationBgBitmap = BitmapFactory.decodeResource(getResources(), i3);
    }

    public void setFrameColor(int i3) {
        this.frameColor = i3;
        invalidate();
    }

    public void setIndicatorProgress(float f16) {
        if (FloatUtils.isEquals(f16, this.mIndicatorProgress)) {
            return;
        }
        this.mIndicatorProgress = f16;
        invalidate();
    }

    public void setIndicatorRes(int i3) {
        this.mIndicatorBitmap = BitmapFactory.decodeResource(getResources(), i3);
        this.mIndicatorWidth = r2.getWidth();
    }

    public void setLockMode(boolean z16) {
        this.mLockMode = z16;
        updateSliderBarSource();
    }

    public void setMaxDurationTips(String str) {
        this.mMaxDurationTips = str;
    }

    public void setMaxSelectAreaWidth(int i3) {
        this.mMaxSelectAreaWidth = i3;
    }

    public void setMaxSelectDuration(long j3) {
        this.mMaxSelectDurationMs = j3;
    }

    public void setMinSelectAreaWidth(int i3) {
        this.mMinSelectAreaWidth = i3;
    }

    @Deprecated
    public void setSelectDuration(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDuration = translateDuration(Long.parseLong(str));
        long parseLong = Long.parseLong(str);
        long j3 = this.mMaxSelectDurationMs;
        if (parseLong == j3 && !((!this.mLeftBarMoved && !this.mRightBarMoved) || this.mTotalDurationMs == j3 || TextUtils.isEmpty(this.mMaxDurationTips))) {
            this.mDuration = this.mMaxDurationTips;
        }
        invalidate();
    }

    public void setShowDuration(boolean z16) {
        this.mShowDuration = z16;
    }

    public void setShowIndicator(boolean z16) {
        this.showIndicator = z16;
    }

    public void setSliderBarMode(boolean z16) {
        this.mSliderBarMode = z16;
        updateSliderBarVisible();
        invalidate();
    }

    public void setSliderBarPosition(float f16, float f17) {
        ImageView imageView = this.mLeftBarIv;
        if (imageView != null) {
            imageView.setX(f16);
        }
        ImageView imageView2 = this.mRightBarIv;
        if (imageView2 != null) {
            imageView2.setX(f17);
        }
    }

    public void setSliderChangeListener(SliderChangeListener sliderChangeListener) {
        this.mSliderChangeListener = sliderChangeListener;
    }

    public void setTotalDurationMs(long j3) {
        this.mTotalDurationMs = j3;
    }

    public void setTypeface(Typeface typeface) {
        this.mDurationTextPaint.setTypeface(typeface);
    }

    public SliderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SliderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.showIndicator = true;
        this.mSliderBarMode = true;
        this.frameColor = Color.parseColor("#ffffffff");
        this.mShowDuration = true;
        this.mDuration = QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
        init();
    }

    public void setSelectDuration(Long l3) {
        if (l3 == null) {
            return;
        }
        this.mDuration = translateDuration(l3.longValue());
        if (l3.equals(Long.valueOf(this.mMaxSelectDurationMs)) && !((!this.mLeftBarMoved && !this.mRightBarMoved) || this.mTotalDurationMs == this.mMaxSelectDurationMs || TextUtils.isEmpty(this.mMaxDurationTips))) {
            this.mDuration = this.mMaxDurationTips;
        }
        invalidate();
    }

    public SliderView(Context context, int i3, int i16, int i17, int i18) {
        super(context, null, 0);
        this.showIndicator = true;
        this.mSliderBarMode = true;
        this.frameColor = Color.parseColor("#ffffffff");
        this.mShowDuration = true;
        this.mDuration = QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
        this.mImgLockLeft = context.getResources().getDrawable(i3);
        this.mImgLockRight = context.getResources().getDrawable(i16);
        this.mImgRangeLeft = context.getResources().getDrawable(i17);
        this.mImgRangeRight = context.getResources().getDrawable(i18);
        init();
    }
}
