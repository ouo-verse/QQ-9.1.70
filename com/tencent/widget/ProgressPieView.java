package com.tencent.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;

/* loaded from: classes27.dex */
public class ProgressPieView extends View {
    static IPatchRedirector $redirector_ = null;
    static final int DEFAULT_MAX = 100;
    static final int DEFAULT_PROGRESS = 0;
    public static final float DEFAULT_PROGRESS_STROKE_WIDTH = 4.0f;
    static final int DEFAULT_START_ANGLE = -90;
    static final float DEFAULT_STROKE_WIDTH = 1.5f;
    static final float DEFAULT_TEXT_SIZE = 14.0f;
    static final float DEFAULT_VIEW_SIZE = 40.0f;
    public static final int FAST_ANIMATION_SPEED = 1;
    public static final int FILL_TYPE_CENTER = 2;
    public static final int FILL_TYPE_RADIAL = 0;
    public static final int FILL_TYPE_RADIAL_STROKE = 1;
    public static final int MEDIUM_ANIMATION_SPEED = 25;
    public static final int PREPROGRESS_TYPE_BLESS = 1;
    public static final int PREPROGRESS_TYPE_NORMAL = 0;
    public static final int SLOW_ANIMATION_SPEED = 50;
    static LruCache<String, Typeface> sTypefaceCache;
    AnimationHandler mAnimationHandler;
    public int mAnimationSpeed;
    public int mAnimationSpeedLevel;
    public Paint mBackgroundPaint;
    public boolean mCounterclockwise;
    float mDefaultViewSize;
    DisplayMetrics mDisplayMetrics;
    private boolean mDrawImageFillView;
    public Drawable mImage;
    Rect mImageRect;
    RectF mInnerProgressRectF;
    RectF mInnerRectF;
    public boolean mInverted;
    OnProgressListener mListener;
    public int mMax;
    public int mProgress;
    public int mProgressFillType;
    public Paint mProgressPaint;
    public Paint mProgressPrePaint;
    public int mProgressPreType;
    public float mProgressStrokeWidth;
    public boolean mShowArc;
    public boolean mShowColorMask;
    public boolean mShowImage;
    public boolean mShowStroke;
    public boolean mShowText;
    public int mStartAngle;
    public Paint mStrokePaint;
    public float mStrokeWidth;
    public String mText;
    public Paint mTextPaint;
    public float mTextSize;
    BlessAnimationHandler mTimeAnimationHandler;
    public String mTypeface;
    float mViewSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class AnimationHandler extends Handler {
        static IPatchRedirector $redirector_;
        int mAnimateTo;
        boolean mHide;

        AnimationHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProgressPieView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
                return;
            }
            ProgressPieView progressPieView = ProgressPieView.this;
            int i3 = progressPieView.mProgress;
            int i16 = this.mAnimateTo;
            if (i3 > i16) {
                progressPieView.setProgress(i3 - 1);
                sendEmptyMessageDelayed(0, ProgressPieView.this.mAnimationSpeed);
                return;
            }
            if (i3 < i16) {
                int i17 = i3 + progressPieView.mAnimationSpeedLevel;
                if (i17 <= i16) {
                    progressPieView.setProgress(i17);
                } else {
                    progressPieView.setProgress(i16);
                }
                sendEmptyMessageDelayed(0, ProgressPieView.this.mAnimationSpeed);
                return;
            }
            removeMessages(0);
            if (this.mHide) {
                ProgressPieView.this.setVisibility(4);
                ProgressPieView.this.setShowImage(false);
                ProgressPieView.this.mShowArc = true;
                this.mHide = false;
            }
        }

        public void setAnimateTo(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.mAnimateTo = i3;
            }
        }
    }

    /* loaded from: classes27.dex */
    class BlessAnimationHandler extends Handler {
        static IPatchRedirector $redirector_;
        int mDuration;
        boolean mHide;
        long startTime;

        BlessAnimationHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProgressPieView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
                return;
            }
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.startTime);
            ProgressPieView progressPieView = ProgressPieView.this;
            int i3 = progressPieView.mMax;
            if (elapsedRealtime < i3) {
                progressPieView.setProgress(elapsedRealtime);
                sendEmptyMessageDelayed(0, 1L);
            } else {
                progressPieView.setProgress(i3);
            }
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.startTime = SystemClock.elapsedRealtime();
            }
        }

        public void setAnimateDuration(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.mDuration = i3;
            }
        }
    }

    /* loaded from: classes27.dex */
    public interface OnProgressListener {
        void onProgressChanged(int i3, int i16);

        void onProgressCompleted();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            sTypefaceCache = new LruCache<>(8);
        }
    }

    public ProgressPieView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void animateProgressFill() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mAnimationHandler.removeMessages(0);
        this.mAnimationHandler.setAnimateTo(this.mMax);
        this.mAnimationHandler.sendEmptyMessage(0);
        invalidate();
    }

    public void animateProgressFillAndHide(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            animateProgressFill(i3);
            this.mAnimationHandler.mHide = true;
        }
    }

    public Drawable getImageDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Drawable) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mImage;
    }

    public int getMaxTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return this.mMax;
    }

    public int getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mProgress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0162  */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r8v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void init(Context context, AttributeSet attributeSet) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDisplayMetrics = displayMetrics;
        float f16 = this.mStrokeWidth;
        float f17 = displayMetrics.density;
        this.mStrokeWidth = f16 * f17;
        this.mProgressStrokeWidth *= f17;
        this.mTextSize *= displayMetrics.scaledDensity;
        this.mDefaultViewSize = 40.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410083i5);
        Resources resources = getResources();
        this.mMax = obtainStyledAttributes.getInteger(jj2.b.f410174q5, this.mMax);
        this.mProgress = obtainStyledAttributes.getInteger(jj2.b.f410186r5, this.mProgress);
        this.mStartAngle = obtainStyledAttributes.getInt(jj2.b.f410262y5, this.mStartAngle);
        this.mInverted = obtainStyledAttributes.getBoolean(jj2.b.f410162p5, this.mInverted);
        this.mCounterclockwise = obtainStyledAttributes.getBoolean(jj2.b.f410138n5, this.mCounterclockwise);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(jj2.b.A5, this.mStrokeWidth);
        this.mProgressStrokeWidth = obtainStyledAttributes.getDimension(jj2.b.f410230v5, this.mProgressStrokeWidth);
        this.mTypeface = obtainStyledAttributes.getString(jj2.b.B5);
        this.mTextSize = obtainStyledAttributes.getDimension(jj2.b.f410094j5, this.mTextSize);
        this.mText = obtainStyledAttributes.getString(jj2.b.f410116l5);
        this.mShowStroke = obtainStyledAttributes.getBoolean(jj2.b.f410240w5, this.mShowStroke);
        this.mShowText = obtainStyledAttributes.getBoolean(jj2.b.f410251x5, this.mShowText);
        this.mImage = obtainStyledAttributes.getDrawable(jj2.b.f410150o5);
        this.mProgressFillType = obtainStyledAttributes.getInteger(jj2.b.f410209t5, this.mProgressFillType);
        int i27 = 0;
        try {
            try {
                i26 = resources.getColor(R.color.f157020hq);
                try {
                    i26 = obtainStyledAttributes.getColor(jj2.b.f410127m5, i26);
                    i17 = resources.getColor(R.color.f157023hu);
                    try {
                        i17 = obtainStyledAttributes.getColor(jj2.b.f410198s5, i17);
                        i16 = resources.getColor(R.color.f157023hu);
                    } catch (Resources.NotFoundException e16) {
                        e = e16;
                        i16 = 0;
                        i18 = 0;
                    }
                } catch (Resources.NotFoundException e17) {
                    e = e17;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                }
                try {
                    i16 = obtainStyledAttributes.getColor(jj2.b.f410220u5, i16);
                    i18 = resources.getColor(R.color.f157024hv);
                    try {
                        i18 = obtainStyledAttributes.getColor(jj2.b.f410273z5, i18);
                        i27 = resources.getColor(R.color.f157025hw);
                        i19 = obtainStyledAttributes.getColor(jj2.b.f410105k5, i27);
                    } catch (Resources.NotFoundException e18) {
                        e = e18;
                        int i28 = i27;
                        i27 = i26;
                        i3 = i28;
                        e.printStackTrace();
                        obtainStyledAttributes.recycle();
                        i19 = i3;
                        i26 = i27;
                        Paint paint = new Paint(1);
                        this.mBackgroundPaint = paint;
                        paint.setColor(i26);
                        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
                        this.mProgressPaint = new Paint(1);
                        this.mProgressPrePaint = new Paint(1);
                        this.mProgressPaint.setColor(i17);
                        this.mProgressPrePaint.setColor(i16);
                        obtainStyledAttributes = this.mProgressFillType;
                        if (obtainStyledAttributes == 1) {
                        }
                        Paint paint2 = new Paint(1);
                        this.mStrokePaint = paint2;
                        paint2.setColor(i18);
                        this.mStrokePaint.setStyle(Paint.Style.STROKE);
                        this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
                        Paint paint3 = new Paint(1);
                        this.mTextPaint = paint3;
                        paint3.setColor(i19);
                        this.mTextPaint.setTextSize(this.mTextSize);
                        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
                        this.mInnerRectF = new RectF();
                        this.mImageRect = new Rect();
                        this.mInnerProgressRectF = new RectF();
                    }
                } catch (Resources.NotFoundException e19) {
                    e = e19;
                    i18 = 0;
                    i27 = i26;
                    i3 = i18;
                    e.printStackTrace();
                    obtainStyledAttributes.recycle();
                    i19 = i3;
                    i26 = i27;
                    Paint paint4 = new Paint(1);
                    this.mBackgroundPaint = paint4;
                    paint4.setColor(i26);
                    this.mBackgroundPaint.setStyle(Paint.Style.FILL);
                    this.mProgressPaint = new Paint(1);
                    this.mProgressPrePaint = new Paint(1);
                    this.mProgressPaint.setColor(i17);
                    this.mProgressPrePaint.setColor(i16);
                    obtainStyledAttributes = this.mProgressFillType;
                    if (obtainStyledAttributes == 1) {
                    }
                    Paint paint22 = new Paint(1);
                    this.mStrokePaint = paint22;
                    paint22.setColor(i18);
                    this.mStrokePaint.setStyle(Paint.Style.STROKE);
                    this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
                    Paint paint32 = new Paint(1);
                    this.mTextPaint = paint32;
                    paint32.setColor(i19);
                    this.mTextPaint.setTextSize(this.mTextSize);
                    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
                    this.mInnerRectF = new RectF();
                    this.mImageRect = new Rect();
                    this.mInnerProgressRectF = new RectF();
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        } catch (Resources.NotFoundException e26) {
            e = e26;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        Paint paint42 = new Paint(1);
        this.mBackgroundPaint = paint42;
        paint42.setColor(i26);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mProgressPaint = new Paint(1);
        this.mProgressPrePaint = new Paint(1);
        this.mProgressPaint.setColor(i17);
        this.mProgressPrePaint.setColor(i16);
        obtainStyledAttributes = this.mProgressFillType;
        if (obtainStyledAttributes == 1) {
            this.mProgressPaint.setStyle(Paint.Style.STROKE);
            this.mProgressPaint.setStrokeWidth(this.mProgressStrokeWidth);
            this.mProgressPrePaint.setStyle(Paint.Style.STROKE);
            this.mProgressPrePaint.setStrokeWidth(this.mProgressStrokeWidth);
        } else {
            this.mProgressPaint.setStyle(Paint.Style.FILL);
            this.mProgressPrePaint.setStyle(Paint.Style.FILL);
        }
        Paint paint222 = new Paint(1);
        this.mStrokePaint = paint222;
        paint222.setColor(i18);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
        Paint paint322 = new Paint(1);
        this.mTextPaint = paint322;
        paint322.setColor(i19);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mInnerRectF = new RectF();
        this.mImageRect = new Rect();
        this.mInnerProgressRectF = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AssetManager assets;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        RectF rectF = this.mInnerRectF;
        float f16 = this.mViewSize;
        rectF.set(0.0f, 0.0f, f16, f16);
        this.mInnerRectF.offset((getWidth() - this.mViewSize) / 2.0f, (getHeight() - this.mViewSize) / 2.0f);
        if (this.mShowStroke) {
            float strokeWidth = (int) ((this.mStrokePaint.getStrokeWidth() / 2.0f) + 0.5f);
            this.mInnerRectF.inset(strokeWidth, strokeWidth);
        }
        float centerX = this.mInnerRectF.centerX();
        float centerY = this.mInnerRectF.centerY();
        if (this.mShowArc) {
            this.mInnerProgressRectF.set(this.mInnerRectF);
            canvas.drawArc(this.mInnerProgressRectF, 0.0f, 360.0f, true, this.mBackgroundPaint);
            int i3 = this.mProgressFillType;
            if (i3 != 0 && i3 != 1) {
                if (i3 == 2) {
                    float f17 = (this.mViewSize / 2.0f) * (this.mProgress / this.mMax);
                    if (this.mShowStroke) {
                        f17 = (f17 + 0.5f) - this.mStrokePaint.getStrokeWidth();
                    }
                    canvas.drawCircle(centerX, centerY, f17, this.mProgressPaint);
                } else {
                    throw new IllegalArgumentException("Invalid Progress Fill = " + this.mProgressFillType);
                }
            } else {
                float f18 = (this.mProgress * 360) / this.mMax;
                if (this.mInverted) {
                    f18 -= 360.0f;
                }
                if (this.mCounterclockwise) {
                    f18 = -f18;
                }
                float f19 = f18;
                if (i3 == 0) {
                    canvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f19, true, this.mProgressPaint);
                } else {
                    float strokeWidth2 = (int) ((this.mProgressPaint.getStrokeWidth() / 2.0f) + 0.5f);
                    this.mInnerProgressRectF.inset(strokeWidth2, strokeWidth2);
                    if (this.mProgressPreType == 1) {
                        if (this.mProgress >= 500) {
                            float f26 = 180000 / this.mMax;
                            canvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f26, false, this.mProgressPrePaint);
                            canvas.drawArc(this.mInnerProgressRectF, this.mStartAngle + r9, f19 - f26, false, this.mProgressPaint);
                        } else {
                            canvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f19, false, this.mProgressPrePaint);
                        }
                    } else {
                        canvas.drawArc(this.mInnerProgressRectF, this.mStartAngle, f19, false, this.mProgressPaint);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.mText) && this.mShowText) {
            if (!TextUtils.isEmpty(this.mTypeface)) {
                Typeface typeface = sTypefaceCache.get(this.mTypeface);
                if (typeface == null && getResources() != null && (assets = getResources().getAssets()) != null) {
                    typeface = Typeface.createFromAsset(assets, this.mTypeface);
                    sTypefaceCache.put(this.mTypeface, typeface);
                }
                this.mTextPaint.setTypeface(typeface);
            }
            canvas.drawText(this.mText, (int) centerX, (int) (centerY - ((this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0f)), this.mTextPaint);
        }
        Drawable drawable = this.mImage;
        if (drawable != null && this.mShowImage) {
            if (this.mDrawImageFillView) {
                this.mImageRect.set(0, 0, getWidth(), getHeight());
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                this.mImageRect.set(0, 0, intrinsicWidth, intrinsicWidth);
                this.mImageRect.offset((getWidth() - intrinsicWidth) / 2, (getHeight() - intrinsicWidth) / 2);
            }
            this.mImage.setBounds(this.mImageRect);
            this.mImage.draw(canvas);
        }
        if (this.mShowStroke && this.mShowArc) {
            canvas.drawOval(this.mInnerRectF, this.mStrokePaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int resolveSize = View.resolveSize(Utils.n(this.mDefaultViewSize, getResources()), i3);
        int resolveSize2 = View.resolveSize(Utils.n(this.mDefaultViewSize, getResources()), i16);
        this.mViewSize = Math.min(resolveSize, resolveSize2);
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public void setAnimationSpeed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mAnimationSpeed = i3;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mBackgroundPaint.setColor(i3);
            invalidate();
        }
    }

    public void setCounterclockwise(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mCounterclockwise = z16;
        }
    }

    public void setDefaultViewSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
            return;
        }
        float f16 = i3;
        if (Float.compare(this.mDefaultViewSize, f16) != 0) {
            this.mDefaultViewSize = f16;
            invalidate();
        }
    }

    public void setDrawImageFillView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mDrawImageFillView = z16;
        }
    }

    public void setImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) drawable);
        } else {
            this.mImage = drawable;
            invalidate();
        }
    }

    public void setImageResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else if (getResources() != null) {
            this.mImage = getResources().getDrawable(i3);
            invalidate();
        }
    }

    public void setInverted(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mInverted = z16;
        }
    }

    public void setMax(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            if (i3 > 0 && i3 >= this.mProgress) {
                this.mMax = i3;
                invalidate();
                return;
            }
            throw new IllegalArgumentException(String.format("Max (%d) must be > 0 and >= %d", Integer.valueOf(i3), Integer.valueOf(this.mProgress)));
        }
    }

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) onProgressListener);
        } else {
            this.mListener = onProgressListener;
        }
    }

    public void setPregressPreColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mProgressPrePaint.setColor(i3);
            invalidate();
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (i3 <= this.mMax && i3 >= 0) {
            this.mProgress = i3;
            invalidate();
            OnProgressListener onProgressListener = this.mListener;
            if (onProgressListener != null) {
                int i16 = this.mProgress;
                int i17 = this.mMax;
                if (i16 == i17) {
                    onProgressListener.onProgressCompleted();
                    return;
                } else {
                    onProgressListener.onProgressChanged(i16, i17);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", Integer.valueOf(i3), 0, Integer.valueOf(this.mMax)));
    }

    public void setProgressColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mProgressPaint.setColor(i3);
            invalidate();
        }
    }

    public void setProgressFillType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        this.mProgressFillType = i3;
        if (i3 == 1) {
            this.mProgressPaint.setStyle(Paint.Style.STROKE);
            this.mProgressPaint.setStrokeWidth(this.mProgressStrokeWidth);
        } else {
            this.mProgressPaint.setStyle(Paint.Style.FILL);
        }
    }

    public void setProgressPreType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mProgressPreType = i3;
        }
    }

    public void setProgressStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else if (this.mProgressPaint.getStyle() == Paint.Style.STROKE) {
            float f16 = i3 * this.mDisplayMetrics.density;
            this.mProgressStrokeWidth = f16;
            this.mProgressPaint.setStrokeWidth(f16);
            invalidate();
        }
    }

    public void setShowImage(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            this.mShowImage = z16;
            invalidate();
        }
    }

    public void setShowStroke(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.mShowStroke = z16;
            invalidate();
        }
    }

    public void setShowText(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.mShowText = z16;
            invalidate();
        }
    }

    public void setStartAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mStartAngle = i3;
        }
    }

    public void setStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mStrokePaint.setColor(i3);
            invalidate();
        }
    }

    public void setStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        float f16 = i3 * this.mDisplayMetrics.density;
        this.mStrokeWidth = f16;
        this.mStrokePaint.setStrokeWidth(f16);
        invalidate();
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.mText = str;
            invalidate();
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mTextPaint.setColor(i3);
            invalidate();
        }
    }

    public void setTextSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        float f16 = i3 * this.mDisplayMetrics.scaledDensity;
        this.mTextSize = f16;
        this.mTextPaint.setTextSize(f16);
        invalidate();
    }

    public void setTypeface(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.mTypeface = str;
            invalidate();
        }
    }

    public void startTimeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            this.mTimeAnimationHandler.reset();
            this.mTimeAnimationHandler.sendEmptyMessageDelayed(0, 1L);
        }
    }

    public void stopAnimating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mAnimationHandler.removeMessages(0);
        this.mAnimationHandler.setAnimateTo(this.mProgress);
        this.mTimeAnimationHandler.removeMessages(0);
        invalidate();
    }

    public ProgressPieView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ProgressPieView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mMax = 100;
        this.mProgress = 0;
        this.mStartAngle = DEFAULT_START_ANGLE;
        this.mInverted = false;
        this.mCounterclockwise = false;
        this.mShowStroke = true;
        this.mStrokeWidth = 1.5f;
        this.mProgressStrokeWidth = 4.0f;
        this.mShowText = true;
        this.mTextSize = 14.0f;
        this.mShowImage = true;
        this.mProgressFillType = 1;
        this.mAnimationSpeed = 25;
        this.mAnimationHandler = new AnimationHandler();
        this.mTimeAnimationHandler = new BlessAnimationHandler();
        this.mDrawImageFillView = false;
        this.mShowArc = true;
        this.mShowColorMask = false;
        this.mAnimationSpeedLevel = 1;
        this.mProgressPreType = 0;
        init(context, attributeSet);
    }

    public void animateProgressFill(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.mAnimationHandler.removeMessages(0);
        if (i3 <= this.mMax && i3 >= 0) {
            this.mAnimationHandler.setAnimateTo(i3);
            this.mAnimationHandler.sendEmptyMessage(0);
            invalidate();
            return;
        }
        throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", Integer.valueOf(i3), Integer.valueOf(this.mMax)));
    }
}
